package org.bouncycastle.p194crypto.p210modes;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class G3413CBCBlockCipher implements BlockCipher {

    /* renamed from: R */
    private byte[] f20542R;

    /* renamed from: R_init */
    private byte[] f20543R_init;
    private int blockSize;

    /* renamed from: cipher */
    private BlockCipher f20544cipher;
    private boolean forEncryption;
    private boolean initialized = false;

    /* renamed from: m */
    private int f20545m;

    public G3413CBCBlockCipher(BlockCipher blockCipher) {
        this.blockSize = blockCipher.getBlockSize();
        this.f20544cipher = blockCipher;
    }

    /* renamed from: decrypt */
    private int m15599decrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte[] bArrM15607MSB = GOST3413CipherUtil.m15607MSB(this.f20542R, this.blockSize);
        byte[] bArrCopyFromInput = GOST3413CipherUtil.copyFromInput(bArr, this.blockSize, i);
        byte[] bArr3 = new byte[bArrCopyFromInput.length];
        this.f20544cipher.processBlock(bArrCopyFromInput, 0, bArr3, 0);
        byte[] bArrM15608sum = GOST3413CipherUtil.m15608sum(bArr3, bArrM15607MSB);
        System.arraycopy(bArrM15608sum, 0, bArr2, i2, bArrM15608sum.length);
        if (bArr2.length > i2 + bArrM15608sum.length) {
            generateR(bArrCopyFromInput);
        }
        return bArrM15608sum.length;
    }

    /* renamed from: encrypt */
    private int m15600encrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte[] bArrM15608sum = GOST3413CipherUtil.m15608sum(GOST3413CipherUtil.copyFromInput(bArr, this.blockSize, i), GOST3413CipherUtil.m15607MSB(this.f20542R, this.blockSize));
        int length = bArrM15608sum.length;
        byte[] bArr3 = new byte[length];
        this.f20544cipher.processBlock(bArrM15608sum, 0, bArr3, 0);
        System.arraycopy(bArr3, 0, bArr2, i2, length);
        if (bArr2.length > i2 + bArrM15608sum.length) {
            generateR(bArr3);
        }
        return length;
    }

    private void generateR(byte[] bArr) {
        byte[] bArrM15606LSB = GOST3413CipherUtil.m15606LSB(this.f20542R, this.f20545m - this.blockSize);
        System.arraycopy(bArrM15606LSB, 0, this.f20542R, 0, bArrM15606LSB.length);
        System.arraycopy(bArr, 0, this.f20542R, bArrM15606LSB.length, this.f20545m - bArrM15606LSB.length);
    }

    private void initArrays() {
        int i = this.f20545m;
        this.f20542R = new byte[i];
        this.f20543R_init = new byte[i];
    }

    private void setupDefaultParams() {
        this.f20545m = this.blockSize;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public String getAlgorithmName() {
        return this.f20544cipher.getAlgorithmName() + "/CBC";
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int getBlockSize() {
        return this.blockSize;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: init */
    public void mo14946init(boolean z, CipherParameters cipherParameters) {
        BlockCipher blockCipher;
        this.forEncryption = z;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] bArrM15801getIV = parametersWithIV.m15801getIV();
            if (bArrM15801getIV.length < this.blockSize) {
                throw new IllegalArgumentException("Parameter m must blockSize <= m");
            }
            this.f20545m = bArrM15801getIV.length;
            initArrays();
            byte[] bArrM18231clone = C6238Arrays.m18231clone(bArrM15801getIV);
            this.f20543R_init = bArrM18231clone;
            System.arraycopy(bArrM18231clone, 0, this.f20542R, 0, bArrM18231clone.length);
            if (parametersWithIV.getParameters() != null) {
                blockCipher = this.f20544cipher;
                cipherParameters = parametersWithIV.getParameters();
                blockCipher.mo14946init(z, cipherParameters);
            }
        } else {
            setupDefaultParams();
            initArrays();
            byte[] bArr = this.f20543R_init;
            System.arraycopy(bArr, 0, this.f20542R, 0, bArr.length);
            if (cipherParameters != null) {
                blockCipher = this.f20544cipher;
                blockCipher.mo14946init(z, cipherParameters);
            }
        }
        this.initialized = true;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        return this.forEncryption ? m15600encrypt(bArr, i, bArr2, i2) : m15599decrypt(bArr, i, bArr2, i2);
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: reset */
    public void mo14947reset() {
        if (this.initialized) {
            byte[] bArr = this.f20543R_init;
            System.arraycopy(bArr, 0, this.f20542R, 0, bArr.length);
            this.f20544cipher.mo14947reset();
        }
    }
}
