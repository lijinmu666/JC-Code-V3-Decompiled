package org.bouncycastle.p194crypto.p210modes;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.StreamBlockCipher;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class SICBlockCipher extends StreamBlockCipher implements CTRModeCipher {

    /* renamed from: IV */
    private byte[] f20637IV;
    private final int blockSize;
    private int byteCount;

    /* renamed from: cipher */
    private final BlockCipher f20638cipher;

    /* renamed from: counter */
    private byte[] f20639counter;
    private byte[] counterOut;

    @Deprecated
    public SICBlockCipher(BlockCipher blockCipher) {
        super(blockCipher);
        this.f20638cipher = blockCipher;
        int blockSize = blockCipher.getBlockSize();
        this.blockSize = blockSize;
        this.f20637IV = new byte[blockSize];
        this.f20639counter = new byte[blockSize];
        this.counterOut = new byte[blockSize];
        this.byteCount = 0;
    }

    private void adjustCounter(long j) {
        int i = 5;
        if (j >= 0) {
            long j2 = (this.byteCount + j) / this.blockSize;
            long j3 = j2;
            if (j2 > 255) {
                while (i >= 1) {
                    long j4 = 1 << (i * 8);
                    while (j3 >= j4) {
                        incrementCounterAt(i);
                        j3 -= j4;
                    }
                    i--;
                }
            }
            incrementCounter((int) j3);
            this.byteCount = (int) ((j + this.byteCount) - (this.blockSize * j2));
            return;
        }
        long j5 = ((-j) - this.byteCount) / this.blockSize;
        long j6 = j5;
        if (j5 > 255) {
            while (i >= 1) {
                long j7 = 1 << (i * 8);
                while (j6 > j7) {
                    decrementCounterAt(i);
                    j6 -= j7;
                }
                i--;
            }
        }
        for (long j8 = 0; j8 != j6; j8++) {
            decrementCounterAt(0);
        }
        int i2 = (int) (this.byteCount + j + (this.blockSize * j5));
        if (i2 >= 0) {
            this.byteCount = 0;
        } else {
            decrementCounterAt(0);
            this.byteCount = this.blockSize + i2;
        }
    }

    private void checkCounter() {
        byte[] bArr = this.f20637IV;
        if (bArr.length < this.blockSize) {
            for (int length = bArr.length - 1; length >= 0; length--) {
                if (this.f20639counter[length] != this.f20637IV[length]) {
                    throw new IllegalStateException("Counter in CTR/SIC mode out of range.");
                }
            }
        }
    }

    private void checkLastIncrement() {
        byte[] bArr = this.f20637IV;
        if (bArr.length < this.blockSize && this.f20639counter[bArr.length - 1] != bArr[bArr.length - 1]) {
            throw new IllegalStateException("Counter in CTR/SIC mode out of range.");
        }
    }

    private void decrementCounterAt(int i) {
        byte b;
        int length = this.f20639counter.length - i;
        do {
            length--;
            if (length < 0) {
                return;
            }
            b = (byte) (r1[length] - 1);
            this.f20639counter[length] = b;
        } while (b == -1);
    }

    private void incrementCounter() {
        byte b;
        int length = this.f20639counter.length;
        do {
            length--;
            if (length < 0) {
                return;
            }
            byte[] bArr = this.f20639counter;
            b = (byte) (bArr[length] + 1);
            bArr[length] = b;
        } while (b == 0);
    }

    private void incrementCounterAt(int i) {
        byte b;
        int length = this.f20639counter.length - i;
        do {
            length--;
            if (length < 0) {
                return;
            }
            byte[] bArr = this.f20639counter;
            b = (byte) (bArr[length] + 1);
            bArr[length] = b;
        } while (b == 0);
    }

    public static CTRModeCipher newInstance(BlockCipher blockCipher) {
        return new SICBlockCipher(blockCipher);
    }

    @Override // org.bouncycastle.p194crypto.StreamBlockCipher
    public byte calculateByte(byte b) {
        int i = this.byteCount;
        if (i == 0) {
            checkLastIncrement();
            this.f20638cipher.processBlock(this.f20639counter, 0, this.counterOut, 0);
            byte[] bArr = this.counterOut;
            int i2 = this.byteCount;
            this.byteCount = i2 + 1;
            return (byte) (bArr[i2] ^ b);
        }
        byte[] bArr2 = this.counterOut;
        int i3 = i + 1;
        this.byteCount = i3;
        byte b2 = (byte) (b ^ bArr2[i]);
        if (i3 == this.f20639counter.length) {
            this.byteCount = 0;
            incrementCounter();
        }
        return b2;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public String getAlgorithmName() {
        return this.f20638cipher.getAlgorithmName() + "/SIC";
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int getBlockSize() {
        return this.f20638cipher.getBlockSize();
    }

    @Override // org.bouncycastle.p194crypto.SkippingCipher
    public long getPosition() {
        byte[] bArr = this.f20639counter;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        int i = length - 1;
        while (i >= 1) {
            byte[] bArr3 = this.f20637IV;
            int i2 = i < bArr3.length ? (bArr2[i] & C1126UByte.MAX_VALUE) - (bArr3[i] & C1126UByte.MAX_VALUE) : bArr2[i] & C1126UByte.MAX_VALUE;
            if (i2 < 0) {
                int i3 = i - 1;
                bArr2[i3] = (byte) (bArr2[i3] - 1);
                i2 += 256;
            }
            bArr2[i] = (byte) i2;
            i--;
        }
        return (AbstractC6245Pack.bigEndianToLong(bArr2, length - 8) * this.blockSize) + this.byteCount;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: init */
    public void mo14946init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof ParametersWithIV)) {
            throw new IllegalArgumentException("CTR/SIC mode requires ParametersWithIV");
        }
        ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
        byte[] bArrM18231clone = C6238Arrays.m18231clone(parametersWithIV.m15801getIV());
        this.f20637IV = bArrM18231clone;
        int i = this.blockSize;
        if (i < bArrM18231clone.length) {
            throw new IllegalArgumentException("CTR/SIC mode requires IV no greater than: " + this.blockSize + " bytes.");
        }
        int i2 = 8 > i / 2 ? i / 2 : 8;
        if (i - bArrM18231clone.length <= i2) {
            if (parametersWithIV.getParameters() != null) {
                this.f20638cipher.mo14946init(true, parametersWithIV.getParameters());
            }
            mo14947reset();
        } else {
            throw new IllegalArgumentException("CTR/SIC mode requires IV of at least: " + (this.blockSize - i2) + " bytes.");
        }
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.byteCount != 0) {
            processBytes(bArr, i, this.blockSize, bArr2, i2);
        } else {
            int i3 = this.blockSize;
            if (i + i3 > bArr.length) {
                throw new DataLengthException("input buffer too small");
            }
            if (i3 + i2 > bArr2.length) {
                throw new OutputLengthException("output buffer too short");
            }
            this.f20638cipher.processBlock(this.f20639counter, 0, this.counterOut, 0);
            for (int i4 = 0; i4 < this.blockSize; i4++) {
                bArr2[i2 + i4] = (byte) (bArr[i + i4] ^ this.counterOut[i4]);
            }
            incrementCounter();
        }
        return this.blockSize;
    }

    @Override // org.bouncycastle.p194crypto.StreamBlockCipher, org.bouncycastle.p194crypto.StreamCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        byte b;
        if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too small");
        }
        if (i3 + i2 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = this.byteCount;
            if (i5 == 0) {
                checkLastIncrement();
                this.f20638cipher.processBlock(this.f20639counter, 0, this.counterOut, 0);
                byte b2 = bArr[i + i4];
                byte[] bArr3 = this.counterOut;
                int i6 = this.byteCount;
                this.byteCount = i6 + 1;
                b = (byte) (b2 ^ bArr3[i6]);
            } else {
                byte b3 = bArr[i + i4];
                byte[] bArr4 = this.counterOut;
                int i7 = i5 + 1;
                this.byteCount = i7;
                b = (byte) (bArr4[i5] ^ b3);
                if (i7 == this.f20639counter.length) {
                    this.byteCount = 0;
                    incrementCounter();
                }
            }
            bArr2[i3 + i4] = b;
        }
        return i2;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: reset */
    public void mo14947reset() {
        C6238Arrays.m18249fill(this.f20639counter, (byte) 0);
        byte[] bArr = this.f20637IV;
        System.arraycopy(bArr, 0, this.f20639counter, 0, bArr.length);
        this.f20638cipher.mo14947reset();
        this.byteCount = 0;
    }

    @Override // org.bouncycastle.p194crypto.SkippingCipher
    /* renamed from: seekTo */
    public long mo14991seekTo(long j) {
        mo14947reset();
        return mo14992skip(j);
    }

    @Override // org.bouncycastle.p194crypto.SkippingCipher
    /* renamed from: skip */
    public long mo14992skip(long j) {
        adjustCounter(j);
        checkCounter();
        this.f20638cipher.processBlock(this.f20639counter, 0, this.counterOut, 0);
        return j;
    }

    private void incrementCounter(int i) {
        byte[] bArr = this.f20639counter;
        byte b = bArr[bArr.length - 1];
        int length = bArr.length - 1;
        bArr[length] = (byte) (bArr[length] + ((byte) i));
        if ((b & C1126UByte.MAX_VALUE) + i > 255) {
            incrementCounterAt(1);
        }
    }
}
