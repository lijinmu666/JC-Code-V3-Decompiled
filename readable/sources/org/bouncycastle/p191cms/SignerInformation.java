package org.bouncycastle.p191cms;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.RawContentVerifier;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.C5104DERSet;
import org.bouncycastle.p133asn1.p139cms.Attribute;
import org.bouncycastle.p133asn1.p139cms.AttributeTable;
import org.bouncycastle.p133asn1.p139cms.C5115Time;
import org.bouncycastle.p133asn1.p139cms.CMSAlgorithmProtection;
import org.bouncycastle.p133asn1.p139cms.CMSAttributes;
import org.bouncycastle.p133asn1.p139cms.IssuerAndSerialNumber;
import org.bouncycastle.p133asn1.p139cms.SignerIdentifier;
import org.bouncycastle.p133asn1.p139cms.SignerInfo;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.DigestInfo;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.p362io.TeeOutputStream;

/* loaded from: classes2.dex */
public class SignerInformation {

    /* renamed from: content */
    private final CMSProcessable f19040content;
    private final ASN1ObjectIdentifier contentType;
    protected final AlgorithmIdentifier digestAlgorithm;
    protected final AlgorithmIdentifier encryptionAlgorithm;

    /* renamed from: info */
    protected final SignerInfo f19041info;
    private final boolean isCounterSignature;
    private byte[] resultDigest;

    /* renamed from: sid */
    private final SignerId f19042sid;
    private final byte[] signature;
    protected final AbstractC5093ASN1Set signedAttributeSet;
    private AttributeTable signedAttributeValues;
    protected final AbstractC5093ASN1Set unsignedAttributeSet;
    private AttributeTable unsignedAttributeValues;

    public SignerInformation(SignerInfo signerInfo, ASN1ObjectIdentifier aSN1ObjectIdentifier, CMSProcessable cMSProcessable, byte[] bArr) {
        SignerId signerId;
        this.f19041info = signerInfo;
        this.contentType = aSN1ObjectIdentifier;
        this.isCounterSignature = aSN1ObjectIdentifier == null;
        SignerIdentifier signerIdentifierM14556getSID = signerInfo.m14556getSID();
        boolean zIsTagged = signerIdentifierM14556getSID.isTagged();
        ASN1Encodable aSN1EncodableM14555getId = signerIdentifierM14556getSID.m14555getId();
        if (zIsTagged) {
            signerId = new SignerId(ASN1OctetString.getInstance(aSN1EncodableM14555getId).getOctets());
        } else {
            IssuerAndSerialNumber issuerAndSerialNumber = IssuerAndSerialNumber.getInstance(aSN1EncodableM14555getId);
            signerId = new SignerId(issuerAndSerialNumber.m14540getName(), issuerAndSerialNumber.getSerialNumber().getValue());
        }
        this.f19042sid = signerId;
        this.digestAlgorithm = signerInfo.getDigestAlgorithm();
        this.signedAttributeSet = signerInfo.getAuthenticatedAttributes();
        this.unsignedAttributeSet = signerInfo.getUnauthenticatedAttributes();
        this.encryptionAlgorithm = signerInfo.getDigestEncryptionAlgorithm();
        this.signature = signerInfo.getEncryptedDigest().getOctets();
        this.f19040content = cMSProcessable;
        this.resultDigest = bArr;
    }

    public static SignerInformation addCounterSigners(SignerInformation signerInformation, SignerInformationStore signerInformationStore) {
        SignerInfo signerInfo = signerInformation.f19041info;
        AttributeTable unsignedAttributes = signerInformation.getUnsignedAttributes();
        ASN1EncodableVector aSN1EncodableVector = unsignedAttributes != null ? unsignedAttributes.toASN1EncodableVector() : new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        Iterator<SignerInformation> it = signerInformationStore.getSigners().iterator();
        while (it.hasNext()) {
            aSN1EncodableVector2.m14420add(it.next().toASN1Structure());
        }
        aSN1EncodableVector.m14420add(new Attribute(CMSAttributes.counterSignature, new C5104DERSet(aSN1EncodableVector2)));
        return new SignerInformation(new SignerInfo(signerInfo.m14556getSID(), signerInfo.getDigestAlgorithm(), signerInfo.getAuthenticatedAttributes(), signerInfo.getDigestEncryptionAlgorithm(), signerInfo.getEncryptedDigest(), new C5104DERSet(aSN1EncodableVector)), signerInformation.contentType, signerInformation.f19040content, null);
    }

    private boolean doVerify(SignerInformationVerifier signerInformationVerifier) throws CMSException, IOException {
        String encryptionAlgName = CMSSignedHelper.INSTANCE.getEncryptionAlgName(getEncryptionAlgOID());
        AlgorithmIdentifier digestAlgorithm = this.signedAttributeSet != null ? this.f19041info.getDigestAlgorithm() : translateBrokenRSAPkcs7(this.encryptionAlgorithm, this.f19041info.getDigestAlgorithm());
        try {
            ContentVerifier contentVerifier = signerInformationVerifier.getContentVerifier(this.encryptionAlgorithm, digestAlgorithm);
            try {
                OutputStream outputStream = contentVerifier.getOutputStream();
                if (this.resultDigest == null) {
                    DigestCalculator digestCalculator = signerInformationVerifier.getDigestCalculator(digestAlgorithm);
                    if (this.f19040content != null) {
                        OutputStream outputStream2 = digestCalculator.getOutputStream();
                        if (this.signedAttributeSet != null) {
                            this.f19040content.mo14759write(outputStream2);
                            outputStream.write(getEncodedSignedAttributes());
                        } else if (contentVerifier instanceof RawContentVerifier) {
                            this.f19040content.mo14759write(outputStream2);
                        } else {
                            TeeOutputStream teeOutputStream = new TeeOutputStream(outputStream2, outputStream);
                            this.f19040content.mo14759write(teeOutputStream);
                            teeOutputStream.close();
                        }
                        outputStream2.close();
                    } else {
                        if (this.signedAttributeSet == null) {
                            throw new CMSException("data not encapsulated in signature - use detached constructor.");
                        }
                        outputStream.write(getEncodedSignedAttributes());
                    }
                    this.resultDigest = digestCalculator.getDigest();
                } else if (this.signedAttributeSet == null) {
                    CMSProcessable cMSProcessable = this.f19040content;
                    if (cMSProcessable != null) {
                        cMSProcessable.mo14759write(outputStream);
                    }
                } else {
                    outputStream.write(getEncodedSignedAttributes());
                }
                outputStream.close();
                verifyContentTypeAttributeValue();
                AttributeTable signedAttributes = getSignedAttributes();
                verifyAlgorithmIdentifierProtectionAttribute(signedAttributes);
                verifyMessageDigestAttribute();
                verifyCounterSignatureAttribute(signedAttributes);
                try {
                    if (this.signedAttributeSet != null || this.resultDigest == null || !(contentVerifier instanceof RawContentVerifier)) {
                        return contentVerifier.mo16015verify(getSignature());
                    }
                    RawContentVerifier rawContentVerifier = (RawContentVerifier) contentVerifier;
                    return encryptionAlgName.equals("RSA") ? rawContentVerifier.mo17387verify(new DigestInfo(new AlgorithmIdentifier(digestAlgorithm.getAlgorithm(), C5103DERNull.INSTANCE), this.resultDigest).getEncoded(ASN1Encoding.f17902DER), getSignature()) : rawContentVerifier.mo17387verify(this.resultDigest, getSignature());
                } catch (IOException e) {
                    throw new CMSException("can't process mime object to create signature.", e);
                }
            } catch (IOException e2) {
                throw new CMSException("can't process mime object to create signature.", e2);
            } catch (OperatorCreationException e3) {
                throw new CMSException("can't create digest calculator: " + e3.getMessage(), e3);
            }
        } catch (OperatorCreationException e4) {
            throw new CMSException("can't create content verifier: " + e4.getMessage(), e4);
        }
    }

    private C5115Time getSigningTime() throws CMSException {
        ASN1Primitive singleValuedSignedAttribute = getSingleValuedSignedAttribute(CMSAttributes.signingTime, "signing-time");
        if (singleValuedSignedAttribute == null) {
            return null;
        }
        try {
            return C5115Time.getInstance(singleValuedSignedAttribute);
        } catch (IllegalArgumentException unused) {
            throw new CMSException("signing-time attribute value not a valid 'Time' structure");
        }
    }

    private ASN1Primitive getSingleValuedSignedAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) throws CMSException {
        ASN1EncodableVector aSN1EncodableVectorM14531getAll;
        int iM14424size;
        AttributeTable unsignedAttributes = getUnsignedAttributes();
        if (unsignedAttributes != null && unsignedAttributes.m14531getAll(aSN1ObjectIdentifier).m14424size() > 0) {
            throw new CMSException("The " + str + " attribute MUST NOT be an unsigned attribute");
        }
        AttributeTable signedAttributes = getSignedAttributes();
        if (signedAttributes == null || (iM14424size = (aSN1EncodableVectorM14531getAll = signedAttributes.m14531getAll(aSN1ObjectIdentifier)).m14424size()) == 0) {
            return null;
        }
        if (iM14424size != 1) {
            throw new CMSException("The SignedAttributes in a signerInfo MUST NOT include multiple instances of the " + str + " attribute");
        }
        AbstractC5093ASN1Set attrValues = ((Attribute) aSN1EncodableVectorM14531getAll.m14423get(0)).getAttrValues();
        if (attrValues.m14454size() == 1) {
            return attrValues.getObjectAt(0).toASN1Primitive();
        }
        throw new CMSException("A " + str + " attribute MUST have a single attribute value");
    }

    public static SignerInformation replaceUnsignedAttributes(SignerInformation signerInformation, AttributeTable attributeTable) {
        SignerInfo signerInfo = signerInformation.f19041info;
        return new SignerInformation(new SignerInfo(signerInfo.m14556getSID(), signerInfo.getDigestAlgorithm(), signerInfo.getAuthenticatedAttributes(), signerInfo.getDigestEncryptionAlgorithm(), signerInfo.getEncryptedDigest(), attributeTable != null ? new C5104DERSet(attributeTable.toASN1EncodableVector()) : null), signerInformation.contentType, signerInformation.f19040content, null);
    }

    private static AlgorithmIdentifier translateBrokenRSAPkcs7(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2) {
        return (PKCSObjectIdentifiers.rsaEncryption.m14446equals((ASN1Primitive) algorithmIdentifier.getAlgorithm()) && (OIWObjectIdentifiers.sha1WithRSA.m14446equals((ASN1Primitive) algorithmIdentifier2.getAlgorithm()) || PKCSObjectIdentifiers.sha1WithRSAEncryption.m14446equals((ASN1Primitive) algorithmIdentifier2.getAlgorithm()))) ? new AlgorithmIdentifier(OIWObjectIdentifiers.f18459idSHA1, C5103DERNull.INSTANCE) : algorithmIdentifier2;
    }

    private void verifyAlgorithmIdentifierProtectionAttribute(AttributeTable attributeTable) throws CMSException {
        AttributeTable unsignedAttributes = getUnsignedAttributes();
        if (unsignedAttributes != null && unsignedAttributes.m14531getAll(CMSAttributes.cmsAlgorithmProtect).m14424size() > 0) {
            throw new CMSException("A cmsAlgorithmProtect attribute MUST be a signed attribute");
        }
        if (attributeTable != null) {
            ASN1EncodableVector aSN1EncodableVectorM14531getAll = attributeTable.m14531getAll(CMSAttributes.cmsAlgorithmProtect);
            if (aSN1EncodableVectorM14531getAll.m14424size() > 1) {
                throw new CMSException("Only one instance of a cmsAlgorithmProtect attribute can be present");
            }
            if (aSN1EncodableVectorM14531getAll.m14424size() > 0) {
                Attribute attribute = Attribute.getInstance(aSN1EncodableVectorM14531getAll.m14423get(0));
                if (attribute.getAttrValues().m14454size() != 1) {
                    throw new CMSException("A cmsAlgorithmProtect attribute MUST contain exactly one value");
                }
                CMSAlgorithmProtection cMSAlgorithmProtection = CMSAlgorithmProtection.getInstance(attribute.getAttributeValues()[0]);
                if (!CMSUtils.isEquivalent(cMSAlgorithmProtection.getDigestAlgorithm(), this.f19041info.getDigestAlgorithm())) {
                    throw new CMSException("CMS Algorithm Identifier Protection check failed for digestAlgorithm");
                }
                if (!CMSUtils.isEquivalent(cMSAlgorithmProtection.getSignatureAlgorithm(), this.f19041info.getDigestEncryptionAlgorithm())) {
                    throw new CMSException("CMS Algorithm Identifier Protection check failed for signatureAlgorithm");
                }
            }
        }
    }

    private void verifyContentTypeAttributeValue() throws CMSException {
        ASN1Primitive singleValuedSignedAttribute = getSingleValuedSignedAttribute(CMSAttributes.contentType, "content-type");
        if (singleValuedSignedAttribute == null) {
            if (!this.isCounterSignature && this.signedAttributeSet != null) {
                throw new CMSException("The content-type attribute type MUST be present whenever signed attributes are present in signed-data");
            }
        } else {
            if (this.isCounterSignature) {
                throw new CMSException("[For counter signatures,] the signedAttributes field MUST NOT contain a content-type attribute");
            }
            if (!(singleValuedSignedAttribute instanceof ASN1ObjectIdentifier)) {
                throw new CMSException("content-type attribute value not of ASN.1 type 'OBJECT IDENTIFIER'");
            }
            if (!((ASN1ObjectIdentifier) singleValuedSignedAttribute).m14446equals((ASN1Primitive) this.contentType)) {
                throw new CMSException("content-type attribute value does not match eContentType");
            }
        }
    }

    private void verifyCounterSignatureAttribute(AttributeTable attributeTable) throws CMSException {
        if (attributeTable != null && attributeTable.m14531getAll(CMSAttributes.counterSignature).m14424size() > 0) {
            throw new CMSException("A countersignature attribute MUST NOT be a signed attribute");
        }
        AttributeTable unsignedAttributes = getUnsignedAttributes();
        if (unsignedAttributes != null) {
            ASN1EncodableVector aSN1EncodableVectorM14531getAll = unsignedAttributes.m14531getAll(CMSAttributes.counterSignature);
            for (int i = 0; i < aSN1EncodableVectorM14531getAll.m14424size(); i++) {
                if (Attribute.getInstance(aSN1EncodableVectorM14531getAll.m14423get(i)).getAttrValues().m14454size() < 1) {
                    throw new CMSException("A countersignature attribute MUST contain at least one AttributeValue");
                }
            }
        }
    }

    private void verifyMessageDigestAttribute() throws CMSException {
        ASN1Primitive singleValuedSignedAttribute = getSingleValuedSignedAttribute(CMSAttributes.messageDigest, "message-digest");
        if (singleValuedSignedAttribute == null) {
            if (this.signedAttributeSet != null) {
                throw new CMSException("the message-digest signed attribute type MUST be present when there are any signed attributes present");
            }
        } else {
            if (!(singleValuedSignedAttribute instanceof ASN1OctetString)) {
                throw new CMSException("message-digest attribute value not of ASN.1 type 'OCTET STRING'");
            }
            if (!C6238Arrays.constantTimeAreEqual(this.resultDigest, ((ASN1OctetString) singleValuedSignedAttribute).getOctets())) {
                throw new CMSSignerDigestMismatchException("message-digest attribute value does not match calculated value");
            }
        }
    }

    public byte[] getContentDigest() {
        byte[] bArr = this.resultDigest;
        if (bArr != null) {
            return C6238Arrays.m18231clone(bArr);
        }
        throw new IllegalStateException("method can only be called after verify.");
    }

    public ASN1ObjectIdentifier getContentType() {
        return this.contentType;
    }

    public SignerInformationStore getCounterSignatures() {
        AttributeTable unsignedAttributes = getUnsignedAttributes();
        if (unsignedAttributes == null) {
            return new SignerInformationStore(new ArrayList(0));
        }
        ArrayList arrayList = new ArrayList();
        ASN1EncodableVector aSN1EncodableVectorM14531getAll = unsignedAttributes.m14531getAll(CMSAttributes.counterSignature);
        for (int i = 0; i < aSN1EncodableVectorM14531getAll.m14424size(); i++) {
            AbstractC5093ASN1Set attrValues = ((Attribute) aSN1EncodableVectorM14531getAll.m14423get(i)).getAttrValues();
            attrValues.m14454size();
            Enumeration objects = attrValues.getObjects();
            while (objects.hasMoreElements()) {
                arrayList.add(new SignerInformation(SignerInfo.getInstance(objects.nextElement()), null, new CMSProcessableByteArray(getSignature()), null));
            }
        }
        return new SignerInformationStore(arrayList);
    }

    public String getDigestAlgOID() {
        return this.digestAlgorithm.getAlgorithm().m14433getId();
    }

    public byte[] getDigestAlgParams() {
        try {
            return CMSUtils.encodeObj(this.digestAlgorithm.getParameters());
        } catch (Exception e) {
            throw new RuntimeException("exception getting digest parameters " + e);
        }
    }

    public AlgorithmIdentifier getDigestAlgorithmID() {
        return this.digestAlgorithm;
    }

    public byte[] getEncodedSignedAttributes() {
        AbstractC5093ASN1Set abstractC5093ASN1Set = this.signedAttributeSet;
        if (abstractC5093ASN1Set != null) {
            return abstractC5093ASN1Set.getEncoded(ASN1Encoding.f17902DER);
        }
        return null;
    }

    public String getEncryptionAlgOID() {
        return this.encryptionAlgorithm.getAlgorithm().m14433getId();
    }

    public byte[] getEncryptionAlgParams() {
        try {
            return CMSUtils.encodeObj(this.encryptionAlgorithm.getParameters());
        } catch (Exception e) {
            throw new RuntimeException("exception getting encryption parameters " + e);
        }
    }

    /* renamed from: getSID */
    public SignerId m14901getSID() {
        return this.f19042sid;
    }

    public byte[] getSignature() {
        return C6238Arrays.m18231clone(this.signature);
    }

    public AttributeTable getSignedAttributes() {
        AbstractC5093ASN1Set abstractC5093ASN1Set = this.signedAttributeSet;
        if (abstractC5093ASN1Set != null && this.signedAttributeValues == null) {
            this.signedAttributeValues = new AttributeTable(abstractC5093ASN1Set);
        }
        return this.signedAttributeValues;
    }

    public AttributeTable getUnsignedAttributes() {
        AbstractC5093ASN1Set abstractC5093ASN1Set = this.unsignedAttributeSet;
        if (abstractC5093ASN1Set != null && this.unsignedAttributeValues == null) {
            this.unsignedAttributeValues = new AttributeTable(abstractC5093ASN1Set);
        }
        return this.unsignedAttributeValues;
    }

    public int getVersion() {
        return this.f19041info.getVersion().intValueExact();
    }

    public boolean isCounterSignature() {
        return this.isCounterSignature;
    }

    public SignerInfo toASN1Structure() {
        return this.f19041info;
    }

    /* renamed from: verify */
    public boolean m14902verify(SignerInformationVerifier signerInformationVerifier) throws CMSException {
        C5115Time signingTime = getSigningTime();
        if (!signerInformationVerifier.hasAssociatedCertificate() || signingTime == null || signerInformationVerifier.getAssociatedCertificate().isValidOn(signingTime.m14557getDate())) {
            return doVerify(signerInformationVerifier);
        }
        throw new CMSVerifierCertificateNotValidException("verifier not valid at signingTime");
    }

    public SignerInformation(SignerInformation signerInformation) {
        this(signerInformation, signerInformation.f19041info);
    }

    public SignerInformation(SignerInformation signerInformation, SignerInfo signerInfo) {
        this.f19041info = signerInfo;
        this.contentType = signerInformation.contentType;
        this.isCounterSignature = signerInformation.isCounterSignature();
        this.f19042sid = signerInformation.m14901getSID();
        this.digestAlgorithm = signerInfo.getDigestAlgorithm();
        this.signedAttributeSet = signerInfo.getAuthenticatedAttributes();
        this.unsignedAttributeSet = signerInfo.getUnauthenticatedAttributes();
        this.encryptionAlgorithm = signerInfo.getDigestEncryptionAlgorithm();
        this.signature = signerInfo.getEncryptedDigest().getOctets();
        this.f19040content = signerInformation.f19040content;
        this.resultDigest = signerInformation.resultDigest;
        this.signedAttributeValues = getSignedAttributes();
        this.unsignedAttributeValues = getUnsignedAttributes();
    }
}
