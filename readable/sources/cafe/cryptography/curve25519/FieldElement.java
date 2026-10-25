package cafe.cryptography.curve25519;

import cafe.cryptography.p027subtle.ConstantTime;
import java.util.Arrays;
import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import p094kotlin.C1126UByte;

/* loaded from: classes.dex */
class FieldElement {
    public static final FieldElement MINUS_ONE;

    /* renamed from: ONE */
    public static final FieldElement f1976ONE;

    /* renamed from: ZERO */
    public static final FieldElement f1977ZERO;
    private static final byte[] ZERO_BYTES;

    /* renamed from: t */
    private final int[] f1978t;

    public static class SqrtRatioM1Result {

        /* renamed from: result */
        FieldElement f1979result;
        int wasSquare;

        public SqrtRatioM1Result(int i, FieldElement fieldElement) {
            this.wasSquare = i;
            this.f1979result = fieldElement;
        }
    }

    static {
        FieldElement fieldElement = new FieldElement(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        f1977ZERO = fieldElement;
        FieldElement fieldElement2 = new FieldElement(new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        f1976ONE = fieldElement2;
        MINUS_ONE = fieldElement.subtract(fieldElement2);
        ZERO_BYTES = new byte[32];
    }

    public FieldElement(int[] iArr) {
        if (iArr.length != 10) {
            throw new IllegalArgumentException("Invalid radix-2^25.5 representation");
        }
        this.f1978t = iArr;
    }

    public static FieldElement fromByteArray(byte[] bArr) {
        long jM2113load_4 = m2113load_4(bArr, 0);
        long jM2112load_3 = m2112load_3(bArr, 4) << 6;
        long jM2112load_32 = m2112load_3(bArr, 7) << 5;
        long jM2112load_33 = m2112load_3(bArr, 10) << 3;
        long jM2112load_34 = m2112load_3(bArr, 13) << 2;
        long jM2113load_42 = m2113load_4(bArr, 16);
        long jM2112load_35 = m2112load_3(bArr, 20) << 7;
        long jM2112load_36 = m2112load_3(bArr, 23) << 5;
        long jM2112load_37 = m2112load_3(bArr, 26) << 4;
        long jM2112load_38 = (m2112load_3(bArr, 29) & 8388607) << 2;
        long j = (jM2112load_38 + 16777216) >> 25;
        long j2 = jM2113load_4 + (19 * j);
        long j3 = jM2112load_38 - (j << 25);
        long j4 = (jM2112load_3 + 16777216) >> 25;
        long j5 = jM2112load_32 + j4;
        long j6 = jM2112load_3 - (j4 << 25);
        long j7 = (jM2112load_33 + 16777216) >> 25;
        long j8 = jM2112load_34 + j7;
        long j9 = jM2112load_33 - (j7 << 25);
        long j10 = (jM2113load_42 + 16777216) >> 25;
        long j11 = jM2112load_35 + j10;
        long j12 = (jM2112load_36 + 16777216) >> 25;
        long j13 = jM2112load_37 + j12;
        long j14 = jM2112load_36 - (j12 << 25);
        long j15 = (j2 + 33554432) >> 26;
        long j16 = j6 + j15;
        long j17 = (j5 + 33554432) >> 26;
        long j18 = j9 + j17;
        long j19 = j5 - (j17 << 26);
        long j20 = (j8 + 33554432) >> 26;
        long j21 = (jM2113load_42 - (j10 << 25)) + j20;
        long j22 = j8 - (j20 << 26);
        long j23 = (j11 + 33554432) >> 26;
        long j24 = j14 + j23;
        long j25 = j11 - (j23 << 26);
        long j26 = (j13 + 33554432) >> 26;
        return new FieldElement(new int[]{(int) (j2 - (j15 << 26)), (int) j16, (int) j19, (int) j18, (int) j22, (int) j21, (int) j25, (int) j24, (int) (j13 - (j26 << 26)), (int) (j3 + j26)});
    }

    /* renamed from: load_3 */
    public static int m2112load_3(byte[] bArr, int i) {
        int i2 = bArr[i] & C1126UByte.MAX_VALUE;
        return ((bArr[i + 2] & C1126UByte.MAX_VALUE) << 16) | ((bArr[i + 1] & C1126UByte.MAX_VALUE) << 8) | i2;
    }

    /* renamed from: load_4 */
    public static long m2113load_4(byte[] bArr, int i) {
        int i2 = ((bArr[i + 1] & C1126UByte.MAX_VALUE) << 8) | (bArr[i] & C1126UByte.MAX_VALUE);
        return ((bArr[i + 3] << 24) | i2 | ((bArr[i + 2] & C1126UByte.MAX_VALUE) << 16)) & BodyPartID.bodyIdMax;
    }

    public static SqrtRatioM1Result sqrtRatioM1(FieldElement fieldElement, FieldElement fieldElement2) {
        FieldElement fieldElementMultiply = fieldElement2.m2121square().multiply(fieldElement2);
        FieldElement fieldElementMultiply2 = fieldElement.multiply(fieldElementMultiply).multiply(fieldElement.multiply(fieldElementMultiply.m2121square().multiply(fieldElement2)).m2120powP58());
        FieldElement fieldElementMultiply3 = fieldElement2.multiply(fieldElementMultiply2.m2121square());
        FieldElement fieldElementM2119negate = fieldElement.m2119negate();
        int iCtEquals = fieldElementMultiply3.ctEquals(fieldElement);
        int iCtEquals2 = fieldElementMultiply3.ctEquals(fieldElementM2119negate);
        FieldElement fieldElement3 = Constants.f1970SQRT_M1;
        return new SqrtRatioM1Result(iCtEquals | iCtEquals2, fieldElementMultiply2.ctSelect(fieldElementMultiply2.multiply(fieldElement3), fieldElementMultiply3.ctEquals(fieldElementM2119negate.multiply(fieldElement3)) | iCtEquals2).m2115ctAbs());
    }

    /* renamed from: add */
    public FieldElement m2114add(FieldElement fieldElement) {
        int[] iArr = fieldElement.f1978t;
        int[] iArr2 = new int[10];
        for (int i = 0; i < 10; i++) {
            iArr2[i] = this.f1978t[i] + iArr[i];
        }
        return new FieldElement(iArr2);
    }

    /* renamed from: ctAbs */
    public FieldElement m2115ctAbs() {
        return ctSelect(m2119negate(), isNegative());
    }

    public int ctEquals(FieldElement fieldElement) {
        return ConstantTime.m2146equal(toByteArray(), fieldElement.toByteArray());
    }

    public FieldElement ctSelect(FieldElement fieldElement, int i) {
        int i2 = -i;
        int[] iArr = new int[10];
        for (int i3 = 0; i3 < 10; i3++) {
            int[] iArr2 = this.f1978t;
            int i4 = iArr2[i3];
            iArr[i3] = i4;
            iArr[i3] = ((iArr2[i3] ^ fieldElement.f1978t[i3]) & i2) ^ i4;
        }
        return new FieldElement(iArr);
    }

    /* renamed from: equals */
    public boolean m2116equals(Object obj) {
        return (obj instanceof FieldElement) && ctEquals((FieldElement) obj) == 1;
    }

    public int hashCode() {
        return Arrays.hashCode(toByteArray());
    }

    /* renamed from: invert */
    public FieldElement m2117invert() {
        FieldElement fieldElementM2121square = m2121square();
        FieldElement fieldElementMultiply = multiply(fieldElementM2121square.m2121square().m2121square());
        FieldElement fieldElementMultiply2 = fieldElementM2121square.multiply(fieldElementMultiply);
        FieldElement fieldElementMultiply3 = fieldElementMultiply.multiply(fieldElementMultiply2.m2121square());
        FieldElement fieldElementM2121square2 = fieldElementMultiply3.m2121square();
        for (int i = 1; i < 5; i++) {
            fieldElementM2121square2 = fieldElementM2121square2.m2121square();
        }
        FieldElement fieldElementMultiply4 = fieldElementM2121square2.multiply(fieldElementMultiply3);
        FieldElement fieldElementM2121square3 = fieldElementMultiply4.m2121square();
        for (int i2 = 1; i2 < 10; i2++) {
            fieldElementM2121square3 = fieldElementM2121square3.m2121square();
        }
        FieldElement fieldElementMultiply5 = fieldElementM2121square3.multiply(fieldElementMultiply4);
        FieldElement fieldElementM2121square4 = fieldElementMultiply5.m2121square();
        for (int i3 = 1; i3 < 20; i3++) {
            fieldElementM2121square4 = fieldElementM2121square4.m2121square();
        }
        FieldElement fieldElementM2121square5 = fieldElementM2121square4.multiply(fieldElementMultiply5).m2121square();
        for (int i4 = 1; i4 < 10; i4++) {
            fieldElementM2121square5 = fieldElementM2121square5.m2121square();
        }
        FieldElement fieldElementMultiply6 = fieldElementM2121square5.multiply(fieldElementMultiply4);
        FieldElement fieldElementM2121square6 = fieldElementMultiply6.m2121square();
        for (int i5 = 1; i5 < 50; i5++) {
            fieldElementM2121square6 = fieldElementM2121square6.m2121square();
        }
        FieldElement fieldElementMultiply7 = fieldElementM2121square6.multiply(fieldElementMultiply6);
        FieldElement fieldElementM2121square7 = fieldElementMultiply7.m2121square();
        for (int i6 = 1; i6 < 100; i6++) {
            fieldElementM2121square7 = fieldElementM2121square7.m2121square();
        }
        FieldElement fieldElementM2121square8 = fieldElementM2121square7.multiply(fieldElementMultiply7).m2121square();
        for (int i7 = 1; i7 < 50; i7++) {
            fieldElementM2121square8 = fieldElementM2121square8.m2121square();
        }
        FieldElement fieldElementM2121square9 = fieldElementM2121square8.multiply(fieldElementMultiply6).m2121square();
        for (int i8 = 1; i8 < 5; i8++) {
            fieldElementM2121square9 = fieldElementM2121square9.m2121square();
        }
        return fieldElementM2121square9.multiply(fieldElementMultiply2);
    }

    public int isNegative() {
        return toByteArray()[0] & 1;
    }

    /* renamed from: isZero */
    public int m2118isZero() {
        return ConstantTime.m2146equal(toByteArray(), ZERO_BYTES);
    }

    public FieldElement multiply(FieldElement fieldElement) {
        int[] iArr = fieldElement.f1978t;
        int i = iArr[1];
        int i2 = i * 19;
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = i5 * 19;
        int i7 = iArr[5];
        int i8 = i7 * 19;
        int i9 = iArr[6];
        int i10 = iArr[7];
        int i11 = iArr[8];
        int i12 = i11 * 19;
        int i13 = iArr[9];
        int i14 = i13 * 19;
        int[] iArr2 = this.f1978t;
        int i15 = iArr2[1];
        int i16 = iArr2[3];
        int i17 = i16 * 2;
        int i18 = iArr2[5];
        int i19 = i18 * 2;
        int i20 = iArr2[7];
        int i21 = i20 * 2;
        int i22 = iArr2[9];
        int i23 = i22 * 2;
        int i24 = iArr2[0];
        int i25 = iArr[0];
        long j = i24 * i25;
        long j2 = i24 * i;
        long j3 = i24 * i5;
        long j4 = i24 * i7;
        long j5 = i24 * i10;
        long j6 = i24 * i11;
        long j7 = i24 * i13;
        long j8 = i15 * i25;
        long j9 = i15 * 2;
        long j10 = i * j9;
        long j11 = i4 * j9;
        long j12 = i15 * i5;
        long j13 = i7 * j9;
        long j14 = i15 * i9;
        long j15 = i10 * j9;
        long j16 = i15 * i11;
        long j17 = i14;
        long j18 = j9 * j17;
        int i26 = iArr2[2];
        long j19 = i26 * i25;
        long j20 = i26 * i;
        long j21 = i26 * i3;
        long j22 = i26 * i4;
        long j23 = i26 * i5;
        long j24 = i26 * i7;
        long j25 = i26 * i9;
        long j26 = i26 * i10;
        long j27 = i12;
        long j28 = i26 * j27;
        long j29 = i26 * j17;
        long j30 = i16 * i25;
        long j31 = i17;
        long j32 = i * j31;
        long j33 = i4 * j31;
        long j34 = i16 * i5;
        long j35 = i7 * j31;
        long j36 = i16 * i9;
        long j37 = i10 * 19;
        long j38 = j31 * j37;
        long j39 = i16 * j27;
        long j40 = j31 * j17;
        int i27 = iArr2[4];
        long j41 = i27 * i25;
        long j42 = i27 * i;
        long j43 = i27 * i3;
        long j44 = i27 * i4;
        long j45 = i27 * i5;
        long j46 = i27 * i7;
        long j47 = i9 * 19;
        long j48 = i27 * j47;
        long j49 = i27 * j37;
        long j50 = i27 * j27;
        long j51 = i27 * j17;
        long j52 = i18 * i25;
        long j53 = i19;
        long j54 = i * j53;
        long j55 = i4 * j53;
        long j56 = i18 * i5;
        long j57 = i8;
        long j58 = j53 * j57;
        long j59 = i18 * j47;
        long j60 = j53 * j37;
        int i28 = iArr2[6];
        long j61 = i28 * i25;
        long j62 = i28 * i;
        long j63 = i28 * i3;
        long j64 = i28 * i4;
        long j65 = i6;
        long j66 = i28 * j65;
        long j67 = i28 * j57;
        long j68 = i28 * j47;
        long j69 = i28 * j37;
        long j70 = i28 * j27;
        long j71 = i28 * j17;
        long j72 = i20 * i25;
        long j73 = i21;
        long j74 = i * j73;
        long j75 = i4 * 19;
        long j76 = j73 * j75;
        long j77 = i20 * j65;
        long j78 = j73 * j57;
        long j79 = i20 * j47;
        long j80 = j73 * j37;
        long j81 = j73 * j17;
        int i29 = iArr2[8];
        long j82 = i29 * i25;
        long j83 = i29 * i;
        long j84 = i3 * 19;
        long j85 = i29 * j84;
        long j86 = i29 * j75;
        long j87 = i29 * j65;
        long j88 = i29 * j57;
        long j89 = i29 * j47;
        long j90 = i29 * j37;
        long j91 = i29 * j27;
        long j92 = i29 * j17;
        long j93 = i22 * i25;
        long j94 = i23;
        long j95 = i22 * j84;
        long j96 = i22 * j65;
        long j97 = i22 * j47;
        long j98 = j + j18 + j28 + j38 + j48 + j58 + j66 + j76 + j85 + (i2 * j94);
        long j99 = j2 + j8 + j29 + j39 + j49 + j59 + j67 + j77 + j86 + j95;
        long j100 = (i24 * i3) + j10 + j19 + j40 + j50 + j60 + j68 + j78 + j87 + (j75 * j94);
        long j101 = (i24 * i4) + (i15 * i3) + j20 + j30 + j51 + (i18 * j27) + j69 + j79 + j88 + j96;
        long j102 = j3 + j11 + j21 + j32 + j41 + (j53 * j17) + j70 + j80 + j89 + (j57 * j94);
        long j103 = j4 + j12 + j22 + (i16 * i3) + j42 + j52 + j71 + (i20 * j27) + j90 + j97;
        long j104 = (i24 * i9) + j13 + j23 + j33 + j43 + j54 + j61 + j81 + j91 + (j37 * j94);
        long j105 = j5 + j14 + j24 + j34 + j44 + (i18 * i3) + j62 + j72 + j92 + (i22 * j27);
        long j106 = j6 + j15 + j25 + j35 + j45 + j55 + j63 + j74 + j82 + (j94 * j17);
        long j107 = j7 + j16 + j26 + j36 + j46 + j56 + j64 + (i20 * i3) + j83 + j93;
        long j108 = (j98 + 33554432) >> 26;
        long j109 = j99 + j108;
        long j110 = j98 - (j108 << 26);
        long j111 = (j102 + 33554432) >> 26;
        long j112 = j103 + j111;
        long j113 = (j109 + 16777216) >> 25;
        long j114 = j100 + j113;
        long j115 = j109 - (j113 << 25);
        long j116 = (j112 + 16777216) >> 25;
        long j117 = j104 + j116;
        long j118 = j112 - (j116 << 25);
        long j119 = (j114 + 33554432) >> 26;
        long j120 = j101 + j119;
        long j121 = j114 - (j119 << 26);
        long j122 = (j117 + 33554432) >> 26;
        long j123 = j105 + j122;
        long j124 = j117 - (j122 << 26);
        long j125 = (j120 + 16777216) >> 25;
        long j126 = (j102 - (j111 << 26)) + j125;
        long j127 = j120 - (j125 << 25);
        long j128 = (j123 + 16777216) >> 25;
        long j129 = j106 + j128;
        long j130 = j123 - (j128 << 25);
        long j131 = (j126 + 33554432) >> 26;
        long j132 = j118 + j131;
        long j133 = j126 - (j131 << 26);
        long j134 = (j129 + 33554432) >> 26;
        long j135 = j107 + j134;
        long j136 = j129 - (j134 << 26);
        long j137 = (j135 + 16777216) >> 25;
        long j138 = j110 + (19 * j137);
        long j139 = j135 - (j137 << 25);
        long j140 = (j138 + 33554432) >> 26;
        return new FieldElement(new int[]{(int) (j138 - (j140 << 26)), (int) (j115 + j140), (int) j121, (int) j127, (int) j133, (int) j132, (int) j124, (int) j130, (int) j136, (int) j139});
    }

    /* renamed from: negate */
    public FieldElement m2119negate() {
        int[] iArr = new int[10];
        for (int i = 0; i < 10; i++) {
            iArr[i] = -this.f1978t[i];
        }
        return new FieldElement(iArr);
    }

    /* renamed from: powP58 */
    public FieldElement m2120powP58() {
        FieldElement fieldElementM2121square = m2121square();
        FieldElement fieldElementMultiply = multiply(fieldElementM2121square.m2121square().m2121square());
        FieldElement fieldElementMultiply2 = fieldElementMultiply.multiply(fieldElementM2121square.multiply(fieldElementMultiply).m2121square());
        FieldElement fieldElementM2121square2 = fieldElementMultiply2.m2121square();
        for (int i = 1; i < 5; i++) {
            fieldElementM2121square2 = fieldElementM2121square2.m2121square();
        }
        FieldElement fieldElementMultiply3 = fieldElementM2121square2.multiply(fieldElementMultiply2);
        FieldElement fieldElementM2121square3 = fieldElementMultiply3.m2121square();
        for (int i2 = 1; i2 < 10; i2++) {
            fieldElementM2121square3 = fieldElementM2121square3.m2121square();
        }
        FieldElement fieldElementMultiply4 = fieldElementM2121square3.multiply(fieldElementMultiply3);
        FieldElement fieldElementM2121square4 = fieldElementMultiply4.m2121square();
        for (int i3 = 1; i3 < 20; i3++) {
            fieldElementM2121square4 = fieldElementM2121square4.m2121square();
        }
        FieldElement fieldElementM2121square5 = fieldElementM2121square4.multiply(fieldElementMultiply4).m2121square();
        for (int i4 = 1; i4 < 10; i4++) {
            fieldElementM2121square5 = fieldElementM2121square5.m2121square();
        }
        FieldElement fieldElementMultiply5 = fieldElementM2121square5.multiply(fieldElementMultiply3);
        FieldElement fieldElementM2121square6 = fieldElementMultiply5.m2121square();
        for (int i5 = 1; i5 < 50; i5++) {
            fieldElementM2121square6 = fieldElementM2121square6.m2121square();
        }
        FieldElement fieldElementMultiply6 = fieldElementM2121square6.multiply(fieldElementMultiply5);
        FieldElement fieldElementM2121square7 = fieldElementMultiply6.m2121square();
        for (int i6 = 1; i6 < 100; i6++) {
            fieldElementM2121square7 = fieldElementM2121square7.m2121square();
        }
        FieldElement fieldElementM2121square8 = fieldElementM2121square7.multiply(fieldElementMultiply6).m2121square();
        for (int i7 = 1; i7 < 50; i7++) {
            fieldElementM2121square8 = fieldElementM2121square8.m2121square();
        }
        return multiply(fieldElementM2121square8.multiply(fieldElementMultiply5).m2121square().m2121square());
    }

    public String printInternalRepresentation() {
        String str = "FieldElement([";
        for (int i = 0; i < this.f1978t.length; i++) {
            if (i > 0) {
                str = str + ", ";
            }
            str = str + this.f1978t[i];
        }
        return str + "])";
    }

    /* renamed from: square */
    public FieldElement m2121square() {
        int[] iArr = this.f1978t;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = iArr[8];
        int i10 = iArr[9];
        int i11 = i3 * 2;
        int i12 = i5 * 2;
        int i13 = i7 * 2;
        int i14 = i7 * 19;
        int i15 = i9 * 19;
        int i16 = i10 * 38;
        long j = i;
        long j2 = j * j;
        long j3 = i * 2;
        long j4 = i2;
        long j5 = j3 * j4;
        long j6 = i3;
        long j7 = j3 * j6;
        long j8 = i4;
        long j9 = j3 * j8;
        long j10 = i5;
        long j11 = j3 * j10;
        long j12 = i6;
        long j13 = j3 * j12;
        long j14 = i7;
        long j15 = j3 * j14;
        long j16 = i8;
        long j17 = j3 * j16;
        long j18 = i9;
        long j19 = j3 * j18;
        long j20 = i10;
        long j21 = j3 * j20;
        long j22 = i2 * 2;
        long j23 = j4 * j22;
        long j24 = j22 * j6;
        long j25 = i4 * 2;
        long j26 = j22 * j25;
        long j27 = j22 * j10;
        long j28 = i6 * 2;
        long j29 = j22 * j28;
        long j30 = j22 * j14;
        long j31 = i8 * 2;
        long j32 = j22 * j31;
        long j33 = j22 * j18;
        long j34 = i16;
        long j35 = j22 * j34;
        long j36 = i11;
        long j37 = j36 * j12;
        long j38 = j36 * j14;
        long j39 = j36 * j16;
        long j40 = i15;
        long j41 = j8 * j25;
        long j42 = j25 * j10;
        long j43 = j25 * j28;
        long j44 = j25 * j14;
        long j45 = i8 * 38;
        long j46 = j25 * j45;
        long j47 = j25 * j40;
        long j48 = j25 * j34;
        long j49 = i12;
        long j50 = j49 * j12;
        long j51 = i14;
        long j52 = j28 * j51;
        long j53 = j28 * j40;
        long j54 = j14 * j45;
        long j55 = j31 * j40;
        long j56 = j18 * j40;
        long j57 = j2 + j35 + (j36 * j40) + j46 + (j49 * j51) + (i6 * 38 * j12);
        long j58 = j7 + j23 + j48 + (j49 * j40) + (j28 * j45) + (j51 * j14);
        long j59 = j11 + j26 + (j6 * j6) + (j28 * j34) + (i13 * j40) + (j45 * j16);
        long j60 = (j57 + 33554432) >> 26;
        long j61 = j5 + (j6 * j34) + j47 + (j10 * j45) + j52 + j60;
        long j62 = j57 - (j60 << 26);
        long j63 = (j59 + 33554432) >> 26;
        long j64 = j13 + j27 + (j36 * j8) + (j14 * j34) + j55 + j63;
        long j65 = (j61 + 16777216) >> 25;
        long j66 = j58 + j65;
        long j67 = j61 - (j65 << 25);
        long j68 = (j64 + 16777216) >> 25;
        long j69 = j15 + j29 + (j36 * j10) + j41 + (j31 * j34) + j56 + j68;
        long j70 = j64 - (j68 << 25);
        long j71 = (j66 + 33554432) >> 26;
        long j72 = j9 + j24 + (j10 * j34) + j53 + j54 + j71;
        long j73 = (j69 + 33554432) >> 26;
        long j74 = j17 + j30 + j37 + j42 + (j18 * j34) + j73;
        long j75 = (j72 + 16777216) >> 25;
        long j76 = (j59 - (j63 << 26)) + j75;
        long j77 = (j74 + 16777216) >> 25;
        long j78 = j19 + j32 + j38 + j43 + (j10 * j10) + (j34 * j20) + j77;
        long j79 = (j76 + 33554432) >> 26;
        long j80 = j70 + j79;
        long j81 = j76 - (j79 << 26);
        long j82 = (j78 + 33554432) >> 26;
        long j83 = j21 + j33 + j39 + j44 + j50 + j82;
        long j84 = j78 - (j82 << 26);
        long j85 = (j83 + 16777216) >> 25;
        long j86 = j62 + (19 * j85);
        long j87 = (j86 + 33554432) >> 26;
        return new FieldElement(new int[]{(int) (j86 - (j87 << 26)), (int) (j67 + j87), (int) (j66 - (j71 << 26)), (int) (j72 - (j75 << 25)), (int) j81, (int) j80, (int) (j69 - (j73 << 26)), (int) (j74 - (j77 << 25)), (int) j84, (int) (j83 - (j85 << 25))});
    }

    public FieldElement squareAndDouble() {
        int[] iArr = this.f1978t;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = iArr[8];
        int i10 = iArr[9];
        int i11 = i3 * 2;
        int i12 = i5 * 2;
        int i13 = i7 * 2;
        int i14 = i7 * 19;
        int i15 = i9 * 19;
        int i16 = i10 * 38;
        long j = i;
        long j2 = j * j;
        long j3 = i * 2;
        long j4 = i2;
        long j5 = j3 * j4;
        long j6 = i3;
        long j7 = j3 * j6;
        long j8 = i4;
        long j9 = j3 * j8;
        long j10 = i5;
        long j11 = j3 * j10;
        long j12 = i6;
        long j13 = j3 * j12;
        long j14 = i7;
        long j15 = j3 * j14;
        long j16 = i8;
        long j17 = j3 * j16;
        long j18 = i9;
        long j19 = j3 * j18;
        long j20 = i10;
        long j21 = j3 * j20;
        long j22 = i2 * 2;
        long j23 = j4 * j22;
        long j24 = j22 * j6;
        long j25 = i4 * 2;
        long j26 = j22 * j25;
        long j27 = j22 * j10;
        long j28 = i6 * 2;
        long j29 = j22 * j28;
        long j30 = j22 * j14;
        long j31 = i8 * 2;
        long j32 = j22 * j31;
        long j33 = j22 * j18;
        long j34 = i16;
        long j35 = j22 * j34;
        long j36 = i11;
        long j37 = j36 * j12;
        long j38 = j36 * j14;
        long j39 = i15;
        long j40 = j8 * j25;
        long j41 = j25 * j10;
        long j42 = j25 * j28;
        long j43 = j25 * j14;
        long j44 = i8 * 38;
        long j45 = j25 * j44;
        long j46 = j25 * j39;
        long j47 = j25 * j34;
        long j48 = i12;
        long j49 = i14;
        long j50 = j28 * j49;
        long j51 = j14 * j44;
        long j52 = j31 * j39;
        long j53 = j18 * j39;
        long j54 = j2 + j35 + (j36 * j39) + j45 + (j48 * j49) + (i6 * 38 * j12);
        long j55 = j5 + (j6 * j34) + j46 + (j10 * j44) + j50;
        long j56 = j7 + j23 + j47 + (j48 * j39) + (j28 * j44) + (j49 * j14);
        long j57 = j9 + j24 + (j10 * j34) + (j28 * j39) + j51;
        long j58 = j11 + j26 + (j6 * j6) + (j28 * j34) + (i13 * j39) + (j44 * j16);
        long j59 = j13 + j27 + (j36 * j8) + (j14 * j34) + j52;
        long j60 = j15 + j29 + (j36 * j10) + j40 + (j31 * j34) + j53;
        long j61 = j17 + j30 + j37 + j41 + (j18 * j34);
        long j62 = j19 + j32 + j38 + j42 + (j10 * j10) + (j34 * j20);
        long j63 = j21 + j33 + (j36 * j16) + j43 + (j48 * j12);
        long j64 = j54 + j54;
        long j65 = j58 + j58;
        long j66 = (j64 + 33554432) >> 26;
        long j67 = j55 + j55 + j66;
        long j68 = j64 - (j66 << 26);
        long j69 = (j65 + 33554432) >> 26;
        long j70 = j59 + j59 + j69;
        long j71 = (j67 + 16777216) >> 25;
        long j72 = j56 + j56 + j71;
        long j73 = j67 - (j71 << 25);
        long j74 = (j70 + 16777216) >> 25;
        long j75 = j60 + j60 + j74;
        long j76 = j70 - (j74 << 25);
        long j77 = (j72 + 33554432) >> 26;
        long j78 = j57 + j57 + j77;
        long j79 = (j75 + 33554432) >> 26;
        long j80 = j61 + j61 + j79;
        long j81 = (j78 + 16777216) >> 25;
        long j82 = (j65 - (j69 << 26)) + j81;
        long j83 = (j80 + 16777216) >> 25;
        long j84 = j62 + j62 + j83;
        long j85 = (j82 + 33554432) >> 26;
        long j86 = j76 + j85;
        long j87 = j82 - (j85 << 26);
        long j88 = (j84 + 33554432) >> 26;
        long j89 = j63 + j63 + j88;
        long j90 = j84 - (j88 << 26);
        long j91 = (j89 + 16777216) >> 25;
        long j92 = j68 + (19 * j91);
        long j93 = (j92 + 33554432) >> 26;
        return new FieldElement(new int[]{(int) (j92 - (j93 << 26)), (int) (j73 + j93), (int) (j72 - (j77 << 26)), (int) (j78 - (j81 << 25)), (int) j87, (int) j86, (int) (j75 - (j79 << 26)), (int) (j80 - (j83 << 25)), (int) j90, (int) (j89 - (j91 << 25))});
    }

    public FieldElement subtract(FieldElement fieldElement) {
        int[] iArr = fieldElement.f1978t;
        int[] iArr2 = new int[10];
        for (int i = 0; i < 10; i++) {
            iArr2[i] = this.f1978t[i] - iArr[i];
        }
        return new FieldElement(iArr2);
    }

    public byte[] toByteArray() {
        int[] iArr = this.f1978t;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = iArr[8];
        int i10 = iArr[9];
        int i11 = i + (((i10 + ((i9 + ((i8 + ((i7 + ((i6 + ((i5 + ((i4 + ((i3 + ((i2 + ((i + (((i10 * 19) + 16777216) >> 25)) >> 26)) >> 25)) >> 26)) >> 25)) >> 26)) >> 25)) >> 26)) >> 25)) >> 26)) >> 25) * 19);
        int i12 = i11 >> 26;
        int i13 = i2 + i12;
        int i14 = i11 - (i12 << 26);
        int i15 = i13 >> 25;
        int i16 = i3 + i15;
        int i17 = i13 - (i15 << 25);
        int i18 = i16 >> 26;
        int i19 = i4 + i18;
        int i20 = i16 - (i18 << 26);
        int i21 = i19 >> 25;
        int i22 = i5 + i21;
        int i23 = i19 - (i21 << 25);
        int i24 = i22 >> 26;
        int i25 = i6 + i24;
        int i26 = i22 - (i24 << 26);
        int i27 = i25 >> 25;
        int i28 = i7 + i27;
        int i29 = i25 - (i27 << 25);
        int i30 = i28 >> 26;
        int i31 = i8 + i30;
        int i32 = i28 - (i30 << 26);
        int i33 = i31 >> 25;
        int i34 = i9 + i33;
        int i35 = i31 - (i33 << 25);
        int i36 = i34 >> 26;
        int i37 = i10 + i36;
        int i38 = i34 - (i36 << 26);
        int i39 = i37 - ((i37 >> 25) << 25);
        return new byte[]{(byte) i14, (byte) (i14 >> 8), (byte) (i14 >> 16), (byte) ((i14 >> 24) | (i17 << 2)), (byte) (i17 >> 6), (byte) (i17 >> 14), (byte) ((i17 >> 22) | (i20 << 3)), (byte) (i20 >> 5), (byte) (i20 >> 13), (byte) ((i20 >> 21) | (i23 << 5)), (byte) (i23 >> 3), (byte) (i23 >> 11), (byte) ((i23 >> 19) | (i26 << 6)), (byte) (i26 >> 2), (byte) (i26 >> 10), (byte) (i26 >> 18), (byte) i29, (byte) (i29 >> 8), (byte) (i29 >> 16), (byte) ((i29 >> 24) | (i32 << 1)), (byte) (i32 >> 7), (byte) (i32 >> 15), (byte) ((i32 >> 23) | (i35 << 3)), (byte) (i35 >> 5), (byte) (i35 >> 13), (byte) ((i35 >> 21) | (i38 << 4)), (byte) (i38 >> 4), (byte) (i38 >> 12), (byte) ((i38 >> 20) | (i39 << 6)), (byte) (i39 >> 2), (byte) (i39 >> 10), (byte) (i39 >> 18)};
    }
}
