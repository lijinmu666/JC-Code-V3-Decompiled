package org.bouncycastle.p314pqc.p316crypto.p322mayo;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class MayoPublicKeyParameters extends MayoKeyParameters {

    /* renamed from: p */
    private final byte[] f23294p;

    public MayoPublicKeyParameters(MayoParameters mayoParameters, byte[] bArr) {
        super(false, mayoParameters);
        this.f23294p = C6238Arrays.m18231clone(bArr);
    }

    public byte[] getEncoded() {
        return C6238Arrays.m18231clone(this.f23294p);
    }

    /* renamed from: getP */
    public byte[] m17673getP() {
        return C6238Arrays.m18231clone(this.f23294p);
    }
}
