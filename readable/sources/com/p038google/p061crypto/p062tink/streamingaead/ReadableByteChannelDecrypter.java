package com.p038google.p061crypto.p062tink.streamingaead;

import com.p038google.p061crypto.p062tink.PrimitiveSet;
import com.p038google.p061crypto.p062tink.StreamingAead;
import com.p038google.p061crypto.p062tink.p075subtle.RewindableReadableByteChannel;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.security.GeneralSecurityException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
final class ReadableByteChannelDecrypter implements ReadableByteChannel {
    byte[] associatedData;

    @GuardedBy("this")
    RewindableReadableByteChannel ciphertextChannel;

    @GuardedBy("this")
    ReadableByteChannel attemptingChannel = null;

    @GuardedBy("this")
    ReadableByteChannel matchingChannel = null;
    Deque<StreamingAead> remainingPrimitives = new ArrayDeque();

    public ReadableByteChannelDecrypter(PrimitiveSet<StreamingAead> primitiveSet, ReadableByteChannel readableByteChannel, byte[] bArr) {
        Iterator<PrimitiveSet.C0320Entry<StreamingAead>> it = primitiveSet.getRawPrimitives().iterator();
        while (it.hasNext()) {
            this.remainingPrimitives.add(it.next().getPrimitive());
        }
        this.ciphertextChannel = new RewindableReadableByteChannel(readableByteChannel);
        this.associatedData = (byte[]) bArr.clone();
    }

    @GuardedBy("this")
    private synchronized ReadableByteChannel nextAttemptingChannel() {
        while (!this.remainingPrimitives.isEmpty()) {
            try {
            } catch (GeneralSecurityException unused) {
                this.ciphertextChannel.m4282rewind();
            }
        }
        throw new IOException("No matching key found for the ciphertext in the stream.");
        return this.remainingPrimitives.removeFirst().newDecryptingChannel(this.ciphertextChannel, this.associatedData);
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.ciphertextChannel.close();
    }

    @Override // java.nio.channels.Channel
    public synchronized boolean isOpen() {
        return this.ciphertextChannel.isOpen();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public synchronized int read(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() == 0) {
            return 0;
        }
        ReadableByteChannel readableByteChannel = this.matchingChannel;
        if (readableByteChannel != null) {
            return readableByteChannel.read(byteBuffer);
        }
        if (this.attemptingChannel == null) {
            this.attemptingChannel = nextAttemptingChannel();
        }
        while (true) {
            try {
                int i = this.attemptingChannel.read(byteBuffer);
                if (i == 0) {
                    return 0;
                }
                this.matchingChannel = this.attemptingChannel;
                this.attemptingChannel = null;
                this.ciphertextChannel.disableRewinding();
                return i;
            } catch (IOException unused) {
                this.ciphertextChannel.m4282rewind();
                this.attemptingChannel = nextAttemptingChannel();
            }
        }
    }
}
