package org.bouncycastle.p133asn1.p142dvcs;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p174x509.DigestInfo;

/* renamed from: org.bouncycastle.asn1.dvcs.Data */
/* loaded from: classes2.dex */
public class C5124Data extends ASN1Object implements ASN1Choice {

    /* renamed from: certs */
    private ASN1Sequence f18317certs;

    /* renamed from: message */
    private ASN1OctetString f18318message;
    private DigestInfo messageImprint;

    public C5124Data(ASN1OctetString aSN1OctetString) {
        this.f18318message = aSN1OctetString;
    }

    public static C5124Data getInstance(Object obj) {
        if (obj instanceof C5124Data) {
            return (C5124Data) obj;
        }
        if (obj instanceof ASN1OctetString) {
            return new C5124Data((ASN1OctetString) obj);
        }
        if (obj instanceof ASN1Sequence) {
            return new C5124Data(DigestInfo.getInstance(obj));
        }
        if (obj instanceof ASN1TaggedObject) {
            return new C5124Data(ASN1Sequence.getInstance((ASN1TaggedObject) obj, false));
        }
        throw new IllegalArgumentException("Unknown object submitted to getInstance: " + obj.getClass().getName());
    }

    public TargetEtcChain[] getCerts() {
        ASN1Sequence aSN1Sequence = this.f18317certs;
        if (aSN1Sequence == null) {
            return null;
        }
        int iMo14450size = aSN1Sequence.mo14450size();
        TargetEtcChain[] targetEtcChainArr = new TargetEtcChain[iMo14450size];
        for (int i = 0; i != iMo14450size; i++) {
            targetEtcChainArr[i] = TargetEtcChain.getInstance(this.f18317certs.getObjectAt(i));
        }
        return targetEtcChainArr;
    }

    public ASN1OctetString getMessage() {
        return this.f18318message;
    }

    public DigestInfo getMessageImprint() {
        return this.messageImprint;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1OctetString aSN1OctetString = this.f18318message;
        if (aSN1OctetString != null) {
            return aSN1OctetString.toASN1Primitive();
        }
        DigestInfo digestInfo = this.messageImprint;
        return digestInfo != null ? digestInfo.toASN1Primitive() : new DERTaggedObject(false, 0, (ASN1Encodable) this.f18317certs);
    }

    public String toString() {
        StringBuilder sb;
        Object obj;
        if (this.f18318message != null) {
            sb = new StringBuilder();
            sb.append("Data {\n");
            obj = this.f18318message;
        } else if (this.messageImprint != null) {
            sb = new StringBuilder();
            sb.append("Data {\n");
            obj = this.messageImprint;
        } else {
            sb = new StringBuilder();
            sb.append("Data {\n");
            obj = this.f18317certs;
        }
        sb.append(obj);
        sb.append("}\n");
        return sb.toString();
    }

    private C5124Data(ASN1Sequence aSN1Sequence) {
        this.f18317certs = aSN1Sequence;
    }

    public static C5124Data getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getExplicitBaseObject());
    }

    public C5124Data(TargetEtcChain targetEtcChain) {
        this.f18317certs = new DERSequence(targetEtcChain);
    }

    public C5124Data(DigestInfo digestInfo) {
        this.messageImprint = digestInfo;
    }

    public C5124Data(byte[] bArr) {
        this.f18318message = new DEROctetString(bArr);
    }

    public C5124Data(TargetEtcChain[] targetEtcChainArr) {
        this.f18317certs = new DERSequence(targetEtcChainArr);
    }
}
