package org.bouncycastle.p307pkcs;

import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public interface PKCS12MacCalculatorBuilder {
    /* renamed from: build */
    MacCalculator mo17407build(char[] cArr);

    AlgorithmIdentifier getDigestAlgorithmIdentifier();
}
