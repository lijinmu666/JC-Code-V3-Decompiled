package org.bouncycastle.p133asn1.p166pkcs;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class DHParameter extends ASN1Object {

    /* renamed from: g */
    ASN1Integer f18470g;

    /* renamed from: l */
    ASN1Integer f18471l;

    /* renamed from: p */
    ASN1Integer f18472p;

    public DHParameter(BigInteger bigInteger, BigInteger bigInteger2, int i) {
        this.f18472p = new ASN1Integer(bigInteger);
        this.f18470g = new ASN1Integer(bigInteger2);
        this.f18471l = i != 0 ? ASN1Integer.m14429valueOf(i) : null;
    }

    public static DHParameter getInstance(Object obj) {
        if (obj instanceof DHParameter) {
            return (DHParameter) obj;
        }
        if (obj != null) {
            return new DHParameter(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getG */
    public BigInteger m14627getG() {
        return this.f18470g.getPositiveValue();
    }

    /* renamed from: getL */
    public BigInteger m14628getL() {
        ASN1Integer aSN1Integer = this.f18471l;
        if (aSN1Integer == null) {
            return null;
        }
        return aSN1Integer.getPositiveValue();
    }

    /* renamed from: getP */
    public BigInteger m14629getP() {
        return this.f18472p.getPositiveValue();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(this.f18472p);
        aSN1EncodableVector.m14420add(this.f18470g);
        if (m14628getL() != null) {
            aSN1EncodableVector.m14420add(this.f18471l);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    private DHParameter(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f18472p = ASN1Integer.getInstance(objects.nextElement());
        this.f18470g = ASN1Integer.getInstance(objects.nextElement());
        this.f18471l = objects.hasMoreElements() ? (ASN1Integer) objects.nextElement() : null;
    }
}
