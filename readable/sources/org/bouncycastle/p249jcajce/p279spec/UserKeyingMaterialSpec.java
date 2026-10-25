package org.bouncycastle.p249jcajce.p279spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class UserKeyingMaterialSpec implements AlgorithmParameterSpec {

    /* renamed from: salt */
    private final byte[] f21950salt;
    private final byte[] userKeyingMaterial;

    public UserKeyingMaterialSpec(byte[] bArr) {
        this(bArr, null);
    }

    /* renamed from: getSalt */
    public byte[] m16222getSalt() {
        return C6238Arrays.m18231clone(this.f21950salt);
    }

    public byte[] getUserKeyingMaterial() {
        return C6238Arrays.m18231clone(this.userKeyingMaterial);
    }

    public UserKeyingMaterialSpec(byte[] bArr, byte[] bArr2) {
        this.userKeyingMaterial = C6238Arrays.m18231clone(bArr);
        this.f21950salt = C6238Arrays.m18231clone(bArr2);
    }
}
