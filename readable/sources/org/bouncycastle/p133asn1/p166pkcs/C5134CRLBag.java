package org.bouncycastle.p133asn1.p166pkcs;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* renamed from: org.bouncycastle.asn1.pkcs.CRLBag */
/* loaded from: classes2.dex */
public class C5134CRLBag extends ASN1Object {

    /* renamed from: crlId */
    private ASN1ObjectIdentifier f18462crlId;
    private ASN1Encodable crlValue;

    public C5134CRLBag(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f18462crlId = aSN1ObjectIdentifier;
        this.crlValue = aSN1Encodable;
    }

    public static C5134CRLBag getInstance(Object obj) {
        if (obj instanceof C5134CRLBag) {
            return (C5134CRLBag) obj;
        }
        if (obj != null) {
            return new C5134CRLBag(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1ObjectIdentifier getCrlId() {
        return this.f18462crlId;
    }

    public ASN1Encodable getCrlValue() {
        return this.crlValue;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.f18462crlId, new DERTaggedObject(0, this.crlValue));
    }

    private C5134CRLBag(ASN1Sequence aSN1Sequence) {
        this.f18462crlId = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        this.crlValue = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(1)).getExplicitBaseObject();
    }
}
