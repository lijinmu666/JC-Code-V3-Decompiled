package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.StreamCipher;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class Grain128Engine implements StreamCipher {
    private static final int STATE_SIZE = 4;

    /* renamed from: index */
    private int f19891index = 4;
    private boolean initialised = false;

    /* renamed from: lfsr */
    private int[] f19892lfsr;

    /* renamed from: nfsr */
    private int[] f19893nfsr;

    /* renamed from: out */
    private byte[] f19894out;

    /* renamed from: output */
    private int f19895output;
    private byte[] workingIV;
    private byte[] workingKey;

    private byte getKeyStream() {
        if (this.f19891index > 3) {
            oneRound();
            this.f19891index = 0;
        }
        byte[] bArr = this.f19894out;
        int i = this.f19891index;
        this.f19891index = i + 1;
        return bArr[i];
    }

    private int getOutput() {
        int[] iArr = this.f19893nfsr;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = (i >>> 2) | (i2 << 30);
        int i4 = (i >>> 12) | (i2 << 20);
        int i5 = (i >>> 15) | (i2 << 17);
        int i6 = iArr[2];
        int i7 = (i2 >>> 4) | (i6 << 28);
        int i8 = (i2 >>> 13) | (i6 << 19);
        int i9 = iArr[3];
        int i10 = (i6 >>> 9) | (i9 << 23);
        int i11 = (i6 >>> 25) | (i9 << 7);
        int i12 = (i9 << 1) | (i6 >>> 31);
        int[] iArr2 = this.f19892lfsr;
        int i13 = iArr2[0];
        int i14 = iArr2[1];
        int i15 = (i13 >>> 8) | (i14 << 24);
        int i16 = (i13 >>> 13) | (i14 << 19);
        int i17 = (i13 >>> 20) | (i14 << 12);
        int i18 = iArr2[2];
        int i19 = iArr2[3];
        int i20 = i17 & i16;
        return (((((((((((i18 >>> 30) | (i19 << 2)) & (i12 & i4)) ^ (((i20 ^ (i4 & i15)) ^ (i12 & ((i14 >>> 10) | (i18 << 22)))) ^ (((i14 >>> 28) | (i18 << 4)) & ((i18 >>> 15) | (i19 << 17))))) ^ ((i18 >>> 29) | (i19 << 3))) ^ i3) ^ i5) ^ i7) ^ i8) ^ i6) ^ i10) ^ i11;
    }

    private int getOutputLFSR() {
        int[] iArr = this.f19892lfsr;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = (i >>> 7) | (i2 << 25);
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = (i4 >>> 6) | (i5 << 26);
        return i5 ^ ((((i ^ i3) ^ ((i2 >>> 6) | (i4 << 26))) ^ i6) ^ ((i4 >>> 17) | (i5 << 15)));
    }

    private int getOutputNFSR() {
        int[] iArr = this.f19893nfsr;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = (i >>> 3) | (i2 << 29);
        int i4 = (i >>> 11) | (i2 << 21);
        int i5 = (i >>> 13) | (i2 << 19);
        int i6 = (i >>> 17) | (i2 << 15);
        int i7 = (i >>> 18) | (i2 << 14);
        int i8 = (i >>> 26) | (i2 << 6);
        int i9 = (i >>> 27) | (i2 << 5);
        int i10 = iArr[2];
        int i11 = (i2 >>> 8) | (i10 << 24);
        int i12 = (i2 >>> 16) | (i10 << 16);
        int i13 = (i2 >>> 24) | (i10 << 8);
        int i14 = (i2 >>> 27) | (i10 << 5);
        int i15 = (i2 >>> 29) | (i10 << 3);
        int i16 = iArr[3];
        return (((((((i16 ^ (((i ^ i8) ^ i13) ^ ((i10 >>> 27) | (i16 << 5)))) ^ (i3 & ((i10 >>> 3) | (i16 << 29)))) ^ (i4 & i5)) ^ (i6 & i7)) ^ (i9 & i14)) ^ (i11 & i12)) ^ (i15 & ((i10 >>> 1) | (i16 << 31)))) ^ (((i10 >>> 4) | (i16 << 28)) & ((i10 >>> 20) | (i16 << 12)));
    }

    private void initGrain() {
        for (int i = 0; i < 8; i++) {
            this.f19895output = getOutput();
            this.f19893nfsr = m15326shift(this.f19893nfsr, (getOutputNFSR() ^ this.f19892lfsr[0]) ^ this.f19895output);
            this.f19892lfsr = m15326shift(this.f19892lfsr, getOutputLFSR() ^ this.f19895output);
        }
        this.initialised = true;
    }

    private void oneRound() {
        int output = getOutput();
        this.f19895output = output;
        byte[] bArr = this.f19894out;
        bArr[0] = (byte) output;
        bArr[1] = (byte) (output >> 8);
        bArr[2] = (byte) (output >> 16);
        bArr[3] = (byte) (output >> 24);
        this.f19893nfsr = m15326shift(this.f19893nfsr, getOutputNFSR() ^ this.f19892lfsr[0]);
        this.f19892lfsr = m15326shift(this.f19892lfsr, getOutputLFSR());
    }

    /* renamed from: setKey */
    private void m15325setKey(byte[] bArr, byte[] bArr2) {
        bArr2[12] = -1;
        bArr2[13] = -1;
        bArr2[14] = -1;
        bArr2[15] = -1;
        this.workingKey = bArr;
        this.workingIV = bArr2;
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = this.f19893nfsr;
            if (i >= iArr.length) {
                return;
            }
            byte[] bArr3 = this.workingKey;
            int i3 = i2 + 3;
            int i4 = i2 + 2;
            int i5 = i2 + 1;
            iArr[i] = (bArr3[i2] & C1126UByte.MAX_VALUE) | (bArr3[i3] << 24) | ((bArr3[i4] << 16) & 16711680) | ((bArr3[i5] << 8) & 65280);
            int[] iArr2 = this.f19892lfsr;
            byte[] bArr4 = this.workingIV;
            iArr2[i] = (bArr4[i2] & C1126UByte.MAX_VALUE) | (bArr4[i3] << 24) | ((bArr4[i4] << 16) & 16711680) | ((bArr4[i5] << 8) & 65280);
            i2 += 4;
            i++;
        }
    }

    /* renamed from: shift */
    private int[] m15326shift(int[] iArr, int i) {
        iArr[0] = iArr[1];
        iArr[1] = iArr[2];
        iArr[2] = iArr[3];
        iArr[3] = i;
        return iArr;
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    public String getAlgorithmName() {
        return "Grain-128";
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    /* renamed from: init */
    public void mo14993init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof ParametersWithIV)) {
            throw new IllegalArgumentException("Grain-128 Init parameters must include an IV");
        }
        ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
        byte[] bArrM15801getIV = parametersWithIV.m15801getIV();
        if (bArrM15801getIV == null || bArrM15801getIV.length != 12) {
            throw new IllegalArgumentException("Grain-128 requires exactly 12 bytes of IV");
        }
        if (!(parametersWithIV.getParameters() instanceof KeyParameter)) {
            throw new IllegalArgumentException("Grain-128 init parameters must include a key");
        }
        byte[] bArrM15773getKey = ((KeyParameter) parametersWithIV.getParameters()).m15773getKey();
        if (bArrM15773getKey.length != 16) {
            throw new IllegalArgumentException("Grain-128 key must be 128 bits long");
        }
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), 128, cipherParameters, C5342Utils.getPurpose(z)));
        byte[] bArr = new byte[bArrM15773getKey.length];
        this.workingIV = bArr;
        this.workingKey = new byte[bArrM15773getKey.length];
        this.f19892lfsr = new int[4];
        this.f19893nfsr = new int[4];
        this.f19894out = new byte[4];
        System.arraycopy(bArrM15801getIV, 0, bArr, 0, bArrM15801getIV.length);
        System.arraycopy(bArrM15773getKey, 0, this.workingKey, 0, bArrM15773getKey.length);
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
        this.f19891index = 4;
        m15325setKey(this.workingKey, this.workingIV);
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
