package org.bouncycastle.p133asn1.p174x509;

import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Boolean;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class IssuingDistributionPoint extends ASN1Object {
    private DistributionPointName distributionPoint;
    private boolean indirectCRL;
    private boolean onlyContainsAttributeCerts;
    private boolean onlyContainsCACerts;
    private boolean onlyContainsUserCerts;
    private ReasonFlags onlySomeReasons;

    /* renamed from: seq */
    private ASN1Sequence f18666seq;

    private IssuingDistributionPoint(ASN1Sequence aSN1Sequence) {
        this.f18666seq = aSN1Sequence;
        for (int i = 0; i != aSN1Sequence.mo14450size(); i++) {
            ASN1TaggedObject aSN1TaggedObject = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(i));
            int tagNo = aSN1TaggedObject.getTagNo();
            if (tagNo == 0) {
                this.distributionPoint = DistributionPointName.getInstance(aSN1TaggedObject, true);
            } else if (tagNo == 1) {
                this.onlyContainsUserCerts = ASN1Boolean.getInstance(aSN1TaggedObject, false).m14419isTrue();
            } else if (tagNo == 2) {
                this.onlyContainsCACerts = ASN1Boolean.getInstance(aSN1TaggedObject, false).m14419isTrue();
            } else if (tagNo == 3) {
                this.onlySomeReasons = new ReasonFlags(ASN1BitString.getInstance(aSN1TaggedObject, false));
            } else if (tagNo == 4) {
                this.indirectCRL = ASN1Boolean.getInstance(aSN1TaggedObject, false).m14419isTrue();
            } else {
                if (tagNo != 5) {
                    throw new IllegalArgumentException("unknown tag in IssuingDistributionPoint");
                }
                this.onlyContainsAttributeCerts = ASN1Boolean.getInstance(aSN1TaggedObject, false).m14419isTrue();
            }
        }
    }

    private void appendObject(StringBuilder sb, String str, String str2, String str3) {
        sb.append("    ");
        sb.append(str2);
        sb.append(":");
        sb.append(str);
        sb.append("    ");
        sb.append("    ");
        sb.append(str3);
        sb.append(str);
    }

    private String booleanToString(boolean z) {
        return z ? "true" : "false";
    }

    public static IssuingDistributionPoint getInstance(Object obj) {
        if (obj instanceof IssuingDistributionPoint) {
            return (IssuingDistributionPoint) obj;
        }
        if (obj != null) {
            return new IssuingDistributionPoint(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public DistributionPointName getDistributionPoint() {
        return this.distributionPoint;
    }

    public ReasonFlags getOnlySomeReasons() {
        return this.onlySomeReasons;
    }

    public boolean isIndirectCRL() {
        return this.indirectCRL;
    }

    public boolean onlyContainsAttributeCerts() {
        return this.onlyContainsAttributeCerts;
    }

    public boolean onlyContainsCACerts() {
        return this.onlyContainsCACerts;
    }

    public boolean onlyContainsUserCerts() {
        return this.onlyContainsUserCerts;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18666seq;
    }

    public String toString() {
        String strLineSeparator = C6250Strings.lineSeparator();
        StringBuilder sb = new StringBuilder();
        sb.append("IssuingDistributionPoint: [");
        sb.append(strLineSeparator);
        DistributionPointName distributionPointName = this.distributionPoint;
        if (distributionPointName != null) {
            appendObject(sb, strLineSeparator, "distributionPoint", distributionPointName.toString());
        }
        boolean z = this.onlyContainsUserCerts;
        if (z) {
            appendObject(sb, strLineSeparator, "onlyContainsUserCerts", booleanToString(z));
        }
        boolean z2 = this.onlyContainsCACerts;
        if (z2) {
            appendObject(sb, strLineSeparator, "onlyContainsCACerts", booleanToString(z2));
        }
        ReasonFlags reasonFlags = this.onlySomeReasons;
        if (reasonFlags != null) {
            appendObject(sb, strLineSeparator, "onlySomeReasons", reasonFlags.toString());
        }
        boolean z3 = this.onlyContainsAttributeCerts;
        if (z3) {
            appendObject(sb, strLineSeparator, "onlyContainsAttributeCerts", booleanToString(z3));
        }
        boolean z4 = this.indirectCRL;
        if (z4) {
            appendObject(sb, strLineSeparator, "indirectCRL", booleanToString(z4));
        }
        sb.append("]");
        sb.append(strLineSeparator);
        return sb.toString();
    }

    public IssuingDistributionPoint(DistributionPointName distributionPointName, boolean z, boolean z2) {
        this(distributionPointName, false, false, null, z, z2);
    }

    public static IssuingDistributionPoint getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public IssuingDistributionPoint(DistributionPointName distributionPointName, boolean z, boolean z2, ReasonFlags reasonFlags, boolean z3, boolean z4) {
        if ((z2 && (z || z4)) || (z && z4)) {
            throw new IllegalArgumentException("only one of onlyContainsCACerts, onlyContainsUserCerts, or onlyContainsAttributeCerts can be true");
        }
        this.distributionPoint = distributionPointName;
        this.indirectCRL = z3;
        this.onlyContainsAttributeCerts = z4;
        this.onlyContainsCACerts = z2;
        this.onlyContainsUserCerts = z;
        this.onlySomeReasons = reasonFlags;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(6);
        if (distributionPointName != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 0, (ASN1Encodable) distributionPointName));
        }
        if (z) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 1, (ASN1Encodable) ASN1Boolean.getInstance(true)));
        }
        if (z2) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 2, (ASN1Encodable) ASN1Boolean.getInstance(true)));
        }
        if (reasonFlags != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 3, (ASN1Encodable) reasonFlags));
        }
        if (z3) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 4, (ASN1Encodable) ASN1Boolean.getInstance(true)));
        }
        if (z4) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 5, (ASN1Encodable) ASN1Boolean.getInstance(true)));
        }
        this.f18666seq = new DERSequence(aSN1EncodableVector);
    }
}
