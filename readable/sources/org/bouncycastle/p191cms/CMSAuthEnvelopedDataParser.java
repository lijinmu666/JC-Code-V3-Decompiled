package org.bouncycastle.p191cms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1OctetStringParser;
import org.bouncycastle.p133asn1.ASN1SequenceParser;
import org.bouncycastle.p133asn1.ASN1SetParser;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p139cms.AttributeTable;
import org.bouncycastle.p133asn1.p139cms.AuthEnvelopedDataParser;
import org.bouncycastle.p133asn1.p139cms.CMSAttributes;
import org.bouncycastle.p133asn1.p139cms.EncryptedContentInfoParser;
import org.bouncycastle.p133asn1.p139cms.OriginatorInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class CMSAuthEnvelopedDataParser extends CMSContentInfoParser {
    private boolean authAttrNotRead;
    private AbstractC5093ASN1Set authAttrSet;
    private AttributeTable authAttrs;
    private final AuthEnvelopedDataParser authEvnData;

    /* renamed from: encAlg */
    private final AlgorithmIdentifier f18940encAlg;
    private final LocalMacProvider localMacProvider;
    private OriginatorInformation originatorInfo;
    private final RecipientInformationStore recipientInfoStore;
    private boolean unauthAttrNotRead;
    private AttributeTable unauthAttrs;

    public static class LocalMacProvider implements MACProvider {
        private final AuthEnvelopedDataParser authEnvData;

        /* renamed from: mac */
        private byte[] f18942mac;

        /* renamed from: parser */
        private final CMSAuthEnvelopedDataParser f18943parser;
        private CMSSecureReadableWithAAD readable;

        public LocalMacProvider(AuthEnvelopedDataParser authEnvelopedDataParser, CMSAuthEnvelopedDataParser cMSAuthEnvelopedDataParser) {
            this.authEnvData = authEnvelopedDataParser;
            this.f18943parser = cMSAuthEnvelopedDataParser;
        }

        @Override // org.bouncycastle.p191cms.MACProvider
        /* renamed from: getMAC */
        public byte[] mo14847getMAC() {
            return this.f18942mac;
        }

        @Override // org.bouncycastle.p191cms.MACProvider
        /* renamed from: init */
        public void mo14848init() throws IOException {
            CMSAuthEnvelopedDataParser cMSAuthEnvelopedDataParser = this.f18943parser;
            cMSAuthEnvelopedDataParser.authAttrs = cMSAuthEnvelopedDataParser.getAuthAttrs();
            if (this.f18943parser.authAttrs != null) {
                this.readable.setAuthAttrSet(this.f18943parser.authAttrSet);
                this.readable.getAADStream().write(this.f18943parser.authAttrs.toASN1Structure().getEncoded(ASN1Encoding.f17902DER));
            }
            this.f18942mac = this.authEnvData.m14535getMac().getOctets();
        }

        public void setSecureReadable(CMSSecureReadableWithAAD cMSSecureReadableWithAAD) {
            this.readable = cMSSecureReadableWithAAD;
        }
    }

    public CMSAuthEnvelopedDataParser(InputStream inputStream) {
        super(inputStream);
        this.authAttrNotRead = true;
        this.unauthAttrNotRead = true;
        AuthEnvelopedDataParser authEnvelopedDataParser = new AuthEnvelopedDataParser((ASN1SequenceParser) this._contentInfo.getContent(16));
        this.authEvnData = authEnvelopedDataParser;
        OriginatorInfo originatorInfo = authEnvelopedDataParser.getOriginatorInfo();
        if (originatorInfo != null) {
            this.originatorInfo = new OriginatorInformation(originatorInfo);
        }
        AbstractC5093ASN1Set abstractC5093ASN1Set = AbstractC5093ASN1Set.getInstance(authEnvelopedDataParser.getRecipientInfos().toASN1Primitive());
        final EncryptedContentInfoParser authEncryptedContentInfo = authEnvelopedDataParser.getAuthEncryptedContentInfo();
        AlgorithmIdentifier contentEncryptionAlgorithm = authEncryptedContentInfo.getContentEncryptionAlgorithm();
        this.f18940encAlg = contentEncryptionAlgorithm;
        LocalMacProvider localMacProvider = new LocalMacProvider(authEnvelopedDataParser, this);
        this.localMacProvider = localMacProvider;
        final CMSProcessableInputStream cMSProcessableInputStream = new CMSProcessableInputStream(new InputStreamWithMAC(((ASN1OctetStringParser) authEncryptedContentInfo.getEncryptedContent(4)).getOctetStream(), localMacProvider));
        CMSSecureReadableWithAAD cMSSecureReadableWithAAD = new CMSSecureReadableWithAAD(this) { // from class: org.bouncycastle.cms.CMSAuthEnvelopedDataParser.1
            private OutputStream aadStream;

            /* renamed from: this$0 */
            final /* synthetic */ CMSAuthEnvelopedDataParser f18941this$0;

            {
                this.f18941this$0 = this;
            }

            @Override // org.bouncycastle.p191cms.CMSSecureReadableWithAAD
            public OutputStream getAADStream() {
                return this.aadStream;
            }

            @Override // org.bouncycastle.p191cms.CMSSecureReadable
            public AbstractC5093ASN1Set getAuthAttrSet() {
                return this.f18941this$0.authAttrSet;
            }

            @Override // org.bouncycastle.p191cms.CMSSecureReadable
            public ASN1ObjectIdentifier getContentType() {
                return authEncryptedContentInfo.getContentType();
            }

            @Override // org.bouncycastle.p191cms.CMSSecureReadable
            public InputStream getInputStream() {
                return cMSProcessableInputStream.getInputStream();
            }

            @Override // org.bouncycastle.p191cms.CMSSecureReadableWithAAD
            /* renamed from: getMAC */
            public byte[] mo14845getMAC() {
                return C6238Arrays.m18231clone(this.f18941this$0.localMacProvider.mo14847getMAC());
            }

            @Override // org.bouncycastle.p191cms.CMSSecureReadable
            public boolean hasAdditionalData() {
                return true;
            }

            @Override // org.bouncycastle.p191cms.CMSSecureReadableWithAAD
            public void setAADStream(OutputStream outputStream) {
                this.aadStream = outputStream;
            }

            @Override // org.bouncycastle.p191cms.CMSSecureReadable
            public void setAuthAttrSet(AbstractC5093ASN1Set abstractC5093ASN1Set2) {
            }
        };
        localMacProvider.setSecureReadable(cMSSecureReadableWithAAD);
        this.recipientInfoStore = CMSEnvelopedHelper.buildRecipientInformationStore(abstractC5093ASN1Set, contentEncryptionAlgorithm, cMSSecureReadableWithAAD);
    }

    private AbstractC5093ASN1Set getAuthAttrSet() {
        if (this.authAttrs == null && this.authAttrNotRead) {
            ASN1SetParser authAttrs = this.authEvnData.getAuthAttrs();
            if (authAttrs != null) {
                this.authAttrSet = (AbstractC5093ASN1Set) authAttrs.toASN1Primitive();
            }
            this.authAttrNotRead = false;
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

    public String getEncAlgOID() {
        return this.f18940encAlg.getAlgorithm().toString();
    }

    public byte[] getEncAlgParams() {
        try {
            return CMSUtils.encodeObj(this.f18940encAlg.getParameters());
        } catch (Exception e) {
            throw new RuntimeException("exception getting encryption parameters " + e);
        }
    }

    public AlgorithmIdentifier getEncryptionAlgOID() {
        return this.f18940encAlg;
    }

    /* renamed from: getMac */
    public byte[] m14846getMac() {
        return C6238Arrays.m18231clone(this.localMacProvider.mo14847getMAC());
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
            this.unauthAttrs = CMSUtils.getAttributesTable(this.authEvnData.getUnauthAttrs());
        }
        return this.unauthAttrs;
    }

    public CMSAuthEnvelopedDataParser(byte[] bArr) {
        this(new ByteArrayInputStream(bArr));
    }
}
