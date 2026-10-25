package org.bouncycastle.p177cert;

import java.math.BigInteger;
import java.util.Date;
import java.util.Locale;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.C5194Time;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p133asn1.p174x509.V1TBSCertificateGenerator;

/* loaded from: classes2.dex */
public class X509v1CertificateBuilder {

    /* renamed from: tbsGen */
    private V1TBSCertificateGenerator f18803tbsGen;

    public X509v1CertificateBuilder(X500Name x500Name, BigInteger bigInteger, Date date, Date date2, Locale locale, X500Name x500Name2, SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this(x500Name, bigInteger, new C5194Time(date, locale), new C5194Time(date2, locale), x500Name2, subjectPublicKeyInfo);
    }

    /* renamed from: build */
    public X509CertificateHolder m14752build(ContentSigner contentSigner) {
        this.f18803tbsGen.setSignature(contentSigner.getAlgorithmIdentifier());
        return CertUtils.generateFullCert(contentSigner, this.f18803tbsGen.generateTBSCertificate());
    }

    public X509v1CertificateBuilder(X500Name x500Name, BigInteger bigInteger, Date date, Date date2, X500Name x500Name2, SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this(x500Name, bigInteger, new C5194Time(date), new C5194Time(date2), x500Name2, subjectPublicKeyInfo);
    }

    public X509v1CertificateBuilder(X500Name x500Name, BigInteger bigInteger, C5194Time c5194Time, C5194Time c5194Time2, X500Name x500Name2, SubjectPublicKeyInfo subjectPublicKeyInfo) {
        if (x500Name == null) {
            throw new IllegalArgumentException("issuer must not be null");
        }
        if (subjectPublicKeyInfo == null) {
            throw new IllegalArgumentException("publicKeyInfo must not be null");
        }
        V1TBSCertificateGenerator v1TBSCertificateGenerator = new V1TBSCertificateGenerator();
        this.f18803tbsGen = v1TBSCertificateGenerator;
        v1TBSCertificateGenerator.setSerialNumber(new ASN1Integer(bigInteger));
        this.f18803tbsGen.setIssuer(x500Name);
        this.f18803tbsGen.setStartDate(c5194Time);
        this.f18803tbsGen.setEndDate(c5194Time2);
        this.f18803tbsGen.setSubject(x500Name2);
        this.f18803tbsGen.setSubjectPublicKeyInfo(subjectPublicKeyInfo);
    }
}
