package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p300oer.p301its.ItsUtils;

/* loaded from: classes2.dex */
public class CountryAndRegions extends ASN1Object implements RegionInterface {
    private final CountryOnly countryOnly;

    /* renamed from: regions */
    private final SequenceOfUint8 f22696regions;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.CountryAndRegions$Builder */
    public static class C5943Builder {
        private CountryOnly countryOnly;
        private SequenceOfUint8 regionList;

        public CountryAndRegions createCountryAndRegions() {
            return new CountryAndRegions(this.countryOnly, this.regionList);
        }

        public C5943Builder setCountryOnly(CountryOnly countryOnly) {
            this.countryOnly = countryOnly;
            return this;
        }

        public C5943Builder setRegions(SequenceOfUint8 sequenceOfUint8) {
            this.regionList = sequenceOfUint8;
            return this;
        }
    }

    private CountryAndRegions(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        this.countryOnly = CountryOnly.getInstance((Object) aSN1Sequence.getObjectAt(0));
        this.f22696regions = SequenceOfUint8.getInstance(aSN1Sequence.getObjectAt(1));
    }

    /* renamed from: builder */
    public static C5943Builder m17256builder() {
        return new C5943Builder();
    }

    public static CountryAndRegions getInstance(Object obj) {
        if (obj instanceof CountryAndRegions) {
            return (CountryAndRegions) obj;
        }
        if (obj != null) {
            return new CountryAndRegions(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CountryOnly getCountryOnly() {
        return this.countryOnly;
    }

    public SequenceOfUint8 getRegions() {
        return this.f22696regions;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return ItsUtils.toSequence(this.countryOnly, this.f22696regions);
    }

    public CountryAndRegions(CountryOnly countryOnly, SequenceOfUint8 sequenceOfUint8) {
        this.countryOnly = countryOnly;
        this.f22696regions = SequenceOfUint8.getInstance(sequenceOfUint8);
    }
}
