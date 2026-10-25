package androidx.recyclerview.p023widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.p023widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.qdMbNW */
/* loaded from: classes.dex */
public abstract class AbstractC0178qdMbNW {

    /* renamed from: AZxh */
    public int f1872AZxh;

    /* renamed from: mjFkc */
    public final RecyclerView.AbstractC0159qGY f1873mjFkc;

    /* renamed from: wA */
    public final Rect f1874wA;

    /* renamed from: androidx.recyclerview.widget.qdMbNW$AZxh */
    public class AZxh extends AbstractC0178qdMbNW {
        public AZxh(RecyclerView.AbstractC0159qGY abstractC0159qGY) {
            super(abstractC0159qGY, null);
        }

        @Override // androidx.recyclerview.p023widget.AbstractC0178qdMbNW
        /* renamed from: Dt */
        public int mo2046Dt() {
            return this.f1873mjFkc.m1735JBhc();
        }

        @Override // androidx.recyclerview.p023widget.AbstractC0178qdMbNW
        /* renamed from: ETF */
        public int mo2047ETF() {
            return this.f1873mjFkc.m1741JrJO();
        }

        @Override // androidx.recyclerview.p023widget.AbstractC0178qdMbNW
        /* renamed from: IEE */
        public void mo2048IEE(int i) {
            this.f1873mjFkc.mo1798tISON(i);
        }

        @Override // androidx.recyclerview.p023widget.AbstractC0178qdMbNW
        /* renamed from: JHa */
        public int mo2049JHa(View view) {
            RecyclerView.C0153fehf c0153fehf = (RecyclerView.C0153fehf) view.getLayoutParams();
            return this.f1873mjFkc.m1744KRTLGT(view) + ((ViewGroup.MarginLayoutParams) c0153fehf).leftMargin + ((ViewGroup.MarginLayoutParams) c0153fehf).rightMargin;
        }

        @Override // androidx.recyclerview.p023widget.AbstractC0178qdMbNW
        /* renamed from: KLFTb */
        public int mo2050KLFTb(View view) {
            RecyclerView.C0153fehf c0153fehf = (RecyclerView.C0153fehf) view.getLayoutParams();
            return this.f1873mjFkc.m1765WrLQs(view) + ((ViewGroup.MarginLayoutParams) c0153fehf).topMargin + ((ViewGroup.MarginLayoutParams) c0153fehf).bottomMargin;
        }

        @Override // androidx.recyclerview.p023widget.AbstractC0178qdMbNW
        /* renamed from: MiMN */
        public int mo2051MiMN() {
            return this.f1873mjFkc.m1777dm();
        }

        @Override // androidx.recyclerview.p023widget.AbstractC0178qdMbNW
        /* renamed from: VA */
        public int mo2053VA() {
            return this.f1873mjFkc.m1751Qr();
        }

        @Override // androidx.recyclerview.p023widget.AbstractC0178qdMbNW
        /* renamed from: YoKzxo */
        public int mo2054YoKzxo() {
            return (this.f1873mjFkc.m1737JYgkl() - this.f1873mjFkc.m1777dm()) - this.f1873mjFkc.m1735JBhc();
        }

        @Override // androidx.recyclerview.p023widget.AbstractC0178qdMbNW
        /* renamed from: ZfxDd */
        public int mo2055ZfxDd(View view) {
            return this.f1873mjFkc.m1808vadzgd(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.C0153fehf) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.p023widget.AbstractC0178qdMbNW
        /* renamed from: fehf */
        public int mo2056fehf(View view) {
            this.f1873mjFkc.m1756SmIWf(view, true, this.f1874wA);
            return this.f1874wA.top;
        }

        @Override // androidx.recyclerview.p023widget.AbstractC0178qdMbNW
        /* renamed from: lgHUyS */
        public int mo2057lgHUyS() {
            return this.f1873mjFkc.m1737JYgkl();
        }

        @Override // androidx.recyclerview.p023widget.AbstractC0178qdMbNW
        /* renamed from: qGY */
        public int mo2058qGY(View view) {
            this.f1873mjFkc.m1756SmIWf(view, true, this.f1874wA);
            return this.f1874wA.bottom;
        }

        @Override // androidx.recyclerview.p023widget.AbstractC0178qdMbNW
        /* renamed from: qdMbNW */
        public int mo2059qdMbNW() {
            return this.f1873mjFkc.m1737JYgkl() - this.f1873mjFkc.m1735JBhc();
        }

        @Override // androidx.recyclerview.p023widget.AbstractC0178qdMbNW
        /* renamed from: xJ */
        public int mo2061xJ(View view) {
            return this.f1873mjFkc.m1803uHVRx(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.C0153fehf) view.getLayoutParams())).topMargin;
        }
    }

    /* renamed from: androidx.recyclerview.widget.qdMbNW$mjFkc */
    public class mjFkc extends AbstractC0178qdMbNW {
        public mjFkc(RecyclerView.AbstractC0159qGY abstractC0159qGY) {
            super(abstractC0159qGY, null);
        }

        @Override // androidx.recyclerview.p023widget.AbstractC0178qdMbNW
        /* renamed from: Dt */
        public int mo2046Dt() {
            return this.f1873mjFkc.m1719ANMGZc();
        }

        @Override // androidx.recyclerview.p023widget.AbstractC0178qdMbNW
        /* renamed from: ETF */
        public int mo2047ETF() {
            return this.f1873mjFkc.m1751Qr();
        }

        @Override // androidx.recyclerview.p023widget.AbstractC0178qdMbNW
        /* renamed from: IEE */
        public void mo2048IEE(int i) {
            this.f1873mjFkc.mo1802uH(i);
        }

        @Override // androidx.recyclerview.p023widget.AbstractC0178qdMbNW
        /* renamed from: JHa */
        public int mo2049JHa(View view) {
            RecyclerView.C0153fehf c0153fehf = (RecyclerView.C0153fehf) view.getLayoutParams();
            return this.f1873mjFkc.m1765WrLQs(view) + ((ViewGroup.MarginLayoutParams) c0153fehf).topMargin + ((ViewGroup.MarginLayoutParams) c0153fehf).bottomMargin;
        }

        @Override // androidx.recyclerview.p023widget.AbstractC0178qdMbNW
        /* renamed from: KLFTb */
        public int mo2050KLFTb(View view) {
            RecyclerView.C0153fehf c0153fehf = (RecyclerView.C0153fehf) view.getLayoutParams();
            return this.f1873mjFkc.m1744KRTLGT(view) + ((ViewGroup.MarginLayoutParams) c0153fehf).leftMargin + ((ViewGroup.MarginLayoutParams) c0153fehf).rightMargin;
        }

        @Override // androidx.recyclerview.p023widget.AbstractC0178qdMbNW
        /* renamed from: MiMN */
        public int mo2051MiMN() {
            return this.f1873mjFkc.m1783jm();
        }

        @Override // androidx.recyclerview.p023widget.AbstractC0178qdMbNW
        /* renamed from: VA */
        public int mo2053VA() {
            return this.f1873mjFkc.m1741JrJO();
        }

        @Override // androidx.recyclerview.p023widget.AbstractC0178qdMbNW
        /* renamed from: YoKzxo */
        public int mo2054YoKzxo() {
            return (this.f1873mjFkc.m1755SOS() - this.f1873mjFkc.m1783jm()) - this.f1873mjFkc.m1719ANMGZc();
        }

        @Override // androidx.recyclerview.p023widget.AbstractC0178qdMbNW
        /* renamed from: ZfxDd */
        public int mo2055ZfxDd(View view) {
            return this.f1873mjFkc.m1728GMIER(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.C0153fehf) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.p023widget.AbstractC0178qdMbNW
        /* renamed from: fehf */
        public int mo2056fehf(View view) {
            this.f1873mjFkc.m1756SmIWf(view, true, this.f1874wA);
            return this.f1874wA.left;
        }

        @Override // androidx.recyclerview.p023widget.AbstractC0178qdMbNW
        /* renamed from: lgHUyS */
        public int mo2057lgHUyS() {
            return this.f1873mjFkc.m1755SOS();
        }

        @Override // androidx.recyclerview.p023widget.AbstractC0178qdMbNW
        /* renamed from: qGY */
        public int mo2058qGY(View view) {
            this.f1873mjFkc.m1756SmIWf(view, true, this.f1874wA);
            return this.f1874wA.right;
        }

        @Override // androidx.recyclerview.p023widget.AbstractC0178qdMbNW
        /* renamed from: qdMbNW */
        public int mo2059qdMbNW() {
            return this.f1873mjFkc.m1755SOS() - this.f1873mjFkc.m1719ANMGZc();
        }

        @Override // androidx.recyclerview.p023widget.AbstractC0178qdMbNW
        /* renamed from: xJ */
        public int mo2061xJ(View view) {
            return this.f1873mjFkc.m1774aqHPIZ(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.C0153fehf) view.getLayoutParams())).leftMargin;
        }
    }

    public /* synthetic */ AbstractC0178qdMbNW(RecyclerView.AbstractC0159qGY abstractC0159qGY, mjFkc mjfkc) {
        this(abstractC0159qGY);
    }

    /* renamed from: AZxh */
    public static AbstractC0178qdMbNW m2043AZxh(RecyclerView.AbstractC0159qGY abstractC0159qGY, int i) {
        if (i == 0) {
            return m2044mjFkc(abstractC0159qGY);
        }
        if (i == 1) {
            return m2045wA(abstractC0159qGY);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    /* renamed from: mjFkc */
    public static AbstractC0178qdMbNW m2044mjFkc(RecyclerView.AbstractC0159qGY abstractC0159qGY) {
        return new mjFkc(abstractC0159qGY);
    }

    /* renamed from: wA */
    public static AbstractC0178qdMbNW m2045wA(RecyclerView.AbstractC0159qGY abstractC0159qGY) {
        return new AZxh(abstractC0159qGY);
    }

    /* renamed from: Dt */
    public abstract int mo2046Dt();

    /* renamed from: ETF */
    public abstract int mo2047ETF();

    /* renamed from: IEE */
    public abstract void mo2048IEE(int i);

    /* renamed from: JHa */
    public abstract int mo2049JHa(View view);

    /* renamed from: KLFTb */
    public abstract int mo2050KLFTb(View view);

    /* renamed from: MiMN */
    public abstract int mo2051MiMN();

    /* renamed from: Pq */
    public void m2052Pq() {
        this.f1872AZxh = mo2054YoKzxo();
    }

    /* renamed from: VA */
    public abstract int mo2053VA();

    /* renamed from: YoKzxo */
    public abstract int mo2054YoKzxo();

    /* renamed from: ZfxDd */
    public abstract int mo2055ZfxDd(View view);

    /* renamed from: fehf */
    public abstract int mo2056fehf(View view);

    /* renamed from: lgHUyS */
    public abstract int mo2057lgHUyS();

    /* renamed from: qGY */
    public abstract int mo2058qGY(View view);

    /* renamed from: qdMbNW */
    public abstract int mo2059qdMbNW();

    /* renamed from: rkYL */
    public int m2060rkYL() {
        if (Integer.MIN_VALUE == this.f1872AZxh) {
            return 0;
        }
        return mo2054YoKzxo() - this.f1872AZxh;
    }

    /* renamed from: xJ */
    public abstract int mo2061xJ(View view);

    public AbstractC0178qdMbNW(RecyclerView.AbstractC0159qGY abstractC0159qGY) {
        this.f1872AZxh = Integer.MIN_VALUE;
        this.f1874wA = new Rect();
        this.f1873mjFkc = abstractC0159qGY;
    }
}
