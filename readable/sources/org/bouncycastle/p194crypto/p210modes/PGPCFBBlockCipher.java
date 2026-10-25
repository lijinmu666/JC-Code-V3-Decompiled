package org.bouncycastle.p194crypto.p210modes;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;

/* loaded from: classes2.dex */
public class PGPCFBBlockCipher implements BlockCipher {

    /* renamed from: FR */
    private byte[] f20631FR;

    /* renamed from: FRE */
    private byte[] f20632FRE;

    /* renamed from: IV */
    private byte[] f20633IV;
    private int blockSize;

    /* renamed from: cipher */
    private BlockCipher f20634cipher;

    /* renamed from: count */
    private int f20635count;
    private boolean forEncryption;
    private boolean inlineIv;

    /* renamed from: tmp */
    private byte[] f20636tmp;

    public PGPCFBBlockCipher(BlockCipher blockCipher, boolean z) {
        this.f20634cipher = blockCipher;
        this.inlineIv = z;
        int blockSize = blockCipher.getBlockSize();
        this.blockSize = blockSize;
        this.f20633IV = new byte[blockSize];
        this.f20631FR = new byte[blockSize];
        this.f20632FRE = new byte[blockSize];
        this.f20636tmp = new byte[blockSize];
    }

    private int decryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = this.blockSize;
        if (i + i3 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i3 + i2 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        int i4 = 0;
        this.f20634cipher.processBlock(this.f20631FR, 0, this.f20632FRE, 0);
        for (int i5 = 0; i5 < this.blockSize; i5++) {
            bArr2[i2 + i5] = encryptByte(bArr[i + i5], i5);
        }
        while (true) {
            int i6 = this.blockSize;
            if (i4 >= i6) {
                return i6;
            }
            this.f20631FR[i4] = bArr[i + i4];
            i4++;
        }
    }

    private int decryptBlockWithIV(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3;
        int i4 = this.blockSize;
        if (i + i4 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i2 + i4 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        int i5 = this.f20635count;
        if (i5 == 0) {
            for (int i6 = 0; i6 < this.blockSize; i6++) {
                this.f20631FR[i6] = bArr[i + i6];
            }
            this.f20634cipher.processBlock(this.f20631FR, 0, this.f20632FRE, 0);
            this.f20635count += this.blockSize;
            return 0;
        }
        if (i5 != i4) {
            if (i5 >= i4 + 2) {
                System.arraycopy(bArr, i, this.f20636tmp, 0, i4);
                bArr2[i2] = encryptByte(this.f20636tmp[0], this.blockSize - 2);
                bArr2[i2 + 1] = encryptByte(this.f20636tmp[1], this.blockSize - 1);
                System.arraycopy(this.f20636tmp, 0, this.f20631FR, this.blockSize - 2, 2);
                this.f20634cipher.processBlock(this.f20631FR, 0, this.f20632FRE, 0);
                int i7 = 0;
                while (true) {
                    i3 = this.blockSize;
                    if (i7 >= i3 - 2) {
                        break;
                    }
                    bArr2[i2 + i7 + 2] = encryptByte(this.f20636tmp[i7 + 2], i7);
                    i7++;
                }
                System.arraycopy(this.f20636tmp, 2, this.f20631FR, 0, i3 - 2);
            }
            return this.blockSize;
        }
        System.arraycopy(bArr, i, this.f20636tmp, 0, i4);
        byte[] bArr3 = this.f20631FR;
        System.arraycopy(bArr3, 2, bArr3, 0, this.blockSize - 2);
        byte[] bArr4 = this.f20631FR;
        int i8 = this.blockSize;
        byte[] bArr5 = this.f20636tmp;
        bArr4[i8 - 2] = bArr5[0];
        bArr4[i8 - 1] = bArr5[1];
        this.f20634cipher.processBlock(bArr4, 0, this.f20632FRE, 0);
        int i9 = 0;
        while (true) {
            int i10 = this.blockSize;
            if (i9 >= i10 - 2) {
                System.arraycopy(this.f20636tmp, 2, this.f20631FR, 0, i10 - 2);
                this.f20635count += 2;
                return this.blockSize - 2;
            }
            bArr2[i2 + i9] = encryptByte(this.f20636tmp[i9 + 2], i9);
            i9++;
        }
    }

    private int encryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = this.blockSize;
        if (i + i3 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i3 + i2 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        int i4 = 0;
        this.f20634cipher.processBlock(this.f20631FR, 0, this.f20632FRE, 0);
        for (int i5 = 0; i5 < this.blockSize; i5++) {
            bArr2[i2 + i5] = encryptByte(bArr[i + i5], i5);
        }
        while (true) {
            int i6 = this.blockSize;
            if (i4 >= i6) {
                return i6;
            }
            this.f20631FR[i4] = bArr2[i2 + i4];
            i4++;
        }
    }

    private int encryptBlockWithIV(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3;
        int i4;
        int i5 = this.blockSize;
        if (i + i5 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        int i6 = this.f20635count;
        if (i6 != 0) {
            if (i6 >= i5 + 2) {
                if (i5 + i2 > bArr2.length) {
                    throw new OutputLengthException("output buffer too short");
                }
                this.f20634cipher.processBlock(this.f20631FR, 0, this.f20632FRE, 0);
                int i7 = 0;
                while (true) {
                    i3 = this.blockSize;
                    if (i7 >= i3) {
                        break;
                    }
                    bArr2[i2 + i7] = encryptByte(bArr[i + i7], i7);
                    i7++;
                }
                System.arraycopy(bArr2, i2, this.f20631FR, 0, i3);
            }
            return this.blockSize;
        }
        if ((i5 * 2) + i2 + 2 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        this.f20634cipher.processBlock(this.f20631FR, 0, this.f20632FRE, 0);
        int i8 = 0;
        while (true) {
            i4 = this.blockSize;
            if (i8 >= i4) {
                break;
            }
            bArr2[i2 + i8] = encryptByte(this.f20633IV[i8], i8);
            i8++;
        }
        System.arraycopy(bArr2, i2, this.f20631FR, 0, i4);
        this.f20634cipher.processBlock(this.f20631FR, 0, this.f20632FRE, 0);
        int i9 = this.blockSize;
        bArr2[i2 + i9] = encryptByte(this.f20633IV[i9 - 2], 0);
        int i10 = this.blockSize;
        bArr2[i2 + i10 + 1] = encryptByte(this.f20633IV[i10 - 1], 1);
        System.arraycopy(bArr2, i2 + 2, this.f20631FR, 0, this.blockSize);
        this.f20634cipher.processBlock(this.f20631FR, 0, this.f20632FRE, 0);
        int i11 = 0;
        while (true) {
            int i12 = this.blockSize;
            if (i11 >= i12) {
                System.arraycopy(bArr2, i2 + i12 + 2, this.f20631FR, 0, i12);
                int i13 = this.f20635count;
                int i14 = this.blockSize;
                this.f20635count = i13 + (i14 * 2) + 2;
                return (i14 * 2) + 2;
            }
            bArr2[i12 + i2 + 2 + i11] = encryptByte(bArr[i + i11], i11);
            i11++;
        }
    }

    private byte encryptByte(byte b, int i) {
        return (byte) (this.f20632FRE[i] ^ b);
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public String getAlgorithmName() {
        StringBuilder sb;
        String str;
        if (this.inlineIv) {
            sb = new StringBuilder();
            sb.append(this.f20634cipher.getAlgorithmName());
            str = "/PGPCFBwithIV";
        } else {
            sb = new StringBuilder();
            sb.append(this.f20634cipher.getAlgorithmName());
            str = "/PGPCFB";
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int getBlockSize() {
        return this.f20634cipher.getBlockSize();
    }

    public BlockCipher getUnderlyingCipher() {
        return this.f20634cipher;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: init */
    public void mo14946init(boolean z, CipherParameters cipherParameters) {
        this.forEncryption = z;
        if (!(cipherParameters instanceof ParametersWithIV)) {
            mo14947reset();
            this.f20634cipher.mo14946init(true, cipherParameters);
            return;
        }
        ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
        byte[] bArrM15801getIV = parametersWithIV.m15801getIV();
        int length = bArrM15801getIV.length;
        byte[] bArr = this.f20633IV;
        if (length < bArr.length) {
            System.arraycopy(bArrM15801getIV, 0, bArr, bArr.length - bArrM15801getIV.length, bArrM15801getIV.length);
            int i = 0;
            while (true) {
                byte[] bArr2 = this.f20633IV;
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
        this.f20634cipher.mo14946init(true, parametersWithIV.getParameters());
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        return this.inlineIv ? this.forEncryption ? encryptBlockWithIV(bArr, i, bArr2, i2) : decryptBlockWithIV(bArr, i, bArr2, i2) : this.forEncryption ? encryptBlock(bArr, i, bArr2, i2) : decryptBlock(bArr, i, bArr2, i2);
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: reset */
    public void mo14947reset() {
        this.f20635count = 0;
        int i = 0;
        while (true) {
            byte[] bArr = this.f20631FR;
            if (i == bArr.length) {
                this.f20634cipher.mo14947reset();
                return;
            }
            if (this.inlineIv) {
                bArr[i] = 0;
            } else {
                bArr[i] = this.f20633IV[i];
            }
            i++;
        }
    }
}
