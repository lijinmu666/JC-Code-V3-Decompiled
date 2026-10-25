package org.bouncycastle.p177cert.selector.p189jcajce;

import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.X509CertSelector;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p177cert.selector.X509CertificateHolderSelector;

/* loaded from: classes2.dex */
public class JcaSelectorConverter {
    public X509CertificateHolderSelector getCertificateHolderSelector(X509CertSelector x509CertSelector) {
        try {
            X500Name x500Name = X500Name.getInstance(x509CertSelector.getIssuerAsBytes());
            BigInteger serialNumber = x509CertSelector.getSerialNumber();
            byte[] subjectKeyIdentifier = x509CertSelector.getSubjectKeyIdentifier();
            return new X509CertificateHolderSelector(x500Name, serialNumber, subjectKeyIdentifier != null ? ASN1OctetString.getInstance(subjectKeyIdentifier).getOctets() : null);
        } catch (IOException e) {
            throw new IllegalArgumentException("unable to convert issuer: " + e.getMessage());
        }
    }
}
