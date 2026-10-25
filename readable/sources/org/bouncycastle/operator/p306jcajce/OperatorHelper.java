package org.bouncycastle.operator.p306jcajce;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import org.bouncycastle.operator.DefaultSignatureNameFinder;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.p157kisa.KISAObjectIdentifiers;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p163ntt.NTTObjectIdentifiers;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.RSAESOAEPparams;
import org.bouncycastle.p133asn1.p166pkcs.RSASSAPSSparams;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p133asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p249jcajce.p280util.AlgorithmParametersUtils;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.MessageDigestUtils;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
class OperatorHelper {
    private static final Map asymmetricWrapperAlgNames;
    private static final Map oaepParamsMap;

    /* renamed from: oids */
    private static final Map f22921oids;
    private static DefaultSignatureNameFinder sigFinder;
    private static final Map symmetricKeyAlgNames;
    private static final Map symmetricWrapperAlgNames;
    private static final Map symmetricWrapperKeySizes;

    /* renamed from: helper */
    private JcaJceHelper f22922helper;

    public static class OAEPParamsValue {
        private String cipherName;
        private byte[] derEncoding;

        private OAEPParamsValue(String str, byte[] bArr) {
            this.cipherName = str;
            this.derEncoding = bArr;
        }

        /* renamed from: add */
        public static void m17400add(Map map, String str, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            try {
                map.put(aSN1ObjectIdentifier, new OAEPParamsValue(str, getDEREncoding(createOAEPParams(aSN1ObjectIdentifier))));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        private static RSAESOAEPparams createOAEPParams(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(aSN1ObjectIdentifier, C5103DERNull.INSTANCE);
            return new RSAESOAEPparams(algorithmIdentifier, new AlgorithmIdentifier(PKCSObjectIdentifiers.f18498id_mgf1, algorithmIdentifier), RSAESOAEPparams.DEFAULT_P_SOURCE_ALGORITHM);
        }

        private static byte[] getDEREncoding(RSAESOAEPparams rSAESOAEPparams) {
            return rSAESOAEPparams.getEncoded(ASN1Encoding.f17902DER);
        }

        public String getCipherName() {
            return this.cipherName;
        }

        /* renamed from: matches */
        public boolean m17401matches(RSAESOAEPparams rSAESOAEPparams) {
            return C6238Arrays.areEqual(this.derEncoding, getDEREncoding(rSAESOAEPparams));
        }
    }

    public static class OpCertificateException extends CertificateException {

        /* renamed from: cause */
        private Throwable f22923cause;

        public OpCertificateException(String str, Throwable th) {
            super(str);
            this.f22923cause = th;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.f22923cause;
        }
    }

    static {
        HashMap map = new HashMap();
        f22921oids = map;
        HashMap map2 = new HashMap();
        asymmetricWrapperAlgNames = map2;
        HashMap map3 = new HashMap();
        symmetricWrapperAlgNames = map3;
        HashMap map4 = new HashMap();
        symmetricKeyAlgNames = map4;
        HashMap map5 = new HashMap();
        symmetricWrapperKeySizes = map5;
        HashMap map6 = new HashMap();
        oaepParamsMap = map6;
        sigFinder = new DefaultSignatureNameFinder();
        ASN1ObjectIdentifier aSN1ObjectIdentifier = OIWObjectIdentifiers.f18459idSHA1;
        map.put(aSN1ObjectIdentifier, "SHA1");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_sha224;
        map.put(aSN1ObjectIdentifier2, "SHA224");
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_sha256;
        map.put(aSN1ObjectIdentifier3, "SHA256");
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NISTObjectIdentifiers.id_sha384;
        map.put(aSN1ObjectIdentifier4, "SHA384");
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = NISTObjectIdentifiers.id_sha512;
        map.put(aSN1ObjectIdentifier5, "SHA512");
        map.put(TeleTrusTObjectIdentifiers.ripemd128, "RIPEMD128");
        map.put(TeleTrusTObjectIdentifiers.ripemd160, "RIPEMD160");
        map.put(TeleTrusTObjectIdentifiers.ripemd256, "RIPEMD256");
        map2.put(PKCSObjectIdentifiers.rsaEncryption, "RSA/ECB/PKCS1Padding");
        map2.put(OIWObjectIdentifiers.elGamalAlgorithm, "Elgamal/ECB/PKCS1Padding");
        map2.put(PKCSObjectIdentifiers.id_RSAES_OAEP, "RSA/ECB/OAEPPadding");
        map2.put(CryptoProObjectIdentifiers.gostR3410_2001, "ECGOST3410");
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = PKCSObjectIdentifiers.id_alg_CMS3DESwrap;
        map3.put(aSN1ObjectIdentifier6, "DESEDEWrap");
        map3.put(PKCSObjectIdentifiers.id_alg_CMSRC2wrap, "RC2Wrap");
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = NISTObjectIdentifiers.id_aes128_wrap;
        map3.put(aSN1ObjectIdentifier7, "AESWrap");
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = NISTObjectIdentifiers.id_aes192_wrap;
        map3.put(aSN1ObjectIdentifier8, "AESWrap");
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = NISTObjectIdentifiers.id_aes256_wrap;
        map3.put(aSN1ObjectIdentifier9, "AESWrap");
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = NTTObjectIdentifiers.id_camellia128_wrap;
        map3.put(aSN1ObjectIdentifier10, "CamelliaWrap");
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = NTTObjectIdentifiers.id_camellia192_wrap;
        map3.put(aSN1ObjectIdentifier11, "CamelliaWrap");
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = NTTObjectIdentifiers.id_camellia256_wrap;
        map3.put(aSN1ObjectIdentifier12, "CamelliaWrap");
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = KISAObjectIdentifiers.id_npki_app_cmsSeed_wrap;
        map3.put(aSN1ObjectIdentifier13, "SEEDWrap");
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = PKCSObjectIdentifiers.des_EDE3_CBC;
        map3.put(aSN1ObjectIdentifier14, "DESede");
        map5.put(aSN1ObjectIdentifier6, Integers.m18296valueOf(192));
        map5.put(aSN1ObjectIdentifier7, Integers.m18296valueOf(128));
        map5.put(aSN1ObjectIdentifier8, Integers.m18296valueOf(192));
        map5.put(aSN1ObjectIdentifier9, Integers.m18296valueOf(256));
        map5.put(aSN1ObjectIdentifier10, Integers.m18296valueOf(128));
        map5.put(aSN1ObjectIdentifier11, Integers.m18296valueOf(192));
        map5.put(aSN1ObjectIdentifier12, Integers.m18296valueOf(256));
        map5.put(aSN1ObjectIdentifier13, Integers.m18296valueOf(128));
        map5.put(aSN1ObjectIdentifier14, Integers.m18296valueOf(192));
        map4.put(NISTObjectIdentifiers.f18429aes, "AES");
        map4.put(NISTObjectIdentifiers.id_aes128_CBC, "AES");
        map4.put(NISTObjectIdentifiers.id_aes192_CBC, "AES");
        map4.put(NISTObjectIdentifiers.id_aes256_CBC, "AES");
        map4.put(aSN1ObjectIdentifier14, "DESede");
        map4.put(PKCSObjectIdentifiers.f18490RC2_CBC, "RC2");
        OAEPParamsValue.m17400add(map6, "RSA/ECB/OAEPWithSHA-1AndMGF1Padding", aSN1ObjectIdentifier);
        OAEPParamsValue.m17400add(map6, "RSA/ECB/OAEPWithSHA-224AndMGF1Padding", aSN1ObjectIdentifier2);
        OAEPParamsValue.m17400add(map6, "RSA/ECB/OAEPWithSHA-256AndMGF1Padding", aSN1ObjectIdentifier3);
        OAEPParamsValue.m17400add(map6, "RSA/ECB/OAEPWithSHA-384AndMGF1Padding", aSN1ObjectIdentifier4);
        OAEPParamsValue.m17400add(map6, "RSA/ECB/OAEPWithSHA-512AndMGF1Padding", aSN1ObjectIdentifier5);
    }

    public OperatorHelper(JcaJceHelper jcaJceHelper) {
        this.f22922helper = jcaJceHelper;
    }

    public static String getDigestName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String digestName = MessageDigestUtils.getDigestName(aSN1ObjectIdentifier);
        int iIndexOf = digestName.indexOf(45);
        if (iIndexOf <= 0 || digestName.startsWith("SHA3")) {
            return digestName;
        }
        return digestName.substring(0, iIndexOf) + digestName.substring(iIndexOf + 1);
    }

    private static String getSignatureName(AlgorithmIdentifier algorithmIdentifier) {
        return sigFinder.getAlgorithmName(algorithmIdentifier);
    }

    private boolean notDefaultPSSParams(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence == null || aSN1Sequence.mo14450size() == 0) {
            return false;
        }
        RSASSAPSSparams rSASSAPSSparams = RSASSAPSSparams.getInstance(aSN1Sequence);
        if (rSASSAPSSparams.getMaskGenAlgorithm().getAlgorithm().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.f18498id_mgf1) && rSASSAPSSparams.getHashAlgorithm().mo14431equals(AlgorithmIdentifier.getInstance(rSASSAPSSparams.getMaskGenAlgorithm().getParameters()))) {
            return rSASSAPSSparams.getSaltLength().intValue() != createDigest(rSASSAPSSparams.getHashAlgorithm()).getDigestLength();
        }
        return true;
    }

    public X509Certificate convertCertificate(X509CertificateHolder x509CertificateHolder) throws OpCertificateException {
        try {
            return (X509Certificate) this.f22922helper.createCertificateFactory("X.509").generateCertificate(new ByteArrayInputStream(x509CertificateHolder.getEncoded()));
        } catch (IOException e) {
            throw new OpCertificateException("cannot get encoded form of certificate: " + e.getMessage(), e);
        } catch (NoSuchProviderException e2) {
            throw new OpCertificateException("cannot find factory provider: " + e2.getMessage(), e2);
        }
    }

    public PublicKey convertPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) throws OperatorCreationException {
        try {
            return this.f22922helper.createKeyFactory(subjectPublicKeyInfo.getAlgorithm().getAlgorithm().m14433getId()).generatePublic(new X509EncodedKeySpec(subjectPublicKeyInfo.getEncoded()));
        } catch (IOException e) {
            throw new OperatorCreationException("cannot get encoded form of key: " + e.getMessage(), e);
        } catch (NoSuchAlgorithmException e2) {
            throw new OperatorCreationException("cannot create key factory: " + e2.getMessage(), e2);
        } catch (NoSuchProviderException e3) {
            throw new OperatorCreationException("cannot find factory provider: " + e3.getMessage(), e3);
        } catch (InvalidKeySpecException e4) {
            throw new OperatorCreationException("cannot create key factory: " + e4.getMessage(), e4);
        }
    }

    public AlgorithmParameters createAlgorithmParameters(AlgorithmIdentifier algorithmIdentifier) throws OperatorCreationException, IOException {
        AlgorithmParameters algorithmParametersCreateAlgorithmParameters;
        if (algorithmIdentifier.getAlgorithm().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.rsaEncryption)) {
            return null;
        }
        if (algorithmIdentifier.getAlgorithm().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.id_RSAES_OAEP)) {
            try {
                algorithmParametersCreateAlgorithmParameters = this.f22922helper.createAlgorithmParameters("OAEP");
            } catch (NoSuchAlgorithmException unused) {
            } catch (NoSuchProviderException e) {
                throw new OperatorCreationException("cannot create algorithm parameters: " + e.getMessage(), e);
            }
        } else {
            algorithmParametersCreateAlgorithmParameters = null;
        }
        if (algorithmParametersCreateAlgorithmParameters == null) {
            try {
                algorithmParametersCreateAlgorithmParameters = this.f22922helper.createAlgorithmParameters(algorithmIdentifier.getAlgorithm().m14433getId());
            } catch (NoSuchAlgorithmException unused2) {
                return null;
            } catch (NoSuchProviderException e2) {
                throw new OperatorCreationException("cannot create algorithm parameters: " + e2.getMessage(), e2);
            }
        }
        try {
            algorithmParametersCreateAlgorithmParameters.init(algorithmIdentifier.getParameters().toASN1Primitive().getEncoded());
            return algorithmParametersCreateAlgorithmParameters;
        } catch (IOException e3) {
            throw new OperatorCreationException("cannot initialise algorithm parameters: " + e3.getMessage(), e3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Cipher createAsymmetricWrapper(AlgorithmIdentifier algorithmIdentifier, Map map) throws OperatorCreationException {
        String cipherName;
        if (algorithmIdentifier == null) {
            throw new NullPointerException("'algorithmID' cannot be null");
        }
        ASN1ObjectIdentifier algorithm = algorithmIdentifier.getAlgorithm();
        if (map != null) {
            try {
                cipherName = !map.isEmpty() ? (String) map.get(algorithm) : null;
            } catch (GeneralSecurityException e) {
                throw new OperatorCreationException("cannot create cipher: " + e.getMessage(), e);
            }
        }
        if (cipherName == null) {
            cipherName = (String) asymmetricWrapperAlgNames.get(algorithm);
        }
        if (cipherName != null) {
            if (cipherName.indexOf("OAEPPadding") > 0) {
                try {
                    RSAESOAEPparams rSAESOAEPparams = RSAESOAEPparams.getInstance(algorithmIdentifier.getParameters());
                    if (rSAESOAEPparams != null) {
                        OAEPParamsValue oAEPParamsValue = (OAEPParamsValue) oaepParamsMap.get(rSAESOAEPparams.getHashAlgorithm().getAlgorithm());
                        if (oAEPParamsValue != null && oAEPParamsValue.m17401matches(rSAESOAEPparams.withDefaultPSource())) {
                            cipherName = oAEPParamsValue.getCipherName();
                        }
                    }
                } catch (Exception unused) {
                }
            }
            try {
                return this.f22922helper.createCipher(cipherName);
            } catch (NoSuchAlgorithmException unused2) {
                try {
                    if (cipherName.equals("RSA/ECB/PKCS1Padding")) {
                        return this.f22922helper.createCipher("RSA/NONE/PKCS1Padding");
                    }
                    if (cipherName.indexOf("ECB/OAEPWith") > 0) {
                        int iIndexOf = cipherName.indexOf("ECB");
                        return this.f22922helper.createCipher(cipherName.substring(0, iIndexOf) + "NONE" + cipherName.substring(iIndexOf + 3));
                    }
                } catch (NoSuchAlgorithmException unused3) {
                }
            }
        }
        return this.f22922helper.createCipher(algorithm.m14433getId());
    }

    public Cipher createCipher(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws OperatorCreationException {
        try {
            return this.f22922helper.createCipher(aSN1ObjectIdentifier.m14433getId());
        } catch (GeneralSecurityException e) {
            throw new OperatorCreationException("cannot create cipher: " + e.getMessage(), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.security.MessageDigest] */
    public MessageDigest createDigest(AlgorithmIdentifier algorithmIdentifier) throws NoSuchAlgorithmException {
        JcaJceHelper jcaJceHelper;
        String digestName;
        try {
            if (algorithmIdentifier.getAlgorithm().m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_shake256_len)) {
                jcaJceHelper = this.f22922helper;
                digestName = "SHAKE256-" + ASN1Integer.getInstance(algorithmIdentifier.getParameters()).getValue();
            } else if (algorithmIdentifier.getAlgorithm().m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_shake128_len)) {
                jcaJceHelper = this.f22922helper;
                digestName = "SHAKE128-" + ASN1Integer.getInstance(algorithmIdentifier.getParameters()).getValue();
            } else {
                jcaJceHelper = this.f22922helper;
                digestName = MessageDigestUtils.getDigestName(algorithmIdentifier.getAlgorithm());
            }
            this = jcaJceHelper.createMessageDigest(digestName);
            return this;
        } catch (NoSuchAlgorithmException e) {
            Map map = f22921oids;
            if (map.get(algorithmIdentifier.getAlgorithm()) == null) {
                throw e;
            }
            return this.f22922helper.createMessageDigest((String) map.get(algorithmIdentifier.getAlgorithm()));
        }
    }

    public KeyAgreement createKeyAgreement(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws OperatorCreationException {
        try {
            return this.f22922helper.createKeyAgreement(aSN1ObjectIdentifier.m14433getId());
        } catch (GeneralSecurityException e) {
            throw new OperatorCreationException("cannot create key agreement: " + e.getMessage(), e);
        }
    }

    public KeyPairGenerator createKeyPairGenerator(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws CMSException {
        try {
            return this.f22922helper.createKeyPairGenerator(aSN1ObjectIdentifier.m14433getId());
        } catch (GeneralSecurityException e) {
            throw new CMSException("cannot create key agreement: " + e.getMessage(), e);
        }
    }

    public Signature createRawSignature(AlgorithmIdentifier algorithmIdentifier) throws InvalidAlgorithmParameterException {
        try {
            String signatureName = getSignatureName(algorithmIdentifier);
            String str = "NONE" + signatureName.substring(signatureName.indexOf("WITH"));
            Signature signatureCreateSignature = this.f22922helper.createSignature(str);
            if (algorithmIdentifier.getAlgorithm().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.id_RSASSA_PSS)) {
                AlgorithmParameters algorithmParametersCreateAlgorithmParameters = this.f22922helper.createAlgorithmParameters(str);
                AlgorithmParametersUtils.loadParameters(algorithmParametersCreateAlgorithmParameters, algorithmIdentifier.getParameters());
                signatureCreateSignature.setParameter((PSSParameterSpec) algorithmParametersCreateAlgorithmParameters.getParameterSpec(PSSParameterSpec.class));
            }
            return signatureCreateSignature;
        } catch (Exception unused) {
            return null;
        }
    }

    public Signature createSignature(AlgorithmIdentifier algorithmIdentifier) throws GeneralSecurityException, IOException {
        Signature signatureCreateSignature;
        String signatureName = getSignatureName(algorithmIdentifier);
        try {
            signatureCreateSignature = this.f22922helper.createSignature(signatureName);
        } catch (NoSuchAlgorithmException e) {
            if (!signatureName.endsWith("WITHRSAANDMGF1")) {
                throw e;
            }
            signatureCreateSignature = this.f22922helper.createSignature(signatureName.substring(0, signatureName.indexOf(87)) + "WITHRSASSA-PSS");
        }
        if (algorithmIdentifier.getAlgorithm().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.id_RSASSA_PSS)) {
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(algorithmIdentifier.getParameters());
            if (notDefaultPSSParams(aSN1Sequence)) {
                try {
                    AlgorithmParameters algorithmParametersCreateAlgorithmParameters = this.f22922helper.createAlgorithmParameters("PSS");
                    algorithmParametersCreateAlgorithmParameters.init(aSN1Sequence.getEncoded());
                    signatureCreateSignature.setParameter(algorithmParametersCreateAlgorithmParameters.getParameterSpec(PSSParameterSpec.class));
                } catch (IOException e2) {
                    throw new GeneralSecurityException("unable to process PSS parameters: " + e2.getMessage());
                }
            }
        }
        return signatureCreateSignature;
    }

    public Cipher createSymmetricWrapper(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws OperatorCreationException {
        try {
            String str = (String) symmetricWrapperAlgNames.get(aSN1ObjectIdentifier);
            if (str != null) {
                try {
                    return this.f22922helper.createCipher(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.f22922helper.createCipher(aSN1ObjectIdentifier.m14433getId());
        } catch (GeneralSecurityException e) {
            throw new OperatorCreationException("cannot create cipher: " + e.getMessage(), e);
        }
    }

    public String getKeyAlgorithmName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String str = (String) symmetricKeyAlgNames.get(aSN1ObjectIdentifier);
        return str != null ? str : aSN1ObjectIdentifier.m14433getId();
    }

    public int getKeySizeInBits(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return ((Integer) symmetricWrapperKeySizes.get(aSN1ObjectIdentifier)).intValue();
    }

    public String getWrappingAlgorithmName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (String) symmetricWrapperAlgNames.get(aSN1ObjectIdentifier);
    }
}
