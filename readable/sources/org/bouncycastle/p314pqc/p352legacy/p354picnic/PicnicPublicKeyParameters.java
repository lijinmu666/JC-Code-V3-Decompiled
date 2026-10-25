package org.bouncycastle.p314pqc.p352legacy.p354picnic;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class PicnicPublicKeyParameters extends PicnicKeyParameters {
    private final byte[] publicKey;

    public PicnicPublicKeyParameters(PicnicParameters picnicParameters, byte[] bArr) {
        super(false, picnicParameters);
        this.publicKey = C6238Arrays.m18231clone(bArr);
    }

    public byte[] getEncoded() {
        return C6238Arrays.m18231clone(this.publicKey);
    }
}
