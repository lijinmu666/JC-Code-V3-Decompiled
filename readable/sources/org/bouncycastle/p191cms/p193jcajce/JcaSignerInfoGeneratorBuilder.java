package org.bouncycastle.p191cms.p193jcajce;

import java.security.cert.X509Certificate;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p177cert.p185jcajce.JcaX509CertificateHolder;
import org.bouncycastle.p191cms.CMSAttributeTableGenerator;
import org.bouncycastle.p191cms.CMSSignatureEncryptionAlgorithmFinder;
import org.bouncycastle.p191cms.DefaultCMSSignatureEncryptionAlgorithmFinder;
import org.bouncycastle.p191cms.SignerInfoGenerator;
import org.bouncycastle.p191cms.SignerInfoGeneratorBuilder;

/* loaded from: classes2.dex */
public class JcaSignerInfoGeneratorBuilder {

    /* renamed from: builder */
    private SignerInfoGeneratorBuilder f19064builder;

    public JcaSignerInfoGeneratorBuilder(DigestCalculatorProvider digestCalculatorProvider) {
        this(digestCalculatorProvider, new DefaultCMSSignatureEncryptionAlgorithmFinder());
    }

    /* renamed from: build */
    public SignerInfoGenerator m14922build(ContentSigner contentSigner, X509Certificate x509Certificate) {
        return m14923build(contentSigner, new JcaX509CertificateHolder(x509Certificate));
    }

    public JcaSignerInfoGeneratorBuilder setContentDigest(AlgorithmIdentifier algorithmIdentifier) {
        this.f19064builder.setContentDigest(algorithmIdentifier);
        return this;
    }

    public JcaSignerInfoGeneratorBuilder setDirectSignature(boolean z) {
        this.f19064builder.setDirectSignature(z);
        return this;
    }

    public JcaSignerInfoGeneratorBuilder setSignedAttributeGenerator(CMSAttributeTableGenerator cMSAttributeTableGenerator) {
        this.f19064builder.setSignedAttributeGenerator(cMSAttributeTableGenerator);
        return this;
    }

    public JcaSignerInfoGeneratorBuilder setUnsignedAttributeGenerator(CMSAttributeTableGenerator cMSAttributeTableGenerator) {
        this.f19064builder.setUnsignedAttributeGenerator(cMSAttributeTableGenerator);
        return this;
    }

    public JcaSignerInfoGeneratorBuilder(DigestCalculatorProvider digestCalculatorProvider, CMSSignatureEncryptionAlgorithmFinder cMSSignatureEncryptionAlgorithmFinder) {
        this.f19064builder = new SignerInfoGeneratorBuilder(digestCalculatorProvider, cMSSignatureEncryptionAlgorithmFinder);
    }

    /* renamed from: build */
    public SignerInfoGenerator m14923build(ContentSigner contentSigner, X509CertificateHolder x509CertificateHolder) {
        return this.f19064builder.m14899build(contentSigner, x509CertificateHolder);
    }

    /* renamed from: build */
    public SignerInfoGenerator m14924build(ContentSigner contentSigner, byte[] bArr) {
        return this.f19064builder.m14900build(contentSigner, bArr);
    }
}
