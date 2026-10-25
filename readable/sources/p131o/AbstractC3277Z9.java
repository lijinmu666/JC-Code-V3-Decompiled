package p131o;

import android.view.ViewGroup;

/* renamed from: o.Z9 */
/* loaded from: classes.dex */
public abstract class AbstractC3277Z9 {

    /* renamed from: o.Z9$mjFkc */
    public static class mjFkc {
        /* renamed from: AZxh */
        public static boolean m11189AZxh(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }

        /* renamed from: mjFkc */
        public static int m11190mjFkc(ViewGroup viewGroup) {
            return viewGroup.getNestedScrollAxes();
        }

        /* renamed from: wA */
        public static void m11191wA(ViewGroup viewGroup, boolean z) {
            viewGroup.setTransitionGroup(z);
        }
    }

    /* renamed from: mjFkc */
    public static boolean m11188mjFkc(ViewGroup viewGroup) {
        return mjFkc.m11189AZxh(viewGroup);
    }
}
