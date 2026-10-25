package org.bouncycastle.p191cms.p192bc;

import org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.SignatureAlgorithmIdentifierFinder;
import org.bouncycastle.operator.p305bc.BcEdDSAContentVerifierProviderBuilder;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p191cms.CMSSignatureAlgorithmNameGenerator;
import org.bouncycastle.p191cms.SignerInformationVerifier;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

/* loaded from: classes2.dex */
public class BcEdDSASignerInfoVerifierBuilder {
    private BcEdDSAContentVerifierProviderBuilder contentVerifierProviderBuilder = new BcEdDSAContentVerifierProviderBuilder();
    private DigestCalculatorProvider digestCalculatorProvider;
    private SignatureAlgorithmIdentifierFinder sigAlgIdFinder;
    private CMSSignatureAlgorithmNameGenerator sigAlgNameGen;

    public BcEdDSASignerInfoVerifierBuilder(CMSSignatureAlgorithmNameGenerator cMSSignatureAlgorithmNameGenerator, SignatureAlgorithmIdentifierFinder signatureAlgorithmIdentifierFinder, DigestAlgorithmIdentifierFinder digestAlgorithmIdentifierFinder, DigestCalculatorProvider digestCalculatorProvider) {
        this.sigAlgNameGen = cMSSignatureAlgorithmNameGenerator;
        this.sigAlgIdFinder = signatureAlgorithmIdentifierFinder;
        this.digestCalculatorProvider = digestCalculatorProvider;
    }

    /* renamed from: build */
    public SignerInformationVerifier m14911build(X509CertificateHolder x509CertificateHolder) {
        return new SignerInformationVerifier(this.sigAlgNameGen, this.sigAlgIdFinder, this.contentVerifierProviderBuilder.m17389build(x509CertificateHolder), this.digestCalculatorProvider);
    }

    /* renamed from: build */
    public SignerInformationVerifier m14912build(AsymmetricKeyParameter asymmetricKeyParameter) {
        return new SignerInformationVerifier(this.sigAlgNameGen, this.sigAlgIdFinder, this.contentVerifierProviderBuilder.m17390build(asymmetricKeyParameter), this.digestCalculatorProvider);
    }
}
