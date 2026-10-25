package org.bouncycastle.p284math.p285ec.p286custom.p288gm;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.AbstractECLookupTable;
import org.bouncycastle.p284math.p285ec.ECConstants;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p285ec.ECLookupTable;
import org.bouncycastle.p284math.p295raw.AbstractC5874Nat256;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class SM2P256V1Curve extends AbstractC5817ECCurve.AbstractFp {
    private static final int SM2P256V1_DEFAULT_COORDS = 2;
    protected SM2P256V1Point infinity;

    /* renamed from: q */
    public static final BigInteger f22169q = SM2P256V1FieldElement.f22176Q;
    private static final ECFieldElement[] SM2P256V1_AFFINE_ZS = {new SM2P256V1FieldElement(ECConstants.f22091ONE)};

    public SM2P256V1Curve() {
        super(f22169q);
        this.infinity = new SM2P256V1Point(this, null, null);
        this.f22095a = fromBigInteger(new BigInteger(1, C6255Hex.decodeStrict("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFC")));
        this.f22096b = fromBigInteger(new BigInteger(1, C6255Hex.decodeStrict("28E9FA9E9D9F5E344D5A9E4BCF6509A7F39789F515AB8F92DDBCBD414D940E93")));
        this.f22099order = new BigInteger(1, C6255Hex.decodeStrict("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFF7203DF6B21C6052B53BBF40939D54123"));
        this.cofactor = BigInteger.valueOf(1L);
        this.f22097coord = 2;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5817ECCurve cloneCurve() {
        return new SM2P256V1Curve();
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public ECLookupTable createCacheSafeLookupTable(AbstractC5820ECPoint[] abstractC5820ECPointArr, int i, final int i2) {
        final int[] iArr = new int[i2 * 16];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            AbstractC5820ECPoint abstractC5820ECPoint = abstractC5820ECPointArr[i + i4];
            AbstractC5874Nat256.m17064copy(((SM2P256V1FieldElement) abstractC5820ECPoint.getRawXCoord()).f22177x, 0, iArr, i3);
            AbstractC5874Nat256.m17064copy(((SM2P256V1FieldElement) abstractC5820ECPoint.getRawYCoord()).f22177x, 0, iArr, i3 + 8);
            i3 += 16;
        }
        return new AbstractECLookupTable(this) { // from class: org.bouncycastle.math.ec.custom.gm.SM2P256V1Curve.1

            /* renamed from: this$0 */
            final /* synthetic */ SM2P256V1Curve f22170this$0;

            {
                this.f22170this$0 = this;
            }

            private AbstractC5820ECPoint createPoint(int[] iArr2, int[] iArr3) {
                return this.f22170this$0.createRawPoint(new SM2P256V1FieldElement(iArr2), new SM2P256V1FieldElement(iArr3), SM2P256V1Curve.SM2P256V1_AFFINE_ZS);
            }

            @Override // org.bouncycastle.p284math.p285ec.ECLookupTable
            /* renamed from: getSize */
            public int mo16300getSize() {
                return i2;
            }

            @Override // org.bouncycastle.p284math.p285ec.ECLookupTable
            /* renamed from: lookup */
            public AbstractC5820ECPoint mo16301lookup(int i5) {
                int[] iArrM17068create = AbstractC5874Nat256.m17068create();
                int[] iArrM17068create2 = AbstractC5874Nat256.m17068create();
                int i6 = 0;
                for (int i7 = 0; i7 < i2; i7++) {
                    int i8 = ((i7 ^ i5) - 1) >> 31;
                    for (int i9 = 0; i9 < 8; i9++) {
                        int i10 = iArrM17068create[i9];
                        int[] iArr2 = iArr;
                        iArrM17068create[i9] = i10 ^ (iArr2[i6 + i9] & i8);
                        iArrM17068create2[i9] = iArrM17068create2[i9] ^ (iArr2[(i6 + 8) + i9] & i8);
                    }
                    i6 += 16;
                }
                return createPoint(iArrM17068create, iArrM17068create2);
            }

            @Override // org.bouncycastle.p284math.p285ec.AbstractECLookupTable, org.bouncycastle.p284math.p285ec.ECLookupTable
            public AbstractC5820ECPoint lookupVar(int i5) {
                int[] iArrM17068create = AbstractC5874Nat256.m17068create();
                int[] iArrM17068create2 = AbstractC5874Nat256.m17068create();
                int i6 = i5 * 16;
                for (int i7 = 0; i7 < 8; i7++) {
                    int[] iArr2 = iArr;
                    iArrM17068create[i7] = iArr2[i6 + i7];
                    iArrM17068create2[i7] = iArr2[8 + i6 + i7];
                }
                return createPoint(iArrM17068create, iArrM17068create2);
            }
        };
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5820ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        return new SM2P256V1Point(this, eCFieldElement, eCFieldElement2);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public ECFieldElement fromBigInteger(BigInteger bigInteger) {
        return new SM2P256V1FieldElement(bigInteger);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public int getFieldSize() {
        return f22169q.bitLength();
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5820ECPoint getInfinity() {
        return this.infinity;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve.AbstractFp
    /* renamed from: getQ */
    public BigInteger mo16304getQ() {
        return f22169q;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve.AbstractFp, org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public ECFieldElement randomFieldElement(SecureRandom secureRandom) {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        SM2P256V1Field.m16404random(secureRandom, iArrM17068create);
        return new SM2P256V1FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve.AbstractFp, org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public ECFieldElement randomFieldElementMult(SecureRandom secureRandom) {
        int[] iArrM17068create = AbstractC5874Nat256.m17068create();
        SM2P256V1Field.randomMult(secureRandom, iArrM17068create);
        return new SM2P256V1FieldElement(iArrM17068create);
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public boolean supportsCoordinateSystem(int i) {
        return i == 2;
    }

    @Override // org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve
    public AbstractC5820ECPoint createRawPoint(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, ECFieldElement[] eCFieldElementArr) {
        return new SM2P256V1Point(this, eCFieldElement, eCFieldElement2, eCFieldElementArr);
    }
}
