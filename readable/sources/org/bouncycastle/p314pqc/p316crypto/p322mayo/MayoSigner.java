package org.bouncycastle.p314pqc.p316crypto.p322mayo;

import java.security.SecureRandom;
import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p314pqc.p316crypto.MessageSigner;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6240Bytes;
import org.bouncycastle.p361util.C6242GF16;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class MayoSigner implements MessageSigner {
    private static final long EVEN_2BYTES = 281470681808895L;
    private static final long EVEN_BYTES = 71777214294589695L;
    private static final int F_TAIL_LEN = 4;

    /* renamed from: params */
    private MayoParameters f23295params;

    /* renamed from: privKey */
    private MayoPrivateKeyParameters f23296privKey;

    /* renamed from: pubKey */
    private MayoPublicKeyParameters f23297pubKey;

    /* renamed from: random */
    private SecureRandom f23298random;

    private static long ctCompare64(int i, int i2) {
        return (-(i ^ i2)) >> 63;
    }

    private static void mVecMultiplyBins(int i, int i2, long[] jArr, long[] jArr2) {
        int i3 = i + i;
        int i4 = i3 + i;
        int i5 = i4 + i;
        int i6 = i5 + i;
        int i7 = i6 + i;
        int i8 = i7 + i;
        int i9 = i8 + i;
        int i10 = i9 + i;
        int i11 = i10 + i;
        int i12 = i11 + i;
        int i13 = i12 + i;
        int i14 = i13 + i;
        int i15 = i14 + i;
        int i16 = i15 + i;
        int i17 = i2;
        int i18 = 0;
        int i19 = 0;
        while (i18 < i17) {
            int i20 = i19;
            int i21 = 0;
            while (i21 < i) {
                long j = jArr[i20 + i6];
                long j2 = j & 1229782938247303441L;
                long j3 = (jArr[i20 + i11] ^ ((j & (-1229782938247303442L)) >>> 1)) ^ ((j2 << 3) + j2);
                long j4 = jArr[i20 + i12];
                long j5 = (j4 & (-8608480567731124088L)) >>> 3;
                long j6 = (jArr[i20 + i13] ^ ((j4 & 8608480567731124087L) << 1)) ^ ((j5 << 1) + j5);
                long j7 = j3 & 1229782938247303441L;
                long j8 = (jArr[i20 + i8] ^ ((j3 & (-1229782938247303442L)) >>> 1)) ^ ((j7 << 3) + j7);
                long j9 = (j6 & (-8608480567731124088L)) >>> 3;
                long j10 = (jArr[i20 + i7] ^ ((j6 & 8608480567731124087L) << 1)) ^ ((j9 << 1) + j9);
                long j11 = j8 & 1229782938247303441L;
                long j12 = (jArr[i20 + i15] ^ ((j8 & (-1229782938247303442L)) >>> 1)) ^ ((j11 << 3) + j11);
                long j13 = (j10 & (-8608480567731124088L)) >>> 3;
                long j14 = (jArr[i20 + i4] ^ ((j10 & 8608480567731124087L) << 1)) ^ ((j13 << 1) + j13);
                long j15 = j12 & 1229782938247303441L;
                long j16 = (jArr[i20 + i16] ^ ((j12 & (-1229782938247303442L)) >>> 1)) ^ ((j15 << 3) + j15);
                long j17 = (j14 & (-8608480567731124088L)) >>> 3;
                long j18 = (jArr[i20 + i9] ^ ((j14 & 8608480567731124087L) << 1)) ^ ((j17 << 1) + j17);
                long j19 = j16 & 1229782938247303441L;
                long j20 = (jArr[i20 + i14] ^ ((j16 & (-1229782938247303442L)) >>> 1)) ^ ((j19 << 3) + j19);
                long j21 = (j18 & (-8608480567731124088L)) >>> 3;
                long j22 = (jArr[i20 + i5] ^ ((j18 & 8608480567731124087L) << 1)) ^ ((j21 << 1) + j21);
                long j23 = j20 & 1229782938247303441L;
                long j24 = (jArr[i20 + i10] ^ ((j20 & (-1229782938247303442L)) >>> 1)) ^ ((j23 << 3) + j23);
                long j25 = (j22 & (-8608480567731124088L)) >>> 3;
                long j26 = (jArr[i20 + i3] ^ ((j22 & 8608480567731124087L) << 1)) ^ ((j25 << 1) + j25);
                long j27 = j24 & 1229782938247303441L;
                long j28 = (jArr[i20 + i] ^ ((j24 & (-1229782938247303442L)) >>> 1)) ^ ((j27 << 3) + j27);
                long j29 = (j26 & (-8608480567731124088L)) >>> 3;
                jArr2[(i19 >> 4) + i21] = (j28 ^ ((j26 & 8608480567731124087L) << 1)) ^ ((j29 << 1) + j29);
                i21++;
                i20++;
            }
            i18++;
            i19 += i << 4;
            i17 = i2;
        }
    }

    private static void mayoGenericMCalculatePS(MayoParameters mayoParameters, long[] jArr, int i, int i2, byte[] bArr, int i3, int i4, int i5, long[] jArr2) {
        int i6 = i3;
        int i7 = i4;
        int i8 = i7 + i6;
        int mVecLimbs = mayoParameters.getMVecLimbs();
        long[] jArr3 = new long[(((mayoParameters.m17667getK() * mVecLimbs) * mayoParameters.m17669getN()) * mVecLimbs) << 4];
        int i9 = i7 * mVecLimbs;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i10 < i6) {
            for (int i14 = i10; i14 < i6; i14++) {
                int i15 = 0;
                int i16 = 0;
                while (i15 < i5) {
                    AbstractC5869Nat.m16951xorTo64(mVecLimbs, jArr, i12, jArr3, (((i13 + i15) << 4) + (bArr[i16 + i14] & 255)) * mVecLimbs);
                    i15++;
                    i16 += i8;
                }
                i12 += mVecLimbs;
            }
            int i17 = i11;
            int i18 = 0;
            while (i18 < i7) {
                int i19 = 0;
                int i20 = 0;
                while (i19 < i5) {
                    AbstractC5869Nat.m16951xorTo64(mVecLimbs, jArr, i + i17, jArr3, (((i13 + i19) << 4) + (bArr[i20 + i18 + i6] & 255)) * mVecLimbs);
                    i19++;
                    i20 += i8;
                    i12 = i12;
                }
                i18++;
                i17 += mVecLimbs;
                i7 = i4;
            }
            i10++;
            i13 += i5;
            i11 += i9;
            i7 = i4;
        }
        int i21 = i6 * i5;
        int i22 = 0;
        while (i6 < i8) {
            for (int i23 = i6; i23 < i8; i23++) {
                int i24 = 0;
                int i25 = 0;
                while (i24 < i5) {
                    AbstractC5869Nat.m16951xorTo64(mVecLimbs, jArr, i2 + i22, jArr3, (((i21 + i24) << 4) + (bArr[i25 + i23] & 255)) * mVecLimbs);
                    i24++;
                    i25 += i8;
                }
                i22 += mVecLimbs;
            }
            i6++;
            i21 += i5;
        }
        mVecMultiplyBins(mVecLimbs, i8 * i5, jArr3, jArr2);
    }

    private static void mayoGenericMCalculateSPS(long[] jArr, byte[] bArr, int i, int i2, int i3, long[] jArr2) {
        int i4 = i2;
        int i5 = i4 * i4;
        long[] jArr3 = new long[(i * i5) << 4];
        int i6 = i4 * i;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < i4) {
            int i10 = 0;
            int i11 = 0;
            while (i10 < i3) {
                int i12 = ((bArr[i8 + i10] & 255) * i) + i9;
                int i13 = 0;
                int i14 = 0;
                while (i13 < i4) {
                    AbstractC5869Nat.m16951xorTo64(i, jArr, i11 + i14, jArr3, i12 + (i14 << 4));
                    i13++;
                    i14 += i;
                    i4 = i2;
                }
                i10++;
                i11 += i6;
                i4 = i2;
            }
            i7++;
            i8 += i3;
            i9 += i6 << 4;
            i4 = i2;
        }
        mVecMultiplyBins(i, i5, jArr3, jArr2);
    }

    private static int mulTable(int i) {
        int i2 = i * 134480385;
        int i3 = (-252645136) & i2;
        return (i2 ^ (i3 >>> 4)) ^ (i3 >>> 3);
    }

    private static void transpose16x16Nibbles(long[] jArr, int i) {
        for (int i2 = 0; i2 < 16; i2 += 2) {
            int i3 = i + i2;
            int i4 = i3 + 1;
            long j = jArr[i3];
            long j2 = ((j >>> 4) ^ jArr[i4]) & 1085102592571150095L;
            jArr[i3] = j ^ (j2 << 4);
            jArr[i4] = jArr[i4] ^ j2;
        }
        int i5 = i;
        for (int i6 = 0; i6 < 16; i6 += 4) {
            long j3 = jArr[i5];
            long j4 = ((j3 >>> 8) ^ jArr[i5 + 2]) & EVEN_BYTES;
            int i7 = i5 + 1;
            long j5 = EVEN_BYTES & ((jArr[i7] >>> 8) ^ jArr[i5 + 3]);
            jArr[i5] = j3 ^ (j4 << 8);
            int i8 = i5 + 2;
            jArr[i7] = jArr[i7] ^ (j5 << 8);
            int i9 = i5 + 3;
            jArr[i8] = jArr[i8] ^ j4;
            i5 += 4;
            jArr[i9] = jArr[i9] ^ j5;
        }
        for (int i10 = 0; i10 < 4; i10++) {
            int i11 = i + i10;
            long j6 = jArr[i11];
            int i12 = i11 + 4;
            long j7 = ((j6 >>> 16) ^ jArr[i12]) & EVEN_2BYTES;
            int i13 = i11 + 8;
            int i14 = i11 + 12;
            long j8 = EVEN_2BYTES & ((jArr[i13] >>> 16) ^ jArr[i14]);
            jArr[i11] = j6 ^ (j7 << 16);
            jArr[i13] = jArr[i13] ^ (j8 << 16);
            jArr[i12] = jArr[i12] ^ j7;
            jArr[i14] = jArr[i14] ^ j8;
        }
        for (int i15 = 0; i15 < 8; i15++) {
            int i16 = i + i15;
            long j9 = jArr[i16];
            int i17 = i16 + 8;
            long j10 = ((j9 >>> 32) ^ jArr[i17]) & BodyPartID.bodyIdMax;
            jArr[i16] = j9 ^ (j10 << 32);
            jArr[i17] = jArr[i17] ^ j10;
        }
    }

    private static void vecMulAddU64(int i, long[] jArr, byte b, long[] jArr2) {
        int iMulTable = mulTable(b & C1126UByte.MAX_VALUE);
        for (int i2 = 0; i2 < i; i2++) {
            long j = jArr[i2];
            jArr2[i2] = ((((j >>> 3) & 1229782938247303441L) * ((iMulTable >>> 24) & 15)) ^ ((((j & 1229782938247303441L) * (iMulTable & 255)) ^ (((j >>> 1) & 1229782938247303441L) * ((iMulTable >>> 8) & 15))) ^ (((j >>> 2) & 1229782938247303441L) * ((iMulTable >>> 16) & 15)))) ^ jArr2[i2];
        }
    }

    public void computeA(long[] jArr, byte[] bArr) {
        int i;
        int i2;
        char c;
        int iM17667getK = this.f23295params.m17667getK();
        int iM17671getO = this.f23295params.m17671getO();
        int iM17668getM = this.f23295params.m17668getM();
        int mVecLimbs = this.f23295params.getMVecLimbs();
        int aCols = this.f23295params.getACols();
        int[] fTail = this.f23295params.getFTail();
        int i3 = iM17671getO * iM17667getK;
        int i4 = iM17671getO * mVecLimbs;
        int i5 = ((i3 + 15) >> 4) << 4;
        long[] jArr2 = new long[(((iM17668getM + 7) >>> 3) * i5) << 4];
        int i6 = iM17668getM & 15;
        if (i6 != 0) {
            long j = (1 << (i6 << 2)) - 1;
            int i7 = mVecLimbs - 1;
            int i8 = 0;
            while (i8 < i3) {
                jArr[i7] = jArr[i7] & j;
                i8++;
                i7 += mVecLimbs;
            }
        }
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i9 < iM17667getK) {
            int i14 = iM17667getK - 1;
            int i15 = i14 * i4;
            int i16 = i14 * iM17671getO;
            int i17 = i14;
            while (i17 >= i9) {
                int i18 = 0;
                int i19 = 0;
                while (i18 < iM17671getO) {
                    int i20 = 0;
                    int i21 = 0;
                    while (i20 < mVecLimbs) {
                        long j2 = jArr[i15 + i20 + i19];
                        int i22 = i10 + i18 + i13 + i21;
                        jArr2[i22] = jArr2[i22] ^ (j2 << i12);
                        if (i12 > 0) {
                            int i23 = i22 + i5;
                            jArr2[i23] = jArr2[i23] ^ (j2 >>> (64 - i12));
                        }
                        i20++;
                        i21 += i5;
                    }
                    i18++;
                    i19 += mVecLimbs;
                }
                if (i9 != i17) {
                    int i24 = 0;
                    int i25 = 0;
                    while (i24 < iM17671getO) {
                        int i26 = 0;
                        int i27 = 0;
                        while (i26 < mVecLimbs) {
                            long j3 = jArr[i11 + i26 + i25];
                            int i28 = i16 + i24 + i13 + i27;
                            jArr2[i28] = jArr2[i28] ^ (j3 << i12);
                            if (i12 > 0) {
                                int i29 = i28 + i5;
                                jArr2[i29] = jArr2[i29] ^ (j3 >>> (64 - i12));
                            }
                            i26++;
                            i27 += i5;
                        }
                        i24++;
                        i25 += mVecLimbs;
                    }
                }
                int i30 = i12 + 4;
                if (i30 == 64) {
                    i13 += i5;
                    i12 = 0;
                } else {
                    i12 = i30;
                }
                i17--;
                i15 -= i4;
                i16 -= iM17671getO;
            }
            i9++;
            i10 += iM17671getO;
            i11 += i4;
        }
        int i31 = 0;
        while (true) {
            i = (iM17667getK + 1) * iM17667getK;
            i2 = 4;
            if (i31 >= ((((i >> 1) + iM17668getM) + 15) >>> 4) * i5) {
                break;
            }
            transpose16x16Nibbles(jArr2, i31);
            i31 += 16;
        }
        byte[] bArr2 = new byte[16];
        int i32 = 0;
        int i33 = 0;
        while (true) {
            c = 1;
            if (i32 >= i2) {
                break;
            }
            int i34 = fTail[i32];
            bArr2[i33] = (byte) C6242GF16.m18292mul(i34, 1);
            bArr2[i33 + 1] = (byte) C6242GF16.m18292mul(i34, 2);
            int i35 = i33 + 3;
            bArr2[i33 + 2] = (byte) C6242GF16.m18292mul(i34, 4);
            i33 += 4;
            bArr2[i35] = (byte) C6242GF16.m18292mul(i34, 8);
            i32++;
            i2 = 4;
        }
        int i36 = 0;
        while (i36 < i5) {
            int i37 = iM17668getM;
            while (i37 < (i >>> 1) + iM17668getM) {
                long j4 = jArr2[((i37 >>> 4) * i5) + i36 + (i37 & 15)];
                long j5 = j4 & 1229782938247303441L;
                long j6 = (j4 >>> c) & 1229782938247303441L;
                long j7 = (j4 >>> 2) & 1229782938247303441L;
                long j8 = (j4 >>> 3) & 1229782938247303441L;
                int i38 = 4;
                int i39 = 0;
                int i40 = 0;
                while (i39 < i38) {
                    int i41 = (i37 + i39) - iM17668getM;
                    int i42 = ((i41 >> 4) * i5) + i36 + (i41 & 15);
                    jArr2[i42] = jArr2[i42] ^ ((((bArr2[i40] * j5) ^ (bArr2[i40 + 1] * j6)) ^ (bArr2[i40 + 2] * j7)) ^ (bArr2[i40 + 3] * j8));
                    i39++;
                    i40 += 4;
                    i38 = 4;
                    j5 = j5;
                }
                i37++;
                c = 1;
            }
            i36 += 16;
            c = 1;
        }
        byte[] bArrLongToLittleEndian = AbstractC6245Pack.longToLittleEndian(jArr2);
        for (int i43 = 0; i43 < iM17668getM; i43 += 16) {
            int i44 = 0;
            while (true) {
                int i45 = aCols - 1;
                if (i44 < i45) {
                    int i46 = 0;
                    while (true) {
                        int i47 = i46 + i43;
                        if (i47 < iM17668getM) {
                            C6242GF16.m18285decode(bArrLongToLittleEndian, ((((i43 * i5) >> 4) + i44) + i46) << 3, bArr, (i47 * aCols) + i44, Math.min(16, i45 - i44));
                            i46++;
                        }
                    }
                    i44 += 16;
                }
            }
        }
    }

    public void computeRHS(long[] jArr, byte[] bArr, byte[] bArr2) {
        int i;
        int iM17668getM = this.f23295params.m17668getM();
        int mVecLimbs = this.f23295params.getMVecLimbs();
        int iM17667getK = this.f23295params.m17667getK();
        int[] fTail = this.f23295params.getFTail();
        int i2 = ((iM17668getM - 1) & 15) << 2;
        int i3 = iM17668getM & 15;
        if (i3 != 0) {
            long j = (1 << (i3 << 2)) - 1;
            int i4 = iM17667getK * iM17667getK;
            int i5 = mVecLimbs - 1;
            int i6 = 0;
            while (i6 < i4) {
                jArr[i5] = jArr[i5] & j;
                i6++;
                i5 += mVecLimbs;
            }
        }
        long[] jArr2 = new long[mVecLimbs];
        byte[] bArr3 = new byte[mVecLimbs << 3];
        int i7 = iM17667getK * mVecLimbs;
        int i8 = iM17667getK - 1;
        int i9 = i8 * mVecLimbs;
        int i10 = i9 * iM17667getK;
        while (true) {
            char c = 4;
            if (i8 < 0) {
                break;
            }
            int i11 = i8;
            int i12 = i9;
            int i13 = i10;
            while (i11 < iM17667getK) {
                int i14 = mVecLimbs - 1;
                long j2 = jArr2[i14];
                byte[] bArr4 = bArr3;
                int i15 = (int) ((j2 >>> i2) & 15);
                jArr2[i14] = j2 << c;
                for (int i16 = mVecLimbs - 2; i16 >= 0; i16--) {
                    int i17 = i16 + 1;
                    jArr2[i17] = jArr2[i17] ^ (jArr2[i16] >>> 60);
                    jArr2[i16] = jArr2[i16] << c;
                }
                AbstractC6245Pack.longToLittleEndian(jArr2, bArr4, 0);
                int i18 = iM17667getK;
                int i19 = 0;
                for (int i20 = 4; i19 < i20; i20 = 4) {
                    int i21 = fTail[i19];
                    if (i21 == 0) {
                        i = i2;
                    } else {
                        i = i2;
                        long jM18292mul = C6242GF16.m18292mul(i15, i21);
                        if ((i19 & 1) == 0) {
                            int i22 = i19 >> 1;
                            bArr4[i22] = (byte) (bArr4[i22] ^ ((byte) (jM18292mul & 15)));
                        } else {
                            int i23 = i19 >> 1;
                            bArr4[i23] = (byte) (bArr4[i23] ^ ((byte) ((jM18292mul & 15) << 4)));
                        }
                    }
                    i19++;
                    i2 = i;
                }
                int i24 = i2;
                AbstractC6245Pack.littleEndianToLong(bArr4, 0, jArr2);
                int i25 = i10 + i12;
                int i26 = i13 + i9;
                boolean z = i8 == i11;
                for (int i27 = 0; i27 < mVecLimbs; i27++) {
                    long j3 = jArr[i25 + i27];
                    if (!z) {
                        j3 ^= jArr[i26 + i27];
                    }
                    jArr2[i27] = jArr2[i27] ^ j3;
                }
                i11++;
                i12 += mVecLimbs;
                i13 += i7;
                bArr3 = bArr4;
                iM17667getK = i18;
                i2 = i24;
                c = 4;
            }
            i8--;
            i9 -= mVecLimbs;
            i10 -= i7;
        }
        byte[] bArr5 = bArr3;
        AbstractC6245Pack.longToLittleEndian(jArr2, bArr5, 0);
        for (int i28 = 0; i28 < iM17668getM; i28 += 2) {
            int i29 = i28 >> 1;
            bArr2[i28] = (byte) (bArr[i28] ^ (bArr5[i29] & 15));
            int i30 = i28 + 1;
            bArr2[i30] = (byte) (((bArr5[i29] >>> 4) & 15) ^ bArr[i30]);
        }
    }

    /* renamed from: ef */
    public void m17674ef(byte[] bArr, int i, int i2) {
        byte[] bArr2 = bArr;
        int i3 = i;
        int i4 = i2;
        int i5 = (i4 + 15) >> 4;
        long[] jArr = new long[i5];
        long[] jArr2 = new long[i5];
        long[] jArr3 = new long[i3 * i5];
        int i6 = 16;
        int iM17671getO = (this.f23295params.m17671getO() * this.f23295params.m17667getK()) + 16;
        byte[] bArr3 = new byte[iM17671getO >> 1];
        int i7 = iM17671getO >> 4;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i8 < i3) {
            int i11 = 0;
            while (i11 < i5) {
                long j = 0;
                int i12 = 0;
                while (i12 < i6) {
                    if ((i11 << 4) + i12 < i4) {
                        j |= (bArr2[r15 + i9] & 15) << (i12 << 2);
                    }
                    i12++;
                    bArr2 = bArr;
                    i6 = 16;
                }
                jArr3[i11 + i10] = j;
                i11++;
                bArr2 = bArr;
                i6 = 16;
            }
            i8++;
            i9 += i4;
            i10 += i5;
            bArr2 = bArr;
            i6 = 16;
        }
        int i13 = 0;
        int i14 = 0;
        while (i13 < i4) {
            int iMax = Math.max(0, (i13 + i3) - i4);
            int i15 = i3 - 1;
            int iMin = Math.min(i15, i13);
            C6238Arrays.m18230clear(jArr);
            C6238Arrays.m18230clear(jArr2);
            int iMin2 = Math.min(i15, iMin + 32);
            int i16 = iMax * i5;
            int i17 = i7;
            int i18 = i16;
            byte[] bArr4 = bArr3;
            long j2 = -1;
            int i19 = 0;
            while (iMax <= iMin2) {
                int i20 = i16;
                long j3 = ~ctCompare64(iMax, i14);
                int i21 = iMin2;
                int i22 = iMin;
                long j4 = (i14 - iMax) >> 63;
                for (int i23 = 0; i23 < i5; i23++) {
                    jArr[i23] = jArr[i23] ^ ((j3 | (j4 & j2)) & jArr3[i18 + i23]);
                }
                i19 = (int) ((jArr[i13 >>> 4] >>> ((i13 & 15) << 2)) & 15);
                j2 = ~((-i19) >> 63);
                iMax++;
                i18 += i5;
                i16 = i20;
                iMin = i22;
                iMin2 = i21;
            }
            int i24 = iMin;
            int i25 = i16;
            vecMulAddU64(i5, jArr, C6242GF16.m18289inv((byte) i19), jArr2);
            int i26 = iMax;
            int i27 = i25;
            while (true) {
                int i28 = i24;
                if (i26 > i28) {
                    break;
                }
                int i29 = i19;
                long j5 = (~ctCompare64(i26, i14)) & (~j2);
                long j6 = ~j5;
                i24 = i28;
                int i30 = i27;
                int i31 = 0;
                while (i31 < i5) {
                    jArr3[i30] = (j6 & jArr3[i30]) | (j5 & jArr2[i31]);
                    i31++;
                    i30++;
                }
                i26++;
                i27 += i5;
                i19 = i29;
            }
            int i32 = i19;
            i3 = i;
            int i33 = iMax;
            int i34 = i25;
            while (i33 < i3) {
                vecMulAddU64(i5, jArr2, (byte) (((int) ((jArr3[(i13 >>> 4) + i34] >>> ((i13 & 15) << 2)) & 15)) & (i33 > i14 ? -1 : 0)), jArr3, i34);
                i33++;
                i34 += i5;
            }
            if (i32 != 0) {
                i14++;
            }
            i13++;
            i4 = i2;
            bArr3 = bArr4;
            i7 = i17;
        }
        int i35 = i7;
        byte[] bArr5 = bArr3;
        int i36 = 0;
        int i37 = 0;
        int i38 = 0;
        while (i38 < i3) {
            AbstractC6245Pack.longToLittleEndian(jArr3, i36, i35, bArr5, 0);
            C6242GF16.m18285decode(bArr5, 0, bArr, i37, i2);
            i37 += i2;
            i38++;
            i36 += i5;
        }
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    public byte[] generateSignature(byte[] bArr) throws Throwable {
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        byte[] bArr5;
        byte[] bArr6;
        byte[] bArr7;
        byte[] bArr8;
        byte[] bArr9;
        byte[] bArr10;
        byte b;
        byte[] bArr11;
        byte[] bArr12;
        int i;
        byte[] bArr13;
        byte[] bArr14;
        int i2;
        int i3;
        byte[] bArr15;
        int i4;
        byte[] bArr16;
        byte[] bArr17;
        byte[] bArr18;
        byte[] bArr19;
        int i5;
        int i6;
        int i7;
        int i8;
        SHAKEDigest sHAKEDigest;
        long[] jArr;
        int i9;
        long[] jArr2;
        long[] jArr3;
        long[] jArr4;
        int i10;
        int i11;
        int iM17667getK = this.f23295params.m17667getK();
        int iM17672getV = this.f23295params.m17672getV();
        int iM17671getO = this.f23295params.m17671getO();
        int iM17669getN = this.f23295params.m17669getN();
        int iM17668getM = this.f23295params.m17668getM();
        int vBytes = this.f23295params.getVBytes();
        int oBytes = this.f23295params.getOBytes();
        int saltBytes = this.f23295params.getSaltBytes();
        int mVecLimbs = this.f23295params.getMVecLimbs();
        int p1Limbs = this.f23295params.getP1Limbs();
        int pkSeedBytes = this.f23295params.getPkSeedBytes();
        int digestBytes = this.f23295params.getDigestBytes();
        int skSeedBytes = this.f23295params.getSkSeedBytes();
        byte[] bArr20 = new byte[this.f23295params.getMBytes()];
        byte[] bArr21 = new byte[iM17668getM];
        byte[] bArr22 = new byte[iM17668getM];
        byte[] bArr23 = new byte[saltBytes];
        int i12 = iM17667getK * vBytes;
        int rBytes = this.f23295params.getRBytes() + i12;
        int i13 = i12;
        byte[] bArr24 = new byte[rBytes];
        int i14 = iM17672getV * iM17667getK;
        int i15 = rBytes;
        byte[] bArr25 = new byte[i14];
        int i16 = iM17667getK * iM17671getO;
        int i17 = iM17667getK * iM17669getN;
        int i18 = i16 + 1;
        byte[] bArr26 = new byte[((iM17668getM + 7) / 8) * 8 * i18];
        byte[] bArr27 = new byte[i18];
        byte[] bArr28 = new byte[i17];
        int i19 = digestBytes + saltBytes;
        byte[] bArr29 = new byte[i17];
        int i20 = i19 + skSeedBytes;
        int i21 = i17;
        int i22 = i20 + 1;
        byte[] bArr30 = bArr20;
        byte[] bArr31 = new byte[i22];
        int i23 = i22;
        int sigBytes = this.f23295params.getSigBytes();
        byte[] bArr32 = new byte[sigBytes];
        int i24 = sigBytes;
        long[] jArr5 = new long[p1Limbs + this.f23295params.getP2Limbs()];
        int i25 = iM17672getV * iM17671getO;
        byte[] bArr33 = new byte[i25];
        long[] jArr6 = new long[i16 * mVecLimbs];
        int i26 = i16;
        long[] jArr7 = new long[iM17667getK * iM17667getK * mVecLimbs];
        SHAKEDigest sHAKEDigest2 = new SHAKEDigest(256);
        try {
            byte[] seedSk = this.f23296privKey.getSeedSk();
            int i27 = oBytes + pkSeedBytes;
            i = iM17667getK;
            bArr13 = new byte[i27];
            try {
                sHAKEDigest2.mo14970update(seedSk, 0, seedSk.length);
                sHAKEDigest2.mo14998doFinal(bArr13, 0, i27);
                C6242GF16.m18285decode(bArr13, pkSeedBytes, bArr33, 0, i25);
                try {
                    C6071Utils.expandP1P2(this.f23295params, jArr5, bArr13);
                    int i28 = iM17671getO * mVecLimbs;
                    int i29 = 0;
                    int i30 = 0;
                    int i31 = 0;
                    int i32 = 0;
                    while (i29 < iM17672getV) {
                        byte[] bArr34 = seedSk;
                        int i33 = i30;
                        int i34 = i31;
                        int i35 = i29;
                        while (i35 < iM17672getV) {
                            if (i35 == i29) {
                                i32 += mVecLimbs;
                                i11 = iM17672getV;
                            } else {
                                i11 = iM17672getV;
                                int i36 = p1Limbs;
                                int i37 = 0;
                                while (i37 < iM17671getO) {
                                    GF16Utils.mVecMulAdd(mVecLimbs, jArr5, i32, bArr33[i33 + i37], jArr5, i31 + i36);
                                    GF16Utils.mVecMulAdd(mVecLimbs, jArr5, i32, bArr33[i30 + i37], jArr5, i34 + i36);
                                    i37++;
                                    i36 += mVecLimbs;
                                }
                                i32 += mVecLimbs;
                            }
                            i35++;
                            i33 += iM17671getO;
                            i34 += i28;
                            iM17672getV = i11;
                        }
                        i29++;
                        i30 += iM17671getO;
                        i31 += i28;
                        seedSk = bArr34;
                    }
                    bArr14 = seedSk;
                    i2 = iM17672getV;
                } catch (Throwable th) {
                    th = th;
                    bArr3 = bArr31;
                    bArr4 = bArr22;
                    bArr5 = bArr21;
                    bArr6 = bArr24;
                    bArr7 = bArr25;
                    bArr8 = bArr26;
                    bArr10 = bArr27;
                    bArr9 = bArr28;
                    bArr11 = bArr29;
                    bArr12 = bArr30;
                    bArr2 = bArr23;
                }
            } catch (Throwable th2) {
                th = th2;
                b = 0;
            }
        } catch (Throwable th3) {
            th = th3;
            bArr2 = bArr23;
            bArr3 = bArr31;
            bArr4 = bArr22;
            bArr5 = bArr21;
            bArr6 = bArr24;
            bArr7 = bArr25;
        }
        try {
            C6238Arrays.m18249fill(bArr13, (byte) 0);
            sHAKEDigest2.mo14970update(bArr, 0, bArr.length);
            sHAKEDigest2.mo14998doFinal(bArr31, 0, digestBytes);
            byte[] bArr35 = bArr23;
            try {
                this.f23298random.nextBytes(bArr35);
                int i38 = saltBytes;
                System.arraycopy(bArr35, 0, bArr31, digestBytes, i38);
                System.arraycopy(bArr14, 0, bArr31, i19, skSeedBytes);
                int i39 = i20;
                sHAKEDigest2.mo14970update(bArr31, 0, i39);
                sHAKEDigest2.mo14998doFinal(bArr35, 0, i38);
                System.arraycopy(bArr35, 0, bArr31, digestBytes, i38);
                sHAKEDigest2.mo14970update(bArr31, 0, i19);
                byte[] bArr36 = bArr30;
                try {
                    sHAKEDigest2.mo14998doFinal(bArr36, 0, this.f23295params.getMBytes());
                    byte[] bArr37 = bArr21;
                    try {
                        C6242GF16.m18286decode(bArr36, bArr37, iM17668getM);
                        long[] jArr8 = new long[i14 * mVecLimbs];
                        int i40 = i2;
                        byte[] bArr38 = new byte[i40];
                        int i41 = 0;
                        while (true) {
                            if (i41 > 255) {
                                i3 = i38;
                                bArr15 = bArr38;
                                i4 = i40;
                                bArr16 = bArr35;
                                bArr17 = bArr31;
                                bArr18 = bArr36;
                                bArr5 = bArr37;
                                bArr4 = bArr22;
                                bArr6 = bArr24;
                                bArr7 = bArr25;
                                bArr8 = bArr26;
                                bArr10 = bArr27;
                                bArr19 = bArr28;
                                i5 = i21;
                                i6 = i24;
                                i7 = i;
                                break;
                            }
                            try {
                                bArr31[i39] = (byte) i41;
                                int i42 = i39;
                                int i43 = i23;
                                int i44 = 0;
                                sHAKEDigest2.mo14970update(bArr31, 0, i43);
                                byte[] bArr39 = bArr31;
                                byte[] bArr40 = bArr24;
                                int i45 = i15;
                                try {
                                    sHAKEDigest2.mo14998doFinal(bArr40, 0, i45);
                                    i15 = i45;
                                    i7 = i;
                                    while (i44 < i7) {
                                        int i46 = i41;
                                        byte[] bArr41 = bArr38;
                                        bArr30 = bArr36;
                                        bArr7 = bArr25;
                                        try {
                                            C6242GF16.m18285decode(bArr40, i44 * vBytes, bArr7, i44 * i40, i40);
                                            i44++;
                                            bArr25 = bArr7;
                                            i41 = i46;
                                            bArr38 = bArr41;
                                            bArr36 = bArr30;
                                        } catch (Throwable th4) {
                                            th = th4;
                                            bArr2 = bArr35;
                                            bArr6 = bArr40;
                                            bArr5 = bArr37;
                                            bArr3 = bArr39;
                                            bArr4 = bArr22;
                                            bArr8 = bArr26;
                                            bArr10 = bArr27;
                                            bArr9 = bArr28;
                                            bArr11 = bArr29;
                                            bArr12 = bArr30;
                                            b = 0;
                                            C6238Arrays.m18249fill(bArr12, b);
                                            C6238Arrays.m18249fill(bArr5, b);
                                            C6238Arrays.m18249fill(bArr4, b);
                                            C6238Arrays.m18249fill(bArr2, b);
                                            C6238Arrays.m18249fill(bArr6, b);
                                            C6238Arrays.m18249fill(bArr7, b);
                                            C6238Arrays.m18249fill(bArr8, b);
                                            C6238Arrays.m18249fill(bArr9, b);
                                            C6238Arrays.m18249fill(bArr10, b);
                                            C6238Arrays.m18249fill(bArr11, b);
                                            C6238Arrays.m18249fill(bArr3, b);
                                            throw th;
                                        }
                                    }
                                    i8 = i41;
                                    byte[] bArr42 = bArr36;
                                    bArr7 = bArr25;
                                    sHAKEDigest = sHAKEDigest2;
                                    byte[] bArr43 = bArr37;
                                    bArr15 = bArr38;
                                    bArr8 = bArr26;
                                    i4 = i40;
                                    jArr = jArr8;
                                    bArr16 = bArr35;
                                    bArr4 = bArr22;
                                    i3 = i38;
                                    bArr28 = bArr28;
                                    i9 = i13;
                                    i5 = i21;
                                    jArr2 = jArr5;
                                    bArr6 = bArr40;
                                    i6 = i24;
                                    bArr17 = bArr39;
                                    bArr18 = bArr42;
                                    bArr5 = bArr43;
                                    try {
                                        GF16Utils.mulAddMatXMMat(mVecLimbs, bArr7, jArr5, p1Limbs, jArr6, i7, i4, iM17671getO);
                                        GF16Utils.mulAddMUpperTriangularMatXMatTrans(mVecLimbs, jArr2, bArr7, jArr, i4, i7);
                                        GF16Utils.mulAddMatXMMat(mVecLimbs, bArr7, jArr, jArr7, i7, i4);
                                        jArr3 = jArr7;
                                        computeRHS(jArr3, bArr5, bArr4);
                                        jArr4 = jArr6;
                                        computeA(jArr4, bArr8);
                                        bArr10 = bArr27;
                                        i10 = i26;
                                        try {
                                            C6242GF16.m18285decode(bArr6, i9, bArr10, 0, i10);
                                            bArr19 = bArr28;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            bArr19 = bArr28;
                                            bArr9 = bArr19;
                                            bArr11 = bArr29;
                                            bArr2 = bArr16;
                                            bArr12 = bArr18;
                                            bArr3 = bArr17;
                                            b = 0;
                                            C6238Arrays.m18249fill(bArr12, b);
                                            C6238Arrays.m18249fill(bArr5, b);
                                            C6238Arrays.m18249fill(bArr4, b);
                                            C6238Arrays.m18249fill(bArr2, b);
                                            C6238Arrays.m18249fill(bArr6, b);
                                            C6238Arrays.m18249fill(bArr7, b);
                                            C6238Arrays.m18249fill(bArr8, b);
                                            C6238Arrays.m18249fill(bArr9, b);
                                            C6238Arrays.m18249fill(bArr10, b);
                                            C6238Arrays.m18249fill(bArr11, b);
                                            C6238Arrays.m18249fill(bArr3, b);
                                            throw th;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        bArr10 = bArr27;
                                        bArr19 = bArr28;
                                        bArr9 = bArr19;
                                        bArr11 = bArr29;
                                        bArr2 = bArr16;
                                        bArr12 = bArr18;
                                        bArr3 = bArr17;
                                        b = 0;
                                        C6238Arrays.m18249fill(bArr12, b);
                                        C6238Arrays.m18249fill(bArr5, b);
                                        C6238Arrays.m18249fill(bArr4, b);
                                        C6238Arrays.m18249fill(bArr2, b);
                                        C6238Arrays.m18249fill(bArr6, b);
                                        C6238Arrays.m18249fill(bArr7, b);
                                        C6238Arrays.m18249fill(bArr8, b);
                                        C6238Arrays.m18249fill(bArr9, b);
                                        C6238Arrays.m18249fill(bArr10, b);
                                        C6238Arrays.m18249fill(bArr11, b);
                                        C6238Arrays.m18249fill(bArr3, b);
                                        throw th;
                                    }
                                } catch (Throwable th7) {
                                    th = th7;
                                    bArr16 = bArr35;
                                    bArr6 = bArr40;
                                    bArr18 = bArr36;
                                    bArr5 = bArr37;
                                    bArr17 = bArr39;
                                    bArr4 = bArr22;
                                    bArr7 = bArr25;
                                    bArr8 = bArr26;
                                    bArr10 = bArr27;
                                    bArr19 = bArr28;
                                    bArr9 = bArr19;
                                    bArr11 = bArr29;
                                    bArr2 = bArr16;
                                    bArr12 = bArr18;
                                    bArr3 = bArr17;
                                    b = 0;
                                    C6238Arrays.m18249fill(bArr12, b);
                                    C6238Arrays.m18249fill(bArr5, b);
                                    C6238Arrays.m18249fill(bArr4, b);
                                    C6238Arrays.m18249fill(bArr2, b);
                                    C6238Arrays.m18249fill(bArr6, b);
                                    C6238Arrays.m18249fill(bArr7, b);
                                    C6238Arrays.m18249fill(bArr8, b);
                                    C6238Arrays.m18249fill(bArr9, b);
                                    C6238Arrays.m18249fill(bArr10, b);
                                    C6238Arrays.m18249fill(bArr11, b);
                                    C6238Arrays.m18249fill(bArr3, b);
                                    throw th;
                                }
                                try {
                                    if (sampleSolution(bArr8, bArr4, bArr10, bArr19)) {
                                        break;
                                    }
                                    C6238Arrays.m18256fill(jArr4, 0L);
                                    C6238Arrays.m18256fill(jArr3, 0L);
                                    jArr7 = jArr3;
                                    jArr6 = jArr4;
                                    i26 = i10;
                                    i41 = i8 + 1;
                                    bArr28 = bArr19;
                                    bArr27 = bArr10;
                                    i = i7;
                                    bArr25 = bArr7;
                                    bArr24 = bArr6;
                                    bArr26 = bArr8;
                                    i40 = i4;
                                    jArr8 = jArr;
                                    sHAKEDigest2 = sHAKEDigest;
                                    i23 = i43;
                                    i24 = i6;
                                    jArr5 = jArr2;
                                    i39 = i42;
                                    bArr35 = bArr16;
                                    i21 = i5;
                                    bArr36 = bArr18;
                                    bArr31 = bArr17;
                                    bArr22 = bArr4;
                                    bArr37 = bArr5;
                                    i13 = i9;
                                    bArr38 = bArr15;
                                    i38 = i3;
                                } catch (Throwable th8) {
                                    th = th8;
                                    bArr9 = bArr19;
                                    bArr11 = bArr29;
                                    bArr2 = bArr16;
                                    bArr12 = bArr18;
                                    bArr3 = bArr17;
                                    b = 0;
                                    C6238Arrays.m18249fill(bArr12, b);
                                    C6238Arrays.m18249fill(bArr5, b);
                                    C6238Arrays.m18249fill(bArr4, b);
                                    C6238Arrays.m18249fill(bArr2, b);
                                    C6238Arrays.m18249fill(bArr6, b);
                                    C6238Arrays.m18249fill(bArr7, b);
                                    C6238Arrays.m18249fill(bArr8, b);
                                    C6238Arrays.m18249fill(bArr9, b);
                                    C6238Arrays.m18249fill(bArr10, b);
                                    C6238Arrays.m18249fill(bArr11, b);
                                    C6238Arrays.m18249fill(bArr3, b);
                                    throw th;
                                }
                            } catch (Throwable th9) {
                                th = th9;
                                bArr16 = bArr35;
                                bArr17 = bArr31;
                                bArr18 = bArr36;
                                bArr5 = bArr37;
                                bArr4 = bArr22;
                                bArr6 = bArr24;
                            }
                        }
                        int i47 = 0;
                        int i48 = 0;
                        int i49 = 0;
                        int i50 = 0;
                        while (i47 < i7) {
                            int i51 = i7;
                            bArr9 = bArr19;
                            try {
                                GF16Utils.m17665matMul(bArr33, bArr19, i48, bArr15, iM17671getO, i4);
                                C6240Bytes.m18275xor(i4, bArr7, i49, bArr15, bArr29, i50);
                                bArr11 = bArr29;
                            } catch (Throwable th10) {
                                th = th10;
                                bArr11 = bArr29;
                                bArr2 = bArr16;
                                bArr12 = bArr18;
                                bArr3 = bArr17;
                                b = 0;
                                C6238Arrays.m18249fill(bArr12, b);
                                C6238Arrays.m18249fill(bArr5, b);
                                C6238Arrays.m18249fill(bArr4, b);
                                C6238Arrays.m18249fill(bArr2, b);
                                C6238Arrays.m18249fill(bArr6, b);
                                C6238Arrays.m18249fill(bArr7, b);
                                C6238Arrays.m18249fill(bArr8, b);
                                C6238Arrays.m18249fill(bArr9, b);
                                C6238Arrays.m18249fill(bArr10, b);
                                C6238Arrays.m18249fill(bArr11, b);
                                C6238Arrays.m18249fill(bArr3, b);
                                throw th;
                            }
                            try {
                                System.arraycopy(bArr9, i48, bArr11, i50 + i4, iM17671getO);
                                i47++;
                                i48 += iM17671getO;
                                i50 += iM17669getN;
                                i49 += i4;
                                bArr29 = bArr11;
                                bArr19 = bArr9;
                                i7 = i51;
                            } catch (Throwable th11) {
                                th = th11;
                                bArr2 = bArr16;
                                bArr12 = bArr18;
                                bArr3 = bArr17;
                                b = 0;
                                C6238Arrays.m18249fill(bArr12, b);
                                C6238Arrays.m18249fill(bArr5, b);
                                C6238Arrays.m18249fill(bArr4, b);
                                C6238Arrays.m18249fill(bArr2, b);
                                C6238Arrays.m18249fill(bArr6, b);
                                C6238Arrays.m18249fill(bArr7, b);
                                C6238Arrays.m18249fill(bArr8, b);
                                C6238Arrays.m18249fill(bArr9, b);
                                C6238Arrays.m18249fill(bArr10, b);
                                C6238Arrays.m18249fill(bArr11, b);
                                C6238Arrays.m18249fill(bArr3, b);
                                throw th;
                            }
                        }
                        bArr9 = bArr19;
                        bArr11 = bArr29;
                        C6242GF16.m18287encode(bArr11, bArr32, i5);
                        bArr2 = bArr16;
                        b = 0;
                        try {
                            System.arraycopy(bArr2, 0, bArr32, i6 - i3, i3);
                            byte[] bArrConcatenate = C6238Arrays.concatenate(bArr32, bArr);
                            C6238Arrays.m18249fill(bArr18, (byte) 0);
                            C6238Arrays.m18249fill(bArr5, (byte) 0);
                            C6238Arrays.m18249fill(bArr4, (byte) 0);
                            C6238Arrays.m18249fill(bArr2, (byte) 0);
                            C6238Arrays.m18249fill(bArr6, (byte) 0);
                            C6238Arrays.m18249fill(bArr7, (byte) 0);
                            C6238Arrays.m18249fill(bArr8, (byte) 0);
                            C6238Arrays.m18249fill(bArr9, (byte) 0);
                            C6238Arrays.m18249fill(bArr10, (byte) 0);
                            C6238Arrays.m18249fill(bArr11, (byte) 0);
                            C6238Arrays.m18249fill(bArr17, (byte) 0);
                            return bArrConcatenate;
                        } catch (Throwable th12) {
                            th = th12;
                            bArr12 = bArr18;
                            bArr3 = bArr17;
                            C6238Arrays.m18249fill(bArr12, b);
                            C6238Arrays.m18249fill(bArr5, b);
                            C6238Arrays.m18249fill(bArr4, b);
                            C6238Arrays.m18249fill(bArr2, b);
                            C6238Arrays.m18249fill(bArr6, b);
                            C6238Arrays.m18249fill(bArr7, b);
                            C6238Arrays.m18249fill(bArr8, b);
                            C6238Arrays.m18249fill(bArr9, b);
                            C6238Arrays.m18249fill(bArr10, b);
                            C6238Arrays.m18249fill(bArr11, b);
                            C6238Arrays.m18249fill(bArr3, b);
                            throw th;
                        }
                    } catch (Throwable th13) {
                        th = th13;
                        bArr2 = bArr35;
                        bArr3 = bArr31;
                        bArr12 = bArr36;
                        bArr5 = bArr37;
                        bArr4 = bArr22;
                        bArr6 = bArr24;
                        bArr7 = bArr25;
                        bArr8 = bArr26;
                        bArr10 = bArr27;
                        bArr9 = bArr28;
                        bArr11 = bArr29;
                    }
                } catch (Throwable th14) {
                    th = th14;
                    b = 0;
                    bArr2 = bArr35;
                    bArr3 = bArr31;
                    bArr12 = bArr36;
                    bArr4 = bArr22;
                    bArr5 = bArr21;
                    bArr6 = bArr24;
                    bArr7 = bArr25;
                    bArr8 = bArr26;
                    bArr10 = bArr27;
                    bArr9 = bArr28;
                    bArr11 = bArr29;
                }
            } catch (Throwable th15) {
                th = th15;
                b = 0;
                bArr2 = bArr35;
                bArr3 = bArr31;
                bArr4 = bArr22;
                bArr5 = bArr21;
                bArr6 = bArr24;
                bArr7 = bArr25;
                bArr8 = bArr26;
                bArr10 = bArr27;
                bArr9 = bArr28;
                bArr11 = bArr29;
                bArr12 = bArr30;
            }
        } catch (Throwable th16) {
            th = th16;
            b = 0;
            bArr3 = bArr31;
            bArr4 = bArr22;
            bArr5 = bArr21;
            bArr6 = bArr24;
            bArr7 = bArr25;
            bArr8 = bArr26;
            bArr10 = bArr27;
            bArr9 = bArr28;
            bArr11 = bArr29;
            bArr12 = bArr30;
            bArr2 = bArr23;
            C6238Arrays.m18249fill(bArr12, b);
            C6238Arrays.m18249fill(bArr5, b);
            C6238Arrays.m18249fill(bArr4, b);
            C6238Arrays.m18249fill(bArr2, b);
            C6238Arrays.m18249fill(bArr6, b);
            C6238Arrays.m18249fill(bArr7, b);
            C6238Arrays.m18249fill(bArr8, b);
            C6238Arrays.m18249fill(bArr9, b);
            C6238Arrays.m18249fill(bArr10, b);
            C6238Arrays.m18249fill(bArr11, b);
            C6238Arrays.m18249fill(bArr3, b);
            throw th;
        }
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    /* renamed from: init */
    public void mo15864init(boolean z, CipherParameters cipherParameters) {
        SecureRandom secureRandom;
        if (!z) {
            MayoPublicKeyParameters mayoPublicKeyParameters = (MayoPublicKeyParameters) cipherParameters;
            this.f23297pubKey = mayoPublicKeyParameters;
            this.f23295params = mayoPublicKeyParameters.getParameters();
            this.f23296privKey = null;
            this.f23298random = null;
            return;
        }
        this.f23297pubKey = null;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f23296privKey = (MayoPrivateKeyParameters) parametersWithRandom.getParameters();
            secureRandom = parametersWithRandom.getRandom();
        } else {
            this.f23296privKey = (MayoPrivateKeyParameters) cipherParameters;
            secureRandom = CryptoServicesRegistrar.getSecureRandom();
        }
        this.f23298random = secureRandom;
        this.f23295params = this.f23296privKey.getParameters();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean sampleSolution(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        int i;
        int i2;
        int i3;
        byte[] bArr5 = bArr4;
        int iM17667getK = this.f23295params.m17667getK();
        int iM17671getO = this.f23295params.m17671getO();
        int iM17668getM = this.f23295params.m17668getM();
        int aCols = this.f23295params.getACols();
        int i4 = iM17667getK * iM17671getO;
        byte b = 0;
        System.arraycopy(bArr3, 0, bArr5, 0, i4);
        byte[] bArr6 = new byte[iM17668getM];
        int i5 = i4 + 1;
        GF16Utils.m17665matMul(bArr, bArr3, 0, bArr6, i5, iM17668getM);
        int i6 = i4;
        int i7 = 0;
        while (i7 < iM17668getM) {
            bArr[i6] = (byte) (bArr2[i7] ^ bArr6[i7]);
            i7++;
            i6 += i5;
        }
        m17674ef(bArr, iM17668getM, aCols);
        int i8 = iM17668getM - 1;
        int i9 = i8 * aCols;
        int i10 = i9;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            i = aCols - 1;
            i2 = 1;
            if (i11 >= i) {
                break;
            }
            if (bArr[i10] == 0) {
                i2 = 0;
            }
            i12 |= i2;
            i11++;
            i10++;
        }
        if (i12 == 0) {
            return false;
        }
        while (i8 >= 0) {
            int iMin = Math.min((32 / (iM17668getM - i8)) + i8, i4);
            int i13 = i8;
            byte b2 = b;
            while (i13 <= iMin) {
                byte b3 = (byte) ((-(bArr[i9 + i13] & C1126UByte.MAX_VALUE)) >> 31);
                byte b4 = (byte) ((~b2) & b3 & bArr[(i9 + aCols) - i2]);
                bArr5[i13] = (byte) (bArr5[i13] ^ b4);
                int i14 = i13;
                int i15 = i;
                int i16 = b;
                while (i16 < i8) {
                    int i17 = iMin;
                    int i18 = b;
                    byte b5 = b3;
                    long j = 0;
                    int i19 = i18;
                    while (true) {
                        if (i18 >= 8) {
                            break;
                        }
                        j ^= (bArr[i14 + i19] & C1126UByte.MAX_VALUE) << (i18 << 3);
                        i18++;
                        i19 += aCols;
                        iM17668getM = iM17668getM;
                    }
                    int i20 = iM17668getM;
                    long jM17666mulFx8 = GF16Utils.m17666mulFx8(b4, j);
                    int i21 = 0;
                    int i22 = 0;
                    for (i3 = 8; i21 < i3; i3 = 8) {
                        int i23 = i15 + i22;
                        bArr[i23] = (byte) (bArr[i23] ^ ((byte) ((jM17666mulFx8 >> (i21 << 3)) & 15)));
                        i21++;
                        i22 += aCols;
                        i13 = i13;
                    }
                    i16 += 8;
                    int i24 = aCols << 3;
                    i14 += i24;
                    i15 += i24;
                    b3 = b5;
                    iMin = i17;
                    iM17668getM = i20;
                    b = 0;
                }
                b2 = (byte) (b2 | b3);
                i13++;
                iMin = iMin;
                bArr5 = bArr4;
                i2 = 1;
                b = 0;
            }
            i8--;
            i9 -= aCols;
            bArr5 = bArr4;
            i2 = 1;
            b = 0;
        }
        return i2;
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        int iM17668getM = this.f23295params.m17668getM();
        int iM17669getN = this.f23295params.m17669getN();
        int iM17667getK = this.f23295params.m17667getK();
        int i = iM17667getK * iM17669getN;
        int p1Limbs = this.f23295params.getP1Limbs();
        int p2Limbs = this.f23295params.getP2Limbs();
        int p3Limbs = this.f23295params.getP3Limbs();
        int mBytes = this.f23295params.getMBytes();
        int sigBytes = this.f23295params.getSigBytes();
        int digestBytes = this.f23295params.getDigestBytes();
        int saltBytes = this.f23295params.getSaltBytes();
        int mVecLimbs = this.f23295params.getMVecLimbs();
        byte[] bArr3 = new byte[mBytes];
        byte[] bArr4 = new byte[iM17668getM];
        byte[] bArr5 = new byte[iM17668getM << 1];
        byte[] bArr6 = new byte[i];
        int i2 = p1Limbs + p2Limbs;
        long[] jArr = new long[i2 + p3Limbs];
        byte[] bArr7 = new byte[digestBytes + saltBytes];
        byte[] encoded = this.f23297pubKey.getEncoded();
        C6071Utils.expandP1P2(this.f23295params, jArr, encoded);
        C6071Utils.unpackMVecs(encoded, this.f23295params.getPkSeedBytes(), jArr, i2, p3Limbs / mVecLimbs, iM17668getM);
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        sHAKEDigest.mo14970update(bArr, 0, bArr.length);
        sHAKEDigest.mo14998doFinal(bArr7, 0, digestBytes);
        sHAKEDigest.mo14970update(bArr7, 0, digestBytes);
        sHAKEDigest.mo14970update(bArr2, sigBytes - saltBytes, saltBytes);
        sHAKEDigest.mo14998doFinal(bArr3, 0, mBytes);
        C6242GF16.m18286decode(bArr3, bArr4, iM17668getM);
        C6242GF16.m18286decode(bArr2, bArr6, i);
        long[] jArr2 = new long[iM17667getK * iM17667getK * mVecLimbs];
        long[] jArr3 = new long[i * mVecLimbs];
        MayoParameters mayoParameters = this.f23295params;
        mayoGenericMCalculatePS(mayoParameters, jArr, p1Limbs, i2, bArr6, mayoParameters.m17672getV(), this.f23295params.m17671getO(), iM17667getK, jArr3);
        mayoGenericMCalculateSPS(jArr3, bArr6, mVecLimbs, iM17667getK, iM17669getN, jArr2);
        computeRHS(jArr2, new byte[iM17668getM], bArr5);
        return C6238Arrays.constantTimeAreEqual(iM17668getM, bArr5, 0, bArr4, 0);
    }

    private static void vecMulAddU64(int i, long[] jArr, byte b, long[] jArr2, int i2) {
        int iMulTable = mulTable(b & C1126UByte.MAX_VALUE);
        for (int i3 = 0; i3 < i; i3++) {
            long j = jArr[i3];
            int i4 = i2 + i3;
            jArr2[i4] = ((((j >>> 3) & 1229782938247303441L) * ((iMulTable >>> 24) & 15)) ^ ((((j & 1229782938247303441L) * (iMulTable & 255)) ^ (((j >>> 1) & 1229782938247303441L) * ((iMulTable >>> 8) & 15))) ^ (((j >>> 2) & 1229782938247303441L) * ((iMulTable >>> 16) & 15)))) ^ jArr2[i4];
        }
    }
}
