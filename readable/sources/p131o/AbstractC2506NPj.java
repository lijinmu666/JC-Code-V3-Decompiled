package p131o;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* renamed from: o.NPj */
/* loaded from: classes.dex */
public abstract class AbstractC2506NPj {

    /* renamed from: mjFkc */
    public static final TimeInterpolator f9739mjFkc = new LinearInterpolator();

    /* renamed from: AZxh */
    public static final TimeInterpolator f9736AZxh = new C3439bXx();

    /* renamed from: wA */
    public static final TimeInterpolator f9740wA = new C2432MLqR();

    /* renamed from: ZfxDd */
    public static final TimeInterpolator f9738ZfxDd = new C3132X0();

    /* renamed from: KLFTb */
    public static final TimeInterpolator f9737KLFTb = new DecelerateInterpolator();

    /* renamed from: AZxh */
    public static float m9655AZxh(float f, float f2, float f3, float f4, float f5) {
        return f5 <= f3 ? f : f5 >= f4 ? f2 : m9656mjFkc(f, f2, (f5 - f3) / (f4 - f3));
    }

    /* renamed from: mjFkc */
    public static float m9656mjFkc(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    /* renamed from: wA */
    public static int m9657wA(int i, int i2, float f) {
        return i + Math.round(f * (i2 - i));
    }
}
