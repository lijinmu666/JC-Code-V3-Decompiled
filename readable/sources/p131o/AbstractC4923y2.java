package p131o;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;

/* renamed from: o.y2 */
/* loaded from: classes.dex */
public abstract class AbstractC4923y2 {
    /* renamed from: AZxh */
    public static String m13982AZxh(String str, String str2) {
        return str.substring(str2.length() + 1, str.length() - 1);
    }

    /* renamed from: JHa */
    public static int m13983JHa(Context context, int i, int i2) {
        return AbstractC1931F1.m8250wA(context, i, i2);
    }

    /* renamed from: KLFTb */
    public static boolean m13984KLFTb(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("(");
        return str.startsWith(sb.toString()) && str.endsWith(")");
    }

    /* renamed from: ZfxDd */
    public static boolean m13985ZfxDd(String str) {
        return m13984KLFTb(str, "cubic-bezier") || m13984KLFTb(str, "path");
    }

    /* renamed from: mjFkc */
    public static float m13986mjFkc(String[] strArr, int i) throws NumberFormatException {
        float f = Float.parseFloat(strArr[i]);
        if (f >= 0.0f && f <= 1.0f) {
            return f;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + f);
    }

    /* renamed from: wA */
    public static TimeInterpolator m13987wA(String str) {
        if (!m13984KLFTb(str, "cubic-bezier")) {
            if (m13984KLFTb(str, "path")) {
                return AbstractC4523s3.m13451AZxh(AbstractC4657u3.m13682ZfxDd(m13982AZxh(str, "path")));
            }
            throw new IllegalArgumentException("Invalid motion easing type: " + str);
        }
        String[] strArrSplit = m13982AZxh(str, "cubic-bezier").split(",");
        if (strArrSplit.length == 4) {
            return AbstractC4523s3.m13452mjFkc(m13986mjFkc(strArrSplit, 0), m13986mjFkc(strArrSplit, 1), m13986mjFkc(strArrSplit, 2), m13986mjFkc(strArrSplit, 3));
        }
        throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + strArrSplit.length);
    }

    /* renamed from: xJ */
    public static TimeInterpolator m13988xJ(Context context, int i, TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type != 3) {
            throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
        }
        String strValueOf = String.valueOf(typedValue.string);
        return m13985ZfxDd(strValueOf) ? m13987wA(strValueOf) : AnimationUtils.loadInterpolator(context, typedValue.resourceId);
    }
}
