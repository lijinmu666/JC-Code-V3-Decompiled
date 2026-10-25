package org.bouncycastle.p133asn1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public abstract class DERGenerator extends ASN1Generator {
    private boolean _isExplicit;

    /* renamed from: _tagNo */
    private int f17990_tagNo;

    /* renamed from: _tagged */
    private boolean f17991_tagged;

    public DERGenerator(OutputStream outputStream) {
        super(outputStream);
        this.f17991_tagged = false;
    }

    private void writeLength(OutputStream outputStream, int i) throws IOException {
        if (i <= 127) {
            outputStream.write((byte) i);
            return;
        }
        int i2 = 1;
        int i3 = i;
        while (true) {
            i3 >>>= 8;
            if (i3 == 0) {
                break;
            } else {
                i2++;
            }
        }
        outputStream.write((byte) (i2 | 128));
        for (int i4 = (i2 - 1) * 8; i4 >= 0; i4 -= 8) {
            outputStream.write((byte) (i >> i4));
        }
    }

    public void writeDEREncoded(int i, byte[] bArr) throws IOException {
        OutputStream outputStream;
        if (!this.f17991_tagged) {
            outputStream = this.f17911_out;
        } else {
            if (this._isExplicit) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                writeDEREncoded(byteArrayOutputStream, i, bArr);
                writeDEREncoded(this.f17911_out, this.f17990_tagNo | 160, byteArrayOutputStream.toByteArray());
                return;
            }
            outputStream = this.f17911_out;
            i = ASN1Generator.inheritConstructedFlag(this.f17990_tagNo | 128, i);
        }
        writeDEREncoded(outputStream, i, bArr);
    }

    public DERGenerator(OutputStream outputStream, int i, boolean z) {
        super(outputStream);
        this.f17991_tagged = true;
        this._isExplicit = z;
        this.f17990_tagNo = i;
    }

    public void writeDEREncoded(OutputStream outputStream, int i, byte[] bArr) throws IOException {
        outputStream.write(i);
        writeLength(outputStream, bArr.length);
        outputStream.write(bArr);
    }
}
