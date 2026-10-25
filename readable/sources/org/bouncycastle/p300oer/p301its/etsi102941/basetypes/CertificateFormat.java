package org.bouncycastle.p300oer.p301its.etsi102941.basetypes;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class CertificateFormat extends ASN1Object {

    /* renamed from: format */
    private final int f22615format;

    public CertificateFormat(int i) {
        this.f22615format = i;
    }

    public static CertificateFormat getInstance(Object obj) {
        if (obj instanceof CertificateFormat) {
            return (CertificateFormat) obj;
        }
        if (obj != null) {
            return new CertificateFormat(ASN1Integer.getInstance(obj));
        }
        return null;
    }

    public int getFormat() {
        return this.f22615format;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return ASN1Integer.m14429valueOf(this.f22615format);
    }

    public CertificateFormat(BigInteger bigInteger) {
        this.f22615format = BigIntegers.intValueExact(bigInteger);
    }

    private CertificateFormat(ASN1Integer aSN1Integer) {
        this(aSN1Integer.getValue());
    }
}
