package org.bouncycastle.p133asn1.p141crmf;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class CertReqMsg extends ASN1Object {

    /* renamed from: certReq */
    private CertRequest f18248certReq;

    /* renamed from: pop */
    private ProofOfPossession f18249pop;

    /* renamed from: regInfo */
    private ASN1Sequence f18250regInfo;

    private CertReqMsg(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f18248certReq = CertRequest.getInstance(objects.nextElement());
        while (objects.hasMoreElements()) {
            Object objNextElement = objects.nextElement();
            if ((objNextElement instanceof ASN1TaggedObject) || (objNextElement instanceof ProofOfPossession)) {
                this.f18249pop = ProofOfPossession.getInstance(objNextElement);
            } else {
                this.f18250regInfo = ASN1Sequence.getInstance(objNextElement);
            }
        }
    }

    private void addOptional(ASN1EncodableVector aSN1EncodableVector, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            aSN1EncodableVector.m14420add(aSN1Encodable);
        }
    }

    public static CertReqMsg getInstance(Object obj) {
        if (obj instanceof CertReqMsg) {
            return (CertReqMsg) obj;
        }
        if (obj != null) {
            return new CertReqMsg(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CertRequest getCertReq() {
        return this.f18248certReq;
    }

    /* renamed from: getPop */
    public ProofOfPossession m14562getPop() {
        return this.f18249pop;
    }

    /* renamed from: getPopo */
    public ProofOfPossession m14563getPopo() {
        return this.f18249pop;
    }

    public AttributeTypeAndValue[] getRegInfo() {
        ASN1Sequence aSN1Sequence = this.f18250regInfo;
        if (aSN1Sequence == null) {
            return null;
        }
        int iMo14450size = aSN1Sequence.mo14450size();
        AttributeTypeAndValue[] attributeTypeAndValueArr = new AttributeTypeAndValue[iMo14450size];
        for (int i = 0; i != iMo14450size; i++) {
            attributeTypeAndValueArr[i] = AttributeTypeAndValue.getInstance(this.f18250regInfo.getObjectAt(i));
        }
        return attributeTypeAndValueArr;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(this.f18248certReq);
        addOptional(aSN1EncodableVector, this.f18249pop);
        addOptional(aSN1EncodableVector, this.f18250regInfo);
        return new DERSequence(aSN1EncodableVector);
    }

    public CertReqMsg(CertRequest certRequest, ProofOfPossession proofOfPossession, AttributeTypeAndValue[] attributeTypeAndValueArr) {
        if (certRequest == null) {
            throw new IllegalArgumentException("'certReq' cannot be null");
        }
        this.f18248certReq = certRequest;
        this.f18249pop = proofOfPossession;
        if (attributeTypeAndValueArr != null) {
            this.f18250regInfo = new DERSequence(attributeTypeAndValueArr);
        }
    }

    public static CertReqMsg getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
