package org.bouncycastle.p194crypto.p215prng.p216drbg;

/* loaded from: classes2.dex */
public interface SP80090DRBG {
    int generate(byte[] bArr, byte[] bArr2, boolean z);

    int getBlockSize();

    /* renamed from: reseed */
    void mo15845reseed(byte[] bArr);
}
