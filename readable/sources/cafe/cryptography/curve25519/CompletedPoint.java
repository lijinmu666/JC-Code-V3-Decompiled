package cafe.cryptography.curve25519;

/* loaded from: classes.dex */
class CompletedPoint {

    /* renamed from: T */
    final FieldElement f1960T;

    /* renamed from: X */
    final FieldElement f1961X;

    /* renamed from: Y */
    final FieldElement f1962Y;

    /* renamed from: Z */
    final FieldElement f1963Z;

    public CompletedPoint(FieldElement fieldElement, FieldElement fieldElement2, FieldElement fieldElement3, FieldElement fieldElement4) {
        this.f1961X = fieldElement;
        this.f1962Y = fieldElement2;
        this.f1963Z = fieldElement3;
        this.f1960T = fieldElement4;
    }

    public EdwardsPoint toExtended() {
        return new EdwardsPoint(this.f1961X.multiply(this.f1960T), this.f1962Y.multiply(this.f1963Z), this.f1963Z.multiply(this.f1960T), this.f1961X.multiply(this.f1962Y));
    }

    public ProjectivePoint toProjective() {
        return new ProjectivePoint(this.f1961X.multiply(this.f1960T), this.f1962Y.multiply(this.f1963Z), this.f1963Z.multiply(this.f1960T));
    }
}
