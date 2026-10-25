package org.bouncycastle.p133asn1.p176x9;

import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.ECFieldElement;

/* loaded from: classes2.dex */
public class X9IntegerConverter {
    public int getByteLength(AbstractC5817ECCurve abstractC5817ECCurve) {
        return abstractC5817ECCurve.getFieldElementEncodingLength();
    }

    public byte[] integerToBytes(BigInteger bigInteger, int i) {
        byte[] byteArray = bigInteger.toByteArray();
        if (i < byteArray.length) {
            byte[] bArr = new byte[i];
            System.arraycopy(byteArray, byteArray.length - i, bArr, 0, i);
            return bArr;
        }
        if (i <= byteArray.length) {
            return byteArray;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(byteArray, 0, bArr2, i - byteArray.length, byteArray.length);
        return bArr2;
    }

    public int getByteLength(ECFieldElement eCFieldElement) {
        return eCFieldElement.getEncodedLength();
    }
}
