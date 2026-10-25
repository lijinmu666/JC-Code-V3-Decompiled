package androidx.recyclerview.p023widget;

import android.view.View;
import androidx.recyclerview.p023widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.VA */
/* loaded from: classes.dex */
public abstract class AbstractC0172VA {
    /* renamed from: AZxh */
    public static int m1965AZxh(RecyclerView.C0148VocHEe c0148VocHEe, AbstractC0178qdMbNW abstractC0178qdMbNW, View view, View view2, RecyclerView.AbstractC0159qGY abstractC0159qGY, boolean z, boolean z2) {
        if (abstractC0159qGY.m1817zvd() == 0 || c0148VocHEe.m1624AZxh() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z2 ? Math.max(0, (c0148VocHEe.m1624AZxh() - Math.max(abstractC0159qGY.m1799tQ(view), abstractC0159qGY.m1799tQ(view2))) - 1) : Math.max(0, Math.min(abstractC0159qGY.m1799tQ(view), abstractC0159qGY.m1799tQ(view2)));
        if (z) {
            return Math.round((iMax * (Math.abs(abstractC0178qdMbNW.mo2055ZfxDd(view2) - abstractC0178qdMbNW.mo2061xJ(view)) / (Math.abs(abstractC0159qGY.m1799tQ(view) - abstractC0159qGY.m1799tQ(view2)) + 1))) + (abstractC0178qdMbNW.mo2051MiMN() - abstractC0178qdMbNW.mo2061xJ(view)));
        }
        return iMax;
    }

    /* renamed from: mjFkc */
    public static int m1966mjFkc(RecyclerView.C0148VocHEe c0148VocHEe, AbstractC0178qdMbNW abstractC0178qdMbNW, View view, View view2, RecyclerView.AbstractC0159qGY abstractC0159qGY, boolean z) {
        if (abstractC0159qGY.m1817zvd() == 0 || c0148VocHEe.m1624AZxh() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(abstractC0159qGY.m1799tQ(view) - abstractC0159qGY.m1799tQ(view2)) + 1;
        }
        return Math.min(abstractC0178qdMbNW.mo2054YoKzxo(), abstractC0178qdMbNW.mo2055ZfxDd(view2) - abstractC0178qdMbNW.mo2061xJ(view));
    }

    /* renamed from: wA */
    public static int m1967wA(RecyclerView.C0148VocHEe c0148VocHEe, AbstractC0178qdMbNW abstractC0178qdMbNW, View view, View view2, RecyclerView.AbstractC0159qGY abstractC0159qGY, boolean z) {
        if (abstractC0159qGY.m1817zvd() == 0 || c0148VocHEe.m1624AZxh() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return c0148VocHEe.m1624AZxh();
        }
        return (int) (((abstractC0178qdMbNW.mo2055ZfxDd(view2) - abstractC0178qdMbNW.mo2061xJ(view)) / (Math.abs(abstractC0159qGY.m1799tQ(view) - abstractC0159qGY.m1799tQ(view2)) + 1)) * c0148VocHEe.m1624AZxh());
    }
}
