package org.bouncycastle.p314pqc.p316crypto.p318falcon;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class FalconPrivateKeyParameters extends FalconKeyParameters {

    /* renamed from: F */
    private final byte[] f23124F;

    /* renamed from: f */
    private final byte[] f23125f;

    /* renamed from: g */
    private final byte[] f23126g;

    /* renamed from: pk */
    private final byte[] f23127pk;

    public FalconPrivateKeyParameters(FalconParameters falconParameters, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        super(true, falconParameters);
        this.f23125f = C6238Arrays.m18231clone(bArr);
        this.f23126g = C6238Arrays.m18231clone(bArr2);
        this.f23124F = C6238Arrays.m18231clone(bArr3);
        this.f23127pk = C6238Arrays.m18231clone(bArr4);
    }

    public byte[] getEncoded() {
        return C6238Arrays.concatenate(this.f23125f, this.f23126g, this.f23124F);
    }

    /* renamed from: getG */
    public byte[] m17550getG() {
        return C6238Arrays.m18231clone(this.f23126g);
    }

    public byte[] getPublicKey() {
        return C6238Arrays.m18231clone(this.f23127pk);
    }

    public byte[] getSpolyF() {
        return C6238Arrays.m18231clone(this.f23124F);
    }

    public byte[] getSpolyf() {
        return C6238Arrays.m18231clone(this.f23125f);
    }
}
