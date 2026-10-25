package org.bouncycastle.p177cert.p178bc;

import java.math.BigInteger;
import java.util.Date;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p177cert.X509v3CertificateBuilder;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p221util.SubjectPublicKeyInfoFactory;

/* loaded from: classes2.dex */
public class BcX509v3CertificateBuilder extends X509v3CertificateBuilder {
    public BcX509v3CertificateBuilder(X500Name x500Name, BigInteger bigInteger, Date date, Date date2, X500Name x500Name2, AsymmetricKeyParameter asymmetricKeyParameter) {
        super(x500Name, bigInteger, date, date2, x500Name2, SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(asymmetricKeyParameter));
    }

    public BcX509v3CertificateBuilder(X509CertificateHolder x509CertificateHolder, BigInteger bigInteger, Date date, Date date2, X500Name x500Name, AsymmetricKeyParameter asymmetricKeyParameter) {
        super(x509CertificateHolder.getSubject(), bigInteger, date, date2, x500Name, SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(asymmetricKeyParameter));
    }
}
