package org.bouncycastle.p133asn1.p166pkcs;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* renamed from: org.bouncycastle.asn1.pkcs.CertBag */
/* loaded from: classes2.dex */
public class C5135CertBag extends ASN1Object {

    /* renamed from: certId */
    private ASN1ObjectIdentifier f18463certId;
    private ASN1Encodable certValue;

    public C5135CertBag(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f18463certId = aSN1ObjectIdentifier;
        this.certValue = aSN1Encodable;
    }

    public static C5135CertBag getInstance(Object obj) {
        if (obj instanceof C5135CertBag) {
            return (C5135CertBag) obj;
        }
        if (obj != null) {
            return new C5135CertBag(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1ObjectIdentifier getCertId() {
        return this.f18463certId;
    }

    public ASN1Encodable getCertValue() {
        return this.certValue;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.f18463certId, new DERTaggedObject(0, this.certValue));
    }

    private C5135CertBag(ASN1Sequence aSN1Sequence) {
        this.f18463certId = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        this.certValue = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(1)).getExplicitBaseObject();
    }
}
