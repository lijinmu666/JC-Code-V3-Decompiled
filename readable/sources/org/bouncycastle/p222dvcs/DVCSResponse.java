package org.bouncycastle.p222dvcs;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;
import org.bouncycastle.p133asn1.p139cms.SignedData;
import org.bouncycastle.p133asn1.p142dvcs.DVCSObjectIdentifiers;
import org.bouncycastle.p191cms.CMSSignedData;

/* loaded from: classes2.dex */
public class DVCSResponse extends DVCSMessage {

    /* renamed from: asn1 */
    private org.bouncycastle.p133asn1.p142dvcs.DVCSResponse f21146asn1;

    public DVCSResponse(ContentInfo contentInfo) throws DVCSConstructionException {
        super(contentInfo);
        if (!DVCSObjectIdentifiers.id_ct_DVCSResponseData.m14446equals((ASN1Primitive) contentInfo.getContentType())) {
            throw new DVCSConstructionException("ContentInfo not a DVCS Response");
        }
        try {
            this.f21146asn1 = contentInfo.getContent().toASN1Primitive() instanceof ASN1Sequence ? org.bouncycastle.p133asn1.p142dvcs.DVCSResponse.getInstance(contentInfo.getContent()) : org.bouncycastle.p133asn1.p142dvcs.DVCSResponse.getInstance(ASN1OctetString.getInstance(contentInfo.getContent()).getOctets());
        } catch (Exception e) {
            throw new DVCSConstructionException("Unable to parse content: " + e.getMessage(), e);
        }
    }

    @Override // org.bouncycastle.p222dvcs.DVCSMessage
    public ASN1Encodable getContent() {
        return this.f21146asn1;
    }

    public DVCSResponse(CMSSignedData cMSSignedData) {
        this(SignedData.getInstance(cMSSignedData.toASN1Structure().getContent()).getEncapContentInfo());
    }
}
