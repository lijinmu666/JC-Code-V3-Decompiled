package org.bouncycastle.p300oer.p301its.ieee1609dot2;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p300oer.p301its.ItsUtils;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.HashedId;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.HashedId8;

/* loaded from: classes2.dex */
public class SymmRecipientInfo extends ASN1Object {

    /* renamed from: encKey */
    private final SymmetricCiphertext f22676encKey;
    private final HashedId8 recipientId;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.SymmRecipientInfo$Builder */
    public static class C5937Builder {

        /* renamed from: encKey */
        private SymmetricCiphertext f22677encKey;
        private HashedId8 recipientId;

        public SymmRecipientInfo createSymmRecipientInfo() {
            return new SymmRecipientInfo(this.recipientId, this.f22677encKey);
        }

        public C5937Builder setEncKey(SymmetricCiphertext symmetricCiphertext) {
            this.f22677encKey = symmetricCiphertext;
            return this;
        }

        public C5937Builder setRecipientId(HashedId8 hashedId8) {
            this.recipientId = hashedId8;
            return this;
        }
    }

    private SymmRecipientInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        this.recipientId = HashedId8.getInstance(aSN1Sequence.getObjectAt(0));
        this.f22676encKey = SymmetricCiphertext.getInstance(aSN1Sequence.getObjectAt(1));
    }

    /* renamed from: builder */
    public static C5937Builder m17249builder() {
        return new C5937Builder();
    }

    public static SymmRecipientInfo getInstance(Object obj) {
        if (obj instanceof SymmRecipientInfo) {
            return (SymmRecipientInfo) obj;
        }
        if (obj != null) {
            return new SymmRecipientInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public SymmetricCiphertext getEncKey() {
        return this.f22676encKey;
    }

    public HashedId getRecipientId() {
        return this.recipientId;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return ItsUtils.toSequence(this.recipientId, this.f22676encKey);
    }

    public SymmRecipientInfo(HashedId8 hashedId8, SymmetricCiphertext symmetricCiphertext) {
        this.recipientId = hashedId8;
        this.f22676encKey = symmetricCiphertext;
    }
}
