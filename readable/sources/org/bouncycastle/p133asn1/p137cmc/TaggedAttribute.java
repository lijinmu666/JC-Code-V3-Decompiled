package org.bouncycastle.p133asn1.p137cmc;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes.dex */
public class TaggedAttribute extends ASN1Object {
    private final ASN1ObjectIdentifier attrType;
    private final AbstractC5093ASN1Set attrValues;
    private final BodyPartID bodyPartID;

    private TaggedAttribute(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 3) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.bodyPartID = BodyPartID.getInstance(aSN1Sequence.getObjectAt(0));
        this.attrType = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
        this.attrValues = AbstractC5093ASN1Set.getInstance(aSN1Sequence.getObjectAt(2));
    }

    public static TaggedAttribute getInstance(Object obj) {
        if (obj instanceof TaggedAttribute) {
            return (TaggedAttribute) obj;
        }
        if (obj != null) {
            return new TaggedAttribute(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1ObjectIdentifier getAttrType() {
        return this.attrType;
    }

    public AbstractC5093ASN1Set getAttrValues() {
        return this.attrValues;
    }

    public BodyPartID getBodyPartID() {
        return this.bodyPartID;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.bodyPartID, this.attrType, this.attrValues});
    }

    public TaggedAttribute(BodyPartID bodyPartID, ASN1ObjectIdentifier aSN1ObjectIdentifier, AbstractC5093ASN1Set abstractC5093ASN1Set) {
        this.bodyPartID = bodyPartID;
        this.attrType = aSN1ObjectIdentifier;
        this.attrValues = abstractC5093ASN1Set;
    }
}
