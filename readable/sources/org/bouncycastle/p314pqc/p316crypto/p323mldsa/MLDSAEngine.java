package org.bouncycastle.p314pqc.p316crypto.p323mldsa;

import java.security.SecureRandom;
import org.bouncycastle.p133asn1.p138cmp.PKIFailureInfo;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p314pqc.p316crypto.p323mldsa.Symmetric;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
class MLDSAEngine {
    public static final int CrhBytes = 64;
    public static final int DilithiumD = 13;
    public static final int DilithiumN = 256;
    public static final int DilithiumPolyT0PackedBytes = 416;
    public static final int DilithiumPolyT1PackedBytes = 320;
    public static final int DilithiumQ = 8380417;
    public static final int DilithiumQinv = 58728449;
    public static final int RndBytes = 32;
    public static final int SeedBytes = 32;

    /* renamed from: TrBytes */
    public static final int f23304TrBytes = 64;
    private final int CryptoBytes;
    private final int CryptoPublicKeyBytes;
    private final int DilithiumBeta;
    private final int DilithiumCTilde;
    private final int DilithiumEta;
    private final int DilithiumGamma1;
    private final int DilithiumGamma2;
    private final int DilithiumK;
    private final int DilithiumL;
    private final int DilithiumOmega;
    private final int DilithiumPolyEtaPackedBytes;
    private final int DilithiumPolyVecHPackedBytes;
    private final int DilithiumPolyW1PackedBytes;
    private final int DilithiumPolyZPackedBytes;
    private final int DilithiumTau;
    private final int PolyUniformGamma1NBlocks;

    /* renamed from: random */
    private final SecureRandom f23305random;
    final SHAKEDigest shake256Digest = new SHAKEDigest(256);
    private final Symmetric symmetric;

    public MLDSAEngine(int i, SecureRandom secureRandom) {
        int i2;
        int i3;
        int i4;
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
        Symmetric.ShakeSymmetric shakeSymmetric = new Symmetric.ShakeSymmetric();
        this.symmetric = shakeSymmetric;
        this.f23305random = secureRandom;
        int i5 = this.DilithiumOmega;
        int i6 = this.DilithiumK;
        int i7 = i5 + i6;
        this.DilithiumPolyVecHPackedBytes = i7;
        this.CryptoPublicKeyBytes = (i6 * 320) + 32;
        this.CryptoBytes = this.DilithiumCTilde + (this.DilithiumL * this.DilithiumPolyZPackedBytes) + i7;
        int i8 = this.DilithiumGamma1;
        if (i8 == 131072) {
            i2 = shakeSymmetric.stream256BlockBytes;
            i3 = i2 + 575;
        } else {
            if (i8 != 524288) {
                throw new RuntimeException("Wrong Dilithium Gamma1!");
            }
            i2 = shakeSymmetric.stream256BlockBytes;
            i3 = i2 + 639;
        }
        this.PolyUniformGamma1NBlocks = i3 / i2;
    }

    private boolean doVerifyInternal(byte[] bArr, byte[] bArr2, int i, SHAKEDigest sHAKEDigest, byte[] bArr3, byte[] bArr4) {
        if (i != this.CryptoBytes) {
            return false;
        }
        PolyVecK polyVecK = new PolyVecK(this);
        PolyVecL polyVecL = new PolyVecL(this);
        if (!C6073Packing.unpackSignature(polyVecL, polyVecK, bArr2, this) || polyVecL.checkNorm(getDilithiumGamma1() - getDilithiumBeta())) {
            return false;
        }
        C6074Poly c6074Poly = new C6074Poly(this);
        PolyVecMatrix polyVecMatrix = new PolyVecMatrix(this);
        PolyVecK polyVecK2 = new PolyVecK(this);
        PolyVecK polyVecK3 = new PolyVecK(this);
        PolyVecK polyVecKUnpackPublicKey = C6073Packing.unpackPublicKey(polyVecK2, bArr4, this);
        c6074Poly.challenge(bArr2, 0, this.DilithiumCTilde);
        polyVecMatrix.expandMatrix(bArr3);
        polyVecL.polyVecNtt();
        polyVecMatrix.pointwiseMontgomery(polyVecK3, polyVecL);
        c6074Poly.m17692polyNtt();
        polyVecKUnpackPublicKey.shiftLeft();
        polyVecKUnpackPublicKey.polyVecNtt();
        polyVecKUnpackPublicKey.pointwisePolyMontgomery(c6074Poly, polyVecKUnpackPublicKey);
        polyVecK3.subtract(polyVecKUnpackPublicKey);
        polyVecK3.m17697reduce();
        polyVecK3.invNttToMont();
        polyVecK3.conditionalAddQ();
        polyVecK3.m17698useHint(polyVecK3, polyVecK);
        polyVecK3.m17696packW1(this, bArr, 64);
        sHAKEDigest.mo14970update(bArr, 0, (this.DilithiumK * this.DilithiumPolyW1PackedBytes) + 64);
        sHAKEDigest.mo14998doFinal(bArr, 0, this.DilithiumCTilde);
        return C6238Arrays.constantTimeAreEqual(this.DilithiumCTilde, bArr2, 0, bArr, 0);
    }

    public Symmetric GetSymmetric() {
        return this.symmetric;
    }

    public void absorbCtx(boolean z, byte[] bArr) {
        if (bArr != null) {
            this.shake256Digest.mo14969update(z ? (byte) 1 : (byte) 0);
            this.shake256Digest.mo14969update((byte) bArr.length);
            this.shake256Digest.mo14970update(bArr, 0, bArr.length);
        }
    }

    public byte[] deriveT1(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6) {
        PolyVecMatrix polyVecMatrix = new PolyVecMatrix(this);
        PolyVecL polyVecL = new PolyVecL(this);
        PolyVecK polyVecK = new PolyVecK(this);
        PolyVecK polyVecK2 = new PolyVecK(this);
        PolyVecK polyVecK3 = new PolyVecK(this);
        C6073Packing.unpackSecretKey(polyVecK3, polyVecL, polyVecK, bArr6, bArr4, bArr5, this);
        polyVecMatrix.expandMatrix(bArr);
        PolyVecL polyVecL2 = new PolyVecL(this);
        polyVecL.m17699copyTo(polyVecL2);
        polyVecL2.polyVecNtt();
        polyVecMatrix.pointwiseMontgomery(polyVecK2, polyVecL2);
        polyVecK2.m17697reduce();
        polyVecK2.invNttToMont();
        polyVecK2.addPolyVecK(polyVecK);
        polyVecK2.conditionalAddQ();
        polyVecK2.power2Round(polyVecK3);
        return C6073Packing.packPublicKey(polyVecK2, this);
    }

    public byte[][] generateKeyPair() {
        byte[] bArr = new byte[32];
        this.f23305random.nextBytes(bArr);
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
        polyVecL.m17699copyTo(polyVecL2);
        polyVecL2.polyVecNtt();
        polyVecMatrix.pointwiseMontgomery(polyVecK2, polyVecL2);
        polyVecK2.m17697reduce();
        polyVecK2.invNttToMont();
        polyVecK2.addPolyVecK(polyVecK);
        polyVecK2.conditionalAddQ();
        polyVecK2.power2Round(polyVecK3);
        byte[] bArrPackPublicKey = C6073Packing.packPublicKey(polyVecK2, this);
        this.shake256Digest.mo14970update(bArr4, 0, 32);
        this.shake256Digest.mo14970update(bArrPackPublicKey, 0, bArrPackPublicKey.length);
        this.shake256Digest.mo14998doFinal(bArr3, 0, 64);
        byte[][] bArrPackSecretKey = C6073Packing.packSecretKey(bArr4, bArr3, bArr6, polyVecK3, polyVecL, polyVecK, this);
        return new byte[][]{bArrPackSecretKey[0], bArrPackSecretKey[1], bArrPackSecretKey[2], bArrPackSecretKey[3], bArrPackSecretKey[4], bArrPackSecretKey[5], bArrPackPublicKey, bArr};
    }

    public byte[] generateMu(SHAKEDigest sHAKEDigest) {
        byte[] bArr = new byte[64];
        sHAKEDigest.mo14998doFinal(bArr, 0, 64);
        return bArr;
    }

    public byte[] generateSignature(byte[] bArr, SHAKEDigest sHAKEDigest, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7) {
        PolyVecK polyVecK;
        PolyVecK polyVecK2;
        int i;
        PolyVecMatrix polyVecMatrix;
        byte[] bArr8 = new byte[this.CryptoBytes];
        int i2 = 64;
        byte[] bArr9 = new byte[64];
        PolyVecL polyVecL = new PolyVecL(this);
        PolyVecL polyVecL2 = new PolyVecL(this);
        PolyVecL polyVecL3 = new PolyVecL(this);
        PolyVecK polyVecK3 = new PolyVecK(this);
        PolyVecK polyVecK4 = new PolyVecK(this);
        PolyVecK polyVecK5 = new PolyVecK(this);
        PolyVecK polyVecK6 = new PolyVecK(this);
        PolyVecK polyVecK7 = new PolyVecK(this);
        C6074Poly c6074Poly = new C6074Poly(this);
        PolyVecMatrix polyVecMatrix2 = new PolyVecMatrix(this);
        C6074Poly c6074Poly2 = c6074Poly;
        PolyVecK polyVecK8 = polyVecK7;
        PolyVecK polyVecK9 = polyVecK6;
        PolyVecK polyVecK10 = polyVecK5;
        PolyVecK polyVecK11 = polyVecK4;
        PolyVecK polyVecK12 = polyVecK3;
        C6073Packing.unpackSecretKey(polyVecK3, polyVecL, polyVecK4, bArr4, bArr5, bArr6, this);
        byte[] bArrM18242copyOf = C6238Arrays.m18242copyOf(bArr3, 128);
        int i3 = 0;
        System.arraycopy(bArr7, 0, bArrM18242copyOf, 32, 32);
        System.arraycopy(bArr, 0, bArrM18242copyOf, 64, 64);
        sHAKEDigest.mo14970update(bArrM18242copyOf, 0, 128);
        sHAKEDigest.mo14998doFinal(bArr9, 0, 64);
        PolyVecMatrix polyVecMatrix3 = polyVecMatrix2;
        polyVecMatrix3.expandMatrix(bArr2);
        polyVecL.polyVecNtt();
        polyVecK11.polyVecNtt();
        polyVecK12.polyVecNtt();
        int i4 = 0;
        short s = 0;
        while (i4 < 1000) {
            int i5 = i4 + 1;
            short s2 = (short) (s + 1);
            polyVecL2.uniformGamma1(bArr9, s);
            polyVecL2.m17699copyTo(polyVecL3);
            polyVecL3.polyVecNtt();
            PolyVecK polyVecK13 = polyVecK10;
            polyVecMatrix3.pointwiseMontgomery(polyVecK13, polyVecL3);
            polyVecK13.m17697reduce();
            polyVecK13.invNttToMont();
            polyVecK13.conditionalAddQ();
            PolyVecK polyVecK14 = polyVecK9;
            polyVecK13.decompose(polyVecK14);
            polyVecK13.m17696packW1(this, bArr8, i3);
            sHAKEDigest.mo14970update(bArr, i3, i2);
            sHAKEDigest.mo14970update(bArr8, i3, this.DilithiumK * this.DilithiumPolyW1PackedBytes);
            sHAKEDigest.mo14998doFinal(bArr8, i3, this.DilithiumCTilde);
            C6074Poly c6074Poly3 = c6074Poly2;
            c6074Poly3.challenge(bArr8, i3, this.DilithiumCTilde);
            c6074Poly3.m17692polyNtt();
            polyVecL3.pointwisePolyMontgomery(c6074Poly3, polyVecL);
            polyVecL3.invNttToMont();
            polyVecL3.addPolyVecL(polyVecL2);
            polyVecL3.m17700reduce();
            if (polyVecL3.checkNorm(this.DilithiumGamma1 - this.DilithiumBeta)) {
                polyVecK = polyVecK11;
                i = i5;
                polyVecMatrix = polyVecMatrix3;
                polyVecK2 = polyVecK8;
            } else {
                polyVecK = polyVecK11;
                polyVecK2 = polyVecK8;
                polyVecK2.pointwisePolyMontgomery(c6074Poly3, polyVecK);
                polyVecK2.invNttToMont();
                polyVecK14.subtract(polyVecK2);
                polyVecK14.m17697reduce();
                i = i5;
                polyVecMatrix = polyVecMatrix3;
                if (polyVecK14.checkNorm(this.DilithiumGamma2 - this.DilithiumBeta)) {
                    continue;
                } else {
                    PolyVecK polyVecK15 = polyVecK12;
                    polyVecK2.pointwisePolyMontgomery(c6074Poly3, polyVecK15);
                    polyVecK2.invNttToMont();
                    polyVecK2.m17697reduce();
                    if (polyVecK2.checkNorm(this.DilithiumGamma2)) {
                        polyVecK12 = polyVecK15;
                    } else {
                        polyVecK14.addPolyVecK(polyVecK2);
                        polyVecK14.conditionalAddQ();
                        polyVecK12 = polyVecK15;
                        if (polyVecK2.makeHint(polyVecK14, polyVecK13) <= this.DilithiumOmega) {
                            C6073Packing.packSignature(bArr8, polyVecL3, polyVecK2, this);
                            return bArr8;
                        }
                    }
                }
            }
            i4 = i;
            polyVecK10 = polyVecK13;
            polyVecK11 = polyVecK;
            s = s2;
            polyVecK9 = polyVecK14;
            polyVecK8 = polyVecK2;
            polyVecMatrix3 = polyVecMatrix;
            i3 = 0;
            c6074Poly2 = c6074Poly3;
            i2 = 64;
        }
        return null;
    }

    public int getCryptoPublicKeyBytes() {
        return this.CryptoPublicKeyBytes;
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

    public int getDilithiumOmega() {
        return this.DilithiumOmega;
    }

    public int getDilithiumPolyEtaPackedBytes() {
        return this.DilithiumPolyEtaPackedBytes;
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
        return new SHAKEDigest(this.shake256Digest);
    }

    public void initSign(byte[] bArr, boolean z, byte[] bArr2) {
        this.shake256Digest.mo14970update(bArr, 0, 64);
        absorbCtx(z, bArr2);
    }

    public void initVerify(byte[] bArr, byte[] bArr2, boolean z, byte[] bArr3) {
        byte[] bArr4 = new byte[64];
        this.shake256Digest.mo14970update(bArr, 0, bArr.length);
        this.shake256Digest.mo14970update(bArr2, 0, bArr2.length);
        this.shake256Digest.mo14998doFinal(bArr4, 0, 64);
        this.shake256Digest.mo14970update(bArr4, 0, 64);
        absorbCtx(z, bArr3);
    }

    public byte[] signInternal(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7) {
        SHAKEDigest sHAKEDigest = new SHAKEDigest(this.shake256Digest);
        sHAKEDigest.mo14970update(bArr, 0, i);
        return generateSignature(generateMu(sHAKEDigest), sHAKEDigest, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7);
    }

    public boolean verifyInternal(byte[] bArr, int i, SHAKEDigest sHAKEDigest, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[Math.max((this.DilithiumK * this.DilithiumPolyW1PackedBytes) + 64, this.DilithiumCTilde)];
        sHAKEDigest.mo14967doFinal(bArr4, 0);
        return doVerifyInternal(bArr4, bArr, i, sHAKEDigest, bArr2, bArr3);
    }

    public boolean verifyInternalMu(byte[] bArr) {
        byte[] bArr2 = new byte[64];
        this.shake256Digest.mo14967doFinal(bArr2, 0);
        return C6238Arrays.constantTimeAreEqual(bArr2, bArr);
    }

    public boolean verifyInternalMuSignature(byte[] bArr, byte[] bArr2, int i, SHAKEDigest sHAKEDigest, byte[] bArr3, byte[] bArr4) {
        byte[] bArr5 = new byte[Math.max((this.DilithiumK * this.DilithiumPolyW1PackedBytes) + 64, this.DilithiumCTilde)];
        System.arraycopy(bArr, 0, bArr5, 0, bArr.length);
        return doVerifyInternal(bArr5, bArr2, i, sHAKEDigest, bArr3, bArr4);
    }
}
