package org.bouncycastle.p314pqc.p316crypto.crystals.dilithium;

import java.security.SecureRandom;
import org.bouncycastle.p133asn1.p138cmp.PKIFailureInfo;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p314pqc.p316crypto.crystals.dilithium.Symmetric;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
class DilithiumEngine {
    public static final int CrhBytes = 64;
    public static final int DilithiumD = 13;
    public static final int DilithiumN = 256;
    public static final int DilithiumPolyT0PackedBytes = 416;
    public static final int DilithiumPolyT1PackedBytes = 320;
    public static final int DilithiumQ = 8380417;
    public static final int DilithiumQinv = 58728449;
    public static final int DilithiumRootOfUnity = 1753;
    public static final int RndBytes = 32;
    public static final int SeedBytes = 32;

    /* renamed from: TrBytes */
    public static final int f23079TrBytes = 64;
    private final int CryptoBytes;
    private final int CryptoPublicKeyBytes;
    private final int CryptoSecretKeyBytes;
    private final int DilithiumBeta;
    private final int DilithiumCTilde;
    private final int DilithiumEta;
    private final int DilithiumGamma1;
    private final int DilithiumGamma2;
    private final int DilithiumK;
    private final int DilithiumL;
    private final int DilithiumMode;
    private final int DilithiumOmega;
    private final int DilithiumPolyEtaPackedBytes;
    private final int DilithiumPolyVecHPackedBytes;
    private final int DilithiumPolyW1PackedBytes;
    private final int DilithiumPolyZPackedBytes;
    private final int DilithiumTau;
    private final int PolyUniformGamma1NBlocks;

    /* renamed from: random */
    private final SecureRandom f23080random;
    private final SHAKEDigest shake256Digest = new SHAKEDigest(256);
    private final Symmetric symmetric;

    public DilithiumEngine(int i, SecureRandom secureRandom, boolean z) {
        int i2;
        int i3;
        int i4;
        this.DilithiumMode = i;
        if (i != 2) {
            if (i == 3) {
                this.DilithiumK = 6;
                this.DilithiumL = 5;
                this.DilithiumEta = 4;
                this.DilithiumTau = 49;
                this.DilithiumBeta = 196;
                this.DilithiumGamma1 = PKIFailureInfo.signerNotTrusted;
                this.DilithiumGamma2 = 261888;
                this.DilithiumOmega = 55;
                this.DilithiumPolyZPackedBytes = 640;
                this.DilithiumPolyW1PackedBytes = 128;
                this.DilithiumPolyEtaPackedBytes = 128;
                i4 = 48;
            } else {
                if (i != 5) {
                    throw new IllegalArgumentException("The mode " + i + "is not supported by Crystals Dilithium!");
                }
                this.DilithiumK = 8;
                this.DilithiumL = 7;
                this.DilithiumEta = 2;
                this.DilithiumTau = 60;
                this.DilithiumBeta = 120;
                this.DilithiumGamma1 = PKIFailureInfo.signerNotTrusted;
                this.DilithiumGamma2 = 261888;
                this.DilithiumOmega = 75;
                this.DilithiumPolyZPackedBytes = 640;
                this.DilithiumPolyW1PackedBytes = 128;
                this.DilithiumPolyEtaPackedBytes = 96;
                i4 = 64;
            }
            this.DilithiumCTilde = i4;
        } else {
            this.DilithiumK = 4;
            this.DilithiumL = 4;
            this.DilithiumEta = 2;
            this.DilithiumTau = 39;
            this.DilithiumBeta = 78;
            this.DilithiumGamma1 = PKIFailureInfo.unsupportedVersion;
            this.DilithiumGamma2 = 95232;
            this.DilithiumOmega = 80;
            this.DilithiumPolyZPackedBytes = 576;
            this.DilithiumPolyW1PackedBytes = 192;
            this.DilithiumPolyEtaPackedBytes = 96;
            this.DilithiumCTilde = 32;
        }
        this.symmetric = z ? new Symmetric.AesSymmetric() : new Symmetric.ShakeSymmetric();
        this.f23080random = secureRandom;
        int i5 = this.DilithiumOmega;
        int i6 = this.DilithiumK;
        int i7 = i5 + i6;
        this.DilithiumPolyVecHPackedBytes = i7;
        this.CryptoPublicKeyBytes = (i6 * 320) + 32;
        int i8 = this.DilithiumL;
        int i9 = this.DilithiumPolyEtaPackedBytes;
        this.CryptoSecretKeyBytes = (i8 * i9) + 128 + (i9 * i6) + (i6 * 416);
        this.CryptoBytes = this.DilithiumCTilde + (i8 * this.DilithiumPolyZPackedBytes) + i7;
        int i10 = this.DilithiumGamma1;
        if (i10 == 131072) {
            i2 = this.symmetric.stream256BlockBytes;
            i3 = i2 + 575;
        } else {
            if (i10 != 524288) {
                throw new RuntimeException("Wrong Dilithium Gamma1!");
            }
            i2 = this.symmetric.stream256BlockBytes;
            i3 = i2 + 639;
        }
        this.PolyUniformGamma1NBlocks = i3 / i2;
    }

    public Symmetric GetSymmetric() {
        return this.symmetric;
    }

    public byte[][] generateKeyPair() {
        byte[] bArr = new byte[32];
        this.f23080random.nextBytes(bArr);
        return generateKeyPairInternal(bArr);
    }

    public byte[][] generateKeyPairInternal(byte[] bArr) {
        byte[] bArr2 = new byte[128];
        byte[] bArr3 = new byte[64];
        byte[] bArr4 = new byte[32];
        byte[] bArr5 = new byte[64];
        byte[] bArr6 = new byte[32];
        PolyVecMatrix polyVecMatrix = new PolyVecMatrix(this);
        PolyVecL polyVecL = new PolyVecL(this);
        PolyVecK polyVecK = new PolyVecK(this);
        PolyVecK polyVecK2 = new PolyVecK(this);
        PolyVecK polyVecK3 = new PolyVecK(this);
        this.shake256Digest.mo14970update(bArr, 0, 32);
        this.shake256Digest.mo14969update((byte) this.DilithiumK);
        this.shake256Digest.mo14969update((byte) this.DilithiumL);
        this.shake256Digest.mo14998doFinal(bArr2, 0, 128);
        System.arraycopy(bArr2, 0, bArr4, 0, 32);
        System.arraycopy(bArr2, 32, bArr5, 0, 64);
        System.arraycopy(bArr2, 96, bArr6, 0, 32);
        polyVecMatrix.expandMatrix(bArr4);
        polyVecL.uniformEta(bArr5, (short) 0);
        polyVecK.uniformEta(bArr5, (short) this.DilithiumL);
        PolyVecL polyVecL2 = new PolyVecL(this);
        polyVecL.copyPolyVecL(polyVecL2);
        polyVecL2.polyVecNtt();
        polyVecMatrix.pointwiseMontgomery(polyVecK2, polyVecL2);
        polyVecK2.m17534reduce();
        polyVecK2.invNttToMont();
        polyVecK2.addPolyVecK(polyVecK);
        polyVecK2.conditionalAddQ();
        polyVecK2.power2Round(polyVecK3);
        byte[] bArrPackPublicKey = C6059Packing.packPublicKey(polyVecK2, this);
        this.shake256Digest.mo14970update(bArr4, 0, 32);
        this.shake256Digest.mo14970update(bArrPackPublicKey, 0, bArrPackPublicKey.length);
        this.shake256Digest.mo14998doFinal(bArr3, 0, 64);
        byte[][] bArrPackSecretKey = C6059Packing.packSecretKey(bArr4, bArr3, bArr6, polyVecK3, polyVecL, polyVecK, this);
        return new byte[][]{bArrPackSecretKey[0], bArrPackSecretKey[1], bArrPackSecretKey[2], bArrPackSecretKey[3], bArrPackSecretKey[4], bArrPackSecretKey[5], bArrPackPublicKey};
    }

    public int getCryptoBytes() {
        return this.CryptoBytes;
    }

    public int getCryptoPublicKeyBytes() {
        return this.CryptoPublicKeyBytes;
    }

    public int getCryptoSecretKeyBytes() {
        return this.CryptoSecretKeyBytes;
    }

    public int getDilithiumBeta() {
        return this.DilithiumBeta;
    }

    public int getDilithiumCTilde() {
        return this.DilithiumCTilde;
    }

    public int getDilithiumEta() {
        return this.DilithiumEta;
    }

    public int getDilithiumGamma1() {
        return this.DilithiumGamma1;
    }

    public int getDilithiumGamma2() {
        return this.DilithiumGamma2;
    }

    public int getDilithiumK() {
        return this.DilithiumK;
    }

    public int getDilithiumL() {
        return this.DilithiumL;
    }

    public int getDilithiumMode() {
        return this.DilithiumMode;
    }

    public int getDilithiumOmega() {
        return this.DilithiumOmega;
    }

    public int getDilithiumPolyEtaPackedBytes() {
        return this.DilithiumPolyEtaPackedBytes;
    }

    public int getDilithiumPolyVecHPackedBytes() {
        return this.DilithiumPolyVecHPackedBytes;
    }

    public int getDilithiumPolyW1PackedBytes() {
        return this.DilithiumPolyW1PackedBytes;
    }

    public int getDilithiumPolyZPackedBytes() {
        return this.DilithiumPolyZPackedBytes;
    }

    public int getDilithiumTau() {
        return this.DilithiumTau;
    }

    public int getPolyUniformGamma1NBlocks() {
        return this.PolyUniformGamma1NBlocks;
    }

    public SHAKEDigest getShake256Digest() {
        return this.shake256Digest;
    }

    /* renamed from: sign */
    public byte[] m17514sign(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7) {
        return signSignature(bArr, i, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7);
    }

    public boolean signOpen(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4) {
        return signVerify(bArr2, i, bArr, bArr.length, bArr3, bArr4);
    }

    public byte[] signSignature(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7) {
        byte[] bArr8 = new byte[32];
        SecureRandom secureRandom = this.f23080random;
        if (secureRandom != null) {
            secureRandom.nextBytes(bArr8);
        }
        return signSignatureInternal(bArr, i, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8);
    }

    public byte[] signSignatureInternal(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8) {
        PolyVecK polyVecK;
        PolyVecK polyVecK2;
        int i2;
        byte[] bArr9 = new byte[this.CryptoBytes + i];
        byte[] bArr10 = new byte[64];
        byte[] bArr11 = new byte[64];
        PolyVecL polyVecL = new PolyVecL(this);
        PolyVecL polyVecL2 = new PolyVecL(this);
        PolyVecL polyVecL3 = new PolyVecL(this);
        PolyVecK polyVecK3 = new PolyVecK(this);
        PolyVecK polyVecK4 = new PolyVecK(this);
        PolyVecK polyVecK5 = new PolyVecK(this);
        PolyVecK polyVecK6 = new PolyVecK(this);
        PolyVecK polyVecK7 = new PolyVecK(this);
        C6060Poly c6060Poly = new C6060Poly(this);
        PolyVecMatrix polyVecMatrix = new PolyVecMatrix(this);
        C6060Poly c6060Poly2 = c6060Poly;
        PolyVecK polyVecK8 = polyVecK7;
        PolyVecK polyVecK9 = polyVecK6;
        PolyVecK polyVecK10 = polyVecK5;
        PolyVecK polyVecK11 = polyVecK4;
        PolyVecK polyVecK12 = polyVecK3;
        C6059Packing.unpackSecretKey(polyVecK3, polyVecL, polyVecK4, bArr5, bArr6, bArr7, this);
        int i3 = 0;
        this.shake256Digest.mo14970update(bArr4, 0, 64);
        this.shake256Digest.mo14970update(bArr, 0, i);
        this.shake256Digest.mo14998doFinal(bArr10, 0, 64);
        byte[] bArrM18242copyOf = C6238Arrays.m18242copyOf(bArr3, 128);
        System.arraycopy(bArr8, 0, bArrM18242copyOf, 32, 32);
        System.arraycopy(bArr10, 0, bArrM18242copyOf, 64, 64);
        this.shake256Digest.mo14970update(bArrM18242copyOf, 0, 128);
        this.shake256Digest.mo14998doFinal(bArr11, 0, 64);
        polyVecMatrix.expandMatrix(bArr2);
        polyVecL.polyVecNtt();
        polyVecK11.polyVecNtt();
        polyVecK12.polyVecNtt();
        int i4 = 0;
        short s = 0;
        while (i4 < 1000) {
            int i5 = i4 + 1;
            short s2 = (short) (s + 1);
            polyVecL2.uniformGamma1(bArr11, s);
            polyVecL2.copyPolyVecL(polyVecL3);
            polyVecL3.polyVecNtt();
            PolyVecK polyVecK13 = polyVecK10;
            polyVecMatrix.pointwiseMontgomery(polyVecK13, polyVecL3);
            polyVecK13.m17534reduce();
            polyVecK13.invNttToMont();
            polyVecK13.conditionalAddQ();
            PolyVecK polyVecK14 = polyVecK9;
            polyVecK13.decompose(polyVecK14);
            System.arraycopy(polyVecK13.m17533packW1(), i3, bArr9, i3, this.DilithiumK * this.DilithiumPolyW1PackedBytes);
            this.shake256Digest.mo14970update(bArr10, i3, 64);
            this.shake256Digest.mo14970update(bArr9, i3, this.DilithiumK * this.DilithiumPolyW1PackedBytes);
            this.shake256Digest.mo14998doFinal(bArr9, i3, this.DilithiumCTilde);
            C6060Poly c6060Poly3 = c6060Poly2;
            c6060Poly3.challenge(C6238Arrays.copyOfRange(bArr9, i3, this.DilithiumCTilde));
            c6060Poly3.m17528polyNtt();
            polyVecL3.pointwisePolyMontgomery(c6060Poly3, polyVecL);
            polyVecL3.invNttToMont();
            polyVecL3.addPolyVecL(polyVecL2);
            polyVecL3.m17536reduce();
            if (polyVecL3.checkNorm(this.DilithiumGamma1 - this.DilithiumBeta)) {
                polyVecK = polyVecK11;
                i2 = i5;
                polyVecK2 = polyVecK8;
            } else {
                polyVecK = polyVecK11;
                polyVecK2 = polyVecK8;
                polyVecK2.pointwisePolyMontgomery(c6060Poly3, polyVecK);
                polyVecK2.invNttToMont();
                polyVecK14.subtract(polyVecK2);
                polyVecK14.m17534reduce();
                i2 = i5;
                if (polyVecK14.checkNorm(this.DilithiumGamma2 - this.DilithiumBeta)) {
                    continue;
                } else {
                    PolyVecK polyVecK15 = polyVecK12;
                    polyVecK2.pointwisePolyMontgomery(c6060Poly3, polyVecK15);
                    polyVecK2.invNttToMont();
                    polyVecK2.m17534reduce();
                    if (polyVecK2.checkNorm(this.DilithiumGamma2)) {
                        polyVecK12 = polyVecK15;
                    } else {
                        polyVecK14.addPolyVecK(polyVecK2);
                        polyVecK14.conditionalAddQ();
                        polyVecK12 = polyVecK15;
                        if (polyVecK2.makeHint(polyVecK14, polyVecK13) <= this.DilithiumOmega) {
                            return C6059Packing.packSignature(bArr9, polyVecL3, polyVecK2, this);
                        }
                    }
                }
            }
            i4 = i2;
            polyVecK10 = polyVecK13;
            s = s2;
            polyVecK9 = polyVecK14;
            polyVecK11 = polyVecK;
            c6060Poly2 = c6060Poly3;
            polyVecK8 = polyVecK2;
            i3 = 0;
        }
        return null;
    }

    public boolean signVerify(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4) {
        return signVerifyInternal(bArr, i, bArr2, i2, bArr3, bArr4);
    }

    public boolean signVerifyInternal(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4) {
        byte[] bArr5 = new byte[64];
        byte[] bArr6 = new byte[this.DilithiumCTilde];
        C6060Poly c6060Poly = new C6060Poly(this);
        PolyVecMatrix polyVecMatrix = new PolyVecMatrix(this);
        PolyVecL polyVecL = new PolyVecL(this);
        PolyVecK polyVecK = new PolyVecK(this);
        PolyVecK polyVecK2 = new PolyVecK(this);
        PolyVecK polyVecK3 = new PolyVecK(this);
        if (i != this.CryptoBytes) {
            return false;
        }
        PolyVecK polyVecKUnpackPublicKey = C6059Packing.unpackPublicKey(polyVecK, bArr4, this);
        if (!C6059Packing.unpackSignature(polyVecL, polyVecK3, bArr, this)) {
            return false;
        }
        byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(bArr, 0, this.DilithiumCTilde);
        if (polyVecL.checkNorm(getDilithiumGamma1() - getDilithiumBeta())) {
            return false;
        }
        this.shake256Digest.mo14970update(bArr3, 0, bArr3.length);
        this.shake256Digest.mo14970update(bArr4, 0, bArr4.length);
        this.shake256Digest.mo14998doFinal(bArr5, 0, 64);
        this.shake256Digest.mo14970update(bArr5, 0, 64);
        this.shake256Digest.mo14970update(bArr2, 0, i2);
        this.shake256Digest.mo14967doFinal(bArr5, 0);
        c6060Poly.challenge(C6238Arrays.copyOfRange(bArrCopyOfRange, 0, this.DilithiumCTilde));
        polyVecMatrix.expandMatrix(bArr3);
        polyVecL.polyVecNtt();
        polyVecMatrix.pointwiseMontgomery(polyVecK2, polyVecL);
        c6060Poly.m17528polyNtt();
        polyVecKUnpackPublicKey.shiftLeft();
        polyVecKUnpackPublicKey.polyVecNtt();
        polyVecKUnpackPublicKey.pointwisePolyMontgomery(c6060Poly, polyVecKUnpackPublicKey);
        polyVecK2.subtract(polyVecKUnpackPublicKey);
        polyVecK2.m17534reduce();
        polyVecK2.invNttToMont();
        polyVecK2.conditionalAddQ();
        polyVecK2.m17535useHint(polyVecK2, polyVecK3);
        byte[] bArrM17533packW1 = polyVecK2.m17533packW1();
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        sHAKEDigest.mo14970update(bArr5, 0, 64);
        sHAKEDigest.mo14970update(bArrM17533packW1, 0, this.DilithiumK * this.DilithiumPolyW1PackedBytes);
        sHAKEDigest.mo14998doFinal(bArr6, 0, this.DilithiumCTilde);
        return C6238Arrays.constantTimeAreEqual(bArrCopyOfRange, bArr6);
    }
}
