package org.bouncycastle.p194crypto.p217signers;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricBlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.SignerWithRecovery;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p194crypto.p213params.ParametersWithSalt;
import org.bouncycastle.p194crypto.p213params.RSAKeyParameters;
import org.bouncycastle.p361util.C6238Arrays;
import p094kotlin.C1126UByte;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* loaded from: classes2.dex */
public class ISO9796d2PSSSigner implements SignerWithRecovery {
    public static final int TRAILER_IMPLICIT = 188;
    public static final int TRAILER_RIPEMD128 = 13004;
    public static final int TRAILER_RIPEMD160 = 12748;
    public static final int TRAILER_SHA1 = 13260;
    public static final int TRAILER_SHA256 = 13516;
    public static final int TRAILER_SHA384 = 14028;
    public static final int TRAILER_SHA512 = 13772;
    public static final int TRAILER_WHIRLPOOL = 14284;

    /* renamed from: block */
    private byte[] f20991block;

    /* renamed from: cipher */
    private AsymmetricBlockCipher f20992cipher;

    /* renamed from: digest */
    private InterfaceC5277Digest f20993digest;
    private boolean fullMessage;

    /* renamed from: hLen */
    private int f20994hLen;

    /* renamed from: keyBits */
    private int f20995keyBits;

    /* renamed from: mBuf */
    private byte[] f20996mBuf;
    private int messageLength;
    private byte[] preBlock;
    private int preMStart;

    /* renamed from: preSig */
    private byte[] f20997preSig;
    private int preTLength;

    /* renamed from: random */
    private SecureRandom f20998random;
    private byte[] recoveredMessage;
    private int saltLength;
    private byte[] standardSalt;

    /* renamed from: trailer */
    private int f20999trailer;

    public ISO9796d2PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, InterfaceC5277Digest interfaceC5277Digest, int i) {
        this(asymmetricBlockCipher, interfaceC5277Digest, i, false);
    }

    /* renamed from: ItoOSP */
    private void m15861ItoOSP(int i, byte[] bArr) {
        bArr[0] = (byte) (i >>> 24);
        bArr[1] = (byte) (i >>> 16);
        bArr[2] = (byte) (i >>> 8);
        bArr[3] = (byte) i;
    }

    /* renamed from: LtoOSP */
    private void m15862LtoOSP(long j, byte[] bArr) {
        bArr[0] = (byte) (j >>> 56);
        bArr[1] = (byte) (j >>> 48);
        bArr[2] = (byte) (j >>> 40);
        bArr[3] = (byte) (j >>> 32);
        bArr[4] = (byte) (j >>> 24);
        bArr[5] = (byte) (j >>> 16);
        bArr[6] = (byte) (j >>> 8);
        bArr[7] = (byte) j;
    }

    private void clearBlock(byte[] bArr) {
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = 0;
        }
    }

    private boolean isSameAs(byte[] bArr, byte[] bArr2) {
        boolean z = this.messageLength == bArr2.length;
        for (int i = 0; i != bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                z = false;
            }
        }
        return z;
    }

    private byte[] maskGeneratorFunction1(byte[] bArr, int i, int i2, int i3) {
        int i4;
        byte[] bArr2 = new byte[i3];
        byte[] bArr3 = new byte[this.f20994hLen];
        byte[] bArr4 = new byte[4];
        this.f20993digest.mo14968reset();
        int i5 = 0;
        while (true) {
            i4 = this.f20994hLen;
            if (i5 >= i3 / i4) {
                break;
            }
            m15861ItoOSP(i5, bArr4);
            this.f20993digest.mo14970update(bArr, i, i2);
            this.f20993digest.mo14970update(bArr4, 0, 4);
            this.f20993digest.mo14967doFinal(bArr3, 0);
            int i6 = this.f20994hLen;
            System.arraycopy(bArr3, 0, bArr2, i5 * i6, i6);
            i5++;
        }
        if (i4 * i5 < i3) {
            m15861ItoOSP(i5, bArr4);
            this.f20993digest.mo14970update(bArr, i, i2);
            this.f20993digest.mo14970update(bArr4, 0, 4);
            this.f20993digest.mo14967doFinal(bArr3, 0);
            int i7 = this.f20994hLen;
            System.arraycopy(bArr3, 0, bArr2, i5 * i7, i3 - (i5 * i7));
        }
        return bArr2;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public byte[] generateSignature() {
        int digestSize = this.f20993digest.getDigestSize();
        byte[] bArr = new byte[digestSize];
        this.f20993digest.mo14967doFinal(bArr, 0);
        byte[] bArr2 = new byte[8];
        m15862LtoOSP(this.messageLength * 8, bArr2);
        this.f20993digest.mo14970update(bArr2, 0, 8);
        this.f20993digest.mo14970update(this.f20996mBuf, 0, this.messageLength);
        this.f20993digest.mo14970update(bArr, 0, digestSize);
        byte[] bArr3 = this.standardSalt;
        if (bArr3 == null) {
            bArr3 = new byte[this.saltLength];
            this.f20998random.nextBytes(bArr3);
        }
        this.f20993digest.mo14970update(bArr3, 0, bArr3.length);
        int digestSize2 = this.f20993digest.getDigestSize();
        byte[] bArr4 = new byte[digestSize2];
        this.f20993digest.mo14967doFinal(bArr4, 0);
        int i = this.f20999trailer == 188 ? 1 : 2;
        byte[] bArr5 = this.f20991block;
        int length = bArr5.length;
        int i2 = this.messageLength;
        int length2 = (((length - i2) - bArr3.length) - this.f20994hLen) - i;
        bArr5[length2 - 1] = 1;
        System.arraycopy(this.f20996mBuf, 0, bArr5, length2, i2);
        System.arraycopy(bArr3, 0, this.f20991block, length2 + this.messageLength, bArr3.length);
        byte[] bArrMaskGeneratorFunction1 = maskGeneratorFunction1(bArr4, 0, digestSize2, (this.f20991block.length - this.f20994hLen) - i);
        for (int i3 = 0; i3 != bArrMaskGeneratorFunction1.length; i3++) {
            byte[] bArr6 = this.f20991block;
            bArr6[i3] = (byte) (bArr6[i3] ^ bArrMaskGeneratorFunction1[i3]);
        }
        byte[] bArr7 = this.f20991block;
        int length3 = bArr7.length;
        int i4 = this.f20994hLen;
        System.arraycopy(bArr4, 0, bArr7, (length3 - i4) - i, i4);
        int i5 = this.f20999trailer;
        if (i5 == 188) {
            byte[] bArr8 = this.f20991block;
            bArr8[bArr8.length - 1] = PSSSigner.TRAILER_IMPLICIT;
        } else {
            byte[] bArr9 = this.f20991block;
            bArr9[bArr9.length - 2] = (byte) (i5 >>> 8);
            bArr9[bArr9.length - 1] = (byte) i5;
        }
        byte[] bArr10 = this.f20991block;
        bArr10[0] = (byte) (bArr10[0] & ByteCompanionObject.MAX_VALUE);
        byte[] bArrProcessBlock = this.f20992cipher.processBlock(bArr10, 0, bArr10.length);
        int i6 = this.messageLength;
        byte[] bArr11 = new byte[i6];
        this.recoveredMessage = bArr11;
        byte[] bArr12 = this.f20996mBuf;
        this.fullMessage = i6 <= bArr12.length;
        System.arraycopy(bArr12, 0, bArr11, 0, bArr11.length);
        clearBlock(this.f20996mBuf);
        clearBlock(this.f20991block);
        this.messageLength = 0;
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

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016 A[PHI: r1
      0x0016: PHI (r1v6 org.bouncycastle.crypto.params.RSAKeyParameters) = (r1v3 org.bouncycastle.crypto.params.RSAKeyParameters), (r1v11 org.bouncycastle.crypto.params.RSAKeyParameters) binds: [B:17:0x0043, B:5:0x000f] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: init */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo14987init(boolean z, CipherParameters cipherParameters) {
        RSAKeyParameters rSAKeyParameters;
        SecureRandom secureRandom;
        int length = this.saltLength;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            rSAKeyParameters = (RSAKeyParameters) parametersWithRandom.getParameters();
            secureRandom = z ? parametersWithRandom.getRandom() : null;
            this.f20998random = secureRandom;
            this.standardSalt = null;
        } else if (cipherParameters instanceof ParametersWithSalt) {
            ParametersWithSalt parametersWithSalt = (ParametersWithSalt) cipherParameters;
            rSAKeyParameters = (RSAKeyParameters) parametersWithSalt.getParameters();
            this.f20998random = null;
            byte[] bArrM15803getSalt = parametersWithSalt.m15803getSalt();
            this.standardSalt = bArrM15803getSalt;
            length = bArrM15803getSalt.length;
            if (bArrM15803getSalt.length != this.saltLength) {
                throw new IllegalArgumentException("Fixed salt is of wrong length");
            }
        } else {
            rSAKeyParameters = (RSAKeyParameters) cipherParameters;
            if (z) {
                secureRandom = CryptoServicesRegistrar.getSecureRandom();
            }
            this.f20998random = secureRandom;
            this.standardSalt = null;
        }
        this.f20992cipher.mo14943init(z, rSAKeyParameters);
        int iBitLength = rSAKeyParameters.getModulus().bitLength();
        this.f20995keyBits = iBitLength;
        byte[] bArr = new byte[(iBitLength + 7) / 8];
        this.f20991block = bArr;
        int i = this.f20999trailer;
        int length2 = bArr.length;
        if (i == 188) {
            this.f20996mBuf = new byte[((length2 - this.f20993digest.getDigestSize()) - length) - 2];
        } else {
            this.f20996mBuf = new byte[((length2 - this.f20993digest.getDigestSize()) - length) - 3];
        }
        mo14988reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: reset */
    public void mo14988reset() {
        this.f20993digest.mo14968reset();
        this.messageLength = 0;
        byte[] bArr = this.f20996mBuf;
        if (bArr != null) {
            clearBlock(bArr);
        }
        byte[] bArr2 = this.recoveredMessage;
        if (bArr2 != null) {
            clearBlock(bArr2);
            this.recoveredMessage = null;
        }
        this.fullMessage = false;
        if (this.f20997preSig != null) {
            this.f20997preSig = null;
            clearBlock(this.preBlock);
            this.preBlock = null;
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14989update(byte b) {
        if (this.f20997preSig == null) {
            int i = this.messageLength;
            byte[] bArr = this.f20996mBuf;
            if (i < bArr.length) {
                this.messageLength = i + 1;
                bArr[i] = b;
                return;
            }
        }
        this.f20993digest.mo14969update(b);
    }

    @Override // org.bouncycastle.p194crypto.SignerWithRecovery
    public void updateWithRecoveredMessage(byte[] bArr) {
        int i;
        byte[] bArrProcessBlock = this.f20992cipher.processBlock(bArr, 0, bArr.length);
        int length = bArrProcessBlock.length;
        int i2 = this.f20995keyBits;
        if (length < (i2 + 7) / 8) {
            int i3 = (i2 + 7) / 8;
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArrProcessBlock, 0, bArr2, i3 - bArrProcessBlock.length, bArrProcessBlock.length);
            clearBlock(bArrProcessBlock);
            bArrProcessBlock = bArr2;
        }
        if (((bArrProcessBlock[bArrProcessBlock.length - 1] & C1126UByte.MAX_VALUE) ^ 188) == 0) {
            i = 1;
        } else {
            i = 2;
            int i4 = ((bArrProcessBlock[bArrProcessBlock.length - 2] & C1126UByte.MAX_VALUE) << 8) | (bArrProcessBlock[bArrProcessBlock.length - 1] & C1126UByte.MAX_VALUE);
            Integer trailer = ISOTrailers.getTrailer(this.f20993digest);
            if (trailer == null) {
                throw new IllegalArgumentException("unrecognised hash in signature");
            }
            int iIntValue = trailer.intValue();
            if (i4 != iIntValue && (iIntValue != 15052 || i4 != 16588)) {
                throw new IllegalStateException("signer initialised with wrong digest for trailer " + i4);
            }
        }
        this.f20993digest.mo14967doFinal(new byte[this.f20994hLen], 0);
        int length2 = bArrProcessBlock.length;
        int i5 = this.f20994hLen;
        byte[] bArrMaskGeneratorFunction1 = maskGeneratorFunction1(bArrProcessBlock, (length2 - i5) - i, i5, (bArrProcessBlock.length - i5) - i);
        for (int i6 = 0; i6 != bArrMaskGeneratorFunction1.length; i6++) {
            bArrProcessBlock[i6] = (byte) (bArrProcessBlock[i6] ^ bArrMaskGeneratorFunction1[i6]);
        }
        bArrProcessBlock[0] = (byte) (bArrProcessBlock[0] & ByteCompanionObject.MAX_VALUE);
        int i7 = 0;
        while (i7 != bArrProcessBlock.length && bArrProcessBlock[i7] != 1) {
            i7++;
        }
        int i8 = i7 + 1;
        if (i8 >= bArrProcessBlock.length) {
            clearBlock(bArrProcessBlock);
        }
        this.fullMessage = i8 > 1;
        byte[] bArr3 = new byte[(bArrMaskGeneratorFunction1.length - i8) - this.saltLength];
        this.recoveredMessage = bArr3;
        System.arraycopy(bArrProcessBlock, i8, bArr3, 0, bArr3.length);
        byte[] bArr4 = this.recoveredMessage;
        System.arraycopy(bArr4, 0, this.f20996mBuf, 0, bArr4.length);
        this.f20997preSig = bArr;
        this.preBlock = bArrProcessBlock;
        this.preMStart = i8;
        this.preTLength = i;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public boolean verifySignature(byte[] bArr) {
        int i = this.f20994hLen;
        byte[] bArr2 = new byte[i];
        this.f20993digest.mo14967doFinal(bArr2, 0);
        byte[] bArr3 = this.f20997preSig;
        if (bArr3 == null) {
            try {
                updateWithRecoveredMessage(bArr);
            } catch (Exception unused) {
                return false;
            }
        } else if (!C6238Arrays.areEqual(bArr3, bArr)) {
            throw new IllegalStateException("updateWithRecoveredMessage called on different signature");
        }
        byte[] bArr4 = this.preBlock;
        int i2 = this.preMStart;
        int i3 = this.preTLength;
        this.f20997preSig = null;
        this.preBlock = null;
        byte[] bArr5 = new byte[8];
        m15862LtoOSP(this.recoveredMessage.length * 8, bArr5);
        this.f20993digest.mo14970update(bArr5, 0, 8);
        byte[] bArr6 = this.recoveredMessage;
        if (bArr6.length != 0) {
            this.f20993digest.mo14970update(bArr6, 0, bArr6.length);
        }
        this.f20993digest.mo14970update(bArr2, 0, i);
        byte[] bArr7 = this.standardSalt;
        if (bArr7 != null) {
            this.f20993digest.mo14970update(bArr7, 0, bArr7.length);
        } else {
            this.f20993digest.mo14970update(bArr4, i2 + this.recoveredMessage.length, this.saltLength);
        }
        int digestSize = this.f20993digest.getDigestSize();
        byte[] bArr8 = new byte[digestSize];
        this.f20993digest.mo14967doFinal(bArr8, 0);
        int length = (bArr4.length - i3) - digestSize;
        boolean z = true;
        for (int i4 = 0; i4 != digestSize; i4++) {
            if (bArr8[i4] != bArr4[length + i4]) {
                z = false;
            }
        }
        clearBlock(bArr4);
        clearBlock(bArr8);
        if (!z) {
            this.fullMessage = false;
            this.messageLength = 0;
            clearBlock(this.recoveredMessage);
            return false;
        }
        if (this.messageLength == 0 || isSameAs(this.f20996mBuf, this.recoveredMessage)) {
            this.messageLength = 0;
            clearBlock(this.f20996mBuf);
            return true;
        }
        this.messageLength = 0;
        clearBlock(this.f20996mBuf);
        return false;
    }

    public ISO9796d2PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, InterfaceC5277Digest interfaceC5277Digest, int i, boolean z) {
        int iIntValue;
        this.f20992cipher = asymmetricBlockCipher;
        this.f20993digest = interfaceC5277Digest;
        this.f20994hLen = interfaceC5277Digest.getDigestSize();
        this.saltLength = i;
        if (z) {
            iIntValue = 188;
        } else {
            Integer trailer = ISOTrailers.getTrailer(interfaceC5277Digest);
            if (trailer == null) {
                throw new IllegalArgumentException("no valid trailer for digest: " + interfaceC5277Digest.getAlgorithmName());
            }
            iIntValue = trailer.intValue();
        }
        this.f20999trailer = iIntValue;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14990update(byte[] bArr, int i, int i2) {
        if (this.f20997preSig == null) {
            while (i2 > 0 && this.messageLength < this.f20996mBuf.length) {
                mo14989update(bArr[i]);
                i++;
                i2--;
            }
        }
        if (i2 > 0) {
            this.f20993digest.mo14970update(bArr, i, i2);
        }
    }
}
