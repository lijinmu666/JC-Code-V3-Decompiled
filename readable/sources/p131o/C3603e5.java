package p131o;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* renamed from: o.e5 */
/* loaded from: classes.dex */
public class C3603e5 implements TypeEvaluator {

    /* renamed from: mjFkc */
    public Rect f13434mjFkc;

    @Override // android.animation.TypeEvaluator
    /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
    public Rect evaluate(float f, Rect rect, Rect rect2) {
        int i = rect.left + ((int) ((rect2.left - r0) * f));
        int i2 = rect.top + ((int) ((rect2.top - r1) * f));
        int i3 = rect.right + ((int) ((rect2.right - r2) * f));
        int i4 = rect.bottom + ((int) ((rect2.bottom - r6) * f));
        Rect rect3 = this.f13434mjFkc;
        if (rect3 == null) {
            return new Rect(i, i2, i3, i4);
        }
        rect3.set(i, i2, i3, i4);
        return this.f13434mjFkc;
    }
}
