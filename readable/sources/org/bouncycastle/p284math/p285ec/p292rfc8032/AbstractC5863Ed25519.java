package org.bouncycastle.p284math.p285ec.p292rfc8032;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p199digests.SHA512Digest;
import org.bouncycastle.p284math.p285ec.p291rfc7748.AbstractC5860X25519;
import org.bouncycastle.p284math.p285ec.p291rfc7748.X25519Field;
import org.bouncycastle.p284math.p295raw.AbstractC5874Nat256;
import org.bouncycastle.p284math.p295raw.Interleave;
import org.bouncycastle.p361util.Integers;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* renamed from: org.bouncycastle.math.ec.rfc8032.Ed25519 */
/* loaded from: classes2.dex */
public abstract class AbstractC5863Ed25519 {
    private static final int COORD_INTS = 8;
    private static final int POINT_BYTES = 32;
    private static final int PRECOMP_BLOCKS = 8;
    private static final int PRECOMP_MASK = 7;
    private static final int PRECOMP_POINTS = 8;
    private static final int PRECOMP_RANGE = 256;
    private static final int PRECOMP_SPACING = 8;
    private static final int PRECOMP_TEETH = 4;
    public static final int PREHASH_SIZE = 64;
    public static final int PUBLIC_KEY_SIZE = 32;
    private static final int SCALAR_BYTES = 32;
    private static final int SCALAR_INTS = 8;
    public static final int SECRET_KEY_SIZE = 32;
    public static final int SIGNATURE_SIZE = 64;
    private static final int WNAF_WIDTH_128 = 4;
    private static final int WNAF_WIDTH_BASE = 6;
    private static final byte[] DOM2_PREFIX = {83, 105, 103, 69, 100, 50, 53, 53, 49, 57, 32, 110, 111, 32, 69, 100, 50, 53, 53, 49, 57, 32, 99, 111, 108, 108, 105, 115, 105, 111, 110, 115};

    /* renamed from: P */
    private static final int[] f22395P = {-19, -1, -1, -1, -1, -1, -1, Integer.MAX_VALUE};
    private static final int[] ORDER8_y1 = {1886001095, 1339575613, 1980447930, 258412557, -95215574, -959694548, 2013120334, 2047061138};
    private static final int[] ORDER8_y2 = {-1886001114, -1339575614, -1980447931, -258412558, 95215573, 959694547, -2013120335, 100422509};

    /* renamed from: B_x */
    private static final int[] f22390B_x = {52811034, 25909283, 8072341, 50637101, 13785486, 30858332, 20483199, 20966410, 43936626, 4379245};

    /* renamed from: B_y */
    private static final int[] f22391B_y = {40265304, 26843545, 6710886, 53687091, 13421772, 40265318, 26843545, 6710886, 53687091, 13421772};

    /* renamed from: B128_x */
    private static final int[] f22388B128_x = {12052516, 1174424, 4087752, 38672185, 20040971, 21899680, 55468344, 20105554, 66708015, 9981791};

    /* renamed from: B128_y */
    private static final int[] f22389B128_y = {66430571, 45040722, 4842939, 15895846, 18981244, 46308410, 4697481, 8903007, 53646190, 12474675};

    /* renamed from: C_d */
    private static final int[] f22392C_d = {56195235, 47411844, 25868126, 40503822, 57364, 58321048, 30416477, 31930572, 57760639, 10749657};

    /* renamed from: C_d2 */
    private static final int[] f22393C_d2 = {45281625, 27714825, 18181821, 13898781, 114729, 49533232, 60832955, 30306712, 48412415, 4722099};

    /* renamed from: C_d4 */
    private static final int[] f22394C_d4 = {23454386, 55429651, 2809210, 27797563, 229458, 31957600, 54557047, 27058993, 29715967, 9444199};
    private static final Object PRECOMP_LOCK = new Object();
    private static PointPrecomp[] PRECOMP_BASE_WNAF = null;
    private static PointPrecomp[] PRECOMP_BASE128_WNAF = null;
    private static int[] PRECOMP_BASE_COMB = null;

    /* renamed from: org.bouncycastle.math.ec.rfc8032.Ed25519$Algorithm */
    public static final class Algorithm {

        /* renamed from: Ed25519 */
        public static final int f22396Ed25519 = 0;
        public static final int Ed25519ctx = 1;
        public static final int Ed25519ph = 2;
    }

    /* renamed from: org.bouncycastle.math.ec.rfc8032.Ed25519$F */
    public static class F extends X25519Field {
        private F() {
        }
    }

    /* renamed from: org.bouncycastle.math.ec.rfc8032.Ed25519$PointAccum */
    public static class PointAccum {

        /* renamed from: u */
        int[] f22397u;

        /* renamed from: v */
        int[] f22398v;

        /* renamed from: x */
        int[] f22399x;

        /* renamed from: y */
        int[] f22400y;

        /* renamed from: z */
        int[] f22401z;

        private PointAccum() {
            this.f22399x = X25519Field.m16794create();
            this.f22400y = X25519Field.m16794create();
            this.f22401z = X25519Field.m16794create();
            this.f22397u = X25519Field.m16794create();
            this.f22398v = X25519Field.m16794create();
        }
    }

    /* renamed from: org.bouncycastle.math.ec.rfc8032.Ed25519$PointAffine */
    public static class PointAffine {

        /* renamed from: x */
        int[] f22402x;

        /* renamed from: y */
        int[] f22403y;

        private PointAffine() {
            this.f22402x = X25519Field.m16794create();
            this.f22403y = X25519Field.m16794create();
        }
    }

    /* renamed from: org.bouncycastle.math.ec.rfc8032.Ed25519$PointExtended */
    public static class PointExtended {

        /* renamed from: t */
        int[] f22404t;

        /* renamed from: x */
        int[] f22405x;

        /* renamed from: y */
        int[] f22406y;

        /* renamed from: z */
        int[] f22407z;

        private PointExtended() {
            this.f22405x = X25519Field.m16794create();
            this.f22406y = X25519Field.m16794create();
            this.f22407z = X25519Field.m16794create();
            this.f22404t = X25519Field.m16794create();
        }
    }

    /* renamed from: org.bouncycastle.math.ec.rfc8032.Ed25519$PointPrecomp */
    public static class PointPrecomp {

        /* renamed from: xyd */
        int[] f22408xyd;

        /* renamed from: ymx_h */
        int[] f22409ymx_h;

        /* renamed from: ypx_h */
        int[] f22410ypx_h;

        private PointPrecomp() {
            this.f22409ymx_h = X25519Field.m16794create();
            this.f22410ypx_h = X25519Field.m16794create();
            this.f22408xyd = X25519Field.m16794create();
        }
    }

    /* renamed from: org.bouncycastle.math.ec.rfc8032.Ed25519$PointPrecompZ */
    public static class PointPrecompZ {

        /* renamed from: xyd */
        int[] f22411xyd;

        /* renamed from: ymx_h */
        int[] f22412ymx_h;

        /* renamed from: ypx_h */
        int[] f22413ypx_h;

        /* renamed from: z */
        int[] f22414z;

        private PointPrecompZ() {
            this.f22412ymx_h = X25519Field.m16794create();
            this.f22413ypx_h = X25519Field.m16794create();
            this.f22411xyd = X25519Field.m16794create();
            this.f22414z = X25519Field.m16794create();
        }
    }

    /* renamed from: org.bouncycastle.math.ec.rfc8032.Ed25519$PointTemp */
    public static class PointTemp {

        /* renamed from: r0 */
        int[] f22415r0;

        /* renamed from: r1 */
        int[] f22416r1;

        private PointTemp() {
            this.f22415r0 = X25519Field.m16794create();
            this.f22416r1 = X25519Field.m16794create();
        }
    }

    /* renamed from: org.bouncycastle.math.ec.rfc8032.Ed25519$PublicPoint */
    public static final class PublicPoint {

        /* renamed from: data */
        final int[] f22417data;

        public PublicPoint(int[] iArr) {
            this.f22417data = iArr;
        }
    }

    private static byte[] calculateS(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int[] iArr = new int[16];
        Scalar25519.m16865decode(bArr, iArr);
        int[] iArr2 = new int[8];
        Scalar25519.m16865decode(bArr2, iArr2);
        int[] iArr3 = new int[8];
        Scalar25519.m16865decode(bArr3, iArr3);
        AbstractC5874Nat256.mulAddTo(iArr2, iArr3, iArr);
        byte[] bArr4 = new byte[64];
        AbstractC5862Codec.encode32(iArr, 0, 16, bArr4, 0);
        return Scalar25519.reduce512(bArr4);
    }

    private static boolean checkContextVar(byte[] bArr, byte b) {
        return (bArr == null && b == 0) || (bArr != null && bArr.length < 256);
    }

    private static int checkPoint(PointAccum pointAccum) {
        int[] iArrM16794create = X25519Field.m16794create();
        int[] iArrM16794create2 = X25519Field.m16794create();
        int[] iArrM16794create3 = X25519Field.m16794create();
        int[] iArrM16794create4 = X25519Field.m16794create();
        X25519Field.m16814sqr(pointAccum.f22399x, iArrM16794create2);
        X25519Field.m16814sqr(pointAccum.f22400y, iArrM16794create3);
        X25519Field.m16814sqr(pointAccum.f22401z, iArrM16794create4);
        X25519Field.m16809mul(iArrM16794create2, iArrM16794create3, iArrM16794create);
        X25519Field.m16815sub(iArrM16794create2, iArrM16794create3, iArrM16794create2);
        X25519Field.m16809mul(iArrM16794create2, iArrM16794create4, iArrM16794create2);
        X25519Field.m16814sqr(iArrM16794create4, iArrM16794create4);
        X25519Field.m16809mul(iArrM16794create, f22392C_d, iArrM16794create);
        X25519Field.m16786add(iArrM16794create, iArrM16794create4, iArrM16794create);
        X25519Field.m16786add(iArrM16794create, iArrM16794create2, iArrM16794create);
        X25519Field.normalize(iArrM16794create);
        X25519Field.normalize(iArrM16794create3);
        X25519Field.normalize(iArrM16794create4);
        return X25519Field.m16807isZero(iArrM16794create) & (~X25519Field.m16807isZero(iArrM16794create3)) & (~X25519Field.m16807isZero(iArrM16794create4));
    }

    private static boolean checkPointFullVar(byte[] bArr) {
        int iDecode32 = AbstractC5862Codec.decode32(bArr, 28) & Integer.MAX_VALUE;
        int i = f22395P[7] ^ iDecode32;
        int i2 = ORDER8_y1[7] ^ iDecode32;
        int i3 = ORDER8_y2[7] ^ iDecode32;
        for (int i4 = 6; i4 > 0; i4--) {
            int iDecode322 = AbstractC5862Codec.decode32(bArr, i4 * 4);
            iDecode32 |= iDecode322;
            i |= f22395P[i4] ^ iDecode322;
            i2 |= ORDER8_y1[i4] ^ iDecode322;
            i3 |= iDecode322 ^ ORDER8_y2[i4];
        }
        int iDecode323 = AbstractC5862Codec.decode32(bArr, 0);
        if (iDecode32 == 0 && Integers.compareUnsigned(iDecode323, 1) <= 0) {
            return false;
        }
        if (i == 0 && Integers.compareUnsigned(iDecode323, f22395P[0] - 1) >= 0) {
            return false;
        }
        return (((ORDER8_y1[0] ^ iDecode323) | i2) != 0) & (((iDecode323 ^ ORDER8_y2[0]) | i3) != 0);
    }

    private static boolean checkPointOrderVar(PointAffine pointAffine) {
        PointAccum pointAccum = new PointAccum();
        scalarMultOrderVar(pointAffine, pointAccum);
        return normalizeToNeutralElementVar(pointAccum);
    }

    private static boolean checkPointVar(byte[] bArr) {
        if ((AbstractC5862Codec.decode32(bArr, 28) & Integer.MAX_VALUE) < f22395P[7]) {
            return true;
        }
        int[] iArr = new int[8];
        AbstractC5862Codec.decode32(bArr, 0, iArr, 0, 8);
        iArr[7] = iArr[7] & Integer.MAX_VALUE;
        return !AbstractC5874Nat256.m17074gte(iArr, r2);
    }

    /* renamed from: copy */
    private static byte[] m16849copy(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    private static InterfaceC5277Digest createDigest() {
        SHA512Digest sHA512Digest = new SHA512Digest();
        if (sHA512Digest.getDigestSize() == 64) {
            return sHA512Digest;
        }
        throw new IllegalStateException();
    }

    public static InterfaceC5277Digest createPrehash() {
        return createDigest();
    }

    private static boolean decodePointVar(byte[] bArr, boolean z, PointAffine pointAffine) {
        int i = (bArr[31] & ByteCompanionObject.MIN_VALUE) >>> 7;
        X25519Field.decode255(bArr, pointAffine.f22403y);
        int[] iArrM16794create = X25519Field.m16794create();
        int[] iArrM16794create2 = X25519Field.m16794create();
        X25519Field.m16814sqr(pointAffine.f22403y, iArrM16794create);
        X25519Field.m16809mul(f22392C_d, iArrM16794create, iArrM16794create2);
        X25519Field.m16816subOne(iArrM16794create);
        X25519Field.m16787addOne(iArrM16794create2);
        if (!X25519Field.sqrtRatioVar(iArrM16794create, iArrM16794create2, pointAffine.f22402x)) {
            return false;
        }
        X25519Field.normalize(pointAffine.f22402x);
        if (i == 1 && X25519Field.isZeroVar(pointAffine.f22402x)) {
            return false;
        }
        int[] iArr = pointAffine.f22402x;
        if (z ^ (i != (iArr[0] & 1))) {
            X25519Field.m16810negate(iArr, iArr);
            X25519Field.normalize(pointAffine.f22402x);
        }
        return true;
    }

    /* renamed from: dom2 */
    private static void m16850dom2(InterfaceC5277Digest interfaceC5277Digest, byte b, byte[] bArr) {
        byte[] bArr2 = DOM2_PREFIX;
        int length = bArr2.length;
        int i = length + 2;
        int length2 = bArr.length + i;
        byte[] bArr3 = new byte[length2];
        System.arraycopy(bArr2, 0, bArr3, 0, length);
        bArr3[length] = b;
        bArr3[length + 1] = (byte) bArr.length;
        System.arraycopy(bArr, 0, bArr3, i, bArr.length);
        interfaceC5277Digest.mo14970update(bArr3, 0, length2);
    }

    private static void encodePoint(PointAffine pointAffine, byte[] bArr, int i) {
        X25519Field.m16802encode(pointAffine.f22403y, bArr, i);
        int i2 = i + 31;
        bArr[i2] = (byte) (((pointAffine.f22402x[0] & 1) << 7) | bArr[i2]);
    }

    public static void encodePublicPoint(PublicPoint publicPoint, byte[] bArr, int i) {
        X25519Field.m16800encode(publicPoint.f22417data, 10, bArr, i);
        int i2 = i + 31;
        bArr[i2] = (byte) (((publicPoint.f22417data[0] & 1) << 7) | bArr[i2]);
    }

    private static int encodeResult(PointAccum pointAccum, byte[] bArr, int i) {
        PointAffine pointAffine = new PointAffine();
        normalizeToAffine(pointAccum, pointAffine);
        int iCheckPoint = checkPoint(pointAffine);
        encodePoint(pointAffine, bArr, i);
        return iCheckPoint;
    }

    private static PublicPoint exportPoint(PointAffine pointAffine) {
        int[] iArr = new int[20];
        X25519Field.m16793copy(pointAffine.f22402x, 0, iArr, 0);
        X25519Field.m16793copy(pointAffine.f22403y, 0, iArr, 10);
        return new PublicPoint(iArr);
    }

    public static void generatePrivateKey(SecureRandom secureRandom, byte[] bArr) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("k");
        }
        secureRandom.nextBytes(bArr);
    }

    public static PublicPoint generatePublicKey(byte[] bArr, int i) {
        InterfaceC5277Digest interfaceC5277DigestCreateDigest = createDigest();
        byte[] bArr2 = new byte[64];
        interfaceC5277DigestCreateDigest.mo14970update(bArr, i, 32);
        interfaceC5277DigestCreateDigest.mo14967doFinal(bArr2, 0);
        byte[] bArr3 = new byte[32];
        pruneScalar(bArr2, 0, bArr3);
        PointAccum pointAccum = new PointAccum();
        scalarMultBase(bArr3, pointAccum);
        PointAffine pointAffine = new PointAffine();
        normalizeToAffine(pointAccum, pointAffine);
        if (checkPoint(pointAffine) != 0) {
            return exportPoint(pointAffine);
        }
        throw new IllegalStateException();
    }

    private static int getWindow4(int[] iArr, int i) {
        return (iArr[i >>> 3] >>> ((i & 7) << 2)) & 15;
    }

    private static void groupCombBits(int[] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = Interleave.shuffle2(iArr[i]);
        }
    }

    private static void implSign(InterfaceC5277Digest interfaceC5277Digest, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4, byte b, byte[] bArr5, int i2, int i3, byte[] bArr6, int i4) {
        if (bArr4 != null) {
            m16850dom2(interfaceC5277Digest, b, bArr4);
        }
        interfaceC5277Digest.mo14970update(bArr, 32, 32);
        interfaceC5277Digest.mo14970update(bArr5, i2, i3);
        interfaceC5277Digest.mo14967doFinal(bArr, 0);
        byte[] bArrReduce512 = Scalar25519.reduce512(bArr);
        byte[] bArr7 = new byte[32];
        scalarMultBaseEncoded(bArrReduce512, bArr7, 0);
        if (bArr4 != null) {
            m16850dom2(interfaceC5277Digest, b, bArr4);
        }
        interfaceC5277Digest.mo14970update(bArr7, 0, 32);
        interfaceC5277Digest.mo14970update(bArr3, i, 32);
        interfaceC5277Digest.mo14970update(bArr5, i2, i3);
        interfaceC5277Digest.mo14967doFinal(bArr, 0);
        byte[] bArrCalculateS = calculateS(bArrReduce512, Scalar25519.reduce512(bArr), bArr2);
        System.arraycopy(bArr7, 0, bArr6, i4, 32);
        System.arraycopy(bArrCalculateS, 0, bArr6, i4 + 32, 32);
    }

    private static boolean implVerify(byte[] bArr, int i, PublicPoint publicPoint, byte[] bArr2, byte b, byte[] bArr3, int i2, int i3) {
        if (!checkContextVar(bArr2, b)) {
            throw new IllegalArgumentException("ctx");
        }
        byte[] bArrM16849copy = m16849copy(bArr, i, 32);
        byte[] bArrM16849copy2 = m16849copy(bArr, i + 32, 32);
        if (!checkPointVar(bArrM16849copy)) {
            return false;
        }
        int[] iArr = new int[8];
        if (!Scalar25519.checkVar(bArrM16849copy2, iArr)) {
            return false;
        }
        PointAffine pointAffine = new PointAffine();
        if (!decodePointVar(bArrM16849copy, true, pointAffine)) {
            return false;
        }
        PointAffine pointAffine2 = new PointAffine();
        X25519Field.m16810negate(publicPoint.f22417data, pointAffine2.f22402x);
        X25519Field.m16793copy(publicPoint.f22417data, 10, pointAffine2.f22403y, 0);
        byte[] bArr4 = new byte[32];
        encodePublicPoint(publicPoint, bArr4, 0);
        InterfaceC5277Digest interfaceC5277DigestCreateDigest = createDigest();
        byte[] bArr5 = new byte[64];
        if (bArr2 != null) {
            m16850dom2(interfaceC5277DigestCreateDigest, b, bArr2);
        }
        interfaceC5277DigestCreateDigest.mo14970update(bArrM16849copy, 0, 32);
        interfaceC5277DigestCreateDigest.mo14970update(bArr4, 0, 32);
        interfaceC5277DigestCreateDigest.mo14970update(bArr3, i2, i3);
        interfaceC5277DigestCreateDigest.mo14967doFinal(bArr5, 0);
        int[] iArr2 = new int[8];
        Scalar25519.m16865decode(Scalar25519.reduce512(bArr5), iArr2);
        int[] iArr3 = new int[4];
        int[] iArr4 = new int[4];
        if (!Scalar25519.reduceBasisVar(iArr2, iArr3, iArr4)) {
            throw new IllegalStateException();
        }
        Scalar25519.multiply128Var(iArr, iArr4, iArr);
        PointAccum pointAccum = new PointAccum();
        scalarMultStraus128Var(iArr, iArr3, pointAffine2, iArr4, pointAffine, pointAccum);
        return normalizeToNeutralElementVar(pointAccum);
    }

    private static void invertDoubleZs(PointExtended[] pointExtendedArr) {
        int length = pointExtendedArr.length;
        int[] iArrCreateTable = X25519Field.createTable(length);
        int[] iArrM16794create = X25519Field.m16794create();
        X25519Field.m16793copy(pointExtendedArr[0].f22407z, 0, iArrM16794create, 0);
        X25519Field.m16793copy(iArrM16794create, 0, iArrCreateTable, 0);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i2 >= length) {
                break;
            }
            X25519Field.m16809mul(iArrM16794create, pointExtendedArr[i2].f22407z, iArrM16794create);
            X25519Field.m16793copy(iArrM16794create, 0, iArrCreateTable, i2 * 10);
            i = i2;
        }
        X25519Field.m16786add(iArrM16794create, iArrM16794create, iArrM16794create);
        X25519Field.m16805invVar(iArrM16794create, iArrM16794create);
        int[] iArrM16794create2 = X25519Field.m16794create();
        while (i > 0) {
            int i3 = i - 1;
            X25519Field.m16793copy(iArrCreateTable, i3 * 10, iArrM16794create2, 0);
            X25519Field.m16809mul(iArrM16794create2, iArrM16794create, iArrM16794create2);
            X25519Field.m16809mul(iArrM16794create, pointExtendedArr[i].f22407z, iArrM16794create);
            X25519Field.m16793copy(iArrM16794create2, 0, pointExtendedArr[i].f22407z, 0);
            i = i3;
        }
        X25519Field.m16793copy(iArrM16794create, 0, pointExtendedArr[0].f22407z, 0);
    }

    private static void normalizeToAffine(PointAccum pointAccum, PointAffine pointAffine) {
        X25519Field.m16804inv(pointAccum.f22401z, pointAffine.f22403y);
        X25519Field.m16809mul(pointAffine.f22403y, pointAccum.f22399x, pointAffine.f22402x);
        int[] iArr = pointAffine.f22403y;
        X25519Field.m16809mul(iArr, pointAccum.f22400y, iArr);
        X25519Field.normalize(pointAffine.f22402x);
        X25519Field.normalize(pointAffine.f22403y);
    }

    private static boolean normalizeToNeutralElementVar(PointAccum pointAccum) {
        X25519Field.normalize(pointAccum.f22399x);
        X25519Field.normalize(pointAccum.f22400y);
        X25519Field.normalize(pointAccum.f22401z);
        return X25519Field.isZeroVar(pointAccum.f22399x) && !X25519Field.isZeroVar(pointAccum.f22400y) && X25519Field.areEqualVar(pointAccum.f22400y, pointAccum.f22401z);
    }

    private static void pointAdd(PointExtended pointExtended, PointExtended pointExtended2, PointExtended pointExtended3, PointTemp pointTemp) {
        int[] iArr = pointExtended3.f22405x;
        int[] iArr2 = pointExtended3.f22406y;
        int[] iArr3 = pointTemp.f22415r0;
        int[] iArr4 = pointTemp.f22416r1;
        X25519Field.m16789apm(pointExtended.f22406y, pointExtended.f22405x, iArr2, iArr);
        X25519Field.m16789apm(pointExtended2.f22406y, pointExtended2.f22405x, iArr4, iArr3);
        X25519Field.m16809mul(iArr, iArr3, iArr);
        X25519Field.m16809mul(iArr2, iArr4, iArr2);
        X25519Field.m16809mul(pointExtended.f22404t, pointExtended2.f22404t, iArr3);
        X25519Field.m16809mul(iArr3, f22393C_d2, iArr3);
        int[] iArr5 = pointExtended.f22407z;
        X25519Field.m16786add(iArr5, iArr5, iArr4);
        X25519Field.m16809mul(iArr4, pointExtended2.f22407z, iArr4);
        X25519Field.m16789apm(iArr2, iArr, iArr2, iArr);
        X25519Field.m16789apm(iArr4, iArr3, iArr4, iArr3);
        X25519Field.m16809mul(iArr, iArr2, pointExtended3.f22404t);
        X25519Field.m16809mul(iArr3, iArr4, pointExtended3.f22407z);
        X25519Field.m16809mul(iArr, iArr3, pointExtended3.f22405x);
        X25519Field.m16809mul(iArr2, iArr4, pointExtended3.f22406y);
    }

    private static void pointAddVar(boolean z, PointPrecomp pointPrecomp, PointAccum pointAccum, PointTemp pointTemp) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3 = pointAccum.f22399x;
        int[] iArr4 = pointAccum.f22400y;
        int[] iArr5 = pointTemp.f22415r0;
        int[] iArr6 = pointAccum.f22397u;
        int[] iArr7 = pointAccum.f22398v;
        if (z) {
            iArr2 = iArr3;
            iArr = iArr4;
        } else {
            iArr = iArr3;
            iArr2 = iArr4;
        }
        X25519Field.m16789apm(iArr4, iArr3, iArr4, iArr3);
        X25519Field.m16809mul(iArr, pointPrecomp.f22409ymx_h, iArr);
        X25519Field.m16809mul(iArr2, pointPrecomp.f22410ypx_h, iArr2);
        X25519Field.m16809mul(pointAccum.f22397u, pointAccum.f22398v, iArr5);
        X25519Field.m16809mul(iArr5, pointPrecomp.f22408xyd, iArr5);
        X25519Field.m16789apm(iArr4, iArr3, iArr7, iArr6);
        X25519Field.m16789apm(pointAccum.f22401z, iArr5, iArr2, iArr);
        X25519Field.m16809mul(iArr3, iArr4, pointAccum.f22401z);
        X25519Field.m16809mul(iArr3, iArr6, pointAccum.f22399x);
        X25519Field.m16809mul(iArr4, iArr7, pointAccum.f22400y);
    }

    private static void pointCopy(PointAccum pointAccum, PointExtended pointExtended) {
        X25519Field.m16793copy(pointAccum.f22399x, 0, pointExtended.f22405x, 0);
        X25519Field.m16793copy(pointAccum.f22400y, 0, pointExtended.f22406y, 0);
        X25519Field.m16793copy(pointAccum.f22401z, 0, pointExtended.f22407z, 0);
        X25519Field.m16809mul(pointAccum.f22397u, pointAccum.f22398v, pointExtended.f22404t);
    }

    private static void pointDouble(PointAccum pointAccum) {
        int[] iArr = pointAccum.f22399x;
        int[] iArr2 = pointAccum.f22400y;
        int[] iArr3 = pointAccum.f22401z;
        int[] iArr4 = pointAccum.f22397u;
        int[] iArr5 = pointAccum.f22398v;
        X25519Field.m16786add(iArr, iArr2, iArr4);
        X25519Field.m16814sqr(pointAccum.f22399x, iArr);
        X25519Field.m16814sqr(pointAccum.f22400y, iArr2);
        X25519Field.m16814sqr(pointAccum.f22401z, iArr3);
        X25519Field.m16786add(iArr3, iArr3, iArr3);
        X25519Field.m16789apm(iArr, iArr2, iArr5, iArr2);
        X25519Field.m16814sqr(iArr4, iArr4);
        X25519Field.m16815sub(iArr5, iArr4, iArr4);
        X25519Field.m16786add(iArr3, iArr2, iArr);
        X25519Field.m16790carry(iArr);
        X25519Field.m16809mul(iArr, iArr2, pointAccum.f22401z);
        X25519Field.m16809mul(iArr, iArr4, pointAccum.f22399x);
        X25519Field.m16809mul(iArr2, iArr5, pointAccum.f22400y);
    }

    private static void pointLookup(int i, int i2, PointPrecomp pointPrecomp) {
        int i3 = i * 240;
        for (int i4 = 0; i4 < 8; i4++) {
            int i5 = ((i4 ^ i2) - 1) >> 31;
            X25519Field.m16791cmov(i5, PRECOMP_BASE_COMB, i3, pointPrecomp.f22409ymx_h, 0);
            X25519Field.m16791cmov(i5, PRECOMP_BASE_COMB, i3 + 10, pointPrecomp.f22410ypx_h, 0);
            X25519Field.m16791cmov(i5, PRECOMP_BASE_COMB, i3 + 20, pointPrecomp.f22408xyd, 0);
            i3 += 30;
        }
    }

    private static void pointLookupZ(int[] iArr, int i, int[] iArr2, PointPrecompZ pointPrecompZ) {
        int window4 = getWindow4(iArr, i);
        int i2 = (window4 >>> 3) ^ 1;
        int i3 = (window4 ^ (-i2)) & 7;
        int i4 = 0;
        for (int i5 = 0; i5 < 8; i5++) {
            int i6 = ((i5 ^ i3) - 1) >> 31;
            X25519Field.m16791cmov(i6, iArr2, i4, pointPrecompZ.f22412ymx_h, 0);
            X25519Field.m16791cmov(i6, iArr2, i4 + 10, pointPrecompZ.f22413ypx_h, 0);
            X25519Field.m16791cmov(i6, iArr2, i4 + 20, pointPrecompZ.f22411xyd, 0);
            X25519Field.m16791cmov(i6, iArr2, i4 + 30, pointPrecompZ.f22414z, 0);
            i4 += 40;
        }
        X25519Field.m16795cswap(i2, pointPrecompZ.f22412ymx_h, pointPrecompZ.f22413ypx_h);
        X25519Field.m16792cnegate(i2, pointPrecompZ.f22411xyd);
    }

    private static void pointPrecompute(PointAffine pointAffine, PointExtended[] pointExtendedArr, int i, int i2, PointTemp pointTemp) {
        PointExtended pointExtended = new PointExtended();
        pointCopy(pointAffine, pointExtended);
        pointExtendedArr[i] = pointExtended;
        PointExtended pointExtended2 = new PointExtended();
        pointAdd(pointExtended, pointExtended, pointExtended2, pointTemp);
        for (int i3 = 1; i3 < i2; i3++) {
            PointExtended pointExtended3 = new PointExtended();
            int i4 = i + i3;
            pointAdd(pointExtendedArr[i4 - 1], pointExtended2, pointExtended3, pointTemp);
            pointExtendedArr[i4] = pointExtended3;
        }
    }

    private static void pointPrecomputeZ(PointAffine pointAffine, PointPrecompZ[] pointPrecompZArr, int i, PointTemp pointTemp) {
        PointExtended pointExtended = new PointExtended();
        pointCopy(pointAffine, pointExtended);
        PointExtended pointExtended2 = new PointExtended();
        pointAdd(pointExtended, pointExtended, pointExtended2, pointTemp);
        int i2 = 0;
        while (true) {
            PointPrecompZ pointPrecompZ = new PointPrecompZ();
            pointCopy(pointExtended, pointPrecompZ);
            pointPrecompZArr[i2] = pointPrecompZ;
            i2++;
            if (i2 == i) {
                return;
            } else {
                pointAdd(pointExtended, pointExtended2, pointExtended, pointTemp);
            }
        }
    }

    private static void pointSetNeutral(PointAccum pointAccum) {
        X25519Field.m16817zero(pointAccum.f22399x);
        X25519Field.m16811one(pointAccum.f22400y);
        X25519Field.m16811one(pointAccum.f22401z);
        X25519Field.m16817zero(pointAccum.f22397u);
        X25519Field.m16811one(pointAccum.f22398v);
    }

    public static void precompute() {
        synchronized (PRECOMP_LOCK) {
            try {
                if (PRECOMP_BASE_COMB != null) {
                    return;
                }
                PointExtended[] pointExtendedArr = new PointExtended[96];
                PointTemp pointTemp = new PointTemp();
                PointAffine pointAffine = new PointAffine();
                int[] iArr = f22390B_x;
                int i = 0;
                X25519Field.m16793copy(iArr, 0, pointAffine.f22402x, 0);
                int[] iArr2 = f22391B_y;
                X25519Field.m16793copy(iArr2, 0, pointAffine.f22403y, 0);
                pointPrecompute(pointAffine, pointExtendedArr, 0, 16, pointTemp);
                PointAffine pointAffine2 = new PointAffine();
                X25519Field.m16793copy(f22388B128_x, 0, pointAffine2.f22402x, 0);
                X25519Field.m16793copy(f22389B128_y, 0, pointAffine2.f22403y, 0);
                pointPrecompute(pointAffine2, pointExtendedArr, 16, 16, pointTemp);
                PointAccum pointAccum = new PointAccum();
                X25519Field.m16793copy(iArr, 0, pointAccum.f22399x, 0);
                X25519Field.m16793copy(iArr2, 0, pointAccum.f22400y, 0);
                X25519Field.m16811one(pointAccum.f22401z);
                X25519Field.m16793copy(pointAccum.f22399x, 0, pointAccum.f22397u, 0);
                X25519Field.m16793copy(pointAccum.f22400y, 0, pointAccum.f22398v, 0);
                int i2 = 4;
                PointExtended[] pointExtendedArr2 = new PointExtended[4];
                for (int i3 = 0; i3 < 4; i3++) {
                    pointExtendedArr2[i3] = new PointExtended();
                }
                PointExtended pointExtended = new PointExtended();
                int i4 = 0;
                int i5 = 32;
                while (i4 < 8) {
                    PointExtended pointExtended2 = new PointExtended();
                    int i6 = i;
                    while (i6 < i2) {
                        if (i6 == 0) {
                            pointCopy(pointAccum, pointExtended2);
                        } else {
                            pointCopy(pointAccum, pointExtended);
                            pointAdd(pointExtended2, pointExtended, pointExtended2, pointTemp);
                        }
                        pointDouble(pointAccum);
                        pointCopy(pointAccum, pointExtendedArr2[i6]);
                        if (i4 + i6 != 10) {
                            for (int i7 = 1; i7 < 8; i7++) {
                                pointDouble(pointAccum);
                            }
                        }
                        i6++;
                        i2 = 4;
                    }
                    int[] iArr3 = pointExtended2.f22405x;
                    X25519Field.m16810negate(iArr3, iArr3);
                    int[] iArr4 = pointExtended2.f22404t;
                    X25519Field.m16810negate(iArr4, iArr4);
                    pointExtendedArr[i5] = pointExtended2;
                    i5++;
                    for (int i8 = 0; i8 < 3; i8++) {
                        int i9 = 1 << i8;
                        int i10 = 0;
                        while (i10 < i9) {
                            PointExtended pointExtended3 = new PointExtended();
                            pointExtendedArr[i5] = pointExtended3;
                            pointAdd(pointExtendedArr[i5 - i9], pointExtendedArr2[i8], pointExtended3, pointTemp);
                            i10++;
                            i5++;
                        }
                    }
                    i4++;
                    i2 = 4;
                    i = 0;
                }
                invertDoubleZs(pointExtendedArr);
                PRECOMP_BASE_WNAF = new PointPrecomp[16];
                for (int i11 = 0; i11 < 16; i11++) {
                    PointExtended pointExtended4 = pointExtendedArr[i11];
                    PointPrecomp pointPrecomp = new PointPrecomp();
                    int[] iArr5 = pointExtended4.f22405x;
                    X25519Field.m16809mul(iArr5, pointExtended4.f22407z, iArr5);
                    int[] iArr6 = pointExtended4.f22406y;
                    X25519Field.m16809mul(iArr6, pointExtended4.f22407z, iArr6);
                    X25519Field.m16789apm(pointExtended4.f22406y, pointExtended4.f22405x, pointPrecomp.f22410ypx_h, pointPrecomp.f22409ymx_h);
                    X25519Field.m16809mul(pointExtended4.f22405x, pointExtended4.f22406y, pointPrecomp.f22408xyd);
                    int[] iArr7 = pointPrecomp.f22408xyd;
                    X25519Field.m16809mul(iArr7, f22394C_d4, iArr7);
                    X25519Field.normalize(pointPrecomp.f22409ymx_h);
                    X25519Field.normalize(pointPrecomp.f22410ypx_h);
                    X25519Field.normalize(pointPrecomp.f22408xyd);
                    PRECOMP_BASE_WNAF[i11] = pointPrecomp;
                }
                PRECOMP_BASE128_WNAF = new PointPrecomp[16];
                for (int i12 = 0; i12 < 16; i12++) {
                    PointExtended pointExtended5 = pointExtendedArr[16 + i12];
                    PointPrecomp pointPrecomp2 = new PointPrecomp();
                    int[] iArr8 = pointExtended5.f22405x;
                    X25519Field.m16809mul(iArr8, pointExtended5.f22407z, iArr8);
                    int[] iArr9 = pointExtended5.f22406y;
                    X25519Field.m16809mul(iArr9, pointExtended5.f22407z, iArr9);
                    X25519Field.m16789apm(pointExtended5.f22406y, pointExtended5.f22405x, pointPrecomp2.f22410ypx_h, pointPrecomp2.f22409ymx_h);
                    X25519Field.m16809mul(pointExtended5.f22405x, pointExtended5.f22406y, pointPrecomp2.f22408xyd);
                    int[] iArr10 = pointPrecomp2.f22408xyd;
                    X25519Field.m16809mul(iArr10, f22394C_d4, iArr10);
                    X25519Field.normalize(pointPrecomp2.f22409ymx_h);
                    X25519Field.normalize(pointPrecomp2.f22410ypx_h);
                    X25519Field.normalize(pointPrecomp2.f22408xyd);
                    PRECOMP_BASE128_WNAF[i12] = pointPrecomp2;
                }
                PRECOMP_BASE_COMB = X25519Field.createTable(192);
                PointPrecomp pointPrecomp3 = new PointPrecomp();
                int i13 = 0;
                for (int i14 = 32; i14 < 96; i14++) {
                    PointExtended pointExtended6 = pointExtendedArr[i14];
                    int[] iArr11 = pointExtended6.f22405x;
                    X25519Field.m16809mul(iArr11, pointExtended6.f22407z, iArr11);
                    int[] iArr12 = pointExtended6.f22406y;
                    X25519Field.m16809mul(iArr12, pointExtended6.f22407z, iArr12);
                    X25519Field.m16789apm(pointExtended6.f22406y, pointExtended6.f22405x, pointPrecomp3.f22410ypx_h, pointPrecomp3.f22409ymx_h);
                    X25519Field.m16809mul(pointExtended6.f22405x, pointExtended6.f22406y, pointPrecomp3.f22408xyd);
                    int[] iArr13 = pointPrecomp3.f22408xyd;
                    X25519Field.m16809mul(iArr13, f22394C_d4, iArr13);
                    X25519Field.normalize(pointPrecomp3.f22409ymx_h);
                    X25519Field.normalize(pointPrecomp3.f22410ypx_h);
                    X25519Field.normalize(pointPrecomp3.f22408xyd);
                    X25519Field.m16793copy(pointPrecomp3.f22409ymx_h, 0, PRECOMP_BASE_COMB, i13);
                    X25519Field.m16793copy(pointPrecomp3.f22410ypx_h, 0, PRECOMP_BASE_COMB, i13 + 10);
                    X25519Field.m16793copy(pointPrecomp3.f22408xyd, 0, PRECOMP_BASE_COMB, i13 + 20);
                    i13 += 30;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void pruneScalar(byte[] bArr, int i, byte[] bArr2) {
        System.arraycopy(bArr, i, bArr2, 0, 32);
        bArr2[0] = (byte) (bArr2[0] & 248);
        byte b = (byte) (bArr2[31] & ByteCompanionObject.MAX_VALUE);
        bArr2[31] = b;
        bArr2[31] = (byte) (b | 64);
    }

    private static void scalarMult(byte[] bArr, PointAffine pointAffine, PointAccum pointAccum) {
        int[] iArr = new int[8];
        Scalar25519.m16865decode(bArr, iArr);
        Scalar25519.toSignedDigits(256, iArr);
        PointPrecompZ pointPrecompZ = new PointPrecompZ();
        PointTemp pointTemp = new PointTemp();
        int[] iArrPointPrecomputeZ = pointPrecomputeZ(pointAffine, 8, pointTemp);
        pointSetNeutral(pointAccum);
        int i = 63;
        while (true) {
            pointLookupZ(iArr, i, iArrPointPrecomputeZ, pointPrecompZ);
            pointAdd(pointPrecompZ, pointAccum, pointTemp);
            i--;
            if (i < 0) {
                return;
            }
            for (int i2 = 0; i2 < 4; i2++) {
                pointDouble(pointAccum);
            }
        }
    }

    private static void scalarMultBase(byte[] bArr, PointAccum pointAccum) {
        precompute();
        int[] iArr = new int[8];
        Scalar25519.m16865decode(bArr, iArr);
        Scalar25519.toSignedDigits(256, iArr);
        groupCombBits(iArr);
        PointPrecomp pointPrecomp = new PointPrecomp();
        PointTemp pointTemp = new PointTemp();
        pointSetNeutral(pointAccum);
        int i = 28;
        int i2 = 0;
        while (true) {
            int i3 = 0;
            while (i3 < 8) {
                int i4 = iArr[i3] >>> i;
                int i5 = (i4 >>> 3) & 1;
                pointLookup(i3, (i4 ^ (-i5)) & 7, pointPrecomp);
                int i6 = i2 ^ i5;
                X25519Field.m16792cnegate(i6, pointAccum.f22399x);
                X25519Field.m16792cnegate(i6, pointAccum.f22397u);
                pointAdd(pointPrecomp, pointAccum, pointTemp);
                i3++;
                i2 = i5;
            }
            i -= 4;
            if (i < 0) {
                X25519Field.m16792cnegate(i2, pointAccum.f22399x);
                X25519Field.m16792cnegate(i2, pointAccum.f22397u);
                return;
            }
            pointDouble(pointAccum);
        }
    }

    private static void scalarMultBaseEncoded(byte[] bArr, byte[] bArr2, int i) {
        PointAccum pointAccum = new PointAccum();
        scalarMultBase(bArr, pointAccum);
        if (encodeResult(pointAccum, bArr2, i) == 0) {
            throw new IllegalStateException();
        }
    }

    public static void scalarMultBaseYZ(AbstractC5860X25519.Friend friend, byte[] bArr, int i, int[] iArr, int[] iArr2) {
        if (friend == null) {
            throw new NullPointerException("This method is only for use by X25519");
        }
        byte[] bArr2 = new byte[32];
        pruneScalar(bArr, i, bArr2);
        PointAccum pointAccum = new PointAccum();
        scalarMultBase(bArr2, pointAccum);
        if (checkPoint(pointAccum) == 0) {
            throw new IllegalStateException();
        }
        X25519Field.m16793copy(pointAccum.f22400y, 0, iArr, 0);
        X25519Field.m16793copy(pointAccum.f22401z, 0, iArr2, 0);
    }

    private static void scalarMultOrderVar(PointAffine pointAffine, PointAccum pointAccum) {
        byte[] bArr = new byte[253];
        Scalar25519.getOrderWnafVar(4, bArr);
        PointPrecompZ[] pointPrecompZArr = new PointPrecompZ[4];
        PointTemp pointTemp = new PointTemp();
        pointPrecomputeZ(pointAffine, pointPrecompZArr, 4, pointTemp);
        pointSetNeutral(pointAccum);
        int i = 252;
        while (true) {
            byte b = bArr[i];
            if (b != 0) {
                pointAddVar(b < 0, pointPrecompZArr[(b >> 1) ^ (b >> 31)], pointAccum, pointTemp);
            }
            i--;
            if (i < 0) {
                return;
            } else {
                pointDouble(pointAccum);
            }
        }
    }

    private static void scalarMultStraus128Var(int[] iArr, int[] iArr2, PointAffine pointAffine, int[] iArr3, PointAffine pointAffine2, PointAccum pointAccum) {
        int i;
        precompute();
        byte[] bArr = new byte[256];
        int i2 = 128;
        byte[] bArr2 = new byte[128];
        byte[] bArr3 = new byte[128];
        AbstractC5865Wnaf.getSignedVar(iArr, 6, bArr);
        AbstractC5865Wnaf.getSignedVar(iArr2, 4, bArr2);
        AbstractC5865Wnaf.getSignedVar(iArr3, 4, bArr3);
        PointPrecompZ[] pointPrecompZArr = new PointPrecompZ[4];
        PointPrecompZ[] pointPrecompZArr2 = new PointPrecompZ[4];
        PointTemp pointTemp = new PointTemp();
        pointPrecomputeZ(pointAffine, pointPrecompZArr, 4, pointTemp);
        pointPrecomputeZ(pointAffine2, pointPrecompZArr2, 4, pointTemp);
        pointSetNeutral(pointAccum);
        while (true) {
            i = i2 - 1;
            if (i < 0 || (bArr[i] | bArr[i2 + 127] | bArr2[i] | bArr3[i]) != 0) {
                break;
            } else {
                i2 = i;
            }
        }
        while (i >= 0) {
            byte b = bArr[i];
            if (b != 0) {
                pointAddVar(b < 0, PRECOMP_BASE_WNAF[(b >> 1) ^ (b >> 31)], pointAccum, pointTemp);
            }
            byte b2 = bArr[i + 128];
            if (b2 != 0) {
                pointAddVar(b2 < 0, PRECOMP_BASE128_WNAF[(b2 >> 1) ^ (b2 >> 31)], pointAccum, pointTemp);
            }
            byte b3 = bArr2[i];
            if (b3 != 0) {
                pointAddVar(b3 < 0, pointPrecompZArr[(b3 >> 1) ^ (b3 >> 31)], pointAccum, pointTemp);
            }
            byte b4 = bArr3[i];
            if (b4 != 0) {
                pointAddVar(b4 < 0, pointPrecompZArr2[(b4 >> 1) ^ (b4 >> 31)], pointAccum, pointTemp);
            }
            pointDouble(pointAccum);
            i--;
        }
        pointDouble(pointAccum);
        pointDouble(pointAccum);
    }

    /* renamed from: sign */
    public static void m16851sign(byte[] bArr, int i, byte[] bArr2, int i2, int i3, byte[] bArr3, int i4) {
        implSign(bArr, i, null, (byte) 0, bArr2, i2, i3, bArr3, i4);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, InterfaceC5277Digest interfaceC5277Digest, byte[] bArr4, int i3) {
        byte[] bArr5 = new byte[64];
        if (64 != interfaceC5277Digest.mo14967doFinal(bArr5, 0)) {
            throw new IllegalArgumentException("ph");
        }
        implSign(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr5, 0, 64, bArr4, i3);
    }

    public static boolean validatePublicKeyFull(byte[] bArr, int i) {
        byte[] bArrM16849copy = m16849copy(bArr, i, 32);
        if (!checkPointFullVar(bArrM16849copy)) {
            return false;
        }
        PointAffine pointAffine = new PointAffine();
        if (decodePointVar(bArrM16849copy, false, pointAffine)) {
            return checkPointOrderVar(pointAffine);
        }
        return false;
    }

    public static PublicPoint validatePublicKeyFullExport(byte[] bArr, int i) {
        byte[] bArrM16849copy = m16849copy(bArr, i, 32);
        if (!checkPointFullVar(bArrM16849copy)) {
            return null;
        }
        PointAffine pointAffine = new PointAffine();
        if (decodePointVar(bArrM16849copy, false, pointAffine) && checkPointOrderVar(pointAffine)) {
            return exportPoint(pointAffine);
        }
        return null;
    }

    public static boolean validatePublicKeyPartial(byte[] bArr, int i) {
        byte[] bArrM16849copy = m16849copy(bArr, i, 32);
        if (checkPointFullVar(bArrM16849copy)) {
            return decodePointVar(bArrM16849copy, false, new PointAffine());
        }
        return false;
    }

    public static PublicPoint validatePublicKeyPartialExport(byte[] bArr, int i) {
        byte[] bArrM16849copy = m16849copy(bArr, i, 32);
        if (!checkPointFullVar(bArrM16849copy)) {
            return null;
        }
        PointAffine pointAffine = new PointAffine();
        if (decodePointVar(bArrM16849copy, false, pointAffine)) {
            return exportPoint(pointAffine);
        }
        return null;
    }

    /* renamed from: verify */
    public static boolean m16855verify(byte[] bArr, int i, PublicPoint publicPoint, byte[] bArr2, int i2, int i3) {
        return implVerify(bArr, i, publicPoint, null, (byte) 0, bArr2, i2, i3);
    }

    public static boolean verifyPrehash(byte[] bArr, int i, PublicPoint publicPoint, byte[] bArr2, InterfaceC5277Digest interfaceC5277Digest) {
        byte[] bArr3 = new byte[64];
        if (64 == interfaceC5277Digest.mo14967doFinal(bArr3, 0)) {
            return implVerify(bArr, i, publicPoint, bArr2, (byte) 1, bArr3, 0, 64);
        }
        throw new IllegalArgumentException("ph");
    }

    private static int checkPoint(PointAffine pointAffine) {
        int[] iArrM16794create = X25519Field.m16794create();
        int[] iArrM16794create2 = X25519Field.m16794create();
        int[] iArrM16794create3 = X25519Field.m16794create();
        X25519Field.m16814sqr(pointAffine.f22402x, iArrM16794create2);
        X25519Field.m16814sqr(pointAffine.f22403y, iArrM16794create3);
        X25519Field.m16809mul(iArrM16794create2, iArrM16794create3, iArrM16794create);
        X25519Field.m16815sub(iArrM16794create2, iArrM16794create3, iArrM16794create2);
        X25519Field.m16809mul(iArrM16794create, f22392C_d, iArrM16794create);
        X25519Field.m16787addOne(iArrM16794create);
        X25519Field.m16786add(iArrM16794create, iArrM16794create2, iArrM16794create);
        X25519Field.normalize(iArrM16794create);
        X25519Field.normalize(iArrM16794create3);
        return X25519Field.m16807isZero(iArrM16794create) & (~X25519Field.m16807isZero(iArrM16794create3));
    }

    public static void generatePublicKey(byte[] bArr, int i, byte[] bArr2, int i2) {
        InterfaceC5277Digest interfaceC5277DigestCreateDigest = createDigest();
        byte[] bArr3 = new byte[64];
        interfaceC5277DigestCreateDigest.mo14970update(bArr, i, 32);
        interfaceC5277DigestCreateDigest.mo14967doFinal(bArr3, 0);
        byte[] bArr4 = new byte[32];
        pruneScalar(bArr3, 0, bArr4);
        scalarMultBaseEncoded(bArr4, bArr2, i2);
    }

    private static void implSign(byte[] bArr, int i, byte[] bArr2, byte b, byte[] bArr3, int i2, int i3, byte[] bArr4, int i4) {
        if (!checkContextVar(bArr2, b)) {
            throw new IllegalArgumentException("ctx");
        }
        InterfaceC5277Digest interfaceC5277DigestCreateDigest = createDigest();
        byte[] bArr5 = new byte[64];
        interfaceC5277DigestCreateDigest.mo14970update(bArr, i, 32);
        interfaceC5277DigestCreateDigest.mo14967doFinal(bArr5, 0);
        byte[] bArr6 = new byte[32];
        pruneScalar(bArr5, 0, bArr6);
        byte[] bArr7 = new byte[32];
        scalarMultBaseEncoded(bArr6, bArr7, 0);
        implSign(interfaceC5277DigestCreateDigest, bArr5, bArr6, bArr7, 0, bArr2, b, bArr3, i2, i3, bArr4, i4);
    }

    private static boolean implVerify(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte b, byte[] bArr4, int i3, int i4) {
        if (!checkContextVar(bArr3, b)) {
            throw new IllegalArgumentException("ctx");
        }
        byte[] bArrM16849copy = m16849copy(bArr, i, 32);
        byte[] bArrM16849copy2 = m16849copy(bArr, i + 32, 32);
        byte[] bArrM16849copy3 = m16849copy(bArr2, i2, 32);
        if (!checkPointVar(bArrM16849copy)) {
            return false;
        }
        int[] iArr = new int[8];
        if (!Scalar25519.checkVar(bArrM16849copy2, iArr) || !checkPointFullVar(bArrM16849copy3)) {
            return false;
        }
        PointAffine pointAffine = new PointAffine();
        if (!decodePointVar(bArrM16849copy, true, pointAffine)) {
            return false;
        }
        PointAffine pointAffine2 = new PointAffine();
        if (!decodePointVar(bArrM16849copy3, true, pointAffine2)) {
            return false;
        }
        InterfaceC5277Digest interfaceC5277DigestCreateDigest = createDigest();
        byte[] bArr5 = new byte[64];
        if (bArr3 != null) {
            m16850dom2(interfaceC5277DigestCreateDigest, b, bArr3);
        }
        interfaceC5277DigestCreateDigest.mo14970update(bArrM16849copy, 0, 32);
        interfaceC5277DigestCreateDigest.mo14970update(bArrM16849copy3, 0, 32);
        interfaceC5277DigestCreateDigest.mo14970update(bArr4, i3, i4);
        interfaceC5277DigestCreateDigest.mo14967doFinal(bArr5, 0);
        int[] iArr2 = new int[8];
        Scalar25519.m16865decode(Scalar25519.reduce512(bArr5), iArr2);
        int[] iArr3 = new int[4];
        int[] iArr4 = new int[4];
        if (!Scalar25519.reduceBasisVar(iArr2, iArr3, iArr4)) {
            throw new IllegalStateException();
        }
        Scalar25519.multiply128Var(iArr, iArr4, iArr);
        PointAccum pointAccum = new PointAccum();
        scalarMultStraus128Var(iArr, iArr3, pointAffine2, iArr4, pointAffine, pointAccum);
        return normalizeToNeutralElementVar(pointAccum);
    }

    private static void pointAdd(PointPrecomp pointPrecomp, PointAccum pointAccum, PointTemp pointTemp) {
        int[] iArr = pointAccum.f22399x;
        int[] iArr2 = pointAccum.f22400y;
        int[] iArr3 = pointTemp.f22415r0;
        int[] iArr4 = pointAccum.f22397u;
        int[] iArr5 = pointAccum.f22398v;
        X25519Field.m16789apm(iArr2, iArr, iArr2, iArr);
        X25519Field.m16809mul(iArr, pointPrecomp.f22409ymx_h, iArr);
        X25519Field.m16809mul(iArr2, pointPrecomp.f22410ypx_h, iArr2);
        X25519Field.m16809mul(pointAccum.f22397u, pointAccum.f22398v, iArr3);
        X25519Field.m16809mul(iArr3, pointPrecomp.f22408xyd, iArr3);
        X25519Field.m16789apm(iArr2, iArr, iArr5, iArr4);
        X25519Field.m16789apm(pointAccum.f22401z, iArr3, iArr2, iArr);
        X25519Field.m16809mul(iArr, iArr2, pointAccum.f22401z);
        X25519Field.m16809mul(iArr, iArr4, pointAccum.f22399x);
        X25519Field.m16809mul(iArr2, iArr5, pointAccum.f22400y);
    }

    private static void pointAddVar(boolean z, PointPrecompZ pointPrecompZ, PointAccum pointAccum, PointTemp pointTemp) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3 = pointAccum.f22399x;
        int[] iArr4 = pointAccum.f22400y;
        int[] iArr5 = pointTemp.f22415r0;
        int[] iArr6 = pointAccum.f22401z;
        int[] iArr7 = pointAccum.f22397u;
        int[] iArr8 = pointAccum.f22398v;
        if (z) {
            iArr2 = iArr3;
            iArr = iArr4;
        } else {
            iArr = iArr3;
            iArr2 = iArr4;
        }
        X25519Field.m16789apm(iArr4, iArr3, iArr4, iArr3);
        X25519Field.m16809mul(iArr, pointPrecompZ.f22412ymx_h, iArr);
        X25519Field.m16809mul(iArr2, pointPrecompZ.f22413ypx_h, iArr2);
        X25519Field.m16809mul(pointAccum.f22397u, pointAccum.f22398v, iArr5);
        X25519Field.m16809mul(iArr5, pointPrecompZ.f22411xyd, iArr5);
        X25519Field.m16809mul(pointAccum.f22401z, pointPrecompZ.f22414z, iArr6);
        X25519Field.m16789apm(iArr4, iArr3, iArr8, iArr7);
        X25519Field.m16789apm(iArr6, iArr5, iArr2, iArr);
        X25519Field.m16809mul(iArr3, iArr4, pointAccum.f22401z);
        X25519Field.m16809mul(iArr3, iArr7, pointAccum.f22399x);
        X25519Field.m16809mul(iArr4, iArr8, pointAccum.f22400y);
    }

    private static void pointCopy(PointAffine pointAffine, PointExtended pointExtended) {
        X25519Field.m16793copy(pointAffine.f22402x, 0, pointExtended.f22405x, 0);
        X25519Field.m16793copy(pointAffine.f22403y, 0, pointExtended.f22406y, 0);
        X25519Field.m16811one(pointExtended.f22407z);
        X25519Field.m16809mul(pointAffine.f22402x, pointAffine.f22403y, pointExtended.f22404t);
    }

    private static int[] pointPrecomputeZ(PointAffine pointAffine, int i, PointTemp pointTemp) {
        PointExtended pointExtended = new PointExtended();
        pointCopy(pointAffine, pointExtended);
        PointExtended pointExtended2 = new PointExtended();
        pointAdd(pointExtended, pointExtended, pointExtended2, pointTemp);
        PointPrecompZ pointPrecompZ = new PointPrecompZ();
        int[] iArrCreateTable = X25519Field.createTable(i * 4);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            pointCopy(pointExtended, pointPrecompZ);
            X25519Field.m16793copy(pointPrecompZ.f22412ymx_h, 0, iArrCreateTable, i2);
            X25519Field.m16793copy(pointPrecompZ.f22413ypx_h, 0, iArrCreateTable, i2 + 10);
            X25519Field.m16793copy(pointPrecompZ.f22411xyd, 0, iArrCreateTable, i2 + 20);
            X25519Field.m16793copy(pointPrecompZ.f22414z, 0, iArrCreateTable, i2 + 30);
            i2 += 40;
            i3++;
            if (i3 == i) {
                return iArrCreateTable;
            }
            pointAdd(pointExtended, pointExtended2, pointExtended, pointTemp);
        }
    }

    /* renamed from: sign */
    public static void m16852sign(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3, int i4, byte[] bArr4, int i5) {
        implSign(bArr, i, bArr2, i2, null, (byte) 0, bArr3, i3, i4, bArr4, i5);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, byte[] bArr5, int i4) {
        implSign(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, i3, 64, bArr5, i4);
    }

    /* renamed from: verify */
    public static boolean m16856verify(byte[] bArr, int i, PublicPoint publicPoint, byte[] bArr2, byte[] bArr3, int i2, int i3) {
        return implVerify(bArr, i, publicPoint, bArr2, (byte) 0, bArr3, i2, i3);
    }

    public static boolean verifyPrehash(byte[] bArr, int i, PublicPoint publicPoint, byte[] bArr2, byte[] bArr3, int i2) {
        return implVerify(bArr, i, publicPoint, bArr2, (byte) 1, bArr3, i2, 64);
    }

    private static void implSign(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte b, byte[] bArr4, int i3, int i4, byte[] bArr5, int i5) {
        if (!checkContextVar(bArr3, b)) {
            throw new IllegalArgumentException("ctx");
        }
        InterfaceC5277Digest interfaceC5277DigestCreateDigest = createDigest();
        byte[] bArr6 = new byte[64];
        interfaceC5277DigestCreateDigest.mo14970update(bArr, i, 32);
        interfaceC5277DigestCreateDigest.mo14967doFinal(bArr6, 0);
        byte[] bArr7 = new byte[32];
        pruneScalar(bArr6, 0, bArr7);
        implSign(interfaceC5277DigestCreateDigest, bArr6, bArr7, bArr2, i2, bArr3, b, bArr4, i3, i4, bArr5, i5);
    }

    private static void pointAdd(PointPrecompZ pointPrecompZ, PointAccum pointAccum, PointTemp pointTemp) {
        int[] iArr = pointAccum.f22399x;
        int[] iArr2 = pointAccum.f22400y;
        int[] iArr3 = pointTemp.f22415r0;
        int[] iArr4 = pointAccum.f22401z;
        int[] iArr5 = pointAccum.f22397u;
        int[] iArr6 = pointAccum.f22398v;
        X25519Field.m16789apm(iArr2, iArr, iArr2, iArr);
        X25519Field.m16809mul(iArr, pointPrecompZ.f22412ymx_h, iArr);
        X25519Field.m16809mul(iArr2, pointPrecompZ.f22413ypx_h, iArr2);
        X25519Field.m16809mul(pointAccum.f22397u, pointAccum.f22398v, iArr3);
        X25519Field.m16809mul(iArr3, pointPrecompZ.f22411xyd, iArr3);
        X25519Field.m16809mul(pointAccum.f22401z, pointPrecompZ.f22414z, iArr4);
        X25519Field.m16789apm(iArr2, iArr, iArr6, iArr5);
        X25519Field.m16789apm(iArr4, iArr3, iArr2, iArr);
        X25519Field.m16809mul(iArr, iArr2, pointAccum.f22401z);
        X25519Field.m16809mul(iArr, iArr5, pointAccum.f22399x);
        X25519Field.m16809mul(iArr2, iArr6, pointAccum.f22400y);
    }

    private static void pointCopy(PointExtended pointExtended, PointPrecompZ pointPrecompZ) {
        X25519Field.m16789apm(pointExtended.f22406y, pointExtended.f22405x, pointPrecompZ.f22413ypx_h, pointPrecompZ.f22412ymx_h);
        X25519Field.m16809mul(pointExtended.f22404t, f22393C_d2, pointPrecompZ.f22411xyd);
        int[] iArr = pointExtended.f22407z;
        X25519Field.m16786add(iArr, iArr, pointPrecompZ.f22414z);
    }

    /* renamed from: sign */
    public static void m16853sign(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, int i4, byte[] bArr5, int i5) {
        implSign(bArr, i, bArr2, i2, bArr3, (byte) 0, bArr4, i3, i4, bArr5, i5);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, InterfaceC5277Digest interfaceC5277Digest, byte[] bArr3, int i2) {
        byte[] bArr4 = new byte[64];
        if (64 != interfaceC5277Digest.mo14967doFinal(bArr4, 0)) {
            throw new IllegalArgumentException("ph");
        }
        implSign(bArr, i, bArr2, (byte) 1, bArr4, 0, 64, bArr3, i2);
    }

    /* renamed from: verify */
    public static boolean m16857verify(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3, int i4) {
        return implVerify(bArr, i, bArr2, i2, null, (byte) 0, bArr3, i3, i4);
    }

    public static boolean verifyPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, InterfaceC5277Digest interfaceC5277Digest) {
        byte[] bArr4 = new byte[64];
        if (64 == interfaceC5277Digest.mo14967doFinal(bArr4, 0)) {
            return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, 0, 64);
        }
        throw new IllegalArgumentException("ph");
    }

    /* renamed from: sign */
    public static void m16854sign(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, int i2, int i3, byte[] bArr4, int i4) {
        implSign(bArr, i, bArr2, (byte) 0, bArr3, i2, i3, bArr4, i4);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, int i2, byte[] bArr4, int i3) {
        implSign(bArr, i, bArr2, (byte) 1, bArr3, i2, 64, bArr4, i3);
    }

    /* renamed from: verify */
    public static boolean m16858verify(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, int i4) {
        return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 0, bArr4, i3, i4);
    }

    public static boolean verifyPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3) {
        return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, i3, 64);
    }
}
