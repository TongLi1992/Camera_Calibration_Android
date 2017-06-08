package com.tongli.calibration_client;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.3.0)",
    comments = "Source: CalibrationService.proto")
public final class CalibrationServiceGrpc {

  private CalibrationServiceGrpc() {}

  public static final String SERVICE_NAME = "calibration_grpc.CalibrationService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.tongli.calibration_client.CalibrationProto.Image,
      com.tongli.calibration_client.CalibrationProto.CameraMatrix> METHOD_CALIBRATE =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING,
          generateFullMethodName(
              "calibration_grpc.CalibrationService", "calibrate"),
          io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(com.tongli.calibration_client.CalibrationProto.Image.getDefaultInstance()),
          io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(com.tongli.calibration_client.CalibrationProto.CameraMatrix.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CalibrationServiceStub newStub(io.grpc.Channel channel) {
    return new CalibrationServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CalibrationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CalibrationServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static CalibrationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CalibrationServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class CalibrationServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.tongli.calibration_client.CalibrationProto.Image> calibrate(
        io.grpc.stub.StreamObserver<com.tongli.calibration_client.CalibrationProto.CameraMatrix> responseObserver) {
      return asyncUnimplementedStreamingCall(METHOD_CALIBRATE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CALIBRATE,
            asyncClientStreamingCall(
              new MethodHandlers<
                com.tongli.calibration_client.CalibrationProto.Image,
                com.tongli.calibration_client.CalibrationProto.CameraMatrix>(
                  this, METHODID_CALIBRATE)))
          .build();
    }
  }

  /**
   */
  public static final class CalibrationServiceStub extends io.grpc.stub.AbstractStub<CalibrationServiceStub> {
    private CalibrationServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalibrationServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalibrationServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalibrationServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.tongli.calibration_client.CalibrationProto.Image> calibrate(
        io.grpc.stub.StreamObserver<com.tongli.calibration_client.CalibrationProto.CameraMatrix> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(METHOD_CALIBRATE, getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class CalibrationServiceBlockingStub extends io.grpc.stub.AbstractStub<CalibrationServiceBlockingStub> {
    private CalibrationServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalibrationServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalibrationServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalibrationServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class CalibrationServiceFutureStub extends io.grpc.stub.AbstractStub<CalibrationServiceFutureStub> {
    private CalibrationServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CalibrationServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CalibrationServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CalibrationServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_CALIBRATE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CalibrationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CalibrationServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CALIBRATE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.calibrate(
              (io.grpc.stub.StreamObserver<com.tongli.calibration_client.CalibrationProto.CameraMatrix>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CalibrationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(METHOD_CALIBRATE)
              .build();
        }
      }
    }
    return result;
  }
}
