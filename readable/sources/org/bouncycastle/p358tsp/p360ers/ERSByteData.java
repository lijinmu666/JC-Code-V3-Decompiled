package org.bouncycastle.p358tsp.p360ers;

import java.io.IOException;
import org.bouncycastle.operator.DigestCalculator;

/* loaded from: classes2.dex */
public class ERSByteData extends ERSCachingData {

    /* renamed from: content */
    private final byte[] f24179content;

    public ERSByteData(byte[] bArr) {
        this.f24179content = bArr;
    }

    @Override // org.bouncycastle.p358tsp.p360ers.ERSCachingData
    public byte[] calculateHash(DigestCalculator digestCalculator, byte[] bArr) throws IOException {
        byte[] bArrCalculateDigest = C6236ERSUtil.calculateDigest(digestCalculator, this.f24179content);
        return bArr != null ? C6236ERSUtil.concatPreviousHashes(digestCalculator, bArr, bArrCalculateDigest) : bArrCalculateDigest;
    }
}
