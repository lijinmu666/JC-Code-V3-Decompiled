package org.bouncycastle.p281jce.provider;

import java.security.AccessController;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bouncycastle.internal.p231asn1.p238isara.IsaraObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p135bc.BCObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p194crypto.CryptoServiceConstraintsException;
import org.bouncycastle.p194crypto.CryptoServiceProperties;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p266config.ProviderConfiguration;
import org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AsymmetricKeyInfoConverter;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.ClassUtil;
import org.bouncycastle.p314pqc.p315asn1.PQCObjectIdentifiers;
import org.bouncycastle.p314pqc.p334jcajce.provider.dilithium.DilithiumKeyFactorySpi;
import org.bouncycastle.p314pqc.p334jcajce.provider.p335bike.BIKEKeyFactorySpi;
import org.bouncycastle.p314pqc.p334jcajce.provider.p336cmce.CMCEKeyFactorySpi;
import org.bouncycastle.p314pqc.p334jcajce.provider.p337falcon.FalconKeyFactorySpi;
import org.bouncycastle.p314pqc.p334jcajce.provider.p339hqc.HQCKeyFactorySpi;
import org.bouncycastle.p314pqc.p334jcajce.provider.p340kyber.KyberKeyFactorySpi;
import org.bouncycastle.p314pqc.p334jcajce.provider.p341lms.LMSKeyFactorySpi;
import org.bouncycastle.p314pqc.p334jcajce.provider.p342mayo.MayoKeyFactorySpi;
import org.bouncycastle.p314pqc.p334jcajce.provider.p343newhope.NHKeyFactorySpi;
import org.bouncycastle.p314pqc.p334jcajce.provider.p344ntru.NTRUKeyFactorySpi;
import org.bouncycastle.p314pqc.p334jcajce.provider.p345picnic.PicnicKeyFactorySpi;
import org.bouncycastle.p314pqc.p334jcajce.provider.p347snova.SnovaKeyFactorySpi;
import org.bouncycastle.p314pqc.p334jcajce.provider.p348sphincs.Sphincs256KeyFactorySpi;
import org.bouncycastle.p314pqc.p334jcajce.provider.p350xmss.XMSSKeyFactorySpi;
import org.bouncycastle.p314pqc.p334jcajce.provider.p350xmss.XMSSMTKeyFactorySpi;
import org.bouncycastle.p314pqc.p334jcajce.provider.sphincsplus.SPHINCSPlusKeyFactorySpi;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public final class BouncyCastleProvider extends Provider implements ConfigurableProvider {
    private static final String ASYMMETRIC_PACKAGE = "org.bouncycastle.jcajce.provider.asymmetric.";
    private static final String DIGEST_PACKAGE = "org.bouncycastle.jcajce.provider.digest.";
    private static final String KDF_PACKAGE = "org.bouncycastle.jcajce.provider.kdf.";
    private static final String KEYSTORE_PACKAGE = "org.bouncycastle.jcajce.provider.keystore.";
    private static final String SECURE_RANDOM_PACKAGE = "org.bouncycastle.jcajce.provider.drbg.";
    private static final String SYMMETRIC_PACKAGE = "org.bouncycastle.jcajce.provider.symmetric.";
    private Map<String, Provider.Service> serviceMap;

    /* renamed from: LOG */
    private static final Logger f21976LOG = Logger.getLogger(BouncyCastleProvider.class.getName());

    /* renamed from: info */
    private static String f21977info = "BouncyCastle Security Provider v1.84";
    public static final ProviderConfiguration CONFIGURATION = new BouncyCastleProviderConfiguration();
    private static final Map keyInfoConverters = new HashMap();
    private static final Class revChkClass = ClassUtil.loadClass(BouncyCastleProvider.class, "java.security.cert.PKIXRevocationChecker");
    private static final String[] SYMMETRIC_GENERIC = {"PBEPBKDF1", "PBEPBKDF2", "PBEPKCS12", "TLSKDF", "SCRYPT", "HKDF"};
    private static final String[] SYMMETRIC_MACS = {"SipHash", "SipHash128", "Poly1305"};
    private static final CryptoServiceProperties[] SYMMETRIC_CIPHERS = {m16236service("AES", 256), m16236service("ARC4", 20), m16236service("ARIA", 256), m16236service("Blowfish", 128), m16236service("Camellia", 256), m16236service("CAST5", 128), m16236service("CAST6", 256), m16236service("ChaCha", 128), m16236service("DES", 56), m16236service("DESede", 112), m16236service("GOST28147", 128), m16236service("Grainv1", 128), m16236service("Grain128", 128), m16236service("HC128", 128), m16236service("HC256", 256), m16236service("IDEA", 128), m16236service("Noekeon", 128), m16236service("RC2", 128), m16236service("RC5", 128), m16236service("RC6", 256), m16236service("Rijndael", 256), m16236service("Salsa20", 128), m16236service("SEED", 128), m16236service("Serpent", 256), m16236service("Shacal2", 128), m16236service("Skipjack", 80), m16236service("SM4", 128), m16236service("TEA", 128), m16236service("Twofish", 256), m16236service("Threefish", 128), m16236service("VMPC", 128), m16236service("VMPCKSA3", 128), m16236service("XTEA", 128), m16236service("XSalsa20", 128), m16236service("OpenSSLPBKDF", 128), m16236service("DSTU7624", 256), m16236service("GOST3412_2015", 256), m16236service("Zuc", 128)};
    private static final String[] ASYMMETRIC_GENERIC = {"X509", "IES", "COMPOSITE", "EXTERNAL", "CompositeSignatures", "NoSig"};
    private static final String[] ASYMMETRIC_CIPHERS = {"DSA", "DH", "EC", "RSA", "GOST", "ECGOST", "ElGamal", "DSTU4145", "GM", "EdEC", "LMS", "NTRU", "Falcon", "CONTEXT", "SLHDSA", "MLDSA", "MLKEM", "Dilithium", "SPHINCSPlus"};

    /* renamed from: DIGESTS */
    private static final String[] f21974DIGESTS = {"GOST3411", "Keccak", "MD2", "MD4", "MD5", "SHA1", "RIPEMD128", "RIPEMD160", "RIPEMD256", "RIPEMD320", "SHA224", "SHA256", "SHA384", "SHA512", "SHA3", "Skein", "SM3", "Tiger", "Whirlpool", "Blake2b", "Blake2s", "DSTU7564", "Haraka", "Blake3"};
    public static final String PROVIDER_NAME = "BC";
    private static final String[] KEYSTORES = {PROVIDER_NAME, "BCFKS", "PKCS12"};
    private static final String[] SECURE_RANDOMS = {"DRBG"};

    /* renamed from: KDFS */
    private static final String[] f21975KDFS = {"HKDF", "PBKDF2", "SCRYPT"};

    public static class JcaCryptoService implements CryptoServiceProperties {
        private final int bitsOfSecurity;

        /* renamed from: name */
        private final String f21981name;

        public JcaCryptoService(String str, int i) {
            this.f21981name = str;
            this.bitsOfSecurity = i;
        }

        @Override // org.bouncycastle.p194crypto.CryptoServiceProperties
        public int bitsOfSecurity() {
            return this.bitsOfSecurity;
        }

        @Override // org.bouncycastle.p194crypto.CryptoServiceProperties
        public Object getParams() {
            return null;
        }

        @Override // org.bouncycastle.p194crypto.CryptoServiceProperties
        public CryptoServicePurpose getPurpose() {
            return CryptoServicePurpose.ANY;
        }

        @Override // org.bouncycastle.p194crypto.CryptoServiceProperties
        public String getServiceName() {
            return this.f21981name;
        }
    }

    public BouncyCastleProvider() {
        super(PROVIDER_NAME, 1.84d, f21977info);
        this.serviceMap = new ConcurrentHashMap();
        AccessController.doPrivileged(new PrivilegedAction() { // from class: org.bouncycastle.jce.provider.BouncyCastleProvider.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                BouncyCastleProvider.this.m16237setup();
                return null;
            }
        });
    }

    private static AsymmetricKeyInfoConverter getAsymmetricKeyInfoConverter(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        AsymmetricKeyInfoConverter asymmetricKeyInfoConverter;
        Map map = keyInfoConverters;
        synchronized (map) {
            asymmetricKeyInfoConverter = (AsymmetricKeyInfoConverter) map.get(aSN1ObjectIdentifier);
        }
        return asymmetricKeyInfoConverter;
    }

    public static PrivateKey getPrivateKey(PrivateKeyInfo privateKeyInfo) {
        AsymmetricKeyInfoConverter asymmetricKeyInfoConverter = getAsymmetricKeyInfoConverter(privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm());
        if (asymmetricKeyInfoConverter == null) {
            return null;
        }
        return asymmetricKeyInfoConverter.generatePrivate(privateKeyInfo);
    }

    public static PublicKey getPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        if (subjectPublicKeyInfo.getAlgorithm().getAlgorithm().m14435on(BCObjectIdentifiers.picnic_key)) {
            return new PicnicKeyFactorySpi().generatePublic(subjectPublicKeyInfo);
        }
        AsymmetricKeyInfoConverter asymmetricKeyInfoConverter = getAsymmetricKeyInfoConverter(subjectPublicKeyInfo.getAlgorithm().getAlgorithm());
        if (asymmetricKeyInfoConverter == null) {
            return null;
        }
        return asymmetricKeyInfoConverter.generatePublic(subjectPublicKeyInfo);
    }

    private void loadAlgorithms(String str, String[] strArr) {
        for (int i = 0; i != strArr.length; i++) {
            loadServiceClass(str, strArr[i]);
        }
    }

    private void loadPQCKeys() {
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_sha2_128s_r3, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_sha2_128f_r3, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_shake_128s_r3, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_shake_128f_r3, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_haraka_128s_r3, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_haraka_128f_r3, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_sha2_192s_r3, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_sha2_192f_r3, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_shake_192s_r3, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_shake_192f_r3, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_haraka_192s_r3, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_haraka_192f_r3, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_sha2_256s_r3, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_sha2_256f_r3, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_shake_256s_r3, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_shake_256f_r3, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_haraka_256s_r3, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_haraka_256f_r3, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_sha2_128s_r3_simple, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_sha2_128f_r3_simple, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_shake_128s_r3_simple, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_shake_128f_r3_simple, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_haraka_128s_r3_simple, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_haraka_128f_r3_simple, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_sha2_192s_r3_simple, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_sha2_192f_r3_simple, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_shake_192s_r3_simple, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_shake_192f_r3_simple, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_haraka_192s_r3_simple, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_haraka_192f_r3_simple, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_sha2_256s_r3_simple, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_sha2_256f_r3_simple, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_shake_256s_r3_simple, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_shake_256f_r3_simple, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_haraka_256s_r3_simple, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_haraka_256f_r3_simple, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_sha2_128s, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_sha2_192s, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_sha2_256s, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(new ASN1ObjectIdentifier("1.3.9999.6.4.10"), new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_shake_128f, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_shake_192f, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.sphincsPlus_shake_256f, new SPHINCSPlusKeyFactorySpi());
        addKeyInfoConverter(PQCObjectIdentifiers.sphincs256, new Sphincs256KeyFactorySpi());
        addKeyInfoConverter(PQCObjectIdentifiers.f23021newHope, new NHKeyFactorySpi());
        addKeyInfoConverter(PQCObjectIdentifiers.f23024xmss, new XMSSKeyFactorySpi());
        addKeyInfoConverter(IsaraObjectIdentifiers.id_alg_xmss, new XMSSKeyFactorySpi());
        addKeyInfoConverter(PQCObjectIdentifiers.f23025xmss_mt, new XMSSMTKeyFactorySpi());
        addKeyInfoConverter(IsaraObjectIdentifiers.id_alg_xmssmt, new XMSSMTKeyFactorySpi());
        addKeyInfoConverter(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig, new LMSKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.picnic_key, new PicnicKeyFactorySpi());
        ASN1ObjectIdentifier aSN1ObjectIdentifier = BCObjectIdentifiers.old_falcon_512;
        addKeyInfoConverter(aSN1ObjectIdentifier, new FalconKeyFactorySpi(aSN1ObjectIdentifier));
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = BCObjectIdentifiers.old_falcon_1024;
        addKeyInfoConverter(aSN1ObjectIdentifier2, new FalconKeyFactorySpi(aSN1ObjectIdentifier2));
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = BCObjectIdentifiers.falcon_512;
        addKeyInfoConverter(aSN1ObjectIdentifier3, new FalconKeyFactorySpi(aSN1ObjectIdentifier3));
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = BCObjectIdentifiers.falcon_1024;
        addKeyInfoConverter(aSN1ObjectIdentifier4, new FalconKeyFactorySpi(aSN1ObjectIdentifier4));
        addKeyInfoConverter(BCObjectIdentifiers.dilithium2, new DilithiumKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.dilithium3, new DilithiumKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.dilithium5, new DilithiumKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.dilithium2_aes, new DilithiumKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.dilithium3_aes, new DilithiumKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.dilithium5_aes, new DilithiumKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.mceliece348864_r3, new CMCEKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.mceliece460896_r3, new CMCEKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.mceliece6688128_r3, new CMCEKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.mceliece6960119_r3, new CMCEKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.mceliece8192128_r3, new CMCEKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.f18019bike128, new BIKEKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.f18020bike192, new BIKEKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.f18021bike256, new BIKEKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.f18023hqc128, new HQCKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.f18024hqc192, new HQCKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.f18025hqc256, new HQCKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.kyber512_aes, new KyberKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.kyber768_aes, new KyberKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.kyber1024_aes, new KyberKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.ntruhps2048509, new NTRUKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.ntruhps2048677, new NTRUKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.ntruhps4096821, new NTRUKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.ntruhrss701, new NTRUKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.f18027mayo1, new MayoKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.f18028mayo2, new MayoKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.f18029mayo3, new MayoKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.f18030mayo5, new MayoKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_24_5_4_ssk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_24_5_4_esk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_24_5_4_shake_ssk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_24_5_4_shake_esk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_24_5_5_ssk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_24_5_5_esk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_24_5_5_shake_ssk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_24_5_5_shake_esk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_25_8_3_ssk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_25_8_3_esk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_25_8_3_shake_ssk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_25_8_3_shake_esk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_37_8_4_ssk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_37_8_4_esk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_37_8_4_shake_ssk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_37_8_4_shake_esk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_37_17_2_ssk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_37_17_2_esk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_37_17_2_shake_ssk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_37_17_2_shake_esk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_49_11_3_ssk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_49_11_3_esk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_49_11_3_shake_ssk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_49_11_3_shake_esk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_56_25_2_ssk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_56_25_2_esk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_56_25_2_shake_ssk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_56_25_2_shake_esk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_60_10_4_ssk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_60_10_4_esk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_60_10_4_shake_ssk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_60_10_4_shake_esk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_66_15_3_ssk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_66_15_3_esk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_66_15_3_shake_ssk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_66_15_3_shake_esk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_75_33_2_ssk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_75_33_2_esk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_75_33_2_shake_ssk, new SnovaKeyFactorySpi());
        addKeyInfoConverter(BCObjectIdentifiers.snova_75_33_2_shake_esk, new SnovaKeyFactorySpi());
    }

    private void loadServiceClass(String str, String str2) {
        Class clsLoadClass = ClassUtil.loadClass(BouncyCastleProvider.class, str + str2 + "$Mappings");
        if (clsLoadClass != null) {
            try {
                ((AlgorithmProvider) clsLoadClass.newInstance()).configure(this);
            } catch (Exception e) {
                throw new InternalError("cannot create instance of " + str + str2 + "$Mappings : " + e);
            }
        }
    }

    /* renamed from: service */
    private static CryptoServiceProperties m16236service(String str, int i) {
        return new JcaCryptoService(str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setup */
    public void m16237setup() {
        String str;
        String str2;
        loadAlgorithms(DIGEST_PACKAGE, f21974DIGESTS);
        loadAlgorithms(SYMMETRIC_PACKAGE, SYMMETRIC_GENERIC);
        loadAlgorithms(SYMMETRIC_PACKAGE, SYMMETRIC_MACS);
        loadAlgorithms(SYMMETRIC_PACKAGE, SYMMETRIC_CIPHERS);
        loadAlgorithms(ASYMMETRIC_PACKAGE, ASYMMETRIC_GENERIC);
        loadAlgorithms(ASYMMETRIC_PACKAGE, ASYMMETRIC_CIPHERS);
        loadAlgorithms(KEYSTORE_PACKAGE, KEYSTORES);
        loadAlgorithms(SECURE_RANDOM_PACKAGE, SECURE_RANDOMS);
        loadAlgorithms(KDF_PACKAGE, f21975KDFS);
        loadPQCKeys();
        put("X509Store.CERTIFICATE/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCertCollection");
        put("X509Store.ATTRIBUTECERTIFICATE/COLLECTION", "org.bouncycastle.jce.provider.X509StoreAttrCertCollection");
        put("X509Store.CRL/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCRLCollection");
        put("X509Store.CERTIFICATEPAIR/COLLECTION", "org.bouncycastle.jce.provider.X509StoreCertPairCollection");
        put("X509Store.CERTIFICATE/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCerts");
        put("X509Store.CRL/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCRLs");
        put("X509Store.ATTRIBUTECERTIFICATE/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPAttrCerts");
        put("X509Store.CERTIFICATEPAIR/LDAP", "org.bouncycastle.jce.provider.X509StoreLDAPCertPairs");
        put("X509StreamParser.CERTIFICATE", "org.bouncycastle.jce.provider.X509CertParser");
        put("X509StreamParser.ATTRIBUTECERTIFICATE", "org.bouncycastle.jce.provider.X509AttrCertParser");
        put("X509StreamParser.CRL", "org.bouncycastle.jce.provider.X509CRLParser");
        put("X509StreamParser.CERTIFICATEPAIR", "org.bouncycastle.jce.provider.X509CertPairParser");
        put("Cipher.BROKENPBEWITHMD5ANDDES", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithMD5AndDES");
        put("Cipher.BROKENPBEWITHSHA1ANDDES", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithSHA1AndDES");
        put("Cipher.OLDPBEWITHSHAANDTWOFISH-CBC", "org.bouncycastle.jce.provider.BrokenJCEBlockCipher$OldPBEWithSHAAndTwofish");
        Class cls = revChkClass;
        put("CertPathValidator.RFC3281", "org.bouncycastle.jce.provider.PKIXAttrCertPathValidatorSpi");
        put("CertPathBuilder.RFC3281", "org.bouncycastle.jce.provider.PKIXAttrCertPathBuilderSpi");
        if (cls != null) {
            str = "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi_8";
            put("CertPathValidator.RFC3280", "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi_8");
            str2 = "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi_8";
        } else {
            str = "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi";
            put("CertPathValidator.RFC3280", "org.bouncycastle.jce.provider.PKIXCertPathValidatorSpi");
            str2 = "org.bouncycastle.jce.provider.PKIXCertPathBuilderSpi";
        }
        put("CertPathBuilder.RFC3280", str2);
        put("CertPathValidator.PKIX", str);
        put("CertPathBuilder.PKIX", str2);
        put("CertStore.Collection", "org.bouncycastle.jce.provider.CertStoreCollectionSpi");
        put("CertStore.LDAP", "org.bouncycastle.jce.provider.X509LDAPCertStoreSpi");
        put("CertStore.Multi", "org.bouncycastle.jce.provider.MultiCertStoreSpi");
        put("Alg.Alias.CertStore.X509LDAP", "LDAP");
    }

    @Override // org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider
    public void addAlgorithm(String str, String str2) {
        if (!containsKey(str)) {
            put(str, str2);
            return;
        }
        throw new IllegalStateException("duplicate provider key (" + str + ") found");
    }

    @Override // org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider
    public void addAttributes(String str, Map<String, String> map) {
        put(str + " ImplementedIn", "Software");
        for (String str2 : map.keySet()) {
            String str3 = str + " " + str2;
            if (containsKey(str3)) {
                throw new IllegalStateException("duplicate provider attribute key (" + str3 + ") found");
            }
            put(str3, map.get(str2));
        }
    }

    @Override // org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider
    public void addKeyInfoConverter(ASN1ObjectIdentifier aSN1ObjectIdentifier, AsymmetricKeyInfoConverter asymmetricKeyInfoConverter) {
        Map map = keyInfoConverters;
        synchronized (map) {
            map.put(aSN1ObjectIdentifier, asymmetricKeyInfoConverter);
        }
    }

    @Override // org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider
    public AsymmetricKeyInfoConverter getKeyInfoConverter(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (AsymmetricKeyInfoConverter) keyInfoConverters.get(aSN1ObjectIdentifier);
    }

    @Override // java.security.Provider
    public final Provider.Service getService(final String str, final String str2) {
        final String str3 = str + "." + C6250Strings.toUpperCase(str2);
        Provider.Service service = this.serviceMap.get(str3);
        if (service == null) {
            synchronized (this) {
                try {
                    service = (Provider.Service) (!this.serviceMap.containsKey(str3) ? AccessController.doPrivileged(new PrivilegedAction<Provider.Service>(this) { // from class: org.bouncycastle.jce.provider.BouncyCastleProvider.2

                        /* renamed from: this$0 */
                        final /* synthetic */ BouncyCastleProvider f21979this$0;

                        {
                            this.f21979this$0 = this;
                        }

                        @Override // java.security.PrivilegedAction
                        public Provider.Service run() {
                            Provider.Service service2 = BouncyCastleProvider.super.getService(str, str2);
                            if (service2 == null || service2.getClassName() == null) {
                                return null;
                            }
                            this.f21979this$0.serviceMap.put(str3, service2);
                            BouncyCastleProvider.super.remove(service2.getType() + "." + service2.getAlgorithm());
                            BouncyCastleProvider.super.putService(service2);
                            return service2;
                        }
                    }) : this.serviceMap.get(str3));
                } finally {
                }
            }
        }
        return service;
    }

    @Override // org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider
    public boolean hasAlgorithm(String str, String str2) {
        if (!containsKey(str + "." + str2)) {
            if (!containsKey("Alg.Alias." + str + "." + str2)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider
    public void setParameter(String str, Object obj) {
        ProviderConfiguration providerConfiguration = CONFIGURATION;
        synchronized (providerConfiguration) {
            ((BouncyCastleProviderConfiguration) providerConfiguration).setParameter(str, obj);
        }
    }

    private void loadAlgorithms(String str, CryptoServiceProperties[] cryptoServicePropertiesArr) {
        for (int i = 0; i != cryptoServicePropertiesArr.length; i++) {
            CryptoServiceProperties cryptoServiceProperties = cryptoServicePropertiesArr[i];
            try {
                CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties);
                loadServiceClass(str, cryptoServiceProperties.getServiceName());
            } catch (CryptoServiceConstraintsException unused) {
                Logger logger = f21976LOG;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine("service for " + cryptoServiceProperties.getServiceName() + " ignored due to constraints");
                }
            }
        }
    }

    @Override // org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider
    public void addAlgorithm(String str, String str2, Map<String, String> map) {
        addAlgorithm(str, str2);
        addAttributes(str, map);
    }

    @Override // org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider
    public void addAlgorithm(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str2) {
        addAlgorithm(str + "." + aSN1ObjectIdentifier, str2);
        addAlgorithm(str + ".OID." + aSN1ObjectIdentifier, str2);
    }

    @Override // org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider
    public void addAlgorithm(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str2, Map<String, String> map) {
        addAlgorithm(str, aSN1ObjectIdentifier, str2);
        addAttributes(str + "." + aSN1ObjectIdentifier, map);
        addAttributes(str + ".OID." + aSN1ObjectIdentifier, map);
    }
}
