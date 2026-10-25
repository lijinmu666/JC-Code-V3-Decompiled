package org.bouncycastle.p314pqc.p316crypto.ntruprime;

import org.bouncycastle.p314pqc.p316crypto.KEMParameters;

/* loaded from: classes2.dex */
public class SNTRUPrimeParameters implements KEMParameters {

    /* renamed from: name */
    private final String f23433name;

    /* renamed from: p */
    private final int f23434p;
    private final int privateKeyBytes;
    private final int publicKeyBytes;

    /* renamed from: q */
    private final int f23435q;
    private final int roundedPolynomialBytes;
    private final int rqPolynomialBytes;
    private final int sharedKeyBytes;

    /* renamed from: w */
    private final int f23436w;
    public static final SNTRUPrimeParameters sntrup653 = new SNTRUPrimeParameters("sntrup653", 653, 4621, 288, 994, 865, 994, 1518, 32);
    public static final SNTRUPrimeParameters sntrup761 = new SNTRUPrimeParameters("sntrup761", 761, 4591, 286, 1158, 1007, 1158, 1763, 32);
    public static final SNTRUPrimeParameters sntrup857 = new SNTRUPrimeParameters("sntrup857", 857, 5167, 322, 1322, 1152, 1322, 1999, 32);
    public static final SNTRUPrimeParameters sntrup953 = new SNTRUPrimeParameters("sntrup953", 953, 6343, 396, 1505, 1317, 1505, 2254, 32);
    public static final SNTRUPrimeParameters sntrup1013 = new SNTRUPrimeParameters("sntrup1013", 1013, 7177, 448, 1623, 1423, 1623, 2417, 32);
    public static final SNTRUPrimeParameters sntrup1277 = new SNTRUPrimeParameters("sntrup1277", 1277, 7879, 492, 2067, 1815, 2067, 3059, 32);

    private SNTRUPrimeParameters(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f23433name = str;
        this.f23434p = i;
        this.f23435q = i2;
        this.f23436w = i3;
        this.rqPolynomialBytes = i4;
        this.roundedPolynomialBytes = i5;
        this.publicKeyBytes = i6;
        this.privateKeyBytes = i7;
        this.sharedKeyBytes = i8;
    }

    /* renamed from: getName */
    public String m17789getName() {
        return this.f23433name;
    }

    /* renamed from: getP */
    public int m17790getP() {
        return this.f23434p;
    }

    public int getPrivateKeyBytes() {
        return this.privateKeyBytes;
    }

    public int getPublicKeyBytes() {
        return this.publicKeyBytes;
    }

    /* renamed from: getQ */
    public int m17791getQ() {
        return this.f23435q;
    }

    public int getRoundedPolynomialBytes() {
        return this.roundedPolynomialBytes;
    }

    public int getRqPolynomialBytes() {
        return this.rqPolynomialBytes;
    }

    public int getSessionKeySize() {
        return this.sharedKeyBytes * 8;
    }

    /* renamed from: getW */
    public int m17792getW() {
        return this.f23436w;
    }
}
