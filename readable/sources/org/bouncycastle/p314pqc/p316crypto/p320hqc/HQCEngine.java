package org.bouncycastle.p314pqc.p316crypto.p320hqc;

import java.security.SecureRandom;
import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.bouncycastle.p194crypto.p199digests.SHA3Digest;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
class HQCEngine {
    private static final int SALT_BYTES = 16;
    private static final int SEED_BYTES = 32;
    private final int N1N2_BYTE;
    private final int N1N2_BYTE_64;

    /* renamed from: N_BYTE */
    private final int f23183N_BYTE;
    private final int cipherTextBytes;

    /* renamed from: delta */
    private final int f23184delta;

    /* renamed from: fft */
    private final int f23185fft;
    private final int[] generatorPoly;

    /* renamed from: gf2x */
    private final C6064GF2x f23186gf2x;

    /* renamed from: k */
    private final int f23187k;
    private final int mulParam;

    /* renamed from: n */
    private final int f23188n;

    /* renamed from: n1 */
    private final int f23189n1;

    /* renamed from: nMu */
    private final int f23190nMu;

    /* renamed from: pkSize */
    private final int f23191pkSize;
    private final int rejectionThreshold;

    /* renamed from: w */
    private final int f23192w;

    /* renamed from: wr */
    private final int f23193wr;

    public HQCEngine(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int[] iArr) {
        this.f23188n = i;
        this.f23187k = i4;
        this.f23184delta = i5;
        this.f23192w = i6;
        this.f23193wr = i7;
        this.f23189n1 = i2;
        this.generatorPoly = iArr;
        this.f23185fft = i8;
        this.f23190nMu = i9;
        this.f23191pkSize = i10;
        this.mulParam = i3 >> 7;
        int byteSizeFromBitSize = C6065Utils.getByteSizeFromBitSize(i);
        this.f23183N_BYTE = byteSizeFromBitSize;
        int i11 = i2 * i3;
        this.N1N2_BYTE_64 = C6065Utils.getByte64SizeFromBitSize(i11);
        int byteSizeFromBitSize2 = C6065Utils.getByteSizeFromBitSize(i11);
        this.N1N2_BYTE = byteSizeFromBitSize2;
        this.f23186gf2x = new C6064GF2x(i);
        this.rejectionThreshold = (16777216 / i) * i;
        this.cipherTextBytes = byteSizeFromBitSize + byteSizeFromBitSize2 + 16;
    }

    private int barrettReduce(int i) {
        int i2 = (int) ((i * this.f23190nMu) >>> 32);
        int i3 = this.f23188n;
        int i4 = (i - i3) - (i2 * i3);
        return i4 + (i3 & (i4 >> 31));
    }

    /* renamed from: cdiff */
    private static int m17587cdiff(int i, int i2) {
        return ((i - i2) | (i2 - i)) >> 31;
    }

    private void generateRandomSupport(int[] iArr, int i, Shake256RandomGenerator shake256RandomGenerator) {
        int i2 = i * 3;
        byte[] bArr = new byte[i2];
        int i3 = i2;
        int i4 = 0;
        while (i4 < i) {
            if (i3 == i2) {
                shake256RandomGenerator.xofGetBytes(bArr, i2);
                i3 = 0;
            }
            int i5 = i3 + 2;
            int i6 = ((bArr[i3 + 1] & C1126UByte.MAX_VALUE) << 8) | ((bArr[i3] & C1126UByte.MAX_VALUE) << 16);
            i3 += 3;
            int i7 = i6 | (bArr[i5] & C1126UByte.MAX_VALUE);
            if (i7 < this.rejectionThreshold) {
                int iBarrettReduce = barrettReduce(i7);
                int i8 = 0;
                while (true) {
                    if (i8 >= i4) {
                        iArr[i4] = iBarrettReduce;
                        i4++;
                        break;
                    } else if (iArr[i8] == iBarrettReduce) {
                        break;
                    } else {
                        i8++;
                    }
                }
            }
        }
    }

    /* renamed from: hashGJ */
    private static void m17588hashGJ(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, int i2, int i3, byte[] bArr4, int i4, int i5, byte b) {
        SHA3Digest sHA3Digest = new SHA3Digest(i);
        sHA3Digest.mo14970update(bArr2, 0, bArr2.length);
        sHA3Digest.mo14970update(bArr3, i2, i3);
        sHA3Digest.mo14970update(bArr4, i4, i5);
        sHA3Digest.mo14969update(b);
        sHA3Digest.mo14967doFinal(bArr, 0);
    }

    /* renamed from: hashHI */
    private static void m17589hashHI(byte[] bArr, int i, byte[] bArr2, int i2, byte b) {
        SHA3Digest sHA3Digest = new SHA3Digest(i);
        sHA3Digest.mo14970update(bArr2, 0, i2);
        sHA3Digest.mo14969update(b);
        sHA3Digest.mo14967doFinal(bArr, 0);
    }

    private void pkeEncrypt(long[] jArr, long[] jArr2, byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        long[] jArrM17583create = this.f23186gf2x.m17583create();
        long[] jArrM17583create2 = this.f23186gf2x.m17583create();
        int i2 = this.f23189n1;
        byte[] bArr4 = new byte[i2];
        ReedSolomon.m17596encode(bArr4, bArr2, i2, this.f23187k, this.generatorPoly);
        ReedMuller.m17594encode(jArr2, bArr4, this.f23189n1, this.mulParam);
        Shake256RandomGenerator shake256RandomGenerator = new Shake256RandomGenerator(bArr, 0, 32, (byte) 1);
        this.f23186gf2x.m17586random(shake256RandomGenerator, jArrM17583create2);
        shake256RandomGenerator.m17597init(bArr3, i, 32, (byte) 1);
        vectSampleFixedWeights2(shake256RandomGenerator, jArrM17583create, this.f23193wr);
        this.f23186gf2x.m17585mul(jArrM17583create2, jArrM17583create, jArr);
        C6065Utils.fromByteArrayToLongArray(jArrM17583create2, bArr, 32, this.f23191pkSize - 32);
        this.f23186gf2x.m17585mul(jArrM17583create2, jArrM17583create, jArrM17583create2);
        vectSampleFixedWeights2(shake256RandomGenerator, jArrM17583create, this.f23193wr);
        this.f23186gf2x.m17581addTo(jArrM17583create, jArrM17583create2);
        vectTruncate(jArrM17583create2);
        AbstractC5869Nat.m16952xorTo64(this.N1N2_BYTE_64, jArrM17583create2, jArr2);
        vectSampleFixedWeights2(shake256RandomGenerator, jArrM17583create2, this.f23193wr);
        this.f23186gf2x.m17581addTo(jArrM17583create2, jArr);
        this.f23186gf2x.m17582clear(jArrM17583create);
        this.f23186gf2x.m17582clear(jArrM17583create2);
        C6238Arrays.m18227clear(bArr4);
    }

    private void vectSampleFixedWeight1(long[] jArr, Shake256RandomGenerator shake256RandomGenerator, int i) {
        int[] iArr = new int[this.f23193wr];
        generateRandomSupport(iArr, i, shake256RandomGenerator);
        writeSupportToVector(jArr, iArr, i);
    }

    private void vectSampleFixedWeights2(Shake256RandomGenerator shake256RandomGenerator, long[] jArr, int i) {
        int i2 = this.f23193wr << 2;
        byte[] bArr = new byte[i2];
        shake256RandomGenerator.xofGetBytes(bArr, i2);
        int[] iArr = new int[this.f23193wr];
        AbstractC6245Pack.littleEndianToInt(bArr, 0, iArr);
        int i3 = i;
        while (true) {
            int i4 = i3 - 1;
            if (i4 < 0) {
                writeSupportToVector(jArr, iArr, i);
                return;
            }
            int i5 = ((int) (((iArr[i4] & BodyPartID.bodyIdMax) * (this.f23188n - i4)) >> 32)) + i4;
            int iM17587cdiff = -1;
            while (i3 < i) {
                iM17587cdiff &= m17587cdiff(i5, iArr[i3]);
                i3++;
            }
            iArr[i4] = ((~iM17587cdiff) & i4) ^ (i5 & iM17587cdiff);
            i3 = i4;
        }
    }

    private void vectTruncate(long[] jArr) {
        C6238Arrays.m18255fill(jArr, this.N1N2_BYTE_64, (this.f23188n + 63) >> 6, 0L);
    }

    private void writeSupportToVector(long[] jArr, int[] iArr, int i) {
        int i2 = this.f23193wr;
        int[] iArr2 = new int[i2];
        long[] jArr2 = new long[i2];
        for (int i3 = 0; i3 < i; i3++) {
            iArr2[i3] = iArr[i3] >>> 6;
            jArr2[i3] = 1 << (iArr[i3] & 63);
        }
        for (int i4 = 0; i4 < jArr.length; i4++) {
            long j = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i4 - iArr2[i5];
                j |= jArr2[i5] & (~((i6 | (-i6)) >> 31));
            }
            jArr[i4] = j;
        }
    }

    /* renamed from: decaps */
    public int m17590decaps(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        long[] jArrM17583create = this.f23186gf2x.m17583create();
        long[] jArrM17583create2 = this.f23186gf2x.m17583create();
        long[] jArrM17583create3 = this.f23186gf2x.m17583create();
        long[] jArrM17583create4 = this.f23186gf2x.m17583create();
        byte[] bArr4 = new byte[32];
        byte[] bArr5 = new byte[64];
        int i = this.f23187k;
        byte[] bArr6 = new byte[i];
        byte[] bArr7 = new byte[32];
        byte[] bArr8 = new byte[this.f23189n1];
        vectSampleFixedWeight1(jArrM17583create4, new Shake256RandomGenerator(bArr3, this.f23191pkSize, 32, (byte) 1), this.f23192w);
        C6065Utils.fromByteArrayToLongArray(jArrM17583create, bArr2, 0, this.f23183N_BYTE);
        C6065Utils.fromByteArrayToLongArray(jArrM17583create2, bArr2, this.f23183N_BYTE, this.N1N2_BYTE);
        this.f23186gf2x.m17585mul(jArrM17583create4, jArrM17583create, jArrM17583create3);
        vectTruncate(jArrM17583create3);
        this.f23186gf2x.m17581addTo(jArrM17583create2, jArrM17583create3);
        ReedMuller.m17593decode(bArr8, jArrM17583create3, this.f23189n1, this.mulParam);
        ReedSolomon.m17595decode(bArr6, bArr8, this.f23189n1, this.f23185fft, this.f23184delta, this.f23187k, this.generatorPoly.length);
        m17589hashHI(bArr4, 256, bArr3, this.f23191pkSize, (byte) 1);
        m17588hashGJ(bArr5, 512, bArr4, bArr6, 0, i, bArr2, this.f23183N_BYTE + this.N1N2_BYTE, 16, (byte) 0);
        System.arraycopy(bArr5, 0, bArr, 0, 32);
        C6238Arrays.m18256fill(jArrM17583create4, 0L);
        pkeEncrypt(jArrM17583create3, jArrM17583create4, bArr3, bArr6, bArr5, 32);
        m17588hashGJ(bArr7, 256, bArr4, bArr3, this.f23191pkSize + 32, this.f23187k, bArr2, 0, bArr2.length, (byte) 3);
        int iM17584equalTo = (int) (this.f23186gf2x.m17584equalTo(jArrM17583create, jArrM17583create3) & this.f23186gf2x.m17584equalTo(jArrM17583create2, jArrM17583create4));
        for (int i2 = 0; i2 < this.f23187k; i2++) {
            bArr[i2] = (byte) (((bArr[i2] & iM17584equalTo) ^ (bArr7[i2] & (~iM17584equalTo))) & 255);
        }
        this.f23186gf2x.m17582clear(jArrM17583create);
        this.f23186gf2x.m17582clear(jArrM17583create2);
        this.f23186gf2x.m17582clear(jArrM17583create3);
        this.f23186gf2x.m17582clear(jArrM17583create4);
        C6238Arrays.m18227clear(bArr4);
        C6238Arrays.m18227clear(bArr5);
        C6238Arrays.m18227clear(bArr6);
        C6238Arrays.m18227clear(bArr7);
        C6238Arrays.m18227clear(bArr8);
        return -iM17584equalTo;
    }

    /* renamed from: encaps */
    public void m17591encaps(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, SecureRandom secureRandom) {
        int i = this.f23187k;
        byte[] bArr6 = new byte[i];
        byte[] bArr7 = new byte[32];
        long[] jArrM17583create = this.f23186gf2x.m17583create();
        long[] jArr = new long[this.N1N2_BYTE_64];
        secureRandom.nextBytes(bArr6);
        secureRandom.nextBytes(bArr5);
        m17589hashHI(bArr7, 256, bArr4, bArr4.length, (byte) 1);
        m17588hashGJ(bArr3, 512, bArr7, bArr6, 0, i, bArr5, 0, 16, (byte) 0);
        pkeEncrypt(jArrM17583create, jArr, bArr4, bArr6, bArr3, 32);
        C6065Utils.fromLongArrayToByteArray(bArr, 0, bArr.length, jArrM17583create);
        C6065Utils.fromLongArrayToByteArray(bArr2, 0, bArr2.length, jArr);
        this.f23186gf2x.m17582clear(jArrM17583create);
        C6238Arrays.m18230clear(jArr);
        C6238Arrays.m18227clear(bArr6);
        C6238Arrays.m18227clear(bArr7);
    }

    public void genKeyPair(byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
        byte[] bArr3 = new byte[32];
        byte[] bArr4 = new byte[64];
        long[] jArrM17583create = this.f23186gf2x.m17583create();
        long[] jArrM17583create2 = this.f23186gf2x.m17583create();
        long[] jArrM17583create3 = this.f23186gf2x.m17583create();
        secureRandom.nextBytes(bArr3);
        Shake256RandomGenerator shake256RandomGenerator = new Shake256RandomGenerator(bArr3, (byte) 1);
        System.arraycopy(bArr3, 0, bArr2, this.f23191pkSize + 32 + this.f23187k, 32);
        shake256RandomGenerator.nextBytes(bArr3);
        shake256RandomGenerator.nextBytes(bArr2, this.f23191pkSize + 32, this.f23187k);
        m17589hashHI(bArr4, 512, bArr3, 32, (byte) 2);
        shake256RandomGenerator.m17597init(bArr4, 0, 32, (byte) 1);
        vectSampleFixedWeight1(jArrM17583create2, shake256RandomGenerator, this.f23192w);
        vectSampleFixedWeight1(jArrM17583create, shake256RandomGenerator, this.f23192w);
        System.arraycopy(bArr4, 32, bArr, 0, 32);
        shake256RandomGenerator.m17597init(bArr4, 32, 32, (byte) 1);
        this.f23186gf2x.m17586random(shake256RandomGenerator, jArrM17583create3);
        this.f23186gf2x.m17585mul(jArrM17583create3, jArrM17583create2, jArrM17583create3);
        this.f23186gf2x.m17581addTo(jArrM17583create, jArrM17583create3);
        C6065Utils.fromLongArrayToByteArray(bArr, 32, bArr.length - 32, jArrM17583create3);
        System.arraycopy(bArr4, 0, bArr2, this.f23191pkSize, 32);
        System.arraycopy(bArr, 0, bArr2, 0, this.f23191pkSize);
        C6238Arrays.m18227clear(bArr4);
        this.f23186gf2x.m17582clear(jArrM17583create);
        this.f23186gf2x.m17582clear(jArrM17583create2);
        this.f23186gf2x.m17582clear(jArrM17583create3);
    }

    public int getCipherTextBytes() {
        return this.cipherTextBytes;
    }
}
