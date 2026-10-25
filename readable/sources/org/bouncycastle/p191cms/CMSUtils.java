package org.bouncycastle.p191cms;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OutputAEADEncryptor;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1InputStream;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1SequenceParser;
import org.bouncycastle.p133asn1.ASN1SetParser;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.BEROctetStringGenerator;
import org.bouncycastle.p133asn1.BERSequenceGenerator;
import org.bouncycastle.p133asn1.C5101BERSet;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.C5104DERSet;
import org.bouncycastle.p133asn1.C5105DLSet;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.p139cms.AttributeTable;
import org.bouncycastle.p133asn1.p139cms.CMSObjectIdentifiers;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;
import org.bouncycastle.p133asn1.p139cms.EncryptedContentInfo;
import org.bouncycastle.p133asn1.p139cms.OriginatorInfo;
import org.bouncycastle.p133asn1.p139cms.OtherRevocationInfoFormat;
import org.bouncycastle.p133asn1.p164ocsp.OCSPResponse;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p167sec.SECObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p133asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.p177cert.X509AttributeCertificateHolder;
import org.bouncycastle.p177cert.X509CRLHolder;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p361util.InterfaceC6249Store;
import org.bouncycastle.p361util.p362io.C6257Streams;
import org.bouncycastle.p361util.p362io.TeeInputStream;
import org.bouncycastle.p361util.p362io.TeeOutputStream;

/* loaded from: classes2.dex */
class CMSUtils {

    /* renamed from: desAlgs */
    private static final Set f19009desAlgs;

    /* renamed from: ecAlgs */
    private static final Set f19010ecAlgs;
    private static final Set gostAlgs;

    /* renamed from: mqvAlgs */
    private static final Set f19011mqvAlgs;

    static {
        HashSet hashSet = new HashSet();
        f19009desAlgs = hashSet;
        HashSet hashSet2 = new HashSet();
        f19011mqvAlgs = hashSet2;
        HashSet hashSet3 = new HashSet();
        f19010ecAlgs = hashSet3;
        HashSet hashSet4 = new HashSet();
        gostAlgs = hashSet4;
        hashSet.add(OIWObjectIdentifiers.f18454desCBC);
        hashSet.add(PKCSObjectIdentifiers.des_EDE3_CBC);
        hashSet.add(PKCSObjectIdentifiers.id_alg_CMS3DESwrap);
        hashSet2.add(X9ObjectIdentifiers.mqvSinglePass_sha1kdf_scheme);
        hashSet2.add(SECObjectIdentifiers.mqvSinglePass_sha224kdf_scheme);
        hashSet2.add(SECObjectIdentifiers.mqvSinglePass_sha256kdf_scheme);
        hashSet2.add(SECObjectIdentifiers.mqvSinglePass_sha384kdf_scheme);
        hashSet2.add(SECObjectIdentifiers.mqvSinglePass_sha512kdf_scheme);
        hashSet3.add(X9ObjectIdentifiers.dhSinglePass_cofactorDH_sha1kdf_scheme);
        hashSet3.add(X9ObjectIdentifiers.dhSinglePass_stdDH_sha1kdf_scheme);
        hashSet3.add(SECObjectIdentifiers.dhSinglePass_cofactorDH_sha224kdf_scheme);
        hashSet3.add(SECObjectIdentifiers.dhSinglePass_stdDH_sha224kdf_scheme);
        hashSet3.add(SECObjectIdentifiers.dhSinglePass_cofactorDH_sha256kdf_scheme);
        hashSet3.add(SECObjectIdentifiers.dhSinglePass_stdDH_sha256kdf_scheme);
        hashSet3.add(SECObjectIdentifiers.dhSinglePass_cofactorDH_sha384kdf_scheme);
        hashSet3.add(SECObjectIdentifiers.dhSinglePass_stdDH_sha384kdf_scheme);
        hashSet3.add(SECObjectIdentifiers.dhSinglePass_cofactorDH_sha512kdf_scheme);
        hashSet3.add(SECObjectIdentifiers.dhSinglePass_stdDH_sha512kdf_scheme);
        hashSet4.add(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_ESDH);
        hashSet4.add(RosstandartObjectIdentifiers.id_tc26_agreement_gost_3410_12_256);
        hashSet4.add(RosstandartObjectIdentifiers.id_tc26_agreement_gost_3410_12_512);
    }

    public static void addAttriSetToGenerator(BERSequenceGenerator bERSequenceGenerator, CMSAttributeTableGenerator cMSAttributeTableGenerator, int i, Map map) {
        if (cMSAttributeTableGenerator != null) {
            bERSequenceGenerator.addObject((ASN1Primitive) new DERTaggedObject(false, i, (ASN1Encodable) new C5101BERSet(cMSAttributeTableGenerator.getAttributes(map).toASN1EncodableVector())));
        }
    }

    public static void addDigestAlgs(Set<AlgorithmIdentifier> set, SignerInformation signerInformation, DigestAlgorithmIdentifierFinder digestAlgorithmIdentifierFinder) {
        set.add(CMSSignedHelper.INSTANCE.fixDigestAlgID(signerInformation.getDigestAlgorithmID(), digestAlgorithmIdentifierFinder));
        Iterator<SignerInformation> it = signerInformation.getCounterSignatures().iterator();
        while (it.hasNext()) {
            set.add(CMSSignedHelper.INSTANCE.fixDigestAlgID(it.next().getDigestAlgorithmID(), digestAlgorithmIdentifierFinder));
        }
    }

    public static void addOriginatorInfoToGenerator(BERSequenceGenerator bERSequenceGenerator, OriginatorInfo originatorInfo) {
        if (originatorInfo != null) {
            bERSequenceGenerator.addObject((ASN1Primitive) new DERTaggedObject(false, 0, (ASN1Encodable) originatorInfo));
        }
    }

    public static void addRecipientInfosToGenerator(ASN1EncodableVector aSN1EncodableVector, BERSequenceGenerator bERSequenceGenerator, boolean z) {
        (z ? new C5101BERSet(aSN1EncodableVector) : new C5104DERSet(aSN1EncodableVector)).encodeTo(bERSequenceGenerator.getRawOutputStream());
    }

    public static InputStream attachDigestsToInputStream(Collection collection, InputStream inputStream) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            inputStream = new TeeInputStream(inputStream, ((DigestCalculator) it.next()).getOutputStream());
        }
        return inputStream;
    }

    public static OutputStream attachSignersToOutputStream(Collection collection, OutputStream outputStream) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            outputStream = getSafeTeeOutputStream(outputStream, ((SignerInfoGenerator) it.next()).getCalculatingOutputStream());
        }
        return outputStream;
    }

    public static AbstractC5093ASN1Set convertToDlSet(Set<AlgorithmIdentifier> set) {
        return new C5105DLSet((AlgorithmIdentifier[]) set.toArray(new AlgorithmIdentifier[set.size()]));
    }

    public static OutputStream createBEROctetOutputStream(OutputStream outputStream, int i, boolean z, int i2) {
        BEROctetStringGenerator bEROctetStringGenerator = new BEROctetStringGenerator(outputStream, i, z);
        return i2 != 0 ? bEROctetStringGenerator.getOctetOutputStream(new byte[i2]) : bEROctetStringGenerator.getOctetOutputStream();
    }

    public static AbstractC5093ASN1Set createBerSetFromList(List list) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            aSN1EncodableVector.m14420add((ASN1Encodable) it.next());
        }
        return new C5101BERSet(aSN1EncodableVector);
    }

    public static AbstractC5093ASN1Set createDerSetFromList(List list) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            aSN1EncodableVector.m14420add((ASN1Encodable) it.next());
        }
        return new C5104DERSet(aSN1EncodableVector);
    }

    public static AbstractC5093ASN1Set createDlSetFromList(List list) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            aSN1EncodableVector.m14420add((ASN1Encodable) it.next());
        }
        return new C5105DLSet(aSN1EncodableVector);
    }

    public static byte[] encodeObj(ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            return aSN1Encodable.toASN1Primitive().getEncoded();
        }
        return null;
    }

    public static AbstractC5093ASN1Set getAttrBERSet(CMSAttributeTableGenerator cMSAttributeTableGenerator) {
        if (cMSAttributeTableGenerator != null) {
            return new C5101BERSet(cMSAttributeTableGenerator.getAttributes(getEmptyParameters()).toASN1EncodableVector());
        }
        return null;
    }

    public static AbstractC5093ASN1Set getAttrDLSet(CMSAttributeTableGenerator cMSAttributeTableGenerator) {
        if (cMSAttributeTableGenerator != null) {
            return new C5105DLSet(cMSAttributeTableGenerator.getAttributes(getEmptyParameters()).toASN1EncodableVector());
        }
        return null;
    }

    public static List getAttributeCertificatesFromStore(InterfaceC6249Store interfaceC6249Store) throws CMSException {
        ArrayList arrayList = new ArrayList();
        try {
            Iterator it = interfaceC6249Store.getMatches(null).iterator();
            while (it.hasNext()) {
                arrayList.add(new DERTaggedObject(false, 2, (ASN1Encodable) ((X509AttributeCertificateHolder) it.next()).toASN1Structure()));
            }
            return arrayList;
        } catch (ClassCastException e) {
            throw new CMSException("error processing certs", e);
        }
    }

    public static AttributeTable getAttributesTable(ASN1SetParser aSN1SetParser) {
        if (aSN1SetParser == null) {
            return null;
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        while (true) {
            ASN1Encodable object = aSN1SetParser.readObject();
            if (object == null) {
                return new AttributeTable(new C5104DERSet(aSN1EncodableVector));
            }
            aSN1EncodableVector.m14420add(((ASN1SequenceParser) object).toASN1Primitive());
        }
    }

    public static List getCRLsFromStore(InterfaceC6249Store interfaceC6249Store) throws CMSException {
        ArrayList arrayList = new ArrayList();
        try {
            for (Object aSN1Structure : interfaceC6249Store.getMatches(null)) {
                if (aSN1Structure instanceof X509CRLHolder) {
                    aSN1Structure = ((X509CRLHolder) aSN1Structure).toASN1Structure();
                } else if (aSN1Structure instanceof OtherRevocationInfoFormat) {
                    OtherRevocationInfoFormat otherRevocationInfoFormat = OtherRevocationInfoFormat.getInstance(aSN1Structure);
                    validateInfoFormat(otherRevocationInfoFormat);
                    arrayList.add(new DERTaggedObject(false, 1, (ASN1Encodable) otherRevocationInfoFormat));
                } else if (aSN1Structure instanceof ASN1TaggedObject) {
                }
                arrayList.add(aSN1Structure);
            }
            return arrayList;
        } catch (ClassCastException e) {
            throw new CMSException("error processing certs", e);
        }
    }

    public static List getCertificatesFromStore(InterfaceC6249Store interfaceC6249Store) throws CMSException {
        ArrayList arrayList = new ArrayList();
        try {
            Iterator it = interfaceC6249Store.getMatches(null).iterator();
            while (it.hasNext()) {
                arrayList.add(((X509CertificateHolder) it.next()).toASN1Structure());
            }
            return arrayList;
        } catch (ClassCastException e) {
            throw new CMSException("error processing certs", e);
        }
    }

    public static Map getEmptyParameters() {
        return Collections.EMPTY_MAP;
    }

    public static EncryptedContentInfo getEncryptedContentInfo(CMSTypedData cMSTypedData, OutputEncryptor outputEncryptor, ASN1OctetString aSN1OctetString) {
        return new EncryptedContentInfo(cMSTypedData.getContentType(), outputEncryptor.getAlgorithmIdentifier(), aSN1OctetString);
    }

    public static Collection getOthersFromStore(ASN1ObjectIdentifier aSN1ObjectIdentifier, InterfaceC6249Store interfaceC6249Store) {
        ArrayList arrayList = new ArrayList();
        Iterator it = interfaceC6249Store.getMatches(null).iterator();
        while (it.hasNext()) {
            OtherRevocationInfoFormat otherRevocationInfoFormat = new OtherRevocationInfoFormat(aSN1ObjectIdentifier, (ASN1Encodable) it.next());
            validateInfoFormat(otherRevocationInfoFormat);
            arrayList.add(new DERTaggedObject(false, 1, (ASN1Encodable) otherRevocationInfoFormat));
        }
        return arrayList;
    }

    public static ASN1EncodableVector getRecipentInfos(GenericKey genericKey, List list) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            aSN1EncodableVector.m14420add(((RecipientInfoGenerator) it.next()).generate(genericKey));
        }
        return aSN1EncodableVector;
    }

    public static OutputStream getSafeOutputStream(OutputStream outputStream) {
        return outputStream == null ? new NullOutputStream() : outputStream;
    }

    public static OutputStream getSafeTeeOutputStream(OutputStream outputStream, OutputStream outputStream2) {
        return outputStream == null ? getSafeOutputStream(outputStream2) : outputStream2 == null ? getSafeOutputStream(outputStream) : new TeeOutputStream(outputStream, outputStream2);
    }

    /* renamed from: isDES */
    public static boolean m14878isDES(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return f19009desAlgs.contains(aSN1ObjectIdentifier);
    }

    /* renamed from: isEC */
    public static boolean m14879isEC(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return f19010ecAlgs.contains(aSN1ObjectIdentifier);
    }

    public static boolean isEquivalent(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2) {
        if (algorithmIdentifier == null || algorithmIdentifier2 == null || !algorithmIdentifier.getAlgorithm().m14446equals((ASN1Primitive) algorithmIdentifier2.getAlgorithm())) {
            return false;
        }
        ASN1Encodable parameters = algorithmIdentifier.getParameters();
        ASN1Encodable parameters2 = algorithmIdentifier2.getParameters();
        return parameters != null ? parameters.equals(parameters2) || (parameters.equals(C5103DERNull.INSTANCE) && parameters2 == null) : parameters2 == null || parameters2.equals(C5103DERNull.INSTANCE);
    }

    /* renamed from: isGOST */
    public static boolean m14880isGOST(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return gostAlgs.contains(aSN1ObjectIdentifier);
    }

    /* renamed from: isMQV */
    public static boolean m14881isMQV(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return f19011mqvAlgs.contains(aSN1ObjectIdentifier);
    }

    public static boolean isRFC2631(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return PKCSObjectIdentifiers.id_alg_ESDH.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) || PKCSObjectIdentifiers.id_alg_SSDH.m14446equals((ASN1Primitive) aSN1ObjectIdentifier);
    }

    public static AbstractC5093ASN1Set processAuthAttrSet(CMSAttributeTableGenerator cMSAttributeTableGenerator, OutputAEADEncryptor outputAEADEncryptor) throws IOException {
        if (cMSAttributeTableGenerator == null) {
            return null;
        }
        C5104DERSet c5104DERSet = new C5104DERSet(cMSAttributeTableGenerator.getAttributes(getEmptyParameters()).toASN1EncodableVector());
        outputAEADEncryptor.getAADStream().write(c5104DERSet.getEncoded(ASN1Encoding.f17902DER));
        return c5104DERSet;
    }

    public static ContentInfo readContentInfo(InputStream inputStream) {
        return readContentInfo(new ASN1InputStream(inputStream));
    }

    public static byte[] streamToByteArray(InputStream inputStream) {
        return C6257Streams.m18363readAll(inputStream);
    }

    public static void validateInfoFormat(OtherRevocationInfoFormat otherRevocationInfoFormat) {
        if (CMSObjectIdentifiers.id_ri_ocsp_response.m14446equals((ASN1Primitive) otherRevocationInfoFormat.getInfoFormat()) && OCSPResponse.getInstance(otherRevocationInfoFormat.m14549getInfo()).getResponseStatus().getIntValue() != 0) {
            throw new IllegalArgumentException("cannot add unsuccessful OCSP response to CMS SignedData");
        }
    }

    private static ContentInfo readContentInfo(ASN1InputStream aSN1InputStream) throws CMSException {
        try {
            ContentInfo contentInfo = ContentInfo.getInstance(aSN1InputStream.readObject());
            if (contentInfo != null) {
                return contentInfo;
            }
            throw new CMSException("No content found.");
        } catch (IOException e) {
            throw new CMSException("IOException reading content.", e);
        } catch (ClassCastException e2) {
            throw new CMSException("Malformed content.", e2);
        } catch (IllegalArgumentException e3) {
            throw new CMSException("Malformed content.", e3);
        }
    }

    public static byte[] streamToByteArray(InputStream inputStream, int i) {
        return C6257Streams.readAllLimited(inputStream, i);
    }

    public static ContentInfo readContentInfo(byte[] bArr) {
        return readContentInfo(new ASN1InputStream(bArr));
    }
}
