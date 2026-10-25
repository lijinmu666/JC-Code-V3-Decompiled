package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p194crypto.CipherParameters;

/* loaded from: classes2.dex */
public class ParametersWithUKM implements CipherParameters {
    private CipherParameters parameters;

    /* renamed from: ukm */
    private byte[] f20817ukm;

    public ParametersWithUKM(CipherParameters cipherParameters, byte[] bArr) {
        this(cipherParameters, bArr, 0, bArr.length);
    }

    public CipherParameters getParameters() {
        return this.parameters;
    }

    /* renamed from: getUKM */
    public byte[] m15804getUKM() {
        return this.f20817ukm;
    }

    public ParametersWithUKM(CipherParameters cipherParameters, byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.f20817ukm = bArr2;
        this.parameters = cipherParameters;
        System.arraycopy(bArr, i, bArr2, 0, i2);
    }
}
