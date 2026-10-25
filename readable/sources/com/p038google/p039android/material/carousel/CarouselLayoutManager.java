package com.p038google.p039android.material.carousel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.p023widget.C0181xJ;
import androidx.recyclerview.p023widget.RecyclerView;
import com.p038google.p039android.material.carousel.C0249mjFkc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p131o.AbstractC2280K3;
import p131o.AbstractC2506NPj;
import p131o.AbstractC2868T1;
import p131o.AbstractC4191n4;
import p131o.AbstractC4898xfXeiC;
import p131o.AbstractC4946yP;
import p131o.InterfaceC4810wLtdyQ;

/* loaded from: classes.dex */
public class CarouselLayoutManager extends RecyclerView.AbstractC0159qGY implements InterfaceC4810wLtdyQ {

    /* renamed from: Gd */
    public AbstractC4946yP f2476Gd;

    /* renamed from: HGpJ */
    public C0244AZxh f2477HGpJ;

    /* renamed from: Pq */
    public int f2478Pq;

    /* renamed from: diqgf */
    public int f2481diqgf;

    /* renamed from: eyqo */
    public int f2482eyqo;

    /* renamed from: vI */
    public C0249mjFkc f2484vI;

    /* renamed from: Ucbh */
    public boolean f2479Ucbh = false;

    /* renamed from: huTpC */
    public final C0248wA f2483huTpC = new C0248wA();

    /* renamed from: VocHEe */
    public int f2480VocHEe = 0;

    /* renamed from: com.google.android.material.carousel.CarouselLayoutManager$AZxh */
    public static final class C0245AZxh {

        /* renamed from: AZxh */
        public float f2485AZxh;

        /* renamed from: mjFkc */
        public View f2486mjFkc;

        /* renamed from: wA */
        public C0246ZfxDd f2487wA;

        public C0245AZxh(View view, float f, C0246ZfxDd c0246ZfxDd) {
            this.f2486mjFkc = view;
            this.f2485AZxh = f;
            this.f2487wA = c0246ZfxDd;
        }
    }

    /* renamed from: com.google.android.material.carousel.CarouselLayoutManager$ZfxDd */
    public static class C0246ZfxDd {

        /* renamed from: AZxh */
        public final C0249mjFkc.wA f2488AZxh;

        /* renamed from: mjFkc */
        public final C0249mjFkc.wA f2489mjFkc;

        public C0246ZfxDd(C0249mjFkc.wA wAVar, C0249mjFkc.wA wAVar2) {
            AbstractC2280K3.m9123mjFkc(wAVar.f2506mjFkc <= wAVar2.f2506mjFkc);
            this.f2489mjFkc = wAVar;
            this.f2488AZxh = wAVar2;
        }
    }

    /* renamed from: com.google.android.material.carousel.CarouselLayoutManager$mjFkc */
    public class C0247mjFkc extends C0181xJ {
        public C0247mjFkc(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.p023widget.C0181xJ
        /* renamed from: diqgf */
        public int mo2083diqgf(View view, int i) {
            CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
            return (int) (CarouselLayoutManager.this.f2478Pq - carouselLayoutManager.m2671oJ(carouselLayoutManager.f2477HGpJ.m2638JHa(), CarouselLayoutManager.this.m1799tQ(view)));
        }

        @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0162vI
        /* renamed from: mjFkc */
        public PointF mo1842mjFkc(int i) {
            if (CarouselLayoutManager.this.f2477HGpJ == null) {
                return null;
            }
            CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
            return new PointF(carouselLayoutManager.m2671oJ(carouselLayoutManager.f2477HGpJ.m2638JHa(), i) - CarouselLayoutManager.this.f2478Pq, 0.0f);
        }
    }

    /* renamed from: com.google.android.material.carousel.CarouselLayoutManager$wA */
    public static class C0248wA extends RecyclerView.AbstractC0161rkYL {

        /* renamed from: AZxh */
        public List f2491AZxh;

        /* renamed from: mjFkc */
        public final Paint f2492mjFkc;

        public C0248wA() {
            Paint paint = new Paint();
            this.f2492mjFkc = paint;
            this.f2491AZxh = Collections.unmodifiableList(new ArrayList());
            paint.setStrokeWidth(5.0f);
            paint.setColor(-65281);
        }

        /* renamed from: Dt */
        public void m2679Dt(List list) {
            this.f2491AZxh = Collections.unmodifiableList(list);
        }

        @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0161rkYL
        /* renamed from: qdMbNW */
        public void mo1828qdMbNW(Canvas canvas, RecyclerView recyclerView, RecyclerView.C0148VocHEe c0148VocHEe) {
            super.mo1828qdMbNW(canvas, recyclerView, c0148VocHEe);
            this.f2492mjFkc.setStrokeWidth(recyclerView.getResources().getDimension(AbstractC4191n4.f15314JHa));
            for (C0249mjFkc.wA wAVar : this.f2491AZxh) {
                this.f2492mjFkc.setColor(AbstractC4898xfXeiC.m13966wA(-65281, -16776961, wAVar.f2507wA));
                canvas.drawLine(wAVar.f2504AZxh, ((CarouselLayoutManager) recyclerView.getLayoutManager()).m2655Hk(), wAVar.f2504AZxh, ((CarouselLayoutManager) recyclerView.getLayoutManager()).m2660Rsp(), this.f2492mjFkc);
            }
        }
    }

    public CarouselLayoutManager() {
        m2662TFbkuO(new C0250wA());
    }

    /* renamed from: MC */
    public static int m2644MC(int i, int i2, int i3, int i4) {
        int i5 = i2 + i;
        return i5 < i3 ? i3 - i2 : i5 > i4 ? i4 - i2 : i;
    }

    /* renamed from: bWIyu */
    public static C0246ZfxDd m2646bWIyu(List list, float f, boolean z) {
        float f2 = Float.MAX_VALUE;
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        float f3 = -3.4028235E38f;
        float f4 = Float.MAX_VALUE;
        float f5 = Float.MAX_VALUE;
        for (int i5 = 0; i5 < list.size(); i5++) {
            C0249mjFkc.wA wAVar = (C0249mjFkc.wA) list.get(i5);
            float f6 = z ? wAVar.f2504AZxh : wAVar.f2506mjFkc;
            float fAbs = Math.abs(f6 - f);
            if (f6 <= f && fAbs <= f2) {
                i = i5;
                f2 = fAbs;
            }
            if (f6 > f && fAbs <= f4) {
                i3 = i5;
                f4 = fAbs;
            }
            if (f6 <= f5) {
                i2 = i5;
                f5 = f6;
            }
            if (f6 > f3) {
                i4 = i5;
                f3 = f6;
            }
        }
        if (i == -1) {
            i = i2;
        }
        if (i3 == -1) {
            i3 = i4;
        }
        return new C0246ZfxDd((C0249mjFkc.wA) list.get(i), (C0249mjFkc.wA) list.get(i3));
    }

    /* renamed from: tPvjn */
    private int m2649tPvjn(int i, RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe) {
        if (m1817zvd() == 0 || i == 0) {
            return 0;
        }
        int iM2644MC = m2644MC(i, this.f2478Pq, this.f2481diqgf, this.f2482eyqo);
        this.f2478Pq += iM2644MC;
        m2659OzIs();
        float fM2685ZfxDd = this.f2484vI.m2685ZfxDd() / 2.0f;
        int iM2676xbjHT = m2676xbjHT(m1799tQ(m1743KLMXS(0)));
        Rect rect = new Rect();
        for (int i2 = 0; i2 < m1817zvd(); i2++) {
            m2672peCqC(m1743KLMXS(i2), iM2676xbjHT, fM2685ZfxDd, rect);
            iM2676xbjHT = m2666Vptz(iM2676xbjHT, (int) this.f2484vI.m2685ZfxDd());
        }
        m2674vZ(c0146Ucbh, c0148VocHEe);
        return iM2644MC;
    }

    /* renamed from: ArO */
    public final void m2650ArO() {
        if (!this.f2479Ucbh || m1817zvd() < 1) {
            return;
        }
        int i = 0;
        while (i < m1817zvd() - 1) {
            int iM1799tQ = m1799tQ(m1743KLMXS(i));
            int i2 = i + 1;
            int iM1799tQ2 = m1799tQ(m1743KLMXS(i2));
            if (iM1799tQ > iM1799tQ2) {
                m2665UOnCkw();
                throw new IllegalStateException("Detected invalid child order. Child at index [" + i + "] had adapter position [" + iM1799tQ + "] and child at index [" + i2 + "] had adapter position [" + iM1799tQ2 + "].");
            }
            i = i2;
        }
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: BxruE */
    public int mo1230BxruE(int i, RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe) {
        if (mo1335VA()) {
            return m2649tPvjn(i, c0146Ucbh, c0148VocHEe);
        }
        return 0;
    }

    /* renamed from: CcoH */
    public final void m2651CcoH(RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe, int i) {
        int iM2676xbjHT = m2676xbjHT(i);
        while (i < c0148VocHEe.m1624AZxh()) {
            C0245AZxh c0245AZxhM2661Sx = m2661Sx(c0146Ucbh, iM2676xbjHT, i);
            if (m2664UDcil(c0245AZxhM2661Sx.f2485AZxh, c0245AZxhM2661Sx.f2487wA)) {
                return;
            }
            iM2676xbjHT = m2666Vptz(iM2676xbjHT, (int) this.f2484vI.m2685ZfxDd());
            if (!m2669jY(c0245AZxhM2661Sx.f2485AZxh, c0245AZxhM2661Sx.f2487wA)) {
                m2656KSf(c0245AZxhM2661Sx.f2486mjFkc, -1, c0245AZxhM2661Sx.f2485AZxh);
            }
            i++;
        }
    }

    /* renamed from: CqAnRZ */
    public final float m2652CqAnRZ(float f, C0246ZfxDd c0246ZfxDd) {
        C0249mjFkc.wA wAVar = c0246ZfxDd.f2489mjFkc;
        float f2 = wAVar.f2505ZfxDd;
        C0249mjFkc.wA wAVar2 = c0246ZfxDd.f2488AZxh;
        return AbstractC2506NPj.m9655AZxh(f2, wAVar2.f2505ZfxDd, wAVar.f2504AZxh, wAVar2.f2504AZxh, f);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: Dp */
    public void mo1308Dp(AccessibilityEvent accessibilityEvent) {
        super.mo1308Dp(accessibilityEvent);
        if (m1817zvd() > 0) {
            accessibilityEvent.setFromIndex(m1799tQ(m1743KLMXS(0)));
            accessibilityEvent.setToIndex(m1799tQ(m1743KLMXS(m1817zvd() - 1)));
        }
    }

    /* renamed from: EoC */
    public final float m2653EoC(View view, float f, C0246ZfxDd c0246ZfxDd) {
        C0249mjFkc.wA wAVar = c0246ZfxDd.f2489mjFkc;
        float f2 = wAVar.f2504AZxh;
        C0249mjFkc.wA wAVar2 = c0246ZfxDd.f2488AZxh;
        float fM9655AZxh = AbstractC2506NPj.m9655AZxh(f2, wAVar2.f2504AZxh, wAVar.f2506mjFkc, wAVar2.f2506mjFkc, f);
        if (c0246ZfxDd.f2488AZxh != this.f2484vI.m2688wA() && c0246ZfxDd.f2489mjFkc != this.f2484vI.m2686lgHUyS()) {
            return fM9655AZxh;
        }
        RecyclerView.C0153fehf c0153fehf = (RecyclerView.C0153fehf) view.getLayoutParams();
        float fM2685ZfxDd = (((ViewGroup.MarginLayoutParams) c0153fehf).rightMargin + ((ViewGroup.MarginLayoutParams) c0153fehf).leftMargin) / this.f2484vI.m2685ZfxDd();
        C0249mjFkc.wA wAVar3 = c0246ZfxDd.f2488AZxh;
        return fM9655AZxh + ((f - wAVar3.f2506mjFkc) * ((1.0f - wAVar3.f2507wA) + fM2685ZfxDd));
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: Fztqa */
    public boolean mo1727Fztqa(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
        C0244AZxh c0244AZxh = this.f2477HGpJ;
        if (c0244AZxh == null) {
            return false;
        }
        int iM2671oJ = m2671oJ(c0244AZxh.m2638JHa(), m1799tQ(view)) - this.f2478Pq;
        if (z2 || iM2671oJ == 0) {
            return false;
        }
        recyclerView.scrollBy(iM2671oJ, 0);
        return true;
    }

    /* renamed from: HX */
    public final void m2654HX(RecyclerView.C0146Ucbh c0146Ucbh, int i) {
        int iM2676xbjHT = m2676xbjHT(i);
        while (i >= 0) {
            C0245AZxh c0245AZxhM2661Sx = m2661Sx(c0146Ucbh, iM2676xbjHT, i);
            if (m2669jY(c0245AZxhM2661Sx.f2485AZxh, c0245AZxhM2661Sx.f2487wA)) {
                return;
            }
            iM2676xbjHT = m2673qrxT(iM2676xbjHT, (int) this.f2484vI.m2685ZfxDd());
            if (!m2664UDcil(c0245AZxhM2661Sx.f2485AZxh, c0245AZxhM2661Sx.f2487wA)) {
                m2656KSf(c0245AZxhM2661Sx.f2486mjFkc, 0, c0245AZxhM2661Sx.f2485AZxh);
            }
            i--;
        }
    }

    /* renamed from: Hk */
    public final int m2655Hk() {
        return m1777dm();
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: IEE */
    public int mo1315IEE(RecyclerView.C0148VocHEe c0148VocHEe) {
        return (int) this.f2477HGpJ.m2638JHa().m2685ZfxDd();
    }

    /* renamed from: KSf */
    public final void m2656KSf(View view, int i, float f) {
        float fM2685ZfxDd = this.f2484vI.m2685ZfxDd() / 2.0f;
        m1736JHa(view, i);
        m1767XFUzSY(view, (int) (f - fM2685ZfxDd), m2655Hk(), (int) (f + fM2685ZfxDd), m2660Rsp());
    }

    /* renamed from: Mpf */
    public final int m2657Mpf() {
        if (m2667XyP()) {
            return m1755SOS();
        }
        return 0;
    }

    /* renamed from: Otxclu */
    public final void m2658Otxclu(View view, float f, C0246ZfxDd c0246ZfxDd) {
    }

    /* renamed from: OzIs */
    public final void m2659OzIs() {
        int i = this.f2482eyqo;
        int i2 = this.f2481diqgf;
        if (i <= i2) {
            this.f2484vI = m2667XyP() ? this.f2477HGpJ.m2639lgHUyS() : this.f2477HGpJ.m2641xJ();
        } else {
            this.f2484vI = this.f2477HGpJ.m2640qdMbNW(this.f2478Pq, i2, i);
        }
        this.f2483huTpC.m2679Dt(this.f2484vI.m2684KLFTb());
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: Pq */
    public int mo1240Pq(RecyclerView.C0148VocHEe c0148VocHEe) {
        return this.f2478Pq;
    }

    /* renamed from: Rsp */
    public final int m2660Rsp() {
        return m1737JYgkl() - m1735JBhc();
    }

    /* renamed from: Sx */
    public final C0245AZxh m2661Sx(RecyclerView.C0146Ucbh c0146Ucbh, float f, int i) {
        float fM2685ZfxDd = this.f2484vI.m2685ZfxDd() / 2.0f;
        View viewM1616rkYL = c0146Ucbh.m1616rkYL(i);
        mo1770XtE(viewM1616rkYL, 0, 0);
        float fM2666Vptz = m2666Vptz((int) f, (int) fM2685ZfxDd);
        C0246ZfxDd c0246ZfxDdM2646bWIyu = m2646bWIyu(this.f2484vI.m2684KLFTb(), fM2666Vptz, false);
        float fM2653EoC = m2653EoC(viewM1616rkYL, fM2666Vptz, c0246ZfxDdM2646bWIyu);
        m2658Otxclu(viewM1616rkYL, fM2666Vptz, c0246ZfxDdM2646bWIyu);
        return new C0245AZxh(viewM1616rkYL, fM2653EoC, c0246ZfxDdM2646bWIyu);
    }

    /* renamed from: TFbkuO */
    public void m2662TFbkuO(AbstractC4946yP abstractC4946yP) {
        this.f2476Gd = abstractC4946yP;
        this.f2477HGpJ = null;
        m1788mzUGzO();
    }

    /* renamed from: TvfBiy */
    public final float m2663TvfBiy(View view) {
        super.mo1791oCFDzJ(view, new Rect());
        return r0.centerX();
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: Tw */
    public void mo1331Tw(int i) {
        C0244AZxh c0244AZxh = this.f2477HGpJ;
        if (c0244AZxh == null) {
            return;
        }
        this.f2478Pq = m2671oJ(c0244AZxh.m2638JHa(), i);
        this.f2480VocHEe = AbstractC2868T1.m10211AZxh(i, 0, Math.max(0, m1790nxI() - 1));
        m2659OzIs();
        m1788mzUGzO();
    }

    /* renamed from: UDcil */
    public final boolean m2664UDcil(float f, C0246ZfxDd c0246ZfxDd) {
        int iM2673qrxT = m2673qrxT((int) f, (int) (m2652CqAnRZ(f, c0246ZfxDd) / 2.0f));
        if (m2667XyP()) {
            if (iM2673qrxT >= 0) {
                return false;
            }
        } else if (iM2673qrxT <= mo2670mjFkc()) {
            return false;
        }
        return true;
    }

    /* renamed from: UOnCkw */
    public final void m2665UOnCkw() {
        if (this.f2479Ucbh && Log.isLoggable("CarouselLayoutManager", 3)) {
            Log.d("CarouselLayoutManager", "internal representation of views on the screen");
            for (int i = 0; i < m1817zvd(); i++) {
                View viewM1743KLMXS = m1743KLMXS(i);
                Log.d("CarouselLayoutManager", "item position " + m1799tQ(viewM1743KLMXS) + ", center:" + m2663TvfBiy(viewM1743KLMXS) + ", child index:" + i);
            }
            Log.d("CarouselLayoutManager", "==============");
        }
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: VA */
    public boolean mo1335VA() {
        return true;
    }

    /* renamed from: Vptz */
    public final int m2666Vptz(int i, int i2) {
        return m2667XyP() ? i - i2 : i + i2;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: XtE */
    public void mo1770XtE(View view, int i, int i2) {
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: Xxz */
    public void mo1245Xxz(RecyclerView.C0148VocHEe c0148VocHEe) {
        super.mo1245Xxz(c0148VocHEe);
        if (m1817zvd() == 0) {
            this.f2480VocHEe = 0;
        } else {
            this.f2480VocHEe = m1799tQ(m1743KLMXS(0));
        }
        m2650ArO();
    }

    /* renamed from: XyP */
    public final boolean m2667XyP() {
        return m1764WGXroI() == 1;
    }

    /* renamed from: aDq */
    public final int m2668aDq(C0244AZxh c0244AZxh) {
        boolean zM2667XyP = m2667XyP();
        C0249mjFkc c0249mjFkcM2639lgHUyS = zM2667XyP ? c0244AZxh.m2639lgHUyS() : c0244AZxh.m2641xJ();
        return (int) (((m1773alEkx() * (zM2667XyP ? 1 : -1)) + m2657Mpf()) - m2673qrxT((int) (zM2667XyP ? c0249mjFkcM2639lgHUyS.m2683JHa() : c0249mjFkcM2639lgHUyS.m2687mjFkc()).f2506mjFkc, (int) (c0249mjFkcM2639lgHUyS.m2685ZfxDd() / 2.0f)));
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: dGDT */
    public void mo1248dGDT(RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe) {
        if (c0148VocHEe.m1624AZxh() <= 0) {
            m1797sqndV(c0146Ucbh);
            this.f2480VocHEe = 0;
            return;
        }
        boolean zM2667XyP = m2667XyP();
        boolean z = this.f2477HGpJ == null;
        if (z) {
            View viewM1616rkYL = c0146Ucbh.m1616rkYL(0);
            mo1770XtE(viewM1616rkYL, 0, 0);
            C0249mjFkc c0249mjFkcMo2699AZxh = this.f2476Gd.mo2699AZxh(this, viewM1616rkYL);
            if (zM2667XyP) {
                c0249mjFkcMo2699AZxh = C0249mjFkc.m2680Dt(c0249mjFkcMo2699AZxh);
            }
            this.f2477HGpJ = C0244AZxh.m2629KLFTb(this, c0249mjFkcMo2699AZxh);
        }
        int iM2668aDq = m2668aDq(this.f2477HGpJ);
        int iM2678zPp = m2678zPp(c0148VocHEe, this.f2477HGpJ);
        int i = zM2667XyP ? iM2678zPp : iM2668aDq;
        this.f2481diqgf = i;
        if (zM2667XyP) {
            iM2678zPp = iM2668aDq;
        }
        this.f2482eyqo = iM2678zPp;
        if (z) {
            this.f2478Pq = iM2668aDq;
        } else {
            int i2 = this.f2478Pq;
            this.f2478Pq = i2 + m2644MC(0, i2, i, iM2678zPp);
        }
        this.f2480VocHEe = AbstractC2868T1.m10211AZxh(this.f2480VocHEe, 0, c0148VocHEe.m1624AZxh());
        m2659OzIs();
        m1729Gd(c0146Ucbh);
        m2674vZ(c0146Ucbh, c0148VocHEe);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: diqgf */
    public int mo1249diqgf(RecyclerView.C0148VocHEe c0148VocHEe) {
        return this.f2482eyqo - this.f2481diqgf;
    }

    /* renamed from: jY */
    public final boolean m2669jY(float f, C0246ZfxDd c0246ZfxDd) {
        int iM2666Vptz = m2666Vptz((int) f, (int) (m2652CqAnRZ(f, c0246ZfxDd) / 2.0f));
        if (m2667XyP()) {
            if (iM2666Vptz <= mo2670mjFkc()) {
                return false;
            }
        } else if (iM2666Vptz >= 0) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: mByQ */
    public RecyclerView.C0153fehf mo1263mByQ() {
        return new RecyclerView.C0153fehf(-2, -2);
    }

    @Override // p131o.InterfaceC4810wLtdyQ
    /* renamed from: mjFkc */
    public int mo2670mjFkc() {
        return m1755SOS();
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: oCFDzJ */
    public void mo1791oCFDzJ(View view, Rect rect) {
        super.mo1791oCFDzJ(view, rect);
        float fCenterX = rect.centerX();
        float fWidth = (rect.width() - m2652CqAnRZ(fCenterX, m2646bWIyu(this.f2484vI.m2684KLFTb(), fCenterX, true))) / 2.0f;
        rect.set((int) (rect.left + fWidth), rect.top, (int) (rect.right - fWidth), rect.bottom);
    }

    /* renamed from: oJ */
    public final int m2671oJ(C0249mjFkc c0249mjFkc, int i) {
        return (int) (m2667XyP() ? ((mo2670mjFkc() - c0249mjFkc.m2683JHa().f2506mjFkc) - (i * c0249mjFkc.m2685ZfxDd())) - (c0249mjFkc.m2685ZfxDd() / 2.0f) : ((i * c0249mjFkc.m2685ZfxDd()) - c0249mjFkc.m2687mjFkc().f2506mjFkc) + (c0249mjFkc.m2685ZfxDd() / 2.0f));
    }

    /* renamed from: peCqC */
    public final void m2672peCqC(View view, float f, float f2, Rect rect) {
        float fM2666Vptz = m2666Vptz((int) f, (int) f2);
        C0246ZfxDd c0246ZfxDdM2646bWIyu = m2646bWIyu(this.f2484vI.m2684KLFTb(), fM2666Vptz, false);
        float fM2653EoC = m2653EoC(view, fM2666Vptz, c0246ZfxDdM2646bWIyu);
        m2658Otxclu(view, fM2666Vptz, c0246ZfxDdM2646bWIyu);
        super.mo1791oCFDzJ(view, rect);
        view.offsetLeftAndRight((int) (fM2653EoC - (rect.left + f2)));
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: qGgY */
    public void mo1357qGgY(RecyclerView recyclerView, RecyclerView.C0148VocHEe c0148VocHEe, int i) {
        C0247mjFkc c0247mjFkc = new C0247mjFkc(recyclerView.getContext());
        c0247mjFkc.m1843qGY(i);
        m1807vUsV(c0247mjFkc);
    }

    /* renamed from: qrxT */
    public final int m2673qrxT(int i, int i2) {
        return m2667XyP() ? i + i2 : i - i2;
    }

    /* renamed from: vZ */
    public final void m2674vZ(RecyclerView.C0146Ucbh c0146Ucbh, RecyclerView.C0148VocHEe c0148VocHEe) {
        m2675wGscSa(c0146Ucbh);
        if (m1817zvd() == 0) {
            m2654HX(c0146Ucbh, this.f2480VocHEe - 1);
            m2651CcoH(c0146Ucbh, c0148VocHEe, this.f2480VocHEe);
        } else {
            int iM1799tQ = m1799tQ(m1743KLMXS(0));
            int iM1799tQ2 = m1799tQ(m1743KLMXS(m1817zvd() - 1));
            m2654HX(c0146Ucbh, iM1799tQ - 1);
            m2651CcoH(c0146Ucbh, c0148VocHEe, iM1799tQ2 + 1);
        }
        m2650ArO();
    }

    /* renamed from: wGscSa */
    public final void m2675wGscSa(RecyclerView.C0146Ucbh c0146Ucbh) {
        while (m1817zvd() > 0) {
            View viewM1743KLMXS = m1743KLMXS(0);
            float fM2663TvfBiy = m2663TvfBiy(viewM1743KLMXS);
            if (!m2669jY(fM2663TvfBiy, m2646bWIyu(this.f2484vI.m2684KLFTb(), fM2663TvfBiy, true))) {
                break;
            } else {
                m1752RWyiuY(viewM1743KLMXS, c0146Ucbh);
            }
        }
        while (m1817zvd() - 1 >= 0) {
            View viewM1743KLMXS2 = m1743KLMXS(m1817zvd() - 1);
            float fM2663TvfBiy2 = m2663TvfBiy(viewM1743KLMXS2);
            if (!m2664UDcil(fM2663TvfBiy2, m2646bWIyu(this.f2484vI.m2684KLFTb(), fM2663TvfBiy2, true))) {
                return;
            } else {
                m1752RWyiuY(viewM1743KLMXS2, c0146Ucbh);
            }
        }
    }

    /* renamed from: xbjHT */
    public final int m2676xbjHT(int i) {
        return m2666Vptz(m2657Mpf() - this.f2478Pq, (int) (this.f2484vI.m2685ZfxDd() * i));
    }

    /* renamed from: xfXeiC */
    public final int m2677xfXeiC() {
        if (m2667XyP()) {
            return 0;
        }
        return m1755SOS();
    }

    /* renamed from: zPp */
    public final int m2678zPp(RecyclerView.C0148VocHEe c0148VocHEe, C0244AZxh c0244AZxh) {
        boolean zM2667XyP = m2667XyP();
        C0249mjFkc c0249mjFkcM2641xJ = zM2667XyP ? c0244AZxh.m2641xJ() : c0244AZxh.m2639lgHUyS();
        C0249mjFkc.wA wAVarM2687mjFkc = zM2667XyP ? c0249mjFkcM2641xJ.m2687mjFkc() : c0249mjFkcM2641xJ.m2683JHa();
        float fM1624AZxh = (((c0148VocHEe.m1624AZxh() - 1) * c0249mjFkcM2641xJ.m2685ZfxDd()) + m1758Vdz()) * (zM2667XyP ? -1.0f : 1.0f);
        float fM2657Mpf = wAVarM2687mjFkc.f2506mjFkc - m2657Mpf();
        float fM2677xfXeiC = m2677xfXeiC() - wAVarM2687mjFkc.f2506mjFkc;
        if (Math.abs(fM2657Mpf) > Math.abs(fM1624AZxh)) {
            return 0;
        }
        return (int) ((fM1624AZxh - fM2657Mpf) + fM2677xfXeiC);
    }
}
