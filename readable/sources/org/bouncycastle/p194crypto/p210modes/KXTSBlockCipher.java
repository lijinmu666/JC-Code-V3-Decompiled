package org.bouncycastle.p194crypto.p210modes;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.DefaultBufferedBlockCipher;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class KXTSBlockCipher extends DefaultBufferedBlockCipher {
    private static final long RED_POLY_128 = 135;
    private static final long RED_POLY_256 = 1061;
    private static final long RED_POLY_512 = 293;
    private final int blockSize;

    /* renamed from: counter */
    private int f20612counter;
    private final long reductionPolynomial;
    private final long[] tw_current;

    /* renamed from: tw_init */
    private final long[] f20613tw_init;

    public KXTSBlockCipher(BlockCipher blockCipher) {
        ((DefaultBufferedBlockCipher) this).f19135cipher = blockCipher;
        int blockSize = blockCipher.getBlockSize();
        this.blockSize = blockSize;
        this.reductionPolynomial = getReductionPolynomial(blockSize);
        this.f20613tw_init = new long[blockSize >>> 3];
        this.tw_current = new long[blockSize >>> 3];
        this.f20612counter = -1;
    }

    private static void GF_double(long j, long[] jArr) {
        long j2 = 0;
        int i = 0;
        while (i < jArr.length) {
            long j3 = jArr[i];
            jArr[i] = j2 ^ (j3 << 1);
            i++;
            j2 = j3 >>> 63;
        }
        jArr[0] = (j & (-j2)) ^ jArr[0];
    }

    public static long getReductionPolynomial(int i) {
        if (i == 16) {
            return RED_POLY_128;
        }
        if (i == 32) {
            return RED_POLY_256;
        }
        if (i == 64) {
            return RED_POLY_512;
        }
        throw new IllegalArgumentException("Only 128, 256, and 512 -bit block sizes supported");
    }

    private void processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = this.f20612counter;
        if (i3 == -1) {
            throw new IllegalStateException("Attempt to process too many blocks");
        }
        this.f20612counter = i3 + 1;
        GF_double(this.reductionPolynomial, this.tw_current);
        byte[] bArr3 = new byte[this.blockSize];
        AbstractC6245Pack.longToLittleEndian(this.tw_current, bArr3, 0);
        int i4 = this.blockSize;
        byte[] bArr4 = new byte[i4];
        System.arraycopy(bArr3, 0, bArr4, 0, i4);
        for (int i5 = 0; i5 < this.blockSize; i5++) {
            bArr4[i5] = (byte) (bArr4[i5] ^ bArr[i + i5]);
        }
        ((DefaultBufferedBlockCipher) this).f19135cipher.processBlock(bArr4, 0, bArr4, 0);
        for (int i6 = 0; i6 < this.blockSize; i6++) {
            bArr2[i2 + i6] = (byte) (bArr4[i6] ^ bArr3[i6]);
        }
    }

    @Override // org.bouncycastle.p194crypto.DefaultBufferedBlockCipher, org.bouncycastle.p194crypto.BufferedBlockCipher
    /* renamed from: doFinal */
    public int mo14951doFinal(byte[] bArr, int i) {
        mo14953reset();
        return 0;
    }

    @Override // org.bouncycastle.p194crypto.DefaultBufferedBlockCipher, org.bouncycastle.p194crypto.BufferedBlockCipher
    public int getOutputSize(int i) {
        return i;
    }

    @Override // org.bouncycastle.p194crypto.DefaultBufferedBlockCipher, org.bouncycastle.p194crypto.BufferedBlockCipher
    public int getUpdateOutputSize(int i) {
        return i;
    }

    @Override // org.bouncycastle.p194crypto.DefaultBufferedBlockCipher, org.bouncycastle.p194crypto.BufferedBlockCipher
    /* renamed from: init */
    public void mo14952init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof ParametersWithIV)) {
            throw new IllegalArgumentException("Invalid parameters passed");
        }
        ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
        CipherParameters parameters = parametersWithIV.getParameters();
        byte[] bArrM15801getIV = parametersWithIV.m15801getIV();
        int length = bArrM15801getIV.length;
        int i = this.blockSize;
        if (length != i) {
            throw new IllegalArgumentException("Currently only support IVs of exactly one block");
        }
        byte[] bArr = new byte[i];
        System.arraycopy(bArrM15801getIV, 0, bArr, 0, i);
        ((DefaultBufferedBlockCipher) this).f19135cipher.mo14946init(true, parameters);
        ((DefaultBufferedBlockCipher) this).f19135cipher.processBlock(bArr, 0, bArr, 0);
        ((DefaultBufferedBlockCipher) this).f19135cipher.mo14946init(z, parameters);
        AbstractC6245Pack.littleEndianToLong(bArr, 0, this.f20613tw_init);
        long[] jArr = this.f20613tw_init;
        System.arraycopy(jArr, 0, this.tw_current, 0, jArr.length);
        this.f20612counter = 0;
    }

    @Override // org.bouncycastle.p194crypto.DefaultBufferedBlockCipher, org.bouncycastle.p194crypto.BufferedBlockCipher
    public int processByte(byte b, byte[] bArr, int i) {
        throw new IllegalStateException("unsupported operation");
    }

    @Override // org.bouncycastle.p194crypto.DefaultBufferedBlockCipher, org.bouncycastle.p194crypto.BufferedBlockCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (bArr.length - i < i2) {
            throw new DataLengthException("Input buffer too short");
        }
        if (bArr2.length - i < i2) {
            throw new OutputLengthException("Output buffer too short");
        }
        if (i2 % this.blockSize != 0) {
            throw new IllegalArgumentException("Partial blocks not supported");
        }
        int i4 = 0;
        if (bArr == bArr2 && C6238Arrays.segmentsOverlap(i, i2, i3, i2)) {
            bArr = new byte[i2];
            System.arraycopy(bArr2, i, bArr, 0, i2);
            i = 0;
        }
        while (i4 < i2) {
            processBlock(bArr, i + i4, bArr2, i3 + i4);
            i4 += this.blockSize;
        }
        return i2;
    }

    @Override // org.bouncycastle.p194crypto.DefaultBufferedBlockCipher, org.bouncycastle.p194crypto.BufferedBlockCipher
    /* renamed from: reset */
    public void mo14953reset() {
        ((DefaultBufferedBlockCipher) this).f19135cipher.mo14947reset();
        long[] jArr = this.f20613tw_init;
        System.arraycopy(jArr, 0, this.tw_current, 0, jArr.length);
        this.f20612counter = 0;
    }
}
