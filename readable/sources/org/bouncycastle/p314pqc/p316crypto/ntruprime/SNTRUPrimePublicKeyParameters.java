package org.bouncycastle.p314pqc.p316crypto.ntruprime;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class SNTRUPrimePublicKeyParameters extends SNTRUPrimeKeyParameters {

    /* renamed from: encH */
    private final byte[] f23442encH;

    public SNTRUPrimePublicKeyParameters(SNTRUPrimeParameters sNTRUPrimeParameters, byte[] bArr) {
        super(false, sNTRUPrimeParameters);
        this.f23442encH = C6238Arrays.m18231clone(bArr);
    }

    /* renamed from: getEncH */
    public byte[] m17798getEncH() {
        return this.f23442encH;
    }

    public byte[] getEncoded() {
        return C6238Arrays.m18231clone(this.f23442encH);
    }
}
