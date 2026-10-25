package org.bouncycastle.p191cms.p193jcajce;

import java.security.Provider;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.operator.DefaultSignatureAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.SignatureAlgorithmIdentifierFinder;
import org.bouncycastle.operator.p306jcajce.JcaContentVerifierProviderBuilder;
import org.bouncycastle.operator.p306jcajce.JcaDigestCalculatorProviderBuilder;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p191cms.CMSSignatureAlgorithmNameGenerator;
import org.bouncycastle.p191cms.DefaultCMSSignatureAlgorithmNameGenerator;
import org.bouncycastle.p191cms.SignerInformationVerifier;

/* loaded from: classes2.dex */
public class JcaSignerInfoVerifierBuilder {
    private DigestCalculatorProvider digestProvider;

    /* renamed from: helper */
    private C5250Helper f19065helper = new C5250Helper();
    private CMSSignatureAlgorithmNameGenerator sigAlgNameGen = new DefaultCMSSignatureAlgorithmNameGenerator();
    private SignatureAlgorithmIdentifierFinder sigAlgIDFinder = new DefaultSignatureAlgorithmIdentifierFinder();

    /* renamed from: org.bouncycastle.cms.jcajce.JcaSignerInfoVerifierBuilder$Helper */
    public static class C5250Helper {
        private C5250Helper() {
        }

        public ContentVerifierProvider createContentVerifierProvider(PublicKey publicKey) {
            return new JcaContentVerifierProviderBuilder().m17393build(publicKey);
        }

        public DigestCalculatorProvider createDigestCalculatorProvider() {
            return new JcaDigestCalculatorProviderBuilder().m17397build();
        }

        public ContentVerifierProvider createContentVerifierProvider(X509Certificate x509Certificate) {
            return new JcaContentVerifierProviderBuilder().m17394build(x509Certificate);
        }

        public ContentVerifierProvider createContentVerifierProvider(X509CertificateHolder x509CertificateHolder) {
            return new JcaContentVerifierProviderBuilder().m17396build(x509CertificateHolder);
        }
    }

    public static class NamedHelper extends C5250Helper {
        private final String providerName;

        public NamedHelper(String str) {
            super();
            this.providerName = str;
        }

        @Override // org.bouncycastle.p191cms.p193jcajce.JcaSignerInfoVerifierBuilder.C5250Helper
        public ContentVerifierProvider createContentVerifierProvider(PublicKey publicKey) {
            return new JcaContentVerifierProviderBuilder().setProvider(this.providerName).m17393build(publicKey);
        }

        @Override // org.bouncycastle.p191cms.p193jcajce.JcaSignerInfoVerifierBuilder.C5250Helper
        public DigestCalculatorProvider createDigestCalculatorProvider() {
            return new JcaDigestCalculatorProviderBuilder().setProvider(this.providerName).m17397build();
        }

        @Override // org.bouncycastle.p191cms.p193jcajce.JcaSignerInfoVerifierBuilder.C5250Helper
        public ContentVerifierProvider createContentVerifierProvider(X509Certificate x509Certificate) {
            return new JcaContentVerifierProviderBuilder().setProvider(this.providerName).m17394build(x509Certificate);
        }

        @Override // org.bouncycastle.p191cms.p193jcajce.JcaSignerInfoVerifierBuilder.C5250Helper
        public ContentVerifierProvider createContentVerifierProvider(X509CertificateHolder x509CertificateHolder) {
            return new JcaContentVerifierProviderBuilder().setProvider(this.providerName).m17396build(x509CertificateHolder);
        }
    }

    public static class ProviderHelper extends C5250Helper {
        private final Provider provider;

        public ProviderHelper(Provider provider) {
            super();
            this.provider = provider;
        }

        @Override // org.bouncycastle.p191cms.p193jcajce.JcaSignerInfoVerifierBuilder.C5250Helper
        public ContentVerifierProvider createContentVerifierProvider(PublicKey publicKey) {
            return new JcaContentVerifierProviderBuilder().setProvider(this.provider).m17393build(publicKey);
        }

        @Override // org.bouncycastle.p191cms.p193jcajce.JcaSignerInfoVerifierBuilder.C5250Helper
        public DigestCalculatorProvider createDigestCalculatorProvider() {
            return new JcaDigestCalculatorProviderBuilder().setProvider(this.provider).m17397build();
        }

        @Override // org.bouncycastle.p191cms.p193jcajce.JcaSignerInfoVerifierBuilder.C5250Helper
        public ContentVerifierProvider createContentVerifierProvider(X509Certificate x509Certificate) {
            return new JcaContentVerifierProviderBuilder().setProvider(this.provider).m17394build(x509Certificate);
        }

        @Override // org.bouncycastle.p191cms.p193jcajce.JcaSignerInfoVerifierBuilder.C5250Helper
        public ContentVerifierProvider createContentVerifierProvider(X509CertificateHolder x509CertificateHolder) {
            return new JcaContentVerifierProviderBuilder().setProvider(this.provider).m17396build(x509CertificateHolder);
        }
    }

    public JcaSignerInfoVerifierBuilder(DigestCalculatorProvider digestCalculatorProvider) {
        this.digestProvider = digestCalculatorProvider;
    }

    /* renamed from: build */
    public SignerInformationVerifier m14925build(PublicKey publicKey) {
        return new SignerInformationVerifier(this.sigAlgNameGen, this.sigAlgIDFinder, this.f19065helper.createContentVerifierProvider(publicKey), this.digestProvider);
    }

    public JcaSignerInfoVerifierBuilder setProvider(String str) {
        this.f19065helper = new NamedHelper(str);
        return this;
    }

    public JcaSignerInfoVerifierBuilder setSignatureAlgorithmFinder(SignatureAlgorithmIdentifierFinder signatureAlgorithmIdentifierFinder) {
        this.sigAlgIDFinder = signatureAlgorithmIdentifierFinder;
        return this;
    }

    public JcaSignerInfoVerifierBuilder setSignatureAlgorithmNameGenerator(CMSSignatureAlgorithmNameGenerator cMSSignatureAlgorithmNameGenerator) {
        this.sigAlgNameGen = cMSSignatureAlgorithmNameGenerator;
        return this;
    }

    /* renamed from: build */
    public SignerInformationVerifier m14926build(X509Certificate x509Certificate) {
        return new SignerInformationVerifier(this.sigAlgNameGen, this.sigAlgIDFinder, this.f19065helper.createContentVerifierProvider(x509Certificate), this.digestProvider);
    }

    public JcaSignerInfoVerifierBuilder setProvider(Provider provider) {
        this.f19065helper = new ProviderHelper(provider);
        return this;
    }

    /* renamed from: build */
    public SignerInformationVerifier m14927build(X509CertificateHolder x509CertificateHolder) {
        return new SignerInformationVerifier(this.sigAlgNameGen, this.sigAlgIDFinder, this.f19065helper.createContentVerifierProvider(x509CertificateHolder), this.digestProvider);
    }
}
