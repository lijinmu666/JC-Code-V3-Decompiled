package org.bouncycastle.p191cms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p139cms.AttributeTable;
import org.bouncycastle.p133asn1.p139cms.AuthEnvelopedData;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;
import org.bouncycastle.p133asn1.p139cms.EncryptedContentInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Encodable;

/* loaded from: classes2.dex */
public class CMSAuthEnvelopedData implements Encodable {
    private AbstractC5093ASN1Set authAttrs;
    private AlgorithmIdentifier authEncAlg;
    ContentInfo contentInfo;

    /* renamed from: mac */
    private byte[] f18938mac;
    private OriginatorInformation originatorInfo;
    RecipientInformationStore recipientInfoStore;
    private AbstractC5093ASN1Set unauthAttrs;

    public CMSAuthEnvelopedData(InputStream inputStream) {
        this(CMSUtils.readContentInfo(inputStream));
    }

    public AttributeTable getAuthAttrs() {
        AbstractC5093ASN1Set abstractC5093ASN1Set = this.authAttrs;
        if (abstractC5093ASN1Set == null) {
            return null;
        }
        return new AttributeTable(abstractC5093ASN1Set);
    }

    @Override // org.bouncycastle.p361util.Encodable
    public byte[] getEncoded() {
        return this.contentInfo.getEncoded();
    }

    public String getEncryptionAlgOID() {
        return this.authEncAlg.getAlgorithm().m14433getId();
    }

    /* renamed from: getMac */
    public byte[] m14844getMac() {
        return C6238Arrays.m18231clone(this.f18938mac);
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

    public CMSAuthEnvelopedData(ContentInfo contentInfo) {
        this.contentInfo = contentInfo;
        AuthEnvelopedData authEnvelopedData = AuthEnvelopedData.getInstance(contentInfo.getContent());
        if (authEnvelopedData.getOriginatorInfo() != null) {
            this.originatorInfo = new OriginatorInformation(authEnvelopedData.getOriginatorInfo());
        }
        AbstractC5093ASN1Set recipientInfos = authEnvelopedData.getRecipientInfos();
        final EncryptedContentInfo authEncryptedContentInfo = authEnvelopedData.getAuthEncryptedContentInfo();
        this.authEncAlg = authEncryptedContentInfo.getContentEncryptionAlgorithm();
        this.f18938mac = authEnvelopedData.m14534getMac().getOctets();
        CMSSecureReadableWithAAD cMSSecureReadableWithAAD = new CMSSecureReadableWithAAD(this) { // from class: org.bouncycastle.cms.CMSAuthEnvelopedData.1
            private OutputStream aadStream;

            /* renamed from: this$0 */
            final /* synthetic */ CMSAuthEnvelopedData f18939this$0;

            {
                this.f18939this$0 = this;
            }

            @Override // org.bouncycastle.p191cms.CMSSecureReadableWithAAD
            public OutputStream getAADStream() {
                return this.aadStream;
            }

            @Override // org.bouncycastle.p191cms.CMSSecureReadable
            public AbstractC5093ASN1Set getAuthAttrSet() {
                return this.f18939this$0.authAttrs;
            }

            @Override // org.bouncycastle.p191cms.CMSSecureReadable
            public ASN1ObjectIdentifier getContentType() {
                return authEncryptedContentInfo.getContentType();
            }

            @Override // org.bouncycastle.p191cms.CMSSecureReadable
            public InputStream getInputStream() throws IOException {
                if (this.aadStream != null && this.f18939this$0.authAttrs != null) {
                    this.aadStream.write(this.f18939this$0.authAttrs.getEncoded(ASN1Encoding.f17902DER));
                }
                return new InputStreamWithMAC(new ByteArrayInputStream(authEncryptedContentInfo.getEncryptedContent().getOctets()), this.f18939this$0.f18938mac);
            }

            @Override // org.bouncycastle.p191cms.CMSSecureReadableWithAAD
            /* renamed from: getMAC */
            public byte[] mo14845getMAC() {
                return C6238Arrays.m18231clone(this.f18939this$0.f18938mac);
            }

            @Override // org.bouncycastle.p191cms.CMSSecureReadable
            public boolean hasAdditionalData() {
                return (this.aadStream == null || this.f18939this$0.authAttrs == null) ? false : true;
            }

            @Override // org.bouncycastle.p191cms.CMSSecureReadableWithAAD
            public void setAADStream(OutputStream outputStream) {
                this.aadStream = outputStream;
            }

            @Override // org.bouncycastle.p191cms.CMSSecureReadable
            public void setAuthAttrSet(AbstractC5093ASN1Set abstractC5093ASN1Set) {
            }
        };
        this.authAttrs = authEnvelopedData.getAuthAttrs();
        this.unauthAttrs = authEnvelopedData.getUnauthAttrs();
        this.recipientInfoStore = CMSEnvelopedHelper.buildRecipientInformationStore(recipientInfos, this.authEncAlg, cMSSecureReadableWithAAD);
    }

    public CMSAuthEnvelopedData(byte[] bArr) {
        this(CMSUtils.readContentInfo(bArr));
    }
}
