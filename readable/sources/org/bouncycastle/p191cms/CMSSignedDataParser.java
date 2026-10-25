package org.bouncycastle.p191cms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Generator;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetStringParser;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1SequenceParser;
import org.bouncycastle.p133asn1.ASN1SetParser;
import org.bouncycastle.p133asn1.ASN1StreamParser;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.BERSequenceGenerator;
import org.bouncycastle.p133asn1.BERSetParser;
import org.bouncycastle.p133asn1.BERTaggedObject;
import org.bouncycastle.p133asn1.C5104DERSet;
import org.bouncycastle.p133asn1.C5105DLSet;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p139cms.CMSObjectIdentifiers;
import org.bouncycastle.p133asn1.p139cms.ContentInfoParser;
import org.bouncycastle.p133asn1.p139cms.SignedDataParser;
import org.bouncycastle.p133asn1.p139cms.SignerInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p361util.InterfaceC6249Store;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes2.dex */
public class CMSSignedDataParser extends CMSContentInfoParser {

    /* renamed from: HELPER */
    private static final CMSSignedHelper f18988HELPER = CMSSignedHelper.INSTANCE;
    private static final DefaultDigestAlgorithmIdentifierFinder dgstAlgFinder = new DefaultDigestAlgorithmIdentifierFinder();
    private AbstractC5093ASN1Set _certSet;

    /* renamed from: _crlSet */
    private AbstractC5093ASN1Set f18989_crlSet;
    private boolean _isCertCrlParsed;
    private CMSTypedStream _signedContent;
    private ASN1ObjectIdentifier _signedContentType;
    private SignedDataParser _signedData;
    private SignerInformationStore _signerInfoStore;
    private Set<AlgorithmIdentifier> digestAlgorithms;

    /* renamed from: digests */
    private Map f18990digests;

    public CMSSignedDataParser(DigestCalculatorProvider digestCalculatorProvider, InputStream inputStream) {
        this(digestCalculatorProvider, (CMSTypedStream) null, inputStream);
    }

    private static AbstractC5093ASN1Set getASN1Set(ASN1SetParser aSN1SetParser) {
        if (aSN1SetParser == null) {
            return null;
        }
        return AbstractC5093ASN1Set.getInstance(aSN1SetParser.toASN1Primitive());
    }

    private static void pipeEncapsulatedOctetString(ContentInfoParser contentInfoParser, OutputStream outputStream) throws IOException {
        ASN1OctetStringParser aSN1OctetStringParser = (ASN1OctetStringParser) contentInfoParser.getContent(4);
        if (aSN1OctetStringParser != null) {
            pipeOctetString(aSN1OctetStringParser, outputStream);
        }
    }

    private static void pipeOctetString(ASN1OctetStringParser aSN1OctetStringParser, OutputStream outputStream) throws IOException {
        OutputStream outputStreamCreateBEROctetOutputStream = CMSUtils.createBEROctetOutputStream(outputStream, 0, true, 0);
        C6257Streams.m18361pipeAll(aSN1OctetStringParser.getOctetStream(), outputStreamCreateBEROctetOutputStream);
        outputStreamCreateBEROctetOutputStream.close();
    }

    private void populateCertCrlSets() throws CMSException {
        if (this._isCertCrlParsed) {
            return;
        }
        this._isCertCrlParsed = true;
        try {
            this._certSet = getASN1Set(this._signedData.getCertificates());
            this.f18989_crlSet = getASN1Set(this._signedData.m14554getCrls());
        } catch (IOException e) {
            throw new CMSException("problem parsing cert/crl sets", e);
        }
    }

    public static OutputStream replaceCertificatesAndCRLs(InputStream inputStream, InterfaceC6249Store interfaceC6249Store, InterfaceC6249Store interfaceC6249Store2, InterfaceC6249Store interfaceC6249Store3, OutputStream outputStream) throws IOException {
        SignedDataParser signedDataParser = SignedDataParser.getInstance(new ContentInfoParser((ASN1SequenceParser) new ASN1StreamParser(inputStream).readObject()).getContent(16));
        BERSequenceGenerator bERSequenceGenerator = new BERSequenceGenerator(outputStream);
        bERSequenceGenerator.addObject((ASN1Primitive) CMSObjectIdentifiers.signedData);
        BERSequenceGenerator bERSequenceGenerator2 = new BERSequenceGenerator(bERSequenceGenerator.getRawOutputStream(), 0, true);
        bERSequenceGenerator2.addObject((ASN1Primitive) signedDataParser.getVersion());
        bERSequenceGenerator2.addObject(signedDataParser.getDigestAlgorithms());
        writeEncapContentInfoToGenerator(signedDataParser, bERSequenceGenerator2);
        getASN1Set(signedDataParser.getCertificates());
        getASN1Set(signedDataParser.m14554getCrls());
        if (interfaceC6249Store != null || interfaceC6249Store3 != null) {
            ArrayList arrayList = new ArrayList();
            if (interfaceC6249Store != null) {
                arrayList.addAll(CMSUtils.getCertificatesFromStore(interfaceC6249Store));
            }
            if (interfaceC6249Store3 != null) {
                arrayList.addAll(CMSUtils.getAttributeCertificatesFromStore(interfaceC6249Store3));
            }
            AbstractC5093ASN1Set abstractC5093ASN1SetCreateBerSetFromList = CMSUtils.createBerSetFromList(arrayList);
            if (abstractC5093ASN1SetCreateBerSetFromList.m14454size() > 0) {
                bERSequenceGenerator2.addObject((ASN1Primitive) new DERTaggedObject(false, 0, (ASN1Encodable) abstractC5093ASN1SetCreateBerSetFromList));
            }
        }
        if (interfaceC6249Store2 != null) {
            AbstractC5093ASN1Set abstractC5093ASN1SetCreateBerSetFromList2 = CMSUtils.createBerSetFromList(CMSUtils.getCRLsFromStore(interfaceC6249Store2));
            if (abstractC5093ASN1SetCreateBerSetFromList2.m14454size() > 0) {
                bERSequenceGenerator2.addObject((ASN1Primitive) new DERTaggedObject(false, 1, (ASN1Encodable) abstractC5093ASN1SetCreateBerSetFromList2));
            }
        }
        bERSequenceGenerator2.addObject(signedDataParser.getSignerInfos());
        bERSequenceGenerator2.m14466close();
        bERSequenceGenerator.m14466close();
        return outputStream;
    }

    public static OutputStream replaceSigners(InputStream inputStream, SignerInformationStore signerInformationStore, OutputStream outputStream) throws IOException {
        SignedDataParser signedDataParser = SignedDataParser.getInstance(new ContentInfoParser((ASN1SequenceParser) new ASN1StreamParser(inputStream).readObject()).getContent(16));
        BERSequenceGenerator bERSequenceGenerator = new BERSequenceGenerator(outputStream);
        bERSequenceGenerator.addObject((ASN1Primitive) CMSObjectIdentifiers.signedData);
        BERSequenceGenerator bERSequenceGenerator2 = new BERSequenceGenerator(bERSequenceGenerator.getRawOutputStream(), 0, true);
        bERSequenceGenerator2.addObject((ASN1Primitive) signedDataParser.getVersion());
        signedDataParser.getDigestAlgorithms().toASN1Primitive();
        HashSet hashSet = new HashSet();
        for (SignerInformation signerInformation : signerInformationStore.getSigners()) {
            DefaultDigestAlgorithmIdentifierFinder defaultDigestAlgorithmIdentifierFinder = dgstAlgFinder;
            CMSUtils.addDigestAlgs(hashSet, signerInformation, defaultDigestAlgorithmIdentifierFinder);
            hashSet.add(f18988HELPER.fixDigestAlgID(signerInformation.getDigestAlgorithmID(), defaultDigestAlgorithmIdentifierFinder));
        }
        bERSequenceGenerator2.addObject((ASN1Primitive) new C5105DLSet((AlgorithmIdentifier[]) hashSet.toArray(new AlgorithmIdentifier[hashSet.size()])));
        writeEncapContentInfoToGenerator(signedDataParser, bERSequenceGenerator2);
        writeSetToGeneratorTagged(bERSequenceGenerator2, signedDataParser.getCertificates(), 0);
        writeSetToGeneratorTagged(bERSequenceGenerator2, signedDataParser.m14554getCrls(), 1);
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Iterator<SignerInformation> it = signerInformationStore.getSigners().iterator();
        while (it.hasNext()) {
            aSN1EncodableVector.m14420add(it.next().toASN1Structure());
        }
        bERSequenceGenerator2.addObject((ASN1Primitive) new C5104DERSet(aSN1EncodableVector));
        bERSequenceGenerator2.m14466close();
        bERSequenceGenerator.m14466close();
        return outputStream;
    }

    public static void writeEncapContentInfoToGenerator(SignedDataParser signedDataParser, BERSequenceGenerator bERSequenceGenerator) throws IOException {
        ContentInfoParser encapContentInfo = signedDataParser.getEncapContentInfo();
        BERSequenceGenerator bERSequenceGenerator2 = new BERSequenceGenerator(bERSequenceGenerator.getRawOutputStream());
        bERSequenceGenerator2.addObject((ASN1Primitive) encapContentInfo.getContentType());
        pipeEncapsulatedOctetString(encapContentInfo, bERSequenceGenerator2.getRawOutputStream());
        bERSequenceGenerator2.m14466close();
    }

    public static void writeSetToGeneratorTagged(ASN1Generator aSN1Generator, ASN1SetParser aSN1SetParser, int i) {
        AbstractC5093ASN1Set aSN1Set = getASN1Set(aSN1SetParser);
        if (aSN1Set != null) {
            (aSN1SetParser instanceof BERSetParser ? new BERTaggedObject(false, i, (ASN1Encodable) aSN1Set) : new DERTaggedObject(false, i, (ASN1Encodable) aSN1Set)).encodeTo(aSN1Generator.getRawOutputStream());
        }
    }

    public InterfaceC6249Store getAttributeCertificates() throws CMSException {
        populateCertCrlSets();
        return f18988HELPER.getAttributeCertificates(this._certSet);
    }

    /* renamed from: getCRLs */
    public InterfaceC6249Store m14868getCRLs() throws CMSException {
        populateCertCrlSets();
        return f18988HELPER.m14876getCRLs(this.f18989_crlSet);
    }

    public InterfaceC6249Store getCertificates() throws CMSException {
        populateCertCrlSets();
        return f18988HELPER.getCertificates(this._certSet);
    }

    public Set<AlgorithmIdentifier> getDigestAlgorithmIDs() {
        return this.digestAlgorithms;
    }

    public InterfaceC6249Store getOtherRevocationInfo(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws CMSException {
        populateCertCrlSets();
        return f18988HELPER.getOtherRevocationInfo(aSN1ObjectIdentifier, this.f18989_crlSet);
    }

    public CMSTypedStream getSignedContent() {
        if (this._signedContent == null) {
            return null;
        }
        return new CMSTypedStream(this._signedContent.getContentType(), CMSUtils.attachDigestsToInputStream(this.f18990digests.values(), this._signedContent.getContentStream()));
    }

    public String getSignedContentTypeOID() {
        return this._signedContentType.m14433getId();
    }

    public SignerInformationStore getSignerInfos() throws CMSException {
        if (this._signerInfoStore == null) {
            populateCertCrlSets();
            ArrayList arrayList = new ArrayList();
            HashMap map = new HashMap();
            for (Object obj : this.f18990digests.keySet()) {
                map.put(obj, ((DigestCalculator) this.f18990digests.get(obj)).getDigest());
            }
            try {
                ASN1SetParser signerInfos = this._signedData.getSignerInfos();
                while (true) {
                    ASN1Encodable object = signerInfos.readObject();
                    if (object == null) {
                        break;
                    }
                    SignerInfo signerInfo = SignerInfo.getInstance(object.toASN1Primitive());
                    arrayList.add(new SignerInformation(signerInfo, this._signedContentType, null, (byte[]) map.get(signerInfo.getDigestAlgorithm().getAlgorithm())));
                }
                this._signerInfoStore = new SignerInformationStore(arrayList);
            } catch (IOException e) {
                throw new CMSException("io exception: " + e.getMessage(), e);
            }
        }
        return this._signerInfoStore;
    }

    public int getVersion() {
        return this._signedData.getVersion().intValueExact();
    }

    public CMSSignedDataParser(DigestCalculatorProvider digestCalculatorProvider, CMSTypedStream cMSTypedStream, InputStream inputStream) throws CMSException {
        CMSTypedStream pKCS7TypedStream;
        super(inputStream);
        try {
            this._signedContent = cMSTypedStream;
            this._signedData = SignedDataParser.getInstance(this._contentInfo.getContent(16));
            this.f18990digests = new HashMap();
            ASN1SetParser digestAlgorithms = this._signedData.getDigestAlgorithms();
            HashSet hashSet = new HashSet();
            while (true) {
                ASN1Encodable object = digestAlgorithms.readObject();
                if (object == null) {
                    break;
                }
                AlgorithmIdentifier algorithmIdentifier = AlgorithmIdentifier.getInstance(object);
                hashSet.add(algorithmIdentifier);
                try {
                    DigestCalculator digestCalculatorMo14763get = digestCalculatorProvider.mo14763get(algorithmIdentifier);
                    if (digestCalculatorMo14763get != null) {
                        this.f18990digests.put(algorithmIdentifier.getAlgorithm(), digestCalculatorMo14763get);
                    }
                } catch (OperatorCreationException unused) {
                }
            }
            this.digestAlgorithms = Collections.unmodifiableSet(hashSet);
            ContentInfoParser encapContentInfo = this._signedData.getEncapContentInfo();
            ASN1Encodable content = encapContentInfo.getContent(4);
            if (content instanceof ASN1OctetStringParser) {
                pKCS7TypedStream = new CMSTypedStream(encapContentInfo.getContentType(), ((ASN1OctetStringParser) content).getOctetStream());
                if (this._signedContent == null) {
                    this._signedContent = pKCS7TypedStream;
                } else {
                    pKCS7TypedStream.mo14877drain();
                }
            } else if (content != null) {
                pKCS7TypedStream = new PKCS7TypedStream(encapContentInfo.getContentType(), content);
                if (this._signedContent == null) {
                    this._signedContent = pKCS7TypedStream;
                } else {
                    pKCS7TypedStream.mo14877drain();
                }
            }
            this._signedContentType = cMSTypedStream == null ? encapContentInfo.getContentType() : this._signedContent.getContentType();
        } catch (IOException e) {
            throw new CMSException("io exception: " + e.getMessage(), e);
        }
    }

    public CMSSignedDataParser(DigestCalculatorProvider digestCalculatorProvider, CMSTypedStream cMSTypedStream, byte[] bArr) {
        this(digestCalculatorProvider, cMSTypedStream, new ByteArrayInputStream(bArr));
    }

    public CMSSignedDataParser(DigestCalculatorProvider digestCalculatorProvider, byte[] bArr) {
        this(digestCalculatorProvider, new ByteArrayInputStream(bArr));
    }
}
