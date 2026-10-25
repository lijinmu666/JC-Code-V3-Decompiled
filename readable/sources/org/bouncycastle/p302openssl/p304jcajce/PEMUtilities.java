package org.bouncycastle.p302openssl.p304jcajce;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p302openssl.EncryptionException;
import org.bouncycastle.p302openssl.PEMException;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
class PEMUtilities {
    private static final Map CIPHER_NAMES;
    private static final Map KEYSIZES;
    private static final Map KEY_NAMES;
    private static final Set PKCS5_SCHEME_1;
    private static final Set PKCS5_SCHEME_2;

    /* renamed from: PRFS */
    private static final Map f22853PRFS;
    private static final Map PRFS_SALT;

    static {
        HashMap map = new HashMap();
        KEYSIZES = map;
        HashSet hashSet = new HashSet();
        PKCS5_SCHEME_1 = hashSet;
        HashSet hashSet2 = new HashSet();
        PKCS5_SCHEME_2 = hashSet2;
        HashMap map2 = new HashMap();
        f22853PRFS = map2;
        HashMap map3 = new HashMap();
        PRFS_SALT = map3;
        HashMap map4 = new HashMap();
        CIPHER_NAMES = map4;
        HashMap map5 = new HashMap();
        KEY_NAMES = map5;
        hashSet.add(PKCSObjectIdentifiers.pbeWithMD2AndDES_CBC);
        hashSet.add(PKCSObjectIdentifiers.pbeWithMD2AndRC2_CBC);
        hashSet.add(PKCSObjectIdentifiers.pbeWithMD5AndDES_CBC);
        hashSet.add(PKCSObjectIdentifiers.pbeWithMD5AndRC2_CBC);
        hashSet.add(PKCSObjectIdentifiers.pbeWithSHA1AndDES_CBC);
        hashSet.add(PKCSObjectIdentifiers.pbeWithSHA1AndRC2_CBC);
        hashSet2.add(PKCSObjectIdentifiers.id_PBES2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.des_EDE3_CBC;
        hashSet2.add(aSN1ObjectIdentifier);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_aes128_CBC;
        hashSet2.add(aSN1ObjectIdentifier2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_aes192_CBC;
        hashSet2.add(aSN1ObjectIdentifier3);
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NISTObjectIdentifiers.id_aes256_CBC;
        hashSet2.add(aSN1ObjectIdentifier4);
        map.put(aSN1ObjectIdentifier.m14433getId(), Integers.m18296valueOf(192));
        map.put(aSN1ObjectIdentifier2.m14433getId(), Integers.m18296valueOf(128));
        map.put(aSN1ObjectIdentifier3.m14433getId(), Integers.m18296valueOf(192));
        map.put(aSN1ObjectIdentifier4.m14433getId(), Integers.m18296valueOf(256));
        map.put(PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC4.m14433getId(), Integers.m18296valueOf(128));
        map.put(PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC4, Integers.m18296valueOf(40));
        map.put(PKCSObjectIdentifiers.pbeWithSHAAnd2_KeyTripleDES_CBC, Integers.m18296valueOf(128));
        map.put(PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC, Integers.m18296valueOf(192));
        map.put(PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC2_CBC, Integers.m18296valueOf(128));
        map.put(PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC2_CBC, Integers.m18296valueOf(40));
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = PKCSObjectIdentifiers.id_hmacWithSHA1;
        map2.put(aSN1ObjectIdentifier5, "PBKDF2withHMACSHA1");
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = PKCSObjectIdentifiers.id_hmacWithSHA256;
        map2.put(aSN1ObjectIdentifier6, "PBKDF2withHMACSHA256");
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = PKCSObjectIdentifiers.id_hmacWithSHA512;
        map2.put(aSN1ObjectIdentifier7, "PBKDF2withHMACSHA512");
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = PKCSObjectIdentifiers.id_hmacWithSHA224;
        map2.put(aSN1ObjectIdentifier8, "PBKDF2withHMACSHA224");
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = PKCSObjectIdentifiers.id_hmacWithSHA384;
        map2.put(aSN1ObjectIdentifier9, "PBKDF2withHMACSHA384");
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = NISTObjectIdentifiers.id_hmacWithSHA3_224;
        map2.put(aSN1ObjectIdentifier10, "PBKDF2withHMACSHA3-224");
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = NISTObjectIdentifiers.id_hmacWithSHA3_256;
        map2.put(aSN1ObjectIdentifier11, "PBKDF2withHMACSHA3-256");
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = NISTObjectIdentifiers.id_hmacWithSHA3_384;
        map2.put(aSN1ObjectIdentifier12, "PBKDF2withHMACSHA3-384");
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = NISTObjectIdentifiers.id_hmacWithSHA3_512;
        map2.put(aSN1ObjectIdentifier13, "PBKDF2withHMACSHA3-512");
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = CryptoProObjectIdentifiers.gostR3411Hmac;
        map2.put(aSN1ObjectIdentifier14, "PBKDF2withHMACGOST3411");
        map3.put(aSN1ObjectIdentifier5, Integers.m18296valueOf(20));
        map3.put(aSN1ObjectIdentifier6, Integers.m18296valueOf(32));
        map3.put(aSN1ObjectIdentifier7, Integers.m18296valueOf(64));
        map3.put(aSN1ObjectIdentifier8, Integers.m18296valueOf(28));
        map3.put(aSN1ObjectIdentifier9, Integers.m18296valueOf(48));
        map3.put(aSN1ObjectIdentifier10, Integers.m18296valueOf(28));
        map3.put(aSN1ObjectIdentifier11, Integers.m18296valueOf(32));
        map3.put(aSN1ObjectIdentifier12, Integers.m18296valueOf(48));
        map3.put(aSN1ObjectIdentifier13, Integers.m18296valueOf(64));
        map3.put(aSN1ObjectIdentifier14, Integers.m18296valueOf(32));
        map4.put(aSN1ObjectIdentifier, "DESEDE/CBC/PKCS5Padding");
        map4.put(aSN1ObjectIdentifier2, "AES/CBC/PKCS7Padding");
        map4.put(aSN1ObjectIdentifier3, "AES/CBC/PKCS7Padding");
        map4.put(aSN1ObjectIdentifier4, "AES/CBC/PKCS7Padding");
        map5.put(aSN1ObjectIdentifier.m14433getId(), "DESEDE");
        map5.put(aSN1ObjectIdentifier2.m14433getId(), "AES");
        map5.put(aSN1ObjectIdentifier3.m14433getId(), "AES");
        map5.put(aSN1ObjectIdentifier4.m14433getId(), "AES");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [javax.crypto.spec.RC2ParameterSpec] */
    /* JADX WARN: Type inference failed for: r2v7, types: [javax.crypto.spec.RC2ParameterSpec] */
    /* JADX WARN: Type inference failed for: r2v8, types: [javax.crypto.spec.RC2ParameterSpec] */
    /* renamed from: crypt */
    public static byte[] m17376crypt(boolean z, JcaJceHelper jcaJceHelper, byte[] bArr, char[] cArr, String str, byte[] bArr2) throws PEMException, InvalidKeyException, InvalidAlgorithmParameterException {
        String str2;
        String str3;
        String str4;
        String str5;
        byte[] bArr3;
        String str6;
        SecretKey secretKeyM17377getKey;
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
        if (str.endsWith("-CFB")) {
            str2 = "CFB";
            str3 = "NoPadding";
        } else {
            str2 = "CBC";
            str3 = "PKCS5Padding";
        }
        if (str.endsWith("-ECB") || "DES-EDE".equals(str) || "DES-EDE3".equals(str)) {
            str2 = "ECB";
            ivParameterSpec = null;
        }
        IvParameterSpec rC2ParameterSpec = ivParameterSpec;
        if (str.endsWith("-OFB")) {
            str5 = "OFB";
            str4 = "NoPadding";
        } else {
            str4 = str3;
            str5 = str2;
        }
        int i = 1;
        if (str.startsWith("DES-EDE")) {
            str6 = "DESede";
            secretKeyM17377getKey = m17378getKey(jcaJceHelper, cArr, "DESede", 24, bArr2, !str.startsWith("DES-EDE3"));
        } else if (str.startsWith("DES-")) {
            str6 = "DES";
            secretKeyM17377getKey = m17377getKey(jcaJceHelper, cArr, "DES", 8, bArr2);
        } else if (str.startsWith("BF-")) {
            str6 = "Blowfish";
            secretKeyM17377getKey = m17377getKey(jcaJceHelper, cArr, "Blowfish", 16, bArr2);
        } else {
            int i2 = 128;
            if (str.startsWith("RC2-")) {
                if (str.startsWith("RC2-40-")) {
                    i2 = 40;
                } else if (str.startsWith("RC2-64-")) {
                    i2 = 64;
                }
                str6 = "RC2";
                secretKeyM17377getKey = m17377getKey(jcaJceHelper, cArr, "RC2", i2 / 8, bArr2);
                rC2ParameterSpec = rC2ParameterSpec == null ? new RC2ParameterSpec(i2) : new RC2ParameterSpec(i2, bArr2);
            } else {
                if (!str.startsWith("AES-")) {
                    throw new EncryptionException("unknown encryption with private key");
                }
                if (bArr2.length > 8) {
                    bArr3 = new byte[8];
                    System.arraycopy(bArr2, 0, bArr3, 0, 8);
                } else {
                    bArr3 = bArr2;
                }
                if (!str.startsWith("AES-128-")) {
                    if (str.startsWith("AES-192-")) {
                        i2 = 192;
                    } else {
                        if (!str.startsWith("AES-256-")) {
                            throw new EncryptionException("unknown AES encryption with private key");
                        }
                        i2 = 256;
                    }
                }
                str6 = "AES";
                secretKeyM17377getKey = m17377getKey(jcaJceHelper, cArr, "AES", i2 / 8, bArr3);
            }
        }
        try {
            Cipher cipherCreateCipher = jcaJceHelper.createCipher(str6 + "/" + str5 + "/" + str4);
            if (!z) {
                i = 2;
            }
            if (rC2ParameterSpec == null) {
                cipherCreateCipher.init(i, secretKeyM17377getKey);
            } else {
                cipherCreateCipher.init(i, secretKeyM17377getKey, rC2ParameterSpec);
            }
            return cipherCreateCipher.doFinal(bArr);
        } catch (Exception e) {
            throw new EncryptionException("exception using cipher - please check password and data.", e);
        }
    }

    public static SecretKey generateSecretKeyForPKCS5Scheme2(JcaJceHelper jcaJceHelper, String str, char[] cArr, byte[] bArr, int i) {
        return new SecretKeySpec(jcaJceHelper.createSecretKeyFactory("PBKDF2with8BIT").generateSecret(new PBEKeySpec(cArr, bArr, i, getKeySize(str))).getEncoded(), getAlgorithmName(str));
    }

    public static String getAlgorithmName(String str) {
        String str2 = (String) KEY_NAMES.get(str);
        return str2 != null ? str2 : str;
    }

    public static String getCipherName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String str = (String) CIPHER_NAMES.get(aSN1ObjectIdentifier);
        return str != null ? str : aSN1ObjectIdentifier.m14433getId();
    }

    /* renamed from: getKey */
    private static SecretKey m17377getKey(JcaJceHelper jcaJceHelper, char[] cArr, String str, int i, byte[] bArr) {
        return m17378getKey(jcaJceHelper, cArr, str, i, bArr, false);
    }

    public static int getKeySize(String str) {
        Map map = KEYSIZES;
        if (map.containsKey(str)) {
            return ((Integer) map.get(str)).intValue();
        }
        throw new IllegalStateException("no key size for algorithm: " + str);
    }

    public static int getSaltSize(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        Map map = PRFS_SALT;
        if (map.containsKey(aSN1ObjectIdentifier)) {
            return ((Integer) map.get(aSN1ObjectIdentifier)).intValue();
        }
        throw new IllegalStateException("no salt size for algorithm: " + aSN1ObjectIdentifier);
    }

    public static boolean isHmacSHA1(AlgorithmIdentifier algorithmIdentifier) {
        return algorithmIdentifier == null || algorithmIdentifier.getAlgorithm().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.id_hmacWithSHA1);
    }

    public static boolean isPKCS12(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return aSN1ObjectIdentifier.m14433getId().startsWith(PKCSObjectIdentifiers.pkcs_12PbeIds.m14433getId());
    }

    public static boolean isPKCS5Scheme1(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return PKCS5_SCHEME_1.contains(aSN1ObjectIdentifier);
    }

    public static boolean isPKCS5Scheme2(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return PKCS5_SCHEME_2.contains(aSN1ObjectIdentifier);
    }

    public static SecretKey generateSecretKeyForPKCS5Scheme2(JcaJceHelper jcaJceHelper, String str, char[] cArr, byte[] bArr, int i, AlgorithmIdentifier algorithmIdentifier) throws NoSuchAlgorithmException {
        String str2 = (String) f22853PRFS.get(algorithmIdentifier.getAlgorithm());
        if (str2 != null) {
            return new SecretKeySpec(jcaJceHelper.createSecretKeyFactory(str2).generateSecret(new PBEKeySpec(cArr, bArr, i, getKeySize(str))).getEncoded(), str);
        }
        throw new NoSuchAlgorithmException("unknown PRF in PKCS#2: " + algorithmIdentifier.getAlgorithm());
    }

    /* renamed from: getKey */
    private static SecretKey m17378getKey(JcaJceHelper jcaJceHelper, char[] cArr, String str, int i, byte[] bArr, boolean z) throws PEMException {
        try {
            byte[] encoded = jcaJceHelper.createSecretKeyFactory("PBKDF-OpenSSL").generateSecret(new PBEKeySpec(cArr, bArr, 1, i * 8)).getEncoded();
            if (z && encoded.length >= 24) {
                System.arraycopy(encoded, 0, encoded, 16, 8);
            }
            return new SecretKeySpec(encoded, str);
        } catch (GeneralSecurityException e) {
            throw new PEMException("Unable to create OpenSSL PBDKF: " + e.getMessage(), e);
        }
    }
}
