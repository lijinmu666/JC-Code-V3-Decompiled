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
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.HashedId8;

/* loaded from: classes2.dex */
public class SharedAtRequest extends ASN1Object {
    private final CertificateFormat certificateFormat;

    /* renamed from: eaId */
    private final HashedId8 f22606eaId;

    /* renamed from: keyTag */
    private final ASN1OctetString f22607keyTag;
    private final CertificateSubjectAttributes requestedSubjectAttributes;

    /* renamed from: org.bouncycastle.oer.its.etsi102941.SharedAtRequest$Builder */
    public static class C5911Builder {
        private CertificateFormat certificateFormat;

        /* renamed from: eaId */
        private HashedId8 f22608eaId;

        /* renamed from: keyTag */
        private ASN1OctetString f22609keyTag;
        private CertificateSubjectAttributes requestedSubjectAttributes;

        public SharedAtRequest createSharedAtRequest() {
            return new SharedAtRequest(this.f22608eaId, this.f22609keyTag, this.certificateFormat, this.requestedSubjectAttributes);
        }

        public C5911Builder setCertificateFormat(CertificateFormat certificateFormat) {
            this.certificateFormat = certificateFormat;
            return this;
        }

        /* renamed from: setEaId */
        public C5911Builder m17204setEaId(HashedId8 hashedId8) {
            this.f22608eaId = hashedId8;
            return this;
        }

        public C5911Builder setKeyTag(ASN1OctetString aSN1OctetString) {
            this.f22609keyTag = aSN1OctetString;
            return this;
        }

        public C5911Builder setRequestedSubjectAttributes(CertificateSubjectAttributes certificateSubjectAttributes) {
            this.requestedSubjectAttributes = certificateSubjectAttributes;
            return this;
        }

        public C5911Builder setKeyTag(byte[] bArr) {
            this.f22609keyTag = new DEROctetString(bArr);
            return this;
        }
    }

    private SharedAtRequest(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 4) {
            throw new IllegalArgumentException("expected sequence size of 4");
        }
        this.f22606eaId = HashedId8.getInstance(aSN1Sequence.getObjectAt(0));
        this.f22607keyTag = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1));
        this.certificateFormat = CertificateFormat.getInstance(aSN1Sequence.getObjectAt(2));
        this.requestedSubjectAttributes = CertificateSubjectAttributes.getInstance(aSN1Sequence.getObjectAt(3));
    }

    /* renamed from: builder */
    public static C5911Builder m17202builder() {
        return new C5911Builder();
    }

    public static SharedAtRequest getInstance(Object obj) {
        if (obj instanceof SharedAtRequest) {
            return (SharedAtRequest) obj;
        }
        if (obj != null) {
            return new SharedAtRequest(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CertificateFormat getCertificateFormat() {
        return this.certificateFormat;
    }

    /* renamed from: getEaId */
    public HashedId8 m17203getEaId() {
        return this.f22606eaId;
    }

    public ASN1OctetString getKeyTag() {
        return this.f22607keyTag;
    }

    public CertificateSubjectAttributes getRequestedSubjectAttributes() {
        return this.requestedSubjectAttributes;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.f22606eaId, this.f22607keyTag, this.certificateFormat, this.requestedSubjectAttributes});
    }

    public SharedAtRequest(HashedId8 hashedId8, ASN1OctetString aSN1OctetString, CertificateFormat certificateFormat, CertificateSubjectAttributes certificateSubjectAttributes) {
        this.f22606eaId = hashedId8;
        this.f22607keyTag = aSN1OctetString;
        this.certificateFormat = certificateFormat;
        this.requestedSubjectAttributes = certificateSubjectAttributes;
    }
}
