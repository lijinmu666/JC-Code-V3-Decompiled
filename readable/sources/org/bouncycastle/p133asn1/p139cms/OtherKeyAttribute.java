package org.bouncycastle.p133asn1.p139cms;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes.dex */
public class OtherKeyAttribute extends ASN1Object {

    /* renamed from: keyAttr */
    private ASN1Encodable f18214keyAttr;
    private ASN1ObjectIdentifier keyAttrId;

    public OtherKeyAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.keyAttrId = aSN1ObjectIdentifier;
        this.f18214keyAttr = aSN1Encodable;
    }

    public static OtherKeyAttribute getInstance(Object obj) {
        if (obj instanceof OtherKeyAttribute) {
            return (OtherKeyAttribute) obj;
        }
        if (obj != null) {
            return new OtherKeyAttribute(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Encodable getKeyAttr() {
        return this.f18214keyAttr;
    }

    public ASN1ObjectIdentifier getKeyAttrId() {
        return this.keyAttrId;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.m14420add(this.keyAttrId);
        ASN1Encodable aSN1Encodable = this.f18214keyAttr;
        if (aSN1Encodable != null) {
            aSN1EncodableVector.m14420add(aSN1Encodable);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    private OtherKeyAttribute(ASN1Sequence aSN1Sequence) {
        this.keyAttrId = (ASN1ObjectIdentifier) aSN1Sequence.getObjectAt(0);
        if (aSN1Sequence.mo14450size() > 1) {
            this.f18214keyAttr = aSN1Sequence.getObjectAt(1);
        }
    }
}
