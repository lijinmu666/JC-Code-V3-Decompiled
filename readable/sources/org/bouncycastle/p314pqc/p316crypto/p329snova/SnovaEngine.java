package org.bouncycastle.p314pqc.p316crypto.p329snova;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p194crypto.p201engines.AESEngine;
import org.bouncycastle.p194crypto.p210modes.CTRModeCipher;
import org.bouncycastle.p194crypto.p210modes.SICBlockCipher;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6242GF16;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
class SnovaEngine {
    private static final Map<Integer, byte[]> fixedAbqSet = new HashMap();

    /* renamed from: sSet */
    private static final Map<Integer, byte[][]> f23538sSet = new HashMap();

    /* renamed from: xSSet */
    private static final Map<Integer, int[][]> f23539xSSet = new HashMap();

    /* renamed from: S */
    final byte[][] f23540S;

    /* renamed from: alpha */
    private final int f23541alpha;

    /* renamed from: l */
    private final int f23542l;

    /* renamed from: lsq */
    private final int f23543lsq;

    /* renamed from: m */
    private final int f23544m;

    /* renamed from: n */
    private final int f23545n;

    /* renamed from: o */
    private final int f23546o;

    /* renamed from: params */
    private final SnovaParameters f23547params;

    /* renamed from: v */
    private final int f23548v;

    /* renamed from: xS */
    final int[][] f23549xS;

    public SnovaEngine(SnovaParameters snovaParameters) {
        int i;
        this.f23547params = snovaParameters;
        int iM17864getL = snovaParameters.m17864getL();
        this.f23542l = iM17864getL;
        int iM17865getLsq = snovaParameters.m17865getLsq();
        this.f23543lsq = iM17865getLsq;
        this.f23544m = snovaParameters.m17866getM();
        this.f23548v = snovaParameters.m17870getV();
        this.f23546o = snovaParameters.m17869getO();
        this.f23541alpha = snovaParameters.getAlpha();
        this.f23545n = snovaParameters.m17867getN();
        int i2 = 0;
        if (!f23539xSSet.containsKey(Integers.m18296valueOf(iM17864getL))) {
            int i3 = 2;
            byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, iM17864getL, iM17865getLsq);
            int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, iM17864getL, iM17865getLsq);
            m17855be_aI(bArr[0], 0, (byte) 1);
            m17854beTheS(bArr[1]);
            while (true) {
                int i4 = this.f23542l;
                if (i3 >= i4) {
                    break;
                }
                GF16Utils.gf16mMul(bArr[i3 - 1], bArr[1], bArr[i3], i4);
                i3++;
            }
            int i5 = 0;
            while (true) {
                i = this.f23542l;
                if (i5 >= i) {
                    break;
                }
                for (int i6 = 0; i6 < this.f23543lsq; i6++) {
                    iArr[i5][i6] = GF16Utils.gf16FromNibble(bArr[i5][i6]);
                }
                i5++;
            }
            f23538sSet.put(Integers.m18296valueOf(i), bArr);
            f23539xSSet.put(Integers.m18296valueOf(this.f23542l), iArr);
        }
        this.f23540S = f23538sSet.get(Integers.m18296valueOf(this.f23542l));
        this.f23549xS = f23539xSSet.get(Integers.m18296valueOf(this.f23542l));
        if (this.f23542l >= 4 || fixedAbqSet.containsKey(Integers.m18296valueOf(this.f23546o))) {
            return;
        }
        int i7 = this.f23541alpha;
        int i8 = this.f23542l;
        int i9 = i7 * i8;
        int i10 = i8 * i9;
        int i11 = this.f23546o;
        int i12 = i11 * i9;
        int i13 = i11 * i10;
        byte[] bArr2 = new byte[i13 << 2];
        int i14 = i13 + i12;
        byte[] bArr3 = new byte[i14];
        byte[] bArr4 = new byte[i12 << 2];
        byte[] bytes = "SNOVA_ABQ".getBytes();
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        sHAKEDigest.mo14970update(bytes, 0, bytes.length);
        sHAKEDigest.mo14998doFinal(bArr3, 0, i14);
        int i15 = i13 << 1;
        C6242GF16.m18286decode(bArr3, bArr2, i15);
        C6242GF16.m18285decode(bArr3, i10, bArr4, 0, i12 << 1);
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (true) {
            int i19 = this.f23546o;
            if (i16 >= i19) {
                fixedAbqSet.put(Integers.m18296valueOf(i19), bArr2);
                return;
            }
            int i20 = i2;
            int i21 = i17;
            int i22 = i18;
            while (i20 < this.f23541alpha) {
                makeInvertibleByAddingAS(bArr2, i22);
                makeInvertibleByAddingAS(bArr2, i13 + i22);
                m17856genAFqS(bArr4, i21, bArr2, i15 + i22);
                m17856genAFqS(bArr4, i12 + i21, bArr2, i15 + i13 + i22);
                i20++;
                i21 += this.f23542l;
                i22 += this.f23543lsq;
            }
            i16++;
            i18 += i10;
            i17 += i9;
            i2 = 0;
        }
    }

    /* renamed from: beTheS */
    private void m17854beTheS(byte[] bArr) {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i = this.f23542l;
            if (i3 >= i) {
                break;
            }
            int i5 = 0;
            while (true) {
                i2 = this.f23542l;
                if (i5 < i2) {
                    bArr[i4 + i5] = (byte) ((8 - (i3 + i5)) & 15);
                    i5++;
                }
            }
            i3++;
            i4 += i2;
        }
        if (i == 5) {
            bArr[24] = 9;
        }
    }

    /* renamed from: be_aI */
    private void m17855be_aI(byte[] bArr, int i, byte b) {
        int i2 = this.f23542l + 1;
        int i3 = 0;
        while (i3 < this.f23542l) {
            bArr[i] = b;
            i3++;
            i += i2;
        }
    }

    private static void copy4DMatrix(byte[][][][] bArr, byte[][][][] bArr2, int i, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < i; i5++) {
            for (int i6 = 0; i6 < i2; i6++) {
                for (int i7 = 0; i7 < i3; i7++) {
                    System.arraycopy(bArr[i5][i6][i7], 0, bArr2[i5][i6][i7], 0, i4);
                }
            }
        }
    }

    private byte determinant2x2(byte[] bArr, int i) {
        return (byte) (C6242GF16.m18291mul(bArr[i], bArr[i + 3]) ^ C6242GF16.m18291mul(bArr[i + 1], bArr[i + 2]));
    }

    private byte determinant3x3(byte[] bArr, int i) {
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        byte b3 = bArr[i + 2];
        byte b4 = bArr[i + 3];
        byte b5 = bArr[i + 4];
        byte b6 = bArr[i + 5];
        byte b7 = bArr[i + 6];
        byte b8 = bArr[i + 7];
        byte b9 = bArr[i + 8];
        return (byte) ((C6242GF16.m18292mul(b2, C6242GF16.m18291mul(b4, b9) ^ C6242GF16.m18291mul(b6, b7)) ^ C6242GF16.m18292mul(b, C6242GF16.m18291mul(b5, b9) ^ C6242GF16.m18291mul(b6, b8))) ^ C6242GF16.m18292mul(b3, C6242GF16.m18291mul(b4, b8) ^ C6242GF16.m18291mul(b5, b7)));
    }

    private byte determinant4x4(byte[] bArr, int i) {
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        byte b3 = bArr[i + 2];
        byte b4 = bArr[i + 3];
        byte b5 = bArr[i + 4];
        byte b6 = bArr[i + 5];
        byte b7 = bArr[i + 6];
        byte b8 = bArr[i + 7];
        byte b9 = bArr[i + 8];
        byte b10 = bArr[i + 9];
        byte b11 = bArr[i + 10];
        byte b12 = bArr[i + 11];
        byte b13 = bArr[i + 12];
        byte b14 = bArr[i + 13];
        byte b15 = bArr[i + 14];
        byte b16 = bArr[i + 15];
        byte bM18291mul = (byte) (C6242GF16.m18291mul(b11, b16) ^ C6242GF16.m18291mul(b12, b15));
        byte bM18291mul2 = (byte) (C6242GF16.m18291mul(b10, b16) ^ C6242GF16.m18291mul(b12, b14));
        byte bM18291mul3 = (byte) (C6242GF16.m18291mul(b10, b15) ^ C6242GF16.m18291mul(b11, b14));
        byte bM18291mul4 = (byte) (C6242GF16.m18291mul(b12, b13) ^ C6242GF16.m18291mul(b9, b16));
        byte bM18291mul5 = (byte) (C6242GF16.m18291mul(b11, b13) ^ C6242GF16.m18291mul(b9, b15));
        byte bM18291mul6 = (byte) (C6242GF16.m18291mul(b9, b14) ^ C6242GF16.m18291mul(b10, b13));
        return (byte) (C6242GF16.m18292mul(b4, (C6242GF16.m18291mul(b5, bM18291mul3) ^ C6242GF16.m18291mul(b6, bM18291mul5)) ^ C6242GF16.m18291mul(b7, bM18291mul6)) ^ ((C6242GF16.m18292mul(b, (C6242GF16.m18291mul(b6, bM18291mul) ^ C6242GF16.m18291mul(b7, bM18291mul2)) ^ C6242GF16.m18291mul(b8, bM18291mul3)) ^ C6242GF16.m18292mul(b2, (C6242GF16.m18291mul(b5, bM18291mul) ^ C6242GF16.m18291mul(b7, bM18291mul4)) ^ C6242GF16.m18291mul(b8, bM18291mul5))) ^ C6242GF16.m18292mul(b3, (C6242GF16.m18291mul(b5, bM18291mul2) ^ C6242GF16.m18291mul(b6, bM18291mul4)) ^ C6242GF16.m18291mul(b8, bM18291mul6))));
    }

    private byte determinant5x5(byte[] bArr, int i) {
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        byte b3 = bArr[i + 2];
        byte b4 = bArr[i + 3];
        byte b5 = bArr[i + 4];
        byte b6 = bArr[i + 5];
        byte b7 = bArr[i + 6];
        byte b8 = bArr[i + 7];
        byte b9 = bArr[i + 8];
        byte b10 = bArr[i + 9];
        byte b11 = bArr[i + 10];
        byte b12 = bArr[i + 11];
        byte b13 = bArr[i + 12];
        byte b14 = bArr[i + 13];
        byte b15 = bArr[i + 14];
        byte b16 = bArr[i + 15];
        byte b17 = bArr[i + 16];
        byte b18 = bArr[i + 17];
        byte b19 = bArr[i + 18];
        byte b20 = bArr[i + 19];
        byte b21 = bArr[i + 20];
        byte b22 = bArr[i + 21];
        byte b23 = bArr[i + 22];
        byte b24 = bArr[i + 23];
        byte b25 = bArr[i + 24];
        byte bM18291mul = (byte) (C6242GF16.m18291mul(b6, b12) ^ C6242GF16.m18291mul(b7, b11));
        byte bM18291mul2 = (byte) (C6242GF16.m18291mul(b6, b13) ^ C6242GF16.m18291mul(b8, b11));
        byte bM18291mul3 = (byte) (C6242GF16.m18291mul(b6, b14) ^ C6242GF16.m18291mul(b9, b11));
        byte bM18291mul4 = (byte) (C6242GF16.m18291mul(b6, b15) ^ C6242GF16.m18291mul(b10, b11));
        byte bM18291mul5 = (byte) (C6242GF16.m18291mul(b7, b13) ^ C6242GF16.m18291mul(b8, b12));
        byte bM18291mul6 = (byte) (C6242GF16.m18291mul(b7, b14) ^ C6242GF16.m18291mul(b9, b12));
        byte bM18291mul7 = (byte) (C6242GF16.m18291mul(b7, b15) ^ C6242GF16.m18291mul(b10, b12));
        byte bM18291mul8 = (byte) (C6242GF16.m18291mul(b8, b14) ^ C6242GF16.m18291mul(b9, b13));
        byte bM18291mul9 = (byte) (C6242GF16.m18291mul(b8, b15) ^ C6242GF16.m18291mul(b10, b13));
        byte bM18291mul10 = (byte) (C6242GF16.m18291mul(b9, b15) ^ C6242GF16.m18291mul(b10, b14));
        return (byte) (((byte) (((byte) (((byte) (((byte) (((byte) (((byte) (C6242GF16.m18292mul((C6242GF16.m18291mul(b, bM18291mul8) ^ C6242GF16.m18291mul(b3, bM18291mul3)) ^ C6242GF16.m18291mul(b4, bM18291mul2), C6242GF16.m18291mul(b17, b25) ^ C6242GF16.m18291mul(b20, b22)) ^ ((byte) (((byte) (((byte) C6242GF16.m18292mul((C6242GF16.m18291mul(b, bM18291mul5) ^ C6242GF16.m18291mul(b2, bM18291mul2)) ^ C6242GF16.m18291mul(b3, bM18291mul), C6242GF16.m18291mul(b19, b25) ^ C6242GF16.m18291mul(b20, b24))) ^ C6242GF16.m18292mul((C6242GF16.m18291mul(b, bM18291mul6) ^ C6242GF16.m18291mul(b2, bM18291mul3)) ^ C6242GF16.m18291mul(b4, bM18291mul), C6242GF16.m18291mul(b18, b25) ^ C6242GF16.m18291mul(b20, b23)))) ^ C6242GF16.m18292mul((C6242GF16.m18291mul(b, bM18291mul7) ^ C6242GF16.m18291mul(b2, bM18291mul4)) ^ C6242GF16.m18291mul(b5, bM18291mul), C6242GF16.m18291mul(b18, b24) ^ C6242GF16.m18291mul(b19, b23)))))) ^ C6242GF16.m18292mul(C6242GF16.m18291mul(b5, bM18291mul2) ^ (C6242GF16.m18291mul(b, bM18291mul9) ^ C6242GF16.m18291mul(b3, bM18291mul4)), C6242GF16.m18291mul(b17, b24) ^ C6242GF16.m18291mul(b19, b22)))) ^ C6242GF16.m18292mul((C6242GF16.m18291mul(b, bM18291mul10) ^ C6242GF16.m18291mul(b4, bM18291mul4)) ^ C6242GF16.m18291mul(b5, bM18291mul3), C6242GF16.m18291mul(b17, b23) ^ C6242GF16.m18291mul(b18, b22)))) ^ C6242GF16.m18292mul((C6242GF16.m18291mul(b2, bM18291mul8) ^ C6242GF16.m18291mul(b3, bM18291mul6)) ^ C6242GF16.m18291mul(b4, bM18291mul5), C6242GF16.m18291mul(b16, b25) ^ C6242GF16.m18291mul(b20, b21)))) ^ C6242GF16.m18292mul((C6242GF16.m18291mul(b2, bM18291mul9) ^ C6242GF16.m18291mul(b3, bM18291mul7)) ^ C6242GF16.m18291mul(b5, bM18291mul5), C6242GF16.m18291mul(b16, b24) ^ C6242GF16.m18291mul(b19, b21)))) ^ C6242GF16.m18292mul((C6242GF16.m18291mul(b2, bM18291mul10) ^ C6242GF16.m18291mul(b4, bM18291mul7)) ^ C6242GF16.m18291mul(b5, bM18291mul6), C6242GF16.m18291mul(b16, b23) ^ C6242GF16.m18291mul(b18, b21)))) ^ C6242GF16.m18292mul((C6242GF16.m18291mul(b3, bM18291mul10) ^ C6242GF16.m18291mul(b4, bM18291mul9)) ^ C6242GF16.m18291mul(b5, bM18291mul8), C6242GF16.m18291mul(b16, b22) ^ C6242GF16.m18291mul(b17, b21)));
    }

    /* renamed from: genAFqS */
    private void m17856genAFqS(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3;
        int i4;
        m17855be_aI(bArr2, i2, bArr[i]);
        int i5 = 1;
        while (true) {
            i3 = this.f23542l;
            if (i5 >= i3 - 1) {
                break;
            }
            gf16mScaleTo(this.f23540S[i5], bArr[i + i5], bArr2, i2);
            i5++;
        }
        if (bArr[(i + i3) - 1] != 0) {
            i4 = bArr[(i + i3) - 1];
        } else {
            int i6 = bArr[i];
            i4 = 16 - (i6 + (i6 == 0 ? 1 : 0));
        }
        gf16mScaleTo(this.f23540S[i3 - 1], (byte) i4, bArr2, i2);
    }

    private void genAFqSCT(byte[] bArr, int i, byte[] bArr2) {
        int i2;
        int[] iArr = new int[this.f23543lsq];
        int i3 = this.f23542l + 1;
        int iGf16FromNibble = GF16Utils.gf16FromNibble(bArr[i]);
        int i4 = 0;
        int i5 = 0;
        while (i4 < this.f23542l) {
            iArr[i5] = iGf16FromNibble;
            i4++;
            i5 += i3;
        }
        int i6 = 1;
        while (true) {
            i2 = this.f23542l;
            if (i6 >= i2 - 1) {
                break;
            }
            int iGf16FromNibble2 = GF16Utils.gf16FromNibble(bArr[i + i6]);
            for (int i7 = 0; i7 < this.f23543lsq; i7++) {
                iArr[i7] = iArr[i7] ^ (this.f23549xS[i6][i7] * iGf16FromNibble2);
            }
            i6++;
        }
        int iCtGF16IsNotZero = GF16Utils.ctGF16IsNotZero(bArr[(i2 + i) - 1]);
        int iGf16FromNibble3 = GF16Utils.gf16FromNibble((byte) ((bArr[(this.f23542l + i) - 1] * iCtGF16IsNotZero) + ((1 - iCtGF16IsNotZero) * ((GF16Utils.ctGF16IsNotZero(bArr[i]) + 15) - bArr[i]))));
        for (int i8 = 0; i8 < this.f23543lsq; i8++) {
            int i9 = iArr[i8] ^ (this.f23549xS[this.f23542l - 1][i8] * iGf16FromNibble3);
            iArr[i8] = i9;
            bArr2[i8] = GF16Utils.gf16ToNibble(i9);
        }
        C6238Arrays.m18253fill(iArr, 0);
    }

    /* renamed from: genF */
    private void m17857genF(MapGroup2 mapGroup2, MapGroup1 mapGroup1, byte[][][] bArr) {
        byte[][][][] bArr2 = mapGroup1.f23530p11;
        byte[][][][] bArr3 = mapGroup2.f23535f11;
        int i = this.f23544m;
        int i2 = this.f23548v;
        copy4DMatrix(bArr2, bArr3, i, i2, i2, this.f23543lsq);
        copy4DMatrix(mapGroup1.f23531p12, mapGroup2.f23536f12, this.f23544m, this.f23548v, this.f23546o, this.f23543lsq);
        copy4DMatrix(mapGroup1.f23532p21, mapGroup2.f23537f21, this.f23544m, this.f23546o, this.f23548v, this.f23543lsq);
        for (int i3 = 0; i3 < this.f23544m; i3++) {
            for (int i4 = 0; i4 < this.f23548v; i4++) {
                for (int i5 = 0; i5 < this.f23546o; i5++) {
                    for (int i6 = 0; i6 < this.f23548v; i6++) {
                        byte[][][] bArr4 = mapGroup1.f23530p11[i3];
                        GF16Utils.gf16mMulToTo(bArr4[i4][i6], bArr[i6][i5], bArr4[i6][i4], mapGroup2.f23536f12[i3][i4][i5], mapGroup2.f23537f21[i3][i5][i4], this.f23542l);
                    }
                }
            }
        }
    }

    private void genSeedsAndT12(byte[][][] bArr, byte[] bArr2) {
        int i = this.f23548v * this.f23546o * this.f23542l;
        int i2 = (i + 1) >>> 1;
        byte[] bArr3 = new byte[i2];
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        sHAKEDigest.mo14970update(bArr2, 0, bArr2.length);
        sHAKEDigest.mo14998doFinal(bArr3, 0, i2);
        byte[] bArr4 = new byte[i];
        C6242GF16.m18286decode(bArr3, bArr4, i);
        int i3 = 0;
        for (int i4 = 0; i4 < this.f23548v; i4++) {
            for (int i5 = 0; i5 < this.f23546o; i5++) {
                genAFqSCT(bArr4, i3, bArr[i4][i5]);
                i3 += this.f23542l;
            }
        }
    }

    private void generateASMatrixTo(byte[] bArr, int i, byte b) {
        int i2;
        int i3 = 0;
        while (i3 < this.f23542l) {
            int i4 = 0;
            while (true) {
                i2 = this.f23542l;
                if (i4 < i2) {
                    byte b2 = (byte) (8 - (i3 + i4));
                    if (i2 == 5 && i3 == 4 && i4 == 4) {
                        b2 = 9;
                    }
                    int i5 = i + i4;
                    bArr[i5] = (byte) (C6242GF16.m18291mul(b2, b) ^ bArr[i5]);
                    i4++;
                }
            }
            i3++;
            i += i2;
        }
    }

    private byte gf16Determinant(byte[] bArr, int i) {
        int i2 = this.f23542l;
        if (i2 == 2) {
            return determinant2x2(bArr, i);
        }
        if (i2 == 3) {
            return determinant3x3(bArr, i);
        }
        if (i2 == 4) {
            return determinant4x4(bArr, i);
        }
        if (i2 == 5) {
            return determinant5x5(bArr, i);
        }
        throw new IllegalStateException();
    }

    private void gf16mScaleTo(byte[] bArr, byte b, byte[] bArr2, int i) {
        int i2;
        int i3 = 0;
        int i4 = 0;
        while (i3 < this.f23542l) {
            int i5 = 0;
            while (true) {
                i2 = this.f23542l;
                if (i5 < i2) {
                    int i6 = i4 + i5;
                    int i7 = i6 + i;
                    bArr2[i7] = (byte) (C6242GF16.m18291mul(bArr[i6], b) ^ bArr2[i7]);
                    i5++;
                }
            }
            i3++;
            i4 += i2;
        }
    }

    private void makeInvertibleByAddingAS(byte[] bArr, int i) {
        if (gf16Determinant(bArr, i) != 0) {
            return;
        }
        for (int i2 = 1; i2 < 16; i2++) {
            generateASMatrixTo(bArr, i, (byte) i2);
            if (gf16Determinant(bArr, i) != 0) {
                return;
            }
        }
    }

    /* renamed from: genABQP */
    public void m17858genABQP(MapGroup1 mapGroup1, byte[] bArr) {
        int i = this.f23543lsq;
        int i2 = this.f23544m;
        int i3 = this.f23541alpha;
        int i4 = this.f23545n;
        int i5 = this.f23542l;
        int i6 = (i * ((i2 * 2 * i3) + (((i4 * i4) - (i2 * i2)) * i2))) + (i5 * 2 * i2 * i3);
        int i7 = ((i2 * i3) * i5) << 1;
        byte[] bArr2 = new byte[i7];
        int i8 = (i6 + 1) >> 1;
        byte[] bArr3 = new byte[i8];
        if (this.f23547params.isPkExpandShake()) {
            byte[] bArr4 = new byte[8];
            SHAKEDigest sHAKEDigest = new SHAKEDigest(128);
            long j = 0;
            int i9 = 0;
            while (i8 > 0) {
                sHAKEDigest.mo14970update(bArr, 0, bArr.length);
                AbstractC6245Pack.longToLittleEndian(j, bArr4, 0);
                sHAKEDigest.mo14970update(bArr4, 0, 8);
                int iMin = Math.min(i8, 168);
                sHAKEDigest.mo14998doFinal(bArr3, i9, iMin);
                i9 += iMin;
                i8 -= iMin;
                j++;
            }
        } else {
            CTRModeCipher cTRModeCipherNewInstance = SICBlockCipher.newInstance(AESEngine.newInstance());
            cTRModeCipherNewInstance.mo14946init(true, new ParametersWithIV(new KeyParameter(bArr), new byte[16]));
            int blockSize = cTRModeCipherNewInstance.getBlockSize();
            byte[] bArr5 = new byte[blockSize];
            int i10 = 0;
            while (true) {
                int i11 = i10 + blockSize;
                if (i11 > i8) {
                    break;
                }
                cTRModeCipherNewInstance.processBlock(bArr5, 0, bArr3, i10);
                i10 = i11;
            }
            if (i10 < i8) {
                cTRModeCipherNewInstance.processBlock(bArr5, 0, bArr5, 0);
                System.arraycopy(bArr5, 0, bArr3, i10, i8 - i10);
            }
        }
        if ((this.f23543lsq & 1) == 0) {
            mapGroup1.m17852decode(bArr3, (i6 - i7) >> 1, this.f23542l >= 4);
        } else {
            int i12 = i6 - i7;
            byte[] bArr6 = new byte[i12];
            C6242GF16.m18286decode(bArr3, bArr6, i12);
            mapGroup1.m17853fill(bArr6, this.f23542l >= 4);
        }
        if (this.f23542l < 4) {
            int i13 = this.f23546o;
            int i14 = this.f23541alpha * i13 * this.f23543lsq;
            byte[] bArr7 = fixedAbqSet.get(Integers.m18296valueOf(i13));
            MapGroup1.fillAlpha(bArr7, 0, mapGroup1.f23528aAlpha, this.f23544m * i14);
            MapGroup1.fillAlpha(bArr7, i14, mapGroup1.f23529bAlpha, (this.f23544m - 1) * i14);
            MapGroup1.fillAlpha(bArr7, i14 * 2, mapGroup1.f23533qAlpha1, (this.f23544m - 2) * i14);
            MapGroup1.fillAlpha(bArr7, i14 * 3, mapGroup1.f23534qAlpha2, (this.f23544m - 3) * i14);
            return;
        }
        C6242GF16.m18285decode(bArr3, (i6 - i7) >> 1, bArr2, 0, i7);
        int i15 = this.f23544m * this.f23541alpha * this.f23542l;
        int i16 = 0;
        for (int i17 = 0; i17 < this.f23544m; i17++) {
            for (int i18 = 0; i18 < this.f23541alpha; i18++) {
                makeInvertibleByAddingAS(mapGroup1.f23528aAlpha[i17][i18], 0);
                makeInvertibleByAddingAS(mapGroup1.f23529bAlpha[i17][i18], 0);
                m17856genAFqS(bArr2, i16, mapGroup1.f23533qAlpha1[i17][i18], 0);
                m17856genAFqS(bArr2, i15, mapGroup1.f23534qAlpha2[i17][i18], 0);
                int i19 = this.f23542l;
                i16 += i19;
                i15 += i19;
            }
        }
    }

    public void genMap1T12Map2(SnovaKeyElements snovaKeyElements, byte[] bArr, byte[] bArr2) {
        genSeedsAndT12(snovaKeyElements.f23550T12, bArr2);
        m17858genABQP(snovaKeyElements.f23551map1, bArr);
        m17857genF(snovaKeyElements.f23552map2, snovaKeyElements.f23551map1, snovaKeyElements.f23550T12);
    }

    /* renamed from: genP22 */
    public void m17859genP22(byte[] bArr, int i, byte[][][] bArr2, byte[][][][] bArr3, byte[][][][] bArr4) {
        int i2 = this.f23546o;
        int i3 = this.f23543lsq * i2;
        int i4 = i2 * i3;
        int i5 = this.f23544m * i4;
        byte[] bArr5 = new byte[i5];
        int i6 = 0;
        int i7 = 0;
        while (i6 < this.f23544m) {
            int i8 = 0;
            int i9 = i7;
            while (i8 < this.f23546o) {
                int i10 = 0;
                int i11 = i9;
                while (i10 < this.f23546o) {
                    int i12 = 0;
                    while (i12 < this.f23548v) {
                        byte[][] bArr6 = bArr2[i12];
                        GF16Utils.gf16mMulTo(bArr6[i8], bArr4[i6][i12][i10], bArr3[i6][i8][i12], bArr6[i10], bArr5, i11, this.f23542l);
                        i12++;
                        i10 = i10;
                    }
                    i10++;
                    i11 += this.f23543lsq;
                }
                i8++;
                i9 += i3;
            }
            i6++;
            i7 += i4;
        }
        C6242GF16.m18288encode(bArr5, bArr, i, i5);
    }
}
