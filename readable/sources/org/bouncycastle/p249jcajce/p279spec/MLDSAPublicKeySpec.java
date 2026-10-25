package org.bouncycastle.p249jcajce.p279spec;

import java.security.spec.KeySpec;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class MLDSAPublicKeySpec implements KeySpec {

    /* renamed from: params */
    private final MLDSAParameterSpec f21932params;
    private final byte[] publicData;

    public MLDSAPublicKeySpec(MLDSAParameterSpec mLDSAParameterSpec, byte[] bArr) {
        this.f21932params = mLDSAParameterSpec;
        this.publicData = C6238Arrays.m18231clone(bArr);
    }

    public MLDSAParameterSpec getParameterSpec() {
        return this.f21932params;
    }

    public byte[] getPublicData() {
        return C6238Arrays.m18231clone(this.publicData);
    }
}
