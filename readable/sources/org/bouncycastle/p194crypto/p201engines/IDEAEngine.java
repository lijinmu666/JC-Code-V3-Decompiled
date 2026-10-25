package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class IDEAEngine implements BlockCipher {

    /* renamed from: BASE */
    private static final int f19915BASE = 65537;
    protected static final int BLOCK_SIZE = 8;

    /* renamed from: MASK */
    private static final int f19916MASK = 65535;
    private boolean forEncryption;
    private int[] workingKey = null;

    public IDEAEngine() {
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), 128));
    }

    private int bytesToWord(byte[] bArr, int i) {
        return ((bArr[i] << 8) & 65280) + (bArr[i + 1] & C1126UByte.MAX_VALUE);
    }

    private int[] expandKey(byte[] bArr) {
        int i;
        int[] iArr = new int[52];
        int i2 = 0;
        if (bArr.length < 16) {
            byte[] bArr2 = new byte[16];
            System.arraycopy(bArr, 0, bArr2, 16 - bArr.length, bArr.length);
            bArr = bArr2;
        }
        while (true) {
            if (i2 >= 8) {
                break;
            }
            iArr[i2] = bytesToWord(bArr, i2 * 2);
            i2++;
        }
        for (i = 8; i < 52; i++) {
            int i3 = i & 7;
            if (i3 < 6) {
                iArr[i] = (((iArr[i - 7] & 127) << 9) | (iArr[i - 6] >> 7)) & 65535;
            } else if (i3 == 6) {
                iArr[i] = (((iArr[i - 7] & 127) << 9) | (iArr[i - 14] >> 7)) & 65535;
            } else {
                iArr[i] = (((iArr[i - 15] & 127) << 9) | (iArr[i - 14] >> 7)) & 65535;
            }
        }
        return iArr;
    }

    private int[] generateWorkingKey(boolean z, byte[] bArr) {
        return z ? expandKey(bArr) : invertKey(expandKey(bArr));
    }

    private void ideaFunc(int[] iArr, byte[] bArr, int i, byte[] bArr2, int i2) {
        int iBytesToWord = bytesToWord(bArr, i);
        int iBytesToWord2 = bytesToWord(bArr, i + 2);
        int iBytesToWord3 = bytesToWord(bArr, i + 4);
        int iBytesToWord4 = bytesToWord(bArr, i + 6);
        int i3 = 0;
        int i4 = iBytesToWord3;
        int i5 = iBytesToWord2;
        int i6 = iBytesToWord;
        int i7 = 0;
        while (i3 < 8) {
            int iM15344mul = m15344mul(i6, iArr[i7]);
            int i8 = (i5 + iArr[i7 + 1]) & 65535;
            int i9 = (i4 + iArr[i7 + 2]) & 65535;
            int iM15344mul2 = m15344mul(iBytesToWord4, iArr[i7 + 3]);
            int i10 = i7 + 5;
            int iM15344mul3 = m15344mul(i9 ^ iM15344mul, iArr[i7 + 4]);
            i7 += 6;
            int iM15344mul4 = m15344mul(((i8 ^ iM15344mul2) + iM15344mul3) & 65535, iArr[i10]);
            int i11 = 65535 & (iM15344mul3 + iM15344mul4);
            i6 = iM15344mul ^ iM15344mul4;
            iBytesToWord4 = iM15344mul2 ^ i11;
            int i12 = i9 ^ iM15344mul4;
            i3++;
            i4 = i8 ^ i11;
            i5 = i12;
        }
        wordToBytes(m15344mul(i6, iArr[i7]), bArr2, i2);
        wordToBytes(i4 + iArr[i7 + 1], bArr2, i2 + 2);
        wordToBytes(i5 + iArr[i7 + 2], bArr2, i2 + 4);
        wordToBytes(m15344mul(iBytesToWord4, iArr[i7 + 3]), bArr2, i2 + 6);
    }

    private int[] invertKey(int[] iArr) {
        int[] iArr2 = new int[52];
        int iM15345mulInv = m15345mulInv(iArr[0]);
        int iM15346addInv = m15346addInv(iArr[1]);
        int iM15346addInv2 = m15346addInv(iArr[2]);
        iArr2[51] = m15345mulInv(iArr[3]);
        iArr2[50] = iM15346addInv2;
        iArr2[49] = iM15346addInv;
        int i = 48;
        iArr2[48] = iM15345mulInv;
        int i2 = 4;
        for (int i3 = 1; i3 < 8; i3++) {
            int i4 = iArr[i2];
            iArr2[i - 1] = iArr[i2 + 1];
            iArr2[i - 2] = i4;
            int iM15345mulInv2 = m15345mulInv(iArr[i2 + 2]);
            int iM15346addInv3 = m15346addInv(iArr[i2 + 3]);
            int i5 = i2 + 5;
            int iM15346addInv4 = m15346addInv(iArr[i2 + 4]);
            i2 += 6;
            iArr2[i - 3] = m15345mulInv(iArr[i5]);
            iArr2[i - 4] = iM15346addInv3;
            iArr2[i - 5] = iM15346addInv4;
            i -= 6;
            iArr2[i] = iM15345mulInv2;
        }
        int i6 = iArr[i2];
        iArr2[i - 1] = iArr[i2 + 1];
        iArr2[i - 2] = i6;
        int iM15345mulInv3 = m15345mulInv(iArr[i2 + 2]);
        int iM15346addInv5 = m15346addInv(iArr[i2 + 3]);
        int iM15346addInv6 = m15346addInv(iArr[i2 + 4]);
        iArr2[i - 3] = m15345mulInv(iArr[i2 + 5]);
        iArr2[i - 4] = iM15346addInv6;
        iArr2[i - 5] = iM15346addInv5;
        iArr2[i - 6] = iM15345mulInv3;
        return iArr2;
    }

    /* renamed from: mul */
    private int m15344mul(int i, int i2) {
        int i3;
        if (i == 0) {
            i3 = f19915BASE - i2;
        } else if (i2 == 0) {
            i3 = f19915BASE - i;
        } else {
            int i4 = i * i2;
            int i5 = i4 & 65535;
            int i6 = i4 >>> 16;
            i3 = (i5 - i6) + (i5 < i6 ? 1 : 0);
        }
        return 65535 & i3;
    }

    /* renamed from: mulInv */
    private int m15345mulInv(int i) {
        if (i < 2) {
            return i;
        }
        int i2 = f19915BASE / i;
        int i3 = f19915BASE % i;
        int i4 = 1;
        while (i3 != 1) {
            int i5 = i / i3;
            i %= i3;
            i4 = (i4 + (i5 * i2)) & 65535;
            if (i == 1) {
                return i4;
            }
            int i6 = i3 / i;
            i3 %= i;
            i2 = (i2 + (i6 * i4)) & 65535;
        }
        return (1 - i2) & 65535;
    }

    private void wordToBytes(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 8);
        bArr[i2 + 1] = (byte) i;
    }

    /* renamed from: addInv */
    public int m15346addInv(int i) {
        return (0 - i) & 65535;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public String getAlgorithmName() {
        return "IDEA";
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int getBlockSize() {
        return 8;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: init */
    public void mo14946init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("invalid parameter passed to IDEA init - " + cipherParameters.getClass().getName());
        }
        byte[] bArrM15773getKey = ((KeyParameter) cipherParameters).m15773getKey();
        this.workingKey = generateWorkingKey(z, bArrM15773getKey);
        this.forEncryption = z;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), bArrM15773getKey.length * 8, cipherParameters, C5342Utils.getPurpose(z)));
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int[] iArr = this.workingKey;
        if (iArr == null) {
            throw new IllegalStateException("IDEA engine not initialised");
        }
        if (i + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i2 + 8 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        ideaFunc(iArr, bArr, i, bArr2, i2);
        return 8;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: reset */
    public void mo14947reset() {
    }
}
