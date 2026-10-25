package org.bouncycastle.p191cms.p193jcajce;

import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.X509Certificate;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.p306jcajce.JcaContentSignerBuilder;
import org.bouncycastle.operator.p306jcajce.JcaDigestCalculatorProviderBuilder;
import org.bouncycastle.p133asn1.p139cms.AttributeTable;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p177cert.p185jcajce.JcaX509CertificateHolder;
import org.bouncycastle.p191cms.CMSAttributeTableGenerator;
import org.bouncycastle.p191cms.DefaultSignedAttributeTableGenerator;
import org.bouncycastle.p191cms.SignerInfoGenerator;
import org.bouncycastle.p191cms.SignerInfoGeneratorBuilder;

/* loaded from: classes2.dex */
public class JcaSimpleSignerInfoGeneratorBuilder {
    private AlgorithmIdentifier contentDigest;
    private boolean hasNoSignedAttributes;

    /* renamed from: helper */
    private C5252Helper f19066helper = new C5252Helper();
    private CMSAttributeTableGenerator signedGen;
    private CMSAttributeTableGenerator unsignedGen;

    /* renamed from: org.bouncycastle.cms.jcajce.JcaSimpleSignerInfoGeneratorBuilder$Helper */
    public static class C5252Helper {
        private C5252Helper() {
        }

        public ContentSigner createContentSigner(String str, PrivateKey privateKey) {
            return new JcaContentSignerBuilder(str).m17392build(CMSUtils.cleanPrivateKey(privateKey));
        }

        public DigestCalculatorProvider createDigestCalculatorProvider() {
            return new JcaDigestCalculatorProviderBuilder().m17397build();
        }
    }

    public static class NamedHelper extends C5252Helper {
        private final String providerName;

        public NamedHelper(String str) {
            super();
            this.providerName = str;
        }

        @Override // org.bouncycastle.p191cms.p193jcajce.JcaSimpleSignerInfoGeneratorBuilder.C5252Helper
        public ContentSigner createContentSigner(String str, PrivateKey privateKey) {
            return new JcaContentSignerBuilder(str).setProvider(this.providerName).m17392build(CMSUtils.cleanPrivateKey(privateKey));
        }

        @Override // org.bouncycastle.p191cms.p193jcajce.JcaSimpleSignerInfoGeneratorBuilder.C5252Helper
        public DigestCalculatorProvider createDigestCalculatorProvider() {
            return new JcaDigestCalculatorProviderBuilder().setProvider(this.providerName).m17397build();
        }
    }

    public static class ProviderHelper extends C5252Helper {
        private final Provider provider;

        public ProviderHelper(Provider provider) {
            super();
            this.provider = provider;
        }

        @Override // org.bouncycastle.p191cms.p193jcajce.JcaSimpleSignerInfoGeneratorBuilder.C5252Helper
        public ContentSigner createContentSigner(String str, PrivateKey privateKey) {
            return new JcaContentSignerBuilder(str).setProvider(this.provider).m17392build(CMSUtils.cleanPrivateKey(privateKey));
        }

        @Override // org.bouncycastle.p191cms.p193jcajce.JcaSimpleSignerInfoGeneratorBuilder.C5252Helper
        public DigestCalculatorProvider createDigestCalculatorProvider() {
            return new JcaDigestCalculatorProviderBuilder().setProvider(this.provider).m17397build();
        }
    }

    private SignerInfoGeneratorBuilder configureAndBuild() {
        SignerInfoGeneratorBuilder signerInfoGeneratorBuilder = new SignerInfoGeneratorBuilder(this.f19066helper.createDigestCalculatorProvider());
        signerInfoGeneratorBuilder.setDirectSignature(this.hasNoSignedAttributes);
        signerInfoGeneratorBuilder.setContentDigest(this.contentDigest);
        signerInfoGeneratorBuilder.setSignedAttributeGenerator(this.signedGen);
        signerInfoGeneratorBuilder.setUnsignedAttributeGenerator(this.unsignedGen);
        return signerInfoGeneratorBuilder;
    }

    /* renamed from: build */
    public SignerInfoGenerator m14928build(String str, PrivateKey privateKey, X509Certificate x509Certificate) {
        return configureAndBuild().m14899build(this.f19066helper.createContentSigner(str, CMSUtils.cleanPrivateKey(privateKey)), new JcaX509CertificateHolder(x509Certificate));
    }

    public JcaSimpleSignerInfoGeneratorBuilder setContentDigest(AlgorithmIdentifier algorithmIdentifier) {
        this.contentDigest = algorithmIdentifier;
        return this;
    }

    public JcaSimpleSignerInfoGeneratorBuilder setDirectSignature(boolean z) {
        this.hasNoSignedAttributes = z;
        return this;
    }

    public JcaSimpleSignerInfoGeneratorBuilder setProvider(String str) {
        this.f19066helper = new NamedHelper(str);
        return this;
    }

    public JcaSimpleSignerInfoGeneratorBuilder setSignedAttributeGenerator(AttributeTable attributeTable) {
        this.signedGen = new DefaultSignedAttributeTableGenerator(attributeTable);
        return this;
    }

    public JcaSimpleSignerInfoGeneratorBuilder setUnsignedAttributeGenerator(CMSAttributeTableGenerator cMSAttributeTableGenerator) {
        this.unsignedGen = cMSAttributeTableGenerator;
        return this;
    }

    /* renamed from: build */
    public SignerInfoGenerator m14929build(String str, PrivateKey privateKey, X509CertificateHolder x509CertificateHolder) {
        return configureAndBuild().m14899build(this.f19066helper.createContentSigner(str, CMSUtils.cleanPrivateKey(privateKey)), x509CertificateHolder);
    }

    public JcaSimpleSignerInfoGeneratorBuilder setProvider(Provider provider) {
        this.f19066helper = new ProviderHelper(provider);
        return this;
    }

    public JcaSimpleSignerInfoGeneratorBuilder setSignedAttributeGenerator(CMSAttributeTableGenerator cMSAttributeTableGenerator) {
        this.signedGen = cMSAttributeTableGenerator;
        return this;
    }

    /* renamed from: build */
    public SignerInfoGenerator m14930build(String str, PrivateKey privateKey, byte[] bArr) {
        return configureAndBuild().m14900build(this.f19066helper.createContentSigner(str, CMSUtils.cleanPrivateKey(privateKey)), bArr);
    }
}
