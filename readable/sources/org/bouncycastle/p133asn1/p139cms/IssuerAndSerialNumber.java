package org.bouncycastle.p133asn1.p139cms;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.Certificate;
import org.bouncycastle.p133asn1.p174x509.X509CertificateStructure;
import org.bouncycastle.p133asn1.p174x509.X509Name;

/* loaded from: classes.dex */
public class IssuerAndSerialNumber extends ASN1Object {

    /* renamed from: name */
    private X500Name f18195name;
    private ASN1Integer serialNumber;

    public IssuerAndSerialNumber(ASN1Sequence aSN1Sequence) {
        this.f18195name = X500Name.getInstance(aSN1Sequence.getObjectAt(0));
        this.serialNumber = (ASN1Integer) aSN1Sequence.getObjectAt(1);
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

    /* renamed from: getName */
    public X500Name m14540getName() {
        return this.f18195name;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.f18195name, this.serialNumber);
    }

    public IssuerAndSerialNumber(X500Name x500Name, BigInteger bigInteger) {
        this.f18195name = x500Name;
        this.serialNumber = new ASN1Integer(bigInteger);
    }

    public IssuerAndSerialNumber(Certificate certificate) {
        this.f18195name = certificate.getIssuer();
        this.serialNumber = certificate.getSerialNumber();
    }

    public IssuerAndSerialNumber(X509CertificateStructure x509CertificateStructure) {
        this.f18195name = x509CertificateStructure.getIssuer();
        this.serialNumber = x509CertificateStructure.getSerialNumber();
    }

    public IssuerAndSerialNumber(X509Name x509Name, BigInteger bigInteger) {
        this.f18195name = X500Name.getInstance(x509Name);
        this.serialNumber = new ASN1Integer(bigInteger);
    }

    public IssuerAndSerialNumber(X509Name x509Name, ASN1Integer aSN1Integer) {
        this.f18195name = X500Name.getInstance(x509Name);
        this.serialNumber = aSN1Integer;
    }
}
