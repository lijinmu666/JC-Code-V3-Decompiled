package p131o;

/* renamed from: o.Ba */
/* loaded from: classes.dex */
public final class C1702Ba {

    /* renamed from: ETF */
    public static final C1702Ba f7486ETF = m7718ETF(AbstractC2001Fztqa.f8278wA, (float) ((AbstractC2001Fztqa.m8341lgHUyS(50.0f) * 63.66197723675813d) / 100.0d), 50.0f, 2.0f, false);

    /* renamed from: AZxh */
    public final float f7487AZxh;

    /* renamed from: Dt */
    public final float f7488Dt;

    /* renamed from: JHa */
    public final float f7489JHa;

    /* renamed from: KLFTb */
    public final float f7490KLFTb;

    /* renamed from: ZfxDd */
    public final float f7491ZfxDd;

    /* renamed from: lgHUyS */
    public final float f7492lgHUyS;

    /* renamed from: mjFkc */
    public final float f7493mjFkc;

    /* renamed from: qdMbNW */
    public final float f7494qdMbNW;

    /* renamed from: wA */
    public final float f7495wA;

    /* renamed from: xJ */
    public final float[] f7496xJ;

    public C1702Ba(float f, float f2, float f3, float f4, float f5, float f6, float[] fArr, float f7, float f8, float f9) {
        this.f7489JHa = f;
        this.f7493mjFkc = f2;
        this.f7487AZxh = f3;
        this.f7495wA = f4;
        this.f7491ZfxDd = f5;
        this.f7490KLFTb = f6;
        this.f7496xJ = fArr;
        this.f7492lgHUyS = f7;
        this.f7494qdMbNW = f8;
        this.f7488Dt = f9;
    }

    /* renamed from: ETF */
    public static C1702Ba m7718ETF(float[] fArr, float f, float f2, float f3, boolean z) {
        float[][] fArr2 = AbstractC2001Fztqa.f8277mjFkc;
        float f4 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f5 = fArr3[0] * f4;
        float f6 = fArr[1];
        float f7 = f5 + (fArr3[1] * f6);
        float f8 = fArr[2];
        float f9 = f7 + (fArr3[2] * f8);
        float[] fArr4 = fArr2[1];
        float f10 = (fArr4[0] * f4) + (fArr4[1] * f6) + (fArr4[2] * f8);
        float[] fArr5 = fArr2[2];
        float f11 = (f4 * fArr5[0]) + (f6 * fArr5[1]) + (f8 * fArr5[2]);
        float f12 = (f3 / 10.0f) + 0.8f;
        float fM8340ZfxDd = ((double) f12) >= 0.9d ? AbstractC2001Fztqa.m8340ZfxDd(0.59f, 0.69f, (f12 - 0.9f) * 10.0f) : AbstractC2001Fztqa.m8340ZfxDd(0.525f, 0.59f, (f12 - 0.8f) * 10.0f);
        float fExp = z ? 1.0f : (1.0f - (((float) Math.exp(((-f) - 42.0f) / 92.0f)) * 0.2777778f)) * f12;
        double d = fExp;
        if (d > 1.0d) {
            fExp = 1.0f;
        } else if (d < 0.0d) {
            fExp = 0.0f;
        }
        float[] fArr6 = {(((100.0f / f9) * fExp) + 1.0f) - fExp, (((100.0f / f10) * fExp) + 1.0f) - fExp, (((100.0f / f11) * fExp) + 1.0f) - fExp};
        float f13 = 1.0f / ((5.0f * f) + 1.0f);
        float f14 = f13 * f13 * f13 * f13;
        float f15 = 1.0f - f14;
        float fCbrt = (f14 * f) + (0.1f * f15 * f15 * ((float) Math.cbrt(f * 5.0d)));
        float fM8341lgHUyS = AbstractC2001Fztqa.m8341lgHUyS(f2) / fArr[1];
        double d2 = fM8341lgHUyS;
        float fSqrt = ((float) Math.sqrt(d2)) + 1.48f;
        float fPow = 0.725f / ((float) Math.pow(d2, 0.2d));
        float[] fArr7 = {(float) Math.pow(((fArr6[0] * fCbrt) * f9) / 100.0d, 0.42d), (float) Math.pow(((fArr6[1] * fCbrt) * f10) / 100.0d, 0.42d), (float) Math.pow(((fArr6[2] * fCbrt) * f11) / 100.0d, 0.42d)};
        float f16 = fArr7[0];
        float f17 = (f16 * 400.0f) / (f16 + 27.13f);
        float f18 = fArr7[1];
        float f19 = (f18 * 400.0f) / (f18 + 27.13f);
        float f20 = fArr7[2];
        float[] fArr8 = {f17, f19, (400.0f * f20) / (f20 + 27.13f)};
        return new C1702Ba(fM8341lgHUyS, ((fArr8[0] * 2.0f) + fArr8[1] + (fArr8[2] * 0.05f)) * fPow, fPow, fPow, fM8340ZfxDd, f12, fArr6, fCbrt, (float) Math.pow(fCbrt, 0.25d), fSqrt);
    }

    /* renamed from: AZxh */
    public float m7719AZxh() {
        return this.f7491ZfxDd;
    }

    /* renamed from: Dt */
    public float m7720Dt() {
        return this.f7488Dt;
    }

    /* renamed from: JHa */
    public float m7721JHa() {
        return this.f7487AZxh;
    }

    /* renamed from: KLFTb */
    public float m7722KLFTb() {
        return this.f7489JHa;
    }

    /* renamed from: ZfxDd */
    public float m7723ZfxDd() {
        return this.f7494qdMbNW;
    }

    /* renamed from: lgHUyS */
    public float m7724lgHUyS() {
        return this.f7495wA;
    }

    /* renamed from: mjFkc */
    public float m7725mjFkc() {
        return this.f7493mjFkc;
    }

    /* renamed from: qdMbNW */
    public float[] m7726qdMbNW() {
        return this.f7496xJ;
    }

    /* renamed from: wA */
    public float m7727wA() {
        return this.f7492lgHUyS;
    }

    /* renamed from: xJ */
    public float m7728xJ() {
        return this.f7490KLFTb;
    }
}
