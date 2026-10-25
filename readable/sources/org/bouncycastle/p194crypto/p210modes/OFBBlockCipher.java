package org.bouncycastle.p194crypto.p210modes;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.StreamBlockCipher;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;

/* loaded from: classes2.dex */
public class OFBBlockCipher extends StreamBlockCipher {

    /* renamed from: IV */
    private byte[] f20622IV;
    private final int blockSize;
    private int byteCount;

    /* renamed from: cipher */
    private final BlockCipher f20623cipher;

    /* renamed from: ofbOutV */
    private byte[] f20624ofbOutV;

    /* renamed from: ofbV */
    private byte[] f20625ofbV;

    public OFBBlockCipher(BlockCipher blockCipher, int i) {
        super(blockCipher);
        if (i > blockCipher.getBlockSize() * 8 || i < 8 || i % 8 != 0) {
            throw new IllegalArgumentException("0FB" + i + " not supported");
        }
        this.f20623cipher = blockCipher;
        this.blockSize = i / 8;
        this.f20622IV = new byte[blockCipher.getBlockSize()];
        this.f20625ofbV = new byte[blockCipher.getBlockSize()];
        this.f20624ofbOutV = new byte[blockCipher.getBlockSize()];
    }

    @Override // org.bouncycastle.p194crypto.StreamBlockCipher
    public byte calculateByte(byte b) {
        if (this.byteCount == 0) {
            this.f20623cipher.processBlock(this.f20625ofbV, 0, this.f20624ofbOutV, 0);
        }
        byte[] bArr = this.f20624ofbOutV;
        int i = this.byteCount;
        int i2 = i + 1;
        this.byteCount = i2;
        byte b2 = (byte) (b ^ bArr[i]);
        int i3 = this.blockSize;
        if (i2 == i3) {
            this.byteCount = 0;
            byte[] bArr2 = this.f20625ofbV;
            System.arraycopy(bArr2, i3, bArr2, 0, bArr2.length - i3);
            byte[] bArr3 = this.f20624ofbOutV;
            byte[] bArr4 = this.f20625ofbV;
            int length = bArr4.length;
            int i4 = this.blockSize;
            System.arraycopy(bArr3, 0, bArr4, length - i4, i4);
        }
        return b2;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public String getAlgorithmName() {
        return this.f20623cipher.getAlgorithmName() + "/OFB" + (this.blockSize * 8);
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int getBlockSize() {
        return this.blockSize;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: init */
    public void mo14946init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof ParametersWithIV)) {
            mo14947reset();
            if (cipherParameters != null) {
                this.f20623cipher.mo14946init(true, cipherParameters);
                return;
            }
            return;
        }
        ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
        byte[] bArrM15801getIV = parametersWithIV.m15801getIV();
        int length = bArrM15801getIV.length;
        byte[] bArr = this.f20622IV;
        if (length < bArr.length) {
            System.arraycopy(bArrM15801getIV, 0, bArr, bArr.length - bArrM15801getIV.length, bArrM15801getIV.length);
            int i = 0;
            while (true) {
                byte[] bArr2 = this.f20622IV;
                if (i >= bArr2.length - bArrM15801getIV.length) {
                    break;
                }
                bArr2[i] = 0;
                i++;
            }
        } else {
            System.arraycopy(bArrM15801getIV, 0, bArr, 0, bArr.length);
        }
        mo14947reset();
        if (parametersWithIV.getParameters() != null) {
            this.f20623cipher.mo14946init(true, parametersWithIV.getParameters());
        }
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        processBytes(bArr, i, this.blockSize, bArr2, i2);
        return this.blockSize;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: reset */
    public void mo14947reset() {
        byte[] bArr = this.f20622IV;
        System.arraycopy(bArr, 0, this.f20625ofbV, 0, bArr.length);
        this.byteCount = 0;
        this.f20623cipher.mo14947reset();
    }
}
