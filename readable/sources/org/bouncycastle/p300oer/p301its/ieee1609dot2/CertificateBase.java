package org.bouncycastle.p300oer.p301its.ieee1609dot2;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p300oer.OEROptional;
import org.bouncycastle.p300oer.p301its.ItsUtils;
import org.bouncycastle.p300oer.p301its.etsi103097.EtsiTs103097Certificate;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5976UINT8;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.Signature;

/* loaded from: classes2.dex */
public class CertificateBase extends ASN1Object {

    /* renamed from: issuer */
    private final IssuerIdentifier f22628issuer;
    private final Signature signature;
    private final ToBeSignedCertificate toBeSigned;

    /* renamed from: type */
    private final CertificateType f22629type;

    /* renamed from: version */
    private final C5976UINT8 f22630version;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.CertificateBase$Builder */
    public static class C5922Builder {

        /* renamed from: issuer */
        private IssuerIdentifier f22631issuer;
        private Signature signature;
        private ToBeSignedCertificate toBeSigned;

        /* renamed from: type */
        private CertificateType f22632type;

        /* renamed from: version */
        private C5976UINT8 f22633version;

        public Certificate createCertificate() {
            return new Certificate(this.f22633version, this.f22632type, this.f22631issuer, this.toBeSigned, this.signature);
        }

        public CertificateBase createCertificateBase() {
            return new CertificateBase(this.f22633version, this.f22632type, this.f22631issuer, this.toBeSigned, this.signature);
        }

        public CertificateBase createEtsiTs103097Certificate() {
            return new EtsiTs103097Certificate(this.f22633version, this.f22631issuer, this.toBeSigned, this.signature);
        }

        public ExplicitCertificate createExplicitCertificate() {
            return new ExplicitCertificate(this.f22633version, this.f22631issuer, this.toBeSigned, this.signature);
        }

        public ImplicitCertificate createImplicitCertificate() {
            return new ImplicitCertificate(this.f22633version, this.f22631issuer, this.toBeSigned, this.signature);
        }

        public C5922Builder setIssuer(IssuerIdentifier issuerIdentifier) {
            this.f22631issuer = issuerIdentifier;
            return this;
        }

        public C5922Builder setSignature(Signature signature) {
            this.signature = signature;
            return this;
        }

        public C5922Builder setToBeSigned(ToBeSignedCertificate toBeSignedCertificate) {
            this.toBeSigned = toBeSignedCertificate;
            return this;
        }

        /* renamed from: setType */
        public C5922Builder m17218setType(CertificateType certificateType) {
            this.f22632type = certificateType;
            return this;
        }

        public C5922Builder setVersion(C5976UINT8 c5976uint8) {
            this.f22633version = c5976uint8;
            return this;
        }
    }

    public CertificateBase(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 5) {
            throw new IllegalArgumentException("expected sequence size of 5");
        }
        this.f22630version = C5976UINT8.getInstance(aSN1Sequence.getObjectAt(0));
        this.f22629type = CertificateType.getInstance((Object) aSN1Sequence.getObjectAt(1));
        this.f22628issuer = IssuerIdentifier.getInstance(aSN1Sequence.getObjectAt(2));
        this.toBeSigned = ToBeSignedCertificate.getInstance(aSN1Sequence.getObjectAt(3));
        this.signature = (Signature) OEROptional.getValue(Signature.class, aSN1Sequence.getObjectAt(4));
    }

    /* renamed from: builder */
    public static C5922Builder m17216builder() {
        return new C5922Builder();
    }

    public static CertificateBase getInstance(Object obj) {
        if (obj instanceof CertificateBase) {
            return (CertificateBase) obj;
        }
        if (obj != null) {
            return new CertificateBase(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public IssuerIdentifier getIssuer() {
        return this.f22628issuer;
    }

    public Signature getSignature() {
        return this.signature;
    }

    public ToBeSignedCertificate getToBeSigned() {
        return this.toBeSigned;
    }

    /* renamed from: getType */
    public CertificateType m17217getType() {
        return this.f22629type;
    }

    public C5976UINT8 getVersion() {
        return this.f22630version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return ItsUtils.toSequence(this.f22630version, this.f22629type, this.f22628issuer, this.toBeSigned, OEROptional.getInstance(this.signature));
    }

    public CertificateBase(C5976UINT8 c5976uint8, CertificateType certificateType, IssuerIdentifier issuerIdentifier, ToBeSignedCertificate toBeSignedCertificate, Signature signature) {
        this.f22630version = c5976uint8;
        this.f22629type = certificateType;
        this.f22628issuer = issuerIdentifier;
        this.toBeSigned = toBeSignedCertificate;
        this.signature = signature;
    }
}
