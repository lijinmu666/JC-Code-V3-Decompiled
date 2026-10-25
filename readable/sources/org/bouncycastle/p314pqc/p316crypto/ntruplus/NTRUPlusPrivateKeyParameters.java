package org.bouncycastle.p314pqc.p316crypto.ntruplus;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class NTRUPlusPrivateKeyParameters extends NTRUPlusKeyParameters {

    /* renamed from: sk */
    private final byte[] f23411sk;

    public NTRUPlusPrivateKeyParameters(NTRUPlusParameters nTRUPlusParameters, byte[] bArr) {
        super(true, nTRUPlusParameters);
        this.f23411sk = C6238Arrays.m18231clone(bArr);
    }

    public byte[] getEncoded() {
        return C6238Arrays.m18231clone(this.f23411sk);
    }
}
