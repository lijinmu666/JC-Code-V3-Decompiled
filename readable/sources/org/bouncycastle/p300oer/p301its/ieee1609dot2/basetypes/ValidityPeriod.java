package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class ValidityPeriod extends ASN1Object {
    private final Duration duration;

    /* renamed from: start */
    private final C5969Time32 f22781start;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.ValidityPeriod$Builder */
    public static class C5977Builder {
        private Duration duration;

        /* renamed from: start */
        private C5969Time32 f22782start;

        public ValidityPeriod createValidityPeriod() {
            return new ValidityPeriod(this.f22782start, this.duration);
        }

        public C5977Builder setDuration(Duration duration) {
            this.duration = duration;
            return this;
        }

        public C5977Builder setStart(C5969Time32 c5969Time32) {
            this.f22782start = c5969Time32;
            return this;
        }
    }

    private ValidityPeriod(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        this.f22781start = C5969Time32.getInstance((Object) aSN1Sequence.getObjectAt(0));
        this.duration = Duration.getInstance(aSN1Sequence.getObjectAt(1));
    }

    /* renamed from: builder */
    public static C5977Builder m17347builder() {
        return new C5977Builder();
    }

    public static ValidityPeriod getInstance(Object obj) {
        if (obj instanceof ValidityPeriod) {
            return (ValidityPeriod) obj;
        }
        if (obj != null) {
            return new ValidityPeriod(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public Duration getDuration() {
        return this.duration;
    }

    public C5969Time32 getStart() {
        return this.f22781start;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.f22781start, this.duration});
    }

    public String toString() {
        return "ValidityPeriod[" + this.f22781start + " " + this.duration + "]";
    }

    public ValidityPeriod(C5969Time32 c5969Time32, Duration duration) {
        this.f22781start = c5969Time32;
        this.duration = duration;
    }
}
