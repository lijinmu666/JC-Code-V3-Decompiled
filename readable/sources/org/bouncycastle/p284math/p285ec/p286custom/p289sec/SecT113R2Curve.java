package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.AbstractECLookupTable;
import org.bouncycastle.p284math.p285ec.ECConstants;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p285ec.ECLookupTable;
import org.bouncycastle.p284math.p295raw.AbstractC5870Nat128;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class SecT113R2Curve extends AbstractC5817ECCurve.AbstractF2m {
    private static final ECFieldElement[] SECT113R2_AFFINE_ZS = {new SecT113FieldElement(ECConstants.f22091ONE)};
    private static final int SECT113R2_DEFAULT_COORDS = 6;
    protected SecT113R2Point infinity;

    public SecT113R2Curve() {
        super(113, 9, 0, 0);
        this.infinity = new SecT113R2Point(this, null, null);
        this.f22095a = fromBigInteger(new BigInteger(1, C6255Hex.decodeStrict("00689918DBEC7E5A0DD6DFC0AA55C7")));
        this.f22096b = fromBigInteger(new BigInteger(1, C6255Hex.decodeStrict("0095E9A9EC9B297BD4BF36E059184F")));
        this.f22099order = new BigInteger(1, C6255Hex.decodeStrict("010000000000000108789B2496AF93"));
        this.cofactor = BigInteger.valueOf(2L);
        this.f22097coord = 6;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5817ECCurve cloneCurve() {
        return new SecT113R2Curve();
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public ECLookupTable createCacheSafeLookupTable(AbstractC5820ECPoint[] abstractC5820ECPointArr, int i, final int i2) {
        final long[] jArr = new long[i2 * 4];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            AbstractC5820ECPoint abstractC5820ECPoint = abstractC5820ECPointArr[i + i4];
            AbstractC5870Nat128.m16962copy64(((SecT113FieldElement) abstractC5820ECPoint.getRawXCoord()).f22299x, 0, jArr, i3);
            AbstractC5870Nat128.m16962copy64(((SecT113FieldElement) abstractC5820ECPoint.getRawYCoord()).f22299x, 0, jArr, i3 + 2);
            i3 += 4;
        }
        return new AbstractECLookupTable(this) { // from class: org.bouncycastle.math.ec.custom.sec.SecT113R2Curve.1

            /* renamed from: this$0 */
            final /* synthetic */ SecT113R2Curve f22302this$0;

            {
                this.f22302this$0 = this;
            }

            private AbstractC5820ECPoint createPoint(long[] jArr2, long[] jArr3) {
                return this.f22302this$0.createRawPoint(new SecT113FieldElement(jArr2), new SecT113FieldElement(jArr3), SecT113R2Curve.SECT113R2_AFFINE_ZS);
            }

            @Override // org.bouncycastle.p284math.p285ec.ECLookupTable
            /* renamed from: getSize */
            public int mo16300getSize() {
                return i2;
            }

            @Override // org.bouncycastle.p284math.p285ec.ECLookupTable
            /* renamed from: lookup */
            public AbstractC5820ECPoint mo16301lookup(int i5) {
                long[] jArrCreate64 = AbstractC5870Nat128.create64();
                long[] jArrCreate642 = AbstractC5870Nat128.create64();
                int i6 = 0;
                for (int i7 = 0; i7 < i2; i7++) {
                    long j = ((i7 ^ i5) - 1) >> 31;
                    for (int i8 = 0; i8 < 2; i8++) {
                        long j2 = jArrCreate64[i8];
                        long[] jArr2 = jArr;
                        jArrCreate64[i8] = j2 ^ (jArr2[i6 + i8] & j);
                        jArrCreate642[i8] = jArrCreate642[i8] ^ (jArr2[(i6 + 2) + i8] & j);
                    }
                    i6 += 4;
                }
                return createPoint(jArrCreate64, jArrCreate642);
            }

            @Override // org.bouncycastle.p284math.p285ec.AbstractECLookupTable, org.bouncycastle.p284math.p285ec.ECLookupTable
            public AbstractC5820ECPoint lookupVar(int i5) {
                long[] jArrCreate64 = AbstractC5870Nat128.create64();
                long[] jArrCreate642 = AbstractC5870Nat128.create64();
                int i6 = i5 * 4;
                for (int i7 = 0; i7 < 2; i7++) {
                    long[] jArr2 = jArr;
                    jArrCreate64[i7] = jArr2[i6 + i7];
                    jArrCreate642[i7] = jArr2[2 + i6 + i7];
                }
                return createPoint(jArrCreate64, jArrCreate642);
            }
        };
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5820ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecT113R2Point(this, eCFieldElement, eCFieldElement2);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecT113FieldElement(bigInteger);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public int getFieldSize() {
        return 113;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5820ECPoint getInfinity() {
        return this.infinity;
    }

    /* renamed from: getK1 */
    public int m16587getK1() {
        return 9;
    }

    /* renamed from: getK2 */
    public int m16588getK2() {
        return 0;
    }

    /* renamed from: getK3 */
    public int m16589getK3() {
        return 0;
    }

    /* renamed from: getM */
    public int m16590getM() {
        return 113;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve.AbstractF2m
    public boolean isKoblitz() {
        return false;
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
        return new SecT113R2Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }
}
