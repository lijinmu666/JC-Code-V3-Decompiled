package org.bouncycastle.p300oer.p301its.ieee1609dot2dot1;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p300oer.OEROptional;
import org.bouncycastle.p300oer.p301its.ItsUtils;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.CertificateType;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.ToBeSignedCertificate;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5969Time32;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5976UINT8;

/* loaded from: classes2.dex */
public class EeRaCertRequest extends ASN1Object {
    private final AdditionalParams additionalParams;
    private final C5969Time32 generationTime;

    /* renamed from: tbsCert */
    private final ToBeSignedCertificate f22793tbsCert;

    /* renamed from: type */
    private final CertificateType f22794type;

    /* renamed from: version */
    private final C5976UINT8 f22795version;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2dot1.EeRaCertRequest$Builder */
    public static class C5980Builder {
        private AdditionalParams additionalParams;
        private C5969Time32 generationTime;

        /* renamed from: tbsCert */
        private ToBeSignedCertificate f22796tbsCert;

        /* renamed from: type */
        private CertificateType f22797type;

        /* renamed from: version */
        private C5976UINT8 f22798version;

        public EeRaCertRequest createEeRaCertRequest() {
            return new EeRaCertRequest(this.f22798version, this.generationTime, this.f22797type, this.f22796tbsCert, this.additionalParams);
        }

        public C5980Builder setAdditionalParams(AdditionalParams additionalParams) {
            this.additionalParams = additionalParams;
            return this;
        }

        public C5980Builder setGenerationTime(C5969Time32 c5969Time32) {
            this.generationTime = c5969Time32;
            return this;
        }

        public C5980Builder setTbsCert(ToBeSignedCertificate toBeSignedCertificate) {
            this.f22796tbsCert = toBeSignedCertificate;
            return this;
        }

        /* renamed from: setType */
        public C5980Builder m17357setType(CertificateType certificateType) {
            this.f22797type = certificateType;
            return this;
        }

        public C5980Builder setVersion(C5976UINT8 c5976uint8) {
            this.f22798version = c5976uint8;
            return this;
        }
    }

    private EeRaCertRequest(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 5) {
            throw new IllegalArgumentException("expected sequence size of 5");
        }
        this.f22795version = C5976UINT8.getInstance(aSN1Sequence.getObjectAt(0));
        this.generationTime = C5969Time32.getInstance((Object) aSN1Sequence.getObjectAt(1));
        this.f22794type = CertificateType.getInstance((Object) aSN1Sequence.getObjectAt(2));
        this.f22793tbsCert = ToBeSignedCertificate.getInstance(aSN1Sequence.getObjectAt(3));
        this.additionalParams = (AdditionalParams) OEROptional.getInstance(aSN1Sequence.getObjectAt(4)).getObject(AdditionalParams.class);
    }

    /* renamed from: builder */
    public static C5980Builder m17355builder() {
        return new C5980Builder();
    }

    public static EeRaCertRequest getInstance(Object obj) {
        if (obj instanceof EeRaCertRequest) {
            return (EeRaCertRequest) obj;
        }
        if (obj != null) {
            return new EeRaCertRequest(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AdditionalParams getAdditionalParams() {
        return this.additionalParams;
    }

    public C5969Time32 getGenerationTime() {
        return this.generationTime;
    }

    public ToBeSignedCertificate getTbsCert() {
        return this.f22793tbsCert;
    }

    /* renamed from: getType */
    public CertificateType m17356getType() {
        return this.f22794type;
    }

    public C5976UINT8 getVersion() {
        return this.f22795version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return ItsUtils.toSequence(this.f22795version, this.generationTime, this.f22794type, this.f22793tbsCert, OEROptional.getInstance(this.additionalParams));
    }

    public EeRaCertRequest(C5976UINT8 c5976uint8, C5969Time32 c5969Time32, CertificateType certificateType, ToBeSignedCertificate toBeSignedCertificate, AdditionalParams additionalParams) {
        this.f22795version = c5976uint8;
        this.generationTime = c5969Time32;
        this.f22794type = certificateType;
        this.f22793tbsCert = toBeSignedCertificate;
        this.additionalParams = additionalParams;
    }
}
