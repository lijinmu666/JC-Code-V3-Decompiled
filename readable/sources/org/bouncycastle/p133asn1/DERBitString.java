package org.bouncycastle.p133asn1;

import java.io.IOException;
import p094kotlin.C1126UByte;

/* loaded from: classes.dex */
public class DERBitString extends ASN1BitString {
    public DERBitString(byte b, int i) {
        super(b, i);
    }

    /* renamed from: convert */
    public static DERBitString m14469convert(ASN1BitString aSN1BitString) {
        return (DERBitString) aSN1BitString.toDERObject();
    }

    public static DERBitString fromOctetString(ASN1OctetString aSN1OctetString) {
        return new DERBitString(aSN1OctetString.getOctets(), true);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    /* renamed from: encode */
    public void mo14417encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        byte[] bArr = this.contents;
        int i = bArr[0] & C1126UByte.MAX_VALUE;
        int length = bArr.length - 1;
        byte b = bArr[length];
        byte b2 = (byte) ((255 << i) & b);
        if (b == b2) {
            aSN1OutputStream.writeEncodingDL(z, 3, bArr);
        } else {
            aSN1OutputStream.writeEncodingDL(z, 3, bArr, 0, length, b2);
        }
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public int encodedLength(boolean z) {
        return ASN1OutputStream.getLengthOfEncodingDL(z, this.contents.length);
    }

    @Override // org.bouncycastle.p133asn1.ASN1BitString, org.bouncycastle.p133asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return this;
    }

    @Override // org.bouncycastle.p133asn1.ASN1BitString, org.bouncycastle.p133asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return this;
    }

    public DERBitString(int i) {
        super(i);
    }

    public DERBitString(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.f17902DER), 0);
    }

    public DERBitString(byte[] bArr) {
        this(bArr, 0);
    }

    public DERBitString(byte[] bArr, int i) {
        super(bArr, i);
    }

    public DERBitString(byte[] bArr, boolean z) {
        super(bArr, z);
    }
}
