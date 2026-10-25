package org.bouncycastle.p191cms;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.BERSequenceGenerator;
import org.bouncycastle.p133asn1.BERTaggedObject;
import org.bouncycastle.p133asn1.C5104DERSet;
import org.bouncycastle.p133asn1.C5105DLSet;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.DLSequence;
import org.bouncycastle.p133asn1.p139cms.CMSObjectIdentifiers;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public class CMSSignedDataStreamGenerator extends CMSSignedGenerator {
    private int _bufferSize;
    private String encoding;

    public class CmsDLSignedDataOutputStream extends OutputStream {
        private ASN1ObjectIdentifier _contentOID;
        private ByteArrayOutputStream _ecStream;

        /* renamed from: _eiGen */
        private ASN1EncodableVector f18992_eiGen;

        /* renamed from: _out */
        private OutputStream f18993_out;

        /* renamed from: _output */
        private OutputStream f18994_output;

        /* renamed from: _sigGen */
        private ASN1EncodableVector f18995_sigGen;

        public CmsDLSignedDataOutputStream(OutputStream outputStream, ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1EncodableVector aSN1EncodableVector, ASN1EncodableVector aSN1EncodableVector2, ByteArrayOutputStream byteArrayOutputStream, OutputStream outputStream2) {
            this.f18993_out = outputStream;
            this._contentOID = aSN1ObjectIdentifier;
            this.f18995_sigGen = aSN1EncodableVector;
            this.f18992_eiGen = aSN1EncodableVector2;
            this._ecStream = byteArrayOutputStream;
            this.f18994_output = outputStream2;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f18993_out.close();
            if (this._ecStream != null) {
                this.f18992_eiGen.m14420add(new DERTaggedObject(true, 0, (ASN1Encodable) new DEROctetString(this._ecStream.toByteArray())));
            }
            CMSSignedDataStreamGenerator.this.f19005digests.clear();
            this.f18995_sigGen.m14420add(new DLSequence(this.f18992_eiGen));
            boolean zEquals = ASN1Encoding.f17902DER.equals(CMSSignedDataStreamGenerator.this.encoding);
            if (CMSSignedDataStreamGenerator.this.f19003certs.size() != 0) {
                List list = CMSSignedDataStreamGenerator.this.f19003certs;
                this.f18995_sigGen.m14420add(new DERTaggedObject(false, 0, (ASN1Encodable) (zEquals ? CMSUtils.createDerSetFromList(list) : CMSUtils.createDlSetFromList(list))));
            }
            if (CMSSignedDataStreamGenerator.this.f19004crls.size() != 0) {
                List list2 = CMSSignedDataStreamGenerator.this.f19004crls;
                this.f18995_sigGen.m14420add(new DERTaggedObject(false, 1, (ASN1Encodable) (zEquals ? CMSUtils.createDerSetFromList(list2) : CMSUtils.createDlSetFromList(list2))));
            }
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            for (SignerInfoGenerator signerInfoGenerator : CMSSignedDataStreamGenerator.this.signerGens) {
                try {
                    aSN1EncodableVector.m14420add(signerInfoGenerator.generate(this._contentOID));
                    CMSSignedDataStreamGenerator.this.f19005digests.put(signerInfoGenerator.getDigestAlgorithm().getAlgorithm().m14433getId(), signerInfoGenerator.getCalculatedDigest());
                } catch (CMSException e) {
                    throw new CMSStreamException("exception generating signers: " + e.getMessage(), e);
                }
            }
            Iterator it = CMSSignedDataStreamGenerator.this._signers.iterator();
            while (it.hasNext()) {
                aSN1EncodableVector.m14420add(((SignerInformation) it.next()).toASN1Structure());
            }
            this.f18995_sigGen.m14420add(zEquals ? new C5104DERSet(aSN1EncodableVector) : new C5105DLSet(aSN1EncodableVector));
            this.f18994_output.write(new ContentInfo(CMSObjectIdentifiers.signedData, new DLSequence(this.f18995_sigGen)).getEncoded(CMSSignedDataStreamGenerator.this.encoding));
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.f18993_out.write(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f18993_out.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.f18993_out.write(bArr, i, i2);
        }
    }

    public class CmsSignedDataOutputStream extends OutputStream {
        private ASN1ObjectIdentifier _contentOID;

        /* renamed from: _eiGen */
        private BERSequenceGenerator f18997_eiGen;

        /* renamed from: _out */
        private OutputStream f18998_out;

        /* renamed from: _sGen */
        private BERSequenceGenerator f18999_sGen;

        /* renamed from: _sigGen */
        private BERSequenceGenerator f19000_sigGen;

        public CmsSignedDataOutputStream(OutputStream outputStream, ASN1ObjectIdentifier aSN1ObjectIdentifier, BERSequenceGenerator bERSequenceGenerator, BERSequenceGenerator bERSequenceGenerator2, BERSequenceGenerator bERSequenceGenerator3) {
            this.f18998_out = outputStream;
            this._contentOID = aSN1ObjectIdentifier;
            this.f18999_sGen = bERSequenceGenerator;
            this.f19000_sigGen = bERSequenceGenerator2;
            this.f18997_eiGen = bERSequenceGenerator3;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f18998_out.close();
            this.f18997_eiGen.m14466close();
            CMSSignedDataStreamGenerator.this.f19005digests.clear();
            if (CMSSignedDataStreamGenerator.this.f19003certs.size() != 0) {
                this.f19000_sigGen.addObject((ASN1Primitive) new BERTaggedObject(false, 0, (ASN1Encodable) CMSUtils.createBerSetFromList(CMSSignedDataStreamGenerator.this.f19003certs)));
            }
            if (CMSSignedDataStreamGenerator.this.f19004crls.size() != 0) {
                this.f19000_sigGen.addObject((ASN1Primitive) new BERTaggedObject(false, 1, (ASN1Encodable) CMSUtils.createBerSetFromList(CMSSignedDataStreamGenerator.this.f19004crls)));
            }
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            for (SignerInfoGenerator signerInfoGenerator : CMSSignedDataStreamGenerator.this.signerGens) {
                try {
                    aSN1EncodableVector.m14420add(signerInfoGenerator.generate(this._contentOID));
                    CMSSignedDataStreamGenerator.this.f19005digests.put(signerInfoGenerator.getDigestAlgorithm().getAlgorithm().m14433getId(), signerInfoGenerator.getCalculatedDigest());
                } catch (CMSException e) {
                    throw new CMSStreamException("exception generating signers: " + e.getMessage(), e);
                }
            }
            Iterator it = CMSSignedDataStreamGenerator.this._signers.iterator();
            while (it.hasNext()) {
                aSN1EncodableVector.m14420add(((SignerInformation) it.next()).toASN1Structure());
            }
            this.f19000_sigGen.addObject((ASN1Primitive) new C5105DLSet(aSN1EncodableVector));
            this.f19000_sigGen.m14466close();
            this.f18999_sGen.m14466close();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.f18998_out.write(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f18998_out.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.f18998_out.write(bArr, i, i2);
        }
    }

    public CMSSignedDataStreamGenerator() {
        this.encoding = ASN1Encoding.f17901BER;
    }

    private ASN1Integer calculateVersion(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        boolean z;
        boolean z2;
        boolean z3;
        List list = this.f19003certs;
        boolean z4 = false;
        if (list != null) {
            z = false;
            z2 = false;
            z3 = false;
            for (Object obj : list) {
                if (obj instanceof ASN1TaggedObject) {
                    ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) obj;
                    if (aSN1TaggedObject.getTagNo() == 1) {
                        z2 = true;
                    } else if (aSN1TaggedObject.getTagNo() == 2) {
                        z3 = true;
                    } else if (aSN1TaggedObject.getTagNo() == 3) {
                        z = true;
                    }
                }
            }
        } else {
            z = false;
            z2 = false;
            z3 = false;
        }
        if (z) {
            return ASN1Integer.f17916FIVE;
        }
        List list2 = this.f19004crls;
        if (list2 != null) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                if (it.next() instanceof ASN1TaggedObject) {
                    z4 = true;
                }
            }
        }
        if (z4) {
            return ASN1Integer.f17916FIVE;
        }
        if (z3) {
            return ASN1Integer.f17917FOUR;
        }
        if (!z2 && !checkForVersion3(this._signers, this.signerGens) && CMSObjectIdentifiers.f18179data.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return ASN1Integer.f17918ONE;
        }
        return ASN1Integer.f17919THREE;
    }

    private static boolean checkForVersion3(List list, List list2) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((SignerInformation) it.next()).toASN1Structure().getVersion().hasValue(3)) {
                return true;
            }
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            if (((SignerInfoGenerator) it2.next()).getGeneratedVersion() == 3) {
                return true;
            }
        }
        return false;
    }

    public List<AlgorithmIdentifier> getDigestAlgorithms() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this._signers.iterator();
        while (it.hasNext()) {
            arrayList.add(CMSSignedHelper.INSTANCE.fixDigestAlgID(((SignerInformation) it.next()).getDigestAlgorithmID(), this.digestAlgIdFinder));
        }
        Iterator it2 = this.signerGens.iterator();
        while (it2.hasNext()) {
            arrayList.add(((SignerInfoGenerator) it2.next()).getDigestAlgorithm());
        }
        return arrayList;
    }

    /* renamed from: open */
    public OutputStream m14869open(OutputStream outputStream) {
        return m14870open(outputStream, false);
    }

    public void setBufferSize(int i) {
        this._bufferSize = i;
    }

    public void setEncoding(String str) {
        if (!ASN1Encoding.f17901BER.equals(str) && !ASN1Encoding.f17903DL.equals(str) && !ASN1Encoding.f17902DER.equals(str)) {
            throw new IllegalArgumentException("encoding must be one of BER, DER, or DL");
        }
        this.encoding = str;
    }

    public CMSSignedDataStreamGenerator(DigestAlgorithmIdentifierFinder digestAlgorithmIdentifierFinder) {
        super(digestAlgorithmIdentifierFinder);
        this.encoding = ASN1Encoding.f17901BER;
    }

    /* renamed from: open */
    public OutputStream m14870open(OutputStream outputStream, boolean z) {
        return m14872open(CMSObjectIdentifiers.f18179data, outputStream, z);
    }

    /* renamed from: open */
    public OutputStream m14871open(OutputStream outputStream, boolean z, OutputStream outputStream2) {
        return m14873open(CMSObjectIdentifiers.f18179data, outputStream, z, outputStream2);
    }

    /* renamed from: open */
    public OutputStream m14872open(ASN1ObjectIdentifier aSN1ObjectIdentifier, OutputStream outputStream, boolean z) {
        return m14873open(aSN1ObjectIdentifier, outputStream, z, null);
    }

    /* renamed from: open */
    public OutputStream m14873open(ASN1ObjectIdentifier aSN1ObjectIdentifier, OutputStream outputStream, boolean z, OutputStream outputStream2) {
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.extraDigestAlgorithms);
        Iterator it = this._signers.iterator();
        while (it.hasNext()) {
            CMSUtils.addDigestAlgs(hashSet, (SignerInformation) it.next(), this.digestAlgIdFinder);
        }
        Iterator it2 = this.signerGens.iterator();
        while (it2.hasNext()) {
            hashSet.add(CMSSignedHelper.INSTANCE.fixDigestAlgID(((SignerInfoGenerator) it2.next()).getDigestAlgorithm(), this.digestAlgIdFinder));
        }
        if (ASN1Encoding.f17901BER.equals(this.encoding)) {
            BERSequenceGenerator bERSequenceGenerator = new BERSequenceGenerator(outputStream);
            bERSequenceGenerator.addObject((ASN1Primitive) CMSObjectIdentifiers.signedData);
            BERSequenceGenerator bERSequenceGenerator2 = new BERSequenceGenerator(bERSequenceGenerator.getRawOutputStream(), 0, true);
            bERSequenceGenerator2.addObject((ASN1Primitive) calculateVersion(aSN1ObjectIdentifier));
            bERSequenceGenerator2.addObject((ASN1Primitive) CMSUtils.convertToDlSet(hashSet));
            BERSequenceGenerator bERSequenceGenerator3 = new BERSequenceGenerator(bERSequenceGenerator2.getRawOutputStream());
            bERSequenceGenerator3.addObject((ASN1Primitive) aSN1ObjectIdentifier);
            return new CmsSignedDataOutputStream(CMSUtils.attachSignersToOutputStream(this.signerGens, CMSUtils.getSafeTeeOutputStream(outputStream2, z ? CMSUtils.createBEROctetOutputStream(bERSequenceGenerator3.getRawOutputStream(), 0, true, this._bufferSize) : null)), aSN1ObjectIdentifier, bERSequenceGenerator, bERSequenceGenerator2, bERSequenceGenerator3);
        }
        new ASN1EncodableVector().m14420add(CMSObjectIdentifiers.signedData);
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m14420add(calculateVersion(aSN1ObjectIdentifier));
        aSN1EncodableVector.m14420add(CMSUtils.convertToDlSet(hashSet));
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        aSN1EncodableVector2.m14420add(aSN1ObjectIdentifier);
        ByteArrayOutputStream byteArrayOutputStream = z ? new ByteArrayOutputStream() : null;
        return new CmsDLSignedDataOutputStream(CMSUtils.attachSignersToOutputStream(this.signerGens, CMSUtils.getSafeTeeOutputStream(outputStream2, byteArrayOutputStream)), aSN1ObjectIdentifier, aSN1EncodableVector, aSN1EncodableVector2, byteArrayOutputStream, outputStream);
    }
}
