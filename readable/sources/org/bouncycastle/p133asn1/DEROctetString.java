package org.bouncycastle.p133asn1;

import java.io.IOException;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes.dex */
public class DEROctetString extends ASN1OctetString {

    /* renamed from: EMPTY */
    public static final DEROctetString f17992EMPTY = new DEROctetString(ASN1OctetString.EMPTY_OCTETS);

    public DEROctetString(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.f17902DER));
    }

    public static DEROctetString fromContents(byte[] bArr) {
        if (bArr != null) {
            return internalFromContents(bArr);
        }
        throw new NullPointerException("'contents' cannot be null");
    }

    public static DEROctetString fromContentsOptional(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return internalFromContents(bArr);
    }

    public static DEROctetString internalFromContents(byte[] bArr) {
        return bArr.length < 1 ? f17992EMPTY : new DEROctetString(C6238Arrays.m18231clone(bArr));
    }

    public static DEROctetString internalWithContents(byte[] bArr) {
        return bArr.length < 1 ? f17992EMPTY : new DEROctetString(bArr);
    }

    public static DEROctetString withContents(byte[] bArr) {
        if (bArr != null) {
            return internalWithContents(bArr);
        }
        throw new NullPointerException("'contents' cannot be null");
    }

    public static DEROctetString withContentsOptional(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return internalWithContents(bArr);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    /* renamed from: encode */
    public void mo14417encode(ASN1OutputStream aSN1OutputStream, boolean z) {
        aSN1OutputStream.writeEncodingDL(z, 4, this.f17932string);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public int encodedLength(boolean z) {
        return ASN1OutputStream.getLengthOfEncodingDL(z, this.f17932string.length);
    }

    @Override // org.bouncycastle.p133asn1.ASN1OctetString, org.bouncycastle.p133asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return this;
    }

    @Override // org.bouncycastle.p133asn1.ASN1OctetString, org.bouncycastle.p133asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return this;
    }

    public DEROctetString(byte[] bArr) {
        super(bArr);
    }

    /* renamed from: encode */
    public static void m14471encode(ASN1OutputStream aSN1OutputStream, boolean z, byte[] bArr, int i, int i2) throws IOException {
        aSN1OutputStream.writeEncodingDL(z, 4, bArr, i, i2);
    }

    public static int encodedLength(boolean z, int i) {
        return ASN1OutputStream.getLengthOfEncodingDL(z, i);
    }
}
