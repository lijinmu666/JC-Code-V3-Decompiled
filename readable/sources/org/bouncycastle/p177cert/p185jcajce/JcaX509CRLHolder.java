package org.bouncycastle.p177cert.p185jcajce;

import java.security.cert.X509CRL;
import org.bouncycastle.p133asn1.p174x509.CertificateList;
import org.bouncycastle.p177cert.X509CRLHolder;

/* loaded from: classes2.dex */
public class JcaX509CRLHolder extends X509CRLHolder {
    public JcaX509CRLHolder(X509CRL x509crl) {
        super(CertificateList.getInstance(x509crl.getEncoded()));
    }
}
