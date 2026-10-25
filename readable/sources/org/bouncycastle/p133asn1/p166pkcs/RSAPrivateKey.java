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
public class RSAPrivateKey extends ASN1Object {
    private BigInteger coefficient;
    private BigInteger exponent1;
    private BigInteger exponent2;

    /* renamed from: modulus */
    private BigInteger f18516modulus;
    private ASN1Sequence otherPrimeInfos;

    /* renamed from: prime1 */
    private BigInteger f18517prime1;

    /* renamed from: prime2 */
    private BigInteger f18518prime2;
    private BigInteger privateExponent;
    private BigInteger publicExponent;

    /* renamed from: version */
    private BigInteger f18519version;

    public RSAPrivateKey(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5, BigInteger bigInteger6, BigInteger bigInteger7, BigInteger bigInteger8) {
        this.otherPrimeInfos = null;
        this.f18519version = BigInteger.valueOf(0L);
        this.f18516modulus = bigInteger;
        this.publicExponent = bigInteger2;
        this.privateExponent = bigInteger3;
        this.f18517prime1 = bigInteger4;
        this.f18518prime2 = bigInteger5;
        this.exponent1 = bigInteger6;
        this.exponent2 = bigInteger7;
        this.coefficient = bigInteger8;
    }

    public static RSAPrivateKey getInstance(Object obj) {
        if (obj instanceof RSAPrivateKey) {
            return (RSAPrivateKey) obj;
        }
        if (obj != null) {
            return new RSAPrivateKey(ASN1Sequence.getInstance(obj));
        }
        return null;
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
        return this.f18516modulus;
    }

    public BigInteger getPrime1() {
        return this.f18517prime1;
    }

    public BigInteger getPrime2() {
        return this.f18518prime2;
    }

    public BigInteger getPrivateExponent() {
        return this.privateExponent;
    }

    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }

    public BigInteger getVersion() {
        return this.f18519version;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(10);
        aSN1EncodableVector.m14420add(new ASN1Integer(this.f18519version));
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

    private RSAPrivateKey(ASN1Sequence aSN1Sequence) {
        this.otherPrimeInfos = null;
        Enumeration objects = aSN1Sequence.getObjects();
        ASN1Integer aSN1Integer = (ASN1Integer) objects.nextElement();
        int iIntValueExact = aSN1Integer.intValueExact();
        if (iIntValueExact < 0 || iIntValueExact > 1) {
            throw new IllegalArgumentException("wrong version for RSA private key");
        }
        this.f18519version = aSN1Integer.getValue();
        this.f18516modulus = ((ASN1Integer) objects.nextElement()).getValue();
        this.publicExponent = ((ASN1Integer) objects.nextElement()).getValue();
        this.privateExponent = ((ASN1Integer) objects.nextElement()).getValue();
        this.f18517prime1 = ((ASN1Integer) objects.nextElement()).getValue();
        this.f18518prime2 = ((ASN1Integer) objects.nextElement()).getValue();
        this.exponent1 = ((ASN1Integer) objects.nextElement()).getValue();
        this.exponent2 = ((ASN1Integer) objects.nextElement()).getValue();
        this.coefficient = ((ASN1Integer) objects.nextElement()).getValue();
        if (objects.hasMoreElements()) {
            this.otherPrimeInfos = (ASN1Sequence) objects.nextElement();
        }
    }

    public static RSAPrivateKey getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
