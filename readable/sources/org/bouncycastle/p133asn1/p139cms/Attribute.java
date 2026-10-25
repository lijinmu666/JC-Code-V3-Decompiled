package org.bouncycastle.p133asn1.p139cms;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes.dex */
public class Attribute extends ASN1Object {
    private ASN1ObjectIdentifier attrType;
    private AbstractC5093ASN1Set attrValues;

    public Attribute(ASN1ObjectIdentifier aSN1ObjectIdentifier, AbstractC5093ASN1Set abstractC5093ASN1Set) {
        this.attrType = aSN1ObjectIdentifier;
        this.attrValues = abstractC5093ASN1Set;
    }

    public static Attribute getInstance(Object obj) {
        if (obj instanceof Attribute) {
            return (Attribute) obj;
        }
        if (obj != null) {
            return new Attribute(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1ObjectIdentifier getAttrType() {
        return this.attrType;
    }

    public AbstractC5093ASN1Set getAttrValues() {
        return this.attrValues;
    }

    public ASN1Encodable[] getAttributeValues() {
        return this.attrValues.m14455toArray();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.attrType, this.attrValues);
    }

    private Attribute(ASN1Sequence aSN1Sequence) {
        this.attrType = (ASN1ObjectIdentifier) aSN1Sequence.getObjectAt(0);
        this.attrValues = (AbstractC5093ASN1Set) aSN1Sequence.getObjectAt(1);
    }
}
