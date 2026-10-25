package org.bouncycastle.p133asn1.p138cmp;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* loaded from: classes.dex */
public class CertRepMessage extends ASN1Object {

    /* renamed from: caPubs */
    private final ASN1Sequence f18101caPubs;
    private final ASN1Sequence response;

    private CertRepMessage(ASN1Sequence aSN1Sequence) {
        int i = 0;
        if (aSN1Sequence.mo14450size() > 1) {
            this.f18101caPubs = ASN1Sequence.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(0), true);
            i = 1;
        } else {
            this.f18101caPubs = null;
        }
        this.response = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(i));
    }

    public static CertRepMessage getInstance(Object obj) {
        if (obj instanceof CertRepMessage) {
            return (CertRepMessage) obj;
        }
        if (obj != null) {
            return new CertRepMessage(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CMPCertificate[] getCaPubs() {
        ASN1Sequence aSN1Sequence = this.f18101caPubs;
        if (aSN1Sequence == null) {
            return null;
        }
        int iMo14450size = aSN1Sequence.mo14450size();
        CMPCertificate[] cMPCertificateArr = new CMPCertificate[iMo14450size];
        for (int i = 0; i != iMo14450size; i++) {
            cMPCertificateArr[i] = CMPCertificate.getInstance(this.f18101caPubs.getObjectAt(i));
        }
        return cMPCertificateArr;
    }

    public CertResponse[] getResponse() {
        int iMo14450size = this.response.mo14450size();
        CertResponse[] certResponseArr = new CertResponse[iMo14450size];
        for (int i = 0; i != iMo14450size; i++) {
            certResponseArr[i] = CertResponse.getInstance(this.response.getObjectAt(i));
        }
        return certResponseArr;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        ASN1Sequence aSN1Sequence = this.f18101caPubs;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 1, (ASN1Encodable) aSN1Sequence));
        }
        aSN1EncodableVector.m14420add(this.response);
        return new DERSequence(aSN1EncodableVector);
    }

    public CertRepMessage(CMPCertificate[] cMPCertificateArr, CertResponse[] certResponseArr) {
        if (certResponseArr == null) {
            throw new IllegalArgumentException("'response' cannot be null");
        }
        if (cMPCertificateArr == null || cMPCertificateArr.length == 0) {
            this.f18101caPubs = null;
        } else {
            this.f18101caPubs = new DERSequence(cMPCertificateArr);
        }
        this.response = new DERSequence(certResponseArr);
    }
}
