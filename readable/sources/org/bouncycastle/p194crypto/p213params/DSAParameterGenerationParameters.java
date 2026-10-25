package org.bouncycastle.p194crypto.p213params;

import java.security.SecureRandom;

/* loaded from: classes2.dex */
public class DSAParameterGenerationParameters {
    public static final int DIGITAL_SIGNATURE_USAGE = 1;
    public static final int KEY_ESTABLISHMENT_USAGE = 2;
    private final int certainty;

    /* renamed from: l */
    private final int f20710l;

    /* renamed from: n */
    private final int f20711n;

    /* renamed from: random */
    private final SecureRandom f20712random;
    private final int usageIndex;

    public DSAParameterGenerationParameters(int i, int i2, int i3, SecureRandom secureRandom) {
        this(i, i2, i3, secureRandom, -1);
    }

    public int getCertainty() {
        return this.certainty;
    }

    /* renamed from: getL */
    public int m15701getL() {
        return this.f20710l;
    }

    /* renamed from: getN */
    public int m15702getN() {
        return this.f20711n;
    }

    public SecureRandom getRandom() {
        return this.f20712random;
    }

    public int getUsageIndex() {
        return this.usageIndex;
    }

    public DSAParameterGenerationParameters(int i, int i2, int i3, SecureRandom secureRandom, int i4) {
        this.f20710l = i;
        this.f20711n = i2;
        this.certainty = i3;
        this.usageIndex = i4;
        this.f20712random = secureRandom;
    }
}
