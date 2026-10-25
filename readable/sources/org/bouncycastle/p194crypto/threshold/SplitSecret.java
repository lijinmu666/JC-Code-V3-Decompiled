package org.bouncycastle.p194crypto.threshold;

/* loaded from: classes2.dex */
public interface SplitSecret {
    byte[] getSecret();

    SecretShare[] getSecretShares();
}
