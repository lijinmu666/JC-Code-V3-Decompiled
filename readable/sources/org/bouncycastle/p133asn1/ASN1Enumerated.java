package org.bouncycastle.p133asn1;

import java.math.BigInteger;
import org.bouncycastle.p361util.C6238Arrays;
import p094kotlin.C1126UByte;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* loaded from: classes.dex */
public class ASN1Enumerated extends ASN1Primitive {

    /* renamed from: TYPE */
    static final ASN1UniversalType f17904TYPE = new ASN1UniversalType(ASN1Enumerated.class, 10) { // from class: org.bouncycastle.asn1.ASN1Enumerated.1
        @Override // org.bouncycastle.p133asn1.ASN1UniversalType
        public ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return ASN1Enumerated.createPrimitive(dEROctetString.getOctets(), false);
        }
    };

    /* renamed from: cache */
    private static final ASN1Enumerated[] f17905cache = new ASN1Enumerated[12];
    private final byte[] contents;

    /* renamed from: start */
    private final int f17906start;

    public ASN1Enumerated(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("enumerated must be non-negative");
        }
        this.contents = BigInteger.valueOf(i).toByteArray();
        this.f17906start = 0;
    }

    public static ASN1Enumerated createPrimitive(byte[] bArr, boolean z) {
        if (bArr.length > 1) {
            return new ASN1Enumerated(bArr, z);
        }
        if (bArr.length == 0) {
            throw new IllegalArgumentException("ENUMERATED has zero length");
        }
        int i = bArr[0] & C1126UByte.MAX_VALUE;
        ASN1Enumerated[] aSN1EnumeratedArr = f17905cache;
        if (i >= aSN1EnumeratedArr.length) {
            return new ASN1Enumerated(bArr, z);
        }
        ASN1Enumerated aSN1Enumerated = aSN1EnumeratedArr[i];
        if (aSN1Enumerated != null) {
            return aSN1Enumerated;
        }
        ASN1Enumerated aSN1Enumerated2 = new ASN1Enumerated(bArr, z);
        aSN1EnumeratedArr[i] = aSN1Enumerated2;
        return aSN1Enumerated2;
    }

    public static ASN1Enumerated getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1Enumerated)) {
            return (ASN1Enumerated) obj;
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (ASN1Enumerated) f17904TYPE.fromByteArray((byte[]) obj);
        } catch (Exception e) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
        }
    }

    public static ASN1Enumerated getTagged(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1Enumerated) f17904TYPE.getTagged(aSN1TaggedObject, z);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof ASN1Enumerated) {
            return C6238Arrays.areEqual(this.contents, ((ASN1Enumerated) aSN1Primitive).contents);
        }
        return false;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    /* renamed from: encode */
    public void mo14417encode(ASN1OutputStream aSN1OutputStream, boolean z) {
        aSN1OutputStream.writeEncodingDL(z, 10, this.contents);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public int encodedLength(boolean z) {
        return ASN1OutputStream.getLengthOfEncodingDL(z, this.contents.length);
    }

    public BigInteger getValue() {
        return new BigInteger(this.contents);
    }

    public boolean hasValue(int i) {
        byte[] bArr = this.contents;
        int length = bArr.length;
        int i2 = this.f17906start;
        return length - i2 <= 4 && ASN1Integer.intValue(bArr, i2, -1) == i;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive, org.bouncycastle.p133asn1.ASN1Object
    public int hashCode() {
        return C6238Arrays.hashCode(this.contents);
    }

    public int intValueExact() {
        byte[] bArr = this.contents;
        int length = bArr.length;
        int i = this.f17906start;
        if (length - i <= 4) {
            return ASN1Integer.intValue(bArr, i, -1);
        }
        throw new ArithmeticException("ASN.1 Enumerated out of int range");
    }

    public ASN1Enumerated(BigInteger bigInteger) {
        if (bigInteger.signum() < 0) {
            throw new IllegalArgumentException("enumerated must be non-negative");
        }
        this.contents = bigInteger.toByteArray();
        this.f17906start = 0;
    }

    public static ASN1Enumerated getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1Enumerated) f17904TYPE.getContextTagged(aSN1TaggedObject, z);
    }

    public boolean hasValue(BigInteger bigInteger) {
        return bigInteger != null && ASN1Integer.intValue(this.contents, this.f17906start, -1) == bigInteger.intValue() && getValue().equals(bigInteger);
    }

    public ASN1Enumerated(byte[] bArr) {
        this(bArr, true);
    }

    public ASN1Enumerated(byte[] bArr, boolean z) {
        if (ASN1Integer.isMalformed(bArr)) {
            throw new IllegalArgumentException("malformed enumerated");
        }
        if ((bArr[0] & ByteCompanionObject.MIN_VALUE) != 0) {
            throw new IllegalArgumentException("enumerated must be non-negative");
        }
        this.contents = z ? C6238Arrays.m18231clone(bArr) : bArr;
        this.f17906start = ASN1Integer.signBytesToSkip(bArr);
    }
}
