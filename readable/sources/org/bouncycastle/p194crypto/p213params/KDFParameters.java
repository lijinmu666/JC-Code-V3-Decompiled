package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p194crypto.DerivationParameters;

/* loaded from: classes2.dex */
public class KDFParameters implements DerivationParameters {

    /* renamed from: iv */
    byte[] f20775iv;

    /* renamed from: shared */
    byte[] f20776shared;

    public KDFParameters(byte[] bArr, byte[] bArr2) {
        this.f20776shared = bArr;
        this.f20775iv = bArr2;
    }

    /* renamed from: getIV */
    public byte[] m15771getIV() {
        return this.f20775iv;
    }

    public byte[] getSharedSecret() {
        return this.f20776shared;
    }
}
