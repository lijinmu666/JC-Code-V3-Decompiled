package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.TweakableBlockCipherParameters;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public class ThreefishEngine implements BlockCipher {
    public static final int BLOCKSIZE_1024 = 1024;
    public static final int BLOCKSIZE_256 = 256;
    public static final int BLOCKSIZE_512 = 512;

    /* renamed from: C_240 */
    private static final long f20112C_240 = 2004413935125273122L;
    private static final int MAX_ROUNDS = 80;

    /* renamed from: MOD17 */
    private static int[] f20113MOD17 = null;

    /* renamed from: MOD3 */
    private static int[] f20114MOD3 = null;

    /* renamed from: MOD5 */
    private static int[] f20115MOD5 = null;

    /* renamed from: MOD9 */
    private static int[] f20116MOD9 = null;
    private static final int ROUNDS_1024 = 80;
    private static final int ROUNDS_256 = 72;
    private static final int ROUNDS_512 = 72;
    private static final int TWEAK_SIZE_BYTES = 16;
    private static final int TWEAK_SIZE_WORDS = 2;
    private int blocksizeBytes;
    private int blocksizeWords;

    /* renamed from: cipher */
    private ThreefishCipher f20117cipher;
    private long[] currentBlock;
    private boolean forEncryption;

    /* renamed from: kw */
    private long[] f20118kw;

    /* renamed from: t */
    private long[] f20119t;

    public static final class Threefish1024Cipher extends ThreefishCipher {
        private static final int ROTATION_0_0 = 24;
        private static final int ROTATION_0_1 = 13;
        private static final int ROTATION_0_2 = 8;
        private static final int ROTATION_0_3 = 47;
        private static final int ROTATION_0_4 = 8;
        private static final int ROTATION_0_5 = 17;
        private static final int ROTATION_0_6 = 22;
        private static final int ROTATION_0_7 = 37;
        private static final int ROTATION_1_0 = 38;
        private static final int ROTATION_1_1 = 19;
        private static final int ROTATION_1_2 = 10;
        private static final int ROTATION_1_3 = 55;
        private static final int ROTATION_1_4 = 49;
        private static final int ROTATION_1_5 = 18;
        private static final int ROTATION_1_6 = 23;
        private static final int ROTATION_1_7 = 52;
        private static final int ROTATION_2_0 = 33;
        private static final int ROTATION_2_1 = 4;
        private static final int ROTATION_2_2 = 51;
        private static final int ROTATION_2_3 = 13;
        private static final int ROTATION_2_4 = 34;
        private static final int ROTATION_2_5 = 41;
        private static final int ROTATION_2_6 = 59;
        private static final int ROTATION_2_7 = 17;
        private static final int ROTATION_3_0 = 5;
        private static final int ROTATION_3_1 = 20;
        private static final int ROTATION_3_2 = 48;
        private static final int ROTATION_3_3 = 41;
        private static final int ROTATION_3_4 = 47;
        private static final int ROTATION_3_5 = 28;
        private static final int ROTATION_3_6 = 16;
        private static final int ROTATION_3_7 = 25;
        private static final int ROTATION_4_0 = 41;
        private static final int ROTATION_4_1 = 9;
        private static final int ROTATION_4_2 = 37;
        private static final int ROTATION_4_3 = 31;
        private static final int ROTATION_4_4 = 12;
        private static final int ROTATION_4_5 = 47;
        private static final int ROTATION_4_6 = 44;
        private static final int ROTATION_4_7 = 30;
        private static final int ROTATION_5_0 = 16;
        private static final int ROTATION_5_1 = 34;
        private static final int ROTATION_5_2 = 56;
        private static final int ROTATION_5_3 = 51;
        private static final int ROTATION_5_4 = 4;
        private static final int ROTATION_5_5 = 53;
        private static final int ROTATION_5_6 = 42;
        private static final int ROTATION_5_7 = 41;
        private static final int ROTATION_6_0 = 31;
        private static final int ROTATION_6_1 = 44;
        private static final int ROTATION_6_2 = 47;
        private static final int ROTATION_6_3 = 46;
        private static final int ROTATION_6_4 = 19;
        private static final int ROTATION_6_5 = 42;
        private static final int ROTATION_6_6 = 44;
        private static final int ROTATION_6_7 = 25;
        private static final int ROTATION_7_0 = 9;
        private static final int ROTATION_7_1 = 48;
        private static final int ROTATION_7_2 = 35;
        private static final int ROTATION_7_3 = 52;
        private static final int ROTATION_7_4 = 23;
        private static final int ROTATION_7_5 = 31;
        private static final int ROTATION_7_6 = 37;
        private static final int ROTATION_7_7 = 20;

        public Threefish1024Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        public void decryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.f20120kw;
            long[] jArr4 = this.f20121t;
            int[] iArr = ThreefishEngine.f20113MOD17;
            int[] iArr2 = ThreefishEngine.f20114MOD3;
            if (jArr3.length != 33) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j = jArr[0];
            int i = 1;
            long j2 = jArr[1];
            long j3 = jArr[2];
            long j4 = jArr[3];
            long j5 = jArr[4];
            long j6 = jArr[5];
            long j7 = jArr[6];
            long j8 = jArr[7];
            long j9 = jArr[8];
            long j10 = jArr[9];
            long j11 = jArr[10];
            long j12 = jArr[11];
            long j13 = jArr[12];
            long j14 = jArr[13];
            long j15 = jArr[14];
            long jM15435xorRotr = jArr[15];
            int i2 = 19;
            while (i2 >= i) {
                int i3 = iArr[i2];
                int i4 = iArr2[i2];
                int i5 = i3 + 1;
                long j16 = j - jArr3[i5];
                int i6 = i3 + 2;
                long j17 = j2 - jArr3[i6];
                int i7 = i3 + 3;
                long j18 = j3 - jArr3[i7];
                int i8 = i3 + 4;
                long j19 = j4 - jArr3[i8];
                int i9 = i3 + 5;
                long j20 = j5 - jArr3[i9];
                int i10 = i3 + 6;
                long j21 = j6 - jArr3[i10];
                int i11 = i3 + 7;
                int[] iArr3 = iArr;
                long j22 = j7 - jArr3[i11];
                int i12 = i3 + 8;
                long j23 = j8 - jArr3[i12];
                int i13 = i3 + 9;
                long j24 = j9 - jArr3[i13];
                int i14 = i3 + 10;
                long j25 = j10 - jArr3[i14];
                int i15 = i3 + 11;
                long j26 = j11 - jArr3[i15];
                int i16 = i3 + 12;
                long j27 = j12 - jArr3[i16];
                int i17 = i3 + 13;
                long j28 = j13 - jArr3[i17];
                int i18 = i3 + 14;
                int i19 = i4 + 1;
                long j29 = j14 - (jArr3[i18] + jArr4[i19]);
                int i20 = i3 + 15;
                long j30 = j15 - (jArr3[i20] + jArr4[i4 + 2]);
                long[] jArr5 = jArr4;
                long[] jArr6 = jArr3;
                long j31 = i2;
                long jM15435xorRotr2 = ThreefishEngine.m15435xorRotr(jM15435xorRotr - ((jArr3[i3 + 16] + j31) + 1), 9, j16);
                long j32 = j16 - jM15435xorRotr2;
                long jM15435xorRotr3 = ThreefishEngine.m15435xorRotr(j27, 48, j18);
                long j33 = j18 - jM15435xorRotr3;
                long jM15435xorRotr4 = ThreefishEngine.m15435xorRotr(j29, 35, j22);
                long j34 = j22 - jM15435xorRotr4;
                long jM15435xorRotr5 = ThreefishEngine.m15435xorRotr(j25, 52, j20);
                long j35 = j20 - jM15435xorRotr5;
                long jM15435xorRotr6 = ThreefishEngine.m15435xorRotr(j17, 23, j30);
                long j36 = j30 - jM15435xorRotr6;
                long jM15435xorRotr7 = ThreefishEngine.m15435xorRotr(j21, 31, j24);
                long j37 = j24 - jM15435xorRotr7;
                long jM15435xorRotr8 = ThreefishEngine.m15435xorRotr(j19, 37, j26);
                long j38 = j26 - jM15435xorRotr8;
                long jM15435xorRotr9 = ThreefishEngine.m15435xorRotr(j23, 20, j28);
                long j39 = j28 - jM15435xorRotr9;
                long jM15435xorRotr10 = ThreefishEngine.m15435xorRotr(jM15435xorRotr9, 31, j32);
                long j40 = j32 - jM15435xorRotr10;
                long jM15435xorRotr11 = ThreefishEngine.m15435xorRotr(jM15435xorRotr7, 44, j33);
                long j41 = j33 - jM15435xorRotr11;
                long jM15435xorRotr12 = ThreefishEngine.m15435xorRotr(jM15435xorRotr8, 47, j35);
                long j42 = j35 - jM15435xorRotr12;
                long jM15435xorRotr13 = ThreefishEngine.m15435xorRotr(jM15435xorRotr6, 46, j34);
                long j43 = j34 - jM15435xorRotr13;
                long jM15435xorRotr14 = ThreefishEngine.m15435xorRotr(jM15435xorRotr2, 19, j39);
                long j44 = j39 - jM15435xorRotr14;
                long jM15435xorRotr15 = ThreefishEngine.m15435xorRotr(jM15435xorRotr4, 42, j36);
                long j45 = j36 - jM15435xorRotr15;
                long jM15435xorRotr16 = ThreefishEngine.m15435xorRotr(jM15435xorRotr3, 44, j37);
                long j46 = j37 - jM15435xorRotr16;
                long jM15435xorRotr17 = ThreefishEngine.m15435xorRotr(jM15435xorRotr5, 25, j38);
                long j47 = j38 - jM15435xorRotr17;
                long jM15435xorRotr18 = ThreefishEngine.m15435xorRotr(jM15435xorRotr17, 16, j40);
                long j48 = j40 - jM15435xorRotr18;
                long jM15435xorRotr19 = ThreefishEngine.m15435xorRotr(jM15435xorRotr15, 34, j41);
                long j49 = j41 - jM15435xorRotr19;
                long jM15435xorRotr20 = ThreefishEngine.m15435xorRotr(jM15435xorRotr16, 56, j43);
                long j50 = j43 - jM15435xorRotr20;
                long jM15435xorRotr21 = ThreefishEngine.m15435xorRotr(jM15435xorRotr14, 51, j42);
                long j51 = j42 - jM15435xorRotr21;
                long jM15435xorRotr22 = ThreefishEngine.m15435xorRotr(jM15435xorRotr10, 4, j47);
                long j52 = j47 - jM15435xorRotr22;
                long jM15435xorRotr23 = ThreefishEngine.m15435xorRotr(jM15435xorRotr12, 53, j44);
                long j53 = j44 - jM15435xorRotr23;
                long jM15435xorRotr24 = ThreefishEngine.m15435xorRotr(jM15435xorRotr11, 42, j45);
                long j54 = j45 - jM15435xorRotr24;
                long jM15435xorRotr25 = ThreefishEngine.m15435xorRotr(jM15435xorRotr13, 41, j46);
                long j55 = j46 - jM15435xorRotr25;
                long jM15435xorRotr26 = ThreefishEngine.m15435xorRotr(jM15435xorRotr25, 41, j48);
                long jM15435xorRotr27 = ThreefishEngine.m15435xorRotr(jM15435xorRotr23, 9, j49);
                long jM15435xorRotr28 = ThreefishEngine.m15435xorRotr(jM15435xorRotr24, 37, j51);
                long j56 = j51 - jM15435xorRotr28;
                long jM15435xorRotr29 = ThreefishEngine.m15435xorRotr(jM15435xorRotr22, 31, j50);
                long j57 = j50 - jM15435xorRotr29;
                long jM15435xorRotr30 = ThreefishEngine.m15435xorRotr(jM15435xorRotr18, 12, j55);
                long j58 = j55 - jM15435xorRotr30;
                long jM15435xorRotr31 = ThreefishEngine.m15435xorRotr(jM15435xorRotr20, 47, j52);
                long j59 = j52 - jM15435xorRotr31;
                long jM15435xorRotr32 = ThreefishEngine.m15435xorRotr(jM15435xorRotr19, 44, j53);
                long j60 = j53 - jM15435xorRotr32;
                long jM15435xorRotr33 = ThreefishEngine.m15435xorRotr(jM15435xorRotr21, 30, j54);
                long j61 = j54 - jM15435xorRotr33;
                long j62 = (j48 - jM15435xorRotr26) - jArr6[i3];
                long j63 = jM15435xorRotr26 - jArr6[i5];
                long j64 = (j49 - jM15435xorRotr27) - jArr6[i6];
                long j65 = jM15435xorRotr27 - jArr6[i7];
                long j66 = j56 - jArr6[i8];
                long j67 = jM15435xorRotr28 - jArr6[i9];
                long j68 = j57 - jArr6[i10];
                long j69 = jM15435xorRotr29 - jArr6[i11];
                long j70 = j58 - jArr6[i12];
                long j71 = jM15435xorRotr30 - jArr6[i13];
                long j72 = j59 - jArr6[i14];
                long j73 = jM15435xorRotr31 - jArr6[i15];
                long j74 = j60 - jArr6[i16];
                long j75 = jM15435xorRotr32 - (jArr6[i17] + jArr5[i4]);
                long j76 = j61 - (jArr6[i18] + jArr5[i19]);
                long jM15435xorRotr34 = ThreefishEngine.m15435xorRotr(jM15435xorRotr33 - (jArr6[i20] + j31), 5, j62);
                long j77 = j62 - jM15435xorRotr34;
                long jM15435xorRotr35 = ThreefishEngine.m15435xorRotr(j73, 20, j64);
                long j78 = j64 - jM15435xorRotr35;
                long jM15435xorRotr36 = ThreefishEngine.m15435xorRotr(j75, 48, j68);
                long j79 = j68 - jM15435xorRotr36;
                long jM15435xorRotr37 = ThreefishEngine.m15435xorRotr(j71, 41, j66);
                long j80 = j66 - jM15435xorRotr37;
                long jM15435xorRotr38 = ThreefishEngine.m15435xorRotr(j63, 47, j76);
                long j81 = j76 - jM15435xorRotr38;
                long jM15435xorRotr39 = ThreefishEngine.m15435xorRotr(j67, 28, j70);
                long j82 = j70 - jM15435xorRotr39;
                long jM15435xorRotr40 = ThreefishEngine.m15435xorRotr(j65, 16, j72);
                long j83 = j72 - jM15435xorRotr40;
                long jM15435xorRotr41 = ThreefishEngine.m15435xorRotr(j69, 25, j74);
                long j84 = j74 - jM15435xorRotr41;
                long jM15435xorRotr42 = ThreefishEngine.m15435xorRotr(jM15435xorRotr41, 33, j77);
                long j85 = j77 - jM15435xorRotr42;
                long jM15435xorRotr43 = ThreefishEngine.m15435xorRotr(jM15435xorRotr39, 4, j78);
                long j86 = j78 - jM15435xorRotr43;
                long jM15435xorRotr44 = ThreefishEngine.m15435xorRotr(jM15435xorRotr40, 51, j80);
                long j87 = j80 - jM15435xorRotr44;
                long jM15435xorRotr45 = ThreefishEngine.m15435xorRotr(jM15435xorRotr38, 13, j79);
                long j88 = j79 - jM15435xorRotr45;
                long jM15435xorRotr46 = ThreefishEngine.m15435xorRotr(jM15435xorRotr34, 34, j84);
                long j89 = j84 - jM15435xorRotr46;
                long jM15435xorRotr47 = ThreefishEngine.m15435xorRotr(jM15435xorRotr36, 41, j81);
                long j90 = j81 - jM15435xorRotr47;
                long jM15435xorRotr48 = ThreefishEngine.m15435xorRotr(jM15435xorRotr35, 59, j82);
                long j91 = j82 - jM15435xorRotr48;
                long jM15435xorRotr49 = ThreefishEngine.m15435xorRotr(jM15435xorRotr37, 17, j83);
                long j92 = j83 - jM15435xorRotr49;
                long jM15435xorRotr50 = ThreefishEngine.m15435xorRotr(jM15435xorRotr49, 38, j85);
                long j93 = j85 - jM15435xorRotr50;
                long jM15435xorRotr51 = ThreefishEngine.m15435xorRotr(jM15435xorRotr47, 19, j86);
                long j94 = j86 - jM15435xorRotr51;
                long jM15435xorRotr52 = ThreefishEngine.m15435xorRotr(jM15435xorRotr48, 10, j88);
                long j95 = j88 - jM15435xorRotr52;
                long jM15435xorRotr53 = ThreefishEngine.m15435xorRotr(jM15435xorRotr46, 55, j87);
                long j96 = j87 - jM15435xorRotr53;
                long jM15435xorRotr54 = ThreefishEngine.m15435xorRotr(jM15435xorRotr42, ROTATION_1_4, j92);
                long j97 = j92 - jM15435xorRotr54;
                long jM15435xorRotr55 = ThreefishEngine.m15435xorRotr(jM15435xorRotr44, 18, j89);
                long j98 = j89 - jM15435xorRotr55;
                long jM15435xorRotr56 = ThreefishEngine.m15435xorRotr(jM15435xorRotr43, 23, j90);
                long j99 = j90 - jM15435xorRotr56;
                long jM15435xorRotr57 = ThreefishEngine.m15435xorRotr(jM15435xorRotr45, 52, j91);
                long j100 = j91 - jM15435xorRotr57;
                long jM15435xorRotr58 = ThreefishEngine.m15435xorRotr(jM15435xorRotr57, 24, j93);
                j = j93 - jM15435xorRotr58;
                long jM15435xorRotr59 = ThreefishEngine.m15435xorRotr(jM15435xorRotr55, 13, j94);
                j3 = j94 - jM15435xorRotr59;
                long jM15435xorRotr60 = ThreefishEngine.m15435xorRotr(jM15435xorRotr56, 8, j96);
                long j101 = j96 - jM15435xorRotr60;
                long jM15435xorRotr61 = ThreefishEngine.m15435xorRotr(jM15435xorRotr54, 47, j95);
                long j102 = j95 - jM15435xorRotr61;
                long jM15435xorRotr62 = ThreefishEngine.m15435xorRotr(jM15435xorRotr50, 8, j100);
                long j103 = j100 - jM15435xorRotr62;
                long jM15435xorRotr63 = ThreefishEngine.m15435xorRotr(jM15435xorRotr52, 17, j97);
                long j104 = j97 - jM15435xorRotr63;
                long jM15435xorRotr64 = ThreefishEngine.m15435xorRotr(jM15435xorRotr51, 22, j98);
                long j105 = j98 - jM15435xorRotr64;
                jM15435xorRotr = ThreefishEngine.m15435xorRotr(jM15435xorRotr53, 37, j99);
                j15 = j99 - jM15435xorRotr;
                j12 = jM15435xorRotr63;
                iArr = iArr3;
                iArr2 = iArr2;
                jArr3 = jArr6;
                j9 = j103;
                j4 = jM15435xorRotr59;
                i2 -= 2;
                jArr4 = jArr5;
                i = 1;
                j2 = jM15435xorRotr58;
                j8 = jM15435xorRotr61;
                j11 = j104;
                j14 = jM15435xorRotr64;
                j7 = j102;
                j13 = j105;
                j6 = jM15435xorRotr60;
                j5 = j101;
                j10 = jM15435xorRotr62;
            }
            long[] jArr7 = jArr4;
            long[] jArr8 = jArr3;
            long j106 = j - jArr8[0];
            long j107 = j2 - jArr8[1];
            long j108 = j3 - jArr8[2];
            long j109 = j4 - jArr8[3];
            long j110 = j5 - jArr8[4];
            long j111 = j6 - jArr8[5];
            long j112 = j7 - jArr8[6];
            long j113 = j8 - jArr8[7];
            long j114 = j9 - jArr8[8];
            long j115 = j10 - jArr8[9];
            long j116 = j11 - jArr8[10];
            long j117 = j12 - jArr8[11];
            long j118 = j13 - jArr8[12];
            long j119 = j14 - (jArr8[13] + jArr7[0]);
            long j120 = j15 - (jArr8[14] + jArr7[1]);
            long j121 = jM15435xorRotr - jArr8[15];
            jArr2[0] = j106;
            jArr2[1] = j107;
            jArr2[2] = j108;
            jArr2[3] = j109;
            jArr2[4] = j110;
            jArr2[5] = j111;
            jArr2[6] = j112;
            jArr2[7] = j113;
            jArr2[8] = j114;
            jArr2[9] = j115;
            jArr2[10] = j116;
            jArr2[11] = j117;
            jArr2[12] = j118;
            jArr2[13] = j119;
            jArr2[14] = j120;
            jArr2[15] = j121;
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        public void encryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.f20120kw;
            long[] jArr4 = this.f20121t;
            int[] iArr = ThreefishEngine.f20113MOD17;
            int[] iArr2 = ThreefishEngine.f20114MOD3;
            if (jArr3.length != 33) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j = jArr[0];
            int i = 1;
            long j2 = jArr[1];
            long j3 = jArr[2];
            long j4 = jArr[3];
            long j5 = jArr[4];
            long j6 = jArr[5];
            long j7 = jArr[6];
            long j8 = jArr[7];
            long j9 = jArr[8];
            long j10 = jArr[9];
            long j11 = jArr[10];
            long j12 = jArr[11];
            long j13 = jArr[12];
            int i2 = 13;
            long j14 = jArr[13];
            long j15 = jArr[14];
            long j16 = jArr[15];
            long j17 = j + jArr3[0];
            long j18 = j2 + jArr3[1];
            long j19 = j3 + jArr3[2];
            long j20 = j4 + jArr3[3];
            long j21 = j5 + jArr3[4];
            long j22 = j6 + jArr3[5];
            long j23 = j7 + jArr3[6];
            long j24 = j8 + jArr3[7];
            long j25 = j9 + jArr3[8];
            long j26 = j10 + jArr3[9];
            long j27 = j11 + jArr3[10];
            long j28 = j12 + jArr3[11];
            long j29 = j13 + jArr3[12];
            long j30 = j14 + jArr3[13] + jArr4[0];
            long j31 = j15 + jArr3[14] + jArr4[1];
            long j32 = j20;
            long j33 = j22;
            long j34 = j24;
            long j35 = j26;
            long j36 = j28;
            long j37 = j30;
            long j38 = j16 + jArr3[15];
            while (i < 20) {
                int i3 = iArr[i];
                int i4 = iArr2[i];
                long j39 = j17 + j18;
                long jM15433rotlXor = ThreefishEngine.m15433rotlXor(j18, 24, j39);
                long j40 = j19 + j32;
                long jM15433rotlXor2 = ThreefishEngine.m15433rotlXor(j32, i2, j40);
                long j41 = j33;
                long j42 = j21 + j41;
                long jM15433rotlXor3 = ThreefishEngine.m15433rotlXor(j41, 8, j42);
                long j43 = j34;
                int[] iArr3 = iArr;
                long j44 = j23 + j43;
                long jM15433rotlXor4 = ThreefishEngine.m15433rotlXor(j43, 47, j44);
                long[] jArr5 = jArr4;
                long[] jArr6 = jArr3;
                int i5 = i;
                long j45 = j35;
                long j46 = j25 + j45;
                long jM15433rotlXor5 = ThreefishEngine.m15433rotlXor(j45, 8, j46);
                long j47 = j36;
                long j48 = j27 + j47;
                long jM15433rotlXor6 = ThreefishEngine.m15433rotlXor(j47, 17, j48);
                long j49 = j37;
                long j50 = j29 + j49;
                long jM15433rotlXor7 = ThreefishEngine.m15433rotlXor(j49, 22, j50);
                long j51 = j38;
                long j52 = j31 + j51;
                long jM15433rotlXor8 = ThreefishEngine.m15433rotlXor(j51, 37, j52);
                long j53 = j39 + jM15433rotlXor5;
                long jM15433rotlXor9 = ThreefishEngine.m15433rotlXor(jM15433rotlXor5, 38, j53);
                long j54 = j40 + jM15433rotlXor7;
                long jM15433rotlXor10 = ThreefishEngine.m15433rotlXor(jM15433rotlXor7, 19, j54);
                long j55 = j44 + jM15433rotlXor6;
                long jM15433rotlXor11 = ThreefishEngine.m15433rotlXor(jM15433rotlXor6, 10, j55);
                long j56 = j42 + jM15433rotlXor8;
                long jM15433rotlXor12 = ThreefishEngine.m15433rotlXor(jM15433rotlXor8, 55, j56);
                long j57 = j48 + jM15433rotlXor4;
                long jM15433rotlXor13 = ThreefishEngine.m15433rotlXor(jM15433rotlXor4, ROTATION_1_4, j57);
                long j58 = j50 + jM15433rotlXor2;
                long jM15433rotlXor14 = ThreefishEngine.m15433rotlXor(jM15433rotlXor2, 18, j58);
                long j59 = j52 + jM15433rotlXor3;
                long jM15433rotlXor15 = ThreefishEngine.m15433rotlXor(jM15433rotlXor3, 23, j59);
                long j60 = j46 + jM15433rotlXor;
                long jM15433rotlXor16 = ThreefishEngine.m15433rotlXor(jM15433rotlXor, 52, j60);
                long j61 = j53 + jM15433rotlXor13;
                long jM15433rotlXor17 = ThreefishEngine.m15433rotlXor(jM15433rotlXor13, 33, j61);
                long j62 = j54 + jM15433rotlXor15;
                long jM15433rotlXor18 = ThreefishEngine.m15433rotlXor(jM15433rotlXor15, 4, j62);
                long j63 = j56 + jM15433rotlXor14;
                long jM15433rotlXor19 = ThreefishEngine.m15433rotlXor(jM15433rotlXor14, 51, j63);
                long j64 = j55 + jM15433rotlXor16;
                long jM15433rotlXor20 = ThreefishEngine.m15433rotlXor(jM15433rotlXor16, 13, j64);
                long j65 = j58 + jM15433rotlXor12;
                long jM15433rotlXor21 = ThreefishEngine.m15433rotlXor(jM15433rotlXor12, 34, j65);
                long j66 = j59 + jM15433rotlXor10;
                long jM15433rotlXor22 = ThreefishEngine.m15433rotlXor(jM15433rotlXor10, 41, j66);
                long j67 = j60 + jM15433rotlXor11;
                long jM15433rotlXor23 = ThreefishEngine.m15433rotlXor(jM15433rotlXor11, 59, j67);
                long j68 = j57 + jM15433rotlXor9;
                long jM15433rotlXor24 = ThreefishEngine.m15433rotlXor(jM15433rotlXor9, 17, j68);
                long j69 = j61 + jM15433rotlXor21;
                long jM15433rotlXor25 = ThreefishEngine.m15433rotlXor(jM15433rotlXor21, 5, j69);
                long j70 = j62 + jM15433rotlXor23;
                long jM15433rotlXor26 = ThreefishEngine.m15433rotlXor(jM15433rotlXor23, 20, j70);
                long j71 = j64 + jM15433rotlXor22;
                long jM15433rotlXor27 = ThreefishEngine.m15433rotlXor(jM15433rotlXor22, 48, j71);
                long j72 = j63 + jM15433rotlXor24;
                long jM15433rotlXor28 = ThreefishEngine.m15433rotlXor(jM15433rotlXor24, 41, j72);
                long j73 = j66 + jM15433rotlXor20;
                long jM15433rotlXor29 = ThreefishEngine.m15433rotlXor(jM15433rotlXor20, 47, j73);
                long j74 = j67 + jM15433rotlXor18;
                long jM15433rotlXor30 = ThreefishEngine.m15433rotlXor(jM15433rotlXor18, 28, j74);
                long j75 = j68 + jM15433rotlXor19;
                long jM15433rotlXor31 = ThreefishEngine.m15433rotlXor(jM15433rotlXor19, 16, j75);
                long j76 = j65 + jM15433rotlXor17;
                long jM15433rotlXor32 = ThreefishEngine.m15433rotlXor(jM15433rotlXor17, 25, j76);
                long j77 = j69 + jArr6[i3];
                int i6 = i3 + 1;
                long j78 = jM15433rotlXor29 + jArr6[i6];
                int i7 = i3 + 2;
                long j79 = j70 + jArr6[i7];
                int i8 = i3 + 3;
                long j80 = jM15433rotlXor31 + jArr6[i8];
                int i9 = i3 + 4;
                long j81 = j72 + jArr6[i9];
                int i10 = i3 + 5;
                long j82 = jM15433rotlXor30 + jArr6[i10];
                int i11 = i3 + 6;
                long j83 = j71 + jArr6[i11];
                int i12 = i3 + 7;
                long j84 = jM15433rotlXor32 + jArr6[i12];
                int i13 = i3 + 8;
                long j85 = j74 + jArr6[i13];
                int i14 = i3 + 9;
                long j86 = jM15433rotlXor28 + jArr6[i14];
                int i15 = i3 + 10;
                long j87 = j75 + jArr6[i15];
                int i16 = i3 + 11;
                long j88 = jM15433rotlXor26 + jArr6[i16];
                int i17 = i3 + 12;
                long j89 = j76 + jArr6[i17];
                int i18 = i3 + 13;
                long j90 = jM15433rotlXor27 + jArr6[i18] + jArr5[i4];
                int i19 = i3 + 14;
                int i20 = i4 + 1;
                long j91 = j73 + jArr6[i19] + jArr5[i20];
                int i21 = i3 + 15;
                long j92 = i5;
                long j93 = jM15433rotlXor25 + jArr6[i21] + j92;
                long j94 = j77 + j78;
                long jM15433rotlXor33 = ThreefishEngine.m15433rotlXor(j78, 41, j94);
                long j95 = j79 + j80;
                long jM15433rotlXor34 = ThreefishEngine.m15433rotlXor(j80, 9, j95);
                long j96 = j81 + j82;
                long jM15433rotlXor35 = ThreefishEngine.m15433rotlXor(j82, 37, j96);
                long j97 = j83 + j84;
                long jM15433rotlXor36 = ThreefishEngine.m15433rotlXor(j84, 31, j97);
                long j98 = j85 + j86;
                long jM15433rotlXor37 = ThreefishEngine.m15433rotlXor(j86, 12, j98);
                long j99 = j87 + j88;
                long jM15433rotlXor38 = ThreefishEngine.m15433rotlXor(j88, 47, j99);
                long j100 = j89 + j90;
                long jM15433rotlXor39 = ThreefishEngine.m15433rotlXor(j90, 44, j100);
                long j101 = j91 + j93;
                long jM15433rotlXor40 = ThreefishEngine.m15433rotlXor(j93, 30, j101);
                long j102 = j94 + jM15433rotlXor37;
                long jM15433rotlXor41 = ThreefishEngine.m15433rotlXor(jM15433rotlXor37, 16, j102);
                long j103 = j95 + jM15433rotlXor39;
                long jM15433rotlXor42 = ThreefishEngine.m15433rotlXor(jM15433rotlXor39, 34, j103);
                long j104 = j97 + jM15433rotlXor38;
                long jM15433rotlXor43 = ThreefishEngine.m15433rotlXor(jM15433rotlXor38, 56, j104);
                long j105 = j96 + jM15433rotlXor40;
                long jM15433rotlXor44 = ThreefishEngine.m15433rotlXor(jM15433rotlXor40, 51, j105);
                long j106 = j99 + jM15433rotlXor36;
                long jM15433rotlXor45 = ThreefishEngine.m15433rotlXor(jM15433rotlXor36, 4, j106);
                long j107 = j100 + jM15433rotlXor34;
                long jM15433rotlXor46 = ThreefishEngine.m15433rotlXor(jM15433rotlXor34, 53, j107);
                long j108 = j101 + jM15433rotlXor35;
                long jM15433rotlXor47 = ThreefishEngine.m15433rotlXor(jM15433rotlXor35, 42, j108);
                long j109 = j98 + jM15433rotlXor33;
                long jM15433rotlXor48 = ThreefishEngine.m15433rotlXor(jM15433rotlXor33, 41, j109);
                long j110 = j102 + jM15433rotlXor45;
                long jM15433rotlXor49 = ThreefishEngine.m15433rotlXor(jM15433rotlXor45, 31, j110);
                long j111 = j103 + jM15433rotlXor47;
                long jM15433rotlXor50 = ThreefishEngine.m15433rotlXor(jM15433rotlXor47, 44, j111);
                long j112 = j105 + jM15433rotlXor46;
                long jM15433rotlXor51 = ThreefishEngine.m15433rotlXor(jM15433rotlXor46, 47, j112);
                long j113 = j104 + jM15433rotlXor48;
                long jM15433rotlXor52 = ThreefishEngine.m15433rotlXor(jM15433rotlXor48, 46, j113);
                long j114 = j107 + jM15433rotlXor44;
                long jM15433rotlXor53 = ThreefishEngine.m15433rotlXor(jM15433rotlXor44, 19, j114);
                long j115 = j108 + jM15433rotlXor42;
                long jM15433rotlXor54 = ThreefishEngine.m15433rotlXor(jM15433rotlXor42, 42, j115);
                long j116 = j109 + jM15433rotlXor43;
                long jM15433rotlXor55 = ThreefishEngine.m15433rotlXor(jM15433rotlXor43, 44, j116);
                long j117 = j106 + jM15433rotlXor41;
                long jM15433rotlXor56 = ThreefishEngine.m15433rotlXor(jM15433rotlXor41, 25, j117);
                long j118 = j110 + jM15433rotlXor53;
                long jM15433rotlXor57 = ThreefishEngine.m15433rotlXor(jM15433rotlXor53, 9, j118);
                long j119 = j111 + jM15433rotlXor55;
                long jM15433rotlXor58 = ThreefishEngine.m15433rotlXor(jM15433rotlXor55, 48, j119);
                long j120 = j113 + jM15433rotlXor54;
                long jM15433rotlXor59 = ThreefishEngine.m15433rotlXor(jM15433rotlXor54, 35, j120);
                long j121 = j112 + jM15433rotlXor56;
                long jM15433rotlXor60 = ThreefishEngine.m15433rotlXor(jM15433rotlXor56, 52, j121);
                long j122 = j115 + jM15433rotlXor52;
                long jM15433rotlXor61 = ThreefishEngine.m15433rotlXor(jM15433rotlXor52, 23, j122);
                long j123 = j116 + jM15433rotlXor50;
                long jM15433rotlXor62 = ThreefishEngine.m15433rotlXor(jM15433rotlXor50, 31, j123);
                long j124 = j117 + jM15433rotlXor51;
                long jM15433rotlXor63 = ThreefishEngine.m15433rotlXor(jM15433rotlXor51, 37, j124);
                long j125 = j114 + jM15433rotlXor49;
                long jM15433rotlXor64 = ThreefishEngine.m15433rotlXor(jM15433rotlXor49, 20, j125);
                j17 = j118 + jArr6[i6];
                long j126 = jM15433rotlXor61 + jArr6[i7];
                long j127 = j119 + jArr6[i8];
                j32 = jArr6[i9] + jM15433rotlXor63;
                long j128 = jArr6[i10] + j121;
                long j129 = jM15433rotlXor62 + jArr6[i11];
                j23 = j120 + jArr6[i12];
                long j130 = jM15433rotlXor64 + jArr6[i13];
                long j131 = j123 + jArr6[i14];
                long j132 = jM15433rotlXor60 + jArr6[i15];
                long j133 = j124 + jArr6[i16];
                j36 = jM15433rotlXor58 + jArr6[i17];
                long j134 = j125 + jArr6[i18];
                j37 = jM15433rotlXor59 + jArr6[i19] + jArr5[i20];
                j31 = j122 + jArr6[i21] + jArr5[i4 + 2];
                j38 = jM15433rotlXor57 + jArr6[i3 + 16] + j92 + 1;
                j29 = j134;
                j25 = j131;
                j35 = j132;
                j27 = j133;
                j34 = j130;
                j21 = j128;
                j33 = j129;
                i = i5 + 2;
                i2 = 13;
                j19 = j127;
                j18 = j126;
                iArr2 = iArr2;
                iArr = iArr3;
                jArr3 = jArr6;
                jArr4 = jArr5;
            }
            jArr2[0] = j17;
            jArr2[1] = j18;
            jArr2[2] = j19;
            jArr2[3] = j32;
            jArr2[4] = j21;
            jArr2[5] = j33;
            jArr2[6] = j23;
            jArr2[7] = j34;
            jArr2[8] = j25;
            jArr2[9] = j35;
            jArr2[10] = j27;
            jArr2[11] = j36;
            jArr2[12] = j29;
            jArr2[13] = j37;
            jArr2[14] = j31;
            jArr2[15] = j38;
        }
    }

    public static final class Threefish256Cipher extends ThreefishCipher {
        private static final int ROTATION_0_0 = 14;
        private static final int ROTATION_0_1 = 16;
        private static final int ROTATION_1_0 = 52;
        private static final int ROTATION_1_1 = 57;
        private static final int ROTATION_2_0 = 23;
        private static final int ROTATION_2_1 = 40;
        private static final int ROTATION_3_0 = 5;
        private static final int ROTATION_3_1 = 37;
        private static final int ROTATION_4_0 = 25;
        private static final int ROTATION_4_1 = 33;
        private static final int ROTATION_5_0 = 46;
        private static final int ROTATION_5_1 = 12;
        private static final int ROTATION_6_0 = 58;
        private static final int ROTATION_6_1 = 22;
        private static final int ROTATION_7_0 = 32;
        private static final int ROTATION_7_1 = 32;

        public Threefish256Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        public void decryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.f20120kw;
            long[] jArr4 = this.f20121t;
            int[] iArr = ThreefishEngine.f20115MOD5;
            int[] iArr2 = ThreefishEngine.f20114MOD3;
            if (jArr3.length != 9) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            boolean z = false;
            long j = jArr[0];
            long j2 = jArr[1];
            long j3 = jArr[2];
            long jM15435xorRotr = jArr[3];
            int i = 17;
            for (int i2 = 1; i >= i2; i2 = 1) {
                int i3 = iArr[i];
                int i4 = iArr2[i];
                int i5 = i3 + 1;
                long j4 = j - jArr3[i5];
                int i6 = i3 + 2;
                int i7 = i4 + 1;
                long j5 = j2 - (jArr3[i6] + jArr4[i7]);
                int i8 = i3 + 3;
                long j6 = j3 - (jArr3[i8] + jArr4[i4 + 2]);
                long j7 = i;
                long jM15435xorRotr2 = ThreefishEngine.m15435xorRotr(jM15435xorRotr - ((jArr3[i3 + 4] + j7) + 1), 32, j4);
                long j8 = j4 - jM15435xorRotr2;
                int[] iArr3 = iArr;
                long jM15435xorRotr3 = ThreefishEngine.m15435xorRotr(j5, 32, j6);
                long j9 = j6 - jM15435xorRotr3;
                long jM15435xorRotr4 = ThreefishEngine.m15435xorRotr(jM15435xorRotr3, 58, j8);
                long j10 = j8 - jM15435xorRotr4;
                long jM15435xorRotr5 = ThreefishEngine.m15435xorRotr(jM15435xorRotr2, 22, j9);
                long j11 = j9 - jM15435xorRotr5;
                long jM15435xorRotr6 = ThreefishEngine.m15435xorRotr(jM15435xorRotr5, 46, j10);
                long j12 = j10 - jM15435xorRotr6;
                long jM15435xorRotr7 = ThreefishEngine.m15435xorRotr(jM15435xorRotr4, 12, j11);
                long j13 = j11 - jM15435xorRotr7;
                long jM15435xorRotr8 = ThreefishEngine.m15435xorRotr(jM15435xorRotr7, 25, j12);
                long jM15435xorRotr9 = ThreefishEngine.m15435xorRotr(jM15435xorRotr6, 33, j13);
                long j14 = (j12 - jM15435xorRotr8) - jArr3[i3];
                long j15 = jM15435xorRotr8 - (jArr3[i5] + jArr4[i4]);
                long j16 = (j13 - jM15435xorRotr9) - (jArr3[i6] + jArr4[i7]);
                long jM15435xorRotr10 = ThreefishEngine.m15435xorRotr(jM15435xorRotr9 - (jArr3[i8] + j7), 5, j14);
                long j17 = j14 - jM15435xorRotr10;
                long jM15435xorRotr11 = ThreefishEngine.m15435xorRotr(j15, 37, j16);
                long j18 = j16 - jM15435xorRotr11;
                long jM15435xorRotr12 = ThreefishEngine.m15435xorRotr(jM15435xorRotr11, 23, j17);
                long j19 = j17 - jM15435xorRotr12;
                long jM15435xorRotr13 = ThreefishEngine.m15435xorRotr(jM15435xorRotr10, 40, j18);
                long j20 = j18 - jM15435xorRotr13;
                long jM15435xorRotr14 = ThreefishEngine.m15435xorRotr(jM15435xorRotr13, 52, j19);
                long j21 = j19 - jM15435xorRotr14;
                long jM15435xorRotr15 = ThreefishEngine.m15435xorRotr(jM15435xorRotr12, 57, j20);
                long j22 = j20 - jM15435xorRotr15;
                long jM15435xorRotr16 = ThreefishEngine.m15435xorRotr(jM15435xorRotr15, 14, j21);
                j = j21 - jM15435xorRotr16;
                jM15435xorRotr = ThreefishEngine.m15435xorRotr(jM15435xorRotr14, 16, j22);
                j3 = j22 - jM15435xorRotr;
                i -= 2;
                j2 = jM15435xorRotr16;
                iArr = iArr3;
                iArr2 = iArr2;
                z = false;
            }
            boolean z2 = z;
            long j23 = j - jArr3[z2 ? 1 : 0];
            long j24 = j2 - (jArr3[1] + jArr4[z2 ? 1 : 0]);
            long j25 = j3 - (jArr3[2] + jArr4[1]);
            long j26 = jM15435xorRotr - jArr3[3];
            jArr2[z2 ? 1 : 0] = j23;
            jArr2[1] = j24;
            jArr2[2] = j25;
            jArr2[3] = j26;
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        public void encryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.f20120kw;
            long[] jArr4 = this.f20121t;
            int[] iArr = ThreefishEngine.f20115MOD5;
            int[] iArr2 = ThreefishEngine.f20114MOD3;
            if (jArr3.length != 9) {
                throw new IllegalArgumentException();
            }
            int i = 5;
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j = jArr[0];
            int i2 = 1;
            long j2 = jArr[1];
            long j3 = jArr[2];
            long j4 = jArr[3];
            long j5 = j + jArr3[0];
            long j6 = j2 + jArr3[1] + jArr4[0];
            long j7 = j3 + jArr3[2] + jArr4[1];
            long j8 = j4 + jArr3[3];
            while (i2 < 18) {
                int i3 = iArr[i2];
                int i4 = iArr2[i2];
                long j9 = j5 + j6;
                long jM15433rotlXor = ThreefishEngine.m15433rotlXor(j6, 14, j9);
                long j10 = j7 + j8;
                long jM15433rotlXor2 = ThreefishEngine.m15433rotlXor(j8, 16, j10);
                long j11 = j9 + jM15433rotlXor2;
                long jM15433rotlXor3 = ThreefishEngine.m15433rotlXor(jM15433rotlXor2, 52, j11);
                long j12 = j10 + jM15433rotlXor;
                long jM15433rotlXor4 = ThreefishEngine.m15433rotlXor(jM15433rotlXor, 57, j12);
                long j13 = j11 + jM15433rotlXor4;
                long jM15433rotlXor5 = ThreefishEngine.m15433rotlXor(jM15433rotlXor4, 23, j13);
                long j14 = j12 + jM15433rotlXor3;
                long jM15433rotlXor6 = ThreefishEngine.m15433rotlXor(jM15433rotlXor3, 40, j14);
                long j15 = j13 + jM15433rotlXor6;
                long jM15433rotlXor7 = ThreefishEngine.m15433rotlXor(jM15433rotlXor6, i, j15);
                long j16 = j14 + jM15433rotlXor5;
                long jM15433rotlXor8 = ThreefishEngine.m15433rotlXor(jM15433rotlXor5, 37, j16);
                long j17 = j15 + jArr3[i3];
                int i5 = i3 + 1;
                long j18 = jM15433rotlXor8 + jArr3[i5] + jArr4[i4];
                int i6 = i3 + 2;
                int i7 = i4 + 1;
                long j19 = j16 + jArr3[i6] + jArr4[i7];
                int i8 = i3 + 3;
                long j20 = i2;
                long j21 = jM15433rotlXor7 + jArr3[i8] + j20;
                int[] iArr3 = iArr;
                long j22 = j17 + j18;
                long jM15433rotlXor9 = ThreefishEngine.m15433rotlXor(j18, 25, j22);
                long j23 = j19 + j21;
                long jM15433rotlXor10 = ThreefishEngine.m15433rotlXor(j21, 33, j23);
                long j24 = j22 + jM15433rotlXor10;
                long jM15433rotlXor11 = ThreefishEngine.m15433rotlXor(jM15433rotlXor10, 46, j24);
                long j25 = j23 + jM15433rotlXor9;
                long jM15433rotlXor12 = ThreefishEngine.m15433rotlXor(jM15433rotlXor9, 12, j25);
                long j26 = j24 + jM15433rotlXor12;
                long jM15433rotlXor13 = ThreefishEngine.m15433rotlXor(jM15433rotlXor12, 58, j26);
                long j27 = j25 + jM15433rotlXor11;
                long jM15433rotlXor14 = ThreefishEngine.m15433rotlXor(jM15433rotlXor11, 22, j27);
                long j28 = j26 + jM15433rotlXor14;
                long jM15433rotlXor15 = ThreefishEngine.m15433rotlXor(jM15433rotlXor14, 32, j28);
                long j29 = j27 + jM15433rotlXor13;
                long jM15433rotlXor16 = ThreefishEngine.m15433rotlXor(jM15433rotlXor13, 32, j29);
                long j30 = j28 + jArr3[i5];
                j6 = jM15433rotlXor16 + jArr3[i6] + jArr4[i7];
                j7 = j29 + jArr3[i8] + jArr4[i4 + 2];
                j8 = jM15433rotlXor15 + jArr3[i3 + 4] + j20 + 1;
                i2 += 2;
                j5 = j30;
                iArr = iArr3;
                iArr2 = iArr2;
                i = 5;
            }
            jArr2[0] = j5;
            jArr2[1] = j6;
            jArr2[2] = j7;
            jArr2[3] = j8;
        }
    }

    public static final class Threefish512Cipher extends ThreefishCipher {
        private static final int ROTATION_0_0 = 46;
        private static final int ROTATION_0_1 = 36;
        private static final int ROTATION_0_2 = 19;
        private static final int ROTATION_0_3 = 37;
        private static final int ROTATION_1_0 = 33;
        private static final int ROTATION_1_1 = 27;
        private static final int ROTATION_1_2 = 14;
        private static final int ROTATION_1_3 = 42;
        private static final int ROTATION_2_0 = 17;
        private static final int ROTATION_2_1 = 49;
        private static final int ROTATION_2_2 = 36;
        private static final int ROTATION_2_3 = 39;
        private static final int ROTATION_3_0 = 44;
        private static final int ROTATION_3_1 = 9;
        private static final int ROTATION_3_2 = 54;
        private static final int ROTATION_3_3 = 56;
        private static final int ROTATION_4_0 = 39;
        private static final int ROTATION_4_1 = 30;
        private static final int ROTATION_4_2 = 34;
        private static final int ROTATION_4_3 = 24;
        private static final int ROTATION_5_0 = 13;
        private static final int ROTATION_5_1 = 50;
        private static final int ROTATION_5_2 = 10;
        private static final int ROTATION_5_3 = 17;
        private static final int ROTATION_6_0 = 25;
        private static final int ROTATION_6_1 = 29;
        private static final int ROTATION_6_2 = 39;
        private static final int ROTATION_6_3 = 43;
        private static final int ROTATION_7_0 = 8;
        private static final int ROTATION_7_1 = 35;
        private static final int ROTATION_7_2 = 56;
        private static final int ROTATION_7_3 = 22;

        public Threefish512Cipher(long[] jArr, long[] jArr2) {
            super(jArr, jArr2);
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        public void decryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.f20120kw;
            long[] jArr4 = this.f20121t;
            int[] iArr = ThreefishEngine.f20116MOD9;
            int[] iArr2 = ThreefishEngine.f20114MOD3;
            if (jArr3.length != 17) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            boolean z = false;
            long j = jArr[0];
            int i = 1;
            long j2 = jArr[1];
            long j3 = jArr[2];
            long j4 = jArr[3];
            long j5 = jArr[4];
            long jM15435xorRotr = jArr[5];
            long j6 = jArr[6];
            long jM15435xorRotr2 = jArr[7];
            int i2 = 17;
            while (i2 >= i) {
                int i3 = iArr[i2];
                int i4 = iArr2[i2];
                int i5 = i3 + 1;
                long j7 = j - jArr3[i5];
                int i6 = i3 + 2;
                long j8 = j2 - jArr3[i6];
                int i7 = i3 + 3;
                long j9 = j3 - jArr3[i7];
                int i8 = i3 + 4;
                long j10 = j4 - jArr3[i8];
                int i9 = i3 + 5;
                long j11 = j5 - jArr3[i9];
                int i10 = i3 + 6;
                int i11 = i4 + 1;
                long j12 = jM15435xorRotr - (jArr3[i10] + jArr4[i11]);
                int i12 = i3 + 7;
                int[] iArr3 = iArr;
                long j13 = j6 - (jArr3[i12] + jArr4[i4 + 2]);
                long j14 = i2;
                long j15 = jM15435xorRotr2 - ((jArr3[i3 + 8] + j14) + 1);
                long[] jArr5 = jArr4;
                long[] jArr6 = jArr3;
                long jM15435xorRotr3 = ThreefishEngine.m15435xorRotr(j8, 8, j13);
                long j16 = j13 - jM15435xorRotr3;
                long jM15435xorRotr4 = ThreefishEngine.m15435xorRotr(j15, 35, j7);
                long j17 = j7 - jM15435xorRotr4;
                long jM15435xorRotr5 = ThreefishEngine.m15435xorRotr(j12, 56, j9);
                long j18 = j9 - jM15435xorRotr5;
                long jM15435xorRotr6 = ThreefishEngine.m15435xorRotr(j10, 22, j11);
                long j19 = j11 - jM15435xorRotr6;
                long jM15435xorRotr7 = ThreefishEngine.m15435xorRotr(jM15435xorRotr3, 25, j19);
                long j20 = j19 - jM15435xorRotr7;
                long jM15435xorRotr8 = ThreefishEngine.m15435xorRotr(jM15435xorRotr6, 29, j16);
                long j21 = j16 - jM15435xorRotr8;
                long jM15435xorRotr9 = ThreefishEngine.m15435xorRotr(jM15435xorRotr5, 39, j17);
                long j22 = j17 - jM15435xorRotr9;
                long jM15435xorRotr10 = ThreefishEngine.m15435xorRotr(jM15435xorRotr4, 43, j18);
                long j23 = j18 - jM15435xorRotr10;
                long jM15435xorRotr11 = ThreefishEngine.m15435xorRotr(jM15435xorRotr7, 13, j23);
                long j24 = j23 - jM15435xorRotr11;
                long jM15435xorRotr12 = ThreefishEngine.m15435xorRotr(jM15435xorRotr10, 50, j20);
                long j25 = j20 - jM15435xorRotr12;
                long jM15435xorRotr13 = ThreefishEngine.m15435xorRotr(jM15435xorRotr9, 10, j21);
                long j26 = j21 - jM15435xorRotr13;
                long jM15435xorRotr14 = ThreefishEngine.m15435xorRotr(jM15435xorRotr8, 17, j22);
                long j27 = j22 - jM15435xorRotr14;
                long jM15435xorRotr15 = ThreefishEngine.m15435xorRotr(jM15435xorRotr11, 39, j27);
                long jM15435xorRotr16 = ThreefishEngine.m15435xorRotr(jM15435xorRotr14, 30, j24);
                long jM15435xorRotr17 = ThreefishEngine.m15435xorRotr(jM15435xorRotr13, 34, j25);
                long j28 = j25 - jM15435xorRotr17;
                long jM15435xorRotr18 = ThreefishEngine.m15435xorRotr(jM15435xorRotr12, 24, j26);
                long j29 = j26 - jM15435xorRotr18;
                long j30 = (j27 - jM15435xorRotr15) - jArr6[i3];
                long j31 = jM15435xorRotr15 - jArr6[i5];
                long j32 = (j24 - jM15435xorRotr16) - jArr6[i6];
                long j33 = jM15435xorRotr16 - jArr6[i7];
                long j34 = j28 - jArr6[i8];
                long j35 = jM15435xorRotr17 - (jArr6[i9] + jArr5[i4]);
                long j36 = j29 - (jArr6[i10] + jArr5[i11]);
                long j37 = jM15435xorRotr18 - (jArr6[i12] + j14);
                long jM15435xorRotr19 = ThreefishEngine.m15435xorRotr(j31, 44, j36);
                long j38 = j36 - jM15435xorRotr19;
                long jM15435xorRotr20 = ThreefishEngine.m15435xorRotr(j37, 9, j30);
                long j39 = j30 - jM15435xorRotr20;
                long jM15435xorRotr21 = ThreefishEngine.m15435xorRotr(j35, 54, j32);
                long j40 = j32 - jM15435xorRotr21;
                long jM15435xorRotr22 = ThreefishEngine.m15435xorRotr(j33, 56, j34);
                long j41 = j34 - jM15435xorRotr22;
                long jM15435xorRotr23 = ThreefishEngine.m15435xorRotr(jM15435xorRotr19, 17, j41);
                long j42 = j41 - jM15435xorRotr23;
                long jM15435xorRotr24 = ThreefishEngine.m15435xorRotr(jM15435xorRotr22, ROTATION_2_1, j38);
                long j43 = j38 - jM15435xorRotr24;
                long jM15435xorRotr25 = ThreefishEngine.m15435xorRotr(jM15435xorRotr21, 36, j39);
                long j44 = j39 - jM15435xorRotr25;
                long jM15435xorRotr26 = ThreefishEngine.m15435xorRotr(jM15435xorRotr20, 39, j40);
                long j45 = j40 - jM15435xorRotr26;
                long jM15435xorRotr27 = ThreefishEngine.m15435xorRotr(jM15435xorRotr23, 33, j45);
                long j46 = j45 - jM15435xorRotr27;
                long jM15435xorRotr28 = ThreefishEngine.m15435xorRotr(jM15435xorRotr26, 27, j42);
                long j47 = j42 - jM15435xorRotr28;
                long jM15435xorRotr29 = ThreefishEngine.m15435xorRotr(jM15435xorRotr25, 14, j43);
                long j48 = j43 - jM15435xorRotr29;
                long jM15435xorRotr30 = ThreefishEngine.m15435xorRotr(jM15435xorRotr24, 42, j44);
                long j49 = j44 - jM15435xorRotr30;
                long jM15435xorRotr31 = ThreefishEngine.m15435xorRotr(jM15435xorRotr27, 46, j49);
                j = j49 - jM15435xorRotr31;
                long jM15435xorRotr32 = ThreefishEngine.m15435xorRotr(jM15435xorRotr30, 36, j46);
                jM15435xorRotr = ThreefishEngine.m15435xorRotr(jM15435xorRotr29, 19, j47);
                j5 = j47 - jM15435xorRotr;
                jM15435xorRotr2 = ThreefishEngine.m15435xorRotr(jM15435xorRotr28, 37, j48);
                j6 = j48 - jM15435xorRotr2;
                i2 -= 2;
                j3 = j46 - jM15435xorRotr32;
                j2 = jM15435xorRotr31;
                iArr = iArr3;
                iArr2 = iArr2;
                jArr3 = jArr6;
                jArr4 = jArr5;
                i = 1;
                j4 = jM15435xorRotr32;
                z = false;
            }
            long[] jArr7 = jArr4;
            long[] jArr8 = jArr3;
            boolean z2 = z;
            long j50 = j - jArr8[z2 ? 1 : 0];
            long j51 = j2 - jArr8[1];
            long j52 = j3 - jArr8[2];
            long j53 = j4 - jArr8[3];
            long j54 = j5 - jArr8[4];
            long j55 = jM15435xorRotr - (jArr8[5] + jArr7[z2 ? 1 : 0]);
            long j56 = j6 - (jArr8[6] + jArr7[1]);
            long j57 = jM15435xorRotr2 - jArr8[7];
            jArr2[z2 ? 1 : 0] = j50;
            jArr2[1] = j51;
            jArr2[2] = j52;
            jArr2[3] = j53;
            jArr2[4] = j54;
            jArr2[5] = j55;
            jArr2[6] = j56;
            jArr2[7] = j57;
        }

        @Override // org.bouncycastle.crypto.engines.ThreefishEngine.ThreefishCipher
        public void encryptBlock(long[] jArr, long[] jArr2) {
            long[] jArr3 = this.f20120kw;
            long[] jArr4 = this.f20121t;
            int[] iArr = ThreefishEngine.f20116MOD9;
            int[] iArr2 = ThreefishEngine.f20114MOD3;
            if (jArr3.length != 17) {
                throw new IllegalArgumentException();
            }
            if (jArr4.length != 5) {
                throw new IllegalArgumentException();
            }
            long j = jArr[0];
            long j2 = jArr[1];
            long j3 = jArr[2];
            long j4 = jArr[3];
            long j5 = jArr[4];
            long j6 = jArr[5];
            long j7 = jArr[6];
            long j8 = jArr[7];
            long j9 = j + jArr3[0];
            long j10 = j2 + jArr3[1];
            long j11 = j3 + jArr3[2];
            long j12 = j4 + jArr3[3];
            long j13 = j5 + jArr3[4];
            long j14 = j6 + jArr3[5] + jArr4[0];
            long j15 = j7 + jArr3[6] + jArr4[1];
            int i = 1;
            long j16 = j12;
            long j17 = j14;
            long j18 = j8 + jArr3[7];
            while (i < 18) {
                int i2 = iArr[i];
                int i3 = iArr2[i];
                long j19 = j9 + j10;
                long jM15433rotlXor = ThreefishEngine.m15433rotlXor(j10, 46, j19);
                long j20 = j11 + j16;
                long jM15433rotlXor2 = ThreefishEngine.m15433rotlXor(j16, 36, j20);
                int[] iArr3 = iArr;
                long j21 = j17;
                long j22 = j13 + j21;
                int i4 = i;
                long jM15433rotlXor3 = ThreefishEngine.m15433rotlXor(j21, 19, j22);
                long[] jArr5 = jArr4;
                long[] jArr6 = jArr3;
                long j23 = j18;
                long j24 = j15 + j23;
                long jM15433rotlXor4 = ThreefishEngine.m15433rotlXor(j23, 37, j24);
                long j25 = j20 + jM15433rotlXor;
                long jM15433rotlXor5 = ThreefishEngine.m15433rotlXor(jM15433rotlXor, 33, j25);
                long j26 = j22 + jM15433rotlXor4;
                long jM15433rotlXor6 = ThreefishEngine.m15433rotlXor(jM15433rotlXor4, 27, j26);
                long j27 = j24 + jM15433rotlXor3;
                long jM15433rotlXor7 = ThreefishEngine.m15433rotlXor(jM15433rotlXor3, 14, j27);
                long j28 = j19 + jM15433rotlXor2;
                long jM15433rotlXor8 = ThreefishEngine.m15433rotlXor(jM15433rotlXor2, 42, j28);
                long j29 = j26 + jM15433rotlXor5;
                long jM15433rotlXor9 = ThreefishEngine.m15433rotlXor(jM15433rotlXor5, 17, j29);
                long j30 = j27 + jM15433rotlXor8;
                long jM15433rotlXor10 = ThreefishEngine.m15433rotlXor(jM15433rotlXor8, ROTATION_2_1, j30);
                long j31 = j28 + jM15433rotlXor7;
                long jM15433rotlXor11 = ThreefishEngine.m15433rotlXor(jM15433rotlXor7, 36, j31);
                long j32 = j25 + jM15433rotlXor6;
                long jM15433rotlXor12 = ThreefishEngine.m15433rotlXor(jM15433rotlXor6, 39, j32);
                long j33 = j30 + jM15433rotlXor9;
                long jM15433rotlXor13 = ThreefishEngine.m15433rotlXor(jM15433rotlXor9, 44, j33);
                long j34 = j31 + jM15433rotlXor12;
                long jM15433rotlXor14 = ThreefishEngine.m15433rotlXor(jM15433rotlXor12, 9, j34);
                long j35 = j32 + jM15433rotlXor11;
                long jM15433rotlXor15 = ThreefishEngine.m15433rotlXor(jM15433rotlXor11, 54, j35);
                long j36 = j29 + jM15433rotlXor10;
                long jM15433rotlXor16 = ThreefishEngine.m15433rotlXor(jM15433rotlXor10, 56, j36);
                long j37 = j34 + jArr6[i2];
                int i5 = i2 + 1;
                long j38 = jM15433rotlXor13 + jArr6[i5];
                int i6 = i2 + 2;
                long j39 = j35 + jArr6[i6];
                int i7 = i2 + 3;
                long j40 = jM15433rotlXor16 + jArr6[i7];
                int i8 = i2 + 4;
                long j41 = j36 + jArr6[i8];
                int i9 = i2 + 5;
                long j42 = jM15433rotlXor15 + jArr6[i9] + jArr5[i3];
                int i10 = i2 + 6;
                int i11 = i3 + 1;
                long j43 = j33 + jArr6[i10] + jArr5[i11];
                int i12 = i2 + 7;
                long j44 = i4;
                long j45 = jM15433rotlXor14 + jArr6[i12] + j44;
                long j46 = j37 + j38;
                long jM15433rotlXor17 = ThreefishEngine.m15433rotlXor(j38, 39, j46);
                long j47 = j39 + j40;
                long jM15433rotlXor18 = ThreefishEngine.m15433rotlXor(j40, 30, j47);
                long j48 = j41 + j42;
                long jM15433rotlXor19 = ThreefishEngine.m15433rotlXor(j42, 34, j48);
                long j49 = j43 + j45;
                long jM15433rotlXor20 = ThreefishEngine.m15433rotlXor(j45, 24, j49);
                long j50 = j47 + jM15433rotlXor17;
                long jM15433rotlXor21 = ThreefishEngine.m15433rotlXor(jM15433rotlXor17, 13, j50);
                long j51 = j48 + jM15433rotlXor20;
                long jM15433rotlXor22 = ThreefishEngine.m15433rotlXor(jM15433rotlXor20, 50, j51);
                long j52 = j49 + jM15433rotlXor19;
                long jM15433rotlXor23 = ThreefishEngine.m15433rotlXor(jM15433rotlXor19, 10, j52);
                long j53 = j46 + jM15433rotlXor18;
                long jM15433rotlXor24 = ThreefishEngine.m15433rotlXor(jM15433rotlXor18, 17, j53);
                long j54 = j51 + jM15433rotlXor21;
                long jM15433rotlXor25 = ThreefishEngine.m15433rotlXor(jM15433rotlXor21, 25, j54);
                long j55 = j52 + jM15433rotlXor24;
                long jM15433rotlXor26 = ThreefishEngine.m15433rotlXor(jM15433rotlXor24, 29, j55);
                long j56 = j53 + jM15433rotlXor23;
                long jM15433rotlXor27 = ThreefishEngine.m15433rotlXor(jM15433rotlXor23, 39, j56);
                long j57 = j50 + jM15433rotlXor22;
                long jM15433rotlXor28 = ThreefishEngine.m15433rotlXor(jM15433rotlXor22, 43, j57);
                long j58 = j55 + jM15433rotlXor25;
                long jM15433rotlXor29 = ThreefishEngine.m15433rotlXor(jM15433rotlXor25, 8, j58);
                long j59 = j56 + jM15433rotlXor28;
                long jM15433rotlXor30 = ThreefishEngine.m15433rotlXor(jM15433rotlXor28, 35, j59);
                long j60 = j57 + jM15433rotlXor27;
                long jM15433rotlXor31 = ThreefishEngine.m15433rotlXor(jM15433rotlXor27, 56, j60);
                long j61 = j54 + jM15433rotlXor26;
                long jM15433rotlXor32 = ThreefishEngine.m15433rotlXor(jM15433rotlXor26, 22, j61);
                j9 = j59 + jArr6[i5];
                long j62 = jM15433rotlXor29 + jArr6[i6];
                j11 = j60 + jArr6[i7];
                j16 = jM15433rotlXor32 + jArr6[i8];
                long j63 = j61 + jArr6[i9];
                j17 = jM15433rotlXor31 + jArr6[i10] + jArr5[i11];
                j15 = j58 + jArr6[i12] + jArr5[i3 + 2];
                long j64 = jM15433rotlXor30 + jArr6[i2 + 8] + j44 + 1;
                i = i4 + 2;
                j13 = j63;
                j10 = j62;
                iArr = iArr3;
                iArr2 = iArr2;
                jArr4 = jArr5;
                jArr3 = jArr6;
                j18 = j64;
            }
            jArr2[0] = j9;
            jArr2[1] = j10;
            jArr2[2] = j11;
            jArr2[3] = j16;
            jArr2[4] = j13;
            jArr2[5] = j17;
            jArr2[6] = j15;
            jArr2[7] = j18;
        }
    }

    public static abstract class ThreefishCipher {

        /* renamed from: kw */
        protected final long[] f20120kw;

        /* renamed from: t */
        protected final long[] f20121t;

        public ThreefishCipher(long[] jArr, long[] jArr2) {
            this.f20120kw = jArr;
            this.f20121t = jArr2;
        }

        public abstract void decryptBlock(long[] jArr, long[] jArr2);

        public abstract void encryptBlock(long[] jArr, long[] jArr2);
    }

    static {
        int[] iArr = new int[80];
        f20116MOD9 = iArr;
        f20113MOD17 = new int[iArr.length];
        f20115MOD5 = new int[iArr.length];
        f20114MOD3 = new int[iArr.length];
        int i = 0;
        while (true) {
            int[] iArr2 = f20116MOD9;
            if (i >= iArr2.length) {
                return;
            }
            f20113MOD17[i] = i % 17;
            iArr2[i] = i % 9;
            f20115MOD5[i] = i % 5;
            f20114MOD3[i] = i % 3;
            i++;
        }
    }

    public ThreefishEngine(int i) {
        ThreefishCipher threefish256Cipher;
        long[] jArr = new long[5];
        this.f20119t = jArr;
        int i2 = i / 8;
        this.blocksizeBytes = i2;
        int i3 = i2 / 8;
        this.blocksizeWords = i3;
        this.currentBlock = new long[i3];
        long[] jArr2 = new long[(i3 * 2) + 1];
        this.f20118kw = jArr2;
        if (i == 256) {
            threefish256Cipher = new Threefish256Cipher(jArr2, jArr);
        } else if (i == 512) {
            threefish256Cipher = new Threefish512Cipher(jArr2, jArr);
        } else {
            if (i != 1024) {
                throw new IllegalArgumentException("Invalid blocksize - Threefish is defined with block size of 256, 512, or 1024 bits");
            }
            threefish256Cipher = new Threefish1024Cipher(jArr2, jArr);
        }
        this.f20117cipher = threefish256Cipher;
    }

    public static long bytesToWord(byte[] bArr, int i) {
        return AbstractC6245Pack.littleEndianToLong(bArr, i);
    }

    /* renamed from: rotlXor */
    public static long m15433rotlXor(long j, int i, long j2) {
        return ((j >>> (-i)) | (j << i)) ^ j2;
    }

    /* renamed from: setKey */
    private void m15434setKey(long[] jArr) {
        if (jArr.length != this.blocksizeWords) {
            throw new IllegalArgumentException("Threefish key must be same size as block (" + this.blocksizeWords + " words)");
        }
        long j = f20112C_240;
        int i = 0;
        while (true) {
            int i2 = this.blocksizeWords;
            if (i >= i2) {
                long[] jArr2 = this.f20118kw;
                jArr2[i2] = j;
                System.arraycopy(jArr2, 0, jArr2, i2 + 1, i2);
                return;
            } else {
                long[] jArr3 = this.f20118kw;
                long j2 = jArr[i];
                jArr3[i] = j2;
                j ^= j2;
                i++;
            }
        }
    }

    private void setTweak(long[] jArr) {
        if (jArr.length != 2) {
            throw new IllegalArgumentException("Tweak must be 2 words.");
        }
        long[] jArr2 = this.f20119t;
        long j = jArr[0];
        jArr2[0] = j;
        long j2 = jArr[1];
        jArr2[1] = j2;
        jArr2[2] = j ^ j2;
        jArr2[3] = j;
        jArr2[4] = j2;
    }

    public static void wordToBytes(long j, byte[] bArr, int i) {
        AbstractC6245Pack.longToLittleEndian(j, bArr, i);
    }

    /* renamed from: xorRotr */
    public static long m15435xorRotr(long j, int i, long j2) {
        long j3 = j ^ j2;
        return (j3 << (-i)) | (j3 >>> i);
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public String getAlgorithmName() {
        return "Threefish-" + (this.blocksizeBytes * 8);
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int getBlockSize() {
        return this.blocksizeBytes;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: init */
    public void mo14946init(boolean z, CipherParameters cipherParameters) {
        byte[] bArrM15773getKey;
        byte[] tweak;
        long[] jArr;
        long[] jArr2 = null;
        if (cipherParameters instanceof TweakableBlockCipherParameters) {
            TweakableBlockCipherParameters tweakableBlockCipherParameters = (TweakableBlockCipherParameters) cipherParameters;
            bArrM15773getKey = tweakableBlockCipherParameters.m15831getKey().m15773getKey();
            tweak = tweakableBlockCipherParameters.getTweak();
        } else {
            if (!(cipherParameters instanceof KeyParameter)) {
                throw new IllegalArgumentException("Invalid parameter passed to Threefish init - " + cipherParameters.getClass().getName());
            }
            bArrM15773getKey = ((KeyParameter) cipherParameters).m15773getKey();
            tweak = null;
        }
        if (bArrM15773getKey == null) {
            jArr = null;
        } else {
            if (bArrM15773getKey.length != this.blocksizeBytes) {
                throw new IllegalArgumentException("Threefish key must be same size as block (" + this.blocksizeBytes + " bytes)");
            }
            jArr = new long[this.blocksizeWords];
            AbstractC6245Pack.littleEndianToLong(bArrM15773getKey, 0, jArr);
        }
        if (tweak != null) {
            if (tweak.length != 16) {
                throw new IllegalArgumentException("Threefish tweak must be 16 bytes");
            }
            jArr2 = new long[2];
            AbstractC6245Pack.littleEndianToLong(tweak, 0, jArr2);
        }
        m15436init(z, jArr, jArr2);
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), 256, cipherParameters, C5342Utils.getPurpose(z)));
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = this.blocksizeBytes;
        if (i + i3 > bArr.length) {
            throw new DataLengthException("Input buffer too short");
        }
        if (i3 + i2 > bArr2.length) {
            throw new OutputLengthException("Output buffer too short");
        }
        AbstractC6245Pack.littleEndianToLong(bArr, i, this.currentBlock);
        long[] jArr = this.currentBlock;
        processBlock(jArr, jArr);
        AbstractC6245Pack.longToLittleEndian(this.currentBlock, bArr2, i2);
        return this.blocksizeBytes;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: reset */
    public void mo14947reset() {
    }

    /* renamed from: init */
    public void m15436init(boolean z, long[] jArr, long[] jArr2) {
        this.forEncryption = z;
        if (jArr != null) {
            m15434setKey(jArr);
        }
        if (jArr2 != null) {
            setTweak(jArr2);
        }
    }

    public int processBlock(long[] jArr, long[] jArr2) {
        long[] jArr3 = this.f20118kw;
        int i = this.blocksizeWords;
        if (jArr3[i] == 0) {
            throw new IllegalStateException("Threefish engine not initialised");
        }
        if (jArr.length != i) {
            throw new DataLengthException("Input buffer too short");
        }
        if (jArr2.length != i) {
            throw new OutputLengthException("Output buffer too short");
        }
        if (this.forEncryption) {
            this.f20117cipher.encryptBlock(jArr, jArr2);
        } else {
            this.f20117cipher.decryptBlock(jArr, jArr2);
        }
        return this.blocksizeWords;
    }
}
