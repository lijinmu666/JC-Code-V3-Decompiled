package org.bouncycastle.p133asn1;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public abstract class BERGenerator extends ASN1Generator {
    private boolean _isExplicit;

    /* renamed from: _tagNo */
    private int f17962_tagNo;

    /* renamed from: _tagged */
    private boolean f17963_tagged;

    public BERGenerator(OutputStream outputStream) {
        super(outputStream);
        this.f17963_tagged = false;
    }

    private void writeHdr(int i) throws IOException {
        this.f17911_out.write(i);
        this.f17911_out.write(128);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Generator
    public OutputStream getRawOutputStream() {
        return this.f17911_out;
    }

    public void writeBEREnd() throws IOException {
        this.f17911_out.write(0);
        this.f17911_out.write(0);
        if (this.f17963_tagged && this._isExplicit) {
            this.f17911_out.write(0);
            this.f17911_out.write(0);
        }
    }

    public void writeBERHeader(int i) throws IOException {
        if (this.f17963_tagged) {
            if (this._isExplicit) {
                writeHdr(this.f17962_tagNo | 160);
            } else {
                i = ASN1Generator.inheritConstructedFlag(this.f17962_tagNo | 128, i);
            }
        }
        writeHdr(i);
    }

    public BERGenerator(OutputStream outputStream, int i, boolean z) {
        super(outputStream);
        this.f17963_tagged = true;
        this._isExplicit = z;
        this.f17962_tagNo = i;
    }
}
