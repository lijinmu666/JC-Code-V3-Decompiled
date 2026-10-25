package org.bouncycastle.p191cms;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.operator.OutputAEADEncryptor;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.BERSequenceGenerator;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p139cms.CMSObjectIdentifiers;

/* loaded from: classes2.dex */
public class CMSAuthEnvelopedDataStreamGenerator extends CMSAuthEnvelopedGenerator {
    private boolean _berEncodeRecipientSet;
    private int _bufferSize;

    public class CMSAuthEnvelopedDataOutputStream extends OutputStream {

        /* renamed from: _cGen */
        private final BERSequenceGenerator f18944_cGen;

        /* renamed from: _cOut */
        private final OutputStream f18945_cOut;

        /* renamed from: _eiGen */
        private final BERSequenceGenerator f18946_eiGen;
        private final OutputAEADEncryptor _encryptor;

        /* renamed from: _envGen */
        private final BERSequenceGenerator f18947_envGen;
        private final OutputStream _octetStream;

        public CMSAuthEnvelopedDataOutputStream(OutputAEADEncryptor outputAEADEncryptor, OutputStream outputStream, BERSequenceGenerator bERSequenceGenerator, BERSequenceGenerator bERSequenceGenerator2, BERSequenceGenerator bERSequenceGenerator3) {
            this._encryptor = outputAEADEncryptor;
            this._octetStream = outputStream;
            this.f18945_cOut = outputAEADEncryptor.getOutputStream(outputStream);
            this.f18944_cGen = bERSequenceGenerator;
            this.f18947_envGen = bERSequenceGenerator2;
            this.f18946_eiGen = bERSequenceGenerator3;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            AbstractC5093ASN1Set abstractC5093ASN1SetProcessAuthAttrSet = CMSUtils.processAuthAttrSet(CMSAuthEnvelopedDataStreamGenerator.this.authAttrsGenerator, this._encryptor);
            this.f18945_cOut.close();
            this._octetStream.close();
            this.f18946_eiGen.m14466close();
            if (abstractC5093ASN1SetProcessAuthAttrSet != null) {
                this.f18947_envGen.addObject((ASN1Primitive) new DERTaggedObject(false, 1, (ASN1Encodable) abstractC5093ASN1SetProcessAuthAttrSet));
            }
            this.f18947_envGen.addObject((ASN1Primitive) new DEROctetString(this._encryptor.mo14908getMAC()));
            CMSUtils.addAttriSetToGenerator(this.f18947_envGen, CMSAuthEnvelopedDataStreamGenerator.this.unauthAttrsGenerator, 2, CMSUtils.getEmptyParameters());
            this.f18947_envGen.m14466close();
            this.f18944_cGen.m14466close();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.f18945_cOut.write(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f18945_cOut.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.f18945_cOut.write(bArr, i, i2);
        }
    }

    /* renamed from: open */
    public OutputStream m14849open(OutputStream outputStream, ASN1EncodableVector aSN1EncodableVector, OutputAEADEncryptor outputAEADEncryptor) throws CMSException {
        try {
            return m14851open(CMSObjectIdentifiers.f18179data, outputStream, aSN1EncodableVector, outputAEADEncryptor);
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
    public OutputStream m14850open(OutputStream outputStream, OutputAEADEncryptor outputAEADEncryptor) {
        return m14852open(CMSObjectIdentifiers.f18179data, outputStream, outputAEADEncryptor);
    }

    /* renamed from: open */
    public OutputStream m14851open(ASN1ObjectIdentifier aSN1ObjectIdentifier, OutputStream outputStream, ASN1EncodableVector aSN1EncodableVector, OutputAEADEncryptor outputAEADEncryptor) {
        BERSequenceGenerator bERSequenceGenerator = new BERSequenceGenerator(outputStream);
        bERSequenceGenerator.addObject((ASN1Primitive) CMSObjectIdentifiers.authEnvelopedData);
        BERSequenceGenerator bERSequenceGenerator2 = new BERSequenceGenerator(bERSequenceGenerator.getRawOutputStream(), 0, true);
        bERSequenceGenerator2.addObject((ASN1Primitive) ASN1Integer.f17922ZERO);
        CMSUtils.addOriginatorInfoToGenerator(bERSequenceGenerator2, ((CMSAuthEnvelopedGenerator) this).originatorInfo);
        CMSUtils.addRecipientInfosToGenerator(aSN1EncodableVector, bERSequenceGenerator2, this._berEncodeRecipientSet);
        BERSequenceGenerator bERSequenceGenerator3 = new BERSequenceGenerator(bERSequenceGenerator2.getRawOutputStream());
        bERSequenceGenerator3.addObject((ASN1Primitive) aSN1ObjectIdentifier);
        bERSequenceGenerator3.addObject(outputAEADEncryptor.getAlgorithmIdentifier());
        return new CMSAuthEnvelopedDataOutputStream(outputAEADEncryptor, CMSUtils.createBEROctetOutputStream(bERSequenceGenerator3.getRawOutputStream(), 0, false, this._bufferSize), bERSequenceGenerator, bERSequenceGenerator2, bERSequenceGenerator3);
    }

    /* renamed from: open */
    public OutputStream m14852open(ASN1ObjectIdentifier aSN1ObjectIdentifier, OutputStream outputStream, OutputAEADEncryptor outputAEADEncryptor) {
        return m14851open(aSN1ObjectIdentifier, outputStream, CMSUtils.getRecipentInfos(outputAEADEncryptor.mo14795getKey(), this.recipientInfoGenerators), outputAEADEncryptor);
    }
}
