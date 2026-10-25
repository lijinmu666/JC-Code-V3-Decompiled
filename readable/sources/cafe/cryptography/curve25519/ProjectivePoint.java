package cafe.cryptography.curve25519;

/* loaded from: classes.dex */
class ProjectivePoint {

    /* renamed from: X */
    final FieldElement f1986X;

    /* renamed from: Y */
    final FieldElement f1987Y;

    /* renamed from: Z */
    final FieldElement f1988Z;

    public ProjectivePoint(FieldElement fieldElement, FieldElement fieldElement2, FieldElement fieldElement3) {
        this.f1986X = fieldElement;
        this.f1987Y = fieldElement2;
        this.f1988Z = fieldElement3;
    }

    /* renamed from: dbl */
    public CompletedPoint m2125dbl() {
        FieldElement fieldElementM2121square = this.f1986X.m2121square();
        FieldElement fieldElementM2121square2 = this.f1987Y.m2121square();
        FieldElement fieldElementSquareAndDouble = this.f1988Z.squareAndDouble();
        FieldElement fieldElementM2121square3 = this.f1986X.m2114add(this.f1987Y).m2121square();
        FieldElement fieldElementM2114add = fieldElementM2121square2.m2114add(fieldElementM2121square);
        FieldElement fieldElementSubtract = fieldElementM2121square2.subtract(fieldElementM2121square);
        return new CompletedPoint(fieldElementM2121square3.subtract(fieldElementM2114add), fieldElementM2114add, fieldElementSubtract, fieldElementSquareAndDouble.subtract(fieldElementSubtract));
    }

    public EdwardsPoint toExtended() {
        return new EdwardsPoint(this.f1986X.multiply(this.f1988Z), this.f1987Y.multiply(this.f1988Z), this.f1988Z.m2121square(), this.f1986X.multiply(this.f1987Y));
    }
}
