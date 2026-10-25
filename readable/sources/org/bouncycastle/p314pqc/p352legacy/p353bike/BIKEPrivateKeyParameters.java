package org.bouncycastle.p314pqc.p352legacy.p353bike;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class BIKEPrivateKeyParameters extends BIKEKeyParameters {

    /* renamed from: h0 */
    private byte[] f23957h0;

    /* renamed from: h1 */
    private byte[] f23958h1;

    /* renamed from: sigma */
    private byte[] f23959sigma;

    public BIKEPrivateKeyParameters(BIKEParameters bIKEParameters, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(true, bIKEParameters);
        this.f23957h0 = C6238Arrays.m18231clone(bArr);
        this.f23958h1 = C6238Arrays.m18231clone(bArr2);
        this.f23959sigma = C6238Arrays.m18231clone(bArr3);
    }

    public byte[] getEncoded() {
        return C6238Arrays.concatenate(this.f23957h0, this.f23958h1, this.f23959sigma);
    }

    /* renamed from: getH0 */
    public byte[] m18069getH0() {
        return this.f23957h0;
    }

    /* renamed from: getH1 */
    public byte[] m18070getH1() {
        return this.f23958h1;
    }

    public byte[] getSigma() {
        return this.f23959sigma;
    }
}
