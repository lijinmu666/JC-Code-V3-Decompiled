package org.bouncycastle.p314pqc.p316crypto.p320hqc;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class HQCPublicKeyParameters extends HQCKeyParameters {

    /* renamed from: pk */
    private final byte[] f23209pk;

    public HQCPublicKeyParameters(HQCParameters hQCParameters, byte[] bArr) {
        super(true, hQCParameters);
        this.f23209pk = C6238Arrays.m18231clone(bArr);
    }

    public byte[] getEncoded() {
        return getPublicKey();
    }

    public byte[] getPublicKey() {
        return C6238Arrays.m18231clone(this.f23209pk);
    }
}
