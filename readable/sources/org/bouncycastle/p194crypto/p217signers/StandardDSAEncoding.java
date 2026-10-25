package org.bouncycastle.p194crypto.p217signers;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class StandardDSAEncoding implements DSAEncoding {
    public static final StandardDSAEncoding INSTANCE = new StandardDSAEncoding();

    public BigInteger checkValue(BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger2.signum() < 0 || (bigInteger != null && bigInteger2.compareTo(bigInteger) >= 0)) {
            throw new IllegalArgumentException("Value out of range");
        }
        return bigInteger2;
    }

    @Override // org.bouncycastle.p194crypto.p217signers.DSAEncoding
    /* renamed from: decode */
    public BigInteger[] mo15856decode(BigInteger bigInteger, byte[] bArr) {
        ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(bArr);
        if (aSN1Sequence.mo14450size() == 2) {
            BigInteger bigIntegerDecodeValue = decodeValue(bigInteger, aSN1Sequence, 0);
            BigInteger bigIntegerDecodeValue2 = decodeValue(bigInteger, aSN1Sequence, 1);
            if (C6238Arrays.areEqual(mo15857encode(bigInteger, bigIntegerDecodeValue, bigIntegerDecodeValue2), bArr)) {
                return new BigInteger[]{bigIntegerDecodeValue, bigIntegerDecodeValue2};
            }
        }
        throw new IllegalArgumentException("Malformed signature");
    }

    public BigInteger decodeValue(BigInteger bigInteger, ASN1Sequence aSN1Sequence, int i) {
        return checkValue(bigInteger, ((ASN1Integer) aSN1Sequence.getObjectAt(i)).getValue());
    }

    @Override // org.bouncycastle.p194crypto.p217signers.DSAEncoding
    /* renamed from: encode */
    public byte[] mo15857encode(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        return new DERSequence(encodeValue(bigInteger, bigInteger2), encodeValue(bigInteger, bigInteger3)).getEncoded(ASN1Encoding.f17902DER);
    }

    public ASN1Integer encodeValue(BigInteger bigInteger, BigInteger bigInteger2) {
        return new ASN1Integer(checkValue(bigInteger, bigInteger2));
    }
}
