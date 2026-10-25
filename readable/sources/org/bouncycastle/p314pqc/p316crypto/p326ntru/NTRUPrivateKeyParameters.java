package org.bouncycastle.p314pqc.p316crypto.p326ntru;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class NTRUPrivateKeyParameters extends NTRUKeyParameters {
    final byte[] privateKey;

    public NTRUPrivateKeyParameters(NTRUParameters nTRUParameters, byte[] bArr) {
        super(true, nTRUParameters);
        this.privateKey = C6238Arrays.m18231clone(bArr);
    }

    public byte[] getEncoded() {
        return getPrivateKey();
    }

    public byte[] getPrivateKey() {
        return C6238Arrays.m18231clone(this.privateKey);
    }
}
