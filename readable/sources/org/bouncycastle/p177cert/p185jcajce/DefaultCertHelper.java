package org.bouncycastle.p177cert.p185jcajce;

import java.security.cert.CertificateFactory;

/* loaded from: classes2.dex */
class DefaultCertHelper extends CertHelper {
    @Override // org.bouncycastle.p177cert.p185jcajce.CertHelper
    public CertificateFactory createCertificateFactory(String str) {
        return CertificateFactory.getInstance(str);
    }
}
