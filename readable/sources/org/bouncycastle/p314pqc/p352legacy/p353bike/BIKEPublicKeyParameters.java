package org.bouncycastle.p314pqc.p352legacy.p353bike;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class BIKEPublicKeyParameters extends BIKEKeyParameters {
    byte[] publicKey;

    public BIKEPublicKeyParameters(BIKEParameters bIKEParameters, byte[] bArr) {
        super(false, bIKEParameters);
        this.publicKey = C6238Arrays.m18231clone(bArr);
    }

    public byte[] getEncoded() {
        return C6238Arrays.m18231clone(this.publicKey);
    }
}
