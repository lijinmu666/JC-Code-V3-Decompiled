package org.bouncycastle.p133asn1;

import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes.dex */
public abstract class ASN1T61String extends ASN1Primitive implements ASN1String {

    /* renamed from: TYPE */
    static final ASN1UniversalType f17951TYPE = new ASN1UniversalType(ASN1T61String.class, 20) { // from class: org.bouncycastle.asn1.ASN1T61String.1
        @Override // org.bouncycastle.p133asn1.ASN1UniversalType
        public ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return ASN1T61String.createPrimitive(dEROctetString.getOctets());
        }
    };
    final byte[] contents;

    public ASN1T61String(String str) {
        this.contents = C6250Strings.toByteArray(str);
    }

    public static ASN1T61String createPrimitive(byte[] bArr) {
        return new DERT61String(bArr, false);
    }

    public static ASN1T61String getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1T61String)) {
            return (ASN1T61String) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1T61String) {
                return (ASN1T61String) aSN1Primitive;
            }
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (ASN1T61String) f17951TYPE.fromByteArray((byte[]) obj);
        } catch (Exception e) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
        }
    }

    public static ASN1T61String getTagged(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1T61String) f17951TYPE.getTagged(aSN1TaggedObject, z);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public final boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof ASN1T61String) {
            return C6238Arrays.areEqual(this.contents, ((ASN1T61String) aSN1Primitive).contents);
        }
        return false;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    /* renamed from: encode */
    public final void mo14417encode(ASN1OutputStream aSN1OutputStream, boolean z) {
        aSN1OutputStream.writeEncodingDL(z, 20, this.contents);
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

    public ASN1T61String(byte[] bArr, boolean z) {
        this.contents = z ? C6238Arrays.m18231clone(bArr) : bArr;
    }

    public static ASN1T61String getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1T61String) f17951TYPE.getContextTagged(aSN1TaggedObject, z);
    }
}
