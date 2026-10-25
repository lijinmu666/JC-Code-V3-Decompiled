package org.bouncycastle.p133asn1.p143eac;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class RSAPublicKey extends PublicKeyDataObject {
    private static int exponentValid = 2;
    private static int modulusValid = 1;
    private BigInteger exponent;

    /* renamed from: modulus */
    private BigInteger f18362modulus;

    /* renamed from: usage */
    private ASN1ObjectIdentifier f18363usage;

    /* renamed from: valid */
    private int f18364valid = 0;

    public RSAPublicKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, BigInteger bigInteger, BigInteger bigInteger2) {
        this.f18363usage = aSN1ObjectIdentifier;
        this.f18362modulus = bigInteger;
        this.exponent = bigInteger2;
    }

    private void setExponent(UnsignedInteger unsignedInteger) {
        int i = this.f18364valid;
        int i2 = exponentValid;
        if ((i & i2) != 0) {
            throw new IllegalArgumentException("Exponent already set");
        }
        this.f18364valid = i | i2;
        this.exponent = unsignedInteger.getValue();
    }

    private void setModulus(UnsignedInteger unsignedInteger) {
        int i = this.f18364valid;
        int i2 = modulusValid;
        if ((i & i2) != 0) {
            throw new IllegalArgumentException("Modulus already set");
        }
        this.f18364valid = i | i2;
        this.f18362modulus = unsignedInteger.getValue();
    }

    public BigInteger getModulus() {
        return this.f18362modulus;
    }

    public BigInteger getPublicExponent() {
        return this.exponent;
    }

    @Override // org.bouncycastle.p133asn1.p143eac.PublicKeyDataObject
    public ASN1ObjectIdentifier getUsage() {
        return this.f18363usage;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(this.f18363usage);
        aSN1EncodableVector.m14420add(new UnsignedInteger(1, getModulus()));
        aSN1EncodableVector.m14420add(new UnsignedInteger(2, getPublicExponent()));
        return new DERSequence(aSN1EncodableVector);
    }

    public RSAPublicKey(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f18363usage = ASN1ObjectIdentifier.getInstance(objects.nextElement());
        while (objects.hasMoreElements()) {
            UnsignedInteger unsignedInteger = UnsignedInteger.getInstance(objects.nextElement());
            int tagNo = unsignedInteger.getTagNo();
            if (tagNo == 1) {
                setModulus(unsignedInteger);
            } else {
                if (tagNo != 2) {
                    throw new IllegalArgumentException("Unknown DERTaggedObject :" + unsignedInteger.getTagNo() + "-> not an Iso7816RSAPublicKeyStructure");
                }
                setExponent(unsignedInteger);
            }
        }
        if (this.f18364valid != 3) {
            throw new IllegalArgumentException("missing argument -> not an Iso7816RSAPublicKeyStructure");
        }
    }
}
