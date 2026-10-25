package androidx.recyclerview.p023widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.p023widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.Dt */
/* loaded from: classes.dex */
public class C0123Dt extends AbstractC0173YoKzxo {

    /* renamed from: KLFTb */
    public AbstractC0178qdMbNW f1447KLFTb;

    /* renamed from: ZfxDd */
    public AbstractC0178qdMbNW f1448ZfxDd;

    /* renamed from: androidx.recyclerview.widget.Dt$mjFkc */
    public class mjFkc extends C0181xJ {
        public mjFkc(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.p023widget.C0181xJ
        /* renamed from: Gd */
        public int mo1215Gd(int i) {
            return Math.min(100, super.mo1215Gd(i));
        }

        @Override // androidx.recyclerview.p023widget.C0181xJ
        /* renamed from: Ucbh */
        public float mo1216Ucbh(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.p023widget.C0181xJ, androidx.recyclerview.p023widget.RecyclerView.AbstractC0162vI
        /* renamed from: rkYL */
        public void mo1217rkYL(View view, RecyclerView.C0148VocHEe c0148VocHEe, RecyclerView.AbstractC0162vI.mjFkc mjfkc) {
            C0123Dt c0123Dt = C0123Dt.this;
            int[] iArrMo1213wA = c0123Dt.mo1213wA(c0123Dt.f1813mjFkc.getLayoutManager(), view);
            int i = iArrMo1213wA[0];
            int i2 = iArrMo1213wA[1];
            int iM2085huTpC = m2085huTpC(Math.max(Math.abs(i), Math.abs(i2)));
            if (iM2085huTpC > 0) {
                mjfkc.m1849ZfxDd(i, i2, iM2085huTpC, this.f1933Dt);
            }
        }
    }

    /* renamed from: ETF */
    public final int m1204ETF(View view, AbstractC0178qdMbNW abstractC0178qdMbNW) {
        return (abstractC0178qdMbNW.mo2061xJ(view) + (abstractC0178qdMbNW.mo2050KLFTb(view) / 2)) - (abstractC0178qdMbNW.mo2051MiMN() + (abstractC0178qdMbNW.mo2054YoKzxo() / 2));
    }

    @Override // androidx.recyclerview.p023widget.AbstractC0173YoKzxo
    /* renamed from: JHa */
    public View mo1205JHa(RecyclerView.AbstractC0159qGY abstractC0159qGY) {
        if (abstractC0159qGY.mo1322MiMN()) {
            return m1207VA(abstractC0159qGY, m1212rkYL(abstractC0159qGY));
        }
        if (abstractC0159qGY.mo1335VA()) {
            return m1207VA(abstractC0159qGY, m1206MiMN(abstractC0159qGY));
        }
        return null;
    }

    /* renamed from: MiMN */
    public final AbstractC0178qdMbNW m1206MiMN(RecyclerView.AbstractC0159qGY abstractC0159qGY) {
        AbstractC0178qdMbNW abstractC0178qdMbNW = this.f1447KLFTb;
        if (abstractC0178qdMbNW == null || abstractC0178qdMbNW.f1873mjFkc != abstractC0159qGY) {
            this.f1447KLFTb = AbstractC0178qdMbNW.m2044mjFkc(abstractC0159qGY);
        }
        return this.f1447KLFTb;
    }

    /* renamed from: VA */
    public final View m1207VA(RecyclerView.AbstractC0159qGY abstractC0159qGY, AbstractC0178qdMbNW abstractC0178qdMbNW) {
        int iM1817zvd = abstractC0159qGY.m1817zvd();
        View view = null;
        if (iM1817zvd == 0) {
            return null;
        }
        int iMo2051MiMN = abstractC0178qdMbNW.mo2051MiMN() + (abstractC0178qdMbNW.mo2054YoKzxo() / 2);
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < iM1817zvd; i2++) {
            View viewM1743KLMXS = abstractC0159qGY.m1743KLMXS(i2);
            int iAbs = Math.abs((abstractC0178qdMbNW.mo2061xJ(viewM1743KLMXS) + (abstractC0178qdMbNW.mo2050KLFTb(viewM1743KLMXS) / 2)) - iMo2051MiMN);
            if (iAbs < i) {
                view = viewM1743KLMXS;
                i = iAbs;
            }
        }
        return view;
    }

    /* renamed from: YoKzxo */
    public final AbstractC0178qdMbNW m1208YoKzxo(RecyclerView.AbstractC0159qGY abstractC0159qGY) {
        if (abstractC0159qGY.mo1322MiMN()) {
            return m1212rkYL(abstractC0159qGY);
        }
        if (abstractC0159qGY.mo1335VA()) {
            return m1206MiMN(abstractC0159qGY);
        }
        return null;
    }

    @Override // androidx.recyclerview.p023widget.AbstractC0173YoKzxo
    /* renamed from: ZfxDd */
    public RecyclerView.AbstractC0162vI mo1209ZfxDd(RecyclerView.AbstractC0159qGY abstractC0159qGY) {
        if (abstractC0159qGY instanceof RecyclerView.AbstractC0162vI.AZxh) {
            return new mjFkc(this.f1813mjFkc.getContext());
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: fehf */
    public final boolean m1210fehf(RecyclerView.AbstractC0159qGY abstractC0159qGY) {
        PointF pointFMo1304AZxh;
        int iM1790nxI = abstractC0159qGY.m1790nxI();
        if (!(abstractC0159qGY instanceof RecyclerView.AbstractC0162vI.AZxh) || (pointFMo1304AZxh = ((RecyclerView.AbstractC0162vI.AZxh) abstractC0159qGY).mo1304AZxh(iM1790nxI - 1)) == null) {
            return false;
        }
        return pointFMo1304AZxh.x < 0.0f || pointFMo1304AZxh.y < 0.0f;
    }

    /* renamed from: qGY */
    public final boolean m1211qGY(RecyclerView.AbstractC0159qGY abstractC0159qGY, int i, int i2) {
        return abstractC0159qGY.mo1335VA() ? i > 0 : i2 > 0;
    }

    /* renamed from: rkYL */
    public final AbstractC0178qdMbNW m1212rkYL(RecyclerView.AbstractC0159qGY abstractC0159qGY) {
        AbstractC0178qdMbNW abstractC0178qdMbNW = this.f1448ZfxDd;
        if (abstractC0178qdMbNW == null || abstractC0178qdMbNW.f1873mjFkc != abstractC0159qGY) {
            this.f1448ZfxDd = AbstractC0178qdMbNW.m2045wA(abstractC0159qGY);
        }
        return this.f1448ZfxDd;
    }

    @Override // androidx.recyclerview.p023widget.AbstractC0173YoKzxo
    /* renamed from: wA */
    public int[] mo1213wA(RecyclerView.AbstractC0159qGY abstractC0159qGY, View view) {
        int[] iArr = new int[2];
        if (abstractC0159qGY.mo1335VA()) {
            iArr[0] = m1204ETF(view, m1206MiMN(abstractC0159qGY));
        } else {
            iArr[0] = 0;
        }
        if (abstractC0159qGY.mo1322MiMN()) {
            iArr[1] = m1204ETF(view, m1212rkYL(abstractC0159qGY));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.p023widget.AbstractC0173YoKzxo
    /* renamed from: xJ */
    public int mo1214xJ(RecyclerView.AbstractC0159qGY abstractC0159qGY, int i, int i2) {
        AbstractC0178qdMbNW abstractC0178qdMbNWM1208YoKzxo;
        int iM1790nxI = abstractC0159qGY.m1790nxI();
        if (iM1790nxI == 0 || (abstractC0178qdMbNWM1208YoKzxo = m1208YoKzxo(abstractC0159qGY)) == null) {
            return -1;
        }
        int iM1817zvd = abstractC0159qGY.m1817zvd();
        View view = null;
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MIN_VALUE;
        View view2 = null;
        for (int i5 = 0; i5 < iM1817zvd; i5++) {
            View viewM1743KLMXS = abstractC0159qGY.m1743KLMXS(i5);
            if (viewM1743KLMXS != null) {
                int iM1204ETF = m1204ETF(viewM1743KLMXS, abstractC0178qdMbNWM1208YoKzxo);
                if (iM1204ETF <= 0 && iM1204ETF > i4) {
                    view2 = viewM1743KLMXS;
                    i4 = iM1204ETF;
                }
                if (iM1204ETF >= 0 && iM1204ETF < i3) {
                    view = viewM1743KLMXS;
                    i3 = iM1204ETF;
                }
            }
        }
        boolean zM1211qGY = m1211qGY(abstractC0159qGY, i, i2);
        if (zM1211qGY && view != null) {
            return abstractC0159qGY.m1799tQ(view);
        }
        if (!zM1211qGY && view2 != null) {
            return abstractC0159qGY.m1799tQ(view2);
        }
        if (zM1211qGY) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int iM1799tQ = abstractC0159qGY.m1799tQ(view) + (m1210fehf(abstractC0159qGY) == zM1211qGY ? -1 : 1);
        if (iM1799tQ < 0 || iM1799tQ >= iM1790nxI) {
            return -1;
        }
        return iM1799tQ;
    }
}
