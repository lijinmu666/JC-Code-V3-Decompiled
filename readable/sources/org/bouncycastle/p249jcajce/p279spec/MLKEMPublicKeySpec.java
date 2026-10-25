package org.bouncycastle.p249jcajce.p279spec;

import java.security.spec.KeySpec;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class MLKEMPublicKeySpec implements KeySpec {

    /* renamed from: params */
    private final MLKEMParameterSpec f21937params;
    private final byte[] publicData;

    public MLKEMPublicKeySpec(MLKEMParameterSpec mLKEMParameterSpec, byte[] bArr) {
        this.f21937params = mLKEMParameterSpec;
        this.publicData = C6238Arrays.m18231clone(bArr);
    }

    public MLKEMParameterSpec getParameterSpec() {
        return this.f21937params;
    }

    public byte[] getPublicData() {
        return C6238Arrays.m18231clone(this.publicData);
    }
}
