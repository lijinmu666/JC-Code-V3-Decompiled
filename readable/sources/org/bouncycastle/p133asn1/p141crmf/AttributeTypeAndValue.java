package org.bouncycastle.p133asn1.p141crmf;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class AttributeTypeAndValue extends ASN1Object {

    /* renamed from: type */
    private ASN1ObjectIdentifier f18241type;

    /* renamed from: value */
    private ASN1Encodable f18242value;

    public AttributeTypeAndValue(String str, ASN1Encodable aSN1Encodable) {
        this(new ASN1ObjectIdentifier(str), aSN1Encodable);
    }

    public static AttributeTypeAndValue getInstance(Object obj) {
        if (obj instanceof AttributeTypeAndValue) {
            return (AttributeTypeAndValue) obj;
        }
        if (obj != null) {
            return new AttributeTypeAndValue(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getType */
    public ASN1ObjectIdentifier m14561getType() {
        return this.f18241type;
    }

    public ASN1Encodable getValue() {
        return this.f18242value;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.f18241type, this.f18242value);
    }

    public AttributeTypeAndValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f18241type = aSN1ObjectIdentifier;
        this.f18242value = aSN1Encodable;
    }

    private AttributeTypeAndValue(ASN1Sequence aSN1Sequence) {
        this.f18241type = (ASN1ObjectIdentifier) aSN1Sequence.getObjectAt(0);
        this.f18242value = aSN1Sequence.getObjectAt(1);
    }
}
