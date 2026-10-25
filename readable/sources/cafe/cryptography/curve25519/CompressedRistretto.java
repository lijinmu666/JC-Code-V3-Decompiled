package cafe.cryptography.curve25519;

import cafe.cryptography.curve25519.FieldElement;
import cafe.cryptography.p027subtle.ConstantTime;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

/* loaded from: classes.dex */
public class CompressedRistretto implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: data */
    private transient byte[] f1965data;

    public CompressedRistretto(byte[] bArr) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("Invalid CompressedRistretto encoding");
        }
        this.f1965data = bArr;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        byte[] bArr = new byte[32];
        objectInputStream.readFully(bArr);
        this.f1965data = bArr;
    }

    private void readObjectNoData() throws InvalidObjectException {
        throw new InvalidObjectException("Cannot deserialize CompressedRistretto from no data");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.write(toByteArray());
    }

    public int ctEquals(CompressedRistretto compressedRistretto) {
        return ConstantTime.m2146equal(this.f1965data, compressedRistretto.f1965data);
    }

    public RistrettoElement decompress() throws InvalidEncodingException {
        FieldElement fieldElementFromByteArray = FieldElement.fromByteArray(this.f1965data);
        if (ConstantTime.m2146equal(this.f1965data, fieldElementFromByteArray.toByteArray()) == 0 || fieldElementFromByteArray.isNegative() == 1) {
            throw new InvalidEncodingException("Invalid ristretto255 encoding");
        }
        FieldElement fieldElementM2121square = fieldElementFromByteArray.m2121square();
        FieldElement fieldElement = FieldElement.f1976ONE;
        FieldElement fieldElementSubtract = fieldElement.subtract(fieldElementM2121square);
        FieldElement fieldElementM2114add = fieldElement.m2114add(fieldElementM2121square);
        FieldElement fieldElementM2121square2 = fieldElementM2114add.m2121square();
        FieldElement fieldElementSubtract2 = Constants.NEG_EDWARDS_D.multiply(fieldElementSubtract.m2121square()).subtract(fieldElementM2121square2);
        FieldElement.SqrtRatioM1Result sqrtRatioM1ResultSqrtRatioM1 = FieldElement.sqrtRatioM1(fieldElement, fieldElementSubtract2.multiply(fieldElementM2121square2));
        FieldElement fieldElementMultiply = sqrtRatioM1ResultSqrtRatioM1.f1979result.multiply(fieldElementM2114add);
        FieldElement fieldElementMultiply2 = sqrtRatioM1ResultSqrtRatioM1.f1979result.multiply(fieldElementMultiply).multiply(fieldElementSubtract2);
        FieldElement fieldElementM2115ctAbs = fieldElementFromByteArray.m2114add(fieldElementFromByteArray).multiply(fieldElementMultiply).m2115ctAbs();
        FieldElement fieldElementMultiply3 = fieldElementSubtract.multiply(fieldElementMultiply2);
        FieldElement fieldElementMultiply4 = fieldElementM2115ctAbs.multiply(fieldElementMultiply3);
        if (sqrtRatioM1ResultSqrtRatioM1.wasSquare == 0 || fieldElementMultiply4.isNegative() == 1 || fieldElementMultiply3.m2118isZero() == 1) {
            throw new InvalidEncodingException("Invalid ristretto255 encoding");
        }
        return new RistrettoElement(new EdwardsPoint(fieldElementM2115ctAbs, fieldElementMultiply3, fieldElement, fieldElementMultiply4));
    }

    /* renamed from: equals */
    public boolean m2105equals(Object obj) {
        return (obj instanceof CompressedRistretto) && ctEquals((CompressedRistretto) obj) == 1;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f1965data);
    }

    public byte[] toByteArray() {
        return this.f1965data;
    }
}
