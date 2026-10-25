package org.bouncycastle.p194crypto.p210modes;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.StreamBlockCipher;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class G3413OFBBlockCipher extends StreamBlockCipher {

    /* renamed from: R */
    private byte[] f20558R;

    /* renamed from: R_init */
    private byte[] f20559R_init;

    /* renamed from: Y */
    private byte[] f20560Y;
    private int blockSize;
    private int byteCount;

    /* renamed from: cipher */
    private BlockCipher f20561cipher;
    private boolean initialized;

    /* renamed from: m */
    private int f20562m;

    public G3413OFBBlockCipher(BlockCipher blockCipher) {
        super(blockCipher);
        this.initialized = false;
        int blockSize = blockCipher.getBlockSize();
        this.blockSize = blockSize;
        this.f20561cipher = blockCipher;
        this.f20560Y = new byte[blockSize];
    }

    private void generateR() {
        byte[] bArrM15606LSB = GOST3413CipherUtil.m15606LSB(this.f20558R, this.f20562m - this.blockSize);
        System.arraycopy(bArrM15606LSB, 0, this.f20558R, 0, bArrM15606LSB.length);
        System.arraycopy(this.f20560Y, 0, this.f20558R, bArrM15606LSB.length, this.f20562m - bArrM15606LSB.length);
    }

    private void generateY() {
        this.f20561cipher.processBlock(GOST3413CipherUtil.m15607MSB(this.f20558R, this.blockSize), 0, this.f20560Y, 0);
    }

    private void initArrays() {
        int i = this.f20562m;
        this.f20558R = new byte[i];
        this.f20559R_init = new byte[i];
    }

    private void setupDefaultParams() {
        this.f20562m = this.blockSize * 2;
    }

    @Override // org.bouncycastle.p194crypto.StreamBlockCipher
    public byte calculateByte(byte b) {
        if (this.byteCount == 0) {
            generateY();
        }
        byte[] bArr = this.f20560Y;
        int i = this.byteCount;
        byte b2 = (byte) (b ^ bArr[i]);
        int i2 = i + 1;
        this.byteCount = i2;
        if (i2 == getBlockSize()) {
            this.byteCount = 0;
            generateR();
        }
        return b2;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public String getAlgorithmName() {
        return this.f20561cipher.getAlgorithmName() + "/OFB";
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int getBlockSize() {
        return this.blockSize;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: init */
    public void mo14946init(boolean z, CipherParameters cipherParameters) {
        BlockCipher blockCipher;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] bArrM15801getIV = parametersWithIV.m15801getIV();
            if (bArrM15801getIV.length < this.blockSize) {
                throw new IllegalArgumentException("Parameter m must blockSize <= m");
            }
            this.f20562m = bArrM15801getIV.length;
            initArrays();
            byte[] bArrM18231clone = C6238Arrays.m18231clone(bArrM15801getIV);
            this.f20559R_init = bArrM18231clone;
            System.arraycopy(bArrM18231clone, 0, this.f20558R, 0, bArrM18231clone.length);
            if (parametersWithIV.getParameters() != null) {
                blockCipher = this.f20561cipher;
                cipherParameters = parametersWithIV.getParameters();
                blockCipher.mo14946init(true, cipherParameters);
            }
        } else {
            setupDefaultParams();
            initArrays();
            byte[] bArr = this.f20559R_init;
            System.arraycopy(bArr, 0, this.f20558R, 0, bArr.length);
            if (cipherParameters != null) {
                blockCipher = this.f20561cipher;
                blockCipher.mo14946init(true, cipherParameters);
            }
        }
        this.initialized = true;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        processBytes(bArr, i, this.blockSize, bArr2, i2);
        return this.blockSize;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: reset */
    public void mo14947reset() {
        if (this.initialized) {
            byte[] bArr = this.f20559R_init;
            System.arraycopy(bArr, 0, this.f20558R, 0, bArr.length);
            C6238Arrays.m18227clear(this.f20560Y);
            this.byteCount = 0;
            this.f20561cipher.mo14947reset();
        }
    }
}
