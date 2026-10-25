package cafe.cryptography.curve25519;

import cafe.cryptography.p027subtle.ConstantTime;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* renamed from: cafe.cryptography.curve25519.Scalar */
/* loaded from: classes.dex */
public class C0186Scalar implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: s */
    private transient byte[] f1993s;

    /* renamed from: ZERO */
    public static final C0186Scalar f1992ZERO = new C0186Scalar(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

    /* renamed from: ONE */
    public static final C0186Scalar f1991ONE = new C0186Scalar(new byte[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

    public C0186Scalar(byte[] bArr) {
        if (bArr.length != 32 || ((bArr[31] >> 7) & 1) != 0) {
            throw new IllegalArgumentException("Invalid scalar representation");
        }
        this.f1993s = Arrays.copyOf(bArr, bArr.length);
    }

    public static C0186Scalar fromBits(byte[] bArr) {
        bArr[31] = (byte) (bArr[31] & ByteCompanionObject.MAX_VALUE);
        return new C0186Scalar(bArr);
    }

    public static C0186Scalar fromBytesModOrder(byte[] bArr) {
        if (bArr.length == 32) {
            return m2131reduce(bArr);
        }
        throw new IllegalArgumentException("Input must by 32 bytes");
    }

    public static C0186Scalar fromBytesModOrderWide(byte[] bArr) {
        if (bArr.length != 64) {
            throw new IllegalArgumentException("Input must by 64 bytes");
        }
        long jM2112load_3 = FieldElement.m2112load_3(bArr, 0) & 2097151;
        long jM2113load_4 = (FieldElement.m2113load_4(bArr, 2) >> 5) & 2097151;
        long jM2112load_32 = (FieldElement.m2112load_3(bArr, 5) >> 2) & 2097151;
        long jM2113load_42 = (FieldElement.m2113load_4(bArr, 7) >> 7) & 2097151;
        long jM2113load_43 = (FieldElement.m2113load_4(bArr, 10) >> 4) & 2097151;
        long jM2112load_33 = (FieldElement.m2112load_3(bArr, 13) >> 1) & 2097151;
        long jM2113load_44 = (FieldElement.m2113load_4(bArr, 15) >> 6) & 2097151;
        long jM2112load_34 = (FieldElement.m2112load_3(bArr, 18) >> 3) & 2097151;
        long jM2112load_35 = FieldElement.m2112load_3(bArr, 21) & 2097151;
        long jM2113load_45 = (FieldElement.m2113load_4(bArr, 23) >> 5) & 2097151;
        long jM2112load_36 = (FieldElement.m2112load_3(bArr, 26) >> 2) & 2097151;
        long jM2113load_46 = (FieldElement.m2113load_4(bArr, 28) >> 7) & 2097151;
        long jM2113load_47 = (FieldElement.m2113load_4(bArr, 31) >> 4) & 2097151;
        long jM2112load_37 = (FieldElement.m2112load_3(bArr, 34) >> 1) & 2097151;
        long jM2113load_48 = (FieldElement.m2113load_4(bArr, 36) >> 6) & 2097151;
        long jM2112load_38 = (FieldElement.m2112load_3(bArr, 39) >> 3) & 2097151;
        long jM2112load_39 = FieldElement.m2112load_3(bArr, 42) & 2097151;
        long jM2113load_49 = (FieldElement.m2113load_4(bArr, 44) >> 5) & 2097151;
        long jM2112load_310 = (FieldElement.m2112load_3(bArr, 47) >> 2) & 2097151;
        long jM2113load_410 = (FieldElement.m2113load_4(bArr, 49) >> 7) & 2097151;
        long jM2113load_411 = (FieldElement.m2113load_4(bArr, 52) >> 4) & 2097151;
        long jM2112load_311 = 2097151 & (FieldElement.m2112load_3(bArr, 55) >> 1);
        long jM2113load_412 = (FieldElement.m2113load_4(bArr, 57) >> 6) & 2097151;
        long jM2113load_413 = FieldElement.m2113load_4(bArr, 60) >> 3;
        long j = jM2112load_39 - (jM2113load_413 * 683901);
        long j2 = (jM2112load_38 + (jM2113load_413 * 136657)) - (jM2113load_412 * 683901);
        long j3 = ((jM2112load_37 + (jM2113load_413 * 654183)) - (jM2113load_412 * 997805)) + (jM2112load_311 * 136657);
        long j4 = ((jM2113load_48 - (jM2113load_413 * 997805)) + (jM2113load_412 * 136657)) - (jM2112load_311 * 683901);
        long j5 = jM2113load_45 + (jM2112load_311 * 666643) + (jM2113load_411 * 470296);
        long j6 = (((jM2113load_46 + (jM2113load_413 * 666643)) + (jM2113load_412 * 470296)) + (jM2112load_311 * 654183)) - (jM2113load_411 * 997805);
        long j7 = ((((jM2113load_47 + (jM2113load_413 * 470296)) + (jM2113load_412 * 654183)) - (jM2112load_311 * 997805)) + (jM2113load_411 * 136657)) - (jM2113load_410 * 683901);
        long j8 = jM2113load_44 + (jM2112load_310 * 666643);
        long j9 = jM2112load_35 + (jM2113load_411 * 666643) + (jM2113load_410 * 470296) + (jM2112load_310 * 654183);
        long j10 = ((((jM2112load_36 + (jM2113load_412 * 666643)) + (jM2112load_311 * 470296)) + (jM2113load_411 * 654183)) - (jM2113load_410 * 997805)) + (jM2112load_310 * 136657);
        long j11 = (j8 + 1048576) >> 21;
        long j12 = jM2112load_34 + (jM2113load_410 * 666643) + (jM2112load_310 * 470296) + j11;
        long j13 = j8 - (j11 << 21);
        long j14 = (j9 + 1048576) >> 21;
        long j15 = ((j5 + (jM2113load_410 * 654183)) - (jM2112load_310 * 997805)) + j14;
        long j16 = j9 - (j14 << 21);
        long j17 = (j10 + 1048576) >> 21;
        long j18 = ((j6 + (jM2113load_410 * 136657)) - (jM2112load_310 * 683901)) + j17;
        long j19 = j10 - (j17 << 21);
        long j20 = (j7 + 1048576) >> 21;
        long j21 = (j3 - (jM2113load_411 * 683901)) + j20;
        long j22 = j7 - (j20 << 21);
        long j23 = (j4 + 1048576) >> 21;
        long j24 = j2 + j23;
        long j25 = j4 - (j23 << 21);
        long j26 = (j + 1048576) >> 21;
        long j27 = jM2113load_49 + j26;
        long j28 = j - (j26 << 21);
        long j29 = (j12 + 1048576) >> 21;
        long j30 = j16 + j29;
        long j31 = j12 - (j29 << 21);
        long j32 = (j15 + 1048576) >> 21;
        long j33 = j19 + j32;
        long j34 = j15 - (j32 << 21);
        long j35 = (j18 + 1048576) >> 21;
        long j36 = j22 + j35;
        long j37 = j18 - (j35 << 21);
        long j38 = (j21 + 1048576) >> 21;
        long j39 = j25 + j38;
        long j40 = j21 - (j38 << 21);
        long j41 = (j24 + 1048576) >> 21;
        long j42 = j28 + j41;
        long j43 = j24 - (j41 << 21);
        long j44 = j33 - (j27 * 683901);
        long j45 = ((j31 + (j27 * 654183)) - (j42 * 997805)) + (j43 * 136657);
        long j46 = ((j30 - (j27 * 997805)) + (j42 * 136657)) - (j43 * 683901);
        long j47 = ((((jM2112load_33 + (j27 * 666643)) + (j42 * 470296)) + (j43 * 654183)) - (j39 * 997805)) + (j40 * 136657);
        long j48 = ((((j13 + (j27 * 470296)) + (j42 * 654183)) - (j43 * 997805)) + (j39 * 136657)) - (j40 * 683901);
        long j49 = jM2112load_3 + (j36 * 666643);
        long j50 = jM2112load_32 + (j39 * 666643) + (j40 * 470296) + (j36 * 654183);
        long j51 = (((jM2113load_42 + (j43 * 666643)) + (j39 * 470296)) + (j40 * 654183)) - (j36 * 997805);
        long j52 = ((((jM2113load_43 + (j42 * 666643)) + (j43 * 470296)) + (j39 * 654183)) - (j40 * 997805)) + (j36 * 136657);
        long j53 = (j49 + 1048576) >> 21;
        long j54 = jM2113load_4 + (j40 * 666643) + (j36 * 470296) + j53;
        long j55 = j49 - (j53 << 21);
        long j56 = (j50 + 1048576) >> 21;
        long j57 = j51 + j56;
        long j58 = j50 - (j56 << 21);
        long j59 = (j52 + 1048576) >> 21;
        long j60 = (j47 - (j36 * 683901)) + j59;
        long j61 = j52 - (j59 << 21);
        long j62 = (j48 + 1048576) >> 21;
        long j63 = (j45 - (j39 * 683901)) + j62;
        long j64 = j48 - (j62 << 21);
        long j65 = (j46 + 1048576) >> 21;
        long j66 = ((j34 + (j27 * 136657)) - (j42 * 683901)) + j65;
        long j67 = j46 - (j65 << 21);
        long j68 = (j44 + 1048576) >> 21;
        long j69 = j37 + j68;
        long j70 = j44 - (j68 << 21);
        long j71 = (j54 + 1048576) >> 21;
        long j72 = j58 + j71;
        long j73 = j54 - (j71 << 21);
        long j74 = (j57 + 1048576) >> 21;
        long j75 = j61 + j74;
        long j76 = j57 - (j74 << 21);
        long j77 = (j60 + 1048576) >> 21;
        long j78 = j64 + j77;
        long j79 = j60 - (j77 << 21);
        long j80 = (j63 + 1048576) >> 21;
        long j81 = j67 + j80;
        long j82 = j63 - (j80 << 21);
        long j83 = (j66 + 1048576) >> 21;
        long j84 = j70 + j83;
        long j85 = j66 - (j83 << 21);
        long j86 = (j69 + 1048576) >> 21;
        long j87 = j69 - (j86 << 21);
        long j88 = j55 + (j86 * 666643);
        long j89 = j73 + (j86 * 470296);
        long j90 = j72 + (j86 * 654183);
        long j91 = j76 - (j86 * 997805);
        long j92 = j75 + (j86 * 136657);
        long j93 = j79 - (j86 * 683901);
        long j94 = j88 >> 21;
        long j95 = j89 + j94;
        long j96 = j88 - (j94 << 21);
        long j97 = j95 >> 21;
        long j98 = j90 + j97;
        long j99 = j95 - (j97 << 21);
        long j100 = j98 >> 21;
        long j101 = j91 + j100;
        long j102 = j98 - (j100 << 21);
        long j103 = j101 >> 21;
        long j104 = j92 + j103;
        long j105 = j101 - (j103 << 21);
        long j106 = j104 >> 21;
        long j107 = j93 + j106;
        long j108 = j104 - (j106 << 21);
        long j109 = j107 >> 21;
        long j110 = j78 + j109;
        long j111 = j107 - (j109 << 21);
        long j112 = j110 >> 21;
        long j113 = j82 + j112;
        long j114 = j110 - (j112 << 21);
        long j115 = j113 >> 21;
        long j116 = j81 + j115;
        long j117 = j113 - (j115 << 21);
        long j118 = j116 >> 21;
        long j119 = j85 + j118;
        long j120 = j116 - (j118 << 21);
        long j121 = j119 >> 21;
        long j122 = j84 + j121;
        long j123 = j119 - (j121 << 21);
        long j124 = j122 >> 21;
        long j125 = j87 + j124;
        long j126 = j122 - (j124 << 21);
        long j127 = j125 >> 21;
        long j128 = j125 - (j127 << 21);
        long j129 = j96 + (666643 * j127);
        long j130 = j99 + (470296 * j127);
        long j131 = j102 + (654183 * j127);
        long j132 = j105 - (997805 * j127);
        long j133 = j108 + (136657 * j127);
        long j134 = j111 - (j127 * 683901);
        long j135 = j129 >> 21;
        long j136 = j130 + j135;
        long j137 = j129 - (j135 << 21);
        long j138 = j136 >> 21;
        long j139 = j131 + j138;
        long j140 = j136 - (j138 << 21);
        long j141 = j139 >> 21;
        long j142 = j132 + j141;
        long j143 = j139 - (j141 << 21);
        long j144 = j142 >> 21;
        long j145 = j133 + j144;
        long j146 = j142 - (j144 << 21);
        long j147 = j145 >> 21;
        long j148 = j134 + j147;
        long j149 = j145 - (j147 << 21);
        long j150 = j148 >> 21;
        long j151 = j114 + j150;
        long j152 = j148 - (j150 << 21);
        long j153 = j151 >> 21;
        long j154 = j117 + j153;
        long j155 = j151 - (j153 << 21);
        long j156 = j154 >> 21;
        long j157 = j120 + j156;
        long j158 = j154 - (j156 << 21);
        long j159 = j157 >> 21;
        long j160 = j123 + j159;
        long j161 = j157 - (j159 << 21);
        long j162 = j160 >> 21;
        long j163 = j126 + j162;
        long j164 = j160 - (j162 << 21);
        long j165 = j163 >> 21;
        long j166 = j128 + j165;
        long j167 = j163 - (j165 << 21);
        return new C0186Scalar(new byte[]{(byte) j137, (byte) (j137 >> 8), (byte) ((j137 >> 16) | (j140 << 5)), (byte) (j140 >> 3), (byte) (j140 >> 11), (byte) ((j140 >> 19) | (j143 << 2)), (byte) (j143 >> 6), (byte) ((j143 >> 14) | (j146 << 7)), (byte) (j146 >> serialVersionUID), (byte) (j146 >> 9), (byte) ((j146 >> 17) | (j149 << 4)), (byte) (j149 >> 4), (byte) (j149 >> 12), (byte) ((j149 >> 20) | (j152 << serialVersionUID)), (byte) (j152 >> 7), (byte) ((j152 >> 15) | (j155 << 6)), (byte) (j155 >> 2), (byte) (j155 >> 10), (byte) ((j155 >> 18) | (j158 << 3)), (byte) (j158 >> 5), (byte) (j158 >> 13), (byte) j161, (byte) (j161 >> 8), (byte) ((j161 >> 16) | (j164 << 5)), (byte) (j164 >> 3), (byte) (j164 >> 11), (byte) ((j164 >> 19) | (j167 << 2)), (byte) (j167 >> 6), (byte) ((j167 >> 14) | (j166 << 7)), (byte) (j166 >> serialVersionUID), (byte) (j166 >> 9), (byte) (j166 >> 17)});
    }

    public static C0186Scalar fromCanonicalBytes(byte[] bArr) {
        C0186Scalar c0186Scalar = new C0186Scalar(bArr);
        if (c0186Scalar.isCanonical()) {
            return c0186Scalar;
        }
        throw new IllegalArgumentException("Non-canonical scalar representation");
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        byte[] bArr = new byte[32];
        objectInputStream.readFully(bArr);
        if (((bArr[31] >> 7) & 1) != 0) {
            throw new InvalidObjectException("Invalid scalar representation");
        }
        this.f1993s = bArr;
    }

    private void readObjectNoData() throws InvalidObjectException {
        throw new InvalidObjectException("Cannot deserialize Scalar from no data");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.write(toByteArray());
    }

    /* renamed from: add */
    public C0186Scalar m2132add(C0186Scalar c0186Scalar) {
        return new C0186Scalar(UnpackedScalar.fromByteArray(this.f1993s).m2136add(UnpackedScalar.fromByteArray(c0186Scalar.f1993s)).toByteArray());
    }

    public int ctEquals(C0186Scalar c0186Scalar) {
        return ConstantTime.m2146equal(this.f1993s, c0186Scalar.f1993s);
    }

    /* renamed from: equals */
    public boolean m2133equals(Object obj) {
        return (obj instanceof C0186Scalar) && ctEquals((C0186Scalar) obj) == 1;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f1993s);
    }

    public boolean isCanonical() {
        return ctEquals(m2131reduce(this.f1993s)) == 1;
    }

    public C0186Scalar multiply(C0186Scalar c0186Scalar) {
        return multiplyAndAdd(c0186Scalar, f1992ZERO);
    }

    public C0186Scalar multiplyAndAdd(C0186Scalar c0186Scalar, C0186Scalar c0186Scalar2) {
        long jM2112load_3 = FieldElement.m2112load_3(this.f1993s, 0) & 2097151;
        long jM2113load_4 = (FieldElement.m2113load_4(this.f1993s, 2) >> 5) & 2097151;
        long jM2112load_32 = (FieldElement.m2112load_3(this.f1993s, 5) >> 2) & 2097151;
        long jM2113load_42 = (FieldElement.m2113load_4(this.f1993s, 7) >> 7) & 2097151;
        long jM2113load_43 = (FieldElement.m2113load_4(this.f1993s, 10) >> 4) & 2097151;
        long jM2112load_33 = (FieldElement.m2112load_3(this.f1993s, 13) >> 1) & 2097151;
        long jM2113load_44 = (FieldElement.m2113load_4(this.f1993s, 15) >> 6) & 2097151;
        long jM2112load_34 = (FieldElement.m2112load_3(this.f1993s, 18) >> 3) & 2097151;
        long jM2112load_35 = FieldElement.m2112load_3(this.f1993s, 21) & 2097151;
        long jM2113load_45 = (FieldElement.m2113load_4(this.f1993s, 23) >> 5) & 2097151;
        long jM2112load_36 = (FieldElement.m2112load_3(this.f1993s, 26) >> 2) & 2097151;
        long jM2113load_46 = FieldElement.m2113load_4(this.f1993s, 28) >> 7;
        long jM2112load_37 = FieldElement.m2112load_3(c0186Scalar.f1993s, 0) & 2097151;
        long jM2113load_47 = (FieldElement.m2113load_4(c0186Scalar.f1993s, 2) >> 5) & 2097151;
        long jM2112load_38 = (FieldElement.m2112load_3(c0186Scalar.f1993s, 5) >> 2) & 2097151;
        long jM2113load_48 = (FieldElement.m2113load_4(c0186Scalar.f1993s, 7) >> 7) & 2097151;
        long jM2113load_49 = (FieldElement.m2113load_4(c0186Scalar.f1993s, 10) >> 4) & 2097151;
        long jM2112load_39 = (FieldElement.m2112load_3(c0186Scalar.f1993s, 13) >> 1) & 2097151;
        long jM2113load_410 = (FieldElement.m2113load_4(c0186Scalar.f1993s, 15) >> 6) & 2097151;
        long jM2112load_310 = (FieldElement.m2112load_3(c0186Scalar.f1993s, 18) >> 3) & 2097151;
        long jM2112load_311 = FieldElement.m2112load_3(c0186Scalar.f1993s, 21) & 2097151;
        long jM2113load_411 = (FieldElement.m2113load_4(c0186Scalar.f1993s, 23) >> 5) & 2097151;
        long jM2112load_312 = (FieldElement.m2112load_3(c0186Scalar.f1993s, 26) >> 2) & 2097151;
        long jM2113load_412 = FieldElement.m2113load_4(c0186Scalar.f1993s, 28) >> 7;
        long jM2112load_313 = FieldElement.m2112load_3(c0186Scalar2.f1993s, 0) & 2097151;
        long jM2113load_413 = (FieldElement.m2113load_4(c0186Scalar2.f1993s, 2) >> 5) & 2097151;
        long jM2112load_314 = (FieldElement.m2112load_3(c0186Scalar2.f1993s, 5) >> 2) & 2097151;
        long jM2113load_414 = (FieldElement.m2113load_4(c0186Scalar2.f1993s, 7) >> 7) & 2097151;
        long jM2113load_415 = (FieldElement.m2113load_4(c0186Scalar2.f1993s, 10) >> 4) & 2097151;
        long jM2112load_315 = (FieldElement.m2112load_3(c0186Scalar2.f1993s, 13) >> 1) & 2097151;
        long jM2113load_416 = (FieldElement.m2113load_4(c0186Scalar2.f1993s, 15) >> 6) & 2097151;
        long jM2112load_316 = (FieldElement.m2112load_3(c0186Scalar2.f1993s, 18) >> 3) & 2097151;
        long j = jM2112load_313 + (jM2112load_3 * jM2112load_37);
        long j2 = jM2113load_413 + (jM2112load_3 * jM2113load_47) + (jM2113load_4 * jM2112load_37);
        long j3 = jM2112load_314 + (jM2112load_3 * jM2112load_38) + (jM2113load_4 * jM2113load_47) + (jM2112load_32 * jM2112load_37);
        long j4 = jM2113load_414 + (jM2112load_3 * jM2113load_48) + (jM2113load_4 * jM2112load_38) + (jM2112load_32 * jM2113load_47) + (jM2113load_42 * jM2112load_37);
        long j5 = jM2113load_415 + (jM2112load_3 * jM2113load_49) + (jM2113load_4 * jM2113load_48) + (jM2112load_32 * jM2112load_38) + (jM2113load_42 * jM2113load_47) + (jM2113load_43 * jM2112load_37);
        long j6 = jM2112load_315 + (jM2112load_3 * jM2112load_39) + (jM2113load_4 * jM2113load_49) + (jM2112load_32 * jM2113load_48) + (jM2113load_42 * jM2112load_38) + (jM2113load_43 * jM2113load_47) + (jM2112load_33 * jM2112load_37);
        long j7 = jM2113load_416 + (jM2112load_3 * jM2113load_410) + (jM2113load_4 * jM2112load_39) + (jM2112load_32 * jM2113load_49) + (jM2113load_42 * jM2113load_48) + (jM2113load_43 * jM2112load_38) + (jM2112load_33 * jM2113load_47) + (jM2113load_44 * jM2112load_37);
        long j8 = jM2112load_316 + (jM2112load_3 * jM2112load_310) + (jM2113load_4 * jM2113load_410) + (jM2112load_32 * jM2112load_39) + (jM2113load_42 * jM2113load_49) + (jM2113load_43 * jM2113load_48) + (jM2112load_33 * jM2112load_38) + (jM2113load_44 * jM2113load_47) + (jM2112load_34 * jM2112load_37);
        long jM2112load_317 = (FieldElement.m2112load_3(c0186Scalar2.f1993s, 21) & 2097151) + (jM2112load_3 * jM2112load_311) + (jM2113load_4 * jM2112load_310) + (jM2112load_32 * jM2113load_410) + (jM2113load_42 * jM2112load_39) + (jM2113load_43 * jM2113load_49) + (jM2112load_33 * jM2113load_48) + (jM2113load_44 * jM2112load_38) + (jM2112load_34 * jM2113load_47) + (jM2112load_35 * jM2112load_37);
        long jM2113load_417 = ((FieldElement.m2113load_4(c0186Scalar2.f1993s, 23) >> 5) & 2097151) + (jM2112load_3 * jM2113load_411) + (jM2113load_4 * jM2112load_311) + (jM2112load_32 * jM2112load_310) + (jM2113load_42 * jM2113load_410) + (jM2113load_43 * jM2112load_39) + (jM2112load_33 * jM2113load_49) + (jM2113load_44 * jM2113load_48) + (jM2112load_34 * jM2112load_38) + (jM2112load_35 * jM2113load_47) + (jM2113load_45 * jM2112load_37);
        long jM2112load_318 = ((FieldElement.m2112load_3(c0186Scalar2.f1993s, 26) >> 2) & 2097151) + (jM2112load_3 * jM2112load_312) + (jM2113load_4 * jM2113load_411) + (jM2112load_32 * jM2112load_311) + (jM2113load_42 * jM2112load_310) + (jM2113load_43 * jM2113load_410) + (jM2112load_33 * jM2112load_39) + (jM2113load_44 * jM2113load_49) + (jM2112load_34 * jM2113load_48) + (jM2112load_35 * jM2112load_38) + (jM2113load_45 * jM2113load_47) + (jM2112load_36 * jM2112load_37);
        long jM2113load_418 = (FieldElement.m2113load_4(c0186Scalar2.f1993s, 28) >> 7) + (jM2112load_3 * jM2113load_412) + (jM2113load_4 * jM2112load_312) + (jM2112load_32 * jM2113load_411) + (jM2113load_42 * jM2112load_311) + (jM2113load_43 * jM2112load_310) + (jM2112load_33 * jM2113load_410) + (jM2113load_44 * jM2112load_39) + (jM2112load_34 * jM2113load_49) + (jM2112load_35 * jM2113load_48) + (jM2113load_45 * jM2112load_38) + (jM2112load_36 * jM2113load_47) + (jM2112load_37 * jM2113load_46);
        long j9 = (jM2113load_4 * jM2113load_412) + (jM2112load_32 * jM2112load_312) + (jM2113load_42 * jM2113load_411) + (jM2113load_43 * jM2112load_311) + (jM2112load_33 * jM2112load_310) + (jM2113load_44 * jM2113load_410) + (jM2112load_34 * jM2112load_39) + (jM2112load_35 * jM2113load_49) + (jM2113load_45 * jM2113load_48) + (jM2112load_36 * jM2112load_38) + (jM2113load_47 * jM2113load_46);
        long j10 = (jM2112load_32 * jM2113load_412) + (jM2113load_42 * jM2112load_312) + (jM2113load_43 * jM2113load_411) + (jM2112load_33 * jM2112load_311) + (jM2113load_44 * jM2112load_310) + (jM2112load_34 * jM2113load_410) + (jM2112load_35 * jM2112load_39) + (jM2113load_45 * jM2113load_49) + (jM2112load_36 * jM2113load_48) + (jM2112load_38 * jM2113load_46);
        long j11 = (jM2113load_42 * jM2113load_412) + (jM2113load_43 * jM2112load_312) + (jM2112load_33 * jM2113load_411) + (jM2113load_44 * jM2112load_311) + (jM2112load_34 * jM2112load_310) + (jM2112load_35 * jM2113load_410) + (jM2113load_45 * jM2112load_39) + (jM2112load_36 * jM2113load_49) + (jM2113load_48 * jM2113load_46);
        long j12 = (jM2113load_43 * jM2113load_412) + (jM2112load_33 * jM2112load_312) + (jM2113load_44 * jM2113load_411) + (jM2112load_34 * jM2112load_311) + (jM2112load_35 * jM2112load_310) + (jM2113load_45 * jM2113load_410) + (jM2112load_36 * jM2112load_39) + (jM2113load_49 * jM2113load_46);
        long j13 = (jM2112load_33 * jM2113load_412) + (jM2113load_44 * jM2112load_312) + (jM2112load_34 * jM2113load_411) + (jM2112load_35 * jM2112load_311) + (jM2113load_45 * jM2112load_310) + (jM2112load_36 * jM2113load_410) + (jM2113load_46 * jM2112load_39);
        long j14 = (jM2113load_44 * jM2113load_412) + (jM2112load_34 * jM2112load_312) + (jM2112load_35 * jM2113load_411) + (jM2113load_45 * jM2112load_311) + (jM2112load_36 * jM2112load_310) + (jM2113load_46 * jM2113load_410);
        long j15 = (jM2112load_34 * jM2113load_412) + (jM2112load_35 * jM2112load_312) + (jM2113load_45 * jM2113load_411) + (jM2112load_36 * jM2112load_311) + (jM2113load_46 * jM2112load_310);
        long j16 = (jM2112load_35 * jM2113load_412) + (jM2113load_45 * jM2112load_312) + (jM2112load_36 * jM2113load_411) + (jM2113load_46 * jM2112load_311);
        long j17 = (jM2113load_45 * jM2113load_412) + (jM2112load_36 * jM2112load_312) + (jM2113load_411 * jM2113load_46);
        long j18 = (jM2112load_36 * jM2113load_412) + (jM2113load_46 * jM2112load_312);
        long j19 = jM2113load_46 * jM2113load_412;
        long j20 = (j + 1048576) >> 21;
        long j21 = j2 + j20;
        long j22 = j - (j20 << 21);
        long j23 = (j3 + 1048576) >> 21;
        long j24 = j4 + j23;
        long j25 = j3 - (j23 << 21);
        long j26 = (j5 + 1048576) >> 21;
        long j27 = j6 + j26;
        long j28 = j5 - (j26 << 21);
        long j29 = (j7 + 1048576) >> 21;
        long j30 = j8 + j29;
        long j31 = j7 - (j29 << 21);
        long j32 = (jM2112load_317 + 1048576) >> 21;
        long j33 = jM2113load_417 + j32;
        long j34 = jM2112load_317 - (j32 << 21);
        long j35 = (jM2112load_318 + 1048576) >> 21;
        long j36 = jM2113load_418 + j35;
        long j37 = jM2112load_318 - (j35 << 21);
        long j38 = (j9 + 1048576) >> 21;
        long j39 = j10 + j38;
        long j40 = j9 - (j38 << 21);
        long j41 = (j11 + 1048576) >> 21;
        long j42 = j12 + j41;
        long j43 = j11 - (j41 << 21);
        long j44 = (j13 + 1048576) >> 21;
        long j45 = j14 + j44;
        long j46 = j13 - (j44 << 21);
        long j47 = (j15 + 1048576) >> 21;
        long j48 = j16 + j47;
        long j49 = j15 - (j47 << 21);
        long j50 = (j17 + 1048576) >> 21;
        long j51 = j18 + j50;
        long j52 = j17 - (j50 << 21);
        long j53 = (j19 + 1048576) >> 21;
        long j54 = (j21 + 1048576) >> 21;
        long j55 = j25 + j54;
        long j56 = j21 - (j54 << 21);
        long j57 = (j24 + 1048576) >> 21;
        long j58 = j28 + j57;
        long j59 = j24 - (j57 << 21);
        long j60 = (j27 + 1048576) >> 21;
        long j61 = j31 + j60;
        long j62 = j27 - (j60 << 21);
        long j63 = (j30 + 1048576) >> 21;
        long j64 = j34 + j63;
        long j65 = j30 - (j63 << 21);
        long j66 = (j33 + 1048576) >> 21;
        long j67 = j37 + j66;
        long j68 = j33 - (j66 << 21);
        long j69 = (j36 + 1048576) >> 21;
        long j70 = j40 + j69;
        long j71 = j36 - (j69 << 21);
        long j72 = (j39 + 1048576) >> 21;
        long j73 = j43 + j72;
        long j74 = j39 - (j72 << 21);
        long j75 = (j42 + 1048576) >> 21;
        long j76 = j46 + j75;
        long j77 = j42 - (j75 << 21);
        long j78 = (j45 + 1048576) >> 21;
        long j79 = j49 + j78;
        long j80 = j45 - (j78 << 21);
        long j81 = (j48 + 1048576) >> 21;
        long j82 = j52 + j81;
        long j83 = j48 - (j81 << 21);
        long j84 = (j51 + 1048576) >> 21;
        long j85 = (j19 - (j53 << 21)) + j84;
        long j86 = j51 - (j84 << 21);
        long j87 = j76 - (j53 * 683901);
        long j88 = ((j73 - (j53 * 997805)) + (j85 * 136657)) - (j86 * 683901);
        long j89 = ((((j70 + (j53 * 470296)) + (j85 * 654183)) - (j86 * 997805)) + (j82 * 136657)) - (j83 * 683901);
        long j90 = j61 + (j79 * 666643);
        long j91 = j64 + (j82 * 666643) + (j83 * 470296) + (j79 * 654183);
        long j92 = ((((j67 + (j85 * 666643)) + (j86 * 470296)) + (j82 * 654183)) - (j83 * 997805)) + (j79 * 136657);
        long j93 = (j90 + 1048576) >> 21;
        long j94 = j65 + (j83 * 666643) + (j79 * 470296) + j93;
        long j95 = j90 - (j93 << 21);
        long j96 = (j91 + 1048576) >> 21;
        long j97 = ((((j68 + (j86 * 666643)) + (j82 * 470296)) + (j83 * 654183)) - (j79 * 997805)) + j96;
        long j98 = j91 - (j96 << 21);
        long j99 = (j92 + 1048576) >> 21;
        long j100 = ((((((j71 + (j53 * 666643)) + (j85 * 470296)) + (j86 * 654183)) - (j82 * 997805)) + (j83 * 136657)) - (j79 * 683901)) + j99;
        long j101 = j92 - (j99 << 21);
        long j102 = (j89 + 1048576) >> 21;
        long j103 = ((((j74 + (j53 * 654183)) - (j85 * 997805)) + (j86 * 136657)) - (j82 * 683901)) + j102;
        long j104 = j89 - (j102 << 21);
        long j105 = (j88 + 1048576) >> 21;
        long j106 = ((j77 + (j53 * 136657)) - (j85 * 683901)) + j105;
        long j107 = j88 - (j105 << 21);
        long j108 = (j87 + 1048576) >> 21;
        long j109 = j80 + j108;
        long j110 = j87 - (j108 << 21);
        long j111 = (j94 + 1048576) >> 21;
        long j112 = j98 + j111;
        long j113 = j94 - (j111 << 21);
        long j114 = (j97 + 1048576) >> 21;
        long j115 = j101 + j114;
        long j116 = j97 - (j114 << 21);
        long j117 = (j100 + 1048576) >> 21;
        long j118 = j104 + j117;
        long j119 = j100 - (j117 << 21);
        long j120 = (j103 + 1048576) >> 21;
        long j121 = j107 + j120;
        long j122 = j103 - (j120 << 21);
        long j123 = (j106 + 1048576) >> 21;
        long j124 = j110 + j123;
        long j125 = j106 - (j123 << 21);
        long j126 = j115 - (j109 * 683901);
        long j127 = (j116 + (j109 * 136657)) - (j124 * 683901);
        long j128 = ((j113 + (j109 * 654183)) - (j124 * 997805)) + (j125 * 136657);
        long j129 = ((j112 - (j109 * 997805)) + (j124 * 136657)) - (j125 * 683901);
        long j130 = ((((j62 + (j109 * 666643)) + (j124 * 470296)) + (j125 * 654183)) - (j121 * 997805)) + (j122 * 136657);
        long j131 = ((((j95 + (j109 * 470296)) + (j124 * 654183)) - (j125 * 997805)) + (j121 * 136657)) - (j122 * 683901);
        long j132 = j22 + (j118 * 666643);
        long j133 = j55 + (j121 * 666643) + (j122 * 470296) + (j118 * 654183);
        long j134 = ((((j58 + (j124 * 666643)) + (j125 * 470296)) + (j121 * 654183)) - (j122 * 997805)) + (j118 * 136657);
        long j135 = (j132 + 1048576) >> 21;
        long j136 = j56 + (j122 * 666643) + (j118 * 470296) + j135;
        long j137 = j132 - (j135 << 21);
        long j138 = (j133 + 1048576) >> 21;
        long j139 = ((((j59 + (j125 * 666643)) + (j121 * 470296)) + (j122 * 654183)) - (j118 * 997805)) + j138;
        long j140 = j133 - (j138 << 21);
        long j141 = (j134 + 1048576) >> 21;
        long j142 = (j130 - (j118 * 683901)) + j141;
        long j143 = j134 - (j141 << 21);
        long j144 = (j131 + 1048576) >> 21;
        long j145 = (j128 - (j121 * 683901)) + j144;
        long j146 = j131 - (j144 << 21);
        long j147 = (j129 + 1048576) >> 21;
        long j148 = j127 + j147;
        long j149 = j129 - (j147 << 21);
        long j150 = (j126 + 1048576) >> 21;
        long j151 = j119 + j150;
        long j152 = j126 - (j150 << 21);
        long j153 = (j136 + 1048576) >> 21;
        long j154 = j140 + j153;
        long j155 = j136 - (j153 << 21);
        long j156 = (j139 + 1048576) >> 21;
        long j157 = j143 + j156;
        long j158 = j139 - (j156 << 21);
        long j159 = (j142 + 1048576) >> 21;
        long j160 = j146 + j159;
        long j161 = j142 - (j159 << 21);
        long j162 = (j145 + 1048576) >> 21;
        long j163 = j149 + j162;
        long j164 = j145 - (j162 << 21);
        long j165 = (j148 + 1048576) >> 21;
        long j166 = j152 + j165;
        long j167 = j148 - (j165 << 21);
        long j168 = (j151 + 1048576) >> 21;
        long j169 = j137 + (j168 * 666643);
        long j170 = j169 >> 21;
        long j171 = j155 + (j168 * 470296) + j170;
        long j172 = j169 - (j170 << 21);
        long j173 = j171 >> 21;
        long j174 = j154 + (j168 * 654183) + j173;
        long j175 = j171 - (j173 << 21);
        long j176 = j174 >> 21;
        long j177 = (j158 - (j168 * 997805)) + j176;
        long j178 = j174 - (j176 << 21);
        long j179 = j177 >> 21;
        long j180 = j157 + (j168 * 136657) + j179;
        long j181 = j177 - (j179 << 21);
        long j182 = j180 >> 21;
        long j183 = (j161 - (j168 * 683901)) + j182;
        long j184 = j180 - (j182 << 21);
        long j185 = j183 >> 21;
        long j186 = j160 + j185;
        long j187 = j183 - (j185 << 21);
        long j188 = j186 >> 21;
        long j189 = j164 + j188;
        long j190 = j186 - (j188 << 21);
        long j191 = j189 >> 21;
        long j192 = j163 + j191;
        long j193 = j189 - (j191 << 21);
        long j194 = j192 >> 21;
        long j195 = j167 + j194;
        long j196 = j192 - (j194 << 21);
        long j197 = j195 >> 21;
        long j198 = j166 + j197;
        long j199 = j195 - (j197 << 21);
        long j200 = j198 >> 21;
        long j201 = (j151 - (j168 << 21)) + j200;
        long j202 = j198 - (j200 << 21);
        long j203 = j201 >> 21;
        long j204 = j201 - (j203 << 21);
        long j205 = j172 + (666643 * j203);
        long j206 = j175 + (470296 * j203);
        long j207 = j178 + (654183 * j203);
        long j208 = j181 - (997805 * j203);
        long j209 = j184 + (136657 * j203);
        long j210 = j187 - (j203 * 683901);
        long j211 = j205 >> 21;
        long j212 = j206 + j211;
        long j213 = j205 - (j211 << 21);
        long j214 = j212 >> 21;
        long j215 = j207 + j214;
        long j216 = j212 - (j214 << 21);
        long j217 = j215 >> 21;
        long j218 = j208 + j217;
        long j219 = j215 - (j217 << 21);
        long j220 = j218 >> 21;
        long j221 = j209 + j220;
        long j222 = j218 - (j220 << 21);
        long j223 = j221 >> 21;
        long j224 = j210 + j223;
        long j225 = j221 - (j223 << 21);
        long j226 = j224 >> 21;
        long j227 = j190 + j226;
        long j228 = j224 - (j226 << 21);
        long j229 = j227 >> 21;
        long j230 = j193 + j229;
        long j231 = j227 - (j229 << 21);
        long j232 = j230 >> 21;
        long j233 = j196 + j232;
        long j234 = j230 - (j232 << 21);
        long j235 = j233 >> 21;
        long j236 = j199 + j235;
        long j237 = j233 - (j235 << 21);
        long j238 = j236 >> 21;
        long j239 = j202 + j238;
        long j240 = j236 - (j238 << 21);
        long j241 = j239 >> 21;
        long j242 = j204 + j241;
        long j243 = j239 - (j241 << 21);
        return new C0186Scalar(new byte[]{(byte) j213, (byte) (j213 >> 8), (byte) ((j213 >> 16) | (j216 << 5)), (byte) (j216 >> 3), (byte) (j216 >> 11), (byte) ((j216 >> 19) | (j219 << 2)), (byte) (j219 >> 6), (byte) ((j219 >> 14) | (j222 << 7)), (byte) (j222 >> serialVersionUID), (byte) (j222 >> 9), (byte) ((j222 >> 17) | (j225 << 4)), (byte) (j225 >> 4), (byte) (j225 >> 12), (byte) ((j225 >> 20) | (j228 << serialVersionUID)), (byte) (j228 >> 7), (byte) ((j228 >> 15) | (j231 << 6)), (byte) (j231 >> 2), (byte) (j231 >> 10), (byte) ((j231 >> 18) | (j234 << 3)), (byte) (j234 >> 5), (byte) (j234 >> 13), (byte) j237, (byte) (j237 >> 8), (byte) ((j237 >> 16) | (j240 << 5)), (byte) (j240 >> 3), (byte) (j240 >> 11), (byte) ((j240 >> 19) | (j243 << 2)), (byte) (j243 >> 6), (byte) ((j243 >> 14) | (j242 << 7)), (byte) (j242 >> serialVersionUID), (byte) (j242 >> 9), (byte) (j242 >> 17)});
    }

    public byte[] nonAdjacentForm() {
        int i;
        byte[] bArr = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            bArr[i2] = (byte) (1 & (this.f1993s[i2 >> 3] >> (i2 & 7)));
        }
        for (int i3 = 0; i3 < 256; i3++) {
            if (bArr[i3] != 0) {
                for (int i4 = 1; i4 <= 6 && (i = i3 + i4) < 256; i4++) {
                    byte b = bArr[i];
                    if (b != 0) {
                        byte b2 = bArr[i3];
                        if ((b << i4) + b2 <= 15) {
                            bArr[i3] = (byte) (b2 + (b << i4));
                            bArr[i] = 0;
                        } else if (b2 - (b << i4) >= -15) {
                            bArr[i3] = (byte) (b2 - (b << i4));
                            while (true) {
                                if (i >= 256) {
                                    break;
                                }
                                if (bArr[i] == 0) {
                                    bArr[i] = 1;
                                    break;
                                }
                                bArr[i] = 0;
                                i++;
                            }
                        }
                    }
                }
            }
        }
        return bArr;
    }

    /* renamed from: reduce */
    public C0186Scalar m2134reduce() {
        return m2131reduce(this.f1993s);
    }

    public C0186Scalar subtract(C0186Scalar c0186Scalar) {
        return new C0186Scalar(UnpackedScalar.fromByteArray(this.f1993s).subtract(UnpackedScalar.fromByteArray(c0186Scalar.f1993s)).toByteArray());
    }

    public byte[] toByteArray() {
        byte[] bArr = this.f1993s;
        return Arrays.copyOf(bArr, bArr.length);
    }

    public byte[] toRadix16() {
        byte[] bArr = new byte[64];
        int i = 0;
        for (int i2 = 0; i2 < 32; i2++) {
            int i3 = i2 * 2;
            byte[] bArr2 = this.f1993s;
            bArr[i3] = (byte) (bArr2[i2] & 15);
            bArr[i3 + 1] = (byte) ((bArr2[i2] >> 4) & 15);
        }
        int i4 = 0;
        while (i < 63) {
            byte b = (byte) (bArr[i] + i4);
            bArr[i] = b;
            int i5 = (b + 8) >> 4;
            bArr[i] = (byte) (b - (i5 << 4));
            i++;
            i4 = i5;
        }
        bArr[63] = (byte) (bArr[63] + i4);
        return bArr;
    }

    public String toString() {
        return "Scalar(" + StrUtils.bytesToHex(this.f1993s) + ")";
    }

    /* renamed from: reduce */
    public static C0186Scalar m2131reduce(byte[] bArr) {
        return new C0186Scalar(UnpackedScalar.montgomeryReduce(UnpackedScalar.fromByteArray(bArr).mulInternal(Constants.f1968R)).toByteArray());
    }
}
