package org.bouncycastle.p302openssl;

/* loaded from: classes2.dex */
public interface PEMEncryptor {
    /* renamed from: encrypt */
    byte[] mo17362encrypt(byte[] bArr);

    String getAlgorithm();

    /* renamed from: getIV */
    byte[] mo17363getIV();
}
