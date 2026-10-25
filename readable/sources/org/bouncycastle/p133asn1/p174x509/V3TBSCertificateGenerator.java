package org.bouncycastle.p133asn1.p174x509;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1UTCTime;
import org.bouncycastle.p133asn1.DERBitString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p172x500.X500Name;

/* loaded from: classes2.dex */
public class V3TBSCertificateGenerator {

    /* renamed from: VERSION */
    private static final DERTaggedObject f18709VERSION = new DERTaggedObject(true, 0, (ASN1Encodable) ASN1Integer.f17920TWO);
    private boolean altNamePresentAndCritical;

    /* renamed from: endDate */
    C5194Time f18710endDate;
    Extensions extensions;

    /* renamed from: issuer */
    X500Name f18711issuer;
    private DERBitString issuerUniqueID;
    ASN1Integer serialNumber;
    AlgorithmIdentifier signature;
    C5194Time startDate;

    /* renamed from: subject */
    X500Name f18712subject;
    SubjectPublicKeyInfo subjectPublicKeyInfo;
    private DERBitString subjectUniqueID;
    Validity validity;

    public ASN1Sequence generatePreTBSCertificate() {
        if (this.signature != null) {
            throw new IllegalStateException("signature field should not be set in PreTBSCertificate");
        }
        if (this.serialNumber == null || this.f18711issuer == null || ((this.validity == null && (this.startDate == null || this.f18710endDate == null)) || ((this.f18712subject == null && !this.altNamePresentAndCritical) || this.subjectPublicKeyInfo == null))) {
            throw new IllegalStateException("not all mandatory fields set in V3 TBScertificate generator");
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(9);
        aSN1EncodableVector.m14420add(f18709VERSION);
        aSN1EncodableVector.m14420add(this.serialNumber);
        aSN1EncodableVector.m14420add(this.f18711issuer);
        Validity validity = this.validity;
        if (validity == null) {
            validity = new Validity(this.startDate, this.f18710endDate);
        }
        aSN1EncodableVector.m14420add(validity);
        X500Name x500Name = this.f18712subject;
        if (x500Name == null) {
            x500Name = X500Name.getInstance(new DERSequence());
        }
        aSN1EncodableVector.m14420add(x500Name);
        aSN1EncodableVector.m14420add(this.subjectPublicKeyInfo);
        DERBitString dERBitString = this.issuerUniqueID;
        if (dERBitString != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 1, (ASN1Encodable) dERBitString));
        }
        DERBitString dERBitString2 = this.subjectUniqueID;
        if (dERBitString2 != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 2, (ASN1Encodable) dERBitString2));
        }
        Extensions extensions = this.extensions;
        if (extensions != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 3, (ASN1Encodable) extensions));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public TBSCertificate generateTBSCertificate() {
        AlgorithmIdentifier algorithmIdentifier;
        X500Name x500Name;
        Validity validity;
        ASN1Integer aSN1Integer = this.serialNumber;
        if (aSN1Integer == null || (algorithmIdentifier = this.signature) == null || (x500Name = this.f18711issuer) == null || (((validity = this.validity) == null && (this.startDate == null || this.f18710endDate == null)) || ((this.f18712subject == null && !this.altNamePresentAndCritical) || this.subjectPublicKeyInfo == null))) {
            throw new IllegalStateException("not all mandatory fields set in V3 TBScertificate generator");
        }
        ASN1Integer aSN1Integer2 = ASN1Integer.f17920TWO;
        if (validity == null) {
            validity = new Validity(this.startDate, this.f18710endDate);
        }
        Validity validity2 = validity;
        X500Name x500Name2 = this.f18712subject;
        if (x500Name2 == null) {
            x500Name2 = X500Name.getInstance(new DERSequence());
        }
        return new TBSCertificate(aSN1Integer2, aSN1Integer, algorithmIdentifier, x500Name, validity2, x500Name2, this.subjectPublicKeyInfo, this.issuerUniqueID, this.subjectUniqueID, this.extensions);
    }

    public void setEndDate(ASN1UTCTime aSN1UTCTime) {
        setEndDate(new C5194Time(aSN1UTCTime));
    }

    public void setExtensions(Extensions extensions) {
        Extension extension;
        this.extensions = extensions;
        if (extensions == null || (extension = extensions.getExtension(Extension.subjectAlternativeName)) == null || !extension.isCritical()) {
            return;
        }
        this.altNamePresentAndCritical = true;
    }

    public void setIssuer(X500Name x500Name) {
        this.f18711issuer = x500Name;
    }

    public void setIssuerUniqueID(DERBitString dERBitString) {
        this.issuerUniqueID = dERBitString;
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
        this.f18712subject = x500Name;
    }

    public void setSubjectPublicKeyInfo(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.subjectPublicKeyInfo = subjectPublicKeyInfo;
    }

    public void setSubjectUniqueID(DERBitString dERBitString) {
        this.subjectUniqueID = dERBitString;
    }

    public void setValidity(Validity validity) {
        this.validity = validity;
        this.startDate = null;
        this.f18710endDate = null;
    }

    public void setEndDate(C5194Time c5194Time) {
        this.validity = null;
        this.f18710endDate = c5194Time;
    }

    public void setExtensions(X509Extensions x509Extensions) {
        setExtensions(Extensions.getInstance(x509Extensions));
    }

    public void setIssuer(X509Name x509Name) {
        this.f18711issuer = X500Name.getInstance(x509Name);
    }

    public void setStartDate(C5194Time c5194Time) {
        this.validity = null;
        this.startDate = c5194Time;
    }

    public void setSubject(X509Name x509Name) {
        this.f18712subject = X500Name.getInstance(x509Name.toASN1Primitive());
    }
}
