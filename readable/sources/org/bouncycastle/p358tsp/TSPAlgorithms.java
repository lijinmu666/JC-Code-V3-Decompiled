package org.bouncycastle.p358tsp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.p148gm.GMObjectIdentifiers;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.p133asn1.teletrust.TeleTrusTObjectIdentifiers;

/* loaded from: classes2.dex */
public interface TSPAlgorithms {

    /* renamed from: ALLOWED */
    public static final Set f24148ALLOWED;
    public static final ASN1ObjectIdentifier GOST3411;
    public static final ASN1ObjectIdentifier GOST3411_2012_256;
    public static final ASN1ObjectIdentifier GOST3411_2012_512;

    /* renamed from: MD5 */
    public static final ASN1ObjectIdentifier f24149MD5;
    public static final ASN1ObjectIdentifier RIPEMD128;
    public static final ASN1ObjectIdentifier RIPEMD160;
    public static final ASN1ObjectIdentifier RIPEMD256;

    /* renamed from: SHA1 */
    public static final ASN1ObjectIdentifier f24150SHA1;

    /* renamed from: SHA224 */
    public static final ASN1ObjectIdentifier f24151SHA224;

    /* renamed from: SHA256 */
    public static final ASN1ObjectIdentifier f24152SHA256;

    /* renamed from: SHA384 */
    public static final ASN1ObjectIdentifier f24153SHA384;
    public static final ASN1ObjectIdentifier SHA3_224;
    public static final ASN1ObjectIdentifier SHA3_256;
    public static final ASN1ObjectIdentifier SHA3_384;
    public static final ASN1ObjectIdentifier SHA3_512;

    /* renamed from: SHA512 */
    public static final ASN1ObjectIdentifier f24154SHA512;

    /* renamed from: SM3 */
    public static final ASN1ObjectIdentifier f24155SM3;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.f18503md5;
        f24149MD5 = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = OIWObjectIdentifiers.f18459idSHA1;
        f24150SHA1 = aSN1ObjectIdentifier2;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_sha224;
        f24151SHA224 = aSN1ObjectIdentifier3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NISTObjectIdentifiers.id_sha256;
        f24152SHA256 = aSN1ObjectIdentifier4;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = NISTObjectIdentifiers.id_sha384;
        f24153SHA384 = aSN1ObjectIdentifier5;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = NISTObjectIdentifiers.id_sha512;
        f24154SHA512 = aSN1ObjectIdentifier6;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = NISTObjectIdentifiers.id_sha3_224;
        SHA3_224 = aSN1ObjectIdentifier7;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = NISTObjectIdentifiers.id_sha3_256;
        SHA3_256 = aSN1ObjectIdentifier8;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = NISTObjectIdentifiers.id_sha3_384;
        SHA3_384 = aSN1ObjectIdentifier9;
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = NISTObjectIdentifiers.id_sha3_512;
        SHA3_512 = aSN1ObjectIdentifier10;
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = TeleTrusTObjectIdentifiers.ripemd128;
        RIPEMD128 = aSN1ObjectIdentifier11;
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = TeleTrusTObjectIdentifiers.ripemd160;
        RIPEMD160 = aSN1ObjectIdentifier12;
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = TeleTrusTObjectIdentifiers.ripemd256;
        RIPEMD256 = aSN1ObjectIdentifier13;
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = CryptoProObjectIdentifiers.gostR3411;
        GOST3411 = aSN1ObjectIdentifier14;
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = RosstandartObjectIdentifiers.id_tc26_gost_3411_12_256;
        GOST3411_2012_256 = aSN1ObjectIdentifier15;
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = RosstandartObjectIdentifiers.id_tc26_gost_3411_12_512;
        GOST3411_2012_512 = aSN1ObjectIdentifier16;
        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = GMObjectIdentifiers.f18386sm3;
        f24155SM3 = aSN1ObjectIdentifier17;
        f24148ALLOWED = new HashSet(Arrays.asList(aSN1ObjectIdentifier17, aSN1ObjectIdentifier14, aSN1ObjectIdentifier15, aSN1ObjectIdentifier16, aSN1ObjectIdentifier, aSN1ObjectIdentifier2, aSN1ObjectIdentifier3, aSN1ObjectIdentifier4, aSN1ObjectIdentifier5, aSN1ObjectIdentifier6, aSN1ObjectIdentifier7, aSN1ObjectIdentifier8, aSN1ObjectIdentifier9, aSN1ObjectIdentifier10, aSN1ObjectIdentifier11, aSN1ObjectIdentifier12, aSN1ObjectIdentifier13));
    }
}
