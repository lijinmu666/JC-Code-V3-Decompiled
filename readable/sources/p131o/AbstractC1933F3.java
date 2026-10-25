package p131o;

import android.view.View;
import android.widget.PopupWindow;

/* renamed from: o.F3 */
/* loaded from: classes.dex */
public abstract class AbstractC1933F3 {

    /* renamed from: o.F3$mjFkc */
    public static class mjFkc {
        /* renamed from: AZxh */
        public static int m8254AZxh(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }

        /* renamed from: ZfxDd */
        public static void m8255ZfxDd(PopupWindow popupWindow, int i) {
            popupWindow.setWindowLayoutType(i);
        }

        /* renamed from: mjFkc */
        public static boolean m8256mjFkc(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        /* renamed from: wA */
        public static void m8257wA(PopupWindow popupWindow, boolean z) {
            popupWindow.setOverlapAnchor(z);
        }
    }

    /* renamed from: AZxh */
    public static void m8251AZxh(PopupWindow popupWindow, int i) {
        mjFkc.m8255ZfxDd(popupWindow, i);
    }

    /* renamed from: mjFkc */
    public static void m8252mjFkc(PopupWindow popupWindow, boolean z) {
        mjFkc.m8257wA(popupWindow, z);
    }

    /* renamed from: wA */
    public static void m8253wA(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        popupWindow.showAsDropDown(view, i, i2, i3);
    }
}
