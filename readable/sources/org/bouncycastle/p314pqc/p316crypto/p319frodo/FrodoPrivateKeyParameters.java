package org.bouncycastle.p314pqc.p316crypto.p319frodo;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class FrodoPrivateKeyParameters extends FrodoKeyParameters {
    private byte[] privateKey;

    public FrodoPrivateKeyParameters(FrodoParameters frodoParameters, byte[] bArr) {
        super(true, frodoParameters);
        this.privateKey = C6238Arrays.m18231clone(bArr);
    }

    public byte[] getEncoded() {
        return C6238Arrays.m18231clone(this.privateKey);
    }

    public byte[] getPrivateKey() {
        return C6238Arrays.m18231clone(this.privateKey);
    }
}
