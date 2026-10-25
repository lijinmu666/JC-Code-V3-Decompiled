package org.bouncycastle.p133asn1.p137cmc;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes.dex */
public class BodyPartList extends ASN1Object {
    private final BodyPartID[] bodyPartIDs;

    private BodyPartList(ASN1Sequence aSN1Sequence) {
        this.bodyPartIDs = C5111Utils.toBodyPartIDArray(aSN1Sequence);
    }

    public static BodyPartList getInstance(Object obj) {
        if (obj instanceof BodyPartList) {
            return (BodyPartList) obj;
        }
        if (obj != null) {
            return new BodyPartList(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BodyPartID[] getBodyPartIDs() {
        return C5111Utils.m14498clone(this.bodyPartIDs);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.bodyPartIDs);
    }

    public BodyPartList(BodyPartID bodyPartID) {
        this.bodyPartIDs = new BodyPartID[]{bodyPartID};
    }

    public static BodyPartList getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public BodyPartList(BodyPartID[] bodyPartIDArr) {
        this.bodyPartIDs = C5111Utils.m14498clone(bodyPartIDArr);
    }
}
