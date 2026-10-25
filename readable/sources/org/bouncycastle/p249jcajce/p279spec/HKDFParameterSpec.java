package org.bouncycastle.p249jcajce.p279spec;

import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import org.bouncycastle.p194crypto.p213params.HKDFParameters;

/* loaded from: classes2.dex */
public class HKDFParameterSpec implements KeySpec, AlgorithmParameterSpec {
    private final HKDFParameters hkdfParameters;
    private final int outputLength;

    public HKDFParameterSpec(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        this.hkdfParameters = new HKDFParameters(bArr, bArr2, bArr3);
        this.outputLength = i;
    }

    /* renamed from: getIKM */
    public byte[] m16198getIKM() {
        return this.hkdfParameters.m15760getIKM();
    }

    /* renamed from: getInfo */
    public byte[] m16199getInfo() {
        return this.hkdfParameters.m15761getInfo();
    }

    public int getOutputLength() {
        return this.outputLength;
    }

    /* renamed from: getSalt */
    public byte[] m16200getSalt() {
        return this.hkdfParameters.m15762getSalt();
    }

    public boolean skipExtract() {
        return this.hkdfParameters.skipExtract();
    }
}
