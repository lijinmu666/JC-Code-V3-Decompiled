package org.bouncycastle.p300oer.p301its.ieee1609dot2;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;

/* loaded from: classes2.dex */
public class HeaderInfoContributorId extends ASN1Object {

    /* renamed from: MAX */
    private static final BigInteger f22645MAX = BigInteger.valueOf(255);
    private final BigInteger contributorId;

    public HeaderInfoContributorId(long j) {
        this(BigInteger.valueOf(j));
    }

    public static HeaderInfoContributorId getInstance(Object obj) {
        if (obj instanceof HeaderInfoContributorId) {
            return (HeaderInfoContributorId) obj;
        }
        if (obj != null) {
            return new HeaderInfoContributorId(ASN1Integer.getInstance(obj));
        }
        return null;
    }

    public BigInteger getContributorId() {
        return this.contributorId;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new ASN1Integer(this.contributorId);
    }

    public HeaderInfoContributorId(BigInteger bigInteger) {
        if (bigInteger.signum() >= 0 || bigInteger.compareTo(f22645MAX) <= 0) {
            this.contributorId = bigInteger;
            return;
        }
        throw new IllegalArgumentException("contributor id " + bigInteger + " is out of range 0..255");
    }

    private HeaderInfoContributorId(ASN1Integer aSN1Integer) {
        this(aSN1Integer.getValue());
    }
}
