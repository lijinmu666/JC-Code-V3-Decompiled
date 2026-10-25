package org.bouncycastle.p300oer.p301its.ieee1609dot2;

import java.util.Iterator;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Null;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p300oer.OEROptional;
import org.bouncycastle.p300oer.p301its.ItsUtils;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.CrlSeries;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.GeographicRegion;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.HashedId3;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.PublicEncryptionKey;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.SequenceOfPsidSsp;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.SubjectAssurance;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.ValidityPeriod;

/* loaded from: classes2.dex */
public class ToBeSignedCertificate extends ASN1Object {
    private final SequenceOfPsidSsp appPermissions;
    private final SubjectAssurance assuranceLevel;
    private final ASN1Null canRequestRollover;
    private final SequenceOfPsidGroupPermissions certIssuePermissions;
    private final SequenceOfPsidGroupPermissions certRequestPermissions;

    /* renamed from: cracaId */
    private final HashedId3 f22679cracaId;
    private final CrlSeries crlSeries;
    private final PublicEncryptionKey encryptionKey;

    /* renamed from: id */
    private final CertificateId f22680id;

    /* renamed from: region */
    private final GeographicRegion f22681region;
    private final ValidityPeriod validityPeriod;
    private final VerificationKeyIndicator verifyKeyIndicator;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.ToBeSignedCertificate$Builder */
    public static class C5938Builder {
        private SequenceOfPsidSsp appPermissions;
        private SubjectAssurance assuranceLevel;
        private ASN1Null canRequestRollover;
        private SequenceOfPsidGroupPermissions certIssuePermissions;
        private SequenceOfPsidGroupPermissions certRequestPermissions;

        /* renamed from: cracaId */
        private HashedId3 f22682cracaId;
        private CrlSeries crlSeries;
        private PublicEncryptionKey encryptionKey;

        /* renamed from: id */
        private CertificateId f22683id;

        /* renamed from: region */
        private GeographicRegion f22684region;
        private ValidityPeriod validityPeriod;
        private VerificationKeyIndicator verifyKeyIndicator;

        public C5938Builder() {
        }

        public ToBeSignedCertificate createToBeSignedCertificate() {
            return new ToBeSignedCertificate(this.f22683id, this.f22682cracaId, this.crlSeries, this.validityPeriod, this.f22684region, this.assuranceLevel, this.appPermissions, this.certIssuePermissions, this.certRequestPermissions, this.canRequestRollover, this.encryptionKey, this.verifyKeyIndicator);
        }

        public C5938Builder setAppPermissions(SequenceOfPsidSsp sequenceOfPsidSsp) {
            this.appPermissions = sequenceOfPsidSsp;
            return this;
        }

        public C5938Builder setAssuranceLevel(SubjectAssurance subjectAssurance) {
            this.assuranceLevel = subjectAssurance;
            return this;
        }

        public C5938Builder setCanRequestRollover() {
            this.canRequestRollover = C5103DERNull.INSTANCE;
            return this;
        }

        public C5938Builder setCertIssuePermissions(SequenceOfPsidGroupPermissions sequenceOfPsidGroupPermissions) {
            this.certIssuePermissions = sequenceOfPsidGroupPermissions;
            return this;
        }

        public C5938Builder setCertRequestPermissions(SequenceOfPsidGroupPermissions sequenceOfPsidGroupPermissions) {
            this.certRequestPermissions = sequenceOfPsidGroupPermissions;
            return this;
        }

        public C5938Builder setCracaId(HashedId3 hashedId3) {
            this.f22682cracaId = hashedId3;
            return this;
        }

        public C5938Builder setCrlSeries(CrlSeries crlSeries) {
            this.crlSeries = crlSeries;
            return this;
        }

        public C5938Builder setEncryptionKey(PublicEncryptionKey publicEncryptionKey) {
            this.encryptionKey = publicEncryptionKey;
            return this;
        }

        /* renamed from: setId */
        public C5938Builder m17252setId(CertificateId certificateId) {
            this.f22683id = certificateId;
            return this;
        }

        public C5938Builder setRegion(GeographicRegion geographicRegion) {
            this.f22684region = geographicRegion;
            return this;
        }

        public C5938Builder setValidityPeriod(ValidityPeriod validityPeriod) {
            this.validityPeriod = validityPeriod;
            return this;
        }

        public C5938Builder setVerifyKeyIndicator(VerificationKeyIndicator verificationKeyIndicator) {
            this.verifyKeyIndicator = verificationKeyIndicator;
            return this;
        }

        public C5938Builder(C5938Builder c5938Builder) {
            this.f22683id = c5938Builder.f22683id;
            this.f22682cracaId = c5938Builder.f22682cracaId;
            this.crlSeries = c5938Builder.crlSeries;
            this.validityPeriod = c5938Builder.validityPeriod;
            this.f22684region = c5938Builder.f22684region;
            this.assuranceLevel = c5938Builder.assuranceLevel;
            this.appPermissions = c5938Builder.appPermissions;
            this.certIssuePermissions = c5938Builder.certIssuePermissions;
            this.certRequestPermissions = c5938Builder.certRequestPermissions;
            this.canRequestRollover = c5938Builder.canRequestRollover;
            this.encryptionKey = c5938Builder.encryptionKey;
            this.verifyKeyIndicator = c5938Builder.verifyKeyIndicator;
        }

        public C5938Builder(ToBeSignedCertificate toBeSignedCertificate) {
            this.f22683id = toBeSignedCertificate.f22680id;
            this.f22682cracaId = toBeSignedCertificate.f22679cracaId;
            this.crlSeries = toBeSignedCertificate.crlSeries;
            this.validityPeriod = toBeSignedCertificate.validityPeriod;
            this.f22684region = toBeSignedCertificate.f22681region;
            this.assuranceLevel = toBeSignedCertificate.assuranceLevel;
            this.appPermissions = toBeSignedCertificate.appPermissions;
            this.certIssuePermissions = toBeSignedCertificate.certIssuePermissions;
            this.certRequestPermissions = toBeSignedCertificate.certRequestPermissions;
            this.canRequestRollover = toBeSignedCertificate.canRequestRollover;
            this.encryptionKey = toBeSignedCertificate.encryptionKey;
            this.verifyKeyIndicator = toBeSignedCertificate.verifyKeyIndicator;
        }
    }

    private ToBeSignedCertificate(ASN1Sequence aSN1Sequence) {
        Iterator<ASN1Encodable> it = ASN1Sequence.getInstance(aSN1Sequence).iterator();
        if (aSN1Sequence.mo14450size() != 12) {
            throw new IllegalArgumentException("expected sequence size of 12");
        }
        this.f22680id = CertificateId.getInstance(it.next());
        this.f22679cracaId = HashedId3.getInstance(it.next());
        this.crlSeries = CrlSeries.getInstance((Object) it.next());
        this.validityPeriod = ValidityPeriod.getInstance(it.next());
        this.f22681region = (GeographicRegion) OEROptional.getValue(GeographicRegion.class, it.next());
        this.assuranceLevel = (SubjectAssurance) OEROptional.getValue(SubjectAssurance.class, it.next());
        this.appPermissions = (SequenceOfPsidSsp) OEROptional.getValue(SequenceOfPsidSsp.class, it.next());
        this.certIssuePermissions = (SequenceOfPsidGroupPermissions) OEROptional.getValue(SequenceOfPsidGroupPermissions.class, it.next());
        this.certRequestPermissions = (SequenceOfPsidGroupPermissions) OEROptional.getValue(SequenceOfPsidGroupPermissions.class, it.next());
        this.canRequestRollover = (ASN1Null) OEROptional.getValue(ASN1Null.class, it.next());
        this.encryptionKey = (PublicEncryptionKey) OEROptional.getValue(PublicEncryptionKey.class, it.next());
        this.verifyKeyIndicator = VerificationKeyIndicator.getInstance(it.next());
    }

    /* renamed from: builder */
    public static C5938Builder m17250builder() {
        return new C5938Builder();
    }

    public static ToBeSignedCertificate getInstance(Object obj) {
        if (obj instanceof ToBeSignedCertificate) {
            return (ToBeSignedCertificate) obj;
        }
        if (obj != null) {
            return new ToBeSignedCertificate(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public SequenceOfPsidSsp getAppPermissions() {
        return this.appPermissions;
    }

    public SubjectAssurance getAssuranceLevel() {
        return this.assuranceLevel;
    }

    public ASN1Null getCanRequestRollover() {
        return this.canRequestRollover;
    }

    public SequenceOfPsidGroupPermissions getCertIssuePermissions() {
        return this.certIssuePermissions;
    }

    public SequenceOfPsidGroupPermissions getCertRequestPermissions() {
        return this.certRequestPermissions;
    }

    public HashedId3 getCracaId() {
        return this.f22679cracaId;
    }

    public CrlSeries getCrlSeries() {
        return this.crlSeries;
    }

    public PublicEncryptionKey getEncryptionKey() {
        return this.encryptionKey;
    }

    /* renamed from: getId */
    public CertificateId m17251getId() {
        return this.f22680id;
    }

    public GeographicRegion getRegion() {
        return this.f22681region;
    }

    public ValidityPeriod getValidityPeriod() {
        return this.validityPeriod;
    }

    public VerificationKeyIndicator getVerifyKeyIndicator() {
        return this.verifyKeyIndicator;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return ItsUtils.toSequence(this.f22680id, this.f22679cracaId, this.crlSeries, this.validityPeriod, OEROptional.getInstance(this.f22681region), OEROptional.getInstance(this.assuranceLevel), OEROptional.getInstance(this.appPermissions), OEROptional.getInstance(this.certIssuePermissions), OEROptional.getInstance(this.certRequestPermissions), OEROptional.getInstance(this.canRequestRollover), OEROptional.getInstance(this.encryptionKey), this.verifyKeyIndicator);
    }

    public ToBeSignedCertificate(CertificateId certificateId, HashedId3 hashedId3, CrlSeries crlSeries, ValidityPeriod validityPeriod, GeographicRegion geographicRegion, SubjectAssurance subjectAssurance, SequenceOfPsidSsp sequenceOfPsidSsp, SequenceOfPsidGroupPermissions sequenceOfPsidGroupPermissions, SequenceOfPsidGroupPermissions sequenceOfPsidGroupPermissions2, ASN1Null aSN1Null, PublicEncryptionKey publicEncryptionKey, VerificationKeyIndicator verificationKeyIndicator) {
        this.f22680id = certificateId;
        this.f22679cracaId = hashedId3;
        this.crlSeries = crlSeries;
        this.validityPeriod = validityPeriod;
        this.f22681region = geographicRegion;
        this.assuranceLevel = subjectAssurance;
        this.appPermissions = sequenceOfPsidSsp;
        this.certIssuePermissions = sequenceOfPsidGroupPermissions;
        this.certRequestPermissions = sequenceOfPsidGroupPermissions2;
        this.canRequestRollover = aSN1Null;
        this.encryptionKey = publicEncryptionKey;
        this.verifyKeyIndicator = verificationKeyIndicator;
    }
}
