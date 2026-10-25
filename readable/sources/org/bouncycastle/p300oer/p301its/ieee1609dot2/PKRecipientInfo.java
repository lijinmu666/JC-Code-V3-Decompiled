package org.bouncycastle.p300oer.p301its.ieee1609dot2;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p300oer.p301its.ItsUtils;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.HashedId;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.HashedId8;

/* loaded from: classes2.dex */
public class PKRecipientInfo extends ASN1Object {

    /* renamed from: encKey */
    private final EncryptedDataEncryptionKey f22657encKey;
    private final HashedId8 recipientId;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.PKRecipientInfo$Builder */
    public static class C5930Builder {

        /* renamed from: encKey */
        private EncryptedDataEncryptionKey f22658encKey;
        private HashedId8 recipientId;

        public PKRecipientInfo createPKRecipientInfo() {
            return new PKRecipientInfo(this.recipientId, this.f22658encKey);
        }

        public C5930Builder setEncKey(EncryptedDataEncryptionKey encryptedDataEncryptionKey) {
            this.f22658encKey = encryptedDataEncryptionKey;
            return this;
        }

        public C5930Builder setRecipientId(HashedId8 hashedId8) {
            this.recipientId = hashedId8;
            return this;
        }
    }

    private PKRecipientInfo(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        this.recipientId = HashedId8.getInstance(aSN1Sequence.getObjectAt(0));
        this.f22657encKey = EncryptedDataEncryptionKey.getInstance(aSN1Sequence.getObjectAt(1));
    }

    /* renamed from: builder */
    public static C5930Builder m17235builder() {
        return new C5930Builder();
    }

    public static PKRecipientInfo getInstance(Object obj) {
        if (obj instanceof PKRecipientInfo) {
            return (PKRecipientInfo) obj;
        }
        if (obj != null) {
            return new PKRecipientInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public EncryptedDataEncryptionKey getEncKey() {
        return this.f22657encKey;
    }

    public HashedId getRecipientId() {
        return this.recipientId;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return ItsUtils.toSequence(this.recipientId, this.f22657encKey);
    }

    public PKRecipientInfo(HashedId8 hashedId8, EncryptedDataEncryptionKey encryptedDataEncryptionKey) {
        this.recipientId = hashedId8;
        this.f22657encKey = encryptedDataEncryptionKey;
    }
}
