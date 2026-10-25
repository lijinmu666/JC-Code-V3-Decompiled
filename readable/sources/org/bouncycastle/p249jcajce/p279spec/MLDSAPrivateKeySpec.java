package org.bouncycastle.p249jcajce.p279spec;

import java.security.spec.KeySpec;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class MLDSAPrivateKeySpec implements KeySpec {

    /* renamed from: data */
    private final byte[] f21929data;

    /* renamed from: isSeed */
    private final boolean f21930isSeed;

    /* renamed from: params */
    private final MLDSAParameterSpec f21931params;
    private final byte[] publicData;

    public MLDSAPrivateKeySpec(MLDSAParameterSpec mLDSAParameterSpec, byte[] bArr) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("incorrect length for seed");
        }
        this.f21930isSeed = true;
        this.f21931params = mLDSAParameterSpec;
        this.f21929data = C6238Arrays.m18231clone(bArr);
        this.publicData = null;
    }

    public MLDSAParameterSpec getParameterSpec() {
        return this.f21931params;
    }

    public byte[] getPrivateData() {
        if (m16207isSeed()) {
            throw new IllegalStateException("KeySpec represents seed");
        }
        return C6238Arrays.m18231clone(this.f21929data);
    }

    public byte[] getPublicData() {
        if (m16207isSeed()) {
            throw new IllegalStateException("KeySpec represents long form");
        }
        return C6238Arrays.m18231clone(this.publicData);
    }

    /* renamed from: getSeed */
    public byte[] m16206getSeed() {
        if (m16207isSeed()) {
            return C6238Arrays.m18231clone(this.f21929data);
        }
        throw new IllegalStateException("KeySpec represents long form");
    }

    /* renamed from: isSeed */
    public boolean m16207isSeed() {
        return this.f21930isSeed;
    }

    public MLDSAPrivateKeySpec(MLDSAParameterSpec mLDSAParameterSpec, byte[] bArr, byte[] bArr2) {
        this.f21930isSeed = false;
        this.f21931params = mLDSAParameterSpec;
        this.f21929data = C6238Arrays.m18231clone(bArr);
        this.publicData = C6238Arrays.m18231clone(bArr2);
    }
}
