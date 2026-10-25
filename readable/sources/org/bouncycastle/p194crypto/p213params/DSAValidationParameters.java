package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class DSAValidationParameters {

    /* renamed from: counter */
    private int f20720counter;

    /* renamed from: seed */
    private byte[] f20721seed;
    private int usageIndex;

    public DSAValidationParameters(byte[] bArr, int i) {
        this(bArr, i, -1);
    }

    /* renamed from: equals */
    public boolean m15709equals(Object obj) {
        if (!(obj instanceof DSAValidationParameters)) {
            return false;
        }
        DSAValidationParameters dSAValidationParameters = (DSAValidationParameters) obj;
        if (dSAValidationParameters.f20720counter != this.f20720counter) {
            return false;
        }
        return C6238Arrays.areEqual(this.f20721seed, dSAValidationParameters.f20721seed);
    }

    public int getCounter() {
        return this.f20720counter;
    }

    /* renamed from: getSeed */
    public byte[] m15710getSeed() {
        return C6238Arrays.m18231clone(this.f20721seed);
    }

    public int getUsageIndex() {
        return this.usageIndex;
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f20721seed) ^ this.f20720counter;
    }

    public DSAValidationParameters(byte[] bArr, int i, int i2) {
        this.f20721seed = C6238Arrays.m18231clone(bArr);
        this.f20720counter = i;
        this.usageIndex = i2;
    }
}
