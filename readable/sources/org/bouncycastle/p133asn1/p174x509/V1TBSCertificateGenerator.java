package org.bouncycastle.p133asn1.p174x509;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1UTCTime;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p172x500.X500Name;

/* loaded from: classes2.dex */
public class V1TBSCertificateGenerator {

    /* renamed from: endDate */
    C5194Time f18698endDate;

    /* renamed from: issuer */
    X500Name f18699issuer;
    ASN1Integer serialNumber;
    AlgorithmIdentifier signature;
    C5194Time startDate;

    /* renamed from: subject */
    X500Name f18700subject;
    SubjectPublicKeyInfo subjectPublicKeyInfo;
    Validity validity;

    /* renamed from: version */
    DERTaggedObject f18701version = new DERTaggedObject(true, 0, (ASN1Encodable) ASN1Integer.f17922ZERO);

    public TBSCertificate generateTBSCertificate() {
        AlgorithmIdentifier algorithmIdentifier;
        X500Name x500Name;
        Validity validity;
        ASN1Integer aSN1Integer = this.serialNumber;
        if (aSN1Integer == null || (algorithmIdentifier = this.signature) == null || (x500Name = this.f18699issuer) == null || (((validity = this.validity) == null && (this.startDate == null || this.f18698endDate == null)) || this.f18700subject == null || this.subjectPublicKeyInfo == null)) {
            throw new IllegalStateException("not all mandatory fields set in V1 TBScertificate generator");
        }
        ASN1Integer aSN1Integer2 = ASN1Integer.f17922ZERO;
        if (validity == null) {
            validity = new Validity(this.startDate, this.f18698endDate);
        }
        return new TBSCertificate(aSN1Integer2, aSN1Integer, algorithmIdentifier, x500Name, validity, this.f18700subject, this.subjectPublicKeyInfo, null, null, null);
    }

    public void setEndDate(ASN1UTCTime aSN1UTCTime) {
        setEndDate(new C5194Time(aSN1UTCTime));
    }

    public void setIssuer(X500Name x500Name) {
        this.f18699issuer = x500Name;
    }

    public void setSerialNumber(ASN1Integer aSN1Integer) {
        this.serialNumber = aSN1Integer;
    }

    public void setSignature(AlgorithmIdentifier algorithmIdentifier) {
        this.signature = algorithmIdentifier;
    }

    public void setStartDate(ASN1UTCTime aSN1UTCTime) {
        setStartDate(new C5194Time(aSN1UTCTime));
    }

    public void setSubject(X500Name x500Name) {
        this.f18700subject = x500Name;
    }

    public void setSubjectPublicKeyInfo(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.subjectPublicKeyInfo = subjectPublicKeyInfo;
    }

    public void setValidity(Validity validity) {
        this.validity = validity;
        this.startDate = null;
        this.f18698endDate = null;
    }

    public void setEndDate(C5194Time c5194Time) {
        this.validity = null;
        this.f18698endDate = c5194Time;
    }

    public void setIssuer(X509Name x509Name) {
        this.f18699issuer = X500Name.getInstance(x509Name.toASN1Primitive());
    }

    public void setStartDate(C5194Time c5194Time) {
        this.validity = null;
        this.startDate = c5194Time;
    }

    public void setSubject(X509Name x509Name) {
        this.f18700subject = X500Name.getInstance(x509Name.toASN1Primitive());
    }
}
