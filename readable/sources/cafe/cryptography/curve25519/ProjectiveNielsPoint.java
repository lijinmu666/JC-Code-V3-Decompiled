package cafe.cryptography.curve25519;

import cafe.cryptography.p027subtle.ConstantTime;

/* loaded from: classes.dex */
class ProjectiveNielsPoint {
    static final ProjectiveNielsPoint IDENTITY;

    /* renamed from: T2D */
    final FieldElement f1980T2D;

    /* renamed from: YMinusX */
    final FieldElement f1981YMinusX;

    /* renamed from: YPlusX */
    final FieldElement f1982YPlusX;

    /* renamed from: Z */
    final FieldElement f1983Z;

    public static class LookupTable {

        /* renamed from: table */
        private final ProjectiveNielsPoint[] f1984table;

        public LookupTable(ProjectiveNielsPoint[] projectiveNielsPointArr) {
            this.f1984table = projectiveNielsPointArr;
        }

        /* renamed from: select */
        public ProjectiveNielsPoint m2123select(int i) {
            if (i < -8 || i > 8) {
                throw new IllegalArgumentException("x is not in range -8 <= x <= 8");
            }
            int iIsNegative = ConstantTime.isNegative(i);
            int i2 = i - (((-iIsNegative) & i) << 1);
            ProjectiveNielsPoint projectiveNielsPointCtSelect = ProjectiveNielsPoint.IDENTITY;
            for (int i3 = 1; i3 < 9; i3++) {
                projectiveNielsPointCtSelect = projectiveNielsPointCtSelect.ctSelect(this.f1984table[i3 - 1], ConstantTime.m2145equal(i2, i3));
            }
            return projectiveNielsPointCtSelect.ctSelect(projectiveNielsPointCtSelect.m2122negate(), iIsNegative);
        }
    }

    public static class NafLookupTable {

        /* renamed from: table */
        private final ProjectiveNielsPoint[] f1985table;

        public NafLookupTable(ProjectiveNielsPoint[] projectiveNielsPointArr) {
            this.f1985table = projectiveNielsPointArr;
        }

        /* renamed from: select */
        public ProjectiveNielsPoint m2124select(int i) {
            if (i % 2 == 0 || i >= 16) {
                throw new IllegalArgumentException("invalid x");
            }
            return this.f1985table[i / 2];
        }
    }

    static {
        FieldElement fieldElement = FieldElement.f1976ONE;
        IDENTITY = new ProjectiveNielsPoint(fieldElement, fieldElement, fieldElement, FieldElement.f1977ZERO);
    }

    public ProjectiveNielsPoint(FieldElement fieldElement, FieldElement fieldElement2, FieldElement fieldElement3, FieldElement fieldElement4) {
        this.f1982YPlusX = fieldElement;
        this.f1981YMinusX = fieldElement2;
        this.f1983Z = fieldElement3;
        this.f1980T2D = fieldElement4;
    }

    public static LookupTable buildLookupTable(EdwardsPoint edwardsPoint) {
        ProjectiveNielsPoint[] projectiveNielsPointArr = new ProjectiveNielsPoint[8];
        int i = 0;
        projectiveNielsPointArr[0] = edwardsPoint.toProjectiveNiels();
        while (i < 7) {
            int i2 = i + 1;
            projectiveNielsPointArr[i2] = edwardsPoint.m2107add(projectiveNielsPointArr[i]).toExtended().toProjectiveNiels();
            i = i2;
        }
        return new LookupTable(projectiveNielsPointArr);
    }

    public static NafLookupTable buildNafLookupTable(EdwardsPoint edwardsPoint) {
        ProjectiveNielsPoint[] projectiveNielsPointArr = new ProjectiveNielsPoint[8];
        int i = 0;
        projectiveNielsPointArr[0] = edwardsPoint.toProjectiveNiels();
        EdwardsPoint edwardsPointM2109dbl = edwardsPoint.m2109dbl();
        while (i < 7) {
            int i2 = i + 1;
            projectiveNielsPointArr[i2] = edwardsPointM2109dbl.m2107add(projectiveNielsPointArr[i]).toExtended().toProjectiveNiels();
            i = i2;
        }
        return new NafLookupTable(projectiveNielsPointArr);
    }

    public ProjectiveNielsPoint ctSelect(ProjectiveNielsPoint projectiveNielsPoint, int i) {
        return new ProjectiveNielsPoint(this.f1982YPlusX.ctSelect(projectiveNielsPoint.f1982YPlusX, i), this.f1981YMinusX.ctSelect(projectiveNielsPoint.f1981YMinusX, i), this.f1983Z.ctSelect(projectiveNielsPoint.f1983Z, i), this.f1980T2D.ctSelect(projectiveNielsPoint.f1980T2D, i));
    }

    /* renamed from: negate */
    public ProjectiveNielsPoint m2122negate() {
        return new ProjectiveNielsPoint(this.f1981YMinusX, this.f1982YPlusX, this.f1983Z, this.f1980T2D.m2119negate());
    }
}
