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
import org.bouncycastle.p133asn1.BERTaggedObject;

/* loaded from: classes.dex */
public class EncryptedData extends ASN1Object {
    private EncryptedContentInfo encryptedContentInfo;
    private AbstractC5093ASN1Set unprotectedAttrs;

    /* renamed from: version */
    private ASN1Integer f18188version;

    private EncryptedData(ASN1Sequence aSN1Sequence) {
        this.f18188version = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        this.encryptedContentInfo = EncryptedContentInfo.getInstance(aSN1Sequence.getObjectAt(1));
        if (aSN1Sequence.mo14450size() == 3) {
            this.unprotectedAttrs = AbstractC5093ASN1Set.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(2), false);
        }
    }

    public static EncryptedData getInstance(Object obj) {
        if (obj instanceof EncryptedData) {
            return (EncryptedData) obj;
        }
        if (obj != null) {
            return new EncryptedData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public EncryptedContentInfo getEncryptedContentInfo() {
        return this.encryptedContentInfo;
    }

    public AbstractC5093ASN1Set getUnprotectedAttrs() {
        return this.unprotectedAttrs;
    }

    public ASN1Integer getVersion() {
        return this.f18188version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(this.f18188version);
        aSN1EncodableVector.m14420add(this.encryptedContentInfo);
        AbstractC5093ASN1Set abstractC5093ASN1Set = this.unprotectedAttrs;
        if (abstractC5093ASN1Set != null) {
            aSN1EncodableVector.m14420add(new BERTaggedObject(false, 1, (ASN1Encodable) abstractC5093ASN1Set));
        }
        return new BERSequence(aSN1EncodableVector);
    }

    public EncryptedData(EncryptedContentInfo encryptedContentInfo) {
        this(encryptedContentInfo, null);
    }

    public EncryptedData(EncryptedContentInfo encryptedContentInfo, AbstractC5093ASN1Set abstractC5093ASN1Set) {
        this.f18188version = abstractC5093ASN1Set == null ? ASN1Integer.f17922ZERO : ASN1Integer.f17920TWO;
        this.encryptedContentInfo = encryptedContentInfo;
        this.unprotectedAttrs = abstractC5093ASN1Set;
    }
}
