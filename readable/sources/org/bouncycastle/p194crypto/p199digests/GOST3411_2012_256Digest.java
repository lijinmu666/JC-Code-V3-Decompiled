package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
public final class GOST3411_2012_256Digest extends GOST3411_2012Digest {

    /* renamed from: IV */
    private static final byte[] f19388IV = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

    public GOST3411_2012_256Digest() {
        super(f19388IV, CryptoServicePurpose.ANY);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GOST3411_2012Digest, org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        return new GOST3411_2012_256Digest(this);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GOST3411_2012Digest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        byte[] bArr2 = new byte[64];
        super.mo14967doFinal(bArr2, 0);
        System.arraycopy(bArr2, 32, bArr, i, 32);
        return 32;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GOST3411_2012Digest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return "GOST3411-2012-256";
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GOST3411_2012Digest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return 32;
    }

    public GOST3411_2012_256Digest(CryptoServicePurpose cryptoServicePurpose) {
        super(f19388IV, cryptoServicePurpose);
    }

    public GOST3411_2012_256Digest(GOST3411_2012_256Digest gOST3411_2012_256Digest) {
        super(f19388IV, gOST3411_2012_256Digest.f19386purpose);
        mo14824reset(gOST3411_2012_256Digest);
    }
}
