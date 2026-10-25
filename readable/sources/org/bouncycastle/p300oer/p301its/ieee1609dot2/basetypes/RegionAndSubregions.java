package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p300oer.p301its.ItsUtils;

/* loaded from: classes2.dex */
public class RegionAndSubregions extends ASN1Object implements RegionInterface {

    /* renamed from: region */
    private final C5976UINT8 f22757region;
    private final SequenceOfUint16 subregions;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.RegionAndSubregions$Builder */
    public static class C5960Builder {

        /* renamed from: region */
        private C5976UINT8 f22758region;
        private SequenceOfUint16 subRegions;

        public RegionAndSubregions createRegionAndSubregions() {
            return new RegionAndSubregions(this.f22758region, this.subRegions);
        }

        public C5960Builder setRegion(C5976UINT8 c5976uint8) {
            this.f22758region = c5976uint8;
            return this;
        }

        public C5960Builder setSubregions(SequenceOfUint16 sequenceOfUint16) {
            this.subRegions = sequenceOfUint16;
            return this;
        }
    }

    private RegionAndSubregions(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        this.f22757region = C5976UINT8.getInstance(aSN1Sequence.getObjectAt(0));
        this.subregions = SequenceOfUint16.getInstance(aSN1Sequence.getObjectAt(1));
    }

    /* renamed from: builder */
    public static C5960Builder m17322builder() {
        return new C5960Builder();
    }

    public static RegionAndSubregions getInstance(Object obj) {
        if (obj instanceof RegionAndSubregions) {
            return (RegionAndSubregions) obj;
        }
        if (obj != null) {
            return new RegionAndSubregions(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public C5976UINT8 getRegion() {
        return this.f22757region;
    }

    public SequenceOfUint16 getSubregions() {
        return this.subregions;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return ItsUtils.toSequence(this.f22757region, this.subregions);
    }

    public RegionAndSubregions(C5976UINT8 c5976uint8, SequenceOfUint16 sequenceOfUint16) {
        this.f22757region = c5976uint8;
        this.subregions = sequenceOfUint16;
    }
}
