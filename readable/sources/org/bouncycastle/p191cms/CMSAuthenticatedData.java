package org.bouncycastle.p191cms;

import java.io.InputStream;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p139cms.Attribute;
import org.bouncycastle.p133asn1.p139cms.AttributeTable;
import org.bouncycastle.p133asn1.p139cms.AuthenticatedData;
import org.bouncycastle.p133asn1.p139cms.CMSAlgorithmProtection;
import org.bouncycastle.p133asn1.p139cms.CMSAttributes;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p191cms.CMSEnvelopedHelper;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Encodable;

/* loaded from: classes2.dex */
public class CMSAuthenticatedData implements Encodable {
    private AbstractC5093ASN1Set authAttrs;
    ContentInfo contentInfo;

    /* renamed from: mac */
    private byte[] f18949mac;

    /* renamed from: macAlg */
    private AlgorithmIdentifier f18950macAlg;
    private OriginatorInformation originatorInfo;
    RecipientInformationStore recipientInfoStore;
    private AbstractC5093ASN1Set unauthAttrs;

    public CMSAuthenticatedData(InputStream inputStream) {
        this(CMSUtils.readContentInfo(inputStream));
    }

    public AttributeTable getAuthAttrs() {
        AbstractC5093ASN1Set abstractC5093ASN1Set = this.authAttrs;
        if (abstractC5093ASN1Set == null) {
            return null;
        }
        return new AttributeTable(abstractC5093ASN1Set);
    }

    public byte[] getContentDigest() {
        if (this.authAttrs != null) {
            return ASN1OctetString.getInstance(getAuthAttrs().m14530get(CMSAttributes.messageDigest).getAttrValues().getObjectAt(0)).getOctets();
        }
        return null;
    }

    public ContentInfo getContentInfo() {
        return this.contentInfo;
    }

    @Override // org.bouncycastle.p361util.Encodable
    public byte[] getEncoded() {
        return this.contentInfo.getEncoded();
    }

    /* renamed from: getMac */
    public byte[] m14853getMac() {
        return C6238Arrays.m18231clone(this.f18949mac);
    }

    public String getMacAlgOID() {
        return this.f18950macAlg.getAlgorithm().m14433getId();
    }

    public byte[] getMacAlgParams() {
        try {
            return CMSUtils.encodeObj(this.f18950macAlg.getParameters());
        } catch (Exception e) {
            throw new RuntimeException("exception getting encryption parameters " + e);
        }
    }

    public AlgorithmIdentifier getMacAlgorithm() {
        return this.f18950macAlg;
    }

    public OriginatorInformation getOriginatorInfo() {
        return this.originatorInfo;
    }

    public RecipientInformationStore getRecipientInfos() {
        return this.recipientInfoStore;
    }

    public AttributeTable getUnauthAttrs() {
        AbstractC5093ASN1Set abstractC5093ASN1Set = this.unauthAttrs;
        if (abstractC5093ASN1Set == null) {
            return null;
        }
        return new AttributeTable(abstractC5093ASN1Set);
    }

    public ContentInfo toASN1Structure() {
        return this.contentInfo;
    }

    public CMSAuthenticatedData(InputStream inputStream, DigestCalculatorProvider digestCalculatorProvider) {
        this(CMSUtils.readContentInfo(inputStream), digestCalculatorProvider);
    }

    public CMSAuthenticatedData(ContentInfo contentInfo) {
        this(contentInfo, (DigestCalculatorProvider) null);
    }

    public CMSAuthenticatedData(ContentInfo contentInfo, DigestCalculatorProvider digestCalculatorProvider) throws CMSException {
        this.contentInfo = contentInfo;
        AuthenticatedData authenticatedData = AuthenticatedData.getInstance(contentInfo.getContent());
        if (authenticatedData.getOriginatorInfo() != null) {
            this.originatorInfo = new OriginatorInformation(authenticatedData.getOriginatorInfo());
        }
        AbstractC5093ASN1Set recipientInfos = authenticatedData.getRecipientInfos();
        this.f18950macAlg = authenticatedData.getMacAlgorithm();
        this.authAttrs = authenticatedData.getAuthAttrs();
        this.f18949mac = authenticatedData.m14536getMac().getOctets();
        this.unauthAttrs = authenticatedData.getUnauthAttrs();
        ContentInfo encapsulatedContentInfo = authenticatedData.getEncapsulatedContentInfo();
        CMSProcessableByteArray cMSProcessableByteArray = new CMSProcessableByteArray(encapsulatedContentInfo.getContentType(), ASN1OctetString.getInstance(encapsulatedContentInfo.getContent()).getOctets());
        AbstractC5093ASN1Set abstractC5093ASN1Set = this.authAttrs;
        if (abstractC5093ASN1Set == null) {
            this.recipientInfoStore = CMSEnvelopedHelper.buildRecipientInformationStore(recipientInfos, this.f18950macAlg, new CMSEnvelopedHelper.CMSAuthEnveSecureReadable(this.f18950macAlg, encapsulatedContentInfo.getContentType(), cMSProcessableByteArray));
            return;
        }
        if (digestCalculatorProvider == null) {
            throw new CMSException("a digest calculator provider is required if authenticated attributes are present");
        }
        ASN1EncodableVector aSN1EncodableVectorM14531getAll = new AttributeTable(abstractC5093ASN1Set).m14531getAll(CMSAttributes.cmsAlgorithmProtect);
        if (aSN1EncodableVectorM14531getAll.m14424size() > 1) {
            throw new CMSException("Only one instance of a cmsAlgorithmProtect attribute can be present");
        }
        if (aSN1EncodableVectorM14531getAll.m14424size() > 0) {
            Attribute attribute = Attribute.getInstance(aSN1EncodableVectorM14531getAll.m14423get(0));
            if (attribute.getAttrValues().m14454size() != 1) {
                throw new CMSException("A cmsAlgorithmProtect attribute MUST contain exactly one value");
            }
            CMSAlgorithmProtection cMSAlgorithmProtection = CMSAlgorithmProtection.getInstance(attribute.getAttributeValues()[0]);
            if (!CMSUtils.isEquivalent(cMSAlgorithmProtection.getDigestAlgorithm(), authenticatedData.getDigestAlgorithm())) {
                throw new CMSException("CMS Algorithm Identifier Protection check failed for digestAlgorithm");
            }
            if (!CMSUtils.isEquivalent(cMSAlgorithmProtection.getMacAlgorithm(), this.f18950macAlg)) {
                throw new CMSException("CMS Algorithm Identifier Protection check failed for macAlgorithm");
            }
        }
        try {
            CMSEnvelopedHelper.CMSDigestAuthenticatedSecureReadable cMSDigestAuthenticatedSecureReadable = new CMSEnvelopedHelper.CMSDigestAuthenticatedSecureReadable(digestCalculatorProvider.mo14763get(authenticatedData.getDigestAlgorithm()), encapsulatedContentInfo.getContentType(), cMSProcessableByteArray);
            cMSDigestAuthenticatedSecureReadable.setAuthAttrSet(this.authAttrs);
            this.recipientInfoStore = CMSEnvelopedHelper.buildRecipientInformationStore(recipientInfos, this.f18950macAlg, cMSDigestAuthenticatedSecureReadable);
        } catch (OperatorCreationException e) {
            throw new CMSException("unable to create digest calculator: " + e.getMessage(), e);
        }
    }

    public CMSAuthenticatedData(byte[] bArr) {
        this(CMSUtils.readContentInfo(bArr));
    }

    public CMSAuthenticatedData(byte[] bArr, DigestCalculatorProvider digestCalculatorProvider) {
        this(CMSUtils.readContentInfo(bArr), digestCalculatorProvider);
    }
}
