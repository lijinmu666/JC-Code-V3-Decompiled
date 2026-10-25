package org.bouncycastle.p249jcajce.provider.asymmetric.p264util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import javax.crypto.KeyAgreementSpi;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.internal.p231asn1.p236gnu.GNUObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p241kisa.KISAObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p242misc.MiscObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p244ntt.NTTObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p245oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p194crypto.DerivationFunction;
import org.bouncycastle.p194crypto.DerivationParameters;
import org.bouncycastle.p194crypto.agreement.p197kdf.DHKDFParameters;
import org.bouncycastle.p194crypto.agreement.p197kdf.DHKEKGenerator;
import org.bouncycastle.p194crypto.generators.HKDFBytesGenerator;
import org.bouncycastle.p194crypto.p213params.DESParameters;
import org.bouncycastle.p194crypto.p213params.HKDFParameters;
import org.bouncycastle.p194crypto.p213params.KDFParameters;
import org.bouncycastle.p249jcajce.p279spec.HybridValueParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
public abstract class BaseAgreementSpi extends KeyAgreementSpi {
    private static final Map<String, ASN1ObjectIdentifier> defaultOids;

    /* renamed from: des */
    private static final Hashtable f21629des;
    private static final Map<String, Integer> keySizes;
    private static final Map<String, String> nameTable;

    /* renamed from: oids */
    private static final Hashtable f21630oids;
    private HybridValueParameterSpec hybridSpec;
    protected final String kaAlgorithm;

    /* renamed from: kdf */
    protected final DerivationFunction f21631kdf;
    protected byte[] ukmParameters;
    protected byte[] ukmParametersSalt;

    static {
        HashMap map = new HashMap();
        defaultOids = map;
        HashMap map2 = new HashMap();
        keySizes = map2;
        HashMap map3 = new HashMap();
        nameTable = map3;
        Hashtable hashtable = new Hashtable();
        f21630oids = hashtable;
        Hashtable hashtable2 = new Hashtable();
        f21629des = hashtable2;
        Integer numM18296valueOf = Integers.m18296valueOf(64);
        Integer numM18296valueOf2 = Integers.m18296valueOf(128);
        Integer numM18296valueOf3 = Integers.m18296valueOf(192);
        Integer numM18296valueOf4 = Integers.m18296valueOf(256);
        map2.put("DES", numM18296valueOf);
        map2.put("DESEDE", numM18296valueOf3);
        map2.put("BLOWFISH", numM18296valueOf2);
        map2.put("AES", numM18296valueOf4);
        map2.put(NISTObjectIdentifiers.id_aes128_ECB.m14433getId(), numM18296valueOf2);
        map2.put(NISTObjectIdentifiers.id_aes192_ECB.m14433getId(), numM18296valueOf3);
        map2.put(NISTObjectIdentifiers.id_aes256_ECB.m14433getId(), numM18296valueOf4);
        map2.put(NISTObjectIdentifiers.id_aes128_CBC.m14433getId(), numM18296valueOf2);
        map2.put(NISTObjectIdentifiers.id_aes192_CBC.m14433getId(), numM18296valueOf3);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_aes256_CBC;
        map2.put(aSN1ObjectIdentifier.m14433getId(), numM18296valueOf4);
        map2.put(NISTObjectIdentifiers.id_aes128_CFB.m14433getId(), numM18296valueOf2);
        map2.put(NISTObjectIdentifiers.id_aes192_CFB.m14433getId(), numM18296valueOf3);
        map2.put(NISTObjectIdentifiers.id_aes256_CFB.m14433getId(), numM18296valueOf4);
        map2.put(NISTObjectIdentifiers.id_aes128_OFB.m14433getId(), numM18296valueOf2);
        map2.put(NISTObjectIdentifiers.id_aes192_OFB.m14433getId(), numM18296valueOf3);
        map2.put(NISTObjectIdentifiers.id_aes256_OFB.m14433getId(), numM18296valueOf4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_aes128_wrap;
        map2.put(aSN1ObjectIdentifier2.m14433getId(), numM18296valueOf2);
        map2.put(NISTObjectIdentifiers.id_aes192_wrap.m14433getId(), numM18296valueOf3);
        map2.put(NISTObjectIdentifiers.id_aes256_wrap.m14433getId(), numM18296valueOf4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_aes128_CCM;
        map2.put(aSN1ObjectIdentifier3.m14433getId(), numM18296valueOf2);
        map2.put(NISTObjectIdentifiers.id_aes192_CCM.m14433getId(), numM18296valueOf3);
        map2.put(NISTObjectIdentifiers.id_aes256_CCM.m14433getId(), numM18296valueOf4);
        map2.put(NISTObjectIdentifiers.id_aes128_GCM.m14433getId(), numM18296valueOf2);
        map2.put(NISTObjectIdentifiers.id_aes192_GCM.m14433getId(), numM18296valueOf3);
        map2.put(NISTObjectIdentifiers.id_aes256_GCM.m14433getId(), numM18296valueOf4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NTTObjectIdentifiers.id_camellia128_wrap;
        map2.put(aSN1ObjectIdentifier4.m14433getId(), numM18296valueOf2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = NTTObjectIdentifiers.id_camellia192_wrap;
        map2.put(aSN1ObjectIdentifier5.m14433getId(), numM18296valueOf3);
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = NTTObjectIdentifiers.id_camellia256_wrap;
        map2.put(aSN1ObjectIdentifier6.m14433getId(), numM18296valueOf4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = KISAObjectIdentifiers.id_npki_app_cmsSeed_wrap;
        map2.put(aSN1ObjectIdentifier7.m14433getId(), numM18296valueOf2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = PKCSObjectIdentifiers.id_alg_CMS3DESwrap;
        map2.put(aSN1ObjectIdentifier8.m14433getId(), numM18296valueOf3);
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = PKCSObjectIdentifiers.des_EDE3_CBC;
        map2.put(aSN1ObjectIdentifier9.m14433getId(), numM18296valueOf3);
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = OIWObjectIdentifiers.f21277desCBC;
        map2.put(aSN1ObjectIdentifier10.m14433getId(), numM18296valueOf);
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = CryptoProObjectIdentifiers.gostR28147_gcfb;
        map2.put(aSN1ObjectIdentifier11.m14433getId(), numM18296valueOf4);
        map2.put(CryptoProObjectIdentifiers.id_Gost28147_89_None_KeyWrap.m14433getId(), numM18296valueOf4);
        map2.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_KeyWrap.m14433getId(), numM18296valueOf4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = PKCSObjectIdentifiers.id_hmacWithSHA1;
        map2.put(aSN1ObjectIdentifier12.m14433getId(), Integers.m18296valueOf(160));
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = PKCSObjectIdentifiers.id_hmacWithSHA256;
        map2.put(aSN1ObjectIdentifier13.m14433getId(), numM18296valueOf4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = PKCSObjectIdentifiers.id_hmacWithSHA384;
        map2.put(aSN1ObjectIdentifier14.m14433getId(), Integers.m18296valueOf(384));
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = PKCSObjectIdentifiers.id_hmacWithSHA512;
        map2.put(aSN1ObjectIdentifier15.m14433getId(), Integers.m18296valueOf(512));
        map.put("DESEDE", aSN1ObjectIdentifier9);
        map.put("AES", aSN1ObjectIdentifier);
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = NTTObjectIdentifiers.id_camellia256_cbc;
        map.put("CAMELLIA", aSN1ObjectIdentifier16);
        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = KISAObjectIdentifiers.id_seedCBC;
        map.put("SEED", aSN1ObjectIdentifier17);
        map.put("DES", aSN1ObjectIdentifier10);
        map3.put(MiscObjectIdentifiers.cast5CBC.m14433getId(), "CAST5");
        map3.put(MiscObjectIdentifiers.as_sys_sec_alg_ideaCBC.m14433getId(), "IDEA");
        map3.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_ECB.m14433getId(), "Blowfish");
        map3.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_CBC.m14433getId(), "Blowfish");
        map3.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_CFB.m14433getId(), "Blowfish");
        map3.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_OFB.m14433getId(), "Blowfish");
        map3.put(OIWObjectIdentifiers.f21279desECB.m14433getId(), "DES");
        map3.put(aSN1ObjectIdentifier10.m14433getId(), "DES");
        map3.put(OIWObjectIdentifiers.f21278desCFB.m14433getId(), "DES");
        map3.put(OIWObjectIdentifiers.f21281desOFB.m14433getId(), "DES");
        map3.put(OIWObjectIdentifiers.f21280desEDE.m14433getId(), "DESede");
        map3.put(aSN1ObjectIdentifier9.m14433getId(), "DESede");
        map3.put(aSN1ObjectIdentifier8.m14433getId(), "DESede");
        map3.put(PKCSObjectIdentifiers.id_alg_CMSRC2wrap.m14433getId(), "RC2");
        map3.put(aSN1ObjectIdentifier12.m14433getId(), "HmacSHA1");
        map3.put(PKCSObjectIdentifiers.id_hmacWithSHA224.m14433getId(), "HmacSHA224");
        map3.put(aSN1ObjectIdentifier13.m14433getId(), "HmacSHA256");
        map3.put(aSN1ObjectIdentifier14.m14433getId(), "HmacSHA384");
        map3.put(aSN1ObjectIdentifier15.m14433getId(), "HmacSHA512");
        map3.put(NTTObjectIdentifiers.id_camellia128_cbc.m14433getId(), "Camellia");
        map3.put(NTTObjectIdentifiers.id_camellia192_cbc.m14433getId(), "Camellia");
        map3.put(aSN1ObjectIdentifier16.m14433getId(), "Camellia");
        map3.put(aSN1ObjectIdentifier4.m14433getId(), "Camellia");
        map3.put(aSN1ObjectIdentifier5.m14433getId(), "Camellia");
        map3.put(aSN1ObjectIdentifier6.m14433getId(), "Camellia");
        map3.put(aSN1ObjectIdentifier7.m14433getId(), "SEED");
        map3.put(aSN1ObjectIdentifier17.m14433getId(), "SEED");
        map3.put(KISAObjectIdentifiers.id_seedMAC.m14433getId(), "SEED");
        map3.put(aSN1ObjectIdentifier11.m14433getId(), "GOST28147");
        map3.put(aSN1ObjectIdentifier2.m14433getId(), "AES");
        map3.put(aSN1ObjectIdentifier3.m14433getId(), "AES");
        map3.put(aSN1ObjectIdentifier3.m14433getId(), "AES");
        hashtable.put("DESEDE", aSN1ObjectIdentifier9);
        hashtable.put("AES", aSN1ObjectIdentifier);
        hashtable.put("DES", aSN1ObjectIdentifier10);
        hashtable2.put("DES", "DES");
        hashtable2.put("DESEDE", "DES");
        hashtable2.put(aSN1ObjectIdentifier10.m14433getId(), "DES");
        hashtable2.put(aSN1ObjectIdentifier9.m14433getId(), "DES");
        hashtable2.put(aSN1ObjectIdentifier8.m14433getId(), "DES");
    }

    public BaseAgreementSpi(String str, DerivationFunction derivationFunction) {
        this.kaAlgorithm = str;
        this.f21631kdf = derivationFunction;
    }

    private byte[] calcSecret() {
        if (this.hybridSpec == null) {
            return doCalcSecret();
        }
        byte[] bArrDoCalcSecret = doCalcSecret();
        boolean zIsPrependedT = this.hybridSpec.isPrependedT();
        byte[] bArrM16201getT = this.hybridSpec.m16201getT();
        byte[] bArrConcatenate = zIsPrependedT ? C6238Arrays.concatenate(bArrM16201getT, bArrDoCalcSecret) : C6238Arrays.concatenate(bArrDoCalcSecret, bArrM16201getT);
        C6238Arrays.m18227clear(bArrDoCalcSecret);
        return bArrConcatenate;
    }

    public static String getAlgorithm(String str) {
        if (str.indexOf(91) > 0) {
            return str.substring(0, str.indexOf(91));
        }
        if (str.startsWith(NISTObjectIdentifiers.f18429aes.m14433getId())) {
            return "AES";
        }
        if (str.startsWith(GNUObjectIdentifiers.f21254Serpent.m14433getId())) {
            return "Serpent";
        }
        String str2 = nameTable.get(C6250Strings.toUpperCase(str));
        return str2 != null ? str2 : str;
    }

    public static int getKeySize(String str) {
        if (str.indexOf(91) > 0) {
            return Integer.parseInt(str.substring(str.indexOf(91) + 1, str.indexOf(93)));
        }
        String upperCase = C6250Strings.toUpperCase(str);
        Map<String, Integer> map = keySizes;
        if (map.containsKey(upperCase)) {
            return map.get(upperCase).intValue();
        }
        return -1;
    }

    private byte[] getSharedSecretBytes(byte[] bArr, String str, int i) throws NoSuchAlgorithmException {
        DerivationParameters kDFParameters;
        DerivationFunction derivationFunction = this.f21631kdf;
        if (derivationFunction == null) {
            if (i <= 0) {
                return bArr;
            }
            int i2 = i / 8;
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            C6238Arrays.m18227clear(bArr);
            return bArr2;
        }
        if (i < 0) {
            throw new NoSuchAlgorithmException("unknown algorithm encountered: " + str);
        }
        int i3 = i / 8;
        byte[] bArr3 = new byte[i3];
        if (derivationFunction instanceof DHKEKGenerator) {
            if (str == null) {
                throw new NoSuchAlgorithmException("algorithm OID is null");
            }
            ASN1ObjectIdentifier aSN1ObjectIdentifierTryFromID = ASN1ObjectIdentifier.tryFromID(str);
            if (aSN1ObjectIdentifierTryFromID == null) {
                throw new NoSuchAlgorithmException("no OID for algorithm: " + str);
            }
            kDFParameters = new DHKDFParameters(aSN1ObjectIdentifierTryFromID, i, bArr, this.ukmParameters);
        } else {
            if (derivationFunction instanceof HKDFBytesGenerator) {
                derivationFunction.mo14966init(new HKDFParameters(bArr, this.ukmParametersSalt, this.ukmParameters));
                this.f21631kdf.generateBytes(bArr3, 0, i3);
                C6238Arrays.m18227clear(bArr);
                return bArr3;
            }
            kDFParameters = new KDFParameters(bArr, this.ukmParameters);
        }
        this.f21631kdf.mo14966init(kDFParameters);
        this.f21631kdf.generateBytes(bArr3, 0, i3);
        C6238Arrays.m18227clear(bArr);
        return bArr3;
    }

    public static byte[] trimZeroes(byte[] bArr) {
        if (bArr[0] != 0) {
            return bArr;
        }
        int i = 0;
        while (i < bArr.length && bArr[i] == 0) {
            i++;
        }
        int length = bArr.length - i;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, i, bArr2, 0, length);
        return bArr2;
    }

    public abstract byte[] doCalcSecret();

    public abstract void doInitFromKey(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom);

    @Override // javax.crypto.KeyAgreementSpi
    public int engineGenerateSecret(byte[] bArr, int i) throws ShortBufferException {
        byte[] bArrEngineGenerateSecret = engineGenerateSecret();
        if (bArr.length - i >= bArrEngineGenerateSecret.length) {
            System.arraycopy(bArrEngineGenerateSecret, 0, bArr, i, bArrEngineGenerateSecret.length);
            return bArrEngineGenerateSecret.length;
        }
        throw new ShortBufferException(this.kaAlgorithm + " key agreement: need " + bArrEngineGenerateSecret.length + " bytes");
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            doInitFromKey(key, null, secureRandom);
        } catch (InvalidAlgorithmParameterException e) {
            throw new InvalidKeyException(e.getMessage());
        }
    }

    @Override // javax.crypto.KeyAgreementSpi
    public SecretKey engineGenerateSecret(String str) throws NoSuchAlgorithmException {
        String upperCase = C6250Strings.toUpperCase(str);
        Hashtable hashtable = f21630oids;
        String strM14433getId = hashtable.containsKey(upperCase) ? ((ASN1ObjectIdentifier) hashtable.get(upperCase)).m14433getId() : str;
        byte[] sharedSecretBytes = getSharedSecretBytes(calcSecret(), strM14433getId, getKeySize(strM14433getId));
        String algorithm = getAlgorithm(str);
        if (f21629des.containsKey(algorithm)) {
            DESParameters.setOddParity(sharedSecretBytes);
        }
        return new SecretKeySpec(sharedSecretBytes, algorithm);
    }

    @Override // javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        if (algorithmParameterSpec instanceof HybridValueParameterSpec) {
            HybridValueParameterSpec hybridValueParameterSpec = (HybridValueParameterSpec) algorithmParameterSpec;
            this.hybridSpec = hybridValueParameterSpec;
            algorithmParameterSpec = hybridValueParameterSpec.getBaseParameterSpec();
        } else {
            this.hybridSpec = null;
        }
        doInitFromKey(key, algorithmParameterSpec, secureRandom);
    }

    @Override // javax.crypto.KeyAgreementSpi
    public byte[] engineGenerateSecret() {
        if (this.f21631kdf == null) {
            return calcSecret();
        }
        byte[] bArrCalcSecret = calcSecret();
        try {
            return getSharedSecretBytes(bArrCalcSecret, null, bArrCalcSecret.length * 8);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
