package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class UnsafeByteOperations {
    private UnsafeByteOperations() {
    }

    public static ByteString unsafeWrap(byte[] bArr) {
        return ByteString.m3935wrap(bArr);
    }

    public static void unsafeWriteTo(ByteString byteString, ByteOutput byteOutput) {
        byteString.mo3945writeTo(byteOutput);
    }

    public static ByteString unsafeWrap(byte[] bArr, int i, int i2) {
        return ByteString.m3936wrap(bArr, i, i2);
    }

    public static ByteString unsafeWrap(ByteBuffer byteBuffer) {
        return ByteString.m3934wrap(byteBuffer);
    }
}
