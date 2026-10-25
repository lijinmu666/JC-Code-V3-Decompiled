package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
public class GOST3411_2012_512Digest extends GOST3411_2012Digest {

    /* renamed from: IV */
    private static final byte[] f19389IV = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public GOST3411_2012_512Digest() {
        super(f19389IV, CryptoServicePurpose.ANY);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GOST3411_2012Digest, org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        return new GOST3411_2012_512Digest(this);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GOST3411_2012Digest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return "GOST3411-2012-512";
    }

    @Override // org.bouncycastle.p194crypto.p199digests.GOST3411_2012Digest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return 64;
    }

    public GOST3411_2012_512Digest(CryptoServicePurpose cryptoServicePurpose) {
        super(f19389IV, cryptoServicePurpose);
    }

    public GOST3411_2012_512Digest(GOST3411_2012_512Digest gOST3411_2012_512Digest) {
        super(f19389IV, gOST3411_2012_512Digest.f19386purpose);
        mo14824reset(gOST3411_2012_512Digest);
    }
}
