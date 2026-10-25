package org.bouncycastle.p177cert.p180crmf;

import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.p133asn1.p141crmf.CertReqMessages;
import org.bouncycastle.p133asn1.p141crmf.CertReqMsg;

/* loaded from: classes2.dex */
public class CertificateReqMessagesBuilder {
    private final List<CertReqMsg> requests = new ArrayList();

    public void addRequest(CertificateRequestMessage certificateRequestMessage) {
        this.requests.add(certificateRequestMessage.toASN1Structure());
    }

    /* renamed from: build */
    public CertificateReqMessages m14779build() {
        CertificateReqMessages certificateReqMessages = new CertificateReqMessages(new CertReqMessages((CertReqMsg[]) this.requests.toArray(new CertReqMsg[0])));
        this.requests.clear();
        return certificateReqMessages;
    }
}
