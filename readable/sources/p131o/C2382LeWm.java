package p131o;

/* renamed from: o.LeWm */
/* loaded from: classes.dex */
public class C2382LeWm {

    /* renamed from: AZxh */
    public final float f9461AZxh;

    /* renamed from: JHa */
    public final float f9462JHa;

    /* renamed from: KLFTb */
    public final float f9463KLFTb;

    /* renamed from: ZfxDd */
    public final float f9464ZfxDd;

    /* renamed from: lgHUyS */
    public final float f9465lgHUyS;

    /* renamed from: mjFkc */
    public final float f9466mjFkc;

    /* renamed from: qdMbNW */
    public final float f9467qdMbNW;

    /* renamed from: wA */
    public final float f9468wA;

    /* renamed from: xJ */
    public final float f9469xJ;

    public C2382LeWm(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.f9466mjFkc = f;
        this.f9461AZxh = f2;
        this.f9468wA = f3;
        this.f9464ZfxDd = f4;
        this.f9463KLFTb = f5;
        this.f9462JHa = f6;
        this.f9469xJ = f7;
        this.f9465lgHUyS = f8;
        this.f9467qdMbNW = f9;
    }

    /* renamed from: AZxh */
    public static C2382LeWm m9374AZxh(float f, float f2, float f3) {
        float f4 = 100.0f;
        float f5 = 1000.0f;
        float f6 = 0.0f;
        C2382LeWm c2382LeWm = null;
        float f7 = 1000.0f;
        while (Math.abs(f6 - f4) > 0.01f) {
            float f8 = ((f4 - f6) / 2.0f) + f6;
            int iM9386qGY = m9376KLFTb(f8, f2, f).m9386qGY();
            float fM8337AZxh = AbstractC2001Fztqa.m8337AZxh(iM9386qGY);
            float fAbs = Math.abs(f3 - fM8337AZxh);
            if (fAbs < 0.2f) {
                C2382LeWm c2382LeWmM9380wA = m9380wA(iM9386qGY);
                float fM9385mjFkc = c2382LeWmM9380wA.m9385mjFkc(m9376KLFTb(c2382LeWmM9380wA.m9382ETF(), c2382LeWmM9380wA.m9387qdMbNW(), f));
                if (fM9385mjFkc <= 1.0f) {
                    c2382LeWm = c2382LeWmM9380wA;
                    f5 = fAbs;
                    f7 = fM9385mjFkc;
                }
            }
            if (f5 == 0.0f && f7 == 0.0f) {
                break;
            }
            if (fM8337AZxh < f3) {
                f6 = f8;
            } else {
                f4 = f8;
            }
        }
        return c2382LeWm;
    }

    /* renamed from: JHa */
    public static C2382LeWm m9375JHa(float f, float f2, float f3, C1702Ba c1702Ba) {
        float fM7719AZxh = (4.0f / c1702Ba.m7719AZxh()) * ((float) Math.sqrt(f / 100.0d)) * (c1702Ba.m7725mjFkc() + 4.0f) * c1702Ba.m7723ZfxDd();
        float fM7723ZfxDd = f2 * c1702Ba.m7723ZfxDd();
        float fSqrt = ((float) Math.sqrt(((f2 / ((float) Math.sqrt(r4))) * c1702Ba.m7719AZxh()) / (c1702Ba.m7725mjFkc() + 4.0f))) * 50.0f;
        float f4 = (1.7f * f) / ((0.007f * f) + 1.0f);
        float fLog = ((float) Math.log((fM7723ZfxDd * 0.0228d) + 1.0d)) * 43.85965f;
        double d = (3.1415927f * f3) / 180.0f;
        return new C2382LeWm(f3, f2, f, fM7719AZxh, fM7723ZfxDd, fSqrt, f4, fLog * ((float) Math.cos(d)), fLog * ((float) Math.sin(d)));
    }

    /* renamed from: KLFTb */
    public static C2382LeWm m9376KLFTb(float f, float f2, float f3) {
        return m9375JHa(f, f2, f3, C1702Ba.f7486ETF);
    }

    /* renamed from: MiMN */
    public static int m9377MiMN(float f, float f2, float f3) {
        return m9378YoKzxo(f, f2, f3, C1702Ba.f7486ETF);
    }

    /* renamed from: YoKzxo */
    public static int m9378YoKzxo(float f, float f2, float f3, C1702Ba c1702Ba) {
        if (f2 < 1.0d || Math.round(f3) <= 0.0d || Math.round(f3) >= 100.0d) {
            return AbstractC2001Fztqa.m8342mjFkc(f3);
        }
        float fMin = f < 0.0f ? 0.0f : Math.min(360.0f, f);
        C2382LeWm c2382LeWm = null;
        boolean z = true;
        float f4 = 0.0f;
        float f5 = f2;
        while (Math.abs(f4 - f2) >= 0.4f) {
            C2382LeWm c2382LeWmM9374AZxh = m9374AZxh(fMin, f5, f3);
            if (!z) {
                if (c2382LeWmM9374AZxh == null) {
                    f2 = f5;
                } else {
                    f4 = f5;
                    c2382LeWm = c2382LeWmM9374AZxh;
                }
                f5 = ((f2 - f4) / 2.0f) + f4;
            } else {
                if (c2382LeWmM9374AZxh != null) {
                    return c2382LeWmM9374AZxh.m9388rkYL(c1702Ba);
                }
                f5 = ((f2 - f4) / 2.0f) + f4;
                z = false;
            }
        }
        return c2382LeWm == null ? AbstractC2001Fztqa.m8342mjFkc(f3) : c2382LeWm.m9388rkYL(c1702Ba);
    }

    /* renamed from: ZfxDd */
    public static void m9379ZfxDd(int i, C1702Ba c1702Ba, float[] fArr, float[] fArr2) {
        AbstractC2001Fztqa.m8338JHa(i, fArr2);
        float[][] fArr3 = AbstractC2001Fztqa.f8277mjFkc;
        float f = fArr2[0];
        float[] fArr4 = fArr3[0];
        float f2 = fArr4[0] * f;
        float f3 = fArr2[1];
        float f4 = f2 + (fArr4[1] * f3);
        float f5 = fArr2[2];
        float f6 = f4 + (fArr4[2] * f5);
        float[] fArr5 = fArr3[1];
        float f7 = (fArr5[0] * f) + (fArr5[1] * f3) + (fArr5[2] * f5);
        float[] fArr6 = fArr3[2];
        float f8 = (f * fArr6[0]) + (f3 * fArr6[1]) + (f5 * fArr6[2]);
        float f9 = c1702Ba.m7726qdMbNW()[0] * f6;
        float f10 = c1702Ba.m7726qdMbNW()[1] * f7;
        float f11 = c1702Ba.m7726qdMbNW()[2] * f8;
        float fPow = (float) Math.pow((c1702Ba.m7727wA() * Math.abs(f9)) / 100.0d, 0.42d);
        float fPow2 = (float) Math.pow((c1702Ba.m7727wA() * Math.abs(f10)) / 100.0d, 0.42d);
        float fPow3 = (float) Math.pow((c1702Ba.m7727wA() * Math.abs(f11)) / 100.0d, 0.42d);
        float fSignum = ((Math.signum(f9) * 400.0f) * fPow) / (fPow + 27.13f);
        float fSignum2 = ((Math.signum(f10) * 400.0f) * fPow2) / (fPow2 + 27.13f);
        float fSignum3 = ((Math.signum(f11) * 400.0f) * fPow3) / (fPow3 + 27.13f);
        double d = fSignum3;
        float f12 = ((float) (((fSignum * 11.0d) + (fSignum2 * (-12.0d))) + d)) / 11.0f;
        float f13 = ((float) ((fSignum + fSignum2) - (d * 2.0d))) / 9.0f;
        float f14 = fSignum2 * 20.0f;
        float f15 = (((fSignum * 20.0f) + f14) + (21.0f * fSignum3)) / 20.0f;
        float f16 = (((fSignum * 40.0f) + f14) + fSignum3) / 20.0f;
        float fAtan2 = (((float) Math.atan2(f13, f12)) * 180.0f) / 3.1415927f;
        if (fAtan2 < 0.0f) {
            fAtan2 += 360.0f;
        } else if (fAtan2 >= 360.0f) {
            fAtan2 -= 360.0f;
        }
        float f17 = (3.1415927f * fAtan2) / 180.0f;
        float fPow4 = ((float) Math.pow((f16 * c1702Ba.m7721JHa()) / c1702Ba.m7725mjFkc(), c1702Ba.m7719AZxh() * c1702Ba.m7720Dt())) * 100.0f;
        float fM7719AZxh = (4.0f / c1702Ba.m7719AZxh()) * ((float) Math.sqrt(fPow4 / 100.0f)) * (c1702Ba.m7725mjFkc() + 4.0f) * c1702Ba.m7723ZfxDd();
        float fSqrt = ((float) Math.sqrt(fPow4 / 100.0d)) * ((float) Math.pow(1.64d - Math.pow(0.29d, c1702Ba.m7722KLFTb()), 0.73d)) * ((float) Math.pow((((((((float) (Math.cos((((((double) fAtan2) < 20.14d ? 360.0f + fAtan2 : fAtan2) * 3.141592653589793d) / 180.0d) + 2.0d) + 3.8d)) * 0.25f) * 3846.1538f) * c1702Ba.m7728xJ()) * c1702Ba.m7724lgHUyS()) * ((float) Math.sqrt((f12 * f12) + (f13 * f13)))) / (f15 + 0.305f), 0.9d));
        float fM7723ZfxDd = c1702Ba.m7723ZfxDd() * fSqrt;
        float fSqrt2 = ((float) Math.sqrt((r7 * c1702Ba.m7719AZxh()) / (c1702Ba.m7725mjFkc() + 4.0f))) * 50.0f;
        float f18 = (1.7f * fPow4) / ((0.007f * fPow4) + 1.0f);
        float fLog = ((float) Math.log((0.0228f * fM7723ZfxDd) + 1.0f)) * 43.85965f;
        double d2 = f17;
        float fCos = ((float) Math.cos(d2)) * fLog;
        float fSin = fLog * ((float) Math.sin(d2));
        fArr2[0] = fAtan2;
        fArr2[1] = fSqrt;
        if (fArr != null) {
            fArr[0] = fPow4;
            fArr[1] = fM7719AZxh;
            fArr[2] = fM7723ZfxDd;
            fArr[3] = fSqrt2;
            fArr[4] = f18;
            fArr[5] = fCos;
            fArr[6] = fSin;
        }
    }

    /* renamed from: wA */
    public static C2382LeWm m9380wA(int i) {
        float[] fArr = new float[7];
        float[] fArr2 = new float[3];
        m9379ZfxDd(i, C1702Ba.f7486ETF, fArr, fArr2);
        return new C2382LeWm(fArr2[0], fArr2[1], fArr[0], fArr[1], fArr[2], fArr[3], fArr[4], fArr[5], fArr[6]);
    }

    /* renamed from: Dt */
    public float m9381Dt() {
        return this.f9466mjFkc;
    }

    /* renamed from: ETF */
    public float m9382ETF() {
        return this.f9468wA;
    }

    /* renamed from: VA */
    public float m9383VA() {
        return this.f9469xJ;
    }

    /* renamed from: lgHUyS */
    public float m9384lgHUyS() {
        return this.f9467qdMbNW;
    }

    /* renamed from: mjFkc */
    public float m9385mjFkc(C2382LeWm c2382LeWm) {
        float fM9383VA = m9383VA() - c2382LeWm.m9383VA();
        float fM9389xJ = m9389xJ() - c2382LeWm.m9389xJ();
        float fM9384lgHUyS = m9384lgHUyS() - c2382LeWm.m9384lgHUyS();
        return (float) (Math.pow(Math.sqrt((fM9383VA * fM9383VA) + (fM9389xJ * fM9389xJ) + (fM9384lgHUyS * fM9384lgHUyS)), 0.63d) * 1.41d);
    }

    /* renamed from: qGY */
    public int m9386qGY() {
        return m9388rkYL(C1702Ba.f7486ETF);
    }

    /* renamed from: qdMbNW */
    public float m9387qdMbNW() {
        return this.f9461AZxh;
    }

    /* renamed from: rkYL */
    public int m9388rkYL(C1702Ba c1702Ba) {
        float fPow = (float) Math.pow(((((double) m9387qdMbNW()) == 0.0d || ((double) m9382ETF()) == 0.0d) ? 0.0f : m9387qdMbNW() / ((float) Math.sqrt(m9382ETF() / 100.0d))) / Math.pow(1.64d - Math.pow(0.29d, c1702Ba.m7722KLFTb()), 0.73d), 1.1111111111111112d);
        double dM9381Dt = (m9381Dt() * 3.1415927f) / 180.0f;
        float fCos = ((float) (Math.cos(2.0d + dM9381Dt) + 3.8d)) * 0.25f;
        float fM7725mjFkc = c1702Ba.m7725mjFkc() * ((float) Math.pow(m9382ETF() / 100.0d, (1.0d / c1702Ba.m7719AZxh()) / c1702Ba.m7720Dt()));
        float fM7728xJ = fCos * 3846.1538f * c1702Ba.m7728xJ() * c1702Ba.m7724lgHUyS();
        float fM7721JHa = fM7725mjFkc / c1702Ba.m7721JHa();
        float fSin = (float) Math.sin(dM9381Dt);
        float fCos2 = (float) Math.cos(dM9381Dt);
        float f = (((0.305f + fM7721JHa) * 23.0f) * fPow) / (((fM7728xJ * 23.0f) + ((11.0f * fPow) * fCos2)) + ((fPow * 108.0f) * fSin));
        float f2 = fCos2 * f;
        float f3 = f * fSin;
        float f4 = fM7721JHa * 460.0f;
        float f5 = (((451.0f * f2) + f4) + (288.0f * f3)) / 1403.0f;
        float f6 = ((f4 - (891.0f * f2)) - (261.0f * f3)) / 1403.0f;
        float fSignum = Math.signum(f5) * (100.0f / c1702Ba.m7727wA()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f5) * 27.13d) / (400.0d - Math.abs(f5))), 2.380952380952381d));
        float fSignum2 = Math.signum(f6) * (100.0f / c1702Ba.m7727wA()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(f6) * 27.13d) / (400.0d - Math.abs(f6))), 2.380952380952381d));
        float fSignum3 = Math.signum(((f4 - (f2 * 220.0f)) - (f3 * 6300.0f)) / 1403.0f) * (100.0f / c1702Ba.m7727wA()) * ((float) Math.pow((float) Math.max(0.0d, (Math.abs(r8) * 27.13d) / (400.0d - Math.abs(r8))), 2.380952380952381d));
        float f7 = fSignum / c1702Ba.m7726qdMbNW()[0];
        float f8 = fSignum2 / c1702Ba.m7726qdMbNW()[1];
        float f9 = fSignum3 / c1702Ba.m7726qdMbNW()[2];
        float[][] fArr = AbstractC2001Fztqa.f8275AZxh;
        float[] fArr2 = fArr[0];
        float f10 = (fArr2[0] * f7) + (fArr2[1] * f8) + (fArr2[2] * f9);
        float[] fArr3 = fArr[1];
        float f11 = (fArr3[0] * f7) + (fArr3[1] * f8) + (fArr3[2] * f9);
        float[] fArr4 = fArr[2];
        return AbstractC4898xfXeiC.m13957AZxh(f10, f11, (f7 * fArr4[0]) + (f8 * fArr4[1]) + (f9 * fArr4[2]));
    }

    /* renamed from: xJ */
    public float m9389xJ() {
        return this.f9465lgHUyS;
    }
}
