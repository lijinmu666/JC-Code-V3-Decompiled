package org.bouncycastle.operator.p305bc;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p194crypto.p213params.KeyParameter;

/* renamed from: org.bouncycastle.operator.bc.AESUtil */
/* loaded from: classes2.dex */
class C5992AESUtil {
    public static AlgorithmIdentifier determineKeyEncAlg(KeyParameter keyParameter) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        int length = keyParameter.m15773getKey().length * 8;
        if (length == 128) {
            aSN1ObjectIdentifier = NISTObjectIdentifiers.id_aes128_wrap;
        } else if (length == 192) {
            aSN1ObjectIdentifier = NISTObjectIdentifiers.id_aes192_wrap;
        } else {
            if (length != 256) {
                throw new IllegalArgumentException("illegal keysize in AES");
            }
            aSN1ObjectIdentifier = NISTObjectIdentifiers.id_aes256_wrap;
        }
        return new AlgorithmIdentifier(aSN1ObjectIdentifier);
    }
}
