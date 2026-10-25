package p131o;

import android.graphics.Color;

/* renamed from: o.Fztqa */
/* loaded from: classes.dex */
public abstract class AbstractC2001Fztqa {

    /* renamed from: mjFkc */
    public static final float[][] f8277mjFkc = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};

    /* renamed from: AZxh */
    public static final float[][] f8275AZxh = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};

    /* renamed from: wA */
    public static final float[] f8278wA = {95.047f, 100.0f, 108.883f};

    /* renamed from: ZfxDd */
    public static final float[][] f8276ZfxDd = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};

    /* renamed from: AZxh */
    public static float m8337AZxh(int i) {
        return m8343wA(m8344xJ(i));
    }

    /* renamed from: JHa */
    public static void m8338JHa(int i, float[] fArr) {
        float fM8339KLFTb = m8339KLFTb(Color.red(i));
        float fM8339KLFTb2 = m8339KLFTb(Color.green(i));
        float fM8339KLFTb3 = m8339KLFTb(Color.blue(i));
        float[][] fArr2 = f8276ZfxDd;
        float[] fArr3 = fArr2[0];
        fArr[0] = (fArr3[0] * fM8339KLFTb) + (fArr3[1] * fM8339KLFTb2) + (fArr3[2] * fM8339KLFTb3);
        float[] fArr4 = fArr2[1];
        fArr[1] = (fArr4[0] * fM8339KLFTb) + (fArr4[1] * fM8339KLFTb2) + (fArr4[2] * fM8339KLFTb3);
        float[] fArr5 = fArr2[2];
        fArr[2] = (fM8339KLFTb * fArr5[0]) + (fM8339KLFTb2 * fArr5[1]) + (fM8339KLFTb3 * fArr5[2]);
    }

    /* renamed from: KLFTb */
    public static float m8339KLFTb(int i) {
        float f = i / 255.0f;
        return (f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d)) * 100.0f;
    }

    /* renamed from: ZfxDd */
    public static float m8340ZfxDd(float f, float f2, float f3) {
        return f + ((f2 - f) * f3);
    }

    /* renamed from: lgHUyS */
    public static float m8341lgHUyS(float f) {
        return (f > 8.0f ? (float) Math.pow((f + 16.0d) / 116.0d, 3.0d) : f / 903.2963f) * 100.0f;
    }

    /* renamed from: mjFkc */
    public static int m8342mjFkc(float f) {
        if (f < 1.0f) {
            return -16777216;
        }
        if (f > 99.0f) {
            return -1;
        }
        float f2 = (f + 16.0f) / 116.0f;
        float f3 = f > 8.0f ? f2 * f2 * f2 : f / 903.2963f;
        float f4 = f2 * f2 * f2;
        boolean z = f4 > 0.008856452f;
        float f5 = z ? f4 : ((f2 * 116.0f) - 16.0f) / 903.2963f;
        if (!z) {
            f4 = ((f2 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = f8278wA;
        return AbstractC4898xfXeiC.m13957AZxh(f5 * fArr[0], f3 * fArr[1], f4 * fArr[2]);
    }

    /* renamed from: wA */
    public static float m8343wA(float f) {
        float f2 = f / 100.0f;
        return f2 <= 0.008856452f ? f2 * 903.2963f : (((float) Math.cbrt(f2)) * 116.0f) - 16.0f;
    }

    /* renamed from: xJ */
    public static float m8344xJ(int i) {
        float fM8339KLFTb = m8339KLFTb(Color.red(i));
        float fM8339KLFTb2 = m8339KLFTb(Color.green(i));
        float fM8339KLFTb3 = m8339KLFTb(Color.blue(i));
        float[] fArr = f8276ZfxDd[1];
        return (fM8339KLFTb * fArr[0]) + (fM8339KLFTb2 * fArr[1]) + (fM8339KLFTb3 * fArr[2]);
    }
}
