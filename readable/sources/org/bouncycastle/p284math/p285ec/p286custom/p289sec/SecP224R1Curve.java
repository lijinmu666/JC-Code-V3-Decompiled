package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.AbstractECLookupTable;
import org.bouncycastle.p284math.p285ec.ECConstants;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p285ec.ECLookupTable;
import org.bouncycastle.p284math.p295raw.AbstractC5873Nat224;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class SecP224R1Curve extends AbstractC5817ECCurve.AbstractFp {
    private static final int SECP224R1_DEFAULT_COORDS = 2;
    protected SecP224R1Point infinity;

    /* renamed from: q */
    public static final BigInteger f22248q = SecP224R1FieldElement.f22257Q;
    private static final ECFieldElement[] SECP224R1_AFFINE_ZS = {new SecP224R1FieldElement(ECConstants.f22091ONE)};

    public SecP224R1Curve() {
        super(f22248q);
        this.infinity = new SecP224R1Point(this, null, null);
        this.f22095a = fromBigInteger(new BigInteger(1, C6255Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFE")));
        this.f22096b = fromBigInteger(new BigInteger(1, C6255Hex.decodeStrict("B4050A850C04B3ABF54132565044B0B7D7BFD8BA270B39432355FFB4")));
        this.f22099order = new BigInteger(1, C6255Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFF16A2E0B8F03E13DD29455C5C2A3D"));
        this.cofactor = BigInteger.valueOf(1L);
        this.f22097coord = 2;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5817ECCurve cloneCurve() {
        return new SecP224R1Curve();
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public ECLookupTable createCacheSafeLookupTable(AbstractC5820ECPoint[] abstractC5820ECPointArr, int i, final int i2) {
        final int[] iArr = new int[i2 * 14];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            AbstractC5820ECPoint abstractC5820ECPoint = abstractC5820ECPointArr[i + i4];
            AbstractC5873Nat224.m17039copy(((SecP224R1FieldElement) abstractC5820ECPoint.getRawXCoord()).f22258x, 0, iArr, i3);
            AbstractC5873Nat224.m17039copy(((SecP224R1FieldElement) abstractC5820ECPoint.getRawYCoord()).f22258x, 0, iArr, i3 + 7);
            i3 += 14;
        }
        return new AbstractECLookupTable(this) { // from class: org.bouncycastle.math.ec.custom.sec.SecP224R1Curve.1

            /* renamed from: this$0 */
            final /* synthetic */ SecP224R1Curve f22249this$0;

            {
                this.f22249this$0 = this;
            }

            private AbstractC5820ECPoint createPoint(int[] iArr2, int[] iArr3) {
                return this.f22249this$0.createRawPoint(new SecP224R1FieldElement(iArr2), new SecP224R1FieldElement(iArr3), SecP224R1Curve.SECP224R1_AFFINE_ZS);
            }

            @Override // org.bouncycastle.p284math.p285ec.ECLookupTable
            /* renamed from: getSize */
            public int mo16300getSize() {
                return i2;
            }

            @Override // org.bouncycastle.p284math.p285ec.ECLookupTable
            /* renamed from: lookup */
            public AbstractC5820ECPoint mo16301lookup(int i5) {
                int[] iArrM17041create = AbstractC5873Nat224.m17041create();
                int[] iArrM17041create2 = AbstractC5873Nat224.m17041create();
                int i6 = 0;
                for (int i7 = 0; i7 < i2; i7++) {
                    int i8 = ((i7 ^ i5) - 1) >> 31;
                    for (int i9 = 0; i9 < 7; i9++) {
                        int i10 = iArrM17041create[i9];
                        int[] iArr2 = iArr;
                        iArrM17041create[i9] = i10 ^ (iArr2[i6 + i9] & i8);
                        iArrM17041create2[i9] = iArrM17041create2[i9] ^ (iArr2[(i6 + 7) + i9] & i8);
                    }
                    i6 += 14;
                }
                return createPoint(iArrM17041create, iArrM17041create2);
            }

            @Override // org.bouncycastle.p284math.p285ec.AbstractECLookupTable, org.bouncycastle.p284math.p285ec.ECLookupTable
            public AbstractC5820ECPoint lookupVar(int i5) {
                int[] iArrM17041create = AbstractC5873Nat224.m17041create();
                int[] iArrM17041create2 = AbstractC5873Nat224.m17041create();
                int i6 = i5 * 14;
                for (int i7 = 0; i7 < 7; i7++) {
                    int[] iArr2 = iArr;
                    iArrM17041create[i7] = iArr2[i6 + i7];
                    iArrM17041create2[i7] = iArr2[7 + i6 + i7];
                }
                return createPoint(iArrM17041create, iArrM17041create2);
            }
        };
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5820ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecP224R1Point(this, eCFieldElement, eCFieldElement2);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecP224R1FieldElement(bigInteger);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public int getFieldSize() {
        return f22248q.bitLength();
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5820ECPoint getInfinity() {
        return this.infinity;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve.AbstractFp
    /* renamed from: getQ */
    public BigInteger mo16304getQ() {
        return f22248q;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve.AbstractFp, org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public ECFieldElement randomFieldElement(SecureRandom secureRandom) {
        int[] iArrM17041create = AbstractC5873Nat224.m17041create();
        SecP224R1Field.m16495random(secureRandom, iArrM17041create);
        return new SecP224R1FieldElement(iArrM17041create);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve.AbstractFp, org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public ECFieldElement randomFieldElementMult(SecureRandom secureRandom) {
        int[] iArrM17041create = AbstractC5873Nat224.m17041create();
        SecP224R1Field.randomMult(secureRandom, iArrM17041create);
        return new SecP224R1FieldElement(iArrM17041create);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public boolean supportsCoordinateSystem(int i) {
        return i == 2;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5820ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SecP224R1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }
}
