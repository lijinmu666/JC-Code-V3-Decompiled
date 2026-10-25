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
public class X509CertificateStructure extends ASN1Object implements X509ObjectIdentifiers, PKCSObjectIdentifiers {

    /* renamed from: seq */
    ASN1Sequence f18714seq;

    /* renamed from: sig */
    ASN1BitString f18715sig;
    AlgorithmIdentifier sigAlgId;

    /* renamed from: tbsCert */
    TBSCertificateStructure f18716tbsCert;

    public X509CertificateStructure(ASN1Sequence aSN1Sequence) {
        this.f18714seq = aSN1Sequence;
        if (aSN1Sequence.mo14450size() != 3) {
            throw new IllegalArgumentException("sequence wrong size for a certificate");
        }
        this.f18716tbsCert = TBSCertificateStructure.getInstance(aSN1Sequence.getObjectAt(0));
        this.sigAlgId = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
        this.f18715sig = ASN1BitString.getInstance(aSN1Sequence.getObjectAt(2));
    }

    public static X509CertificateStructure getInstance(Object obj) {
        if (obj instanceof X509CertificateStructure) {
            return (X509CertificateStructure) obj;
        }
        if (obj != null) {
            return new X509CertificateStructure(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public C5194Time getEndDate() {
        return this.f18716tbsCert.getEndDate();
    }

    public X500Name getIssuer() {
        return this.f18716tbsCert.getIssuer();
    }

    public ASN1Integer getSerialNumber() {
        return this.f18716tbsCert.getSerialNumber();
    }

    public ASN1BitString getSignature() {
        return this.f18715sig;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.sigAlgId;
    }

    public C5194Time getStartDate() {
        return this.f18716tbsCert.getStartDate();
    }

    public X500Name getSubject() {
        return this.f18716tbsCert.getSubject();
    }

    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return this.f18716tbsCert.getSubjectPublicKeyInfo();
    }

    public TBSCertificateStructure getTBSCertificate() {
        return this.f18716tbsCert;
    }

    public Validity getValidity() {
        return this.f18716tbsCert.getValidity();
    }

    public int getVersion() {
        return this.f18716tbsCert.getVersion();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18714seq;
    }

    public static X509CertificateStructure getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
