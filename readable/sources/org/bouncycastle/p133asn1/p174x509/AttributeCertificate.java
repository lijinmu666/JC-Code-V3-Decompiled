package org.bouncycastle.p133asn1.p174x509;

import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class AttributeCertificate extends ASN1Object {

    /* renamed from: acinfo */
    AttributeCertificateInfo f18624acinfo;
    AlgorithmIdentifier signatureAlgorithm;
    ASN1BitString signatureValue;

    private AttributeCertificate(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() == 3) {
            this.f18624acinfo = AttributeCertificateInfo.getInstance(aSN1Sequence.getObjectAt(0));
            this.signatureAlgorithm = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
            this.signatureValue = ASN1BitString.getInstance(aSN1Sequence.getObjectAt(2));
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.mo14450size());
        }
    }

    public static AttributeCertificate getInstance(Object obj) {
        if (obj instanceof AttributeCertificate) {
            return (AttributeCertificate) obj;
        }
        if (obj != null) {
            return new AttributeCertificate(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AttributeCertificateInfo getAcinfo() {
        return this.f18624acinfo;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    public ASN1BitString getSignatureValue() {
        return this.signatureValue;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(this.f18624acinfo);
        aSN1EncodableVector.m14420add(this.signatureAlgorithm);
        aSN1EncodableVector.m14420add(this.signatureValue);
        return new DERSequence(aSN1EncodableVector);
    }

    public AttributeCertificate(AttributeCertificateInfo attributeCertificateInfo, AlgorithmIdentifier algorithmIdentifier, ASN1BitString aSN1BitString) {
        this.f18624acinfo = attributeCertificateInfo;
        this.signatureAlgorithm = algorithmIdentifier;
        this.signatureValue = aSN1BitString;
    }
}
