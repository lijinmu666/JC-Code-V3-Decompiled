package p131o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

/* renamed from: o.N1 */
/* loaded from: classes.dex */
public abstract class AbstractC2478N1 {
    /* renamed from: AZxh */
    public static ColorStateList m9573AZxh(Context context, C1606A8 c1606a8, int i) {
        int iM7581MiMN;
        ColorStateList colorStateListM13795mjFkc;
        return (!c1606a8.m7586fehf(i) || (iM7581MiMN = c1606a8.m7581MiMN(i, 0)) == 0 || (colorStateListM13795mjFkc = AbstractC4768vjlshU.m13795mjFkc(context, iM7581MiMN)) == null) ? c1606a8.m7592wA(i) : colorStateListM13795mjFkc;
    }

    /* renamed from: JHa */
    public static boolean m9574JHa(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    /* renamed from: KLFTb */
    public static C3008V7 m9575KLFTb(Context context, TypedArray typedArray, int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return new C3008V7(context, resourceId);
    }

    /* renamed from: ZfxDd */
    public static int m9576ZfxDd(TypedArray typedArray, int i, int i2) {
        return typedArray.hasValue(i) ? i : i2;
    }

    /* renamed from: mjFkc */
    public static ColorStateList m9577mjFkc(Context context, TypedArray typedArray, int i) {
        int resourceId;
        ColorStateList colorStateListM13795mjFkc;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateListM13795mjFkc = AbstractC4768vjlshU.m13795mjFkc(context, resourceId)) == null) ? typedArray.getColorStateList(i) : colorStateListM13795mjFkc;
    }

    /* renamed from: wA */
    public static Drawable m9578wA(Context context, TypedArray typedArray, int i) {
        int resourceId;
        Drawable drawableM13794AZxh;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (drawableM13794AZxh = AbstractC4768vjlshU.m13794AZxh(context, resourceId)) == null) ? typedArray.getDrawable(i) : drawableM13794AZxh;
    }

    /* renamed from: xJ */
    public static boolean m9579xJ(Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }
}
