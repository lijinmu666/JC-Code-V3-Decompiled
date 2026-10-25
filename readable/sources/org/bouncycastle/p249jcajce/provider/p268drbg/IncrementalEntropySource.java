package org.bouncycastle.p249jcajce.provider.p268drbg;

import org.bouncycastle.p194crypto.p215prng.EntropySource;

/* loaded from: classes2.dex */
interface IncrementalEntropySource extends EntropySource {
    byte[] getEntropy(long j);
}
