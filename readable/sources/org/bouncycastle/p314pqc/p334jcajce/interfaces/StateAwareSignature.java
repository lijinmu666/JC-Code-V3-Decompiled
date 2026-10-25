package org.bouncycastle.p314pqc.p334jcajce.interfaces;

import java.nio.ByteBuffer;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.Certificate;

/* loaded from: classes2.dex */
public interface StateAwareSignature {
    String getAlgorithm();

    PrivateKey getUpdatedPrivateKey();

    void initSign(PrivateKey privateKey);

    void initSign(PrivateKey privateKey, SecureRandom secureRandom);

    void initVerify(PublicKey publicKey);

    void initVerify(Certificate certificate);

    boolean isSigningCapable();

    /* renamed from: sign */
    int m17933sign(byte[] bArr, int i, int i2);

    /* renamed from: sign */
    byte[] m17934sign();

    /* renamed from: update */
    void m17935update(byte b);

    /* renamed from: update */
    void m17936update(ByteBuffer byteBuffer);

    /* renamed from: update */
    void m17937update(byte[] bArr);

    /* renamed from: update */
    void m17938update(byte[] bArr, int i, int i2);

    /* renamed from: verify */
    boolean m17939verify(byte[] bArr);

    /* renamed from: verify */
    boolean m17940verify(byte[] bArr, int i, int i2);
}
