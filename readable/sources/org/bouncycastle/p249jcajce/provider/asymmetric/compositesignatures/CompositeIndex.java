package org.bouncycastle.p249jcajce.provider.asymmetric.compositesignatures;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.RSAKeyGenParameterSpec;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.internal.p231asn1.p237iana.IANAObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p242misc.MiscObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p194crypto.p199digests.SHA384Digest;
import org.bouncycastle.p194crypto.p199digests.SHA512Digest;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p249jcajce.p279spec.EdDSAParameterSpec;
import org.bouncycastle.p281jce.p282spec.ECNamedCurveGenParameterSpec;

/* loaded from: classes2.dex */
public class CompositeIndex {
    private static Map<ASN1ObjectIdentifier, String[]> pairings = new HashMap();
    private static Map<ASN1ObjectIdentifier, AlgorithmParameterSpec[]> kpgInitSpecs = new HashMap();
    private static Map<ASN1ObjectIdentifier, String> algorithmNames = new HashMap();

    static {
        Map<ASN1ObjectIdentifier, String[]> map = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = IANAObjectIdentifiers.id_MLDSA44_RSA2048_PSS_SHA256;
        map.put(aSN1ObjectIdentifier, new String[]{"ML-DSA-44", "RSASSA-PSS"});
        Map<ASN1ObjectIdentifier, String[]> map2 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = IANAObjectIdentifiers.id_MLDSA44_RSA2048_PKCS15_SHA256;
        map2.put(aSN1ObjectIdentifier2, new String[]{"ML-DSA-44", "SHA256withRSA"});
        Map<ASN1ObjectIdentifier, String[]> map3 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = IANAObjectIdentifiers.id_MLDSA44_Ed25519_SHA512;
        map3.put(aSN1ObjectIdentifier3, new String[]{"ML-DSA-44", EdDSAParameterSpec.f21918Ed25519});
        Map<ASN1ObjectIdentifier, String[]> map4 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = IANAObjectIdentifiers.id_MLDSA44_ECDSA_P256_SHA256;
        map4.put(aSN1ObjectIdentifier4, new String[]{"ML-DSA-44", "SHA256withECDSA"});
        Map<ASN1ObjectIdentifier, String[]> map5 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = IANAObjectIdentifiers.id_MLDSA65_RSA3072_PSS_SHA512;
        map5.put(aSN1ObjectIdentifier5, new String[]{"ML-DSA-65", "RSASSA-PSS"});
        Map<ASN1ObjectIdentifier, String[]> map6 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = IANAObjectIdentifiers.id_MLDSA65_RSA3072_PKCS15_SHA512;
        map6.put(aSN1ObjectIdentifier6, new String[]{"ML-DSA-65", "SHA256withRSA"});
        Map<ASN1ObjectIdentifier, String[]> map7 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = IANAObjectIdentifiers.id_MLDSA65_RSA4096_PSS_SHA512;
        map7.put(aSN1ObjectIdentifier7, new String[]{"ML-DSA-65", "RSASSA-PSS"});
        Map<ASN1ObjectIdentifier, String[]> map8 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = IANAObjectIdentifiers.id_MLDSA65_RSA4096_PKCS15_SHA512;
        map8.put(aSN1ObjectIdentifier8, new String[]{"ML-DSA-65", "SHA384withRSA"});
        Map<ASN1ObjectIdentifier, String[]> map9 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = IANAObjectIdentifiers.id_MLDSA65_ECDSA_P256_SHA512;
        map9.put(aSN1ObjectIdentifier9, new String[]{"ML-DSA-65", "SHA256withECDSA"});
        Map<ASN1ObjectIdentifier, String[]> map10 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = IANAObjectIdentifiers.id_MLDSA65_ECDSA_P384_SHA512;
        map10.put(aSN1ObjectIdentifier10, new String[]{"ML-DSA-65", "SHA384withECDSA"});
        Map<ASN1ObjectIdentifier, String[]> map11 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = IANAObjectIdentifiers.id_MLDSA65_ECDSA_brainpoolP256r1_SHA512;
        map11.put(aSN1ObjectIdentifier11, new String[]{"ML-DSA-65", "SHA256withECDSA"});
        Map<ASN1ObjectIdentifier, String[]> map12 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = IANAObjectIdentifiers.id_MLDSA65_Ed25519_SHA512;
        map12.put(aSN1ObjectIdentifier12, new String[]{"ML-DSA-65", EdDSAParameterSpec.f21918Ed25519});
        Map<ASN1ObjectIdentifier, String[]> map13 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = IANAObjectIdentifiers.id_MLDSA87_ECDSA_P384_SHA512;
        map13.put(aSN1ObjectIdentifier13, new String[]{"ML-DSA-87", "SHA384withECDSA"});
        Map<ASN1ObjectIdentifier, String[]> map14 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = IANAObjectIdentifiers.id_MLDSA87_ECDSA_brainpoolP384r1_SHA512;
        map14.put(aSN1ObjectIdentifier14, new String[]{"ML-DSA-87", "SHA384withECDSA"});
        Map<ASN1ObjectIdentifier, String[]> map15 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = IANAObjectIdentifiers.id_MLDSA87_Ed448_SHAKE256;
        map15.put(aSN1ObjectIdentifier15, new String[]{"ML-DSA-87", EdDSAParameterSpec.f21919Ed448});
        Map<ASN1ObjectIdentifier, String[]> map16 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = IANAObjectIdentifiers.id_MLDSA87_RSA3072_PSS_SHA512;
        map16.put(aSN1ObjectIdentifier16, new String[]{"ML-DSA-87", "RSASSA-PSS"});
        Map<ASN1ObjectIdentifier, String[]> map17 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = IANAObjectIdentifiers.id_MLDSA87_RSA4096_PSS_SHA512;
        map17.put(aSN1ObjectIdentifier17, new String[]{"ML-DSA-87", "RSASSA-PSS"});
        Map<ASN1ObjectIdentifier, String[]> map18 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier18 = IANAObjectIdentifiers.id_MLDSA87_ECDSA_P521_SHA512;
        map18.put(aSN1ObjectIdentifier18, new String[]{"ML-DSA-87", "SHA512withECDSA"});
        Map<ASN1ObjectIdentifier, AlgorithmParameterSpec[]> map19 = kpgInitSpecs;
        ASN1ObjectIdentifier aSN1ObjectIdentifier19 = MiscObjectIdentifiers.id_HashMLDSA44_RSA2048_PSS_SHA256;
        BigInteger bigInteger = RSAKeyGenParameterSpec.F4;
        map19.put(aSN1ObjectIdentifier19, new AlgorithmParameterSpec[]{null, new RSAKeyGenParameterSpec(2048, bigInteger)});
        Map<ASN1ObjectIdentifier, AlgorithmParameterSpec[]> map20 = kpgInitSpecs;
        ASN1ObjectIdentifier aSN1ObjectIdentifier20 = MiscObjectIdentifiers.id_HashMLDSA44_RSA2048_PKCS15_SHA256;
        map20.put(aSN1ObjectIdentifier20, new AlgorithmParameterSpec[]{null, new RSAKeyGenParameterSpec(2048, bigInteger)});
        Map<ASN1ObjectIdentifier, AlgorithmParameterSpec[]> map21 = kpgInitSpecs;
        ASN1ObjectIdentifier aSN1ObjectIdentifier21 = MiscObjectIdentifiers.id_HashMLDSA44_Ed25519_SHA512;
        map21.put(aSN1ObjectIdentifier21, new AlgorithmParameterSpec[]{null, null});
        Map<ASN1ObjectIdentifier, AlgorithmParameterSpec[]> map22 = kpgInitSpecs;
        ASN1ObjectIdentifier aSN1ObjectIdentifier22 = MiscObjectIdentifiers.id_HashMLDSA44_ECDSA_P256_SHA256;
        map22.put(aSN1ObjectIdentifier22, new AlgorithmParameterSpec[]{null, new ECNamedCurveGenParameterSpec("P-256")});
        Map<ASN1ObjectIdentifier, AlgorithmParameterSpec[]> map23 = kpgInitSpecs;
        ASN1ObjectIdentifier aSN1ObjectIdentifier23 = MiscObjectIdentifiers.id_HashMLDSA65_RSA3072_PSS_SHA512;
        map23.put(aSN1ObjectIdentifier23, new AlgorithmParameterSpec[]{null, new RSAKeyGenParameterSpec(3072, bigInteger)});
        Map<ASN1ObjectIdentifier, AlgorithmParameterSpec[]> map24 = kpgInitSpecs;
        ASN1ObjectIdentifier aSN1ObjectIdentifier24 = MiscObjectIdentifiers.id_HashMLDSA65_RSA3072_PKCS15_SHA512;
        map24.put(aSN1ObjectIdentifier24, new AlgorithmParameterSpec[]{null, new RSAKeyGenParameterSpec(3072, bigInteger)});
        Map<ASN1ObjectIdentifier, AlgorithmParameterSpec[]> map25 = kpgInitSpecs;
        ASN1ObjectIdentifier aSN1ObjectIdentifier25 = MiscObjectIdentifiers.id_HashMLDSA65_RSA4096_PSS_SHA512;
        map25.put(aSN1ObjectIdentifier25, new AlgorithmParameterSpec[]{null, new RSAKeyGenParameterSpec(4096, bigInteger)});
        Map<ASN1ObjectIdentifier, AlgorithmParameterSpec[]> map26 = kpgInitSpecs;
        ASN1ObjectIdentifier aSN1ObjectIdentifier26 = MiscObjectIdentifiers.id_HashMLDSA65_RSA4096_PKCS15_SHA512;
        map26.put(aSN1ObjectIdentifier26, new AlgorithmParameterSpec[]{null, new RSAKeyGenParameterSpec(4096, bigInteger)});
        Map<ASN1ObjectIdentifier, AlgorithmParameterSpec[]> map27 = kpgInitSpecs;
        ASN1ObjectIdentifier aSN1ObjectIdentifier27 = MiscObjectIdentifiers.id_HashMLDSA65_ECDSA_P384_SHA512;
        map27.put(aSN1ObjectIdentifier27, new AlgorithmParameterSpec[]{null, new ECNamedCurveGenParameterSpec("P-384")});
        Map<ASN1ObjectIdentifier, AlgorithmParameterSpec[]> map28 = kpgInitSpecs;
        ASN1ObjectIdentifier aSN1ObjectIdentifier28 = MiscObjectIdentifiers.id_HashMLDSA65_ECDSA_brainpoolP256r1_SHA512;
        map28.put(aSN1ObjectIdentifier28, new AlgorithmParameterSpec[]{null, new ECNamedCurveGenParameterSpec("brainpoolP256r1")});
        Map<ASN1ObjectIdentifier, AlgorithmParameterSpec[]> map29 = kpgInitSpecs;
        ASN1ObjectIdentifier aSN1ObjectIdentifier29 = MiscObjectIdentifiers.id_HashMLDSA65_Ed25519_SHA512;
        map29.put(aSN1ObjectIdentifier29, new AlgorithmParameterSpec[]{null, null});
        Map<ASN1ObjectIdentifier, AlgorithmParameterSpec[]> map30 = kpgInitSpecs;
        ASN1ObjectIdentifier aSN1ObjectIdentifier30 = MiscObjectIdentifiers.id_HashMLDSA87_ECDSA_P384_SHA512;
        map30.put(aSN1ObjectIdentifier30, new AlgorithmParameterSpec[]{null, new ECNamedCurveGenParameterSpec("P-384")});
        Map<ASN1ObjectIdentifier, AlgorithmParameterSpec[]> map31 = kpgInitSpecs;
        ASN1ObjectIdentifier aSN1ObjectIdentifier31 = MiscObjectIdentifiers.id_HashMLDSA87_ECDSA_brainpoolP384r1_SHA512;
        map31.put(aSN1ObjectIdentifier31, new AlgorithmParameterSpec[]{null, new ECNamedCurveGenParameterSpec("brainpoolP384r1")});
        Map<ASN1ObjectIdentifier, AlgorithmParameterSpec[]> map32 = kpgInitSpecs;
        ASN1ObjectIdentifier aSN1ObjectIdentifier32 = MiscObjectIdentifiers.id_HashMLDSA87_Ed448_SHA512;
        map32.put(aSN1ObjectIdentifier32, new AlgorithmParameterSpec[]{null, null});
        kpgInitSpecs.put(aSN1ObjectIdentifier, new AlgorithmParameterSpec[]{null, new RSAKeyGenParameterSpec(2048, bigInteger)});
        kpgInitSpecs.put(aSN1ObjectIdentifier2, new AlgorithmParameterSpec[]{null, new RSAKeyGenParameterSpec(2048, bigInteger)});
        kpgInitSpecs.put(aSN1ObjectIdentifier3, new AlgorithmParameterSpec[]{null, null});
        kpgInitSpecs.put(aSN1ObjectIdentifier4, new AlgorithmParameterSpec[]{null, new ECNamedCurveGenParameterSpec("P-256")});
        kpgInitSpecs.put(aSN1ObjectIdentifier5, new AlgorithmParameterSpec[]{null, new RSAKeyGenParameterSpec(3072, bigInteger)});
        kpgInitSpecs.put(aSN1ObjectIdentifier6, new AlgorithmParameterSpec[]{null, new RSAKeyGenParameterSpec(3072, bigInteger)});
        kpgInitSpecs.put(aSN1ObjectIdentifier7, new AlgorithmParameterSpec[]{null, new RSAKeyGenParameterSpec(4096, bigInteger)});
        kpgInitSpecs.put(aSN1ObjectIdentifier8, new AlgorithmParameterSpec[]{null, new RSAKeyGenParameterSpec(4096, bigInteger)});
        kpgInitSpecs.put(aSN1ObjectIdentifier9, new AlgorithmParameterSpec[]{null, new ECNamedCurveGenParameterSpec("P-256")});
        kpgInitSpecs.put(aSN1ObjectIdentifier10, new AlgorithmParameterSpec[]{null, new ECNamedCurveGenParameterSpec("P-384")});
        kpgInitSpecs.put(aSN1ObjectIdentifier11, new AlgorithmParameterSpec[]{null, new ECNamedCurveGenParameterSpec("brainpoolP256r1")});
        kpgInitSpecs.put(aSN1ObjectIdentifier12, new AlgorithmParameterSpec[]{null, null});
        kpgInitSpecs.put(aSN1ObjectIdentifier13, new AlgorithmParameterSpec[]{null, new ECNamedCurveGenParameterSpec("P-384")});
        kpgInitSpecs.put(aSN1ObjectIdentifier14, new AlgorithmParameterSpec[]{null, new ECNamedCurveGenParameterSpec("brainpoolP384r1")});
        kpgInitSpecs.put(aSN1ObjectIdentifier15, new AlgorithmParameterSpec[]{null, null});
        kpgInitSpecs.put(aSN1ObjectIdentifier17, new AlgorithmParameterSpec[]{null, new RSAKeyGenParameterSpec(4096, bigInteger)});
        kpgInitSpecs.put(aSN1ObjectIdentifier18, new AlgorithmParameterSpec[]{null, new ECNamedCurveGenParameterSpec("P-521")});
        kpgInitSpecs.put(aSN1ObjectIdentifier16, new AlgorithmParameterSpec[]{null, new RSAKeyGenParameterSpec(3072, bigInteger)});
        algorithmNames.put(aSN1ObjectIdentifier19, "HashMLDSA44-RSA2048-PSS-SHA256");
        algorithmNames.put(aSN1ObjectIdentifier20, "HashMLDSA44-RSA2048-PKCS15-SHA256");
        algorithmNames.put(aSN1ObjectIdentifier21, "HashMLDSA44-Ed25519-SHA512");
        algorithmNames.put(aSN1ObjectIdentifier22, "HashMLDSA44-ECDSA-P256-SHA256");
        algorithmNames.put(aSN1ObjectIdentifier23, "HashMLDSA65-RSA3072-PSS-SHA512");
        algorithmNames.put(aSN1ObjectIdentifier24, "HashMLDSA65-RSA3072-PKCS15-SHA512");
        algorithmNames.put(aSN1ObjectIdentifier25, "HashMLDSA65-RSA4096-PSS-SHA512");
        algorithmNames.put(aSN1ObjectIdentifier26, "HashMLDSA65-RSA4096-PKCS15-SHA512");
        algorithmNames.put(aSN1ObjectIdentifier27, "HashMLDSA65-ECDSA-P384-SHA512");
        algorithmNames.put(aSN1ObjectIdentifier28, "HashMLDSA65-ECDSA-brainpoolP256r1-SHA512");
        algorithmNames.put(aSN1ObjectIdentifier29, "HashMLDSA65-Ed25519-SHA512");
        algorithmNames.put(aSN1ObjectIdentifier30, "HashMLDSA87-ECDSA-P384-SHA512");
        algorithmNames.put(aSN1ObjectIdentifier31, "HashMLDSA87-ECDSA-brainpoolP384r1-SHA512");
        algorithmNames.put(aSN1ObjectIdentifier32, "HashMLDSA87-Ed448-SHA512");
        algorithmNames.put(aSN1ObjectIdentifier, "MLDSA44-RSA2048-PSS-SHA256");
        algorithmNames.put(aSN1ObjectIdentifier2, "MLDSA44-RSA2048-PKCS15-SHA256");
        algorithmNames.put(aSN1ObjectIdentifier3, "MLDSA44-Ed25519-SHA512");
        algorithmNames.put(aSN1ObjectIdentifier4, "MLDSA44-ECDSA-P256-SHA256");
        algorithmNames.put(aSN1ObjectIdentifier5, "MLDSA65-RSA3072-PSS-SHA512");
        algorithmNames.put(aSN1ObjectIdentifier6, "MLDSA65-RSA3072-PKCS15-SHA512");
        algorithmNames.put(aSN1ObjectIdentifier7, "MLDSA65-RSA4096-PSS-SHA512");
        algorithmNames.put(aSN1ObjectIdentifier8, "MLDSA65-RSA4096-PKCS15-SHA512");
        algorithmNames.put(aSN1ObjectIdentifier9, "MLDSA65-ECDSA-P256-SHA512");
        algorithmNames.put(aSN1ObjectIdentifier10, "MLDSA65-ECDSA-P384-SHA512");
        algorithmNames.put(aSN1ObjectIdentifier11, "MLDSA65-ECDSA-brainpoolP256r1-SHA512");
        algorithmNames.put(aSN1ObjectIdentifier12, "MLDSA65-Ed25519-SHA512");
        algorithmNames.put(aSN1ObjectIdentifier13, "MLDSA87-ECDSA-P384-SHA512");
        algorithmNames.put(aSN1ObjectIdentifier14, "MLDSA87-ECDSA-brainpoolP384r1-SHA512");
        algorithmNames.put(aSN1ObjectIdentifier15, "MLDSA87-Ed448-SHAKE256");
        algorithmNames.put(aSN1ObjectIdentifier17, "MLDSA87-RSA4096-PSS-SHA512");
        algorithmNames.put(aSN1ObjectIdentifier18, "MLDSA87-ECDSA-P521-SHA512");
        algorithmNames.put(aSN1ObjectIdentifier16, "MLDSA87-RSA3072-PSS-SHA512");
    }

    public static String getAlgorithmName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return algorithmNames.get(aSN1ObjectIdentifier);
    }

    public static String getBaseName(String str) {
        return str.indexOf("RSA") >= 0 ? "RSA" : str.indexOf("ECDSA") >= 0 ? "EC" : str;
    }

    public static InterfaceC5277Digest getDigest(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String str = algorithmNames.get(aSN1ObjectIdentifier);
        return str.endsWith("SHA256") ? new SHA256Digest() : str.endsWith("SHA384") ? new SHA384Digest() : str.endsWith("SHA512") ? new SHA512Digest() : new SHAKEDigest(256);
    }

    public static AlgorithmParameterSpec[] getKeyPairSpecs(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return kpgInitSpecs.get(aSN1ObjectIdentifier);
    }

    public static String[] getPairing(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return pairings.get(aSN1ObjectIdentifier);
    }

    public static Set<ASN1ObjectIdentifier> getSupportedIdentifiers() {
        return pairings.keySet();
    }

    public static boolean isAlgorithmSupported(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return pairings.containsKey(aSN1ObjectIdentifier);
    }
}
