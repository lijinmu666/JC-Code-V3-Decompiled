package org.bouncycastle.p194crypto.p206io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.p194crypto.BufferedBlockCipher;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.SkippingCipher;
import org.bouncycastle.p194crypto.StreamCipher;
import org.bouncycastle.p194crypto.p210modes.AEADBlockCipher;
import org.bouncycastle.p361util.C6238Arrays;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class CipherInputStream extends FilterInputStream {
    private static final int INPUT_BUF_SIZE = 2048;
    private AEADBlockCipher aeadBlockCipher;

    /* renamed from: buf */
    private byte[] f20352buf;

    /* renamed from: bufOff */
    private int f20353bufOff;
    private BufferedBlockCipher bufferedBlockCipher;
    private boolean finalized;

    /* renamed from: inBuf */
    private byte[] f20354inBuf;

    /* renamed from: markBuf */
    private byte[] f20355markBuf;
    private int markBufOff;
    private long markPosition;

    /* renamed from: maxBuf */
    private int f20356maxBuf;
    private SkippingCipher skippingCipher;
    private StreamCipher streamCipher;

    public CipherInputStream(InputStream inputStream, BufferedBlockCipher bufferedBlockCipher) {
        this(inputStream, bufferedBlockCipher, 2048);
    }

    private void ensureCapacity(int i, boolean z) {
        if (z) {
            BufferedBlockCipher bufferedBlockCipher = this.bufferedBlockCipher;
            if (bufferedBlockCipher != null) {
                i = bufferedBlockCipher.getOutputSize(i);
            } else {
                AEADBlockCipher aEADBlockCipher = this.aeadBlockCipher;
                if (aEADBlockCipher != null) {
                    i = aEADBlockCipher.getOutputSize(i);
                }
            }
        } else {
            BufferedBlockCipher bufferedBlockCipher2 = this.bufferedBlockCipher;
            if (bufferedBlockCipher2 != null) {
                i = bufferedBlockCipher2.getUpdateOutputSize(i);
            } else {
                AEADBlockCipher aEADBlockCipher2 = this.aeadBlockCipher;
                if (aEADBlockCipher2 != null) {
                    i = aEADBlockCipher2.getUpdateOutputSize(i);
                }
            }
        }
        byte[] bArr = this.f20352buf;
        if (bArr == null || bArr.length < i) {
            this.f20352buf = new byte[i];
        }
    }

    private void finaliseCipher() throws IOException {
        int iMo15224doFinal;
        try {
            this.finalized = true;
            ensureCapacity(0, true);
            BufferedBlockCipher bufferedBlockCipher = this.bufferedBlockCipher;
            if (bufferedBlockCipher != null) {
                iMo15224doFinal = bufferedBlockCipher.mo14951doFinal(this.f20352buf, 0);
            } else {
                AEADBlockCipher aEADBlockCipher = this.aeadBlockCipher;
                if (aEADBlockCipher == null) {
                    this.f20356maxBuf = 0;
                    return;
                }
                iMo15224doFinal = aEADBlockCipher.mo15224doFinal(this.f20352buf, 0);
            }
            this.f20356maxBuf = iMo15224doFinal;
        } catch (InvalidCipherTextException e) {
            throw new InvalidCipherTextIOException("Error finalising cipher", e);
        } catch (Exception e2) {
            throw new IOException("Error finalising cipher " + e2);
        }
    }

    private int nextChunk() throws IOException {
        if (this.finalized) {
            return -1;
        }
        this.f20353bufOff = 0;
        this.f20356maxBuf = 0;
        while (true) {
            int i = this.f20356maxBuf;
            if (i != 0) {
                return i;
            }
            int iProcessBytes = ((FilterInputStream) this).in.read(this.f20354inBuf);
            if (iProcessBytes == -1) {
                finaliseCipher();
                int i2 = this.f20356maxBuf;
                if (i2 == 0) {
                    return -1;
                }
                return i2;
            }
            try {
                ensureCapacity(iProcessBytes, false);
                BufferedBlockCipher bufferedBlockCipher = this.bufferedBlockCipher;
                if (bufferedBlockCipher != null) {
                    iProcessBytes = bufferedBlockCipher.processBytes(this.f20354inBuf, 0, iProcessBytes, this.f20352buf, 0);
                } else {
                    AEADBlockCipher aEADBlockCipher = this.aeadBlockCipher;
                    if (aEADBlockCipher != null) {
                        iProcessBytes = aEADBlockCipher.processBytes(this.f20354inBuf, 0, iProcessBytes, this.f20352buf, 0);
                    } else {
                        this.streamCipher.processBytes(this.f20354inBuf, 0, iProcessBytes, this.f20352buf, 0);
                    }
                }
                this.f20356maxBuf = iProcessBytes;
            } catch (Exception e) {
                throw new CipherIOException("Error processing stream ", e);
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        return this.f20356maxBuf - this.f20353bufOff;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            ((FilterInputStream) this).in.close();
            this.f20353bufOff = 0;
            this.f20356maxBuf = 0;
            this.markBufOff = 0;
            this.markPosition = 0L;
            byte[] bArr = this.f20355markBuf;
            if (bArr != null) {
                C6238Arrays.m18249fill(bArr, (byte) 0);
                this.f20355markBuf = null;
            }
            byte[] bArr2 = this.f20352buf;
            if (bArr2 != null) {
                C6238Arrays.m18249fill(bArr2, (byte) 0);
                this.f20352buf = null;
            }
            C6238Arrays.m18249fill(this.f20354inBuf, (byte) 0);
        } finally {
            if (!this.finalized) {
                finaliseCipher();
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        ((FilterInputStream) this).in.mark(i);
        SkippingCipher skippingCipher = this.skippingCipher;
        if (skippingCipher != null) {
            this.markPosition = skippingCipher.getPosition();
        }
        byte[] bArr = this.f20352buf;
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            this.f20355markBuf = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
        this.markBufOff = this.f20353bufOff;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        if (this.skippingCipher != null) {
            return ((FilterInputStream) this).in.markSupported();
        }
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        if (this.f20353bufOff >= this.f20356maxBuf && nextChunk() < 0) {
            return -1;
        }
        byte[] bArr = this.f20352buf;
        int i = this.f20353bufOff;
        this.f20353bufOff = i + 1;
        return bArr[i] & C1126UByte.MAX_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        if (this.skippingCipher == null) {
            throw new IOException("cipher must implement SkippingCipher to be used with reset()");
        }
        ((FilterInputStream) this).in.reset();
        this.skippingCipher.mo14991seekTo(this.markPosition);
        byte[] bArr = this.f20355markBuf;
        if (bArr != null) {
            this.f20352buf = bArr;
        }
        this.f20353bufOff = this.markBufOff;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        if (j <= 0) {
            return 0L;
        }
        if (this.skippingCipher == null) {
            int iMin = (int) Math.min(j, available());
            this.f20353bufOff += iMin;
            return iMin;
        }
        long jAvailable = available();
        if (j <= jAvailable) {
            this.f20353bufOff = (int) (this.f20353bufOff + j);
            return j;
        }
        this.f20353bufOff = this.f20356maxBuf;
        long jSkip = ((FilterInputStream) this).in.skip(j - jAvailable);
        if (jSkip == this.skippingCipher.mo14992skip(jSkip)) {
            return jSkip + jAvailable;
        }
        throw new IOException("Unable to skip cipher " + jSkip + " bytes.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CipherInputStream(InputStream inputStream, BufferedBlockCipher bufferedBlockCipher, int i) {
        super(inputStream);
        this.bufferedBlockCipher = bufferedBlockCipher;
        this.f20354inBuf = new byte[i];
        this.skippingCipher = bufferedBlockCipher instanceof SkippingCipher ? (SkippingCipher) bufferedBlockCipher : null;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public CipherInputStream(InputStream inputStream, StreamCipher streamCipher) {
        this(inputStream, streamCipher, 2048);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (this.f20353bufOff >= this.f20356maxBuf && nextChunk() < 0) {
            return -1;
        }
        int iMin = Math.min(i2, available());
        System.arraycopy(this.f20352buf, this.f20353bufOff, bArr, i, iMin);
        this.f20353bufOff += iMin;
        return iMin;
    }

    public CipherInputStream(InputStream inputStream, StreamCipher streamCipher, int i) {
        super(inputStream);
        this.streamCipher = streamCipher;
        this.f20354inBuf = new byte[i];
        this.skippingCipher = streamCipher instanceof SkippingCipher ? (SkippingCipher) streamCipher : null;
    }

    public CipherInputStream(InputStream inputStream, AEADBlockCipher aEADBlockCipher) {
        this(inputStream, aEADBlockCipher, 2048);
    }

    public CipherInputStream(InputStream inputStream, AEADBlockCipher aEADBlockCipher, int i) {
        super(inputStream);
        this.aeadBlockCipher = aEADBlockCipher;
        this.f20354inBuf = new byte[i];
        this.skippingCipher = aEADBlockCipher instanceof SkippingCipher ? (SkippingCipher) aEADBlockCipher : null;
    }
}
