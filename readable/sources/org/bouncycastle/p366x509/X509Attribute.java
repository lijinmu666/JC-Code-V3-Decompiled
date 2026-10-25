package org.bouncycastle.p366x509;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.C5104DERSet;
import org.bouncycastle.p133asn1.p174x509.Attribute;

/* loaded from: classes2.dex */
public class X509Attribute extends ASN1Object {

    /* renamed from: attr */
    Attribute f24285attr;

    public X509Attribute(String str, ASN1Encodable aSN1Encodable) {
        this.f24285attr = new Attribute(new ASN1ObjectIdentifier(str), new C5104DERSet(aSN1Encodable));
    }

    /* renamed from: getOID */
    public String m18392getOID() {
        return this.f24285attr.getAttrType().m14433getId();
    }

    public ASN1Encodable[] getValues() {
        AbstractC5093ASN1Set attrValues = this.f24285attr.getAttrValues();
        ASN1Encodable[] aSN1EncodableArr = new ASN1Encodable[attrValues.m14454size()];
        for (int i = 0; i != attrValues.m14454size(); i++) {
            aSN1EncodableArr[i] = attrValues.getObjectAt(i);
        }
        return aSN1EncodableArr;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f24285attr.toASN1Primitive();
    }

    public X509Attribute(String str, ASN1EncodableVector aSN1EncodableVector) {
        this.f24285attr = new Attribute(new ASN1ObjectIdentifier(str), new C5104DERSet(aSN1EncodableVector));
    }

    public X509Attribute(ASN1Encodable aSN1Encodable) {
        this.f24285attr = Attribute.getInstance(aSN1Encodable);
    }
}
