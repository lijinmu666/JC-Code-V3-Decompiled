package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class ParametersWithContext implements CipherParameters {

    /* renamed from: context */
    private byte[] f20811context;
    private CipherParameters parameters;

    public ParametersWithContext(CipherParameters cipherParameters, byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("'context' cannot be null");
        }
        this.parameters = cipherParameters;
        this.f20811context = C6238Arrays.m18231clone(bArr);
    }

    public void copyContextTo(byte[] bArr, int i, int i2) {
        byte[] bArr2 = this.f20811context;
        if (bArr2.length != i2) {
            throw new IllegalArgumentException("len");
        }
        System.arraycopy(bArr2, 0, bArr, i, i2);
    }

    public byte[] getContext() {
        return C6238Arrays.m18231clone(this.f20811context);
    }

    public int getContextLength() {
        return this.f20811context.length;
    }

    public CipherParameters getParameters() {
        return this.parameters;
    }
}
