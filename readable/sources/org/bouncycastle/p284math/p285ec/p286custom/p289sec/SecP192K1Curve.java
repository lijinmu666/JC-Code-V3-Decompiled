package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.AbstractECLookupTable;
import org.bouncycastle.p284math.p285ec.ECConstants;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p285ec.ECLookupTable;
import org.bouncycastle.p284math.p295raw.AbstractC5872Nat192;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class SecP192K1Curve extends AbstractC5817ECCurve.AbstractFp {
    private static final int SECP192K1_DEFAULT_COORDS = 2;
    protected SecP192K1Point infinity;

    /* renamed from: q */
    public static final BigInteger f22215q = SecP192K1FieldElement.f22224Q;
    private static final ECFieldElement[] SECP192K1_AFFINE_ZS = {new SecP192K1FieldElement(ECConstants.f22091ONE)};

    public SecP192K1Curve() {
        super(f22215q);
        this.infinity = new SecP192K1Point(this, null, null);
        this.f22095a = fromBigInteger(ECConstants.f22094ZERO);
        this.f22096b = fromBigInteger(BigInteger.valueOf(3L));
        this.f22099order = new BigInteger(1, C6255Hex.decodeStrict("FFFFFFFFFFFFFFFFFFFFFFFE26F2FC170F69466A74DEFD8D"));
        this.cofactor = BigInteger.valueOf(1L);
        this.f22097coord = 2;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5817ECCurve cloneCurve() {
        return new SecP192K1Curve();
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public ECLookupTable createCacheSafeLookupTable(AbstractC5820ECPoint[] abstractC5820ECPointArr, int i, final int i2) {
        final int[] iArr = new int[i2 * 12];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            AbstractC5820ECPoint abstractC5820ECPoint = abstractC5820ECPointArr[i + i4];
            AbstractC5872Nat192.m17010copy(((SecP192K1FieldElement) abstractC5820ECPoint.getRawXCoord()).f22225x, 0, iArr, i3);
            AbstractC5872Nat192.m17010copy(((SecP192K1FieldElement) abstractC5820ECPoint.getRawYCoord()).f22225x, 0, iArr, i3 + 6);
            i3 += 12;
        }
        return new AbstractECLookupTable(this) { // from class: org.bouncycastle.math.ec.custom.sec.SecP192K1Curve.1

            /* renamed from: this$0 */
            final /* synthetic */ SecP192K1Curve f22216this$0;

            {
                this.f22216this$0 = this;
            }

            private AbstractC5820ECPoint createPoint(int[] iArr2, int[] iArr3) {
                return this.f22216this$0.createRawPoint(new SecP192K1FieldElement(iArr2), new SecP192K1FieldElement(iArr3), SecP192K1Curve.SECP192K1_AFFINE_ZS);
            }

            @Override // org.bouncycastle.p284math.p285ec.ECLookupTable
            /* renamed from: getSize */
            public int mo16300getSize() {
                return i2;
            }

            @Override // org.bouncycastle.p284math.p285ec.ECLookupTable
            /* renamed from: lookup */
            public AbstractC5820ECPoint mo16301lookup(int i5) {
                int[] iArrM17014create = AbstractC5872Nat192.m17014create();
                int[] iArrM17014create2 = AbstractC5872Nat192.m17014create();
                int i6 = 0;
                for (int i7 = 0; i7 < i2; i7++) {
                    int i8 = ((i7 ^ i5) - 1) >> 31;
                    for (int i9 = 0; i9 < 6; i9++) {
                        int i10 = iArrM17014create[i9];
                        int[] iArr2 = iArr;
                        iArrM17014create[i9] = i10 ^ (iArr2[i6 + i9] & i8);
                        iArrM17014create2[i9] = iArrM17014create2[i9] ^ (iArr2[(i6 + 6) + i9] & i8);
                    }
                    i6 += 12;
                }
                return createPoint(iArrM17014create, iArrM17014create2);
            }

            @Override // org.bouncycastle.p284math.p285ec.AbstractECLookupTable, org.bouncycastle.p284math.p285ec.ECLookupTable
            public AbstractC5820ECPoint lookupVar(int i5) {
                int[] iArrM17014create = AbstractC5872Nat192.m17014create();
                int[] iArrM17014create2 = AbstractC5872Nat192.m17014create();
                int i6 = i5 * 12;
                for (int i7 = 0; i7 < 6; i7++) {
                    int[] iArr2 = iArr;
                    iArrM17014create[i7] = iArr2[i6 + i7];
                    iArrM17014create2[i7] = iArr2[6 + i6 + i7];
                }
                return createPoint(iArrM17014create, iArrM17014create2);
            }
        };
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5820ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecP192K1Point(this, eCFieldElement, eCFieldElement2);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecP192K1FieldElement(bigInteger);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public int getFieldSize() {
        return f22215q.bitLength();
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5820ECPoint getInfinity() {
        return this.infinity;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve.AbstractFp
    /* renamed from: getQ */
    public BigInteger mo16304getQ() {
        return f22215q;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve.AbstractFp, org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public ECFieldElement randomFieldElement(SecureRandom secureRandom) {
        int[] iArrM17014create = AbstractC5872Nat192.m17014create();
        SecP192K1Field.m16456random(secureRandom, iArrM17014create);
        return new SecP192K1FieldElement(iArrM17014create);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve.AbstractFp, org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public ECFieldElement randomFieldElementMult(SecureRandom secureRandom) {
        int[] iArrM17014create = AbstractC5872Nat192.m17014create();
        SecP192K1Field.randomMult(secureRandom, iArrM17014create);
        return new SecP192K1FieldElement(iArrM17014create);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public boolean supportsCoordinateSystem(int i) {
        return i == 2;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5820ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SecP192K1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }
}
