package org.bouncycastle.p300oer.p301its.ieee1609dot2;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p300oer.p301its.ItsUtils;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.CrlSeries;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.HashedId3;

/* loaded from: classes2.dex */
public class MissingCrlIdentifier extends ASN1Object {

    /* renamed from: cracaId */
    private final HashedId3 f22653cracaId;
    private final CrlSeries crlSeries;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.MissingCrlIdentifier$Builder */
    public static class C5928Builder {

        /* renamed from: cracaId */
        private HashedId3 f22654cracaId;
        private CrlSeries crlSeries;

        public MissingCrlIdentifier createMissingCrlIdentifier() {
            return new MissingCrlIdentifier(this.f22654cracaId, this.crlSeries);
        }

        public C5928Builder setCracaId(HashedId3 hashedId3) {
            this.f22654cracaId = hashedId3;
            return this;
        }

        public C5928Builder setCrlSeries(CrlSeries crlSeries) {
            this.crlSeries = crlSeries;
            return this;
        }
    }

    private MissingCrlIdentifier(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        this.f22653cracaId = HashedId3.getInstance(aSN1Sequence.getObjectAt(0));
        this.crlSeries = CrlSeries.getInstance((Object) aSN1Sequence.getObjectAt(1));
    }

    /* renamed from: builder */
    public static C5928Builder m17234builder() {
        return new C5928Builder();
    }

    public static MissingCrlIdentifier getInstance(Object obj) {
        if (obj instanceof MissingCrlIdentifier) {
            return (MissingCrlIdentifier) obj;
        }
        if (obj != null) {
            return new MissingCrlIdentifier(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public HashedId3 getCracaId() {
        return this.f22653cracaId;
    }

    public CrlSeries getCrlSeries() {
        return this.crlSeries;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return ItsUtils.toSequence(this.f22653cracaId, this.crlSeries);
    }

    public MissingCrlIdentifier(HashedId3 hashedId3, CrlSeries crlSeries) {
        this.f22653cracaId = hashedId3;
        this.crlSeries = crlSeries;
    }
}
