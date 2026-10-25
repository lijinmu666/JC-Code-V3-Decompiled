package p131o;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.p023widget.C0181xJ;
import androidx.recyclerview.p023widget.LinearLayoutManager;
import androidx.recyclerview.p023widget.RecyclerView;

/* renamed from: o.X6 */
/* loaded from: classes.dex */
public abstract class AbstractC3138X6 extends LinearLayoutManager {

    /* renamed from: o.X6$mjFkc */
    public class mjFkc extends C0181xJ {
        public mjFkc(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.p023widget.C0181xJ
        /* renamed from: Ucbh */
        public float mo1216Ucbh(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    public AbstractC3138X6(Context context, int i, boolean z) {
        super(context, i, z);
    }

    @Override // androidx.recyclerview.p023widget.LinearLayoutManager, androidx.recyclerview.p023widget.RecyclerView.AbstractC0159qGY
    /* renamed from: qGgY */
    public void mo1357qGgY(RecyclerView recyclerView, RecyclerView.C0148VocHEe c0148VocHEe, int i) {
        mjFkc mjfkc = new mjFkc(recyclerView.getContext());
        mjfkc.m1843qGY(i);
        m1807vUsV(mjfkc);
    }
}
