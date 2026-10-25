package org.bouncycastle.p284math.p285ec.p286custom.p289sec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.AbstractECLookupTable;
import org.bouncycastle.p284math.p285ec.ECConstants;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p285ec.ECLookupTable;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class SecP521R1Curve extends AbstractC5817ECCurve.AbstractFp {
    private static final int SECP521R1_DEFAULT_COORDS = 2;
    protected SecP521R1Point infinity;

    /* renamed from: q */
    public static final BigInteger f22290q = SecP521R1FieldElement.f22295Q;
    private static final ECFieldElement[] SECP521R1_AFFINE_ZS = {new SecP521R1FieldElement(ECConstants.f22091ONE)};

    public SecP521R1Curve() {
        super(f22290q);
        this.infinity = new SecP521R1Point(this, null, null);
        this.f22095a = fromBigInteger(new BigInteger(1, C6255Hex.decodeStrict("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC")));
        this.f22096b = fromBigInteger(new BigInteger(1, C6255Hex.decodeStrict("0051953EB9618E1C9A1F929A21A0B68540EEA2DA725B99B315F3B8B489918EF109E156193951EC7E937B1652C0BD3BB1BF073573DF883D2C34F1EF451FD46B503F00")));
        this.f22099order = new BigInteger(1, C6255Hex.decodeStrict("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFA51868783BF2F966B7FCC0148F709A5D03BB5C9B8899C47AEBB6FB71E91386409"));
        this.cofactor = BigInteger.valueOf(1L);
        this.f22097coord = 2;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5817ECCurve cloneCurve() {
        return new SecP521R1Curve();
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public ECLookupTable createCacheSafeLookupTable(AbstractC5820ECPoint[] abstractC5820ECPointArr, int i, final int i2) {
        final int[] iArr = new int[i2 * 34];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            AbstractC5820ECPoint abstractC5820ECPoint = abstractC5820ECPointArr[i + i4];
            AbstractC5869Nat.m16898copy(17, ((SecP521R1FieldElement) abstractC5820ECPoint.getRawXCoord()).f22296x, 0, iArr, i3);
            AbstractC5869Nat.m16898copy(17, ((SecP521R1FieldElement) abstractC5820ECPoint.getRawYCoord()).f22296x, 0, iArr, i3 + 17);
            i3 += 34;
        }
        return new AbstractECLookupTable(this) { // from class: org.bouncycastle.math.ec.custom.sec.SecP521R1Curve.1

            /* renamed from: this$0 */
            final /* synthetic */ SecP521R1Curve f22291this$0;

            {
                this.f22291this$0 = this;
            }

            private AbstractC5820ECPoint createPoint(int[] iArr2, int[] iArr3) {
                return this.f22291this$0.createRawPoint(new SecP521R1FieldElement(iArr2), new SecP521R1FieldElement(iArr3), SecP521R1Curve.SECP521R1_AFFINE_ZS);
            }

            @Override // org.bouncycastle.p284math.p285ec.ECLookupTable
            /* renamed from: getSize */
            public int mo16300getSize() {
                return i2;
            }

            @Override // org.bouncycastle.p284math.p285ec.ECLookupTable
            /* renamed from: lookup */
            public AbstractC5820ECPoint mo16301lookup(int i5) {
                int[] iArrM16904create = AbstractC5869Nat.m16904create(17);
                int[] iArrM16904create2 = AbstractC5869Nat.m16904create(17);
                int i6 = 0;
                for (int i7 = 0; i7 < i2; i7++) {
                    int i8 = ((i7 ^ i5) - 1) >> 31;
                    for (int i9 = 0; i9 < 17; i9++) {
                        int i10 = iArrM16904create[i9];
                        int[] iArr2 = iArr;
                        iArrM16904create[i9] = i10 ^ (iArr2[i6 + i9] & i8);
                        iArrM16904create2[i9] = iArrM16904create2[i9] ^ (iArr2[(i6 + 17) + i9] & i8);
                    }
                    i6 += 34;
                }
                return createPoint(iArrM16904create, iArrM16904create2);
            }

            @Override // org.bouncycastle.p284math.p285ec.AbstractECLookupTable, org.bouncycastle.p284math.p285ec.ECLookupTable
            public AbstractC5820ECPoint lookupVar(int i5) {
                int[] iArrM16904create = AbstractC5869Nat.m16904create(17);
                int[] iArrM16904create2 = AbstractC5869Nat.m16904create(17);
                int i6 = i5 * 34;
                for (int i7 = 0; i7 < 17; i7++) {
                    int i8 = iArrM16904create[i7];
                    int[] iArr2 = iArr;
                    iArrM16904create[i7] = i8 ^ iArr2[i6 + i7];
                    iArrM16904create2[i7] = iArrM16904create2[i7] ^ iArr2[(i6 + 17) + i7];
                }
                return createPoint(iArrM16904create, iArrM16904create2);
            }
        };
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5820ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SecP521R1Point(this, eCFieldElement, eCFieldElement2);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SecP521R1FieldElement(bigInteger);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public int getFieldSize() {
        return f22290q.bitLength();
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5820ECPoint getInfinity() {
        return this.infinity;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve.AbstractFp
    /* renamed from: getQ */
    public BigInteger mo16304getQ() {
        return f22290q;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve.AbstractFp, org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public ECFieldElement randomFieldElement(SecureRandom secureRandom) {
        int[] iArrM16904create = AbstractC5869Nat.m16904create(17);
        SecP521R1Field.m16556random(secureRandom, iArrM16904create);
        return new SecP521R1FieldElement(iArrM16904create);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve.AbstractFp, org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public ECFieldElement randomFieldElementMult(SecureRandom secureRandom) {
        int[] iArrM16904create = AbstractC5869Nat.m16904create(17);
        SecP521R1Field.randomMult(secureRandom, iArrM16904create);
        return new SecP521R1FieldElement(iArrM16904create);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public boolean supportsCoordinateSystem(int i) {
        return i == 2;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5820ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SecP521R1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }
}
