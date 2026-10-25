package org.bouncycastle.p133asn1.p146ess;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.PolicyInformation;

/* loaded from: classes2.dex */
public class SigningCertificate extends ASN1Object {

    /* renamed from: certs */
    ASN1Sequence f18377certs;
    ASN1Sequence policies;

    private SigningCertificate(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() < 1 || aSN1Sequence.mo14450size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.mo14450size());
        }
        this.f18377certs = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.mo14450size() > 1) {
            this.policies = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
        }
    }

    public static SigningCertificate getInstance(Object obj) {
        if (obj instanceof SigningCertificate) {
            return (SigningCertificate) obj;
        }
        if (obj != null) {
            return new SigningCertificate(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ESSCertID[] getCerts() {
        ESSCertID[] eSSCertIDArr = new ESSCertID[this.f18377certs.mo14450size()];
        for (int i = 0; i != this.f18377certs.mo14450size(); i++) {
            eSSCertIDArr[i] = ESSCertID.getInstance(this.f18377certs.getObjectAt(i));
        }
        return eSSCertIDArr;
    }

    public PolicyInformation[] getPolicies() {
        ASN1Sequence aSN1Sequence = this.policies;
        if (aSN1Sequence == null) {
            return null;
        }
        PolicyInformation[] policyInformationArr = new PolicyInformation[aSN1Sequence.mo14450size()];
        for (int i = 0; i != this.policies.mo14450size(); i++) {
            policyInformationArr[i] = PolicyInformation.getInstance(this.policies.getObjectAt(i));
        }
        return policyInformationArr;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.m14420add(this.f18377certs);
        ASN1Sequence aSN1Sequence = this.policies;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.m14420add(aSN1Sequence);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public SigningCertificate(ESSCertID eSSCertID) {
        this.f18377certs = new DERSequence(eSSCertID);
    }
}
