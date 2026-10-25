package org.bouncycastle.p191cms;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.operator.OutputCompressor;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.BERSequenceGenerator;
import org.bouncycastle.p133asn1.p139cms.CMSObjectIdentifiers;

/* loaded from: classes2.dex */
public class CMSCompressedDataStreamGenerator {

    /* renamed from: ZLIB */
    public static final String f18961ZLIB = CMSObjectIdentifiers.zlibCompress.m14433getId();
    private int _bufferSize;

    public static class CmsCompressedOutputStream extends OutputStream {

        /* renamed from: _cGen */
        private BERSequenceGenerator f18962_cGen;

        /* renamed from: _eiGen */
        private BERSequenceGenerator f18963_eiGen;

        /* renamed from: _out */
        private OutputStream f18964_out;

        /* renamed from: _sGen */
        private BERSequenceGenerator f18965_sGen;

        public CmsCompressedOutputStream(OutputStream outputStream, BERSequenceGenerator bERSequenceGenerator, BERSequenceGenerator bERSequenceGenerator2, BERSequenceGenerator bERSequenceGenerator3) {
            this.f18964_out = outputStream;
            this.f18965_sGen = bERSequenceGenerator;
            this.f18962_cGen = bERSequenceGenerator2;
            this.f18963_eiGen = bERSequenceGenerator3;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f18964_out.close();
            this.f18963_eiGen.m14466close();
            this.f18962_cGen.m14466close();
            this.f18965_sGen.m14466close();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.f18964_out.write(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f18964_out.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.f18964_out.write(bArr, i, i2);
        }
    }

    /* renamed from: open */
    public OutputStream m14859open(OutputStream outputStream, OutputCompressor outputCompressor) {
        return m14860open(CMSObjectIdentifiers.f18179data, outputStream, outputCompressor);
    }

    public void setBufferSize(int i) {
        this._bufferSize = i;
    }

    /* renamed from: open */
    public OutputStream m14860open(ASN1ObjectIdentifier aSN1ObjectIdentifier, OutputStream outputStream, OutputCompressor outputCompressor) {
        BERSequenceGenerator bERSequenceGenerator = new BERSequenceGenerator(outputStream);
        bERSequenceGenerator.addObject((ASN1Primitive) CMSObjectIdentifiers.compressedData);
        BERSequenceGenerator bERSequenceGenerator2 = new BERSequenceGenerator(bERSequenceGenerator.getRawOutputStream(), 0, true);
        bERSequenceGenerator2.addObject((ASN1Primitive) ASN1Integer.f17922ZERO);
        bERSequenceGenerator2.addObject(outputCompressor.getAlgorithmIdentifier());
        BERSequenceGenerator bERSequenceGenerator3 = new BERSequenceGenerator(bERSequenceGenerator2.getRawOutputStream());
        bERSequenceGenerator3.addObject((ASN1Primitive) aSN1ObjectIdentifier);
        return new CmsCompressedOutputStream(outputCompressor.getOutputStream(CMSUtils.createBEROctetOutputStream(bERSequenceGenerator3.getRawOutputStream(), 0, true, this._bufferSize)), bERSequenceGenerator, bERSequenceGenerator2, bERSequenceGenerator3);
    }
}
