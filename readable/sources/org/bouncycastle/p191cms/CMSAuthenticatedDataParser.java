package org.bouncycastle.p191cms;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1OctetStringParser;
import org.bouncycastle.p133asn1.ASN1SequenceParser;
import org.bouncycastle.p133asn1.ASN1SetParser;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p139cms.AttributeTable;
import org.bouncycastle.p133asn1.p139cms.AuthenticatedDataParser;
import org.bouncycastle.p133asn1.p139cms.CMSAttributes;
import org.bouncycastle.p133asn1.p139cms.ContentInfoParser;
import org.bouncycastle.p133asn1.p139cms.OriginatorInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p191cms.CMSEnvelopedHelper;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class CMSAuthenticatedDataParser extends CMSContentInfoParser {
    private boolean authAttrNotRead;
    private AbstractC5093ASN1Set authAttrSet;
    private AttributeTable authAttrs;
    AuthenticatedDataParser authData;

    /* renamed from: mac */
    private byte[] f18952mac;

    /* renamed from: macAlg */
    private AlgorithmIdentifier f18953macAlg;
    private OriginatorInformation originatorInfo;
    RecipientInformationStore recipientInfoStore;
    private CMSSecureReadable secureReadable;
    private boolean unauthAttrNotRead;
    private AttributeTable unauthAttrs;

    public CMSAuthenticatedDataParser(InputStream inputStream) {
        this(inputStream, (DigestCalculatorProvider) null);
    }

    private AbstractC5093ASN1Set getAuthAttrSet() {
        if (this.authAttrs == null && this.authAttrNotRead) {
            ASN1SetParser authAttrs = this.authData.getAuthAttrs();
            if (authAttrs != null) {
                this.authAttrSet = (AbstractC5093ASN1Set) authAttrs.toASN1Primitive();
            }
            this.authAttrNotRead = false;
            this.secureReadable.setAuthAttrSet(this.authAttrSet);
        }
        return this.authAttrSet;
    }

    public AttributeTable getAuthAttrs() {
        AbstractC5093ASN1Set authAttrSet;
        if (this.authAttrs == null && this.authAttrNotRead && (authAttrSet = getAuthAttrSet()) != null) {
            this.authAttrs = new AttributeTable(authAttrSet);
        }
        return this.authAttrs;
    }

    public byte[] getContentDigest() {
        AttributeTable attributeTable = this.authAttrs;
        if (attributeTable != null) {
            return ASN1OctetString.getInstance(attributeTable.m14530get(CMSAttributes.messageDigest).getAttrValues().getObjectAt(0)).getOctets();
        }
        return null;
    }

    /* renamed from: getMac */
    public byte[] m14854getMac() {
        if (this.f18952mac == null) {
            getAuthAttrs();
            this.f18952mac = this.authData.m14537getMac().getOctets();
        }
        return C6238Arrays.m18231clone(this.f18952mac);
    }

    public String getMacAlgOID() {
        return this.f18953macAlg.getAlgorithm().toString();
    }

    public byte[] getMacAlgParams() {
        try {
            return CMSUtils.encodeObj(this.f18953macAlg.getParameters());
        } catch (Exception e) {
            throw new RuntimeException("exception getting encryption parameters " + e);
        }
    }

    public AlgorithmIdentifier getMacAlgorithm() {
        return this.f18953macAlg;
    }

    public OriginatorInformation getOriginatorInfo() {
        return this.originatorInfo;
    }

    public RecipientInformationStore getRecipientInfos() {
        return this.recipientInfoStore;
    }

    public AttributeTable getUnauthAttrs() {
        if (this.unauthAttrs == null && this.unauthAttrNotRead) {
            this.unauthAttrNotRead = false;
            this.unauthAttrs = CMSUtils.getAttributesTable(this.authData.getUnauthAttrs());
        }
        return this.unauthAttrs;
    }

    public CMSAuthenticatedDataParser(InputStream inputStream, DigestCalculatorProvider digestCalculatorProvider) throws CMSException {
        super(inputStream);
        this.authAttrNotRead = true;
        AuthenticatedDataParser authenticatedDataParser = new AuthenticatedDataParser((ASN1SequenceParser) this._contentInfo.getContent(16));
        this.authData = authenticatedDataParser;
        OriginatorInfo originatorInfo = authenticatedDataParser.getOriginatorInfo();
        if (originatorInfo != null) {
            this.originatorInfo = new OriginatorInformation(originatorInfo);
        }
        AbstractC5093ASN1Set abstractC5093ASN1Set = AbstractC5093ASN1Set.getInstance(this.authData.getRecipientInfos().toASN1Primitive());
        this.f18953macAlg = this.authData.getMacAlgorithm();
        AlgorithmIdentifier digestAlgorithm = this.authData.getDigestAlgorithm();
        if (digestAlgorithm == null) {
            ContentInfoParser encapsulatedContentInfo = this.authData.getEncapsulatedContentInfo();
            CMSEnvelopedHelper.CMSAuthEnveSecureReadable cMSAuthEnveSecureReadable = new CMSEnvelopedHelper.CMSAuthEnveSecureReadable(this.f18953macAlg, encapsulatedContentInfo.getContentType(), new CMSProcessableInputStream(((ASN1OctetStringParser) encapsulatedContentInfo.getContent(4)).getOctetStream()));
            this.secureReadable = cMSAuthEnveSecureReadable;
            this.recipientInfoStore = CMSEnvelopedHelper.buildRecipientInformationStore(abstractC5093ASN1Set, this.f18953macAlg, cMSAuthEnveSecureReadable);
            return;
        }
        if (digestCalculatorProvider == null) {
            throw new CMSException("a digest calculator provider is required if authenticated attributes are present");
        }
        ContentInfoParser encapsulatedContentInfo2 = this.authData.getEncapsulatedContentInfo();
        try {
            CMSEnvelopedHelper.CMSDigestAuthenticatedSecureReadable cMSDigestAuthenticatedSecureReadable = new CMSEnvelopedHelper.CMSDigestAuthenticatedSecureReadable(digestCalculatorProvider.mo14763get(digestAlgorithm), encapsulatedContentInfo2.getContentType(), new CMSProcessableInputStream(((ASN1OctetStringParser) encapsulatedContentInfo2.getContent(4)).getOctetStream()));
            this.secureReadable = cMSDigestAuthenticatedSecureReadable;
            this.recipientInfoStore = CMSEnvelopedHelper.buildRecipientInformationStore(abstractC5093ASN1Set, this.f18953macAlg, cMSDigestAuthenticatedSecureReadable);
        } catch (OperatorCreationException e) {
            throw new CMSException("unable to create digest calculator: " + e.getMessage(), e);
        }
    }

    public CMSAuthenticatedDataParser(byte[] bArr) {
        this(new ByteArrayInputStream(bArr));
    }

    public CMSAuthenticatedDataParser(byte[] bArr, DigestCalculatorProvider digestCalculatorProvider) {
        this(new ByteArrayInputStream(bArr), digestCalculatorProvider);
    }
}
