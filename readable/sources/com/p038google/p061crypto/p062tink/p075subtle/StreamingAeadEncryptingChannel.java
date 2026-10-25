package com.p038google.p061crypto.p062tink.p075subtle;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.WritableByteChannel;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
class StreamingAeadEncryptingChannel implements WritableByteChannel {
    private WritableByteChannel ciphertextChannel;
    ByteBuffer ctBuffer;
    private StreamSegmentEncrypter encrypter;

    /* renamed from: open */
    boolean f3999open = true;
    private int plaintextSegmentSize;
    ByteBuffer ptBuffer;

    public StreamingAeadEncryptingChannel(NonceBasedStreamingAead nonceBasedStreamingAead, WritableByteChannel writableByteChannel, byte[] bArr) throws IOException {
        this.ciphertextChannel = writableByteChannel;
        this.encrypter = nonceBasedStreamingAead.newStreamSegmentEncrypter(bArr);
        int plaintextSegmentSize = nonceBasedStreamingAead.getPlaintextSegmentSize();
        this.plaintextSegmentSize = plaintextSegmentSize;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(plaintextSegmentSize);
        this.ptBuffer = byteBufferAllocate;
        byteBufferAllocate.limit(this.plaintextSegmentSize - nonceBasedStreamingAead.getCiphertextOffset());
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(nonceBasedStreamingAead.getCiphertextSegmentSize());
        this.ctBuffer = byteBufferAllocate2;
        byteBufferAllocate2.put(this.encrypter.getHeader());
        this.ctBuffer.flip();
        writableByteChannel.write(this.ctBuffer);
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.f3999open) {
            while (this.ctBuffer.remaining() > 0) {
                if (this.ciphertextChannel.write(this.ctBuffer) <= 0) {
                    throw new IOException("Failed to write ciphertext before closing");
                }
            }
            try {
                this.ctBuffer.clear();
                this.ptBuffer.flip();
                this.encrypter.encryptSegment(this.ptBuffer, true, this.ctBuffer);
                this.ctBuffer.flip();
                while (this.ctBuffer.remaining() > 0) {
                    if (this.ciphertextChannel.write(this.ctBuffer) <= 0) {
                        throw new IOException("Failed to write ciphertext before closing");
                    }
                }
                this.ciphertextChannel.close();
                this.f3999open = false;
            } catch (GeneralSecurityException e) {
                throw new IOException(e);
            }
        }
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.f3999open;
    }

    @Override // java.nio.channels.WritableByteChannel
    public synchronized int write(ByteBuffer byteBuffer) {
        try {
            if (!this.f3999open) {
                throw new ClosedChannelException();
            }
            if (this.ctBuffer.remaining() > 0) {
                this.ciphertextChannel.write(this.ctBuffer);
            }
            int iPosition = byteBuffer.position();
            while (byteBuffer.remaining() > this.ptBuffer.remaining()) {
                if (this.ctBuffer.remaining() > 0) {
                    return byteBuffer.position() - iPosition;
                }
                int iRemaining = this.ptBuffer.remaining();
                ByteBuffer byteBufferSlice = byteBuffer.slice();
                byteBufferSlice.limit(iRemaining);
                byteBuffer.position(byteBuffer.position() + iRemaining);
                try {
                    this.ptBuffer.flip();
                    this.ctBuffer.clear();
                    if (byteBufferSlice.remaining() != 0) {
                        this.encrypter.encryptSegment(this.ptBuffer, byteBufferSlice, false, this.ctBuffer);
                    } else {
                        this.encrypter.encryptSegment(this.ptBuffer, false, this.ctBuffer);
                    }
                    this.ctBuffer.flip();
                    this.ciphertextChannel.write(this.ctBuffer);
                    this.ptBuffer.clear();
                    this.ptBuffer.limit(this.plaintextSegmentSize);
                } catch (GeneralSecurityException e) {
                    throw new IOException(e);
                }
            }
            this.ptBuffer.put(byteBuffer);
            return byteBuffer.position() - iPosition;
        } catch (Throwable th) {
            throw th;
        }
    }
}
