package org.bouncycastle.p177cert.p180crmf;

import java.util.ArrayList;
import org.bouncycastle.p133asn1.p138cmp.C5114PKIBody;
import org.bouncycastle.p133asn1.p138cmp.CMPCertificate;
import org.bouncycastle.p133asn1.p138cmp.CertRepMessage;
import org.bouncycastle.p133asn1.p138cmp.CertResponse;
import org.bouncycastle.p177cert.X509CertificateHolder;

/* loaded from: classes2.dex */
public class CertificateRepMessage {

    /* renamed from: caCerts */
    private final CMPCertificate[] f18820caCerts;

    /* renamed from: resps */
    private final CertResponse[] f18821resps;

    public CertificateRepMessage(CertRepMessage certRepMessage) {
        this.f18821resps = certRepMessage.getResponse();
        this.f18820caCerts = certRepMessage.getCaPubs();
    }

    public static CertificateRepMessage fromPKIBody(C5114PKIBody c5114PKIBody) {
        if (isCertificateRepMessage(c5114PKIBody.m14517getType())) {
            return new CertificateRepMessage(CertRepMessage.getInstance(c5114PKIBody.getContent()));
        }
        throw new IllegalArgumentException("content of PKIBody wrong type: " + c5114PKIBody.m14517getType());
    }

    public static boolean isCertificateRepMessage(int i) {
        return i == 1 || i == 3 || i == 8 || i == 14;
    }

    public CMPCertificate[] getCMPCertificates() {
        CMPCertificate[] cMPCertificateArr = this.f18820caCerts;
        int length = cMPCertificateArr.length;
        CMPCertificate[] cMPCertificateArr2 = new CMPCertificate[length];
        System.arraycopy(cMPCertificateArr, 0, cMPCertificateArr2, 0, length);
        return cMPCertificateArr2;
    }

    public CertificateResponse[] getResponses() {
        int length = this.f18821resps.length;
        CertificateResponse[] certificateResponseArr = new CertificateResponse[length];
        for (int i = 0; i != length; i++) {
            certificateResponseArr[i] = new CertificateResponse(this.f18821resps[i]);
        }
        return certificateResponseArr;
    }

    public X509CertificateHolder[] getX509Certificates() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            CMPCertificate[] cMPCertificateArr = this.f18820caCerts;
            if (i == cMPCertificateArr.length) {
                return (X509CertificateHolder[]) arrayList.toArray(new X509CertificateHolder[0]);
            }
            if (cMPCertificateArr[i].isX509v3PKCert()) {
                arrayList.add(new X509CertificateHolder(this.f18820caCerts[i].getX509v3PKCert()));
            }
            i++;
        }
    }

    public boolean isOnlyX509PKCertificates() {
        boolean zIsX509v3PKCert = true;
        int i = 0;
        while (true) {
            CMPCertificate[] cMPCertificateArr = this.f18820caCerts;
            if (i == cMPCertificateArr.length) {
                return zIsX509v3PKCert;
            }
            zIsX509v3PKCert &= cMPCertificateArr[i].isX509v3PKCert();
            i++;
        }
    }

    public CertRepMessage toASN1Structure() {
        return new CertRepMessage(this.f18820caCerts, this.f18821resps);
    }
}
