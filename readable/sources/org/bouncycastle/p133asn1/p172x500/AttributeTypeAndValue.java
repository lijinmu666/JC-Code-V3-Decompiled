package org.bouncycastle.p133asn1.p172x500;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class AttributeTypeAndValue extends ASN1Object {

    /* renamed from: type */
    private ASN1ObjectIdentifier f18581type;

    /* renamed from: value */
    private ASN1Encodable f18582value;

    public AttributeTypeAndValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f18581type = aSN1ObjectIdentifier;
        this.f18582value = aSN1Encodable;
    }

    public static AttributeTypeAndValue getInstance(Object obj) {
        if (obj instanceof AttributeTypeAndValue) {
            return (AttributeTypeAndValue) obj;
        }
        if (obj != null) {
            return new AttributeTypeAndValue(ASN1Sequence.getInstance(obj));
        }
        throw new IllegalArgumentException("null value in getInstance()");
    }

    /* renamed from: getType */
    public ASN1ObjectIdentifier m14663getType() {
        return this.f18581type;
    }

    public ASN1Encodable getValue() {
        return this.f18582value;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.f18581type, this.f18582value);
    }

    private AttributeTypeAndValue(ASN1Sequence aSN1Sequence) {
        this.f18581type = (ASN1ObjectIdentifier) aSN1Sequence.getObjectAt(0);
        this.f18582value = aSN1Sequence.getObjectAt(1);
    }
}
