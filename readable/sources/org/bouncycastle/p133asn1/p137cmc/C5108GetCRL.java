package org.bouncycastle.p133asn1.p137cmc;

import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1GeneralizedTime;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p133asn1.p174x509.ReasonFlags;

/* renamed from: org.bouncycastle.asn1.cmc.GetCRL */
/* loaded from: classes.dex */
public class C5108GetCRL extends ASN1Object {

    /* renamed from: cRLName */
    private GeneralName f18079cRLName;
    private final X500Name issuerName;

    /* renamed from: reasons */
    private ReasonFlags f18080reasons;

    /* renamed from: time */
    private ASN1GeneralizedTime f18081time;

    private C5108GetCRL(ASN1Sequence aSN1Sequence) {
        int i = 1;
        if (aSN1Sequence.mo14450size() < 1 || aSN1Sequence.mo14450size() > 4) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.issuerName = X500Name.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.mo14450size() > 1 && (aSN1Sequence.getObjectAt(1).toASN1Primitive() instanceof ASN1TaggedObject)) {
            this.f18079cRLName = GeneralName.getInstance(aSN1Sequence.getObjectAt(1));
            i = 2;
        }
        if (aSN1Sequence.mo14450size() > i && (aSN1Sequence.getObjectAt(i).toASN1Primitive() instanceof ASN1GeneralizedTime)) {
            this.f18081time = ASN1GeneralizedTime.getInstance(aSN1Sequence.getObjectAt(i));
            i++;
        }
        if (aSN1Sequence.mo14450size() <= i || !(aSN1Sequence.getObjectAt(i).toASN1Primitive() instanceof ASN1BitString)) {
            return;
        }
        this.f18080reasons = new ReasonFlags(ASN1BitString.getInstance(aSN1Sequence.getObjectAt(i)));
    }

    public static C5108GetCRL getInstance(Object obj) {
        if (obj instanceof C5108GetCRL) {
            return (C5108GetCRL) obj;
        }
        if (obj != null) {
            return new C5108GetCRL(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public X500Name getIssuerName() {
        return this.issuerName;
    }

    public ReasonFlags getReasons() {
        return this.f18080reasons;
    }

    /* renamed from: getTime */
    public ASN1GeneralizedTime m14492getTime() {
        return this.f18081time;
    }

    public GeneralName getcRLName() {
        return this.f18079cRLName;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(4);
        aSN1EncodableVector.m14420add(this.issuerName);
        GeneralName generalName = this.f18079cRLName;
        if (generalName != null) {
            aSN1EncodableVector.m14420add(generalName);
        }
        ASN1GeneralizedTime aSN1GeneralizedTime = this.f18081time;
        if (aSN1GeneralizedTime != null) {
            aSN1EncodableVector.m14420add(aSN1GeneralizedTime);
        }
        ReasonFlags reasonFlags = this.f18080reasons;
        if (reasonFlags != null) {
            aSN1EncodableVector.m14420add(reasonFlags);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public C5108GetCRL(X500Name x500Name, GeneralName generalName, ASN1GeneralizedTime aSN1GeneralizedTime, ReasonFlags reasonFlags) {
        this.issuerName = x500Name;
        this.f18079cRLName = generalName;
        this.f18081time = aSN1GeneralizedTime;
        this.f18080reasons = reasonFlags;
    }
}
