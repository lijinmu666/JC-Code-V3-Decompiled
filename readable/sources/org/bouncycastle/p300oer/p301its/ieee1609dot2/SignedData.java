package org.bouncycastle.p300oer.p301its.ieee1609dot2;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p300oer.p301its.ItsUtils;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.HashAlgorithm;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.Signature;

/* loaded from: classes2.dex */
public class SignedData extends ASN1Object {

    /* renamed from: hashId */
    private final HashAlgorithm f22663hashId;
    private final Signature signature;

    /* renamed from: signer */
    private final SignerIdentifier f22664signer;

    /* renamed from: tbsData */
    private final ToBeSignedData f22665tbsData;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.SignedData$Builder */
    public static class C5935Builder {

        /* renamed from: hashId */
        private HashAlgorithm f22666hashId;
        private Signature signature;

        /* renamed from: signer */
        private SignerIdentifier f22667signer;

        /* renamed from: tbsData */
        private ToBeSignedData f22668tbsData;

        public SignedData createSignedData() {
            return new SignedData(this.f22666hashId, this.f22668tbsData, this.f22667signer, this.signature);
        }

        public C5935Builder setHashId(HashAlgorithm hashAlgorithm) {
            this.f22666hashId = hashAlgorithm;
            return this;
        }

        public C5935Builder setSignature(Signature signature) {
            this.signature = signature;
            return this;
        }

        public C5935Builder setSigner(SignerIdentifier signerIdentifier) {
            this.f22667signer = signerIdentifier;
            return this;
        }

        public C5935Builder setTbsData(ToBeSignedData toBeSignedData) {
            this.f22668tbsData = toBeSignedData;
            return this;
        }
    }

    private SignedData(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 4) {
            throw new IllegalArgumentException("expected sequence size of 4");
        }
        this.f22663hashId = HashAlgorithm.getInstance((Object) aSN1Sequence.getObjectAt(0));
        this.f22665tbsData = ToBeSignedData.getInstance(aSN1Sequence.getObjectAt(1));
        this.f22664signer = SignerIdentifier.getInstance(aSN1Sequence.getObjectAt(2));
        this.signature = Signature.getInstance(aSN1Sequence.getObjectAt(3));
    }

    /* renamed from: builder */
    public static C5935Builder m17242builder() {
        return new C5935Builder();
    }

    public static SignedData getInstance(Object obj) {
        if (obj instanceof SignedData) {
            return (SignedData) obj;
        }
        if (obj != null) {
            return new SignedData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public HashAlgorithm getHashId() {
        return this.f22663hashId;
    }

    public Signature getSignature() {
        return this.signature;
    }

    public SignerIdentifier getSigner() {
        return this.f22664signer;
    }

    public ToBeSignedData getTbsData() {
        return this.f22665tbsData;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return ItsUtils.toSequence(this.f22663hashId, this.f22665tbsData, this.f22664signer, this.signature);
    }

    public SignedData(HashAlgorithm hashAlgorithm, ToBeSignedData toBeSignedData, SignerIdentifier signerIdentifier, Signature signature) {
        this.f22663hashId = hashAlgorithm;
        this.f22665tbsData = toBeSignedData;
        this.f22664signer = signerIdentifier;
        this.signature = signature;
    }
}
