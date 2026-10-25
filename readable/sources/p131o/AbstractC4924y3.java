package p131o;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import p094kotlin.p105jvm.internal.Intrinsics;

/* renamed from: o.y3 */
/* loaded from: classes.dex */
public abstract class AbstractC4924y3 {

    /* renamed from: mjFkc */
    public static final int f17473mjFkc = AbstractC4857x4.f17313AZxh;

    /* renamed from: AZxh */
    public static final int f17472AZxh = AbstractC4857x4.f17314mjFkc;

    /* renamed from: AZxh */
    public static final void m13989AZxh(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        Iterator it = AbstractC3371aa.m11325mjFkc(viewGroup).iterator();
        while (it.hasNext()) {
            m13992wA((View) it.next()).m14086mjFkc();
        }
    }

    /* renamed from: ZfxDd */
    public static final void m13990ZfxDd(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setTag(f17472AZxh, Boolean.valueOf(z));
    }

    /* renamed from: mjFkc */
    public static final void m13991mjFkc(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Iterator it = AbstractC3699fa.m11958mjFkc(view).iterator();
        while (it.hasNext()) {
            m13992wA((View) it.next()).m14086mjFkc();
        }
    }

    /* renamed from: wA */
    public static final C4988z3 m13992wA(View view) {
        int i = f17473mjFkc;
        C4988z3 c4988z3 = (C4988z3) view.getTag(i);
        if (c4988z3 != null) {
            return c4988z3;
        }
        C4988z3 c4988z32 = new C4988z3();
        view.setTag(i, c4988z32);
        return c4988z32;
    }
}
