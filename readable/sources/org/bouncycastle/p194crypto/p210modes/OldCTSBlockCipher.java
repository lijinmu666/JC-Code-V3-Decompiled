package org.bouncycastle.p194crypto.p210modes;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.DefaultBufferedBlockCipher;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class OldCTSBlockCipher extends DefaultBufferedBlockCipher {
    private int blockSize;

    public OldCTSBlockCipher(BlockCipher blockCipher) {
        if ((blockCipher instanceof OFBBlockCipher) || (blockCipher instanceof CFBBlockCipher)) {
            throw new IllegalArgumentException("CTSBlockCipher can only accept ECB, or CBC ciphers");
        }
        ((DefaultBufferedBlockCipher) this).f19135cipher = blockCipher;
        int blockSize = blockCipher.getBlockSize();
        this.blockSize = blockSize;
        ((DefaultBufferedBlockCipher) this).f19133buf = new byte[blockSize * 2];
        ((DefaultBufferedBlockCipher) this).f19134bufOff = 0;
    }

    @Override // org.bouncycastle.p194crypto.DefaultBufferedBlockCipher, org.bouncycastle.p194crypto.BufferedBlockCipher
    /* renamed from: doFinal */
    public int mo14951doFinal(byte[] bArr, int i) {
        if (((DefaultBufferedBlockCipher) this).f19134bufOff + i > bArr.length) {
            throw new OutputLengthException("output buffer to small in doFinal");
        }
        int blockSize = ((DefaultBufferedBlockCipher) this).f19135cipher.getBlockSize();
        int i2 = ((DefaultBufferedBlockCipher) this).f19134bufOff - blockSize;
        byte[] bArr2 = new byte[blockSize];
        if (((DefaultBufferedBlockCipher) this).forEncryption) {
            ((DefaultBufferedBlockCipher) this).f19135cipher.processBlock(((DefaultBufferedBlockCipher) this).f19133buf, 0, bArr2, 0);
            int i3 = ((DefaultBufferedBlockCipher) this).f19134bufOff;
            if (i3 < blockSize) {
                throw new DataLengthException("need at least one block of input for CTS");
            }
            while (true) {
                byte[] bArr3 = ((DefaultBufferedBlockCipher) this).f19133buf;
                if (i3 == bArr3.length) {
                    break;
                }
                bArr3[i3] = bArr2[i3 - blockSize];
                i3++;
            }
            for (int i4 = blockSize; i4 != ((DefaultBufferedBlockCipher) this).f19134bufOff; i4++) {
                byte[] bArr4 = ((DefaultBufferedBlockCipher) this).f19133buf;
                bArr4[i4] = (byte) (bArr4[i4] ^ bArr2[i4 - blockSize]);
            }
            BlockCipher blockCipher = ((DefaultBufferedBlockCipher) this).f19135cipher;
            if (blockCipher instanceof CBCBlockCipher) {
                ((CBCBlockCipher) blockCipher).getUnderlyingCipher().processBlock(((DefaultBufferedBlockCipher) this).f19133buf, blockSize, bArr, i);
            } else {
                blockCipher.processBlock(((DefaultBufferedBlockCipher) this).f19133buf, blockSize, bArr, i);
            }
            System.arraycopy(bArr2, 0, bArr, i + blockSize, i2);
        } else {
            byte[] bArr5 = new byte[blockSize];
            BlockCipher blockCipher2 = ((DefaultBufferedBlockCipher) this).f19135cipher;
            if (blockCipher2 instanceof CBCBlockCipher) {
                ((CBCBlockCipher) blockCipher2).getUnderlyingCipher().processBlock(((DefaultBufferedBlockCipher) this).f19133buf, 0, bArr2, 0);
            } else {
                blockCipher2.processBlock(((DefaultBufferedBlockCipher) this).f19133buf, 0, bArr2, 0);
            }
            for (int i5 = blockSize; i5 != ((DefaultBufferedBlockCipher) this).f19134bufOff; i5++) {
                int i6 = i5 - blockSize;
                bArr5[i6] = (byte) (bArr2[i6] ^ ((DefaultBufferedBlockCipher) this).f19133buf[i5]);
            }
            System.arraycopy(((DefaultBufferedBlockCipher) this).f19133buf, blockSize, bArr2, 0, i2);
            ((DefaultBufferedBlockCipher) this).f19135cipher.processBlock(bArr2, 0, bArr, i);
            System.arraycopy(bArr5, 0, bArr, i + blockSize, i2);
        }
        int i7 = ((DefaultBufferedBlockCipher) this).f19134bufOff;
        mo14953reset();
        return i7;
    }

    @Override // org.bouncycastle.p194crypto.DefaultBufferedBlockCipher, org.bouncycastle.p194crypto.BufferedBlockCipher
    public int getOutputSize(int i) {
        return i + ((DefaultBufferedBlockCipher) this).f19134bufOff;
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
            byte[] bArr3 = ((DefaultBufferedBlockCipher) this).f19133buf;
            int i4 = this.blockSize;
            System.arraycopy(bArr3, i4, bArr3, 0, i4);
            ((DefaultBufferedBlockCipher) this).f19134bufOff = this.blockSize;
            i3 = iProcessBlock;
        }
        byte[] bArr4 = ((DefaultBufferedBlockCipher) this).f19133buf;
        int i5 = ((DefaultBufferedBlockCipher) this).f19134bufOff;
        ((DefaultBufferedBlockCipher) this).f19134bufOff = i5 + 1;
        bArr4[i5] = b;
        return i3;
    }

    @Override // org.bouncycastle.p194crypto.DefaultBufferedBlockCipher, org.bouncycastle.p194crypto.BufferedBlockCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int blockSize = getBlockSize();
        int updateOutputSize = getUpdateOutputSize(i2);
        if (updateOutputSize > 0 && i3 + updateOutputSize > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        byte[] bArr3 = ((DefaultBufferedBlockCipher) this).f19133buf;
        int length = bArr3.length;
        int i4 = ((DefaultBufferedBlockCipher) this).f19134bufOff;
        int i5 = length - i4;
        int i6 = 0;
        if (i2 > i5) {
            System.arraycopy(bArr, i, bArr3, i4, i5);
            i += i5;
            i2 -= i5;
            if (bArr == bArr2 && C6238Arrays.segmentsOverlap(i, i2, i3, updateOutputSize)) {
                bArr = new byte[i2];
                System.arraycopy(bArr2, i, bArr, 0, i2);
                i = 0;
            }
            int iProcessBlock = ((DefaultBufferedBlockCipher) this).f19135cipher.processBlock(((DefaultBufferedBlockCipher) this).f19133buf, 0, bArr2, i3);
            byte[] bArr4 = ((DefaultBufferedBlockCipher) this).f19133buf;
            System.arraycopy(bArr4, blockSize, bArr4, 0, blockSize);
            ((DefaultBufferedBlockCipher) this).f19134bufOff = blockSize;
            while (i2 > blockSize) {
                System.arraycopy(bArr, i, ((DefaultBufferedBlockCipher) this).f19133buf, ((DefaultBufferedBlockCipher) this).f19134bufOff, blockSize);
                iProcessBlock += ((DefaultBufferedBlockCipher) this).f19135cipher.processBlock(((DefaultBufferedBlockCipher) this).f19133buf, 0, bArr2, i3 + iProcessBlock);
                byte[] bArr5 = ((DefaultBufferedBlockCipher) this).f19133buf;
                System.arraycopy(bArr5, blockSize, bArr5, 0, blockSize);
                i2 -= blockSize;
                i += blockSize;
            }
            i6 = iProcessBlock;
        }
        System.arraycopy(bArr, i, ((DefaultBufferedBlockCipher) this).f19133buf, ((DefaultBufferedBlockCipher) this).f19134bufOff, i2);
        ((DefaultBufferedBlockCipher) this).f19134bufOff += i2;
        return i6;
    }
}
