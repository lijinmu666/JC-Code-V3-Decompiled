package org.bouncycastle.p177cert.selector.p189jcajce;

import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.X509CertSelector;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p177cert.selector.X509CertificateHolderSelector;
import org.bouncycastle.p361util.Exceptions;

/* loaded from: classes2.dex */
public class JcaX509CertSelectorConverter {
    public X509CertSelector doConversion(X500Name x500Name, BigInteger bigInteger, byte[] bArr) throws IOException {
        X509CertSelector x509CertSelector = new X509CertSelector();
        if (x500Name != null) {
            try {
                x509CertSelector.setIssuer(x500Name.getEncoded());
            } catch (IOException e) {
                throw Exceptions.illegalArgumentException("unable to convert issuer: " + e.getMessage(), e);
            }
        }
        if (bigInteger != null) {
            x509CertSelector.setSerialNumber(bigInteger);
        }
        if (bArr != null) {
            try {
                x509CertSelector.setSubjectKeyIdentifier(new DEROctetString(bArr).getEncoded());
            } catch (IOException e2) {
                throw Exceptions.illegalArgumentException("unable to convert subjectKeyIdentifier: " + e2.getMessage(), e2);
            }
        }
        return x509CertSelector;
    }

    public X509CertSelector getCertSelector(X509CertificateHolderSelector x509CertificateHolderSelector) {
        return doConversion(x509CertificateHolderSelector.getIssuer(), x509CertificateHolderSelector.getSerialNumber(), x509CertificateHolderSelector.getSubjectKeyIdentifier());
    }
}
