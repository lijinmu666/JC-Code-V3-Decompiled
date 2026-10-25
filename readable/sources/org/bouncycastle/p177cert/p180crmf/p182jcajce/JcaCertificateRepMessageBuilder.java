package org.bouncycastle.p177cert.p180crmf.p182jcajce;

import java.security.cert.X509Certificate;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p177cert.p180crmf.CertificateRepMessageBuilder;
import org.bouncycastle.p177cert.p185jcajce.JcaX509CertificateHolder;

/* loaded from: classes2.dex */
public class JcaCertificateRepMessageBuilder extends CertificateRepMessageBuilder {
    public JcaCertificateRepMessageBuilder(X509Certificate... x509CertificateArr) {
        super(m14800convert(x509CertificateArr));
    }

    /* renamed from: convert */
    private static X509CertificateHolder[] m14800convert(X509Certificate... x509CertificateArr) {
        int length = x509CertificateArr.length;
        X509CertificateHolder[] x509CertificateHolderArr = new X509CertificateHolder[length];
        for (int i = 0; i != length; i++) {
            x509CertificateHolderArr[i] = new JcaX509CertificateHolder(x509CertificateArr[i]);
        }
        return x509CertificateHolderArr;
    }
}
