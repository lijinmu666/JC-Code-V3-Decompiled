package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.StreamCipher;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public class ISAACEngine implements StreamCipher {

    /* renamed from: sizeL */
    private final int f19930sizeL = 8;
    private final int stateArraySize = 256;
    private int[] engineState = null;

    /* renamed from: results */
    private int[] f19929results = null;

    /* renamed from: a */
    private int f19925a = 0;

    /* renamed from: b */
    private int f19926b = 0;

    /* renamed from: c */
    private int f19927c = 0;

    /* renamed from: index */
    private int f19928index = 0;
    private byte[] keyStream = new byte[1024];
    private byte[] workingKey = null;
    private boolean initialised = false;

    /* renamed from: isaac */
    private void m15351isaac() {
        int i;
        int i2;
        int i3 = this.f19926b;
        int i4 = this.f19927c + 1;
        this.f19927c = i4;
        this.f19926b = i3 + i4;
        for (int i5 = 0; i5 < 256; i5++) {
            int[] iArr = this.engineState;
            int i6 = iArr[i5];
            int i7 = i5 & 3;
            if (i7 == 0) {
                i = this.f19925a;
                i2 = i << 13;
            } else if (i7 == 1) {
                i = this.f19925a;
                i2 = i >>> 6;
            } else if (i7 == 2) {
                i = this.f19925a;
                i2 = i << 2;
            } else if (i7 != 3) {
                int i8 = this.f19925a + iArr[(i5 + 128) & 255];
                this.f19925a = i8;
                int i9 = iArr[(i6 >>> 2) & 255] + i8 + this.f19926b;
                iArr[i5] = i9;
                int[] iArr2 = this.f19929results;
                int i10 = iArr[(i9 >>> 10) & 255] + i6;
                this.f19926b = i10;
                iArr2[i5] = i10;
            } else {
                i = this.f19925a;
                i2 = i >>> 16;
            }
            this.f19925a = i ^ i2;
            int i82 = this.f19925a + iArr[(i5 + 128) & 255];
            this.f19925a = i82;
            int i92 = iArr[(i6 >>> 2) & 255] + i82 + this.f19926b;
            iArr[i5] = i92;
            int[] iArr22 = this.f19929results;
            int i102 = iArr[(i92 >>> 10) & 255] + i6;
            this.f19926b = i102;
            iArr22[i5] = i102;
        }
    }

    /* renamed from: mix */
    private void m15352mix(int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = i ^ (i2 << 11);
        iArr[0] = i3;
        int i4 = iArr[3] + i3;
        iArr[3] = i4;
        int i5 = iArr[2];
        int i6 = i2 + i5;
        iArr[1] = i6;
        int i7 = i6 ^ (i5 >>> 2);
        iArr[1] = i7;
        int i8 = iArr[4] + i7;
        iArr[4] = i8;
        int i9 = i5 + i4;
        iArr[2] = i9;
        int i10 = i9 ^ (i4 << 8);
        iArr[2] = i10;
        int i11 = iArr[5] + i10;
        iArr[5] = i11;
        int i12 = i4 + i8;
        iArr[3] = i12;
        int i13 = i12 ^ (i8 >>> 16);
        iArr[3] = i13;
        int i14 = iArr[6] + i13;
        iArr[6] = i14;
        int i15 = i8 + i11;
        iArr[4] = i15;
        int i16 = (i11 << 10) ^ i15;
        iArr[4] = i16;
        int i17 = iArr[7] + i16;
        iArr[7] = i17;
        int i18 = i11 + i14;
        iArr[5] = i18;
        int i19 = (i14 >>> 4) ^ i18;
        iArr[5] = i19;
        int i20 = i3 + i19;
        iArr[0] = i20;
        int i21 = i14 + i17;
        iArr[6] = i21;
        int i22 = (i17 << 8) ^ i21;
        iArr[6] = i22;
        int i23 = i7 + i22;
        iArr[1] = i23;
        int i24 = i17 + i20;
        iArr[7] = i24;
        int i25 = (i20 >>> 9) ^ i24;
        iArr[7] = i25;
        iArr[2] = i10 + i25;
        iArr[0] = i20 + i23;
    }

    /* renamed from: setKey */
    private void m15353setKey(byte[] bArr) {
        this.workingKey = bArr;
        if (this.engineState == null) {
            this.engineState = new int[256];
        }
        if (this.f19929results == null) {
            this.f19929results = new int[256];
        }
        for (int i = 0; i < 256; i++) {
            int[] iArr = this.engineState;
            this.f19929results[i] = 0;
            iArr[i] = 0;
        }
        this.f19927c = 0;
        this.f19926b = 0;
        this.f19925a = 0;
        this.f19928index = 0;
        int length = bArr.length + (bArr.length & 3);
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        for (int i2 = 0; i2 < length; i2 += 4) {
            this.f19929results[i2 >>> 2] = AbstractC6245Pack.littleEndianToInt(bArr2, i2);
        }
        int[] iArr2 = new int[8];
        for (int i3 = 0; i3 < 8; i3++) {
            iArr2[i3] = -1640531527;
        }
        for (int i4 = 0; i4 < 4; i4++) {
            m15352mix(iArr2);
        }
        int i5 = 0;
        while (i5 < 2) {
            for (int i6 = 0; i6 < 256; i6 += 8) {
                for (int i7 = 0; i7 < 8; i7++) {
                    iArr2[i7] = iArr2[i7] + (i5 < 1 ? this.f19929results[i6 + i7] : this.engineState[i6 + i7]);
                }
                m15352mix(iArr2);
                for (int i8 = 0; i8 < 8; i8++) {
                    this.engineState[i6 + i8] = iArr2[i8];
                }
            }
            i5++;
        }
        m15351isaac();
        this.initialised = true;
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    public String getAlgorithmName() {
        return "ISAAC";
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    /* renamed from: init */
    public void mo14993init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            byte[] bArrM15773getKey = ((KeyParameter) cipherParameters).m15773getKey();
            m15353setKey(bArrM15773getKey);
            CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), bArrM15773getKey.length < 32 ? bArrM15773getKey.length * 8 : 256, cipherParameters, C5342Utils.getPurpose(z)));
        } else {
            throw new IllegalArgumentException("invalid parameter passed to ISAAC init - " + cipherParameters.getClass().getName());
        }
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (!this.initialised) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        }
        if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i3 + i2 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        for (int i4 = 0; i4 < i2; i4++) {
            if (this.f19928index == 0) {
                m15351isaac();
                this.keyStream = AbstractC6245Pack.intToBigEndian(this.f19929results);
            }
            byte[] bArr3 = this.keyStream;
            int i5 = this.f19928index;
            bArr2[i4 + i3] = (byte) (bArr3[i5] ^ bArr[i4 + i]);
            this.f19928index = (i5 + 1) & 1023;
        }
        return i2;
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    /* renamed from: reset */
    public void mo14994reset() {
        m15353setKey(this.workingKey);
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    public byte returnByte(byte b) {
        if (this.f19928index == 0) {
            m15351isaac();
            this.keyStream = AbstractC6245Pack.intToBigEndian(this.f19929results);
        }
        byte[] bArr = this.keyStream;
        int i = this.f19928index;
        byte b2 = (byte) (b ^ bArr[i]);
        this.f19928index = (i + 1) & 1023;
        return b2;
    }
}
