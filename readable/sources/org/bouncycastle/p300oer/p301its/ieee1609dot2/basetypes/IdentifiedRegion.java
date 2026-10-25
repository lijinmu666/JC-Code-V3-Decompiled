package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERTaggedObject;

/* loaded from: classes2.dex */
public class IdentifiedRegion extends ASN1Object implements ASN1Choice, RegionInterface {
    public static final int countryAndRegions = 1;
    public static final int countryAndSubregions = 2;
    public static final int countryOnly = 0;

    /* renamed from: choice */
    private final int f22734choice;
    private final ASN1Encodable identifiedRegion;

    public IdentifiedRegion(int i, ASN1Encodable aSN1Encodable) {
        this.f22734choice = i;
        this.identifiedRegion = aSN1Encodable;
    }

    public static IdentifiedRegion countryAndRegions(CountryAndRegions countryAndRegions2) {
        return new IdentifiedRegion(1, countryAndRegions2);
    }

    public static IdentifiedRegion countryAndSubregions(CountryAndSubregions countryAndSubregions2) {
        return new IdentifiedRegion(2, countryAndSubregions2);
    }

    public static IdentifiedRegion countryOnly(CountryOnly countryOnly2) {
        return new IdentifiedRegion(0, countryOnly2);
    }

    public static IdentifiedRegion getInstance(Object obj) {
        if (obj instanceof IdentifiedRegion) {
            return (IdentifiedRegion) obj;
        }
        if (obj != null) {
            return new IdentifiedRegion(ASN1TaggedObject.getContextInstance(obj));
        }
        return null;
    }

    public int getChoice() {
        return this.f22734choice;
    }

    public ASN1Encodable getIdentifiedRegion() {
        return this.identifiedRegion;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.f22734choice, this.identifiedRegion);
    }

    private IdentifiedRegion(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Encodable countryOnly2;
        int tagNo = aSN1TaggedObject.getTagNo();
        this.f22734choice = tagNo;
        if (tagNo == 0) {
            countryOnly2 = CountryOnly.getInstance((Object) aSN1TaggedObject.getExplicitBaseObject());
        } else if (tagNo == 1) {
            countryOnly2 = CountryAndRegions.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        } else {
            if (tagNo != 2) {
                throw new IllegalArgumentException("invalid choice value " + tagNo);
            }
            countryOnly2 = CountryAndSubregions.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        }
        this.identifiedRegion = countryOnly2;
    }
}
