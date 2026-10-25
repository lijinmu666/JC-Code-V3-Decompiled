package org.bouncycastle.p191cms;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.bouncycastle.p133asn1.ASN1OctetStringParser;
import org.bouncycastle.p133asn1.ASN1SequenceParser;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p139cms.AttributeTable;
import org.bouncycastle.p133asn1.p139cms.EncryptedContentInfoParser;
import org.bouncycastle.p133asn1.p139cms.EnvelopedDataParser;
import org.bouncycastle.p133asn1.p139cms.OriginatorInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p191cms.CMSEnvelopedHelper;

/* loaded from: classes2.dex */
public class CMSEnvelopedDataParser extends CMSContentInfoParser {
    private boolean attrNotRead;

    /* renamed from: encAlg */
    private AlgorithmIdentifier f18968encAlg;
    EnvelopedDataParser envelopedData;
    private OriginatorInformation originatorInfo;
    RecipientInformationStore recipientInfoStore;
    private AttributeTable unprotectedAttributes;

    public CMSEnvelopedDataParser(InputStream inputStream) {
        super(inputStream);
        this.attrNotRead = true;
        EnvelopedDataParser envelopedDataParser = new EnvelopedDataParser((ASN1SequenceParser) this._contentInfo.getContent(16));
        this.envelopedData = envelopedDataParser;
        OriginatorInfo originatorInfo = envelopedDataParser.getOriginatorInfo();
        if (originatorInfo != null) {
            this.originatorInfo = new OriginatorInformation(originatorInfo);
        }
        AbstractC5093ASN1Set abstractC5093ASN1Set = AbstractC5093ASN1Set.getInstance(this.envelopedData.getRecipientInfos().toASN1Primitive());
        EncryptedContentInfoParser encryptedContentInfo = this.envelopedData.getEncryptedContentInfo();
        this.f18968encAlg = encryptedContentInfo.getContentEncryptionAlgorithm();
        this.recipientInfoStore = CMSEnvelopedHelper.buildRecipientInformationStore(abstractC5093ASN1Set, this.f18968encAlg, new CMSEnvelopedHelper.CMSAuthEnveSecureReadable(this.f18968encAlg, encryptedContentInfo.getContentType(), new CMSProcessableInputStream(((ASN1OctetStringParser) encryptedContentInfo.getEncryptedContent(4)).getOctetStream())));
    }

    public AlgorithmIdentifier getContentEncryptionAlgorithm() {
        return this.f18968encAlg;
    }

    public String getEncryptionAlgOID() {
        return this.f18968encAlg.getAlgorithm().toString();
    }

    public byte[] getEncryptionAlgParams() {
        try {
            return CMSUtils.encodeObj(this.f18968encAlg.getParameters());
        } catch (Exception e) {
            throw new RuntimeException("exception getting encryption parameters " + e);
        }
    }

    public OriginatorInformation getOriginatorInfo() {
        return this.originatorInfo;
    }

    public RecipientInformationStore getRecipientInfos() {
        return this.recipientInfoStore;
    }

    public AttributeTable getUnprotectedAttributes() {
        if (this.unprotectedAttributes == null && this.attrNotRead) {
            this.attrNotRead = false;
            this.unprotectedAttributes = CMSUtils.getAttributesTable(this.envelopedData.getUnprotectedAttrs());
        }
        return this.unprotectedAttributes;
    }

    public CMSEnvelopedDataParser(byte[] bArr) {
        this(new ByteArrayInputStream(bArr));
    }
}
