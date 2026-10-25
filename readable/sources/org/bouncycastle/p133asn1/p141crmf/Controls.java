package org.bouncycastle.p133asn1.p141crmf;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class Controls extends ASN1Object {

    /* renamed from: content */
    private ASN1Sequence f18258content;

    private Controls(ASN1Sequence aSN1Sequence) {
        this.f18258content = aSN1Sequence;
    }

    public static Controls getInstance(Object obj) {
        if (obj instanceof Controls) {
            return (Controls) obj;
        }
        if (obj != null) {
            return new Controls(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18258content;
    }

    public AttributeTypeAndValue[] toAttributeTypeAndValueArray() {
        int iMo14450size = this.f18258content.mo14450size();
        AttributeTypeAndValue[] attributeTypeAndValueArr = new AttributeTypeAndValue[iMo14450size];
        for (int i = 0; i != iMo14450size; i++) {
            attributeTypeAndValueArr[i] = AttributeTypeAndValue.getInstance(this.f18258content.getObjectAt(i));
        }
        return attributeTypeAndValueArr;
    }

    public Controls(AttributeTypeAndValue attributeTypeAndValue) {
        this.f18258content = new DERSequence(attributeTypeAndValue);
    }

    public Controls(AttributeTypeAndValue[] attributeTypeAndValueArr) {
        this.f18258content = new DERSequence(attributeTypeAndValueArr);
    }
}
