package p131o;

import android.os.Build;
import android.view.View;
import android.view.Window;

/* renamed from: o.Ka */
/* loaded from: classes.dex */
public abstract class AbstractC2315Ka {

    /* renamed from: o.Ka$AZxh */
    public static class AZxh {
        /* renamed from: mjFkc */
        public static void m9244mjFkc(Window window, boolean z) {
            window.setDecorFitsSystemWindows(z);
        }
    }

    /* renamed from: o.Ka$mjFkc */
    public static class mjFkc {
        /* renamed from: mjFkc */
        public static void m9245mjFkc(Window window, boolean z) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility & (-1793) : systemUiVisibility | 1792);
        }
    }

    /* renamed from: AZxh */
    public static void m9242AZxh(Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 30) {
            AZxh.m9244mjFkc(window, z);
        } else {
            mjFkc.m9245mjFkc(window, z);
        }
    }

    /* renamed from: mjFkc */
    public static C4224nb m9243mjFkc(Window window, View view) {
        return new C4224nb(window, view);
    }
}
