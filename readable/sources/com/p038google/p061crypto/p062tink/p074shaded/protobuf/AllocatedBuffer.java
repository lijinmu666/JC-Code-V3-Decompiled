package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import java.nio.ByteBuffer;

@CheckReturnValue
/* loaded from: classes.dex */
abstract class AllocatedBuffer {
    /* renamed from: wrap */
    public static AllocatedBuffer m3910wrap(byte[] bArr) {
        return wrapNoCheck(bArr, 0, bArr.length);
    }

    private static AllocatedBuffer wrapNoCheck(final byte[] bArr, final int i, final int i2) {
        return new AllocatedBuffer() { // from class: com.google.crypto.tink.shaded.protobuf.AllocatedBuffer.2
            private int position;

            @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AllocatedBuffer
            /* renamed from: array */
            public byte[] mo3912array() {
                return bArr;
            }

            @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AllocatedBuffer
            public int arrayOffset() {
                return i;
            }

            @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AllocatedBuffer
            public boolean hasArray() {
                return true;
            }

            @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AllocatedBuffer
            public boolean hasNioBuffer() {
                return false;
            }

            @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AllocatedBuffer
            /* renamed from: limit */
            public int mo3913limit() {
                return i2;
            }

            @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AllocatedBuffer
            public ByteBuffer nioBuffer() {
                throw new UnsupportedOperationException();
            }

            @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AllocatedBuffer
            public int position() {
                return this.position;
            }

            @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AllocatedBuffer
            public int remaining() {
                return i2 - this.position;
            }

            @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AllocatedBuffer
            public AllocatedBuffer position(int i3) {
                if (i3 >= 0 && i3 <= i2) {
                    this.position = i3;
                    return this;
                }
                throw new IllegalArgumentException("Invalid position: " + i3);
            }
        };
    }

    /* renamed from: array */
    public abstract byte[] mo3912array();

    public abstract int arrayOffset();

    public abstract boolean hasArray();

    public abstract boolean hasNioBuffer();

    /* renamed from: limit */
    public abstract int mo3913limit();

    public abstract ByteBuffer nioBuffer();

    public abstract int position();

    @CanIgnoreReturnValue
    public abstract AllocatedBuffer position(int i);

    public abstract int remaining();

    /* renamed from: wrap */
    public static AllocatedBuffer m3911wrap(byte[] bArr, int i, int i2) {
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            throw new IndexOutOfBoundsException(String.format("bytes.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        return wrapNoCheck(bArr, i, i2);
    }

    /* renamed from: wrap */
    public static AllocatedBuffer m3909wrap(final ByteBuffer byteBuffer) {
        Internal.checkNotNull(byteBuffer, "buffer");
        return new AllocatedBuffer() { // from class: com.google.crypto.tink.shaded.protobuf.AllocatedBuffer.1
            @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AllocatedBuffer
            /* renamed from: array */
            public byte[] mo3912array() {
                return byteBuffer.array();
            }

            @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AllocatedBuffer
            public int arrayOffset() {
                return byteBuffer.arrayOffset();
            }

            @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AllocatedBuffer
            public boolean hasArray() {
                return byteBuffer.hasArray();
            }

            @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AllocatedBuffer
            public boolean hasNioBuffer() {
                return true;
            }

            @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AllocatedBuffer
            /* renamed from: limit */
            public int mo3913limit() {
                return byteBuffer.limit();
            }

            @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AllocatedBuffer
            public ByteBuffer nioBuffer() {
                return byteBuffer;
            }

            @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AllocatedBuffer
            public int position() {
                return byteBuffer.position();
            }

            @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AllocatedBuffer
            public int remaining() {
                return byteBuffer.remaining();
            }

            @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AllocatedBuffer
            public AllocatedBuffer position(int i) {
                byteBuffer.position(i);
                return this;
            }
        };
    }
}
