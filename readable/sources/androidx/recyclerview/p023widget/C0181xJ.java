package androidx.recyclerview.p023widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.p023widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.xJ */
/* loaded from: classes.dex */
public class C0181xJ extends RecyclerView.AbstractC0162vI {

    /* renamed from: ETF */
    public PointF f1934ETF;

    /* renamed from: VA */
    public final DisplayMetrics f1936VA;

    /* renamed from: YoKzxo */
    public float f1937YoKzxo;

    /* renamed from: qdMbNW */
    public final LinearInterpolator f1939qdMbNW = new LinearInterpolator();

    /* renamed from: Dt */
    public final DecelerateInterpolator f1933Dt = new DecelerateInterpolator();

    /* renamed from: MiMN */
    public boolean f1935MiMN = false;

    /* renamed from: rkYL */
    public int f1940rkYL = 0;

    /* renamed from: qGY */
    public int f1938qGY = 0;

    public C0181xJ(Context context) {
        this.f1936VA = context.getResources().getDisplayMetrics();
    }

    /* renamed from: BAnRFn */
    public int m2079BAnRFn() {
        PointF pointF = this.f1934ETF;
        if (pointF != null) {
            float f = pointF.y;
            if (f != 0.0f) {
                return f > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    /* renamed from: Gd */
    public int mo1215Gd(int i) {
        return (int) Math.ceil(Math.abs(i) * m2082VocHEe());
    }

    /* renamed from: HGpJ */
    public final int m2080HGpJ(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0162vI
    /* renamed from: MiMN */
    public void mo1836MiMN() {
    }

    /* renamed from: Pq */
    public int m2081Pq(int i, int i2, int i3, int i4, int i5) {
        if (i5 == -1) {
            return i3 - i;
        }
        if (i5 != 0) {
            if (i5 == 1) {
                return i4 - i2;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i6 = i3 - i;
        if (i6 > 0) {
            return i6;
        }
        int i7 = i4 - i2;
        if (i7 < 0) {
            return i7;
        }
        return 0;
    }

    /* renamed from: Ucbh */
    public float mo1216Ucbh(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0162vI
    /* renamed from: VA */
    public void mo1837VA(int i, int i2, RecyclerView.C0148VocHEe c0148VocHEe, RecyclerView.AbstractC0162vI.mjFkc mjfkc) {
        if (m1845wA() == 0) {
            m1833IEE();
            return;
        }
        this.f1940rkYL = m2080HGpJ(this.f1940rkYL, i);
        int iM2080HGpJ = m2080HGpJ(this.f1938qGY, i2);
        this.f1938qGY = iM2080HGpJ;
        if (this.f1940rkYL == 0 && iM2080HGpJ == 0) {
            m2086lB(mjfkc);
        }
    }

    /* renamed from: VocHEe */
    public final float m2082VocHEe() {
        if (!this.f1935MiMN) {
            this.f1937YoKzxo = mo1216Ucbh(this.f1936VA);
            this.f1935MiMN = true;
        }
        return this.f1937YoKzxo;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0162vI
    /* renamed from: YoKzxo */
    public void mo1838YoKzxo() {
        this.f1938qGY = 0;
        this.f1940rkYL = 0;
        this.f1934ETF = null;
    }

    /* renamed from: diqgf */
    public int mo2083diqgf(View view, int i) {
        RecyclerView.AbstractC0159qGY abstractC0159qGYM1835KLFTb = m1835KLFTb();
        if (abstractC0159qGYM1835KLFTb == null || !abstractC0159qGYM1835KLFTb.mo1335VA()) {
            return 0;
        }
        RecyclerView.C0153fehf c0153fehf = (RecyclerView.C0153fehf) view.getLayoutParams();
        return m2081Pq(abstractC0159qGYM1835KLFTb.m1774aqHPIZ(view) - ((ViewGroup.MarginLayoutParams) c0153fehf).leftMargin, abstractC0159qGYM1835KLFTb.m1728GMIER(view) + ((ViewGroup.MarginLayoutParams) c0153fehf).rightMargin, abstractC0159qGYM1835KLFTb.m1783jm(), abstractC0159qGYM1835KLFTb.m1755SOS() - abstractC0159qGYM1835KLFTb.m1719ANMGZc(), i);
    }

    /* renamed from: eyqo */
    public int m2084eyqo(View view, int i) {
        RecyclerView.AbstractC0159qGY abstractC0159qGYM1835KLFTb = m1835KLFTb();
        if (abstractC0159qGYM1835KLFTb == null || !abstractC0159qGYM1835KLFTb.mo1322MiMN()) {
            return 0;
        }
        RecyclerView.C0153fehf c0153fehf = (RecyclerView.C0153fehf) view.getLayoutParams();
        return m2081Pq(abstractC0159qGYM1835KLFTb.m1803uHVRx(view) - ((ViewGroup.MarginLayoutParams) c0153fehf).topMargin, abstractC0159qGYM1835KLFTb.m1808vadzgd(view) + ((ViewGroup.MarginLayoutParams) c0153fehf).bottomMargin, abstractC0159qGYM1835KLFTb.m1777dm(), abstractC0159qGYM1835KLFTb.m1737JYgkl() - abstractC0159qGYM1835KLFTb.m1735JBhc(), i);
    }

    /* renamed from: huTpC */
    public int m2085huTpC(int i) {
        return (int) Math.ceil(mo1215Gd(i) / 0.3356d);
    }

    /* renamed from: lB */
    public void m2086lB(RecyclerView.AbstractC0162vI.mjFkc mjfkc) {
        PointF pointFMo1842mjFkc = mo1842mjFkc(m1834JHa());
        if (pointFMo1842mjFkc == null || (pointFMo1842mjFkc.x == 0.0f && pointFMo1842mjFkc.y == 0.0f)) {
            mjfkc.m1847AZxh(m1834JHa());
            m1833IEE();
            return;
        }
        m1844qdMbNW(pointFMo1842mjFkc);
        this.f1934ETF = pointFMo1842mjFkc;
        this.f1940rkYL = (int) (pointFMo1842mjFkc.x * 10000.0f);
        this.f1938qGY = (int) (pointFMo1842mjFkc.y * 10000.0f);
        mjfkc.m1849ZfxDd((int) (this.f1940rkYL * 1.2f), (int) (this.f1938qGY * 1.2f), (int) (mo1215Gd(10000) * 1.2f), this.f1939qdMbNW);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0162vI
    /* renamed from: rkYL */
    public void mo1217rkYL(View view, RecyclerView.C0148VocHEe c0148VocHEe, RecyclerView.AbstractC0162vI.mjFkc mjfkc) {
        int iMo2083diqgf = mo2083diqgf(view, m2087vI());
        int iM2084eyqo = m2084eyqo(view, m2079BAnRFn());
        int iM2085huTpC = m2085huTpC((int) Math.sqrt((iMo2083diqgf * iMo2083diqgf) + (iM2084eyqo * iM2084eyqo)));
        if (iM2085huTpC > 0) {
            mjfkc.m1849ZfxDd(-iMo2083diqgf, -iM2084eyqo, iM2085huTpC, this.f1933Dt);
        }
    }

    /* renamed from: vI */
    public int m2087vI() {
        PointF pointF = this.f1934ETF;
        if (pointF != null) {
            float f = pointF.x;
            if (f != 0.0f) {
                return f > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }
}
