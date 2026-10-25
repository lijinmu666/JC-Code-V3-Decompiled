package org.bouncycastle.p249jcajce.provider.keystore.p275pkcs12;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.internal.p231asn1.p233cms.GCMParameters;
import org.bouncycastle.internal.p231asn1.p242misc.MiscObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p244ntt.NTTObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1BMPString;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1InputStream;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.BEROctetString;
import org.bouncycastle.p133asn1.BERSequence;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.C5104DERSet;
import org.bouncycastle.p133asn1.DERBMPString;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.cryptopro.GOST28147Parameters;
import org.bouncycastle.p133asn1.p138cmp.PKIFailureInfo;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.AuthenticatedSafe;
import org.bouncycastle.p133asn1.p166pkcs.C5135CertBag;
import org.bouncycastle.p133asn1.p166pkcs.C5136MacData;
import org.bouncycastle.p133asn1.p166pkcs.C5137Pfx;
import org.bouncycastle.p133asn1.p166pkcs.C5138SafeBag;
import org.bouncycastle.p133asn1.p166pkcs.ContentInfo;
import org.bouncycastle.p133asn1.p166pkcs.EncryptedData;
import org.bouncycastle.p133asn1.p166pkcs.EncryptedPrivateKeyInfo;
import org.bouncycastle.p133asn1.p166pkcs.EncryptionScheme;
import org.bouncycastle.p133asn1.p166pkcs.KeyDerivationFunc;
import org.bouncycastle.p133asn1.p166pkcs.PBES2Parameters;
import org.bouncycastle.p133asn1.p166pkcs.PBKDF2Params;
import org.bouncycastle.p133asn1.p166pkcs.PBMAC1Params;
import org.bouncycastle.p133asn1.p166pkcs.PKCS12PBEParams;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p171util.ASN1Dump;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.AuthorityKeyIdentifier;
import org.bouncycastle.p133asn1.p174x509.DigestInfo;
import org.bouncycastle.p133asn1.p174x509.ExtendedKeyUsage;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.Extensions;
import org.bouncycastle.p133asn1.p174x509.KeyPurposeId;
import org.bouncycastle.p133asn1.p174x509.SubjectKeyIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p133asn1.p174x509.TBSCertificate;
import org.bouncycastle.p133asn1.p174x509.X509ObjectIdentifiers;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.p194crypto.p199digests.SHA1Digest;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p194crypto.p199digests.SHA512Digest;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p221util.DigestFactory;
import org.bouncycastle.p249jcajce.BCLoadStoreParameter;
import org.bouncycastle.p249jcajce.PKCS12Key;
import org.bouncycastle.p249jcajce.PKCS12LoadStoreParameter;
import org.bouncycastle.p249jcajce.PKCS12StoreParameter;
import org.bouncycastle.p249jcajce.p279spec.GOST28147ParameterSpec;
import org.bouncycastle.p249jcajce.p279spec.PBKDF2KeySpec;
import org.bouncycastle.p249jcajce.p280util.BCJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.provider.keystore.p276util.AdaptingKeyStoreSpi;
import org.bouncycastle.p249jcajce.provider.keystore.p276util.ParameterUtil;
import org.bouncycastle.p281jce.PKCS12Util;
import org.bouncycastle.p281jce.interfaces.BCKeyStore;
import org.bouncycastle.p281jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.p281jce.provider.BouncyCastleProvider;
import org.bouncycastle.p281jce.provider.JDKPKCS12StoreParameter;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.Exceptions;
import org.bouncycastle.p361util.Integers;
import org.bouncycastle.p361util.Properties;
import org.bouncycastle.p361util.encoders.C6255Hex;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public class PKCS12PBMAC1KeyStoreSpi extends KeyStoreSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers, BCKeyStore {
    static final int CERTIFICATE = 1;

    /* renamed from: KEY */
    static final int f21755KEY = 2;
    static final int KEY_PRIVATE = 0;
    static final int KEY_PUBLIC = 1;
    static final int KEY_SECRET = 2;
    private static final int MIN_ITERATIONS = 51200;

    /* renamed from: NULL */
    static final int f21756NULL = 0;
    private static final int SALT_SIZE = 20;

    /* renamed from: SEALED */
    static final int f21757SEALED = 4;

    /* renamed from: SECRET */
    static final int f21758SECRET = 3;
    private static final DefaultSecretKeyProvider keySizeProvider = new DefaultSecretKeyProvider();
    private ASN1ObjectIdentifier certAlgorithm;
    private CertificateFactory certFact;

    /* renamed from: certs */
    private IgnoresCaseHashtable f21759certs;
    private ASN1ObjectIdentifier keyAlgorithm;

    /* renamed from: keys */
    private IgnoresCaseHashtable f21762keys;
    private IgnoresCaseHashtable localIds;

    /* renamed from: helper */
    private final JcaJceHelper f21760helper = new BCJcaJceHelper();
    private Hashtable chainCerts = new Hashtable();
    private Hashtable keyCerts = new Hashtable();

    /* renamed from: random */
    protected SecureRandom f21763random = CryptoServicesRegistrar.getSecureRandom();
    private AlgorithmIdentifier macAlgorithm = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBMAC1);

    /* renamed from: itCount */
    private int f21761itCount = 102400;
    private int saltLength = 20;
    private boolean useISO8859d1ForDecryption = false;

    public static class BCPKCS12KeyStore extends AdaptingKeyStoreSpi {
        public BCPKCS12KeyStore() {
            super(new BCJcaJceHelper(), new PKCS12PBMAC1KeyStoreSpi(new BCJcaJceHelper(), NISTObjectIdentifiers.id_aes256_CBC, NISTObjectIdentifiers.id_aes128_CBC));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12PBMAC1KeyStoreSpi$CertId */
    public class C5676CertId {

        /* renamed from: id */
        byte[] f21764id;

        public C5676CertId(PublicKey publicKey) {
            this.f21764id = PKCS12PBMAC1KeyStoreSpi.this.createSubjectKeyId(publicKey).getKeyIdentifier();
        }

        /* renamed from: equals */
        public boolean m16165equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof C5676CertId) {
                return C6238Arrays.areEqual(this.f21764id, ((C5676CertId) obj).f21764id);
            }
            return false;
        }

        public int hashCode() {
            return C6238Arrays.hashCode(this.f21764id);
        }

        public C5676CertId(byte[] bArr) {
            this.f21764id = bArr;
        }
    }

    public static class DefaultSecretKeyProvider {
        private final Map KEY_SIZES;

        public DefaultSecretKeyProvider() {
            HashMap map = new HashMap();
            map.put(new ASN1ObjectIdentifier("1.2.840.113533.7.66.10"), Integers.m18296valueOf(128));
            map.put(PKCSObjectIdentifiers.des_EDE3_CBC, Integers.m18296valueOf(192));
            map.put(NISTObjectIdentifiers.id_aes128_CBC, Integers.m18296valueOf(128));
            map.put(NISTObjectIdentifiers.id_aes192_CBC, Integers.m18296valueOf(192));
            map.put(NISTObjectIdentifiers.id_aes256_CBC, Integers.m18296valueOf(256));
            map.put(NISTObjectIdentifiers.id_aes128_GCM, Integers.m18296valueOf(128));
            map.put(NISTObjectIdentifiers.id_aes256_GCM, Integers.m18296valueOf(256));
            map.put(NTTObjectIdentifiers.id_camellia128_cbc, Integers.m18296valueOf(128));
            map.put(NTTObjectIdentifiers.id_camellia192_cbc, Integers.m18296valueOf(192));
            map.put(NTTObjectIdentifiers.id_camellia256_cbc, Integers.m18296valueOf(256));
            map.put(CryptoProObjectIdentifiers.gostR28147_gcfb, Integers.m18296valueOf(256));
            this.KEY_SIZES = Collections.unmodifiableMap(map);
        }

        public int getKeySize(AlgorithmIdentifier algorithmIdentifier) {
            Integer num = (Integer) this.KEY_SIZES.get(algorithmIdentifier.getAlgorithm());
            if (num != null) {
                return num.intValue();
            }
            return -1;
        }
    }

    public static class IgnoresCaseHashtable {

        /* renamed from: keys */
        private Hashtable f21766keys;

        /* renamed from: orig */
        private Hashtable f21767orig;

        private IgnoresCaseHashtable() {
            this.f21767orig = new Hashtable();
            this.f21766keys = new Hashtable();
        }

        public Enumeration elements() {
            return this.f21767orig.elements();
        }

        /* renamed from: get */
        public Object m16166get(String str) {
            String str2 = (String) this.f21766keys.get(str == null ? null : C6250Strings.toLowerCase(str));
            if (str2 == null) {
                return null;
            }
            return this.f21767orig.get(str2);
        }

        /* renamed from: keys */
        public Enumeration m16167keys() {
            return new Hashtable(this.f21767orig).keys();
        }

        /* renamed from: put */
        public void m16168put(String str, Object obj) {
            String lowerCase = str == null ? null : C6250Strings.toLowerCase(str);
            String str2 = (String) this.f21766keys.get(lowerCase);
            if (str2 != null) {
                this.f21767orig.remove(str2);
            }
            this.f21766keys.put(lowerCase, str);
            this.f21767orig.put(str, obj);
        }

        /* renamed from: remove */
        public Object m16169remove(String str) {
            String str2 = (String) this.f21766keys.remove(str == null ? null : C6250Strings.toLowerCase(str));
            if (str2 == null) {
                return null;
            }
            return this.f21767orig.remove(str2);
        }

        /* renamed from: size */
        public int m16170size() {
            return this.f21767orig.size();
        }
    }

    public PKCS12PBMAC1KeyStoreSpi(JcaJceHelper jcaJceHelper, ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier2) {
        this.f21762keys = new IgnoresCaseHashtable();
        this.localIds = new IgnoresCaseHashtable();
        this.f21759certs = new IgnoresCaseHashtable();
        this.keyAlgorithm = aSN1ObjectIdentifier;
        this.certAlgorithm = aSN1ObjectIdentifier2;
        try {
            this.certFact = jcaJceHelper.createCertificateFactory("X.509");
        } catch (Exception e) {
            throw new IllegalArgumentException("can't create cert factory - " + e.toString());
        }
    }

    private byte[] calculatePbeMac(ASN1ObjectIdentifier aSN1ObjectIdentifier, byte[] bArr, int i, char[] cArr, boolean z, byte[] bArr2) throws IOException {
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = PKCSObjectIdentifiers.id_PBMAC1;
        if (aSN1ObjectIdentifier2.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            if (this.macAlgorithm.getParameters() == null) {
                byte[] bArr3 = new byte[32];
                this.f21760helper.createSecureRandom("DEFAULT").nextBytes(bArr3);
                this.macAlgorithm = new AlgorithmIdentifier(aSN1ObjectIdentifier2, new PBMAC1Params(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBKDF2, new PBKDF2Params(bArr3, PKIFailureInfo.notAuthorized, 256, new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA256))), new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA512)));
            }
            PBMAC1Params pBMAC1Params = PBMAC1Params.getInstance(this.macAlgorithm.getParameters());
            if (pBMAC1Params == null) {
                throw new IOException("If the DigestAlgorithmIdentifier is id-PBMAC1, then the parameters field must contain valid PBMAC1-params parameters.");
            }
            if (PKCSObjectIdentifiers.id_PBKDF2.m14446equals((ASN1Primitive) pBMAC1Params.getKeyDerivationFunc().getAlgorithm())) {
                PBKDF2Params pBKDF2Params = PBKDF2Params.getInstance(pBMAC1Params.getKeyDerivationFunc().getParameters());
                if (pBKDF2Params.getKeyLength() == null) {
                    throw new IOException("Key length must be present when using PBMAC1.");
                }
                C5360HMac c5360HMac = new C5360HMac(m16162getPrf(pBMAC1Params.getMessageAuthScheme().getAlgorithm()));
                PKCS5S2ParametersGenerator pKCS5S2ParametersGenerator = new PKCS5S2ParametersGenerator(m16162getPrf(pBKDF2Params.m14634getPrf().getAlgorithm()));
                pKCS5S2ParametersGenerator.m14982init(C6250Strings.toUTF8ByteArray(cArr), pBKDF2Params.m14635getSalt(), PKCS12Util.validateIterationCount(pBKDF2Params.getIterationCount()));
                CipherParameters cipherParametersGenerateDerivedParameters = pKCS5S2ParametersGenerator.generateDerivedParameters(BigIntegers.intValueExact(pBKDF2Params.getKeyLength()) * 8);
                C6238Arrays.m18227clear(pKCS5S2ParametersGenerator.getPassword());
                c5360HMac.mo14976init(cipherParametersGenerateDerivedParameters);
                c5360HMac.mo14979update(bArr2, 0, bArr2.length);
                byte[] bArr4 = new byte[c5360HMac.getMacSize()];
                c5360HMac.mo14975doFinal(bArr4, 0);
                return bArr4;
            }
        }
        PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(bArr, i);
        PKCS12Key pKCS12Key = new PKCS12Key(cArr, z);
        try {
            Mac macCreateMac = this.f21760helper.createMac(aSN1ObjectIdentifier.m14433getId());
            macCreateMac.init(pKCS12Key, pBEParameterSpec);
            macCreateMac.update(bArr2);
            return macCreateMac.doFinal();
        } finally {
            C6238Arrays.m18228clear(pKCS12Key.getPassword());
        }
    }

    private Cipher createCipher(int i, char[] cArr, AlgorithmIdentifier algorithmIdentifier) throws InvalidKeySpecException, InvalidKeyException, IOException, InvalidAlgorithmParameterException {
        SecretKey secretKeyGenerateSecret;
        PBES2Parameters pBES2Parameters = PBES2Parameters.getInstance(algorithmIdentifier.getParameters());
        PBKDF2Params pBKDF2Params = PBKDF2Params.getInstance(pBES2Parameters.getKeyDerivationFunc().getParameters());
        AlgorithmIdentifier algorithmIdentifier2 = AlgorithmIdentifier.getInstance(pBES2Parameters.getEncryptionScheme());
        SecretKeyFactory secretKeyFactoryCreateSecretKeyFactory = this.f21760helper.createSecretKeyFactory(pBES2Parameters.getKeyDerivationFunc().getAlgorithm().m14433getId());
        byte[] bArrM14635getSalt = pBKDF2Params.m14635getSalt();
        int iValidateIterationCount = PKCS12Util.validateIterationCount(pBKDF2Params.getIterationCount());
        int keySize = keySizeProvider.getKeySize(algorithmIdentifier2);
        if (!pBKDF2Params.isDefaultPrf()) {
            secretKeyGenerateSecret = secretKeyFactoryCreateSecretKeyFactory.generateSecret(new PBKDF2KeySpec(cArr, bArrM14635getSalt, iValidateIterationCount, keySize, pBKDF2Params.m14634getPrf()));
        } else if ((i == 2 || i == 4) && this.useISO8859d1ForDecryption) {
            PKCS5S2ParametersGenerator pKCS5S2ParametersGenerator = new PKCS5S2ParametersGenerator(new SHA1Digest());
            pKCS5S2ParametersGenerator.m14982init(new String(cArr).getBytes(StandardCharsets.ISO_8859_1), bArrM14635getSalt, iValidateIterationCount);
            secretKeyGenerateSecret = new SecretKeySpec(((KeyParameter) pKCS5S2ParametersGenerator.generateDerivedParameters(keySize)).m15773getKey(), "AES");
        } else {
            secretKeyGenerateSecret = secretKeyFactoryCreateSecretKeyFactory.generateSecret(new PBEKeySpec(cArr, bArrM14635getSalt, iValidateIterationCount, keySize));
        }
        Cipher cipherCreateCipher = this.f21760helper.createCipher(pBES2Parameters.getEncryptionScheme().getAlgorithm().m14433getId());
        ASN1Encodable parameters = pBES2Parameters.getEncryptionScheme().getParameters();
        if (parameters instanceof ASN1OctetString) {
            cipherCreateCipher.init(i, secretKeyGenerateSecret, new IvParameterSpec(ASN1OctetString.getInstance(parameters).getOctets()));
        } else {
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(parameters);
            if (aSN1Sequence.getObjectAt(1) instanceof ASN1ObjectIdentifier) {
                GOST28147Parameters gOST28147Parameters = GOST28147Parameters.getInstance(parameters);
                cipherCreateCipher.init(i, secretKeyGenerateSecret, new GOST28147ParameterSpec(gOST28147Parameters.getEncryptionParamSet(), gOST28147Parameters.m14575getIV()));
            } else {
                AlgorithmParameters algorithmParametersCreateAlgorithmParameters = this.f21760helper.createAlgorithmParameters(algorithmIdentifier2.getAlgorithm().m14433getId());
                try {
                    algorithmParametersCreateAlgorithmParameters.init(aSN1Sequence.getEncoded());
                    cipherCreateCipher.init(i, secretKeyGenerateSecret, algorithmParametersCreateAlgorithmParameters);
                } catch (IOException e) {
                    throw new InvalidKeySpecException(e.getMessage());
                }
            }
        }
        return cipherCreateCipher;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private C5138SafeBag createSafeBag(String str, Certificate certificate, boolean z) {
        C5135CertBag c5135CertBag = new C5135CertBag(PKCSObjectIdentifiers.x509Certificate, new DEROctetString(certificate.getEncoded()));
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        boolean z2 = false;
        if (certificate instanceof PKCS12BagAttributeCarrier) {
            PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier = (PKCS12BagAttributeCarrier) certificate;
            ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.pkcs_9_at_friendlyName;
            ASN1BMPString aSN1BMPString = (ASN1BMPString) pKCS12BagAttributeCarrier.getBagAttribute(aSN1ObjectIdentifier);
            if (z && ((aSN1BMPString == null || !aSN1BMPString.getString().equals(str)) && str != null)) {
                pKCS12BagAttributeCarrier.setBagAttribute(aSN1ObjectIdentifier, new DERBMPString(str));
            }
            Enumeration bagAttributeKeys = pKCS12BagAttributeCarrier.getBagAttributeKeys();
            while (bagAttributeKeys.hasMoreElements()) {
                ASN1ObjectIdentifier aSN1ObjectIdentifier2 = (ASN1ObjectIdentifier) bagAttributeKeys.nextElement();
                if (!aSN1ObjectIdentifier2.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.pkcs_9_at_localKeyId) && !aSN1ObjectIdentifier2.m14446equals((ASN1Primitive) MiscObjectIdentifiers.id_oracle_pkcs12_trusted_key_usage)) {
                    ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                    aSN1EncodableVector2.m14420add(aSN1ObjectIdentifier2);
                    aSN1EncodableVector2.m14420add(new C5104DERSet(pKCS12BagAttributeCarrier.getBagAttribute(aSN1ObjectIdentifier2)));
                    aSN1EncodableVector.m14420add(new DERSequence(aSN1EncodableVector2));
                    z2 = true;
                }
            }
        }
        if (!z2) {
            ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
            aSN1EncodableVector3.m14420add(PKCSObjectIdentifiers.pkcs_9_at_friendlyName);
            aSN1EncodableVector3.m14420add(new C5104DERSet(new DERBMPString(str)));
            aSN1EncodableVector.m14420add(new DERSequence(aSN1EncodableVector3));
        }
        if (certificate instanceof X509Certificate) {
            ASN1OctetString extensionValue = Extensions.getExtensionValue(TBSCertificate.getInstance(((X509Certificate) certificate).getTBSCertificate()).getExtensions(), Extension.extendedKeyUsage);
            aSN1EncodableVector.m14420add(new DERSequence(MiscObjectIdentifiers.id_oracle_pkcs12_trusted_key_usage, extensionValue != null ? new C5104DERSet(ExtendedKeyUsage.getInstance(extensionValue.getOctets()).getUsages()) : new C5104DERSet(KeyPurposeId.anyExtendedKeyUsage)));
        }
        return new C5138SafeBag(PKCSObjectIdentifiers.f18491certBag, c5135CertBag.toASN1Primitive(), new C5104DERSet(aSN1EncodableVector));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SubjectKeyIdentifier createSubjectKeyId(PublicKey publicKey) {
        try {
            return new SubjectKeyIdentifier(getDigest(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded())));
        } catch (Exception unused) {
            throw new RuntimeException("error creating key");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: doStore */
    private void m16161doStore(OutputStream outputStream, char[] cArr, boolean z, boolean z2) throws NoSuchAlgorithmException, SignatureException, IOException, InvalidKeyException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException {
        AlgorithmIdentifier algorithmIdentifier;
        C5136MacData c5136MacData;
        boolean z3;
        Enumeration enumeration;
        String str;
        byte[] bArrM16164wrapKey;
        AlgorithmIdentifier algorithmIdentifier2;
        boolean z4;
        if (!z2) {
            syncFriendlyName();
        }
        int iM16170size = this.f21762keys.m16170size();
        String str2 = ASN1Encoding.f17901BER;
        if (iM16170size == 0) {
            if (cArr == null) {
                Enumeration enumerationM16167keys = this.f21759certs.m16167keys();
                ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                while (enumerationM16167keys.hasMoreElements()) {
                    try {
                        String str3 = (String) enumerationM16167keys.nextElement();
                        aSN1EncodableVector.m14420add(createSafeBag(str3, (Certificate) this.f21759certs.m16166get(str3), z2));
                    } catch (CertificateEncodingException e) {
                        throw new IOException("Error encoding certificate: " + e.toString());
                    }
                }
                ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.f18493data;
                if (z) {
                    new C5137Pfx(new ContentInfo(aSN1ObjectIdentifier, new DEROctetString(new DERSequence(new ContentInfo(aSN1ObjectIdentifier, new DEROctetString(new DERSequence(aSN1EncodableVector).getEncoded()))).getEncoded())), null).encodeTo(outputStream, ASN1Encoding.f17902DER);
                    return;
                } else {
                    new C5137Pfx(new ContentInfo(aSN1ObjectIdentifier, new BEROctetString(new BERSequence(new ContentInfo(aSN1ObjectIdentifier, new BEROctetString(new BERSequence(aSN1EncodableVector).getEncoded()))).getEncoded())), null).encodeTo(outputStream, ASN1Encoding.f17901BER);
                    return;
                }
            }
        } else if (cArr == null) {
            throw new NullPointerException("no password supplied for PKCS#12 KeyStore");
        }
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        Enumeration enumerationM16167keys2 = this.f21762keys.m16167keys();
        while (enumerationM16167keys2.hasMoreElements()) {
            byte[] bArr = new byte[20];
            this.f21763random.nextBytes(bArr);
            String str4 = (String) enumerationM16167keys2.nextElement();
            PrivateKey privateKey = (PrivateKey) this.f21762keys.m16166get(str4);
            if (isPBKDF2(this.keyAlgorithm)) {
                enumeration = enumerationM16167keys2;
                PBKDF2Params pBKDF2Params = new PBKDF2Params(bArr, MIN_ITERATIONS, getKeyLength(this.keyAlgorithm), new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA256, C5103DERNull.INSTANCE));
                ASN1ObjectIdentifier aSN1ObjectIdentifier2 = this.keyAlgorithm;
                str = str2;
                algorithmIdentifier2 = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBES2, new PBES2Parameters(new KeyDerivationFunc(PKCSObjectIdentifiers.id_PBKDF2, pBKDF2Params), new EncryptionScheme(aSN1ObjectIdentifier2, getAlgParams(aSN1ObjectIdentifier2))));
                bArrM16164wrapKey = m16164wrapKey(algorithmIdentifier2, privateKey, cArr);
            } else {
                enumeration = enumerationM16167keys2;
                str = str2;
                PKCS12PBEParams pKCS12PBEParams = new PKCS12PBEParams(bArr, MIN_ITERATIONS);
                byte[] bArrM16163wrapKey = m16163wrapKey(this.keyAlgorithm.m14433getId(), privateKey, pKCS12PBEParams, cArr);
                AlgorithmIdentifier algorithmIdentifier3 = new AlgorithmIdentifier(this.keyAlgorithm, pKCS12PBEParams.toASN1Primitive());
                bArrM16164wrapKey = bArrM16163wrapKey;
                algorithmIdentifier2 = algorithmIdentifier3;
            }
            EncryptedPrivateKeyInfo encryptedPrivateKeyInfo = new EncryptedPrivateKeyInfo(algorithmIdentifier2, bArrM16164wrapKey);
            ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
            if (privateKey instanceof PKCS12BagAttributeCarrier) {
                PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier = (PKCS12BagAttributeCarrier) privateKey;
                ASN1ObjectIdentifier aSN1ObjectIdentifier3 = PKCSObjectIdentifiers.pkcs_9_at_friendlyName;
                ASN1BMPString aSN1BMPString = (ASN1BMPString) pKCS12BagAttributeCarrier.getBagAttribute(aSN1ObjectIdentifier3);
                if (z2 && (aSN1BMPString == null || !aSN1BMPString.getString().equals(str4))) {
                    pKCS12BagAttributeCarrier.setBagAttribute(aSN1ObjectIdentifier3, new DERBMPString(str4));
                }
                ASN1ObjectIdentifier aSN1ObjectIdentifier4 = PKCSObjectIdentifiers.pkcs_9_at_localKeyId;
                if (pKCS12BagAttributeCarrier.getBagAttribute(aSN1ObjectIdentifier4) == null) {
                    pKCS12BagAttributeCarrier.setBagAttribute(aSN1ObjectIdentifier4, createSubjectKeyId(engineGetCertificate(str4).getPublicKey()));
                }
                Enumeration bagAttributeKeys = pKCS12BagAttributeCarrier.getBagAttributeKeys();
                z4 = false;
                while (bagAttributeKeys.hasMoreElements()) {
                    ASN1ObjectIdentifier aSN1ObjectIdentifier5 = (ASN1ObjectIdentifier) bagAttributeKeys.nextElement();
                    ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
                    aSN1EncodableVector4.m14420add(aSN1ObjectIdentifier5);
                    aSN1EncodableVector4.m14420add(new C5104DERSet(pKCS12BagAttributeCarrier.getBagAttribute(aSN1ObjectIdentifier5)));
                    aSN1EncodableVector3.m14420add(new DERSequence(aSN1EncodableVector4));
                    z4 = true;
                }
            } else {
                z4 = false;
            }
            if (!z4) {
                ASN1EncodableVector aSN1EncodableVector5 = new ASN1EncodableVector();
                Certificate certificateEngineGetCertificate = engineGetCertificate(str4);
                aSN1EncodableVector5.m14420add(PKCSObjectIdentifiers.pkcs_9_at_localKeyId);
                aSN1EncodableVector5.m14420add(new C5104DERSet(createSubjectKeyId(certificateEngineGetCertificate.getPublicKey())));
                aSN1EncodableVector3.m14420add(new DERSequence(aSN1EncodableVector5));
                ASN1EncodableVector aSN1EncodableVector6 = new ASN1EncodableVector();
                aSN1EncodableVector6.m14420add(PKCSObjectIdentifiers.pkcs_9_at_friendlyName);
                aSN1EncodableVector6.m14420add(new C5104DERSet(new DERBMPString(str4)));
                aSN1EncodableVector3.m14420add(new DERSequence(aSN1EncodableVector6));
            }
            aSN1EncodableVector2.m14420add(new C5138SafeBag(PKCSObjectIdentifiers.pkcs8ShroudedKeyBag, encryptedPrivateKeyInfo.toASN1Primitive(), new C5104DERSet(aSN1EncodableVector3)));
            enumerationM16167keys2 = enumeration;
            str2 = str;
        }
        String str5 = str2;
        BEROctetString bEROctetString = new BEROctetString(new DERSequence(aSN1EncodableVector2).getEncoded(ASN1Encoding.f17902DER));
        byte[] bArr2 = new byte[20];
        this.f21763random.nextBytes(bArr2);
        ASN1EncodableVector aSN1EncodableVector7 = new ASN1EncodableVector();
        if (isPBKDF2(this.certAlgorithm)) {
            PBKDF2Params pBKDF2Params2 = new PBKDF2Params(bArr2, MIN_ITERATIONS, getKeyLength(this.certAlgorithm), new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA256, C5103DERNull.INSTANCE));
            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = PKCSObjectIdentifiers.id_PBES2;
            KeyDerivationFunc keyDerivationFunc = new KeyDerivationFunc(PKCSObjectIdentifiers.id_PBKDF2, pBKDF2Params2);
            ASN1ObjectIdentifier aSN1ObjectIdentifier7 = this.certAlgorithm;
            algorithmIdentifier = new AlgorithmIdentifier(aSN1ObjectIdentifier6, new PBES2Parameters(keyDerivationFunc, new EncryptionScheme(aSN1ObjectIdentifier7, getAlgParams(aSN1ObjectIdentifier7))));
        } else {
            algorithmIdentifier = new AlgorithmIdentifier(this.certAlgorithm, new PKCS12PBEParams(bArr2, MIN_ITERATIONS).toASN1Primitive());
        }
        AlgorithmIdentifier algorithmIdentifier4 = algorithmIdentifier;
        Hashtable hashtable = new Hashtable();
        Enumeration enumerationM16167keys3 = this.f21762keys.m16167keys();
        while (enumerationM16167keys3.hasMoreElements()) {
            try {
                String str6 = (String) enumerationM16167keys3.nextElement();
                Certificate certificateEngineGetCertificate2 = engineGetCertificate(str6);
                Enumeration enumeration2 = enumerationM16167keys3;
                C5135CertBag c5135CertBag = new C5135CertBag(PKCSObjectIdentifiers.x509Certificate, new DEROctetString(certificateEngineGetCertificate2.getEncoded()));
                ASN1EncodableVector aSN1EncodableVector8 = new ASN1EncodableVector();
                if (certificateEngineGetCertificate2 instanceof PKCS12BagAttributeCarrier) {
                    PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier2 = (PKCS12BagAttributeCarrier) certificateEngineGetCertificate2;
                    ASN1ObjectIdentifier aSN1ObjectIdentifier8 = PKCSObjectIdentifiers.pkcs_9_at_friendlyName;
                    ASN1BMPString aSN1BMPString2 = (ASN1BMPString) pKCS12BagAttributeCarrier2.getBagAttribute(aSN1ObjectIdentifier8);
                    if (z2 && (aSN1BMPString2 == null || !aSN1BMPString2.getString().equals(str6))) {
                        pKCS12BagAttributeCarrier2.setBagAttribute(aSN1ObjectIdentifier8, new DERBMPString(str6));
                    }
                    ASN1ObjectIdentifier aSN1ObjectIdentifier9 = PKCSObjectIdentifiers.pkcs_9_at_localKeyId;
                    if (pKCS12BagAttributeCarrier2.getBagAttribute(aSN1ObjectIdentifier9) == null) {
                        pKCS12BagAttributeCarrier2.setBagAttribute(aSN1ObjectIdentifier9, createSubjectKeyId(certificateEngineGetCertificate2.getPublicKey()));
                    }
                    Enumeration bagAttributeKeys2 = pKCS12BagAttributeCarrier2.getBagAttributeKeys();
                    z3 = false;
                    while (bagAttributeKeys2.hasMoreElements()) {
                        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = (ASN1ObjectIdentifier) bagAttributeKeys2.nextElement();
                        Enumeration enumeration3 = bagAttributeKeys2;
                        ASN1EncodableVector aSN1EncodableVector9 = new ASN1EncodableVector();
                        aSN1EncodableVector9.m14420add(aSN1ObjectIdentifier10);
                        aSN1EncodableVector9.m14420add(new C5104DERSet(pKCS12BagAttributeCarrier2.getBagAttribute(aSN1ObjectIdentifier10)));
                        aSN1EncodableVector8.m14420add(new DERSequence(aSN1EncodableVector9));
                        bagAttributeKeys2 = enumeration3;
                        z3 = true;
                    }
                } else {
                    z3 = false;
                }
                if (!z3) {
                    ASN1EncodableVector aSN1EncodableVector10 = new ASN1EncodableVector();
                    aSN1EncodableVector10.m14420add(PKCSObjectIdentifiers.pkcs_9_at_localKeyId);
                    aSN1EncodableVector10.m14420add(new C5104DERSet(createSubjectKeyId(certificateEngineGetCertificate2.getPublicKey())));
                    aSN1EncodableVector8.m14420add(new DERSequence(aSN1EncodableVector10));
                    ASN1EncodableVector aSN1EncodableVector11 = new ASN1EncodableVector();
                    aSN1EncodableVector11.m14420add(PKCSObjectIdentifiers.pkcs_9_at_friendlyName);
                    aSN1EncodableVector11.m14420add(new C5104DERSet(new DERBMPString(str6)));
                    aSN1EncodableVector8.m14420add(new DERSequence(aSN1EncodableVector11));
                }
                aSN1EncodableVector7.m14420add(new C5138SafeBag(PKCSObjectIdentifiers.f18491certBag, c5135CertBag.toASN1Primitive(), new C5104DERSet(aSN1EncodableVector8)));
                hashtable.put(certificateEngineGetCertificate2, certificateEngineGetCertificate2);
                enumerationM16167keys3 = enumeration2;
            } catch (CertificateEncodingException e2) {
                throw new IOException("Error encoding certificate: " + e2.toString());
            }
        }
        Enumeration enumerationM16167keys4 = this.f21759certs.m16167keys();
        while (enumerationM16167keys4.hasMoreElements()) {
            try {
                String str7 = (String) enumerationM16167keys4.nextElement();
                Certificate certificate = (Certificate) this.f21759certs.m16166get(str7);
                if (this.f21762keys.m16166get(str7) == null) {
                    aSN1EncodableVector7.m14420add(createSafeBag(str7, certificate, z2));
                    hashtable.put(certificate, certificate);
                }
            } catch (CertificateEncodingException e3) {
                throw new IOException("Error encoding certificate: " + e3.toString());
            }
        }
        Set usedCertificateSet = getUsedCertificateSet();
        Enumeration enumerationKeys = this.chainCerts.keys();
        while (enumerationKeys.hasMoreElements()) {
            try {
                Certificate certificate2 = (Certificate) this.chainCerts.get((C5676CertId) enumerationKeys.nextElement());
                if (usedCertificateSet.contains(certificate2) && hashtable.get(certificate2) == null) {
                    C5135CertBag c5135CertBag2 = new C5135CertBag(PKCSObjectIdentifiers.x509Certificate, new DEROctetString(certificate2.getEncoded()));
                    ASN1EncodableVector aSN1EncodableVector12 = new ASN1EncodableVector();
                    if (certificate2 instanceof PKCS12BagAttributeCarrier) {
                        PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier3 = (PKCS12BagAttributeCarrier) certificate2;
                        Enumeration bagAttributeKeys3 = pKCS12BagAttributeCarrier3.getBagAttributeKeys();
                        while (bagAttributeKeys3.hasMoreElements()) {
                            ASN1ObjectIdentifier aSN1ObjectIdentifier11 = (ASN1ObjectIdentifier) bagAttributeKeys3.nextElement();
                            if (!aSN1ObjectIdentifier11.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.pkcs_9_at_localKeyId)) {
                                ASN1EncodableVector aSN1EncodableVector13 = new ASN1EncodableVector();
                                aSN1EncodableVector13.m14420add(aSN1ObjectIdentifier11);
                                aSN1EncodableVector13.m14420add(new C5104DERSet(pKCS12BagAttributeCarrier3.getBagAttribute(aSN1ObjectIdentifier11)));
                                aSN1EncodableVector12.m14420add(new DERSequence(aSN1EncodableVector13));
                            }
                        }
                    }
                    aSN1EncodableVector7.m14420add(new C5138SafeBag(PKCSObjectIdentifiers.f18491certBag, c5135CertBag2.toASN1Primitive(), new C5104DERSet(aSN1EncodableVector12)));
                }
            } catch (CertificateEncodingException e4) {
                throw new IOException("Error encoding certificate: " + e4.toString());
            }
        }
        byte[] bArrCryptData = cryptData(true, algorithmIdentifier4, cArr, false, new DERSequence(aSN1EncodableVector7).getEncoded(ASN1Encoding.f17902DER));
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = PKCSObjectIdentifiers.f18493data;
        ContentInfo contentInfo = new ContentInfo(aSN1ObjectIdentifier12, new BEROctetString(new AuthenticatedSafe(new ContentInfo[]{new ContentInfo(aSN1ObjectIdentifier12, bEROctetString), new ContentInfo(PKCSObjectIdentifiers.encryptedData, new EncryptedData(aSN1ObjectIdentifier12, algorithmIdentifier4, new BEROctetString(bArrCryptData)).toASN1Primitive())}).getEncoded(z ? ASN1Encoding.f17902DER : str5)));
        byte[] bArr3 = new byte[this.saltLength];
        this.f21763random.nextBytes(bArr3);
        byte[] contentOctets = PKCS12Util.getContentOctets(contentInfo);
        if (this.keyAlgorithm.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_aes256_GCM)) {
            c5136MacData = null;
        } else {
            try {
                c5136MacData = new C5136MacData(new DigestInfo(this.macAlgorithm, calculatePbeMac(this.macAlgorithm.getAlgorithm(), bArr3, this.f21761itCount, cArr, false, contentOctets)), bArr3, this.f21761itCount);
            } catch (Exception e5) {
                throw new IOException("error constructing MAC: " + e5.toString());
            }
        }
        new C5137Pfx(contentInfo, c5136MacData).encodeTo(outputStream, z ? ASN1Encoding.f17902DER : str5);
    }

    private ASN1Primitive getAlgParams(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_aes128_CBC) || aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_aes256_CBC)) {
            byte[] bArr = new byte[16];
            this.f21763random.nextBytes(bArr);
            return new DEROctetString(bArr);
        }
        if (!aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_aes128_GCM) && !aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_aes256_GCM)) {
            throw new IllegalStateException("unknown encryption OID in getAlgParams()");
        }
        byte[] bArr2 = new byte[12];
        this.f21763random.nextBytes(bArr2);
        return new GCMParameters(bArr2, 16).toASN1Primitive();
    }

    private static byte[] getDigest(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        InterfaceC5277Digest interfaceC5277DigestCreateSHA1 = DigestFactory.createSHA1();
        byte[] bArr = new byte[interfaceC5277DigestCreateSHA1.getDigestSize()];
        byte[] bytes = subjectPublicKeyInfo.getPublicKeyData().getBytes();
        interfaceC5277DigestCreateSHA1.mo14970update(bytes, 0, bytes.length);
        interfaceC5277DigestCreateSHA1.mo14967doFinal(bArr, 0);
        return bArr;
    }

    private static int getKeyLength(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return keySizeProvider.getKeySize(new AlgorithmIdentifier(aSN1ObjectIdentifier)) / 8;
    }

    /* renamed from: getPrf */
    private static InterfaceC5277Digest m16162getPrf(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (PKCSObjectIdentifiers.id_hmacWithSHA256.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return new SHA256Digest();
        }
        if (PKCSObjectIdentifiers.id_hmacWithSHA512.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return new SHA512Digest();
        }
        throw new IllegalArgumentException("unknown prf id " + aSN1ObjectIdentifier);
    }

    private Set getUsedCertificateSet() throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        HashSet hashSet = new HashSet();
        Enumeration enumerationM16167keys = this.f21762keys.m16167keys();
        while (enumerationM16167keys.hasMoreElements()) {
            Certificate[] certificateArrEngineGetCertificateChain = engineGetCertificateChain((String) enumerationM16167keys.nextElement());
            for (int i = 0; i != certificateArrEngineGetCertificateChain.length; i++) {
                hashSet.add(certificateArrEngineGetCertificateChain[i]);
            }
        }
        Enumeration enumerationM16167keys2 = this.f21759certs.m16167keys();
        while (enumerationM16167keys2.hasMoreElements()) {
            hashSet.add(engineGetCertificate((String) enumerationM16167keys2.nextElement()));
        }
        return hashSet;
    }

    private static boolean isPBKDF2(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_aes256_CBC) || aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_aes256_GCM) || aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_aes128_CBC) || aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_aes128_GCM);
    }

    private void processKeyBag(C5138SafeBag c5138SafeBag) throws IOException {
        String str;
        PrivateKey privateKey = BouncyCastleProvider.getPrivateKey(PrivateKeyInfo.getInstance(c5138SafeBag.getBagValue()));
        ASN1OctetString aSN1OctetString = null;
        String string = null;
        if (privateKey instanceof PKCS12BagAttributeCarrier) {
            PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier = (PKCS12BagAttributeCarrier) privateKey;
            Enumeration objects = c5138SafeBag.getBagAttributes().getObjects();
            ASN1OctetString aSN1OctetString2 = null;
            while (objects.hasMoreElements()) {
                ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(objects.nextElement());
                ASN1ObjectIdentifier aSN1ObjectIdentifier = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
                AbstractC5093ASN1Set abstractC5093ASN1Set = AbstractC5093ASN1Set.getInstance(aSN1Sequence.getObjectAt(1));
                if (abstractC5093ASN1Set.m14454size() > 0) {
                    ASN1Primitive aSN1Primitive = (ASN1Primitive) abstractC5093ASN1Set.getObjectAt(0);
                    ASN1Encodable bagAttribute = pKCS12BagAttributeCarrier.getBagAttribute(aSN1ObjectIdentifier);
                    if (bagAttribute == null) {
                        pKCS12BagAttributeCarrier.setBagAttribute(aSN1ObjectIdentifier, aSN1Primitive);
                    } else if (!bagAttribute.toASN1Primitive().m14446equals(aSN1Primitive)) {
                        throw new IOException("attempt to add existing attribute with different value");
                    }
                    if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.pkcs_9_at_friendlyName)) {
                        string = ((ASN1BMPString) aSN1Primitive).getString();
                        this.f21762keys.m16168put(string, privateKey);
                    } else if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.pkcs_9_at_localKeyId)) {
                        aSN1OctetString2 = (ASN1OctetString) aSN1Primitive;
                    }
                }
            }
            str = string;
            aSN1OctetString = aSN1OctetString2;
        } else {
            str = null;
        }
        String str2 = new String(C6255Hex.m18343encode(aSN1OctetString.getOctets()));
        if (str == null) {
            this.f21762keys.m16168put(str2, privateKey);
        } else {
            this.localIds.m16168put(str, str2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    private boolean processShroudedKeyBag(C5138SafeBag c5138SafeBag, char[] cArr, boolean z) throws InvalidKeyException, IOException, InvalidAlgorithmParameterException {
        String string;
        ASN1OctetString aSN1OctetString;
        EncryptedPrivateKeyInfo encryptedPrivateKeyInfo = EncryptedPrivateKeyInfo.getInstance(c5138SafeBag.getBagValue());
        PrivateKey privateKeyUnwrapKey = unwrapKey(encryptedPrivateKeyInfo.getEncryptionAlgorithm(), encryptedPrivateKeyInfo.getEncryptedData(), cArr, z);
        ASN1OctetString aSN1OctetString2 = null;
        if (c5138SafeBag.getBagAttributes() != null) {
            Enumeration objects = c5138SafeBag.getBagAttributes().getObjects();
            string = null;
            ASN1OctetString aSN1OctetString3 = null;
            while (objects.hasMoreElements()) {
                ASN1Sequence aSN1Sequence = (ASN1Sequence) objects.nextElement();
                ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) aSN1Sequence.getObjectAt(0);
                AbstractC5093ASN1Set abstractC5093ASN1Set = (AbstractC5093ASN1Set) aSN1Sequence.getObjectAt(1);
                if (abstractC5093ASN1Set.m14454size() > 0) {
                    ASN1Primitive aSN1Primitive = (ASN1Primitive) abstractC5093ASN1Set.getObjectAt(0);
                    aSN1OctetString = aSN1Primitive;
                    if (privateKeyUnwrapKey instanceof PKCS12BagAttributeCarrier) {
                        PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier = (PKCS12BagAttributeCarrier) privateKeyUnwrapKey;
                        ASN1Encodable bagAttribute = pKCS12BagAttributeCarrier.getBagAttribute(aSN1ObjectIdentifier);
                        if (bagAttribute != null) {
                            boolean zM14446equals = bagAttribute.toASN1Primitive().m14446equals(aSN1Primitive);
                            aSN1OctetString = aSN1Primitive;
                            if (!zM14446equals) {
                                throw new IOException("attempt to add existing attribute with different value");
                            }
                        } else {
                            pKCS12BagAttributeCarrier.setBagAttribute(aSN1ObjectIdentifier, aSN1Primitive);
                            aSN1OctetString = aSN1Primitive;
                        }
                    }
                } else {
                    aSN1OctetString = 0;
                }
                if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.pkcs_9_at_friendlyName)) {
                    string = ((ASN1BMPString) aSN1OctetString).getString();
                    this.f21762keys.m16168put(string, privateKeyUnwrapKey);
                } else if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.pkcs_9_at_localKeyId)) {
                    aSN1OctetString3 = aSN1OctetString;
                }
            }
            aSN1OctetString2 = aSN1OctetString3;
        } else {
            string = null;
        }
        if (aSN1OctetString2 == null) {
            this.f21762keys.m16168put("unmarked", privateKeyUnwrapKey);
            return true;
        }
        String str = new String(C6255Hex.m18343encode(aSN1OctetString2.getOctets()));
        if (string == null) {
            this.f21762keys.m16168put(str, privateKeyUnwrapKey);
        } else {
            this.localIds.m16168put(string, str);
        }
        return false;
    }

    private void syncFriendlyName() {
        ASN1Encodable bagAttribute;
        ASN1Encodable bagAttribute2;
        ASN1Encodable bagAttribute3;
        Enumeration enumerationM16167keys = this.f21762keys.m16167keys();
        while (enumerationM16167keys.hasMoreElements()) {
            String str = (String) enumerationM16167keys.nextElement();
            PrivateKey privateKey = (PrivateKey) this.f21762keys.m16166get(str);
            if ((privateKey instanceof PKCS12BagAttributeCarrier) && (bagAttribute3 = ((PKCS12BagAttributeCarrier) privateKey).getBagAttribute(PKCSObjectIdentifiers.pkcs_9_at_friendlyName)) != null && !str.equals(bagAttribute3.toString())) {
                this.f21762keys.m16168put(bagAttribute3.toString(), privateKey);
                this.f21762keys.m16169remove(str);
            }
        }
        Enumeration enumerationM16167keys2 = this.f21759certs.m16167keys();
        while (enumerationM16167keys2.hasMoreElements()) {
            String str2 = (String) enumerationM16167keys2.nextElement();
            Object obj = (Certificate) this.f21759certs.m16166get(str2);
            if ((obj instanceof PKCS12BagAttributeCarrier) && (bagAttribute2 = ((PKCS12BagAttributeCarrier) obj).getBagAttribute(PKCSObjectIdentifiers.pkcs_9_at_friendlyName)) != null && !str2.equals(bagAttribute2.toString())) {
                this.f21759certs.m16168put(bagAttribute2.toString(), obj);
                this.f21759certs.m16169remove(str2);
            }
        }
        Enumeration enumerationKeys = this.keyCerts.keys();
        while (enumerationKeys.hasMoreElements()) {
            String str3 = (String) enumerationKeys.nextElement();
            Object obj2 = (Certificate) this.keyCerts.get(str3);
            if ((obj2 instanceof PKCS12BagAttributeCarrier) && (bagAttribute = ((PKCS12BagAttributeCarrier) obj2).getBagAttribute(PKCSObjectIdentifiers.pkcs_9_at_friendlyName)) != null && !str3.equals(bagAttribute.toString())) {
                this.keyCerts.put(bagAttribute.toString(), obj2);
                this.keyCerts.remove(str3);
            }
        }
    }

    public byte[] cryptData(boolean z, AlgorithmIdentifier algorithmIdentifier, char[] cArr, boolean z2, byte[] bArr) throws IOException {
        ASN1ObjectIdentifier algorithm = algorithmIdentifier.getAlgorithm();
        int i = z ? 1 : 2;
        if (!algorithm.m14435on(PKCSObjectIdentifiers.pkcs_12PbeIds)) {
            if (!algorithm.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.id_PBES2)) {
                throw new IOException("unknown PBE algorithm: " + algorithm);
            }
            try {
                return createCipher(i, cArr, algorithmIdentifier).doFinal(bArr);
            } catch (Exception e) {
                throw new IOException("exception decrypting data - " + e.toString());
            }
        }
        PKCS12PBEParams pKCS12PBEParams = PKCS12PBEParams.getInstance(algorithmIdentifier.getParameters());
        PKCS12Key pKCS12Key = new PKCS12Key(cArr, z2);
        try {
            try {
                PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(pKCS12PBEParams.m14636getIV(), PKCS12Util.validateIterationCount(pKCS12PBEParams.getIterations()));
                Cipher cipherCreateCipher = this.f21760helper.createCipher(algorithm.m14433getId());
                cipherCreateCipher.init(i, pKCS12Key, pBEParameterSpec);
                return cipherCreateCipher.doFinal(bArr);
            } catch (Exception e2) {
                throw new IOException("exception decrypting data - " + e2.toString());
            }
        } finally {
            C6238Arrays.m18228clear(pKCS12Key.getPassword());
        }
    }

    @Override // java.security.KeyStoreSpi
    public Enumeration engineAliases() {
        Hashtable hashtable = new Hashtable();
        Enumeration enumerationM16167keys = this.f21759certs.m16167keys();
        while (enumerationM16167keys.hasMoreElements()) {
            hashtable.put(enumerationM16167keys.nextElement(), "cert");
        }
        Enumeration enumerationM16167keys2 = this.f21762keys.m16167keys();
        while (enumerationM16167keys2.hasMoreElements()) {
            String str = (String) enumerationM16167keys2.nextElement();
            if (hashtable.get(str) == null) {
                hashtable.put(str, "key");
            }
        }
        return hashtable.keys();
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineContainsAlias(String str) {
        return (this.f21759certs.m16166get(str) == null && this.f21762keys.m16166get(str) == null) ? false : true;
    }

    @Override // java.security.KeyStoreSpi
    public void engineDeleteEntry(String str) {
        String str2;
        Certificate certificate;
        Certificate certificate2 = (Certificate) this.f21759certs.m16169remove(str);
        if (certificate2 != null) {
            this.chainCerts.remove(new C5676CertId(certificate2.getPublicKey()));
        }
        if (((Key) this.f21762keys.m16169remove(str)) == null || (str2 = (String) this.localIds.m16169remove(str)) == null || (certificate = (Certificate) this.keyCerts.remove(str2)) == null) {
            return;
        }
        this.chainCerts.remove(new C5676CertId(certificate.getPublicKey()));
    }

    @Override // java.security.KeyStoreSpi
    public Certificate engineGetCertificate(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null alias passed to getCertificate.");
        }
        Certificate certificate = (Certificate) this.f21759certs.m16166get(str);
        if (certificate != null) {
            return certificate;
        }
        String str2 = (String) this.localIds.m16166get(str);
        Hashtable hashtable = this.keyCerts;
        return (Certificate) (str2 != null ? hashtable.get(str2) : hashtable.get(str));
    }

    @Override // java.security.KeyStoreSpi
    public String engineGetCertificateAlias(Certificate certificate) {
        Enumeration enumerationElements = this.f21759certs.elements();
        Enumeration enumerationM16167keys = this.f21759certs.m16167keys();
        while (enumerationElements.hasMoreElements()) {
            Certificate certificate2 = (Certificate) enumerationElements.nextElement();
            String str = (String) enumerationM16167keys.nextElement();
            if (certificate2.equals(certificate)) {
                return str;
            }
        }
        Enumeration enumerationElements2 = this.keyCerts.elements();
        Enumeration enumerationKeys = this.keyCerts.keys();
        while (enumerationElements2.hasMoreElements()) {
            Certificate certificate3 = (Certificate) enumerationElements2.nextElement();
            String str2 = (String) enumerationKeys.nextElement();
            if (certificate3.equals(certificate)) {
                return str2;
            }
        }
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public Certificate[] engineGetCertificateChain(String str) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        Certificate certificateEngineGetCertificate;
        byte[] keyIdentifierOctets;
        if (str == null) {
            throw new IllegalArgumentException("null alias passed to getCertificateChain.");
        }
        if (!engineIsKeyEntry(str) || (certificateEngineGetCertificate = engineGetCertificate(str)) == null) {
            return null;
        }
        Vector vector = new Vector();
        while (certificateEngineGetCertificate != null) {
            X509Certificate x509Certificate = (X509Certificate) certificateEngineGetCertificate;
            byte[] extensionValue = x509Certificate.getExtensionValue(Extension.authorityKeyIdentifier.m14433getId());
            Certificate certificate = (extensionValue == null || (keyIdentifierOctets = AuthorityKeyIdentifier.getInstance(ASN1OctetString.getInstance(extensionValue).getOctets()).getKeyIdentifierOctets()) == null) ? null : (Certificate) this.chainCerts.get(new C5676CertId(keyIdentifierOctets));
            if (certificate == null) {
                Principal issuerDN = x509Certificate.getIssuerDN();
                if (!issuerDN.equals(x509Certificate.getSubjectDN())) {
                    Enumeration enumerationKeys = this.chainCerts.keys();
                    while (true) {
                        if (!enumerationKeys.hasMoreElements()) {
                            break;
                        }
                        X509Certificate x509Certificate2 = (X509Certificate) this.chainCerts.get(enumerationKeys.nextElement());
                        if (x509Certificate2.getSubjectDN().equals(issuerDN)) {
                            try {
                                x509Certificate.verify(x509Certificate2.getPublicKey());
                                certificate = x509Certificate2;
                                break;
                            } catch (Exception unused) {
                                continue;
                            }
                        }
                    }
                }
            }
            if (!vector.contains(certificateEngineGetCertificate)) {
                vector.addElement(certificateEngineGetCertificate);
                if (certificate != certificateEngineGetCertificate) {
                    certificateEngineGetCertificate = certificate;
                }
            }
            certificateEngineGetCertificate = null;
        }
        int size = vector.size();
        Certificate[] certificateArr = new Certificate[size];
        for (int i = 0; i != size; i++) {
            certificateArr[i] = (Certificate) vector.elementAt(i);
        }
        return certificateArr;
    }

    @Override // java.security.KeyStoreSpi
    public Date engineGetCreationDate(String str) {
        if (str == null) {
            throw new NullPointerException("alias == null");
        }
        if (this.f21762keys.m16166get(str) == null && this.f21759certs.m16166get(str) == null) {
            return null;
        }
        return new Date();
    }

    @Override // java.security.KeyStoreSpi
    public Key engineGetKey(String str, char[] cArr) {
        if (str != null) {
            return (Key) this.f21762keys.m16166get(str);
        }
        throw new IllegalArgumentException("null alias passed to getKey.");
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsCertificateEntry(String str) {
        return this.f21759certs.m16166get(str) != null && this.f21762keys.m16166get(str) == null;
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsKeyEntry(String str) {
        return this.f21762keys.m16166get(str) != null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x036c  */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Object, java.security.cert.Certificate] */
    /* JADX WARN: Type inference failed for: r5v37 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [org.bouncycastle.asn1.ASN1OctetString] */
    /* JADX WARN: Type inference failed for: r5v6, types: [org.bouncycastle.jcajce.provider.keystore.pkcs12.PKCS12PBMAC1KeyStoreSpi$IgnoresCaseHashtable] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.String] */
    @Override // java.security.KeyStoreSpi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void engineLoad(InputStream inputStream, char[] cArr) throws IOException, InvalidKeyException, CertificateException, InvalidAlgorithmParameterException {
        boolean z;
        boolean z2;
        boolean z3;
        boolean zProcessShroudedKeyBag;
        ?? r5;
        ?? string;
        Enumeration enumeration;
        boolean z4;
        if (inputStream == null) {
            return;
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        bufferedInputStream.mark(10);
        int i = bufferedInputStream.read();
        if (i < 0) {
            throw new EOFException("no data in keystore stream");
        }
        if (i != 48) {
            throw new IOException("stream does not represent a PKCS12 key store");
        }
        bufferedInputStream.reset();
        try {
            C5137Pfx c5137Pfx = C5137Pfx.getInstance(new ASN1InputStream(bufferedInputStream).readObject());
            ContentInfo authSafe = c5137Pfx.getAuthSafe();
            Vector vector = new Vector();
            if (c5137Pfx.getMacData() == null) {
                z = false;
                z2 = true;
            } else {
                if (cArr == null) {
                    throw new NullPointerException("no password supplied when one expected");
                }
                C5136MacData macData = c5137Pfx.getMacData();
                DigestInfo digestInfoM14631getMac = macData.m14631getMac();
                this.macAlgorithm = digestInfoM14631getMac.getAlgorithmId();
                byte[] bArrM14632getSalt = macData.m14632getSalt();
                this.f21761itCount = PKCS12Util.validateIterationCount(macData.getIterationCount());
                this.saltLength = bArrM14632getSalt.length;
                byte[] contentOctets = PKCS12Util.getContentOctets(authSafe);
                try {
                    byte[] bArrCalculatePbeMac = calculatePbeMac(this.macAlgorithm.getAlgorithm(), bArrM14632getSalt, this.f21761itCount, cArr, false, contentOctets);
                    byte[] digest = digestInfoM14631getMac.getDigest();
                    if (C6238Arrays.constantTimeAreEqual(bArrCalculatePbeMac, digest)) {
                        z4 = false;
                    } else {
                        if (cArr.length > 0) {
                            throw Exceptions.ioException("PKCS12 key store mac invalid - wrong password or corrupted file", new UnrecoverableKeyException("PKCS12 key store mac invalid"));
                        }
                        if (!C6238Arrays.constantTimeAreEqual(calculatePbeMac(this.macAlgorithm.getAlgorithm(), bArrM14632getSalt, this.f21761itCount, cArr, true, contentOctets), digest)) {
                            throw Exceptions.ioException("PKCS12 key store mac invalid - wrong password or corrupted file", new UnrecoverableKeyException("PKCS12 key store mac invalid"));
                        }
                        z4 = true;
                    }
                    z = z4;
                    z2 = false;
                } catch (IOException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new IOException("error constructing MAC: " + e2.toString());
                }
            }
            C56751 c56751 = null;
            this.f21762keys = new IgnoresCaseHashtable();
            this.localIds = new IgnoresCaseHashtable();
            if (authSafe.getContentType().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.f18493data)) {
                ContentInfo[] contentInfo = AuthenticatedSafe.getInstance(ASN1OctetString.getInstance(authSafe.getContent()).getOctets()).getContentInfo();
                z3 = true;
                zProcessShroudedKeyBag = false;
                for (int i2 = 0; i2 != contentInfo.length; i2++) {
                    if (contentInfo[i2].getContentType().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.f18493data)) {
                        ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(PKCS12Util.getContentOctets(contentInfo[i2]));
                        for (int i3 = 0; i3 != aSN1Sequence.mo14450size(); i3++) {
                            C5138SafeBag c5138SafeBag = C5138SafeBag.getInstance(aSN1Sequence.getObjectAt(i3));
                            if (c5138SafeBag.getBagId().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.pkcs8ShroudedKeyBag)) {
                                zProcessShroudedKeyBag = processShroudedKeyBag(c5138SafeBag, cArr, z);
                                z3 = false;
                            } else if (c5138SafeBag.getBagId().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.f18491certBag)) {
                                vector.addElement(c5138SafeBag);
                            } else if (c5138SafeBag.getBagId().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.f18500keyBag)) {
                                processKeyBag(c5138SafeBag);
                            } else {
                                PrintStream printStream = System.out;
                                printStream.println("extra in data " + c5138SafeBag.getBagId());
                                printStream.println(ASN1Dump.dumpAsString(c5138SafeBag));
                            }
                        }
                    } else if (contentInfo[i2].getContentType().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.encryptedData)) {
                        EncryptedData encryptedData = EncryptedData.getInstance(PKCS12Util.getContent(contentInfo[i2]));
                        ASN1Sequence aSN1Sequence2 = ASN1Sequence.getInstance(cryptData(false, encryptedData.getEncryptionAlgorithm(), cArr, z, PKCS12Util.getEncryptedContent(encryptedData).getOctets()));
                        for (int i4 = 0; i4 != aSN1Sequence2.mo14450size(); i4++) {
                            C5138SafeBag c5138SafeBag2 = C5138SafeBag.getInstance(aSN1Sequence2.getObjectAt(i4));
                            if (c5138SafeBag2.getBagId().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.f18491certBag)) {
                                vector.addElement(c5138SafeBag2);
                            } else if (c5138SafeBag2.getBagId().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.pkcs8ShroudedKeyBag)) {
                                zProcessShroudedKeyBag = processShroudedKeyBag(c5138SafeBag2, cArr, z);
                            } else if (c5138SafeBag2.getBagId().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.f18500keyBag)) {
                                processKeyBag(c5138SafeBag2);
                            } else {
                                PrintStream printStream2 = System.out;
                                printStream2.println("extra in encryptedData " + c5138SafeBag2.getBagId());
                                printStream2.println(ASN1Dump.dumpAsString(c5138SafeBag2));
                            }
                        }
                        z3 = false;
                    } else {
                        PrintStream printStream3 = System.out;
                        printStream3.println("extra " + contentInfo[i2].getContentType().m14433getId());
                        printStream3.println("extra " + ASN1Dump.dumpAsString(PKCS12Util.getContent(contentInfo[i2])));
                    }
                }
            } else {
                z3 = true;
                zProcessShroudedKeyBag = false;
            }
            this.f21759certs = new IgnoresCaseHashtable();
            this.chainCerts = new Hashtable();
            this.keyCerts = new Hashtable();
            int i5 = 0;
            while (i5 != vector.size()) {
                C5138SafeBag c5138SafeBag3 = (C5138SafeBag) vector.elementAt(i5);
                C5135CertBag c5135CertBag = C5135CertBag.getInstance(c5138SafeBag3.getBagValue());
                if (!c5135CertBag.getCertId().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.x509Certificate)) {
                    throw new RuntimeException("Unsupported certificate type: " + c5135CertBag.getCertId());
                }
                try {
                    ?? GenerateCertificate = this.certFact.generateCertificate(new ByteArrayInputStream(((ASN1OctetString) c5135CertBag.getCertValue()).getOctets()));
                    if (c5138SafeBag3.getBagAttributes() != null) {
                        Enumeration objects = c5138SafeBag3.getBagAttributes().getObjects();
                        Object obj = c56751;
                        string = obj;
                        while (objects.hasMoreElements()) {
                            ASN1Sequence aSN1Sequence3 = ASN1Sequence.getInstance(objects.nextElement());
                            ASN1ObjectIdentifier aSN1ObjectIdentifier = ASN1ObjectIdentifier.getInstance(aSN1Sequence3.getObjectAt(0));
                            AbstractC5093ASN1Set abstractC5093ASN1Set = AbstractC5093ASN1Set.getInstance(aSN1Sequence3.getObjectAt(1));
                            if (abstractC5093ASN1Set.m14454size() > 0) {
                                ASN1Primitive aSN1Primitive = (ASN1Primitive) abstractC5093ASN1Set.getObjectAt(0);
                                if (GenerateCertificate instanceof PKCS12BagAttributeCarrier) {
                                    PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier = (PKCS12BagAttributeCarrier) GenerateCertificate;
                                    ASN1Encodable bagAttribute = pKCS12BagAttributeCarrier.getBagAttribute(aSN1ObjectIdentifier);
                                    if (bagAttribute != null) {
                                        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.pkcs_9_at_localKeyId)) {
                                            String hexString = C6255Hex.toHexString(((ASN1OctetString) aSN1Primitive).getOctets());
                                            if (this.f21762keys.f21766keys.containsKey(hexString) || this.localIds.f21766keys.containsKey(hexString)) {
                                            }
                                        }
                                        if (!bagAttribute.toASN1Primitive().m14446equals(aSN1Primitive)) {
                                            throw new IOException("attempt to add existing attribute with different value");
                                        }
                                    } else {
                                        enumeration = objects;
                                        if (abstractC5093ASN1Set.m14454size() > 1) {
                                            pKCS12BagAttributeCarrier.setBagAttribute(aSN1ObjectIdentifier, abstractC5093ASN1Set);
                                        } else {
                                            pKCS12BagAttributeCarrier.setBagAttribute(aSN1ObjectIdentifier, aSN1Primitive);
                                        }
                                        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.pkcs_9_at_friendlyName)) {
                                            obj = obj;
                                            if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.pkcs_9_at_localKeyId)) {
                                                obj = (ASN1OctetString) aSN1Primitive;
                                            }
                                        } else {
                                            string = ((ASN1BMPString) aSN1Primitive).getString();
                                            obj = obj;
                                        }
                                    }
                                }
                                enumeration = objects;
                                if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.pkcs_9_at_friendlyName)) {
                                }
                            } else {
                                enumeration = objects;
                                obj = obj;
                            }
                            objects = enumeration;
                        }
                        r5 = obj;
                    } else {
                        r5 = 0;
                        string = null;
                    }
                    this.chainCerts.put(new C5676CertId(GenerateCertificate.getPublicKey()), GenerateCertificate);
                    if (!zProcessShroudedKeyBag) {
                        if (r5 != 0) {
                            this.keyCerts.put(new String(C6255Hex.m18343encode(r5.getOctets())), GenerateCertificate);
                        }
                        if (string != null) {
                            this.f21759certs.m16168put(string, GenerateCertificate);
                        }
                    } else if (this.keyCerts.isEmpty()) {
                        String str = new String(C6255Hex.m18343encode(createSubjectKeyId(GenerateCertificate.getPublicKey()).getKeyIdentifier()));
                        this.keyCerts.put(str, GenerateCertificate);
                        IgnoresCaseHashtable ignoresCaseHashtable = this.f21762keys;
                        ignoresCaseHashtable.m16168put(str, ignoresCaseHashtable.m16169remove("unmarked"));
                    }
                    i5++;
                    c56751 = null;
                } catch (Exception e3) {
                    throw new RuntimeException(e3.toString());
                }
            }
            if (z2 && z3 && cArr != null && cArr.length != 0 && !Properties.isOverrideSet("org.bouncycastle.pkcs12.ignore_useless_passwd")) {
                throw new IOException("password supplied for keystore that does not require one");
            }
        } catch (Exception e4) {
            throw new IOException(e4.getMessage());
        }
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineProbe(InputStream inputStream) {
        return false;
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
        if (this.f21762keys.m16166get(str) == null) {
            this.f21759certs.m16168put(str, certificate);
            this.chainCerts.put(new C5676CertId(certificate.getPublicKey()), certificate);
        } else {
            throw new KeyStoreException("There is a key entry with the name " + str + ".");
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
        if (!(key instanceof PrivateKey)) {
            throw new KeyStoreException("PKCS12 does not support non-PrivateKeys");
        }
        if ((key instanceof PrivateKey) && certificateArr == null) {
            throw new KeyStoreException("no certificate chain for private key");
        }
        if (this.f21762keys.m16166get(str) != null) {
            engineDeleteEntry(str);
        }
        this.f21762keys.m16168put(str, key);
        if (certificateArr != null) {
            this.f21759certs.m16168put(str, certificateArr[0]);
            for (int i = 0; i != certificateArr.length; i++) {
                this.chainCerts.put(new C5676CertId(certificateArr[i].getPublicKey()), certificateArr[i]);
            }
        }
    }

    @Override // java.security.KeyStoreSpi
    public int engineSize() {
        Hashtable hashtable = new Hashtable();
        Enumeration enumerationM16167keys = this.f21759certs.m16167keys();
        while (enumerationM16167keys.hasMoreElements()) {
            hashtable.put(enumerationM16167keys.nextElement(), "cert");
        }
        Enumeration enumerationM16167keys2 = this.f21762keys.m16167keys();
        while (enumerationM16167keys2.hasMoreElements()) {
            String str = (String) enumerationM16167keys2.nextElement();
            if (hashtable.get(str) == null) {
                hashtable.put(str, "key");
            }
        }
        return hashtable.size();
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(OutputStream outputStream, char[] cArr) throws NoSuchAlgorithmException, SignatureException, IOException, InvalidKeyException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException {
        m16161doStore(outputStream, cArr, true, true);
    }

    @Override // org.bouncycastle.p281jce.interfaces.BCKeyStore
    public void setRandom(SecureRandom secureRandom) {
        this.f21763random = secureRandom;
    }

    public PrivateKey unwrapKey(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, char[] cArr, boolean z) throws InvalidKeyException, IOException, InvalidAlgorithmParameterException {
        ASN1ObjectIdentifier algorithm = algorithmIdentifier.getAlgorithm();
        try {
            if (algorithm.m14435on(PKCSObjectIdentifiers.pkcs_12PbeIds)) {
                PKCS12PBEParams pKCS12PBEParams = PKCS12PBEParams.getInstance(algorithmIdentifier.getParameters());
                PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(pKCS12PBEParams.m14636getIV(), PKCS12Util.validateIterationCount(pKCS12PBEParams.getIterations()));
                Cipher cipherCreateCipher = this.f21760helper.createCipher(algorithm.m14433getId());
                cipherCreateCipher.init(4, new PKCS12Key(cArr, z), pBEParameterSpec);
                return (PrivateKey) cipherCreateCipher.unwrap(bArr, BuildConfig.f24315FLAVOR, 2);
            }
            if (algorithm.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.id_PBES2)) {
                return (PrivateKey) createCipher(4, cArr, algorithmIdentifier).unwrap(bArr, BuildConfig.f24315FLAVOR, 2);
            }
            throw new IOException("exception unwrapping private key - cannot recognise: " + algorithm);
        } catch (InvalidKeyException e) {
            throw Exceptions.ioException("exception unwrapping private key:" + e.getMessage(), new UnrecoverableKeyException(e.toString()));
        } catch (Exception e2) {
            throw Exceptions.ioException("exception unwrapping private key: " + e2.getMessage(), e2);
        }
    }

    /* renamed from: wrapKey */
    public byte[] m16163wrapKey(String str, Key key, PKCS12PBEParams pKCS12PBEParams, char[] cArr) throws InvalidKeyException, IOException, InvalidAlgorithmParameterException {
        PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr);
        try {
            SecretKeyFactory secretKeyFactoryCreateSecretKeyFactory = this.f21760helper.createSecretKeyFactory(str);
            PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(pKCS12PBEParams.m14636getIV(), PKCS12Util.validateIterationCount(pKCS12PBEParams.getIterations()));
            Cipher cipherCreateCipher = this.f21760helper.createCipher(str);
            cipherCreateCipher.init(3, secretKeyFactoryCreateSecretKeyFactory.generateSecret(pBEKeySpec), pBEParameterSpec);
            return cipherCreateCipher.wrap(key);
        } catch (Exception e) {
            throw new IOException("exception encrypting data - " + e.toString());
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineLoad(KeyStore.LoadStoreParameter loadStoreParameter) throws IOException, InvalidKeyException, CertificateException, InvalidAlgorithmParameterException {
        this.useISO8859d1ForDecryption = false;
        if (loadStoreParameter == null) {
            engineLoad(null, null);
            return;
        }
        if (!(loadStoreParameter instanceof BCLoadStoreParameter)) {
            throw new IllegalArgumentException("no support for 'param' of type " + loadStoreParameter.getClass().getName());
        }
        BCLoadStoreParameter bCLoadStoreParameter = (BCLoadStoreParameter) loadStoreParameter;
        if (bCLoadStoreParameter instanceof PKCS12LoadStoreParameter) {
            this.useISO8859d1ForDecryption = ((PKCS12LoadStoreParameter) bCLoadStoreParameter).useISO8859d1ForDecryption();
        }
        engineLoad(bCLoadStoreParameter.getInputStream(), ParameterUtil.extractPassword(loadStoreParameter));
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) {
        throw new RuntimeException("operation not supported");
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(KeyStore.LoadStoreParameter loadStoreParameter) throws NoSuchAlgorithmException, SignatureException, IOException, InvalidKeyException, CertificateException, NoSuchProviderException, InvalidAlgorithmParameterException {
        PKCS12StoreParameter pKCS12StoreParameter;
        char[] password;
        if (loadStoreParameter == null) {
            throw new IllegalArgumentException("'param' arg cannot be null");
        }
        boolean z = loadStoreParameter instanceof PKCS12StoreParameter;
        if (!z && !(loadStoreParameter instanceof JDKPKCS12StoreParameter)) {
            throw new IllegalArgumentException("No support for 'param' of type " + loadStoreParameter.getClass().getName());
        }
        if (z) {
            pKCS12StoreParameter = (PKCS12StoreParameter) loadStoreParameter;
        } else {
            JDKPKCS12StoreParameter jDKPKCS12StoreParameter = (JDKPKCS12StoreParameter) loadStoreParameter;
            pKCS12StoreParameter = new PKCS12StoreParameter(jDKPKCS12StoreParameter.getOutputStream(), loadStoreParameter.getProtectionParameter(), jDKPKCS12StoreParameter.isUseDEREncoding(), jDKPKCS12StoreParameter.isOverwriteFriendlyName());
        }
        KeyStore.ProtectionParameter protectionParameter = loadStoreParameter.getProtectionParameter();
        if (protectionParameter == null) {
            password = null;
        } else {
            if (!(protectionParameter instanceof KeyStore.PasswordProtection)) {
                throw new IllegalArgumentException("No support for protection parameter of type " + protectionParameter.getClass().getName());
            }
            password = ((KeyStore.PasswordProtection) protectionParameter).getPassword();
        }
        if (pKCS12StoreParameter.getMacAlgorithm().getAlgorithm().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.id_PBMAC1)) {
            AlgorithmIdentifier macAlgorithm = pKCS12StoreParameter.getMacAlgorithm();
            this.macAlgorithm = macAlgorithm;
            PBMAC1Params pBMAC1Params = PBMAC1Params.getInstance(macAlgorithm.getParameters());
            AlgorithmIdentifier keyDerivationFunc = pBMAC1Params.getKeyDerivationFunc();
            pBMAC1Params.getMessageAuthScheme();
            if (!keyDerivationFunc.getAlgorithm().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.id_PBKDF2)) {
                throw new IOException("No support for KDF parameter of type " + keyDerivationFunc.getAlgorithm().toString());
            }
        }
        m16161doStore(pKCS12StoreParameter.getOutputStream(), password, pKCS12StoreParameter.isForDEREncoding(), pKCS12StoreParameter.isOverwriteFriendlyName());
    }

    /* renamed from: wrapKey */
    public byte[] m16164wrapKey(AlgorithmIdentifier algorithmIdentifier, Key key, char[] cArr) throws IOException {
        try {
            return createCipher(3, cArr, algorithmIdentifier).wrap(key);
        } catch (Exception e) {
            throw new IOException("exception encrypting data - " + e.toString());
        }
    }
}
