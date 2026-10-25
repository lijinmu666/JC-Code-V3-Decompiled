package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.InterfaceC5283Wrapper;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class RFC3394WrapEngine implements InterfaceC5283Wrapper {
    private static final byte[] DEFAULT_IV = {-90, -90, -90, -90, -90, -90, -90, -90};

    /* renamed from: engine */
    private final BlockCipher f20009engine;
    private boolean forWrapping;

    /* renamed from: iv */
    private final byte[] f20010iv;

    /* renamed from: param */
    private KeyParameter f20011param;
    private final boolean wrapCipherMode;

    public RFC3394WrapEngine(BlockCipher blockCipher) {
        this(blockCipher, false);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5283Wrapper
    public String getAlgorithmName() {
        return this.f20009engine.getAlgorithmName();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5283Wrapper
    /* renamed from: init */
    public void mo14995init(boolean z, CipherParameters cipherParameters) {
        this.forWrapping = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            cipherParameters = ((ParametersWithRandom) cipherParameters).getParameters();
        }
        if (cipherParameters instanceof KeyParameter) {
            this.f20011param = (KeyParameter) cipherParameters;
            System.arraycopy(DEFAULT_IV, 0, this.f20010iv, 0, 8);
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] bArrM15801getIV = parametersWithIV.m15801getIV();
            if (bArrM15801getIV.length != 8) {
                throw new IllegalArgumentException("IV not equal to 8");
            }
            this.f20011param = (KeyParameter) parametersWithIV.getParameters();
            System.arraycopy(bArrM15801getIV, 0, this.f20010iv, 0, 8);
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5283Wrapper
    /* renamed from: unwrap */
    public byte[] mo14996unwrap(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        if (this.forWrapping) {
            throw new IllegalStateException("not set for unwrapping");
        }
        if (i2 < 16) {
            throw new InvalidCipherTextException("unwrap data too short");
        }
        int i3 = i2 / 8;
        if (i3 * 8 != i2) {
            throw new InvalidCipherTextException("unwrap data must be a multiple of 8 bytes");
        }
        this.f20009engine.mo14946init(!this.wrapCipherMode, this.f20011param);
        byte[] bArr2 = this.f20010iv;
        byte[] bArr3 = new byte[i2 - bArr2.length];
        byte[] bArr4 = new byte[bArr2.length];
        int i4 = 8;
        byte[] bArr5 = new byte[bArr2.length + 8];
        int i5 = i3 - 1;
        if (i5 == 1) {
            this.f20009engine.processBlock(bArr, i, bArr5, 0);
            System.arraycopy(bArr5, 0, bArr4, 0, this.f20010iv.length);
            System.arraycopy(bArr5, this.f20010iv.length, bArr3, 0, 8);
        } else {
            System.arraycopy(bArr, i, bArr4, 0, bArr2.length);
            byte[] bArr6 = this.f20010iv;
            System.arraycopy(bArr, bArr6.length + i, bArr3, 0, i2 - bArr6.length);
            int i6 = 5;
            while (i6 >= 0) {
                int i7 = i5;
                while (i7 >= 1) {
                    System.arraycopy(bArr4, 0, bArr5, 0, this.f20010iv.length);
                    int i8 = (i7 - 1) * i4;
                    System.arraycopy(bArr3, i8, bArr5, this.f20010iv.length, i4);
                    int i9 = (i5 * i6) + i7;
                    int i10 = 1;
                    while (i9 != 0) {
                        int length = this.f20010iv.length - i10;
                        bArr5[length] = (byte) (bArr5[length] ^ ((byte) i9));
                        i9 >>>= 8;
                        i10++;
                    }
                    this.f20009engine.processBlock(bArr5, 0, bArr5, 0);
                    System.arraycopy(bArr5, 0, bArr4, 0, 8);
                    System.arraycopy(bArr5, 8, bArr3, i8, 8);
                    i7--;
                    i4 = 8;
                }
                i6--;
                i4 = 8;
            }
        }
        if (i5 != 1) {
            if (!C6238Arrays.constantTimeAreEqual(bArr4, this.f20010iv)) {
                throw new InvalidCipherTextException("checksum failed");
            }
        } else if (!C6238Arrays.constantTimeAreEqual(bArr4, this.f20010iv)) {
            System.arraycopy(bArr, i, bArr4, 0, this.f20010iv.length);
            byte[] bArr7 = this.f20010iv;
            System.arraycopy(bArr, i + bArr7.length, bArr3, 0, i2 - bArr7.length);
            for (int i11 = 5; i11 >= 0; i11--) {
                System.arraycopy(bArr4, 0, bArr5, 0, this.f20010iv.length);
                System.arraycopy(bArr3, 0, bArr5, this.f20010iv.length, 8);
                int i12 = (i5 * i11) + 1;
                int i13 = 1;
                while (i12 != 0) {
                    int length2 = this.f20010iv.length - i13;
                    bArr5[length2] = (byte) (((byte) i12) ^ bArr5[length2]);
                    i12 >>>= 8;
                    i13++;
                }
                this.f20009engine.processBlock(bArr5, 0, bArr5, 0);
                System.arraycopy(bArr5, 0, bArr4, 0, 8);
                System.arraycopy(bArr5, 8, bArr3, 0, 8);
            }
            if (!C6238Arrays.constantTimeAreEqual(bArr4, this.f20010iv)) {
                throw new InvalidCipherTextException("checksum failed");
            }
        }
        return bArr3;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5283Wrapper
    /* renamed from: wrap */
    public byte[] mo14997wrap(byte[] bArr, int i, int i2) {
        if (!this.forWrapping) {
            throw new IllegalStateException("not set for wrapping");
        }
        if (i2 < 8) {
            throw new DataLengthException("wrap data must be at least 8 bytes");
        }
        int i3 = i2 / 8;
        if (i3 * 8 != i2) {
            throw new DataLengthException("wrap data must be a multiple of 8 bytes");
        }
        this.f20009engine.mo14946init(this.wrapCipherMode, this.f20011param);
        byte[] bArr2 = this.f20010iv;
        byte[] bArr3 = new byte[bArr2.length + i2];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, this.f20010iv.length, i2);
        if (i3 == 1) {
            this.f20009engine.processBlock(bArr3, 0, bArr3, 0);
        } else {
            byte[] bArr4 = new byte[this.f20010iv.length + 8];
            for (int i4 = 0; i4 != 6; i4++) {
                for (int i5 = 1; i5 <= i3; i5++) {
                    System.arraycopy(bArr3, 0, bArr4, 0, this.f20010iv.length);
                    int i6 = i5 * 8;
                    System.arraycopy(bArr3, i6, bArr4, this.f20010iv.length, 8);
                    this.f20009engine.processBlock(bArr4, 0, bArr4, 0);
                    int i7 = (i3 * i4) + i5;
                    int i8 = 1;
                    while (i7 != 0) {
                        int length = this.f20010iv.length - i8;
                        bArr4[length] = (byte) (((byte) i7) ^ bArr4[length]);
                        i7 >>>= 8;
                        i8++;
                    }
                    System.arraycopy(bArr4, 0, bArr3, 0, 8);
                    System.arraycopy(bArr4, 8, bArr3, i6, 8);
                }
            }
        }
        return bArr3;
    }

    public RFC3394WrapEngine(BlockCipher blockCipher, boolean z) {
        this.f20010iv = new byte[8];
        this.f20011param = null;
        this.forWrapping = true;
        this.f20009engine = blockCipher;
        this.wrapCipherMode = !z;
    }
}
