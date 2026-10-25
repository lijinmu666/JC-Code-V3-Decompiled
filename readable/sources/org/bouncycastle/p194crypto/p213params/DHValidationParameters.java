package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class DHValidationParameters {

    /* renamed from: counter */
    private int f20706counter;

    /* renamed from: seed */
    private byte[] f20707seed;

    public DHValidationParameters(byte[] bArr, int i) {
        this.f20707seed = C6238Arrays.m18231clone(bArr);
        this.f20706counter = i;
    }

    /* renamed from: equals */
    public boolean m15699equals(Object obj) {
        if (!(obj instanceof DHValidationParameters)) {
            return false;
        }
        DHValidationParameters dHValidationParameters = (DHValidationParameters) obj;
        if (dHValidationParameters.f20706counter != this.f20706counter) {
            return false;
        }
        return C6238Arrays.areEqual(this.f20707seed, dHValidationParameters.f20707seed);
    }

    public int getCounter() {
        return this.f20706counter;
    }

    /* renamed from: getSeed */
    public byte[] m15700getSeed() {
        return C6238Arrays.m18231clone(this.f20707seed);
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f20707seed) ^ this.f20706counter;
    }
}
