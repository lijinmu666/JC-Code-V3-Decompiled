package org.bouncycastle.operator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.p157kisa.KISAObjectIdentifiers;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p163ntt.NTTObjectIdentifiers;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
public class DefaultSecretKeySizeProvider implements SecretKeySizeProvider {
    public static final SecretKeySizeProvider INSTANCE = new DefaultSecretKeySizeProvider();
    private static final Map KEY_SIZES;

    static {
        HashMap map = new HashMap();
        map.put(new ASN1ObjectIdentifier("1.2.840.113533.7.66.10"), Integers.m18296valueOf(128));
        map.put(PKCSObjectIdentifiers.des_EDE3_CBC, Integers.m18296valueOf(192));
        map.put(PKCSObjectIdentifiers.id_alg_CMS3DESwrap, Integers.m18296valueOf(192));
        map.put(PKCSObjectIdentifiers.pbeWithSHA1AndDES_CBC, Integers.m18296valueOf(64));
        map.put(PKCSObjectIdentifiers.pbeWithMD5AndDES_CBC, Integers.m18296valueOf(64));
        map.put(NISTObjectIdentifiers.id_aes128_CBC, Integers.m18296valueOf(128));
        map.put(NISTObjectIdentifiers.id_aes192_CBC, Integers.m18296valueOf(192));
        map.put(NISTObjectIdentifiers.id_aes256_CBC, Integers.m18296valueOf(256));
        map.put(NISTObjectIdentifiers.id_aes128_GCM, Integers.m18296valueOf(128));
        map.put(NISTObjectIdentifiers.id_aes192_GCM, Integers.m18296valueOf(192));
        map.put(NISTObjectIdentifiers.id_aes256_GCM, Integers.m18296valueOf(256));
        map.put(NISTObjectIdentifiers.id_aes128_CCM, Integers.m18296valueOf(128));
        map.put(NISTObjectIdentifiers.id_aes192_CCM, Integers.m18296valueOf(192));
        map.put(NISTObjectIdentifiers.id_aes256_CCM, Integers.m18296valueOf(256));
        map.put(NISTObjectIdentifiers.id_aes128_wrap, Integers.m18296valueOf(128));
        map.put(NISTObjectIdentifiers.id_aes192_wrap, Integers.m18296valueOf(192));
        map.put(NISTObjectIdentifiers.id_aes256_wrap, Integers.m18296valueOf(256));
        map.put(NISTObjectIdentifiers.id_aes128_wrap_pad, Integers.m18296valueOf(128));
        map.put(NISTObjectIdentifiers.id_aes192_wrap_pad, Integers.m18296valueOf(192));
        map.put(NISTObjectIdentifiers.id_aes256_wrap_pad, Integers.m18296valueOf(256));
        map.put(NTTObjectIdentifiers.id_camellia128_cbc, Integers.m18296valueOf(128));
        map.put(NTTObjectIdentifiers.id_camellia192_cbc, Integers.m18296valueOf(192));
        map.put(NTTObjectIdentifiers.id_camellia256_cbc, Integers.m18296valueOf(256));
        map.put(NTTObjectIdentifiers.id_camellia128_wrap, Integers.m18296valueOf(128));
        map.put(NTTObjectIdentifiers.id_camellia192_wrap, Integers.m18296valueOf(192));
        map.put(NTTObjectIdentifiers.id_camellia256_wrap, Integers.m18296valueOf(256));
        map.put(KISAObjectIdentifiers.id_seedCBC, Integers.m18296valueOf(128));
        map.put(OIWObjectIdentifiers.f18454desCBC, Integers.m18296valueOf(64));
        map.put(CryptoProObjectIdentifiers.gostR28147_gcfb, Integers.m18296valueOf(256));
        KEY_SIZES = Collections.unmodifiableMap(map);
    }

    @Override // org.bouncycastle.operator.SecretKeySizeProvider
    public int getKeySize(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        Integer num = (Integer) KEY_SIZES.get(aSN1ObjectIdentifier);
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // org.bouncycastle.operator.SecretKeySizeProvider
    public int getKeySize(AlgorithmIdentifier algorithmIdentifier) {
        int keySize = getKeySize(algorithmIdentifier.getAlgorithm());
        if (keySize > 0) {
            return keySize;
        }
        return -1;
    }
}
