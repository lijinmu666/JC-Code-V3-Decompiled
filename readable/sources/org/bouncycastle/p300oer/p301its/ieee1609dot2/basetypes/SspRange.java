package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* loaded from: classes2.dex */
public class SspRange extends ASN1Object implements ASN1Choice {

    /* renamed from: all */
    public static final int f22771all = 1;
    public static final int bitmapSspRange = 2;

    /* renamed from: opaque */
    public static final int f22772opaque = 0;

    /* renamed from: choice */
    private final int f22773choice;
    private final ASN1Encodable sspRange;

    public SspRange(int i, ASN1Encodable aSN1Encodable) {
        if (i == 0 || i == 1 || i == 2) {
            this.f22773choice = i;
            this.sspRange = aSN1Encodable;
        } else {
            throw new IllegalArgumentException("invalid choice value " + i);
        }
    }

    /* renamed from: all */
    public static SspRange m17340all() {
        return new SspRange(1, C5103DERNull.INSTANCE);
    }

    public static SspRange bitmapSspRange(BitmapSspRange bitmapSspRange2) {
        return new SspRange(2, bitmapSspRange2);
    }

    public static SspRange getInstance(Object obj) {
        if (obj instanceof SspRange) {
            return (SspRange) obj;
        }
        if (obj != null) {
            return new SspRange(ASN1TaggedObject.getContextInstance(obj));
        }
        return null;
    }

    /* renamed from: opaque */
    public static SspRange m17341opaque(SequenceOfOctetString sequenceOfOctetString) {
        return new SspRange(0, sequenceOfOctetString);
    }

    public int getChoice() {
        return this.f22773choice;
    }

    public ASN1Encodable getSspRange() {
        return this.sspRange;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.f22773choice, this.sspRange);
    }

    private SspRange(ASN1TaggedObject aSN1TaggedObject) {
        this(aSN1TaggedObject.getTagNo(), aSN1TaggedObject.getExplicitBaseObject());
    }
}
