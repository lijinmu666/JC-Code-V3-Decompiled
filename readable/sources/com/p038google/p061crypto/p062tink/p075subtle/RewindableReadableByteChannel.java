package com.p038google.p061crypto.p062tink.p075subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class RewindableReadableByteChannel implements ReadableByteChannel {

    @GuardedBy("this")
    final ReadableByteChannel baseChannel;

    /* renamed from: buffer */
    @GuardedBy("this")
    ByteBuffer f3989buffer = null;

    @GuardedBy("this")
    boolean canRewind = true;

    @GuardedBy("this")
    boolean directRead = false;

    public RewindableReadableByteChannel(ReadableByteChannel readableByteChannel) {
        this.baseChannel = readableByteChannel;
    }

    private synchronized void setBufferLimit(int i) {
        try {
            if (this.f3989buffer.capacity() < i) {
                int iPosition = this.f3989buffer.position();
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(Math.max(this.f3989buffer.capacity() * 2, i));
                this.f3989buffer.rewind();
                byteBufferAllocate.put(this.f3989buffer);
                byteBufferAllocate.position(iPosition);
                this.f3989buffer = byteBufferAllocate;
            }
            this.f3989buffer.limit(i);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.canRewind = false;
        this.directRead = true;
        this.baseChannel.close();
    }

    public synchronized void disableRewinding() {
        this.canRewind = false;
    }

    @Override // java.nio.channels.Channel
    public synchronized boolean isOpen() {
        return this.baseChannel.isOpen();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer byteBuffer) {
        if (this.directRead) {
            return this.baseChannel.read(byteBuffer);
        }
        int iRemaining = byteBuffer.remaining();
        if (iRemaining == 0) {
            return 0;
        }
        ByteBuffer byteBuffer2 = this.f3989buffer;
        if (byteBuffer2 == null) {
            if (!this.canRewind) {
                this.directRead = true;
                return this.baseChannel.read(byteBuffer);
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iRemaining);
            this.f3989buffer = byteBufferAllocate;
            int i = this.baseChannel.read(byteBufferAllocate);
            this.f3989buffer.flip();
            if (i > 0) {
                byteBuffer.put(this.f3989buffer);
            }
            return i;
        }
        if (byteBuffer2.remaining() >= iRemaining) {
            int iLimit = this.f3989buffer.limit();
            ByteBuffer byteBuffer3 = this.f3989buffer;
            byteBuffer3.limit(byteBuffer3.position() + iRemaining);
            byteBuffer.put(this.f3989buffer);
            this.f3989buffer.limit(iLimit);
            if (!this.canRewind && !this.f3989buffer.hasRemaining()) {
                this.f3989buffer = null;
                this.directRead = true;
            }
            return iRemaining;
        }
        int iRemaining2 = this.f3989buffer.remaining();
        int iPosition = this.f3989buffer.position();
        int iLimit2 = this.f3989buffer.limit();
        setBufferLimit((iRemaining - iRemaining2) + iLimit2);
        this.f3989buffer.position(iLimit2);
        int i2 = this.baseChannel.read(this.f3989buffer);
        this.f3989buffer.flip();
        this.f3989buffer.position(iPosition);
        byteBuffer.put(this.f3989buffer);
        if (iRemaining2 == 0 && i2 < 0) {
            return -1;
        }
        int iPosition2 = this.f3989buffer.position() - iPosition;
        if (!this.canRewind && !this.f3989buffer.hasRemaining()) {
            this.f3989buffer = null;
            this.directRead = true;
        }
        return iPosition2;
    }

    /* renamed from: rewind */
    public synchronized void m4282rewind() {
        if (!this.canRewind) {
            throw new IOException("Cannot rewind anymore.");
        }
        ByteBuffer byteBuffer = this.f3989buffer;
        if (byteBuffer != null) {
            byteBuffer.position(0);
        }
    }
}
