package org.bouncycastle.p133asn1.p172x500;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.C5104DERSet;

/* renamed from: org.bouncycastle.asn1.x500.RDN */
/* loaded from: classes2.dex */
public class C5188RDN extends ASN1Object {

    /* renamed from: values */
    private AbstractC5093ASN1Set f18584values;

    public C5188RDN(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this(new AttributeTypeAndValue(aSN1ObjectIdentifier, aSN1Encodable));
    }

    public static C5188RDN getInstance(Object obj) {
        if (obj instanceof C5188RDN) {
            return (C5188RDN) obj;
        }
        if (obj != null) {
            return new C5188RDN(AbstractC5093ASN1Set.getInstance(obj));
        }
        return null;
    }

    public int collectAttributeTypes(ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr, int i) {
        int iM14454size = this.f18584values.m14454size();
        for (int i2 = 0; i2 < iM14454size; i2++) {
            aSN1ObjectIdentifierArr[i + i2] = AttributeTypeAndValue.getInstance(this.f18584values.getObjectAt(i2)).m14663getType();
        }
        return iM14454size;
    }

    public boolean containsAttributeType(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        int iM14454size = this.f18584values.m14454size();
        for (int i = 0; i < iM14454size; i++) {
            if (AttributeTypeAndValue.getInstance(this.f18584values.getObjectAt(i)).m14663getType().m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                return true;
            }
        }
        return false;
    }

    public AttributeTypeAndValue getFirst() {
        if (this.f18584values.m14454size() == 0) {
            return null;
        }
        return AttributeTypeAndValue.getInstance(this.f18584values.getObjectAt(0));
    }

    public AttributeTypeAndValue[] getTypesAndValues() {
        int iM14454size = this.f18584values.m14454size();
        AttributeTypeAndValue[] attributeTypeAndValueArr = new AttributeTypeAndValue[iM14454size];
        for (int i = 0; i != iM14454size; i++) {
            attributeTypeAndValueArr[i] = AttributeTypeAndValue.getInstance(this.f18584values.getObjectAt(i));
        }
        return attributeTypeAndValueArr;
    }

    public boolean isMultiValued() {
        return this.f18584values.m14454size() > 1;
    }

    /* renamed from: size */
    public int m14664size() {
        return this.f18584values.m14454size();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18584values;
    }

    private C5188RDN(AbstractC5093ASN1Set abstractC5093ASN1Set) {
        this.f18584values = abstractC5093ASN1Set;
    }

    public static C5188RDN getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return new C5188RDN(AbstractC5093ASN1Set.getInstance(aSN1TaggedObject, z));
    }

    public C5188RDN(AttributeTypeAndValue attributeTypeAndValue) {
        this.f18584values = new C5104DERSet(attributeTypeAndValue);
    }

    public C5188RDN(AttributeTypeAndValue[] attributeTypeAndValueArr) {
        this.f18584values = new C5104DERSet(attributeTypeAndValueArr);
    }
}
