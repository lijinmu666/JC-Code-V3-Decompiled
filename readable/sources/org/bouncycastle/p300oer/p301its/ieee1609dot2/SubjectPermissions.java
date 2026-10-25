package org.bouncycastle.p300oer.p301its.ieee1609dot2;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Null;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.SequenceOfPsidSspRange;

/* loaded from: classes2.dex */
public class SubjectPermissions extends ASN1Object implements ASN1Choice {

    /* renamed from: all */
    public static final int f22674all = 1;
    public static final int explicit = 0;

    /* renamed from: choice */
    private final int f22675choice;
    private final ASN1Encodable subjectPermissions;

    public SubjectPermissions(int i, ASN1Encodable aSN1Encodable) {
        this.subjectPermissions = aSN1Encodable;
        this.f22675choice = i;
    }

    /* renamed from: all */
    public static SubjectPermissions m17248all() {
        return new SubjectPermissions(1, C5103DERNull.INSTANCE);
    }

    public static SubjectPermissions explicit(SequenceOfPsidSspRange sequenceOfPsidSspRange) {
        return new SubjectPermissions(0, sequenceOfPsidSspRange);
    }

    public static SubjectPermissions getInstance(Object obj) {
        if (obj instanceof SubjectPermissions) {
            return (SubjectPermissions) obj;
        }
        if (obj != null) {
            return new SubjectPermissions(ASN1TaggedObject.getContextInstance(obj));
        }
        return null;
    }

    public int getChoice() {
        return this.f22675choice;
    }

    public ASN1Encodable getSubjectPermissions() {
        return this.subjectPermissions;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.f22675choice, this.subjectPermissions);
    }

    private SubjectPermissions(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Encodable sequenceOfPsidSspRange;
        int tagNo = aSN1TaggedObject.getTagNo();
        this.f22675choice = tagNo;
        if (tagNo == 0) {
            sequenceOfPsidSspRange = SequenceOfPsidSspRange.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        } else {
            if (tagNo != 1) {
                throw new IllegalArgumentException("invalid choice value " + tagNo);
            }
            sequenceOfPsidSspRange = ASN1Null.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        }
        this.subjectPermissions = sequenceOfPsidSspRange;
    }
}
