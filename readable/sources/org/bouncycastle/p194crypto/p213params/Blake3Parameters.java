package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class Blake3Parameters implements CipherParameters {

    /* renamed from: KEYLEN */
    private static final int f20677KEYLEN = 32;
    private byte[] theContext;

    /* renamed from: theKey */
    private byte[] f20678theKey;

    /* renamed from: context */
    public static Blake3Parameters m15670context(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Invalid context");
        }
        Blake3Parameters blake3Parameters = new Blake3Parameters();
        blake3Parameters.theContext = C6238Arrays.m18231clone(bArr);
        return blake3Parameters;
    }

    /* renamed from: key */
    public static Blake3Parameters m15671key(byte[] bArr) {
        if (bArr == null || bArr.length != 32) {
            throw new IllegalArgumentException("Invalid keyLength");
        }
        Blake3Parameters blake3Parameters = new Blake3Parameters();
        blake3Parameters.f20678theKey = C6238Arrays.m18231clone(bArr);
        return blake3Parameters;
    }

    public void clearKey() {
        C6238Arrays.m18249fill(this.f20678theKey, (byte) 0);
    }

    public byte[] getContext() {
        return C6238Arrays.m18231clone(this.theContext);
    }

    /* renamed from: getKey */
    public byte[] m15672getKey() {
        return C6238Arrays.m18231clone(this.f20678theKey);
    }
}
