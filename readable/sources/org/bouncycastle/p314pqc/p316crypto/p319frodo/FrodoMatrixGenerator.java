package org.bouncycastle.p314pqc.p316crypto.p319frodo;

import org.bouncycastle.p194crypto.MultiBlockCipher;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p194crypto.p201engines.AESEngine;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
abstract class FrodoMatrixGenerator {

    /* renamed from: n */
    final int f23169n;

    /* renamed from: q */
    final int f23170q;

    public static class Aes128MatrixGenerator extends FrodoMatrixGenerator {
        public Aes128MatrixGenerator(int i, int i2) {
            super(i, i2);
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p319frodo.FrodoMatrixGenerator
        public short[] genMatrix(byte[] bArr, int i, int i2) {
            int i3 = this.f23169n;
            short[] sArr = new short[i3 * i3];
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[16];
            MultiBlockCipher multiBlockCipherNewInstance = AESEngine.newInstance();
            multiBlockCipherNewInstance.mo14946init(true, new KeyParameter(bArr, i, i2));
            for (int i4 = 0; i4 < this.f23169n; i4++) {
                AbstractC6245Pack.shortToLittleEndian((short) i4, bArr2, 0);
                for (int i5 = 0; i5 < this.f23169n; i5 += 8) {
                    AbstractC6245Pack.shortToLittleEndian((short) i5, bArr2, 2);
                    multiBlockCipherNewInstance.processBlock(bArr2, 0, bArr3, 0);
                    for (int i6 = 0; i6 < 8; i6++) {
                        sArr[(this.f23169n * i4) + i5 + i6] = (short) (AbstractC6245Pack.littleEndianToShort(bArr3, i6 * 2) & (this.f23170q - 1));
                    }
                }
            }
            return sArr;
        }
    }

    public static class Shake128MatrixGenerator extends FrodoMatrixGenerator {
        public Shake128MatrixGenerator(int i, int i2) {
            super(i, i2);
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p319frodo.FrodoMatrixGenerator
        public short[] genMatrix(byte[] bArr, int i, int i2) {
            int i3 = this.f23169n;
            short[] sArr = new short[i3 * i3];
            int i4 = (i3 * 16) / 8;
            byte[] bArr2 = new byte[i4];
            int i5 = i2 + 2;
            byte[] bArr3 = new byte[i5];
            System.arraycopy(bArr, i, bArr3, 2, i2);
            SHAKEDigest sHAKEDigest = new SHAKEDigest(128);
            for (int i6 = 0; i6 < this.f23169n; i6++) {
                AbstractC6245Pack.shortToLittleEndian((short) i6, bArr3, 0);
                sHAKEDigest.mo14970update(bArr3, 0, i5);
                sHAKEDigest.mo14998doFinal(bArr2, 0, i4);
                int i7 = 0;
                while (true) {
                    int i8 = this.f23169n;
                    if (i7 < i8) {
                        sArr[(i8 * i6) + i7] = (short) (AbstractC6245Pack.littleEndianToShort(bArr2, i7 * 2) & (this.f23170q - 1));
                        i7++;
                    }
                }
            }
            return sArr;
        }
    }

    public FrodoMatrixGenerator(int i, int i2) {
        this.f23169n = i;
        this.f23170q = i2;
    }

    public abstract short[] genMatrix(byte[] bArr, int i, int i2);
}
