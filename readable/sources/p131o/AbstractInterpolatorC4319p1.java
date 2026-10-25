package p131o;

import android.view.animation.Interpolator;

/* renamed from: o.p1 */
/* loaded from: classes.dex */
public abstract class AbstractInterpolatorC4319p1 implements Interpolator {

    /* renamed from: AZxh */
    public final float f15893AZxh;

    /* renamed from: mjFkc */
    public final float[] f15894mjFkc;

    public AbstractInterpolatorC4319p1(float[] fArr) {
        this.f15894mjFkc = fArr;
        this.f15893AZxh = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f15894mjFkc;
        int iMin = Math.min((int) ((fArr.length - 1) * f), fArr.length - 2);
        float f2 = this.f15893AZxh;
        float f3 = (f - (iMin * f2)) / f2;
        float[] fArr2 = this.f15894mjFkc;
        float f4 = fArr2[iMin];
        return f4 + (f3 * (fArr2[iMin + 1] - f4));
    }
}
