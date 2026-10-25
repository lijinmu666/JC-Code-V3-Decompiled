package org.bouncycastle.p133asn1.p174x509;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class PolicyInformation extends ASN1Object {
    private ASN1ObjectIdentifier policyIdentifier;
    private ASN1Sequence policyQualifiers;

    public PolicyInformation(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.policyIdentifier = aSN1ObjectIdentifier;
    }

    public static PolicyInformation getInstance(Object obj) {
        return (obj == null || (obj instanceof PolicyInformation)) ? (PolicyInformation) obj : new PolicyInformation(ASN1Sequence.getInstance(obj));
    }

    public ASN1ObjectIdentifier getPolicyIdentifier() {
        return this.policyIdentifier;
    }

    public ASN1Sequence getPolicyQualifiers() {
        return this.policyQualifiers;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.m14420add(this.policyIdentifier);
        ASN1Sequence aSN1Sequence = this.policyQualifiers;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.m14420add(aSN1Sequence);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Policy information: ");
        sb.append(this.policyIdentifier);
        if (this.policyQualifiers != null) {
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < this.policyQualifiers.mo14450size(); i++) {
                if (sb2.length() != 0) {
                    sb2.append(", ");
                }
                sb2.append(PolicyQualifierInfo.getInstance(this.policyQualifiers.getObjectAt(i)));
            }
            sb.append("[");
            sb.append((CharSequence) sb2);
            sb.append("]");
        }
        return sb.toString();
    }

    public PolicyInformation(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Sequence aSN1Sequence) {
        this.policyIdentifier = aSN1ObjectIdentifier;
        this.policyQualifiers = aSN1Sequence;
    }

    private PolicyInformation(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() < 1 || aSN1Sequence.mo14450size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.mo14450size());
        }
        this.policyIdentifier = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.mo14450size() > 1) {
            this.policyQualifiers = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
        }
    }
}
