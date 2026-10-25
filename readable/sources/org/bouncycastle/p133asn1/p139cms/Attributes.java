package org.bouncycastle.p133asn1.p139cms;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.C5105DLSet;

/* loaded from: classes.dex */
public class Attributes extends ASN1Object {
    private AbstractC5093ASN1Set attributes;

    public Attributes(ASN1EncodableVector aSN1EncodableVector) {
        this.attributes = new C5105DLSet(aSN1EncodableVector);
    }

    public static Attributes getInstance(Object obj) {
        if (obj instanceof Attributes) {
            return (Attributes) obj;
        }
        if (obj != null) {
            return new Attributes(AbstractC5093ASN1Set.getInstance(obj));
        }
        return null;
    }

    public static Attributes getTagged(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return new Attributes(AbstractC5093ASN1Set.getTagged(aSN1TaggedObject, z));
    }

    public Attribute[] getAttributes() {
        int iM14454size = this.attributes.m14454size();
        Attribute[] attributeArr = new Attribute[iM14454size];
        for (int i = 0; i != iM14454size; i++) {
            attributeArr[i] = Attribute.getInstance(this.attributes.getObjectAt(i));
        }
        return attributeArr;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.attributes;
    }

    private Attributes(AbstractC5093ASN1Set abstractC5093ASN1Set) {
        this.attributes = abstractC5093ASN1Set;
    }

    public static Attributes getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return new Attributes(AbstractC5093ASN1Set.getInstance(aSN1TaggedObject, z));
    }
}
