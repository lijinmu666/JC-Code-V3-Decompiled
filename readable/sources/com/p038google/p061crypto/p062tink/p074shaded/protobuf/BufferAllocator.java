package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import java.nio.ByteBuffer;

@CheckReturnValue
/* loaded from: classes.dex */
abstract class BufferAllocator {
    private static final BufferAllocator UNPOOLED = new BufferAllocator() { // from class: com.google.crypto.tink.shaded.protobuf.BufferAllocator.1
        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BufferAllocator
        public AllocatedBuffer allocateDirectBuffer(int i) {
            return AllocatedBuffer.m3909wrap(ByteBuffer.allocateDirect(i));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BufferAllocator
        public AllocatedBuffer allocateHeapBuffer(int i) {
            return AllocatedBuffer.m3910wrap(new byte[i]);
        }
    };

    public static BufferAllocator unpooled() {
        return UNPOOLED;
    }

    public abstract AllocatedBuffer allocateDirectBuffer(int i);

    public abstract AllocatedBuffer allocateHeapBuffer(int i);
}
