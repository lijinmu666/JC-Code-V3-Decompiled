package org.bouncycastle.p133asn1.p174x509;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* loaded from: classes2.dex */
public class OtherName extends ASN1Object {

    /* renamed from: typeID */
    private final ASN1ObjectIdentifier f18670typeID;

    /* renamed from: value */
    private final ASN1Encodable f18671value;

    public OtherName(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f18670typeID = aSN1ObjectIdentifier;
        this.f18671value = aSN1Encodable;
    }

    public static OtherName getInstance(Object obj) {
        if (obj instanceof OtherName) {
            return (OtherName) obj;
        }
        if (obj != null) {
            return new OtherName(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1ObjectIdentifier getTypeID() {
        return this.f18670typeID;
    }

    public ASN1Encodable getValue() {
        return this.f18671value;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.f18670typeID, new DERTaggedObject(true, 0, this.f18671value));
    }

    private OtherName(ASN1Sequence aSN1Sequence) {
        this.f18670typeID = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        this.f18671value = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(1)).getExplicitBaseObject();
    }
}
