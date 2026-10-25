package p131o;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* renamed from: o.x2 */
/* loaded from: classes.dex */
public class C4855x2 {

    /* renamed from: AZxh */
    public long f17308AZxh;

    /* renamed from: KLFTb */
    public int f17309KLFTb;

    /* renamed from: ZfxDd */
    public int f17310ZfxDd;

    /* renamed from: mjFkc */
    public long f17311mjFkc;

    /* renamed from: wA */
    public TimeInterpolator f17312wA;

    public C4855x2(long j, long j2) {
        this.f17312wA = null;
        this.f17310ZfxDd = 0;
        this.f17309KLFTb = 1;
        this.f17311mjFkc = j;
        this.f17308AZxh = j2;
    }

    /* renamed from: KLFTb */
    public static TimeInterpolator m13882KLFTb(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        return ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) ? AbstractC2506NPj.f9736AZxh : interpolator instanceof AccelerateInterpolator ? AbstractC2506NPj.f9740wA : interpolator instanceof DecelerateInterpolator ? AbstractC2506NPj.f9738ZfxDd : interpolator;
    }

    /* renamed from: mjFkc */
    public static C4855x2 m13883mjFkc(ValueAnimator valueAnimator) {
        C4855x2 c4855x2 = new C4855x2(valueAnimator.getStartDelay(), valueAnimator.getDuration(), m13882KLFTb(valueAnimator));
        c4855x2.f17310ZfxDd = valueAnimator.getRepeatCount();
        c4855x2.f17309KLFTb = valueAnimator.getRepeatMode();
        return c4855x2;
    }

    /* renamed from: AZxh */
    public long m13884AZxh() {
        return this.f17311mjFkc;
    }

    /* renamed from: JHa */
    public int m13885JHa() {
        return this.f17310ZfxDd;
    }

    /* renamed from: ZfxDd */
    public TimeInterpolator m13886ZfxDd() {
        TimeInterpolator timeInterpolator = this.f17312wA;
        return timeInterpolator != null ? timeInterpolator : AbstractC2506NPj.f9736AZxh;
    }

    /* renamed from: equals */
    public boolean m13887equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4855x2)) {
            return false;
        }
        C4855x2 c4855x2 = (C4855x2) obj;
        if (m13884AZxh() == c4855x2.m13884AZxh() && m13888wA() == c4855x2.m13888wA() && m13885JHa() == c4855x2.m13885JHa() && m13889xJ() == c4855x2.m13889xJ()) {
            return m13886ZfxDd().getClass().equals(c4855x2.m13886ZfxDd().getClass());
        }
        return false;
    }

    public int hashCode() {
        return (((((((((int) (m13884AZxh() ^ (m13884AZxh() >>> 32))) * 31) + ((int) (m13888wA() ^ (m13888wA() >>> 32)))) * 31) + m13886ZfxDd().getClass().hashCode()) * 31) + m13885JHa()) * 31) + m13889xJ();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + m13884AZxh() + " duration: " + m13888wA() + " interpolator: " + m13886ZfxDd().getClass() + " repeatCount: " + m13885JHa() + " repeatMode: " + m13889xJ() + "}\n";
    }

    /* renamed from: wA */
    public long m13888wA() {
        return this.f17308AZxh;
    }

    /* renamed from: xJ */
    public int m13889xJ() {
        return this.f17309KLFTb;
    }

    public C4855x2(long j, long j2, TimeInterpolator timeInterpolator) {
        this.f17310ZfxDd = 0;
        this.f17309KLFTb = 1;
        this.f17311mjFkc = j;
        this.f17308AZxh = j2;
        this.f17312wA = timeInterpolator;
    }
}
