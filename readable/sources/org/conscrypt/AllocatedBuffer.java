package org.conscrypt;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public abstract class AllocatedBuffer {
    /* renamed from: wrap */
    public static AllocatedBuffer m18410wrap(final ByteBuffer byteBuffer) {
        Preconditions.checkNotNull(byteBuffer, "buffer");
        return new AllocatedBuffer() { // from class: org.conscrypt.AllocatedBuffer.1
            @Override // org.conscrypt.AllocatedBuffer
            public ByteBuffer nioBuffer() {
                return byteBuffer;
            }

            @Override // org.conscrypt.AllocatedBuffer
            /* renamed from: release */
            public AllocatedBuffer mo18411release() {
                return this;
            }
        };
    }

    public abstract ByteBuffer nioBuffer();

    /* renamed from: release */
    public abstract AllocatedBuffer mo18411release();

    @Deprecated
    /* renamed from: retain */
    public AllocatedBuffer m18412retain() {
        return this;
    }
}
