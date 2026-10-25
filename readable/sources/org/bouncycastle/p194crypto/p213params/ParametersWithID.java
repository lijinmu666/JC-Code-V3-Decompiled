package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p194crypto.CipherParameters;

/* loaded from: classes2.dex */
public class ParametersWithID implements CipherParameters {

    /* renamed from: id */
    private byte[] f20812id;
    private CipherParameters parameters;

    public ParametersWithID(CipherParameters cipherParameters, byte[] bArr) {
        this.parameters = cipherParameters;
        this.f20812id = bArr;
    }

    /* renamed from: getID */
    public byte[] m15800getID() {
        return this.f20812id;
    }

    public CipherParameters getParameters() {
        return this.parameters;
    }
}
