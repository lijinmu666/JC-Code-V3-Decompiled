package cafe.cryptography.curve25519;

import cafe.cryptography.curve25519.AffineNielsPoint;
import cafe.cryptography.curve25519.ProjectiveNielsPoint;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes.dex */
public class EdwardsPoint implements Serializable {
    public static final EdwardsPoint IDENTITY;
    private static final long serialVersionUID = 1;

    /* renamed from: T */
    transient FieldElement f1972T;

    /* renamed from: X */
    transient FieldElement f1973X;

    /* renamed from: Y */
    transient FieldElement f1974Y;

    /* renamed from: Z */
    transient FieldElement f1975Z;

    static {
        FieldElement fieldElement = FieldElement.f1977ZERO;
        FieldElement fieldElement2 = FieldElement.f1976ONE;
        IDENTITY = new EdwardsPoint(fieldElement, fieldElement2, fieldElement2, fieldElement);
    }

    public EdwardsPoint(FieldElement fieldElement, FieldElement fieldElement2, FieldElement fieldElement3, FieldElement fieldElement4) {
        this.f1973X = fieldElement;
        this.f1974Y = fieldElement2;
        this.f1975Z = fieldElement3;
        this.f1972T = fieldElement4;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        byte[] bArr = new byte[32];
        objectInputStream.readFully(bArr);
        try {
            EdwardsPoint edwardsPointDecompress = new CompressedEdwardsY(bArr).decompress();
            this.f1973X = edwardsPointDecompress.f1973X;
            this.f1974Y = edwardsPointDecompress.f1974Y;
            this.f1975Z = edwardsPointDecompress.f1975Z;
            this.f1972T = edwardsPointDecompress.f1972T;
        } catch (InvalidEncodingException e) {
            throw new InvalidObjectException(e.getMessage());
        }
    }

    private void readObjectNoData() throws InvalidObjectException {
        throw new InvalidObjectException("Cannot deserialize EdwardsPoint from no data");
    }

    public static EdwardsPoint vartimeDoubleScalarMultiplyBasepoint(C0186Scalar c0186Scalar, EdwardsPoint edwardsPoint, C0186Scalar c0186Scalar2) {
        byte[] bArrNonAdjacentForm = c0186Scalar.nonAdjacentForm();
        byte[] bArrNonAdjacentForm2 = c0186Scalar2.nonAdjacentForm();
        ProjectiveNielsPoint.NafLookupTable nafLookupTableBuildNafLookupTable = ProjectiveNielsPoint.buildNafLookupTable(edwardsPoint);
        AffineNielsPoint.NafLookupTable nafLookupTable = Constants.AFFINE_ODD_MULTIPLES_OF_BASEPOINT;
        int i = 255;
        while (i >= 0 && bArrNonAdjacentForm[i] == 0 && bArrNonAdjacentForm2[i] == 0) {
            i--;
        }
        ProjectivePoint projective = IDENTITY.toProjective();
        while (i >= 0) {
            CompletedPoint completedPointM2125dbl = projective.m2125dbl();
            byte b = bArrNonAdjacentForm[i];
            if (b > 0) {
                completedPointM2125dbl = completedPointM2125dbl.toExtended().m2107add(nafLookupTableBuildNafLookupTable.m2124select(bArrNonAdjacentForm[i]));
            } else if (b < 0) {
                completedPointM2125dbl = completedPointM2125dbl.toExtended().subtract(nafLookupTableBuildNafLookupTable.m2124select(-bArrNonAdjacentForm[i]));
            }
            byte b2 = bArrNonAdjacentForm2[i];
            if (b2 > 0) {
                completedPointM2125dbl = completedPointM2125dbl.toExtended().m2106add(nafLookupTable.m2103select(bArrNonAdjacentForm2[i]));
            } else if (b2 < 0) {
                completedPointM2125dbl = completedPointM2125dbl.toExtended().subtract(nafLookupTable.m2103select(-bArrNonAdjacentForm2[i]));
            }
            projective = completedPointM2125dbl.toProjective();
            i--;
        }
        return projective.toExtended();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.write(compress().toByteArray());
    }

    /* renamed from: add */
    public EdwardsPoint m2108add(EdwardsPoint edwardsPoint) {
        return m2107add(edwardsPoint.toProjectiveNiels()).toExtended();
    }

    public CompressedEdwardsY compress() {
        FieldElement fieldElementM2117invert = this.f1975Z.m2117invert();
        FieldElement fieldElementMultiply = this.f1973X.multiply(fieldElementM2117invert);
        byte[] byteArray = this.f1974Y.multiply(fieldElementM2117invert).toByteArray();
        byteArray[31] = (byte) ((fieldElementMultiply.isNegative() << 7) | byteArray[31]);
        return new CompressedEdwardsY(byteArray);
    }

    public int ctEquals(EdwardsPoint edwardsPoint) {
        return compress().ctEquals(edwardsPoint.compress());
    }

    public EdwardsPoint ctSelect(EdwardsPoint edwardsPoint, int i) {
        return new EdwardsPoint(this.f1973X.ctSelect(edwardsPoint.f1973X, i), this.f1974Y.ctSelect(edwardsPoint.f1974Y, i), this.f1975Z.ctSelect(edwardsPoint.f1975Z, i), this.f1972T.ctSelect(edwardsPoint.f1972T, i));
    }

    /* renamed from: dbl */
    public EdwardsPoint m2109dbl() {
        return toProjective().m2125dbl().toExtended();
    }

    /* renamed from: equals */
    public boolean m2110equals(Object obj) {
        return (obj instanceof EdwardsPoint) && ctEquals((EdwardsPoint) obj) == 1;
    }

    public int hashCode() {
        return compress().hashCode();
    }

    public boolean isIdentity() {
        return ctEquals(IDENTITY) == 1;
    }

    public boolean isSmallOrder() {
        return multiplyByCofactor().isIdentity();
    }

    public boolean isTorsionFree() {
        return multiply(Constants.BASEPOINT_ORDER).isIdentity();
    }

    public EdwardsPoint multiply(C0186Scalar c0186Scalar) {
        ProjectiveNielsPoint.LookupTable lookupTableBuildLookupTable = ProjectiveNielsPoint.buildLookupTable(this);
        byte[] radix16 = c0186Scalar.toRadix16();
        EdwardsPoint extended = IDENTITY;
        for (int i = 63; i >= 0; i--) {
            extended = extended.multiplyByPow2(4).m2107add(lookupTableBuildLookupTable.m2123select(radix16[i])).toExtended();
        }
        return extended;
    }

    public EdwardsPoint multiplyByCofactor() {
        return multiplyByPow2(3);
    }

    public EdwardsPoint multiplyByPow2(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Exponent must be positive and non-zero");
        }
        ProjectivePoint projective = toProjective();
        for (int i2 = 0; i2 < i - 1; i2++) {
            projective = projective.m2125dbl().toProjective();
        }
        return projective.m2125dbl().toExtended();
    }

    /* renamed from: negate */
    public EdwardsPoint m2111negate() {
        return new EdwardsPoint(this.f1973X.m2119negate(), this.f1974Y, this.f1975Z, this.f1972T.m2119negate());
    }

    public String printInternalRepresentation() {
        return (((("EdwardsPoint(\n    X: " + this.f1973X.printInternalRepresentation() + ",\n") + "    Y: " + this.f1974Y.printInternalRepresentation() + ",\n") + "    Z: " + this.f1975Z.printInternalRepresentation() + ",\n") + "    T: " + this.f1972T.printInternalRepresentation() + ",\n") + ")";
    }

    public EdwardsPoint subtract(EdwardsPoint edwardsPoint) {
        return subtract(edwardsPoint.toProjectiveNiels()).toExtended();
    }

    public AffineNielsPoint toAffineNiels() {
        FieldElement fieldElementM2117invert = this.f1975Z.m2117invert();
        FieldElement fieldElementMultiply = this.f1973X.multiply(fieldElementM2117invert);
        FieldElement fieldElementMultiply2 = this.f1974Y.multiply(fieldElementM2117invert);
        return new AffineNielsPoint(fieldElementMultiply2.m2114add(fieldElementMultiply), fieldElementMultiply2.subtract(fieldElementMultiply), fieldElementMultiply.multiply(fieldElementMultiply2).multiply(Constants.EDWARDS_2D));
    }

    public ProjectivePoint toProjective() {
        return new ProjectivePoint(this.f1973X, this.f1974Y, this.f1975Z);
    }

    public ProjectiveNielsPoint toProjectiveNiels() {
        return new ProjectiveNielsPoint(this.f1974Y.m2114add(this.f1973X), this.f1974Y.subtract(this.f1973X), this.f1975Z, this.f1972T.multiply(Constants.EDWARDS_2D));
    }

    /* renamed from: add */
    public CompletedPoint m2107add(ProjectiveNielsPoint projectiveNielsPoint) {
        FieldElement fieldElementM2114add = this.f1974Y.m2114add(this.f1973X);
        FieldElement fieldElementSubtract = this.f1974Y.subtract(this.f1973X);
        FieldElement fieldElementMultiply = fieldElementM2114add.multiply(projectiveNielsPoint.f1982YPlusX);
        FieldElement fieldElementMultiply2 = fieldElementSubtract.multiply(projectiveNielsPoint.f1981YMinusX);
        FieldElement fieldElementMultiply3 = this.f1972T.multiply(projectiveNielsPoint.f1980T2D);
        FieldElement fieldElementMultiply4 = this.f1975Z.multiply(projectiveNielsPoint.f1983Z);
        FieldElement fieldElementM2114add2 = fieldElementMultiply4.m2114add(fieldElementMultiply4);
        return new CompletedPoint(fieldElementMultiply.subtract(fieldElementMultiply2), fieldElementMultiply.m2114add(fieldElementMultiply2), fieldElementM2114add2.m2114add(fieldElementMultiply3), fieldElementM2114add2.subtract(fieldElementMultiply3));
    }

    public CompletedPoint subtract(ProjectiveNielsPoint projectiveNielsPoint) {
        FieldElement fieldElementM2114add = this.f1974Y.m2114add(this.f1973X);
        FieldElement fieldElementSubtract = this.f1974Y.subtract(this.f1973X);
        FieldElement fieldElementMultiply = fieldElementM2114add.multiply(projectiveNielsPoint.f1981YMinusX);
        FieldElement fieldElementMultiply2 = fieldElementSubtract.multiply(projectiveNielsPoint.f1982YPlusX);
        FieldElement fieldElementMultiply3 = this.f1972T.multiply(projectiveNielsPoint.f1980T2D);
        FieldElement fieldElementMultiply4 = this.f1975Z.multiply(projectiveNielsPoint.f1983Z);
        FieldElement fieldElementM2114add2 = fieldElementMultiply4.m2114add(fieldElementMultiply4);
        return new CompletedPoint(fieldElementMultiply.subtract(fieldElementMultiply2), fieldElementMultiply.m2114add(fieldElementMultiply2), fieldElementM2114add2.subtract(fieldElementMultiply3), fieldElementM2114add2.m2114add(fieldElementMultiply3));
    }

    /* renamed from: add */
    public CompletedPoint m2106add(AffineNielsPoint affineNielsPoint) {
        FieldElement fieldElementM2114add = this.f1974Y.m2114add(this.f1973X);
        FieldElement fieldElementSubtract = this.f1974Y.subtract(this.f1973X);
        FieldElement fieldElementMultiply = fieldElementM2114add.multiply(affineNielsPoint.f1957yPlusx);
        FieldElement fieldElementMultiply2 = fieldElementSubtract.multiply(affineNielsPoint.f1956yMinusx);
        FieldElement fieldElementMultiply3 = this.f1972T.multiply(affineNielsPoint.f1955xy2D);
        FieldElement fieldElement = this.f1975Z;
        FieldElement fieldElementM2114add2 = fieldElement.m2114add(fieldElement);
        return new CompletedPoint(fieldElementMultiply.subtract(fieldElementMultiply2), fieldElementMultiply.m2114add(fieldElementMultiply2), fieldElementM2114add2.m2114add(fieldElementMultiply3), fieldElementM2114add2.subtract(fieldElementMultiply3));
    }

    public CompletedPoint subtract(AffineNielsPoint affineNielsPoint) {
        FieldElement fieldElementM2114add = this.f1974Y.m2114add(this.f1973X);
        FieldElement fieldElementSubtract = this.f1974Y.subtract(this.f1973X);
        FieldElement fieldElementMultiply = fieldElementM2114add.multiply(affineNielsPoint.f1956yMinusx);
        FieldElement fieldElementMultiply2 = fieldElementSubtract.multiply(affineNielsPoint.f1957yPlusx);
        FieldElement fieldElementMultiply3 = this.f1972T.multiply(affineNielsPoint.f1955xy2D);
        FieldElement fieldElement = this.f1975Z;
        FieldElement fieldElementM2114add2 = fieldElement.m2114add(fieldElement);
        return new CompletedPoint(fieldElementMultiply.subtract(fieldElementMultiply2), fieldElementMultiply.m2114add(fieldElementMultiply2), fieldElementM2114add2.subtract(fieldElementMultiply3), fieldElementM2114add2.m2114add(fieldElementMultiply3));
    }
}
