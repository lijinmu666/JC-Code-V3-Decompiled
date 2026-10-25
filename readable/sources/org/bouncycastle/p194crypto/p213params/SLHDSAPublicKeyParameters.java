package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class SLHDSAPublicKeyParameters extends SLHDSAKeyParameters {

    /* renamed from: pkRoot */
    private final byte[] f20861pkRoot;

    /* renamed from: pkSeed */
    private final byte[] f20862pkSeed;

    public SLHDSAPublicKeyParameters(SLHDSAParameters sLHDSAParameters, byte[] bArr) {
        super(false, sLHDSAParameters);
        int iM15815getN = sLHDSAParameters.m15815getN();
        int i = iM15815getN * 2;
        if (bArr.length != i) {
            throw new IllegalArgumentException("public key encoding does not match parameters");
        }
        this.f20862pkSeed = C6238Arrays.copyOfRange(bArr, 0, iM15815getN);
        this.f20861pkRoot = C6238Arrays.copyOfRange(bArr, iM15815getN, i);
    }

    public byte[] getEncoded() {
        return C6238Arrays.concatenate(this.f20862pkSeed, this.f20861pkRoot);
    }

    /* renamed from: getRoot */
    public byte[] m15823getRoot() {
        return C6238Arrays.m18231clone(this.f20861pkRoot);
    }

    /* renamed from: getSeed */
    public byte[] m15824getSeed() {
        return C6238Arrays.m18231clone(this.f20862pkSeed);
    }
}
