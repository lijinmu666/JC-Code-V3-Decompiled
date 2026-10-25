package org.bouncycastle.p194crypto;

/* loaded from: classes2.dex */
public interface Committer {
    /* renamed from: commit */
    Commitment mo14957commit(byte[] bArr);

    boolean isRevealed(Commitment commitment, byte[] bArr);
}
