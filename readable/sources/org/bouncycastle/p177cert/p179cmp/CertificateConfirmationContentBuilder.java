package org.bouncycastle.p177cert.p179cmp;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p138cmp.CMPCertificate;
import org.bouncycastle.p133asn1.p138cmp.CertConfirmContent;
import org.bouncycastle.p133asn1.p138cmp.CertStatus;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p177cert.X509CertificateHolder;

/* loaded from: classes2.dex */
public class CertificateConfirmationContentBuilder {
    private List<CMPCertificate> acceptedCerts;
    private List<ASN1Integer> acceptedReqIds;
    private List<AlgorithmIdentifier> acceptedSignatureAlgorithms;
    private DigestAlgorithmIdentifierFinder digestAlgFinder;

    public CertificateConfirmationContentBuilder() {
        this(new DefaultDigestAlgorithmIdentifierFinder());
    }

    public CertificateConfirmationContentBuilder addAcceptedCertificate(CMPCertificate cMPCertificate, AlgorithmIdentifier algorithmIdentifier, ASN1Integer aSN1Integer) {
        this.acceptedCerts.add(cMPCertificate);
        this.acceptedSignatureAlgorithms.add(algorithmIdentifier);
        this.acceptedReqIds.add(aSN1Integer);
        return this;
    }

    /* renamed from: build */
    public CertificateConfirmationContent m14760build(DigestCalculatorProvider digestCalculatorProvider) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(this.acceptedCerts.size());
        for (int i = 0; i != this.acceptedCerts.size(); i++) {
            aSN1EncodableVector.m14420add(new CertStatus(C5221CMPUtil.calculateCertHash(this.acceptedCerts.get(i), this.acceptedSignatureAlgorithms.get(i), digestCalculatorProvider, this.digestAlgFinder), this.acceptedReqIds.get(i)));
        }
        return new CertificateConfirmationContent(CertConfirmContent.getInstance(new DERSequence(aSN1EncodableVector)), this.digestAlgFinder);
    }

    public CertificateConfirmationContentBuilder(DigestAlgorithmIdentifierFinder digestAlgorithmIdentifierFinder) {
        this.acceptedCerts = new ArrayList();
        this.acceptedSignatureAlgorithms = new ArrayList();
        this.acceptedReqIds = new ArrayList();
        this.digestAlgFinder = digestAlgorithmIdentifierFinder;
    }

    public CertificateConfirmationContentBuilder addAcceptedCertificate(X509CertificateHolder x509CertificateHolder, BigInteger bigInteger) {
        return addAcceptedCertificate(x509CertificateHolder, new ASN1Integer(bigInteger));
    }

    public CertificateConfirmationContentBuilder addAcceptedCertificate(X509CertificateHolder x509CertificateHolder, ASN1Integer aSN1Integer) {
        return addAcceptedCertificate(new CMPCertificate(x509CertificateHolder.toASN1Structure()), x509CertificateHolder.getSignatureAlgorithm(), aSN1Integer);
    }
}
