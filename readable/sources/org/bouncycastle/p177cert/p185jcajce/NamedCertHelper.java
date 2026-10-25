package org.bouncycastle.p177cert.p185jcajce;

import java.security.cert.CertificateFactory;

/* loaded from: classes2.dex */
class NamedCertHelper extends CertHelper {
    private final String providerName;

    public NamedCertHelper(String str) {
        this.providerName = str;
    }

    @Override // org.bouncycastle.p177cert.p185jcajce.CertHelper
    public CertificateFactory createCertificateFactory(String str) {
        return CertificateFactory.getInstance(str, this.providerName);
    }
}
