package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p194crypto.DerivationParameters;

/* loaded from: classes2.dex */
public class ISO18033KDFParameters implements DerivationParameters {

    /* renamed from: seed */
    byte[] f20767seed;

    public ISO18033KDFParameters(byte[] bArr) {
        this.f20767seed = bArr;
    }

    /* renamed from: getSeed */
    public byte[] m15763getSeed() {
        return this.f20767seed;
    }
}
