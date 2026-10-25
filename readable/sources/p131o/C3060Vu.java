package p131o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;

/* renamed from: o.Vu */
/* loaded from: classes.dex */
public final class C3060Vu {

    /* renamed from: AZxh */
    public final ColorStateList f11379AZxh;

    /* renamed from: JHa */
    public final C2141I6 f11380JHa;

    /* renamed from: KLFTb */
    public final int f11381KLFTb;

    /* renamed from: ZfxDd */
    public final ColorStateList f11382ZfxDd;

    /* renamed from: mjFkc */
    public final Rect f11383mjFkc;

    /* renamed from: wA */
    public final ColorStateList f11384wA;

    public C3060Vu(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i, C2141I6 c2141i6, Rect rect) {
        AbstractC2280K3.m9121ZfxDd(rect.left);
        AbstractC2280K3.m9121ZfxDd(rect.top);
        AbstractC2280K3.m9121ZfxDd(rect.right);
        AbstractC2280K3.m9121ZfxDd(rect.bottom);
        this.f11383mjFkc = rect;
        this.f11379AZxh = colorStateList2;
        this.f11384wA = colorStateList;
        this.f11382ZfxDd = colorStateList3;
        this.f11381KLFTb = i;
        this.f11380JHa = c2141i6;
    }

    /* renamed from: mjFkc */
    public static C3060Vu m10734mjFkc(Context context, int i) throws Resources.NotFoundException {
        AbstractC2280K3.m9118AZxh(i != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, AbstractC3340a5.f12350EeoThB);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(AbstractC3340a5.f12545cdjp, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(AbstractC3340a5.f12420MFekjo, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(AbstractC3340a5.f12687xBQUgd, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(AbstractC3340a5.f12478UPU, 0));
        ColorStateList colorStateListM9577mjFkc = AbstractC2478N1.m9577mjFkc(context, typedArrayObtainStyledAttributes, AbstractC3340a5.f12384IPpyV);
        ColorStateList colorStateListM9577mjFkc2 = AbstractC2478N1.m9577mjFkc(context, typedArrayObtainStyledAttributes, AbstractC3340a5.f12586jpz);
        ColorStateList colorStateListM9577mjFkc3 = AbstractC2478N1.m9577mjFkc(context, typedArrayObtainStyledAttributes, AbstractC3340a5.f12354Es);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC3340a5.f12518ZGL, 0);
        C2141I6 c2141i6M8698MiMN = C2141I6.m8656AZxh(context, typedArrayObtainStyledAttributes.getResourceId(AbstractC3340a5.f12591kOlLW, 0), typedArrayObtainStyledAttributes.getResourceId(AbstractC3340a5.f12416LlB, 0)).m8698MiMN();
        typedArrayObtainStyledAttributes.recycle();
        return new C3060Vu(colorStateListM9577mjFkc, colorStateListM9577mjFkc2, colorStateListM9577mjFkc3, dimensionPixelSize, c2141i6M8698MiMN, rect);
    }
}
