package org.bouncycastle.p300oer.p301its.ieee1609dot2;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p300oer.OEROptional;

/* loaded from: classes2.dex */
public class SignedDataPayload extends ASN1Object {

    /* renamed from: data */
    private final Ieee1609Dot2Data f22669data;
    private final HashedData extDataHash;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.SignedDataPayload$Builder */
    public static class C5936Builder {

        /* renamed from: data */
        private Ieee1609Dot2Data f22670data;
        private HashedData extDataHash;

        public SignedDataPayload createSignedDataPayload() {
            return new SignedDataPayload(this.f22670data, this.extDataHash);
        }

        /* renamed from: setData */
        public C5936Builder m17245setData(Ieee1609Dot2Data ieee1609Dot2Data) {
            this.f22670data = ieee1609Dot2Data;
            return this;
        }

        public C5936Builder setExtDataHash(HashedData hashedData) {
            this.extDataHash = hashedData;
            return this;
        }
    }

    private SignedDataPayload(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        this.f22669data = (Ieee1609Dot2Data) OEROptional.getValue(Ieee1609Dot2Data.class, aSN1Sequence.getObjectAt(0));
        this.extDataHash = (HashedData) OEROptional.getValue(HashedData.class, aSN1Sequence.getObjectAt(1));
    }

    /* renamed from: builder */
    public static C5936Builder m17243builder() {
        return new C5936Builder();
    }

    public static SignedDataPayload getInstance(Object obj) {
        if (obj instanceof SignedDataPayload) {
            return (SignedDataPayload) obj;
        }
        if (obj != null) {
            return new SignedDataPayload(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getData */
    public Ieee1609Dot2Data m17244getData() {
        return this.f22669data;
    }

    public HashedData getExtDataHash() {
        return this.extDataHash;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{OEROptional.getInstance(this.f22669data), OEROptional.getInstance(this.extDataHash)});
    }

    public SignedDataPayload(Ieee1609Dot2Data ieee1609Dot2Data, HashedData hashedData) {
        this.f22669data = ieee1609Dot2Data;
        this.extDataHash = hashedData;
    }
}
