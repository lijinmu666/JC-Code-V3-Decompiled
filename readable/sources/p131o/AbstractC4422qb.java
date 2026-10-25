package p131o;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

/* renamed from: o.qb */
/* loaded from: classes.dex */
public abstract class AbstractC4422qb {

    /* renamed from: o.qb$AZxh */
    public static class AZxh {
        /* renamed from: mjFkc */
        public static Rect m13269mjFkc(WindowManager windowManager) {
            return windowManager.getCurrentWindowMetrics().getBounds();
        }
    }

    /* renamed from: o.qb$mjFkc */
    public static class mjFkc {
        /* renamed from: mjFkc */
        public static Rect m13270mjFkc(WindowManager windowManager) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            Rect rect = new Rect();
            rect.right = point.x;
            rect.bottom = point.y;
            return rect;
        }
    }

    /* renamed from: mjFkc */
    public static Rect m13268mjFkc(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        return Build.VERSION.SDK_INT >= 30 ? AZxh.m13269mjFkc(windowManager) : mjFkc.m13270mjFkc(windowManager);
    }
}
