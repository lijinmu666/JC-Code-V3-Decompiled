package org.bouncycastle.p191cms;

import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.ExtendedContentSigner;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.p139cms.IssuerAndSerialNumber;
import org.bouncycastle.p133asn1.p139cms.SignerIdentifier;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p177cert.X509CertificateHolder;

/* loaded from: classes2.dex */
public class SignerInfoGeneratorBuilder {
    private AlgorithmIdentifier contentDigest;
    private final DigestAlgorithmIdentifierFinder digAlgFinder;
    private DigestCalculatorProvider digestProvider;
    private boolean directSignature;
    private CMSSignatureEncryptionAlgorithmFinder sigEncAlgFinder;
    private CMSAttributeTableGenerator signedGen;
    private CMSAttributeTableGenerator unsignedGen;

    public SignerInfoGeneratorBuilder(DigestCalculatorProvider digestCalculatorProvider) {
        this(digestCalculatorProvider, new DefaultCMSSignatureEncryptionAlgorithmFinder());
    }

    private SignerInfoGenerator createGenerator(ContentSigner contentSigner, SignerIdentifier signerIdentifier) throws OperatorCreationException {
        AlgorithmIdentifier digestAlgorithmIdentifier = this.contentDigest;
        if (digestAlgorithmIdentifier == null) {
            digestAlgorithmIdentifier = contentSigner instanceof ExtendedContentSigner ? ((ExtendedContentSigner) contentSigner).getDigestAlgorithmIdentifier() : null;
            if (digestAlgorithmIdentifier == null) {
                digestAlgorithmIdentifier = this.digAlgFinder.mo17382find(contentSigner.getAlgorithmIdentifier());
            }
            if (digestAlgorithmIdentifier == null) {
                throw new OperatorCreationException("no digest algorithm specified for signature algorithm");
            }
        }
        DigestCalculator digestCalculatorMo14763get = this.digestProvider.mo14763get(digestAlgorithmIdentifier);
        if (this.directSignature) {
            return new SignerInfoGenerator(signerIdentifier, contentSigner, digestCalculatorMo14763get.getAlgorithmIdentifier(), this.sigEncAlgFinder);
        }
        CMSAttributeTableGenerator cMSAttributeTableGenerator = this.signedGen;
        if (cMSAttributeTableGenerator == null && this.unsignedGen == null) {
            return new SignerInfoGenerator(signerIdentifier, contentSigner, digestCalculatorMo14763get, this.sigEncAlgFinder, new DefaultSignedAttributeTableGenerator(), null);
        }
        if (cMSAttributeTableGenerator == null) {
            this.signedGen = new DefaultSignedAttributeTableGenerator();
        }
        return new SignerInfoGenerator(signerIdentifier, contentSigner, digestCalculatorMo14763get, this.sigEncAlgFinder, this.signedGen, this.unsignedGen);
    }

    /* renamed from: build */
    public SignerInfoGenerator m14899build(ContentSigner contentSigner, X509CertificateHolder x509CertificateHolder) throws OperatorCreationException {
        SignerInfoGenerator signerInfoGeneratorCreateGenerator = createGenerator(contentSigner, new SignerIdentifier(new IssuerAndSerialNumber(x509CertificateHolder.toASN1Structure())));
        signerInfoGeneratorCreateGenerator.setAssociatedCertificate(x509CertificateHolder);
        return signerInfoGeneratorCreateGenerator;
    }

    public SignerInfoGeneratorBuilder setContentDigest(AlgorithmIdentifier algorithmIdentifier) {
        this.contentDigest = algorithmIdentifier;
        return this;
    }

    public SignerInfoGeneratorBuilder setDirectSignature(boolean z) {
        this.directSignature = z;
        return this;
    }

    public SignerInfoGeneratorBuilder setSignedAttributeGenerator(CMSAttributeTableGenerator cMSAttributeTableGenerator) {
        this.signedGen = cMSAttributeTableGenerator;
        return this;
    }

    public SignerInfoGeneratorBuilder setUnsignedAttributeGenerator(CMSAttributeTableGenerator cMSAttributeTableGenerator) {
        this.unsignedGen = cMSAttributeTableGenerator;
        return this;
    }

    public SignerInfoGeneratorBuilder(DigestCalculatorProvider digestCalculatorProvider, CMSSignatureEncryptionAlgorithmFinder cMSSignatureEncryptionAlgorithmFinder) {
        this.digAlgFinder = new DefaultDigestAlgorithmIdentifierFinder();
        this.digestProvider = digestCalculatorProvider;
        this.sigEncAlgFinder = cMSSignatureEncryptionAlgorithmFinder;
    }

    /* renamed from: build */
    public SignerInfoGenerator m14900build(ContentSigner contentSigner, byte[] bArr) {
        return createGenerator(contentSigner, new SignerIdentifier((ASN1OctetString) new DEROctetString(bArr)));
    }
}
