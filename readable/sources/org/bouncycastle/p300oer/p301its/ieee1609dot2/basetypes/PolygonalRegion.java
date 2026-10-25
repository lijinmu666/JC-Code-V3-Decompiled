package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p300oer.p301its.ItsUtils;

/* loaded from: classes2.dex */
public class PolygonalRegion extends ASN1Object implements RegionInterface {
    private final List<TwoDLocation> twoDLocations;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.PolygonalRegion$Builder */
    public static class C5953Builder {
        private List<TwoDLocation> locations = new ArrayList();

        public PolygonalRegion createPolygonalRegion() {
            return new PolygonalRegion(this.locations);
        }

        public C5953Builder setLocations(List<TwoDLocation> list) {
            this.locations = list;
            return this;
        }

        public C5953Builder setLocations(TwoDLocation... twoDLocationArr) {
            this.locations.addAll(Arrays.asList(twoDLocationArr));
            return this;
        }
    }

    public PolygonalRegion(List<TwoDLocation> list) {
        this.twoDLocations = Collections.unmodifiableList(list);
    }

    public static PolygonalRegion getInstance(Object obj) {
        if (obj instanceof PolygonalRegion) {
            return (PolygonalRegion) obj;
        }
        if (obj != null) {
            return new PolygonalRegion(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public List<TwoDLocation> getTwoDLocations() {
        return this.twoDLocations;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return ItsUtils.toSequence(this.twoDLocations);
    }

    private PolygonalRegion(ASN1Sequence aSN1Sequence) {
        ArrayList arrayList = new ArrayList();
        Iterator<ASN1Encodable> it = aSN1Sequence.iterator();
        while (it.hasNext()) {
            arrayList.add(TwoDLocation.getInstance(it.next()));
        }
        this.twoDLocations = Collections.unmodifiableList(arrayList);
    }
}
