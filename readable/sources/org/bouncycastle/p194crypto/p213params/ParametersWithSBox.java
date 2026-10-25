package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p194crypto.CipherParameters;

/* loaded from: classes2.dex */
public class ParametersWithSBox implements CipherParameters {
    private CipherParameters parameters;

    /* renamed from: sBox */
    private byte[] f20815sBox;

    public ParametersWithSBox(CipherParameters cipherParameters, byte[] bArr) {
        this.parameters = cipherParameters;
        this.f20815sBox = bArr;
    }

    public CipherParameters getParameters() {
        return this.parameters;
    }

    /* renamed from: getSBox */
    public byte[] m15802getSBox() {
        return this.f20815sBox;
    }
}
