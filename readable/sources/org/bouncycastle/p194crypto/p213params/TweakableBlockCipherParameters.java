package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class TweakableBlockCipherParameters implements CipherParameters {

    /* renamed from: key */
    private final KeyParameter f20865key;

    /* renamed from: tweak */
    private final byte[] f20866tweak;

    public TweakableBlockCipherParameters(KeyParameter keyParameter, byte[] bArr) {
        this.f20865key = keyParameter;
        this.f20866tweak = C6238Arrays.m18231clone(bArr);
    }

    /* renamed from: getKey */
    public KeyParameter m15831getKey() {
        return this.f20865key;
    }

    public byte[] getTweak() {
        return this.f20866tweak;
    }
}
