package org.bouncycastle.p194crypto;

/* loaded from: classes2.dex */
public abstract class DefaultMultiBlockCipher implements MultiBlockCipher {
    @Override // org.bouncycastle.p194crypto.MultiBlockCipher
    public int getMultiBlockSize() {
        return getBlockSize();
    }

    @Override // org.bouncycastle.p194crypto.MultiBlockCipher
    public int processBlocks(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        int blockSize = getBlockSize();
        int i4 = i2 * blockSize;
        if (bArr == bArr2) {
            bArr = new byte[i4];
            System.arraycopy(bArr2, i, bArr, 0, i4);
            i = 0;
        }
        int iProcessBlock = 0;
        for (int i5 = 0; i5 != i2; i5++) {
            iProcessBlock += processBlock(bArr, i, bArr2, i3 + iProcessBlock);
            i += blockSize;
        }
        return iProcessBlock;
    }
}
