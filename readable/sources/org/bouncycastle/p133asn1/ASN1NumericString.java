package org.bouncycastle.p133asn1;

import org.bouncycastle.p133asn1.p143eac.C5125EACTags;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes.dex */
public abstract class ASN1NumericString extends ASN1Primitive implements ASN1String {

    /* renamed from: TYPE */
    static final ASN1UniversalType f17926TYPE = new ASN1UniversalType(ASN1NumericString.class, 18) { // from class: org.bouncycastle.asn1.ASN1NumericString.1
        @Override // org.bouncycastle.p133asn1.ASN1UniversalType
        public ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return ASN1NumericString.createPrimitive(dEROctetString.getOctets());
        }
    };
    final byte[] contents;

    public ASN1NumericString(String str, boolean z) {
        if (z && !isNumericString(str)) {
            throw new IllegalArgumentException("string contains illegal characters");
        }
        this.contents = C6250Strings.toByteArray(str);
    }

    public static ASN1NumericString createPrimitive(byte[] bArr) {
        return new DERNumericString(bArr, false);
    }

    public static ASN1NumericString getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1NumericString)) {
            return (ASN1NumericString) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1NumericString) {
                return (ASN1NumericString) aSN1Primitive;
            }
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (ASN1NumericString) f17926TYPE.fromByteArray((byte[]) obj);
        } catch (Exception e) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
        }
    }

    public static ASN1NumericString getTagged(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1NumericString) f17926TYPE.getTagged(aSN1TaggedObject, z);
    }

    public static boolean isNumericString(String str) {
        for (int length = str.length() - 1; length >= 0; length--) {
            char cCharAt = str.charAt(length);
            if (cCharAt > 127) {
                return false;
            }
            if (('0' > cCharAt || cCharAt > '9') && cCharAt != ' ') {
                return false;
            }
        }
        return true;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public final boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof ASN1NumericString) {
            return C6238Arrays.areEqual(this.contents, ((ASN1NumericString) aSN1Primitive).contents);
        }
        return false;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    /* renamed from: encode */
    public final void mo14417encode(ASN1OutputStream aSN1OutputStream, boolean z) {
        aSN1OutputStream.writeEncodingDL(z, 18, this.contents);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public final boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public final int encodedLength(boolean z) {
        return ASN1OutputStream.getLengthOfEncodingDL(z, this.contents.length);
    }

    public final byte[] getOctets() {
        return C6238Arrays.m18231clone(this.contents);
    }

    @Override // org.bouncycastle.p133asn1.ASN1String
    public final String getString() {
        return C6250Strings.fromByteArray(this.contents);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive, org.bouncycastle.p133asn1.ASN1Object
    public final int hashCode() {
        return C6238Arrays.hashCode(this.contents);
    }

    public String toString() {
        return getString();
    }

    public ASN1NumericString(byte[] bArr, boolean z) {
        this.contents = z ? C6238Arrays.m18231clone(bArr) : bArr;
    }

    public static ASN1NumericString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1NumericString) f17926TYPE.getContextTagged(aSN1TaggedObject, z);
    }

    public static boolean isNumericString(byte[] bArr) {
        for (byte b : bArr) {
            if (b != 32) {
                switch (b) {
                    case 48:
                    case 49:
                    case 50:
                    case C5125EACTags.TRANSACTION_DATE /* 51 */:
                    case C5125EACTags.CARD_SEQUENCE_NUMBER /* 52 */:
                    case C5125EACTags.f18346SEX /* 53 */:
                    case C5125EACTags.CURRENCY_EXPONENT /* 54 */:
                    case 55:
                    case 56:
                    case 57:
                        break;
                    default:
                        return false;
                }
            }
        }
        return true;
    }
}
