package org.bouncycastle.p314pqc.p316crypto.p326ntru;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class NTRUPublicKeyParameters extends NTRUKeyParameters {
    final byte[] publicKey;

    public NTRUPublicKeyParameters(NTRUParameters nTRUParameters, byte[] bArr) {
        super(false, nTRUParameters);
        this.publicKey = C6238Arrays.m18231clone(bArr);
    }

    public byte[] getEncoded() {
        return getPublicKey();
    }

    public byte[] getPublicKey() {
        return C6238Arrays.m18231clone(this.publicKey);
    }
}
