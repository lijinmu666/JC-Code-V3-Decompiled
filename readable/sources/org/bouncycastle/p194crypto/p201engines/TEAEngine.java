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
public class TEAEngine implements BlockCipher {
    private static final int block_size = 8;

    /* renamed from: d_sum */
    private static final int f20105d_sum = -957401312;

    /* renamed from: delta */
    private static final int f20106delta = -1640531527;

    /* renamed from: rounds */
    private static final int f20107rounds = 32;

    /* renamed from: _a */
    private int f20108_a;

    /* renamed from: _b */
    private int f20109_b;

    /* renamed from: _c */
    private int f20110_c;

    /* renamed from: _d */
    private int f20111_d;
    private boolean _forEncryption;
    private boolean _initialised = false;

    private int bytesToInt(byte[] bArr, int i) {
        int i2 = i + 2;
        return ((bArr[i + 1] & C1126UByte.MAX_VALUE) << 16) | (bArr[i] << 24) | ((bArr[i2] & C1126UByte.MAX_VALUE) << 8) | (bArr[i + 3] & C1126UByte.MAX_VALUE);
    }

    private int decryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int iBytesToInt = bytesToInt(bArr, i);
        int iBytesToInt2 = bytesToInt(bArr, i + 4);
        int i3 = f20105d_sum;
        for (int i4 = 0; i4 != 32; i4++) {
            iBytesToInt2 -= (((iBytesToInt << 4) + this.f20110_c) ^ (iBytesToInt + i3)) ^ ((iBytesToInt >>> 5) + this.f20111_d);
            iBytesToInt -= (((iBytesToInt2 << 4) + this.f20108_a) ^ (iBytesToInt2 + i3)) ^ ((iBytesToInt2 >>> 5) + this.f20109_b);
            i3 += 1640531527;
        }
        unpackInt(iBytesToInt, bArr2, i2);
        unpackInt(iBytesToInt2, bArr2, i2 + 4);
        return 8;
    }

    private int encryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int iBytesToInt = bytesToInt(bArr, i);
        int iBytesToInt2 = bytesToInt(bArr, i + 4);
        int i3 = iBytesToInt;
        int i4 = 0;
        for (int i5 = 0; i5 != 32; i5++) {
            i4 -= 1640531527;
            i3 += (((iBytesToInt2 << 4) + this.f20108_a) ^ (iBytesToInt2 + i4)) ^ ((iBytesToInt2 >>> 5) + this.f20109_b);
            iBytesToInt2 += (((i3 << 4) + this.f20110_c) ^ (i3 + i4)) ^ ((i3 >>> 5) + this.f20111_d);
        }
        unpackInt(i3, bArr2, i2);
        unpackInt(iBytesToInt2, bArr2, i2 + 4);
        return 8;
    }

    /* renamed from: setKey */
    private void m15432setKey(byte[] bArr) {
        if (bArr.length != 16) {
            throw new IllegalArgumentException("Key size must be 128 bits.");
        }
        this.f20108_a = bytesToInt(bArr, 0);
        this.f20109_b = bytesToInt(bArr, 4);
        this.f20110_c = bytesToInt(bArr, 8);
        this.f20111_d = bytesToInt(bArr, 12);
    }

    private void unpackInt(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 24);
        bArr[i2 + 1] = (byte) (i >>> 16);
        bArr[i2 + 2] = (byte) (i >>> 8);
        bArr[i2 + 3] = (byte) i;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public String getAlgorithmName() {
        return "TEA";
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int getBlockSize() {
        return 8;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: init */
    public void mo14946init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("invalid parameter passed to TEA init - " + cipherParameters.getClass().getName());
        }
        this._forEncryption = z;
        this._initialised = true;
        m15432setKey(((KeyParameter) cipherParameters).m15773getKey());
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), 128, cipherParameters, C5342Utils.getPurpose(z)));
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (!this._initialised) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        }
        if (i + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i2 + 8 <= bArr2.length) {
            return this._forEncryption ? encryptBlock(bArr, i, bArr2, i2) : decryptBlock(bArr, i, bArr2, i2);
        }
        throw new OutputLengthException("output buffer too short");
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: reset */
    public void mo14947reset() {
    }
}
