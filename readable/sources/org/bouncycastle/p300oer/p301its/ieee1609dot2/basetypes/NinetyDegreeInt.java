package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;

/* loaded from: classes2.dex */
public class NinetyDegreeInt extends ASN1Object {

    /* renamed from: value */
    private final BigInteger f22737value;
    private static final BigInteger loweBound = new BigInteger("-900000000");
    private static final BigInteger upperBound = new BigInteger("900000000");

    /* renamed from: unknown */
    private static final BigInteger f22736unknown = new BigInteger("900000001");

    public NinetyDegreeInt(long j) {
        this(BigInteger.valueOf(j));
    }

    public static NinetyDegreeInt getInstance(Object obj) {
        if (obj instanceof NinetyDegreeInt) {
            return (NinetyDegreeInt) obj;
        }
        if (obj != null) {
            return new NinetyDegreeInt(ASN1Integer.getInstance(obj));
        }
        return null;
    }

    public BigInteger getValue() {
        return this.f22737value;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new ASN1Integer(this.f22737value);
    }

    public NinetyDegreeInt(BigInteger bigInteger) {
        if (!bigInteger.equals(f22736unknown)) {
            if (bigInteger.compareTo(loweBound) < 0) {
                throw new IllegalStateException("ninety degree int cannot be less than -900000000");
            }
            if (bigInteger.compareTo(upperBound) > 0) {
                throw new IllegalStateException("ninety degree int cannot be greater than 900000000");
            }
        }
        this.f22737value = bigInteger;
    }

    private NinetyDegreeInt(ASN1Integer aSN1Integer) {
        this(aSN1Integer.getValue());
    }
}
