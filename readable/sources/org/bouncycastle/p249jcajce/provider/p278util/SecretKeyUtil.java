package org.bouncycastle.p249jcajce.provider.p278util;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.internal.p231asn1.p244ntt.NTTObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
public class SecretKeyUtil {
    private static Map<ASN1ObjectIdentifier, Integer> keySizes;

    static {
        HashMap map = new HashMap();
        keySizes = map;
        map.put(PKCSObjectIdentifiers.des_EDE3_CBC, Integers.m18296valueOf(192));
        keySizes.put(NISTObjectIdentifiers.id_aes128_CBC, Integers.m18296valueOf(128));
        keySizes.put(NISTObjectIdentifiers.id_aes192_CBC, Integers.m18296valueOf(192));
        keySizes.put(NISTObjectIdentifiers.id_aes256_CBC, Integers.m18296valueOf(256));
        keySizes.put(NTTObjectIdentifiers.id_camellia128_cbc, Integers.m18296valueOf(128));
        keySizes.put(NTTObjectIdentifiers.id_camellia192_cbc, Integers.m18296valueOf(192));
        keySizes.put(NTTObjectIdentifiers.id_camellia256_cbc, Integers.m18296valueOf(256));
    }

    public static int getKeySize(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        Integer num = keySizes.get(aSN1ObjectIdentifier);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }
}
