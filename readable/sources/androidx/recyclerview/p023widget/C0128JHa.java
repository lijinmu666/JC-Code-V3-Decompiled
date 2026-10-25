package androidx.recyclerview.p023widget;

import android.view.View;
import androidx.recyclerview.p023widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.JHa */
/* loaded from: classes.dex */
public class C0128JHa {

    /* renamed from: AZxh */
    public int f1469AZxh;

    /* renamed from: KLFTb */
    public int f1471KLFTb;

    /* renamed from: ZfxDd */
    public int f1472ZfxDd;

    /* renamed from: lgHUyS */
    public boolean f1473lgHUyS;

    /* renamed from: qdMbNW */
    public boolean f1475qdMbNW;

    /* renamed from: wA */
    public int f1476wA;

    /* renamed from: mjFkc */
    public boolean f1474mjFkc = true;

    /* renamed from: JHa */
    public int f1470JHa = 0;

    /* renamed from: xJ */
    public int f1477xJ = 0;

    /* renamed from: AZxh */
    public View m1285AZxh(RecyclerView.C0146Ucbh c0146Ucbh) {
        View viewM1616rkYL = c0146Ucbh.m1616rkYL(this.f1476wA);
        this.f1476wA += this.f1472ZfxDd;
        return viewM1616rkYL;
    }

    /* renamed from: mjFkc */
    public boolean m1286mjFkc(RecyclerView.C0148VocHEe c0148VocHEe) {
        int i = this.f1476wA;
        return i >= 0 && i < c0148VocHEe.m1624AZxh();
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f1469AZxh + ", mCurrentPosition=" + this.f1476wA + ", mItemDirection=" + this.f1472ZfxDd + ", mLayoutDirection=" + this.f1471KLFTb + ", mStartLine=" + this.f1470JHa + ", mEndLine=" + this.f1477xJ + '}';
    }
}
