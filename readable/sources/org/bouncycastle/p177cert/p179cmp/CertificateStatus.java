package org.bouncycastle.p177cert.p179cmp;

import java.math.BigInteger;
import org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.p133asn1.p138cmp.CMPCertificate;
import org.bouncycastle.p133asn1.p138cmp.CertStatus;
import org.bouncycastle.p133asn1.p138cmp.PKIStatusInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class CertificateStatus {
    private CertStatus certStatus;
    private DigestAlgorithmIdentifierFinder digestAlgFinder;

    public CertificateStatus(DigestAlgorithmIdentifierFinder digestAlgorithmIdentifierFinder, CertStatus certStatus) {
        this.digestAlgFinder = digestAlgorithmIdentifierFinder;
        this.certStatus = certStatus;
    }

    public BigInteger getCertRequestID() {
        return this.certStatus.getCertReqId().getValue();
    }

    public PKIStatusInfo getStatusInfo() {
        return this.certStatus.getStatusInfo();
    }

    public boolean isVerified(CMPCertificate cMPCertificate, AlgorithmIdentifier algorithmIdentifier, DigestCalculatorProvider digestCalculatorProvider) throws CMPException {
        return C6238Arrays.constantTimeAreEqual(this.certStatus.getCertHash().getOctets(), C5221CMPUtil.calculateCertHash(cMPCertificate, algorithmIdentifier, digestCalculatorProvider, this.digestAlgFinder));
    }

    public boolean isVerified(X509CertificateHolder x509CertificateHolder, DigestCalculatorProvider digestCalculatorProvider) {
        return isVerified(new CMPCertificate(x509CertificateHolder.toASN1Structure()), x509CertificateHolder.getSignatureAlgorithm(), digestCalculatorProvider);
    }
}
