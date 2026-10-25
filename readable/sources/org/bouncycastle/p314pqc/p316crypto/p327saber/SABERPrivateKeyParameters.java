package org.bouncycastle.p314pqc.p316crypto.p327saber;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class SABERPrivateKeyParameters extends SABERKeyParameters {
    private byte[] privateKey;

    public SABERPrivateKeyParameters(SABERParameters sABERParameters, byte[] bArr) {
        super(true, sABERParameters);
        this.privateKey = C6238Arrays.m18231clone(bArr);
    }

    public byte[] getEncoded() {
        return C6238Arrays.m18231clone(this.privateKey);
    }

    public byte[] getPrivateKey() {
        return C6238Arrays.m18231clone(this.privateKey);
    }
}
