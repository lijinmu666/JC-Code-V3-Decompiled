package org.bouncycastle.p194crypto.p210modes;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.StreamBlockCipher;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class G3413CTRBlockCipher extends StreamBlockCipher {

    /* renamed from: CTR */
    private byte[] f20553CTR;

    /* renamed from: IV */
    private byte[] f20554IV;
    private final int blockSize;

    /* renamed from: buf */
    private byte[] f20555buf;
    private int byteCount;

    /* renamed from: cipher */
    private final BlockCipher f20556cipher;
    private boolean initialized;

    /* renamed from: s */
    private final int f20557s;

    public G3413CTRBlockCipher(BlockCipher blockCipher) {
        this(blockCipher, blockCipher.getBlockSize() * 8);
    }

    private byte[] generateBuf() {
        byte[] bArr = this.f20553CTR;
        byte[] bArr2 = new byte[bArr.length];
        this.f20556cipher.processBlock(bArr, 0, bArr2, 0);
        return GOST3413CipherUtil.m15607MSB(bArr2, this.f20557s);
    }

    private void generateCTR() {
        int length = this.f20553CTR.length - 1;
        do {
            byte[] bArr = this.f20553CTR;
            byte b = (byte) (bArr[length] + 1);
            bArr[length] = b;
            if (b != 0) {
                return;
            } else {
                length--;
            }
        } while (length != this.f20554IV.length - 1);
        throw new IllegalStateException("attempt to process too many blocks");
    }

    private void initArrays() {
        int i = this.blockSize;
        this.f20554IV = new byte[i / 2];
        this.f20553CTR = new byte[i];
        this.f20555buf = new byte[this.f20557s];
    }

    @Override // org.bouncycastle.p194crypto.StreamBlockCipher
    public byte calculateByte(byte b) {
        if (this.byteCount == 0) {
            this.f20555buf = generateBuf();
        }
        byte[] bArr = this.f20555buf;
        int i = this.byteCount;
        byte b2 = (byte) (b ^ bArr[i]);
        int i2 = i + 1;
        this.byteCount = i2;
        if (i2 == this.f20557s) {
            this.byteCount = 0;
            generateCTR();
        }
        return b2;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public String getAlgorithmName() {
        return this.f20556cipher.getAlgorithmName() + "/GCTR";
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int getBlockSize() {
        return this.f20557s;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: init */
    public void mo14946init(boolean z, CipherParameters cipherParameters) {
        BlockCipher blockCipher;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            initArrays();
            byte[] bArrM18231clone = C6238Arrays.m18231clone(parametersWithIV.m15801getIV());
            this.f20554IV = bArrM18231clone;
            if (bArrM18231clone.length != this.blockSize / 2) {
                throw new IllegalArgumentException("Parameter IV length must be == blockSize/2");
            }
            System.arraycopy(bArrM18231clone, 0, this.f20553CTR, 0, bArrM18231clone.length);
            for (int length = this.f20554IV.length; length < this.blockSize; length++) {
                this.f20553CTR[length] = 0;
            }
            if (parametersWithIV.getParameters() != null) {
                blockCipher = this.f20556cipher;
                cipherParameters = parametersWithIV.getParameters();
                blockCipher.mo14946init(true, cipherParameters);
            }
        } else {
            initArrays();
            if (cipherParameters != null) {
                blockCipher = this.f20556cipher;
                blockCipher.mo14946init(true, cipherParameters);
            }
        }
        this.initialized = true;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        processBytes(bArr, i, this.f20557s, bArr2, i2);
        return this.f20557s;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: reset */
    public void mo14947reset() {
        if (this.initialized) {
            byte[] bArr = this.f20554IV;
            System.arraycopy(bArr, 0, this.f20553CTR, 0, bArr.length);
            for (int length = this.f20554IV.length; length < this.blockSize; length++) {
                this.f20553CTR[length] = 0;
            }
            this.byteCount = 0;
            this.f20556cipher.mo14947reset();
        }
    }

    public G3413CTRBlockCipher(BlockCipher blockCipher, int i) {
        super(blockCipher);
        this.byteCount = 0;
        if (i < 0 || i > blockCipher.getBlockSize() * 8) {
            throw new IllegalArgumentException("Parameter bitBlockSize must be in range 0 < bitBlockSize <= " + (blockCipher.getBlockSize() * 8));
        }
        this.f20556cipher = blockCipher;
        int blockSize = blockCipher.getBlockSize();
        this.blockSize = blockSize;
        this.f20557s = i / 8;
        this.f20553CTR = new byte[blockSize];
    }
}
