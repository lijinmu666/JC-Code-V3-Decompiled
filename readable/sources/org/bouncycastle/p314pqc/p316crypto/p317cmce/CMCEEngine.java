package org.bouncycastle.p314pqc.p316crypto.p317cmce;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.bouncycastle.p194crypto.p199digests.Blake2xsDigest;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p361util.C6238Arrays;
import p094kotlin.C1126UByte;
import p094kotlin.p105jvm.internal.LongCompanionObject;

/* loaded from: classes2.dex */
class CMCEEngine {
    private int COND_BYTES;

    /* renamed from: GFBITS */
    private int f23061GFBITS;

    /* renamed from: GFMASK */
    private int f23062GFMASK;
    private int IRR_BYTES;
    private int PK_NCOLS;
    private int PK_NROWS;
    private int PK_ROW_BYTES;
    private int SYND_BYTES;

    /* renamed from: SYS_N */
    private int f23063SYS_N;

    /* renamed from: SYS_T */
    private int f23064SYS_T;

    /* renamed from: benes */
    private AbstractC6051BENES f23065benes;
    private boolean countErrorIndices;
    private final int defaultKeySize;

    /* renamed from: gf */
    private AbstractC6054GF f23066gf;

    /* renamed from: poly */
    private int[] f23067poly;
    private boolean usePadding;
    private boolean usePivots;

    public CMCEEngine(int i, int i2, int i3, int[] iArr, boolean z, int i4) {
        AbstractC6051BENES c6053benes13;
        this.usePivots = z;
        this.f23063SYS_N = i2;
        this.f23064SYS_T = i3;
        this.f23061GFBITS = i;
        this.f23067poly = iArr;
        this.defaultKeySize = i4;
        this.IRR_BYTES = i3 * 2;
        this.COND_BYTES = (1 << (i - 4)) * ((i * 2) - 1);
        int i5 = i3 * i;
        this.PK_NROWS = i5;
        int i6 = i2 - i5;
        this.PK_NCOLS = i6;
        this.PK_ROW_BYTES = (i6 + 7) / 8;
        this.SYND_BYTES = (i5 + 7) / 8;
        this.f23062GFMASK = (1 << i) - 1;
        if (i == 12) {
            this.f23066gf = new C6055GF12();
            c6053benes13 = new C6052BENES12(this.f23063SYS_N, this.f23064SYS_T, this.f23061GFBITS);
        } else {
            this.f23066gf = new C6056GF13();
            c6053benes13 = new C6053BENES13(this.f23063SYS_N, this.f23064SYS_T, this.f23061GFBITS);
        }
        this.f23065benes = c6053benes13;
        this.usePadding = this.f23064SYS_T % 8 != 0;
        this.countErrorIndices = (1 << this.f23061GFBITS) > this.f23063SYS_N;
    }

    /* renamed from: bm */
    private void m17481bm(short[] sArr, short[] sArr2) {
        int i;
        int i2 = this.f23064SYS_T;
        short[] sArr3 = new short[i2 + 1];
        short[] sArr4 = new short[i2 + 1];
        short s = 1;
        short[] sArr5 = new short[i2 + 1];
        int i3 = 0;
        for (int i4 = 0; i4 < this.f23064SYS_T + 1; i4++) {
            sArr5[i4] = 0;
            sArr4[i4] = 0;
        }
        sArr4[0] = 1;
        sArr5[1] = 1;
        short s2 = 1;
        short s3 = 0;
        short s4 = 0;
        while (s3 < this.f23064SYS_T * 2) {
            int iGf_mul_ext = 0;
            for (int i5 = 0; i5 <= m17487min(s3, this.f23064SYS_T); i5++) {
                iGf_mul_ext ^= this.f23066gf.gf_mul_ext(sArr4[i5], sArr2[s3 - i5]);
            }
            short sGf_reduce = this.f23066gf.gf_reduce(iGf_mul_ext);
            short s5 = (short) (((short) (((short) (((short) (sGf_reduce - 1)) >> 15)) & s)) - s);
            short s6 = (short) (((short) (((short) (((short) (((short) (s3 - (s4 * 2))) >> 15)) & s)) - s)) & s5);
            for (int i6 = 0; i6 <= this.f23064SYS_T; i6++) {
                sArr3[i6] = sArr4[i6];
            }
            short sMo17504gf_frac = this.f23066gf.mo17504gf_frac(s2, sGf_reduce);
            int i7 = 0;
            while (true) {
                i = this.f23064SYS_T;
                if (i7 > i) {
                    break;
                }
                sArr4[i7] = (short) ((this.f23066gf.mo17506gf_mul(sMo17504gf_frac, sArr5[i7]) & s5) ^ sArr4[i7]);
                i7++;
            }
            int i8 = ~s6;
            int i9 = s3 + 1;
            s4 = (short) (((i9 - s4) & s6) | (s4 & i8));
            for (int i10 = i - 1; i10 >= 0; i10--) {
                sArr5[i10 + 1] = (short) ((sArr5[i10] & i8) | (sArr3[i10] & s6));
            }
            sArr5[0] = 0;
            s2 = (short) ((i8 & s2) | (sGf_reduce & s6));
            s3 = (short) i9;
            s = 1;
        }
        while (true) {
            int i11 = this.f23064SYS_T;
            if (i3 > i11) {
                return;
            }
            sArr[i3] = sArr4[i11 - i3];
            i3++;
        }
    }

    public static void cbrecursion(byte[] bArr, long j, long j2, short[] sArr, int i, long j3, long j4, int[] iArr) {
        long j5;
        long j6 = j4;
        if (j3 == 1) {
            int i2 = (int) (j >> 3);
            bArr[i2] = (byte) ((get_q_short(iArr, i) << ((int) (j & 7))) ^ bArr[i2]);
            return;
        }
        if (sArr != null) {
            for (long j7 = 0; j7 < j6; j7++) {
                int i3 = (int) j7;
                iArr[i3] = sArr[(int) (j7 ^ 1)] | ((sArr[i3] ^ 1) << 16);
            }
        } else {
            for (long j8 = 0; j8 < j6; j8++) {
                long j9 = i;
                iArr[(int) j8] = ((get_q_short(iArr, (int) (j9 + j8)) ^ 1) << 16) | get_q_short(iArr, (int) (j9 + (j8 ^ 1)));
            }
        }
        int i4 = (int) j6;
        m17490sort32(iArr, 0, i4);
        for (long j10 = 0; j10 < j6; j10++) {
            int i5 = (int) j10;
            int i6 = 65535 & iArr[i5];
            if (j10 >= i6) {
                i5 = i6;
            }
            iArr[(int) (j6 + j10)] = i5 | (i6 << 16);
        }
        for (long j11 = 0; j11 < j6; j11++) {
            iArr[(int) j11] = (int) ((iArr[r7] << 16) | j11);
        }
        m17490sort32(iArr, 0, i4);
        for (long j12 = 0; j12 < j6; j12++) {
            int i7 = (int) j12;
            iArr[i7] = (iArr[i7] << 16) + (iArr[(int) (j6 + j12)] >> 16);
        }
        m17490sort32(iArr, 0, i4);
        if (j3 <= 10) {
            for (long j13 = 0; j13 < j6; j13++) {
                int i8 = (int) (j6 + j13);
                iArr[i8] = ((iArr[(int) j13] & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) << 10) | (iArr[i8] & 1023);
            }
            long j14 = 1;
            for (long j15 = 1; j14 < j3 - j15; j15 = 1) {
                long j16 = 0;
                while (j16 < j6) {
                    iArr[(int) j16] = (int) (((iArr[(int) (j6 + j16)] & (-1024)) << 6) | j16);
                    j16++;
                    j14 = j14;
                }
                long j17 = j14;
                m17490sort32(iArr, 0, i4);
                for (long j18 = 0; j18 < j6; j18++) {
                    int i9 = (int) j18;
                    iArr[i9] = (iArr[i9] << 20) | iArr[(int) (j6 + j18)];
                }
                m17490sort32(iArr, 0, i4);
                for (long j19 = 0; j19 < j6; j19++) {
                    int i10 = iArr[(int) j19];
                    int i11 = 1048575 & i10;
                    int i12 = (int) (j6 + j19);
                    int i13 = (i10 & 1047552) | (iArr[i12] & 1023);
                    if (i11 >= i13) {
                        i11 = i13;
                    }
                    iArr[i12] = i11;
                }
                j14 = j17 + 1;
            }
            for (long j20 = 0; j20 < j6; j20++) {
                int i14 = (int) (j6 + j20);
                iArr[i14] = iArr[i14] & 1023;
            }
        } else {
            for (long j21 = 0; j21 < j6; j21++) {
                int i15 = (int) (j6 + j21);
                iArr[i15] = (iArr[(int) j21] << 16) | (iArr[i15] & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH);
            }
            long j22 = 1;
            for (long j23 = 1; j22 < j3 - j23; j23 = 1) {
                for (long j24 = 0; j24 < j6; j24++) {
                    iArr[(int) j24] = (int) ((iArr[(int) (j6 + j24)] & (-65536)) | j24);
                }
                m17490sort32(iArr, 0, i4);
                for (long j25 = 0; j25 < j6; j25++) {
                    int i16 = (int) j25;
                    iArr[i16] = (iArr[i16] << 16) | (iArr[(int) (j6 + j25)] & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH);
                }
                if (j22 < j3 - 2) {
                    for (long j26 = 0; j26 < j6; j26++) {
                        int i17 = (int) (j6 + j26);
                        iArr[i17] = (iArr[(int) j26] & (-65536)) | (iArr[i17] >> 16);
                    }
                    m17490sort32(iArr, i4, (int) (j6 * 2));
                    for (long j27 = 0; j27 < j6; j27++) {
                        int i18 = (int) (j6 + j27);
                        iArr[i18] = (iArr[i18] << 16) | (iArr[(int) j27] & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH);
                    }
                }
                m17490sort32(iArr, 0, i4);
                for (long j28 = 0; j28 < j6; j28++) {
                    int i19 = (int) (j6 + j28);
                    int i20 = iArr[i19];
                    int i21 = (i20 & (-65536)) | (iArr[(int) j28] & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH);
                    if (i21 < i20) {
                        iArr[i19] = i21;
                    }
                }
                j22++;
            }
            for (long j29 = 0; j29 < j6; j29++) {
                int i22 = (int) (j6 + j29);
                iArr[i22] = iArr[i22] & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH;
            }
        }
        long j30 = 0;
        if (sArr != null) {
            while (j30 < j6) {
                iArr[(int) j30] = (int) ((sArr[r0] << 16) + j30);
                j30++;
            }
        } else {
            while (j30 < j6) {
                iArr[(int) j30] = (int) ((get_q_short(iArr, (int) (i + j30)) << 16) + j30);
                j30++;
            }
        }
        m17490sort32(iArr, 0, i4);
        long j31 = j;
        long j32 = 2;
        long j33 = 0;
        while (true) {
            j5 = j6 / j32;
            if (j33 >= j5) {
                break;
            }
            long j34 = j33 * j32;
            long j35 = j6 + j34;
            int i23 = (int) j35;
            int i24 = iArr[i23] & 1;
            int i25 = (int) (i24 + j34);
            int i26 = (int) (j31 >> 3);
            bArr[i26] = (byte) ((i24 << ((int) (j31 & 7))) ^ bArr[i26]);
            j31 += j2;
            iArr[i23] = (iArr[(int) j34] << 16) | i25;
            iArr[(int) (j35 + 1)] = (iArr[(int) (j34 + 1)] << 16) | (i25 ^ 1);
            j33++;
            j6 = j4;
            i4 = i4;
            j32 = 2;
        }
        long j36 = j32;
        long j37 = j4 * j36;
        m17490sort32(iArr, i4, (int) j37);
        long j38 = j3 * j36;
        long j39 = j31 + ((j38 - 3) * j2 * j5);
        long j40 = 0;
        while (j40 < j5) {
            long j41 = j40 * j36;
            long j42 = j4 + j41;
            int i27 = iArr[(int) j42];
            int i28 = i27 & 1;
            long j43 = j39;
            int i29 = (int) (i28 + j41);
            long j44 = j37;
            int i30 = (int) (j43 >> 3);
            bArr[i30] = (byte) (bArr[i30] ^ (i28 << ((int) (j43 & 7))));
            iArr[(int) j41] = (i27 & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) | (i29 << 16);
            iArr[(int) (j41 + 1)] = (iArr[(int) (j42 + 1)] & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) | ((i29 ^ 1) << 16);
            j40++;
            j39 = j43 + j2;
            j37 = j44;
            j38 = j38;
            j36 = 2;
        }
        long j45 = j37;
        m17490sort32(iArr, 0, i4);
        long j46 = 2;
        long j47 = j39 - (((j38 - 2) * j2) * j5);
        short[] sArr2 = new short[i4 * 4];
        long j48 = 0;
        while (j48 < j45) {
            long j49 = j48 * j46;
            int i31 = iArr[(int) j48];
            sArr2[(int) j49] = (short) i31;
            sArr2[(int) (j49 + 1)] = (short) ((i31 & (-65536)) >> 16);
            j48++;
            j46 = 2;
        }
        for (long j50 = 0; j50 < j5; j50++) {
            long j51 = j50 * 2;
            sArr2[(int) j50] = (short) ((iArr[(int) j51] & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) >>> 1);
            sArr2[(int) (j50 + j5)] = (short) ((iArr[(int) (j51 + 1)] & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) >>> 1);
        }
        for (long j52 = 0; j52 < j5; j52++) {
            long j53 = j52 * 2;
            iArr[(int) (j4 + (j4 / 4) + j52)] = (sArr2[(int) (j53 + 1)] << 16) | sArr2[(int) j53];
        }
        long j54 = j2 * 2;
        long j55 = j4 + (j4 / 4);
        long j56 = j3 - 1;
        cbrecursion(bArr, j47, j54, null, ((int) j55) * 2, j56, j5, iArr);
        cbrecursion(bArr, j47 + j2, j54, null, (int) ((j55 * 2) + j5), j56, j5, iArr);
    }

    private static void controlbitsfrompermutation(byte[] bArr, short[] sArr, long j, long j2) {
        long j3 = 2;
        int[] iArr = new int[(int) (j2 * 2)];
        int i = (int) j2;
        short[] sArr2 = new short[i];
        while (true) {
            short s = 0;
            for (int i2 = 0; i2 < (((((j * j3) - 1) * j2) / j3) + 7) / 8; i2++) {
                bArr[i2] = 0;
            }
            int i3 = i;
            short[] sArr3 = sArr2;
            int[] iArr2 = iArr;
            cbrecursion(bArr, 0L, 1L, sArr, 0, j, j2, iArr);
            for (int i4 = 0; i4 < j2; i4++) {
                sArr3[i4] = (short) i4;
            }
            int i5 = 0;
            for (int i6 = 0; i6 < j; i6++) {
                m17486layer(sArr3, bArr, i5, i6, i3);
                i5 = (int) (i5 + (j2 >> 4));
            }
            for (int i7 = (int) (j - 2); i7 >= 0; i7--) {
                m17486layer(sArr3, bArr, i5, i7, i3);
                i5 = (int) (i5 + (j2 >> 4));
            }
            int i8 = 0;
            while (i8 < j2) {
                short s2 = (short) (s | (sArr[i8] ^ sArr3[i8]));
                i8++;
                s = s2;
            }
            if (s == 0) {
                return;
            }
            sArr2 = sArr3;
            i = i3;
            iArr = iArr2;
            j3 = 2;
        }
    }

    /* renamed from: ctz */
    private static int m17482ctz(long j) {
        long j2 = ~j;
        long j3 = 72340172838076673L;
        long j4 = 0;
        for (int i = 0; i < 8; i++) {
            j3 &= j2 >>> i;
            j4 += j3;
        }
        long j5 = 578721382704613384L & j4;
        long j6 = j5 | (j5 >>> 1);
        long j7 = j6 | (j6 >>> 2);
        long j8 = j4 >>> 8;
        long j9 = j4 + (j8 & j7);
        for (int i2 = 2; i2 < 8; i2++) {
            j7 &= j7 >>> 8;
            j8 >>>= 8;
            j9 += j8 & j7;
        }
        return ((int) j9) & 255;
    }

    /* renamed from: decrypt */
    private int m17483decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int i;
        int i2;
        int i3 = this.f23064SYS_T;
        short[] sArr = new short[i3 + 1];
        int i4 = this.f23063SYS_N;
        short[] sArr2 = new short[i4];
        short[] sArr3 = new short[i3 * 2];
        short[] sArr4 = new short[i3 * 2];
        short[] sArr5 = new short[i3 + 1];
        short[] sArr6 = new short[i4];
        byte[] bArr4 = new byte[i4 / 8];
        int i5 = 0;
        while (true) {
            i = this.SYND_BYTES;
            if (i5 >= i) {
                break;
            }
            bArr4[i5] = bArr3[i5];
            i5++;
        }
        while (i < this.f23063SYS_N / 8) {
            bArr4[i] = 0;
            i++;
        }
        int i6 = 0;
        while (true) {
            i2 = this.f23064SYS_T;
            if (i6 >= i2) {
                break;
            }
            sArr[i6] = C6057Utils.m17512load_gf(bArr2, (i6 * 2) + 40, this.f23062GFMASK);
            i6++;
        }
        sArr[i2] = 1;
        this.f23065benes.support_gen(sArr2, bArr2);
        m17492synd(sArr3, sArr, sArr2, bArr4);
        m17481bm(sArr5, sArr3);
        m17489root(sArr6, sArr5, sArr2);
        for (int i7 = 0; i7 < this.f23063SYS_N / 8; i7++) {
            bArr[i7] = 0;
        }
        int i8 = 0;
        for (int i9 = 0; i9 < this.f23063SYS_N; i9++) {
            short sGf_iszero = (short) (this.f23066gf.gf_iszero(sArr6[i9]) & 1);
            int i10 = i9 / 8;
            bArr[i10] = (byte) (bArr[i10] | (sGf_iszero << (i9 % 8)));
            i8 += sGf_iszero;
        }
        m17492synd(sArr4, sArr, sArr2, bArr);
        int i11 = this.f23064SYS_T ^ i8;
        for (int i12 = 0; i12 < this.f23064SYS_T * 2; i12++) {
            i11 |= sArr3[i12] ^ sArr4[i12];
        }
        return (((i11 - 1) >> 15) & 1) ^ 1;
    }

    /* renamed from: encrypt */
    private void m17484encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3, SecureRandom secureRandom) {
        generate_error_vector(bArr3, secureRandom);
        syndrome(bArr, bArr2, bArr3);
    }

    /* renamed from: eval */
    private short m17485eval(short[] sArr, short s) {
        int i = this.f23064SYS_T;
        short sMo17506gf_mul = sArr[i];
        for (int i2 = i - 1; i2 >= 0; i2--) {
            sMo17506gf_mul = (short) (this.f23066gf.mo17506gf_mul(sMo17506gf_mul, s) ^ sArr[i2]);
        }
        return sMo17506gf_mul;
    }

    private void generate_error_vector(byte[] bArr, SecureRandom secureRandom) {
        int i;
        int i2 = this.f23064SYS_T;
        short[] sArr = new short[i2 * 2];
        short[] sArr2 = new short[i2];
        byte[] bArr2 = new byte[i2];
        while (true) {
            if (this.countErrorIndices) {
                byte[] bArr3 = new byte[this.f23064SYS_T * 4];
                secureRandom.nextBytes(bArr3);
                for (int i3 = 0; i3 < this.f23064SYS_T * 2; i3++) {
                    sArr[i3] = C6057Utils.m17512load_gf(bArr3, i3 * 2, this.f23062GFMASK);
                }
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    i = this.f23064SYS_T;
                    if (i4 >= i * 2 || i5 >= i) {
                        break;
                    }
                    short s = sArr[i4];
                    if (s < this.f23063SYS_N) {
                        sArr2[i5] = s;
                        i5++;
                    }
                    i4++;
                }
                if (i5 < i) {
                    continue;
                }
            } else {
                byte[] bArr4 = new byte[this.f23064SYS_T * 2];
                secureRandom.nextBytes(bArr4);
                for (int i6 = 0; i6 < this.f23064SYS_T; i6++) {
                    sArr2[i6] = C6057Utils.m17512load_gf(bArr4, i6 * 2, this.f23062GFMASK);
                }
            }
            boolean z = false;
            for (int i7 = 1; i7 < this.f23064SYS_T && !z; i7++) {
                int i8 = 0;
                while (true) {
                    if (i8 >= i7) {
                        break;
                    }
                    if (sArr2[i7] == sArr2[i8]) {
                        z = true;
                        break;
                    }
                    i8++;
                }
            }
            if (!z) {
                break;
            }
        }
        for (int i9 = 0; i9 < this.f23064SYS_T; i9++) {
            bArr2[i9] = (byte) (1 << (sArr2[i9] & 7));
        }
        for (short s2 = 0; s2 < this.f23063SYS_N / 8; s2 = (short) (s2 + 1)) {
            bArr[s2] = 0;
            for (int i10 = 0; i10 < this.f23064SYS_T; i10++) {
                bArr[s2] = (byte) ((((short) (same_mask32(s2, (short) (sArr2[i10] >> 3)) & 255)) & bArr2[i10]) | bArr[s2]);
            }
        }
    }

    private int generate_irr_poly(short[] sArr) {
        int i;
        int i2 = this.f23064SYS_T;
        int i3 = 2;
        short[][] sArr2 = (short[][]) Array.newInstance((Class<?>) Short.TYPE, i2 + 1, i2);
        sArr2[0][0] = 1;
        System.arraycopy(sArr, 0, sArr2[1], 0, this.f23064SYS_T);
        int[] iArr = new int[(this.f23064SYS_T * 2) - 1];
        while (true) {
            i = this.f23064SYS_T;
            if (i3 >= i) {
                break;
            }
            this.f23066gf.gf_sqr_poly(i, this.f23067poly, sArr2[i3], sArr2[i3 >>> 1], iArr);
            this.f23066gf.gf_mul_poly(this.f23064SYS_T, this.f23067poly, sArr2[i3 + 1], sArr2[i3], sArr, iArr);
            i3 += 2;
        }
        if (i3 == i) {
            this.f23066gf.gf_sqr_poly(i, this.f23067poly, sArr2[i3], sArr2[i3 >>> 1], iArr);
        }
        int i4 = 0;
        while (true) {
            int i5 = this.f23064SYS_T;
            if (i4 >= i5) {
                System.arraycopy(sArr2[i5], 0, sArr, 0, i5);
                return 0;
            }
            int i6 = i4 + 1;
            for (int i7 = i6; i7 < this.f23064SYS_T; i7++) {
                short sGf_iszero = this.f23066gf.gf_iszero(sArr2[i4][i4]);
                for (int i8 = i4; i8 < this.f23064SYS_T + 1; i8++) {
                    short[] sArr3 = sArr2[i8];
                    sArr3[i4] = (short) (sArr3[i4] ^ ((short) (sArr3[i7] & sGf_iszero)));
                }
            }
            short s = sArr2[i4][i4];
            if (s == 0) {
                return -1;
            }
            short sMo17505gf_inv = this.f23066gf.mo17505gf_inv(s);
            for (int i9 = i4; i9 < this.f23064SYS_T + 1; i9++) {
                short[] sArr4 = sArr2[i9];
                sArr4[i4] = this.f23066gf.mo17506gf_mul(sArr4[i4], sMo17505gf_inv);
            }
            for (int i10 = 0; i10 < this.f23064SYS_T; i10++) {
                if (i10 != i4) {
                    short s2 = sArr2[i4][i10];
                    for (int i11 = i4; i11 <= this.f23064SYS_T; i11++) {
                        short[] sArr5 = sArr2[i11];
                        sArr5[i10] = (short) (sArr5[i10] ^ this.f23066gf.mo17506gf_mul(sArr5[i4], s2));
                    }
                }
            }
            i4 = i6;
        }
    }

    public static short get_q_short(int[] iArr, int i) {
        int i2 = i / 2;
        return (short) (i % 2 == 0 ? iArr[i2] : (iArr[i2] & (-65536)) >> 16);
    }

    /* renamed from: layer */
    private static void m17486layer(short[] sArr, byte[] bArr, int i, int i2, int i3) {
        int i4 = 1 << i2;
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6 += i4 * 2) {
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = i6 + i7;
                short s = sArr[i8];
                int i9 = i8 + i4;
                int i10 = (sArr[i9] ^ s) & (-((bArr[(i5 >> 3) + i] >> (i5 & 7)) & 1));
                sArr[i8] = (short) (s ^ i10);
                sArr[i9] = (short) (sArr[i9] ^ i10);
                i5++;
            }
        }
    }

    /* renamed from: min */
    private static int m17487min(short s, int i) {
        return s < i ? s : i;
    }

    private int mov_columns(byte[][] bArr, short[] sArr, long[] jArr) {
        byte[] bArr2;
        long jM17511load8;
        long[] jArr2 = new long[64];
        int i = 32;
        long[] jArr3 = new long[32];
        byte[] bArr3 = new byte[9];
        int i2 = this.PK_NROWS - 32;
        int i3 = i2 / 8;
        int i4 = i2 % 8;
        char c = 0;
        if (this.usePadding) {
            for (int i5 = 0; i5 < 32; i5++) {
                for (int i6 = 0; i6 < 9; i6++) {
                    bArr3[i6] = bArr[i2 + i5][i3 + i6];
                }
                int i7 = 0;
                while (i7 < 8) {
                    int i8 = i7 + 1;
                    bArr3[i7] = (byte) (((bArr3[i7] & C1126UByte.MAX_VALUE) >> i4) | (bArr3[i8] << (8 - i4)));
                    i7 = i8;
                }
                jArr2[i5] = C6057Utils.m17511load8(bArr3, 0);
            }
        } else {
            for (int i9 = 0; i9 < 32; i9++) {
                jArr2[i9] = C6057Utils.m17511load8(bArr[i2 + i9], i3);
            }
        }
        long j = 0;
        jArr[0] = 0;
        int i10 = 0;
        while (i10 < 32) {
            long j2 = jArr2[i10];
            int i11 = i10 + 1;
            for (int i12 = i11; i12 < 32; i12++) {
                j2 |= jArr2[i12];
            }
            if (j2 == j) {
                return -1;
            }
            int iM17482ctz = m17482ctz(j2);
            long j3 = iM17482ctz;
            jArr3[i10] = j3;
            jArr[c] = jArr[c] | (1 << ((int) j3));
            for (int i13 = i11; i13 < 32; i13++) {
                long j4 = jArr2[i10];
                jArr2[i10] = j4 ^ (jArr2[i13] & (((j4 >> iM17482ctz) & 1) - 1));
            }
            int i14 = i11;
            while (i14 < 32) {
                long j5 = jArr2[i14];
                jArr2[i14] = j5 ^ (jArr2[i10] & (-((j5 >> iM17482ctz) & 1)));
                i14++;
                iM17482ctz = iM17482ctz;
                c = 0;
            }
            i10 = i11;
            j = 0;
        }
        int i15 = 0;
        while (i15 < 32) {
            int i16 = i15 + 1;
            int i17 = i16;
            while (i17 < 64) {
                long jSame_mask64 = same_mask64((short) i17, (short) jArr3[i15]) & (sArr[r12] ^ sArr[r17]);
                sArr[i2 + i15] = (short) (sArr[r12] ^ jSame_mask64);
                sArr[i2 + i17] = (short) (jSame_mask64 ^ sArr[r17]);
                i17++;
                bArr3 = bArr3;
            }
            i15 = i16;
        }
        byte[] bArr4 = bArr3;
        int i18 = 0;
        while (i18 < this.PK_NROWS) {
            if (this.usePadding) {
                for (int i19 = 0; i19 < 9; i19++) {
                    bArr4[i19] = bArr[i18][i3 + i19];
                }
                int i20 = 0;
                while (i20 < 8) {
                    int i21 = i20 + 1;
                    bArr4[i20] = (byte) (((bArr4[i20] & C1126UByte.MAX_VALUE) >> i4) | (bArr4[i21] << (8 - i4)));
                    i20 = i21;
                }
                bArr2 = bArr4;
                jM17511load8 = C6057Utils.m17511load8(bArr2, 0);
            } else {
                bArr2 = bArr4;
                jM17511load8 = C6057Utils.m17511load8(bArr[i18], i3);
            }
            int i22 = 0;
            while (i22 < i) {
                long j6 = jArr3[i22];
                long j7 = ((jM17511load8 >> i22) ^ (jM17511load8 >> ((int) j6))) & 1;
                jM17511load8 = (j7 << i22) ^ ((j7 << ((int) j6)) ^ jM17511load8);
                i22++;
                i = 32;
            }
            if (this.usePadding) {
                C6057Utils.m17513store8(bArr2, 0, jM17511load8);
                byte[] bArr5 = bArr[i18];
                int i23 = i3 + 8;
                int i24 = 8 - i4;
                bArr5[i23] = (byte) ((((bArr5[i23] & C1126UByte.MAX_VALUE) >>> i4) << i4) | ((bArr2[7] & C1126UByte.MAX_VALUE) >>> i24));
                bArr5[i3] = (byte) (((bArr2[0] & C1126UByte.MAX_VALUE) << i4) | (((bArr5[i3] & C1126UByte.MAX_VALUE) << i24) >>> i24));
                for (int i25 = 7; i25 >= 1; i25--) {
                    bArr[i18][i3 + i25] = (byte) (((bArr2[i25] & C1126UByte.MAX_VALUE) << i4) | ((bArr2[i25 - 1] & C1126UByte.MAX_VALUE) >>> i24));
                }
            } else {
                C6057Utils.m17513store8(bArr[i18], i3, jM17511load8);
            }
            i18++;
            bArr4 = bArr2;
            i = 32;
        }
        return 0;
    }

    /* renamed from: pk_gen */
    private int m17488pk_gen(byte[] bArr, byte[] bArr2, int[] iArr, short[] sArr, long[] jArr) {
        int i;
        int i2;
        int i3 = this.f23064SYS_T;
        short[] sArr2 = new short[i3 + 1];
        sArr2[i3] = 1;
        int i4 = 0;
        for (int i5 = 0; i5 < this.f23064SYS_T; i5++) {
            sArr2[i5] = C6057Utils.m17512load_gf(bArr2, (i5 * 2) + 40, this.f23062GFMASK);
        }
        int i6 = 1 << this.f23061GFBITS;
        long[] jArr2 = new long[i6];
        for (int i7 = 0; i7 < (1 << this.f23061GFBITS); i7++) {
            long j = iArr[i7];
            jArr2[i7] = j;
            long j2 = j << 31;
            jArr2[i7] = j2;
            long j3 = j2 | i7;
            jArr2[i7] = j3;
            jArr2[i7] = j3 & LongCompanionObject.MAX_VALUE;
        }
        m17491sort64(jArr2, 0, i6);
        for (int i8 = 1; i8 < (1 << this.f23061GFBITS); i8++) {
            if ((jArr2[i8 - 1] >> 31) == (jArr2[i8] >> 31)) {
                return -1;
            }
        }
        short[] sArr3 = new short[this.f23063SYS_N];
        for (int i9 = 0; i9 < (1 << this.f23061GFBITS); i9++) {
            sArr[i9] = (short) (jArr2[i9] & this.f23062GFMASK);
        }
        int i10 = 0;
        while (true) {
            i = this.f23063SYS_N;
            if (i10 >= i) {
                break;
            }
            sArr3[i10] = C6057Utils.m17509bitrev(sArr[i10], this.f23061GFBITS);
            i10++;
        }
        short[] sArr4 = new short[i];
        m17489root(sArr4, sArr2, sArr3);
        int i11 = 0;
        while (true) {
            i2 = this.f23063SYS_N;
            if (i11 >= i2) {
                break;
            }
            sArr4[i11] = this.f23066gf.mo17505gf_inv(sArr4[i11]);
            i11++;
        }
        byte[][] bArr3 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, this.PK_NROWS, i2 / 8);
        for (int i12 = 0; i12 < this.PK_NROWS; i12++) {
            for (int i13 = 0; i13 < this.f23063SYS_N / 8; i13++) {
                bArr3[i12][i13] = 0;
            }
        }
        int i14 = 0;
        while (i14 < this.f23064SYS_T) {
            for (int i15 = 0; i15 < this.f23063SYS_N; i15 += 8) {
                int i16 = 0;
                while (true) {
                    int i17 = this.f23061GFBITS;
                    if (i16 < i17) {
                        bArr3[(i17 * i14) + i16][i15 / 8] = (byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) ((sArr4[i15 + 7] >>> i16) & 1)) << 1)) | ((sArr4[i15 + 6] >>> i16) & 1))) << 1)) | ((sArr4[i15 + 5] >>> i16) & 1))) << 1)) | ((sArr4[i15 + 4] >>> i16) & 1))) << 1)) | ((sArr4[i15 + 3] >>> i16) & 1))) << 1)) | ((sArr4[i15 + 2] >>> i16) & 1))) << 1)) | ((sArr4[i15 + 1] >>> i16) & 1))) << 1)) | ((sArr4[i15] >>> i16) & 1));
                        i16++;
                    }
                }
            }
            for (int i18 = 0; i18 < this.f23063SYS_N; i18++) {
                sArr4[i18] = this.f23066gf.mo17506gf_mul(sArr4[i18], sArr3[i18]);
            }
            i14++;
        }
        int i19 = 0;
        while (true) {
            int i20 = this.PK_NROWS;
            if (i19 < i20) {
                i14 = i19 >>> 3;
                int i21 = i19 & 7;
                if (this.usePivots && i19 == i20 - 32) {
                    if (mov_columns(bArr3, sArr, jArr) != 0) {
                        return -1;
                    }
                }
                int i22 = i19 + 1;
                int i23 = i22;
                while (i23 < this.PK_NROWS) {
                    byte b = (byte) (-((byte) (((byte) (((byte) (bArr3[i19][i14] ^ bArr3[i23][i14])) >> i21)) & 1)));
                    for (int i24 = i4; i24 < this.f23063SYS_N / 8; i24++) {
                        byte[] bArr4 = bArr3[i19];
                        bArr4[i24] = (byte) (bArr4[i24] ^ (bArr3[i23][i24] & b));
                    }
                    i23++;
                    i4 = 0;
                }
                if (((bArr3[i19][i14] >> i21) & 1) == 0) {
                    return -1;
                }
                for (int i25 = 0; i25 < this.PK_NROWS; i25++) {
                    if (i25 != i19) {
                        byte b2 = (byte) (-((byte) (((byte) (bArr3[i25][i14] >> i21)) & 1)));
                        for (int i26 = 0; i26 < this.f23063SYS_N / 8; i26++) {
                            byte[] bArr5 = bArr3[i25];
                            bArr5[i26] = (byte) (bArr5[i26] ^ (bArr3[i19][i26] & b2));
                        }
                    }
                }
                i19 = i22;
                i4 = 0;
            } else {
                if (bArr == null) {
                    return 0;
                }
                if (this.usePadding) {
                    int i27 = i20 % 8;
                    if (i27 == 0) {
                        System.arraycopy(bArr3[i14], (i20 - 1) / 8, bArr, 0, this.f23063SYS_N / 8);
                        return 0;
                    }
                    int i28 = 0;
                    int i29 = 0;
                    while (true) {
                        int i30 = this.PK_NROWS;
                        if (i28 >= i30) {
                            return 0;
                        }
                        int i31 = (i30 - 1) / 8;
                        while (i31 < (this.f23063SYS_N / 8) - 1) {
                            byte[] bArr6 = bArr3[i28];
                            int i32 = (bArr6[i31] & C1126UByte.MAX_VALUE) >>> i27;
                            i31++;
                            bArr[i29] = (byte) ((bArr6[i31] << (8 - i27)) | i32);
                            i29++;
                        }
                        bArr[i29] = (byte) ((bArr3[i28][i31] & C1126UByte.MAX_VALUE) >>> i27);
                        i28++;
                        i29++;
                    }
                } else {
                    int i33 = ((this.f23063SYS_N - i20) + 7) / 8;
                    int i34 = 0;
                    while (true) {
                        int i35 = this.PK_NROWS;
                        if (i34 >= i35) {
                            return 0;
                        }
                        System.arraycopy(bArr3[i34], i35 / 8, bArr, i33 * i34, i33);
                        i34++;
                    }
                }
            }
        }
    }

    /* renamed from: root */
    private void m17489root(short[] sArr, short[] sArr2, short[] sArr3) {
        for (int i = 0; i < this.f23063SYS_N; i++) {
            sArr[i] = m17485eval(sArr2, sArr3[i]);
        }
    }

    private static byte same_mask32(short s, short s2) {
        return (byte) ((-(((s ^ s2) - 1) >>> 31)) & 255);
    }

    private static long same_mask64(short s, short s2) {
        return -(((s ^ s2) - 1) >>> 63);
    }

    /* renamed from: sort32 */
    private static void m17490sort32(int[] iArr, int i, int i2) {
        int i3 = i2 - i;
        if (i3 < 2) {
            return;
        }
        int i4 = 1;
        while (i4 < i3 - i4) {
            i4 += i4;
        }
        for (int i5 = i4; i5 > 0; i5 >>>= 1) {
            int i6 = 0;
            for (int i7 = 0; i7 < i3 - i5; i7++) {
                if ((i7 & i5) == 0) {
                    int i8 = i + i7;
                    int i9 = i8 + i5;
                    int i10 = iArr[i9];
                    int i11 = iArr[i8];
                    int i12 = i10 ^ i11;
                    int i13 = i10 - i11;
                    int i14 = ((((i10 ^ i13) & i12) ^ i13) >> 31) & i12;
                    iArr[i8] = i11 ^ i14;
                    iArr[i9] = iArr[i9] ^ i14;
                }
            }
            for (int i15 = i4; i15 > i5; i15 >>>= 1) {
                while (i6 < i3 - i15) {
                    if ((i6 & i5) == 0) {
                        int i16 = i + i6;
                        int i17 = i16 + i5;
                        int i18 = iArr[i17];
                        for (int i19 = i15; i19 > i5; i19 >>>= 1) {
                            int i20 = i16 + i19;
                            int i21 = iArr[i20];
                            int i22 = i21 ^ i18;
                            int i23 = i21 - i18;
                            int i24 = i22 & ((i23 ^ ((i23 ^ i21) & i22)) >> 31);
                            i18 ^= i24;
                            iArr[i20] = i21 ^ i24;
                        }
                        iArr[i17] = i18;
                    }
                    i6++;
                }
            }
        }
    }

    /* renamed from: sort64 */
    private static void m17491sort64(long[] jArr, int i, int i2) {
        int i3 = i2 - i;
        if (i3 < 2) {
            return;
        }
        int i4 = 1;
        while (i4 < i3 - i4) {
            i4 += i4;
        }
        for (int i5 = i4; i5 > 0; i5 >>>= 1) {
            int i6 = 0;
            for (int i7 = 0; i7 < i3 - i5; i7++) {
                if ((i7 & i5) == 0) {
                    int i8 = i + i7;
                    int i9 = i8 + i5;
                    long j = jArr[i9];
                    long j2 = jArr[i8];
                    long j3 = (j ^ j2) & (-((j - j2) >>> 63));
                    jArr[i8] = j2 ^ j3;
                    jArr[i9] = jArr[i9] ^ j3;
                }
            }
            for (int i10 = i4; i10 > i5; i10 >>>= 1) {
                while (i6 < i3 - i10) {
                    if ((i6 & i5) == 0) {
                        int i11 = i + i6;
                        int i12 = i11 + i5;
                        long j4 = jArr[i12];
                        for (int i13 = i10; i13 > i5; i13 >>>= 1) {
                            int i14 = i11 + i13;
                            long j5 = jArr[i14];
                            long j6 = (-((j5 - j4) >>> 63)) & (j4 ^ j5);
                            j4 ^= j6;
                            jArr[i14] = j5 ^ j6;
                        }
                        jArr[i12] = j4;
                    }
                    i6++;
                }
            }
        }
    }

    /* renamed from: synd */
    private void m17492synd(short[] sArr, short[] sArr2, short[] sArr3, byte[] bArr) {
        short s = (short) (bArr[0] & 1);
        short s2 = sArr3[0];
        short sM17485eval = m17485eval(sArr2, s2);
        AbstractC6054GF abstractC6054GF = this.f23066gf;
        short sMo17505gf_inv = (short) ((-s) & abstractC6054GF.mo17505gf_inv(abstractC6054GF.mo17507gf_sq(sM17485eval)));
        sArr[0] = sMo17505gf_inv;
        for (int i = 1; i < this.f23064SYS_T * 2; i++) {
            sMo17505gf_inv = this.f23066gf.mo17506gf_mul(sMo17505gf_inv, s2);
            sArr[i] = sMo17505gf_inv;
        }
        for (int i2 = 1; i2 < this.f23063SYS_N; i2++) {
            short s3 = (short) ((bArr[i2 / 8] >> (i2 % 8)) & 1);
            short s4 = sArr3[i2];
            short sM17485eval2 = m17485eval(sArr2, s4);
            AbstractC6054GF abstractC6054GF2 = this.f23066gf;
            short sMo17506gf_mul = this.f23066gf.mo17506gf_mul(abstractC6054GF2.mo17505gf_inv(abstractC6054GF2.mo17507gf_sq(sM17485eval2)), s3);
            sArr[0] = (short) (sArr[0] ^ sMo17506gf_mul);
            for (int i3 = 1; i3 < this.f23064SYS_T * 2; i3++) {
                sMo17506gf_mul = this.f23066gf.mo17506gf_mul(sMo17506gf_mul, s4);
                sArr[i3] = (short) (sArr[i3] ^ sMo17506gf_mul);
            }
        }
    }

    private void syndrome(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        short[] sArr = new short[this.f23063SYS_N / 8];
        int i = this.PK_NROWS % 8;
        for (int i2 = 0; i2 < this.SYND_BYTES; i2++) {
            bArr[i2] = 0;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.PK_NROWS; i4++) {
            for (int i5 = 0; i5 < this.f23063SYS_N / 8; i5++) {
                sArr[i5] = 0;
            }
            int i6 = 0;
            while (true) {
                int i7 = this.PK_ROW_BYTES;
                if (i6 >= i7) {
                    break;
                }
                sArr[((this.f23063SYS_N / 8) - i7) + i6] = bArr2[i3 + i6];
                i6++;
            }
            if (this.usePadding) {
                for (int i8 = (this.f23063SYS_N / 8) - 1; i8 >= (this.f23063SYS_N / 8) - this.PK_ROW_BYTES; i8--) {
                    sArr[i8] = (short) ((((sArr[i8] & 255) << i) | ((sArr[i8 - 1] & 255) >>> (8 - i))) & 255);
                }
            }
            int i9 = i4 / 8;
            int i10 = i4 % 8;
            sArr[i9] = (short) (sArr[i9] | (1 << i10));
            byte b = 0;
            for (int i11 = 0; i11 < this.f23063SYS_N / 8; i11++) {
                b = (byte) (b ^ (sArr[i11] & bArr3[i11]));
            }
            byte b2 = (byte) ((b >>> 4) ^ b);
            byte b3 = (byte) (b2 ^ (b2 >>> 2));
            bArr[i9] = (byte) ((((byte) (1 & ((byte) (b3 ^ (b3 >>> 1))))) << i10) | bArr[i9]);
            i3 += this.PK_ROW_BYTES;
        }
    }

    public int check_c_padding(byte[] bArr) {
        return ((byte) ((((byte) (((byte) ((bArr[this.SYND_BYTES - 1] & C1126UByte.MAX_VALUE) >>> (this.PK_NROWS % 8))) - 1)) & C1126UByte.MAX_VALUE) >>> 7)) - 1;
    }

    public int check_pk_padding(byte[] bArr) {
        byte b = 0;
        for (int i = 0; i < this.PK_NROWS; i++) {
            int i2 = this.PK_ROW_BYTES;
            b = (byte) (b | bArr[((i * i2) + i2) - 1]);
        }
        return ((byte) ((((byte) (((byte) ((b & C1126UByte.MAX_VALUE) >>> (this.PK_NCOLS % 8))) - 1)) & C1126UByte.MAX_VALUE) >>> 7)) - 1;
    }

    public byte[] decompress_private_key(byte[] bArr) {
        int i;
        byte[] bArr2 = new byte[getPrivateKeySize()];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        int i2 = (this.f23063SYS_N / 8) + ((1 << this.f23061GFBITS) * 4) + this.IRR_BYTES;
        int i3 = i2 + 32;
        byte[] bArr3 = new byte[i3];
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        sHAKEDigest.mo14969update((byte) 64);
        sHAKEDigest.mo14970update(bArr, 0, 32);
        sHAKEDigest.mo14998doFinal(bArr3, 0, i3);
        if (bArr.length <= 40) {
            short[] sArr = new short[this.f23064SYS_T];
            int i4 = this.IRR_BYTES;
            byte[] bArr4 = new byte[i4];
            int i5 = i2 - i4;
            for (int i6 = 0; i6 < this.f23064SYS_T; i6++) {
                sArr[i6] = C6057Utils.m17512load_gf(bArr3, (i6 * 2) + i5, this.f23062GFMASK);
            }
            generate_irr_poly(sArr);
            for (int i7 = 0; i7 < this.f23064SYS_T; i7++) {
                C6057Utils.store_gf(bArr4, i7 * 2, sArr[i7]);
            }
            System.arraycopy(bArr4, 0, bArr2, 40, this.IRR_BYTES);
        }
        int length = bArr.length;
        int i8 = this.IRR_BYTES;
        if (length <= i8 + 40) {
            int i9 = this.f23061GFBITS;
            int[] iArr = new int[1 << i9];
            short[] sArr2 = new short[1 << i9];
            int i10 = (i2 - i8) - ((1 << i9) * 4);
            int i11 = 0;
            while (true) {
                i = this.f23061GFBITS;
                if (i11 >= (1 << i)) {
                    break;
                }
                iArr[i11] = C6057Utils.m17510load4(bArr3, (i11 * 4) + i10);
                i11++;
            }
            if (this.usePivots) {
                m17488pk_gen(null, bArr2, iArr, sArr2, new long[]{0});
            } else {
                int i12 = 1 << i;
                long[] jArr = new long[i12];
                for (int i13 = 0; i13 < (1 << this.f23061GFBITS); i13++) {
                    long j = iArr[i13];
                    jArr[i13] = j;
                    long j2 = j << 31;
                    jArr[i13] = j2;
                    long j3 = j2 | i13;
                    jArr[i13] = j3;
                    jArr[i13] = j3 & LongCompanionObject.MAX_VALUE;
                }
                m17491sort64(jArr, 0, i12);
                for (int i14 = 0; i14 < (1 << this.f23061GFBITS); i14++) {
                    sArr2[i14] = (short) (jArr[i14] & this.f23062GFMASK);
                }
            }
            int i15 = this.COND_BYTES;
            byte[] bArr5 = new byte[i15];
            controlbitsfrompermutation(bArr5, sArr2, this.f23061GFBITS, 1 << r2);
            System.arraycopy(bArr5, 0, bArr2, this.IRR_BYTES + 40, i15);
        }
        int privateKeySize = getPrivateKeySize();
        int i16 = this.f23063SYS_N;
        System.arraycopy(bArr3, 0, bArr2, privateKeySize - (i16 / 8), i16 / 8);
        return bArr2;
    }

    public byte[] generate_public_key_from_private_key(byte[] bArr) {
        byte[] bArr2 = new byte[getPublicKeySize()];
        int i = this.f23061GFBITS;
        short[] sArr = new short[1 << i];
        long[] jArr = {0};
        int[] iArr = new int[1 << i];
        int i2 = (this.f23063SYS_N / 8) + ((1 << i) * 4);
        byte[] bArr3 = new byte[i2];
        int i3 = ((i2 - 32) - this.IRR_BYTES) - ((1 << i) * 4);
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        sHAKEDigest.mo14969update((byte) 64);
        sHAKEDigest.mo14970update(bArr, 0, 32);
        sHAKEDigest.mo14998doFinal(bArr3, 0, i2);
        for (int i4 = 0; i4 < (1 << this.f23061GFBITS); i4++) {
            iArr[i4] = C6057Utils.m17510load4(bArr3, (i4 * 4) + i3);
        }
        m17488pk_gen(bArr2, bArr, iArr, sArr, jArr);
        return bArr2;
    }

    public int getCipherTextSize() {
        return this.SYND_BYTES;
    }

    public int getCondBytes() {
        return this.COND_BYTES;
    }

    public int getDefaultSessionKeySize() {
        return this.defaultKeySize;
    }

    public int getIrrBytes() {
        return this.IRR_BYTES;
    }

    public int getPrivateKeySize() {
        return this.COND_BYTES + this.IRR_BYTES + (this.f23063SYS_N / 8) + 40;
    }

    public int getPublicKeySize() {
        if (!this.usePadding) {
            return (this.PK_NROWS * this.PK_NCOLS) / 8;
        }
        int i = this.PK_NROWS;
        return i * ((this.f23063SYS_N / 8) - ((i - 1) / 8));
    }

    /* renamed from: kem_dec */
    public int m17493kem_dec(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int i = this.f23063SYS_N;
        byte[] bArr4 = new byte[i / 8];
        int i2 = (i / 8) + 1 + this.SYND_BYTES;
        byte[] bArr5 = new byte[i2];
        int iCheck_c_padding = this.usePadding ? check_c_padding(bArr2) : 0;
        short sM17483decrypt = (short) (((short) (((short) (((byte) m17483decrypt(bArr4, bArr3, bArr2)) - 1)) >> 8)) & 255);
        bArr5[0] = (byte) (sM17483decrypt & 1);
        int i3 = 0;
        while (i3 < this.f23063SYS_N / 8) {
            int i4 = i3 + 1;
            bArr5[i4] = (byte) ((bArr4[i3] & sM17483decrypt) | ((~sM17483decrypt) & bArr3[i3 + 40 + this.IRR_BYTES + this.COND_BYTES]));
            i3 = i4;
        }
        for (int i5 = 0; i5 < this.SYND_BYTES; i5++) {
            bArr5[(this.f23063SYS_N / 8) + 1 + i5] = bArr2[i5];
        }
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        sHAKEDigest.mo14970update(bArr5, 0, i2);
        sHAKEDigest.mo14998doFinal(bArr, 0, bArr.length);
        if (!this.usePadding) {
            return 0;
        }
        byte b = (byte) iCheck_c_padding;
        for (int i6 = 0; i6 < bArr.length; i6++) {
            bArr[i6] = (byte) (bArr[i6] | b);
        }
        return iCheck_c_padding;
    }

    /* renamed from: kem_enc */
    public int m17494kem_enc(byte[] bArr, byte[] bArr2, byte[] bArr3, SecureRandom secureRandom) {
        int i = this.f23063SYS_N / 8;
        byte[] bArr4 = new byte[i];
        int iCheck_pk_padding = this.usePadding ? check_pk_padding(bArr3) : 0;
        m17484encrypt(bArr, bArr3, bArr4, secureRandom);
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        sHAKEDigest.mo14969update((byte) 1);
        sHAKEDigest.mo14970update(bArr4, 0, i);
        sHAKEDigest.mo14970update(bArr, 0, bArr.length);
        sHAKEDigest.mo14998doFinal(bArr2, 0, bArr2.length);
        if (!this.usePadding) {
            return 0;
        }
        byte b = (byte) (((byte) iCheck_pk_padding) ^ C1126UByte.MAX_VALUE);
        for (int i2 = 0; i2 < this.SYND_BYTES; i2++) {
            bArr[i2] = (byte) (bArr[i2] & b);
        }
        for (int i3 = 0; i3 < 32; i3++) {
            bArr2[i3] = (byte) (bArr2[i3] & b);
        }
        return iCheck_pk_padding;
    }

    public void kem_keypair(byte[] bArr, byte[] bArr2, SecureRandom secureRandom) {
        int i;
        int i2;
        short[] sArr;
        byte[] bArr3;
        SHAKEDigest sHAKEDigest;
        int i3;
        long j;
        int i4 = 32;
        byte[] bArr4 = new byte[32];
        int i5 = 0;
        byte[] bArr5 = {64};
        secureRandom.nextBytes(bArr4);
        int i6 = (this.f23063SYS_N / 8) + ((1 << this.f23061GFBITS) * 4) + (this.f23064SYS_T * 2);
        int i7 = i6 + 32;
        byte[] bArr6 = new byte[i7];
        long[] jArr = {0};
        SHAKEDigest sHAKEDigest2 = new SHAKEDigest(256);
        byte[] bArr7 = bArr4;
        while (true) {
            sHAKEDigest2.mo14970update(bArr5, i5, 1);
            sHAKEDigest2.mo14970update(bArr4, i5, bArr4.length);
            sHAKEDigest2.mo14998doFinal(bArr6, i5, i7);
            byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(bArr6, i6, i6 + 32);
            System.arraycopy(bArr7, i5, bArr2, i5, i4);
            byte[] bArrCopyOfRange2 = C6238Arrays.copyOfRange(bArrCopyOfRange, i5, i4);
            int i8 = this.f23064SYS_T;
            short[] sArr2 = new short[i8];
            int i9 = i6 - (i8 * 2);
            for (int i10 = i5; i10 < this.f23064SYS_T; i10++) {
                sArr2[i10] = C6057Utils.m17512load_gf(bArr6, (i10 * 2) + i9, this.f23062GFMASK);
            }
            if (generate_irr_poly(sArr2) != -1) {
                for (int i11 = i5; i11 < this.f23064SYS_T; i11++) {
                    C6057Utils.store_gf(bArr2, 40 + (i11 * 2), sArr2[i11]);
                }
                int i12 = this.f23061GFBITS;
                int[] iArr = new int[1 << i12];
                i = i9 - ((1 << i12) * 4);
                int i13 = 0;
                while (true) {
                    i2 = this.f23061GFBITS;
                    if (i13 >= (1 << i2)) {
                        break;
                    }
                    iArr[i13] = C6057Utils.m17510load4(bArr6, (i13 * 4) + i);
                    i13++;
                }
                sArr = new short[1 << i2];
                bArr3 = bArrCopyOfRange;
                sHAKEDigest = sHAKEDigest2;
                if (m17488pk_gen(bArr, bArr2, iArr, sArr, jArr) != -1) {
                    break;
                }
            } else {
                bArr3 = bArrCopyOfRange;
                sHAKEDigest = sHAKEDigest2;
            }
            bArr7 = bArrCopyOfRange2;
            bArr4 = bArr3;
            sHAKEDigest2 = sHAKEDigest;
            i4 = 32;
            i5 = 0;
        }
        int i14 = this.COND_BYTES;
        byte[] bArr8 = new byte[i14];
        controlbitsfrompermutation(bArr8, sArr, this.f23061GFBITS, 1 << r2);
        System.arraycopy(bArr8, 0, bArr2, this.IRR_BYTES + 40, i14);
        int i15 = this.f23063SYS_N;
        System.arraycopy(bArr6, i - (i15 / 8), bArr2, bArr2.length - (i15 / 8), i15 / 8);
        if (this.usePivots) {
            i3 = 32;
            j = jArr[0];
        } else {
            j = BodyPartID.bodyIdMax;
            i3 = 32;
        }
        C6057Utils.m17513store8(bArr2, i3, j);
    }
}
