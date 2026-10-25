package p131o;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* renamed from: o.oa */
/* loaded from: classes.dex */
public abstract class AbstractC4287oa {

    /* renamed from: o.oa$mjFkc */
    public static class mjFkc {
        /* renamed from: AZxh */
        public static boolean m12972AZxh(ViewParent viewParent, View view, float f, float f2) {
            return viewParent.onNestedPreFling(view, f, f2);
        }

        /* renamed from: JHa */
        public static boolean m12973JHa(ViewParent viewParent, View view, View view2, int i) {
            return viewParent.onStartNestedScroll(view, view2, i);
        }

        /* renamed from: KLFTb */
        public static void m12974KLFTb(ViewParent viewParent, View view, View view2, int i) {
            viewParent.onNestedScrollAccepted(view, view2, i);
        }

        /* renamed from: ZfxDd */
        public static void m12975ZfxDd(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            viewParent.onNestedScroll(view, i, i2, i3, i4);
        }

        /* renamed from: mjFkc */
        public static boolean m12976mjFkc(ViewParent viewParent, View view, float f, float f2, boolean z) {
            return viewParent.onNestedFling(view, f, f2, z);
        }

        /* renamed from: wA */
        public static void m12977wA(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            viewParent.onNestedPreScroll(view, i, i2, iArr);
        }

        /* renamed from: xJ */
        public static void m12978xJ(ViewParent viewParent, View view) {
            viewParent.onStopNestedScroll(view);
        }
    }

    /* renamed from: AZxh */
    public static boolean m12965AZxh(ViewParent viewParent, View view, float f, float f2) {
        try {
            return mjFkc.m12972AZxh(viewParent, view, f, f2);
        } catch (AbstractMethodError e) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e);
            return false;
        }
    }

    /* renamed from: JHa */
    public static boolean m12966JHa(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof InterfaceC1863E2) {
            return ((InterfaceC1863E2) viewParent).mo193JHa(view, view2, i, i2);
        }
        if (i2 != 0) {
            return false;
        }
        try {
            return mjFkc.m12973JHa(viewParent, view, view2, i);
        } catch (AbstractMethodError e) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e);
            return false;
        }
    }

    /* renamed from: KLFTb */
    public static void m12967KLFTb(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof InterfaceC1863E2) {
            ((InterfaceC1863E2) viewParent).mo201mjFkc(view, view2, i, i2);
            return;
        }
        if (i2 == 0) {
            try {
                mjFkc.m12974KLFTb(viewParent, view, view2, i);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e);
            }
        }
    }

    /* renamed from: ZfxDd */
    public static void m12968ZfxDd(ViewParent viewParent, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (viewParent instanceof InterfaceC1932F2) {
            ((InterfaceC1932F2) viewParent).mo198ZfxDd(view, i, i2, i3, i4, i5, iArr);
            return;
        }
        iArr[0] = iArr[0] + i3;
        iArr[1] = iArr[1] + i4;
        if (viewParent instanceof InterfaceC1863E2) {
            ((InterfaceC1863E2) viewParent).mo194KLFTb(view, i, i2, i3, i4, i5);
            return;
        }
        if (i5 == 0) {
            try {
                mjFkc.m12975ZfxDd(viewParent, view, i, i2, i3, i4);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e);
            }
        }
    }

    /* renamed from: mjFkc */
    public static boolean m12969mjFkc(ViewParent viewParent, View view, float f, float f2, boolean z) {
        try {
            return mjFkc.m12976mjFkc(viewParent, view, f, f2, z);
        } catch (AbstractMethodError e) {
            Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e);
            return false;
        }
    }

    /* renamed from: wA */
    public static void m12970wA(ViewParent viewParent, View view, int i, int i2, int[] iArr, int i3) {
        if (viewParent instanceof InterfaceC1863E2) {
            ((InterfaceC1863E2) viewParent).mo208wA(view, i, i2, iArr, i3);
            return;
        }
        if (i3 == 0) {
            try {
                mjFkc.m12977wA(viewParent, view, i, i2, iArr);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e);
            }
        }
    }

    /* renamed from: xJ */
    public static void m12971xJ(ViewParent viewParent, View view, int i) {
        if (viewParent instanceof InterfaceC1863E2) {
            ((InterfaceC1863E2) viewParent).mo189AZxh(view, i);
            return;
        }
        if (i == 0) {
            try {
                mjFkc.m12978xJ(viewParent, view);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e);
            }
        }
    }
}
