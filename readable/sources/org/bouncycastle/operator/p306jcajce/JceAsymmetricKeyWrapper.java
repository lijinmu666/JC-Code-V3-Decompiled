package org.bouncycastle.operator.p306jcajce;

import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.ProviderException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.operator.AsymmetricKeyWrapper;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OperatorException;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.cryptopro.Gost2814789EncryptedKey;
import org.bouncycastle.p133asn1.cryptopro.GostR3410KeyTransport;
import org.bouncycastle.p133asn1.cryptopro.GostR3410TransportParameters;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.RSAESOAEPparams;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p133asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p249jcajce.p279spec.GOST28147WrapParameterSpec;
import org.bouncycastle.p249jcajce.p279spec.UserKeyingMaterialSpec;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;
import org.bouncycastle.p314pqc.p316crypto.p330sphincs.SPHINCSKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyParameters;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class JceAsymmetricKeyWrapper extends AsymmetricKeyWrapper {

    /* renamed from: digests */
    private static final Map f22907digests;
    private static final Set gostAlgs;
    private Map extraMappings;

    /* renamed from: helper */
    private OperatorHelper f22908helper;
    private PublicKey publicKey;

    /* renamed from: random */
    private SecureRandom f22909random;

    static {
        HashSet hashSet = new HashSet();
        gostAlgs = hashSet;
        hashSet.add(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_ESDH);
        hashSet.add(CryptoProObjectIdentifiers.gostR3410_2001);
        hashSet.add(RosstandartObjectIdentifiers.id_tc26_agreement_gost_3410_12_256);
        hashSet.add(RosstandartObjectIdentifiers.id_tc26_agreement_gost_3410_12_512);
        hashSet.add(RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256);
        hashSet.add(RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512);
        HashMap map = new HashMap();
        f22907digests = map;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = OIWObjectIdentifiers.f18459idSHA1;
        C5103DERNull c5103DERNull = C5103DERNull.INSTANCE;
        map.put("SHA1", new AlgorithmIdentifier(aSN1ObjectIdentifier, c5103DERNull));
        map.put("SHA-1", new AlgorithmIdentifier(aSN1ObjectIdentifier, c5103DERNull));
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_sha224;
        map.put("SHA224", new AlgorithmIdentifier(aSN1ObjectIdentifier2, c5103DERNull));
        map.put("SHA-224", new AlgorithmIdentifier(aSN1ObjectIdentifier2, c5103DERNull));
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_sha256;
        map.put("SHA256", new AlgorithmIdentifier(aSN1ObjectIdentifier3, c5103DERNull));
        map.put(XMSSKeyParameters.f23621SHA_256, new AlgorithmIdentifier(aSN1ObjectIdentifier3, c5103DERNull));
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NISTObjectIdentifiers.id_sha384;
        map.put("SHA384", new AlgorithmIdentifier(aSN1ObjectIdentifier4, c5103DERNull));
        map.put("SHA-384", new AlgorithmIdentifier(aSN1ObjectIdentifier4, c5103DERNull));
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = NISTObjectIdentifiers.id_sha512;
        map.put("SHA512", new AlgorithmIdentifier(aSN1ObjectIdentifier5, c5103DERNull));
        map.put(XMSSKeyParameters.f23622SHA_512, new AlgorithmIdentifier(aSN1ObjectIdentifier5, c5103DERNull));
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = NISTObjectIdentifiers.id_sha512_224;
        map.put("SHA512/224", new AlgorithmIdentifier(aSN1ObjectIdentifier6, c5103DERNull));
        map.put("SHA-512/224", new AlgorithmIdentifier(aSN1ObjectIdentifier6, c5103DERNull));
        map.put("SHA-512(224)", new AlgorithmIdentifier(aSN1ObjectIdentifier6, c5103DERNull));
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = NISTObjectIdentifiers.id_sha512_256;
        map.put("SHA512/256", new AlgorithmIdentifier(aSN1ObjectIdentifier7, c5103DERNull));
        map.put(SPHINCSKeyParameters.SHA512_256, new AlgorithmIdentifier(aSN1ObjectIdentifier7, c5103DERNull));
        map.put("SHA-512(256)", new AlgorithmIdentifier(aSN1ObjectIdentifier7, c5103DERNull));
    }

    public JceAsymmetricKeyWrapper(AlgorithmParameters algorithmParameters, PublicKey publicKey) {
        super(extractAlgID(publicKey, algorithmParameters.getParameterSpec(AlgorithmParameterSpec.class)));
        this.f22908helper = new OperatorHelper(new DefaultJcaJceHelper());
        this.extraMappings = new HashMap();
        this.publicKey = publicKey;
    }

    private static AlgorithmIdentifier extractAlgID(PublicKey publicKey, AlgorithmParameterSpec algorithmParameterSpec) {
        if (!(algorithmParameterSpec instanceof OAEPParameterSpec)) {
            throw new IllegalArgumentException("unknown spec: " + algorithmParameterSpec.getClass().getName());
        }
        OAEPParameterSpec oAEPParameterSpec = (OAEPParameterSpec) algorithmParameterSpec;
        if (!oAEPParameterSpec.getMGFAlgorithm().equals(OAEPParameterSpec.DEFAULT.getMGFAlgorithm())) {
            throw new IllegalArgumentException("unknown MGF: " + oAEPParameterSpec.getMGFAlgorithm());
        }
        if (oAEPParameterSpec.getPSource() instanceof PSource.PSpecified) {
            return new AlgorithmIdentifier(PKCSObjectIdentifiers.id_RSAES_OAEP, new RSAESOAEPparams(getDigest(oAEPParameterSpec.getDigestAlgorithm()), new AlgorithmIdentifier(PKCSObjectIdentifiers.f18498id_mgf1, getDigest(((MGF1ParameterSpec) oAEPParameterSpec.getMGFParameters()).getDigestAlgorithm())), new AlgorithmIdentifier(PKCSObjectIdentifiers.id_pSpecified, new DEROctetString(((PSource.PSpecified) oAEPParameterSpec.getPSource()).getValue()))));
        }
        throw new IllegalArgumentException("unknown PSource: " + oAEPParameterSpec.getPSource().getAlgorithm());
    }

    private static AlgorithmIdentifier getDigest(String str) {
        AlgorithmIdentifier algorithmIdentifier = (AlgorithmIdentifier) f22907digests.get(str);
        if (algorithmIdentifier != null) {
            return algorithmIdentifier;
        }
        throw new IllegalArgumentException("unknown digest name: " + str);
    }

    /* renamed from: isGOST */
    public static boolean m17398isGOST(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return gostAlgs.contains(aSN1ObjectIdentifier);
    }

    @Override // org.bouncycastle.operator.KeyWrapper
    public byte[] generateWrappedKey(GenericKey genericKey) throws IllegalStateException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, OperatorException, InvalidAlgorithmParameterException {
        AlgorithmParameters algorithmParametersCreateAlgorithmParameters;
        if (!m17398isGOST(getAlgorithmIdentifier().getAlgorithm())) {
            Cipher cipherCreateAsymmetricWrapper = this.f22908helper.createAsymmetricWrapper(getAlgorithmIdentifier(), this.extraMappings);
            byte[] bArrWrap = null;
            try {
                algorithmParametersCreateAlgorithmParameters = !getAlgorithmIdentifier().getAlgorithm().m14446equals((ASN1Primitive) OIWObjectIdentifiers.elGamalAlgorithm) ? this.f22908helper.createAlgorithmParameters(getAlgorithmIdentifier()) : null;
                try {
                    if (algorithmParametersCreateAlgorithmParameters != null) {
                        cipherCreateAsymmetricWrapper.init(3, this.publicKey, algorithmParametersCreateAlgorithmParameters, this.f22909random);
                    } else {
                        cipherCreateAsymmetricWrapper.init(3, this.publicKey, this.f22909random);
                    }
                    bArrWrap = cipherCreateAsymmetricWrapper.wrap(OperatorUtils.getJceKey(genericKey));
                } catch (IllegalStateException | UnsupportedOperationException | InvalidKeyException | GeneralSecurityException | ProviderException unused) {
                }
            } catch (IllegalStateException | UnsupportedOperationException | InvalidKeyException | GeneralSecurityException | ProviderException unused2) {
                algorithmParametersCreateAlgorithmParameters = null;
            }
            if (bArrWrap != null) {
                return bArrWrap;
            }
            try {
                if (algorithmParametersCreateAlgorithmParameters != null) {
                    cipherCreateAsymmetricWrapper.init(1, this.publicKey, algorithmParametersCreateAlgorithmParameters, this.f22909random);
                } else {
                    cipherCreateAsymmetricWrapper.init(1, this.publicKey, this.f22909random);
                }
                return cipherCreateAsymmetricWrapper.doFinal(OperatorUtils.getJceKey(genericKey).getEncoded());
            } catch (InvalidKeyException e) {
                throw new OperatorException("unable to encrypt contents key", e);
            } catch (GeneralSecurityException e2) {
                throw new OperatorException("unable to encrypt contents key", e2);
            }
        }
        try {
            this.f22909random = CryptoServicesRegistrar.getSecureRandom(this.f22909random);
            KeyPairGenerator keyPairGeneratorCreateKeyPairGenerator = this.f22908helper.createKeyPairGenerator(getAlgorithmIdentifier().getAlgorithm());
            keyPairGeneratorCreateKeyPairGenerator.initialize(((ECPublicKey) this.publicKey).getParams(), this.f22909random);
            KeyPair keyPairGenerateKeyPair = keyPairGeneratorCreateKeyPairGenerator.generateKeyPair();
            byte[] bArr = new byte[8];
            this.f22909random.nextBytes(bArr);
            SubjectPublicKeyInfo subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(keyPairGenerateKeyPair.getPublic().getEncoded());
            GostR3410TransportParameters gostR3410TransportParameters = subjectPublicKeyInfo.getAlgorithm().getAlgorithm().m14435on(RosstandartObjectIdentifiers.f18529id_tc26) ? new GostR3410TransportParameters(RosstandartObjectIdentifiers.id_tc26_gost_28147_param_Z, subjectPublicKeyInfo, bArr) : new GostR3410TransportParameters(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_A_ParamSet, subjectPublicKeyInfo, bArr);
            KeyAgreement keyAgreementCreateKeyAgreement = this.f22908helper.createKeyAgreement(getAlgorithmIdentifier().getAlgorithm());
            keyAgreementCreateKeyAgreement.init(keyPairGenerateKeyPair.getPrivate(), new UserKeyingMaterialSpec(gostR3410TransportParameters.m14581getUkm()));
            keyAgreementCreateKeyAgreement.doPhase(this.publicKey, true);
            ASN1ObjectIdentifier aSN1ObjectIdentifier = CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_KeyWrap;
            SecretKey secretKeyGenerateSecret = keyAgreementCreateKeyAgreement.generateSecret(aSN1ObjectIdentifier.m14433getId());
            byte[] encoded = OperatorUtils.getJceKey(genericKey).getEncoded();
            Cipher cipherCreateCipher = this.f22908helper.createCipher(aSN1ObjectIdentifier);
            cipherCreateCipher.init(3, secretKeyGenerateSecret, new GOST28147WrapParameterSpec(gostR3410TransportParameters.getEncryptionParamSet(), gostR3410TransportParameters.m14581getUkm()));
            byte[] bArrWrap2 = cipherCreateCipher.wrap(new SecretKeySpec(encoded, "GOST"));
            return new GostR3410KeyTransport(new Gost2814789EncryptedKey(C6238Arrays.copyOfRange(bArrWrap2, 0, 32), C6238Arrays.copyOfRange(bArrWrap2, 32, 36)), gostR3410TransportParameters).getEncoded();
        } catch (Exception e3) {
            throw new OperatorException("exception wrapping key: " + e3.getMessage(), e3);
        }
    }

    public JceAsymmetricKeyWrapper setAlgorithmMapping(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        this.extraMappings.put(aSN1ObjectIdentifier, str);
        return this;
    }

    public JceAsymmetricKeyWrapper setProvider(String str) {
        this.f22908helper = new OperatorHelper(new NamedJcaJceHelper(str));
        return this;
    }

    public JceAsymmetricKeyWrapper setSecureRandom(SecureRandom secureRandom) {
        this.f22909random = secureRandom;
        return this;
    }

    public JceAsymmetricKeyWrapper(PublicKey publicKey) {
        super(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()).getAlgorithm());
        this.f22908helper = new OperatorHelper(new DefaultJcaJceHelper());
        this.extraMappings = new HashMap();
        this.publicKey = publicKey;
    }

    public JceAsymmetricKeyWrapper setProvider(Provider provider) {
        this.f22908helper = new OperatorHelper(new ProviderJcaJceHelper(provider));
        return this;
    }

    public JceAsymmetricKeyWrapper(X509Certificate x509Certificate) {
        this(x509Certificate.getPublicKey());
    }

    public JceAsymmetricKeyWrapper(AlgorithmParameterSpec algorithmParameterSpec, PublicKey publicKey) {
        super(extractAlgID(publicKey, algorithmParameterSpec));
        this.f22908helper = new OperatorHelper(new DefaultJcaJceHelper());
        this.extraMappings = new HashMap();
        this.publicKey = publicKey;
    }

    public JceAsymmetricKeyWrapper(AlgorithmIdentifier algorithmIdentifier, PublicKey publicKey) {
        super(algorithmIdentifier);
        this.f22908helper = new OperatorHelper(new DefaultJcaJceHelper());
        this.extraMappings = new HashMap();
        this.publicKey = publicKey;
    }
}
