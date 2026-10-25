package p131o;

import android.graphics.drawable.Drawable;

/* renamed from: o.G5 */
/* loaded from: classes.dex */
public abstract class AbstractC2008G5 extends Drawable {

    /* renamed from: mjFkc */
    public static final double f8329mjFkc = Math.cos(Math.toRadians(45.0d));

    /* renamed from: AZxh */
    public static float m8403AZxh(float f, float f2, boolean z) {
        return z ? (float) ((f * 1.5f) + ((1.0d - f8329mjFkc) * f2)) : f * 1.5f;
    }

    /* renamed from: mjFkc */
    public static float m8404mjFkc(float f, float f2, boolean z) {
        return z ? (float) (f + ((1.0d - f8329mjFkc) * f2)) : f;
    }
}
