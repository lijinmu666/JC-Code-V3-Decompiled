package org.bouncycastle.p300oer.p301its.etsi102941.basetypes;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p300oer.OEROptional;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.CertificateId;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.SequenceOfPsidGroupPermissions;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.GeographicRegion;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.SequenceOfPsidSsp;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.SubjectAssurance;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.ValidityPeriod;

/* loaded from: classes2.dex */
public class CertificateSubjectAttributes extends ASN1Object {
    private final SequenceOfPsidSsp appPermissions;
    private final SubjectAssurance assuranceLevel;
    private final SequenceOfPsidGroupPermissions certIssuePermissions;

    /* renamed from: id */
    private final CertificateId f22616id;

    /* renamed from: region */
    private final GeographicRegion f22617region;
    private final ValidityPeriod validityPeriod;

    private CertificateSubjectAttributes(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 6) {
            throw new IllegalArgumentException("expected sequence size of 6");
        }
        this.f22616id = (CertificateId) OEROptional.getValue(CertificateId.class, aSN1Sequence.getObjectAt(0));
        this.validityPeriod = (ValidityPeriod) OEROptional.getValue(ValidityPeriod.class, aSN1Sequence.getObjectAt(1));
        this.f22617region = (GeographicRegion) OEROptional.getValue(GeographicRegion.class, aSN1Sequence.getObjectAt(2));
        this.assuranceLevel = (SubjectAssurance) OEROptional.getValue(SubjectAssurance.class, aSN1Sequence.getObjectAt(3));
        this.appPermissions = (SequenceOfPsidSsp) OEROptional.getValue(SequenceOfPsidSsp.class, aSN1Sequence.getObjectAt(4));
        this.certIssuePermissions = (SequenceOfPsidGroupPermissions) OEROptional.getValue(SequenceOfPsidGroupPermissions.class, aSN1Sequence.getObjectAt(5));
    }

    public static CertificateSubjectAttributes getInstance(Object obj) {
        if (obj instanceof CertificateSubjectAttributes) {
            return (CertificateSubjectAttributes) obj;
        }
        if (obj != null) {
            return new CertificateSubjectAttributes(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public SequenceOfPsidSsp getAppPermissions() {
        return this.appPermissions;
    }

    public SubjectAssurance getAssuranceLevel() {
        return this.assuranceLevel;
    }

    public SequenceOfPsidGroupPermissions getCertIssuePermissions() {
        return this.certIssuePermissions;
    }

    /* renamed from: getId */
    public CertificateId m17209getId() {
        return this.f22616id;
    }

    public GeographicRegion getRegion() {
        return this.f22617region;
    }

    public ValidityPeriod getValidityPeriod() {
        return this.validityPeriod;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{OEROptional.getInstance(this.f22616id), OEROptional.getInstance(this.validityPeriod), OEROptional.getInstance(this.f22617region), OEROptional.getInstance(this.assuranceLevel), OEROptional.getInstance(this.appPermissions), OEROptional.getInstance(this.certIssuePermissions)});
    }

    public CertificateSubjectAttributes(CertificateId certificateId, ValidityPeriod validityPeriod, GeographicRegion geographicRegion, SubjectAssurance subjectAssurance, SequenceOfPsidSsp sequenceOfPsidSsp, SequenceOfPsidGroupPermissions sequenceOfPsidGroupPermissions) {
        this.f22616id = certificateId;
        this.validityPeriod = validityPeriod;
        this.f22617region = geographicRegion;
        this.assuranceLevel = subjectAssurance;
        this.appPermissions = sequenceOfPsidSsp;
        this.certIssuePermissions = sequenceOfPsidGroupPermissions;
    }
}
