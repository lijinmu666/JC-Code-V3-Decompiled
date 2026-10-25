package org.bouncycastle.p133asn1.p139cms;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* loaded from: classes.dex */
public class OriginatorInfo extends ASN1Object {

    /* renamed from: certs */
    private AbstractC5093ASN1Set f18212certs;

    /* renamed from: crls */
    private AbstractC5093ASN1Set f18213crls;

    private OriginatorInfo(ASN1Sequence aSN1Sequence) {
        ASN1TaggedObject aSN1TaggedObject;
        int iMo14450size = aSN1Sequence.mo14450size();
        if (iMo14450size != 0) {
            if (iMo14450size == 1) {
                aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.getObjectAt(0);
                int tagNo = aSN1TaggedObject.getTagNo();
                if (tagNo == 0) {
                    this.f18212certs = AbstractC5093ASN1Set.getInstance(aSN1TaggedObject, false);
                    return;
                } else if (tagNo != 1) {
                    throw new IllegalArgumentException("Bad tag in OriginatorInfo: " + aSN1TaggedObject.getTagNo());
                }
            } else {
                if (iMo14450size != 2) {
                    throw new IllegalArgumentException("OriginatorInfo too big");
                }
                this.f18212certs = AbstractC5093ASN1Set.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(0), false);
                aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.getObjectAt(1);
            }
            this.f18213crls = AbstractC5093ASN1Set.getInstance(aSN1TaggedObject, false);
        }
    }

    public static OriginatorInfo getInstance(Object obj) {
        if (obj instanceof OriginatorInfo) {
            return (OriginatorInfo) obj;
        }
        if (obj != null) {
            return new OriginatorInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getCRLs */
    public AbstractC5093ASN1Set m14547getCRLs() {
        return this.f18213crls;
    }

    public AbstractC5093ASN1Set getCertificates() {
        return this.f18212certs;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        AbstractC5093ASN1Set abstractC5093ASN1Set = this.f18212certs;
        if (abstractC5093ASN1Set != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 0, (ASN1Encodable) abstractC5093ASN1Set));
        }
        AbstractC5093ASN1Set abstractC5093ASN1Set2 = this.f18213crls;
        if (abstractC5093ASN1Set2 != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 1, (ASN1Encodable) abstractC5093ASN1Set2));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public OriginatorInfo(AbstractC5093ASN1Set abstractC5093ASN1Set, AbstractC5093ASN1Set abstractC5093ASN1Set2) {
        this.f18212certs = abstractC5093ASN1Set;
        this.f18213crls = abstractC5093ASN1Set2;
    }

    public static OriginatorInfo getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
