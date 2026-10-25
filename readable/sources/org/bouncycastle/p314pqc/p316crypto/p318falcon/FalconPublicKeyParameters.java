package org.bouncycastle.p314pqc.p316crypto.p318falcon;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class FalconPublicKeyParameters extends FalconKeyParameters {

    /* renamed from: H */
    private final byte[] f23128H;

    public FalconPublicKeyParameters(FalconParameters falconParameters, byte[] bArr) {
        super(false, falconParameters);
        this.f23128H = C6238Arrays.m18231clone(bArr);
    }

    /* renamed from: getH */
    public byte[] m17551getH() {
        return C6238Arrays.m18231clone(this.f23128H);
    }
}
