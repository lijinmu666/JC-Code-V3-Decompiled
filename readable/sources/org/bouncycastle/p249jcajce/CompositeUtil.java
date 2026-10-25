package org.bouncycastle.p249jcajce;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.internal.p231asn1.p237iana.IANAObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
class CompositeUtil {
    private static final Map<String, ASN1ObjectIdentifier> algorithmOids;

    static {
        HashMap map = new HashMap();
        algorithmOids = map;
        map.put("MLDSA44-RSA2048-PSS-SHA256", IANAObjectIdentifiers.id_MLDSA44_RSA2048_PSS_SHA256);
        map.put("MLDSA44-RSA2048-PKCS15-SHA256", IANAObjectIdentifiers.id_MLDSA44_RSA2048_PKCS15_SHA256);
        map.put("MLDSA44-ED25519-SHA512", IANAObjectIdentifiers.id_MLDSA44_Ed25519_SHA512);
        map.put("MLDSA44-ECDSA-P256-SHA256", IANAObjectIdentifiers.id_MLDSA44_ECDSA_P256_SHA256);
        map.put("MLDSA65-RSA3072-PSS-SHA512", IANAObjectIdentifiers.id_MLDSA65_RSA3072_PSS_SHA512);
        map.put("MLDSA65-RSA3072-PKCS15-SHA512", IANAObjectIdentifiers.id_MLDSA65_RSA3072_PKCS15_SHA512);
        map.put("MLDSA65-RSA4096-PSS-SHA512", IANAObjectIdentifiers.id_MLDSA65_RSA4096_PSS_SHA512);
        map.put("MLDSA65-RSA4096-PKCS15-SHA512", IANAObjectIdentifiers.id_MLDSA65_RSA4096_PKCS15_SHA512);
        map.put("MLDSA65-ECDSA-P256-SHA512", IANAObjectIdentifiers.id_MLDSA65_ECDSA_P256_SHA512);
        map.put("MLDSA65-ECDSA-P384-SHA512", IANAObjectIdentifiers.id_MLDSA65_ECDSA_P384_SHA512);
        map.put("MLDSA65-ECDSA-BRAINPOOLP256R1-SHA512", IANAObjectIdentifiers.id_MLDSA65_ECDSA_brainpoolP256r1_SHA512);
        map.put("MLDSA65-ED25519-SHA512", IANAObjectIdentifiers.id_MLDSA65_Ed25519_SHA512);
        map.put("MLDSA87-ECDSA-P384-SHA512", IANAObjectIdentifiers.id_MLDSA87_ECDSA_P384_SHA512);
        map.put("MLDSA87-ECDSA-BRAINPOOLP384R1-SHA512", IANAObjectIdentifiers.id_MLDSA87_ECDSA_brainpoolP384r1_SHA512);
        map.put("MLDSA87-ED448-SHAKE256", IANAObjectIdentifiers.id_MLDSA87_Ed448_SHAKE256);
        map.put("MLDSA87-RSA4096-PSS-SHA512", IANAObjectIdentifiers.id_MLDSA87_RSA4096_PSS_SHA512);
        map.put("MLDSA87-ECDSA-P521-SHA512", IANAObjectIdentifiers.id_MLDSA87_ECDSA_P521_SHA512);
        map.put("MLDSA87-RSA3072-PSS-SHA512", IANAObjectIdentifiers.id_MLDSA87_RSA3072_PSS_SHA512);
    }

    /* renamed from: getOid */
    public static ASN1ObjectIdentifier m16062getOid(String str) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = algorithmOids.get(C6250Strings.toUpperCase(str));
        if (aSN1ObjectIdentifier != null) {
            return aSN1ObjectIdentifier;
        }
        throw new IllegalArgumentException("name " + str + " not recognized");
    }
}
