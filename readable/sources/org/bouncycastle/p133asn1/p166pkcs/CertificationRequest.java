package org.bouncycastle.p133asn1.p166pkcs;

import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERBitString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public class CertificationRequest extends ASN1Object {

    /* renamed from: reqInfo */
    protected CertificationRequestInfo f18464reqInfo;
    protected AlgorithmIdentifier sigAlgId;

    /* renamed from: sigBits */
    protected ASN1BitString f18465sigBits;

    public CertificationRequest() {
        this.f18464reqInfo = null;
        this.sigAlgId = null;
        this.f18465sigBits = null;
    }

    public static CertificationRequest getInstance(Object obj) {
        if (obj instanceof CertificationRequest) {
            return (CertificationRequest) obj;
        }
        if (obj != null) {
            return new CertificationRequest(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CertificationRequestInfo getCertificationRequestInfo() {
        return this.f18464reqInfo;
    }

    public ASN1BitString getSignature() {
        return this.f18465sigBits;
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.sigAlgId;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(this.f18464reqInfo);
        aSN1EncodableVector.m14420add(this.sigAlgId);
        aSN1EncodableVector.m14420add(this.f18465sigBits);
        return new DERSequence(aSN1EncodableVector);
    }

    public CertificationRequest(ASN1Sequence aSN1Sequence) {
        this.f18464reqInfo = null;
        this.sigAlgId = null;
        this.f18465sigBits = null;
        this.f18464reqInfo = CertificationRequestInfo.getInstance(aSN1Sequence.getObjectAt(0));
        this.sigAlgId = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
        this.f18465sigBits = (DERBitString) aSN1Sequence.getObjectAt(2);
    }

    public CertificationRequest(CertificationRequestInfo certificationRequestInfo, AlgorithmIdentifier algorithmIdentifier, ASN1BitString aSN1BitString) {
        this.f18464reqInfo = certificationRequestInfo;
        this.sigAlgId = algorithmIdentifier;
        this.f18465sigBits = aSN1BitString;
    }
}
