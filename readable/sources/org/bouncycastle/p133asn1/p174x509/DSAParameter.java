package org.bouncycastle.p133asn1.p174x509;

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
public class DSAParameter extends ASN1Object {

    /* renamed from: g */
    ASN1Integer f18640g;

    /* renamed from: p */
    ASN1Integer f18641p;

    /* renamed from: q */
    ASN1Integer f18642q;

    public DSAParameter(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f18641p = new ASN1Integer(bigInteger);
        this.f18642q = new ASN1Integer(bigInteger2);
        this.f18640g = new ASN1Integer(bigInteger3);
    }

    public static DSAParameter getInstance(Object obj) {
        if (obj instanceof DSAParameter) {
            return (DSAParameter) obj;
        }
        if (obj != null) {
            return new DSAParameter(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getG */
    public BigInteger m14679getG() {
        return this.f18640g.getPositiveValue();
    }

    /* renamed from: getP */
    public BigInteger m14680getP() {
        return this.f18641p.getPositiveValue();
    }

    /* renamed from: getQ */
    public BigInteger m14681getQ() {
        return this.f18642q.getPositiveValue();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(this.f18641p);
        aSN1EncodableVector.m14420add(this.f18642q);
        aSN1EncodableVector.m14420add(this.f18640g);
        return new DERSequence(aSN1EncodableVector);
    }

    private DSAParameter(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 3) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.mo14450size());
        }
        Enumeration objects = aSN1Sequence.getObjects();
        this.f18641p = ASN1Integer.getInstance(objects.nextElement());
        this.f18642q = ASN1Integer.getInstance(objects.nextElement());
        this.f18640g = ASN1Integer.getInstance(objects.nextElement());
    }

    public static DSAParameter getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
