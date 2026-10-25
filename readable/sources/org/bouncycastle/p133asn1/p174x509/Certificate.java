package org.bouncycastle.p133asn1.p174x509;

import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p172x500.X500Name;

/* loaded from: classes2.dex */
public class Certificate extends ASN1Object {

    /* renamed from: seq */
    ASN1Sequence f18634seq;

    /* renamed from: sig */
    ASN1BitString f18635sig;
    AlgorithmIdentifier sigAlgId;

    /* renamed from: tbsCert */
    TBSCertificate f18636tbsCert;

    private Certificate(ASN1Sequence aSN1Sequence) {
        this.f18634seq = aSN1Sequence;
        if (aSN1Sequence.mo14450size() != 3) {
            throw new IllegalArgumentException("sequence wrong size for a certificate");
        }
        this.f18636tbsCert = TBSCertificate.getInstance(aSN1Sequence.getObjectAt(0));
        this.sigAlgId = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
        this.f18635sig = ASN1BitString.getInstance(aSN1Sequence.getObjectAt(2));
    }

    public static Certificate getInstance(Object obj) {
        if (obj instanceof Certificate) {
            return (Certificate) obj;
        }
        if (obj != null) {
            return new Certificate(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public C5194Time getEndDate() {
        return this.f18636tbsCert.getEndDate();
    }

    public Extensions getExtensions() {
        return this.f18636tbsCert.getExtensions();
    }

    public X500Name getIssuer() {
        return this.f18636tbsCert.getIssuer();
    }

    public ASN1BitString getIssuerUniqueID() {
        return this.f18636tbsCert.getIssuerUniqueId();
    }

    public ASN1Integer getSerialNumber() {
        return this.f18636tbsCert.getSerialNumber();
    }

    public ASN1BitString getSignature() {
        return this.f18635sig;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.sigAlgId;
    }

    public C5194Time getStartDate() {
        return this.f18636tbsCert.getStartDate();
    }

    public X500Name getSubject() {
        return this.f18636tbsCert.getSubject();
    }

    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return this.f18636tbsCert.getSubjectPublicKeyInfo();
    }

    public ASN1BitString getSubjectUniqueID() {
        return this.f18636tbsCert.getSubjectUniqueId();
    }

    public TBSCertificate getTBSCertificate() {
        return this.f18636tbsCert;
    }

    public Validity getValidity() {
        return this.f18636tbsCert.getValidity();
    }

    public ASN1Integer getVersion() {
        return this.f18636tbsCert.getVersion();
    }

    public int getVersionNumber() {
        return this.f18636tbsCert.getVersionNumber();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18634seq;
    }

    public Certificate(TBSCertificate tBSCertificate, AlgorithmIdentifier algorithmIdentifier, ASN1BitString aSN1BitString) {
        if (tBSCertificate == null) {
            throw new NullPointerException("'tbsCertificate' cannot be null");
        }
        if (algorithmIdentifier == null) {
            throw new NullPointerException("'signatureAlgorithm' cannot be null");
        }
        if (aSN1BitString == null) {
            throw new NullPointerException("'signature' cannot be null");
        }
        this.f18636tbsCert = tBSCertificate;
        this.sigAlgId = algorithmIdentifier;
        this.f18635sig = aSN1BitString;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(tBSCertificate);
        aSN1EncodableVector.m14420add(algorithmIdentifier);
        aSN1EncodableVector.m14420add(aSN1BitString);
        this.f18634seq = new DERSequence(aSN1EncodableVector);
    }

    public static Certificate getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
