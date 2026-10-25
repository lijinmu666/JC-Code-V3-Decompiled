package org.bouncycastle.p133asn1.p174x509;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
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
        return new ASN1ObjectIdentifier(this.attrType.m14433getId());
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
        if (aSN1Sequence.mo14450size() == 2) {
            this.attrType = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
            this.attrValues = AbstractC5093ASN1Set.getInstance(aSN1Sequence.getObjectAt(1));
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.mo14450size());
        }
    }
}
