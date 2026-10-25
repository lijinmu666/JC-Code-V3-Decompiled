package org.bouncycastle.p191cms.p193jcajce;

import java.security.Provider;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.operator.DefaultSignatureAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.p306jcajce.JcaContentVerifierProviderBuilder;
import org.bouncycastle.operator.p306jcajce.JcaDigestCalculatorProviderBuilder;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p191cms.DefaultCMSSignatureAlgorithmNameGenerator;
import org.bouncycastle.p191cms.SignerInformationVerifier;

/* loaded from: classes2.dex */
public class JcaSimpleSignerInfoVerifierBuilder {

    /* renamed from: helper */
    private C5254Helper f19067helper = new C5254Helper();
    private DigestCalculatorProvider digestCalculatorProvider = null;

    /* renamed from: org.bouncycastle.cms.jcajce.JcaSimpleSignerInfoVerifierBuilder$Helper */
    public static class C5254Helper {
        private C5254Helper() {
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

    public static class NamedHelper extends C5254Helper {
        private final String providerName;

        public NamedHelper(String str) {
            super();
            this.providerName = str;
        }

        @Override // org.bouncycastle.p191cms.p193jcajce.JcaSimpleSignerInfoVerifierBuilder.C5254Helper
        public ContentVerifierProvider createContentVerifierProvider(PublicKey publicKey) {
            return new JcaContentVerifierProviderBuilder().setProvider(this.providerName).m17393build(publicKey);
        }

        @Override // org.bouncycastle.p191cms.p193jcajce.JcaSimpleSignerInfoVerifierBuilder.C5254Helper
        public DigestCalculatorProvider createDigestCalculatorProvider() {
            return new JcaDigestCalculatorProviderBuilder().setProvider(this.providerName).m17397build();
        }

        @Override // org.bouncycastle.p191cms.p193jcajce.JcaSimpleSignerInfoVerifierBuilder.C5254Helper
        public ContentVerifierProvider createContentVerifierProvider(X509Certificate x509Certificate) {
            return new JcaContentVerifierProviderBuilder().setProvider(this.providerName).m17394build(x509Certificate);
        }

        @Override // org.bouncycastle.p191cms.p193jcajce.JcaSimpleSignerInfoVerifierBuilder.C5254Helper
        public ContentVerifierProvider createContentVerifierProvider(X509CertificateHolder x509CertificateHolder) {
            return new JcaContentVerifierProviderBuilder().setProvider(this.providerName).m17396build(x509CertificateHolder);
        }
    }

    public static class ProviderHelper extends C5254Helper {
        private final Provider provider;

        public ProviderHelper(Provider provider) {
            super();
            this.provider = provider;
        }

        @Override // org.bouncycastle.p191cms.p193jcajce.JcaSimpleSignerInfoVerifierBuilder.C5254Helper
        public ContentVerifierProvider createContentVerifierProvider(PublicKey publicKey) {
            return new JcaContentVerifierProviderBuilder().setProvider(this.provider).m17393build(publicKey);
        }

        @Override // org.bouncycastle.p191cms.p193jcajce.JcaSimpleSignerInfoVerifierBuilder.C5254Helper
        public DigestCalculatorProvider createDigestCalculatorProvider() {
            return new JcaDigestCalculatorProviderBuilder().setProvider(this.provider).m17397build();
        }

        @Override // org.bouncycastle.p191cms.p193jcajce.JcaSimpleSignerInfoVerifierBuilder.C5254Helper
        public ContentVerifierProvider createContentVerifierProvider(X509Certificate x509Certificate) {
            return new JcaContentVerifierProviderBuilder().setProvider(this.provider).m17394build(x509Certificate);
        }

        @Override // org.bouncycastle.p191cms.p193jcajce.JcaSimpleSignerInfoVerifierBuilder.C5254Helper
        public ContentVerifierProvider createContentVerifierProvider(X509CertificateHolder x509CertificateHolder) {
            return new JcaContentVerifierProviderBuilder().setProvider(this.provider).m17396build(x509CertificateHolder);
        }
    }

    private DigestCalculatorProvider getDigestCalculatorProvider() {
        DigestCalculatorProvider digestCalculatorProvider = this.digestCalculatorProvider;
        return digestCalculatorProvider != null ? digestCalculatorProvider : this.f19067helper.createDigestCalculatorProvider();
    }

    /* renamed from: build */
    public SignerInformationVerifier m14931build(PublicKey publicKey) {
        return new SignerInformationVerifier(new DefaultCMSSignatureAlgorithmNameGenerator(), new DefaultSignatureAlgorithmIdentifierFinder(), this.f19067helper.createContentVerifierProvider(publicKey), getDigestCalculatorProvider());
    }

    public JcaSimpleSignerInfoVerifierBuilder setDigestCalculatorProvider(DigestCalculatorProvider digestCalculatorProvider) {
        this.digestCalculatorProvider = digestCalculatorProvider;
        return this;
    }

    public JcaSimpleSignerInfoVerifierBuilder setProvider(String str) {
        this.f19067helper = new NamedHelper(str);
        return this;
    }

    /* renamed from: build */
    public SignerInformationVerifier m14932build(X509Certificate x509Certificate) {
        return new SignerInformationVerifier(new DefaultCMSSignatureAlgorithmNameGenerator(), new DefaultSignatureAlgorithmIdentifierFinder(), this.f19067helper.createContentVerifierProvider(x509Certificate), getDigestCalculatorProvider());
    }

    public JcaSimpleSignerInfoVerifierBuilder setProvider(Provider provider) {
        this.f19067helper = new ProviderHelper(provider);
        return this;
    }

    /* renamed from: build */
    public SignerInformationVerifier m14933build(X509CertificateHolder x509CertificateHolder) {
        return new SignerInformationVerifier(new DefaultCMSSignatureAlgorithmNameGenerator(), new DefaultSignatureAlgorithmIdentifierFinder(), this.f19067helper.createContentVerifierProvider(x509CertificateHolder), getDigestCalculatorProvider());
    }
}
