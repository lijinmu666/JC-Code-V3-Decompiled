package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class TwoDLocation extends ASN1Object {
    private final Latitude latitude;
    private final Longitude longitude;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.TwoDLocation$Builder */
    public static class C5971Builder {
        private Latitude latitude;
        private Longitude longitude;

        public TwoDLocation createTwoDLocation() {
            return new TwoDLocation(this.latitude, this.longitude);
        }

        public C5971Builder setLatitude(Latitude latitude) {
            this.latitude = latitude;
            return this;
        }

        public C5971Builder setLongitude(Longitude longitude) {
            this.longitude = longitude;
            return this;
        }
    }

    private TwoDLocation(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        this.latitude = Latitude.getInstance((Object) aSN1Sequence.getObjectAt(0));
        this.longitude = Longitude.getInstance((Object) aSN1Sequence.getObjectAt(1));
    }

    /* renamed from: builder */
    public static C5971Builder m17345builder() {
        return new C5971Builder();
    }

    public static TwoDLocation getInstance(Object obj) {
        if (obj instanceof TwoDLocation) {
            return (TwoDLocation) obj;
        }
        if (obj != null) {
            return new TwoDLocation(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public Latitude getLatitude() {
        return this.latitude;
    }

    public Longitude getLongitude() {
        return this.longitude;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.latitude, this.longitude});
    }

    public TwoDLocation(Latitude latitude, Longitude longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
