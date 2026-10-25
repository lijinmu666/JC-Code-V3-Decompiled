package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;

/* loaded from: classes2.dex */
public class OneEightyDegreeInt extends ASN1Object {

    /* renamed from: value */
    private final BigInteger f22739value;
    private static final BigInteger loweBound = new BigInteger("-1799999999");
    private static final BigInteger upperBound = new BigInteger("1800000000");

    /* renamed from: unknown */
    private static final BigInteger f22738unknown = new BigInteger("1800000001");

    public OneEightyDegreeInt(long j) {
        this(BigInteger.valueOf(j));
    }

    private static BigInteger assertValue(BigInteger bigInteger) {
        return bigInteger;
    }

    public static OneEightyDegreeInt getInstance(Object obj) {
        if (obj instanceof OneEightyDegreeInt) {
            return (OneEightyDegreeInt) obj;
        }
        if (obj != null) {
            return new OneEightyDegreeInt(ASN1Integer.getInstance(obj));
        }
        return null;
    }

    public BigInteger getValue() {
        return this.f22739value;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new ASN1Integer(this.f22739value);
    }

    public OneEightyDegreeInt(BigInteger bigInteger) {
        if (!bigInteger.equals(f22738unknown)) {
            if (bigInteger.compareTo(loweBound) < 0) {
                throw new IllegalStateException("one eighty degree int cannot be less than -1799999999");
            }
            if (bigInteger.compareTo(upperBound) > 0) {
                throw new IllegalStateException("one eighty degree int cannot be greater than 1800000000");
            }
        }
        this.f22739value = bigInteger;
    }

    private OneEightyDegreeInt(ASN1Integer aSN1Integer) {
        this(aSN1Integer.getValue());
    }
}
