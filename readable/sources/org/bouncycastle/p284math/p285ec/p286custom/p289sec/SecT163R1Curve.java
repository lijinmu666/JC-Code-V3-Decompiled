package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.AbstractECLookupTable;
import org.bouncycastle.p284math.p285ec.ECConstants;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p285ec.ECLookupTable;
import org.bouncycastle.p284math.p295raw.AbstractC5872Nat192;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class SecT163R1Curve extends AbstractC5817ECCurve.AbstractF2m {
    private static final ECFieldElement[] SECT163R1_AFFINE_ZS = {new SecT163FieldElement(ECConstants.f22091ONE)};
    private static final int SECT163R1_DEFAULT_COORDS = 6;
    protected SecT163R1Point infinity;

    public SecT163R1Curve() {
        super(163, 3, 6, 7);
        this.infinity = new SecT163R1Point(this, null, null);
        this.f22095a = fromBigInteger(new BigInteger(1, C6255Hex.decodeStrict("07B6882CAAEFA84F9554FF8428BD88E246D2782AE2")));
        this.f22096b = fromBigInteger(new BigInteger(1, C6255Hex.decodeStrict("0713612DCDDCB40AAB946BDA29CA91F73AF958AFD9")));
        this.f22099order = new BigInteger(1, C6255Hex.decodeStrict("03FFFFFFFFFFFFFFFFFFFF48AAB689C29CA710279B"));
        this.cofactor = BigInteger.valueOf(2L);
        this.f22097coord = 6;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5817ECCurve cloneCurve() {
        return new SecT163R1Curve();
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public ECLookupTable createCacheSafeLookupTable(AbstractC5820ECPoint[] abstractC5820ECPointArr, int i, final int i2) {
        final long[] jArr = new long[i2 * 6];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            AbstractC5820ECPoint abstractC5820ECPoint = abstractC5820ECPointArr[i + i4];
            AbstractC5872Nat192.m17012copy64(((SecT163FieldElement) abstractC5820ECPoint.getRawXCoord()).f22315x, 0, jArr, i3);
            AbstractC5872Nat192.m17012copy64(((SecT163FieldElement) abstractC5820ECPoint.getRawYCoord()).f22315x, 0, jArr, i3 + 3);
            i3 += 6;
        }
        return new AbstractECLookupTable(this) { // from class: org.bouncycastle.math.ec.custom.sec.SecT163R1Curve.1

            /* renamed from: this$0 */
            final /* synthetic */ SecT163R1Curve f22318this$0;

            {
                this.f22318this$0 = this;
            }

            private AbstractC5820ECPoint createPoint(long[] jArr2, long[] jArr3) {
                return this.f22318this$0.createRawPoint(new SecT163FieldElement(jArr2), new SecT163FieldElement(jArr3), SecT163R1Curve.SECT163R1_AFFINE_ZS);
            }

            @Override // org.bouncycastle.p284math.p285ec.ECLookupTable
            /* renamed from: getSize */
            public int mo16300getSize() {
                return i2;
            }

            @Override // org.bouncycastle.p284math.p285ec.ECLookupTable
            /* renamed from: lookup */
            public AbstractC5820ECPoint mo16301lookup(int i5) {
                long[] jArrCreate64 = AbstractC5872Nat192.create64();
                long[] jArrCreate642 = AbstractC5872Nat192.create64();
                int i6 = 0;
                for (int i7 = 0; i7 < i2; i7++) {
                    long j = ((i7 ^ i5) - 1) >> 31;
                    for (int i8 = 0; i8 < 3; i8++) {
                        long j2 = jArrCreate64[i8];
                        long[] jArr2 = jArr;
                        jArrCreate64[i8] = j2 ^ (jArr2[i6 + i8] & j);
                        jArrCreate642[i8] = jArrCreate642[i8] ^ (jArr2[(i6 + 3) + i8] & j);
                    }
                    i6 += 6;
                }
                return createPoint(jArrCreate64, jArrCreate642);
            }

            @Override // org.bouncycastle.p284math.p285ec.AbstractECLookupTable, org.bouncycastle.p284math.p285ec.ECLookupTable
            public AbstractC5820ECPoint lookupVar(int i5) {
                long[] jArrCreate64 = AbstractC5872Nat192.create64();
                long[] jArrCreate642 = AbstractC5872Nat192.create64();
                int i6 = i5 * 6;
                for (int i7 = 0; i7 < 3; i7++) {
                    long[] jArr2 = jArr;
                    jArrCreate64[i7] = jArr2[i6 + i7];
                    jArrCreate642[i7] = jArr2[3 + i6 + i7];
                }
                return createPoint(jArrCreate64, jArrCreate642);
            }
        };
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5820ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecT163R1Point(this, eCFieldElement, eCFieldElement2);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecT163FieldElement(bigInteger);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public int getFieldSize() {
        return 163;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5820ECPoint getInfinity() {
        return this.infinity;
    }

    /* renamed from: getK1 */
    public int m16633getK1() {
        return 3;
    }

    /* renamed from: getK2 */
    public int m16634getK2() {
        return 6;
    }

    /* renamed from: getK3 */
    public int m16635getK3() {
        return 7;
    }

    /* renamed from: getM */
    public int m16636getM() {
        return 163;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve.AbstractF2m
    public boolean isKoblitz() {
        return false;
    }

    public boolean isTrinomial() {
        return false;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public boolean supportsCoordinateSystem(int i) {
        return i == 6;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5820ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SecT163R1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }
}
