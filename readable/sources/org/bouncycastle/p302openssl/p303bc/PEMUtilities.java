package org.bouncycastle.p302openssl.p303bc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.BufferedBlockCipher;
import org.bouncycastle.p194crypto.PBEParametersGenerator;
import org.bouncycastle.p194crypto.generators.OpenSSLPBEParametersGenerator;
import org.bouncycastle.p194crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.p194crypto.p199digests.SHA1Digest;
import org.bouncycastle.p194crypto.p201engines.AESEngine;
import org.bouncycastle.p194crypto.p201engines.BlowfishEngine;
import org.bouncycastle.p194crypto.p201engines.DESEngine;
import org.bouncycastle.p194crypto.p201engines.DESedeEngine;
import org.bouncycastle.p194crypto.p201engines.RC2Engine;
import org.bouncycastle.p194crypto.p210modes.CBCBlockCipher;
import org.bouncycastle.p194crypto.p210modes.CFBBlockCipher;
import org.bouncycastle.p194crypto.p210modes.OFBBlockCipher;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p194crypto.p213params.RC2Parameters;
import org.bouncycastle.p194crypto.paddings.PKCS7Padding;
import org.bouncycastle.p194crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.p302openssl.EncryptionException;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
class PEMUtilities {
    private static final Map KEYSIZES;
    private static final Set PKCS5_SCHEME_1;
    private static final Set PKCS5_SCHEME_2;

    static {
        HashMap map = new HashMap();
        KEYSIZES = map;
        HashSet hashSet = new HashSet();
        PKCS5_SCHEME_1 = hashSet;
        HashSet hashSet2 = new HashSet();
        PKCS5_SCHEME_2 = hashSet2;
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
    }

    /* renamed from: crypt */
    public static byte[] m17365crypt(boolean z, byte[] bArr, char[] cArr, String str, byte[] bArr2) throws EncryptionException {
        String str2;
        byte[] bArr3;
        KeyParameter keyParameterM17366getKey;
        BlockCipher blockCipherNewInstance;
        byte[] bArr4 = bArr2;
        PKCS7Padding pKCS7Padding = new PKCS7Padding();
        PKCS7Padding pKCS7Padding2 = null;
        if (str.endsWith("-CFB")) {
            str2 = "CFB";
            pKCS7Padding = null;
        } else {
            str2 = "CBC";
        }
        if (str.endsWith("-ECB") || "DES-EDE".equals(str) || "DES-EDE3".equals(str)) {
            str2 = "ECB";
            bArr3 = null;
        } else {
            bArr3 = bArr4;
        }
        if (str.endsWith("-OFB")) {
            str2 = "OFB";
        } else {
            pKCS7Padding2 = pKCS7Padding;
        }
        if (str.startsWith("DES-EDE")) {
            keyParameterM17366getKey = m17367getKey(cArr, 24, bArr4, !str.startsWith("DES-EDE3"));
            blockCipherNewInstance = new DESedeEngine();
        } else if (str.startsWith("DES-")) {
            keyParameterM17366getKey = m17366getKey(cArr, 8, bArr4);
            blockCipherNewInstance = new DESEngine();
        } else if (str.startsWith("BF-")) {
            keyParameterM17366getKey = m17366getKey(cArr, 16, bArr4);
            blockCipherNewInstance = new BlowfishEngine();
        } else {
            int i = 128;
            if (str.startsWith("RC2-")) {
                if (str.startsWith("RC2-40-")) {
                    i = 40;
                } else if (str.startsWith("RC2-64-")) {
                    i = 64;
                }
                RC2Parameters rC2Parameters = new RC2Parameters(m17366getKey(cArr, i / 8, bArr4).m15773getKey(), i);
                blockCipherNewInstance = new RC2Engine();
                keyParameterM17366getKey = rC2Parameters;
            } else {
                if (!str.startsWith("AES-")) {
                    throw new EncryptionException("unknown encryption with private key: " + str);
                }
                if (bArr4.length > 8) {
                    byte[] bArr5 = new byte[8];
                    System.arraycopy(bArr4, 0, bArr5, 0, 8);
                    bArr4 = bArr5;
                }
                if (!str.startsWith("AES-128-")) {
                    if (str.startsWith("AES-192-")) {
                        i = 192;
                    } else {
                        if (!str.startsWith("AES-256-")) {
                            throw new EncryptionException("unknown AES encryption with private key: " + str);
                        }
                        i = 256;
                    }
                }
                keyParameterM17366getKey = m17366getKey(cArr, i / 8, bArr4);
                blockCipherNewInstance = AESEngine.newInstance();
            }
        }
        if (str2.equals("CBC")) {
            blockCipherNewInstance = CBCBlockCipher.newInstance(blockCipherNewInstance);
        } else if (str2.equals("CFB")) {
            blockCipherNewInstance = CFBBlockCipher.newInstance(blockCipherNewInstance, blockCipherNewInstance.getBlockSize() * 8);
        } else if (str2.equals("OFB")) {
            blockCipherNewInstance = new OFBBlockCipher(blockCipherNewInstance, blockCipherNewInstance.getBlockSize() * 8);
        }
        try {
            BufferedBlockCipher bufferedBlockCipher = pKCS7Padding2 == null ? new BufferedBlockCipher(blockCipherNewInstance) : new PaddedBufferedBlockCipher(blockCipherNewInstance, pKCS7Padding2);
            if (bArr3 == null) {
                bufferedBlockCipher.mo14952init(z, keyParameterM17366getKey);
            } else {
                bufferedBlockCipher.mo14952init(z, new ParametersWithIV(keyParameterM17366getKey, bArr3));
            }
            int outputSize = bufferedBlockCipher.getOutputSize(bArr.length);
            byte[] bArr6 = new byte[outputSize];
            int iProcessBytes = bufferedBlockCipher.processBytes(bArr, 0, bArr.length, bArr6, 0);
            int iMo14951doFinal = iProcessBytes + bufferedBlockCipher.mo14951doFinal(bArr6, iProcessBytes);
            if (iMo14951doFinal == outputSize) {
                return bArr6;
            }
            byte[] bArr7 = new byte[iMo14951doFinal];
            System.arraycopy(bArr6, 0, bArr7, 0, iMo14951doFinal);
            return bArr7;
        } catch (Exception e) {
            throw new EncryptionException("exception using cipher - please check password and data.", e);
        }
    }

    public static KeyParameter generateSecretKeyForPKCS5Scheme2(String str, char[] cArr, byte[] bArr, int i) {
        PKCS5S2ParametersGenerator pKCS5S2ParametersGenerator = new PKCS5S2ParametersGenerator(new SHA1Digest());
        pKCS5S2ParametersGenerator.m14982init(PBEParametersGenerator.PKCS5PasswordToBytes(cArr), bArr, i);
        return (KeyParameter) pKCS5S2ParametersGenerator.generateDerivedParameters(getKeySize(str));
    }

    /* renamed from: getKey */
    private static KeyParameter m17366getKey(char[] cArr, int i, byte[] bArr) {
        return m17367getKey(cArr, i, bArr, false);
    }

    public static int getKeySize(String str) {
        Map map = KEYSIZES;
        if (map.containsKey(str)) {
            return ((Integer) map.get(str)).intValue();
        }
        throw new IllegalStateException("no key size for algorithm: " + str);
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

    /* renamed from: getKey */
    private static KeyParameter m17367getKey(char[] cArr, int i, byte[] bArr, boolean z) {
        OpenSSLPBEParametersGenerator openSSLPBEParametersGenerator = new OpenSSLPBEParametersGenerator();
        openSSLPBEParametersGenerator.m14982init(PBEParametersGenerator.PKCS5PasswordToBytes(cArr), bArr, 1);
        KeyParameter keyParameter = (KeyParameter) openSSLPBEParametersGenerator.generateDerivedParameters(i * 8);
        if (!z || keyParameter.m15773getKey().length != 24) {
            return keyParameter;
        }
        byte[] bArrM15773getKey = keyParameter.m15773getKey();
        System.arraycopy(bArrM15773getKey, 0, bArrM15773getKey, 16, 8);
        return new KeyParameter(bArrM15773getKey);
    }
}
