package org.bouncycastle.p133asn1;

/* renamed from: org.bouncycastle.asn1.DERNull */
/* loaded from: classes.dex */
public class C5103DERNull extends ASN1Null {
    public static final C5103DERNull INSTANCE = new C5103DERNull();
    private static final byte[] zeroBytes = new byte[0];

    private C5103DERNull() {
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    /* renamed from: encode */
    public void mo14417encode(ASN1OutputStream aSN1OutputStream, boolean z) {
        aSN1OutputStream.writeEncodingDL(z, 5, zeroBytes);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public boolean encodeConstructed() {
        return false;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public int encodedLength(boolean z) {
        return ASN1OutputStream.getLengthOfEncodingDL(z, 0);
    }
}
