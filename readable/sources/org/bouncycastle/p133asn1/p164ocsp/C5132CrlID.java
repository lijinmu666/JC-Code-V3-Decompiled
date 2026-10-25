package org.bouncycastle.p133asn1.p164ocsp;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1GeneralizedTime;
import org.bouncycastle.p133asn1.ASN1IA5String;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERIA5String;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* renamed from: org.bouncycastle.asn1.ocsp.CrlID */
/* loaded from: classes2.dex */
public class C5132CrlID extends ASN1Object {

    /* renamed from: crlNum */
    private ASN1Integer f18438crlNum;

    /* renamed from: crlTime */
    private ASN1GeneralizedTime f18439crlTime;

    /* renamed from: crlUrl */
    private ASN1IA5String f18440crlUrl;

    private C5132CrlID(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objects.nextElement();
            int tagNo = aSN1TaggedObject.getTagNo();
            if (tagNo == 0) {
                this.f18440crlUrl = ASN1IA5String.getInstance(aSN1TaggedObject, true);
            } else if (tagNo == 1) {
                this.f18438crlNum = ASN1Integer.getInstance(aSN1TaggedObject, true);
            } else {
                if (tagNo != 2) {
                    throw new IllegalArgumentException("unknown tag number: " + aSN1TaggedObject.getTagNo());
                }
                this.f18439crlTime = ASN1GeneralizedTime.getInstance(aSN1TaggedObject, true);
            }
        }
    }

    public static C5132CrlID getInstance(Object obj) {
        if (obj instanceof C5132CrlID) {
            return (C5132CrlID) obj;
        }
        if (obj != null) {
            return new C5132CrlID(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Integer getCrlNum() {
        return this.f18438crlNum;
    }

    public ASN1GeneralizedTime getCrlTime() {
        return this.f18439crlTime;
    }

    public DERIA5String getCrlUrl() {
        ASN1IA5String aSN1IA5String = this.f18440crlUrl;
        return (aSN1IA5String == null || (aSN1IA5String instanceof DERIA5String)) ? (DERIA5String) aSN1IA5String : new DERIA5String(this.f18440crlUrl.getString(), false);
    }

    public ASN1IA5String getCrlUrlIA5() {
        return this.f18440crlUrl;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        ASN1IA5String aSN1IA5String = this.f18440crlUrl;
        if (aSN1IA5String != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 0, (ASN1Encodable) aSN1IA5String));
        }
        ASN1Integer aSN1Integer = this.f18438crlNum;
        if (aSN1Integer != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 1, (ASN1Encodable) aSN1Integer));
        }
        ASN1GeneralizedTime aSN1GeneralizedTime = this.f18439crlTime;
        if (aSN1GeneralizedTime != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 2, (ASN1Encodable) aSN1GeneralizedTime));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
