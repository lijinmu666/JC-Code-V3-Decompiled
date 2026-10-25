package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.AbstractECLookupTable;
import org.bouncycastle.p284math.p285ec.ECConstants;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p285ec.ECLookupTable;
import org.bouncycastle.p284math.p295raw.AbstractC5871Nat160;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class SecP160R2Curve extends AbstractC5817ECCurve.AbstractFp {
    private static final int SECP160R2_DEFAULT_COORDS = 2;
    protected SecP160R2Point infinity;

    /* renamed from: q */
    public static final BigInteger f22204q = SecP160R2FieldElement.f22213Q;
    private static final ECFieldElement[] SECP160R2_AFFINE_ZS = {new SecP160R2FieldElement(ECConstants.f22091ONE)};

    public SecP160R2Curve() {
        super(f22204q);
        this.infinity = new SecP160R2Point(this, null, null);
        this.f22095a = fromBigInteger(new BigInteger(1, C6255Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC70")));
        this.f22096b = fromBigInteger(new BigInteger(1, C6255Hex.decodeStrict("B4E134D3FB59EB8BAB57274904664D5AF50388BA")));
        this.f22099order = new BigInteger(1, C6255Hex.decodeStrict("0100000000000000000000351EE786A818F3A1A16B"));
        this.cofactor = BigInteger.valueOf(1L);
        this.f22097coord = 2;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5817ECCurve cloneCurve() {
        return new SecP160R2Curve();
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public ECLookupTable createCacheSafeLookupTable(AbstractC5820ECPoint[] abstractC5820ECPointArr, int i, final int i2) {
        final int[] iArr = new int[i2 * 10];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            AbstractC5820ECPoint abstractC5820ECPoint = abstractC5820ECPointArr[i + i4];
            AbstractC5871Nat160.m16987copy(((SecP160R2FieldElement) abstractC5820ECPoint.getRawXCoord()).f22214x, 0, iArr, i3);
            AbstractC5871Nat160.m16987copy(((SecP160R2FieldElement) abstractC5820ECPoint.getRawYCoord()).f22214x, 0, iArr, i3 + 5);
            i3 += 10;
        }
        return new AbstractECLookupTable(this) { // from class: org.bouncycastle.math.ec.custom.sec.SecP160R2Curve.1

            /* renamed from: this$0 */
            final /* synthetic */ SecP160R2Curve f22205this$0;

            {
                this.f22205this$0 = this;
            }

            private AbstractC5820ECPoint createPoint(int[] iArr2, int[] iArr3) {
                return this.f22205this$0.createRawPoint(new SecP160R2FieldElement(iArr2), new SecP160R2FieldElement(iArr3), SecP160R2Curve.SECP160R2_AFFINE_ZS);
            }

            @Override // org.bouncycastle.p284math.p285ec.ECLookupTable
            /* renamed from: getSize */
            public int mo16300getSize() {
                return i2;
            }

            @Override // org.bouncycastle.p284math.p285ec.ECLookupTable
            /* renamed from: lookup */
            public AbstractC5820ECPoint mo16301lookup(int i5) {
                int[] iArrM16989create = AbstractC5871Nat160.m16989create();
                int[] iArrM16989create2 = AbstractC5871Nat160.m16989create();
                int i6 = 0;
                for (int i7 = 0; i7 < i2; i7++) {
                    int i8 = ((i7 ^ i5) - 1) >> 31;
                    for (int i9 = 0; i9 < 5; i9++) {
                        int i10 = iArrM16989create[i9];
                        int[] iArr2 = iArr;
                        iArrM16989create[i9] = i10 ^ (iArr2[i6 + i9] & i8);
                        iArrM16989create2[i9] = iArrM16989create2[i9] ^ (iArr2[(i6 + 5) + i9] & i8);
                    }
                    i6 += 10;
                }
                return createPoint(iArrM16989create, iArrM16989create2);
            }

            @Override // org.bouncycastle.p284math.p285ec.AbstractECLookupTable, org.bouncycastle.p284math.p285ec.ECLookupTable
            public AbstractC5820ECPoint lookupVar(int i5) {
                int[] iArrM16989create = AbstractC5871Nat160.m16989create();
                int[] iArrM16989create2 = AbstractC5871Nat160.m16989create();
                int i6 = i5 * 10;
                for (int i7 = 0; i7 < 5; i7++) {
                    int[] iArr2 = iArr;
                    iArrM16989create[i7] = iArr2[i6 + i7];
                    iArrM16989create2[i7] = iArr2[5 + i6 + i7];
                }
                return createPoint(iArrM16989create, iArrM16989create2);
            }
        };
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5820ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecP160R2Point(this, eCFieldElement, eCFieldElement2);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecP160R2FieldElement(bigInteger);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public int getFieldSize() {
        return f22204q.bitLength();
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5820ECPoint getInfinity() {
        return this.infinity;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve.AbstractFp
    /* renamed from: getQ */
    public BigInteger mo16304getQ() {
        return f22204q;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve.AbstractFp, org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public ECFieldElement randomFieldElement(SecureRandom secureRandom) {
        int[] iArrM16989create = AbstractC5871Nat160.m16989create();
        SecP160R2Field.m16443random(secureRandom, iArrM16989create);
        return new SecP160R2FieldElement(iArrM16989create);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve.AbstractFp, org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public ECFieldElement randomFieldElementMult(SecureRandom secureRandom) {
        int[] iArrM16989create = AbstractC5871Nat160.m16989create();
        SecP160R2Field.randomMult(secureRandom, iArrM16989create);
        return new SecP160R2FieldElement(iArrM16989create);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public boolean supportsCoordinateSystem(int i) {
        return i == 2;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5820ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SecP160R2Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }
}
