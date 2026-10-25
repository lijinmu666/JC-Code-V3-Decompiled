package org.bouncycastle.p314pqc.p316crypto.p323mldsa;

import java.security.SecureRandom;

@Deprecated
/* loaded from: classes2.dex */
public class MLDSAParameters {
    public static final int TYPE_PURE = 0;
    public static final int TYPE_SHA2_512 = 1;

    /* renamed from: k */
    private final int f23309k;

    /* renamed from: name */
    private final String f23310name;
    private final int preHashDigest;
    public static final MLDSAParameters ml_dsa_44 = new MLDSAParameters("ml-dsa-44", 2, 0);
    public static final MLDSAParameters ml_dsa_65 = new MLDSAParameters("ml-dsa-65", 3, 0);
    public static final MLDSAParameters ml_dsa_87 = new MLDSAParameters("ml-dsa-87", 5, 0);
    public static final MLDSAParameters ml_dsa_44_with_sha512 = new MLDSAParameters("ml-dsa-44-with-sha512", 2, 1);
    public static final MLDSAParameters ml_dsa_65_with_sha512 = new MLDSAParameters("ml-dsa-65-with-sha512", 3, 1);
    public static final MLDSAParameters ml_dsa_87_with_sha512 = new MLDSAParameters("ml-dsa-87-with-sha512", 5, 1);

    private MLDSAParameters(String str, int i, int i2) {
        this.f23310name = str;
        this.f23309k = i;
        this.preHashDigest = i2;
    }

    public MLDSAEngine getEngine(SecureRandom secureRandom) {
        return new MLDSAEngine(this.f23309k, secureRandom);
    }

    /* renamed from: getName */
    public String m17675getName() {
        return this.f23310name;
    }

    /* renamed from: getType */
    public int m17676getType() {
        return this.preHashDigest;
    }

    public boolean isPreHash() {
        return this.preHashDigest != 0;
    }
}
