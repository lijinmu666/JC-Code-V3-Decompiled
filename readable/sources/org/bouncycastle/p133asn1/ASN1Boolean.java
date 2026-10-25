package org.bouncycastle.p133asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public class ASN1Boolean extends ASN1Primitive {
    private static final byte FALSE_VALUE = 0;
    private static final byte TRUE_VALUE = -1;

    /* renamed from: value */
    private final byte f17900value;

    /* renamed from: TYPE */
    static final ASN1UniversalType f17899TYPE = new ASN1UniversalType(ASN1Boolean.class, 1) { // from class: org.bouncycastle.asn1.ASN1Boolean.1
        @Override // org.bouncycastle.p133asn1.ASN1UniversalType
        public ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return ASN1Boolean.createPrimitive(dEROctetString.getOctets());
        }
    };

    /* renamed from: FALSE */
    public static final ASN1Boolean f17897FALSE = new ASN1Boolean((byte) 0);

    /* renamed from: TRUE */
    public static final ASN1Boolean f17898TRUE = new ASN1Boolean((byte) -1);

    private ASN1Boolean(byte b) {
        this.f17900value = b;
    }

    public static ASN1Boolean createPrimitive(byte[] bArr) {
        if (bArr.length != 1) {
            throw new IllegalArgumentException("BOOLEAN value should have 1 byte in it");
        }
        byte b = bArr[0];
        return b != -1 ? b != 0 ? new ASN1Boolean(b) : f17897FALSE : f17898TRUE;
    }

    public static ASN1Boolean getInstance(int i) {
        return i != 0 ? f17898TRUE : f17897FALSE;
    }

    public static ASN1Boolean getTagged(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1Boolean) f17899TYPE.getTagged(aSN1TaggedObject, z);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        return (aSN1Primitive instanceof ASN1Boolean) && m14419isTrue() == ((ASN1Boolean) aSN1Primitive).m14419isTrue();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    /* renamed from: encode */
    public void mo14417encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeEncodingDL(z, 1, this.f17900value);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public int encodedLength(boolean z) {
        return ASN1OutputStream.getLengthOfEncodingDL(z, 1);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive, org.bouncycastle.p133asn1.ASN1Object
    public int hashCode() {
        return m14419isTrue() ? 1 : 0;
    }

    /* renamed from: isTrue */
    public boolean m14419isTrue() {
        return this.f17900value != 0;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return m14419isTrue() ? f17898TRUE : f17897FALSE;
    }

    public String toString() {
        return m14419isTrue() ? "TRUE" : "FALSE";
    }

    public static ASN1Boolean getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1Boolean)) {
            return (ASN1Boolean) obj;
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (ASN1Boolean) f17899TYPE.fromByteArray((byte[]) obj);
        } catch (IOException e) {
            throw new IllegalArgumentException("failed to construct boolean from byte[]: " + e.getMessage());
        }
    }

    public static ASN1Boolean getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1Boolean) f17899TYPE.getContextTagged(aSN1TaggedObject, z);
    }

    public static ASN1Boolean getInstance(boolean z) {
        return z ? f17898TRUE : f17897FALSE;
    }
}
