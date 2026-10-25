package org.bouncycastle.p249jcajce.p279spec;

import java.security.spec.KeySpec;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class TLSKeyMaterialSpec implements KeySpec {
    public static final String KEY_EXPANSION = "key expansion";
    public static final String MASTER_SECRET = "master secret";

    /* renamed from: label */
    private final String f21946label;

    /* renamed from: length */
    private final int f21947length;

    /* renamed from: secret */
    private final byte[] f21948secret;

    /* renamed from: seed */
    private final byte[] f21949seed;

    public TLSKeyMaterialSpec(byte[] bArr, String str, int i, byte[]... bArr2) {
        this.f21948secret = C6238Arrays.m18231clone(bArr);
        this.f21946label = str;
        this.f21947length = i;
        this.f21949seed = C6238Arrays.concatenate(bArr2);
    }

    public String getLabel() {
        return this.f21946label;
    }

    public int getLength() {
        return this.f21947length;
    }

    public byte[] getSecret() {
        return C6238Arrays.m18231clone(this.f21948secret);
    }

    /* renamed from: getSeed */
    public byte[] m16221getSeed() {
        return C6238Arrays.m18231clone(this.f21949seed);
    }
}
