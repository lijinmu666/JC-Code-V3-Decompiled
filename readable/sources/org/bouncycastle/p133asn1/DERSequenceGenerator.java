package org.bouncycastle.p133asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class DERSequenceGenerator extends DERGenerator {

    /* renamed from: _bOut */
    private final ByteArrayOutputStream f17995_bOut;

    public DERSequenceGenerator(OutputStream outputStream) {
        super(outputStream);
        this.f17995_bOut = new ByteArrayOutputStream();
    }

    public void addObject(ASN1Encodable aSN1Encodable) {
        aSN1Encodable.toASN1Primitive().encodeTo(this.f17995_bOut, ASN1Encoding.f17902DER);
    }

    /* renamed from: close */
    public void m14473close() throws IOException {
        writeDEREncoded(48, this.f17995_bOut.toByteArray());
    }

    @Override // org.bouncycastle.p133asn1.ASN1Generator
    public OutputStream getRawOutputStream() {
        return this.f17995_bOut;
    }

    public DERSequenceGenerator(OutputStream outputStream, int i, boolean z) {
        super(outputStream, i, z);
        this.f17995_bOut = new ByteArrayOutputStream();
    }

    public void addObject(ASN1Primitive aSN1Primitive) {
        aSN1Primitive.encodeTo(this.f17995_bOut, ASN1Encoding.f17902DER);
    }
}
