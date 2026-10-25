package org.bouncycastle.p314pqc.p316crypto.p327saber;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.p199digests.Blake2xsDigest;
import org.bouncycastle.p314pqc.p316crypto.p327saber.Symmetric;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
class SABEREngine {
    public static final int SABER_EP = 10;
    private static final int SABER_HASHBYTES = 32;
    private static final int SABER_KEYBYTES = 32;

    /* renamed from: SABER_N */
    public static final int f23450SABER_N = 256;
    private static final int SABER_NOISE_SEEDBYTES = 32;
    private static final int SABER_SEEDBYTES = 32;
    private final int SABER_BYTES_CCA_DEC;
    private final int SABER_EQ;
    private final int SABER_ET;
    private final int SABER_INDCPA_PUBLICKEYBYTES;
    private final int SABER_INDCPA_SECRETKEYBYTES;

    /* renamed from: SABER_L */
    private final int f23451SABER_L;
    private final int SABER_MU;
    private final int SABER_POLYBYTES;
    private final int SABER_POLYCOINBYTES;
    private final int SABER_POLYCOMPRESSEDBYTES;
    private final int SABER_POLYVECBYTES;
    private final int SABER_POLYVECCOMPRESSEDBYTES;
    private final int SABER_PUBLICKEYBYTES;
    private final int SABER_SCALEBYTES_KEM;
    private final int SABER_SECRETKEYBYTES;
    private final int defaultKeySize;

    /* renamed from: h1 */
    private final int f23452h1;

    /* renamed from: h2 */
    private final int f23453h2;

    /* renamed from: poly */
    private final C6091Poly f23454poly;
    protected final Symmetric symmetric;
    private final boolean usingAES;
    protected final boolean usingEffectiveMasking;

    /* renamed from: utils */
    private final C6092Utils f23455utils;

    public SABEREngine(int i, int i2, boolean z, boolean z2) {
        int i3;
        this.defaultKeySize = i2;
        this.usingAES = z;
        this.usingEffectiveMasking = z2;
        this.f23451SABER_L = i;
        if (i == 2) {
            this.SABER_MU = 10;
            this.SABER_ET = 3;
        } else {
            if (i == 3) {
                this.SABER_MU = 8;
                i3 = 4;
            } else {
                i3 = 6;
                this.SABER_MU = 6;
            }
            this.SABER_ET = i3;
        }
        this.symmetric = z ? new Symmetric.AesSymmetric() : new Symmetric.ShakeSymmetric();
        if (z2) {
            this.SABER_EQ = 12;
            this.SABER_POLYCOINBYTES = 64;
        } else {
            this.SABER_EQ = 13;
            this.SABER_POLYCOINBYTES = (this.SABER_MU * 256) / 8;
        }
        int i4 = this.SABER_EQ;
        int i5 = (i4 * 256) / 8;
        this.SABER_POLYBYTES = i5;
        int i6 = i5 * i;
        this.SABER_POLYVECBYTES = i6;
        this.SABER_POLYCOMPRESSEDBYTES = 320;
        int i7 = i * 320;
        this.SABER_POLYVECCOMPRESSEDBYTES = i7;
        int i8 = this.SABER_ET;
        int i9 = (i8 * 256) / 8;
        this.SABER_SCALEBYTES_KEM = i9;
        int i10 = i7 + 32;
        this.SABER_INDCPA_PUBLICKEYBYTES = i10;
        this.SABER_INDCPA_SECRETKEYBYTES = i6;
        this.SABER_PUBLICKEYBYTES = i10;
        this.SABER_SECRETKEYBYTES = i6 + i10 + 64;
        this.SABER_BYTES_CCA_DEC = i7 + i9;
        this.f23452h1 = 1 << (i4 - 11);
        this.f23453h2 = (256 - (1 << (9 - i8))) + (1 << (i4 - 11));
        this.f23455utils = new C6092Utils(this);
        this.f23454poly = new C6091Poly(this);
    }

    /* renamed from: cmov */
    public static void m17806cmov(byte[] bArr, byte[] bArr2, int i, int i2, byte b) {
        byte b2 = (byte) (-b);
        for (int i3 = 0; i3 < i2; i3++) {
            byte b3 = bArr[i3];
            bArr[i3] = (byte) (b3 ^ ((bArr2[i3 + i] ^ b3) & b2));
        }
    }

    private void indcpa_kem_dec(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int[] iArr = {this.f23451SABER_L, 256};
        Class cls = Short.TYPE;
        short[][] sArr = (short[][]) Array.newInstance((Class<?>) cls, iArr);
        short[][] sArr2 = (short[][]) Array.newInstance((Class<?>) cls, this.f23451SABER_L, 256);
        short[] sArr3 = new short[256];
        short[] sArr4 = new short[256];
        this.f23455utils.BS2POLVECq(bArr, 0, sArr);
        this.f23455utils.BS2POLVECp(bArr2, sArr2);
        this.f23454poly.InnerProd(sArr2, sArr, sArr3);
        this.f23455utils.m17816BS2POLT(bArr2, this.SABER_POLYVECCOMPRESSEDBYTES, sArr4);
        for (int i = 0; i < 256; i++) {
            sArr3[i] = (short) ((((sArr3[i] + this.f23453h2) - (sArr4[i] << (10 - this.SABER_ET))) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) >> 9);
        }
        this.f23455utils.POLmsg2BS(bArr3, sArr3);
    }

    private void indcpa_kem_enc(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        int i = this.f23451SABER_L;
        int[] iArr = {i, i, 256};
        Class cls = Short.TYPE;
        short[][][] sArr = (short[][][]) Array.newInstance((Class<?>) cls, iArr);
        short[][] sArr2 = (short[][]) Array.newInstance((Class<?>) cls, this.f23451SABER_L, 256);
        short[][] sArr3 = (short[][]) Array.newInstance((Class<?>) cls, this.f23451SABER_L, 256);
        short[][] sArr4 = (short[][]) Array.newInstance((Class<?>) cls, this.f23451SABER_L, 256);
        short[] sArr5 = new short[256];
        short[] sArr6 = new short[256];
        this.f23454poly.GenMatrix(sArr, C6238Arrays.copyOfRange(bArr3, this.SABER_POLYVECCOMPRESSEDBYTES, bArr3.length));
        this.f23454poly.GenSecret(sArr2, bArr2);
        this.f23454poly.MatrixVectorMul(sArr, sArr2, sArr3, 0);
        for (int i2 = 0; i2 < this.f23451SABER_L; i2++) {
            for (int i3 = 0; i3 < 256; i3++) {
                short[] sArr7 = sArr3[i2];
                sArr7[i3] = (short) (((sArr7[i3] + this.f23452h1) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) >>> (this.SABER_EQ - 10));
            }
        }
        this.f23455utils.POLVECp2BS(bArr4, sArr3);
        this.f23455utils.BS2POLVECp(bArr3, sArr4);
        this.f23454poly.InnerProd(sArr4, sArr2, sArr6);
        this.f23455utils.BS2POLmsg(bArr, sArr5);
        for (int i4 = 0; i4 < 256; i4++) {
            sArr6[i4] = (short) ((((sArr6[i4] - (sArr5[i4] << 9)) + this.f23452h1) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) >>> (10 - this.SABER_ET));
        }
        this.f23455utils.m17818POLT2BS(bArr4, this.SABER_POLYVECCOMPRESSEDBYTES, sArr6);
    }

    private void indcpa_kem_keypair(byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
        int i = this.f23451SABER_L;
        int[] iArr = {i, i, 256};
        Class cls = Short.TYPE;
        short[][][] sArr = (short[][][]) Array.newInstance((Class<?>) cls, iArr);
        short[][] sArr2 = (short[][]) Array.newInstance((Class<?>) cls, this.f23451SABER_L, 256);
        short[][] sArr3 = (short[][]) Array.newInstance((Class<?>) cls, this.f23451SABER_L, 256);
        byte[] bArr3 = new byte[32];
        byte[] bArr4 = new byte[32];
        secureRandom.nextBytes(bArr3);
        this.symmetric.mo17812prf(bArr3, bArr3, 32, 32);
        secureRandom.nextBytes(bArr4);
        this.f23454poly.GenMatrix(sArr, bArr3);
        this.f23454poly.GenSecret(sArr2, bArr4);
        this.f23454poly.MatrixVectorMul(sArr, sArr2, sArr3, 1);
        for (int i2 = 0; i2 < this.f23451SABER_L; i2++) {
            for (int i3 = 0; i3 < 256; i3++) {
                short[] sArr4 = sArr3[i2];
                sArr4[i3] = (short) (((sArr4[i3] + this.f23452h1) & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) >>> (this.SABER_EQ - 10));
            }
        }
        this.f23455utils.POLVECq2BS(bArr2, sArr2);
        this.f23455utils.POLVECp2BS(bArr, sArr3);
        System.arraycopy(bArr3, 0, bArr, this.SABER_POLYVECCOMPRESSEDBYTES, 32);
    }

    /* renamed from: verify */
    public static int m17807verify(byte[] bArr, byte[] bArr2, int i) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j |= bArr[i2] ^ bArr2[i2];
        }
        return (int) ((-j) >>> 63);
    }

    public int crypto_kem_dec(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[this.SABER_BYTES_CCA_DEC];
        byte[] bArr5 = new byte[64];
        byte[] bArr6 = new byte[64];
        byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(bArr3, this.SABER_INDCPA_SECRETKEYBYTES, bArr3.length);
        indcpa_kem_dec(bArr3, bArr2, bArr5);
        for (int i = 0; i < 32; i++) {
            bArr5[i + 32] = bArr3[(this.SABER_SECRETKEYBYTES - 64) + i];
        }
        this.symmetric.mo17810hash_g(bArr6, bArr5);
        indcpa_kem_enc(bArr5, C6238Arrays.copyOfRange(bArr6, 32, 64), bArrCopyOfRange, bArr4);
        int iM17807verify = m17807verify(bArr2, bArr4, this.SABER_BYTES_CCA_DEC);
        this.symmetric.mo17811hash_h(bArr6, bArr2, 32);
        m17806cmov(bArr6, bArr3, this.SABER_SECRETKEYBYTES - 32, 32, (byte) iM17807verify);
        byte[] bArr7 = new byte[32];
        this.symmetric.mo17811hash_h(bArr7, bArr6, 0);
        System.arraycopy(bArr7, 0, bArr, 0, this.defaultKeySize / 8);
        return 0;
    }

    public int crypto_kem_enc(byte[] bArr, byte[] bArr2, byte[] bArr3, SecureRandom secureRandom) {
        byte[] bArr4 = new byte[64];
        byte[] bArr5 = new byte[64];
        byte[] bArr6 = new byte[32];
        secureRandom.nextBytes(bArr6);
        this.symmetric.mo17811hash_h(bArr6, bArr6, 0);
        System.arraycopy(bArr6, 0, bArr5, 0, 32);
        this.symmetric.mo17811hash_h(bArr5, bArr3, 32);
        this.symmetric.mo17810hash_g(bArr4, bArr5);
        indcpa_kem_enc(bArr5, C6238Arrays.copyOfRange(bArr4, 32, 64), bArr3, bArr);
        this.symmetric.mo17811hash_h(bArr4, bArr, 32);
        byte[] bArr7 = new byte[32];
        this.symmetric.mo17811hash_h(bArr7, bArr4, 0);
        System.arraycopy(bArr7, 0, bArr2, 0, this.defaultKeySize / 8);
        return 0;
    }

    public int crypto_kem_keypair(byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
        indcpa_kem_keypair(bArr, bArr2, secureRandom);
        for (int i = 0; i < this.SABER_INDCPA_PUBLICKEYBYTES; i++) {
            bArr2[this.SABER_INDCPA_SECRETKEYBYTES + i] = bArr[i];
        }
        this.symmetric.mo17811hash_h(bArr2, bArr, this.SABER_SECRETKEYBYTES - 64);
        byte[] bArr3 = new byte[32];
        secureRandom.nextBytes(bArr3);
        System.arraycopy(bArr3, 0, bArr2, this.SABER_SECRETKEYBYTES - 32, 32);
        return 0;
    }

    public int getCipherTextSize() {
        return this.SABER_BYTES_CCA_DEC;
    }

    public int getPrivateKeySize() {
        return this.SABER_SECRETKEYBYTES;
    }

    public int getPublicKeySize() {
        return this.SABER_PUBLICKEYBYTES;
    }

    public int getSABER_EP() {
        return 10;
    }

    public int getSABER_ET() {
        return this.SABER_ET;
    }

    public int getSABER_KEYBYTES() {
        return 32;
    }

    public int getSABER_L() {
        return this.f23451SABER_L;
    }

    public int getSABER_MU() {
        return this.SABER_MU;
    }

    public int getSABER_N() {
        return 256;
    }

    public int getSABER_NOISE_SEEDBYTES() {
        return 32;
    }

    public int getSABER_POLYBYTES() {
        return this.SABER_POLYBYTES;
    }

    public int getSABER_POLYCOINBYTES() {
        return this.SABER_POLYCOINBYTES;
    }

    public int getSABER_POLYVECBYTES() {
        return this.SABER_POLYVECBYTES;
    }

    public int getSABER_SEEDBYTES() {
        return 32;
    }

    public int getSessionKeySize() {
        return this.defaultKeySize / 8;
    }

    public C6092Utils getUtils() {
        return this.f23455utils;
    }
}
