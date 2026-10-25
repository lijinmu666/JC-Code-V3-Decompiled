package org.bouncycastle.p133asn1.p166pkcs;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.DLSequence;
import org.bouncycastle.p133asn1.DLTaggedObject;

/* renamed from: org.bouncycastle.asn1.pkcs.SafeBag */
/* loaded from: classes2.dex */
public class C5138SafeBag extends ASN1Object {
    private AbstractC5093ASN1Set bagAttributes;

    /* renamed from: bagId */
    private ASN1ObjectIdentifier f18525bagId;
    private ASN1Encodable bagValue;

    public C5138SafeBag(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f18525bagId = aSN1ObjectIdentifier;
        this.bagValue = aSN1Encodable;
        this.bagAttributes = null;
    }

    public static C5138SafeBag getInstance(Object obj) {
        if (obj instanceof C5138SafeBag) {
            return (C5138SafeBag) obj;
        }
        if (obj != null) {
            return new C5138SafeBag(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AbstractC5093ASN1Set getBagAttributes() {
        return this.bagAttributes;
    }

    public ASN1ObjectIdentifier getBagId() {
        return this.f18525bagId;
    }

    public ASN1Encodable getBagValue() {
        return this.bagValue;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(this.f18525bagId);
        aSN1EncodableVector.m14420add(new DLTaggedObject(true, 0, this.bagValue));
        AbstractC5093ASN1Set abstractC5093ASN1Set = this.bagAttributes;
        if (abstractC5093ASN1Set != null) {
            aSN1EncodableVector.m14420add(abstractC5093ASN1Set);
        }
        return new DLSequence(aSN1EncodableVector);
    }

    public C5138SafeBag(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable, AbstractC5093ASN1Set abstractC5093ASN1Set) {
        this.f18525bagId = aSN1ObjectIdentifier;
        this.bagValue = aSN1Encodable;
        this.bagAttributes = abstractC5093ASN1Set;
    }

    private C5138SafeBag(ASN1Sequence aSN1Sequence) {
        this.f18525bagId = (ASN1ObjectIdentifier) aSN1Sequence.getObjectAt(0);
        this.bagValue = ((ASN1TaggedObject) aSN1Sequence.getObjectAt(1)).getExplicitBaseObject();
        if (aSN1Sequence.mo14450size() == 3) {
            this.bagAttributes = (AbstractC5093ASN1Set) aSN1Sequence.getObjectAt(2);
        }
    }
}
