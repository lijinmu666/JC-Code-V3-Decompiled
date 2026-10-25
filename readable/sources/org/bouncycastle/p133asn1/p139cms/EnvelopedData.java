package org.bouncycastle.p133asn1.p139cms;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.BERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* loaded from: classes.dex */
public class EnvelopedData extends ASN1Object {
    private EncryptedContentInfo encryptedContentInfo;
    private OriginatorInfo originatorInfo;
    private AbstractC5093ASN1Set recipientInfos;
    private AbstractC5093ASN1Set unprotectedAttrs;

    /* renamed from: version */
    private ASN1Integer f18189version;

    private EnvelopedData(ASN1Sequence aSN1Sequence) {
        this.f18189version = (ASN1Integer) aSN1Sequence.getObjectAt(0);
        ASN1Encodable objectAt = aSN1Sequence.getObjectAt(1);
        int i = 2;
        if (objectAt instanceof ASN1TaggedObject) {
            this.originatorInfo = OriginatorInfo.getInstance((ASN1TaggedObject) objectAt, false);
            objectAt = aSN1Sequence.getObjectAt(2);
            i = 3;
        }
        this.recipientInfos = AbstractC5093ASN1Set.getInstance(objectAt);
        int i2 = i + 1;
        this.encryptedContentInfo = EncryptedContentInfo.getInstance(aSN1Sequence.getObjectAt(i));
        if (aSN1Sequence.mo14450size() > i2) {
            this.unprotectedAttrs = AbstractC5093ASN1Set.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(i2), false);
        }
    }

    public static int calculateVersion(OriginatorInfo originatorInfo, AbstractC5093ASN1Set abstractC5093ASN1Set, AbstractC5093ASN1Set abstractC5093ASN1Set2) {
        if (originatorInfo != null) {
            AbstractC5093ASN1Set abstractC5093ASN1SetM14547getCRLs = originatorInfo.m14547getCRLs();
            if (abstractC5093ASN1SetM14547getCRLs != null) {
                int iM14454size = abstractC5093ASN1SetM14547getCRLs.m14454size();
                for (int i = 0; i < iM14454size; i++) {
                    ASN1Encodable objectAt = abstractC5093ASN1SetM14547getCRLs.getObjectAt(i);
                    if ((objectAt instanceof ASN1TaggedObject) && ((ASN1TaggedObject) objectAt).hasContextTag(1)) {
                        return 4;
                    }
                }
            }
            AbstractC5093ASN1Set certificates = originatorInfo.getCertificates();
            if (certificates != null) {
                int iM14454size2 = certificates.m14454size();
                boolean z = false;
                for (int i2 = 0; i2 < iM14454size2; i2++) {
                    ASN1Encodable objectAt2 = certificates.getObjectAt(i2);
                    if (objectAt2 instanceof ASN1TaggedObject) {
                        ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objectAt2;
                        if (aSN1TaggedObject.hasContextTag(3)) {
                            return 4;
                        }
                        z = z || aSN1TaggedObject.hasContextTag(2);
                    }
                }
                if (z) {
                    return 3;
                }
            }
        }
        int iM14454size3 = abstractC5093ASN1Set.m14454size();
        boolean z2 = true;
        for (int i3 = 0; i3 < iM14454size3; i3++) {
            RecipientInfo recipientInfo = RecipientInfo.getInstance(abstractC5093ASN1Set.getObjectAt(i3));
            if (recipientInfo.isPasswordOrOther()) {
                return 3;
            }
            z2 = z2 && recipientInfo.isKeyTransV0();
        }
        return (originatorInfo == null && abstractC5093ASN1Set2 == null && z2) ? 0 : 2;
    }

    public static EnvelopedData getInstance(Object obj) {
        if (obj instanceof EnvelopedData) {
            return (EnvelopedData) obj;
        }
        if (obj != null) {
            return new EnvelopedData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public EncryptedContentInfo getEncryptedContentInfo() {
        return this.encryptedContentInfo;
    }

    public OriginatorInfo getOriginatorInfo() {
        return this.originatorInfo;
    }

    public AbstractC5093ASN1Set getRecipientInfos() {
        return this.recipientInfos;
    }

    public AbstractC5093ASN1Set getUnprotectedAttrs() {
        return this.unprotectedAttrs;
    }

    public ASN1Integer getVersion() {
        return this.f18189version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(5);
        aSN1EncodableVector.m14420add(this.f18189version);
        OriginatorInfo originatorInfo = this.originatorInfo;
        if (originatorInfo != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 0, (ASN1Encodable) originatorInfo));
        }
        aSN1EncodableVector.m14420add(this.recipientInfos);
        aSN1EncodableVector.m14420add(this.encryptedContentInfo);
        AbstractC5093ASN1Set abstractC5093ASN1Set = this.unprotectedAttrs;
        if (abstractC5093ASN1Set != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 1, (ASN1Encodable) abstractC5093ASN1Set));
        }
        return new BERSequence(aSN1EncodableVector);
    }

    public EnvelopedData(OriginatorInfo originatorInfo, AbstractC5093ASN1Set abstractC5093ASN1Set, EncryptedContentInfo encryptedContentInfo, AbstractC5093ASN1Set abstractC5093ASN1Set2) {
        this.f18189version = ASN1Integer.m14429valueOf(calculateVersion(originatorInfo, abstractC5093ASN1Set, abstractC5093ASN1Set2));
        this.originatorInfo = originatorInfo;
        this.recipientInfos = abstractC5093ASN1Set;
        this.encryptedContentInfo = encryptedContentInfo;
        this.unprotectedAttrs = abstractC5093ASN1Set2;
    }

    public static EnvelopedData getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public EnvelopedData(OriginatorInfo originatorInfo, AbstractC5093ASN1Set abstractC5093ASN1Set, EncryptedContentInfo encryptedContentInfo, Attributes attributes) {
        this.f18189version = ASN1Integer.m14429valueOf(calculateVersion(originatorInfo, abstractC5093ASN1Set, AbstractC5093ASN1Set.getInstance(attributes)));
        this.originatorInfo = originatorInfo;
        this.recipientInfos = abstractC5093ASN1Set;
        this.encryptedContentInfo = encryptedContentInfo;
        this.unprotectedAttrs = AbstractC5093ASN1Set.getInstance(attributes);
    }
}
