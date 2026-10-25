package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p300oer.p301its.ItsUtils;

/* loaded from: classes2.dex */
public class PublicEncryptionKey extends ASN1Object {
    private final BasePublicEncryptionKey publicKey;
    private final SymmAlgorithm supportedSymmAlg;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.PublicEncryptionKey$Builder */
    public static class C5957Builder {
        private BasePublicEncryptionKey publicKey;
        private SymmAlgorithm supportedSymmAlg;

        public PublicEncryptionKey createPublicEncryptionKey() {
            return new PublicEncryptionKey(this.supportedSymmAlg, this.publicKey);
        }

        public C5957Builder setPublicKey(BasePublicEncryptionKey basePublicEncryptionKey) {
            this.publicKey = basePublicEncryptionKey;
            return this;
        }

        public C5957Builder setSupportedSymmAlg(SymmAlgorithm symmAlgorithm) {
            this.supportedSymmAlg = symmAlgorithm;
            return this;
        }
    }

    private PublicEncryptionKey(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        this.supportedSymmAlg = SymmAlgorithm.getInstance((Object) aSN1Sequence.getObjectAt(0));
        this.publicKey = BasePublicEncryptionKey.getInstance(aSN1Sequence.getObjectAt(1));
    }

    /* renamed from: builder */
    public static C5957Builder m17319builder() {
        return new C5957Builder();
    }

    public static PublicEncryptionKey getInstance(Object obj) {
        if (obj instanceof PublicEncryptionKey) {
            return (PublicEncryptionKey) obj;
        }
        if (obj != null) {
            return new PublicEncryptionKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BasePublicEncryptionKey getPublicKey() {
        return this.publicKey;
    }

    public SymmAlgorithm getSupportedSymmAlg() {
        return this.supportedSymmAlg;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return ItsUtils.toSequence(this.supportedSymmAlg, this.publicKey);
    }

    public PublicEncryptionKey(SymmAlgorithm symmAlgorithm, BasePublicEncryptionKey basePublicEncryptionKey) {
        this.supportedSymmAlg = symmAlgorithm;
        this.publicKey = basePublicEncryptionKey;
    }
}
