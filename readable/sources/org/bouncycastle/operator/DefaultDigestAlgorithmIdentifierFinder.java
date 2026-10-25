package org.bouncycastle.operator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.p135bc.BCObjectIdentifiers;
import org.bouncycastle.p133asn1.p136bsi.BSIObjectIdentifiers;
import org.bouncycastle.p133asn1.p143eac.EACObjectIdentifiers;
import org.bouncycastle.p133asn1.p144edec.EdECObjectIdentifiers;
import org.bouncycastle.p133asn1.p148gm.GMObjectIdentifiers;
import org.bouncycastle.p133asn1.p150iana.IANAObjectIdentifiers;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.RSASSAPSSparams;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.X509ObjectIdentifiers;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p133asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.p133asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyParameters;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.SPHINCS256KeyGenParameterSpec;

/* loaded from: classes2.dex */
public class DefaultDigestAlgorithmIdentifierFinder implements DigestAlgorithmIdentifierFinder {
    public static DigestAlgorithmIdentifierFinder INSTANCE;
    private static Map digestOids = new HashMap();
    private static Map digestNameToOids = new HashMap();
    private static Map digestOidToAlgIds = new HashMap();
    private static Set shake256oids = new HashSet();

    static {
        Map map = digestOids;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = OIWObjectIdentifiers.dsaWithSHA1;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = OIWObjectIdentifiers.f18459idSHA1;
        map.put(aSN1ObjectIdentifier, aSN1ObjectIdentifier2);
        Map map2 = digestOids;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = OIWObjectIdentifiers.md4WithRSAEncryption;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = PKCSObjectIdentifiers.f18502md4;
        map2.put(aSN1ObjectIdentifier3, aSN1ObjectIdentifier4);
        digestOids.put(OIWObjectIdentifiers.md4WithRSA, aSN1ObjectIdentifier4);
        Map map3 = digestOids;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = OIWObjectIdentifiers.md5WithRSA;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = PKCSObjectIdentifiers.f18503md5;
        map3.put(aSN1ObjectIdentifier5, aSN1ObjectIdentifier6);
        digestOids.put(OIWObjectIdentifiers.sha1WithRSA, aSN1ObjectIdentifier2);
        Map map4 = digestOids;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = PKCSObjectIdentifiers.sha224WithRSAEncryption;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = NISTObjectIdentifiers.id_sha224;
        map4.put(aSN1ObjectIdentifier7, aSN1ObjectIdentifier8);
        Map map5 = digestOids;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = PKCSObjectIdentifiers.sha256WithRSAEncryption;
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = NISTObjectIdentifiers.id_sha256;
        map5.put(aSN1ObjectIdentifier9, aSN1ObjectIdentifier10);
        Map map6 = digestOids;
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = PKCSObjectIdentifiers.sha384WithRSAEncryption;
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = NISTObjectIdentifiers.id_sha384;
        map6.put(aSN1ObjectIdentifier11, aSN1ObjectIdentifier12);
        Map map7 = digestOids;
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = PKCSObjectIdentifiers.sha512WithRSAEncryption;
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = NISTObjectIdentifiers.id_sha512;
        map7.put(aSN1ObjectIdentifier13, aSN1ObjectIdentifier14);
        Map map8 = digestOids;
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = PKCSObjectIdentifiers.sha512_224WithRSAEncryption;
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = NISTObjectIdentifiers.id_sha512_224;
        map8.put(aSN1ObjectIdentifier15, aSN1ObjectIdentifier16);
        Map map9 = digestOids;
        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = PKCSObjectIdentifiers.sha512_256WithRSAEncryption;
        ASN1ObjectIdentifier aSN1ObjectIdentifier18 = NISTObjectIdentifiers.id_sha512_256;
        map9.put(aSN1ObjectIdentifier17, aSN1ObjectIdentifier18);
        Map map10 = digestOids;
        ASN1ObjectIdentifier aSN1ObjectIdentifier19 = PKCSObjectIdentifiers.md2WithRSAEncryption;
        ASN1ObjectIdentifier aSN1ObjectIdentifier20 = PKCSObjectIdentifiers.f18501md2;
        map10.put(aSN1ObjectIdentifier19, aSN1ObjectIdentifier20);
        digestOids.put(PKCSObjectIdentifiers.md4WithRSAEncryption, aSN1ObjectIdentifier4);
        digestOids.put(PKCSObjectIdentifiers.md5WithRSAEncryption, aSN1ObjectIdentifier6);
        digestOids.put(PKCSObjectIdentifiers.sha1WithRSAEncryption, aSN1ObjectIdentifier2);
        digestOids.put(X9ObjectIdentifiers.ecdsa_with_SHA1, aSN1ObjectIdentifier2);
        digestOids.put(X9ObjectIdentifiers.ecdsa_with_SHA224, aSN1ObjectIdentifier8);
        digestOids.put(X9ObjectIdentifiers.ecdsa_with_SHA256, aSN1ObjectIdentifier10);
        digestOids.put(X9ObjectIdentifiers.ecdsa_with_SHA384, aSN1ObjectIdentifier12);
        digestOids.put(X9ObjectIdentifiers.ecdsa_with_SHA512, aSN1ObjectIdentifier14);
        digestOids.put(X9ObjectIdentifiers.id_dsa_with_sha1, aSN1ObjectIdentifier2);
        digestOids.put(BSIObjectIdentifiers.ecdsa_plain_SHA1, aSN1ObjectIdentifier2);
        digestOids.put(BSIObjectIdentifiers.ecdsa_plain_SHA224, aSN1ObjectIdentifier8);
        digestOids.put(BSIObjectIdentifiers.ecdsa_plain_SHA256, aSN1ObjectIdentifier10);
        digestOids.put(BSIObjectIdentifiers.ecdsa_plain_SHA384, aSN1ObjectIdentifier12);
        digestOids.put(BSIObjectIdentifiers.ecdsa_plain_SHA512, aSN1ObjectIdentifier14);
        Map map11 = digestOids;
        ASN1ObjectIdentifier aSN1ObjectIdentifier21 = BSIObjectIdentifiers.ecdsa_plain_SHA3_224;
        ASN1ObjectIdentifier aSN1ObjectIdentifier22 = NISTObjectIdentifiers.id_sha3_224;
        map11.put(aSN1ObjectIdentifier21, aSN1ObjectIdentifier22);
        Map map12 = digestOids;
        ASN1ObjectIdentifier aSN1ObjectIdentifier23 = BSIObjectIdentifiers.ecdsa_plain_SHA3_256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier24 = NISTObjectIdentifiers.id_sha3_256;
        map12.put(aSN1ObjectIdentifier23, aSN1ObjectIdentifier24);
        Map map13 = digestOids;
        ASN1ObjectIdentifier aSN1ObjectIdentifier25 = BSIObjectIdentifiers.ecdsa_plain_SHA3_384;
        ASN1ObjectIdentifier aSN1ObjectIdentifier26 = NISTObjectIdentifiers.id_sha3_384;
        map13.put(aSN1ObjectIdentifier25, aSN1ObjectIdentifier26);
        Map map14 = digestOids;
        ASN1ObjectIdentifier aSN1ObjectIdentifier27 = BSIObjectIdentifiers.ecdsa_plain_SHA3_512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier28 = NISTObjectIdentifiers.id_sha3_512;
        map14.put(aSN1ObjectIdentifier27, aSN1ObjectIdentifier28);
        Map map15 = digestOids;
        ASN1ObjectIdentifier aSN1ObjectIdentifier29 = BSIObjectIdentifiers.ecdsa_plain_RIPEMD160;
        ASN1ObjectIdentifier aSN1ObjectIdentifier30 = TeleTrusTObjectIdentifiers.ripemd160;
        map15.put(aSN1ObjectIdentifier29, aSN1ObjectIdentifier30);
        digestOids.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_1, aSN1ObjectIdentifier2);
        digestOids.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_224, aSN1ObjectIdentifier8);
        digestOids.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_256, aSN1ObjectIdentifier10);
        digestOids.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_384, aSN1ObjectIdentifier12);
        digestOids.put(EACObjectIdentifiers.id_TA_ECDSA_SHA_512, aSN1ObjectIdentifier14);
        digestOids.put(NISTObjectIdentifiers.dsa_with_sha224, aSN1ObjectIdentifier8);
        digestOids.put(NISTObjectIdentifiers.dsa_with_sha256, aSN1ObjectIdentifier10);
        digestOids.put(NISTObjectIdentifiers.dsa_with_sha384, aSN1ObjectIdentifier12);
        digestOids.put(NISTObjectIdentifiers.dsa_with_sha512, aSN1ObjectIdentifier14);
        digestOids.put(NISTObjectIdentifiers.id_rsassa_pkcs1_v1_5_with_sha3_224, aSN1ObjectIdentifier22);
        digestOids.put(NISTObjectIdentifiers.id_rsassa_pkcs1_v1_5_with_sha3_256, aSN1ObjectIdentifier24);
        digestOids.put(NISTObjectIdentifiers.id_rsassa_pkcs1_v1_5_with_sha3_384, aSN1ObjectIdentifier26);
        digestOids.put(NISTObjectIdentifiers.id_rsassa_pkcs1_v1_5_with_sha3_512, aSN1ObjectIdentifier28);
        digestOids.put(NISTObjectIdentifiers.id_dsa_with_sha3_224, aSN1ObjectIdentifier22);
        digestOids.put(NISTObjectIdentifiers.id_dsa_with_sha3_256, aSN1ObjectIdentifier24);
        digestOids.put(NISTObjectIdentifiers.id_dsa_with_sha3_384, aSN1ObjectIdentifier26);
        digestOids.put(NISTObjectIdentifiers.id_dsa_with_sha3_512, aSN1ObjectIdentifier28);
        digestOids.put(NISTObjectIdentifiers.id_ecdsa_with_sha3_224, aSN1ObjectIdentifier22);
        digestOids.put(NISTObjectIdentifiers.id_ecdsa_with_sha3_256, aSN1ObjectIdentifier24);
        digestOids.put(NISTObjectIdentifiers.id_ecdsa_with_sha3_384, aSN1ObjectIdentifier26);
        digestOids.put(NISTObjectIdentifiers.id_ecdsa_with_sha3_512, aSN1ObjectIdentifier28);
        Map map16 = digestOids;
        ASN1ObjectIdentifier aSN1ObjectIdentifier31 = TeleTrusTObjectIdentifiers.rsaSignatureWithripemd128;
        ASN1ObjectIdentifier aSN1ObjectIdentifier32 = TeleTrusTObjectIdentifiers.ripemd128;
        map16.put(aSN1ObjectIdentifier31, aSN1ObjectIdentifier32);
        digestOids.put(TeleTrusTObjectIdentifiers.rsaSignatureWithripemd160, aSN1ObjectIdentifier30);
        Map map17 = digestOids;
        ASN1ObjectIdentifier aSN1ObjectIdentifier33 = TeleTrusTObjectIdentifiers.rsaSignatureWithripemd256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier34 = TeleTrusTObjectIdentifiers.ripemd256;
        map17.put(aSN1ObjectIdentifier33, aSN1ObjectIdentifier34);
        Map map18 = digestOids;
        ASN1ObjectIdentifier aSN1ObjectIdentifier35 = CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_94;
        ASN1ObjectIdentifier aSN1ObjectIdentifier36 = CryptoProObjectIdentifiers.gostR3411;
        map18.put(aSN1ObjectIdentifier35, aSN1ObjectIdentifier36);
        digestOids.put(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001, aSN1ObjectIdentifier36);
        Map map19 = digestOids;
        ASN1ObjectIdentifier aSN1ObjectIdentifier37 = RosstandartObjectIdentifiers.id_tc26_signwithdigest_gost_3410_12_256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier38 = RosstandartObjectIdentifiers.id_tc26_gost_3411_12_256;
        map19.put(aSN1ObjectIdentifier37, aSN1ObjectIdentifier38);
        Map map20 = digestOids;
        ASN1ObjectIdentifier aSN1ObjectIdentifier39 = RosstandartObjectIdentifiers.id_tc26_signwithdigest_gost_3410_12_512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier40 = RosstandartObjectIdentifiers.id_tc26_gost_3411_12_512;
        map20.put(aSN1ObjectIdentifier39, aSN1ObjectIdentifier40);
        digestOids.put(BCObjectIdentifiers.sphincs256_with_SHA3_512, aSN1ObjectIdentifier28);
        digestOids.put(BCObjectIdentifiers.sphincs256_with_SHA512, aSN1ObjectIdentifier14);
        digestOids.put(BCObjectIdentifiers.sphincsPlus_sha2_128s_r3, aSN1ObjectIdentifier10);
        digestOids.put(BCObjectIdentifiers.sphincsPlus_sha2_128f_r3, aSN1ObjectIdentifier10);
        Map map21 = digestOids;
        ASN1ObjectIdentifier aSN1ObjectIdentifier41 = BCObjectIdentifiers.sphincsPlus_shake_128s_r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier42 = NISTObjectIdentifiers.id_shake256;
        map21.put(aSN1ObjectIdentifier41, aSN1ObjectIdentifier42);
        digestOids.put(BCObjectIdentifiers.sphincsPlus_shake_128f_r3, aSN1ObjectIdentifier42);
        digestOids.put(BCObjectIdentifiers.sphincsPlus_sha2_192s_r3, aSN1ObjectIdentifier10);
        digestOids.put(BCObjectIdentifiers.sphincsPlus_sha2_192f_r3, aSN1ObjectIdentifier10);
        digestOids.put(BCObjectIdentifiers.sphincsPlus_shake_192s_r3, aSN1ObjectIdentifier42);
        digestOids.put(BCObjectIdentifiers.sphincsPlus_shake_192f_r3, aSN1ObjectIdentifier42);
        digestOids.put(BCObjectIdentifiers.sphincsPlus_sha2_256s_r3, aSN1ObjectIdentifier10);
        digestOids.put(BCObjectIdentifiers.sphincsPlus_sha2_256f_r3, aSN1ObjectIdentifier10);
        digestOids.put(BCObjectIdentifiers.sphincsPlus_shake_256s_r3, aSN1ObjectIdentifier42);
        digestOids.put(BCObjectIdentifiers.sphincsPlus_shake_256f_r3, aSN1ObjectIdentifier42);
        digestOids.put(BCObjectIdentifiers.sphincsPlus_sha2_128s_r3_simple, aSN1ObjectIdentifier10);
        digestOids.put(BCObjectIdentifiers.sphincsPlus_sha2_128f_r3_simple, aSN1ObjectIdentifier10);
        digestOids.put(BCObjectIdentifiers.sphincsPlus_shake_128s_r3_simple, aSN1ObjectIdentifier42);
        digestOids.put(BCObjectIdentifiers.sphincsPlus_shake_128f_r3_simple, aSN1ObjectIdentifier42);
        digestOids.put(BCObjectIdentifiers.sphincsPlus_sha2_192s_r3_simple, aSN1ObjectIdentifier10);
        digestOids.put(BCObjectIdentifiers.sphincsPlus_sha2_192f_r3_simple, aSN1ObjectIdentifier10);
        digestOids.put(BCObjectIdentifiers.sphincsPlus_shake_192s_r3_simple, aSN1ObjectIdentifier42);
        digestOids.put(BCObjectIdentifiers.sphincsPlus_shake_192f_r3_simple, aSN1ObjectIdentifier42);
        digestOids.put(BCObjectIdentifiers.sphincsPlus_sha2_256s_r3_simple, aSN1ObjectIdentifier10);
        digestOids.put(BCObjectIdentifiers.sphincsPlus_sha2_256f_r3_simple, aSN1ObjectIdentifier10);
        digestOids.put(BCObjectIdentifiers.sphincsPlus_shake_256s_r3_simple, aSN1ObjectIdentifier42);
        digestOids.put(BCObjectIdentifiers.sphincsPlus_shake_256f_r3_simple, aSN1ObjectIdentifier42);
        digestOids.put(NISTObjectIdentifiers.id_slh_dsa_sha2_128s, aSN1ObjectIdentifier10);
        digestOids.put(NISTObjectIdentifiers.id_slh_dsa_sha2_128f, aSN1ObjectIdentifier10);
        digestOids.put(NISTObjectIdentifiers.id_slh_dsa_sha2_192s, aSN1ObjectIdentifier14);
        digestOids.put(NISTObjectIdentifiers.id_slh_dsa_sha2_192f, aSN1ObjectIdentifier14);
        digestOids.put(NISTObjectIdentifiers.id_slh_dsa_sha2_256s, aSN1ObjectIdentifier14);
        digestOids.put(NISTObjectIdentifiers.id_slh_dsa_sha2_256f, aSN1ObjectIdentifier14);
        digestOids.put(NISTObjectIdentifiers.id_hash_slh_dsa_sha2_128s_with_sha256, aSN1ObjectIdentifier10);
        digestOids.put(NISTObjectIdentifiers.id_hash_slh_dsa_sha2_128f_with_sha256, aSN1ObjectIdentifier10);
        digestOids.put(NISTObjectIdentifiers.id_hash_slh_dsa_sha2_192s_with_sha512, aSN1ObjectIdentifier14);
        digestOids.put(NISTObjectIdentifiers.id_hash_slh_dsa_sha2_192f_with_sha512, aSN1ObjectIdentifier14);
        digestOids.put(NISTObjectIdentifiers.id_hash_slh_dsa_sha2_256s_with_sha512, aSN1ObjectIdentifier14);
        digestOids.put(NISTObjectIdentifiers.id_hash_slh_dsa_sha2_256f_with_sha512, aSN1ObjectIdentifier14);
        Map map22 = digestOids;
        ASN1ObjectIdentifier aSN1ObjectIdentifier43 = NISTObjectIdentifiers.id_slh_dsa_shake_128s;
        ASN1ObjectIdentifier aSN1ObjectIdentifier44 = NISTObjectIdentifiers.id_shake128;
        map22.put(aSN1ObjectIdentifier43, aSN1ObjectIdentifier44);
        digestOids.put(NISTObjectIdentifiers.id_slh_dsa_shake_128f, aSN1ObjectIdentifier44);
        digestOids.put(NISTObjectIdentifiers.id_slh_dsa_shake_192s, aSN1ObjectIdentifier42);
        digestOids.put(NISTObjectIdentifiers.id_slh_dsa_shake_192f, aSN1ObjectIdentifier42);
        digestOids.put(NISTObjectIdentifiers.id_slh_dsa_shake_256s, aSN1ObjectIdentifier42);
        digestOids.put(NISTObjectIdentifiers.id_slh_dsa_shake_256f, aSN1ObjectIdentifier42);
        digestOids.put(NISTObjectIdentifiers.id_hash_slh_dsa_shake_128s_with_shake128, aSN1ObjectIdentifier44);
        digestOids.put(NISTObjectIdentifiers.id_hash_slh_dsa_shake_128f_with_shake128, aSN1ObjectIdentifier44);
        digestOids.put(NISTObjectIdentifiers.id_hash_slh_dsa_shake_192s_with_shake256, aSN1ObjectIdentifier42);
        digestOids.put(NISTObjectIdentifiers.id_hash_slh_dsa_shake_192f_with_shake256, aSN1ObjectIdentifier42);
        digestOids.put(NISTObjectIdentifiers.id_hash_slh_dsa_shake_256s_with_shake256, aSN1ObjectIdentifier42);
        digestOids.put(NISTObjectIdentifiers.id_hash_slh_dsa_shake_256f_with_shake256, aSN1ObjectIdentifier42);
        digestOids.put(NISTObjectIdentifiers.id_ml_dsa_44, aSN1ObjectIdentifier14);
        digestOids.put(NISTObjectIdentifiers.id_ml_dsa_65, aSN1ObjectIdentifier14);
        digestOids.put(NISTObjectIdentifiers.id_ml_dsa_87, aSN1ObjectIdentifier14);
        digestOids.put(NISTObjectIdentifiers.id_hash_ml_dsa_44_with_sha512, aSN1ObjectIdentifier14);
        digestOids.put(NISTObjectIdentifiers.id_hash_ml_dsa_65_with_sha512, aSN1ObjectIdentifier14);
        digestOids.put(NISTObjectIdentifiers.id_hash_ml_dsa_87_with_sha512, aSN1ObjectIdentifier14);
        digestOids.put(IANAObjectIdentifiers.id_MLDSA44_RSA2048_PSS_SHA256, aSN1ObjectIdentifier14);
        digestOids.put(IANAObjectIdentifiers.id_MLDSA44_RSA2048_PKCS15_SHA256, aSN1ObjectIdentifier14);
        digestOids.put(IANAObjectIdentifiers.id_MLDSA44_Ed25519_SHA512, aSN1ObjectIdentifier14);
        digestOids.put(IANAObjectIdentifiers.id_MLDSA44_ECDSA_P256_SHA256, aSN1ObjectIdentifier14);
        digestOids.put(IANAObjectIdentifiers.id_MLDSA65_RSA3072_PSS_SHA512, aSN1ObjectIdentifier14);
        digestOids.put(IANAObjectIdentifiers.id_MLDSA65_RSA3072_PKCS15_SHA512, aSN1ObjectIdentifier14);
        digestOids.put(IANAObjectIdentifiers.id_MLDSA65_RSA4096_PSS_SHA512, aSN1ObjectIdentifier14);
        digestOids.put(IANAObjectIdentifiers.id_MLDSA65_RSA4096_PKCS15_SHA512, aSN1ObjectIdentifier14);
        digestOids.put(IANAObjectIdentifiers.id_MLDSA65_ECDSA_P256_SHA512, aSN1ObjectIdentifier14);
        digestOids.put(IANAObjectIdentifiers.id_MLDSA65_ECDSA_P384_SHA512, aSN1ObjectIdentifier14);
        digestOids.put(IANAObjectIdentifiers.id_MLDSA65_ECDSA_brainpoolP256r1_SHA512, aSN1ObjectIdentifier14);
        digestOids.put(IANAObjectIdentifiers.id_MLDSA65_Ed25519_SHA512, aSN1ObjectIdentifier14);
        digestOids.put(IANAObjectIdentifiers.id_MLDSA87_ECDSA_P384_SHA512, aSN1ObjectIdentifier14);
        digestOids.put(IANAObjectIdentifiers.id_MLDSA87_ECDSA_brainpoolP384r1_SHA512, aSN1ObjectIdentifier14);
        digestOids.put(IANAObjectIdentifiers.id_MLDSA87_Ed448_SHAKE256, aSN1ObjectIdentifier14);
        digestOids.put(IANAObjectIdentifiers.id_MLDSA87_RSA4096_PSS_SHA512, aSN1ObjectIdentifier14);
        digestOids.put(IANAObjectIdentifiers.id_MLDSA87_ECDSA_P521_SHA512, aSN1ObjectIdentifier14);
        digestOids.put(IANAObjectIdentifiers.id_MLDSA87_RSA3072_PSS_SHA512, aSN1ObjectIdentifier14);
        digestOids.put(BCObjectIdentifiers.f18022falcon, aSN1ObjectIdentifier42);
        Map map23 = digestOids;
        ASN1ObjectIdentifier aSN1ObjectIdentifier45 = BCObjectIdentifiers.falcon_512;
        map23.put(aSN1ObjectIdentifier45, aSN1ObjectIdentifier42);
        Map map24 = digestOids;
        ASN1ObjectIdentifier aSN1ObjectIdentifier46 = BCObjectIdentifiers.falcon_1024;
        map24.put(aSN1ObjectIdentifier46, aSN1ObjectIdentifier42);
        digestOids.put(BCObjectIdentifiers.picnic_signature, aSN1ObjectIdentifier42);
        digestOids.put(BCObjectIdentifiers.picnic_with_sha512, aSN1ObjectIdentifier14);
        digestOids.put(BCObjectIdentifiers.picnic_with_sha3_512, aSN1ObjectIdentifier28);
        digestOids.put(BCObjectIdentifiers.picnic_with_shake256, aSN1ObjectIdentifier42);
        digestOids.put(GMObjectIdentifiers.sm2sign_with_sha256, aSN1ObjectIdentifier10);
        Map map25 = digestOids;
        ASN1ObjectIdentifier aSN1ObjectIdentifier47 = GMObjectIdentifiers.sm2sign_with_sm3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier48 = GMObjectIdentifiers.f18386sm3;
        map25.put(aSN1ObjectIdentifier47, aSN1ObjectIdentifier48);
        digestOids.put(X509ObjectIdentifiers.id_rsassa_pss_shake128, aSN1ObjectIdentifier44);
        digestOids.put(X509ObjectIdentifiers.id_rsassa_pss_shake256, aSN1ObjectIdentifier42);
        digestOids.put(X509ObjectIdentifiers.id_ecdsa_with_shake128, aSN1ObjectIdentifier44);
        digestOids.put(X509ObjectIdentifiers.id_ecdsa_with_shake256, aSN1ObjectIdentifier42);
        digestOids.put(EdECObjectIdentifiers.id_Ed25519, aSN1ObjectIdentifier14);
        digestNameToOids.put("SHA-1", aSN1ObjectIdentifier2);
        digestNameToOids.put("SHA-224", aSN1ObjectIdentifier8);
        digestNameToOids.put(XMSSKeyParameters.f23621SHA_256, aSN1ObjectIdentifier10);
        digestNameToOids.put("SHA-384", aSN1ObjectIdentifier12);
        digestNameToOids.put(XMSSKeyParameters.f23622SHA_512, aSN1ObjectIdentifier14);
        digestNameToOids.put("SHA-512-224", aSN1ObjectIdentifier16);
        digestNameToOids.put("SHA-512-256", aSN1ObjectIdentifier18);
        digestNameToOids.put("SHA1", aSN1ObjectIdentifier2);
        digestNameToOids.put("SHA224", aSN1ObjectIdentifier8);
        digestNameToOids.put("SHA256", aSN1ObjectIdentifier10);
        digestNameToOids.put("SHA384", aSN1ObjectIdentifier12);
        digestNameToOids.put("SHA512", aSN1ObjectIdentifier14);
        digestNameToOids.put("SHA512-224", aSN1ObjectIdentifier16);
        digestNameToOids.put(SPHINCS256KeyGenParameterSpec.SHA512_256, aSN1ObjectIdentifier18);
        digestNameToOids.put("SHA3-224", aSN1ObjectIdentifier22);
        digestNameToOids.put("SHA3-256", aSN1ObjectIdentifier24);
        digestNameToOids.put("SHA3-384", aSN1ObjectIdentifier26);
        digestNameToOids.put("SHA3-512", aSN1ObjectIdentifier28);
        digestNameToOids.put("SHAKE128", aSN1ObjectIdentifier44);
        digestNameToOids.put("SHAKE256", aSN1ObjectIdentifier42);
        digestNameToOids.put("SHAKE-128", aSN1ObjectIdentifier44);
        digestNameToOids.put("SHAKE-256", aSN1ObjectIdentifier42);
        digestNameToOids.put("GOST3411", aSN1ObjectIdentifier36);
        digestNameToOids.put("GOST3411-2012-256", aSN1ObjectIdentifier38);
        digestNameToOids.put("GOST3411-2012-512", aSN1ObjectIdentifier40);
        digestNameToOids.put("MD2", aSN1ObjectIdentifier20);
        digestNameToOids.put("MD4", aSN1ObjectIdentifier4);
        digestNameToOids.put("MD5", aSN1ObjectIdentifier6);
        digestNameToOids.put("RIPEMD128", aSN1ObjectIdentifier32);
        digestNameToOids.put("RIPEMD160", aSN1ObjectIdentifier30);
        digestNameToOids.put("RIPEMD256", aSN1ObjectIdentifier34);
        digestNameToOids.put("SM3", aSN1ObjectIdentifier48);
        addDigestAlgId(aSN1ObjectIdentifier2, true);
        addDigestAlgId(aSN1ObjectIdentifier8, false);
        addDigestAlgId(aSN1ObjectIdentifier10, false);
        addDigestAlgId(aSN1ObjectIdentifier12, false);
        addDigestAlgId(aSN1ObjectIdentifier14, false);
        addDigestAlgId(aSN1ObjectIdentifier16, false);
        addDigestAlgId(aSN1ObjectIdentifier18, false);
        addDigestAlgId(aSN1ObjectIdentifier22, false);
        addDigestAlgId(aSN1ObjectIdentifier24, false);
        addDigestAlgId(aSN1ObjectIdentifier26, false);
        addDigestAlgId(aSN1ObjectIdentifier28, false);
        addDigestAlgId(aSN1ObjectIdentifier44, false);
        addDigestAlgId(aSN1ObjectIdentifier42, false);
        addDigestAlgId(aSN1ObjectIdentifier36, true);
        addDigestAlgId(aSN1ObjectIdentifier38, false);
        addDigestAlgId(aSN1ObjectIdentifier40, false);
        addDigestAlgId(aSN1ObjectIdentifier20, true);
        addDigestAlgId(aSN1ObjectIdentifier4, true);
        addDigestAlgId(aSN1ObjectIdentifier6, true);
        addDigestAlgId(aSN1ObjectIdentifier32, true);
        addDigestAlgId(aSN1ObjectIdentifier30, true);
        addDigestAlgId(aSN1ObjectIdentifier34, true);
        shake256oids.add(EdECObjectIdentifiers.id_Ed448);
        shake256oids.add(BCObjectIdentifiers.dilithium2);
        shake256oids.add(BCObjectIdentifiers.dilithium3);
        shake256oids.add(BCObjectIdentifiers.dilithium5);
        shake256oids.add(BCObjectIdentifiers.dilithium2_aes);
        shake256oids.add(BCObjectIdentifiers.dilithium3_aes);
        shake256oids.add(BCObjectIdentifiers.dilithium5_aes);
        shake256oids.add(aSN1ObjectIdentifier45);
        shake256oids.add(aSN1ObjectIdentifier46);
        INSTANCE = new DefaultDigestAlgorithmIdentifierFinder();
    }

    private static void addDigestAlgId(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z) {
        digestOidToAlgIds.put(aSN1ObjectIdentifier, z ? new AlgorithmIdentifier(aSN1ObjectIdentifier, C5103DERNull.INSTANCE) : new AlgorithmIdentifier(aSN1ObjectIdentifier));
    }

    @Override // org.bouncycastle.operator.DigestAlgorithmIdentifierFinder
    /* renamed from: find */
    public AlgorithmIdentifier mo17380find(String str) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) digestNameToOids.get(str);
        if (aSN1ObjectIdentifier != null) {
            return mo17381find(aSN1ObjectIdentifier);
        }
        try {
            return mo17381find(new ASN1ObjectIdentifier(str));
        } catch (RuntimeException unused) {
            return null;
        }
    }

    @Override // org.bouncycastle.operator.DigestAlgorithmIdentifierFinder
    /* renamed from: find */
    public AlgorithmIdentifier mo17381find(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (aSN1ObjectIdentifier == null) {
            throw new NullPointerException("digest OID is null");
        }
        AlgorithmIdentifier algorithmIdentifier = (AlgorithmIdentifier) digestOidToAlgIds.get(aSN1ObjectIdentifier);
        return algorithmIdentifier == null ? new AlgorithmIdentifier(aSN1ObjectIdentifier) : algorithmIdentifier;
    }

    @Override // org.bouncycastle.operator.DigestAlgorithmIdentifierFinder
    /* renamed from: find */
    public AlgorithmIdentifier mo17382find(AlgorithmIdentifier algorithmIdentifier) {
        ASN1ObjectIdentifier algorithm = algorithmIdentifier.getAlgorithm();
        if (shake256oids.contains(algorithm)) {
            return !algorithm.m14446equals((ASN1Primitive) EdECObjectIdentifiers.id_Ed448) ? new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256) : new AlgorithmIdentifier(NISTObjectIdentifiers.id_shake256_len, ASN1Integer.m14429valueOf(512));
        }
        ASN1ObjectIdentifier algorithm2 = algorithm.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.id_RSASSA_PSS) ? RSASSAPSSparams.getInstance(algorithmIdentifier.getParameters()).getHashAlgorithm().getAlgorithm() : (ASN1ObjectIdentifier) digestOids.get(algorithm);
        if (algorithm2 == null) {
            return null;
        }
        return mo17381find(algorithm2);
    }
}
