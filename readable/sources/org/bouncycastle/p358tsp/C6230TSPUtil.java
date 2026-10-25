package org.bouncycastle.p358tsp;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.p139cms.Attribute;
import org.bouncycastle.p133asn1.p139cms.AttributeTable;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;
import org.bouncycastle.p133asn1.p148gm.GMObjectIdentifiers;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.ExtendedKeyUsage;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.Extensions;
import org.bouncycastle.p133asn1.p174x509.ExtensionsGenerator;
import org.bouncycastle.p133asn1.p174x509.KeyPurposeId;
import org.bouncycastle.p133asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.p133asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p191cms.SignerInformation;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Integers;

/* renamed from: org.bouncycastle.tsp.TSPUtil */
/* loaded from: classes2.dex */
public class C6230TSPUtil {
    private static List EMPTY_LIST = Collections.unmodifiableList(new ArrayList());
    private static final Map digestLengths;
    private static final Map digestNames;

    static {
        HashMap map = new HashMap();
        digestLengths = map;
        HashMap map2 = new HashMap();
        digestNames = map2;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.f18503md5;
        map.put(aSN1ObjectIdentifier.m14433getId(), Integers.m18296valueOf(16));
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = OIWObjectIdentifiers.f18459idSHA1;
        map.put(aSN1ObjectIdentifier2.m14433getId(), Integers.m18296valueOf(20));
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_sha224;
        map.put(aSN1ObjectIdentifier3.m14433getId(), Integers.m18296valueOf(28));
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NISTObjectIdentifiers.id_sha256;
        map.put(aSN1ObjectIdentifier4.m14433getId(), Integers.m18296valueOf(32));
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = NISTObjectIdentifiers.id_sha384;
        map.put(aSN1ObjectIdentifier5.m14433getId(), Integers.m18296valueOf(48));
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = NISTObjectIdentifiers.id_sha512;
        map.put(aSN1ObjectIdentifier6.m14433getId(), Integers.m18296valueOf(64));
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = NISTObjectIdentifiers.id_sha3_224;
        map.put(aSN1ObjectIdentifier7.m14433getId(), Integers.m18296valueOf(28));
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = NISTObjectIdentifiers.id_sha3_256;
        map.put(aSN1ObjectIdentifier8.m14433getId(), Integers.m18296valueOf(32));
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = NISTObjectIdentifiers.id_sha3_384;
        map.put(aSN1ObjectIdentifier9.m14433getId(), Integers.m18296valueOf(48));
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = NISTObjectIdentifiers.id_sha3_512;
        map.put(aSN1ObjectIdentifier10.m14433getId(), Integers.m18296valueOf(64));
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = TeleTrusTObjectIdentifiers.ripemd128;
        map.put(aSN1ObjectIdentifier11.m14433getId(), Integers.m18296valueOf(16));
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = TeleTrusTObjectIdentifiers.ripemd160;
        map.put(aSN1ObjectIdentifier12.m14433getId(), Integers.m18296valueOf(20));
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = TeleTrusTObjectIdentifiers.ripemd256;
        map.put(aSN1ObjectIdentifier13.m14433getId(), Integers.m18296valueOf(32));
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = CryptoProObjectIdentifiers.gostR3411;
        map.put(aSN1ObjectIdentifier14.m14433getId(), Integers.m18296valueOf(32));
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = RosstandartObjectIdentifiers.id_tc26_gost_3411_12_256;
        map.put(aSN1ObjectIdentifier15.m14433getId(), Integers.m18296valueOf(32));
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = RosstandartObjectIdentifiers.id_tc26_gost_3411_12_512;
        map.put(aSN1ObjectIdentifier16.m14433getId(), Integers.m18296valueOf(64));
        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = GMObjectIdentifiers.f18386sm3;
        map.put(aSN1ObjectIdentifier17.m14433getId(), Integers.m18296valueOf(32));
        map2.put(aSN1ObjectIdentifier.m14433getId(), "MD5");
        map2.put(aSN1ObjectIdentifier2.m14433getId(), "SHA1");
        map2.put(aSN1ObjectIdentifier3.m14433getId(), "SHA224");
        map2.put(aSN1ObjectIdentifier4.m14433getId(), "SHA256");
        map2.put(aSN1ObjectIdentifier5.m14433getId(), "SHA384");
        map2.put(aSN1ObjectIdentifier6.m14433getId(), "SHA512");
        map2.put(aSN1ObjectIdentifier7.m14433getId(), "SHA3-224");
        map2.put(aSN1ObjectIdentifier8.m14433getId(), "SHA3-256");
        map2.put(aSN1ObjectIdentifier9.m14433getId(), "SHA3-384");
        map2.put(aSN1ObjectIdentifier10.m14433getId(), "SHA3-512");
        map2.put(PKCSObjectIdentifiers.sha1WithRSAEncryption.m14433getId(), "SHA1");
        map2.put(PKCSObjectIdentifiers.sha224WithRSAEncryption.m14433getId(), "SHA224");
        map2.put(PKCSObjectIdentifiers.sha256WithRSAEncryption.m14433getId(), "SHA256");
        map2.put(PKCSObjectIdentifiers.sha384WithRSAEncryption.m14433getId(), "SHA384");
        map2.put(PKCSObjectIdentifiers.sha512WithRSAEncryption.m14433getId(), "SHA512");
        map2.put(aSN1ObjectIdentifier11.m14433getId(), "RIPEMD128");
        map2.put(aSN1ObjectIdentifier12.m14433getId(), "RIPEMD160");
        map2.put(aSN1ObjectIdentifier13.m14433getId(), "RIPEMD256");
        map2.put(aSN1ObjectIdentifier14.m14433getId(), "GOST3411");
        map2.put(aSN1ObjectIdentifier15.m14433getId(), "GOST3411-2012-256");
        map2.put(aSN1ObjectIdentifier16.m14433getId(), "GOST3411-2012-512");
        map2.put(aSN1ObjectIdentifier17.m14433getId(), "SM3");
    }

    public static void addExtension(ExtensionsGenerator extensionsGenerator, ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, ASN1Encodable aSN1Encodable) {
        try {
            extensionsGenerator.addExtension(aSN1ObjectIdentifier, z, aSN1Encodable);
        } catch (IOException e) {
            throw new TSPIOException("cannot encode extension: " + e.getMessage(), e);
        }
    }

    public static int getDigestLength(String str) throws TSPException {
        Integer num = (Integer) digestLengths.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new TSPException("digest algorithm cannot be found.");
    }

    public static List getExtensionOIDs(Extensions extensions) {
        return extensions == null ? EMPTY_LIST : Collections.unmodifiableList(Arrays.asList(extensions.getExtensionOIDs()));
    }

    public static Collection getSignatureTimestamps(SignerInformation signerInformation, DigestCalculatorProvider digestCalculatorProvider) throws TSPValidationException, IOException {
        ArrayList arrayList = new ArrayList();
        AttributeTable unsignedAttributes = signerInformation.getUnsignedAttributes();
        if (unsignedAttributes != null) {
            ASN1EncodableVector aSN1EncodableVectorM14531getAll = unsignedAttributes.m14531getAll(PKCSObjectIdentifiers.id_aa_signatureTimeStampToken);
            for (int i = 0; i < aSN1EncodableVectorM14531getAll.m14424size(); i++) {
                AbstractC5093ASN1Set attrValues = ((Attribute) aSN1EncodableVectorM14531getAll.m14423get(i)).getAttrValues();
                for (int i2 = 0; i2 < attrValues.m14454size(); i2++) {
                    try {
                        TimeStampToken timeStampToken = new TimeStampToken(ContentInfo.getInstance(attrValues.getObjectAt(i2)));
                        TimeStampTokenInfo timeStampInfo = timeStampToken.getTimeStampInfo();
                        DigestCalculator digestCalculatorMo14763get = digestCalculatorProvider.mo14763get(timeStampInfo.getHashAlgorithm());
                        OutputStream outputStream = digestCalculatorMo14763get.getOutputStream();
                        outputStream.write(signerInformation.getSignature());
                        outputStream.close();
                        if (!C6238Arrays.constantTimeAreEqual(digestCalculatorMo14763get.getDigest(), timeStampInfo.getMessageImprintDigest())) {
                            throw new TSPValidationException("Incorrect digest in message imprint");
                        }
                        arrayList.add(timeStampToken);
                    } catch (OperatorCreationException unused) {
                        throw new TSPValidationException("Unknown hash algorithm specified in timestamp");
                    } catch (Exception unused2) {
                        throw new TSPValidationException("Timestamp could not be parsed");
                    }
                }
            }
        }
        return arrayList;
    }

    public static void validateCertificate(X509CertificateHolder x509CertificateHolder) throws TSPValidationException {
        if (x509CertificateHolder.toASN1Structure().getVersionNumber() != 3) {
            throw new IllegalArgumentException("Certificate must have an ExtendedKeyUsage extension.");
        }
        Extension extension = x509CertificateHolder.getExtension(Extension.extendedKeyUsage);
        if (extension == null) {
            throw new TSPValidationException("Certificate must have an ExtendedKeyUsage extension.");
        }
        if (!extension.isCritical()) {
            throw new TSPValidationException("Certificate must have an ExtendedKeyUsage extension marked as critical.");
        }
        ExtendedKeyUsage extendedKeyUsage = ExtendedKeyUsage.getInstance(extension.getParsedValue());
        if (!extendedKeyUsage.hasKeyPurposeId(KeyPurposeId.id_kp_timeStamping) || extendedKeyUsage.m14685size() != 1) {
            throw new TSPValidationException("ExtendedKeyUsage not solely time stamping.");
        }
    }
}
