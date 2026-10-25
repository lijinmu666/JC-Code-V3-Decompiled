package org.bouncycastle.p191cms.p193jcajce;

import java.io.IOException;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.operator.AsymmetricKeyUnwrapper;
import org.bouncycastle.operator.DefaultSecretKeySizeProvider;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.SecretKeySizeProvider;
import org.bouncycastle.operator.SymmetricKeyUnwrapper;
import org.bouncycastle.operator.p306jcajce.JceAsymmetricKeyUnwrapper;
import org.bouncycastle.operator.p306jcajce.JceKTSKeyUnwrapper;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1Null;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.p139cms.CMSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PBKDF2Params;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.RC2CBCParameter;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p191cms.CMSAlgorithm;
import org.bouncycastle.p191cms.CMSEnvelopedGenerator;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p191cms.PasswordRecipient;
import org.bouncycastle.p194crypto.generators.HKDFBytesGenerator;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p194crypto.p213params.HKDFParameters;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class EnvelopedDataHelper {
    protected static final Map BASE_CIPHER_NAMES;
    protected static final Map CIPHER_ALG_NAMES;
    protected static final Map MAC_ALG_NAMES;
    private static final Map PBKDF2_ALG_NAMES;
    private static final Set authEnvelopedAlgorithms;

    /* renamed from: rc2Ekb */
    private static final short[] f19060rc2Ekb;
    private static final short[] rc2Table;

    /* renamed from: helper */
    private JcaJceExtHelper f19061helper;
    protected static final SecretKeySizeProvider KEY_SIZE_PROVIDER = DefaultSecretKeySizeProvider.INSTANCE;
    private static final byte[] hkdfSalt = C6250Strings.toByteArray("The Cryptographic Message Syntax");

    public interface JCECallback {
        /* renamed from: doInJCE */
        Object mo14921doInJCE();
    }

    static {
        HashSet hashSet = new HashSet();
        authEnvelopedAlgorithms = hashSet;
        HashMap map = new HashMap();
        BASE_CIPHER_NAMES = map;
        HashMap map2 = new HashMap();
        CIPHER_ALG_NAMES = map2;
        HashMap map3 = new HashMap();
        MAC_ALG_NAMES = map3;
        HashMap map4 = new HashMap();
        PBKDF2_ALG_NAMES = map4;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = CMSAlgorithm.f18927DES_CBC;
        map.put(aSN1ObjectIdentifier, "DES");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = CMSAlgorithm.DES_EDE3_CBC;
        map.put(aSN1ObjectIdentifier2, "DESEDE");
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = CMSAlgorithm.AES128_CBC;
        map.put(aSN1ObjectIdentifier3, "AES");
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = CMSAlgorithm.AES192_CBC;
        map.put(aSN1ObjectIdentifier4, "AES");
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = CMSAlgorithm.AES256_CBC;
        map.put(aSN1ObjectIdentifier5, "AES");
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = CMSAlgorithm.f18929RC2_CBC;
        map.put(aSN1ObjectIdentifier6, "RC2");
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = CMSAlgorithm.CAST5_CBC;
        map.put(aSN1ObjectIdentifier7, "CAST5");
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = CMSAlgorithm.CAMELLIA128_CBC;
        map.put(aSN1ObjectIdentifier8, "Camellia");
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = CMSAlgorithm.CAMELLIA192_CBC;
        map.put(aSN1ObjectIdentifier9, "Camellia");
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = CMSAlgorithm.CAMELLIA256_CBC;
        map.put(aSN1ObjectIdentifier10, "Camellia");
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = CMSAlgorithm.SEED_CBC;
        map.put(aSN1ObjectIdentifier11, "SEED");
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = PKCSObjectIdentifiers.f18510rc4;
        map.put(aSN1ObjectIdentifier12, "RC4");
        map.put(CryptoProObjectIdentifiers.gostR28147_gcfb, "GOST28147");
        map2.put(aSN1ObjectIdentifier, "DES/CBC/PKCS5Padding");
        map2.put(aSN1ObjectIdentifier6, "RC2/CBC/PKCS5Padding");
        map2.put(aSN1ObjectIdentifier2, "DESEDE/CBC/PKCS5Padding");
        map2.put(aSN1ObjectIdentifier3, "AES/CBC/PKCS5Padding");
        map2.put(aSN1ObjectIdentifier4, "AES/CBC/PKCS5Padding");
        map2.put(aSN1ObjectIdentifier5, "AES/CBC/PKCS5Padding");
        map2.put(PKCSObjectIdentifiers.rsaEncryption, "RSA/ECB/PKCS1Padding");
        map2.put(aSN1ObjectIdentifier7, "CAST5/CBC/PKCS5Padding");
        map2.put(aSN1ObjectIdentifier8, "Camellia/CBC/PKCS5Padding");
        map2.put(aSN1ObjectIdentifier9, "Camellia/CBC/PKCS5Padding");
        map2.put(aSN1ObjectIdentifier10, "Camellia/CBC/PKCS5Padding");
        map2.put(aSN1ObjectIdentifier11, "SEED/CBC/PKCS5Padding");
        map2.put(aSN1ObjectIdentifier12, "RC4");
        map3.put(aSN1ObjectIdentifier2, "DESEDEMac");
        map3.put(aSN1ObjectIdentifier3, "AESMac");
        map3.put(aSN1ObjectIdentifier4, "AESMac");
        map3.put(aSN1ObjectIdentifier5, "AESMac");
        map3.put(aSN1ObjectIdentifier6, "RC2Mac");
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = CMSAlgorithm.ChaCha20Poly1305;
        map3.put(aSN1ObjectIdentifier13, "ChaCha20Poly1305Mac");
        map4.put(PasswordRecipient.C5237PRF.HMacSHA1.getAlgorithmID(), "PBKDF2WITHHMACSHA1");
        map4.put(PasswordRecipient.C5237PRF.HMacSHA224.getAlgorithmID(), "PBKDF2WITHHMACSHA224");
        map4.put(PasswordRecipient.C5237PRF.HMacSHA256.getAlgorithmID(), "PBKDF2WITHHMACSHA256");
        map4.put(PasswordRecipient.C5237PRF.HMacSHA384.getAlgorithmID(), "PBKDF2WITHHMACSHA384");
        map4.put(PasswordRecipient.C5237PRF.HMacSHA512.getAlgorithmID(), "PBKDF2WITHHMACSHA512");
        hashSet.add(CMSAlgorithm.AES128_GCM);
        hashSet.add(CMSAlgorithm.AES192_GCM);
        hashSet.add(CMSAlgorithm.AES256_GCM);
        hashSet.add(CMSAlgorithm.AES128_CCM);
        hashSet.add(CMSAlgorithm.AES192_CCM);
        hashSet.add(CMSAlgorithm.AES256_CCM);
        hashSet.add(aSN1ObjectIdentifier13);
        rc2Table = new short[]{189, 86, 234, 242, 162, 241, 172, 42, 176, 147, 209, 156, 27, 51, 253, 208, 48, 4, 182, 220, 125, 223, 50, 75, 247, 203, 69, 155, 49, 187, 33, 90, 65, 159, 225, 217, 74, 77, 158, 218, 160, 104, 44, 195, 39, 95, 128, 54, 62, 238, 251, 149, 26, 254, 206, 168, 52, 169, 19, 240, 166, 63, 216, 12, 120, 36, 175, 35, 82, 193, 103, 23, 245, 102, 144, 231, 232, 7, 184, 96, 72, 230, 30, 83, 243, 146, 164, 114, 140, 8, 21, 110, 134, 0, 132, 250, 244, 127, 138, 66, 25, 246, 219, 205, 20, 141, 80, 18, 186, 60, 6, 78, 236, 179, 53, 17, 161, 136, 142, 43, 148, 153, 183, 113, 116, 211, 228, 191, 58, 222, 150, 14, 188, 10, 237, 119, 252, 55, 107, 3, 121, 137, 98, 198, 215, 192, 210, 124, 106, 139, 34, 163, 91, 5, 93, 2, 117, 213, 97, 227, 24, 143, 85, 81, 173, 31, 11, 94, 133, 229, 194, 87, 99, 202, 61, 108, 180, 197, 204, 112, 178, 145, 89, 13, 71, 32, 200, 79, 88, 224, 1, 226, 22, 56, 196, 111, 59, 15, 101, 70, 190, 126, 45, 123, 130, 249, 64, 181, 29, 115, 248, 235, 38, 199, 135, 151, 37, 84, 177, 40, 170, 152, 157, 165, 100, 109, 122, 212, 16, 129, 68, 239, 73, 214, 174, 46, 221, 118, 92, 47, 167, 28, 201, 9, 105, 154, 131, 207, 41, 57, 185, 233, 76, 255, 67, 171};
        f19060rc2Ekb = new short[]{93, 190, 155, 139, 17, 153, 110, 77, 89, 243, 133, 166, 63, 183, 131, 197, 228, 115, 107, 58, 104, 90, 192, 71, 160, 100, 52, 12, 241, 208, 82, 165, 185, 30, 150, 67, 65, 216, 212, 44, 219, 248, 7, 119, 42, 202, 235, 239, 16, 28, 22, 13, 56, 114, 47, 137, 193, 249, 128, 196, 109, 174, 48, 61, 206, 32, 99, 254, 230, 26, 199, 184, 80, 232, 36, 23, 252, 37, 111, 187, 106, 163, 68, 83, 217, 162, 1, 171, 188, 182, 31, 152, 238, 154, 167, 45, 79, 158, 142, 172, 224, 198, 73, 70, 41, 244, 148, 138, 175, 225, 91, 195, 179, 123, 87, 209, 124, 156, 237, 135, 64, 140, 226, 203, 147, 20, 201, 97, 46, 229, 204, 246, 94, 168, 92, 214, 117, 141, 98, 149, 88, 105, 118, 161, 74, 181, 85, 9, 120, 51, 130, 215, 221, 121, 245, 27, 11, 222, 38, 33, 40, 116, 4, 151, 86, 223, 60, 240, 55, 57, 220, 255, 6, 164, 234, 66, 8, 218, 180, 113, 176, 207, 18, 122, 78, 250, 108, 29, 132, 0, 200, 127, 145, 69, 170, 43, 194, 177, 143, 213, 186, 242, 173, 25, 178, 103, 54, 247, 15, 10, 146, 125, 227, 157, 233, 144, 62, 35, 39, 102, 19, 236, 129, 21, 189, 34, 191, 159, 126, 169, 81, 75, 76, 251, 2, 211, 112, 134, 49, 231, 59, 5, 3, 84, 96, 72, 101, 24, 210, 205, 95, 50, 136, 14, 53, 253};
    }

    public EnvelopedDataHelper(JcaJceExtHelper jcaJceExtHelper) {
        this.f19061helper = jcaJceExtHelper;
    }

    /* renamed from: execute */
    public static Object m14920execute(JCECallback jCECallback) throws CMSException {
        try {
            return jCECallback.mo14921doInJCE();
        } catch (InvalidAlgorithmParameterException e) {
            throw new CMSException("algorithm parameters invalid.", e);
        } catch (InvalidKeyException e2) {
            throw new CMSException("key invalid in message.", e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new CMSException("can't find algorithm.", e3);
        } catch (NoSuchProviderException e4) {
            throw new CMSException("can't find provider.", e4);
        } catch (InvalidParameterSpecException e5) {
            throw new CMSException("MAC algorithm parameter spec invalid.", e5);
        } catch (NoSuchPaddingException e6) {
            throw new CMSException("required padding not supported.", e6);
        }
    }

    public byte[] calculateDerivedKey(int i, char[] cArr, AlgorithmIdentifier algorithmIdentifier, int i2) throws CMSException {
        JcaJceExtHelper jcaJceExtHelper;
        String str;
        PBKDF2Params pBKDF2Params = PBKDF2Params.getInstance(algorithmIdentifier.getParameters());
        try {
            if (i == 0) {
                jcaJceExtHelper = this.f19061helper;
                str = "PBKDF2with8BIT";
            } else {
                jcaJceExtHelper = this.f19061helper;
                str = (String) PBKDF2_ALG_NAMES.get(pBKDF2Params.m14634getPrf());
            }
            return jcaJceExtHelper.createSecretKeyFactory(str).generateSecret(new PBEKeySpec(cArr, pBKDF2Params.m14635getSalt(), pBKDF2Params.getIterationCount().intValue(), i2)).getEncoded();
        } catch (GeneralSecurityException e) {
            throw new CMSException("Unable to calculate derived key from password: " + e.getMessage(), e);
        }
    }

    public AlgorithmParameterGenerator createAlgorithmParameterGenerator(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String str = (String) BASE_CIPHER_NAMES.get(aSN1ObjectIdentifier);
        if (str != null) {
            try {
                return this.f19061helper.createAlgorithmParameterGenerator(str);
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return this.f19061helper.createAlgorithmParameterGenerator(aSN1ObjectIdentifier.m14433getId());
    }

    public AlgorithmParameters createAlgorithmParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String str = (String) BASE_CIPHER_NAMES.get(aSN1ObjectIdentifier);
        if (str != null) {
            try {
                return this.f19061helper.createAlgorithmParameters(str);
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return this.f19061helper.createAlgorithmParameters(aSN1ObjectIdentifier.m14433getId());
    }

    public JceAsymmetricKeyUnwrapper createAsymmetricUnwrapper(AlgorithmIdentifier algorithmIdentifier, PrivateKey privateKey) {
        return this.f19061helper.createAsymmetricUnwrapper(algorithmIdentifier, CMSUtils.cleanPrivateKey(privateKey));
    }

    public Cipher createCipher(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws CMSException {
        try {
            String str = (String) CIPHER_ALG_NAMES.get(aSN1ObjectIdentifier);
            if (str != null) {
                try {
                    return this.f19061helper.createCipher(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.f19061helper.createCipher(aSN1ObjectIdentifier.m14433getId());
        } catch (GeneralSecurityException e) {
            throw new CMSException("cannot create cipher: " + e.getMessage(), e);
        }
    }

    public Cipher createContentCipher(final Key key, final AlgorithmIdentifier algorithmIdentifier) {
        return (Cipher) m14920execute(new JCECallback(this) { // from class: org.bouncycastle.cms.jcajce.EnvelopedDataHelper.1

            /* renamed from: this$0 */
            final /* synthetic */ EnvelopedDataHelper f19062this$0;

            {
                this.f19062this$0 = this;
            }

            @Override // org.bouncycastle.cms.jcajce.EnvelopedDataHelper.JCECallback
            /* renamed from: doInJCE */
            public Object mo14921doInJCE() throws CMSException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
                Key key2;
                IvParameterSpec ivParameterSpec;
                AlgorithmIdentifier algorithmIdentifier2 = algorithmIdentifier.getAlgorithm().m14446equals((ASN1Primitive) CMSObjectIdentifiers.id_alg_cek_hkdf_sha256) ? AlgorithmIdentifier.getInstance(algorithmIdentifier.getParameters()) : algorithmIdentifier;
                Cipher cipherCreateCipher = this.f19062this$0.createCipher(algorithmIdentifier2.getAlgorithm());
                ASN1Encodable parameters = algorithmIdentifier2.getParameters();
                String strM14433getId = algorithmIdentifier2.getAlgorithm().m14433getId();
                if (parameters != null && !(parameters instanceof ASN1Null)) {
                    try {
                        AlgorithmParameters algorithmParametersCreateAlgorithmParameters = this.f19062this$0.createAlgorithmParameters(algorithmIdentifier2.getAlgorithm());
                        CMSUtils.loadParameters(algorithmParametersCreateAlgorithmParameters, parameters);
                        cipherCreateCipher.init(2, key, algorithmParametersCreateAlgorithmParameters);
                    } catch (NoSuchAlgorithmException e) {
                        if (!strM14433getId.equals(CMSAlgorithm.f18927DES_CBC.m14433getId()) && !strM14433getId.equals(CMSEnvelopedGenerator.DES_EDE3_CBC) && !strM14433getId.equals(CMSEnvelopedGenerator.IDEA_CBC) && !strM14433getId.equals(CMSEnvelopedGenerator.AES128_CBC) && !strM14433getId.equals(CMSEnvelopedGenerator.AES192_CBC) && !strM14433getId.equals(CMSEnvelopedGenerator.AES256_CBC)) {
                            throw e;
                        }
                        key2 = key;
                        ivParameterSpec = new IvParameterSpec(ASN1OctetString.getInstance(parameters).getOctets());
                    }
                } else if (strM14433getId.equals(CMSAlgorithm.f18927DES_CBC.m14433getId()) || strM14433getId.equals(CMSEnvelopedGenerator.DES_EDE3_CBC) || strM14433getId.equals(CMSEnvelopedGenerator.IDEA_CBC) || strM14433getId.equals(CMSEnvelopedGenerator.CAST5_CBC)) {
                    key2 = key;
                    ivParameterSpec = new IvParameterSpec(new byte[8]);
                    cipherCreateCipher.init(2, key2, ivParameterSpec);
                } else {
                    cipherCreateCipher.init(2, key);
                }
                return cipherCreateCipher;
            }
        });
    }

    public Mac createContentMac(final Key key, final AlgorithmIdentifier algorithmIdentifier) {
        return (Mac) m14920execute(new JCECallback(this) { // from class: org.bouncycastle.cms.jcajce.EnvelopedDataHelper.2

            /* renamed from: this$0 */
            final /* synthetic */ EnvelopedDataHelper f19063this$0;

            {
                this.f19063this$0 = this;
            }

            @Override // org.bouncycastle.cms.jcajce.EnvelopedDataHelper.JCECallback
            /* renamed from: doInJCE */
            public Object mo14921doInJCE() throws CMSException, InvalidKeyException, InvalidAlgorithmParameterException {
                Mac macCreateMac = this.f19063this$0.createMac(algorithmIdentifier.getAlgorithm());
                ASN1Encodable parameters = algorithmIdentifier.getParameters();
                if (parameters == null || (parameters instanceof ASN1Null)) {
                    macCreateMac.init(key);
                } else {
                    AlgorithmParameters algorithmParametersCreateAlgorithmParameters = this.f19063this$0.createAlgorithmParameters(algorithmIdentifier.getAlgorithm());
                    CMSUtils.loadParameters(algorithmParametersCreateAlgorithmParameters, parameters);
                    macCreateMac.init(key, algorithmParametersCreateAlgorithmParameters.getParameterSpec(AlgorithmParameterSpec.class));
                }
                return macCreateMac;
            }
        });
    }

    public AsymmetricKeyUnwrapper createKEMUnwrapper(AlgorithmIdentifier algorithmIdentifier, PrivateKey privateKey) {
        return this.f19061helper.createKEMUnwrapper(algorithmIdentifier, CMSUtils.cleanPrivateKey(privateKey));
    }

    public KeyAgreement createKeyAgreement(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws CMSException {
        try {
            String str = (String) BASE_CIPHER_NAMES.get(aSN1ObjectIdentifier);
            if (str != null) {
                try {
                    return this.f19061helper.createKeyAgreement(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.f19061helper.createKeyAgreement(aSN1ObjectIdentifier.m14433getId());
        } catch (GeneralSecurityException e) {
            throw new CMSException("cannot create key agreement: " + e.getMessage(), e);
        }
    }

    public KeyFactory createKeyFactory(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws CMSException {
        try {
            String str = (String) BASE_CIPHER_NAMES.get(aSN1ObjectIdentifier);
            if (str != null) {
                try {
                    return this.f19061helper.createKeyFactory(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.f19061helper.createKeyFactory(aSN1ObjectIdentifier.m14433getId());
        } catch (GeneralSecurityException e) {
            throw new CMSException("cannot create key factory: " + e.getMessage(), e);
        }
    }

    public KeyGenerator createKeyGenerator(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws CMSException {
        try {
            String str = (String) BASE_CIPHER_NAMES.get(aSN1ObjectIdentifier);
            if (str != null) {
                try {
                    return this.f19061helper.createKeyGenerator(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.f19061helper.createKeyGenerator(aSN1ObjectIdentifier.m14433getId());
        } catch (GeneralSecurityException e) {
            throw new CMSException("cannot create key generator: " + e.getMessage(), e);
        }
    }

    public KeyPairGenerator createKeyPairGenerator(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws CMSException {
        try {
            String str = (String) BASE_CIPHER_NAMES.get(aSN1ObjectIdentifier);
            if (str != null) {
                try {
                    return this.f19061helper.createKeyPairGenerator(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.f19061helper.createKeyPairGenerator(aSN1ObjectIdentifier.m14433getId());
        } catch (GeneralSecurityException e) {
            throw new CMSException("cannot create key pair generator: " + e.getMessage(), e);
        }
    }

    public Mac createMac(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws CMSException {
        try {
            String str = (String) MAC_ALG_NAMES.get(aSN1ObjectIdentifier);
            if (str != null) {
                try {
                    return this.f19061helper.createMac(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.f19061helper.createMac(aSN1ObjectIdentifier.m14433getId());
        } catch (GeneralSecurityException e) {
            throw new CMSException("cannot create mac: " + e.getMessage(), e);
        }
    }

    public Cipher createRFC3211Wrapper(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws CMSException {
        String str = (String) BASE_CIPHER_NAMES.get(aSN1ObjectIdentifier);
        if (str == null) {
            throw new CMSException("no name for " + aSN1ObjectIdentifier);
        }
        try {
            return this.f19061helper.createCipher(str + "RFC3211Wrap");
        } catch (GeneralSecurityException e) {
            throw new CMSException("cannot create cipher: " + e.getMessage(), e);
        }
    }

    public SecretKeyFactory createSecretKeyFactory(String str) {
        return this.f19061helper.createSecretKeyFactory(str);
    }

    public SymmetricKeyUnwrapper createSymmetricUnwrapper(AlgorithmIdentifier algorithmIdentifier, SecretKey secretKey) {
        return this.f19061helper.createSymmetricUnwrapper(algorithmIdentifier, secretKey);
    }

    public AlgorithmParameters generateParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, SecretKey secretKey, SecureRandom secureRandom) throws CMSException, InvalidAlgorithmParameterException {
        try {
            AlgorithmParameterGenerator algorithmParameterGeneratorCreateAlgorithmParameterGenerator = createAlgorithmParameterGenerator(aSN1ObjectIdentifier);
            if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) CMSAlgorithm.f18929RC2_CBC)) {
                byte[] bArr = new byte[8];
                secureRandom.nextBytes(bArr);
                try {
                    algorithmParameterGeneratorCreateAlgorithmParameterGenerator.init(new RC2ParameterSpec(secretKey.getEncoded().length * 8, bArr), secureRandom);
                } catch (InvalidAlgorithmParameterException e) {
                    throw new CMSException("parameters generation error: " + e, e);
                }
            }
            return algorithmParameterGeneratorCreateAlgorithmParameterGenerator.generateParameters();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        } catch (GeneralSecurityException e2) {
            throw new CMSException("exception creating algorithm parameter generator: " + e2, e2);
        }
    }

    public AlgorithmIdentifier getAlgorithmIdentifier(ASN1ObjectIdentifier aSN1ObjectIdentifier, AlgorithmParameters algorithmParameters) {
        return new AlgorithmIdentifier(aSN1ObjectIdentifier, algorithmParameters != null ? CMSUtils.extractParameters(algorithmParameters) : C5103DERNull.INSTANCE);
    }

    public String getBaseCipherName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String str = (String) BASE_CIPHER_NAMES.get(aSN1ObjectIdentifier);
        return str == null ? aSN1ObjectIdentifier.m14433getId() : str;
    }

    public Key getJceKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, GenericKey genericKey) {
        if (genericKey.getRepresentation() instanceof Key) {
            return (Key) genericKey.getRepresentation();
        }
        if (genericKey.getRepresentation() instanceof byte[]) {
            return new SecretKeySpec((byte[]) genericKey.getRepresentation(), getBaseCipherName(aSN1ObjectIdentifier));
        }
        throw new IllegalArgumentException("unknown generic key type");
    }

    public boolean isAuthEnveloped(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return authEnvelopedAlgorithms.contains(aSN1ObjectIdentifier);
    }

    public void keySizeCheck(AlgorithmIdentifier algorithmIdentifier, Key key) throws CMSException {
        byte[] encoded;
        int keySize = KEY_SIZE_PROVIDER.getKeySize(algorithmIdentifier);
        if (keySize > 0) {
            try {
                encoded = key.getEncoded();
            } catch (Exception unused) {
                encoded = null;
            }
            if (encoded != null && encoded.length * 8 != keySize) {
                throw new CMSException("Expected key size for algorithm OID not found in recipient.");
            }
        }
    }

    public JceKTSKeyUnwrapper createAsymmetricUnwrapper(AlgorithmIdentifier algorithmIdentifier, PrivateKey privateKey, byte[] bArr, byte[] bArr2) {
        return this.f19061helper.createAsymmetricUnwrapper(algorithmIdentifier, CMSUtils.cleanPrivateKey(privateKey), bArr, bArr2);
    }

    public AlgorithmIdentifier getAlgorithmIdentifier(ASN1ObjectIdentifier aSN1ObjectIdentifier, AlgorithmParameterSpec algorithmParameterSpec) {
        if (algorithmParameterSpec instanceof IvParameterSpec) {
            return new AlgorithmIdentifier(aSN1ObjectIdentifier, new DEROctetString(((IvParameterSpec) algorithmParameterSpec).getIV()));
        }
        if (!(algorithmParameterSpec instanceof RC2ParameterSpec)) {
            throw new IllegalStateException("unknown parameter spec: " + algorithmParameterSpec);
        }
        RC2ParameterSpec rC2ParameterSpec = (RC2ParameterSpec) algorithmParameterSpec;
        int effectiveKeyBits = rC2ParameterSpec.getEffectiveKeyBits();
        if (effectiveKeyBits == -1) {
            return new AlgorithmIdentifier(aSN1ObjectIdentifier, new RC2CBCParameter(rC2ParameterSpec.getIV()));
        }
        int i = effectiveKeyBits;
        if (effectiveKeyBits < 256) {
            i = rc2Table[effectiveKeyBits];
        }
        return new AlgorithmIdentifier(aSN1ObjectIdentifier, new RC2CBCParameter(i, rC2ParameterSpec.getIV()));
    }

    public Key getJceKey(AlgorithmIdentifier algorithmIdentifier, GenericKey genericKey) throws CMSException {
        if (!algorithmIdentifier.getAlgorithm().m14446equals((ASN1Primitive) CMSObjectIdentifiers.id_alg_cek_hkdf_sha256)) {
            return getJceKey(algorithmIdentifier.getAlgorithm(), genericKey);
        }
        byte[] encoded = genericKey.getRepresentation() instanceof Key ? ((Key) genericKey.getRepresentation()).getEncoded() : null;
        if (genericKey.getRepresentation() instanceof byte[]) {
            encoded = (byte[]) genericKey.getRepresentation();
        }
        AlgorithmIdentifier algorithmIdentifier2 = AlgorithmIdentifier.getInstance(algorithmIdentifier.getParameters());
        HKDFBytesGenerator hKDFBytesGenerator = new HKDFBytesGenerator(new SHA256Digest());
        try {
            hKDFBytesGenerator.mo14966init(new HKDFParameters(encoded, hkdfSalt, algorithmIdentifier2.getEncoded(ASN1Encoding.f17902DER)));
            hKDFBytesGenerator.generateBytes(encoded, 0, encoded.length);
            return new SecretKeySpec(encoded, getBaseCipherName(algorithmIdentifier2.getAlgorithm()));
        } catch (IOException e) {
            throw new CMSException("unable to encode enc algorithm parameters", e);
        }
    }

    public Key getJceKey(GenericKey genericKey) {
        if (genericKey.getRepresentation() instanceof Key) {
            return (Key) genericKey.getRepresentation();
        }
        if (genericKey.getRepresentation() instanceof byte[]) {
            return new SecretKeySpec((byte[]) genericKey.getRepresentation(), "ENC");
        }
        throw new IllegalArgumentException("unknown generic key type");
    }
}
