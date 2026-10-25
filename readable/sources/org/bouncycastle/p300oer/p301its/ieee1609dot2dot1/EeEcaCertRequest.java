package org.bouncycastle.p300oer.p301its.ieee1609dot2dot1;

import org.bouncycastle.p133asn1.ASN1IA5String;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERIA5String;
import org.bouncycastle.p300oer.OEROptional;
import org.bouncycastle.p300oer.p301its.ItsUtils;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.CertificateType;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.ToBeSignedCertificate;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5969Time32;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5976UINT8;

/* loaded from: classes2.dex */
public class EeEcaCertRequest extends ASN1Object {
    private final ASN1IA5String canonicalId;
    private final C5969Time32 generationTime;

    /* renamed from: tbsCert */
    private final ToBeSignedCertificate f22787tbsCert;

    /* renamed from: type */
    private final CertificateType f22788type;

    /* renamed from: version */
    private final C5976UINT8 f22789version;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2dot1.EeEcaCertRequest$Builder */
    public static class C5979Builder {
        private DERIA5String canonicalId;
        private C5969Time32 generationTime;

        /* renamed from: tbsCert */
        private ToBeSignedCertificate f22790tbsCert;

        /* renamed from: type */
        private CertificateType f22791type;

        /* renamed from: version */
        private C5976UINT8 f22792version;

        public EeEcaCertRequest createEeEcaCertRequest() {
            return new EeEcaCertRequest(this.f22792version, this.generationTime, this.f22791type, this.f22790tbsCert, this.canonicalId);
        }

        public C5979Builder setCanonicalId(String str) {
            this.canonicalId = new DERIA5String(str);
            return this;
        }

        public C5979Builder setGenerationTime(C5969Time32 c5969Time32) {
            this.generationTime = c5969Time32;
            return this;
        }

        public C5979Builder setTbsCert(ToBeSignedCertificate toBeSignedCertificate) {
            this.f22790tbsCert = toBeSignedCertificate;
            return this;
        }

        /* renamed from: setType */
        public C5979Builder m17354setType(CertificateType certificateType) {
            this.f22791type = certificateType;
            return this;
        }

        public C5979Builder setVersion(C5976UINT8 c5976uint8) {
            this.f22792version = c5976uint8;
            return this;
        }

        public C5979Builder setCanonicalId(DERIA5String dERIA5String) {
            this.canonicalId = dERIA5String;
            return this;
        }
    }

    private EeEcaCertRequest(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 5) {
            throw new IllegalArgumentException("expected sequence size of 5");
        }
        this.f22789version = C5976UINT8.getInstance(aSN1Sequence.getObjectAt(0));
        this.generationTime = C5969Time32.getInstance((Object) aSN1Sequence.getObjectAt(1));
        this.f22788type = CertificateType.getInstance((Object) aSN1Sequence.getObjectAt(2));
        this.f22787tbsCert = ToBeSignedCertificate.getInstance(aSN1Sequence.getObjectAt(3));
        this.canonicalId = (ASN1IA5String) OEROptional.getInstance(aSN1Sequence.getObjectAt(4)).getObject(ASN1IA5String.class);
    }

    /* renamed from: builder */
    public static C5979Builder m17352builder() {
        return new C5979Builder();
    }

    public static EeEcaCertRequest getInstance(Object obj) {
        if (obj instanceof EeEcaCertRequest) {
            return (EeEcaCertRequest) obj;
        }
        if (obj != null) {
            return new EeEcaCertRequest(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1IA5String getCanonicalId() {
        return this.canonicalId;
    }

    public C5969Time32 getGenerationTime() {
        return this.generationTime;
    }

    public ToBeSignedCertificate getTbsCert() {
        return this.f22787tbsCert;
    }

    /* renamed from: getType */
    public CertificateType m17353getType() {
        return this.f22788type;
    }

    public C5976UINT8 getVersion() {
        return this.f22789version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return ItsUtils.toSequence(this.f22789version, this.generationTime, this.f22788type, this.f22787tbsCert, OEROptional.getInstance(this.canonicalId));
    }

    public EeEcaCertRequest(C5976UINT8 c5976uint8, C5969Time32 c5969Time32, CertificateType certificateType, ToBeSignedCertificate toBeSignedCertificate, ASN1IA5String aSN1IA5String) {
        this.f22789version = c5976uint8;
        this.generationTime = c5969Time32;
        this.f22788type = certificateType;
        this.f22787tbsCert = toBeSignedCertificate;
        this.canonicalId = aSN1IA5String;
    }
}
