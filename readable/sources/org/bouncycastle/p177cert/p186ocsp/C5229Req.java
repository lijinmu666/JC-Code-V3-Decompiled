package org.bouncycastle.p177cert.p186ocsp;

import org.bouncycastle.p133asn1.p164ocsp.C5133Request;
import org.bouncycastle.p133asn1.p174x509.Extensions;

/* renamed from: org.bouncycastle.cert.ocsp.Req */
/* loaded from: classes2.dex */
public class C5229Req {

    /* renamed from: req */
    private C5133Request f18894req;

    public C5229Req(C5133Request c5133Request) {
        this.f18894req = c5133Request;
    }

    public CertificateID getCertID() {
        return new CertificateID(this.f18894req.getReqCert());
    }

    public Extensions getSingleRequestExtensions() {
        return this.f18894req.getSingleRequestExtensions();
    }
}
