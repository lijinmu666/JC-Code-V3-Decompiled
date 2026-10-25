package org.bouncycastle.p314pqc.p316crypto.p319frodo;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class FrodoPublicKeyParameters extends FrodoKeyParameters {
    public byte[] publicKey;

    public FrodoPublicKeyParameters(FrodoParameters frodoParameters, byte[] bArr) {
        super(false, frodoParameters);
        this.publicKey = C6238Arrays.m18231clone(bArr);
    }

    public byte[] getEncoded() {
        return getPublicKey();
    }

    public byte[] getPublicKey() {
        return C6238Arrays.m18231clone(this.publicKey);
    }
}
