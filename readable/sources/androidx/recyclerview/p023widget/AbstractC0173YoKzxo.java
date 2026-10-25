package androidx.recyclerview.p023widget;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.p023widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.YoKzxo */
/* loaded from: classes.dex */
public abstract class AbstractC0173YoKzxo extends RecyclerView.AbstractC0141IEE {

    /* renamed from: AZxh */
    public Scroller f1812AZxh;

    /* renamed from: mjFkc */
    public RecyclerView f1813mjFkc;

    /* renamed from: wA */
    public final RecyclerView.AbstractC0151diqgf f1814wA = new mjFkc();

    /* renamed from: androidx.recyclerview.widget.YoKzxo$mjFkc */
    public class mjFkc extends RecyclerView.AbstractC0151diqgf {

        /* renamed from: mjFkc */
        public boolean f1816mjFkc = false;

        public mjFkc() {
        }

        @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0151diqgf
        /* renamed from: AZxh */
        public void mo1635AZxh(RecyclerView recyclerView, int i, int i2) {
            if (i == 0 && i2 == 0) {
                return;
            }
            this.f1816mjFkc = true;
        }

        @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0151diqgf
        /* renamed from: mjFkc */
        public void mo1636mjFkc(RecyclerView recyclerView, int i) {
            super.mo1636mjFkc(recyclerView, i);
            if (i == 0 && this.f1816mjFkc) {
                this.f1816mjFkc = false;
                AbstractC0173YoKzxo.this.m1969Dt();
            }
        }
    }

    /* renamed from: AZxh */
    public void m1968AZxh(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f1813mjFkc;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            m1970KLFTb();
        }
        this.f1813mjFkc = recyclerView;
        if (recyclerView != null) {
            m1971lgHUyS();
            this.f1812AZxh = new Scroller(this.f1813mjFkc.getContext(), new DecelerateInterpolator());
            m1969Dt();
        }
    }

    /* renamed from: Dt */
    public void m1969Dt() {
        RecyclerView.AbstractC0159qGY layoutManager;
        View viewMo1205JHa;
        RecyclerView recyclerView = this.f1813mjFkc;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewMo1205JHa = mo1205JHa(layoutManager)) == null) {
            return;
        }
        int[] iArrMo1213wA = mo1213wA(layoutManager, viewMo1205JHa);
        int i = iArrMo1213wA[0];
        if (i == 0 && iArrMo1213wA[1] == 0) {
            return;
        }
        this.f1813mjFkc.m1423CTcA(i, iArrMo1213wA[1]);
    }

    /* renamed from: JHa */
    public abstract View mo1205JHa(RecyclerView.AbstractC0159qGY abstractC0159qGY);

    /* renamed from: KLFTb */
    public final void m1970KLFTb() {
        this.f1813mjFkc.m1510mPWV(this.f1814wA);
        this.f1813mjFkc.setOnFlingListener(null);
    }

    /* renamed from: ZfxDd */
    public abstract RecyclerView.AbstractC0162vI mo1209ZfxDd(RecyclerView.AbstractC0159qGY abstractC0159qGY);

    /* renamed from: lgHUyS */
    public final void m1971lgHUyS() {
        if (this.f1813mjFkc.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.f1813mjFkc.m1465VA(this.f1814wA);
        this.f1813mjFkc.setOnFlingListener(this);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0141IEE
    /* renamed from: mjFkc */
    public boolean mo1547mjFkc(int i, int i2) {
        RecyclerView.AbstractC0159qGY layoutManager = this.f1813mjFkc.getLayoutManager();
        if (layoutManager == null || this.f1813mjFkc.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f1813mjFkc.getMinFlingVelocity();
        return (Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) && m1972qdMbNW(layoutManager, i, i2);
    }

    /* renamed from: qdMbNW */
    public final boolean m1972qdMbNW(RecyclerView.AbstractC0159qGY abstractC0159qGY, int i, int i2) {
        RecyclerView.AbstractC0162vI abstractC0162vIMo1209ZfxDd;
        int iMo1214xJ;
        if (!(abstractC0159qGY instanceof RecyclerView.AbstractC0162vI.AZxh) || (abstractC0162vIMo1209ZfxDd = mo1209ZfxDd(abstractC0159qGY)) == null || (iMo1214xJ = mo1214xJ(abstractC0159qGY, i, i2)) == -1) {
            return false;
        }
        abstractC0162vIMo1209ZfxDd.m1843qGY(iMo1214xJ);
        abstractC0159qGY.m1807vUsV(abstractC0162vIMo1209ZfxDd);
        return true;
    }

    /* renamed from: wA */
    public abstract int[] mo1213wA(RecyclerView.AbstractC0159qGY abstractC0159qGY, View view);

    /* renamed from: xJ */
    public abstract int mo1214xJ(RecyclerView.AbstractC0159qGY abstractC0159qGY, int i, int i2);
}
