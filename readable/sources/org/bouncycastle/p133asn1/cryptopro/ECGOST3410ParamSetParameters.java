package org.bouncycastle.p133asn1.cryptopro;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class ECGOST3410ParamSetParameters extends ASN1Object {

    /* renamed from: a */
    ASN1Integer f18279a;

    /* renamed from: b */
    ASN1Integer f18280b;

    /* renamed from: p */
    ASN1Integer f18281p;

    /* renamed from: q */
    ASN1Integer f18282q;

    /* renamed from: x */
    ASN1Integer f18283x;

    /* renamed from: y */
    ASN1Integer f18284y;

    public ECGOST3410ParamSetParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i, BigInteger bigInteger5) {
        this.f18279a = new ASN1Integer(bigInteger);
        this.f18280b = new ASN1Integer(bigInteger2);
        this.f18281p = new ASN1Integer(bigInteger3);
        this.f18282q = new ASN1Integer(bigInteger4);
        this.f18283x = ASN1Integer.m14429valueOf(i);
        this.f18284y = new ASN1Integer(bigInteger5);
    }

    public static ECGOST3410ParamSetParameters getInstance(Object obj) {
        if (obj == null || (obj instanceof ECGOST3410ParamSetParameters)) {
            return (ECGOST3410ParamSetParameters) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new ECGOST3410ParamSetParameters((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid GOST3410Parameter: " + obj.getClass().getName());
    }

    /* renamed from: getA */
    public BigInteger m14572getA() {
        return this.f18279a.getPositiveValue();
    }

    /* renamed from: getP */
    public BigInteger m14573getP() {
        return this.f18281p.getPositiveValue();
    }

    /* renamed from: getQ */
    public BigInteger m14574getQ() {
        return this.f18282q.getPositiveValue();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(6);
        aSN1EncodableVector.m14420add(this.f18279a);
        aSN1EncodableVector.m14420add(this.f18280b);
        aSN1EncodableVector.m14420add(this.f18281p);
        aSN1EncodableVector.m14420add(this.f18282q);
        aSN1EncodableVector.m14420add(this.f18283x);
        aSN1EncodableVector.m14420add(this.f18284y);
        return new DERSequence(aSN1EncodableVector);
    }

    public ECGOST3410ParamSetParameters(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f18279a = (ASN1Integer) objects.nextElement();
        this.f18280b = (ASN1Integer) objects.nextElement();
        this.f18281p = (ASN1Integer) objects.nextElement();
        this.f18282q = (ASN1Integer) objects.nextElement();
        this.f18283x = (ASN1Integer) objects.nextElement();
        this.f18284y = (ASN1Integer) objects.nextElement();
    }

    public static ECGOST3410ParamSetParameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
