package org.bouncycastle.p133asn1;

import org.bouncycastle.p133asn1.p143eac.C5125EACTags;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes.dex */
public abstract class ASN1PrintableString extends ASN1Primitive implements ASN1String {

    /* renamed from: TYPE */
    static final ASN1UniversalType f17935TYPE = new ASN1UniversalType(ASN1PrintableString.class, 19) { // from class: org.bouncycastle.asn1.ASN1PrintableString.1
        @Override // org.bouncycastle.p133asn1.ASN1UniversalType
        public ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return ASN1PrintableString.createPrimitive(dEROctetString.getOctets());
        }
    };
    final byte[] contents;

    public ASN1PrintableString(String str, boolean z) {
        if (z && !isPrintableString(str)) {
            throw new IllegalArgumentException("string contains illegal characters");
        }
        this.contents = C6250Strings.toByteArray(str);
    }

    public static ASN1PrintableString createPrimitive(byte[] bArr) {
        return new DERPrintableString(bArr, false);
    }

    public static ASN1PrintableString getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1PrintableString)) {
            return (ASN1PrintableString) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1PrintableString) {
                return (ASN1PrintableString) aSN1Primitive;
            }
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (ASN1PrintableString) f17935TYPE.fromByteArray((byte[]) obj);
        } catch (Exception e) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
        }
    }

    public static ASN1PrintableString getTagged(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1PrintableString) f17935TYPE.getTagged(aSN1TaggedObject, z);
    }

    public static boolean isPrintableString(String str) {
        for (int length = str.length() - 1; length >= 0; length--) {
            char cCharAt = str.charAt(length);
            if (cCharAt > 127) {
                return false;
            }
            if (('a' > cCharAt || cCharAt > 'z') && (('A' > cCharAt || cCharAt > 'Z') && (('0' > cCharAt || cCharAt > '9') && cCharAt != ' ' && cCharAt != ':' && cCharAt != '=' && cCharAt != '?'))) {
                switch (cCharAt) {
                    case C5125EACTags.INTERCHANGE_CONTROL /* 39 */:
                    case '(':
                    case C5125EACTags.INTERCHANGE_PROFILE /* 41 */:
                        continue;
                    default:
                        switch (cCharAt) {
                            case C5125EACTags.DATE_OF_BIRTH /* 43 */:
                            case C5125EACTags.CARDHOLDER_NATIONALITY /* 44 */:
                            case C5125EACTags.LANGUAGE_PREFERENCES /* 45 */:
                            case '.':
                            case C5125EACTags.PIN_USAGE_POLICY /* 47 */:
                                break;
                            default:
                                return false;
                        }
                }
            }
        }
        return true;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public final boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof ASN1PrintableString) {
            return C6238Arrays.areEqual(this.contents, ((ASN1PrintableString) aSN1Primitive).contents);
        }
        return false;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    /* renamed from: encode */
    public final void mo14417encode(ASN1OutputStream aSN1OutputStream, boolean z) {
        aSN1OutputStream.writeEncodingDL(z, 19, this.contents);
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

    public ASN1PrintableString(byte[] bArr, boolean z) {
        this.contents = z ? C6238Arrays.m18231clone(bArr) : bArr;
    }

    public static ASN1PrintableString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1PrintableString) f17935TYPE.getContextTagged(aSN1TaggedObject, z);
    }
}
