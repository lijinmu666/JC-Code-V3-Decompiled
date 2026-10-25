package p131o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.p038google.p039android.material.datepicker.C0253AZxh;

/* renamed from: o.uxlM */
/* loaded from: classes.dex */
public final class C4715uxlM {

    /* renamed from: AZxh */
    public final C3060Vu f16934AZxh;

    /* renamed from: JHa */
    public final C3060Vu f16935JHa;

    /* renamed from: KLFTb */
    public final C3060Vu f16936KLFTb;

    /* renamed from: ZfxDd */
    public final C3060Vu f16937ZfxDd;

    /* renamed from: lgHUyS */
    public final Paint f16938lgHUyS;

    /* renamed from: mjFkc */
    public final C3060Vu f16939mjFkc;

    /* renamed from: wA */
    public final C3060Vu f16940wA;

    /* renamed from: xJ */
    public final C3060Vu f16941xJ;

    public C4715uxlM(Context context) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(AbstractC1931F1.m8248ZfxDd(context, AbstractC3800h4.f13948qGY, C0253AZxh.class.getCanonicalName()), AbstractC3340a5.f12629peCqC);
        this.f16939mjFkc = C3060Vu.m10734mjFkc(context, typedArrayObtainStyledAttributes.getResourceId(AbstractC3340a5.f12470TFbkuO, 0));
        this.f16941xJ = C3060Vu.m10734mjFkc(context, typedArrayObtainStyledAttributes.getResourceId(AbstractC3340a5.f12680wGscSa, 0));
        this.f16934AZxh = C3060Vu.m10734mjFkc(context, typedArrayObtainStyledAttributes.getResourceId(AbstractC3340a5.f12656tPvjn, 0));
        this.f16940wA = C3060Vu.m10734mjFkc(context, typedArrayObtainStyledAttributes.getResourceId(AbstractC3340a5.f12439Otxclu, 0));
        ColorStateList colorStateListM9577mjFkc = AbstractC2478N1.m9577mjFkc(context, typedArrayObtainStyledAttributes, AbstractC3340a5.f12440OzIs);
        this.f16937ZfxDd = C3060Vu.m10734mjFkc(context, typedArrayObtainStyledAttributes.getResourceId(AbstractC3340a5.f12455RWb, 0));
        this.f16936KLFTb = C3060Vu.m10734mjFkc(context, typedArrayObtainStyledAttributes.getResourceId(AbstractC3340a5.f12322ArO, 0));
        this.f16935JHa = C3060Vu.m10734mjFkc(context, typedArrayObtainStyledAttributes.getResourceId(AbstractC3340a5.f12581jTNPnW, 0));
        Paint paint = new Paint();
        this.f16938lgHUyS = paint;
        paint.setColor(colorStateListM9577mjFkc.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
