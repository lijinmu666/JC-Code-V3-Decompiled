package org.bouncycastle.p300oer.p301its.ieee1609dot2;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p300oer.OEROptional;

/* loaded from: classes2.dex */
public class PsidGroupPermissions extends ASN1Object {
    private final ASN1Integer chainLengthRange;

    /* renamed from: eeType */
    private final EndEntityType f22660eeType;
    private final ASN1Integer minChainLength;
    private final SubjectPermissions subjectPermissions;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.PsidGroupPermissions$Builder */
    public static class C5931Builder {
        private ASN1Integer chainLengthRange;

        /* renamed from: eeType */
        private EndEntityType f22661eeType;
        private ASN1Integer minChainLength;
        private SubjectPermissions subjectPermissions;

        public PsidGroupPermissions createPsidGroupPermissions() {
            return new PsidGroupPermissions(this.subjectPermissions, this.minChainLength, this.chainLengthRange, this.f22661eeType);
        }

        public C5931Builder setChainLengthRange(long j) {
            this.chainLengthRange = ASN1Integer.m14430valueOf(j);
            return this;
        }

        public C5931Builder setEeType(EndEntityType endEntityType) {
            this.f22661eeType = endEntityType;
            return this;
        }

        public C5931Builder setMinChainLength(long j) {
            this.minChainLength = ASN1Integer.m14430valueOf(j);
            return this;
        }

        public C5931Builder setSubjectPermissions(SubjectPermissions subjectPermissions) {
            this.subjectPermissions = subjectPermissions;
            return this;
        }

        public C5931Builder setChainLengthRange(BigInteger bigInteger) {
            this.chainLengthRange = new ASN1Integer(bigInteger);
            return this;
        }

        public C5931Builder setMinChainLength(BigInteger bigInteger) {
            this.minChainLength = new ASN1Integer(bigInteger);
            return this;
        }

        public C5931Builder setChainLengthRange(ASN1Integer aSN1Integer) {
            this.chainLengthRange = aSN1Integer;
            return this;
        }

        public C5931Builder setMinChainLength(ASN1Integer aSN1Integer) {
            this.minChainLength = aSN1Integer;
            return this;
        }
    }

    private PsidGroupPermissions(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 4) {
            throw new IllegalArgumentException("expected sequence size of 4");
        }
        this.subjectPermissions = SubjectPermissions.getInstance(aSN1Sequence.getObjectAt(0));
        this.minChainLength = (ASN1Integer) OEROptional.getInstance(aSN1Sequence.getObjectAt(1)).getObject(ASN1Integer.class);
        this.chainLengthRange = (ASN1Integer) OEROptional.getInstance(aSN1Sequence.getObjectAt(2)).getObject(ASN1Integer.class);
        this.f22660eeType = (EndEntityType) OEROptional.getInstance(aSN1Sequence.getObjectAt(3)).getObject(EndEntityType.class);
    }

    /* renamed from: builder */
    public static C5931Builder m17236builder() {
        return new C5931Builder();
    }

    public static PsidGroupPermissions getInstance(Object obj) {
        if (obj instanceof PsidGroupPermissions) {
            return (PsidGroupPermissions) obj;
        }
        if (obj != null) {
            return new PsidGroupPermissions(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Integer getChainLengthRange() {
        return this.chainLengthRange;
    }

    public EndEntityType getEeType() {
        return this.f22660eeType;
    }

    public ASN1Integer getMinChainLength() {
        return this.minChainLength;
    }

    public SubjectPermissions getSubjectPermissions() {
        return this.subjectPermissions;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.subjectPermissions, OEROptional.getInstance(this.minChainLength), OEROptional.getInstance(this.chainLengthRange), OEROptional.getInstance(this.f22660eeType)});
    }

    public PsidGroupPermissions(SubjectPermissions subjectPermissions, ASN1Integer aSN1Integer, ASN1Integer aSN1Integer2, EndEntityType endEntityType) {
        this.subjectPermissions = subjectPermissions;
        this.minChainLength = aSN1Integer;
        this.chainLengthRange = aSN1Integer2;
        this.f22660eeType = endEntityType;
    }
}
