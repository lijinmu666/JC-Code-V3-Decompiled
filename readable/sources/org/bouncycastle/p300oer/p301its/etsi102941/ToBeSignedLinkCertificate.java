package org.bouncycastle.p300oer.p301its.etsi102941;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.HashedData;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5969Time32;

/* loaded from: classes2.dex */
public class ToBeSignedLinkCertificate extends ASN1Object {
    private final HashedData certificateHash;
    private final C5969Time32 expiryTime;

    /* renamed from: org.bouncycastle.oer.its.etsi102941.ToBeSignedLinkCertificate$Builder */
    public static class C5914Builder {
        private HashedData certificateHash;
        private C5969Time32 expiryTime;

        public ToBeSignedLinkCertificate createToBeSignedLinkCertificate() {
            return new ToBeSignedLinkCertificate(this.expiryTime, this.certificateHash);
        }

        public ToBeSignedLinkCertificateRca createToBeSignedLinkCertificateRca() {
            return new ToBeSignedLinkCertificateRca(this.expiryTime, this.certificateHash);
        }

        public ToBeSignedLinkCertificateTlm createToBeSignedLinkCertificateTlm() {
            return new ToBeSignedLinkCertificateTlm(this.expiryTime, this.certificateHash);
        }

        public C5914Builder setCertificateHash(HashedData hashedData) {
            this.certificateHash = hashedData;
            return this;
        }

        public C5914Builder setExpiryTime(C5969Time32 c5969Time32) {
            this.expiryTime = c5969Time32;
            return this;
        }
    }

    public ToBeSignedLinkCertificate(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        this.expiryTime = C5969Time32.getInstance((Object) aSN1Sequence.getObjectAt(0));
        this.certificateHash = HashedData.getInstance(aSN1Sequence.getObjectAt(1));
    }

    /* renamed from: builder */
    public static C5914Builder m17207builder() {
        return new C5914Builder();
    }

    public static ToBeSignedLinkCertificate getInstance(Object obj) {
        if (obj instanceof ToBeSignedLinkCertificate) {
            return (ToBeSignedLinkCertificate) obj;
        }
        if (obj != null) {
            return new ToBeSignedLinkCertificate(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public HashedData getCertificateHash() {
        return this.certificateHash;
    }

    public C5969Time32 getExpiryTime() {
        return this.expiryTime;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.expiryTime, this.certificateHash});
    }

    public ToBeSignedLinkCertificate(C5969Time32 c5969Time32, HashedData hashedData) {
        this.expiryTime = c5969Time32;
        this.certificateHash = hashedData;
    }
}
