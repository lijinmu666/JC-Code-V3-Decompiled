package org.bouncycastle.p133asn1;

import java.io.IOException;

/* renamed from: org.bouncycastle.asn1.BERSet */
/* loaded from: classes.dex */
public class C5101BERSet extends AbstractC5093ASN1Set {
    public C5101BERSet() {
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    /* renamed from: encode */
    public void mo14417encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeEncodingIL(z, 49, this.elements);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public int encodedLength(boolean z) {
        int iEncodedLength = z ? 4 : 3;
        int length = this.elements.length;
        for (int i = 0; i < length; i++) {
            iEncodedLength += this.elements[i].toASN1Primitive().encodedLength(true);
        }
        return iEncodedLength;
    }

    public C5101BERSet(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable);
    }

    public C5101BERSet(ASN1EncodableVector aSN1EncodableVector) {
        super(aSN1EncodableVector, false);
    }

    public C5101BERSet(boolean z, ASN1Encodable[] aSN1EncodableArr) {
        super(z, aSN1EncodableArr);
    }

    public C5101BERSet(ASN1Encodable[] aSN1EncodableArr) {
        super(aSN1EncodableArr, false);
    }
}
