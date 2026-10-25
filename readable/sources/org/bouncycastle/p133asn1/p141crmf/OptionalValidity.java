package org.bouncycastle.p133asn1.p141crmf;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p174x509.C5194Time;

/* loaded from: classes2.dex */
public class OptionalValidity extends ASN1Object {
    private C5194Time notAfter;
    private C5194Time notBefore;

    private OptionalValidity(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objects.nextElement();
            int tagNo = aSN1TaggedObject.getTagNo();
            C5194Time c5194Time = C5194Time.getInstance(aSN1TaggedObject, true);
            if (tagNo == 0) {
                this.notBefore = c5194Time;
            } else {
                this.notAfter = c5194Time;
            }
        }
    }

    public static OptionalValidity getInstance(Object obj) {
        if (obj instanceof OptionalValidity) {
            return (OptionalValidity) obj;
        }
        if (obj != null) {
            return new OptionalValidity(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public static OptionalValidity getTagged(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return new OptionalValidity(ASN1Sequence.getTagged(aSN1TaggedObject, z));
    }

    public C5194Time getNotAfter() {
        return this.notAfter;
    }

    public C5194Time getNotBefore() {
        return this.notBefore;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        C5194Time c5194Time = this.notBefore;
        if (c5194Time != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 0, (ASN1Encodable) c5194Time));
        }
        C5194Time c5194Time2 = this.notAfter;
        if (c5194Time2 != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 1, (ASN1Encodable) c5194Time2));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public OptionalValidity(C5194Time c5194Time, C5194Time c5194Time2) {
        if (c5194Time == null && c5194Time2 == null) {
            throw new IllegalArgumentException("at least one of notBefore/notAfter MUST be present.");
        }
        this.notBefore = c5194Time;
        this.notAfter = c5194Time2;
    }

    public static OptionalValidity getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return new OptionalValidity(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
