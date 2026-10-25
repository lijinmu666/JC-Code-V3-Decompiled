package org.bouncycastle.p194crypto.p215prng;

import org.bouncycastle.p194crypto.p215prng.p216drbg.SP80090DRBG;

/* loaded from: classes2.dex */
interface DRBGProvider {
    /* renamed from: get */
    SP80090DRBG mo15837get(EntropySource entropySource);

    String getAlgorithm();
}
