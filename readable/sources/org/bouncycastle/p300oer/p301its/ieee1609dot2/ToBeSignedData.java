package org.bouncycastle.p300oer.p301its.ieee1609dot2;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class ToBeSignedData extends ASN1Object {
    private final HeaderInfo headerInfo;

    /* renamed from: payload */
    private final SignedDataPayload f22685payload;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.ToBeSignedData$Builder */
    public static class C5939Builder {
        private HeaderInfo headerInfo;

        /* renamed from: payload */
        private SignedDataPayload f22686payload;

        public ToBeSignedData createToBeSignedData() {
            return new ToBeSignedData(this.f22686payload, this.headerInfo);
        }

        public C5939Builder setHeaderInfo(HeaderInfo headerInfo) {
            this.headerInfo = headerInfo;
            return this;
        }

        public C5939Builder setPayload(SignedDataPayload signedDataPayload) {
            this.f22686payload = signedDataPayload;
            return this;
        }
    }

    private ToBeSignedData(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        this.f22685payload = SignedDataPayload.getInstance(aSN1Sequence.getObjectAt(0));
        this.headerInfo = HeaderInfo.getInstance(aSN1Sequence.getObjectAt(1));
    }

    /* renamed from: builder */
    public static C5939Builder m17253builder() {
        return new C5939Builder();
    }

    public static ToBeSignedData getInstance(Object obj) {
        if (obj instanceof ToBeSignedData) {
            return (ToBeSignedData) obj;
        }
        if (obj != null) {
            return new ToBeSignedData(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public HeaderInfo getHeaderInfo() {
        return this.headerInfo;
    }

    public SignedDataPayload getPayload() {
        return this.f22685payload;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.f22685payload, this.headerInfo});
    }

    public ToBeSignedData(SignedDataPayload signedDataPayload, HeaderInfo headerInfo) {
        this.f22685payload = signedDataPayload;
        this.headerInfo = headerInfo;
    }
}
