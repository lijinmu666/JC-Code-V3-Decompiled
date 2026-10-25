package org.bouncycastle.p314pqc.p316crypto.p320hqc;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class HQCPrivateKeyParameters extends HQCKeyParameters {

    /* renamed from: sk */
    private final byte[] f23208sk;

    public HQCPrivateKeyParameters(HQCParameters hQCParameters, byte[] bArr) {
        super(true, hQCParameters);
        this.f23208sk = C6238Arrays.m18231clone(bArr);
    }

    public byte[] getEncoded() {
        return C6238Arrays.m18231clone(this.f23208sk);
    }

    public byte[] getPrivateKey() {
        return C6238Arrays.m18231clone(this.f23208sk);
    }
}
