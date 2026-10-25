package cafe.cryptography.curve25519;

/* loaded from: classes.dex */
public class RistrettoGeneratorTable {

    /* renamed from: table */
    final EdwardsBasepointTable f1990table;

    public RistrettoGeneratorTable(RistrettoElement ristrettoElement) {
        this.f1990table = new EdwardsBasepointTable(ristrettoElement.f1989repr);
    }

    public RistrettoElement multiply(C0186Scalar c0186Scalar) {
        return new RistrettoElement(this.f1990table.multiply(c0186Scalar));
    }
}
