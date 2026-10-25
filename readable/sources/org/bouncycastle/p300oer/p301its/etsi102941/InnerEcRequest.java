package org.bouncycastle.p300oer.p301its.etsi102941;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p300oer.p301its.etsi102941.basetypes.CertificateFormat;
import org.bouncycastle.p300oer.p301its.etsi102941.basetypes.CertificateSubjectAttributes;
import org.bouncycastle.p300oer.p301its.etsi102941.basetypes.PublicKeys;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class InnerEcRequest extends ASN1Object {
    private final CertificateFormat certificateFormat;

    /* renamed from: itsId */
    private final ASN1OctetString f22602itsId;
    private final PublicKeys publicKeys;
    private final CertificateSubjectAttributes requestedSubjectAttributes;

    /* renamed from: org.bouncycastle.oer.its.etsi102941.InnerEcRequest$Builder */
    public static class C5906Builder {
        private CertificateFormat certificateFormat;

        /* renamed from: itsId */
        private ASN1OctetString f22603itsId;
        private PublicKeys publicKeys;
        private CertificateSubjectAttributes requestedSubjectAttributes;

        public InnerEcRequest createInnerEcRequest() {
            return new InnerEcRequest(this.f22603itsId, this.certificateFormat, this.publicKeys, this.requestedSubjectAttributes);
        }

        public C5906Builder setCertificateFormat(CertificateFormat certificateFormat) {
            this.certificateFormat = certificateFormat;
            return this;
        }

        public C5906Builder setItsId(ASN1OctetString aSN1OctetString) {
            this.f22603itsId = aSN1OctetString;
            return this;
        }

        public C5906Builder setPublicKeys(PublicKeys publicKeys) {
            this.publicKeys = publicKeys;
            return this;
        }

        public C5906Builder setRequestedSubjectAttributes(CertificateSubjectAttributes certificateSubjectAttributes) {
            this.requestedSubjectAttributes = certificateSubjectAttributes;
            return this;
        }

        public C5906Builder setItsId(byte[] bArr) {
            this.f22603itsId = new DEROctetString(C6238Arrays.m18231clone(bArr));
            return this;
        }
    }

    public InnerEcRequest(ASN1OctetString aSN1OctetString, CertificateFormat certificateFormat, PublicKeys publicKeys, CertificateSubjectAttributes certificateSubjectAttributes) {
        this.f22602itsId = aSN1OctetString;
        this.certificateFormat = certificateFormat;
        this.publicKeys = publicKeys;
        this.requestedSubjectAttributes = certificateSubjectAttributes;
    }

    /* renamed from: builder */
    public static C5906Builder m17195builder() {
        return new C5906Builder();
    }

    public static InnerEcRequest getInstance(Object obj) {
        if (obj instanceof InnerEcRequest) {
            return (InnerEcRequest) obj;
        }
        if (obj != null) {
            return new InnerEcRequest(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CertificateFormat getCertificateFormat() {
        return this.certificateFormat;
    }

    public ASN1OctetString getItsId() {
        return this.f22602itsId;
    }

    public PublicKeys getPublicKeys() {
        return this.publicKeys;
    }

    public CertificateSubjectAttributes getRequestedSubjectAttributes() {
        return this.requestedSubjectAttributes;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.f22602itsId, this.certificateFormat, this.publicKeys, this.requestedSubjectAttributes});
    }

    private InnerEcRequest(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 4) {
            throw new IllegalArgumentException("expected sequence size of 4");
        }
        this.f22602itsId = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0));
        this.certificateFormat = CertificateFormat.getInstance(aSN1Sequence.getObjectAt(1));
        this.publicKeys = PublicKeys.getInstance(aSN1Sequence.getObjectAt(2));
        this.requestedSubjectAttributes = CertificateSubjectAttributes.getInstance(aSN1Sequence.getObjectAt(3));
    }
}
