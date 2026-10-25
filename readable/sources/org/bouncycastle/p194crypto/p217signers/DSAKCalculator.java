package org.bouncycastle.p194crypto.p217signers;

import java.math.BigInteger;
import java.security.SecureRandom;

/* loaded from: classes2.dex */
public interface DSAKCalculator {
    /* renamed from: init */
    void mo15858init(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr);

    /* renamed from: init */
    void mo15859init(BigInteger bigInteger, SecureRandom secureRandom);

    boolean isDeterministic();

    /* renamed from: nextK */
    BigInteger mo15860nextK();
}
