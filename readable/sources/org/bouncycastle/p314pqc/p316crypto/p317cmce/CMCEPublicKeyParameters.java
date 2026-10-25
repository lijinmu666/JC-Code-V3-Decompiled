package org.bouncycastle.p314pqc.p316crypto.p317cmce;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class CMCEPublicKeyParameters extends CMCEKeyParameters {
    private final byte[] publicKey;

    public CMCEPublicKeyParameters(CMCEParameters cMCEParameters, byte[] bArr) {
        super(false, cMCEParameters);
        this.publicKey = C6238Arrays.m18231clone(bArr);
    }

    public byte[] getEncoded() {
        return getPublicKey();
    }

    public byte[] getPublicKey() {
        return C6238Arrays.m18231clone(this.publicKey);
    }
}
