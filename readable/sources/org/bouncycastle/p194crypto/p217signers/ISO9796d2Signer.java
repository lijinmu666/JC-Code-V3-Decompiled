package org.bouncycastle.p194crypto.p217signers;

import org.bouncycastle.p194crypto.AsymmetricBlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.SignerWithRecovery;
import org.bouncycastle.p194crypto.p213params.RSAKeyParameters;
import org.bouncycastle.p361util.C6238Arrays;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class ISO9796d2Signer implements SignerWithRecovery {
    public static final int TRAILER_IMPLICIT = 188;
    public static final int TRAILER_RIPEMD128 = 13004;
    public static final int TRAILER_RIPEMD160 = 12748;
    public static final int TRAILER_SHA1 = 13260;
    public static final int TRAILER_SHA256 = 13516;
    public static final int TRAILER_SHA384 = 14028;
    public static final int TRAILER_SHA512 = 13772;
    public static final int TRAILER_WHIRLPOOL = 14284;

    /* renamed from: block */
    private byte[] f21000block;

    /* renamed from: cipher */
    private AsymmetricBlockCipher f21001cipher;

    /* renamed from: digest */
    private InterfaceC5277Digest f21002digest;
    private boolean fullMessage;

    /* renamed from: keyBits */
    private int f21003keyBits;

    /* renamed from: mBuf */
    private byte[] f21004mBuf;
    private int messageLength;
    private byte[] preBlock;

    /* renamed from: preSig */
    private byte[] f21005preSig;
    private byte[] recoveredMessage;

    /* renamed from: trailer */
    private int f21006trailer;

    public ISO9796d2Signer(AsymmetricBlockCipher asymmetricBlockCipher, InterfaceC5277Digest interfaceC5277Digest) {
        this(asymmetricBlockCipher, interfaceC5277Digest, false);
    }

    private void clearBlock(byte[] bArr) {
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = 0;
        }
    }

    private boolean isSameAs(byte[] bArr, byte[] bArr2) {
        boolean z;
        int i = this.messageLength;
        byte[] bArr3 = this.f21004mBuf;
        if (i > bArr3.length) {
            z = bArr3.length <= bArr2.length;
            for (int i2 = 0; i2 != this.f21004mBuf.length; i2++) {
                if (bArr[i2] != bArr2[i2]) {
                    z = false;
                }
            }
        } else {
            z = i == bArr2.length;
            for (int i3 = 0; i3 != bArr2.length; i3++) {
                if (bArr[i3] != bArr2[i3]) {
                    z = false;
                }
            }
        }
        return z;
    }

    private boolean returnFalse(byte[] bArr) {
        this.messageLength = 0;
        clearBlock(this.f21004mBuf);
        clearBlock(bArr);
        return false;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public byte[] generateSignature() {
        int length;
        int i;
        int i2;
        int i3;
        int digestSize = this.f21002digest.getDigestSize();
        if (this.f21006trailer == 188) {
            byte[] bArr = this.f21000block;
            length = (bArr.length - digestSize) - 1;
            this.f21002digest.mo14967doFinal(bArr, length);
            byte[] bArr2 = this.f21000block;
            bArr2[bArr2.length - 1] = PSSSigner.TRAILER_IMPLICIT;
            i = 8;
        } else {
            byte[] bArr3 = this.f21000block;
            length = (bArr3.length - digestSize) - 2;
            this.f21002digest.mo14967doFinal(bArr3, length);
            byte[] bArr4 = this.f21000block;
            int length2 = bArr4.length - 2;
            int i4 = this.f21006trailer;
            bArr4[length2] = (byte) (i4 >>> 8);
            bArr4[bArr4.length - 1] = (byte) i4;
            i = 16;
        }
        int i5 = this.messageLength;
        int i6 = ((((digestSize + i5) * 8) + i) + 4) - this.f21003keyBits;
        if (i6 > 0) {
            int i7 = i5 - ((i6 + 7) / 8);
            i2 = length - i7;
            System.arraycopy(this.f21004mBuf, 0, this.f21000block, i2, i7);
            this.recoveredMessage = new byte[i7];
            i3 = 96;
        } else {
            i2 = length - i5;
            System.arraycopy(this.f21004mBuf, 0, this.f21000block, i2, i5);
            this.recoveredMessage = new byte[this.messageLength];
            i3 = 64;
        }
        int i8 = i2 - 1;
        if (i8 > 0) {
            for (int i9 = i8; i9 != 0; i9--) {
                this.f21000block[i9] = -69;
            }
            byte[] bArr5 = this.f21000block;
            bArr5[i8] = (byte) (bArr5[i8] ^ 1);
            bArr5[0] = 11;
            bArr5[0] = (byte) (11 | i3);
        } else {
            byte[] bArr6 = this.f21000block;
            bArr6[0] = 10;
            bArr6[0] = (byte) (10 | i3);
        }
        AsymmetricBlockCipher asymmetricBlockCipher = this.f21001cipher;
        byte[] bArr7 = this.f21000block;
        byte[] bArrProcessBlock = asymmetricBlockCipher.processBlock(bArr7, 0, bArr7.length);
        this.fullMessage = (i3 & 32) == 0;
        byte[] bArr8 = this.f21004mBuf;
        byte[] bArr9 = this.recoveredMessage;
        System.arraycopy(bArr8, 0, bArr9, 0, bArr9.length);
        this.messageLength = 0;
        clearBlock(this.f21004mBuf);
        clearBlock(this.f21000block);
        return bArrProcessBlock;
    }

    @Override // org.bouncycastle.p194crypto.SignerWithRecovery
    public byte[] getRecoveredMessage() {
        return this.recoveredMessage;
    }

    @Override // org.bouncycastle.p194crypto.SignerWithRecovery
    public boolean hasFullMessage() {
        return this.fullMessage;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: init */
    public void mo14987init(boolean z, CipherParameters cipherParameters) {
        RSAKeyParameters rSAKeyParameters = (RSAKeyParameters) cipherParameters;
        this.f21001cipher.mo14943init(z, rSAKeyParameters);
        int iBitLength = rSAKeyParameters.getModulus().bitLength();
        this.f21003keyBits = iBitLength;
        byte[] bArr = new byte[(iBitLength + 7) / 8];
        this.f21000block = bArr;
        int i = this.f21006trailer;
        int length = bArr.length;
        if (i == 188) {
            this.f21004mBuf = new byte[(length - this.f21002digest.getDigestSize()) - 2];
        } else {
            this.f21004mBuf = new byte[(length - this.f21002digest.getDigestSize()) - 3];
        }
        mo14988reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: reset */
    public void mo14988reset() {
        this.f21002digest.mo14968reset();
        this.messageLength = 0;
        clearBlock(this.f21004mBuf);
        byte[] bArr = this.recoveredMessage;
        if (bArr != null) {
            clearBlock(bArr);
        }
        this.recoveredMessage = null;
        this.fullMessage = false;
        if (this.f21005preSig != null) {
            this.f21005preSig = null;
            clearBlock(this.preBlock);
            this.preBlock = null;
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14989update(byte b) {
        this.f21002digest.mo14969update(b);
        int i = this.messageLength;
        byte[] bArr = this.f21004mBuf;
        if (i < bArr.length) {
            bArr[i] = b;
        }
        this.messageLength = i + 1;
    }

    @Override // org.bouncycastle.p194crypto.SignerWithRecovery
    public void updateWithRecoveredMessage(byte[] bArr) throws InvalidCipherTextException {
        int i;
        byte[] bArrProcessBlock = this.f21001cipher.processBlock(bArr, 0, bArr.length);
        if (((bArrProcessBlock[0] & 192) ^ 64) != 0) {
            throw new InvalidCipherTextException("malformed signature");
        }
        if (((bArrProcessBlock[bArrProcessBlock.length - 1] & 15) ^ 12) != 0) {
            throw new InvalidCipherTextException("malformed signature");
        }
        if (((bArrProcessBlock[bArrProcessBlock.length - 1] & C1126UByte.MAX_VALUE) ^ 188) == 0) {
            i = 1;
        } else {
            i = 2;
            int i2 = ((bArrProcessBlock[bArrProcessBlock.length - 2] & C1126UByte.MAX_VALUE) << 8) | (bArrProcessBlock[bArrProcessBlock.length - 1] & C1126UByte.MAX_VALUE);
            Integer trailer = ISOTrailers.getTrailer(this.f21002digest);
            if (trailer == null) {
                throw new IllegalArgumentException("unrecognised hash in signature");
            }
            int iIntValue = trailer.intValue();
            if (i2 != iIntValue && (iIntValue != 15052 || i2 != 16588)) {
                throw new IllegalStateException("signer initialised with wrong digest for trailer " + i2);
            }
        }
        int i3 = 0;
        while (i3 != bArrProcessBlock.length && ((bArrProcessBlock[i3] & 15) ^ 10) != 0) {
            i3++;
        }
        int i4 = i3 + 1;
        int length = ((bArrProcessBlock.length - i) - this.f21002digest.getDigestSize()) - i4;
        if (length <= 0) {
            throw new InvalidCipherTextException("malformed block");
        }
        if ((bArrProcessBlock[0] & 32) == 0) {
            this.fullMessage = true;
            byte[] bArr2 = new byte[length];
            this.recoveredMessage = bArr2;
            System.arraycopy(bArrProcessBlock, i4, bArr2, 0, bArr2.length);
        } else {
            this.fullMessage = false;
            byte[] bArr3 = new byte[length];
            this.recoveredMessage = bArr3;
            System.arraycopy(bArrProcessBlock, i4, bArr3, 0, bArr3.length);
        }
        this.f21005preSig = bArr;
        this.preBlock = bArrProcessBlock;
        InterfaceC5277Digest interfaceC5277Digest = this.f21002digest;
        byte[] bArr4 = this.recoveredMessage;
        interfaceC5277Digest.mo14970update(bArr4, 0, bArr4.length);
        byte[] bArr5 = this.recoveredMessage;
        this.messageLength = bArr5.length;
        System.arraycopy(bArr5, 0, this.f21004mBuf, 0, bArr5.length);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public boolean verifySignature(byte[] bArr) {
        byte[] bArrProcessBlock;
        int i;
        byte[] bArr2 = this.f21005preSig;
        if (bArr2 == null) {
            try {
                bArrProcessBlock = this.f21001cipher.processBlock(bArr, 0, bArr.length);
            } catch (Exception unused) {
                return false;
            }
        } else {
            if (!C6238Arrays.areEqual(bArr2, bArr)) {
                throw new IllegalStateException("updateWithRecoveredMessage called on different signature");
            }
            bArrProcessBlock = this.preBlock;
            this.f21005preSig = null;
            this.preBlock = null;
        }
        if (((bArrProcessBlock[0] & 192) ^ 64) == 0 && ((bArrProcessBlock[bArrProcessBlock.length - 1] & 15) ^ 12) == 0) {
            if (((bArrProcessBlock[bArrProcessBlock.length - 1] & C1126UByte.MAX_VALUE) ^ 188) == 0) {
                i = 1;
            } else {
                i = 2;
                int i2 = ((bArrProcessBlock[bArrProcessBlock.length - 2] & C1126UByte.MAX_VALUE) << 8) | (bArrProcessBlock[bArrProcessBlock.length - 1] & C1126UByte.MAX_VALUE);
                Integer trailer = ISOTrailers.getTrailer(this.f21002digest);
                if (trailer == null) {
                    throw new IllegalArgumentException("unrecognised hash in signature");
                }
                int iIntValue = trailer.intValue();
                if (i2 != iIntValue && (iIntValue != 15052 || i2 != 16588)) {
                    throw new IllegalStateException("signer initialised with wrong digest for trailer " + i2);
                }
            }
            int i3 = 0;
            while (i3 != bArrProcessBlock.length && ((bArrProcessBlock[i3] & 15) ^ 10) != 0) {
                i3++;
            }
            int i4 = i3 + 1;
            int digestSize = this.f21002digest.getDigestSize();
            byte[] bArr3 = new byte[digestSize];
            int length = (bArrProcessBlock.length - i) - digestSize;
            int i5 = length - i4;
            if (i5 <= 0) {
                return returnFalse(bArrProcessBlock);
            }
            if ((bArrProcessBlock[0] & 32) == 0) {
                this.fullMessage = true;
                if (this.messageLength > i5) {
                    return returnFalse(bArrProcessBlock);
                }
                this.f21002digest.mo14968reset();
                this.f21002digest.mo14970update(bArrProcessBlock, i4, i5);
                this.f21002digest.mo14967doFinal(bArr3, 0);
                boolean z = true;
                for (int i6 = 0; i6 != digestSize; i6++) {
                    int i7 = length + i6;
                    byte b = (byte) (bArrProcessBlock[i7] ^ bArr3[i6]);
                    bArrProcessBlock[i7] = b;
                    if (b != 0) {
                        z = false;
                    }
                }
                if (!z) {
                    return returnFalse(bArrProcessBlock);
                }
                byte[] bArr4 = new byte[i5];
                this.recoveredMessage = bArr4;
                System.arraycopy(bArrProcessBlock, i4, bArr4, 0, bArr4.length);
            } else {
                this.fullMessage = false;
                this.f21002digest.mo14967doFinal(bArr3, 0);
                boolean z2 = true;
                for (int i8 = 0; i8 != digestSize; i8++) {
                    int i9 = length + i8;
                    byte b2 = (byte) (bArrProcessBlock[i9] ^ bArr3[i8]);
                    bArrProcessBlock[i9] = b2;
                    if (b2 != 0) {
                        z2 = false;
                    }
                }
                if (!z2) {
                    return returnFalse(bArrProcessBlock);
                }
                byte[] bArr5 = new byte[i5];
                this.recoveredMessage = bArr5;
                System.arraycopy(bArrProcessBlock, i4, bArr5, 0, bArr5.length);
            }
            if (this.messageLength != 0 && !isSameAs(this.f21004mBuf, this.recoveredMessage)) {
                return returnFalse(bArrProcessBlock);
            }
            clearBlock(this.f21004mBuf);
            clearBlock(bArrProcessBlock);
            this.messageLength = 0;
            return true;
        }
        return returnFalse(bArrProcessBlock);
    }

    public ISO9796d2Signer(AsymmetricBlockCipher asymmetricBlockCipher, InterfaceC5277Digest interfaceC5277Digest, boolean z) {
        int iIntValue;
        this.f21001cipher = asymmetricBlockCipher;
        this.f21002digest = interfaceC5277Digest;
        if (z) {
            iIntValue = 188;
        } else {
            Integer trailer = ISOTrailers.getTrailer(interfaceC5277Digest);
            if (trailer == null) {
                throw new IllegalArgumentException("no valid trailer for digest: " + interfaceC5277Digest.getAlgorithmName());
            }
            iIntValue = trailer.intValue();
        }
        this.f21006trailer = iIntValue;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14990update(byte[] bArr, int i, int i2) {
        while (i2 > 0 && this.messageLength < this.f21004mBuf.length) {
            mo14989update(bArr[i]);
            i++;
            i2--;
        }
        this.f21002digest.mo14970update(bArr, i, i2);
        this.messageLength += i2;
    }
}
