package org.bouncycastle.p133asn1;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public class ASN1OutputStream {

    /* renamed from: os */
    private OutputStream f17933os;

    public ASN1OutputStream(OutputStream outputStream) {
        this.f17933os = outputStream;
    }

    /* renamed from: create */
    public static ASN1OutputStream m14438create(OutputStream outputStream) {
        return new ASN1OutputStream(outputStream);
    }

    public static int getLengthOfDL(int i) {
        if (i < 128) {
            return 1;
        }
        int i2 = 2;
        while (true) {
            i >>>= 8;
            if (i == 0) {
                return i2;
            }
            i2++;
        }
    }

    public static int getLengthOfEncodingDL(boolean z, int i) {
        return (z ? 1 : 0) + getLengthOfDL(i) + i;
    }

    public static int getLengthOfIdentifier(int i) {
        if (i < 31) {
            return 1;
        }
        int i2 = 2;
        while (true) {
            i >>>= 7;
            if (i == 0) {
                return i2;
            }
            i2++;
        }
    }

    /* renamed from: close */
    public void m14440close() throws IOException {
        this.f17933os.close();
    }

    /* renamed from: flush */
    public void m14441flush() throws IOException {
        this.f17933os.flush();
    }

    public void flushInternal() {
    }

    public DEROutputStream getDERSubStream() {
        return new DEROutputStream(this.f17933os);
    }

    public DLOutputStream getDLSubStream() {
        return new DLOutputStream(this.f17933os);
    }

    /* renamed from: write */
    public final void m14442write(int i) throws IOException {
        this.f17933os.write(i);
    }

    /* renamed from: writeDL */
    public final void m14444writeDL(int i) {
        if (i < 128) {
            m14442write(i);
            return;
        }
        int i2 = 5;
        byte[] bArr = new byte[5];
        while (true) {
            int i3 = i2 - 1;
            bArr[i3] = (byte) i;
            i >>>= 8;
            if (i == 0) {
                int i4 = i2 - 2;
                bArr[i4] = (byte) ((5 - i3) | 128);
                m14443write(bArr, i4, 6 - i3);
                return;
            }
            i2 = i3;
        }
    }

    public void writeElements(ASN1Encodable[] aSN1EncodableArr) {
        for (ASN1Encodable aSN1Encodable : aSN1EncodableArr) {
            aSN1Encodable.toASN1Primitive().mo14417encode(this, true);
        }
    }

    public final void writeEncodingDL(boolean z, int i, byte b) throws IOException {
        writeIdentifier(z, i);
        m14444writeDL(1);
        m14442write(b);
    }

    public final void writeEncodingIL(boolean z, int i, ASN1Encodable[] aSN1EncodableArr) throws IOException {
        writeIdentifier(z, i);
        m14442write(128);
        writeElements(aSN1EncodableArr);
        m14442write(0);
        m14442write(0);
    }

    public final void writeIdentifier(boolean z, int i) throws IOException {
        if (z) {
            m14442write(i);
        }
    }

    public final void writeObject(ASN1Encodable aSN1Encodable) throws IOException {
        if (aSN1Encodable == null) {
            throw new IOException("null object detected");
        }
        writePrimitive(aSN1Encodable.toASN1Primitive(), true);
        flushInternal();
    }

    public void writePrimitive(ASN1Primitive aSN1Primitive, boolean z) {
        aSN1Primitive.mo14417encode(this, z);
    }

    public void writePrimitives(ASN1Primitive[] aSN1PrimitiveArr) {
        for (ASN1Primitive aSN1Primitive : aSN1PrimitiveArr) {
            aSN1Primitive.mo14417encode(this, true);
        }
    }

    /* renamed from: create */
    public static ASN1OutputStream m14439create(OutputStream outputStream, String str) {
        return str.equals(ASN1Encoding.f17902DER) ? new DEROutputStream(outputStream) : str.equals(ASN1Encoding.f17903DL) ? new DLOutputStream(outputStream) : new ASN1OutputStream(outputStream);
    }

    /* renamed from: write */
    public final void m14443write(byte[] bArr, int i, int i2) throws IOException {
        this.f17933os.write(bArr, i, i2);
    }

    public final void writeEncodingDL(boolean z, int i, byte b, byte[] bArr, int i2, int i3) throws IOException {
        writeIdentifier(z, i);
        m14444writeDL(i3 + 1);
        m14442write(b);
        m14443write(bArr, i2, i3);
    }

    public final void writeIdentifier(boolean z, int i, int i2) {
        if (z) {
            if (i2 < 31) {
                m14442write(i | i2);
                return;
            }
            byte[] bArr = new byte[6];
            int i3 = 5;
            bArr[5] = (byte) (i2 & 127);
            while (i2 > 127) {
                i2 >>>= 7;
                i3--;
                bArr[i3] = (byte) ((i2 & 127) | 128);
            }
            int i4 = i3 - 1;
            bArr[i4] = (byte) (31 | i);
            m14443write(bArr, i4, 6 - i4);
        }
    }

    public final void writeObject(ASN1Primitive aSN1Primitive) throws IOException {
        if (aSN1Primitive == null) {
            throw new IOException("null object detected");
        }
        writePrimitive(aSN1Primitive, true);
        flushInternal();
    }

    public final void writeEncodingDL(boolean z, int i, int i2, byte[] bArr) throws IOException {
        writeIdentifier(z, i, i2);
        m14444writeDL(bArr.length);
        m14443write(bArr, 0, bArr.length);
    }

    public final void writeEncodingDL(boolean z, int i, byte[] bArr) {
        writeIdentifier(z, i);
        m14444writeDL(bArr.length);
        m14443write(bArr, 0, bArr.length);
    }

    public final void writeEncodingDL(boolean z, int i, byte[] bArr, int i2, int i3) throws IOException {
        writeIdentifier(z, i);
        m14444writeDL(i3);
        m14443write(bArr, i2, i3);
    }

    public final void writeEncodingDL(boolean z, int i, byte[] bArr, int i2, int i3, byte b) throws IOException {
        writeIdentifier(z, i);
        m14444writeDL(i3 + 1);
        m14443write(bArr, i2, i3);
        m14442write(b);
    }
}
