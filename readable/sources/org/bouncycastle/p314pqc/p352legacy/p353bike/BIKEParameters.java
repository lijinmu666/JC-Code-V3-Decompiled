package org.bouncycastle.p314pqc.p352legacy.p353bike;

import org.bouncycastle.p314pqc.p316crypto.KEMParameters;

/* loaded from: classes2.dex */
public class BIKEParameters implements KEMParameters {

    /* renamed from: bike128 */
    public static final BIKEParameters f23947bike128 = new BIKEParameters("bike128", 12323, 142, 134, 256, 5, 3, 128);

    /* renamed from: bike192 */
    public static final BIKEParameters f23948bike192 = new BIKEParameters("bike192", 24659, 206, 199, 256, 5, 3, 192);

    /* renamed from: bike256 */
    public static final BIKEParameters f23949bike256 = new BIKEParameters("bike256", 40973, 274, 264, 256, 5, 3, 256);
    private BIKEEngine bikeEngine;
    private final int defaultKeySize;

    /* renamed from: l */
    private int f23950l;

    /* renamed from: name */
    private String f23951name;

    /* renamed from: nbIter */
    private int f23952nbIter;

    /* renamed from: r */
    private int f23953r;

    /* renamed from: t */
    private int f23954t;

    /* renamed from: tau */
    private int f23955tau;

    /* renamed from: w */
    private int f23956w;

    private BIKEParameters(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f23951name = str;
        this.f23953r = i;
        this.f23956w = i2;
        this.f23954t = i3;
        this.f23950l = i4;
        this.f23952nbIter = i5;
        this.f23955tau = i6;
        this.defaultKeySize = i7;
        this.bikeEngine = new BIKEEngine(i, i2, i3, i4, i5, i6);
    }

    public BIKEEngine getEngine() {
        return this.bikeEngine;
    }

    /* renamed from: getL */
    public int m18063getL() {
        return this.f23950l;
    }

    public int getLByte() {
        return this.f23950l / 8;
    }

    /* renamed from: getName */
    public String m18064getName() {
        return this.f23951name;
    }

    public int getNbIter() {
        return this.f23952nbIter;
    }

    /* renamed from: getR */
    public int m18065getR() {
        return this.f23953r;
    }

    public int getRByte() {
        return (this.f23953r + 7) / 8;
    }

    public int getSessionKeySize() {
        return this.defaultKeySize;
    }

    /* renamed from: getT */
    public int m18066getT() {
        return this.f23954t;
    }

    /* renamed from: getTau */
    public int m18067getTau() {
        return this.f23955tau;
    }

    /* renamed from: getW */
    public int m18068getW() {
        return this.f23956w;
    }
}
