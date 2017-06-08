package com.example.android.camera2basic;

import com.tongli.calibration_client.*;

import android.os.AsyncTask;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;


import android.media.Image;
import android.os.SystemClock;


import com.google.protobuf.ByteString;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by tongli on 6/6/17.
 */

public class GrpcSendTask extends AsyncTask<Void, Void, double[]>{
    private ManagedChannel mChannel;
    private String mHost;
    private int mPort;
    List<ByteString> mImages;
    private Listener mListener;
    double[] mResults;
    public interface Listener {
        void onResponse(double[] matrix); // null means network error
    }

    public GrpcSendTask(String host, int port, List<ByteString> images, Listener listener) {
        mHost = host;
        mPort = port;
        mImages = images;
        mListener = listener;
        mResults = null;
    }

    @Override
    protected double[] doInBackground(Void... voids) {
        final CountDownLatch finishLatch = new CountDownLatch(1);
        mChannel = ManagedChannelBuilder.forAddress(mHost, mPort).usePlaintext(true).build();
        CalibrationServiceGrpc.CalibrationServiceStub mStub = CalibrationServiceGrpc.newStub(mChannel);
        StreamObserver<CalibrationProto.CameraMatrix> responseObserver = new StreamObserver<CalibrationProto.CameraMatrix>() {
            @Override
            public void onNext(CalibrationProto.CameraMatrix matrix) {
                mResults = new double[4];
                mResults[0] = matrix.getFx();
                mResults[1] = matrix.getFy();
                mResults[2] = matrix.getCx();
                mResults[3] = matrix.getCy();
                System.out.println("onNext");
            }

            @Override
            public void onError(Throwable t) {
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                finishLatch.countDown();
                System.out.println("onComplete");
            }
        };

        StreamObserver<CalibrationProto.Image> requestObserver = mStub.calibrate(responseObserver);
        try {
            // Send numPoints points randomly selected from the features list.
            for (int i = 0; i < mImages.size(); ++i) {
                CalibrationProto.Image nextImage = CalibrationProto.Image.newBuilder().setImage(mImages.get(i)).build();
                requestObserver.onNext(nextImage);
                if (finishLatch.getCount() == 0) {
                    // RPC completed or errored before we finished sending.
                    // Sending further requests won't error, but they will just be thrown away.
                    return null;
                }
                System.out.println("send image");
            }
        } catch (RuntimeException e) {
            // Cancel RPC
            requestObserver.onError(e);
            throw e;
        }
        // Mark the end of requests
        requestObserver.onCompleted();

        // Receiving happens asynchronously
        try {
            if (!finishLatch.await(1, TimeUnit.MINUTES)) {
                System.out.println("recordRoute can not finish within 1 minutes");
                return null;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return mResults;
    }

    @Override
    protected void onPostExecute(double[] results) {
        mListener.onResponse(results);
    }
}
