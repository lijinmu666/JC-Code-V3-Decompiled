package org.bouncycastle.p194crypto.p215prng;

/* loaded from: classes2.dex */
public interface EntropySource {
    int entropySize();

    byte[] getEntropy();

    boolean isPredictionResistant();
}
