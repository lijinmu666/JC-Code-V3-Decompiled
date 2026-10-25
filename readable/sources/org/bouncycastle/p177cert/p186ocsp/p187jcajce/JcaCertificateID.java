package org.bouncycastle.p177cert.p186ocsp.p187jcajce;

import java.math.BigInteger;
import java.security.cert.X509Certificate;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.p177cert.p185jcajce.JcaX509CertificateHolder;
import org.bouncycastle.p177cert.p186ocsp.CertificateID;

/* loaded from: classes2.dex */
public class JcaCertificateID extends CertificateID {
    public JcaCertificateID(DigestCalculator digestCalculator, X509Certificate x509Certificate, BigInteger bigInteger) {
        super(digestCalculator, new JcaX509CertificateHolder(x509Certificate), bigInteger);
    }
}
