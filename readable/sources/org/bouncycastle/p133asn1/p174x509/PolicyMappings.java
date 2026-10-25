package org.bouncycastle.p133asn1.p174x509;

import java.util.Enumeration;
import java.util.Hashtable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class PolicyMappings extends ASN1Object {

    /* renamed from: seq */
    ASN1Sequence f18672seq;

    public PolicyMappings(Hashtable hashtable) {
        this.f18672seq = null;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(hashtable.size());
        Enumeration enumerationKeys = hashtable.keys();
        while (enumerationKeys.hasMoreElements()) {
            String str = (String) enumerationKeys.nextElement();
            aSN1EncodableVector.m14420add(new DERSequence(new ASN1ObjectIdentifier(str), new ASN1ObjectIdentifier((String) hashtable.get(str))));
        }
        this.f18672seq = new DERSequence(aSN1EncodableVector);
    }

    public static PolicyMappings getInstance(Object obj) {
        if (obj instanceof PolicyMappings) {
            return (PolicyMappings) obj;
        }
        if (obj != null) {
            return new PolicyMappings(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18672seq;
    }

    private PolicyMappings(ASN1Sequence aSN1Sequence) {
        this.f18672seq = aSN1Sequence;
    }

    public PolicyMappings(CertPolicyId certPolicyId, CertPolicyId certPolicyId2) {
        this.f18672seq = null;
        this.f18672seq = new DERSequence(new DERSequence(certPolicyId, certPolicyId2));
    }

    public PolicyMappings(CertPolicyId[] certPolicyIdArr, CertPolicyId[] certPolicyIdArr2) {
        this.f18672seq = null;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(certPolicyIdArr.length);
        for (int i = 0; i != certPolicyIdArr.length; i++) {
            aSN1EncodableVector.m14420add(new DERSequence(certPolicyIdArr[i], certPolicyIdArr2[i]));
        }
        this.f18672seq = new DERSequence(aSN1EncodableVector);
    }
}
