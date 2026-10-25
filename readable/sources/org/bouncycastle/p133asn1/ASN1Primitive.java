package org.bouncycastle.p133asn1;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public abstract class ASN1Primitive extends ASN1Object {
    public static ASN1Primitive fromByteArray(byte[] bArr) throws IOException {
        ASN1InputStream aSN1InputStream = new ASN1InputStream(bArr);
        try {
            ASN1Primitive object = aSN1InputStream.readObject();
            if (aSN1InputStream.available() == 0) {
                return object;
            }
            throw new IOException("Extra data detected in stream");
        } catch (ClassCastException unused) {
            throw new IOException("cannot recognise object in stream");
        }
    }

    public abstract boolean asn1Equals(ASN1Primitive aSN1Primitive);

    /* renamed from: encode */
    public abstract void mo14417encode(ASN1OutputStream aSN1OutputStream, boolean z);

    public abstract boolean encodeConstructed();

    @Override // org.bouncycastle.p133asn1.ASN1Object
    public void encodeTo(OutputStream outputStream) {
        ASN1OutputStream aSN1OutputStreamM14438create = ASN1OutputStream.m14438create(outputStream);
        aSN1OutputStreamM14438create.writePrimitive(this, true);
        aSN1OutputStreamM14438create.flushInternal();
    }

    public abstract int encodedLength(boolean z);

    @Override // org.bouncycastle.p133asn1.ASN1Object
    /* renamed from: equals */
    public final boolean mo14431equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ASN1Encodable) && asn1Equals(((ASN1Encodable) obj).toASN1Primitive());
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object
    public abstract int hashCode();

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public final ASN1Primitive toASN1Primitive() {
        return this;
    }

    public ASN1Primitive toDERObject() {
        return this;
    }

    public ASN1Primitive toDLObject() {
        return this;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object
    public void encodeTo(OutputStream outputStream, String str) {
        ASN1OutputStream aSN1OutputStreamM14439create = ASN1OutputStream.m14439create(outputStream, str);
        aSN1OutputStreamM14439create.writePrimitive(this, true);
        aSN1OutputStreamM14439create.flushInternal();
    }

    /* renamed from: equals */
    public final boolean m14445equals(ASN1Encodable aSN1Encodable) {
        return this == aSN1Encodable || (aSN1Encodable != null && asn1Equals(aSN1Encodable.toASN1Primitive()));
    }

    /* renamed from: equals */
    public final boolean m14446equals(ASN1Primitive aSN1Primitive) {
        return this == aSN1Primitive || asn1Equals(aSN1Primitive);
    }
}
