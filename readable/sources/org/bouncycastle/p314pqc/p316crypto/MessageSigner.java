package org.bouncycastle.p314pqc.p316crypto;

import org.bouncycastle.p194crypto.CipherParameters;

/* loaded from: classes2.dex */
public interface MessageSigner {
    byte[] generateSignature(byte[] bArr);

    /* renamed from: init */
    void mo15864init(boolean z, CipherParameters cipherParameters);

    boolean verifySignature(byte[] bArr, byte[] bArr2);
}
