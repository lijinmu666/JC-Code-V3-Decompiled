package org.bouncycastle.p133asn1;

import java.io.OutputStream;

/* loaded from: classes.dex */
class DLOutputStream extends ASN1OutputStream {
    public DLOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // org.bouncycastle.p133asn1.ASN1OutputStream
    public DLOutputStream getDLSubStream() {
        return this;
    }

    @Override // org.bouncycastle.p133asn1.ASN1OutputStream
    public void writeElements(ASN1Encodable[] aSN1EncodableArr) {
        for (ASN1Encodable aSN1Encodable : aSN1EncodableArr) {
            aSN1Encodable.toASN1Primitive().toDLObject().mo14417encode(this, true);
        }
    }

    @Override // org.bouncycastle.p133asn1.ASN1OutputStream
    public void writePrimitive(ASN1Primitive aSN1Primitive, boolean z) {
        aSN1Primitive.toDLObject().mo14417encode(this, z);
    }

    @Override // org.bouncycastle.p133asn1.ASN1OutputStream
    public void writePrimitives(ASN1Primitive[] aSN1PrimitiveArr) {
        for (ASN1Primitive aSN1Primitive : aSN1PrimitiveArr) {
            aSN1Primitive.toDLObject().mo14417encode(this, true);
        }
    }
}
