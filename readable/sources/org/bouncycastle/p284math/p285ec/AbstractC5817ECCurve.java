package org.bouncycastle.p284math.p285ec;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Random;
import java.util.Set;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p284math.AbstractC5816Primes;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p285ec.p290endo.ECEndomorphism;
import org.bouncycastle.p284math.p285ec.p290endo.GLVEndomorphism;
import org.bouncycastle.p284math.p294field.FiniteField;
import org.bouncycastle.p284math.p294field.FiniteFields;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.Integers;
import org.bouncycastle.p361util.Properties;

/* renamed from: org.bouncycastle.math.ec.ECCurve */
/* loaded from: classes2.dex */
public abstract class AbstractC5817ECCurve {
    public static final int COORD_AFFINE = 0;
    public static final int COORD_HOMOGENEOUS = 1;
    public static final int COORD_JACOBIAN = 2;
    public static final int COORD_JACOBIAN_CHUDNOVSKY = 3;
    public static final int COORD_JACOBIAN_MODIFIED = 4;
    public static final int COORD_LAMBDA_AFFINE = 5;
    public static final int COORD_LAMBDA_PROJECTIVE = 6;
    public static final int COORD_SKEWED = 7;

    /* renamed from: a */
    protected ECFieldElement f22095a;

    /* renamed from: b */
    protected ECFieldElement f22096b;
    protected BigInteger cofactor;

    /* renamed from: field */
    protected FiniteField f22098field;

    /* renamed from: order */
    protected BigInteger f22099order;

    /* renamed from: coord */
    protected int f22097coord = 0;
    protected ECEndomorphism endomorphism = null;
    protected ECMultiplier multiplier = null;

    /* renamed from: org.bouncycastle.math.ec.ECCurve$AbstractF2m */
    public static abstract class AbstractF2m extends AbstractC5817ECCurve {

        /* renamed from: si */
        private BigInteger[] f22102si;

        public AbstractF2m(int i, int i2, int i3, int i4) {
            super(buildField(i, i2, i3, i4));
            this.f22102si = null;
            if (Properties.isOverrideSet("org.bouncycastle.ec.disable")) {
                throw new UnsupportedOperationException("F2M disabled by \"org.bouncycastle.ec.disable\"");
            }
            if (Properties.isOverrideSet("org.bouncycastle.ec.disable_f2m")) {
                throw new UnsupportedOperationException("F2M disabled by \"org.bouncycastle.ec.disable_f2m\"");
            }
        }

        private static FiniteField buildField(int i, int i2, int i3, int i4) {
            if (i <= Properties.asInteger("org.bouncycastle.ec.max_f2m_field_size", 1142)) {
                return FiniteFields.getBinaryExtensionField((i3 | i4) == 0 ? new int[]{0, i2, i} : new int[]{0, i2, i3, i4, i});
            }
            throw new IllegalArgumentException("field size out of range: " + i);
        }

        private static BigInteger implRandomFieldElementMult(SecureRandom secureRandom, int i) {
            BigInteger bigIntegerCreateRandomBigInteger;
            do {
                bigIntegerCreateRandomBigInteger = BigIntegers.createRandomBigInteger(i, secureRandom);
            } while (bigIntegerCreateRandomBigInteger.signum() <= 0);
            return bigIntegerCreateRandomBigInteger;
        }

        /* renamed from: inverse */
        public static BigInteger m16302inverse(int i, int[] iArr, BigInteger bigInteger) {
            return new LongArray(bigInteger).modInverse(i, iArr).toBigInteger();
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
        public AbstractC5820ECPoint createPoint(BigInteger bigInteger, BigInteger bigInteger2) {
            ECFieldElement eCFieldElementFromBigInteger = fromBigInteger(bigInteger);
            ECFieldElement eCFieldElementFromBigInteger2 = fromBigInteger(bigInteger2);
            int coordinateSystem = getCoordinateSystem();
            if (coordinateSystem == 5 || coordinateSystem == 6) {
                if (!eCFieldElementFromBigInteger.mo16315isZero()) {
                    eCFieldElementFromBigInteger2 = eCFieldElementFromBigInteger2.mo16312divide(eCFieldElementFromBigInteger).mo16310add(eCFieldElementFromBigInteger);
                } else if (!eCFieldElementFromBigInteger2.mo16318square().equals(m16299getB())) {
                    throw new IllegalArgumentException();
                }
            }
            return createRawPoint(eCFieldElementFromBigInteger, eCFieldElementFromBigInteger2);
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
        public AbstractC5820ECPoint decompressPoint(int i, BigInteger bigInteger) {
            ECFieldElement eCFieldElementMo16310add;
            ECFieldElement eCFieldElementFromBigInteger = fromBigInteger(bigInteger);
            if (eCFieldElementFromBigInteger.mo16315isZero()) {
                eCFieldElementMo16310add = m16299getB().mo16317sqrt();
            } else {
                ECFieldElement eCFieldElementSolveQuadraticEquation = solveQuadraticEquation(eCFieldElementFromBigInteger.mo16318square().mo16313invert().multiply(m16299getB()).mo16310add(m16298getA()).mo16310add(eCFieldElementFromBigInteger));
                if (eCFieldElementSolveQuadraticEquation != null) {
                    if (eCFieldElementSolveQuadraticEquation.testBitZero() != (i == 1)) {
                        eCFieldElementSolveQuadraticEquation = eCFieldElementSolveQuadraticEquation.mo16311addOne();
                    }
                    int coordinateSystem = getCoordinateSystem();
                    eCFieldElementMo16310add = (coordinateSystem == 5 || coordinateSystem == 6) ? eCFieldElementSolveQuadraticEquation.mo16310add(eCFieldElementFromBigInteger) : eCFieldElementSolveQuadraticEquation.multiply(eCFieldElementFromBigInteger);
                } else {
                    eCFieldElementMo16310add = null;
                }
            }
            if (eCFieldElementMo16310add != null) {
                return createRawPoint(eCFieldElementFromBigInteger, eCFieldElementMo16310add);
            }
            throw new IllegalArgumentException("Invalid point compression");
        }

        /* renamed from: getSi */
        public synchronized BigInteger[] m16303getSi() {
            try {
                if (this.f22102si == null) {
                    this.f22102si = C5822Tnaf.m16375getSi(this);
                }
            } catch (Throwable th) {
                throw th;
            }
            return this.f22102si;
        }

        public boolean isKoblitz() {
            return this.f22099order != null && this.cofactor != null && this.f22096b.mo16314isOne() && (this.f22095a.mo16315isZero() || this.f22095a.mo16314isOne());
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
        public boolean isValidFieldElement(BigInteger bigInteger) {
            return bigInteger != null && bigInteger.signum() >= 0 && bigInteger.bitLength() <= getFieldSize();
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
        public ECFieldElement randomFieldElement(SecureRandom secureRandom) {
            return fromBigInteger(BigIntegers.createRandomBigInteger(getFieldSize(), secureRandom));
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
        public ECFieldElement randomFieldElementMult(SecureRandom secureRandom) {
            int fieldSize = getFieldSize();
            return fromBigInteger(implRandomFieldElementMult(secureRandom, fieldSize)).multiply(fromBigInteger(implRandomFieldElementMult(secureRandom, fieldSize)));
        }

        public ECFieldElement solveQuadraticEquation(ECFieldElement eCFieldElement) {
            ECFieldElement eCFieldElementMo16310add;
            ECFieldElement.AbstractF2m abstractF2m = (ECFieldElement.AbstractF2m) eCFieldElement;
            boolean zHasFastTrace = abstractF2m.hasFastTrace();
            if (zHasFastTrace && abstractF2m.mo16319trace() != 0) {
                return null;
            }
            int fieldSize = getFieldSize();
            if ((fieldSize & 1) != 0) {
                ECFieldElement eCFieldElementHalfTrace = abstractF2m.halfTrace();
                if (zHasFastTrace || eCFieldElementHalfTrace.mo16318square().mo16310add(eCFieldElementHalfTrace).mo16310add(eCFieldElement).mo16315isZero()) {
                    return eCFieldElementHalfTrace;
                }
                return null;
            }
            if (eCFieldElement.mo16315isZero()) {
                return eCFieldElement;
            }
            ECFieldElement eCFieldElementFromBigInteger = fromBigInteger(ECConstants.f22094ZERO);
            Random random = new Random();
            do {
                ECFieldElement eCFieldElementFromBigInteger2 = fromBigInteger(new BigInteger(fieldSize, random));
                ECFieldElement eCFieldElementMo16310add2 = eCFieldElement;
                eCFieldElementMo16310add = eCFieldElementFromBigInteger;
                for (int i = 1; i < fieldSize; i++) {
                    ECFieldElement eCFieldElementMo16318square = eCFieldElementMo16310add2.mo16318square();
                    eCFieldElementMo16310add = eCFieldElementMo16310add.mo16318square().mo16310add(eCFieldElementMo16318square.multiply(eCFieldElementFromBigInteger2));
                    eCFieldElementMo16310add2 = eCFieldElementMo16318square.mo16310add(eCFieldElement);
                }
                if (!eCFieldElementMo16310add2.mo16315isZero()) {
                    return null;
                }
            } while (eCFieldElementMo16310add.mo16318square().mo16310add(eCFieldElementMo16310add).mo16315isZero());
            return eCFieldElementMo16310add;
        }
    }

    /* renamed from: org.bouncycastle.math.ec.ECCurve$AbstractFp */
    public static abstract class AbstractFp extends AbstractC5817ECCurve {
        public AbstractFp(BigInteger bigInteger) {
            super(FiniteFields.getPrimeField(bigInteger));
        }

        private static BigInteger implRandomFieldElement(SecureRandom secureRandom, BigInteger bigInteger) {
            BigInteger bigIntegerCreateRandomBigInteger;
            do {
                bigIntegerCreateRandomBigInteger = BigIntegers.createRandomBigInteger(bigInteger.bitLength(), secureRandom);
            } while (bigIntegerCreateRandomBigInteger.compareTo(bigInteger) >= 0);
            return bigIntegerCreateRandomBigInteger;
        }

        private static BigInteger implRandomFieldElementMult(SecureRandom secureRandom, BigInteger bigInteger) {
            while (true) {
                BigInteger bigIntegerCreateRandomBigInteger = BigIntegers.createRandomBigInteger(bigInteger.bitLength(), secureRandom);
                if (bigIntegerCreateRandomBigInteger.signum() > 0 && bigIntegerCreateRandomBigInteger.compareTo(bigInteger) < 0) {
                    return bigIntegerCreateRandomBigInteger;
                }
            }
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
        public AbstractC5820ECPoint decompressPoint(int i, BigInteger bigInteger) {
            ECFieldElement eCFieldElementFromBigInteger = fromBigInteger(bigInteger);
            ECFieldElement eCFieldElementMo16317sqrt = eCFieldElementFromBigInteger.mo16318square().mo16310add(this.f22095a).multiply(eCFieldElementFromBigInteger).mo16310add(this.f22096b).mo16317sqrt();
            if (eCFieldElementMo16317sqrt == null) {
                throw new IllegalArgumentException("Invalid point compression");
            }
            if (eCFieldElementMo16317sqrt.testBitZero() != (i == 1)) {
                eCFieldElementMo16317sqrt = eCFieldElementMo16317sqrt.mo16316negate();
            }
            return createRawPoint(eCFieldElementFromBigInteger, eCFieldElementMo16317sqrt);
        }

        /* renamed from: getQ */
        public BigInteger mo16304getQ() {
            return getField().getCharacteristic();
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
        public boolean isValidFieldElement(BigInteger bigInteger) {
            return bigInteger != null && bigInteger.signum() >= 0 && bigInteger.compareTo(mo16304getQ()) < 0;
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
        public ECFieldElement randomFieldElement(SecureRandom secureRandom) {
            BigInteger bigIntegerMo16304getQ = mo16304getQ();
            return fromBigInteger(implRandomFieldElement(secureRandom, bigIntegerMo16304getQ)).multiply(fromBigInteger(implRandomFieldElement(secureRandom, bigIntegerMo16304getQ)));
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
        public ECFieldElement randomFieldElementMult(SecureRandom secureRandom) {
            BigInteger bigIntegerMo16304getQ = mo16304getQ();
            return fromBigInteger(implRandomFieldElementMult(secureRandom, bigIntegerMo16304getQ)).multiply(fromBigInteger(implRandomFieldElementMult(secureRandom, bigIntegerMo16304getQ)));
        }
    }

    /* renamed from: org.bouncycastle.math.ec.ECCurve$Config */
    public class Config {

        /* renamed from: coord */
        protected int f22103coord;
        protected ECEndomorphism endomorphism;
        protected ECMultiplier multiplier;

        public Config(int i, ECEndomorphism eCEndomorphism, ECMultiplier eCMultiplier) {
            this.f22103coord = i;
            this.endomorphism = eCEndomorphism;
            this.multiplier = eCMultiplier;
        }

        /* renamed from: create */
        public AbstractC5817ECCurve m16305create() {
            if (!AbstractC5817ECCurve.this.supportsCoordinateSystem(this.f22103coord)) {
                throw new IllegalStateException("unsupported coordinate system");
            }
            AbstractC5817ECCurve abstractC5817ECCurveCloneCurve = AbstractC5817ECCurve.this.cloneCurve();
            if (abstractC5817ECCurveCloneCurve == AbstractC5817ECCurve.this) {
                throw new IllegalStateException("implementation returned current curve");
            }
            synchronized (abstractC5817ECCurveCloneCurve) {
                abstractC5817ECCurveCloneCurve.f22097coord = this.f22103coord;
                abstractC5817ECCurveCloneCurve.endomorphism = this.endomorphism;
                abstractC5817ECCurveCloneCurve.multiplier = this.multiplier;
            }
            return abstractC5817ECCurveCloneCurve;
        }

        public Config setCoordinateSystem(int i) {
            this.f22103coord = i;
            return this;
        }

        public Config setEndomorphism(ECEndomorphism eCEndomorphism) {
            this.endomorphism = eCEndomorphism;
            return this;
        }

        public Config setMultiplier(ECMultiplier eCMultiplier) {
            this.multiplier = eCMultiplier;
            return this;
        }
    }

    /* renamed from: org.bouncycastle.math.ec.ECCurve$F2m */
    public static class F2m extends AbstractF2m {
        private static final int F2M_DEFAULT_COORDS = 6;
        private AbstractC5820ECPoint.F2m infinity;

        /* renamed from: k1 */
        private int f22105k1;

        /* renamed from: k2 */
        private int f22106k2;

        /* renamed from: k3 */
        private int f22107k3;

        /* renamed from: m */
        private int f22108m;

        @Deprecated
        public F2m(int i, int i2, int i3, int i4, BigInteger bigInteger, BigInteger bigInteger2) {
            this(i, i2, i3, i4, bigInteger, bigInteger2, (BigInteger) null, (BigInteger) null);
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
        public AbstractC5817ECCurve cloneCurve() {
            return new F2m(this.f22108m, this.f22105k1, this.f22106k2, this.f22107k3, this.f22095a, this.f22096b, this.f22099order, this.cofactor);
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
        public ECLookupTable createCacheSafeLookupTable(AbstractC5820ECPoint[] abstractC5820ECPointArr, int i, final int i2) {
            final int i3 = (this.f22108m + 63) >>> 6;
            final int[] iArr = isTrinomial() ? new int[]{this.f22105k1} : new int[]{this.f22105k1, this.f22106k2, this.f22107k3};
            final long[] jArr = new long[i2 * i3 * 2];
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                AbstractC5820ECPoint abstractC5820ECPoint = abstractC5820ECPointArr[i + i5];
                ((ECFieldElement.C5818F2m) abstractC5820ECPoint.getRawXCoord()).f22120x.m16355copyTo(jArr, i4);
                int i6 = i4 + i3;
                ((ECFieldElement.C5818F2m) abstractC5820ECPoint.getRawYCoord()).f22120x.m16355copyTo(jArr, i6);
                i4 = i6 + i3;
            }
            return new AbstractECLookupTable(this) { // from class: org.bouncycastle.math.ec.ECCurve.F2m.1

                /* renamed from: this$0 */
                final /* synthetic */ F2m f22109this$0;

                {
                    this.f22109this$0 = this;
                }

                private AbstractC5820ECPoint createPoint(long[] jArr2, long[] jArr3) {
                    return this.f22109this$0.createRawPoint(new ECFieldElement.C5818F2m(this.f22109this$0.f22108m, iArr, new LongArray(jArr2)), new ECFieldElement.C5818F2m(this.f22109this$0.f22108m, iArr, new LongArray(jArr3)));
                }

                @Override // org.bouncycastle.p284math.p285ec.ECLookupTable
                /* renamed from: getSize */
                public int mo16300getSize() {
                    return i2;
                }

                @Override // org.bouncycastle.p284math.p285ec.ECLookupTable
                /* renamed from: lookup */
                public AbstractC5820ECPoint mo16301lookup(int i7) {
                    int i8;
                    long[] jArrCreate64 = AbstractC5869Nat.create64(i3);
                    long[] jArrCreate642 = AbstractC5869Nat.create64(i3);
                    int i9 = 0;
                    for (int i10 = 0; i10 < i2; i10++) {
                        long j = ((i10 ^ i7) - 1) >> 31;
                        int i11 = 0;
                        while (true) {
                            i8 = i3;
                            if (i11 < i8) {
                                long j2 = jArrCreate64[i11];
                                long[] jArr2 = jArr;
                                jArrCreate64[i11] = j2 ^ (jArr2[i9 + i11] & j);
                                jArrCreate642[i11] = jArrCreate642[i11] ^ (jArr2[(i8 + i9) + i11] & j);
                                i11++;
                            }
                        }
                        i9 += i8 * 2;
                    }
                    return createPoint(jArrCreate64, jArrCreate642);
                }

                @Override // org.bouncycastle.p284math.p285ec.AbstractECLookupTable, org.bouncycastle.p284math.p285ec.ECLookupTable
                public AbstractC5820ECPoint lookupVar(int i7) {
                    long[] jArrCreate64 = AbstractC5869Nat.create64(i3);
                    long[] jArrCreate642 = AbstractC5869Nat.create64(i3);
                    int i8 = i7 * i3 * 2;
                    int i9 = 0;
                    while (true) {
                        int i10 = i3;
                        if (i9 >= i10) {
                            return createPoint(jArrCreate64, jArrCreate642);
                        }
                        long[] jArr2 = jArr;
                        jArrCreate64[i9] = jArr2[i8 + i9];
                        jArrCreate642[i9] = jArr2[i10 + i8 + i9];
                        i9++;
                    }
                }
            };
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
        public ECMultiplier createDefaultMultiplier() {
            return isKoblitz() ? new WTauNafMultiplier() : super.createDefaultMultiplier();
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
        public AbstractC5820ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            return new AbstractC5820ECPoint.F2m(this, eCFieldElement, eCFieldElement2);
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
        public ECFieldElement fromBigInteger(BigInteger bigInteger) {
            if (bigInteger != null && bigInteger.signum() >= 0) {
                int iBitLength = bigInteger.bitLength();
                int i = this.f22108m;
                if (iBitLength <= i) {
                    int i2 = this.f22106k2;
                    int i3 = this.f22107k3;
                    return new ECFieldElement.C5818F2m(i, (i2 | i3) == 0 ? new int[]{this.f22105k1} : new int[]{this.f22105k1, i2, i3}, new LongArray(bigInteger));
                }
            }
            throw new IllegalArgumentException("x value invalid in F2m field element");
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
        public int getFieldSize() {
            return this.f22108m;
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
        public AbstractC5820ECPoint getInfinity() {
            return this.infinity;
        }

        /* renamed from: getK1 */
        public int m16306getK1() {
            return this.f22105k1;
        }

        /* renamed from: getK2 */
        public int m16307getK2() {
            return this.f22106k2;
        }

        /* renamed from: getK3 */
        public int m16308getK3() {
            return this.f22107k3;
        }

        /* renamed from: getM */
        public int m16309getM() {
            return this.f22108m;
        }

        public boolean isTrinomial() {
            return this.f22106k2 == 0 && this.f22107k3 == 0;
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
        public boolean supportsCoordinateSystem(int i) {
            return i == 0 || i == 1 || i == 6;
        }

        public F2m(int i, int i2, int i3, int i4, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            super(i, i2, i3, i4);
            this.f22108m = i;
            this.f22105k1 = i2;
            this.f22106k2 = i3;
            this.f22107k3 = i4;
            this.f22099order = bigInteger3;
            this.cofactor = bigInteger4;
            this.infinity = new AbstractC5820ECPoint.F2m(this, null, null);
            this.f22095a = fromBigInteger(bigInteger);
            this.f22096b = fromBigInteger(bigInteger2);
            this.f22097coord = 6;
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
        public AbstractC5820ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            return new AbstractC5820ECPoint.F2m(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }

        public F2m(int i, int i2, int i3, int i4, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, BigInteger bigInteger, BigInteger bigInteger2) {
            super(i, i2, i3, i4);
            this.f22108m = i;
            this.f22105k1 = i2;
            this.f22106k2 = i3;
            this.f22107k3 = i4;
            this.f22099order = bigInteger;
            this.cofactor = bigInteger2;
            this.infinity = new AbstractC5820ECPoint.F2m(this, null, null);
            this.f22095a = eCFieldElement;
            this.f22096b = eCFieldElement2;
            this.f22097coord = 6;
        }

        @Deprecated
        public F2m(int i, int i2, BigInteger bigInteger, BigInteger bigInteger2) {
            this(i, i2, 0, 0, bigInteger, bigInteger2, (BigInteger) null, (BigInteger) null);
        }

        public F2m(int i, int i2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            this(i, i2, 0, 0, bigInteger, bigInteger2, bigInteger3, bigInteger4);
        }
    }

    /* renamed from: org.bouncycastle.math.ec.ECCurve$Fp */
    public static class Fp extends AbstractFp {
        private static final int FP_DEFAULT_COORDS = 4;

        /* renamed from: knownQs */
        private static final Set<BigInteger> f22112knownQs = Collections.synchronizedSet(new HashSet());
        private static final BigIntegers.C6239Cache validatedQs = new BigIntegers.C6239Cache();
        AbstractC5820ECPoint.Fp infinity;

        /* renamed from: q */
        BigInteger f22113q;

        /* renamed from: r */
        BigInteger f22114r;

        @Deprecated
        public Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            this(bigInteger, bigInteger2, bigInteger3, null, null);
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
        public AbstractC5817ECCurve cloneCurve() {
            return new Fp(this.f22113q, this.f22114r, this.f22095a, this.f22096b, this.f22099order, this.cofactor);
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
        public AbstractC5820ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            return new AbstractC5820ECPoint.Fp(this, eCFieldElement, eCFieldElement2);
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
        public ECFieldElement fromBigInteger(BigInteger bigInteger) {
            if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(this.f22113q) >= 0) {
                throw new IllegalArgumentException("x value invalid for Fp field element");
            }
            return new ECFieldElement.C5819Fp(this.f22113q, this.f22114r, bigInteger);
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
        public int getFieldSize() {
            return this.f22113q.bitLength();
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
        public AbstractC5820ECPoint getInfinity() {
            return this.infinity;
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve.AbstractFp
        /* renamed from: getQ */
        public BigInteger mo16304getQ() {
            return this.f22113q;
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
        public AbstractC5820ECPoint importPoint(AbstractC5820ECPoint abstractC5820ECPoint) {
            int coordinateSystem;
            return (this == abstractC5820ECPoint.getCurve() || getCoordinateSystem() != 2 || abstractC5820ECPoint.isInfinity() || !((coordinateSystem = abstractC5820ECPoint.getCurve().getCoordinateSystem()) == 2 || coordinateSystem == 3 || coordinateSystem == 4)) ? super.importPoint(abstractC5820ECPoint) : new AbstractC5820ECPoint.Fp(this, fromBigInteger(abstractC5820ECPoint.f22125x.toBigInteger()), fromBigInteger(abstractC5820ECPoint.f22126y.toBigInteger()), new ECFieldElement[]{fromBigInteger(abstractC5820ECPoint.f22127zs[0].toBigInteger())});
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
        public boolean supportsCoordinateSystem(int i) {
            return i == 0 || i == 1 || i == 2 || i == 4;
        }

        public Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
            this(bigInteger, bigInteger2, bigInteger3, bigInteger4, bigInteger5, false);
        }

        @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
        public AbstractC5820ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
            return new AbstractC5820ECPoint.Fp(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
        }

        public Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, boolean z) {
            super(bigInteger);
            if (z) {
                f22112knownQs.add(bigInteger);
            } else if (!f22112knownQs.contains(bigInteger)) {
                BigIntegers.C6239Cache c6239Cache = validatedQs;
                if (!c6239Cache.contains(bigInteger)) {
                    int iAsInteger = Properties.asInteger("org.bouncycastle.ec.fp_max_size", 1042);
                    int iAsInteger2 = Properties.asInteger("org.bouncycastle.ec.fp_certainty", 100);
                    int iBitLength = bigInteger.bitLength();
                    if (iAsInteger < iBitLength) {
                        throw new IllegalArgumentException("Fp q value out of range");
                    }
                    if (AbstractC5816Primes.hasAnySmallFactors(bigInteger) || !AbstractC5816Primes.isMRProbablePrime(bigInteger, CryptoServicesRegistrar.getSecureRandom(), AbstractC5817ECCurve.getNumberOfIterations(iBitLength, iAsInteger2))) {
                        throw new IllegalArgumentException("Fp q value not prime");
                    }
                    c6239Cache.m18269add(bigInteger);
                }
            }
            this.f22113q = bigInteger;
            this.f22114r = ECFieldElement.C5819Fp.calculateResidue(bigInteger);
            this.infinity = new AbstractC5820ECPoint.Fp(this, null, null);
            this.f22095a = fromBigInteger(bigInteger2);
            this.f22096b = fromBigInteger(bigInteger3);
            this.f22099order = bigInteger4;
            this.cofactor = bigInteger5;
            this.f22097coord = 4;
        }

        public Fp(BigInteger bigInteger, BigInteger bigInteger2, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, BigInteger bigInteger3, BigInteger bigInteger4) {
            super(bigInteger);
            this.f22113q = bigInteger;
            this.f22114r = bigInteger2;
            this.infinity = new AbstractC5820ECPoint.Fp(this, null, null);
            this.f22095a = eCFieldElement;
            this.f22096b = eCFieldElement2;
            this.f22099order = bigInteger3;
            this.cofactor = bigInteger4;
            this.f22097coord = 4;
        }
    }

    public AbstractC5817ECCurve(FiniteField finiteField) {
        this.f22098field = finiteField;
    }

    public static int[] getAllCoordinateSystems() {
        return new int[]{0, 1, 2, 3, 4, 5, 6, 7};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getNumberOfIterations(int i, int i2) {
        if (i >= 1536) {
            if (i2 <= 100) {
                return 3;
            }
            if (i2 <= 128) {
                return 4;
            }
            return 4 + ((i2 - 127) / 2);
        }
        if (i >= 1024) {
            if (i2 <= 100) {
                return 4;
            }
            if (i2 <= 112) {
                return 5;
            }
            return ((i2 - 111) / 2) + 5;
        }
        if (i < 512) {
            if (i2 <= 80) {
                return 40;
            }
            return 40 + ((i2 - 79) / 2);
        }
        if (i2 <= 80) {
            return 5;
        }
        if (i2 <= 100) {
            return 7;
        }
        return 7 + ((i2 - 99) / 2);
    }

    public void checkPoint(AbstractC5820ECPoint abstractC5820ECPoint) {
        if (abstractC5820ECPoint == null || this != abstractC5820ECPoint.getCurve()) {
            throw new IllegalArgumentException("'point' must be non-null and on this curve");
        }
    }

    public void checkPoints(AbstractC5820ECPoint[] abstractC5820ECPointArr) {
        checkPoints(abstractC5820ECPointArr, 0, abstractC5820ECPointArr.length);
    }

    public abstract AbstractC5817ECCurve cloneCurve();

    public synchronized Config configure() {
        return new Config(this.f22097coord, this.endomorphism, this.multiplier);
    }

    public ECLookupTable createCacheSafeLookupTable(AbstractC5820ECPoint[] abstractC5820ECPointArr, int i, final int i2) {
        final int fieldElementEncodingLength = getFieldElementEncodingLength();
        final byte[] bArr = new byte[i2 * fieldElementEncodingLength * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            AbstractC5820ECPoint abstractC5820ECPoint = abstractC5820ECPointArr[i + i4];
            abstractC5820ECPoint.getRawXCoord().encodeTo(bArr, i3);
            int i5 = i3 + fieldElementEncodingLength;
            abstractC5820ECPoint.getRawYCoord().encodeTo(bArr, i5);
            i3 = i5 + fieldElementEncodingLength;
        }
        return new AbstractECLookupTable(this) { // from class: org.bouncycastle.math.ec.ECCurve.1

            /* renamed from: this$0 */
            final /* synthetic */ AbstractC5817ECCurve f22100this$0;

            {
                this.f22100this$0 = this;
            }

            private AbstractC5820ECPoint createPoint(byte[] bArr2, byte[] bArr3) {
                AbstractC5817ECCurve abstractC5817ECCurve = this.f22100this$0;
                return abstractC5817ECCurve.createRawPoint(abstractC5817ECCurve.fromBigInteger(new BigInteger(1, bArr2)), this.f22100this$0.fromBigInteger(new BigInteger(1, bArr3)));
            }

            @Override // org.bouncycastle.p284math.p285ec.ECLookupTable
            /* renamed from: getSize */
            public int mo16300getSize() {
                return i2;
            }

            @Override // org.bouncycastle.p284math.p285ec.ECLookupTable
            /* renamed from: lookup */
            public AbstractC5820ECPoint mo16301lookup(int i6) {
                int i7;
                int i8 = fieldElementEncodingLength;
                byte[] bArr2 = new byte[i8];
                byte[] bArr3 = new byte[i8];
                int i9 = 0;
                for (int i10 = 0; i10 < i2; i10++) {
                    int i11 = ((i10 ^ i6) - 1) >> 31;
                    int i12 = 0;
                    while (true) {
                        i7 = fieldElementEncodingLength;
                        if (i12 < i7) {
                            byte b = bArr2[i12];
                            byte[] bArr4 = bArr;
                            bArr2[i12] = (byte) (b ^ (bArr4[i9 + i12] & i11));
                            bArr3[i12] = (byte) ((bArr4[(i7 + i9) + i12] & i11) ^ bArr3[i12]);
                            i12++;
                        }
                    }
                    i9 += i7 * 2;
                }
                return createPoint(bArr2, bArr3);
            }

            @Override // org.bouncycastle.p284math.p285ec.AbstractECLookupTable, org.bouncycastle.p284math.p285ec.ECLookupTable
            public AbstractC5820ECPoint lookupVar(int i6) {
                int i7 = fieldElementEncodingLength;
                byte[] bArr2 = new byte[i7];
                byte[] bArr3 = new byte[i7];
                int i8 = i6 * i7 * 2;
                int i9 = 0;
                while (true) {
                    int i10 = fieldElementEncodingLength;
                    if (i9 >= i10) {
                        return createPoint(bArr2, bArr3);
                    }
                    byte[] bArr4 = bArr;
                    bArr2[i9] = bArr4[i8 + i9];
                    bArr3[i9] = bArr4[i10 + i8 + i9];
                    i9++;
                }
            }
        };
    }

    public ECMultiplier createDefaultMultiplier() {
        ECEndomorphism eCEndomorphism = this.endomorphism;
        return eCEndomorphism instanceof GLVEndomorphism ? new GLVMultiplier(this, (GLVEndomorphism) eCEndomorphism) : new WNafL2RMultiplier();
    }

    public AbstractC5820ECPoint createPoint(BigInteger bigInteger, BigInteger bigInteger2) {
        return createRawPoint(fromBigInteger(bigInteger), fromBigInteger(bigInteger2));
    }

    public abstract AbstractC5820ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2);

    public abstract AbstractC5820ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr);

    public AbstractC5820ECPoint decodePoint(byte[] bArr) {
        AbstractC5820ECPoint infinity;
        int fieldElementEncodingLength = getFieldElementEncodingLength();
        byte b = bArr[0];
        if (b != 0) {
            if (b == 2 || b == 3) {
                if (bArr.length != fieldElementEncodingLength + 1) {
                    throw new IllegalArgumentException("Incorrect length for compressed encoding");
                }
                infinity = decompressPoint(b & 1, BigIntegers.fromUnsignedByteArray(bArr, 1, fieldElementEncodingLength));
                if (!infinity.implIsValid(true, true)) {
                    throw new IllegalArgumentException("Invalid point");
                }
            } else if (b != 4) {
                if (b != 6 && b != 7) {
                    throw new IllegalArgumentException("Invalid point encoding 0x" + Integer.toString(b, 16));
                }
                if (bArr.length != (fieldElementEncodingLength * 2) + 1) {
                    throw new IllegalArgumentException("Incorrect length for hybrid encoding");
                }
                BigInteger bigIntegerFromUnsignedByteArray = BigIntegers.fromUnsignedByteArray(bArr, 1, fieldElementEncodingLength);
                BigInteger bigIntegerFromUnsignedByteArray2 = BigIntegers.fromUnsignedByteArray(bArr, fieldElementEncodingLength + 1, fieldElementEncodingLength);
                if (bigIntegerFromUnsignedByteArray2.testBit(0) != (b == 7)) {
                    throw new IllegalArgumentException("Inconsistent Y coordinate in hybrid encoding");
                }
                infinity = validatePoint(bigIntegerFromUnsignedByteArray, bigIntegerFromUnsignedByteArray2);
            } else {
                if (bArr.length != (fieldElementEncodingLength * 2) + 1) {
                    throw new IllegalArgumentException("Incorrect length for uncompressed encoding");
                }
                infinity = validatePoint(BigIntegers.fromUnsignedByteArray(bArr, 1, fieldElementEncodingLength), BigIntegers.fromUnsignedByteArray(bArr, fieldElementEncodingLength + 1, fieldElementEncodingLength));
            }
        } else {
            if (bArr.length != 1) {
                throw new IllegalArgumentException("Incorrect length for infinity encoding");
            }
            infinity = getInfinity();
        }
        if (b == 0 || !infinity.isInfinity()) {
            return infinity;
        }
        throw new IllegalArgumentException("Invalid infinity encoding");
    }

    public abstract AbstractC5820ECPoint decompressPoint(int i, BigInteger bigInteger);

    /* renamed from: equals */
    public boolean m16296equals(Object obj) {
        return this == obj || ((obj instanceof AbstractC5817ECCurve) && m16297equals((AbstractC5817ECCurve) obj));
    }

    public abstract ECFieldElement fromBigInteger(BigInteger bigInteger);

    /* renamed from: getA */
    public ECFieldElement m16298getA() {
        return this.f22095a;
    }

    public int getAffinePointEncodingLength(boolean z) {
        int fieldElementEncodingLength = getFieldElementEncodingLength();
        if (!z) {
            fieldElementEncodingLength *= 2;
        }
        return fieldElementEncodingLength + 1;
    }

    /* renamed from: getB */
    public ECFieldElement m16299getB() {
        return this.f22096b;
    }

    public BigInteger getCofactor() {
        return this.cofactor;
    }

    public int getCoordinateSystem() {
        return this.f22097coord;
    }

    public ECEndomorphism getEndomorphism() {
        return this.endomorphism;
    }

    public FiniteField getField() {
        return this.f22098field;
    }

    public int getFieldElementEncodingLength() {
        return (getFieldSize() + 7) / 8;
    }

    public abstract int getFieldSize();

    public abstract AbstractC5820ECPoint getInfinity();

    public ECMultiplier getMultiplier() {
        if (this.multiplier == null) {
            this.multiplier = createDefaultMultiplier();
        }
        return this.multiplier;
    }

    public BigInteger getOrder() {
        return this.f22099order;
    }

    public PreCompInfo getPreCompInfo(AbstractC5820ECPoint abstractC5820ECPoint, String str) {
        Hashtable hashtable;
        PreCompInfo preCompInfo;
        checkPoint(abstractC5820ECPoint);
        synchronized (abstractC5820ECPoint) {
            hashtable = abstractC5820ECPoint.preCompTable;
        }
        if (hashtable == null) {
            return null;
        }
        synchronized (hashtable) {
            preCompInfo = (PreCompInfo) hashtable.get(str);
        }
        return preCompInfo;
    }

    public int hashCode() {
        return Integers.rotateLeft(m16299getB().toBigInteger().hashCode(), 16) ^ (getField().hashCode() ^ Integers.rotateLeft(m16298getA().toBigInteger().hashCode(), 8));
    }

    public AbstractC5820ECPoint importPoint(AbstractC5820ECPoint abstractC5820ECPoint) {
        if (this == abstractC5820ECPoint.getCurve()) {
            return abstractC5820ECPoint;
        }
        if (abstractC5820ECPoint.isInfinity()) {
            return getInfinity();
        }
        AbstractC5820ECPoint abstractC5820ECPointNormalize = abstractC5820ECPoint.normalize();
        return createPoint(abstractC5820ECPointNormalize.getXCoord().toBigInteger(), abstractC5820ECPointNormalize.getYCoord().toBigInteger());
    }

    public abstract boolean isValidFieldElement(BigInteger bigInteger);

    public void normalizeAll(AbstractC5820ECPoint[] abstractC5820ECPointArr) {
        normalizeAll(abstractC5820ECPointArr, 0, abstractC5820ECPointArr.length, null);
    }

    public PreCompInfo precompute(AbstractC5820ECPoint abstractC5820ECPoint, String str, PreCompCallback preCompCallback) {
        Hashtable hashtable;
        PreCompInfo preCompInfoPrecompute;
        checkPoint(abstractC5820ECPoint);
        synchronized (abstractC5820ECPoint) {
            try {
                hashtable = abstractC5820ECPoint.preCompTable;
                if (hashtable == null) {
                    hashtable = new Hashtable(4);
                    abstractC5820ECPoint.preCompTable = hashtable;
                }
            } finally {
            }
        }
        synchronized (hashtable) {
            try {
                PreCompInfo preCompInfo = (PreCompInfo) hashtable.get(str);
                preCompInfoPrecompute = preCompCallback.precompute(preCompInfo);
                if (preCompInfoPrecompute != preCompInfo) {
                    hashtable.put(str, preCompInfoPrecompute);
                }
            } finally {
            }
        }
        return preCompInfoPrecompute;
    }

    public abstract ECFieldElement randomFieldElement(SecureRandom secureRandom);

    public abstract ECFieldElement randomFieldElementMult(SecureRandom secureRandom);

    public boolean supportsCoordinateSystem(int i) {
        return i == 0;
    }

    public AbstractC5820ECPoint validatePoint(BigInteger bigInteger, BigInteger bigInteger2) {
        AbstractC5820ECPoint abstractC5820ECPointCreatePoint = createPoint(bigInteger, bigInteger2);
        if (abstractC5820ECPointCreatePoint.m16334isValid()) {
            return abstractC5820ECPointCreatePoint;
        }
        throw new IllegalArgumentException("Invalid point coordinates");
    }

    public void checkPoints(AbstractC5820ECPoint[] abstractC5820ECPointArr, int i, int i2) {
        if (abstractC5820ECPointArr == null) {
            throw new IllegalArgumentException("'points' cannot be null");
        }
        if (i < 0 || i2 < 0 || i > abstractC5820ECPointArr.length - i2) {
            throw new IllegalArgumentException("invalid range specified for 'points'");
        }
        for (int i3 = 0; i3 < i2; i3++) {
            AbstractC5820ECPoint abstractC5820ECPoint = abstractC5820ECPointArr[i + i3];
            if (abstractC5820ECPoint != null && this != abstractC5820ECPoint.getCurve()) {
                throw new IllegalArgumentException("'points' entries must be null or on this curve");
            }
        }
    }

    /* renamed from: equals */
    public boolean m16297equals(AbstractC5817ECCurve abstractC5817ECCurve) {
        return this == abstractC5817ECCurve || (abstractC5817ECCurve != null && getField().equals(abstractC5817ECCurve.getField()) && m16298getA().toBigInteger().equals(abstractC5817ECCurve.m16298getA().toBigInteger()) && m16299getB().toBigInteger().equals(abstractC5817ECCurve.m16299getB().toBigInteger()));
    }

    public void normalizeAll(AbstractC5820ECPoint[] abstractC5820ECPointArr, int i, int i2, ECFieldElement eCFieldElement) {
        checkPoints(abstractC5820ECPointArr, i, i2);
        int coordinateSystem = getCoordinateSystem();
        if (coordinateSystem == 0 || coordinateSystem == 5) {
            if (eCFieldElement != null) {
                throw new IllegalArgumentException("'iso' not valid for affine coordinates");
            }
            return;
        }
        ECFieldElement[] eCFieldElementArr = new ECFieldElement[i2];
        int[] iArr = new int[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i + i4;
            AbstractC5820ECPoint abstractC5820ECPoint = abstractC5820ECPointArr[i5];
            if (abstractC5820ECPoint != null && (eCFieldElement != null || !abstractC5820ECPoint.isNormalized())) {
                eCFieldElementArr[i3] = abstractC5820ECPoint.getZCoord(0);
                iArr[i3] = i5;
                i3++;
            }
        }
        if (i3 == 0) {
            return;
        }
        ECAlgorithms.montgomeryTrick(eCFieldElementArr, 0, i3, eCFieldElement);
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = iArr[i6];
            abstractC5820ECPointArr[i7] = abstractC5820ECPointArr[i7].normalize(eCFieldElementArr[i6]);
        }
    }
}
