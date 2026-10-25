package org.bouncycastle.p314pqc.p316crypto;

import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class ExchangePair {
    private final AsymmetricKeyParameter publicKey;

    /* renamed from: shared */
    private final byte[] f23056shared;

    public ExchangePair(AsymmetricKeyParameter asymmetricKeyParameter, byte[] bArr) {
        this.publicKey = asymmetricKeyParameter;
        this.f23056shared = C6238Arrays.m18231clone(bArr);
    }

    public AsymmetricKeyParameter getPublicKey() {
        return this.publicKey;
    }

    public byte[] getSharedValue() {
        return C6238Arrays.m18231clone(this.f23056shared);
    }
}
