package org.bouncycastle.p194crypto;

/* loaded from: classes2.dex */
public interface SignerWithRecovery extends InterfaceC5282Signer {
    byte[] getRecoveredMessage();

    boolean hasFullMessage();

    void updateWithRecoveredMessage(byte[] bArr);
}
