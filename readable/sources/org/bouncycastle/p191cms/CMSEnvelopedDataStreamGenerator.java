package org.bouncycastle.p191cms;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.operator.OutputAEADEncryptor;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.BERSequenceGenerator;
import org.bouncycastle.p133asn1.C5105DLSet;
import org.bouncycastle.p133asn1.p139cms.CMSObjectIdentifiers;
import org.bouncycastle.p133asn1.p139cms.EnvelopedData;
import org.bouncycastle.p133asn1.p139cms.OriginatorInfo;

/* loaded from: classes2.dex */
public class CMSEnvelopedDataStreamGenerator extends CMSEnvelopedGenerator {
    private boolean _berEncodeRecipientSet;
    private int _bufferSize;

    public class CmsEnvelopedDataOutputStream extends OutputStream {

        /* renamed from: _cGen */
        private BERSequenceGenerator f18969_cGen;

        /* renamed from: _cOut */
        private final OutputStream f18970_cOut;

        /* renamed from: _eiGen */
        private BERSequenceGenerator f18971_eiGen;
        private final OutputEncryptor _encryptor;

        /* renamed from: _envGen */
        private BERSequenceGenerator f18972_envGen;
        private OutputStream _octetStream;

        public CmsEnvelopedDataOutputStream(OutputEncryptor outputEncryptor, OutputStream outputStream, BERSequenceGenerator bERSequenceGenerator, BERSequenceGenerator bERSequenceGenerator2, BERSequenceGenerator bERSequenceGenerator3) {
            this._encryptor = outputEncryptor;
            this._octetStream = outputStream;
            this.f18970_cOut = outputEncryptor.getOutputStream(outputStream);
            this.f18969_cGen = bERSequenceGenerator;
            this.f18972_envGen = bERSequenceGenerator2;
            this.f18971_eiGen = bERSequenceGenerator3;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f18970_cOut.close();
            OutputEncryptor outputEncryptor = this._encryptor;
            if (outputEncryptor instanceof OutputAEADEncryptor) {
                this._octetStream.write(((OutputAEADEncryptor) outputEncryptor).mo14908getMAC());
                this._octetStream.close();
            }
            this.f18971_eiGen.m14466close();
            CMSUtils.addAttriSetToGenerator(this.f18972_envGen, CMSEnvelopedDataStreamGenerator.this.unprotectedAttributeGenerator, 1, CMSUtils.getEmptyParameters());
            this.f18972_envGen.m14466close();
            this.f18969_cGen.m14466close();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.f18970_cOut.write(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f18970_cOut.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.f18970_cOut.write(bArr, i, i2);
        }
    }

    private ASN1Integer getVersion(ASN1EncodableVector aSN1EncodableVector) {
        C5105DLSet c5105DLSet;
        C5105DLSet c5105DLSet2;
        CMSAttributeTableGenerator cMSAttributeTableGenerator = this.unprotectedAttributeGenerator;
        OriginatorInfo originatorInfo = this.originatorInfo;
        if (cMSAttributeTableGenerator != null) {
            c5105DLSet = new C5105DLSet(aSN1EncodableVector);
            c5105DLSet2 = new C5105DLSet();
        } else {
            c5105DLSet = new C5105DLSet(aSN1EncodableVector);
            c5105DLSet2 = null;
        }
        return ASN1Integer.m14429valueOf(EnvelopedData.calculateVersion(originatorInfo, c5105DLSet, c5105DLSet2));
    }

    /* renamed from: open */
    public OutputStream m14863open(OutputStream outputStream, ASN1EncodableVector aSN1EncodableVector, OutputEncryptor outputEncryptor) throws CMSException {
        try {
            return m14865open(CMSObjectIdentifiers.f18179data, outputStream, aSN1EncodableVector, outputEncryptor);
        } catch (IOException e) {
            throw new CMSException("exception decoding algorithm parameters.", e);
        }
    }

    public void setBEREncodeRecipients(boolean z) {
        this._berEncodeRecipientSet = z;
    }

    public void setBufferSize(int i) {
        this._bufferSize = i;
    }

    /* renamed from: open */
    public OutputStream m14864open(OutputStream outputStream, OutputEncryptor outputEncryptor) {
        return m14866open(CMSObjectIdentifiers.f18179data, outputStream, outputEncryptor);
    }

    /* renamed from: open */
    public OutputStream m14865open(ASN1ObjectIdentifier aSN1ObjectIdentifier, OutputStream outputStream, ASN1EncodableVector aSN1EncodableVector, OutputEncryptor outputEncryptor) {
        BERSequenceGenerator bERSequenceGenerator = new BERSequenceGenerator(outputStream);
        bERSequenceGenerator.addObject((ASN1Primitive) CMSObjectIdentifiers.envelopedData);
        BERSequenceGenerator bERSequenceGenerator2 = new BERSequenceGenerator(bERSequenceGenerator.getRawOutputStream(), 0, true);
        bERSequenceGenerator2.addObject((ASN1Primitive) getVersion(aSN1EncodableVector));
        CMSUtils.addOriginatorInfoToGenerator(bERSequenceGenerator2, this.originatorInfo);
        CMSUtils.addRecipientInfosToGenerator(aSN1EncodableVector, bERSequenceGenerator2, this._berEncodeRecipientSet);
        BERSequenceGenerator bERSequenceGenerator3 = new BERSequenceGenerator(bERSequenceGenerator2.getRawOutputStream());
        bERSequenceGenerator3.addObject((ASN1Primitive) aSN1ObjectIdentifier);
        bERSequenceGenerator3.addObject(outputEncryptor.getAlgorithmIdentifier());
        return new CmsEnvelopedDataOutputStream(outputEncryptor, CMSUtils.createBEROctetOutputStream(bERSequenceGenerator3.getRawOutputStream(), 0, false, this._bufferSize), bERSequenceGenerator, bERSequenceGenerator2, bERSequenceGenerator3);
    }

    /* renamed from: open */
    public OutputStream m14866open(ASN1ObjectIdentifier aSN1ObjectIdentifier, OutputStream outputStream, OutputEncryptor outputEncryptor) {
        return m14865open(aSN1ObjectIdentifier, outputStream, CMSUtils.getRecipentInfos(outputEncryptor.mo14795getKey(), this.recipientInfoGenerators), outputEncryptor);
    }
}
