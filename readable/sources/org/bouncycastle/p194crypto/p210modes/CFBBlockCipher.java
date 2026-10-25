package org.bouncycastle.p194crypto.p210modes;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.StreamBlockCipher;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class CFBBlockCipher extends StreamBlockCipher implements CFBModeCipher {

    /* renamed from: IV */
    private byte[] f20521IV;
    private int blockSize;
    private int byteCount;

    /* renamed from: cfbOutV */
    private byte[] f20522cfbOutV;

    /* renamed from: cfbV */
    private byte[] f20523cfbV;

    /* renamed from: cipher */
    private BlockCipher f20524cipher;
    private boolean encrypting;

    /* renamed from: inBuf */
    private byte[] f20525inBuf;

    public CFBBlockCipher(BlockCipher blockCipher, int i) {
        super(blockCipher);
        this.f20524cipher = null;
        if (i > blockCipher.getBlockSize() * 8 || i < 8 || i % 8 != 0) {
            throw new IllegalArgumentException("CFB" + i + " not supported");
        }
        this.f20524cipher = blockCipher;
        this.blockSize = i / 8;
        this.f20521IV = new byte[blockCipher.getBlockSize()];
        this.f20523cfbV = new byte[blockCipher.getBlockSize()];
        this.f20522cfbOutV = new byte[blockCipher.getBlockSize()];
        this.f20525inBuf = new byte[this.blockSize];
    }

    private byte decryptByte(byte b) {
        if (this.byteCount == 0) {
            this.f20524cipher.processBlock(this.f20523cfbV, 0, this.f20522cfbOutV, 0);
        }
        byte[] bArr = this.f20525inBuf;
        int i = this.byteCount;
        bArr[i] = b;
        byte[] bArr2 = this.f20522cfbOutV;
        int i2 = i + 1;
        this.byteCount = i2;
        byte b2 = (byte) (b ^ bArr2[i]);
        int i3 = this.blockSize;
        if (i2 == i3) {
            this.byteCount = 0;
            byte[] bArr3 = this.f20523cfbV;
            System.arraycopy(bArr3, i3, bArr3, 0, bArr3.length - i3);
            byte[] bArr4 = this.f20525inBuf;
            byte[] bArr5 = this.f20523cfbV;
            int length = bArr5.length;
            int i4 = this.blockSize;
            System.arraycopy(bArr4, 0, bArr5, length - i4, i4);
        }
        return b2;
    }

    private byte encryptByte(byte b) {
        if (this.byteCount == 0) {
            this.f20524cipher.processBlock(this.f20523cfbV, 0, this.f20522cfbOutV, 0);
        }
        byte[] bArr = this.f20522cfbOutV;
        int i = this.byteCount;
        byte b2 = (byte) (b ^ bArr[i]);
        byte[] bArr2 = this.f20525inBuf;
        int i2 = i + 1;
        this.byteCount = i2;
        bArr2[i] = b2;
        int i3 = this.blockSize;
        if (i2 == i3) {
            this.byteCount = 0;
            byte[] bArr3 = this.f20523cfbV;
            System.arraycopy(bArr3, i3, bArr3, 0, bArr3.length - i3);
            byte[] bArr4 = this.f20525inBuf;
            byte[] bArr5 = this.f20523cfbV;
            int length = bArr5.length;
            int i4 = this.blockSize;
            System.arraycopy(bArr4, 0, bArr5, length - i4, i4);
        }
        return b2;
    }

    public static CFBModeCipher newInstance(BlockCipher blockCipher, int i) {
        return new CFBBlockCipher(blockCipher, i);
    }

    @Override // org.bouncycastle.p194crypto.StreamBlockCipher
    public byte calculateByte(byte b) {
        return this.encrypting ? encryptByte(b) : decryptByte(b);
    }

    public int decryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        processBytes(bArr, i, this.blockSize, bArr2, i2);
        return this.blockSize;
    }

    public int encryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        processBytes(bArr, i, this.blockSize, bArr2, i2);
        return this.blockSize;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public String getAlgorithmName() {
        return this.f20524cipher.getAlgorithmName() + "/CFB" + (this.blockSize * 8);
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int getBlockSize() {
        return this.blockSize;
    }

    public byte[] getCurrentIV() {
        return C6238Arrays.m18231clone(this.f20523cfbV);
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: init */
    public void mo14946init(boolean z, CipherParameters cipherParameters) {
        this.encrypting = z;
        if (!(cipherParameters instanceof ParametersWithIV)) {
            mo14947reset();
            if (cipherParameters != null) {
                this.f20524cipher.mo14946init(true, cipherParameters);
                return;
            }
            return;
        }
        ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
        byte[] bArrM15801getIV = parametersWithIV.m15801getIV();
        int length = bArrM15801getIV.length;
        byte[] bArr = this.f20521IV;
        if (length < bArr.length) {
            System.arraycopy(bArrM15801getIV, 0, bArr, bArr.length - bArrM15801getIV.length, bArrM15801getIV.length);
            int i = 0;
            while (true) {
                byte[] bArr2 = this.f20521IV;
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
            this.f20524cipher.mo14946init(true, parametersWithIV.getParameters());
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
        byte[] bArr = this.f20521IV;
        System.arraycopy(bArr, 0, this.f20523cfbV, 0, bArr.length);
        C6238Arrays.m18249fill(this.f20525inBuf, (byte) 0);
        this.byteCount = 0;
        this.f20524cipher.mo14947reset();
    }
}
