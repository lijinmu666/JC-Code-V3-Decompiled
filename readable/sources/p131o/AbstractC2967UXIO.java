package p131o;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;

/* renamed from: o.UXIO */
/* loaded from: classes.dex */
public abstract class AbstractC2967UXIO {

    /* renamed from: o.UXIO$AZxh */
    public static class AZxh {
        /* renamed from: AZxh */
        public static float m10512AZxh(EdgeEffect edgeEffect) {
            try {
                return edgeEffect.getDistance();
            } catch (Throwable unused) {
                return 0.0f;
            }
        }

        /* renamed from: mjFkc */
        public static EdgeEffect m10513mjFkc(Context context, AttributeSet attributeSet) {
            try {
                return new EdgeEffect(context, attributeSet);
            } catch (Throwable unused) {
                return new EdgeEffect(context);
            }
        }

        /* renamed from: wA */
        public static float m10514wA(EdgeEffect edgeEffect, float f, float f2) {
            try {
                return edgeEffect.onPullDistance(f, f2);
            } catch (Throwable unused) {
                edgeEffect.onPull(f, f2);
                return 0.0f;
            }
        }
    }

    /* renamed from: o.UXIO$mjFkc */
    public static class mjFkc {
        /* renamed from: mjFkc */
        public static void m10515mjFkc(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f, f2);
        }
    }

    /* renamed from: AZxh */
    public static float m10508AZxh(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return AZxh.m10512AZxh(edgeEffect);
        }
        return 0.0f;
    }

    /* renamed from: ZfxDd */
    public static float m10509ZfxDd(EdgeEffect edgeEffect, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 31) {
            return AZxh.m10514wA(edgeEffect, f, f2);
        }
        m10511wA(edgeEffect, f, f2);
        return f;
    }

    /* renamed from: mjFkc */
    public static EdgeEffect m10510mjFkc(Context context, AttributeSet attributeSet) {
        return Build.VERSION.SDK_INT >= 31 ? AZxh.m10513mjFkc(context, attributeSet) : new EdgeEffect(context);
    }

    /* renamed from: wA */
    public static void m10511wA(EdgeEffect edgeEffect, float f, float f2) {
        mjFkc.m10515mjFkc(edgeEffect, f, f2);
    }
}
