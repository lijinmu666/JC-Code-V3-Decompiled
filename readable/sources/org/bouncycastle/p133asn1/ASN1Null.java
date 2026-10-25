package org.bouncycastle.p133asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class ASN1Null extends ASN1Primitive {

    /* renamed from: TYPE */
    static final ASN1UniversalType f17925TYPE = new ASN1UniversalType(ASN1Null.class, 5) { // from class: org.bouncycastle.asn1.ASN1Null.1
        @Override // org.bouncycastle.p133asn1.ASN1UniversalType
        public ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            ASN1Null.checkContentsLength(dEROctetString.getOctetsLength());
            return ASN1Null.createPrimitive();
        }
    };

    public static void checkContentsLength(int i) {
        if (i != 0) {
            throw new IllegalStateException("malformed NULL encoding encountered");
        }
    }

    public static ASN1Null createPrimitive() {
        return C5103DERNull.INSTANCE;
    }

    public static ASN1Null getInstance(Object obj) {
        if (obj instanceof ASN1Null) {
            return (ASN1Null) obj;
        }
        if (obj == null) {
            return null;
        }
        try {
            return (ASN1Null) f17925TYPE.fromByteArray((byte[]) obj);
        } catch (IOException e) {
            throw new IllegalArgumentException("failed to construct NULL from byte[]: " + e.getMessage());
        }
    }

    public static ASN1Null getTagged(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1Null) f17925TYPE.getTagged(aSN1TaggedObject, z);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        return aSN1Primitive instanceof ASN1Null;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive, org.bouncycastle.p133asn1.ASN1Object
    public int hashCode() {
        return -1;
    }

    public String toString() {
        return "NULL";
    }

    public static ASN1Null getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1Null) f17925TYPE.getContextTagged(aSN1TaggedObject, z);
    }
}
