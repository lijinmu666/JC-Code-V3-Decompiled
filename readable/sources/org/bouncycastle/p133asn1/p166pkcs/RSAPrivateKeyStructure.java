package org.bouncycastle.p133asn1.p166pkcs;

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
public class RSAPrivateKeyStructure extends ASN1Object {
    private BigInteger coefficient;
    private BigInteger exponent1;
    private BigInteger exponent2;

    /* renamed from: modulus */
    private BigInteger f18520modulus;
    private ASN1Sequence otherPrimeInfos;

    /* renamed from: prime1 */
    private BigInteger f18521prime1;

    /* renamed from: prime2 */
    private BigInteger f18522prime2;
    private BigInteger privateExponent;
    private BigInteger publicExponent;

    /* renamed from: version */
    private int f18523version;

    public RSAPrivateKeyStructure(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8) {
        this.otherPrimeInfos = null;
        this.f18523version = 0;
        this.f18520modulus = bigInteger;
        this.publicExponent = bigInteger2;
        this.privateExponent = bigInteger3;
        this.f18521prime1 = bigInteger4;
        this.f18522prime2 = bigInteger5;
        this.exponent1 = bigInteger6;
        this.exponent2 = bigInteger7;
        this.coefficient = bigInteger8;
    }

    public static RSAPrivateKeyStructure getInstance(Object obj) {
        if (obj instanceof RSAPrivateKeyStructure) {
            return (RSAPrivateKeyStructure) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new RSAPrivateKeyStructure((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public BigInteger getCoefficient() {
        return this.coefficient;
    }

    public BigInteger getExponent1() {
        return this.exponent1;
    }

    public BigInteger getExponent2() {
        return this.exponent2;
    }

    public BigInteger getModulus() {
        return this.f18520modulus;
    }

    public BigInteger getPrime1() {
        return this.f18521prime1;
    }

    public BigInteger getPrime2() {
        return this.f18522prime2;
    }

    public BigInteger getPrivateExponent() {
        return this.privateExponent;
    }

    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }

    public int getVersion() {
        return this.f18523version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(10);
        aSN1EncodableVector.m14420add(ASN1Integer.m14429valueOf(this.f18523version));
        aSN1EncodableVector.m14420add(new ASN1Integer(getModulus()));
        aSN1EncodableVector.m14420add(new ASN1Integer(getPublicExponent()));
        aSN1EncodableVector.m14420add(new ASN1Integer(getPrivateExponent()));
        aSN1EncodableVector.m14420add(new ASN1Integer(getPrime1()));
        aSN1EncodableVector.m14420add(new ASN1Integer(getPrime2()));
        aSN1EncodableVector.m14420add(new ASN1Integer(getExponent1()));
        aSN1EncodableVector.m14420add(new ASN1Integer(getExponent2()));
        aSN1EncodableVector.m14420add(new ASN1Integer(getCoefficient()));
        ASN1Sequence aSN1Sequence = this.otherPrimeInfos;
        if (aSN1Sequence != null) {
            aSN1EncodableVector.m14420add(aSN1Sequence);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public RSAPrivateKeyStructure(ASN1Sequence aSN1Sequence) {
        this.otherPrimeInfos = null;
        Enumeration objects = aSN1Sequence.getObjects();
        int iIntValueExact = ((ASN1Integer) objects.nextElement()).intValueExact();
        if (iIntValueExact < 0 || iIntValueExact > 1) {
            throw new IllegalArgumentException("wrong version for RSA private key");
        }
        this.f18523version = iIntValueExact;
        this.f18520modulus = ((ASN1Integer) objects.nextElement()).getValue();
        this.publicExponent = ((ASN1Integer) objects.nextElement()).getValue();
        this.privateExponent = ((ASN1Integer) objects.nextElement()).getValue();
        this.f18521prime1 = ((ASN1Integer) objects.nextElement()).getValue();
        this.f18522prime2 = ((ASN1Integer) objects.nextElement()).getValue();
        this.exponent1 = ((ASN1Integer) objects.nextElement()).getValue();
        this.exponent2 = ((ASN1Integer) objects.nextElement()).getValue();
        this.coefficient = ((ASN1Integer) objects.nextElement()).getValue();
        if (objects.hasMoreElements()) {
            this.otherPrimeInfos = (ASN1Sequence) objects.nextElement();
        }
    }

    public static RSAPrivateKeyStructure getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
