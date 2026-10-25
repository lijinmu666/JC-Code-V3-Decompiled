package org.bouncycastle.p284math.p295raw;

import org.bouncycastle.p194crypto.p199digests.Blake2xsDigest;

/* loaded from: classes2.dex */
public class Interleave {

    /* renamed from: M32 */
    private static final long f22479M32 = 1431655765;

    /* renamed from: M64 */
    private static final long f22480M64 = 6148914691236517205L;

    /* renamed from: M64R */
    private static final long f22481M64R = -6148914691236517206L;

    public static int expand16to32(int i) {
        int i2 = i & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH;
        int i3 = (i2 | (i2 << 8)) & 16711935;
        int i4 = (i3 | (i3 << 4)) & 252645135;
        int i5 = (i4 | (i4 << 2)) & 858993459;
        return (i5 | (i5 << 1)) & 1431655765;
    }

    public static long expand32to64(int i) {
        return (((r6 >>> 1) & f22479M32) << 32) | (f22479M32 & AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(i, 65280, 8), 15728880, 4), 202116108, 2), 572662306, 1));
    }

    public static void expand64To128(long j, long[] jArr, int i) {
        long jBitPermuteStep = AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(j, 4294901760L, 16), 280375465148160L, 8), 67555025218437360L, 4), 868082074056920076L, 2), 2459565876494606882L, 1);
        jArr[i] = jBitPermuteStep & f22480M64;
        jArr[i + 1] = (jBitPermuteStep >>> 1) & f22480M64;
    }

    public static void expand64To128Rev(long j, long[] jArr, int i) {
        long jBitPermuteStep = AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(j, 4294901760L, 16), 280375465148160L, 8), 67555025218437360L, 4), 868082074056920076L, 2), 2459565876494606882L, 1);
        jArr[i] = jBitPermuteStep & f22481M64R;
        jArr[i + 1] = (jBitPermuteStep << 1) & f22481M64R;
    }

    public static int expand8to16(int i) {
        int i2 = i & 255;
        int i3 = (i2 | (i2 << 4)) & 3855;
        int i4 = (i3 | (i3 << 2)) & 13107;
        return (i4 | (i4 << 1)) & 21845;
    }

    /* renamed from: shuffle */
    public static int m16877shuffle(int i) {
        return AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(i, 65280, 8), 15728880, 4), 202116108, 2), 572662306, 1);
    }

    public static int shuffle2(int i) {
        return AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(i, 11141290, 7), 52428, 14), 15728880, 4), 65280, 8);
    }

    public static long shuffle3(long j) {
        return AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(j, 47851476196393130L, 7), 225176545447116L, 14), 4042322160L, 28);
    }

    public static int unshuffle(int i) {
        return AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(i, 572662306, 1), 202116108, 2), 15728880, 4), 65280, 8);
    }

    public static int unshuffle2(int i) {
        return AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(i, 65280, 8), 15728880, 4), 52428, 14), 11141290, 7);
    }

    public static long unshuffle3(long j) {
        return shuffle3(j);
    }

    public static void expand64To128(long[] jArr, int i, int i2, long[] jArr2, int i3) {
        for (int i4 = 0; i4 < i2; i4++) {
            expand64To128(jArr[i + i4], jArr2, i3);
            i3 += 2;
        }
    }

    /* renamed from: shuffle */
    public static long m16878shuffle(long j) {
        return AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(j, 4294901760L, 16), 280375465148160L, 8), 67555025218437360L, 4), 868082074056920076L, 2), 2459565876494606882L, 1);
    }

    public static long shuffle2(long j) {
        return AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(j, 4278255360L, 24), 57421771435671756L, 6), 264913582878960L, 12), 723401728380766730L, 3);
    }

    public static long unshuffle(long j) {
        return AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(j, 2459565876494606882L, 1), 868082074056920076L, 2), 67555025218437360L, 4), 280375465148160L, 8), 4294901760L, 16);
    }

    public static long unshuffle2(long j) {
        return AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(AbstractC5866Bits.bitPermuteStep(j, 723401728380766730L, 3), 264913582878960L, 12), 57421771435671756L, 6), 4278255360L, 24);
    }
}
