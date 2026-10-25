package p131o;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* renamed from: o.ea */
/* loaded from: classes.dex */
public abstract class AbstractC3634ea {

    /* renamed from: mjFkc */
    public static final ThreadLocal f13477mjFkc = new ThreadLocal();

    /* renamed from: AZxh */
    public static final ThreadLocal f13476AZxh = new ThreadLocal();

    /* renamed from: AZxh */
    public static void m11848AZxh(ViewParent viewParent, View view, Matrix matrix) {
        Object parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            m11848AZxh(viewParent, (View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        if (view.getMatrix().isIdentity()) {
            return;
        }
        matrix.preConcat(view.getMatrix());
    }

    /* renamed from: mjFkc */
    public static void m11849mjFkc(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        m11850wA(viewGroup, view, rect);
    }

    /* renamed from: wA */
    public static void m11850wA(ViewGroup viewGroup, View view, Rect rect) {
        ThreadLocal threadLocal = f13477mjFkc;
        Matrix matrix = (Matrix) threadLocal.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal.set(matrix);
        } else {
            matrix.reset();
        }
        m11848AZxh(viewGroup, view, matrix);
        ThreadLocal threadLocal2 = f13476AZxh;
        RectF rectF = (RectF) threadLocal2.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal2.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }
}
