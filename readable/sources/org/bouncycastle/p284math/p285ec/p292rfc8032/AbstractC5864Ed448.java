package org.bouncycastle.p284math.p285ec.p292rfc8032;

import java.security.SecureRandom;
import org.bouncycastle.p133asn1.InterfaceC5102BERTags;
import org.bouncycastle.p194crypto.InterfaceC5284Xof;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p284math.p285ec.p291rfc7748.AbstractC5861X448;
import org.bouncycastle.p284math.p285ec.p291rfc7748.X448Field;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p361util.Integers;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* renamed from: org.bouncycastle.math.ec.rfc8032.Ed448 */
/* loaded from: classes2.dex */
public abstract class AbstractC5864Ed448 {
    private static final int COORD_INTS = 14;

    /* renamed from: C_d */
    private static final int f22422C_d = 39081;
    private static final int POINT_BYTES = 57;
    private static final int PRECOMP_BLOCKS = 5;
    private static final int PRECOMP_MASK = 15;
    private static final int PRECOMP_POINTS = 16;
    private static final int PRECOMP_RANGE = 450;
    private static final int PRECOMP_SPACING = 18;
    private static final int PRECOMP_TEETH = 5;
    public static final int PREHASH_SIZE = 64;
    public static final int PUBLIC_KEY_SIZE = 57;
    private static final int SCALAR_BYTES = 57;
    private static final int SCALAR_INTS = 14;
    public static final int SECRET_KEY_SIZE = 57;
    public static final int SIGNATURE_SIZE = 114;
    private static final int WNAF_WIDTH_225 = 5;
    private static final int WNAF_WIDTH_BASE = 7;
    private static final byte[] DOM4_PREFIX = {83, 105, 103, 69, 100, 52, 52, 56};

    /* renamed from: P */
    private static final int[] f22423P = {-1, -1, -1, -1, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1};

    /* renamed from: B_x */
    private static final int[] f22420B_x = {118276190, 40534716, 9670182, 135141552, 85017403, 259173222, 68333082, 171784774, 174973732, 15824510, 73756743, 57518561, 94773951, 248652241, 107736333, 82941708};

    /* renamed from: B_y */
    private static final int[] f22421B_y = {36764180, 8885695, 130592152, 20104429, 163904957, 30304195, 121295871, 5901357, 125344798, 171541512, 175338348, 209069246, 3626697, 38307682, 24032956, 110359655};

    /* renamed from: B225_x */
    private static final int[] f22418B225_x = {110141154, 30892124, 160820362, 264558960, 217232225, 47722141, 19029845, 8326902, 183409749, 170134547, 90340180, 222600478, 61097333, 7431335, 198491505, 102372861};

    /* renamed from: B225_y */
    private static final int[] f22419B225_y = {221945828, 50763449, 132637478, 109250759, 216053960, 61612587, 50649998, 138339097, 98949899, 248139835, 186410297, 126520782, 47339196, 78164062, 198835543, 169622712};
    private static final Object PRECOMP_LOCK = new Object();
    private static PointAffine[] PRECOMP_BASE_WNAF = null;
    private static PointAffine[] PRECOMP_BASE225_WNAF = null;
    private static int[] PRECOMP_BASE_COMB = null;

    /* renamed from: org.bouncycastle.math.ec.rfc8032.Ed448$Algorithm */
    public static final class Algorithm {

        /* renamed from: Ed448 */
        public static final int f22424Ed448 = 0;

        /* renamed from: Ed448ph */
        public static final int f22425Ed448ph = 1;
    }

    /* renamed from: org.bouncycastle.math.ec.rfc8032.Ed448$F */
    public static class F extends X448Field {
        private F() {
        }
    }

    /* renamed from: org.bouncycastle.math.ec.rfc8032.Ed448$PointAffine */
    public static class PointAffine {

        /* renamed from: x */
        int[] f22426x;

        /* renamed from: y */
        int[] f22427y;

        private PointAffine() {
            this.f22426x = X448Field.m16825create();
            this.f22427y = X448Field.m16825create();
        }
    }

    /* renamed from: org.bouncycastle.math.ec.rfc8032.Ed448$PointProjective */
    public static class PointProjective {

        /* renamed from: x */
        int[] f22428x;

        /* renamed from: y */
        int[] f22429y;

        /* renamed from: z */
        int[] f22430z;

        private PointProjective() {
            this.f22428x = X448Field.m16825create();
            this.f22429y = X448Field.m16825create();
            this.f22430z = X448Field.m16825create();
        }
    }

    /* renamed from: org.bouncycastle.math.ec.rfc8032.Ed448$PointTemp */
    public static class PointTemp {

        /* renamed from: r0 */
        int[] f22431r0;

        /* renamed from: r1 */
        int[] f22432r1;

        /* renamed from: r2 */
        int[] f22433r2;

        /* renamed from: r3 */
        int[] f22434r3;

        /* renamed from: r4 */
        int[] f22435r4;

        /* renamed from: r5 */
        int[] f22436r5;

        /* renamed from: r6 */
        int[] f22437r6;

        /* renamed from: r7 */
        int[] f22438r7;

        private PointTemp() {
            this.f22431r0 = X448Field.m16825create();
            this.f22432r1 = X448Field.m16825create();
            this.f22433r2 = X448Field.m16825create();
            this.f22434r3 = X448Field.m16825create();
            this.f22435r4 = X448Field.m16825create();
            this.f22436r5 = X448Field.m16825create();
            this.f22437r6 = X448Field.m16825create();
            this.f22438r7 = X448Field.m16825create();
        }
    }

    /* renamed from: org.bouncycastle.math.ec.rfc8032.Ed448$PublicPoint */
    public static final class PublicPoint {

        /* renamed from: data */
        final int[] f22439data;

        public PublicPoint(int[] iArr) {
            this.f22439data = iArr;
        }
    }

    private static byte[] calculateS(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int[] iArr = new int[28];
        Scalar448.m16866decode(bArr, iArr);
        int[] iArr2 = new int[14];
        Scalar448.m16866decode(bArr2, iArr2);
        int[] iArr3 = new int[14];
        Scalar448.m16866decode(bArr3, iArr3);
        AbstractC5869Nat.mulAddTo(14, iArr2, iArr3, iArr);
        byte[] bArr4 = new byte[114];
        AbstractC5862Codec.encode32(iArr, 0, 28, bArr4, 0);
        return Scalar448.reduce912(bArr4);
    }

    private static boolean checkContextVar(byte[] bArr) {
        return bArr != null && bArr.length < 256;
    }

    private static int checkPoint(PointAffine pointAffine) {
        int[] iArrM16825create = X448Field.m16825create();
        int[] iArrM16825create2 = X448Field.m16825create();
        int[] iArrM16825create3 = X448Field.m16825create();
        X448Field.m16845sqr(pointAffine.f22426x, iArrM16825create2);
        X448Field.m16845sqr(pointAffine.f22427y, iArrM16825create3);
        X448Field.m16840mul(iArrM16825create2, iArrM16825create3, iArrM16825create);
        X448Field.m16818add(iArrM16825create2, iArrM16825create3, iArrM16825create2);
        X448Field.m16839mul(iArrM16825create, f22422C_d, iArrM16825create);
        X448Field.m16847subOne(iArrM16825create);
        X448Field.m16818add(iArrM16825create, iArrM16825create2, iArrM16825create);
        X448Field.normalize(iArrM16825create);
        X448Field.normalize(iArrM16825create3);
        return X448Field.m16838isZero(iArrM16825create) & (~X448Field.m16838isZero(iArrM16825create3));
    }

    private static boolean checkPointFullVar(byte[] bArr) {
        if ((bArr[56] & ByteCompanionObject.MAX_VALUE) != 0) {
            return false;
        }
        int iDecode32 = AbstractC5862Codec.decode32(bArr, 52);
        int i = f22423P[13] ^ iDecode32;
        for (int i2 = 12; i2 > 0; i2--) {
            int iDecode322 = AbstractC5862Codec.decode32(bArr, i2 * 4);
            if (i == 0 && Integers.compareUnsigned(iDecode322, f22423P[i2]) > 0) {
                return false;
            }
            iDecode32 |= iDecode322;
            i |= iDecode322 ^ f22423P[i2];
        }
        int iDecode323 = AbstractC5862Codec.decode32(bArr, 0);
        if (iDecode32 != 0 || Integers.compareUnsigned(iDecode323, 1) > 0) {
            return i != 0 || Integers.compareUnsigned(iDecode323, f22423P[0] - 1) < 0;
        }
        return false;
    }

    private static boolean checkPointOrderVar(PointAffine pointAffine) {
        PointProjective pointProjective = new PointProjective();
        scalarMultOrderVar(pointAffine, pointProjective);
        return normalizeToNeutralElementVar(pointProjective);
    }

    private static boolean checkPointVar(byte[] bArr) {
        if ((bArr[56] & ByteCompanionObject.MAX_VALUE) != 0) {
            return false;
        }
        if (AbstractC5862Codec.decode32(bArr, 52) != f22423P[13]) {
            return true;
        }
        AbstractC5862Codec.decode32(bArr, 0, new int[14], 0, 14);
        return !AbstractC5869Nat.m16921gte(14, r3, r2);
    }

    /* renamed from: copy */
    private static byte[] m16859copy(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static InterfaceC5284Xof createPrehash() {
        return createXof();
    }

    private static InterfaceC5284Xof createXof() {
        return new SHAKEDigest(256);
    }

    private static boolean decodePointVar(byte[] bArr, boolean z, PointAffine pointAffine) {
        int i = (bArr[56] & ByteCompanionObject.MIN_VALUE) >>> 7;
        X448Field.decode448(bArr, pointAffine.f22427y);
        int[] iArrM16825create = X448Field.m16825create();
        int[] iArrM16825create2 = X448Field.m16825create();
        X448Field.m16845sqr(pointAffine.f22427y, iArrM16825create);
        X448Field.m16839mul(iArrM16825create, f22422C_d, iArrM16825create2);
        X448Field.m16841negate(iArrM16825create, iArrM16825create);
        X448Field.m16819addOne(iArrM16825create);
        X448Field.m16819addOne(iArrM16825create2);
        if (!X448Field.sqrtRatioVar(iArrM16825create, iArrM16825create2, pointAffine.f22426x)) {
            return false;
        }
        X448Field.normalize(pointAffine.f22426x);
        if (i == 1 && X448Field.isZeroVar(pointAffine.f22426x)) {
            return false;
        }
        int[] iArr = pointAffine.f22426x;
        if (z ^ (i != (iArr[0] & 1))) {
            X448Field.m16841negate(iArr, iArr);
            X448Field.normalize(pointAffine.f22426x);
        }
        return true;
    }

    /* renamed from: dom4 */
    private static void m16860dom4(InterfaceC5284Xof interfaceC5284Xof, byte b, byte[] bArr) {
        byte[] bArr2 = DOM4_PREFIX;
        int length = bArr2.length;
        int i = length + 2;
        int length2 = bArr.length + i;
        byte[] bArr3 = new byte[length2];
        System.arraycopy(bArr2, 0, bArr3, 0, length);
        bArr3[length] = b;
        bArr3[length + 1] = (byte) bArr.length;
        System.arraycopy(bArr, 0, bArr3, i, bArr.length);
        interfaceC5284Xof.mo14970update(bArr3, 0, length2);
    }

    private static void encodePoint(PointAffine pointAffine, byte[] bArr, int i) {
        X448Field.m16833encode(pointAffine.f22427y, bArr, i);
        bArr[i + 56] = (byte) ((pointAffine.f22426x[0] & 1) << 7);
    }

    public static void encodePublicPoint(PublicPoint publicPoint, byte[] bArr, int i) {
        X448Field.m16831encode(publicPoint.f22439data, 16, bArr, i);
        bArr[i + 56] = (byte) ((publicPoint.f22439data[0] & 1) << 7);
    }

    private static int encodeResult(PointProjective pointProjective, byte[] bArr, int i) {
        PointAffine pointAffine = new PointAffine();
        normalizeToAffine(pointProjective, pointAffine);
        int iCheckPoint = checkPoint(pointAffine);
        encodePoint(pointAffine, bArr, i);
        return iCheckPoint;
    }

    private static PublicPoint exportPoint(PointAffine pointAffine) {
        int[] iArr = new int[32];
        X448Field.m16824copy(pointAffine.f22426x, 0, iArr, 0);
        X448Field.m16824copy(pointAffine.f22427y, 0, iArr, 16);
        return new PublicPoint(iArr);
    }

    public static void generatePrivateKey(SecureRandom secureRandom, byte[] bArr) {
        if (bArr.length != 57) {
            throw new IllegalArgumentException("k");
        }
        secureRandom.nextBytes(bArr);
    }

    public static PublicPoint generatePublicKey(byte[] bArr, int i) {
        InterfaceC5284Xof interfaceC5284XofCreateXof = createXof();
        byte[] bArr2 = new byte[114];
        interfaceC5284XofCreateXof.mo14970update(bArr, i, 57);
        interfaceC5284XofCreateXof.mo14998doFinal(bArr2, 0, 114);
        byte[] bArr3 = new byte[57];
        pruneScalar(bArr2, 0, bArr3);
        PointProjective pointProjective = new PointProjective();
        scalarMultBase(bArr3, pointProjective);
        PointAffine pointAffine = new PointAffine();
        normalizeToAffine(pointProjective, pointAffine);
        if (checkPoint(pointAffine) != 0) {
            return exportPoint(pointAffine);
        }
        throw new IllegalStateException();
    }

    private static int getWindow4(int[] iArr, int i) {
        return (iArr[i >>> 3] >>> ((i & 7) << 2)) & 15;
    }

    private static void implSign(InterfaceC5284Xof interfaceC5284Xof, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4, byte b, byte[] bArr5, int i2, int i3, byte[] bArr6, int i4) {
        m16860dom4(interfaceC5284Xof, b, bArr4);
        interfaceC5284Xof.mo14970update(bArr, 57, 57);
        interfaceC5284Xof.mo14970update(bArr5, i2, i3);
        interfaceC5284Xof.mo14998doFinal(bArr, 0, bArr.length);
        byte[] bArrReduce912 = Scalar448.reduce912(bArr);
        byte[] bArr7 = new byte[57];
        scalarMultBaseEncoded(bArrReduce912, bArr7, 0);
        m16860dom4(interfaceC5284Xof, b, bArr4);
        interfaceC5284Xof.mo14970update(bArr7, 0, 57);
        interfaceC5284Xof.mo14970update(bArr3, i, 57);
        interfaceC5284Xof.mo14970update(bArr5, i2, i3);
        interfaceC5284Xof.mo14998doFinal(bArr, 0, bArr.length);
        byte[] bArrCalculateS = calculateS(bArrReduce912, Scalar448.reduce912(bArr), bArr2);
        System.arraycopy(bArr7, 0, bArr6, i4, 57);
        System.arraycopy(bArrCalculateS, 0, bArr6, i4 + 57, 57);
    }

    private static boolean implVerify(byte[] bArr, int i, PublicPoint publicPoint, byte[] bArr2, byte b, byte[] bArr3, int i2, int i3) {
        if (!checkContextVar(bArr2)) {
            throw new IllegalArgumentException("ctx");
        }
        byte[] bArrM16859copy = m16859copy(bArr, i, 57);
        byte[] bArrM16859copy2 = m16859copy(bArr, i + 57, 57);
        if (!checkPointVar(bArrM16859copy)) {
            return false;
        }
        int[] iArr = new int[14];
        if (!Scalar448.checkVar(bArrM16859copy2, iArr)) {
            return false;
        }
        PointAffine pointAffine = new PointAffine();
        if (!decodePointVar(bArrM16859copy, true, pointAffine)) {
            return false;
        }
        PointAffine pointAffine2 = new PointAffine();
        X448Field.m16841negate(publicPoint.f22439data, pointAffine2.f22426x);
        X448Field.m16824copy(publicPoint.f22439data, 16, pointAffine2.f22427y, 0);
        byte[] bArr4 = new byte[57];
        encodePublicPoint(publicPoint, bArr4, 0);
        InterfaceC5284Xof interfaceC5284XofCreateXof = createXof();
        byte[] bArr5 = new byte[114];
        m16860dom4(interfaceC5284XofCreateXof, b, bArr2);
        interfaceC5284XofCreateXof.mo14970update(bArrM16859copy, 0, 57);
        interfaceC5284XofCreateXof.mo14970update(bArr4, 0, 57);
        interfaceC5284XofCreateXof.mo14970update(bArr3, i2, i3);
        interfaceC5284XofCreateXof.mo14998doFinal(bArr5, 0, 114);
        int[] iArr2 = new int[14];
        Scalar448.m16866decode(Scalar448.reduce912(bArr5), iArr2);
        int[] iArr3 = new int[8];
        int[] iArr4 = new int[8];
        if (!Scalar448.reduceBasisVar(iArr2, iArr3, iArr4)) {
            throw new IllegalStateException();
        }
        Scalar448.multiply225Var(iArr, iArr4, iArr);
        PointProjective pointProjective = new PointProjective();
        scalarMultStraus225Var(iArr, iArr3, pointAffine2, iArr4, pointAffine, pointProjective);
        return normalizeToNeutralElementVar(pointProjective);
    }

    private static void invertZs(PointProjective[] pointProjectiveArr) {
        int length = pointProjectiveArr.length;
        int[] iArrCreateTable = X448Field.createTable(length);
        int[] iArrM16825create = X448Field.m16825create();
        X448Field.m16824copy(pointProjectiveArr[0].f22430z, 0, iArrM16825create, 0);
        X448Field.m16824copy(iArrM16825create, 0, iArrCreateTable, 0);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i2 >= length) {
                break;
            }
            X448Field.m16840mul(iArrM16825create, pointProjectiveArr[i2].f22430z, iArrM16825create);
            X448Field.m16824copy(iArrM16825create, 0, iArrCreateTable, i2 * 16);
            i = i2;
        }
        X448Field.m16836invVar(iArrM16825create, iArrM16825create);
        int[] iArrM16825create2 = X448Field.m16825create();
        while (i > 0) {
            int i3 = i - 1;
            X448Field.m16824copy(iArrCreateTable, i3 * 16, iArrM16825create2, 0);
            X448Field.m16840mul(iArrM16825create2, iArrM16825create, iArrM16825create2);
            X448Field.m16840mul(iArrM16825create, pointProjectiveArr[i].f22430z, iArrM16825create);
            X448Field.m16824copy(iArrM16825create2, 0, pointProjectiveArr[i].f22430z, 0);
            i = i3;
        }
        X448Field.m16824copy(iArrM16825create, 0, pointProjectiveArr[0].f22430z, 0);
    }

    private static void normalizeToAffine(PointProjective pointProjective, PointAffine pointAffine) {
        X448Field.m16835inv(pointProjective.f22430z, pointAffine.f22427y);
        X448Field.m16840mul(pointAffine.f22427y, pointProjective.f22428x, pointAffine.f22426x);
        int[] iArr = pointAffine.f22427y;
        X448Field.m16840mul(iArr, pointProjective.f22429y, iArr);
        X448Field.normalize(pointAffine.f22426x);
        X448Field.normalize(pointAffine.f22427y);
    }

    private static boolean normalizeToNeutralElementVar(PointProjective pointProjective) {
        X448Field.normalize(pointProjective.f22428x);
        X448Field.normalize(pointProjective.f22429y);
        X448Field.normalize(pointProjective.f22430z);
        return X448Field.isZeroVar(pointProjective.f22428x) && !X448Field.isZeroVar(pointProjective.f22429y) && X448Field.areEqualVar(pointProjective.f22429y, pointProjective.f22430z);
    }

    private static void pointAdd(PointAffine pointAffine, PointProjective pointProjective, PointTemp pointTemp) {
        int[] iArr = pointTemp.f22432r1;
        int[] iArr2 = pointTemp.f22433r2;
        int[] iArr3 = pointTemp.f22434r3;
        int[] iArr4 = pointTemp.f22435r4;
        int[] iArr5 = pointTemp.f22436r5;
        int[] iArr6 = pointTemp.f22437r6;
        int[] iArr7 = pointTemp.f22438r7;
        X448Field.m16845sqr(pointProjective.f22430z, iArr);
        X448Field.m16840mul(pointAffine.f22426x, pointProjective.f22428x, iArr2);
        X448Field.m16840mul(pointAffine.f22427y, pointProjective.f22429y, iArr3);
        X448Field.m16840mul(iArr2, iArr3, iArr4);
        X448Field.m16839mul(iArr4, f22422C_d, iArr4);
        X448Field.m16818add(iArr, iArr4, iArr5);
        X448Field.m16846sub(iArr, iArr4, iArr6);
        X448Field.m16818add(pointAffine.f22427y, pointAffine.f22426x, iArr7);
        X448Field.m16818add(pointProjective.f22429y, pointProjective.f22428x, iArr4);
        X448Field.m16840mul(iArr7, iArr4, iArr7);
        X448Field.m16818add(iArr3, iArr2, iArr);
        X448Field.m16846sub(iArr3, iArr2, iArr4);
        X448Field.m16821carry(iArr);
        X448Field.m16846sub(iArr7, iArr, iArr7);
        X448Field.m16840mul(iArr7, pointProjective.f22430z, iArr7);
        X448Field.m16840mul(iArr4, pointProjective.f22430z, iArr4);
        X448Field.m16840mul(iArr5, iArr7, pointProjective.f22428x);
        X448Field.m16840mul(iArr4, iArr6, pointProjective.f22429y);
        X448Field.m16840mul(iArr5, iArr6, pointProjective.f22430z);
    }

    private static void pointAddVar(boolean z, PointAffine pointAffine, PointProjective pointProjective, PointTemp pointTemp) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] iArr5 = pointTemp.f22432r1;
        int[] iArr6 = pointTemp.f22433r2;
        int[] iArr7 = pointTemp.f22434r3;
        int[] iArr8 = pointTemp.f22435r4;
        int[] iArr9 = pointTemp.f22436r5;
        int[] iArr10 = pointTemp.f22437r6;
        int[] iArr11 = pointTemp.f22438r7;
        if (z) {
            X448Field.m16846sub(pointAffine.f22427y, pointAffine.f22426x, iArr11);
            iArr2 = iArr5;
            iArr = iArr8;
            iArr4 = iArr9;
            iArr3 = iArr10;
        } else {
            X448Field.m16818add(pointAffine.f22427y, pointAffine.f22426x, iArr11);
            iArr = iArr5;
            iArr2 = iArr8;
            iArr3 = iArr9;
            iArr4 = iArr10;
        }
        X448Field.m16845sqr(pointProjective.f22430z, iArr5);
        X448Field.m16840mul(pointAffine.f22426x, pointProjective.f22428x, iArr6);
        X448Field.m16840mul(pointAffine.f22427y, pointProjective.f22429y, iArr7);
        X448Field.m16840mul(iArr6, iArr7, iArr8);
        X448Field.m16839mul(iArr8, f22422C_d, iArr8);
        X448Field.m16818add(iArr5, iArr8, iArr3);
        X448Field.m16846sub(iArr5, iArr8, iArr4);
        X448Field.m16818add(pointProjective.f22429y, pointProjective.f22428x, iArr8);
        X448Field.m16840mul(iArr11, iArr8, iArr11);
        X448Field.m16818add(iArr7, iArr6, iArr);
        X448Field.m16846sub(iArr7, iArr6, iArr2);
        X448Field.m16821carry(iArr);
        X448Field.m16846sub(iArr11, iArr5, iArr11);
        X448Field.m16840mul(iArr11, pointProjective.f22430z, iArr11);
        X448Field.m16840mul(iArr8, pointProjective.f22430z, iArr8);
        X448Field.m16840mul(iArr9, iArr11, pointProjective.f22428x);
        X448Field.m16840mul(iArr8, iArr10, pointProjective.f22429y);
        X448Field.m16840mul(iArr9, iArr10, pointProjective.f22430z);
    }

    private static void pointCopy(PointAffine pointAffine, PointProjective pointProjective) {
        X448Field.m16824copy(pointAffine.f22426x, 0, pointProjective.f22428x, 0);
        X448Field.m16824copy(pointAffine.f22427y, 0, pointProjective.f22429y, 0);
        X448Field.m16842one(pointProjective.f22430z);
    }

    private static void pointDouble(PointProjective pointProjective, PointTemp pointTemp) {
        int[] iArr = pointTemp.f22432r1;
        int[] iArr2 = pointTemp.f22433r2;
        int[] iArr3 = pointTemp.f22434r3;
        int[] iArr4 = pointTemp.f22435r4;
        int[] iArr5 = pointTemp.f22438r7;
        int[] iArr6 = pointTemp.f22431r0;
        X448Field.m16818add(pointProjective.f22428x, pointProjective.f22429y, iArr);
        X448Field.m16845sqr(iArr, iArr);
        X448Field.m16845sqr(pointProjective.f22428x, iArr2);
        X448Field.m16845sqr(pointProjective.f22429y, iArr3);
        X448Field.m16818add(iArr2, iArr3, iArr4);
        X448Field.m16821carry(iArr4);
        X448Field.m16845sqr(pointProjective.f22430z, iArr5);
        X448Field.m16818add(iArr5, iArr5, iArr5);
        X448Field.m16821carry(iArr5);
        X448Field.m16846sub(iArr4, iArr5, iArr6);
        X448Field.m16846sub(iArr, iArr4, iArr);
        X448Field.m16846sub(iArr2, iArr3, iArr2);
        X448Field.m16840mul(iArr, iArr6, pointProjective.f22428x);
        X448Field.m16840mul(iArr4, iArr2, pointProjective.f22429y);
        X448Field.m16840mul(iArr4, iArr6, pointProjective.f22430z);
    }

    private static void pointLookup(int i, int i2, PointAffine pointAffine) {
        int i3 = i * 512;
        for (int i4 = 0; i4 < 16; i4++) {
            int i5 = ((i4 ^ i2) - 1) >> 31;
            X448Field.m16822cmov(i5, PRECOMP_BASE_COMB, i3, pointAffine.f22426x, 0);
            X448Field.m16822cmov(i5, PRECOMP_BASE_COMB, i3 + 16, pointAffine.f22427y, 0);
            i3 += 32;
        }
    }

    private static void pointLookup15(int[] iArr, PointProjective pointProjective) {
        X448Field.m16824copy(iArr, 336, pointProjective.f22428x, 0);
        X448Field.m16824copy(iArr, 352, pointProjective.f22429y, 0);
        X448Field.m16824copy(iArr, 368, pointProjective.f22430z, 0);
    }

    private static void pointPrecompute(PointAffine pointAffine, PointProjective[] pointProjectiveArr, int i, int i2, PointTemp pointTemp) {
        PointProjective pointProjective = new PointProjective();
        pointCopy(pointAffine, pointProjective);
        pointDouble(pointProjective, pointTemp);
        PointProjective pointProjective2 = new PointProjective();
        pointProjectiveArr[i] = pointProjective2;
        pointCopy(pointAffine, pointProjective2);
        for (int i3 = 1; i3 < i2; i3++) {
            int i4 = i + i3;
            PointProjective pointProjective3 = new PointProjective();
            pointProjectiveArr[i4] = pointProjective3;
            pointCopy(pointProjectiveArr[i4 - 1], pointProjective3);
            pointAdd(pointProjective, pointProjectiveArr[i4], pointTemp);
        }
    }

    private static void pointSetNeutral(PointProjective pointProjective) {
        X448Field.m16848zero(pointProjective.f22428x);
        X448Field.m16842one(pointProjective.f22429y);
        X448Field.m16842one(pointProjective.f22430z);
    }

    public static void precompute() {
        int i;
        synchronized (PRECOMP_LOCK) {
            try {
                if (PRECOMP_BASE_COMB != null) {
                    return;
                }
                PointProjective[] pointProjectiveArr = new PointProjective[144];
                PointTemp pointTemp = new PointTemp();
                PointAffine pointAffine = new PointAffine();
                X448Field.m16824copy(f22420B_x, 0, pointAffine.f22426x, 0);
                X448Field.m16824copy(f22421B_y, 0, pointAffine.f22427y, 0);
                pointPrecompute(pointAffine, pointProjectiveArr, 0, 32, pointTemp);
                PointAffine pointAffine2 = new PointAffine();
                X448Field.m16824copy(f22418B225_x, 0, pointAffine2.f22426x, 0);
                X448Field.m16824copy(f22419B225_y, 0, pointAffine2.f22427y, 0);
                pointPrecompute(pointAffine2, pointProjectiveArr, 32, 32, pointTemp);
                PointProjective pointProjective = new PointProjective();
                pointCopy(pointAffine, pointProjective);
                int i2 = 5;
                PointProjective[] pointProjectiveArr2 = new PointProjective[5];
                for (int i3 = 0; i3 < 5; i3++) {
                    pointProjectiveArr2[i3] = new PointProjective();
                }
                int i4 = 0;
                int i5 = 64;
                while (i4 < i2) {
                    PointProjective pointProjective2 = new PointProjective();
                    int i6 = 0;
                    while (true) {
                        i = 1;
                        if (i6 >= i2) {
                            break;
                        }
                        if (i6 == 0) {
                            pointCopy(pointProjective, pointProjective2);
                        } else {
                            pointAdd(pointProjective, pointProjective2, pointTemp);
                        }
                        pointDouble(pointProjective, pointTemp);
                        pointCopy(pointProjective, pointProjectiveArr2[i6]);
                        if (i4 + i6 != 8) {
                            while (i < 18) {
                                pointDouble(pointProjective, pointTemp);
                                i++;
                            }
                        }
                        i6++;
                        i2 = 5;
                    }
                    int[] iArr = pointProjective2.f22428x;
                    X448Field.m16841negate(iArr, iArr);
                    pointProjectiveArr[i5] = pointProjective2;
                    i5++;
                    int i7 = 0;
                    while (i7 < 4) {
                        int i8 = i << i7;
                        int i9 = 0;
                        while (i9 < i8) {
                            PointProjective pointProjective3 = new PointProjective();
                            pointProjectiveArr[i5] = pointProjective3;
                            pointCopy(pointProjectiveArr[i5 - i8], pointProjective3);
                            pointAdd(pointProjectiveArr2[i7], pointProjectiveArr[i5], pointTemp);
                            i9++;
                            i5++;
                        }
                        i7++;
                        i = 1;
                    }
                    i4++;
                    i2 = 5;
                }
                invertZs(pointProjectiveArr);
                PRECOMP_BASE_WNAF = new PointAffine[32];
                for (int i10 = 0; i10 < 32; i10++) {
                    PointProjective pointProjective4 = pointProjectiveArr[i10];
                    PointAffine pointAffine3 = new PointAffine();
                    X448Field.m16840mul(pointProjective4.f22428x, pointProjective4.f22430z, pointAffine3.f22426x);
                    X448Field.normalize(pointAffine3.f22426x);
                    X448Field.m16840mul(pointProjective4.f22429y, pointProjective4.f22430z, pointAffine3.f22427y);
                    X448Field.normalize(pointAffine3.f22427y);
                    PRECOMP_BASE_WNAF[i10] = pointAffine3;
                }
                PRECOMP_BASE225_WNAF = new PointAffine[32];
                for (int i11 = 0; i11 < 32; i11++) {
                    PointProjective pointProjective5 = pointProjectiveArr[32 + i11];
                    PointAffine pointAffine4 = new PointAffine();
                    X448Field.m16840mul(pointProjective5.f22428x, pointProjective5.f22430z, pointAffine4.f22426x);
                    X448Field.normalize(pointAffine4.f22426x);
                    X448Field.m16840mul(pointProjective5.f22429y, pointProjective5.f22430z, pointAffine4.f22427y);
                    X448Field.normalize(pointAffine4.f22427y);
                    PRECOMP_BASE225_WNAF[i11] = pointAffine4;
                }
                PRECOMP_BASE_COMB = X448Field.createTable(160);
                int i12 = 0;
                for (int i13 = 64; i13 < 144; i13++) {
                    PointProjective pointProjective6 = pointProjectiveArr[i13];
                    int[] iArr2 = pointProjective6.f22428x;
                    X448Field.m16840mul(iArr2, pointProjective6.f22430z, iArr2);
                    X448Field.normalize(pointProjective6.f22428x);
                    int[] iArr3 = pointProjective6.f22429y;
                    X448Field.m16840mul(iArr3, pointProjective6.f22430z, iArr3);
                    X448Field.normalize(pointProjective6.f22429y);
                    X448Field.m16824copy(pointProjective6.f22428x, 0, PRECOMP_BASE_COMB, i12);
                    X448Field.m16824copy(pointProjective6.f22429y, 0, PRECOMP_BASE_COMB, i12 + 16);
                    i12 += 32;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void pruneScalar(byte[] bArr, int i, byte[] bArr2) {
        System.arraycopy(bArr, i, bArr2, 0, 56);
        bArr2[0] = (byte) (bArr2[0] & 252);
        bArr2[55] = (byte) (bArr2[55] | ByteCompanionObject.MIN_VALUE);
        bArr2[56] = 0;
    }

    private static void scalarMult(byte[] bArr, PointProjective pointProjective, PointProjective pointProjective2) {
        int[] iArr = new int[15];
        Scalar448.m16866decode(bArr, iArr);
        Scalar448.toSignedDigits(449, iArr, iArr);
        PointProjective pointProjective3 = new PointProjective();
        PointTemp pointTemp = new PointTemp();
        int[] iArrPointPrecompute = pointPrecompute(pointProjective, 8, pointTemp);
        pointLookup15(iArrPointPrecompute, pointProjective2);
        pointAdd(pointProjective, pointProjective2, pointTemp);
        int i = 111;
        while (true) {
            pointLookup(iArr, i, iArrPointPrecompute, pointProjective3);
            pointAdd(pointProjective3, pointProjective2, pointTemp);
            i--;
            if (i < 0) {
                return;
            }
            for (int i2 = 0; i2 < 4; i2++) {
                pointDouble(pointProjective2, pointTemp);
            }
        }
    }

    private static void scalarMultBase(byte[] bArr, PointProjective pointProjective) {
        precompute();
        int[] iArr = new int[15];
        Scalar448.m16866decode(bArr, iArr);
        Scalar448.toSignedDigits(PRECOMP_RANGE, iArr, iArr);
        PointAffine pointAffine = new PointAffine();
        PointTemp pointTemp = new PointTemp();
        pointSetNeutral(pointProjective);
        int i = 17;
        while (true) {
            int i2 = i;
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = 0;
                for (int i5 = 0; i5 < 5; i5++) {
                    i4 = (i4 & (~(1 << i5))) ^ ((iArr[i2 >>> 5] >>> (i2 & 31)) << i5);
                    i2 += 18;
                }
                int i6 = (i4 >>> 4) & 1;
                pointLookup(i3, ((-i6) ^ i4) & 15, pointAffine);
                X448Field.m16823cnegate(i6, pointAffine.f22426x);
                pointAdd(pointAffine, pointProjective, pointTemp);
            }
            i--;
            if (i < 0) {
                return;
            } else {
                pointDouble(pointProjective, pointTemp);
            }
        }
    }

    private static void scalarMultBaseEncoded(byte[] bArr, byte[] bArr2, int i) {
        PointProjective pointProjective = new PointProjective();
        scalarMultBase(bArr, pointProjective);
        if (encodeResult(pointProjective, bArr2, i) == 0) {
            throw new IllegalStateException();
        }
    }

    public static void scalarMultBaseXY(AbstractC5861X448.Friend friend, byte[] bArr, int i, int[] iArr, int[] iArr2) {
        if (friend == null) {
            throw new NullPointerException("This method is only for use by X448");
        }
        byte[] bArr2 = new byte[57];
        pruneScalar(bArr, i, bArr2);
        PointProjective pointProjective = new PointProjective();
        scalarMultBase(bArr2, pointProjective);
        if (checkPoint(pointProjective) == 0) {
            throw new IllegalStateException();
        }
        X448Field.m16824copy(pointProjective.f22428x, 0, iArr, 0);
        X448Field.m16824copy(pointProjective.f22429y, 0, iArr2, 0);
    }

    private static void scalarMultOrderVar(PointAffine pointAffine, PointProjective pointProjective) {
        byte[] bArr = new byte[447];
        Scalar448.getOrderWnafVar(5, bArr);
        PointProjective[] pointProjectiveArr = new PointProjective[8];
        PointTemp pointTemp = new PointTemp();
        pointPrecompute(pointAffine, pointProjectiveArr, 0, 8, pointTemp);
        pointSetNeutral(pointProjective);
        int i = 446;
        while (true) {
            byte b = bArr[i];
            if (b != 0) {
                pointAddVar(b < 0, pointProjectiveArr[(b >> 1) ^ (b >> 31)], pointProjective, pointTemp);
            }
            i--;
            if (i < 0) {
                return;
            } else {
                pointDouble(pointProjective, pointTemp);
            }
        }
    }

    private static void scalarMultStraus225Var(int[] iArr, int[] iArr2, PointAffine pointAffine, int[] iArr3, PointAffine pointAffine2, PointProjective pointProjective) {
        int i;
        precompute();
        byte[] bArr = new byte[PRECOMP_RANGE];
        int i2 = 225;
        byte[] bArr2 = new byte[225];
        byte[] bArr3 = new byte[225];
        AbstractC5865Wnaf.getSignedVar(iArr, 7, bArr);
        AbstractC5865Wnaf.getSignedVar(iArr2, 5, bArr2);
        AbstractC5865Wnaf.getSignedVar(iArr3, 5, bArr3);
        PointProjective[] pointProjectiveArr = new PointProjective[8];
        PointProjective[] pointProjectiveArr2 = new PointProjective[8];
        PointTemp pointTemp = new PointTemp();
        pointPrecompute(pointAffine, pointProjectiveArr, 0, 8, pointTemp);
        pointPrecompute(pointAffine2, pointProjectiveArr2, 0, 8, pointTemp);
        pointSetNeutral(pointProjective);
        while (true) {
            i = i2 - 1;
            if (i < 0 || (bArr[i] | bArr[i2 + InterfaceC5102BERTags.f17976FLAGS] | bArr2[i] | bArr3[i]) != 0) {
                break;
            } else {
                i2 = i;
            }
        }
        while (i >= 0) {
            byte b = bArr[i];
            if (b != 0) {
                pointAddVar(b < 0, PRECOMP_BASE_WNAF[(b >> 1) ^ (b >> 31)], pointProjective, pointTemp);
            }
            byte b2 = bArr[i + 225];
            if (b2 != 0) {
                pointAddVar(b2 < 0, PRECOMP_BASE225_WNAF[(b2 >> 1) ^ (b2 >> 31)], pointProjective, pointTemp);
            }
            byte b3 = bArr2[i];
            if (b3 != 0) {
                pointAddVar(b3 < 0, pointProjectiveArr[(b3 >> 1) ^ (b3 >> 31)], pointProjective, pointTemp);
            }
            byte b4 = bArr3[i];
            if (b4 != 0) {
                pointAddVar(b4 < 0, pointProjectiveArr2[(b4 >> 1) ^ (b4 >> 31)], pointProjective, pointTemp);
            }
            pointDouble(pointProjective, pointTemp);
            i--;
        }
        pointDouble(pointProjective, pointTemp);
    }

    /* renamed from: sign */
    public static void m16861sign(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, int i4, byte[] bArr5, int i5) {
        implSign(bArr, i, bArr2, i2, bArr3, (byte) 0, bArr4, i3, i4, bArr5, i5);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, InterfaceC5284Xof interfaceC5284Xof, byte[] bArr4, int i3) {
        byte[] bArr5 = new byte[64];
        if (64 != interfaceC5284Xof.mo14998doFinal(bArr5, 0, 64)) {
            throw new IllegalArgumentException("ph");
        }
        implSign(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr5, 0, 64, bArr4, i3);
    }

    public static boolean validatePublicKeyFull(byte[] bArr, int i) {
        byte[] bArrM16859copy = m16859copy(bArr, i, 57);
        if (!checkPointFullVar(bArrM16859copy)) {
            return false;
        }
        PointAffine pointAffine = new PointAffine();
        if (decodePointVar(bArrM16859copy, false, pointAffine)) {
            return checkPointOrderVar(pointAffine);
        }
        return false;
    }

    public static PublicPoint validatePublicKeyFullExport(byte[] bArr, int i) {
        byte[] bArrM16859copy = m16859copy(bArr, i, 57);
        if (!checkPointFullVar(bArrM16859copy)) {
            return null;
        }
        PointAffine pointAffine = new PointAffine();
        if (decodePointVar(bArrM16859copy, false, pointAffine) && checkPointOrderVar(pointAffine)) {
            return exportPoint(pointAffine);
        }
        return null;
    }

    public static boolean validatePublicKeyPartial(byte[] bArr, int i) {
        byte[] bArrM16859copy = m16859copy(bArr, i, 57);
        if (checkPointFullVar(bArrM16859copy)) {
            return decodePointVar(bArrM16859copy, false, new PointAffine());
        }
        return false;
    }

    public static PublicPoint validatePublicKeyPartialExport(byte[] bArr, int i) {
        byte[] bArrM16859copy = m16859copy(bArr, i, 57);
        if (!checkPointFullVar(bArrM16859copy)) {
            return null;
        }
        PointAffine pointAffine = new PointAffine();
        if (decodePointVar(bArrM16859copy, false, pointAffine)) {
            return exportPoint(pointAffine);
        }
        return null;
    }

    /* renamed from: verify */
    public static boolean m16863verify(byte[] bArr, int i, PublicPoint publicPoint, byte[] bArr2, byte[] bArr3, int i2, int i3) {
        return implVerify(bArr, i, publicPoint, bArr2, (byte) 0, bArr3, i2, i3);
    }

    public static boolean verifyPrehash(byte[] bArr, int i, PublicPoint publicPoint, byte[] bArr2, InterfaceC5284Xof interfaceC5284Xof) {
        byte[] bArr3 = new byte[64];
        if (64 == interfaceC5284Xof.mo14998doFinal(bArr3, 0, 64)) {
            return implVerify(bArr, i, publicPoint, bArr2, (byte) 1, bArr3, 0, 64);
        }
        throw new IllegalArgumentException("ph");
    }

    private static int checkPoint(PointProjective pointProjective) {
        int[] iArrM16825create = X448Field.m16825create();
        int[] iArrM16825create2 = X448Field.m16825create();
        int[] iArrM16825create3 = X448Field.m16825create();
        int[] iArrM16825create4 = X448Field.m16825create();
        X448Field.m16845sqr(pointProjective.f22428x, iArrM16825create2);
        X448Field.m16845sqr(pointProjective.f22429y, iArrM16825create3);
        X448Field.m16845sqr(pointProjective.f22430z, iArrM16825create4);
        X448Field.m16840mul(iArrM16825create2, iArrM16825create3, iArrM16825create);
        X448Field.m16818add(iArrM16825create2, iArrM16825create3, iArrM16825create2);
        X448Field.m16840mul(iArrM16825create2, iArrM16825create4, iArrM16825create2);
        X448Field.m16845sqr(iArrM16825create4, iArrM16825create4);
        X448Field.m16839mul(iArrM16825create, f22422C_d, iArrM16825create);
        X448Field.m16846sub(iArrM16825create, iArrM16825create4, iArrM16825create);
        X448Field.m16818add(iArrM16825create, iArrM16825create2, iArrM16825create);
        X448Field.normalize(iArrM16825create);
        X448Field.normalize(iArrM16825create3);
        X448Field.normalize(iArrM16825create4);
        return X448Field.m16838isZero(iArrM16825create) & (~X448Field.m16838isZero(iArrM16825create3)) & (~X448Field.m16838isZero(iArrM16825create4));
    }

    public static void generatePublicKey(byte[] bArr, int i, byte[] bArr2, int i2) {
        InterfaceC5284Xof interfaceC5284XofCreateXof = createXof();
        byte[] bArr3 = new byte[114];
        interfaceC5284XofCreateXof.mo14970update(bArr, i, 57);
        interfaceC5284XofCreateXof.mo14998doFinal(bArr3, 0, 114);
        byte[] bArr4 = new byte[57];
        pruneScalar(bArr3, 0, bArr4);
        scalarMultBaseEncoded(bArr4, bArr2, i2);
    }

    private static void implSign(byte[] bArr, int i, byte[] bArr2, byte b, byte[] bArr3, int i2, int i3, byte[] bArr4, int i4) {
        if (!checkContextVar(bArr2)) {
            throw new IllegalArgumentException("ctx");
        }
        InterfaceC5284Xof interfaceC5284XofCreateXof = createXof();
        byte[] bArr5 = new byte[114];
        interfaceC5284XofCreateXof.mo14970update(bArr, i, 57);
        interfaceC5284XofCreateXof.mo14998doFinal(bArr5, 0, 114);
        byte[] bArr6 = new byte[57];
        pruneScalar(bArr5, 0, bArr6);
        byte[] bArr7 = new byte[57];
        scalarMultBaseEncoded(bArr6, bArr7, 0);
        implSign(interfaceC5284XofCreateXof, bArr5, bArr6, bArr7, 0, bArr2, b, bArr3, i2, i3, bArr4, i4);
    }

    private static boolean implVerify(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte b, byte[] bArr4, int i3, int i4) {
        if (!checkContextVar(bArr3)) {
            throw new IllegalArgumentException("ctx");
        }
        byte[] bArrM16859copy = m16859copy(bArr, i, 57);
        byte[] bArrM16859copy2 = m16859copy(bArr, i + 57, 57);
        byte[] bArrM16859copy3 = m16859copy(bArr2, i2, 57);
        if (!checkPointVar(bArrM16859copy)) {
            return false;
        }
        int[] iArr = new int[14];
        if (!Scalar448.checkVar(bArrM16859copy2, iArr) || !checkPointFullVar(bArrM16859copy3)) {
            return false;
        }
        PointAffine pointAffine = new PointAffine();
        if (!decodePointVar(bArrM16859copy, true, pointAffine)) {
            return false;
        }
        PointAffine pointAffine2 = new PointAffine();
        if (!decodePointVar(bArrM16859copy3, true, pointAffine2)) {
            return false;
        }
        InterfaceC5284Xof interfaceC5284XofCreateXof = createXof();
        byte[] bArr5 = new byte[114];
        m16860dom4(interfaceC5284XofCreateXof, b, bArr3);
        interfaceC5284XofCreateXof.mo14970update(bArrM16859copy, 0, 57);
        interfaceC5284XofCreateXof.mo14970update(bArrM16859copy3, 0, 57);
        interfaceC5284XofCreateXof.mo14970update(bArr4, i3, i4);
        interfaceC5284XofCreateXof.mo14998doFinal(bArr5, 0, 114);
        int[] iArr2 = new int[14];
        Scalar448.m16866decode(Scalar448.reduce912(bArr5), iArr2);
        int[] iArr3 = new int[8];
        int[] iArr4 = new int[8];
        if (!Scalar448.reduceBasisVar(iArr2, iArr3, iArr4)) {
            throw new IllegalStateException();
        }
        Scalar448.multiply225Var(iArr, iArr4, iArr);
        PointProjective pointProjective = new PointProjective();
        scalarMultStraus225Var(iArr, iArr3, pointAffine2, iArr4, pointAffine, pointProjective);
        return normalizeToNeutralElementVar(pointProjective);
    }

    private static void pointAdd(PointProjective pointProjective, PointProjective pointProjective2, PointTemp pointTemp) {
        int[] iArr = pointTemp.f22431r0;
        int[] iArr2 = pointTemp.f22432r1;
        int[] iArr3 = pointTemp.f22433r2;
        int[] iArr4 = pointTemp.f22434r3;
        int[] iArr5 = pointTemp.f22435r4;
        int[] iArr6 = pointTemp.f22436r5;
        int[] iArr7 = pointTemp.f22437r6;
        int[] iArr8 = pointTemp.f22438r7;
        X448Field.m16840mul(pointProjective.f22430z, pointProjective2.f22430z, iArr);
        X448Field.m16845sqr(iArr, iArr2);
        X448Field.m16840mul(pointProjective.f22428x, pointProjective2.f22428x, iArr3);
        X448Field.m16840mul(pointProjective.f22429y, pointProjective2.f22429y, iArr4);
        X448Field.m16840mul(iArr3, iArr4, iArr5);
        X448Field.m16839mul(iArr5, f22422C_d, iArr5);
        X448Field.m16818add(iArr2, iArr5, iArr6);
        X448Field.m16846sub(iArr2, iArr5, iArr7);
        X448Field.m16818add(pointProjective.f22429y, pointProjective.f22428x, iArr8);
        X448Field.m16818add(pointProjective2.f22429y, pointProjective2.f22428x, iArr5);
        X448Field.m16840mul(iArr8, iArr5, iArr8);
        X448Field.m16818add(iArr4, iArr3, iArr2);
        X448Field.m16846sub(iArr4, iArr3, iArr5);
        X448Field.m16821carry(iArr2);
        X448Field.m16846sub(iArr8, iArr2, iArr8);
        X448Field.m16840mul(iArr8, iArr, iArr8);
        X448Field.m16840mul(iArr5, iArr, iArr5);
        X448Field.m16840mul(iArr6, iArr8, pointProjective2.f22428x);
        X448Field.m16840mul(iArr5, iArr7, pointProjective2.f22429y);
        X448Field.m16840mul(iArr6, iArr7, pointProjective2.f22430z);
    }

    private static void pointAddVar(boolean z, PointProjective pointProjective, PointProjective pointProjective2, PointTemp pointTemp) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] iArr5 = pointTemp.f22431r0;
        int[] iArr6 = pointTemp.f22432r1;
        int[] iArr7 = pointTemp.f22433r2;
        int[] iArr8 = pointTemp.f22434r3;
        int[] iArr9 = pointTemp.f22435r4;
        int[] iArr10 = pointTemp.f22436r5;
        int[] iArr11 = pointTemp.f22437r6;
        int[] iArr12 = pointTemp.f22438r7;
        if (z) {
            X448Field.m16846sub(pointProjective.f22429y, pointProjective.f22428x, iArr12);
            iArr2 = iArr6;
            iArr = iArr9;
            iArr4 = iArr10;
            iArr3 = iArr11;
        } else {
            X448Field.m16818add(pointProjective.f22429y, pointProjective.f22428x, iArr12);
            iArr = iArr6;
            iArr2 = iArr9;
            iArr3 = iArr10;
            iArr4 = iArr11;
        }
        X448Field.m16840mul(pointProjective.f22430z, pointProjective2.f22430z, iArr5);
        X448Field.m16845sqr(iArr5, iArr6);
        X448Field.m16840mul(pointProjective.f22428x, pointProjective2.f22428x, iArr7);
        X448Field.m16840mul(pointProjective.f22429y, pointProjective2.f22429y, iArr8);
        X448Field.m16840mul(iArr7, iArr8, iArr9);
        X448Field.m16839mul(iArr9, f22422C_d, iArr9);
        X448Field.m16818add(iArr6, iArr9, iArr3);
        X448Field.m16846sub(iArr6, iArr9, iArr4);
        X448Field.m16818add(pointProjective2.f22429y, pointProjective2.f22428x, iArr9);
        X448Field.m16840mul(iArr12, iArr9, iArr12);
        X448Field.m16818add(iArr8, iArr7, iArr);
        X448Field.m16846sub(iArr8, iArr7, iArr2);
        X448Field.m16821carry(iArr);
        X448Field.m16846sub(iArr12, iArr6, iArr12);
        X448Field.m16840mul(iArr12, iArr5, iArr12);
        X448Field.m16840mul(iArr9, iArr5, iArr9);
        X448Field.m16840mul(iArr10, iArr12, pointProjective2.f22428x);
        X448Field.m16840mul(iArr9, iArr11, pointProjective2.f22429y);
        X448Field.m16840mul(iArr10, iArr11, pointProjective2.f22430z);
    }

    private static void pointCopy(PointProjective pointProjective, PointProjective pointProjective2) {
        X448Field.m16824copy(pointProjective.f22428x, 0, pointProjective2.f22428x, 0);
        X448Field.m16824copy(pointProjective.f22429y, 0, pointProjective2.f22429y, 0);
        X448Field.m16824copy(pointProjective.f22430z, 0, pointProjective2.f22430z, 0);
    }

    private static void pointLookup(int[] iArr, int i, int[] iArr2, PointProjective pointProjective) {
        int window4 = getWindow4(iArr, i);
        int i2 = (window4 >>> 3) ^ 1;
        int i3 = (window4 ^ (-i2)) & 7;
        int i4 = 0;
        for (int i5 = 0; i5 < 8; i5++) {
            int i6 = ((i5 ^ i3) - 1) >> 31;
            X448Field.m16822cmov(i6, iArr2, i4, pointProjective.f22428x, 0);
            X448Field.m16822cmov(i6, iArr2, i4 + 16, pointProjective.f22429y, 0);
            X448Field.m16822cmov(i6, iArr2, i4 + 32, pointProjective.f22430z, 0);
            i4 += 48;
        }
        X448Field.m16823cnegate(i2, pointProjective.f22428x);
    }

    private static int[] pointPrecompute(PointProjective pointProjective, int i, PointTemp pointTemp) {
        PointProjective pointProjective2 = new PointProjective();
        pointCopy(pointProjective, pointProjective2);
        PointProjective pointProjective3 = new PointProjective();
        pointCopy(pointProjective, pointProjective3);
        pointDouble(pointProjective3, pointTemp);
        int[] iArrCreateTable = X448Field.createTable(i * 3);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            X448Field.m16824copy(pointProjective2.f22428x, 0, iArrCreateTable, i2);
            X448Field.m16824copy(pointProjective2.f22429y, 0, iArrCreateTable, i2 + 16);
            X448Field.m16824copy(pointProjective2.f22430z, 0, iArrCreateTable, i2 + 32);
            i2 += 48;
            i3++;
            if (i3 == i) {
                return iArrCreateTable;
            }
            pointAdd(pointProjective3, pointProjective2, pointTemp);
        }
    }

    /* renamed from: sign */
    public static void m16862sign(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, int i2, int i3, byte[] bArr4, int i4) {
        implSign(bArr, i, bArr2, (byte) 0, bArr3, i2, i3, bArr4, i4);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, byte[] bArr5, int i4) {
        implSign(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, i3, 64, bArr5, i4);
    }

    /* renamed from: verify */
    public static boolean m16864verify(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, int i4) {
        return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 0, bArr4, i3, i4);
    }

    public static boolean verifyPrehash(byte[] bArr, int i, PublicPoint publicPoint, byte[] bArr2, byte[] bArr3, int i2) {
        return implVerify(bArr, i, publicPoint, bArr2, (byte) 1, bArr3, i2, 64);
    }

    private static void implSign(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte b, byte[] bArr4, int i3, int i4, byte[] bArr5, int i5) {
        if (!checkContextVar(bArr3)) {
            throw new IllegalArgumentException("ctx");
        }
        InterfaceC5284Xof interfaceC5284XofCreateXof = createXof();
        byte[] bArr6 = new byte[114];
        interfaceC5284XofCreateXof.mo14970update(bArr, i, 57);
        interfaceC5284XofCreateXof.mo14998doFinal(bArr6, 0, 114);
        byte[] bArr7 = new byte[57];
        pruneScalar(bArr6, 0, bArr7);
        implSign(interfaceC5284XofCreateXof, bArr6, bArr7, bArr2, i2, bArr3, b, bArr4, i3, i4, bArr5, i5);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, InterfaceC5284Xof interfaceC5284Xof, byte[] bArr3, int i2) {
        byte[] bArr4 = new byte[64];
        if (64 != interfaceC5284Xof.mo14998doFinal(bArr4, 0, 64)) {
            throw new IllegalArgumentException("ph");
        }
        implSign(bArr, i, bArr2, (byte) 1, bArr4, 0, 64, bArr3, i2);
    }

    public static boolean verifyPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, InterfaceC5284Xof interfaceC5284Xof) {
        byte[] bArr4 = new byte[64];
        if (64 == interfaceC5284Xof.mo14998doFinal(bArr4, 0, 64)) {
            return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, 0, 64);
        }
        throw new IllegalArgumentException("ph");
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, int i2, byte[] bArr4, int i3) {
        implSign(bArr, i, bArr2, (byte) 1, bArr3, i2, 64, bArr4, i3);
    }

    public static boolean verifyPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3) {
        return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, i3, 64);
    }
}
