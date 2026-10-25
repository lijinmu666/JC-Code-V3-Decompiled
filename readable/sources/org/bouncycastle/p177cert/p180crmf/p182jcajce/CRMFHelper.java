package org.bouncycastle.p177cert.p180crmf.p182jcajce;

import java.io.IOException;
import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Null;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.p150iana.IANAObjectIdentifiers;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p177cert.p180crmf.CRMFException;
import org.bouncycastle.p191cms.CMSAlgorithm;
import org.bouncycastle.p249jcajce.p280util.AlgorithmParametersUtils;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;

/* loaded from: classes2.dex */
class CRMFHelper {
    protected static final Map BASE_CIPHER_NAMES;
    protected static final Map CIPHER_ALG_NAMES;
    protected static final Map DIGEST_ALG_NAMES;
    protected static final Map KEY_ALG_NAMES;
    protected static final Map MAC_ALG_NAMES;

    /* renamed from: helper */
    private JcaJceHelper f18852helper;

    public interface JCECallback {
        /* renamed from: doInJCE */
        Object mo14799doInJCE();
    }

    static {
        HashMap map = new HashMap();
        BASE_CIPHER_NAMES = map;
        HashMap map2 = new HashMap();
        CIPHER_ALG_NAMES = map2;
        HashMap map3 = new HashMap();
        DIGEST_ALG_NAMES = map3;
        HashMap map4 = new HashMap();
        KEY_ALG_NAMES = map4;
        HashMap map5 = new HashMap();
        MAC_ALG_NAMES = map5;
        map.put(PKCSObjectIdentifiers.des_EDE3_CBC, "DESEDE");
        map.put(NISTObjectIdentifiers.id_aes128_CBC, "AES");
        map.put(NISTObjectIdentifiers.id_aes192_CBC, "AES");
        map.put(NISTObjectIdentifiers.id_aes256_CBC, "AES");
        map2.put(CMSAlgorithm.DES_EDE3_CBC, "DESEDE/CBC/PKCS5Padding");
        map2.put(CMSAlgorithm.AES128_CBC, "AES/CBC/PKCS5Padding");
        map2.put(CMSAlgorithm.AES192_CBC, "AES/CBC/PKCS5Padding");
        map2.put(CMSAlgorithm.AES256_CBC, "AES/CBC/PKCS5Padding");
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.rsaEncryption;
        map2.put(new ASN1ObjectIdentifier(aSN1ObjectIdentifier.m14433getId()), "RSA/ECB/PKCS1Padding");
        map3.put(OIWObjectIdentifiers.f18459idSHA1, "SHA1");
        map3.put(NISTObjectIdentifiers.id_sha224, "SHA224");
        map3.put(NISTObjectIdentifiers.id_sha256, "SHA256");
        map3.put(NISTObjectIdentifiers.id_sha384, "SHA384");
        map3.put(NISTObjectIdentifiers.id_sha512, "SHA512");
        map5.put(IANAObjectIdentifiers.hmacSHA1, "HMACSHA1");
        map5.put(PKCSObjectIdentifiers.id_hmacWithSHA1, "HMACSHA1");
        map5.put(PKCSObjectIdentifiers.id_hmacWithSHA224, "HMACSHA224");
        map5.put(PKCSObjectIdentifiers.id_hmacWithSHA256, "HMACSHA256");
        map5.put(PKCSObjectIdentifiers.id_hmacWithSHA384, "HMACSHA384");
        map5.put(PKCSObjectIdentifiers.id_hmacWithSHA512, "HMACSHA512");
        map4.put(aSN1ObjectIdentifier, "RSA");
        map4.put(X9ObjectIdentifiers.f18789id_dsa, "DSA");
    }

    public CRMFHelper(JcaJceHelper jcaJceHelper) {
        this.f18852helper = jcaJceHelper;
    }

    /* renamed from: execute */
    public static Object m14798execute(JCECallback jCECallback) throws CRMFException {
        try {
            return jCECallback.mo14799doInJCE();
        } catch (InvalidAlgorithmParameterException e) {
            throw new CRMFException("algorithm parameters invalid.", e);
        } catch (InvalidKeyException e2) {
            throw new CRMFException("key invalid in message.", e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new CRMFException("can't find algorithm.", e3);
        } catch (NoSuchProviderException e4) {
            throw new CRMFException("can't find provider.", e4);
        } catch (InvalidParameterSpecException e5) {
            throw new CRMFException("MAC algorithm parameter spec invalid.", e5);
        } catch (NoSuchPaddingException e6) {
            throw new CRMFException("required padding not supported.", e6);
        }
    }

    public AlgorithmParameterGenerator createAlgorithmParameterGenerator(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String str = (String) BASE_CIPHER_NAMES.get(aSN1ObjectIdentifier);
        if (str != null) {
            try {
                return this.f18852helper.createAlgorithmParameterGenerator(str);
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return this.f18852helper.createAlgorithmParameterGenerator(aSN1ObjectIdentifier.m14433getId());
    }

    public AlgorithmParameters createAlgorithmParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String str = (String) BASE_CIPHER_NAMES.get(aSN1ObjectIdentifier);
        if (str != null) {
            try {
                return this.f18852helper.createAlgorithmParameters(str);
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return this.f18852helper.createAlgorithmParameters(aSN1ObjectIdentifier.m14433getId());
    }

    public Cipher createCipher(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws CRMFException {
        try {
            String str = (String) CIPHER_ALG_NAMES.get(aSN1ObjectIdentifier);
            if (str != null) {
                try {
                    return this.f18852helper.createCipher(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.f18852helper.createCipher(aSN1ObjectIdentifier.m14433getId());
        } catch (GeneralSecurityException e) {
            throw new CRMFException("cannot create cipher: " + e.getMessage(), e);
        }
    }

    public Cipher createContentCipher(final Key key, final AlgorithmIdentifier algorithmIdentifier) {
        return (Cipher) m14798execute(new JCECallback(this) { // from class: org.bouncycastle.cert.crmf.jcajce.CRMFHelper.1

            /* renamed from: this$0 */
            final /* synthetic */ CRMFHelper f18853this$0;

            {
                this.f18853this$0 = this;
            }

            @Override // org.bouncycastle.cert.crmf.jcajce.CRMFHelper.JCECallback
            /* renamed from: doInJCE */
            public Object mo14799doInJCE() throws CRMFException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
                Cipher cipherCreateCipher = this.f18853this$0.createCipher(algorithmIdentifier.getAlgorithm());
                ASN1Primitive aSN1Primitive = (ASN1Primitive) algorithmIdentifier.getParameters();
                ASN1ObjectIdentifier algorithm = algorithmIdentifier.getAlgorithm();
                if (aSN1Primitive != null && !(aSN1Primitive instanceof ASN1Null)) {
                    try {
                        AlgorithmParameters algorithmParametersCreateAlgorithmParameters = this.f18853this$0.createAlgorithmParameters(algorithmIdentifier.getAlgorithm());
                        try {
                            AlgorithmParametersUtils.loadParameters(algorithmParametersCreateAlgorithmParameters, aSN1Primitive);
                            cipherCreateCipher.init(2, key, algorithmParametersCreateAlgorithmParameters);
                        } catch (IOException e) {
                            throw new CRMFException("error decoding algorithm parameters.", e);
                        }
                    } catch (NoSuchAlgorithmException e2) {
                        if (!algorithm.m14446equals((ASN1Primitive) CMSAlgorithm.DES_EDE3_CBC) && !algorithm.m14446equals((ASN1Primitive) CMSAlgorithm.IDEA_CBC) && !algorithm.m14446equals((ASN1Primitive) CMSAlgorithm.AES128_CBC) && !algorithm.m14446equals((ASN1Primitive) CMSAlgorithm.AES192_CBC) && !algorithm.m14446equals((ASN1Primitive) CMSAlgorithm.AES256_CBC)) {
                            throw e2;
                        }
                        cipherCreateCipher.init(2, key, new IvParameterSpec(ASN1OctetString.getInstance(aSN1Primitive).getOctets()));
                    }
                } else if (algorithm.m14446equals((ASN1Primitive) CMSAlgorithm.DES_EDE3_CBC) || algorithm.m14446equals((ASN1Primitive) CMSAlgorithm.IDEA_CBC) || algorithm.m14446equals((ASN1Primitive) CMSAlgorithm.CAST5_CBC)) {
                    cipherCreateCipher.init(2, key, new IvParameterSpec(new byte[8]));
                } else {
                    cipherCreateCipher.init(2, key);
                }
                return cipherCreateCipher;
            }
        });
    }

    public MessageDigest createDigest(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws CRMFException {
        try {
            String str = (String) DIGEST_ALG_NAMES.get(aSN1ObjectIdentifier);
            if (str != null) {
                try {
                    return this.f18852helper.createMessageDigest(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.f18852helper.createMessageDigest(aSN1ObjectIdentifier.m14433getId());
        } catch (GeneralSecurityException e) {
            throw new CRMFException("cannot create cipher: " + e.getMessage(), e);
        }
    }

    public KeyFactory createKeyFactory(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws CRMFException {
        try {
            String str = (String) KEY_ALG_NAMES.get(aSN1ObjectIdentifier);
            if (str != null) {
                try {
                    return this.f18852helper.createKeyFactory(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.f18852helper.createKeyFactory(aSN1ObjectIdentifier.m14433getId());
        } catch (GeneralSecurityException e) {
            throw new CRMFException("cannot create cipher: " + e.getMessage(), e);
        }
    }

    public KeyGenerator createKeyGenerator(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws CRMFException {
        try {
            String str = (String) BASE_CIPHER_NAMES.get(aSN1ObjectIdentifier);
            if (str != null) {
                try {
                    return this.f18852helper.createKeyGenerator(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.f18852helper.createKeyGenerator(aSN1ObjectIdentifier.m14433getId());
        } catch (GeneralSecurityException e) {
            throw new CRMFException("cannot create key generator: " + e.getMessage(), e);
        }
    }

    public Mac createMac(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws CRMFException {
        try {
            String str = (String) MAC_ALG_NAMES.get(aSN1ObjectIdentifier);
            if (str != null) {
                try {
                    return this.f18852helper.createMac(str);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return this.f18852helper.createMac(aSN1ObjectIdentifier.m14433getId());
        } catch (GeneralSecurityException e) {
            throw new CRMFException("cannot create mac: " + e.getMessage(), e);
        }
    }

    public AlgorithmParameters generateParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, SecretKey secretKey, SecureRandom secureRandom) throws CRMFException, InvalidAlgorithmParameterException {
        try {
            AlgorithmParameterGenerator algorithmParameterGeneratorCreateAlgorithmParameterGenerator = createAlgorithmParameterGenerator(aSN1ObjectIdentifier);
            if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) CMSAlgorithm.f18929RC2_CBC)) {
                byte[] bArr = new byte[8];
                secureRandom.nextBytes(bArr);
                try {
                    algorithmParameterGeneratorCreateAlgorithmParameterGenerator.init(new RC2ParameterSpec(secretKey.getEncoded().length * 8, bArr), secureRandom);
                } catch (InvalidAlgorithmParameterException e) {
                    throw new CRMFException("parameters generation error: " + e, e);
                }
            }
            return algorithmParameterGeneratorCreateAlgorithmParameterGenerator.generateParameters();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        } catch (GeneralSecurityException e2) {
            throw new CRMFException("exception creating algorithm parameter generator: " + e2, e2);
        }
    }

    public AlgorithmIdentifier getAlgorithmIdentifier(ASN1ObjectIdentifier aSN1ObjectIdentifier, AlgorithmParameters algorithmParameters) throws CRMFException {
        ASN1Encodable aSN1EncodableExtractParameters;
        if (algorithmParameters != null) {
            try {
                aSN1EncodableExtractParameters = AlgorithmParametersUtils.extractParameters(algorithmParameters);
            } catch (IOException e) {
                throw new CRMFException("cannot encode parameters: " + e.getMessage(), e);
            }
        } else {
            aSN1EncodableExtractParameters = C5103DERNull.INSTANCE;
        }
        return new AlgorithmIdentifier(aSN1ObjectIdentifier, aSN1EncodableExtractParameters);
    }

    public PublicKey toPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) throws CRMFException {
        try {
            return createKeyFactory(subjectPublicKeyInfo.getAlgorithm().getAlgorithm()).generatePublic(new X509EncodedKeySpec(subjectPublicKeyInfo.getEncoded()));
        } catch (Exception e) {
            throw new CRMFException("invalid key: " + e.getMessage(), e);
        }
    }
}
