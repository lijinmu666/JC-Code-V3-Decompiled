package org.bouncycastle.p194crypto.commitments;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.Commitment;
import org.bouncycastle.p194crypto.Committer;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.ExtendedDigest;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class HashCommitter implements Committer {
    private final int byteLength;

    /* renamed from: digest */
    private final InterfaceC5277Digest f19260digest;

    /* renamed from: random */
    private final SecureRandom f19261random;

    public HashCommitter(ExtendedDigest extendedDigest, SecureRandom secureRandom) {
        this.f19260digest = extendedDigest;
        this.byteLength = extendedDigest.getByteLength();
        this.f19261random = secureRandom;
    }

    private byte[] calculateCommitment(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[this.f19260digest.getDigestSize()];
        this.f19260digest.mo14970update(bArr, 0, bArr.length);
        this.f19260digest.mo14970update(bArr2, 0, bArr2.length);
        this.f19260digest.mo14967doFinal(bArr3, 0);
        return bArr3;
    }

    @Override // org.bouncycastle.p194crypto.Committer
    /* renamed from: commit */
    public Commitment mo14957commit(byte[] bArr) {
        int length = bArr.length;
        int i = this.byteLength;
        if (length > i / 2) {
            throw new DataLengthException("Message to be committed to too large for digest.");
        }
        byte[] bArr2 = new byte[i - bArr.length];
        this.f19261random.nextBytes(bArr2);
        return new Commitment(bArr2, calculateCommitment(bArr2, bArr));
    }

    @Override // org.bouncycastle.p194crypto.Committer
    public boolean isRevealed(Commitment commitment, byte[] bArr) {
        if (bArr.length + commitment.getSecret().length != this.byteLength) {
            throw new DataLengthException("Message and witness secret lengths do not match.");
        }
        return C6238Arrays.constantTimeAreEqual(commitment.getCommitment(), calculateCommitment(commitment.getSecret(), bArr));
    }
}
