package org.bouncycastle.p177cert.p185jcajce;

import java.math.BigInteger;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.Date;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.C5194Time;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p177cert.X509v3CertificateBuilder;

/* loaded from: classes2.dex */
public class JcaX509v3CertificateBuilder extends X509v3CertificateBuilder {
    public JcaX509v3CertificateBuilder(X509Certificate x509Certificate) {
        super(new JcaX509CertificateHolder(x509Certificate));
    }

    private static SubjectPublicKeyInfo getSubjectPublicKeyInfo(PublicKey publicKey) {
        return SubjectPublicKeyInfo.getInstance(publicKey.getEncoded());
    }

    public JcaX509v3CertificateBuilder copyAndAddExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, X509Certificate x509Certificate) {
        copyAndAddExtension(aSN1ObjectIdentifier, z, new JcaX509CertificateHolder(x509Certificate));
        return this;
    }

    public JcaX509v3CertificateBuilder(X509Certificate x509Certificate, BigInteger bigInteger, Date date, Date date2, X500Principal x500Principal, PublicKey publicKey) {
        this(x509Certificate.getSubjectX500Principal(), bigInteger, date, date2, x500Principal, publicKey);
    }

    public JcaX509v3CertificateBuilder(X509Certificate x509Certificate, BigInteger bigInteger, Date date, Date date2, X500Name x500Name, PublicKey publicKey) {
        this(X500Name.getInstance(x509Certificate.getSubjectX500Principal().getEncoded()), bigInteger, date, date2, x500Name, publicKey);
    }

    public JcaX509v3CertificateBuilder(X500Principal x500Principal, BigInteger bigInteger, Date date, Date date2, X500Principal x500Principal2, PublicKey publicKey) {
        super(X500Name.getInstance(x500Principal.getEncoded()), bigInteger, date, date2, X500Name.getInstance(x500Principal2.getEncoded()), getSubjectPublicKeyInfo(publicKey));
    }

    public JcaX509v3CertificateBuilder(X500Name x500Name, BigInteger bigInteger, Date date, Date date2, X500Name x500Name2, PublicKey publicKey) {
        super(x500Name, bigInteger, date, date2, x500Name2, getSubjectPublicKeyInfo(publicKey));
    }

    public JcaX509v3CertificateBuilder(X500Name x500Name, BigInteger bigInteger, Date date, Date date2, X500Name x500Name2, SubjectPublicKeyInfo subjectPublicKeyInfo) {
        super(x500Name, bigInteger, date, date2, x500Name2, subjectPublicKeyInfo);
    }

    public JcaX509v3CertificateBuilder(X500Name x500Name, BigInteger bigInteger, C5194Time c5194Time, C5194Time c5194Time2, X500Name x500Name2, PublicKey publicKey) {
        super(x500Name, bigInteger, c5194Time, c5194Time2, x500Name2, getSubjectPublicKeyInfo(publicKey));
    }
}
