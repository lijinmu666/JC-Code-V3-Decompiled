package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p194crypto.KEMParameters;
import org.bouncycastle.p194crypto.p207kems.p208mlkem.MLKEMEngine;

/* loaded from: classes2.dex */
public class MLKEMParameters implements KEMParameters {

    /* renamed from: k */
    private final int f20796k;

    /* renamed from: name */
    private final String f20797name;
    public static final MLKEMParameters ml_kem_512 = new MLKEMParameters("ML-KEM-512", 2);
    public static final MLKEMParameters ml_kem_768 = new MLKEMParameters("ML-KEM-768", 3);
    public static final MLKEMParameters ml_kem_1024 = new MLKEMParameters("ML-KEM-1024", 4);

    private MLKEMParameters(String str, int i) {
        if (str == null) {
            throw new NullPointerException("'name' cannot be null");
        }
        this.f20797name = str;
        this.f20796k = i;
    }

    public int getEncapsulationLength() {
        return MLKEMEngine.getInstance(this).getCipherTextBytes();
    }

    /* renamed from: getK */
    public int m15789getK() {
        return this.f20796k;
    }

    /* renamed from: getName */
    public String m15790getName() {
        return this.f20797name;
    }

    public int getSessionKeySize() {
        return 256;
    }
}
