package p131o;

import android.graphics.Color;

/* renamed from: o.xfXeiC */
/* loaded from: classes.dex */
public abstract class AbstractC4898xfXeiC {

    /* renamed from: mjFkc */
    public static final ThreadLocal f17409mjFkc = new ThreadLocal();

    /* renamed from: AZxh */
    public static int m13957AZxh(double d, double d2, double d3) {
        double d4 = (((3.2406d * d) + ((-1.5372d) * d2)) + ((-0.4986d) * d3)) / 100.0d;
        double d5 = ((((-0.9689d) * d) + (1.8758d * d2)) + (0.0415d * d3)) / 100.0d;
        double d6 = (((0.0557d * d) + ((-0.204d) * d2)) + (1.057d * d3)) / 100.0d;
        return Color.rgb(m13965qdMbNW((int) Math.round((d4 > 0.0031308d ? (Math.pow(d4, 0.4166666666666667d) * 1.055d) - 0.055d : d4 * 12.92d) * 255.0d), 0, 255), m13965qdMbNW((int) Math.round((d5 > 0.0031308d ? (Math.pow(d5, 0.4166666666666667d) * 1.055d) - 0.055d : d5 * 12.92d) * 255.0d), 0, 255), m13965qdMbNW((int) Math.round((d6 > 0.0031308d ? (Math.pow(d6, 0.4166666666666667d) * 1.055d) - 0.055d : d6 * 12.92d) * 255.0d), 0, 255));
    }

    /* renamed from: Dt */
    public static double[] m13958Dt() {
        ThreadLocal threadLocal = f17409mjFkc;
        double[] dArr = (double[]) threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }

    /* renamed from: ETF */
    public static int m13959ETF(int i, int i2) {
        if (i2 < 0 || i2 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i & 16777215) | (i2 << 24);
    }

    /* renamed from: JHa */
    public static int m13960JHa(int i, int i2) {
        return 255 - (((255 - i2) * (255 - i)) / 255);
    }

    /* renamed from: KLFTb */
    public static void m13961KLFTb(int i, double[] dArr) {
        m13964mjFkc(Color.red(i), Color.green(i), Color.blue(i), dArr);
    }

    /* renamed from: ZfxDd */
    public static double m13962ZfxDd(int i) {
        double[] dArrM13958Dt = m13958Dt();
        m13961KLFTb(i, dArrM13958Dt);
        return dArrM13958Dt[1] / 100.0d;
    }

    /* renamed from: lgHUyS */
    public static int m13963lgHUyS(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }

    /* renamed from: mjFkc */
    public static void m13964mjFkc(int i, int i2, int i3, double[] dArr) {
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d = i / 255.0d;
        double dPow = d < 0.04045d ? d / 12.92d : Math.pow((d + 0.055d) / 1.055d, 2.4d);
        double d2 = i2 / 255.0d;
        double dPow2 = d2 < 0.04045d ? d2 / 12.92d : Math.pow((d2 + 0.055d) / 1.055d, 2.4d);
        double d3 = i3 / 255.0d;
        double dPow3 = d3 < 0.04045d ? d3 / 12.92d : Math.pow((d3 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.4124d * dPow) + (0.3576d * dPow2) + (0.1805d * dPow3)) * 100.0d;
        dArr[1] = ((0.2126d * dPow) + (0.7152d * dPow2) + (0.0722d * dPow3)) * 100.0d;
        dArr[2] = ((dPow * 0.0193d) + (dPow2 * 0.1192d) + (dPow3 * 0.9505d)) * 100.0d;
    }

    /* renamed from: qdMbNW */
    public static int m13965qdMbNW(int i, int i2, int i3) {
        return i < i2 ? i2 : Math.min(i, i3);
    }

    /* renamed from: wA */
    public static int m13966wA(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((Color.alpha(i) * f2) + (Color.alpha(i2) * f)), (int) ((Color.red(i) * f2) + (Color.red(i2) * f)), (int) ((Color.green(i) * f2) + (Color.green(i2) * f)), (int) ((Color.blue(i) * f2) + (Color.blue(i2) * f)));
    }

    /* renamed from: xJ */
    public static int m13967xJ(int i, int i2) {
        int iAlpha = Color.alpha(i2);
        int iAlpha2 = Color.alpha(i);
        int iM13960JHa = m13960JHa(iAlpha2, iAlpha);
        return Color.argb(iM13960JHa, m13963lgHUyS(Color.red(i), iAlpha2, Color.red(i2), iAlpha, iM13960JHa), m13963lgHUyS(Color.green(i), iAlpha2, Color.green(i2), iAlpha, iM13960JHa), m13963lgHUyS(Color.blue(i), iAlpha2, Color.blue(i2), iAlpha, iM13960JHa));
    }
}
