package org.bouncycastle.p300oer.p301its.etsi102941;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.SequenceOfHashedId8;

/* renamed from: org.bouncycastle.oer.its.etsi102941.DcEntry */
/* loaded from: classes2.dex */
public class C5900DcEntry extends ASN1Object {

    /* renamed from: cert */
    private final SequenceOfHashedId8 f22592cert;

    /* renamed from: url */
    private final C5915Url f22593url;

    /* renamed from: org.bouncycastle.oer.its.etsi102941.DcEntry$Builder */
    public static class Builder {

        /* renamed from: cert */
        private SequenceOfHashedId8 f22594cert;

        /* renamed from: url */
        private C5915Url f22595url;

        public C5900DcEntry createDcEntry() {
            return new C5900DcEntry(this.f22595url, this.f22594cert);
        }

        /* renamed from: setCert */
        public Builder m17190setCert(SequenceOfHashedId8 sequenceOfHashedId8) {
            this.f22594cert = sequenceOfHashedId8;
            return this;
        }

        /* renamed from: setUrl */
        public Builder m17191setUrl(C5915Url c5915Url) {
            this.f22595url = c5915Url;
            return this;
        }
    }

    private C5900DcEntry(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        this.f22593url = C5915Url.getInstance(aSN1Sequence.getObjectAt(0));
        this.f22592cert = SequenceOfHashedId8.getInstance(aSN1Sequence.getObjectAt(1));
    }

    /* renamed from: builder */
    public static Builder m17187builder() {
        return new Builder();
    }

    public static C5900DcEntry getInstance(Object obj) {
        if (obj instanceof C5900DcEntry) {
            return (C5900DcEntry) obj;
        }
        if (obj != null) {
            return new C5900DcEntry(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getCert */
    public SequenceOfHashedId8 m17188getCert() {
        return this.f22592cert;
    }

    /* renamed from: getUrl */
    public C5915Url m17189getUrl() {
        return this.f22593url;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.f22593url, this.f22592cert});
    }

    public C5900DcEntry(C5915Url c5915Url, SequenceOfHashedId8 sequenceOfHashedId8) {
        this.f22593url = c5915Url;
        this.f22592cert = sequenceOfHashedId8;
    }
}
