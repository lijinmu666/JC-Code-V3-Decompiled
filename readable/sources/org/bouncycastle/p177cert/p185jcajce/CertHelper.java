package org.bouncycastle.p177cert.p185jcajce;

import java.security.cert.CertificateFactory;

/* loaded from: classes2.dex */
abstract class CertHelper {
    public abstract CertificateFactory createCertificateFactory(String str);

    public CertificateFactory getCertificateFactory(String str) {
        return createCertificateFactory(str);
    }
}
