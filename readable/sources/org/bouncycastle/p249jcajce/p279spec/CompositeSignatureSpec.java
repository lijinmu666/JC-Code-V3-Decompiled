package org.bouncycastle.p249jcajce.p279spec;

import java.security.spec.AlgorithmParameterSpec;

/* loaded from: classes2.dex */
public class CompositeSignatureSpec implements AlgorithmParameterSpec {
    private final boolean isPrehashMode;
    private final AlgorithmParameterSpec secondaryParameterSpec;

    public CompositeSignatureSpec(boolean z) {
        this(z, null);
    }

    public AlgorithmParameterSpec getSecondarySpec() {
        return this.secondaryParameterSpec;
    }

    public boolean isPrehashMode() {
        return this.isPrehashMode;
    }

    public CompositeSignatureSpec(boolean z, AlgorithmParameterSpec algorithmParameterSpec) {
        this.isPrehashMode = z;
        this.secondaryParameterSpec = algorithmParameterSpec;
    }
}
