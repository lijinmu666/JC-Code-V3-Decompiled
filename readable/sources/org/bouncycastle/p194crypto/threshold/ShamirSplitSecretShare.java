package org.bouncycastle.p194crypto.threshold;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class ShamirSplitSecretShare implements SecretShare {

    /* renamed from: r */
    final int f21109r;
    private final byte[] secretShare;

    public ShamirSplitSecretShare(byte[] bArr) {
        this.secretShare = C6238Arrays.m18231clone(bArr);
        this.f21109r = 1;
    }

    @Override // org.bouncycastle.p361util.Encodable
    public byte[] getEncoded() {
        return C6238Arrays.m18231clone(this.secretShare);
    }

    public ShamirSplitSecretShare(byte[] bArr, int i) {
        this.secretShare = C6238Arrays.m18231clone(bArr);
        this.f21109r = i;
    }
}
