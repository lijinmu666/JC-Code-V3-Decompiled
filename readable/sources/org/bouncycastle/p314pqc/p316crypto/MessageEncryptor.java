package org.bouncycastle.p314pqc.p316crypto;

import org.bouncycastle.p194crypto.CipherParameters;

/* loaded from: classes2.dex */
public interface MessageEncryptor {
    /* renamed from: init */
    void m17480init(boolean z, CipherParameters cipherParameters);

    byte[] messageDecrypt(byte[] bArr);

    byte[] messageEncrypt(byte[] bArr);
}
