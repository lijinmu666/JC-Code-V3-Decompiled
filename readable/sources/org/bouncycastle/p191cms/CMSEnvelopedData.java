package org.bouncycastle.p191cms;

import java.io.InputStream;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p139cms.AttributeTable;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;
import org.bouncycastle.p133asn1.p139cms.EncryptedContentInfo;
import org.bouncycastle.p133asn1.p139cms.EnvelopedData;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p191cms.CMSEnvelopedHelper;
import org.bouncycastle.p361util.Encodable;

/* loaded from: classes2.dex */
public class CMSEnvelopedData implements Encodable {
    ContentInfo contentInfo;

    /* renamed from: encAlg */
    private AlgorithmIdentifier f18967encAlg;
    private OriginatorInformation originatorInfo;
    RecipientInformationStore recipientInfoStore;
    private AbstractC5093ASN1Set unprotectedAttributes;

    public CMSEnvelopedData(InputStream inputStream) {
        this(CMSUtils.readContentInfo(inputStream));
    }

    public AlgorithmIdentifier getContentEncryptionAlgorithm() {
        return this.f18967encAlg;
    }

    @Override // org.bouncycastle.p361util.Encodable
    public byte[] getEncoded() {
        return this.contentInfo.getEncoded();
    }

    public String getEncryptionAlgOID() {
        return this.f18967encAlg.getAlgorithm().m14433getId();
    }

    public byte[] getEncryptionAlgParams() {
        try {
            return CMSUtils.encodeObj(this.f18967encAlg.getParameters());
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
        AbstractC5093ASN1Set abstractC5093ASN1Set = this.unprotectedAttributes;
        if (abstractC5093ASN1Set == null) {
            return null;
        }
        return new AttributeTable(abstractC5093ASN1Set);
    }

    public ContentInfo toASN1Structure() {
        return this.contentInfo;
    }

    public CMSEnvelopedData(ContentInfo contentInfo) throws CMSException {
        this.contentInfo = contentInfo;
        try {
            EnvelopedData envelopedData = EnvelopedData.getInstance(contentInfo.getContent());
            if (envelopedData.getOriginatorInfo() != null) {
                this.originatorInfo = new OriginatorInformation(envelopedData.getOriginatorInfo());
            }
            AbstractC5093ASN1Set recipientInfos = envelopedData.getRecipientInfos();
            EncryptedContentInfo encryptedContentInfo = envelopedData.getEncryptedContentInfo();
            this.f18967encAlg = encryptedContentInfo.getContentEncryptionAlgorithm();
            this.recipientInfoStore = CMSEnvelopedHelper.buildRecipientInformationStore(recipientInfos, this.f18967encAlg, new CMSEnvelopedHelper.CMSAuthEnveSecureReadable(this.f18967encAlg, encryptedContentInfo.getContentType(), new CMSProcessableByteArray(encryptedContentInfo.getEncryptedContent().getOctets())));
            this.unprotectedAttributes = envelopedData.getUnprotectedAttrs();
        } catch (ClassCastException e) {
            throw new CMSException("Malformed content.", e);
        } catch (IllegalArgumentException e2) {
            throw new CMSException("Malformed content.", e2);
        }
    }

    public CMSEnvelopedData(byte[] bArr) {
        this(CMSUtils.readContentInfo(bArr));
    }
}
