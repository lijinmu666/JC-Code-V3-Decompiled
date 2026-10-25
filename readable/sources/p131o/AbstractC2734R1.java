package p131o;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* renamed from: o.R1 */
/* loaded from: classes.dex */
public abstract class AbstractC2734R1 {

    /* renamed from: mjFkc */
    public static final int[] f10359mjFkc = {R.attr.theme, AbstractC3800h4.f13930KLMXS};

    /* renamed from: AZxh */
    public static final int[] f10358AZxh = {AbstractC3800h4.f13934Pq};

    /* renamed from: AZxh */
    public static int m10037AZxh(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f10358AZxh, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    /* renamed from: mjFkc */
    public static int m10038mjFkc(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f10359mjFkc);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != 0 ? resourceId : resourceId2;
    }

    /* renamed from: wA */
    public static Context m10039wA(Context context, AttributeSet attributeSet, int i, int i2) {
        int iM10037AZxh = m10037AZxh(context, attributeSet, i, i2);
        boolean z = (context instanceof C1966FVsTt) && ((C1966FVsTt) context).m8301AZxh() == iM10037AZxh;
        if (iM10037AZxh == 0 || z) {
            return context;
        }
        C1966FVsTt c1966FVsTt = new C1966FVsTt(context, iM10037AZxh);
        int iM10038mjFkc = m10038mjFkc(context, attributeSet);
        if (iM10038mjFkc != 0) {
            c1966FVsTt.getTheme().applyStyle(iM10038mjFkc, true);
        }
        return c1966FVsTt;
    }
}
