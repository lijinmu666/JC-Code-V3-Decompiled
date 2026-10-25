package org.bouncycastle.operator;

import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public interface KeyWrapper {
    byte[] generateWrappedKey(GenericKey genericKey);

    AlgorithmIdentifier getAlgorithmIdentifier();
}
