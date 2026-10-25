package org.bouncycastle.operator;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.p136bsi.BSIObjectIdentifiers;
import org.bouncycastle.p133asn1.p143eac.EACObjectIdentifiers;
import org.bouncycastle.p133asn1.p144edec.EdECObjectIdentifiers;
import org.bouncycastle.p133asn1.p152isara.IsaraObjectIdentifiers;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.RSASSAPSSparams;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.X509ObjectIdentifiers;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p133asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.p133asn1.teletrust.TeleTrusTObjectIdentifiers;

/* loaded from: classes2.dex */
public class DefaultSignatureNameFinder implements AlgorithmNameFinder {

    /* renamed from: digests */
    private static final Map f22856digests;

    /* renamed from: oids */
    private static final Map f22857oids = new HashMap();

    static {
        HashMap map = new HashMap();
        f22856digests = map;
        addSignatureName(PKCSObjectIdentifiers.id_RSASSA_PSS, "RSASSA-PSS");
        addSignatureName(EdECObjectIdentifiers.id_Ed25519, "ED25519");
        addSignatureName(EdECObjectIdentifiers.id_Ed448, "ED448");
        addSignatureName(new ASN1ObjectIdentifier("1.2.840.113549.1.1.5"), "SHA1WITHRSA");
        addSignatureName(PKCSObjectIdentifiers.sha224WithRSAEncryption, "SHA224WITHRSA");
        addSignatureName(PKCSObjectIdentifiers.sha256WithRSAEncryption, "SHA256WITHRSA");
        addSignatureName(PKCSObjectIdentifiers.sha384WithRSAEncryption, "SHA384WITHRSA");
        addSignatureName(PKCSObjectIdentifiers.sha512WithRSAEncryption, "SHA512WITHRSA");
        addSignatureName(X509ObjectIdentifiers.id_rsassa_pss_shake128, "SHAKE128WITHRSAPSS");
        addSignatureName(X509ObjectIdentifiers.id_rsassa_pss_shake256, "SHAKE256WITHRSAPSS");
        addSignatureName(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_94, "GOST3411WITHGOST3410");
        addSignatureName(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001, "GOST3411WITHECGOST3410");
        addSignatureName(RosstandartObjectIdentifiers.id_tc26_signwithdigest_gost_3410_12_256, "GOST3411-2012-256WITHECGOST3410-2012-256");
        addSignatureName(RosstandartObjectIdentifiers.id_tc26_signwithdigest_gost_3410_12_512, "GOST3411-2012-512WITHECGOST3410-2012-512");
        addSignatureName(BSIObjectIdentifiers.ecdsa_plain_SHA1, "SHA1WITHPLAIN-ECDSA");
        addSignatureName(BSIObjectIdentifiers.ecdsa_plain_SHA224, "SHA224WITHPLAIN-ECDSA");
        addSignatureName(BSIObjectIdentifiers.ecdsa_plain_SHA256, "SHA256WITHPLAIN-ECDSA");
        addSignatureName(BSIObjectIdentifiers.ecdsa_plain_SHA384, "SHA384WITHPLAIN-ECDSA");
        addSignatureName(BSIObjectIdentifiers.ecdsa_plain_SHA512, "SHA512WITHPLAIN-ECDSA");
        addSignatureName(BSIObjectIdentifiers.ecdsa_plain_SHA3_224, "SHA3-224WITHPLAIN-ECDSA");
        addSignatureName(BSIObjectIdentifiers.ecdsa_plain_SHA3_256, "SHA3-256WITHPLAIN-ECDSA");
        addSignatureName(BSIObjectIdentifiers.ecdsa_plain_SHA3_384, "SHA3-384WITHPLAIN-ECDSA");
        addSignatureName(BSIObjectIdentifiers.ecdsa_plain_SHA3_512, "SHA3-512WITHPLAIN-ECDSA");
        addSignatureName(BSIObjectIdentifiers.ecdsa_plain_RIPEMD160, "RIPEMD160WITHPLAIN-ECDSA");
        addSignatureName(EACObjectIdentifiers.id_TA_ECDSA_SHA_1, "SHA1WITHCVC-ECDSA");
        addSignatureName(EACObjectIdentifiers.id_TA_ECDSA_SHA_224, "SHA224WITHCVC-ECDSA");
        addSignatureName(EACObjectIdentifiers.id_TA_ECDSA_SHA_256, "SHA256WITHCVC-ECDSA");
        addSignatureName(EACObjectIdentifiers.id_TA_ECDSA_SHA_384, "SHA384WITHCVC-ECDSA");
        addSignatureName(EACObjectIdentifiers.id_TA_ECDSA_SHA_512, "SHA512WITHCVC-ECDSA");
        addSignatureName(IsaraObjectIdentifiers.id_alg_xmss, "XMSS");
        addSignatureName(IsaraObjectIdentifiers.id_alg_xmssmt, "XMSSMT");
        addSignatureName(TeleTrusTObjectIdentifiers.rsaSignatureWithripemd128, "RIPEMD128WITHRSA");
        addSignatureName(TeleTrusTObjectIdentifiers.rsaSignatureWithripemd160, "RIPEMD160WITHRSA");
        addSignatureName(TeleTrusTObjectIdentifiers.rsaSignatureWithripemd256, "RIPEMD256WITHRSA");
        addSignatureName(new ASN1ObjectIdentifier("1.2.840.113549.1.1.4"), "MD5WITHRSA");
        addSignatureName(new ASN1ObjectIdentifier("1.2.840.113549.1.1.2"), "MD2WITHRSA");
        addSignatureName(new ASN1ObjectIdentifier("1.2.840.10040.4.3"), "SHA1WITHDSA");
        addSignatureName(X9ObjectIdentifiers.ecdsa_with_SHA1, "SHA1WITHECDSA");
        addSignatureName(X9ObjectIdentifiers.ecdsa_with_SHA224, "SHA224WITHECDSA");
        addSignatureName(X9ObjectIdentifiers.ecdsa_with_SHA256, "SHA256WITHECDSA");
        addSignatureName(X9ObjectIdentifiers.ecdsa_with_SHA384, "SHA384WITHECDSA");
        addSignatureName(X9ObjectIdentifiers.ecdsa_with_SHA512, "SHA512WITHECDSA");
        addSignatureName(X509ObjectIdentifiers.id_ecdsa_with_shake128, "SHAKE128WITHECDSA");
        addSignatureName(X509ObjectIdentifiers.id_ecdsa_with_shake256, "SHAKE256WITHECDSA");
        addSignatureName(OIWObjectIdentifiers.sha1WithRSA, "SHA1WITHRSA");
        addSignatureName(OIWObjectIdentifiers.dsaWithSHA1, "SHA1WITHDSA");
        addSignatureName(NISTObjectIdentifiers.dsa_with_sha224, "SHA224WITHDSA");
        addSignatureName(NISTObjectIdentifiers.dsa_with_sha256, "SHA256WITHDSA");
        addSignatureName(PKCSObjectIdentifiers.id_alg_hss_lms_hashsig, "LMS");
        addSignatureName(NISTObjectIdentifiers.id_ml_dsa_44, "ML-DSA-44");
        addSignatureName(NISTObjectIdentifiers.id_ml_dsa_65, "ML-DSA-65");
        addSignatureName(NISTObjectIdentifiers.id_ml_dsa_87, "ML-DSA-87");
        addSignatureName(NISTObjectIdentifiers.id_hash_ml_dsa_44_with_sha512, "ML-DSA-44-WITH-SHA512");
        addSignatureName(NISTObjectIdentifiers.id_hash_ml_dsa_65_with_sha512, "ML-DSA-65-WITH-SHA512");
        addSignatureName(NISTObjectIdentifiers.id_hash_ml_dsa_87_with_sha512, "ML-DSA-87-WITH-SHA512");
        addSignatureName(NISTObjectIdentifiers.id_slh_dsa_sha2_128s, "SLH-DSA-SHA2-128S");
        addSignatureName(NISTObjectIdentifiers.id_slh_dsa_sha2_128f, "SLH-DSA-SHA2-128F");
        addSignatureName(NISTObjectIdentifiers.id_slh_dsa_sha2_192s, "SLH-DSA-SHA2-192S");
        addSignatureName(NISTObjectIdentifiers.id_slh_dsa_sha2_192f, "SLH-DSA-SHA2-192F");
        addSignatureName(NISTObjectIdentifiers.id_slh_dsa_sha2_256s, "SLH-DSA-SHA2-256S");
        addSignatureName(NISTObjectIdentifiers.id_slh_dsa_sha2_256f, "SLH-DSA-SHA2-256F");
        addSignatureName(NISTObjectIdentifiers.id_slh_dsa_shake_128s, "SLH-DSA-SHAKE-128S");
        addSignatureName(NISTObjectIdentifiers.id_slh_dsa_shake_128f, "SLH-DSA-SHAKE-128F");
        addSignatureName(NISTObjectIdentifiers.id_slh_dsa_shake_192s, "SLH-DSA-SHAKE-192S");
        addSignatureName(NISTObjectIdentifiers.id_slh_dsa_shake_192f, "SLH-DSA-SHAKE-192F");
        addSignatureName(NISTObjectIdentifiers.id_slh_dsa_shake_256s, "SLH-DSA-SHAKE-256S");
        addSignatureName(NISTObjectIdentifiers.id_slh_dsa_shake_256f, "SLH-DSA-SHAKE-256F");
        addSignatureName(NISTObjectIdentifiers.id_hash_slh_dsa_sha2_128s_with_sha256, "SLH-DSA-SHA2-128S-WITH-SHA256");
        addSignatureName(NISTObjectIdentifiers.id_hash_slh_dsa_sha2_128f_with_sha256, "SLH-DSA-SHA2-128F-WITH-SHA256");
        addSignatureName(NISTObjectIdentifiers.id_hash_slh_dsa_sha2_192s_with_sha512, "SLH-DSA-SHA2-192S-WITH-SHA512");
        addSignatureName(NISTObjectIdentifiers.id_hash_slh_dsa_sha2_192f_with_sha512, "SLH-DSA-SHA2-192F-WITH-SHA512");
        addSignatureName(NISTObjectIdentifiers.id_hash_slh_dsa_sha2_256s_with_sha512, "SLH-DSA-SHA2-256S-WITH-SHA512");
        addSignatureName(NISTObjectIdentifiers.id_hash_slh_dsa_sha2_256f_with_sha512, "SLH-DSA-SHA2-256F-WITH-SHA512");
        addSignatureName(NISTObjectIdentifiers.id_hash_slh_dsa_shake_128s_with_shake128, "SLH-DSA-SHAKE-128S-WITH-SHAKE128");
        addSignatureName(NISTObjectIdentifiers.id_hash_slh_dsa_shake_128f_with_shake128, "SLH-DSA-SHAKE-128F-WITH-SHAKE128");
        addSignatureName(NISTObjectIdentifiers.id_hash_slh_dsa_shake_192s_with_shake256, "SLH-DSA-SHAKE-192S-WITH-SHAKE256");
        addSignatureName(NISTObjectIdentifiers.id_hash_slh_dsa_shake_192f_with_shake256, "SLH-DSA-SHAKE-192F-WITH-SHAKE256");
        addSignatureName(NISTObjectIdentifiers.id_hash_slh_dsa_shake_256s_with_shake256, "SLH-DSA-SHAKE-256S-WITH-SHAKE256");
        addSignatureName(NISTObjectIdentifiers.id_hash_slh_dsa_shake_256f_with_shake256, "SLH-DSA-SHAKE-256F-WITH-SHAKE256");
        map.put(OIWObjectIdentifiers.f18459idSHA1, "SHA1");
        map.put(NISTObjectIdentifiers.id_sha224, "SHA224");
        map.put(NISTObjectIdentifiers.id_sha256, "SHA256");
        map.put(NISTObjectIdentifiers.id_sha384, "SHA384");
        map.put(NISTObjectIdentifiers.id_sha512, "SHA512");
        map.put(NISTObjectIdentifiers.id_shake128, "SHAKE128");
        map.put(NISTObjectIdentifiers.id_shake256, "SHAKE256");
        map.put(NISTObjectIdentifiers.id_sha3_224, "SHA3-224");
        map.put(NISTObjectIdentifiers.id_sha3_256, "SHA3-256");
        map.put(NISTObjectIdentifiers.id_sha3_384, "SHA3-384");
        map.put(NISTObjectIdentifiers.id_sha3_512, "SHA3-512");
        map.put(TeleTrusTObjectIdentifiers.ripemd128, "RIPEMD128");
        map.put(TeleTrusTObjectIdentifiers.ripemd160, "RIPEMD160");
        map.put(TeleTrusTObjectIdentifiers.ripemd256, "RIPEMD256");
    }

    private static void addSignatureName(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        Map map = f22857oids;
        if (map.containsKey(aSN1ObjectIdentifier)) {
            throw new IllegalStateException("object identifier already present in addSignatureName");
        }
        map.put(aSN1ObjectIdentifier, str);
    }

    private static String getDigestName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String str = (String) f22856digests.get(aSN1ObjectIdentifier);
        return str != null ? str : aSN1ObjectIdentifier.m14433getId();
    }

    @Override // org.bouncycastle.operator.AlgorithmNameFinder
    public String getAlgorithmName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String str = (String) f22857oids.get(aSN1ObjectIdentifier);
        return str != null ? str : aSN1ObjectIdentifier.m14433getId();
    }

    @Override // org.bouncycastle.operator.AlgorithmNameFinder
    public boolean hasAlgorithmName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return f22857oids.containsKey(aSN1ObjectIdentifier);
    }

    @Override // org.bouncycastle.operator.AlgorithmNameFinder
    public String getAlgorithmName(AlgorithmIdentifier algorithmIdentifier) {
        ASN1Encodable parameters = algorithmIdentifier.getParameters();
        if (parameters == null || C5103DERNull.INSTANCE.m14445equals(parameters) || !algorithmIdentifier.getAlgorithm().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.id_RSASSA_PSS)) {
            Map map = f22857oids;
            return map.containsKey(algorithmIdentifier.getAlgorithm()) ? (String) map.get(algorithmIdentifier.getAlgorithm()) : algorithmIdentifier.getAlgorithm().m14433getId();
        }
        RSASSAPSSparams rSASSAPSSparams = RSASSAPSSparams.getInstance(parameters);
        AlgorithmIdentifier maskGenAlgorithm = rSASSAPSSparams.getMaskGenAlgorithm();
        if (!maskGenAlgorithm.getAlgorithm().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.f18498id_mgf1)) {
            return getDigestName(rSASSAPSSparams.getHashAlgorithm().getAlgorithm()) + "WITHRSAAND" + maskGenAlgorithm.getAlgorithm().m14433getId();
        }
        AlgorithmIdentifier hashAlgorithm = rSASSAPSSparams.getHashAlgorithm();
        ASN1ObjectIdentifier algorithm = AlgorithmIdentifier.getInstance(maskGenAlgorithm.getParameters()).getAlgorithm();
        if (algorithm.m14446equals((ASN1Primitive) hashAlgorithm.getAlgorithm())) {
            return getDigestName(hashAlgorithm.getAlgorithm()) + "WITHRSAANDMGF1";
        }
        return getDigestName(hashAlgorithm.getAlgorithm()) + "WITHRSAANDMGF1USING" + getDigestName(algorithm);
    }
}
