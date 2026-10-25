package com.p038google.p061crypto.p062tink.streamingaead;

import com.p038google.p061crypto.p062tink.PrimitiveSet;
import com.p038google.p061crypto.p062tink.StreamingAead;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
final class InputStreamDecrypter extends InputStream {
    byte[] associatedData;

    @GuardedBy("this")
    InputStream ciphertextStream;
    PrimitiveSet<StreamingAead> primitives;

    @GuardedBy("this")
    boolean attemptedMatching = false;

    @GuardedBy("this")
    InputStream matchingStream = null;

    public InputStreamDecrypter(PrimitiveSet<StreamingAead> primitiveSet, InputStream inputStream, byte[] bArr) {
        this.primitives = primitiveSet;
        if (inputStream.markSupported()) {
            this.ciphertextStream = inputStream;
        } else {
            this.ciphertextStream = new BufferedInputStream(inputStream);
        }
        this.ciphertextStream.mark(Integer.MAX_VALUE);
        this.associatedData = (byte[]) bArr.clone();
    }

    @GuardedBy("this")
    private void disableRewinding() {
        this.ciphertextStream.mark(0);
    }

    @GuardedBy("this")
    /* renamed from: rewind */
    private void m4211rewind() throws IOException {
        this.ciphertextStream.reset();
    }

    @Override // java.io.InputStream
    @GuardedBy("this")
    public synchronized int available() {
        InputStream inputStream = this.matchingStream;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    @GuardedBy("this")
    public synchronized void close() {
        this.ciphertextStream.close();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    @GuardedBy("this")
    public synchronized int read() {
        byte[] bArr = new byte[1];
        if (read(bArr) != 1) {
            return -1;
        }
        return bArr[0];
    }

    @Override // java.io.InputStream
    @GuardedBy("this")
    public synchronized int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    @GuardedBy("this")
    public synchronized int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        InputStream inputStream = this.matchingStream;
        if (inputStream != null) {
            return inputStream.read(bArr, i, i2);
        }
        if (!this.attemptedMatching) {
            this.attemptedMatching = true;
            Iterator<PrimitiveSet.C0320Entry<StreamingAead>> it = this.primitives.getRawPrimitives().iterator();
            while (it.hasNext()) {
                try {
                    try {
                        InputStream inputStreamNewDecryptingStream = it.next().getPrimitive().newDecryptingStream(this.ciphertextStream, this.associatedData);
                        int i3 = inputStreamNewDecryptingStream.read(bArr, i, i2);
                        if (i3 != 0) {
                            this.matchingStream = inputStreamNewDecryptingStream;
                            disableRewinding();
                            return i3;
                        }
                        throw new IOException("Could not read bytes from the ciphertext stream");
                    } catch (GeneralSecurityException unused) {
                        m4211rewind();
                    }
                } catch (IOException unused2) {
                    m4211rewind();
                }
            }
            throw new IOException("No matching key found for the ciphertext in the stream.");
        }
        throw new IOException("No matching key found for the ciphertext in the stream.");
    }
}
