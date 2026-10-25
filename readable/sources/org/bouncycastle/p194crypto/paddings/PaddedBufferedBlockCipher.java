package org.bouncycastle.p194crypto.paddings;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.DefaultBufferedBlockCipher;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class PaddedBufferedBlockCipher extends DefaultBufferedBlockCipher {

    /* renamed from: padding */
    BlockCipherPadding f20660padding;

    public PaddedBufferedBlockCipher(BlockCipher blockCipher) {
        this(blockCipher, new PKCS7Padding());
    }

    @Override // org.bouncycastle.p194crypto.DefaultBufferedBlockCipher, org.bouncycastle.p194crypto.BufferedBlockCipher
    /* renamed from: doFinal */
    public int mo14951doFinal(byte[] bArr, int i) {
        int iPadCount;
        int iProcessBlock;
        int blockSize = ((DefaultBufferedBlockCipher) this).f19135cipher.getBlockSize();
        if (((DefaultBufferedBlockCipher) this).forEncryption) {
            if (((DefaultBufferedBlockCipher) this).f19134bufOff != blockSize) {
                iProcessBlock = 0;
            } else {
                if ((blockSize * 2) + i > bArr.length) {
                    mo14953reset();
                    throw new OutputLengthException("output buffer too short");
                }
                iProcessBlock = ((DefaultBufferedBlockCipher) this).f19135cipher.processBlock(((DefaultBufferedBlockCipher) this).f19133buf, 0, bArr, i);
                ((DefaultBufferedBlockCipher) this).f19134bufOff = 0;
            }
            this.f20660padding.addPadding(((DefaultBufferedBlockCipher) this).f19133buf, ((DefaultBufferedBlockCipher) this).f19134bufOff);
            iPadCount = iProcessBlock + ((DefaultBufferedBlockCipher) this).f19135cipher.processBlock(((DefaultBufferedBlockCipher) this).f19133buf, 0, bArr, i + iProcessBlock);
        } else {
            if (((DefaultBufferedBlockCipher) this).f19134bufOff != blockSize) {
                mo14953reset();
                throw new DataLengthException("last block incomplete in decryption");
            }
            BlockCipher blockCipher = ((DefaultBufferedBlockCipher) this).f19135cipher;
            byte[] bArr2 = ((DefaultBufferedBlockCipher) this).f19133buf;
            int iProcessBlock2 = blockCipher.processBlock(bArr2, 0, bArr2, 0);
            ((DefaultBufferedBlockCipher) this).f19134bufOff = 0;
            try {
                iPadCount = iProcessBlock2 - this.f20660padding.padCount(((DefaultBufferedBlockCipher) this).f19133buf);
                System.arraycopy(((DefaultBufferedBlockCipher) this).f19133buf, 0, bArr, i, iPadCount);
            } finally {
                mo14953reset();
            }
        }
        return iPadCount;
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
        return length == 0 ? Math.max(0, i2 - bArr.length) : i2 - length;
    }

    @Override // org.bouncycastle.p194crypto.DefaultBufferedBlockCipher, org.bouncycastle.p194crypto.BufferedBlockCipher
    /* renamed from: init */
    public void mo14952init(boolean z, CipherParameters cipherParameters) {
        BlockCipher blockCipher;
        ((DefaultBufferedBlockCipher) this).forEncryption = z;
        mo14953reset();
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f20660padding.mo15663init(parametersWithRandom.getRandom());
            blockCipher = ((DefaultBufferedBlockCipher) this).f19135cipher;
            cipherParameters = parametersWithRandom.getParameters();
        } else {
            this.f20660padding.mo15663init(null);
            blockCipher = ((DefaultBufferedBlockCipher) this).f19135cipher;
        }
        blockCipher.mo14946init(z, cipherParameters);
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
        if (updateOutputSize > 0 && i3 + updateOutputSize > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        byte[] bArr3 = ((DefaultBufferedBlockCipher) this).f19133buf;
        int length = bArr3.length;
        int i4 = ((DefaultBufferedBlockCipher) this).f19134bufOff;
        int i5 = length - i4;
        int iProcessBlock = 0;
        if (i2 > i5) {
            System.arraycopy(bArr, i, bArr3, i4, i5);
            i += i5;
            i2 -= i5;
            if (bArr == bArr2 && C6238Arrays.segmentsOverlap(i, i2, i3, updateOutputSize)) {
                bArr = new byte[i2];
                System.arraycopy(bArr2, i, bArr, 0, i2);
                i = 0;
            }
            int iProcessBlock2 = ((DefaultBufferedBlockCipher) this).f19135cipher.processBlock(((DefaultBufferedBlockCipher) this).f19133buf, 0, bArr2, i3);
            ((DefaultBufferedBlockCipher) this).f19134bufOff = 0;
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

    public PaddedBufferedBlockCipher(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
        ((DefaultBufferedBlockCipher) this).f19135cipher = blockCipher;
        this.f20660padding = blockCipherPadding;
        ((DefaultBufferedBlockCipher) this).f19133buf = new byte[blockCipher.getBlockSize()];
        ((DefaultBufferedBlockCipher) this).f19134bufOff = 0;
    }
}
