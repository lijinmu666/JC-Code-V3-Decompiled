package org.bouncycastle.p194crypto.p207kems.p208mlkem;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.p199digests.SHA3Digest;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p194crypto.p213params.MLKEMParameters;
import org.bouncycastle.p194crypto.p213params.MLKEMPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.MLKEMPublicKeyParameters;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class MLKEMEngine {

    /* renamed from: Eta2 */
    static final int f20397Eta2 = 2;

    /* renamed from: N */
    static final int f20398N = 256;
    static final int PolyBytes = 384;

    /* renamed from: Q */
    static final int f20399Q = 3329;

    /* renamed from: Qinv */
    static final int f20400Qinv = 62209;
    public static final int SeedBytes = 64;
    static final int SharedSecretBytes = 32;
    public static final int SymBytes = 32;

    /* renamed from: engines */
    private static final MLKEMEngine[] f20401engines = {new MLKEMEngine(MLKEMParameters.ml_kem_512.m15789getK()), new MLKEMEngine(MLKEMParameters.ml_kem_768.m15789getK()), new MLKEMEngine(MLKEMParameters.ml_kem_1024.m15789getK())};
    private final int CipherTextBytes;

    /* renamed from: Eta1 */
    private final int f20402Eta1;
    private final int IndCpaPublicKeyBytes;
    private final int IndCpaSecretKeyBytes;

    /* renamed from: K */
    private final int f20403K;
    private final int PolyCompressedBytes;
    private final int PolyVecBytes;
    private final int PolyVecCompressedBytes;
    private final int SecretKeyBytes;

    /* renamed from: indCpa */
    private final MLKEMIndCpa f20404indCpa;

    private MLKEMEngine(int i) {
        int i2;
        this.f20403K = i;
        if (i == 2) {
            this.f20402Eta1 = 3;
        } else {
            if (i != 3) {
                if (i != 4) {
                    throw new IllegalArgumentException("K: " + i + " is not supported for ML-KEM");
                }
                this.f20402Eta1 = 2;
                this.PolyCompressedBytes = 160;
                i2 = i * 352;
                this.PolyVecCompressedBytes = i2;
                int i3 = i * PolyBytes;
                this.PolyVecBytes = i3;
                int i4 = i3 + 32;
                this.IndCpaPublicKeyBytes = i4;
                this.IndCpaSecretKeyBytes = i3;
                this.CipherTextBytes = this.PolyVecCompressedBytes + this.PolyCompressedBytes;
                this.SecretKeyBytes = i3 + i4 + 64;
                this.f20404indCpa = new MLKEMIndCpa(this);
            }
            this.f20402Eta1 = 2;
        }
        this.PolyCompressedBytes = 128;
        i2 = i * 320;
        this.PolyVecCompressedBytes = i2;
        int i32 = i * PolyBytes;
        this.PolyVecBytes = i32;
        int i42 = i32 + 32;
        this.IndCpaPublicKeyBytes = i42;
        this.IndCpaSecretKeyBytes = i32;
        this.CipherTextBytes = this.PolyVecCompressedBytes + this.PolyCompressedBytes;
        this.SecretKeyBytes = i32 + i42 + 64;
        this.f20404indCpa = new MLKEMIndCpa(this);
    }

    /* renamed from: cmov */
    private void m15562cmov(byte[] bArr, byte[] bArr2, int i, int i2) {
        int i3 = (0 - i2) >> 24;
        for (int i4 = 0; i4 != i; i4++) {
            bArr[i4] = (byte) ((bArr2[i4] & i3) | (bArr[i4] & (~i3)));
        }
    }

    private int constantTimeZeroOnEqual(byte[] bArr, byte[] bArr2) {
        int length = bArr2.length ^ bArr.length;
        for (int i = 0; i != bArr2.length; i++) {
            length |= bArr[i] ^ bArr2[i];
        }
        return length & 255;
    }

    public static MLKEMEngine getInstance(MLKEMParameters mLKEMParameters) {
        return f20401engines[mLKEMParameters.m15789getK() - 2];
    }

    /* renamed from: hash_G */
    public static void m15563hash_G(byte[] bArr, byte[] bArr2) {
        implDigest(new SHA3Digest(512), bArr, 0, bArr.length, bArr2, 0);
    }

    /* renamed from: hash_H */
    private static void m15564hash_H(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        implDigest(new SHA3Digest(256), bArr, i, i2, bArr2, i3);
    }

    private static void implDigest(SHA3Digest sHA3Digest, byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        sHA3Digest.mo14970update(bArr, i, i2);
        sHA3Digest.mo14967doFinal(bArr2, i3);
    }

    public boolean checkModulus(byte[] bArr) {
        return C5356PolyVec.checkModulus(this, bArr) < 0;
    }

    public boolean checkPrivateKey(byte[] bArr) {
        int iM15566getK = m15566getK();
        int i = iM15566getK * PolyBytes;
        int i2 = iM15566getK * 768;
        if (i2 + 96 != bArr.length) {
            throw new IllegalArgumentException("'encoding' has invalid length");
        }
        byte[] bArr2 = new byte[32];
        m15564hash_H(bArr, i, i + 32, bArr2, 0);
        return C6238Arrays.constantTimeAreEqual(32, bArr2, 0, bArr, i2 + 32);
    }

    public byte[][] generateKemKeyPair(SecureRandom secureRandom) {
        byte[] bArr = new byte[32];
        byte[] bArr2 = new byte[32];
        secureRandom.nextBytes(bArr);
        secureRandom.nextBytes(bArr2);
        return generateKemKeyPairInternal(bArr, bArr2);
    }

    public byte[][] generateKemKeyPairInternal(byte[] bArr, byte[] bArr2) {
        byte[][] bArrGenerateKeyPair = this.f20404indCpa.generateKeyPair(bArr);
        int i = this.IndCpaSecretKeyBytes;
        byte[] bArr3 = new byte[i];
        System.arraycopy(bArrGenerateKeyPair[1], 0, bArr3, 0, i);
        byte[] bArr4 = new byte[32];
        byte[] bArr5 = bArrGenerateKeyPair[0];
        m15564hash_H(bArr5, 0, bArr5.length, bArr4, 0);
        int i2 = this.IndCpaPublicKeyBytes;
        byte[] bArr6 = new byte[i2];
        System.arraycopy(bArrGenerateKeyPair[0], 0, bArr6, 0, i2);
        int i3 = i2 - 32;
        return new byte[][]{C6238Arrays.copyOfRange(bArr6, 0, i3), C6238Arrays.copyOfRange(bArr6, i3, i2), bArr3, bArr4, bArr2, C6238Arrays.concatenate(bArr, bArr2)};
    }

    public int getCipherTextBytes() {
        return this.CipherTextBytes;
    }

    /* renamed from: getEta1 */
    public int m15565getEta1() {
        return this.f20402Eta1;
    }

    public int getIndCpaPublicKeyBytes() {
        return this.IndCpaPublicKeyBytes;
    }

    public int getIndCpaSecretKeyBytes() {
        return this.IndCpaSecretKeyBytes;
    }

    /* renamed from: getK */
    public int m15566getK() {
        return this.f20403K;
    }

    public int getPolyCompressedBytes() {
        return this.PolyCompressedBytes;
    }

    public int getPolyVecBytes() {
        return this.PolyVecBytes;
    }

    public int getPolyVecCompressedBytes() {
        return this.PolyVecCompressedBytes;
    }

    public int getPublicKeyBytes() {
        return getIndCpaPublicKeyBytes();
    }

    public int getSecretKeyBytes() {
        return this.SecretKeyBytes;
    }

    public byte[] kemDecrypt(MLKEMPrivateKeyParameters mLKEMPrivateKeyParameters, byte[] bArr) {
        byte[] encoded = mLKEMPrivateKeyParameters.getEncoded();
        byte[] bArr2 = new byte[64];
        this.f20404indCpa.m15567decrypt(encoded, bArr, bArr2);
        System.arraycopy(encoded, this.SecretKeyBytes - 64, bArr2, 32, 32);
        byte[] bArr3 = new byte[64];
        m15563hash_G(bArr2, bArr3);
        int iConstantTimeZeroOnEqual = constantTimeZeroOnEqual(bArr, this.f20404indCpa.m15568encrypt(encoded, this.IndCpaSecretKeyBytes, bArr2, 0, bArr3, 32));
        byte[] bArr4 = new byte[32];
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        sHAKEDigest.mo14970update(encoded, this.SecretKeyBytes - 32, 32);
        sHAKEDigest.mo14970update(bArr, 0, this.CipherTextBytes);
        sHAKEDigest.mo14998doFinal(bArr4, 0, 32);
        m15562cmov(bArr3, bArr4, 32, iConstantTimeZeroOnEqual);
        return C6238Arrays.copyOfRange(bArr3, 0, 32);
    }

    public byte[][] kemEncrypt(MLKEMPublicKeyParameters mLKEMPublicKeyParameters, byte[] bArr) {
        byte[] encoded = mLKEMPublicKeyParameters.getEncoded();
        byte[] bArr2 = new byte[64];
        byte[] bArr3 = new byte[64];
        System.arraycopy(bArr, 0, bArr2, 0, 32);
        m15564hash_H(encoded, 0, encoded.length, bArr2, 32);
        m15563hash_G(bArr2, bArr3);
        byte[] bArrM15568encrypt = this.f20404indCpa.m15568encrypt(encoded, 0, bArr2, 0, bArr3, 32);
        byte[] bArr4 = new byte[32];
        System.arraycopy(bArr3, 0, bArr4, 0, 32);
        return new byte[][]{bArr4, bArrM15568encrypt};
    }
}
