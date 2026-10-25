package org.bouncycastle.p314pqc.p352legacy.p354picnic;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class PicnicPrivateKeyParameters extends PicnicKeyParameters {
    private final byte[] privateKey;

    public PicnicPrivateKeyParameters(PicnicParameters picnicParameters, byte[] bArr) {
        super(true, picnicParameters);
        this.privateKey = C6238Arrays.m18231clone(bArr);
    }

    public byte[] getEncoded() {
        return C6238Arrays.m18231clone(this.privateKey);
    }
}
