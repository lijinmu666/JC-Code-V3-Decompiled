package org.bouncycastle.p194crypto.p217signers;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricBlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.InterfaceC5282Signer;
import org.bouncycastle.p194crypto.InterfaceC5284Xof;
import org.bouncycastle.p194crypto.p199digests.C5294Prehash;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p194crypto.p213params.RSABlindingParameters;
import org.bouncycastle.p194crypto.p213params.RSAKeyParameters;
import org.bouncycastle.p361util.C6238Arrays;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class PSSSigner implements InterfaceC5282Signer {
    public static final byte TRAILER_IMPLICIT = -68;

    /* renamed from: block */
    private byte[] f21017block;

    /* renamed from: cipher */
    private AsymmetricBlockCipher f21018cipher;
    private InterfaceC5277Digest contentDigest1;
    private InterfaceC5277Digest contentDigest2;

    /* renamed from: emBits */
    private int f21019emBits;

    /* renamed from: hLen */
    private int f21020hLen;

    /* renamed from: mDash */
    private byte[] f21021mDash;
    private InterfaceC5277Digest mgfDigest;

    /* renamed from: mgfhLen */
    private int f21022mgfhLen;

    /* renamed from: random */
    private SecureRandom f21023random;

    /* renamed from: sLen */
    private int f21024sLen;

    /* renamed from: sSet */
    private boolean f21025sSet;

    /* renamed from: salt */
    private byte[] f21026salt;

    /* renamed from: trailer */
    private byte f21027trailer;

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, InterfaceC5277Digest interfaceC5277Digest, int i) {
        this(asymmetricBlockCipher, interfaceC5277Digest, i, TRAILER_IMPLICIT);
    }

    /* renamed from: ItoOSP */
    private void m15863ItoOSP(int i, byte[] bArr) {
        bArr[0] = (byte) (i >>> 24);
        bArr[1] = (byte) (i >>> 16);
        bArr[2] = (byte) (i >>> 8);
        bArr[3] = (byte) i;
    }

    private void clearBlock(byte[] bArr) {
        for (int i = 0; i != bArr.length; i++) {
            bArr[i] = 0;
        }
    }

    public static PSSSigner createRawSigner(AsymmetricBlockCipher asymmetricBlockCipher, InterfaceC5277Digest interfaceC5277Digest) {
        return new PSSSigner(asymmetricBlockCipher, C5294Prehash.forDigest(interfaceC5277Digest), interfaceC5277Digest, interfaceC5277Digest, interfaceC5277Digest.getDigestSize(), TRAILER_IMPLICIT);
    }

    private byte[] maskGenerator(byte[] bArr, int i, int i2, int i3) {
        InterfaceC5277Digest interfaceC5277Digest = this.mgfDigest;
        if (!(interfaceC5277Digest instanceof InterfaceC5284Xof)) {
            return maskGeneratorFunction1(bArr, i, i2, i3);
        }
        byte[] bArr2 = new byte[i3];
        interfaceC5277Digest.mo14970update(bArr, i, i2);
        ((InterfaceC5284Xof) this.mgfDigest).mo14998doFinal(bArr2, 0, i3);
        return bArr2;
    }

    private byte[] maskGeneratorFunction1(byte[] bArr, int i, int i2, int i3) {
        int i4;
        byte[] bArr2 = new byte[i3];
        byte[] bArr3 = new byte[this.f21022mgfhLen];
        byte[] bArr4 = new byte[4];
        this.mgfDigest.mo14968reset();
        int i5 = 0;
        while (true) {
            i4 = this.f21022mgfhLen;
            if (i5 >= i3 / i4) {
                break;
            }
            m15863ItoOSP(i5, bArr4);
            this.mgfDigest.mo14970update(bArr, i, i2);
            this.mgfDigest.mo14970update(bArr4, 0, 4);
            this.mgfDigest.mo14967doFinal(bArr3, 0);
            int i6 = this.f21022mgfhLen;
            System.arraycopy(bArr3, 0, bArr2, i5 * i6, i6);
            i5++;
        }
        if (i4 * i5 < i3) {
            m15863ItoOSP(i5, bArr4);
            this.mgfDigest.mo14970update(bArr, i, i2);
            this.mgfDigest.mo14970update(bArr4, 0, 4);
            this.mgfDigest.mo14967doFinal(bArr3, 0);
            int i7 = this.f21022mgfhLen;
            System.arraycopy(bArr3, 0, bArr2, i5 * i7, i3 - (i5 * i7));
        }
        return bArr2;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public byte[] generateSignature() {
        int digestSize = this.contentDigest1.getDigestSize();
        int i = this.f21020hLen;
        if (digestSize != i) {
            throw new IllegalStateException();
        }
        InterfaceC5277Digest interfaceC5277Digest = this.contentDigest1;
        byte[] bArr = this.f21021mDash;
        interfaceC5277Digest.mo14967doFinal(bArr, (bArr.length - i) - this.f21024sLen);
        if (this.f21024sLen != 0) {
            if (!this.f21025sSet) {
                this.f21023random.nextBytes(this.f21026salt);
            }
            byte[] bArr2 = this.f21026salt;
            byte[] bArr3 = this.f21021mDash;
            int length = bArr3.length;
            int i2 = this.f21024sLen;
            System.arraycopy(bArr2, 0, bArr3, length - i2, i2);
        }
        int i3 = this.f21020hLen;
        byte[] bArr4 = new byte[i3];
        InterfaceC5277Digest interfaceC5277Digest2 = this.contentDigest2;
        byte[] bArr5 = this.f21021mDash;
        interfaceC5277Digest2.mo14970update(bArr5, 0, bArr5.length);
        this.contentDigest2.mo14967doFinal(bArr4, 0);
        byte[] bArr6 = this.f21017block;
        int length2 = bArr6.length;
        int i4 = this.f21024sLen;
        int i5 = this.f21020hLen;
        bArr6[(((length2 - i4) - 1) - i5) - 1] = 1;
        System.arraycopy(this.f21026salt, 0, bArr6, ((bArr6.length - i4) - i5) - 1, i4);
        byte[] bArrMaskGenerator = maskGenerator(bArr4, 0, i3, (this.f21017block.length - this.f21020hLen) - 1);
        for (int i6 = 0; i6 != bArrMaskGenerator.length; i6++) {
            byte[] bArr7 = this.f21017block;
            bArr7[i6] = (byte) (bArr7[i6] ^ bArrMaskGenerator[i6]);
        }
        byte[] bArr8 = this.f21017block;
        int length3 = bArr8.length;
        int i7 = this.f21020hLen;
        System.arraycopy(bArr4, 0, bArr8, (length3 - i7) - 1, i7);
        byte[] bArr9 = this.f21017block;
        bArr9[0] = (byte) ((255 >>> ((bArr9.length * 8) - this.f21019emBits)) & bArr9[0]);
        bArr9[bArr9.length - 1] = this.f21027trailer;
        byte[] bArrProcessBlock = this.f21018cipher.processBlock(bArr9, 0, bArr9.length);
        clearBlock(this.f21017block);
        return bArrProcessBlock;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: init */
    public void mo14987init(boolean z, CipherParameters cipherParameters) {
        CipherParameters parameters;
        RSAKeyParameters publicKey;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            parameters = parametersWithRandom.getParameters();
            this.f21023random = parametersWithRandom.getRandom();
        } else {
            if (z) {
                this.f21023random = CryptoServicesRegistrar.getSecureRandom();
            }
            parameters = cipherParameters;
        }
        if (parameters instanceof RSABlindingParameters) {
            publicKey = ((RSABlindingParameters) parameters).getPublicKey();
            this.f21018cipher.mo14943init(z, cipherParameters);
        } else {
            publicKey = (RSAKeyParameters) parameters;
            this.f21018cipher.mo14943init(z, parameters);
        }
        int iBitLength = publicKey.getModulus().bitLength();
        int i = iBitLength - 1;
        this.f21019emBits = i;
        if (i < (this.f21020hLen * 8) + (this.f21024sLen * 8) + 9) {
            throw new IllegalArgumentException("key too small for specified hash and salt lengths");
        }
        this.f21017block = new byte[(iBitLength + 6) / 8];
        mo14988reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: reset */
    public void mo14988reset() {
        this.contentDigest1.mo14968reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14989update(byte b) {
        this.contentDigest1.mo14969update(b);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public boolean verifySignature(byte[] bArr) {
        byte[] bArr2;
        int length;
        byte b;
        int digestSize = this.contentDigest1.getDigestSize();
        int i = this.f21020hLen;
        if (digestSize != i) {
            throw new IllegalStateException();
        }
        InterfaceC5277Digest interfaceC5277Digest = this.contentDigest1;
        byte[] bArr3 = this.f21021mDash;
        interfaceC5277Digest.mo14967doFinal(bArr3, (bArr3.length - i) - this.f21024sLen);
        try {
            byte[] bArrProcessBlock = this.f21018cipher.processBlock(bArr, 0, bArr.length);
            byte[] bArr4 = this.f21017block;
            C6238Arrays.m18250fill(bArr4, 0, bArr4.length - bArrProcessBlock.length, (byte) 0);
            byte[] bArr5 = this.f21017block;
            System.arraycopy(bArrProcessBlock, 0, bArr5, bArr5.length - bArrProcessBlock.length, bArrProcessBlock.length);
            bArr2 = this.f21017block;
            length = 255 >>> ((bArr2.length * 8) - this.f21019emBits);
            b = bArr2[0];
        } catch (Exception unused) {
        }
        if ((b & C1126UByte.MAX_VALUE) != (b & length) || bArr2[bArr2.length - 1] != this.f21027trailer) {
            clearBlock(bArr2);
            return false;
        }
        int length2 = bArr2.length;
        int i2 = this.f21020hLen;
        byte[] bArrMaskGenerator = maskGenerator(bArr2, (length2 - i2) - 1, i2, (bArr2.length - i2) - 1);
        for (int i3 = 0; i3 != bArrMaskGenerator.length; i3++) {
            byte[] bArr6 = this.f21017block;
            bArr6[i3] = (byte) (bArr6[i3] ^ bArrMaskGenerator[i3]);
        }
        byte[] bArr7 = this.f21017block;
        bArr7[0] = (byte) (length & bArr7[0]);
        int i4 = 0;
        while (true) {
            byte[] bArr8 = this.f21017block;
            int length3 = bArr8.length;
            int i5 = this.f21020hLen;
            int i6 = this.f21024sLen;
            if (i4 != ((length3 - i5) - i6) - 2) {
                if (bArr8[i4] != 0) {
                    clearBlock(bArr8);
                    return false;
                }
                i4++;
            } else {
                if (bArr8[((bArr8.length - i5) - i6) - 2] != 1) {
                    clearBlock(bArr8);
                    return false;
                }
                if (this.f21025sSet) {
                    byte[] bArr9 = this.f21026salt;
                    byte[] bArr10 = this.f21021mDash;
                    System.arraycopy(bArr9, 0, bArr10, bArr10.length - i6, i6);
                } else {
                    int length4 = ((bArr8.length - i6) - i5) - 1;
                    byte[] bArr11 = this.f21021mDash;
                    System.arraycopy(bArr8, length4, bArr11, bArr11.length - i6, i6);
                }
                InterfaceC5277Digest interfaceC5277Digest2 = this.contentDigest2;
                byte[] bArr12 = this.f21021mDash;
                interfaceC5277Digest2.mo14970update(bArr12, 0, bArr12.length);
                InterfaceC5277Digest interfaceC5277Digest3 = this.contentDigest2;
                byte[] bArr13 = this.f21021mDash;
                interfaceC5277Digest3.mo14967doFinal(bArr13, bArr13.length - this.f21020hLen);
                int length5 = this.f21017block.length;
                int i7 = this.f21020hLen;
                int i8 = (length5 - i7) - 1;
                int length6 = this.f21021mDash.length - i7;
                while (true) {
                    byte[] bArr14 = this.f21021mDash;
                    if (length6 == bArr14.length) {
                        clearBlock(bArr14);
                        clearBlock(this.f21017block);
                        return true;
                    }
                    if ((this.f21017block[i8] ^ bArr14[length6]) != 0) {
                        clearBlock(bArr14);
                        clearBlock(this.f21017block);
                        return false;
                    }
                    i8++;
                    length6++;
                }
            }
        }
    }

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, InterfaceC5277Digest interfaceC5277Digest, int i, byte b) {
        this(asymmetricBlockCipher, interfaceC5277Digest, interfaceC5277Digest, i, b);
    }

    public static PSSSigner createRawSigner(AsymmetricBlockCipher asymmetricBlockCipher, InterfaceC5277Digest interfaceC5277Digest, InterfaceC5277Digest interfaceC5277Digest2, int i, byte b) {
        return new PSSSigner(asymmetricBlockCipher, C5294Prehash.forDigest(interfaceC5277Digest), interfaceC5277Digest, interfaceC5277Digest2, i, b);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14990update(byte[] bArr, int i, int i2) {
        this.contentDigest1.mo14970update(bArr, i, i2);
    }

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, InterfaceC5277Digest interfaceC5277Digest, InterfaceC5277Digest interfaceC5277Digest2, int i) {
        this(asymmetricBlockCipher, interfaceC5277Digest, interfaceC5277Digest2, i, TRAILER_IMPLICIT);
    }

    public static PSSSigner createRawSigner(AsymmetricBlockCipher asymmetricBlockCipher, InterfaceC5277Digest interfaceC5277Digest, InterfaceC5277Digest interfaceC5277Digest2, byte[] bArr, byte b) {
        return new PSSSigner(asymmetricBlockCipher, C5294Prehash.forDigest(interfaceC5277Digest), interfaceC5277Digest, interfaceC5277Digest2, bArr, b);
    }

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, InterfaceC5277Digest interfaceC5277Digest, InterfaceC5277Digest interfaceC5277Digest2, int i, byte b) {
        this(asymmetricBlockCipher, interfaceC5277Digest, interfaceC5277Digest, interfaceC5277Digest2, i, b);
    }

    private PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, InterfaceC5277Digest interfaceC5277Digest, InterfaceC5277Digest interfaceC5277Digest2, InterfaceC5277Digest interfaceC5277Digest3, int i, byte b) {
        this.f21018cipher = asymmetricBlockCipher;
        this.contentDigest1 = interfaceC5277Digest;
        this.contentDigest2 = interfaceC5277Digest2;
        this.mgfDigest = interfaceC5277Digest3;
        this.f21020hLen = interfaceC5277Digest2.getDigestSize();
        this.f21022mgfhLen = interfaceC5277Digest3.getDigestSize();
        this.f21025sSet = false;
        this.f21024sLen = i;
        this.f21026salt = new byte[i];
        this.f21021mDash = new byte[i + 8 + this.f21020hLen];
        this.f21027trailer = b;
    }

    private PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, InterfaceC5277Digest interfaceC5277Digest, InterfaceC5277Digest interfaceC5277Digest2, InterfaceC5277Digest interfaceC5277Digest3, byte[] bArr, byte b) {
        this.f21018cipher = asymmetricBlockCipher;
        this.contentDigest1 = interfaceC5277Digest;
        this.contentDigest2 = interfaceC5277Digest2;
        this.mgfDigest = interfaceC5277Digest3;
        this.f21020hLen = interfaceC5277Digest2.getDigestSize();
        this.f21022mgfhLen = interfaceC5277Digest3.getDigestSize();
        this.f21025sSet = true;
        int length = bArr.length;
        this.f21024sLen = length;
        this.f21026salt = bArr;
        this.f21021mDash = new byte[length + 8 + this.f21020hLen];
        this.f21027trailer = b;
    }

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, InterfaceC5277Digest interfaceC5277Digest, InterfaceC5277Digest interfaceC5277Digest2, byte[] bArr) {
        this(asymmetricBlockCipher, interfaceC5277Digest, interfaceC5277Digest2, bArr, TRAILER_IMPLICIT);
    }

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, InterfaceC5277Digest interfaceC5277Digest, InterfaceC5277Digest interfaceC5277Digest2, byte[] bArr, byte b) {
        this(asymmetricBlockCipher, interfaceC5277Digest, interfaceC5277Digest, interfaceC5277Digest2, bArr, b);
    }

    public PSSSigner(AsymmetricBlockCipher asymmetricBlockCipher, InterfaceC5277Digest interfaceC5277Digest, byte[] bArr) {
        this(asymmetricBlockCipher, interfaceC5277Digest, interfaceC5277Digest, bArr, TRAILER_IMPLICIT);
    }
}
