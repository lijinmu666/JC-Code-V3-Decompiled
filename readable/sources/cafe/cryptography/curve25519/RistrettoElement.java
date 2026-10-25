package cafe.cryptography.curve25519;

import cafe.cryptography.curve25519.FieldElement;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

/* loaded from: classes.dex */
public class RistrettoElement implements Serializable {
    public static final RistrettoElement IDENTITY = new RistrettoElement(EdwardsPoint.IDENTITY);
    private static final long serialVersionUID = 1;

    /* renamed from: repr */
    transient EdwardsPoint f1989repr;

    public RistrettoElement(EdwardsPoint edwardsPoint) {
        this.f1989repr = edwardsPoint;
    }

    public static RistrettoElement fromUniformBytes(byte[] bArr) {
        return m2126map(FieldElement.fromByteArray(Arrays.copyOfRange(bArr, 0, 32))).m2127add(m2126map(FieldElement.fromByteArray(Arrays.copyOfRange(bArr, 32, 64))));
    }

    /* renamed from: map */
    public static RistrettoElement m2126map(FieldElement fieldElement) {
        FieldElement fieldElementMultiply = fieldElement.m2121square().multiply(Constants.f1970SQRT_M1);
        FieldElement fieldElement2 = FieldElement.f1976ONE;
        FieldElement fieldElementMultiply2 = fieldElementMultiply.m2114add(fieldElement2).multiply(Constants.ONE_MINUS_D_SQ);
        FieldElement fieldElement3 = FieldElement.MINUS_ONE;
        FieldElement fieldElement4 = Constants.EDWARDS_D;
        FieldElement fieldElementMultiply3 = fieldElement3.subtract(fieldElementMultiply.multiply(fieldElement4)).multiply(fieldElementMultiply.m2114add(fieldElement4));
        FieldElement.SqrtRatioM1Result sqrtRatioM1ResultSqrtRatioM1 = FieldElement.sqrtRatioM1(fieldElementMultiply2, fieldElementMultiply3);
        FieldElement fieldElement5 = sqrtRatioM1ResultSqrtRatioM1.f1979result;
        FieldElement fieldElementCtSelect = fieldElement5.multiply(fieldElement).m2115ctAbs().m2119negate().ctSelect(fieldElement5, sqrtRatioM1ResultSqrtRatioM1.wasSquare);
        FieldElement fieldElementSubtract = fieldElementMultiply.ctSelect(fieldElement3, sqrtRatioM1ResultSqrtRatioM1.wasSquare).multiply(fieldElementMultiply.subtract(fieldElement2)).multiply(Constants.D_MINUS_ONE_SQ).subtract(fieldElementMultiply3);
        FieldElement fieldElementM2121square = fieldElementCtSelect.m2121square();
        FieldElement fieldElementMultiply4 = fieldElementCtSelect.m2114add(fieldElementCtSelect).multiply(fieldElementMultiply3);
        FieldElement fieldElementMultiply5 = fieldElementSubtract.multiply(Constants.SQRT_AD_MINUS_ONE);
        FieldElement fieldElementSubtract2 = fieldElement2.subtract(fieldElementM2121square);
        FieldElement fieldElementM2114add = fieldElement2.m2114add(fieldElementM2121square);
        return new RistrettoElement(new EdwardsPoint(fieldElementMultiply4.multiply(fieldElementM2114add), fieldElementSubtract2.multiply(fieldElementMultiply5), fieldElementMultiply5.multiply(fieldElementM2114add), fieldElementMultiply4.multiply(fieldElementSubtract2)));
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        byte[] bArr = new byte[32];
        objectInputStream.readFully(bArr);
        try {
            this.f1989repr = new CompressedRistretto(bArr).decompress().f1989repr;
        } catch (InvalidEncodingException e) {
            throw new InvalidObjectException(e.getMessage());
        }
    }

    private void readObjectNoData() throws InvalidObjectException {
        throw new InvalidObjectException("Cannot deserialize RistrettoElement from no data");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.write(compress().toByteArray());
    }

    /* renamed from: add */
    public RistrettoElement m2127add(RistrettoElement ristrettoElement) {
        return new RistrettoElement(this.f1989repr.m2108add(ristrettoElement.f1989repr));
    }

    public CompressedRistretto compress() {
        EdwardsPoint edwardsPoint = this.f1989repr;
        FieldElement fieldElementM2114add = edwardsPoint.f1975Z.m2114add(edwardsPoint.f1974Y);
        EdwardsPoint edwardsPoint2 = this.f1989repr;
        FieldElement fieldElementMultiply = fieldElementM2114add.multiply(edwardsPoint2.f1975Z.subtract(edwardsPoint2.f1974Y));
        EdwardsPoint edwardsPoint3 = this.f1989repr;
        FieldElement fieldElementMultiply2 = edwardsPoint3.f1973X.multiply(edwardsPoint3.f1974Y);
        FieldElement.SqrtRatioM1Result sqrtRatioM1ResultSqrtRatioM1 = FieldElement.sqrtRatioM1(FieldElement.f1976ONE, fieldElementMultiply.multiply(fieldElementMultiply2.m2121square()));
        FieldElement fieldElementMultiply3 = sqrtRatioM1ResultSqrtRatioM1.f1979result.multiply(fieldElementMultiply);
        FieldElement fieldElementMultiply4 = sqrtRatioM1ResultSqrtRatioM1.f1979result.multiply(fieldElementMultiply2);
        FieldElement fieldElementMultiply5 = fieldElementMultiply3.multiply(fieldElementMultiply4).multiply(this.f1989repr.f1972T);
        FieldElement fieldElement = this.f1989repr.f1973X;
        FieldElement fieldElement2 = Constants.f1970SQRT_M1;
        FieldElement fieldElementMultiply6 = fieldElement.multiply(fieldElement2);
        FieldElement fieldElementMultiply7 = this.f1989repr.f1974Y.multiply(fieldElement2);
        FieldElement fieldElementMultiply8 = fieldElementMultiply3.multiply(Constants.INVSQRT_A_MINUS_D);
        int iIsNegative = this.f1989repr.f1972T.multiply(fieldElementMultiply5).isNegative();
        FieldElement fieldElementCtSelect = this.f1989repr.f1973X.ctSelect(fieldElementMultiply7, iIsNegative);
        FieldElement fieldElementCtSelect2 = this.f1989repr.f1974Y.ctSelect(fieldElementMultiply6, iIsNegative);
        FieldElement fieldElementMultiply9 = fieldElementMultiply4.ctSelect(fieldElementMultiply8, iIsNegative).multiply(this.f1989repr.f1975Z.subtract(fieldElementCtSelect2.ctSelect(fieldElementCtSelect2.m2119negate(), fieldElementCtSelect.multiply(fieldElementMultiply5).isNegative())));
        return new CompressedRistretto(fieldElementMultiply9.ctSelect(fieldElementMultiply9.m2119negate(), fieldElementMultiply9.isNegative()).toByteArray());
    }

    public int ctEquals(RistrettoElement ristrettoElement) {
        FieldElement fieldElementMultiply = this.f1989repr.f1973X.multiply(ristrettoElement.f1989repr.f1974Y);
        FieldElement fieldElementMultiply2 = this.f1989repr.f1974Y.multiply(ristrettoElement.f1989repr.f1973X);
        FieldElement fieldElementMultiply3 = this.f1989repr.f1974Y.multiply(ristrettoElement.f1989repr.f1974Y);
        FieldElement fieldElementMultiply4 = this.f1989repr.f1973X.multiply(ristrettoElement.f1989repr.f1973X);
        return fieldElementMultiply3.ctEquals(fieldElementMultiply4) | fieldElementMultiply.ctEquals(fieldElementMultiply2);
    }

    public RistrettoElement ctSelect(RistrettoElement ristrettoElement, int i) {
        return new RistrettoElement(this.f1989repr.ctSelect(ristrettoElement.f1989repr, i));
    }

    /* renamed from: dbl */
    public RistrettoElement m2128dbl() {
        return new RistrettoElement(this.f1989repr.m2109dbl());
    }

    /* renamed from: equals */
    public boolean m2129equals(Object obj) {
        return (obj instanceof RistrettoElement) && ctEquals((RistrettoElement) obj) == 1;
    }

    public int hashCode() {
        return compress().hashCode();
    }

    public RistrettoElement multiply(C0186Scalar c0186Scalar) {
        return new RistrettoElement(this.f1989repr.multiply(c0186Scalar));
    }

    /* renamed from: negate */
    public RistrettoElement m2130negate() {
        return new RistrettoElement(this.f1989repr.m2111negate());
    }

    public String printInternalRepresentation() {
        return "RistrettoElement(" + this.f1989repr.printInternalRepresentation() + ")";
    }

    public RistrettoElement subtract(RistrettoElement ristrettoElement) {
        return new RistrettoElement(this.f1989repr.subtract(ristrettoElement.f1989repr));
    }
}
