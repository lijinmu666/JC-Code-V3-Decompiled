package org.bouncycastle.p194crypto.threshold;

/* loaded from: classes2.dex */
public interface SecretSplitter {
    /* renamed from: resplit */
    SplitSecret mo15905resplit(byte[] bArr, int i, int i2);

    /* renamed from: split */
    SplitSecret mo15906split(int i, int i2);

    SplitSecret splitAround(SecretShare secretShare, int i, int i2);
}
