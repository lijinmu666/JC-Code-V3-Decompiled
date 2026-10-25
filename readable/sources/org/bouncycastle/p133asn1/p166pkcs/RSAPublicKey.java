package org.bouncycastle.p133asn1.p166pkcs;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class RSAPublicKey extends ASN1Object {

    /* renamed from: modulus */
    private BigInteger f18524modulus;
    private BigInteger publicExponent;

    public RSAPublicKey(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f18524modulus = bigInteger;
        this.publicExponent = bigInteger2;
    }

    public static RSAPublicKey getInstance(Object obj) {
        if (obj instanceof RSAPublicKey) {
            return (RSAPublicKey) obj;
        }
        if (obj != null) {
            return new RSAPublicKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BigInteger getModulus() {
        return this.f18524modulus;
    }

    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Integer(getModulus()), new ASN1Integer(getPublicExponent()));
    }

    private RSAPublicKey(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() == 2) {
            Enumeration objects = aSN1Sequence.getObjects();
            this.f18524modulus = ASN1Integer.getInstance(objects.nextElement()).getPositiveValue();
            this.publicExponent = ASN1Integer.getInstance(objects.nextElement()).getPositiveValue();
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.mo14450size());
        }
    }

    public static RSAPublicKey getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
