package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class CountryAndSubregions extends ASN1Object {

    /* renamed from: country */
    private final CountryOnly f22697country;
    private final SequenceOfRegionAndSubregions regionAndSubregions;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.CountryAndSubregions$Builder */
    public static class C5944Builder {

        /* renamed from: country */
        private CountryOnly f22698country;
        private SequenceOfRegionAndSubregions regionAndSubregions;

        public CountryAndSubregions createCountryAndSubregions() {
            return new CountryAndSubregions(this.f22698country, this.regionAndSubregions);
        }

        public C5944Builder setCountry(CountryOnly countryOnly) {
            this.f22698country = countryOnly;
            return this;
        }

        public C5944Builder setRegionAndSubregions(SequenceOfRegionAndSubregions sequenceOfRegionAndSubregions) {
            this.regionAndSubregions = sequenceOfRegionAndSubregions;
            return this;
        }
    }

    private CountryAndSubregions(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        this.f22697country = CountryOnly.getInstance((Object) aSN1Sequence.getObjectAt(0));
        this.regionAndSubregions = SequenceOfRegionAndSubregions.getInstance(aSN1Sequence.getObjectAt(1));
    }

    /* renamed from: builder */
    public static C5944Builder m17257builder() {
        return new C5944Builder();
    }

    public static CountryAndSubregions getInstance(Object obj) {
        if (obj instanceof CountryAndSubregions) {
            return (CountryAndSubregions) obj;
        }
        if (obj != null) {
            return new CountryAndSubregions(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CountryOnly getCountry() {
        return this.f22697country;
    }

    public SequenceOfRegionAndSubregions getRegionAndSubregions() {
        return this.regionAndSubregions;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.f22697country, this.regionAndSubregions});
    }

    public CountryAndSubregions(CountryOnly countryOnly, SequenceOfRegionAndSubregions sequenceOfRegionAndSubregions) {
        this.f22697country = countryOnly;
        this.regionAndSubregions = sequenceOfRegionAndSubregions;
    }
}
