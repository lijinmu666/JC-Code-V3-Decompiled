package org.bouncycastle.p133asn1.p174x509;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.TBSCertList;

/* loaded from: classes2.dex */
public class CertificateList extends ASN1Object {
    int hashCodeValue;
    boolean isHashCodeSet = false;

    /* renamed from: sig */
    ASN1BitString f18637sig;
    AlgorithmIdentifier sigAlgId;
    TBSCertList tbsCertList;

    private CertificateList(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 3) {
            throw new IllegalArgumentException("sequence wrong size for CertificateList");
        }
        this.tbsCertList = TBSCertList.getInstance(aSN1Sequence.getObjectAt(0));
        this.sigAlgId = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
        this.f18637sig = ASN1BitString.getInstance(aSN1Sequence.getObjectAt(2));
    }

    public static CertificateList getInstance(Object obj) {
        if (obj instanceof CertificateList) {
            return (CertificateList) obj;
        }
        if (obj != null) {
            return new CertificateList(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public Extensions getExtensions() {
        return this.tbsCertList.getExtensions();
    }

    public X500Name getIssuer() {
        return this.tbsCertList.getIssuer();
    }

    public C5194Time getNextUpdate() {
        return this.tbsCertList.getNextUpdate();
    }

    public Enumeration getRevokedCertificateEnumeration() {
        return this.tbsCertList.getRevokedCertificateEnumeration();
    }

    public TBSCertList.CRLEntry[] getRevokedCertificates() {
        return this.tbsCertList.getRevokedCertificates();
    }

    public ASN1BitString getSignature() {
        return this.f18637sig;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.sigAlgId;
    }

    public TBSCertList getTBSCertList() {
        return this.tbsCertList;
    }

    public C5194Time getThisUpdate() {
        return this.tbsCertList.getThisUpdate();
    }

    public int getVersionNumber() {
        return this.tbsCertList.getVersionNumber();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object
    public int hashCode() {
        if (!this.isHashCodeSet) {
            this.hashCodeValue = super.hashCode();
            this.isHashCodeSet = true;
        }
        return this.hashCodeValue;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(this.tbsCertList);
        aSN1EncodableVector.m14420add(this.sigAlgId);
        aSN1EncodableVector.m14420add(this.f18637sig);
        return new DERSequence(aSN1EncodableVector);
    }

    public static CertificateList getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
