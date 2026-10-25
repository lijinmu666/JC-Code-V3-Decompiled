package cafe.cryptography.curve25519;

import cafe.cryptography.p027subtle.ConstantTime;

/* loaded from: classes.dex */
class AffineNielsPoint {
    static final AffineNielsPoint IDENTITY;

    /* renamed from: xy2D */
    final FieldElement f1955xy2D;

    /* renamed from: yMinusx */
    final FieldElement f1956yMinusx;

    /* renamed from: yPlusx */
    final FieldElement f1957yPlusx;

    public static class LookupTable {

        /* renamed from: table */
        private final AffineNielsPoint[] f1958table;

        public LookupTable(AffineNielsPoint[] affineNielsPointArr) {
            this.f1958table = affineNielsPointArr;
        }

        /* renamed from: select */
        public AffineNielsPoint m2102select(int i) {
            if (i < -8 || i > 8) {
                throw new IllegalArgumentException("x is not in range -8 <= x <= 8");
            }
            int iIsNegative = ConstantTime.isNegative(i);
            int i2 = i - (((-iIsNegative) & i) << 1);
            AffineNielsPoint affineNielsPointCtSelect = AffineNielsPoint.IDENTITY;
            for (int i3 = 1; i3 < 9; i3++) {
                affineNielsPointCtSelect = affineNielsPointCtSelect.ctSelect(this.f1958table[i3 - 1], ConstantTime.m2145equal(i2, i3));
            }
            return affineNielsPointCtSelect.ctSelect(affineNielsPointCtSelect.m2101negate(), iIsNegative);
        }
    }

    public static class NafLookupTable {

        /* renamed from: table */
        private final AffineNielsPoint[] f1959table;

        public NafLookupTable(AffineNielsPoint[] affineNielsPointArr) {
            this.f1959table = affineNielsPointArr;
        }

        /* renamed from: select */
        public AffineNielsPoint m2103select(int i) {
            if (i % 2 == 0 || i >= 16) {
                throw new IllegalArgumentException("invalid x");
            }
            return this.f1959table[i / 2];
        }
    }

    static {
        FieldElement fieldElement = FieldElement.f1976ONE;
        IDENTITY = new AffineNielsPoint(fieldElement, fieldElement, FieldElement.f1977ZERO);
    }

    public AffineNielsPoint(FieldElement fieldElement, FieldElement fieldElement2, FieldElement fieldElement3) {
        this.f1957yPlusx = fieldElement;
        this.f1956yMinusx = fieldElement2;
        this.f1955xy2D = fieldElement3;
    }

    public static LookupTable buildLookupTable(EdwardsPoint edwardsPoint) {
        AffineNielsPoint[] affineNielsPointArr = new AffineNielsPoint[8];
        int i = 0;
        affineNielsPointArr[0] = edwardsPoint.toAffineNiels();
        while (i < 7) {
            int i2 = i + 1;
            affineNielsPointArr[i2] = edwardsPoint.m2106add(affineNielsPointArr[i]).toExtended().toAffineNiels();
            i = i2;
        }
        return new LookupTable(affineNielsPointArr);
    }

    public static NafLookupTable buildNafLookupTable(EdwardsPoint edwardsPoint) {
        AffineNielsPoint[] affineNielsPointArr = new AffineNielsPoint[8];
        int i = 0;
        affineNielsPointArr[0] = edwardsPoint.toAffineNiels();
        EdwardsPoint edwardsPointM2109dbl = edwardsPoint.m2109dbl();
        while (i < 7) {
            int i2 = i + 1;
            affineNielsPointArr[i2] = edwardsPointM2109dbl.m2106add(affineNielsPointArr[i]).toExtended().toAffineNiels();
            i = i2;
        }
        return new NafLookupTable(affineNielsPointArr);
    }

    public AffineNielsPoint ctSelect(AffineNielsPoint affineNielsPoint, int i) {
        return new AffineNielsPoint(this.f1957yPlusx.ctSelect(affineNielsPoint.f1957yPlusx, i), this.f1956yMinusx.ctSelect(affineNielsPoint.f1956yMinusx, i), this.f1955xy2D.ctSelect(affineNielsPoint.f1955xy2D, i));
    }

    /* renamed from: negate */
    public AffineNielsPoint m2101negate() {
        return new AffineNielsPoint(this.f1956yMinusx, this.f1957yPlusx, this.f1955xy2D.m2119negate());
    }
}
