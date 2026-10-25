package org.bouncycastle.p133asn1.p141crmf;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class CertReqMessages extends ASN1Object {

    /* renamed from: content */
    private ASN1Sequence f18247content;

    private CertReqMessages(ASN1Sequence aSN1Sequence) {
        this.f18247content = aSN1Sequence;
    }

    public static CertReqMessages getInstance(Object obj) {
        if (obj instanceof CertReqMessages) {
            return (CertReqMessages) obj;
        }
        if (obj != null) {
            return new CertReqMessages(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18247content;
    }

    public CertReqMsg[] toCertReqMsgArray() {
        int iMo14450size = this.f18247content.mo14450size();
        CertReqMsg[] certReqMsgArr = new CertReqMsg[iMo14450size];
        for (int i = 0; i != iMo14450size; i++) {
            certReqMsgArr[i] = CertReqMsg.getInstance(this.f18247content.getObjectAt(i));
        }
        return certReqMsgArr;
    }

    public CertReqMessages(CertReqMsg certReqMsg) {
        this.f18247content = new DERSequence(certReqMsg);
    }

    public CertReqMessages(CertReqMsg[] certReqMsgArr) {
        this.f18247content = new DERSequence(certReqMsgArr);
    }
}
