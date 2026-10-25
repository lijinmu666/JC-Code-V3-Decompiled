package org.bouncycastle.p191cms;

import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes2.dex */
public class CMSTypedStream {

    /* renamed from: BUF_SIZ */
    private static final int f19006BUF_SIZ = 32768;

    /* renamed from: _in */
    protected InputStream f19007_in;

    /* renamed from: _oid */
    private final ASN1ObjectIdentifier f19008_oid;

    public static class FullReaderStream extends FilterInputStream {
        public FullReaderStream(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (i2 == 0) {
                return 0;
            }
            int fully = C6257Streams.readFully(((FilterInputStream) this).in, bArr, i, i2);
            if (fully > 0) {
                return fully;
            }
            return -1;
        }
    }

    public CMSTypedStream(InputStream inputStream) {
        this(PKCSObjectIdentifiers.f18493data.m14433getId(), inputStream, 32768);
    }

    /* renamed from: drain */
    public void mo14877drain() throws IOException {
        C6257Streams.m18360drain(this.f19007_in);
        this.f19007_in.close();
    }

    public InputStream getContentStream() {
        return this.f19007_in;
    }

    public ASN1ObjectIdentifier getContentType() {
        return this.f19008_oid;
    }

    public CMSTypedStream(String str, InputStream inputStream) {
        this(new ASN1ObjectIdentifier(str), inputStream, 32768);
    }

    public CMSTypedStream(String str, InputStream inputStream, int i) {
        this(new ASN1ObjectIdentifier(str), inputStream, i);
    }

    public CMSTypedStream(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.f19008_oid = aSN1ObjectIdentifier;
    }

    public CMSTypedStream(ASN1ObjectIdentifier aSN1ObjectIdentifier, InputStream inputStream) {
        this(aSN1ObjectIdentifier, inputStream, 32768);
    }

    public CMSTypedStream(ASN1ObjectIdentifier aSN1ObjectIdentifier, InputStream inputStream, int i) {
        this.f19008_oid = aSN1ObjectIdentifier;
        this.f19007_in = new FullReaderStream(new BufferedInputStream(inputStream, i));
    }
}
