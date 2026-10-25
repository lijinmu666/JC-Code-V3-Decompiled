package org.bouncycastle.p300oer.p301its.etsi102941;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p300oer.OEROptional;
import org.bouncycastle.p300oer.p301its.etsi103097.EtsiTs103097Certificate;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class InnerEcResponse extends ASN1Object {
    private final EtsiTs103097Certificate certificate;
    private final ASN1OctetString requestHash;
    private final EnrolmentResponseCode responseCode;

    /* renamed from: org.bouncycastle.oer.its.etsi102941.InnerEcResponse$Builder */
    public static class C5907Builder {
        private EtsiTs103097Certificate certificate;
        private ASN1OctetString requestHash;
        private EnrolmentResponseCode responseCode;

        public InnerEcResponse createInnerEcResponse() {
            return new InnerEcResponse(this.requestHash, this.responseCode, this.certificate);
        }

        public C5907Builder setCertificate(EtsiTs103097Certificate etsiTs103097Certificate) {
            this.certificate = etsiTs103097Certificate;
            return this;
        }

        public C5907Builder setRequestHash(ASN1OctetString aSN1OctetString) {
            this.requestHash = aSN1OctetString;
            return this;
        }

        public C5907Builder setResponseCode(EnrolmentResponseCode enrolmentResponseCode) {
            this.responseCode = enrolmentResponseCode;
            return this;
        }

        public C5907Builder setRequestHash(byte[] bArr) {
            this.requestHash = new DEROctetString(C6238Arrays.m18231clone(bArr));
            return this;
        }
    }

    public InnerEcResponse(ASN1OctetString aSN1OctetString, EnrolmentResponseCode enrolmentResponseCode, EtsiTs103097Certificate etsiTs103097Certificate) {
        this.requestHash = aSN1OctetString;
        this.responseCode = enrolmentResponseCode;
        this.certificate = etsiTs103097Certificate;
    }

    /* renamed from: builder */
    public static C5907Builder m17196builder() {
        return new C5907Builder();
    }

    public static InnerEcResponse getInstance(Object obj) {
        if (obj instanceof InnerEcResponse) {
            return (InnerEcResponse) obj;
        }
        if (obj != null) {
            return new InnerEcResponse(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public EtsiTs103097Certificate getCertificate() {
        return this.certificate;
    }

    public ASN1OctetString getRequestHash() {
        return this.requestHash;
    }

    public EnrolmentResponseCode getResponseCode() {
        return this.responseCode;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.requestHash, this.responseCode, OEROptional.getInstance(this.certificate)});
    }

    private InnerEcResponse(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 3) {
            throw new IllegalArgumentException("expected sequence size of 3");
        }
        this.requestHash = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0));
        this.responseCode = EnrolmentResponseCode.getInstance((Object) aSN1Sequence.getObjectAt(1));
        this.certificate = (EtsiTs103097Certificate) OEROptional.getValue(EtsiTs103097Certificate.class, aSN1Sequence.getObjectAt(2));
    }
}
