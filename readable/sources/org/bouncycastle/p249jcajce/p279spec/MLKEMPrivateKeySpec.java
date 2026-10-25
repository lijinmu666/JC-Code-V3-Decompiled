package org.bouncycastle.p249jcajce.p279spec;

import java.security.spec.KeySpec;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class MLKEMPrivateKeySpec implements KeySpec {

    /* renamed from: data */
    private final byte[] f21934data;

    /* renamed from: isSeed */
    private final boolean f21935isSeed;

    /* renamed from: params */
    private final MLKEMParameterSpec f21936params;
    private final byte[] publicData;

    public MLKEMPrivateKeySpec(MLKEMParameterSpec mLKEMParameterSpec, byte[] bArr) {
        if (bArr.length != 64) {
            throw new IllegalArgumentException("incorrect length for seed");
        }
        this.f21935isSeed = true;
        this.f21936params = mLKEMParameterSpec;
        this.f21934data = C6238Arrays.m18231clone(bArr);
        this.publicData = null;
    }

    public MLKEMParameterSpec getParameterSpec() {
        return this.f21936params;
    }

    public byte[] getPrivateData() {
        if (m16210isSeed()) {
            throw new IllegalStateException("KeySpec represents seed");
        }
        return C6238Arrays.m18231clone(this.f21934data);
    }

    public byte[] getPublicData() {
        if (m16210isSeed()) {
            throw new IllegalStateException("KeySpec represents long form");
        }
        return C6238Arrays.m18231clone(this.publicData);
    }

    /* renamed from: getSeed */
    public byte[] m16209getSeed() {
        if (m16210isSeed()) {
            return C6238Arrays.m18231clone(this.f21934data);
        }
        throw new IllegalStateException("KeySpec represents long form");
    }

    /* renamed from: isSeed */
    public boolean m16210isSeed() {
        return this.f21935isSeed;
    }

    public MLKEMPrivateKeySpec(MLKEMParameterSpec mLKEMParameterSpec, byte[] bArr, byte[] bArr2) {
        this.f21935isSeed = false;
        this.f21936params = mLKEMParameterSpec;
        this.f21934data = C6238Arrays.m18231clone(bArr);
        this.publicData = C6238Arrays.m18231clone(bArr2);
    }
}
