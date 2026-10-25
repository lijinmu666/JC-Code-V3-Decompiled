package org.bouncycastle.p177cert.p180crmf;

import org.bouncycastle.p133asn1.p138cmp.C5114PKIBody;
import org.bouncycastle.p133asn1.p141crmf.CertReqMessages;
import org.bouncycastle.p133asn1.p141crmf.CertReqMsg;

/* loaded from: classes2.dex */
public class CertificateReqMessages {

    /* renamed from: reqs */
    private final CertReqMsg[] f18823reqs;

    public CertificateReqMessages(CertReqMessages certReqMessages) {
        this.f18823reqs = certReqMessages.toCertReqMsgArray();
    }

    public static CertificateReqMessages fromPKIBody(C5114PKIBody c5114PKIBody) {
        if (isCertificateRequestMessages(c5114PKIBody.m14517getType())) {
            return new CertificateReqMessages(CertReqMessages.getInstance(c5114PKIBody.getContent()));
        }
        throw new IllegalArgumentException("content of PKIBody wrong type: " + c5114PKIBody.m14517getType());
    }

    public static boolean isCertificateRequestMessages(int i) {
        return i == 0 || i == 2 || i == 7 || i == 9 || i == 13;
    }

    public CertificateRequestMessage[] getRequests() {
        int length = this.f18823reqs.length;
        CertificateRequestMessage[] certificateRequestMessageArr = new CertificateRequestMessage[length];
        for (int i = 0; i != length; i++) {
            certificateRequestMessageArr[i] = new CertificateRequestMessage(this.f18823reqs[i]);
        }
        return certificateRequestMessageArr;
    }

    public CertReqMessages toASN1Structure() {
        return new CertReqMessages(this.f18823reqs);
    }
}
