package org.bouncycastle.p191cms.p193jcajce;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.p139cms.IssuerAndSerialNumber;
import org.bouncycastle.p133asn1.p156iso.ISOIECObjectIdentifiers;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p167sec.SECObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.Certificate;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p133asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.p191cms.CMSAlgorithm;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p249jcajce.p280util.AlgorithmParametersUtils;
import org.bouncycastle.p249jcajce.p280util.AnnotatedPrivateKey;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;

/* loaded from: classes2.dex */
class CMSUtils {
    private static final Map asymmetricWrapperAlgNames;

    /* renamed from: ecAlgs */
    private static final Set f19058ecAlgs;
    private static final Set gostAlgs;

    /* renamed from: mqvAlgs */
    private static final Set f19059mqvAlgs;
    private static Map<ASN1ObjectIdentifier, String> wrapAlgNames;

    static {
        HashSet hashSet = new HashSet();
        f19059mqvAlgs = hashSet;
        HashSet hashSet2 = new HashSet();
        f19058ecAlgs = hashSet2;
        HashSet hashSet3 = new HashSet();
        gostAlgs = hashSet3;
        HashMap map = new HashMap();
        asymmetricWrapperAlgNames = map;
        HashMap map2 = new HashMap();
        wrapAlgNames = map2;
        map2.put(CMSAlgorithm.AES128_WRAP, "AESWRAP");
        wrapAlgNames.put(CMSAlgorithm.AES192_WRAP, "AESWRAP");
        wrapAlgNames.put(CMSAlgorithm.AES256_WRAP, "AESWRAP");
        wrapAlgNames.put(CMSAlgorithm.AES128_WRAP_PAD, "AES-KWP");
        wrapAlgNames.put(CMSAlgorithm.AES192_WRAP_PAD, "AES-KWP");
        wrapAlgNames.put(CMSAlgorithm.AES256_WRAP_PAD, "AES-KWP");
        hashSet.add(X9ObjectIdentifiers.mqvSinglePass_sha1kdf_scheme);
        hashSet.add(SECObjectIdentifiers.mqvSinglePass_sha224kdf_scheme);
        hashSet.add(SECObjectIdentifiers.mqvSinglePass_sha256kdf_scheme);
        hashSet.add(SECObjectIdentifiers.mqvSinglePass_sha384kdf_scheme);
        hashSet.add(SECObjectIdentifiers.mqvSinglePass_sha512kdf_scheme);
        hashSet2.add(X9ObjectIdentifiers.dhSinglePass_cofactorDH_sha1kdf_scheme);
        hashSet2.add(X9ObjectIdentifiers.dhSinglePass_stdDH_sha1kdf_scheme);
        hashSet2.add(SECObjectIdentifiers.dhSinglePass_cofactorDH_sha224kdf_scheme);
        hashSet2.add(SECObjectIdentifiers.dhSinglePass_stdDH_sha224kdf_scheme);
        hashSet2.add(SECObjectIdentifiers.dhSinglePass_cofactorDH_sha256kdf_scheme);
        hashSet2.add(SECObjectIdentifiers.dhSinglePass_stdDH_sha256kdf_scheme);
        hashSet2.add(SECObjectIdentifiers.dhSinglePass_cofactorDH_sha384kdf_scheme);
        hashSet2.add(SECObjectIdentifiers.dhSinglePass_stdDH_sha384kdf_scheme);
        hashSet2.add(SECObjectIdentifiers.dhSinglePass_cofactorDH_sha512kdf_scheme);
        hashSet2.add(SECObjectIdentifiers.dhSinglePass_stdDH_sha512kdf_scheme);
        hashSet3.add(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_ESDH);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = CryptoProObjectIdentifiers.gostR3410_2001;
        hashSet3.add(aSN1ObjectIdentifier);
        hashSet3.add(RosstandartObjectIdentifiers.id_tc26_agreement_gost_3410_12_256);
        hashSet3.add(RosstandartObjectIdentifiers.id_tc26_agreement_gost_3410_12_512);
        hashSet3.add(RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256);
        hashSet3.add(RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512);
        map.put(PKCSObjectIdentifiers.rsaEncryption, "RSA/ECB/PKCS1Padding");
        map.put(OIWObjectIdentifiers.elGamalAlgorithm, "Elgamal/ECB/PKCS1Padding");
        map.put(PKCSObjectIdentifiers.id_RSAES_OAEP, "RSA/ECB/OAEPPadding");
        map.put(aSN1ObjectIdentifier, "ECGOST3410");
        map.put(ISOIECObjectIdentifiers.id_kem_rsa, "RSA-KTS-KEM-KWS");
    }

    public static PrivateKey cleanPrivateKey(PrivateKey privateKey) {
        return privateKey instanceof AnnotatedPrivateKey ? cleanPrivateKey(((AnnotatedPrivateKey) privateKey).m16224getKey()) : privateKey;
    }

    public static Cipher createAsymmetricWrapper(JcaJceHelper jcaJceHelper, ASN1ObjectIdentifier aSN1ObjectIdentifier, Map map) throws OperatorCreationException {
        try {
            String str = !map.isEmpty() ? (String) map.get(aSN1ObjectIdentifier) : null;
            if (str == null) {
                str = (String) asymmetricWrapperAlgNames.get(aSN1ObjectIdentifier);
            }
            if (str != null) {
                try {
                    return jcaJceHelper.createCipher(str);
                } catch (NoSuchAlgorithmException unused) {
                    if (str.equals("RSA/ECB/PKCS1Padding")) {
                        try {
                            return jcaJceHelper.createCipher("RSA/NONE/PKCS1Padding");
                        } catch (NoSuchAlgorithmException unused2) {
                        }
                    }
                }
            }
            return jcaJceHelper.createCipher(aSN1ObjectIdentifier.m14433getId());
        } catch (GeneralSecurityException e) {
            throw new OperatorCreationException("cannot create cipher: " + e.getMessage(), e);
        }
    }

    public static EnvelopedDataHelper createContentHelper(String str) {
        return str != null ? new EnvelopedDataHelper(new NamedJcaJceExtHelper(str)) : new EnvelopedDataHelper(new DefaultJcaJceExtHelper());
    }

    public static ASN1Encodable extractParameters(AlgorithmParameters algorithmParameters) throws CMSException {
        try {
            return AlgorithmParametersUtils.extractParameters(algorithmParameters);
        } catch (IOException e) {
            throw new CMSException("cannot extract parameters: " + e.getMessage(), e);
        }
    }

    public static IssuerAndSerialNumber getIssuerAndSerialNumber(X509Certificate x509Certificate) {
        return new IssuerAndSerialNumber(Certificate.getInstance(x509Certificate.getEncoded()).getIssuer(), x509Certificate.getSerialNumber());
    }

    public static Key getJceKey(GenericKey genericKey) {
        if (genericKey.getRepresentation() instanceof Key) {
            return (Key) genericKey.getRepresentation();
        }
        if (genericKey.getRepresentation() instanceof byte[]) {
            return new SecretKeySpec((byte[]) genericKey.getRepresentation(), "ENC");
        }
        throw new IllegalArgumentException("unknown generic key type");
    }

    public static int getKekSize(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) CMSAlgorithm.AES256_WRAP) || aSN1ObjectIdentifier.m14446equals((ASN1Primitive) CMSAlgorithm.AES256_WRAP_PAD)) {
            return 32;
        }
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) CMSAlgorithm.AES128_WRAP) || aSN1ObjectIdentifier.m14446equals((ASN1Primitive) CMSAlgorithm.AES128_WRAP_PAD)) {
            return 16;
        }
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) CMSAlgorithm.AES192_WRAP) || aSN1ObjectIdentifier.m14446equals((ASN1Primitive) CMSAlgorithm.AES192_WRAP_PAD)) {
            return 24;
        }
        throw new IllegalArgumentException("unknown wrap algorithm");
    }

    public static byte[] getSubjectKeyId(X509Certificate x509Certificate) {
        byte[] extensionValue = x509Certificate.getExtensionValue(Extension.subjectKeyIdentifier.m14433getId());
        if (extensionValue != null) {
            return ASN1OctetString.getInstance(ASN1OctetString.getInstance(extensionValue).getOctets()).getOctets();
        }
        return null;
    }

    public static String getWrapAlgorithmName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return wrapAlgNames.get(aSN1ObjectIdentifier);
    }

    /* renamed from: isEC */
    public static boolean m14917isEC(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return f19058ecAlgs.contains(aSN1ObjectIdentifier);
    }

    /* renamed from: isGOST */
    public static boolean m14918isGOST(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return gostAlgs.contains(aSN1ObjectIdentifier);
    }

    /* renamed from: isMQV */
    public static boolean m14919isMQV(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return f19059mqvAlgs.contains(aSN1ObjectIdentifier);
    }

    public static boolean isRFC2631(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return aSN1ObjectIdentifier.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.id_alg_ESDH) || aSN1ObjectIdentifier.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.id_alg_SSDH);
    }

    public static void loadParameters(AlgorithmParameters algorithmParameters, ASN1Encodable aSN1Encodable) {
        try {
            AlgorithmParametersUtils.loadParameters(algorithmParameters, aSN1Encodable);
        } catch (IOException e) {
            throw new CMSException("error encoding algorithm parameters.", e);
        }
    }

    public static EnvelopedDataHelper createContentHelper(Provider provider) {
        return provider != null ? new EnvelopedDataHelper(new ProviderJcaJceExtHelper(provider)) : new EnvelopedDataHelper(new DefaultJcaJceExtHelper());
    }
}
