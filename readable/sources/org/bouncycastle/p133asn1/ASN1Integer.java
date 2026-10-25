package org.bouncycastle.p133asn1;

import java.math.BigInteger;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Properties;
import p094kotlin.C1126UByte;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* loaded from: classes.dex */
public class ASN1Integer extends ASN1Primitive {

    /* renamed from: FIVE */
    public static final ASN1Integer f17916FIVE;

    /* renamed from: FOUR */
    public static final ASN1Integer f17917FOUR;

    /* renamed from: ONE */
    public static final ASN1Integer f17918ONE;
    static final int SIGN_EXT_SIGNED = -1;
    static final int SIGN_EXT_UNSIGNED = 255;

    /* renamed from: THREE */
    public static final ASN1Integer f17919THREE;

    /* renamed from: TWO */
    public static final ASN1Integer f17920TWO;

    /* renamed from: ZERO */
    public static final ASN1Integer f17922ZERO;

    /* renamed from: bytes */
    private final byte[] f17923bytes;

    /* renamed from: start */
    private final int f17924start;

    /* renamed from: TYPE */
    static final ASN1UniversalType f17921TYPE = new ASN1UniversalType(ASN1Integer.class, 2) { // from class: org.bouncycastle.asn1.ASN1Integer.1
        @Override // org.bouncycastle.p133asn1.ASN1UniversalType
        public ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return ASN1Integer.createPrimitive(dEROctetString.getOctets());
        }
    };
    private static final ASN1Integer[] SMALL_CONSTANTS = new ASN1Integer[17];

    static {
        int i = 0;
        while (true) {
            ASN1Integer[] aSN1IntegerArr = SMALL_CONSTANTS;
            if (i >= aSN1IntegerArr.length) {
                f17922ZERO = aSN1IntegerArr[0];
                f17918ONE = aSN1IntegerArr[1];
                f17920TWO = aSN1IntegerArr[2];
                f17919THREE = aSN1IntegerArr[3];
                f17917FOUR = aSN1IntegerArr[4];
                f17916FIVE = aSN1IntegerArr[5];
                return;
            }
            aSN1IntegerArr[i] = new ASN1Integer(i);
            i++;
        }
    }

    public ASN1Integer(int i) {
        this.f17923bytes = BigInteger.valueOf(i).toByteArray();
        this.f17924start = 0;
    }

    public static ASN1Integer createPrimitive(byte[] bArr) {
        return new ASN1Integer(bArr, false);
    }

    public static ASN1Integer getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1Integer)) {
            return (ASN1Integer) obj;
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (ASN1Integer) f17921TYPE.fromByteArray((byte[]) obj);
        } catch (Exception e) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
        }
    }

    public static ASN1Integer getTagged(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1Integer) f17921TYPE.getTagged(aSN1TaggedObject, z);
    }

    public static int intValue(byte[] bArr, int i, int i2) {
        int length = bArr.length;
        int iMax = Math.max(i, length - 4);
        int i3 = i2 & bArr[iMax];
        while (true) {
            iMax++;
            if (iMax >= length) {
                return i3;
            }
            i3 = (i3 << 8) | (bArr[iMax] & 255);
        }
    }

    public static boolean isMalformed(byte[] bArr) {
        int length = bArr.length;
        if (length == 0) {
            return true;
        }
        if (length != 1) {
            return bArr[0] == (bArr[1] >> 7) && !Properties.isOverrideSet("org.bouncycastle.asn1.allow_unsafe_integer");
        }
        return false;
    }

    public static long longValue(byte[] bArr, int i, int i2) {
        int length = bArr.length;
        int iMax = Math.max(i, length - 8);
        long j = i2 & bArr[iMax];
        while (true) {
            iMax++;
            if (iMax >= length) {
                return j;
            }
            j = (j << 8) | (bArr[iMax] & C1126UByte.MAX_VALUE);
        }
    }

    public static int signBytesToSkip(byte[] bArr) {
        int length = bArr.length - 1;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            if (bArr[i] != (bArr[i2] >> 7)) {
                break;
            }
            i = i2;
        }
        return i;
    }

    /* renamed from: valueOf */
    public static ASN1Integer m14429valueOf(int i) {
        if (i >= 0) {
            ASN1Integer[] aSN1IntegerArr = SMALL_CONSTANTS;
            if (i < aSN1IntegerArr.length) {
                return aSN1IntegerArr[i];
            }
        }
        return new ASN1Integer(i);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof ASN1Integer) {
            return C6238Arrays.areEqual(this.f17923bytes, ((ASN1Integer) aSN1Primitive).f17923bytes);
        }
        return false;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    /* renamed from: encode */
    public void mo14417encode(ASN1OutputStream aSN1OutputStream, boolean z) {
        aSN1OutputStream.writeEncodingDL(z, 2, this.f17923bytes);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public int encodedLength(boolean z) {
        return ASN1OutputStream.getLengthOfEncodingDL(z, this.f17923bytes.length);
    }

    public BigInteger getPositiveValue() {
        return new BigInteger(1, this.f17923bytes);
    }

    public BigInteger getValue() {
        return new BigInteger(this.f17923bytes);
    }

    public boolean hasValue(int i) {
        byte[] bArr = this.f17923bytes;
        int length = bArr.length;
        int i2 = this.f17924start;
        return length - i2 <= 4 && intValue(bArr, i2, -1) == i;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive, org.bouncycastle.p133asn1.ASN1Object
    public int hashCode() {
        return C6238Arrays.hashCode(this.f17923bytes);
    }

    public int intPositiveValueExact() {
        byte[] bArr = this.f17923bytes;
        int length = bArr.length;
        int i = this.f17924start;
        int i2 = length - i;
        if (i2 > 4 || (i2 == 4 && (bArr[i] & ByteCompanionObject.MIN_VALUE) != 0)) {
            throw new ArithmeticException("ASN.1 Integer out of positive int range");
        }
        return intValue(bArr, i, 255);
    }

    public int intValueExact() {
        byte[] bArr = this.f17923bytes;
        int length = bArr.length;
        int i = this.f17924start;
        if (length - i <= 4) {
            return intValue(bArr, i, -1);
        }
        throw new ArithmeticException("ASN.1 Integer out of int range");
    }

    public long longValueExact() {
        byte[] bArr = this.f17923bytes;
        int length = bArr.length;
        int i = this.f17924start;
        if (length - i <= 8) {
            return longValue(bArr, i, -1);
        }
        throw new ArithmeticException("ASN.1 Integer out of long range");
    }

    public String toString() {
        return getValue().toString();
    }

    public ASN1Integer(long j) {
        this.f17923bytes = BigInteger.valueOf(j).toByteArray();
        this.f17924start = 0;
    }

    public static ASN1Integer getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1Integer) f17921TYPE.getContextTagged(aSN1TaggedObject, z);
    }

    /* renamed from: valueOf */
    public static ASN1Integer m14430valueOf(long j) {
        if (j >= 0) {
            ASN1Integer[] aSN1IntegerArr = SMALL_CONSTANTS;
            if (j < aSN1IntegerArr.length) {
                return aSN1IntegerArr[(int) j];
            }
        }
        return new ASN1Integer(j);
    }

    public boolean hasValue(long j) {
        byte[] bArr = this.f17923bytes;
        int length = bArr.length;
        int i = this.f17924start;
        return length - i <= 8 && longValue(bArr, i, -1) == j;
    }

    public ASN1Integer(BigInteger bigInteger) {
        this.f17923bytes = bigInteger.toByteArray();
        this.f17924start = 0;
    }

    public boolean hasValue(BigInteger bigInteger) {
        return bigInteger != null && intValue(this.f17923bytes, this.f17924start, -1) == bigInteger.intValue() && getValue().equals(bigInteger);
    }

    public ASN1Integer(byte[] bArr) {
        this(bArr, true);
    }

    public ASN1Integer(byte[] bArr, boolean z) {
        if (isMalformed(bArr)) {
            throw new IllegalArgumentException("malformed integer");
        }
        this.f17923bytes = z ? C6238Arrays.m18231clone(bArr) : bArr;
        this.f17924start = signBytesToSkip(bArr);
    }
}
