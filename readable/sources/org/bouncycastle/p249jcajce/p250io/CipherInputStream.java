package org.bouncycastle.p249jcajce.p250io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import org.bouncycastle.p194crypto.p206io.InvalidCipherTextIOException;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class CipherInputStream extends FilterInputStream {

    /* renamed from: buf */
    private byte[] f21371buf;

    /* renamed from: bufOff */
    private int f21372bufOff;

    /* renamed from: cipher */
    private final Cipher f21373cipher;
    private boolean finalized;
    private final byte[] inputBuffer;

    /* renamed from: maxBuf */
    private int f21374maxBuf;
    private boolean nextChunkCalled;

    public CipherInputStream(InputStream inputStream, Cipher cipher) {
        super(inputStream);
        this.inputBuffer = new byte[512];
        this.finalized = false;
        this.nextChunkCalled = false;
        this.f21373cipher = cipher;
    }

    private byte[] finaliseCipher() throws IOException {
        try {
            if (!this.nextChunkCalled) {
                nextChunk();
            }
            if (this.finalized) {
                return null;
            }
            this.finalized = true;
            return this.f21373cipher.doFinal();
        } catch (GeneralSecurityException e) {
            throw new InvalidCipherTextIOException("Error finalising cipher", e);
        }
    }

    private int nextChunk() throws IOException {
        if (this.finalized) {
            return -1;
        }
        this.nextChunkCalled = true;
        this.f21372bufOff = 0;
        this.f21374maxBuf = 0;
        while (true) {
            int i = this.f21374maxBuf;
            if (i != 0) {
                return i;
            }
            int i2 = ((FilterInputStream) this).in.read(this.inputBuffer);
            if (i2 == -1) {
                byte[] bArrFinaliseCipher = finaliseCipher();
                this.f21371buf = bArrFinaliseCipher;
                if (bArrFinaliseCipher == null || bArrFinaliseCipher.length == 0) {
                    return -1;
                }
                int length = bArrFinaliseCipher.length;
                this.f21374maxBuf = length;
                return length;
            }
            byte[] bArrUpdate = this.f21373cipher.update(this.inputBuffer, 0, i2);
            this.f21371buf = bArrUpdate;
            if (bArrUpdate != null) {
                this.f21374maxBuf = bArrUpdate.length;
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        return this.f21374maxBuf - this.f21372bufOff;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            ((FilterInputStream) this).in.close();
            this.f21372bufOff = 0;
            this.f21374maxBuf = 0;
        } finally {
            if (!this.finalized) {
                finaliseCipher();
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        if (this.f21372bufOff >= this.f21374maxBuf && nextChunk() < 0) {
            return -1;
        }
        byte[] bArr = this.f21371buf;
        int i = this.f21372bufOff;
        this.f21372bufOff = i + 1;
        return bArr[i] & C1126UByte.MAX_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        if (j <= 0) {
            return 0L;
        }
        int iMin = (int) Math.min(j, available());
        this.f21372bufOff += iMin;
        return iMin;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (this.f21372bufOff >= this.f21374maxBuf && nextChunk() < 0) {
            return -1;
        }
        int iMin = Math.min(i2, available());
        System.arraycopy(this.f21371buf, this.f21372bufOff, bArr, i, iMin);
        this.f21372bufOff += iMin;
        return iMin;
    }
}
