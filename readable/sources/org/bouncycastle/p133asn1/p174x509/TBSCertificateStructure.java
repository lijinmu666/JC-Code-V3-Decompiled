package org.bouncycastle.p133asn1.p174x509;

import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p172x500.X500Name;

/* loaded from: classes2.dex */
public class TBSCertificateStructure extends ASN1Object implements X509ObjectIdentifiers, PKCSObjectIdentifiers {
    X509Extensions extensions;

    /* renamed from: issuer */
    X500Name f18691issuer;
    ASN1BitString issuerUniqueId;

    /* renamed from: seq */
    ASN1Sequence f18692seq;
    ASN1Integer serialNumber;
    AlgorithmIdentifier signature;

    /* renamed from: subject */
    X500Name f18693subject;
    SubjectPublicKeyInfo subjectPublicKeyInfo;
    ASN1BitString subjectUniqueId;
    Validity validity;

    /* renamed from: version */
    ASN1Integer f18694version;

    public TBSCertificateStructure(ASN1Sequence aSN1Sequence) {
        int i;
        this.f18692seq = aSN1Sequence;
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1TaggedObject) {
            this.f18694version = ASN1Integer.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(0), true);
            i = 0;
        } else {
            this.f18694version = ASN1Integer.f17922ZERO;
            i = -1;
        }
        this.serialNumber = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(i + 1));
        this.signature = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(i + 2));
        this.f18691issuer = X500Name.getInstance(aSN1Sequence.getObjectAt(i + 3));
        this.validity = Validity.getInstance(aSN1Sequence.getObjectAt(i + 4));
        this.f18693subject = X500Name.getInstance(aSN1Sequence.getObjectAt(i + 5));
        int i2 = i + 6;
        this.subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(aSN1Sequence.getObjectAt(i2));
        for (int iMo14450size = (aSN1Sequence.mo14450size() - i2) - 1; iMo14450size > 0; iMo14450size--) {
            ASN1TaggedObject aSN1TaggedObject = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(i2 + iMo14450size));
            int tagNo = aSN1TaggedObject.getTagNo();
            if (tagNo == 1) {
                this.issuerUniqueId = ASN1BitString.getInstance(aSN1TaggedObject, false);
            } else if (tagNo == 2) {
                this.subjectUniqueId = ASN1BitString.getInstance(aSN1TaggedObject, false);
            } else if (tagNo == 3) {
                this.extensions = X509Extensions.getInstance(aSN1TaggedObject);
            }
        }
    }

    public static TBSCertificateStructure getInstance(Object obj) {
        if (obj instanceof TBSCertificateStructure) {
            return (TBSCertificateStructure) obj;
        }
        if (obj != null) {
            return new TBSCertificateStructure(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public C5194Time getEndDate() {
        return this.validity.getNotAfter();
    }

    public X509Extensions getExtensions() {
        return this.extensions;
    }

    public X500Name getIssuer() {
        return this.f18691issuer;
    }

    public ASN1BitString getIssuerUniqueId() {
        return this.issuerUniqueId;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    public AlgorithmIdentifier getSignature() {
        return this.signature;
    }

    public C5194Time getStartDate() {
        return this.validity.getNotBefore();
    }

    public X500Name getSubject() {
        return this.f18693subject;
    }

    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return this.subjectPublicKeyInfo;
    }

    public ASN1BitString getSubjectUniqueId() {
        return this.subjectUniqueId;
    }

    public Validity getValidity() {
        return this.validity;
    }

    public int getVersion() {
        return this.f18694version.intValueExact() + 1;
    }

    public ASN1Integer getVersionNumber() {
        return this.f18694version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18692seq;
    }

    public static TBSCertificateStructure getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
