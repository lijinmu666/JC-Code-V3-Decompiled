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
public class CompressedEdwardsY implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: data */
    private transient byte[] f1964data;

    public CompressedEdwardsY(byte[] bArr) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("Invalid CompressedEdwardsY encoding");
        }
        this.f1964data = bArr;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        byte[] bArr = new byte[32];
        objectInputStream.readFully(bArr);
        this.f1964data = bArr;
    }

    private void readObjectNoData() throws InvalidObjectException {
        throw new InvalidObjectException("Cannot deserialize CompressedEdwardsY from no data");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.write(toByteArray());
    }

    public int ctEquals(CompressedEdwardsY compressedEdwardsY) {
        return ConstantTime.m2146equal(this.f1964data, compressedEdwardsY.f1964data);
    }

    public EdwardsPoint decompress() {
        FieldElement fieldElementFromByteArray = FieldElement.fromByteArray(this.f1964data);
        FieldElement fieldElementM2121square = fieldElementFromByteArray.m2121square();
        FieldElement fieldElement = FieldElement.f1976ONE;
        FieldElement.SqrtRatioM1Result sqrtRatioM1ResultSqrtRatioM1 = FieldElement.sqrtRatioM1(fieldElementM2121square.subtract(fieldElement), fieldElementM2121square.multiply(Constants.EDWARDS_D).m2114add(fieldElement));
        if (sqrtRatioM1ResultSqrtRatioM1.wasSquare != 1) {
            throw new InvalidEncodingException("not a valid EdwardsPoint");
        }
        FieldElement fieldElementM2119negate = sqrtRatioM1ResultSqrtRatioM1.f1979result.m2119negate();
        FieldElement fieldElement2 = sqrtRatioM1ResultSqrtRatioM1.f1979result;
        FieldElement fieldElementCtSelect = fieldElementM2119negate.ctSelect(fieldElement2, ConstantTime.m2145equal(fieldElement2.isNegative(), ConstantTime.m2144bit(this.f1964data, 255)));
        return new EdwardsPoint(fieldElementCtSelect, fieldElementFromByteArray, fieldElement, fieldElementCtSelect.multiply(fieldElementFromByteArray));
    }

    /* renamed from: equals */
    public boolean m2104equals(Object obj) {
        return (obj instanceof CompressedEdwardsY) && ctEquals((CompressedEdwardsY) obj) == 1;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f1964data);
    }

    public byte[] toByteArray() {
        return this.f1964data;
    }
}
