package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.StreamCipher;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p199digests.Blake2xsDigest;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class Grainv1Engine implements StreamCipher {
    private static final int STATE_SIZE = 5;

    /* renamed from: index */
    private int f19896index = 2;
    private boolean initialised = false;

    /* renamed from: lfsr */
    private int[] f19897lfsr;

    /* renamed from: nfsr */
    private int[] f19898nfsr;

    /* renamed from: out */
    private byte[] f19899out;

    /* renamed from: output */
    private int f19900output;
    private byte[] workingIV;
    private byte[] workingKey;

    private byte getKeyStream() {
        if (this.f19896index > 1) {
            oneRound();
            this.f19896index = 0;
        }
        byte[] bArr = this.f19899out;
        int i = this.f19896index;
        this.f19896index = i + 1;
        return bArr[i];
    }

    private int getOutput() {
        int[] iArr = this.f19898nfsr;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = (i >>> 1) | (i2 << 15);
        int i4 = (i >>> 2) | (i2 << 14);
        int i5 = (i >>> 4) | (i2 << 12);
        int i6 = (i >>> 10) | (i2 << 6);
        int i7 = iArr[2];
        int i8 = (i2 >>> 15) | (i7 << 1);
        int i9 = iArr[3];
        int i10 = (i7 >>> 11) | (i9 << 5);
        int i11 = iArr[4];
        int i12 = (i9 >>> 8) | (i11 << 8);
        int i13 = (i11 << 1) | (i9 >>> 15);
        int[] iArr2 = this.f19897lfsr;
        int i14 = iArr2[0] >>> 3;
        int i15 = iArr2[1];
        int i16 = i14 | (i15 << 13);
        int i17 = iArr2[2];
        int i18 = (i15 >>> 9) | (i17 << 7);
        int i19 = (iArr2[3] << 2) | (i17 >>> 14);
        int i20 = iArr2[4];
        int i21 = i19 & i20;
        int i22 = ((((i18 ^ i13) ^ (i16 & i20)) ^ i21) ^ (i20 & i13)) ^ ((i16 & i18) & i19);
        int i23 = i16 & i19;
        return ((((((((((((i20 & i23) ^ i22) ^ (i23 & i13)) ^ ((i18 & i19) & i13)) ^ (i13 & i21)) ^ i3) ^ i4) ^ i5) ^ i6) ^ i8) ^ i10) ^ i12) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH;
    }

    private int getOutputLFSR() {
        int[] iArr = this.f19897lfsr;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = (i >>> 13) | (i2 << 3);
        int i4 = iArr[2];
        int i5 = (i2 >>> 7) | (i4 << 9);
        int i6 = iArr[3];
        int i7 = (i4 >>> 6) | (i6 << 10);
        int i8 = iArr[4];
        int i9 = (i6 >>> 3) | (i8 << 13);
        return (((i8 << 2) | (i6 >>> 14)) ^ ((((i ^ i3) ^ i5) ^ i7) ^ i9)) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH;
    }

    private int getOutputNFSR() {
        int[] iArr = this.f19898nfsr;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = (i >>> 9) | (i2 << 7);
        int i4 = (i >>> 14) | (i2 << 2);
        int i5 = (i >>> 15) | (i2 << 1);
        int i6 = iArr[2];
        int i7 = (i2 >>> 5) | (i6 << 11);
        int i8 = (i2 >>> 12) | (i6 << 4);
        int i9 = iArr[3];
        int i10 = (i6 >>> 1) | (i9 << 15);
        int i11 = (i6 >>> 5) | (i9 << 11);
        int i12 = (i6 >>> 13) | (i9 << 3);
        int i13 = iArr[4];
        int i14 = (i9 >>> 4) | (i13 << 12);
        int i15 = (i9 >>> 12) | (i13 << 4);
        int i16 = (i9 >>> 14) | (i13 << 2);
        int i17 = (i13 << 1) | (i9 >>> 15);
        int i18 = i17 & i15;
        int i19 = (((i ^ (((((((((i16 ^ i15) ^ i14) ^ i12) ^ i11) ^ i10) ^ i8) ^ i7) ^ i4) ^ i3)) ^ i18) ^ (i11 & i10)) ^ (i5 & i3);
        int i20 = i15 & i14;
        int i21 = i10 & i8 & i7;
        return (((((((((i17 & i12) & i8) & i3) ^ ((i19 ^ (i20 & i12)) ^ i21)) ^ ((i20 & i11) & i10)) ^ ((i18 & i7) & i5)) ^ (((i18 & i14) & i12) & i11)) ^ ((i21 & i5) & i3)) ^ (((((i14 & i12) & i11) & i10) & i8) & i7)) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH;
    }

    private void initGrain() {
        for (int i = 0; i < 10; i++) {
            this.f19900output = getOutput();
            this.f19898nfsr = m15328shift(this.f19898nfsr, (getOutputNFSR() ^ this.f19897lfsr[0]) ^ this.f19900output);
            this.f19897lfsr = m15328shift(this.f19897lfsr, getOutputLFSR() ^ this.f19900output);
        }
        this.initialised = true;
    }

    private void oneRound() {
        int output = getOutput();
        this.f19900output = output;
        byte[] bArr = this.f19899out;
        bArr[0] = (byte) output;
        bArr[1] = (byte) (output >> 8);
        this.f19898nfsr = m15328shift(this.f19898nfsr, getOutputNFSR() ^ this.f19897lfsr[0]);
        this.f19897lfsr = m15328shift(this.f19897lfsr, getOutputLFSR());
    }

    /* renamed from: setKey */
    private void m15327setKey(byte[] bArr, byte[] bArr2) {
        bArr2[8] = -1;
        bArr2[9] = -1;
        this.workingKey = bArr;
        this.workingIV = bArr2;
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.f19898nfsr;
            if (i >= iArr.length) {
                return;
            }
            byte[] bArr3 = this.workingKey;
            int i3 = i2 + 1;
            iArr[i] = ((bArr3[i2] & C1126UByte.MAX_VALUE) | (bArr3[i3] << 8)) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH;
            int[] iArr2 = this.f19897lfsr;
            byte[] bArr4 = this.workingIV;
            iArr2[i] = ((bArr4[i2] & C1126UByte.MAX_VALUE) | (bArr4[i3] << 8)) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH;
            i2 += 2;
            i++;
        }
    }

    /* renamed from: shift */
    private int[] m15328shift(int[] iArr, int i) {
        iArr[0] = iArr[1];
        iArr[1] = iArr[2];
        iArr[2] = iArr[3];
        iArr[3] = iArr[4];
        iArr[4] = i;
        return iArr;
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    public String getAlgorithmName() {
        return "Grain v1";
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    /* renamed from: init */
    public void mo14993init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof ParametersWithIV)) {
            throw new IllegalArgumentException("Grain v1 init parameters must include an IV");
        }
        ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
        byte[] bArrM15801getIV = parametersWithIV.m15801getIV();
        if (bArrM15801getIV == null || bArrM15801getIV.length != 8) {
            throw new IllegalArgumentException("Grain v1 requires exactly 8 bytes of IV");
        }
        if (!(parametersWithIV.getParameters() instanceof KeyParameter)) {
            throw new IllegalArgumentException("Grain v1 init parameters must include a key");
        }
        byte[] bArrM15773getKey = ((KeyParameter) parametersWithIV.getParameters()).m15773getKey();
        if (bArrM15773getKey.length != 10) {
            throw new IllegalArgumentException("Grain v1 key must be 80 bits long");
        }
        byte[] bArr = new byte[bArrM15773getKey.length];
        this.workingIV = bArr;
        this.workingKey = new byte[bArrM15773getKey.length];
        this.f19897lfsr = new int[5];
        this.f19898nfsr = new int[5];
        this.f19899out = new byte[2];
        System.arraycopy(bArrM15801getIV, 0, bArr, 0, bArrM15801getIV.length);
        System.arraycopy(bArrM15773getKey, 0, this.workingKey, 0, bArrM15773getKey.length);
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), 80, cipherParameters, C5342Utils.getPurpose(z)));
        mo14994reset();
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
            bArr2[i3 + i4] = (byte) (bArr[i + i4] ^ getKeyStream());
        }
        return i2;
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    /* renamed from: reset */
    public void mo14994reset() {
        this.f19896index = 2;
        m15327setKey(this.workingKey, this.workingIV);
        initGrain();
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    public byte returnByte(byte b) {
        if (this.initialised) {
            return (byte) (getKeyStream() ^ b);
        }
        throw new IllegalStateException(getAlgorithmName() + " not initialised");
    }
}
