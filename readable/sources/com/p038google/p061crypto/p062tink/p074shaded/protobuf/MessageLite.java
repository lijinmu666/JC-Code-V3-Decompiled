package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public interface MessageLite extends MessageLiteOrBuilder {

    /* renamed from: com.google.crypto.tink.shaded.protobuf.MessageLite$Builder */
    public interface InterfaceC0766Builder extends MessageLiteOrBuilder, Cloneable {
        /* renamed from: build */
        MessageLite mo3555build();

        MessageLite buildPartial();

        /* renamed from: clear */
        InterfaceC0766Builder mo3556clear();

        /* renamed from: clone */
        InterfaceC0766Builder mo3558clone();

        boolean mergeDelimitedFrom(InputStream inputStream);

        boolean mergeDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite);

        InterfaceC0766Builder mergeFrom(ByteString byteString);

        InterfaceC0766Builder mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite);

        InterfaceC0766Builder mergeFrom(CodedInputStream codedInputStream);

        InterfaceC0766Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite);

        InterfaceC0766Builder mergeFrom(MessageLite messageLite);

        InterfaceC0766Builder mergeFrom(InputStream inputStream);

        InterfaceC0766Builder mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite);

        InterfaceC0766Builder mergeFrom(byte[] bArr);

        InterfaceC0766Builder mergeFrom(byte[] bArr, int i, int i2);

        InterfaceC0766Builder mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite);

        InterfaceC0766Builder mergeFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite);
    }

    InterfaceC0774Parser<? extends MessageLite> getParserForType();

    int getSerializedSize();

    InterfaceC0766Builder newBuilderForType();

    InterfaceC0766Builder toBuilder();

    byte[] toByteArray();

    ByteString toByteString();

    void writeDelimitedTo(OutputStream outputStream);

    /* renamed from: writeTo */
    void mo4026writeTo(CodedOutputStream codedOutputStream);

    /* renamed from: writeTo */
    void mo3906writeTo(OutputStream outputStream);
}
