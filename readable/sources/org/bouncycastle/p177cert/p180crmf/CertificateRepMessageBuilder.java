package org.bouncycastle.p177cert.p180crmf;

import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.p133asn1.p138cmp.CMPCertificate;
import org.bouncycastle.p133asn1.p138cmp.CertRepMessage;
import org.bouncycastle.p133asn1.p138cmp.CertResponse;
import org.bouncycastle.p177cert.X509CertificateHolder;

/* loaded from: classes2.dex */
public class CertificateRepMessageBuilder {

    /* renamed from: caCerts */
    private final CMPCertificate[] f18822caCerts;
    private final List<CertResponse> responses = new ArrayList();

    public CertificateRepMessageBuilder(X509CertificateHolder... x509CertificateHolderArr) {
        this.f18822caCerts = new CMPCertificate[x509CertificateHolderArr.length];
        for (int i = 0; i != x509CertificateHolderArr.length; i++) {
            this.f18822caCerts[i] = new CMPCertificate(x509CertificateHolderArr[i].toASN1Structure());
        }
    }

    public CertificateRepMessageBuilder addCertificateResponse(CertificateResponse certificateResponse) {
        this.responses.add(certificateResponse.toASN1Structure());
        return this;
    }

    /* renamed from: build */
    public CertificateRepMessage m14778build() {
        CMPCertificate[] cMPCertificateArr = this.f18822caCerts;
        CertRepMessage certRepMessage = cMPCertificateArr.length != 0 ? new CertRepMessage(cMPCertificateArr, (CertResponse[]) this.responses.toArray(new CertResponse[0])) : new CertRepMessage(null, (CertResponse[]) this.responses.toArray(new CertResponse[0]));
        this.responses.clear();
        return new CertificateRepMessage(certRepMessage);
    }
}
