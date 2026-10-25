package org.bouncycastle.p194crypto.p210modes;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.StreamBlockCipher;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class G3413CFBBlockCipher extends StreamBlockCipher {

    /* renamed from: R */
    private byte[] f20546R;

    /* renamed from: R_init */
    private byte[] f20547R_init;
    private int blockSize;
    private int byteCount;

    /* renamed from: cipher */
    private BlockCipher f20548cipher;
    private boolean forEncryption;

    /* renamed from: gamma */
    private byte[] f20549gamma;

    /* renamed from: inBuf */
    private byte[] f20550inBuf;
    private boolean initialized;

    /* renamed from: m */
    private int f20551m;

    /* renamed from: s */
    private final int f20552s;

    public G3413CFBBlockCipher(BlockCipher blockCipher) {
        this(blockCipher, blockCipher.getBlockSize() * 8);
    }

    private void initArrays() {
        int i = this.f20551m;
        this.f20546R = new byte[i];
        this.f20547R_init = new byte[i];
    }

    private void setupDefaultParams() {
        this.f20551m = this.blockSize * 2;
    }

    @Override // org.bouncycastle.p194crypto.StreamBlockCipher
    public byte calculateByte(byte b) {
        if (this.byteCount == 0) {
            this.f20549gamma = createGamma();
        }
        byte[] bArr = this.f20549gamma;
        int i = this.byteCount;
        byte b2 = (byte) (bArr[i] ^ b);
        byte[] bArr2 = this.f20550inBuf;
        int i2 = i + 1;
        this.byteCount = i2;
        if (this.forEncryption) {
            b = b2;
        }
        bArr2[i] = b;
        if (i2 == getBlockSize()) {
            this.byteCount = 0;
            generateR(this.f20550inBuf);
        }
        return b2;
    }

    public byte[] createGamma() {
        byte[] bArrM15607MSB = GOST3413CipherUtil.m15607MSB(this.f20546R, this.blockSize);
        byte[] bArr = new byte[bArrM15607MSB.length];
        this.f20548cipher.processBlock(bArrM15607MSB, 0, bArr, 0);
        return GOST3413CipherUtil.m15607MSB(bArr, this.f20552s);
    }

    public void generateR(byte[] bArr) {
        byte[] bArrM15606LSB = GOST3413CipherUtil.m15606LSB(this.f20546R, this.f20551m - this.f20552s);
        System.arraycopy(bArrM15606LSB, 0, this.f20546R, 0, bArrM15606LSB.length);
        System.arraycopy(bArr, 0, this.f20546R, bArrM15606LSB.length, this.f20551m - bArrM15606LSB.length);
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public String getAlgorithmName() {
        return this.f20548cipher.getAlgorithmName() + "/CFB" + (this.blockSize * 8);
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int getBlockSize() {
        return this.f20552s;
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
            this.f20551m = bArrM15801getIV.length;
            initArrays();
            byte[] bArrM18231clone = C6238Arrays.m18231clone(bArrM15801getIV);
            this.f20547R_init = bArrM18231clone;
            System.arraycopy(bArrM18231clone, 0, this.f20546R, 0, bArrM18231clone.length);
            if (parametersWithIV.getParameters() != null) {
                blockCipher = this.f20548cipher;
                cipherParameters = parametersWithIV.getParameters();
                blockCipher.mo14946init(true, cipherParameters);
            }
        } else {
            setupDefaultParams();
            initArrays();
            byte[] bArr = this.f20547R_init;
            System.arraycopy(bArr, 0, this.f20546R, 0, bArr.length);
            if (cipherParameters != null) {
                blockCipher = this.f20548cipher;
                blockCipher.mo14946init(true, cipherParameters);
            }
        }
        this.initialized = true;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        processBytes(bArr, i, getBlockSize(), bArr2, i2);
        return getBlockSize();
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: reset */
    public void mo14947reset() {
        this.byteCount = 0;
        C6238Arrays.m18227clear(this.f20550inBuf);
        C6238Arrays.m18227clear(this.f20549gamma);
        if (this.initialized) {
            byte[] bArr = this.f20547R_init;
            System.arraycopy(bArr, 0, this.f20546R, 0, bArr.length);
            this.f20548cipher.mo14947reset();
        }
    }

    public G3413CFBBlockCipher(BlockCipher blockCipher, int i) {
        super(blockCipher);
        this.initialized = false;
        if (i < 0 || i > blockCipher.getBlockSize() * 8) {
            throw new IllegalArgumentException("Parameter bitBlockSize must be in range 0 < bitBlockSize <= " + (blockCipher.getBlockSize() * 8));
        }
        this.blockSize = blockCipher.getBlockSize();
        this.f20548cipher = blockCipher;
        this.f20552s = i / 8;
        this.f20550inBuf = new byte[getBlockSize()];
    }
}
