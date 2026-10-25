package org.bouncycastle.p194crypto.p210modes;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.DefaultBufferedBlockCipher;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.OutputLengthException;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class PaddedBlockCipher extends DefaultBufferedBlockCipher {
    public PaddedBlockCipher(BlockCipher blockCipher) {
        ((DefaultBufferedBlockCipher) this).f19135cipher = blockCipher;
        ((DefaultBufferedBlockCipher) this).f19133buf = new byte[blockCipher.getBlockSize()];
        ((DefaultBufferedBlockCipher) this).f19134bufOff = 0;
    }

    @Override // org.bouncycastle.p194crypto.DefaultBufferedBlockCipher, org.bouncycastle.p194crypto.BufferedBlockCipher
    /* renamed from: doFinal */
    public int mo14951doFinal(byte[] bArr, int i) throws InvalidCipherTextException {
        int iProcessBlock;
        int iProcessBlock2;
        int blockSize = ((DefaultBufferedBlockCipher) this).f19135cipher.getBlockSize();
        if (((DefaultBufferedBlockCipher) this).forEncryption) {
            if (((DefaultBufferedBlockCipher) this).f19134bufOff != blockSize) {
                iProcessBlock2 = 0;
            } else {
                if ((blockSize * 2) + i > bArr.length) {
                    throw new OutputLengthException("output buffer too short");
                }
                iProcessBlock2 = ((DefaultBufferedBlockCipher) this).f19135cipher.processBlock(((DefaultBufferedBlockCipher) this).f19133buf, 0, bArr, i);
                ((DefaultBufferedBlockCipher) this).f19134bufOff = 0;
            }
            byte b = (byte) (blockSize - ((DefaultBufferedBlockCipher) this).f19134bufOff);
            while (true) {
                int i2 = ((DefaultBufferedBlockCipher) this).f19134bufOff;
                if (i2 >= blockSize) {
                    break;
                }
                ((DefaultBufferedBlockCipher) this).f19133buf[i2] = b;
                ((DefaultBufferedBlockCipher) this).f19134bufOff = i2 + 1;
            }
            iProcessBlock = iProcessBlock2 + ((DefaultBufferedBlockCipher) this).f19135cipher.processBlock(((DefaultBufferedBlockCipher) this).f19133buf, 0, bArr, i + iProcessBlock2);
        } else {
            if (((DefaultBufferedBlockCipher) this).f19134bufOff != blockSize) {
                throw new DataLengthException("last block incomplete in decryption");
            }
            BlockCipher blockCipher = ((DefaultBufferedBlockCipher) this).f19135cipher;
            byte[] bArr2 = ((DefaultBufferedBlockCipher) this).f19133buf;
            int iProcessBlock3 = blockCipher.processBlock(bArr2, 0, bArr2, 0);
            ((DefaultBufferedBlockCipher) this).f19134bufOff = 0;
            byte[] bArr3 = ((DefaultBufferedBlockCipher) this).f19133buf;
            int i3 = bArr3[blockSize - 1] & C1126UByte.MAX_VALUE;
            if (i3 > blockSize) {
                throw new InvalidCipherTextException("pad block corrupted");
            }
            iProcessBlock = iProcessBlock3 - i3;
            System.arraycopy(bArr3, 0, bArr, i, iProcessBlock);
        }
        mo14953reset();
        return iProcessBlock;
    }

    @Override // org.bouncycastle.p194crypto.DefaultBufferedBlockCipher, org.bouncycastle.p194crypto.BufferedBlockCipher
    public int getOutputSize(int i) {
        int i2 = i + ((DefaultBufferedBlockCipher) this).f19134bufOff;
        byte[] bArr = ((DefaultBufferedBlockCipher) this).f19133buf;
        int length = i2 % bArr.length;
        if (length != 0) {
            i2 -= length;
        } else if (!((DefaultBufferedBlockCipher) this).forEncryption) {
            return i2;
        }
        return i2 + bArr.length;
    }

    @Override // org.bouncycastle.p194crypto.DefaultBufferedBlockCipher, org.bouncycastle.p194crypto.BufferedBlockCipher
    public int getUpdateOutputSize(int i) {
        int i2 = i + ((DefaultBufferedBlockCipher) this).f19134bufOff;
        byte[] bArr = ((DefaultBufferedBlockCipher) this).f19133buf;
        int length = i2 % bArr.length;
        return length == 0 ? i2 - bArr.length : i2 - length;
    }

    @Override // org.bouncycastle.p194crypto.DefaultBufferedBlockCipher, org.bouncycastle.p194crypto.BufferedBlockCipher
    public int processByte(byte b, byte[] bArr, int i) {
        int i2 = ((DefaultBufferedBlockCipher) this).f19134bufOff;
        byte[] bArr2 = ((DefaultBufferedBlockCipher) this).f19133buf;
        int i3 = 0;
        if (i2 == bArr2.length) {
            int iProcessBlock = ((DefaultBufferedBlockCipher) this).f19135cipher.processBlock(bArr2, 0, bArr, i);
            ((DefaultBufferedBlockCipher) this).f19134bufOff = 0;
            i3 = iProcessBlock;
        }
        byte[] bArr3 = ((DefaultBufferedBlockCipher) this).f19133buf;
        int i4 = ((DefaultBufferedBlockCipher) this).f19134bufOff;
        ((DefaultBufferedBlockCipher) this).f19134bufOff = i4 + 1;
        bArr3[i4] = b;
        return i3;
    }

    @Override // org.bouncycastle.p194crypto.DefaultBufferedBlockCipher, org.bouncycastle.p194crypto.BufferedBlockCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int blockSize = getBlockSize();
        int updateOutputSize = getUpdateOutputSize(i2);
        if (updateOutputSize > 0 && updateOutputSize + i3 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        byte[] bArr3 = ((DefaultBufferedBlockCipher) this).f19133buf;
        int length = bArr3.length;
        int i4 = ((DefaultBufferedBlockCipher) this).f19134bufOff;
        int i5 = length - i4;
        int iProcessBlock = 0;
        if (i2 > i5) {
            System.arraycopy(bArr, i, bArr3, i4, i5);
            int iProcessBlock2 = ((DefaultBufferedBlockCipher) this).f19135cipher.processBlock(((DefaultBufferedBlockCipher) this).f19133buf, 0, bArr2, i3);
            ((DefaultBufferedBlockCipher) this).f19134bufOff = 0;
            i2 -= i5;
            i += i5;
            iProcessBlock = iProcessBlock2;
            while (i2 > ((DefaultBufferedBlockCipher) this).f19133buf.length) {
                iProcessBlock += ((DefaultBufferedBlockCipher) this).f19135cipher.processBlock(bArr, i, bArr2, i3 + iProcessBlock);
                i2 -= blockSize;
                i += blockSize;
            }
        }
        System.arraycopy(bArr, i, ((DefaultBufferedBlockCipher) this).f19133buf, ((DefaultBufferedBlockCipher) this).f19134bufOff, i2);
        ((DefaultBufferedBlockCipher) this).f19134bufOff += i2;
        return iProcessBlock;
    }
}
