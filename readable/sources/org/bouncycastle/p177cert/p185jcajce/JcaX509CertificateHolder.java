package org.bouncycastle.p177cert.p185jcajce;

import java.security.cert.X509Certificate;
import org.bouncycastle.p133asn1.p174x509.Certificate;
import org.bouncycastle.p177cert.X509CertificateHolder;

/* loaded from: classes2.dex */
public class JcaX509CertificateHolder extends X509CertificateHolder {
    public JcaX509CertificateHolder(X509Certificate x509Certificate) {
        super(Certificate.getInstance(x509Certificate.getEncoded()));
    }
}
