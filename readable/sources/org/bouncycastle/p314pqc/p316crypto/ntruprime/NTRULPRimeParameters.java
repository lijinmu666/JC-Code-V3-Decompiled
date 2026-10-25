package org.bouncycastle.p314pqc.p316crypto.ntruprime;

import org.bouncycastle.p314pqc.p316crypto.KEMParameters;

/* loaded from: classes2.dex */
public class NTRULPRimeParameters implements KEMParameters {

    /* renamed from: delta */
    private final int f23416delta;

    /* renamed from: name */
    private final String f23417name;

    /* renamed from: p */
    private final int f23418p;
    private final int privateKeyBytes;
    private final int publicKeyBytes;

    /* renamed from: q */
    private final int f23419q;
    private final int roundedPolynomialBytes;
    private final int sharedKeyBytes;

    /* renamed from: tau0 */
    private final int f23420tau0;

    /* renamed from: tau1 */
    private final int f23421tau1;

    /* renamed from: tau2 */
    private final int f23422tau2;

    /* renamed from: tau3 */
    private final int f23423tau3;

    /* renamed from: w */
    private final int f23424w;
    public static final NTRULPRimeParameters ntrulpr653 = new NTRULPRimeParameters("ntrulpr653", 653, 4621, 252, 289, 2175, 113, 2031, 290, 865, 897, 1125, 32);
    public static final NTRULPRimeParameters ntrulpr761 = new NTRULPRimeParameters("ntrulpr761", 761, 4591, 250, 292, 2156, 114, 2007, 287, 1007, 1039, 1294, 32);
    public static final NTRULPRimeParameters ntrulpr857 = new NTRULPRimeParameters("ntrulpr857", 857, 5167, 281, 329, 2433, 101, 2265, 324, 1152, 1184, 1463, 32);
    public static final NTRULPRimeParameters ntrulpr953 = new NTRULPRimeParameters("ntrulpr953", 953, 6343, 345, 404, 2997, 82, 2798, 400, 1317, 1349, 1652, 32);
    public static final NTRULPRimeParameters ntrulpr1013 = new NTRULPRimeParameters("ntrulpr1013", 1013, 7177, 392, 450, 3367, 73, 3143, 449, 1423, 1455, 1773, 32);
    public static final NTRULPRimeParameters ntrulpr1277 = new NTRULPRimeParameters("ntrulpr1277", 1277, 7879, 429, 502, 3724, 66, 3469, 496, 1815, 1847, 2231, 32);

    private NTRULPRimeParameters(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        this.f23417name = str;
        this.f23418p = i;
        this.f23419q = i2;
        this.f23424w = i3;
        this.f23416delta = i4;
        this.f23420tau0 = i5;
        this.f23421tau1 = i6;
        this.f23422tau2 = i7;
        this.f23423tau3 = i8;
        this.roundedPolynomialBytes = i9;
        this.publicKeyBytes = i10;
        this.privateKeyBytes = i11;
        this.sharedKeyBytes = i12;
    }

    public int getDelta() {
        return this.f23416delta;
    }

    /* renamed from: getName */
    public String m17776getName() {
        return this.f23417name;
    }

    /* renamed from: getP */
    public int m17777getP() {
        return this.f23418p;
    }

    public int getPrivateKeyBytes() {
        return this.privateKeyBytes;
    }

    public int getPublicKeyBytes() {
        return this.publicKeyBytes;
    }

    /* renamed from: getQ */
    public int m17778getQ() {
        return this.f23419q;
    }

    public int getRoundedPolynomialBytes() {
        return this.roundedPolynomialBytes;
    }

    public int getSessionKeySize() {
        return this.sharedKeyBytes * 8;
    }

    /* renamed from: getTau0 */
    public int m17779getTau0() {
        return this.f23420tau0;
    }

    /* renamed from: getTau1 */
    public int m17780getTau1() {
        return this.f23421tau1;
    }

    /* renamed from: getTau2 */
    public int m17781getTau2() {
        return this.f23422tau2;
    }

    /* renamed from: getTau3 */
    public int m17782getTau3() {
        return this.f23423tau3;
    }

    /* renamed from: getW */
    public int m17783getW() {
        return this.f23424w;
    }
}
