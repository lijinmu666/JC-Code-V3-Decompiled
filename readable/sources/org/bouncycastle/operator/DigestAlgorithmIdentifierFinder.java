package org.bouncycastle.operator;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public interface DigestAlgorithmIdentifierFinder {
    /* renamed from: find */
    AlgorithmIdentifier mo17380find(String str);

    /* renamed from: find */
    AlgorithmIdentifier mo17381find(ASN1ObjectIdentifier aSN1ObjectIdentifier);

    /* renamed from: find */
    AlgorithmIdentifier mo17382find(AlgorithmIdentifier algorithmIdentifier);
}
