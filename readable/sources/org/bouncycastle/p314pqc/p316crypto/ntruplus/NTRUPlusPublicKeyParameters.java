package org.bouncycastle.p314pqc.p316crypto.ntruplus;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class NTRUPlusPublicKeyParameters extends NTRUPlusKeyParameters {

    /* renamed from: p */
    private final byte[] f23412p;

    public NTRUPlusPublicKeyParameters(NTRUPlusParameters nTRUPlusParameters, byte[] bArr) {
        super(false, nTRUPlusParameters);
        this.f23412p = C6238Arrays.m18231clone(bArr);
    }

    public byte[] getEncoded() {
        return C6238Arrays.m18231clone(this.f23412p);
    }
}
