package p131o;

import android.graphics.Rect;
import android.view.Gravity;

/* renamed from: o.l */
/* loaded from: classes.dex */
public abstract class AbstractC4056l {
    /* renamed from: AZxh */
    public static int m12647AZxh(int i, int i2) {
        return Gravity.getAbsoluteGravity(i, i2);
    }

    /* renamed from: mjFkc */
    public static void m12648mjFkc(int i, int i2, int i3, Rect rect, Rect rect2, int i4) {
        Gravity.apply(i, i2, i3, rect, rect2, i4);
    }
}
