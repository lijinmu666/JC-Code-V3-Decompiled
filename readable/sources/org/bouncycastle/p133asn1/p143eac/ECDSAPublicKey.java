package org.bouncycastle.p133asn1.p143eac;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class ECDSAPublicKey extends PublicKeyDataObject {

    /* renamed from: A */
    private static final int f18349A = 2;

    /* renamed from: B */
    private static final int f18350B = 4;

    /* renamed from: F */
    private static final int f18351F = 64;

    /* renamed from: G */
    private static final int f18352G = 8;

    /* renamed from: P */
    private static final int f18353P = 1;

    /* renamed from: R */
    private static final int f18354R = 16;

    /* renamed from: Y */
    private static final int f18355Y = 32;
    private byte[] basePointG;
    private BigInteger cofactorF;
    private BigInteger firstCoefA;

    /* renamed from: options */
    private int f18356options;
    private BigInteger orderOfBasePointR;
    private BigInteger primeModulusP;
    private byte[] publicPointY;
    private BigInteger secondCoefB;

    /* renamed from: usage */
    private ASN1ObjectIdentifier f18357usage;

    public ECDSAPublicKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, byte[] bArr, BigInteger bigInteger4, byte[] bArr2, int i) {
        this.f18357usage = aSN1ObjectIdentifier;
        setPrimeModulusP(bigInteger);
        setFirstCoefA(bigInteger2);
        setSecondCoefB(bigInteger3);
        setBasePointG(new DEROctetString(bArr));
        setOrderOfBasePointR(bigInteger4);
        setPublicPointY(new DEROctetString(bArr2));
        setCofactorF(BigInteger.valueOf(i));
    }

    private void setBasePointG(ASN1OctetString aSN1OctetString) {
        int i = this.f18356options;
        if ((i & 8) != 0) {
            throw new IllegalArgumentException("Base Point G already set");
        }
        this.f18356options = i | 8;
        this.basePointG = aSN1OctetString.getOctets();
    }

    private void setCofactorF(BigInteger bigInteger) {
        int i = this.f18356options;
        if ((i & 64) != 0) {
            throw new IllegalArgumentException("Cofactor F already set");
        }
        this.f18356options = i | 64;
        this.cofactorF = bigInteger;
    }

    private void setFirstCoefA(BigInteger bigInteger) {
        int i = this.f18356options;
        if ((i & 2) != 0) {
            throw new IllegalArgumentException("First Coef A already set");
        }
        this.f18356options = i | 2;
        this.firstCoefA = bigInteger;
    }

    private void setOrderOfBasePointR(BigInteger bigInteger) {
        int i = this.f18356options;
        if ((i & 16) != 0) {
            throw new IllegalArgumentException("Order of base point R already set");
        }
        this.f18356options = i | 16;
        this.orderOfBasePointR = bigInteger;
    }

    private void setPrimeModulusP(BigInteger bigInteger) {
        int i = this.f18356options;
        if ((i & 1) != 0) {
            throw new IllegalArgumentException("Prime Modulus P already set");
        }
        this.f18356options = i | 1;
        this.primeModulusP = bigInteger;
    }

    private void setPublicPointY(ASN1OctetString aSN1OctetString) {
        int i = this.f18356options;
        if ((i & 32) != 0) {
            throw new IllegalArgumentException("Public Point Y already set");
        }
        this.f18356options = i | 32;
        this.publicPointY = aSN1OctetString.getOctets();
    }

    private void setSecondCoefB(BigInteger bigInteger) {
        int i = this.f18356options;
        if ((i & 4) != 0) {
            throw new IllegalArgumentException("Second Coef B already set");
        }
        this.f18356options = i | 4;
        this.secondCoefB = bigInteger;
    }

    public ASN1EncodableVector getASN1EncodableVector(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(8);
        aSN1EncodableVector.m14420add(aSN1ObjectIdentifier);
        if (!z) {
            aSN1EncodableVector.m14420add(new UnsignedInteger(1, getPrimeModulusP()));
            aSN1EncodableVector.m14420add(new UnsignedInteger(2, getFirstCoefA()));
            aSN1EncodableVector.m14420add(new UnsignedInteger(3, getSecondCoefB()));
            aSN1EncodableVector.m14420add(new DERTaggedObject(false, 4, (ASN1Encodable) new DEROctetString(getBasePointG())));
            aSN1EncodableVector.m14420add(new UnsignedInteger(5, getOrderOfBasePointR()));
        }
        aSN1EncodableVector.m14420add(new DERTaggedObject(false, 6, (ASN1Encodable) new DEROctetString(getPublicPointY())));
        if (!z) {
            aSN1EncodableVector.m14420add(new UnsignedInteger(7, getCofactorF()));
        }
        return aSN1EncodableVector;
    }

    public byte[] getBasePointG() {
        if ((this.f18356options & 8) != 0) {
            return C6238Arrays.m18231clone(this.basePointG);
        }
        return null;
    }

    public BigInteger getCofactorF() {
        if ((this.f18356options & 64) != 0) {
            return this.cofactorF;
        }
        return null;
    }

    public BigInteger getFirstCoefA() {
        if ((this.f18356options & 2) != 0) {
            return this.firstCoefA;
        }
        return null;
    }

    public BigInteger getOrderOfBasePointR() {
        if ((this.f18356options & 16) != 0) {
            return this.orderOfBasePointR;
        }
        return null;
    }

    public BigInteger getPrimeModulusP() {
        if ((this.f18356options & 1) != 0) {
            return this.primeModulusP;
        }
        return null;
    }

    public byte[] getPublicPointY() {
        if ((this.f18356options & 32) != 0) {
            return C6238Arrays.m18231clone(this.publicPointY);
        }
        return null;
    }

    public BigInteger getSecondCoefB() {
        if ((this.f18356options & 4) != 0) {
            return this.secondCoefB;
        }
        return null;
    }

    @Override // org.bouncycastle.p133asn1.p143eac.PublicKeyDataObject
    public ASN1ObjectIdentifier getUsage() {
        return this.f18357usage;
    }

    public boolean hasParameters() {
        return this.primeModulusP != null;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(getASN1EncodableVector(this.f18357usage, !hasParameters()));
    }

    public ECDSAPublicKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, byte[] bArr) {
        this.f18357usage = aSN1ObjectIdentifier;
        setPublicPointY(new DEROctetString(bArr));
    }

    public ECDSAPublicKey(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f18357usage = ASN1ObjectIdentifier.getInstance(objects.nextElement());
        this.f18356options = 0;
        while (objects.hasMoreElements()) {
            Object objNextElement = objects.nextElement();
            if (!(objNextElement instanceof ASN1TaggedObject)) {
                throw new IllegalArgumentException("Unknown Object Identifier!");
            }
            ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) objNextElement;
            switch (aSN1TaggedObject.getTagNo()) {
                case 1:
                    setPrimeModulusP(UnsignedInteger.getInstance(aSN1TaggedObject).getValue());
                    break;
                case 2:
                    setFirstCoefA(UnsignedInteger.getInstance(aSN1TaggedObject).getValue());
                    break;
                case 3:
                    setSecondCoefB(UnsignedInteger.getInstance(aSN1TaggedObject).getValue());
                    break;
                case 4:
                    setBasePointG(ASN1OctetString.getInstance(aSN1TaggedObject, false));
                    break;
                case 5:
                    setOrderOfBasePointR(UnsignedInteger.getInstance(aSN1TaggedObject).getValue());
                    break;
                case 6:
                    setPublicPointY(ASN1OctetString.getInstance(aSN1TaggedObject, false));
                    break;
                case 7:
                    setCofactorF(UnsignedInteger.getInstance(aSN1TaggedObject).getValue());
                    break;
                default:
                    this.f18356options = 0;
                    throw new IllegalArgumentException("Unknown Object Identifier!");
            }
        }
        int i = this.f18356options;
        if (i != 32 && i != 127) {
            throw new IllegalArgumentException("All options must be either present or absent!");
        }
    }
}
