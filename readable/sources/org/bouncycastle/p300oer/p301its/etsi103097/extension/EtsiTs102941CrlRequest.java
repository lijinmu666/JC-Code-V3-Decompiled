package org.bouncycastle.p300oer.p301its.etsi103097.extension;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p300oer.OEROptional;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5969Time32;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.HashedId8;

/* loaded from: classes2.dex */
public class EtsiTs102941CrlRequest extends ASN1Object {
    private final HashedId8 issuerId;
    private final C5969Time32 lastKnownUpdate;

    /* renamed from: org.bouncycastle.oer.its.etsi103097.extension.EtsiTs102941CrlRequest$Builder */
    public static class C5918Builder {
        private HashedId8 issuerId;
        private C5969Time32 lastKnownUpdate;

        public EtsiTs102941CrlRequest createEtsiTs102941CrlRequest() {
            return new EtsiTs102941CrlRequest(this.issuerId, this.lastKnownUpdate);
        }

        public C5918Builder setIssuerId(HashedId8 hashedId8) {
            this.issuerId = hashedId8;
            return this;
        }

        public C5918Builder setLastKnownUpdate(C5969Time32 c5969Time32) {
            this.lastKnownUpdate = c5969Time32;
            return this;
        }
    }

    private EtsiTs102941CrlRequest(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        this.issuerId = HashedId8.getInstance(aSN1Sequence.getObjectAt(0));
        this.lastKnownUpdate = aSN1Sequence.mo14450size() > 1 ? (C5969Time32) OEROptional.getValue(C5969Time32.class, aSN1Sequence.getObjectAt(1)) : null;
    }

    /* renamed from: builder */
    public static C5918Builder m17212builder() {
        return new C5918Builder();
    }

    public static EtsiTs102941CrlRequest getInstance(Object obj) {
        if (obj instanceof EtsiTs102941CrlRequest) {
            return (EtsiTs102941CrlRequest) obj;
        }
        if (obj != null) {
            return new EtsiTs102941CrlRequest(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public HashedId8 getIssuerId() {
        return this.issuerId;
    }

    public C5969Time32 getLastKnownUpdate() {
        return this.lastKnownUpdate;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.issuerId, OEROptional.getInstance(this.lastKnownUpdate)});
    }

    public EtsiTs102941CrlRequest(HashedId8 hashedId8, C5969Time32 c5969Time32) {
        this.issuerId = hashedId8;
        this.lastKnownUpdate = c5969Time32;
    }
}
