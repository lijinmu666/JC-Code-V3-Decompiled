package org.bouncycastle.p133asn1.p166pkcs;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.X509Name;

/* loaded from: classes2.dex */
public class IssuerAndSerialNumber extends ASN1Object {
    ASN1Integer certSerialNumber;

    /* renamed from: name */
    X500Name f18477name;

    private IssuerAndSerialNumber(ASN1Sequence aSN1Sequence) {
        this.f18477name = X500Name.getInstance(aSN1Sequence.getObjectAt(0));
        this.certSerialNumber = (ASN1Integer) aSN1Sequence.getObjectAt(1);
    }

    public static IssuerAndSerialNumber getInstance(Object obj) {
        if (obj instanceof IssuerAndSerialNumber) {
            return (IssuerAndSerialNumber) obj;
        }
        if (obj != null) {
            return new IssuerAndSerialNumber(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Integer getCertificateSerialNumber() {
        return this.certSerialNumber;
    }

    /* renamed from: getName */
    public X500Name m14630getName() {
        return this.f18477name;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.f18477name, this.certSerialNumber);
    }

    public IssuerAndSerialNumber(X500Name x500Name, BigInteger bigInteger) {
        this.f18477name = x500Name;
        this.certSerialNumber = new ASN1Integer(bigInteger);
    }

    public IssuerAndSerialNumber(X509Name x509Name, BigInteger bigInteger) {
        this.f18477name = X500Name.getInstance(x509Name.toASN1Primitive());
        this.certSerialNumber = new ASN1Integer(bigInteger);
    }

    public IssuerAndSerialNumber(X509Name x509Name, ASN1Integer aSN1Integer) {
        this.f18477name = X500Name.getInstance(x509Name.toASN1Primitive());
        this.certSerialNumber = aSN1Integer;
    }
}
