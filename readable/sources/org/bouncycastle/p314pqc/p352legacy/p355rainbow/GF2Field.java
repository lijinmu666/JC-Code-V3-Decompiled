package org.bouncycastle.p314pqc.p352legacy.p355rainbow;

import java.lang.reflect.Array;
import org.bouncycastle.p361util.AbstractC6245Pack;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
class GF2Field {

    /* renamed from: MASK */
    public static final int f23997MASK = 255;
    static final byte[][] gfMulTable = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 256, 256);
    static final byte[] gfInvTable = new byte[256];

    static {
        long j;
        int i = 1;
        long j2 = 72340172838076673L;
        while (true) {
            j = 506097522914230528L;
            if (i > 255) {
                break;
            }
            for (int i2 = 0; i2 < 256; i2 += 8) {
                AbstractC6245Pack.longToLittleEndian(gf256Mul_64(j2, j), gfMulTable[i], i2);
                j += 578721382704613384L;
            }
            j2 += 72340172838076673L;
            i++;
        }
        for (int i3 = 0; i3 < 256; i3 += 8) {
            AbstractC6245Pack.longToLittleEndian(gf256Inv_64(j), gfInvTable, i3);
            j += 578721382704613384L;
        }
    }

    /* renamed from: addElem */
    public static short m18115addElem(short s, short s2) {
        return (short) (s ^ s2);
    }

    public static long addElem_64(long j, long j2) {
        return j ^ j2;
    }

    /* renamed from: gf16Mul */
    private static short m18116gf16Mul(short s, short s2) {
        short s3 = (short) (s & 3);
        short s4 = (short) ((s >>> 2) & 255);
        short s5 = (short) (s2 & 3);
        short s6 = (short) ((s2 >>> 2) & 255);
        short sM18118gf4Mul = m18118gf4Mul(s3, s5);
        short sM18118gf4Mul2 = m18118gf4Mul(s4, s6);
        return (short) ((((((short) (m18118gf4Mul((short) (s4 ^ s3), (short) (s6 ^ s5)) ^ sM18118gf4Mul)) << 2) ^ sM18118gf4Mul) ^ m18119gf4Mul2(sM18118gf4Mul2)) & 255);
    }

    private static short gf16Mul8(short s) {
        short s2 = (short) (s & 3);
        short s3 = (short) ((s >>> 2) & 255);
        return (short) ((m18120gf4Mul3(s3) | (m18119gf4Mul2((short) (s2 ^ s3)) << 2)) & 255);
    }

    private static long gf16Mul8_64(long j) {
        long j2 = 3689348814741910323L & j;
        long j3 = j & (-3689348814741910324L);
        long j4 = (j2 << 2) ^ j3;
        long j5 = j3 >>> 2;
        return j5 ^ gf4Mul2_64(j4 ^ j5);
    }

    private static long gf16Mul_64(long j, long j2) {
        long jGf4Mul_64 = gf4Mul_64(j, j2);
        long j3 = 3689348814741910323L & jGf4Mul_64;
        return (gf4Mul_64(((j ^ (j << 2)) & (-3689348814741910324L)) ^ ((jGf4Mul_64 & (-3689348814741910324L)) >>> 2), ((j2 ^ (j2 << 2)) & (-3689348814741910324L)) ^ 2459565876494606882L) ^ (j3 << 2)) ^ j3;
    }

    /* renamed from: gf16Squ */
    private static short m18117gf16Squ(short s) {
        short s2 = (short) (s & 3);
        short sM18121gf4Squ = m18121gf4Squ((short) ((s >>> 2) & 255));
        return (short) ((((sM18121gf4Squ << 2) ^ m18119gf4Mul2(sM18121gf4Squ)) ^ m18121gf4Squ(s2)) & 255);
    }

    private static long gf16Squ_64(long j) {
        long jGf4Squ_64 = gf4Squ_64(j);
        return jGf4Squ_64 ^ (gf4Mul2_64((-3689348814741910324L) & jGf4Squ_64) >>> 2);
    }

    private static short gf256Inv(short s) {
        short sGf256Squ = gf256Squ(s);
        short sGf256Squ2 = gf256Squ(sGf256Squ);
        short sGf256Mul = gf256Mul(gf256Mul(sGf256Squ2, sGf256Squ), gf256Squ(sGf256Squ2));
        return gf256Mul(sGf256Squ, gf256Squ(gf256Mul(gf256Squ(gf256Squ(gf256Squ(sGf256Mul))), sGf256Mul)));
    }

    private static long gf256Inv_64(long j) {
        long jGf256Squ_64 = gf256Squ_64(j);
        long jGf256Squ_642 = gf256Squ_64(jGf256Squ_64);
        long jGf256Mul_64 = gf256Mul_64(gf256Mul_64(jGf256Squ_642, jGf256Squ_64), gf256Squ_64(jGf256Squ_642));
        return gf256Mul_64(jGf256Squ_64, gf256Squ_64(gf256Mul_64(gf256Squ_64(gf256Squ_64(gf256Squ_64(jGf256Mul_64))), jGf256Mul_64)));
    }

    private static short gf256Mul(short s, short s2) {
        short s3 = (short) (s & 15);
        short s4 = (short) ((s >>> 4) & 255);
        short s5 = (short) (s2 & 15);
        short s6 = (short) ((s2 >>> 4) & 255);
        short sM18116gf16Mul = m18116gf16Mul(s3, s5);
        short sM18116gf16Mul2 = m18116gf16Mul(s4, s6);
        return (short) ((((((short) (m18116gf16Mul((short) (s4 ^ s3), (short) (s6 ^ s5)) ^ sM18116gf16Mul)) << 4) ^ sM18116gf16Mul) ^ gf16Mul8(sM18116gf16Mul2)) & 255);
    }

    private static long gf256Mul_64(long j, long j2) {
        long jGf16Mul_64 = gf16Mul_64(j, j2);
        long j3 = 1085102592571150095L & jGf16Mul_64;
        return (gf16Mul_64(((j ^ (j << 4)) & (-1085102592571150096L)) ^ ((jGf16Mul_64 & (-1085102592571150096L)) >>> 4), ((j2 ^ (j2 << 4)) & (-1085102592571150096L)) ^ 578721382704613384L) ^ (j3 << 4)) ^ j3;
    }

    private static short gf256Squ(short s) {
        short s2 = (short) (s & 15);
        short sM18117gf16Squ = m18117gf16Squ((short) ((s >>> 4) & 255));
        return (short) ((((sM18117gf16Squ << 4) ^ gf16Mul8(sM18117gf16Squ)) ^ m18117gf16Squ(s2)) & 255);
    }

    private static long gf256Squ_64(long j) {
        long jGf16Squ_64 = gf16Squ_64(j);
        return jGf16Squ_64 ^ (gf16Mul8_64((-1085102592571150096L) & jGf16Squ_64) >>> 4);
    }

    /* renamed from: gf4Mul */
    private static short m18118gf4Mul(short s, short s2) {
        return (short) (((m18119gf4Mul2(s) * (s2 >>> 1)) ^ ((s2 & 1) * s)) & 255);
    }

    /* renamed from: gf4Mul2 */
    private static short m18119gf4Mul2(short s) {
        return (short) ((((s >>> 1) * 7) ^ (s << 1)) & 255);
    }

    private static long gf4Mul2_64(long j) {
        long j2 = 6148914691236517205L & j;
        long j3 = j & (-6148914691236517206L);
        return (j3 >>> 1) ^ ((j2 << 1) ^ j3);
    }

    /* renamed from: gf4Mul3 */
    private static short m18120gf4Mul3(short s) {
        int i = (s - 2) >>> 1;
        return (short) ((((s - 1) & (~i)) | ((s * 3) & i)) & 255);
    }

    private static long gf4Mul_64(long j, long j2) {
        long j3 = (((j << 1) & j2) ^ ((j2 << 1) & j)) & (-6148914691236517206L);
        long j4 = j & j2;
        return ((j4 & (-6148914691236517206L)) >>> 1) ^ (j4 ^ j3);
    }

    /* renamed from: gf4Squ */
    private static short m18121gf4Squ(short s) {
        return (short) ((s ^ (s >>> 1)) & 255);
    }

    private static long gf4Squ_64(long j) {
        return j ^ (((-6148914691236517206L) & j) >>> 1);
    }

    /* renamed from: invElem */
    public static short m18122invElem(short s) {
        return (short) (gfInvTable[s] & C1126UByte.MAX_VALUE);
    }

    public static long invElem_64(long j) {
        return gf256Inv_64(j);
    }

    public static short multElem(short s, short s2) {
        return (short) (gfMulTable[s][s2] & C1126UByte.MAX_VALUE);
    }

    public static long multElem_64(long j, long j2) {
        return gf256Mul_64(j, j2);
    }
}
