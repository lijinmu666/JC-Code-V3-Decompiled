package p131o;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* renamed from: o.s3 */
/* loaded from: classes.dex */
public abstract class AbstractC4523s3 {

    /* renamed from: o.s3$mjFkc */
    public static class mjFkc {
        /* renamed from: AZxh */
        public static Interpolator m13453AZxh(float f, float f2, float f3, float f4) {
            return new PathInterpolator(f, f2, f3, f4);
        }

        /* renamed from: mjFkc */
        public static Interpolator m13454mjFkc(float f, float f2) {
            return new PathInterpolator(f, f2);
        }

        /* renamed from: wA */
        public static Interpolator m13455wA(Path path) {
            return new PathInterpolator(path);
        }
    }

    /* renamed from: AZxh */
    public static Interpolator m13451AZxh(Path path) {
        return mjFkc.m13455wA(path);
    }

    /* renamed from: mjFkc */
    public static Interpolator m13452mjFkc(float f, float f2, float f3, float f4) {
        return mjFkc.m13453AZxh(f, f2, f3, f4);
    }
}
