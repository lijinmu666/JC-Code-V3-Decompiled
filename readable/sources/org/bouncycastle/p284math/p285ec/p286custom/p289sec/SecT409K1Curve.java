package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.AbstractECLookupTable;
import org.bouncycastle.p284math.p285ec.ECConstants;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p285ec.ECLookupTable;
import org.bouncycastle.p284math.p285ec.ECMultiplier;
import org.bouncycastle.p284math.p285ec.WTauNafMultiplier;
import org.bouncycastle.p284math.p295raw.AbstractC5877Nat448;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class SecT409K1Curve extends AbstractC5817ECCurve.AbstractF2m {
    private static final ECFieldElement[] SECT409K1_AFFINE_ZS = {new SecT409FieldElement(ECConstants.f22091ONE)};
    private static final int SECT409K1_DEFAULT_COORDS = 6;
    protected SecT409K1Point infinity;

    public SecT409K1Curve() {
        super(409, 87, 0, 0);
        this.infinity = new SecT409K1Point(this, null, null);
        this.f22095a = fromBigInteger(BigInteger.valueOf(0L));
        this.f22096b = fromBigInteger(BigInteger.valueOf(1L));
        this.f22099order = new BigInteger(1, C6255Hex.decodeStrict("7FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE5F83B2D4EA20400EC4557D5ED3E3E7CA5B4B5C83B8E01E5FCF"));
        this.cofactor = BigInteger.valueOf(4L);
        this.f22097coord = 6;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5817ECCurve cloneCurve() {
        return new SecT409K1Curve();
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public ECLookupTable createCacheSafeLookupTable(AbstractC5820ECPoint[] abstractC5820ECPointArr, int i, final int i2) {
        final long[] jArr = new long[i2 * 14];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            AbstractC5820ECPoint abstractC5820ECPoint = abstractC5820ECPointArr[i + i4];
            AbstractC5877Nat448.m17097copy64(((SecT409FieldElement) abstractC5820ECPoint.getRawXCoord()).f22351x, 0, jArr, i3);
            AbstractC5877Nat448.m17097copy64(((SecT409FieldElement) abstractC5820ECPoint.getRawYCoord()).f22351x, 0, jArr, i3 + 7);
            i3 += 14;
        }
        return new AbstractECLookupTable(this) { // from class: org.bouncycastle.math.ec.custom.sec.SecT409K1Curve.1

            /* renamed from: this$0 */
            final /* synthetic */ SecT409K1Curve f22352this$0;

            {
                this.f22352this$0 = this;
            }

            private AbstractC5820ECPoint createPoint(long[] jArr2, long[] jArr3) {
                return this.f22352this$0.createRawPoint(new SecT409FieldElement(jArr2), new SecT409FieldElement(jArr3), SecT409K1Curve.SECT409K1_AFFINE_ZS);
            }

            @Override // org.bouncycastle.p284math.p285ec.ECLookupTable
            /* renamed from: getSize */
            public int mo16300getSize() {
                return i2;
            }

            @Override // org.bouncycastle.p284math.p285ec.ECLookupTable
            /* renamed from: lookup */
            public AbstractC5820ECPoint mo16301lookup(int i5) {
                long[] jArrCreate64 = AbstractC5877Nat448.create64();
                long[] jArrCreate642 = AbstractC5877Nat448.create64();
                int i6 = 0;
                for (int i7 = 0; i7 < i2; i7++) {
                    long j = ((i7 ^ i5) - 1) >> 31;
                    for (int i8 = 0; i8 < 7; i8++) {
                        long j2 = jArrCreate64[i8];
                        long[] jArr2 = jArr;
                        jArrCreate64[i8] = j2 ^ (jArr2[i6 + i8] & j);
                        jArrCreate642[i8] = jArrCreate642[i8] ^ (jArr2[(i6 + 7) + i8] & j);
                    }
                    i6 += 14;
                }
                return createPoint(jArrCreate64, jArrCreate642);
            }

            @Override // org.bouncycastle.p284math.p285ec.AbstractECLookupTable, org.bouncycastle.p284math.p285ec.ECLookupTable
            public AbstractC5820ECPoint lookupVar(int i5) {
                long[] jArrCreate64 = AbstractC5877Nat448.create64();
                long[] jArrCreate642 = AbstractC5877Nat448.create64();
                int i6 = i5 * 14;
                for (int i7 = 0; i7 < 7; i7++) {
                    long[] jArr2 = jArr;
                    jArrCreate64[i7] = jArr2[i6 + i7];
                    jArrCreate642[i7] = jArr2[7 + i6 + i7];
                }
                return createPoint(jArrCreate64, jArrCreate642);
            }
        };
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public ECMultiplier createDefaultMultiplier() {
        return new WTauNafMultiplier();
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5820ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecT409K1Point(this, eCFieldElement, eCFieldElement2);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecT409FieldElement(bigInteger);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public int getFieldSize() {
        return 409;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5820ECPoint getInfinity() {
        return this.infinity;
    }

    /* renamed from: getK1 */
    public int m16744getK1() {
        return 87;
    }

    /* renamed from: getK2 */
    public int m16745getK2() {
        return 0;
    }

    /* renamed from: getK3 */
    public int m16746getK3() {
        return 0;
    }

    /* renamed from: getM */
    public int m16747getM() {
        return 409;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve.AbstractF2m
    public boolean isKoblitz() {
        return true;
    }

    public boolean isTrinomial() {
        return true;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public boolean supportsCoordinateSystem(int i) {
        return i == 6;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5820ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SecT409K1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }
}
