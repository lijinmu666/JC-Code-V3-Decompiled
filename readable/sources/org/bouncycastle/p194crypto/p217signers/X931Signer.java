package org.bouncycastle.p194crypto.p217signers;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.AsymmetricBlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.InterfaceC5282Signer;
import org.bouncycastle.p194crypto.p213params.RSAKeyParameters;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class X931Signer implements InterfaceC5282Signer {
    public static final int TRAILER_IMPLICIT = 188;
    public static final int TRAILER_RIPEMD128 = 13004;
    public static final int TRAILER_RIPEMD160 = 12748;
    public static final int TRAILER_SHA1 = 13260;
    public static final int TRAILER_SHA224 = 14540;
    public static final int TRAILER_SHA256 = 13516;
    public static final int TRAILER_SHA384 = 14028;
    public static final int TRAILER_SHA512 = 13772;
    public static final int TRAILER_WHIRLPOOL = 14284;

    /* renamed from: block */
    private byte[] f21049block;

    /* renamed from: cipher */
    private AsymmetricBlockCipher f21050cipher;

    /* renamed from: digest */
    private InterfaceC5277Digest f21051digest;

    /* renamed from: kParam */
    private RSAKeyParameters f21052kParam;

    /* renamed from: keyBits */
    private int f21053keyBits;

    /* renamed from: trailer */
    private int f21054trailer;

    public X931Signer(AsymmetricBlockCipher asymmetricBlockCipher, InterfaceC5277Digest interfaceC5277Digest) {
        this(asymmetricBlockCipher, interfaceC5277Digest, false);
    }

    private void clearBlock(byte[] bArr) {
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = 0;
        }
    }

    private void createSignatureBlock(int i) {
        int length;
        int digestSize = this.f21051digest.getDigestSize();
        if (i == 188) {
            byte[] bArr = this.f21049block;
            length = (bArr.length - digestSize) - 1;
            this.f21051digest.mo14967doFinal(bArr, length);
            this.f21049block[r5.length - 1] = PSSSigner.TRAILER_IMPLICIT;
        } else {
            byte[] bArr2 = this.f21049block;
            int length2 = (bArr2.length - digestSize) - 2;
            this.f21051digest.mo14967doFinal(bArr2, length2);
            byte[] bArr3 = this.f21049block;
            bArr3[bArr3.length - 2] = (byte) (i >>> 8);
            bArr3[bArr3.length - 1] = (byte) i;
            length = length2;
        }
        this.f21049block[0] = 107;
        for (int i2 = length - 2; i2 != 0; i2--) {
            this.f21049block[i2] = -69;
        }
        this.f21049block[length - 1] = -70;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public byte[] generateSignature() {
        createSignatureBlock(this.f21054trailer);
        AsymmetricBlockCipher asymmetricBlockCipher = this.f21050cipher;
        byte[] bArr = this.f21049block;
        BigInteger bigInteger = new BigInteger(1, asymmetricBlockCipher.processBlock(bArr, 0, bArr.length));
        clearBlock(this.f21049block);
        return BigIntegers.asUnsignedByteArray(BigIntegers.getUnsignedByteLength(this.f21052kParam.getModulus()), bigInteger.min(this.f21052kParam.getModulus().subtract(bigInteger)));
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: init */
    public void mo14987init(boolean z, CipherParameters cipherParameters) {
        RSAKeyParameters rSAKeyParameters = (RSAKeyParameters) cipherParameters;
        this.f21052kParam = rSAKeyParameters;
        this.f21050cipher.mo14943init(z, rSAKeyParameters);
        int iBitLength = this.f21052kParam.getModulus().bitLength();
        this.f21053keyBits = iBitLength;
        this.f21049block = new byte[(iBitLength + 7) / 8];
        mo14988reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: reset */
    public void mo14988reset() {
        this.f21051digest.mo14968reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14989update(byte b) {
        this.f21051digest.mo14969update(b);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002f A[PHI: r4
      0x002f: PHI (r4v3 java.math.BigInteger) = (r4v2 java.math.BigInteger), (r4v5 java.math.BigInteger) binds: [B:5:0x001a, B:8:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean verifySignature(byte[] bArr) {
        boolean zConstantTimeAreEqual = false;
        try {
            this.f21049block = this.f21050cipher.processBlock(bArr, 0, bArr.length);
            BigInteger bigInteger = new BigInteger(1, this.f21049block);
            if ((bigInteger.intValue() & 15) == 12) {
                createSignatureBlock(this.f21054trailer);
                byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(this.f21049block.length, bigInteger);
                zConstantTimeAreEqual = C6238Arrays.constantTimeAreEqual(this.f21049block, bArrAsUnsignedByteArray);
                if (this.f21054trailer == 15052 && !zConstantTimeAreEqual) {
                    byte[] bArr2 = this.f21049block;
                    bArr2[bArr2.length - 2] = 64;
                    zConstantTimeAreEqual = C6238Arrays.constantTimeAreEqual(bArr2, bArrAsUnsignedByteArray);
                }
                clearBlock(this.f21049block);
                clearBlock(bArrAsUnsignedByteArray);
            } else {
                bigInteger = this.f21052kParam.getModulus().subtract(bigInteger);
                if ((bigInteger.intValue() & 15) == 12) {
                }
            }
        } catch (Exception unused) {
        }
        return zConstantTimeAreEqual;
    }

    public X931Signer(AsymmetricBlockCipher asymmetricBlockCipher, InterfaceC5277Digest interfaceC5277Digest, boolean z) {
        int iIntValue;
        this.f21050cipher = asymmetricBlockCipher;
        this.f21051digest = interfaceC5277Digest;
        if (z) {
            iIntValue = 188;
        } else {
            Integer trailer = ISOTrailers.getTrailer(interfaceC5277Digest);
            if (trailer == null) {
                throw new IllegalArgumentException("no valid trailer for digest: " + interfaceC5277Digest.getAlgorithmName());
            }
            iIntValue = trailer.intValue();
        }
        this.f21054trailer = iIntValue;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14990update(byte[] bArr, int i, int i2) {
        this.f21051digest.mo14970update(bArr, i, i2);
    }
}
