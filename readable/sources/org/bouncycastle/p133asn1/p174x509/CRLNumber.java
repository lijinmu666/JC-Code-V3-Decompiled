package org.bouncycastle.p133asn1.p174x509;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class CRLNumber extends ASN1Object {

    /* renamed from: number */
    private BigInteger f18630number;

    public CRLNumber(BigInteger bigInteger) {
        if (BigIntegers.f24192ZERO.compareTo(bigInteger) > 0) {
            throw new IllegalArgumentException("Invalid CRL number : not in (0..MAX)");
        }
        this.f18630number = bigInteger;
    }

    public static CRLNumber getInstance(Object obj) {
        if (obj instanceof CRLNumber) {
            return (CRLNumber) obj;
        }
        if (obj != null) {
            return new CRLNumber(ASN1Integer.getInstance(obj).getValue());
        }
        return null;
    }

    public BigInteger getCRLNumber() {
        return this.f18630number;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new ASN1Integer(this.f18630number);
    }

    public String toString() {
        return "CRLNumber: " + getCRLNumber();
    }
}
