package org.bouncycastle.p194crypto.p209macs;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;

/* loaded from: classes2.dex */
class MacCFBBlockCipher {

    /* renamed from: IV */
    private byte[] f20464IV;
    private int blockSize;

    /* renamed from: cfbOutV */
    private byte[] f20465cfbOutV;

    /* renamed from: cfbV */
    private byte[] f20466cfbV;

    /* renamed from: cipher */
    private BlockCipher f20467cipher;

    public MacCFBBlockCipher(BlockCipher blockCipher, int i) {
        this.f20467cipher = blockCipher;
        this.blockSize = i / 8;
        this.f20464IV = new byte[blockCipher.getBlockSize()];
        this.f20466cfbV = new byte[blockCipher.getBlockSize()];
        this.f20465cfbOutV = new byte[blockCipher.getBlockSize()];
    }

    public String getAlgorithmName() {
        return this.f20467cipher.getAlgorithmName() + "/CFB" + (this.blockSize * 8);
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public void getMacBlock(byte[] bArr) {
        this.f20467cipher.processBlock(this.f20466cfbV, 0, bArr, 0);
    }

    /* renamed from: init */
    public void m15589init(CipherParameters cipherParameters) {
        BlockCipher blockCipher;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] bArrM15801getIV = parametersWithIV.m15801getIV();
            int length = bArrM15801getIV.length;
            byte[] bArr = this.f20464IV;
            if (length < bArr.length) {
                System.arraycopy(bArrM15801getIV, 0, bArr, bArr.length - bArrM15801getIV.length, bArrM15801getIV.length);
            } else {
                System.arraycopy(bArrM15801getIV, 0, bArr, 0, bArr.length);
            }
            m15590reset();
            blockCipher = this.f20467cipher;
            cipherParameters = parametersWithIV.getParameters();
        } else {
            m15590reset();
            blockCipher = this.f20467cipher;
        }
        blockCipher.mo14946init(true, cipherParameters);
    }

    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = this.blockSize;
        if (i + i3 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i3 + i2 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        this.f20467cipher.processBlock(this.f20466cfbV, 0, this.f20465cfbOutV, 0);
        int i4 = 0;
        while (true) {
            int i5 = this.blockSize;
            if (i4 >= i5) {
                byte[] bArr3 = this.f20466cfbV;
                System.arraycopy(bArr3, i5, bArr3, 0, bArr3.length - i5);
                byte[] bArr4 = this.f20466cfbV;
                int length = bArr4.length;
                int i6 = this.blockSize;
                System.arraycopy(bArr2, i2, bArr4, length - i6, i6);
                return this.blockSize;
            }
            bArr2[i2 + i4] = (byte) (this.f20465cfbOutV[i4] ^ bArr[i + i4]);
            i4++;
        }
    }

    /* renamed from: reset */
    public void m15590reset() {
        byte[] bArr = this.f20464IV;
        System.arraycopy(bArr, 0, this.f20466cfbV, 0, bArr.length);
        this.f20467cipher.mo14947reset();
    }
}
