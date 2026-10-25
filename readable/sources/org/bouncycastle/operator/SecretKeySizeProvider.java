package org.bouncycastle.operator;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public interface SecretKeySizeProvider {
    int getKeySize(ASN1ObjectIdentifier aSN1ObjectIdentifier);

    int getKeySize(AlgorithmIdentifier algorithmIdentifier);
}
