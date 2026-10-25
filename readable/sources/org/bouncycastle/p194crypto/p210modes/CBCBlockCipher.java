package org.bouncycastle.p194crypto.p210modes;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.DefaultMultiBlockCipher;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class CBCBlockCipher extends DefaultMultiBlockCipher implements CBCModeCipher {

    /* renamed from: IV */
    private byte[] f20514IV;
    private int blockSize;
    private byte[] cbcNextV;

    /* renamed from: cbcV */
    private byte[] f20515cbcV;

    /* renamed from: cipher */
    private BlockCipher f20516cipher;
    private boolean encrypting;

    public CBCBlockCipher(BlockCipher blockCipher) {
        this.f20516cipher = blockCipher;
        int blockSize = blockCipher.getBlockSize();
        this.blockSize = blockSize;
        this.f20514IV = new byte[blockSize];
        this.f20515cbcV = new byte[blockSize];
        this.cbcNextV = new byte[blockSize];
    }

    private int decryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = this.blockSize;
        if (i + i3 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        System.arraycopy(bArr, i, this.cbcNextV, 0, i3);
        int iProcessBlock = this.f20516cipher.processBlock(bArr, i, bArr2, i2);
        for (int i4 = 0; i4 < this.blockSize; i4++) {
            int i5 = i2 + i4;
            bArr2[i5] = (byte) (bArr2[i5] ^ this.f20515cbcV[i4]);
        }
        byte[] bArr3 = this.f20515cbcV;
        this.f20515cbcV = this.cbcNextV;
        this.cbcNextV = bArr3;
        return iProcessBlock;
    }

    private int encryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.blockSize + i > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        for (int i3 = 0; i3 < this.blockSize; i3++) {
            byte[] bArr3 = this.f20515cbcV;
            bArr3[i3] = (byte) (bArr3[i3] ^ bArr[i + i3]);
        }
        int iProcessBlock = this.f20516cipher.processBlock(this.f20515cbcV, 0, bArr2, i2);
        byte[] bArr4 = this.f20515cbcV;
        System.arraycopy(bArr2, i2, bArr4, 0, bArr4.length);
        return iProcessBlock;
    }

    public static CBCModeCipher newInstance(BlockCipher blockCipher) {
        return new CBCBlockCipher(blockCipher);
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public String getAlgorithmName() {
        return this.f20516cipher.getAlgorithmName() + "/CBC";
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int getBlockSize() {
        return this.f20516cipher.getBlockSize();
    }

    @Override // org.bouncycastle.p194crypto.p210modes.CBCModeCipher
    public BlockCipher getUnderlyingCipher() {
        return this.f20516cipher;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: init */
    public void mo14946init(boolean z, CipherParameters cipherParameters) {
        boolean z2 = this.encrypting;
        this.encrypting = z;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] bArrM15801getIV = parametersWithIV.m15801getIV();
            if (bArrM15801getIV.length != this.blockSize) {
                throw new IllegalArgumentException("initialisation vector must be the same length as block size");
            }
            System.arraycopy(bArrM15801getIV, 0, this.f20514IV, 0, bArrM15801getIV.length);
            cipherParameters = parametersWithIV.getParameters();
        } else {
            C6238Arrays.m18249fill(this.f20514IV, (byte) 0);
        }
        mo14947reset();
        if (cipherParameters != null) {
            this.f20516cipher.mo14946init(z, cipherParameters);
        } else if (z2 != z) {
            throw new IllegalArgumentException("cannot change encrypting state without providing key.");
        }
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        return this.encrypting ? encryptBlock(bArr, i, bArr2, i2) : decryptBlock(bArr, i, bArr2, i2);
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: reset */
    public void mo14947reset() {
        byte[] bArr = this.f20514IV;
        System.arraycopy(bArr, 0, this.f20515cbcV, 0, bArr.length);
        C6238Arrays.m18249fill(this.cbcNextV, (byte) 0);
        this.f20516cipher.mo14947reset();
    }
}
