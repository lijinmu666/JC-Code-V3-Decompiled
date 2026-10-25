package org.bouncycastle.p191cms;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Map;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.BERSequenceGenerator;
import org.bouncycastle.p133asn1.C5104DERSet;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p139cms.AuthenticatedData;
import org.bouncycastle.p133asn1.p139cms.CMSObjectIdentifiers;
import org.bouncycastle.p361util.p362io.TeeOutputStream;

/* loaded from: classes2.dex */
public class CMSAuthenticatedDataStreamGenerator extends CMSAuthenticatedGenerator {
    private boolean berEncodeRecipientSet;
    private int bufferSize;

    public class CmsAuthenticatedDataOutputStream extends OutputStream {

        /* renamed from: cGen */
        private BERSequenceGenerator f18954cGen;
        private ASN1ObjectIdentifier contentType;
        private OutputStream dataStream;
        private DigestCalculator digestCalculator;

        /* renamed from: eiGen */
        private BERSequenceGenerator f18955eiGen;

        /* renamed from: envGen */
        private BERSequenceGenerator f18956envGen;
        private MacCalculator macCalculator;

        public CmsAuthenticatedDataOutputStream(MacCalculator macCalculator, DigestCalculator digestCalculator, ASN1ObjectIdentifier aSN1ObjectIdentifier, OutputStream outputStream, BERSequenceGenerator bERSequenceGenerator, BERSequenceGenerator bERSequenceGenerator2, BERSequenceGenerator bERSequenceGenerator3) {
            this.macCalculator = macCalculator;
            this.digestCalculator = digestCalculator;
            this.contentType = aSN1ObjectIdentifier;
            this.dataStream = outputStream;
            this.f18954cGen = bERSequenceGenerator;
            this.f18956envGen = bERSequenceGenerator2;
            this.f18955eiGen = bERSequenceGenerator3;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Map emptyParameters;
            this.dataStream.close();
            this.f18955eiGen.m14466close();
            DigestCalculator digestCalculator = this.digestCalculator;
            if (digestCalculator != null) {
                emptyParameters = Collections.unmodifiableMap(CMSAuthenticatedDataStreamGenerator.this.getBaseParameters(this.contentType, digestCalculator.getAlgorithmIdentifier(), this.macCalculator.getAlgorithmIdentifier(), this.digestCalculator.getDigest()));
                CMSAuthenticatedDataStreamGenerator cMSAuthenticatedDataStreamGenerator = CMSAuthenticatedDataStreamGenerator.this;
                if (cMSAuthenticatedDataStreamGenerator.f18958authGen == null) {
                    cMSAuthenticatedDataStreamGenerator.f18958authGen = new DefaultAuthenticatedAttributeTableGenerator();
                }
                C5104DERSet c5104DERSet = new C5104DERSet(CMSAuthenticatedDataStreamGenerator.this.f18958authGen.getAttributes(emptyParameters).toASN1EncodableVector());
                OutputStream outputStream = this.macCalculator.getOutputStream();
                outputStream.write(c5104DERSet.getEncoded(ASN1Encoding.f17902DER));
                outputStream.close();
                this.f18956envGen.addObject((ASN1Primitive) new DERTaggedObject(false, 2, (ASN1Encodable) c5104DERSet));
            } else {
                emptyParameters = CMSUtils.getEmptyParameters();
            }
            this.f18956envGen.addObject((ASN1Primitive) new DEROctetString(this.macCalculator.mo14790getMac()));
            CMSUtils.addAttriSetToGenerator(this.f18956envGen, CMSAuthenticatedDataStreamGenerator.this.unauthGen, 3, emptyParameters);
            this.f18956envGen.m14466close();
            this.f18954cGen.m14466close();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.dataStream.write(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.dataStream.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.dataStream.write(bArr, i, i2);
        }
    }

    /* renamed from: open */
    public OutputStream m14855open(OutputStream outputStream, MacCalculator macCalculator) {
        return m14857open(CMSObjectIdentifiers.f18179data, outputStream, macCalculator);
    }

    public void setBEREncodeRecipients(boolean z) {
        this.berEncodeRecipientSet = z;
    }

    public void setBufferSize(int i) {
        this.bufferSize = i;
    }

    /* renamed from: open */
    public OutputStream m14856open(OutputStream outputStream, MacCalculator macCalculator, DigestCalculator digestCalculator) {
        return m14858open(CMSObjectIdentifiers.f18179data, outputStream, macCalculator, digestCalculator);
    }

    /* renamed from: open */
    public OutputStream m14857open(ASN1ObjectIdentifier aSN1ObjectIdentifier, OutputStream outputStream, MacCalculator macCalculator) {
        return m14858open(aSN1ObjectIdentifier, outputStream, macCalculator, null);
    }

    /* renamed from: open */
    public OutputStream m14858open(ASN1ObjectIdentifier aSN1ObjectIdentifier, OutputStream outputStream, MacCalculator macCalculator, DigestCalculator digestCalculator) throws CMSException {
        try {
            ASN1EncodableVector recipentInfos = CMSUtils.getRecipentInfos(macCalculator.mo14789getKey(), this.recipientInfoGenerators);
            BERSequenceGenerator bERSequenceGenerator = new BERSequenceGenerator(outputStream);
            bERSequenceGenerator.addObject((ASN1Primitive) CMSObjectIdentifiers.authenticatedData);
            BERSequenceGenerator bERSequenceGenerator2 = new BERSequenceGenerator(bERSequenceGenerator.getRawOutputStream(), 0, true);
            bERSequenceGenerator2.addObject((ASN1Primitive) ASN1Integer.m14429valueOf(AuthenticatedData.calculateVersion(this.originatorInfo)));
            CMSUtils.addOriginatorInfoToGenerator(bERSequenceGenerator2, this.originatorInfo);
            CMSUtils.addRecipientInfosToGenerator(recipentInfos, bERSequenceGenerator2, this.berEncodeRecipientSet);
            bERSequenceGenerator2.addObject(macCalculator.getAlgorithmIdentifier());
            if (digestCalculator != null) {
                bERSequenceGenerator2.addObject((ASN1Primitive) new DERTaggedObject(false, 1, (ASN1Encodable) digestCalculator.getAlgorithmIdentifier()));
            }
            BERSequenceGenerator bERSequenceGenerator3 = new BERSequenceGenerator(bERSequenceGenerator2.getRawOutputStream());
            bERSequenceGenerator3.addObject((ASN1Primitive) aSN1ObjectIdentifier);
            OutputStream outputStreamCreateBEROctetOutputStream = CMSUtils.createBEROctetOutputStream(bERSequenceGenerator3.getRawOutputStream(), 0, true, this.bufferSize);
            return new CmsAuthenticatedDataOutputStream(macCalculator, digestCalculator, aSN1ObjectIdentifier, digestCalculator != null ? new TeeOutputStream(outputStreamCreateBEROctetOutputStream, digestCalculator.getOutputStream()) : new TeeOutputStream(outputStreamCreateBEROctetOutputStream, macCalculator.getOutputStream()), bERSequenceGenerator, bERSequenceGenerator2, bERSequenceGenerator3);
        } catch (IOException e) {
            throw new CMSException("exception decoding algorithm parameters.", e);
        }
    }
}
