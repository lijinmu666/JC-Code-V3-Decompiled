package org.bouncycastle.p133asn1.p139cms;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.BERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* loaded from: classes.dex */
public class AuthEnvelopedData extends ASN1Object {
    private AbstractC5093ASN1Set authAttrs;
    private EncryptedContentInfo authEncryptedContentInfo;

    /* renamed from: mac */
    private ASN1OctetString f18165mac;
    private OriginatorInfo originatorInfo;
    private AbstractC5093ASN1Set recipientInfos;
    private AbstractC5093ASN1Set unauthAttrs;

    /* renamed from: version */
    private ASN1Integer f18166version;

    private AuthEnvelopedData(ASN1Sequence aSN1Sequence) {
        AbstractC5093ASN1Set abstractC5093ASN1Set;
        ASN1Integer aSN1Integer = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0).toASN1Primitive());
        this.f18166version = aSN1Integer;
        if (!aSN1Integer.hasValue(0)) {
            throw new IllegalArgumentException("AuthEnvelopedData version number must be 0");
        }
        ASN1Primitive aSN1Primitive = aSN1Sequence.getObjectAt(1).toASN1Primitive();
        int i = 2;
        if (aSN1Primitive instanceof ASN1TaggedObject) {
            this.originatorInfo = OriginatorInfo.getInstance((ASN1TaggedObject) aSN1Primitive, false);
            aSN1Primitive = aSN1Sequence.getObjectAt(2).toASN1Primitive();
            i = 3;
        }
        AbstractC5093ASN1Set abstractC5093ASN1Set2 = AbstractC5093ASN1Set.getInstance(aSN1Primitive);
        this.recipientInfos = abstractC5093ASN1Set2;
        if (abstractC5093ASN1Set2.m14454size() == 0) {
            throw new IllegalArgumentException("AuthEnvelopedData requires at least 1 RecipientInfo");
        }
        this.authEncryptedContentInfo = EncryptedContentInfo.getInstance(aSN1Sequence.getObjectAt(i).toASN1Primitive());
        int i2 = i + 2;
        ASN1Primitive aSN1Primitive2 = aSN1Sequence.getObjectAt(i + 1).toASN1Primitive();
        if (aSN1Primitive2 instanceof ASN1TaggedObject) {
            this.authAttrs = AbstractC5093ASN1Set.getInstance((ASN1TaggedObject) aSN1Primitive2, false);
            aSN1Primitive2 = aSN1Sequence.getObjectAt(i2).toASN1Primitive();
            i2 = i + 3;
        } else if (!this.authEncryptedContentInfo.getContentType().m14446equals((ASN1Primitive) CMSObjectIdentifiers.f18179data) && ((abstractC5093ASN1Set = this.authAttrs) == null || abstractC5093ASN1Set.m14454size() == 0)) {
            throw new IllegalArgumentException("authAttrs must be present with non-data content");
        }
        this.f18165mac = ASN1OctetString.getInstance(aSN1Primitive2);
        if (aSN1Sequence.mo14450size() > i2) {
            this.unauthAttrs = AbstractC5093ASN1Set.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(i2).toASN1Primitive(), false);
        }
    }

    public static AuthEnvelopedData getInstance(Object obj) {
        if (obj instanceof AuthEnvelopedData) {
            return (AuthEnvelopedData) obj;
        }
        if (obj != null) {
            return new AuthEnvelopedData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AbstractC5093ASN1Set getAuthAttrs() {
        return this.authAttrs;
    }

    public EncryptedContentInfo getAuthEncryptedContentInfo() {
        return this.authEncryptedContentInfo;
    }

    /* renamed from: getMac */
    public ASN1OctetString m14534getMac() {
        return this.f18165mac;
    }

    public OriginatorInfo getOriginatorInfo() {
        return this.originatorInfo;
    }

    public AbstractC5093ASN1Set getRecipientInfos() {
        return this.recipientInfos;
    }

    public AbstractC5093ASN1Set getUnauthAttrs() {
        return this.unauthAttrs;
    }

    public ASN1Integer getVersion() {
        return this.f18166version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(7);
        aSN1EncodableVector.m14420add(this.f18166version);
        OriginatorInfo originatorInfo = this.originatorInfo;
        if (originatorInfo != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 0, (ASN1Encodable) originatorInfo));
        }
        aSN1EncodableVector.m14420add(this.recipientInfos);
        aSN1EncodableVector.m14420add(this.authEncryptedContentInfo);
        AbstractC5093ASN1Set abstractC5093ASN1Set = this.authAttrs;
        if (abstractC5093ASN1Set != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 1, (ASN1Encodable) abstractC5093ASN1Set));
        }
        aSN1EncodableVector.m14420add(this.f18165mac);
        AbstractC5093ASN1Set abstractC5093ASN1Set2 = this.unauthAttrs;
        if (abstractC5093ASN1Set2 != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 2, (ASN1Encodable) abstractC5093ASN1Set2));
        }
        return new BERSequence(aSN1EncodableVector);
    }

    public AuthEnvelopedData(OriginatorInfo originatorInfo, AbstractC5093ASN1Set abstractC5093ASN1Set, EncryptedContentInfo encryptedContentInfo, AbstractC5093ASN1Set abstractC5093ASN1Set2, ASN1OctetString aSN1OctetString, AbstractC5093ASN1Set abstractC5093ASN1Set3) {
        this.f18166version = ASN1Integer.f17922ZERO;
        this.originatorInfo = originatorInfo;
        this.recipientInfos = abstractC5093ASN1Set;
        if (abstractC5093ASN1Set.m14454size() == 0) {
            throw new IllegalArgumentException("AuthEnvelopedData requires at least 1 RecipientInfo");
        }
        this.authEncryptedContentInfo = encryptedContentInfo;
        this.authAttrs = abstractC5093ASN1Set2;
        if (!encryptedContentInfo.getContentType().m14446equals((ASN1Primitive) CMSObjectIdentifiers.f18179data) && (abstractC5093ASN1Set2 == null || abstractC5093ASN1Set2.m14454size() == 0)) {
            throw new IllegalArgumentException("authAttrs must be present with non-data content");
        }
        this.f18165mac = aSN1OctetString;
        this.unauthAttrs = abstractC5093ASN1Set3;
    }

    public static AuthEnvelopedData getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
