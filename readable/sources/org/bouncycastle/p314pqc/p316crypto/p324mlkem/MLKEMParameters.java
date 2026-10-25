package org.bouncycastle.p314pqc.p316crypto.p324mlkem;

import org.bouncycastle.p314pqc.p316crypto.KEMParameters;

@Deprecated
/* loaded from: classes2.dex */
public class MLKEMParameters implements KEMParameters {

    /* renamed from: engine */
    private final MLKEMEngine f23344engine;

    /* renamed from: name */
    private final String f23345name;
    public static final MLKEMParameters ml_kem_512 = new MLKEMParameters("ML-KEM-512", 2);
    public static final MLKEMParameters ml_kem_768 = new MLKEMParameters("ML-KEM-768", 3);
    public static final MLKEMParameters ml_kem_1024 = new MLKEMParameters("ML-KEM-1024", 4);

    private MLKEMParameters(String str, int i) {
        if (str == null) {
            throw new NullPointerException("'name' cannot be null");
        }
        this.f23345name = str;
        this.f23344engine = new MLKEMEngine(i);
    }

    public int getEncapsulationLength() {
        return this.f23344engine.getCipherTextBytes();
    }

    public MLKEMEngine getEngine() {
        return this.f23344engine;
    }

    /* renamed from: getName */
    public String m17711getName() {
        return this.f23345name;
    }

    public int getSessionKeySize() {
        return 256;
    }
}
