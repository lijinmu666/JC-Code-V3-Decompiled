package org.bouncycastle.p314pqc.p316crypto.p322mayo;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class MayoPrivateKeyParameters extends MayoKeyParameters {

    /* renamed from: seed_sk */
    private final byte[] f23293seed_sk;

    public MayoPrivateKeyParameters(MayoParameters mayoParameters, byte[] bArr) {
        super(true, mayoParameters);
        this.f23293seed_sk = C6238Arrays.m18231clone(bArr);
    }

    public byte[] getEncoded() {
        return C6238Arrays.m18231clone(this.f23293seed_sk);
    }

    public byte[] getSeedSk() {
        return C6238Arrays.m18231clone(this.f23293seed_sk);
    }
}
