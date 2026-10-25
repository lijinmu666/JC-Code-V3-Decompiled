package org.bouncycastle.p191cms;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p139cms.CMSObjectIdentifiers;
import org.bouncycastle.p133asn1.p139cms.KEKRecipientInfo;
import org.bouncycastle.p133asn1.p139cms.KEMRecipientInfo;
import org.bouncycastle.p133asn1.p139cms.KeyAgreeRecipientInfo;
import org.bouncycastle.p133asn1.p139cms.KeyTransRecipientInfo;
import org.bouncycastle.p133asn1.p139cms.OtherRecipientInfo;
import org.bouncycastle.p133asn1.p139cms.PasswordRecipientInfo;
import org.bouncycastle.p133asn1.p139cms.RecipientInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
class CMSEnvelopedHelper {

    public static class CMSAuthEnveSecureReadable extends CMSDefaultSecureReadable {
        private AlgorithmIdentifier algorithm;

        public CMSAuthEnveSecureReadable(AlgorithmIdentifier algorithmIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier, CMSReadable cMSReadable) {
            super(aSN1ObjectIdentifier, cMSReadable);
            this.algorithm = algorithmIdentifier;
        }

        @Override // org.bouncycastle.p191cms.CMSSecureReadable
        public InputStream getInputStream() {
            return this.readable.getInputStream();
        }

        @Override // org.bouncycastle.p191cms.CMSSecureReadable
        public boolean hasAdditionalData() {
            return false;
        }
    }

    public static abstract class CMSDefaultSecureReadable implements CMSSecureReadable {
        protected AbstractC5093ASN1Set authAttrSet;
        protected final ASN1ObjectIdentifier contentType;
        protected CMSReadable readable;

        public CMSDefaultSecureReadable(ASN1ObjectIdentifier aSN1ObjectIdentifier, CMSReadable cMSReadable) {
            this.contentType = aSN1ObjectIdentifier;
            this.readable = cMSReadable;
        }

        @Override // org.bouncycastle.p191cms.CMSSecureReadable
        public AbstractC5093ASN1Set getAuthAttrSet() {
            return this.authAttrSet;
        }

        @Override // org.bouncycastle.p191cms.CMSSecureReadable
        public ASN1ObjectIdentifier getContentType() {
            return this.contentType;
        }

        @Override // org.bouncycastle.p191cms.CMSSecureReadable
        public void setAuthAttrSet(AbstractC5093ASN1Set abstractC5093ASN1Set) {
            this.authAttrSet = abstractC5093ASN1Set;
        }
    }

    public static class CMSDigestAuthenticatedSecureReadable extends CMSDefaultSecureReadable {
        private DigestCalculator digestCalculator;

        public CMSDigestAuthenticatedSecureReadable(DigestCalculator digestCalculator, ASN1ObjectIdentifier aSN1ObjectIdentifier, CMSReadable cMSReadable) {
            super(aSN1ObjectIdentifier, cMSReadable);
            this.digestCalculator = digestCalculator;
        }

        public byte[] getDigest() {
            return this.digestCalculator.getDigest();
        }

        @Override // org.bouncycastle.p191cms.CMSSecureReadable
        public InputStream getInputStream() {
            return new FilterInputStream(this.readable.getInputStream()) { // from class: org.bouncycastle.cms.CMSEnvelopedHelper.CMSDigestAuthenticatedSecureReadable.1
                @Override // java.io.FilterInputStream, java.io.InputStream
                public int read() throws IOException {
                    int i = ((FilterInputStream) this).in.read();
                    if (i >= 0) {
                        CMSDigestAuthenticatedSecureReadable.this.digestCalculator.getOutputStream().write(i);
                    }
                    return i;
                }

                @Override // java.io.FilterInputStream, java.io.InputStream
                public int read(byte[] bArr, int i, int i2) throws IOException {
                    int i3 = ((FilterInputStream) this).in.read(bArr, i, i2);
                    if (i3 >= 0) {
                        CMSDigestAuthenticatedSecureReadable.this.digestCalculator.getOutputStream().write(bArr, i, i3);
                    }
                    return i3;
                }
            };
        }

        @Override // org.bouncycastle.p191cms.CMSSecureReadable
        public boolean hasAdditionalData() {
            return true;
        }
    }

    public static RecipientInformationStore buildRecipientInformationStore(AbstractC5093ASN1Set abstractC5093ASN1Set, AlgorithmIdentifier algorithmIdentifier, CMSSecureReadable cMSSecureReadable) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i != abstractC5093ASN1Set.m14454size(); i++) {
            readRecipientInfo(arrayList, RecipientInfo.getInstance(abstractC5093ASN1Set.getObjectAt(i)), algorithmIdentifier, cMSSecureReadable);
        }
        return new RecipientInformationStore(arrayList);
    }

    private static void readRecipientInfo(List list, RecipientInfo recipientInfo, AlgorithmIdentifier algorithmIdentifier, CMSSecureReadable cMSSecureReadable) {
        Object passwordRecipientInformation;
        ASN1Encodable aSN1EncodableM14551getInfo = recipientInfo.m14551getInfo();
        if (aSN1EncodableM14551getInfo instanceof KeyTransRecipientInfo) {
            passwordRecipientInformation = new KeyTransRecipientInformation((KeyTransRecipientInfo) aSN1EncodableM14551getInfo, algorithmIdentifier, cMSSecureReadable);
        } else if (aSN1EncodableM14551getInfo instanceof OtherRecipientInfo) {
            OtherRecipientInfo otherRecipientInfo = OtherRecipientInfo.getInstance(aSN1EncodableM14551getInfo);
            if (!CMSObjectIdentifiers.id_ori_kem.m14446equals((ASN1Primitive) otherRecipientInfo.m14548getType())) {
                return;
            } else {
                passwordRecipientInformation = new KEMRecipientInformation(KEMRecipientInfo.getInstance(otherRecipientInfo.getValue()), algorithmIdentifier, cMSSecureReadable);
            }
        } else if (aSN1EncodableM14551getInfo instanceof KEKRecipientInfo) {
            passwordRecipientInformation = new KEKRecipientInformation((KEKRecipientInfo) aSN1EncodableM14551getInfo, algorithmIdentifier, cMSSecureReadable);
        } else if (aSN1EncodableM14551getInfo instanceof KeyAgreeRecipientInfo) {
            KeyAgreeRecipientInformation.readRecipientInfo(list, (KeyAgreeRecipientInfo) aSN1EncodableM14551getInfo, algorithmIdentifier, cMSSecureReadable);
            return;
        } else if (!(aSN1EncodableM14551getInfo instanceof PasswordRecipientInfo)) {
            return;
        } else {
            passwordRecipientInformation = new PasswordRecipientInformation((PasswordRecipientInfo) aSN1EncodableM14551getInfo, algorithmIdentifier, cMSSecureReadable);
        }
        list.add(passwordRecipientInformation);
    }
}
