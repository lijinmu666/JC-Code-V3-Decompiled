package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class RectangularRegion extends ASN1Object implements RegionInterface {
    private final TwoDLocation northWest;
    private final TwoDLocation southEast;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.RectangularRegion$Builder */
    public static class C5959Builder {
        private TwoDLocation northWest;
        private TwoDLocation southEast;

        public RectangularRegion createRectangularRegion() {
            return new RectangularRegion(this.northWest, this.southEast);
        }

        public C5959Builder setNorthWest(TwoDLocation twoDLocation) {
            this.northWest = twoDLocation;
            return this;
        }

        public C5959Builder setSouthEast(TwoDLocation twoDLocation) {
            this.southEast = twoDLocation;
            return this;
        }
    }

    private RectangularRegion(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        this.northWest = TwoDLocation.getInstance(aSN1Sequence.getObjectAt(0));
        this.southEast = TwoDLocation.getInstance(aSN1Sequence.getObjectAt(1));
    }

    /* renamed from: builder */
    public static C5959Builder m17321builder() {
        return new C5959Builder();
    }

    public static RectangularRegion getInstance(Object obj) {
        if (obj instanceof RectangularRegion) {
            return (RectangularRegion) obj;
        }
        if (obj != null) {
            return new RectangularRegion(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public TwoDLocation getNorthWest() {
        return this.northWest;
    }

    public TwoDLocation getSouthEast() {
        return this.southEast;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.northWest, this.southEast});
    }

    public RectangularRegion(TwoDLocation twoDLocation, TwoDLocation twoDLocation2) {
        this.northWest = twoDLocation;
        this.southEast = twoDLocation2;
    }
}
