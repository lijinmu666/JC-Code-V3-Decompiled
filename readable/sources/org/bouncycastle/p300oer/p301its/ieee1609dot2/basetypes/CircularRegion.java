package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p300oer.p301its.ItsUtils;

/* loaded from: classes2.dex */
public class CircularRegion extends ASN1Object implements RegionInterface {

    /* renamed from: center */
    private final TwoDLocation f22692center;

    /* renamed from: radius */
    private final C5972UINT16 f22693radius;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.CircularRegion$Builder */
    public static class C5942Builder {

        /* renamed from: center */
        private TwoDLocation f22694center;

        /* renamed from: radius */
        private C5972UINT16 f22695radius;

        public CircularRegion createCircularRegion() {
            return new CircularRegion(this.f22694center, this.f22695radius);
        }

        public C5942Builder setCenter(TwoDLocation twoDLocation) {
            this.f22694center = twoDLocation;
            return this;
        }

        public C5942Builder setRadius(C5972UINT16 c5972uint16) {
            this.f22695radius = c5972uint16;
            return this;
        }
    }

    private CircularRegion(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        this.f22692center = TwoDLocation.getInstance(aSN1Sequence.getObjectAt(0));
        this.f22693radius = C5972UINT16.getInstance(aSN1Sequence.getObjectAt(1));
    }

    /* renamed from: builder */
    public static C5942Builder m17255builder() {
        return new C5942Builder();
    }

    public static CircularRegion getInstance(Object obj) {
        if (obj instanceof CircularRegion) {
            return (CircularRegion) obj;
        }
        if (obj != null) {
            return new CircularRegion(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public TwoDLocation getCenter() {
        return this.f22692center;
    }

    public C5972UINT16 getRadius() {
        return this.f22693radius;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return ItsUtils.toSequence(this.f22692center, this.f22693radius);
    }

    public CircularRegion(TwoDLocation twoDLocation, C5972UINT16 c5972uint16) {
        this.f22692center = twoDLocation;
        this.f22693radius = c5972uint16;
    }
}
