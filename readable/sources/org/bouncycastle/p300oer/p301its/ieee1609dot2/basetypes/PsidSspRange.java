package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p300oer.OEROptional;

/* loaded from: classes2.dex */
public class PsidSspRange extends ASN1Object {

    /* renamed from: psid */
    private final C5954Psid f22753psid;
    private final SspRange sspRange;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.PsidSspRange$Builder */
    public static class C5956Builder {

        /* renamed from: psid */
        private C5954Psid f22754psid;
        private SspRange sspRange;

        public PsidSspRange createPsidSspRange() {
            return new PsidSspRange(this.f22754psid, this.sspRange);
        }

        /* renamed from: setPsid */
        public C5956Builder m17317setPsid(long j) {
            this.f22754psid = new C5954Psid(j);
            return this;
        }

        public C5956Builder setSspRange(SspRange sspRange) {
            this.sspRange = sspRange;
            return this;
        }

        /* renamed from: setPsid */
        public C5956Builder m17318setPsid(C5954Psid c5954Psid) {
            this.f22754psid = c5954Psid;
            return this;
        }
    }

    private PsidSspRange(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        this.f22753psid = C5954Psid.getInstance(aSN1Sequence.getObjectAt(0));
        this.sspRange = (SspRange) OEROptional.getValue(SspRange.class, aSN1Sequence.getObjectAt(1));
    }

    /* renamed from: builder */
    public static C5956Builder m17315builder() {
        return new C5956Builder();
    }

    public static PsidSspRange getInstance(Object obj) {
        if (obj instanceof PsidSspRange) {
            return (PsidSspRange) obj;
        }
        if (obj != null) {
            return new PsidSspRange(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getPsid */
    public C5954Psid m17316getPsid() {
        return this.f22753psid;
    }

    public SspRange getSspRange() {
        return this.sspRange;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.f22753psid, OEROptional.getInstance(this.sspRange)});
    }

    public PsidSspRange(C5954Psid c5954Psid, SspRange sspRange) {
        this.f22753psid = c5954Psid;
        this.sspRange = sspRange;
    }
}
