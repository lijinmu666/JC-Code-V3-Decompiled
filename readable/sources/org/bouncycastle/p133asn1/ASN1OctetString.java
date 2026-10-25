package org.bouncycastle.p133asn1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes.dex */
public abstract class ASN1OctetString extends ASN1Primitive implements ASN1OctetStringParser {

    /* renamed from: string */
    byte[] f17932string;

    /* renamed from: TYPE */
    static final ASN1UniversalType f17931TYPE = new ASN1UniversalType(ASN1OctetString.class, 4) { // from class: org.bouncycastle.asn1.ASN1OctetString.1
        @Override // org.bouncycastle.p133asn1.ASN1UniversalType
        public ASN1Primitive fromImplicitConstructed(ASN1Sequence aSN1Sequence) {
            return aSN1Sequence.toASN1OctetString();
        }

        @Override // org.bouncycastle.p133asn1.ASN1UniversalType
        public ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return dEROctetString;
        }
    };
    static final byte[] EMPTY_OCTETS = new byte[0];

    public ASN1OctetString(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("'string' cannot be null");
        }
        this.f17932string = bArr;
    }

    public static ASN1OctetString createPrimitive(byte[] bArr) {
        return new DEROctetString(bArr);
    }

    public static ASN1OctetString getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1OctetString)) {
            return (ASN1OctetString) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1OctetString) {
                return (ASN1OctetString) aSN1Primitive;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (ASN1OctetString) f17931TYPE.fromByteArray((byte[]) obj);
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to construct OCTET STRING from byte[]: " + e.getMessage());
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static ASN1OctetString getTagged(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1OctetString) f17931TYPE.getTagged(aSN1TaggedObject, z);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof ASN1OctetString) {
            return C6238Arrays.areEqual(this.f17932string, ((ASN1OctetString) aSN1Primitive).f17932string);
        }
        return false;
    }

    @Override // org.bouncycastle.p133asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return toASN1Primitive();
    }

    @Override // org.bouncycastle.p133asn1.ASN1OctetStringParser
    public InputStream getOctetStream() {
        return new ByteArrayInputStream(this.f17932string);
    }

    public byte[] getOctets() {
        return this.f17932string;
    }

    public int getOctetsLength() {
        return getOctets().length;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive, org.bouncycastle.p133asn1.ASN1Object
    public int hashCode() {
        return C6238Arrays.hashCode(getOctets());
    }

    /* renamed from: parser */
    public ASN1OctetStringParser m14437parser() {
        return this;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return new DEROctetString(this.f17932string);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return new DEROctetString(this.f17932string);
    }

    public String toString() {
        return "#" + C6250Strings.fromByteArray(C6255Hex.m18343encode(this.f17932string));
    }

    public static ASN1OctetString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1OctetString) f17931TYPE.getContextTagged(aSN1TaggedObject, z);
    }
}
