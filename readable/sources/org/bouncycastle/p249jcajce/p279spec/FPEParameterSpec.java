package org.bouncycastle.p249jcajce.p279spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p194crypto.p221util.RadixConverter;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class FPEParameterSpec implements AlgorithmParameterSpec {
    private final RadixConverter radixConverter;

    /* renamed from: tweak */
    private final byte[] f21920tweak;
    private final boolean useInverse;

    public FPEParameterSpec(int i, byte[] bArr) {
        this(i, bArr, false);
    }

    public int getRadix() {
        return this.radixConverter.getRadix();
    }

    public RadixConverter getRadixConverter() {
        return this.radixConverter;
    }

    public byte[] getTweak() {
        return C6238Arrays.m18231clone(this.f21920tweak);
    }

    public boolean isUsingInverseFunction() {
        return this.useInverse;
    }

    public FPEParameterSpec(int i, byte[] bArr, boolean z) {
        this(new RadixConverter(i), bArr, z);
    }

    public FPEParameterSpec(RadixConverter radixConverter, byte[] bArr, boolean z) {
        this.radixConverter = radixConverter;
        this.f21920tweak = C6238Arrays.m18231clone(bArr);
        this.useInverse = z;
    }
}
