package org.bouncycastle.p191cms;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.p136bsi.BSIObjectIdentifiers;
import org.bouncycastle.p133asn1.p157kisa.KISAObjectIdentifiers;
import org.bouncycastle.p133asn1.p158misc.MiscObjectIdentifiers;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p163ntt.NTTObjectIdentifiers;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p167sec.SECObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p133asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.p133asn1.teletrust.TeleTrusTObjectIdentifiers;

/* loaded from: classes2.dex */
public class CMSAlgorithm {

    /* renamed from: DES_CBC */
    public static final ASN1ObjectIdentifier f18927DES_CBC = OIWObjectIdentifiers.f18454desCBC.m14434intern();
    public static final ASN1ObjectIdentifier DES_EDE3_CBC = PKCSObjectIdentifiers.des_EDE3_CBC.m14434intern();

    /* renamed from: RC2_CBC */
    public static final ASN1ObjectIdentifier f18929RC2_CBC = PKCSObjectIdentifiers.f18490RC2_CBC.m14434intern();
    public static final ASN1ObjectIdentifier IDEA_CBC = MiscObjectIdentifiers.as_sys_sec_alg_ideaCBC.m14434intern();
    public static final ASN1ObjectIdentifier CAST5_CBC = MiscObjectIdentifiers.cast5CBC.m14434intern();
    public static final ASN1ObjectIdentifier AES128_CBC = NISTObjectIdentifiers.id_aes128_CBC.m14434intern();
    public static final ASN1ObjectIdentifier AES192_CBC = NISTObjectIdentifiers.id_aes192_CBC.m14434intern();
    public static final ASN1ObjectIdentifier AES256_CBC = NISTObjectIdentifiers.id_aes256_CBC.m14434intern();
    public static final ASN1ObjectIdentifier AES128_CCM = NISTObjectIdentifiers.id_aes128_CCM.m14434intern();
    public static final ASN1ObjectIdentifier AES192_CCM = NISTObjectIdentifiers.id_aes192_CCM.m14434intern();
    public static final ASN1ObjectIdentifier AES256_CCM = NISTObjectIdentifiers.id_aes256_CCM.m14434intern();
    public static final ASN1ObjectIdentifier AES128_GCM = NISTObjectIdentifiers.id_aes128_GCM.m14434intern();
    public static final ASN1ObjectIdentifier AES192_GCM = NISTObjectIdentifiers.id_aes192_GCM.m14434intern();
    public static final ASN1ObjectIdentifier AES256_GCM = NISTObjectIdentifiers.id_aes256_GCM.m14434intern();
    public static final ASN1ObjectIdentifier CAMELLIA128_CBC = NTTObjectIdentifiers.id_camellia128_cbc.m14434intern();
    public static final ASN1ObjectIdentifier CAMELLIA192_CBC = NTTObjectIdentifiers.id_camellia192_cbc.m14434intern();
    public static final ASN1ObjectIdentifier CAMELLIA256_CBC = NTTObjectIdentifiers.id_camellia256_cbc.m14434intern();
    public static final ASN1ObjectIdentifier GOST28147_GCFB = CryptoProObjectIdentifiers.gostR28147_gcfb.m14434intern();
    public static final ASN1ObjectIdentifier SEED_CBC = KISAObjectIdentifiers.id_seedCBC.m14434intern();
    public static final ASN1ObjectIdentifier DES_EDE3_WRAP = PKCSObjectIdentifiers.id_alg_CMS3DESwrap.m14434intern();
    public static final ASN1ObjectIdentifier AES128_WRAP = NISTObjectIdentifiers.id_aes128_wrap.m14434intern();
    public static final ASN1ObjectIdentifier AES192_WRAP = NISTObjectIdentifiers.id_aes192_wrap.m14434intern();
    public static final ASN1ObjectIdentifier AES256_WRAP = NISTObjectIdentifiers.id_aes256_wrap.m14434intern();
    public static final ASN1ObjectIdentifier AES128_WRAP_PAD = NISTObjectIdentifiers.id_aes128_wrap_pad.m14434intern();
    public static final ASN1ObjectIdentifier AES192_WRAP_PAD = NISTObjectIdentifiers.id_aes192_wrap_pad.m14434intern();
    public static final ASN1ObjectIdentifier AES256_WRAP_PAD = NISTObjectIdentifiers.id_aes256_wrap_pad.m14434intern();
    public static final ASN1ObjectIdentifier CAMELLIA128_WRAP = NTTObjectIdentifiers.id_camellia128_wrap.m14434intern();
    public static final ASN1ObjectIdentifier CAMELLIA192_WRAP = NTTObjectIdentifiers.id_camellia192_wrap.m14434intern();
    public static final ASN1ObjectIdentifier CAMELLIA256_WRAP = NTTObjectIdentifiers.id_camellia256_wrap.m14434intern();
    public static final ASN1ObjectIdentifier SEED_WRAP = KISAObjectIdentifiers.id_npki_app_cmsSeed_wrap.m14434intern();
    public static final ASN1ObjectIdentifier GOST28147_WRAP = CryptoProObjectIdentifiers.id_Gost28147_89_None_KeyWrap.m14434intern();
    public static final ASN1ObjectIdentifier GOST28147_CRYPTOPRO_WRAP = CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_KeyWrap.m14434intern();
    public static final ASN1ObjectIdentifier ECDH_SHA1KDF = X9ObjectIdentifiers.dhSinglePass_stdDH_sha1kdf_scheme.m14434intern();
    public static final ASN1ObjectIdentifier ECCDH_SHA1KDF = X9ObjectIdentifiers.dhSinglePass_cofactorDH_sha1kdf_scheme.m14434intern();
    public static final ASN1ObjectIdentifier ECMQV_SHA1KDF = X9ObjectIdentifiers.mqvSinglePass_sha1kdf_scheme.m14434intern();
    public static final ASN1ObjectIdentifier ECDH_SHA224KDF = SECObjectIdentifiers.dhSinglePass_stdDH_sha224kdf_scheme.m14434intern();
    public static final ASN1ObjectIdentifier ECCDH_SHA224KDF = SECObjectIdentifiers.dhSinglePass_cofactorDH_sha224kdf_scheme.m14434intern();
    public static final ASN1ObjectIdentifier ECMQV_SHA224KDF = SECObjectIdentifiers.mqvSinglePass_sha224kdf_scheme.m14434intern();
    public static final ASN1ObjectIdentifier ECDH_SHA256KDF = SECObjectIdentifiers.dhSinglePass_stdDH_sha256kdf_scheme.m14434intern();
    public static final ASN1ObjectIdentifier ECCDH_SHA256KDF = SECObjectIdentifiers.dhSinglePass_cofactorDH_sha256kdf_scheme.m14434intern();
    public static final ASN1ObjectIdentifier ECMQV_SHA256KDF = SECObjectIdentifiers.mqvSinglePass_sha256kdf_scheme.m14434intern();
    public static final ASN1ObjectIdentifier ECDH_SHA384KDF = SECObjectIdentifiers.dhSinglePass_stdDH_sha384kdf_scheme.m14434intern();
    public static final ASN1ObjectIdentifier ECCDH_SHA384KDF = SECObjectIdentifiers.dhSinglePass_cofactorDH_sha384kdf_scheme.m14434intern();
    public static final ASN1ObjectIdentifier ECMQV_SHA384KDF = SECObjectIdentifiers.mqvSinglePass_sha384kdf_scheme.m14434intern();
    public static final ASN1ObjectIdentifier ECDH_SHA512KDF = SECObjectIdentifiers.dhSinglePass_stdDH_sha512kdf_scheme.m14434intern();
    public static final ASN1ObjectIdentifier ECCDH_SHA512KDF = SECObjectIdentifiers.dhSinglePass_cofactorDH_sha512kdf_scheme.m14434intern();
    public static final ASN1ObjectIdentifier ECMQV_SHA512KDF = SECObjectIdentifiers.mqvSinglePass_sha512kdf_scheme.m14434intern();
    public static final ASN1ObjectIdentifier ECDHGOST3410_2001 = CryptoProObjectIdentifiers.gostR3410_2001.m14434intern();
    public static final ASN1ObjectIdentifier ECDHGOST3410_2012_256 = RosstandartObjectIdentifiers.id_tc26_agreement_gost_3410_12_256.m14434intern();
    public static final ASN1ObjectIdentifier ECDHGOST3410_2012_512 = RosstandartObjectIdentifiers.id_tc26_agreement_gost_3410_12_512.m14434intern();
    public static final ASN1ObjectIdentifier ECKA_EG_X963KDF = BSIObjectIdentifiers.ecka_eg_X963kdf;
    public static final ASN1ObjectIdentifier ECKA_EG_X963KDF_SHA256 = BSIObjectIdentifiers.ecka_eg_X963kdf_SHA256;
    public static final ASN1ObjectIdentifier ECKA_EG_X963KDF_SHA384 = BSIObjectIdentifiers.ecka_eg_X963kdf_SHA384;
    public static final ASN1ObjectIdentifier ECKA_EG_X963KDF_SHA512 = BSIObjectIdentifiers.ecka_eg_X963kdf_SHA512;
    public static final ASN1ObjectIdentifier RSA_PKCS15 = PKCSObjectIdentifiers.rsaEncryption;
    public static final ASN1ObjectIdentifier RSA_OAEP = PKCSObjectIdentifiers.id_RSAES_OAEP;

    /* renamed from: RSA_KEM */
    public static final ASN1ObjectIdentifier f18930RSA_KEM = PKCSObjectIdentifiers.id_rsa_KEM;

    /* renamed from: SHA1 */
    public static final ASN1ObjectIdentifier f18931SHA1 = OIWObjectIdentifiers.f18459idSHA1.m14434intern();

    /* renamed from: SHA224 */
    public static final ASN1ObjectIdentifier f18932SHA224 = NISTObjectIdentifiers.id_sha224.m14434intern();

    /* renamed from: SHA256 */
    public static final ASN1ObjectIdentifier f18933SHA256 = NISTObjectIdentifiers.id_sha256.m14434intern();

    /* renamed from: SHA384 */
    public static final ASN1ObjectIdentifier f18934SHA384 = NISTObjectIdentifiers.id_sha384.m14434intern();

    /* renamed from: SHA512 */
    public static final ASN1ObjectIdentifier f18935SHA512 = NISTObjectIdentifiers.id_sha512.m14434intern();

    /* renamed from: MD5 */
    public static final ASN1ObjectIdentifier f18928MD5 = PKCSObjectIdentifiers.f18503md5.m14434intern();
    public static final ASN1ObjectIdentifier GOST3411 = CryptoProObjectIdentifiers.gostR3411.m14434intern();
    public static final ASN1ObjectIdentifier GOST3411_2012_256 = RosstandartObjectIdentifiers.id_tc26_gost_3411_12_256.m14434intern();
    public static final ASN1ObjectIdentifier GOST3411_2012_512 = RosstandartObjectIdentifiers.id_tc26_gost_3411_12_512.m14434intern();
    public static final ASN1ObjectIdentifier RIPEMD128 = TeleTrusTObjectIdentifiers.ripemd128.m14434intern();
    public static final ASN1ObjectIdentifier RIPEMD160 = TeleTrusTObjectIdentifiers.ripemd160.m14434intern();
    public static final ASN1ObjectIdentifier RIPEMD256 = TeleTrusTObjectIdentifiers.ripemd256.m14434intern();
    public static final ASN1ObjectIdentifier SHAKE128_LEN = NISTObjectIdentifiers.id_shake128_len.m14434intern();
    public static final ASN1ObjectIdentifier SHAKE256_LEN = NISTObjectIdentifiers.id_shake256_len.m14434intern();
    public static final ASN1ObjectIdentifier ChaCha20Poly1305 = PKCSObjectIdentifiers.id_alg_AEADChaCha20Poly1305.m14434intern();
    public static final AlgorithmIdentifier SHAKE128_XOF = new AlgorithmIdentifier(NISTObjectIdentifiers.id_shake128);
    public static final AlgorithmIdentifier SHAKE256_XOF = new AlgorithmIdentifier(NISTObjectIdentifiers.id_shake256);
    public static final AlgorithmIdentifier SHA256_HKDF = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_alg_hkdf_with_sha256);
    public static final AlgorithmIdentifier SHA384_HKDF = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_alg_hkdf_with_sha384);
    public static final AlgorithmIdentifier SHA512_HKDF = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_alg_hkdf_with_sha512);
}
