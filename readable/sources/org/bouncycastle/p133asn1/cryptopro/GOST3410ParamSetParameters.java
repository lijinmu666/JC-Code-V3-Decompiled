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
public class GOST3410ParamSetParameters extends ASN1Object {

    /* renamed from: a */
    ASN1Integer f18289a;

    /* renamed from: keySize */
    int f18290keySize;

    /* renamed from: p */
    ASN1Integer f18291p;

    /* renamed from: q */
    ASN1Integer f18292q;

    public GOST3410ParamSetParameters(int i, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f18290keySize = i;
        this.f18291p = new ASN1Integer(bigInteger);
        this.f18292q = new ASN1Integer(bigInteger2);
        this.f18289a = new ASN1Integer(bigInteger3);
    }

    public static GOST3410ParamSetParameters getInstance(Object obj) {
        if (obj == null || (obj instanceof GOST3410ParamSetParameters)) {
            return (GOST3410ParamSetParameters) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new GOST3410ParamSetParameters((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid GOST3410Parameter: " + obj.getClass().getName());
    }

    /* renamed from: getA */
    public BigInteger m14577getA() {
        return this.f18289a.getPositiveValue();
    }

    public int getKeySize() {
        return this.f18290keySize;
    }

    public int getLKeySize() {
        return this.f18290keySize;
    }

    /* renamed from: getP */
    public BigInteger m14578getP() {
        return this.f18291p.getPositiveValue();
    }

    /* renamed from: getQ */
    public BigInteger m14579getQ() {
        return this.f18292q.getPositiveValue();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(4);
        aSN1EncodableVector.m14420add(ASN1Integer.m14429valueOf(this.f18290keySize));
        aSN1EncodableVector.m14420add(this.f18291p);
        aSN1EncodableVector.m14420add(this.f18292q);
        aSN1EncodableVector.m14420add(this.f18289a);
        return new DERSequence(aSN1EncodableVector);
    }

    public GOST3410ParamSetParameters(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f18290keySize = ((ASN1Integer) objects.nextElement()).intValueExact();
        this.f18291p = (ASN1Integer) objects.nextElement();
        this.f18292q = (ASN1Integer) objects.nextElement();
        this.f18289a = (ASN1Integer) objects.nextElement();
    }

    public static GOST3410ParamSetParameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
