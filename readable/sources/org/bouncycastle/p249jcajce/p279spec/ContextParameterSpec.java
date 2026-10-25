package org.bouncycastle.p249jcajce.p279spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class ContextParameterSpec implements AlgorithmParameterSpec {
    public static ContextParameterSpec EMPTY_CONTEXT_SPEC = new ContextParameterSpec(new byte[0]);

    /* renamed from: context */
    private final byte[] f21911context;

    public ContextParameterSpec(byte[] bArr) {
        this.f21911context = C6238Arrays.m18231clone(bArr);
    }

    public byte[] getContext() {
        return C6238Arrays.m18231clone(this.f21911context);
    }
}
