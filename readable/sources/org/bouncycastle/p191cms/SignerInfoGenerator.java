package org.bouncycastle.p191cms;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.C5104DERSet;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.p139cms.AttributeTable;
import org.bouncycastle.p133asn1.p139cms.SignerIdentifier;
import org.bouncycastle.p133asn1.p139cms.SignerInfo;
import org.bouncycastle.p133asn1.p144edec.EdECObjectIdentifiers;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.p362io.TeeOutputStream;

/* loaded from: classes2.dex */
public class SignerInfoGenerator {
    private byte[] calculatedDigest;
    private X509CertificateHolder certHolder;
    private final AlgorithmIdentifier digestAlgorithm;
    private final DigestCalculator digester;
    private final CMSAttributeTableGenerator sAttrGen;
    private final CMSSignatureEncryptionAlgorithmFinder sigEncAlgFinder;

    /* renamed from: signer */
    private final ContentSigner f19039signer;
    private final SignerIdentifier signerIdentifier;
    private final CMSAttributeTableGenerator unsAttrGen;

    public SignerInfoGenerator(SignerIdentifier signerIdentifier, ContentSigner contentSigner, AlgorithmIdentifier algorithmIdentifier, CMSSignatureEncryptionAlgorithmFinder cMSSignatureEncryptionAlgorithmFinder) {
        this.calculatedDigest = null;
        this.signerIdentifier = signerIdentifier;
        this.f19039signer = contentSigner;
        this.digestAlgorithm = algorithmIdentifier;
        this.digester = null;
        this.sAttrGen = null;
        this.unsAttrGen = null;
        this.sigEncAlgFinder = cMSSignatureEncryptionAlgorithmFinder;
    }

    private AbstractC5093ASN1Set getAttributeSet(AttributeTable attributeTable) {
        if (attributeTable != null) {
            return new C5104DERSet(attributeTable.toASN1EncodableVector());
        }
        return null;
    }

    private Map getBaseParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, byte[] bArr) {
        HashMap map = new HashMap();
        if (aSN1ObjectIdentifier != null) {
            map.put(CMSAttributeTableGenerator.CONTENT_TYPE, aSN1ObjectIdentifier);
        }
        map.put(CMSAttributeTableGenerator.DIGEST_ALGORITHM_IDENTIFIER, algorithmIdentifier);
        map.put(CMSAttributeTableGenerator.SIGNATURE_ALGORITHM_IDENTIFIER, algorithmIdentifier2);
        map.put(CMSAttributeTableGenerator.f18937DIGEST, C6238Arrays.m18231clone(bArr));
        return map;
    }

    public SignerInfo generate(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        AlgorithmIdentifier algorithmIdentifier;
        AbstractC5093ASN1Set abstractC5093ASN1Set;
        AbstractC5093ASN1Set attributeSet;
        try {
            AlgorithmIdentifier algorithmIdentifierFindEncryptionAlgorithm = this.sigEncAlgFinder.findEncryptionAlgorithm(this.f19039signer.getAlgorithmIdentifier());
            if (this.sAttrGen != null) {
                algorithmIdentifier = this.digester.getAlgorithmIdentifier();
                this.calculatedDigest = this.digester.getDigest();
                AbstractC5093ASN1Set attributeSet2 = getAttributeSet(this.sAttrGen.getAttributes(Collections.unmodifiableMap(getBaseParameters(aSN1ObjectIdentifier, this.digester.getAlgorithmIdentifier(), algorithmIdentifierFindEncryptionAlgorithm, this.calculatedDigest))));
                OutputStream outputStream = this.f19039signer.getOutputStream();
                outputStream.write(attributeSet2.getEncoded(ASN1Encoding.f17902DER));
                outputStream.close();
                abstractC5093ASN1Set = attributeSet2;
            } else {
                algorithmIdentifier = this.digestAlgorithm;
                DigestCalculator digestCalculator = this.digester;
                if (digestCalculator != null) {
                    this.calculatedDigest = digestCalculator.getDigest();
                } else {
                    this.calculatedDigest = null;
                }
                abstractC5093ASN1Set = null;
            }
            byte[] signature = this.f19039signer.getSignature();
            if (this.unsAttrGen != null) {
                Map baseParameters = getBaseParameters(aSN1ObjectIdentifier, algorithmIdentifier, algorithmIdentifierFindEncryptionAlgorithm, this.calculatedDigest);
                baseParameters.put(CMSAttributeTableGenerator.SIGNATURE, C6238Arrays.m18231clone(signature));
                attributeSet = getAttributeSet(this.unsAttrGen.getAttributes(Collections.unmodifiableMap(baseParameters)));
            } else {
                attributeSet = null;
            }
            return new SignerInfo(this.signerIdentifier, (this.sAttrGen == null && EdECObjectIdentifiers.id_Ed448.m14446equals((ASN1Primitive) algorithmIdentifierFindEncryptionAlgorithm.getAlgorithm())) ? new AlgorithmIdentifier(NISTObjectIdentifiers.id_shake256) : algorithmIdentifier, abstractC5093ASN1Set, algorithmIdentifierFindEncryptionAlgorithm, new DEROctetString(signature), attributeSet);
        } catch (IOException e) {
            throw new CMSException("encoding error.", e);
        }
    }

    public X509CertificateHolder getAssociatedCertificate() {
        return this.certHolder;
    }

    public byte[] getCalculatedDigest() {
        byte[] bArr = this.calculatedDigest;
        if (bArr != null) {
            return C6238Arrays.m18231clone(bArr);
        }
        return null;
    }

    public OutputStream getCalculatingOutputStream() {
        DigestCalculator digestCalculator = this.digester;
        return digestCalculator != null ? this.sAttrGen == null ? new TeeOutputStream(this.digester.getOutputStream(), this.f19039signer.getOutputStream()) : digestCalculator.getOutputStream() : this.f19039signer.getOutputStream();
    }

    public AlgorithmIdentifier getDigestAlgorithm() {
        return this.digestAlgorithm;
    }

    public int getGeneratedVersion() {
        return this.signerIdentifier.isTagged() ? 3 : 1;
    }

    /* renamed from: getSID */
    public SignerIdentifier m14898getSID() {
        return this.signerIdentifier;
    }

    public CMSAttributeTableGenerator getSignedAttributeTableGenerator() {
        return this.sAttrGen;
    }

    public CMSAttributeTableGenerator getUnsignedAttributeTableGenerator() {
        return this.unsAttrGen;
    }

    public boolean hasAssociatedCertificate() {
        return this.certHolder != null;
    }

    public void setAssociatedCertificate(X509CertificateHolder x509CertificateHolder) {
        this.certHolder = x509CertificateHolder;
    }

    public SignerInfoGenerator(SignerIdentifier signerIdentifier, ContentSigner contentSigner, DigestCalculator digestCalculator, CMSSignatureEncryptionAlgorithmFinder cMSSignatureEncryptionAlgorithmFinder, CMSAttributeTableGenerator cMSAttributeTableGenerator, CMSAttributeTableGenerator cMSAttributeTableGenerator2) {
        this.calculatedDigest = null;
        this.signerIdentifier = signerIdentifier;
        this.f19039signer = contentSigner;
        this.digestAlgorithm = digestCalculator.getAlgorithmIdentifier();
        this.digester = digestCalculator;
        this.sAttrGen = cMSAttributeTableGenerator;
        this.unsAttrGen = cMSAttributeTableGenerator2;
        this.sigEncAlgFinder = cMSSignatureEncryptionAlgorithmFinder;
    }

    public SignerInfoGenerator(SignerInfoGenerator signerInfoGenerator, CMSAttributeTableGenerator cMSAttributeTableGenerator, CMSAttributeTableGenerator cMSAttributeTableGenerator2) {
        this.calculatedDigest = null;
        this.signerIdentifier = signerInfoGenerator.signerIdentifier;
        this.f19039signer = signerInfoGenerator.f19039signer;
        this.digestAlgorithm = signerInfoGenerator.digestAlgorithm;
        this.digester = signerInfoGenerator.digester;
        this.sigEncAlgFinder = signerInfoGenerator.sigEncAlgFinder;
        this.certHolder = signerInfoGenerator.certHolder;
        this.sAttrGen = cMSAttributeTableGenerator;
        this.unsAttrGen = cMSAttributeTableGenerator2;
    }
}
