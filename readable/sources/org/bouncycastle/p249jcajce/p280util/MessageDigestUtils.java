package org.bouncycastle.p249jcajce.p280util;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.internal.p231asn1.p236gnu.GNUObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p240iso.ISOIECObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p242misc.MiscObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p245oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.p148gm.GMObjectIdentifiers;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyParameters;

/* loaded from: classes2.dex */
public class MessageDigestUtils {
    private static Map<ASN1ObjectIdentifier, String> digestOidMap = new HashMap();
    private static Map<String, AlgorithmIdentifier> digestAlgIdMap = new HashMap();

    static {
        digestOidMap.put(PKCSObjectIdentifiers.f18501md2, "MD2");
        digestOidMap.put(PKCSObjectIdentifiers.f18502md4, "MD4");
        digestOidMap.put(PKCSObjectIdentifiers.f18503md5, "MD5");
        Map<ASN1ObjectIdentifier, String> map = digestOidMap;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = OIWObjectIdentifiers.f21282idSHA1;
        map.put(aSN1ObjectIdentifier, "SHA-1");
        Map<ASN1ObjectIdentifier, String> map2 = digestOidMap;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_sha224;
        map2.put(aSN1ObjectIdentifier2, "SHA-224");
        Map<ASN1ObjectIdentifier, String> map3 = digestOidMap;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_sha256;
        map3.put(aSN1ObjectIdentifier3, XMSSKeyParameters.f23621SHA_256);
        Map<ASN1ObjectIdentifier, String> map4 = digestOidMap;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NISTObjectIdentifiers.id_sha384;
        map4.put(aSN1ObjectIdentifier4, "SHA-384");
        Map<ASN1ObjectIdentifier, String> map5 = digestOidMap;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = NISTObjectIdentifiers.id_sha512;
        map5.put(aSN1ObjectIdentifier5, XMSSKeyParameters.f23622SHA_512);
        digestOidMap.put(NISTObjectIdentifiers.id_sha512_224, "SHA-512(224)");
        digestOidMap.put(NISTObjectIdentifiers.id_sha512_256, "SHA-512(256)");
        digestOidMap.put(TeleTrusTObjectIdentifiers.ripemd128, "RIPEMD-128");
        digestOidMap.put(TeleTrusTObjectIdentifiers.ripemd160, "RIPEMD-160");
        digestOidMap.put(TeleTrusTObjectIdentifiers.ripemd256, "RIPEMD-128");
        digestOidMap.put(ISOIECObjectIdentifiers.ripemd128, "RIPEMD-128");
        digestOidMap.put(ISOIECObjectIdentifiers.ripemd160, "RIPEMD-160");
        digestOidMap.put(CryptoProObjectIdentifiers.gostR3411, "GOST3411");
        digestOidMap.put(GNUObjectIdentifiers.Tiger_192, "Tiger");
        digestOidMap.put(ISOIECObjectIdentifiers.whirlpool, "Whirlpool");
        Map<ASN1ObjectIdentifier, String> map6 = digestOidMap;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = NISTObjectIdentifiers.id_sha3_224;
        map6.put(aSN1ObjectIdentifier6, "SHA3-224");
        Map<ASN1ObjectIdentifier, String> map7 = digestOidMap;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = NISTObjectIdentifiers.id_sha3_256;
        map7.put(aSN1ObjectIdentifier7, "SHA3-256");
        Map<ASN1ObjectIdentifier, String> map8 = digestOidMap;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = NISTObjectIdentifiers.id_sha3_384;
        map8.put(aSN1ObjectIdentifier8, "SHA3-384");
        Map<ASN1ObjectIdentifier, String> map9 = digestOidMap;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = NISTObjectIdentifiers.id_sha3_512;
        map9.put(aSN1ObjectIdentifier9, "SHA3-512");
        digestOidMap.put(NISTObjectIdentifiers.id_shake128, "SHAKE128");
        digestOidMap.put(NISTObjectIdentifiers.id_shake256, "SHAKE256");
        digestOidMap.put(GMObjectIdentifiers.f18386sm3, "SM3");
        Map<ASN1ObjectIdentifier, String> map10 = digestOidMap;
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = MiscObjectIdentifiers.blake3_256;
        map10.put(aSN1ObjectIdentifier10, "BLAKE3-256");
        digestAlgIdMap.put("SHA-1", new AlgorithmIdentifier(aSN1ObjectIdentifier, C5103DERNull.INSTANCE));
        digestAlgIdMap.put("SHA-224", new AlgorithmIdentifier(aSN1ObjectIdentifier2));
        digestAlgIdMap.put("SHA224", new AlgorithmIdentifier(aSN1ObjectIdentifier2));
        digestAlgIdMap.put(XMSSKeyParameters.f23621SHA_256, new AlgorithmIdentifier(aSN1ObjectIdentifier3));
        digestAlgIdMap.put("SHA256", new AlgorithmIdentifier(aSN1ObjectIdentifier3));
        digestAlgIdMap.put("SHA-384", new AlgorithmIdentifier(aSN1ObjectIdentifier4));
        digestAlgIdMap.put("SHA384", new AlgorithmIdentifier(aSN1ObjectIdentifier4));
        digestAlgIdMap.put(XMSSKeyParameters.f23622SHA_512, new AlgorithmIdentifier(aSN1ObjectIdentifier5));
        digestAlgIdMap.put("SHA512", new AlgorithmIdentifier(aSN1ObjectIdentifier5));
        digestAlgIdMap.put("SHA3-224", new AlgorithmIdentifier(aSN1ObjectIdentifier6));
        digestAlgIdMap.put("SHA3-256", new AlgorithmIdentifier(aSN1ObjectIdentifier7));
        digestAlgIdMap.put("SHA3-384", new AlgorithmIdentifier(aSN1ObjectIdentifier8));
        digestAlgIdMap.put("SHA3-512", new AlgorithmIdentifier(aSN1ObjectIdentifier9));
        digestAlgIdMap.put("BLAKE3-256", new AlgorithmIdentifier(aSN1ObjectIdentifier10));
    }

    public static AlgorithmIdentifier getDigestAlgID(String str) {
        if (digestAlgIdMap.containsKey(str)) {
            return digestAlgIdMap.get(str);
        }
        throw new IllegalArgumentException("unknown digest: " + str);
    }

    public static String getDigestName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String str = digestOidMap.get(aSN1ObjectIdentifier);
        return str != null ? str : aSN1ObjectIdentifier.m14433getId();
    }
}
