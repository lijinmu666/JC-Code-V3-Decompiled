package org.bouncycastle.p194crypto;

/* loaded from: classes2.dex */
public class DefaultBufferedBlockCipher extends BufferedBlockCipher {

    /* renamed from: buf */
    protected byte[] f19133buf;

    /* renamed from: bufOff */
    protected int f19134bufOff;

    /* renamed from: cipher */
    protected BlockCipher f19135cipher;
    protected boolean forEncryption;
    protected MultiBlockCipher mbCipher;
    protected boolean partialBlockOkay;

    /* renamed from: pgpCFB */
    protected boolean f19136pgpCFB;

    public DefaultBufferedBlockCipher() {
    }

    private int processBuffer(byte[] bArr, int i) {
        this.f19134bufOff = 0;
        MultiBlockCipher multiBlockCipher = this.mbCipher;
        if (multiBlockCipher == null) {
            return this.f19135cipher.processBlock(this.f19133buf, 0, bArr, i);
        }
        byte[] bArr2 = this.f19133buf;
        return multiBlockCipher.processBlocks(bArr2, 0, bArr2.length / multiBlockCipher.getBlockSize(), bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.BufferedBlockCipher
    /* renamed from: doFinal */
    public int mo14951doFinal(byte[] bArr, int i) {
        int blockSize;
        int iProcessBlocks;
        try {
            int i2 = this.f19134bufOff;
            if (i + i2 > bArr.length) {
                throw new OutputLengthException("output buffer too short for doFinal()");
            }
            int i3 = 0;
            if (i2 != 0) {
                MultiBlockCipher multiBlockCipher = this.mbCipher;
                if (multiBlockCipher != null) {
                    int blockSize2 = i2 / multiBlockCipher.getBlockSize();
                    iProcessBlocks = this.mbCipher.processBlocks(this.f19133buf, 0, blockSize2, bArr, i);
                    blockSize = blockSize2 * this.mbCipher.getBlockSize();
                } else {
                    blockSize = 0;
                    iProcessBlocks = 0;
                }
                if (this.f19134bufOff != blockSize) {
                    if (!this.partialBlockOkay) {
                        throw new DataLengthException("data not block size aligned");
                    }
                    BlockCipher blockCipher = this.f19135cipher;
                    byte[] bArr2 = this.f19133buf;
                    blockCipher.processBlock(bArr2, blockSize, bArr2, blockSize);
                    System.arraycopy(this.f19133buf, blockSize, bArr, i + iProcessBlocks, this.f19134bufOff - blockSize);
                    iProcessBlocks += this.f19134bufOff - blockSize;
                    this.f19134bufOff = 0;
                }
                i3 = iProcessBlocks;
            }
            return i3;
        } finally {
            mo14953reset();
        }
    }

    @Override // org.bouncycastle.p194crypto.BufferedBlockCipher
    public int getBlockSize() {
        return this.f19135cipher.getBlockSize();
    }

    @Override // org.bouncycastle.p194crypto.BufferedBlockCipher
    public int getOutputSize(int i) {
        int blockSize;
        if (this.f19136pgpCFB && this.forEncryption) {
            i += this.f19134bufOff;
            blockSize = this.f19135cipher.getBlockSize() + 2;
        } else {
            blockSize = this.f19134bufOff;
        }
        return i + blockSize;
    }

    @Override // org.bouncycastle.p194crypto.BufferedBlockCipher
    public BlockCipher getUnderlyingCipher() {
        return this.f19135cipher;
    }

    @Override // org.bouncycastle.p194crypto.BufferedBlockCipher
    public int getUpdateOutputSize(int i) {
        int length;
        int i2 = i + this.f19134bufOff;
        if (this.f19136pgpCFB && this.forEncryption) {
            length = (i2 % this.f19133buf.length) - (this.f19135cipher.getBlockSize() + 2);
            return i2 - length;
        }
        int length2 = this.f19133buf.length;
        length = i2 % length2;
        return i2 - length;
    }

    @Override // org.bouncycastle.p194crypto.BufferedBlockCipher
    /* renamed from: init */
    public void mo14952init(boolean z, CipherParameters cipherParameters) {
        this.forEncryption = z;
        mo14953reset();
        this.f19135cipher.mo14946init(z, cipherParameters);
    }

    @Override // org.bouncycastle.p194crypto.BufferedBlockCipher
    public int processByte(byte b, byte[] bArr, int i) {
        byte[] bArr2 = this.f19133buf;
        int i2 = this.f19134bufOff;
        int i3 = i2 + 1;
        this.f19134bufOff = i3;
        bArr2[i2] = b;
        if (i3 == bArr2.length) {
            return processBuffer(bArr, i);
        }
        return 0;
    }

    @Override // org.bouncycastle.p194crypto.BufferedBlockCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        byte[] bArr3;
        int i4;
        int i5;
        int i6 = i;
        int i7 = i2;
        if (i7 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int blockSize = getBlockSize();
        int updateOutputSize = getUpdateOutputSize(i7);
        if (updateOutputSize > 0 && updateOutputSize + i3 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        byte[] bArr4 = this.f19133buf;
        int length = bArr4.length;
        int i8 = this.f19134bufOff;
        int i9 = length - i8;
        if (i7 > i9) {
            if (i8 != 0) {
                System.arraycopy(bArr, i6, bArr4, i8, i9);
                i6 += i9;
                i7 -= i9;
            }
            i5 = i7;
            if (bArr == bArr2) {
                byte[] bArr5 = new byte[i5];
                System.arraycopy(bArr2, i6, bArr5, 0, i5);
                bArr3 = bArr5;
                i4 = 0;
            } else {
                bArr3 = bArr;
                i4 = i6;
            }
            iProcessBuffer = this.f19134bufOff != 0 ? processBuffer(bArr2, i3) : 0;
            MultiBlockCipher multiBlockCipher = this.mbCipher;
            if (multiBlockCipher != null) {
                int multiBlockSize = (i5 / multiBlockCipher.getMultiBlockSize()) * (this.mbCipher.getMultiBlockSize() / blockSize);
                if (multiBlockSize > 0) {
                    iProcessBuffer += this.mbCipher.processBlocks(bArr3, i4, multiBlockSize, bArr2, i3 + iProcessBuffer);
                    int i10 = multiBlockSize * blockSize;
                    i5 -= i10;
                    i4 += i10;
                }
            } else {
                while (i5 > this.f19133buf.length) {
                    iProcessBuffer += this.f19135cipher.processBlock(bArr3, i4, bArr2, i3 + iProcessBuffer);
                    i5 -= blockSize;
                    i4 += blockSize;
                }
            }
        } else {
            bArr3 = bArr;
            i4 = i6;
            i5 = i7;
        }
        System.arraycopy(bArr3, i4, this.f19133buf, this.f19134bufOff, i5);
        int i11 = this.f19134bufOff + i5;
        this.f19134bufOff = i11;
        return i11 == this.f19133buf.length ? iProcessBuffer + processBuffer(bArr2, i3 + iProcessBuffer) : iProcessBuffer;
    }

    @Override // org.bouncycastle.p194crypto.BufferedBlockCipher
    /* renamed from: reset */
    public void mo14953reset() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f19133buf;
            if (i >= bArr.length) {
                this.f19134bufOff = 0;
                this.f19135cipher.mo14947reset();
                return;
            } else {
                bArr[i] = 0;
                i++;
            }
        }
    }

    public DefaultBufferedBlockCipher(BlockCipher blockCipher) {
        this.f19135cipher = blockCipher;
        if (blockCipher instanceof MultiBlockCipher) {
            MultiBlockCipher multiBlockCipher = (MultiBlockCipher) blockCipher;
            this.mbCipher = multiBlockCipher;
            this.f19133buf = new byte[multiBlockCipher.getMultiBlockSize()];
        } else {
            this.mbCipher = null;
            this.f19133buf = new byte[blockCipher.getBlockSize()];
        }
        boolean z = false;
        this.f19134bufOff = 0;
        String algorithmName = blockCipher.getAlgorithmName();
        int iIndexOf = algorithmName.indexOf(47) + 1;
        boolean z2 = iIndexOf > 0 && algorithmName.startsWith("PGP", iIndexOf);
        this.f19136pgpCFB = z2;
        if (z2 || (blockCipher instanceof StreamCipher)) {
            this.partialBlockOkay = true;
            return;
        }
        if (iIndexOf > 0 && algorithmName.startsWith("OpenPGP", iIndexOf)) {
            z = true;
        }
        this.partialBlockOkay = z;
    }
}
