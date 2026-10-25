package p131o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import p131o.AbstractC4592t5;

/* renamed from: o.A8 */
/* loaded from: classes.dex */
public class C1606A8 {

    /* renamed from: AZxh */
    public final TypedArray f7322AZxh;

    /* renamed from: mjFkc */
    public final Context f7323mjFkc;

    /* renamed from: wA */
    public TypedValue f7324wA;

    public C1606A8(Context context, TypedArray typedArray) {
        this.f7323mjFkc = context;
        this.f7322AZxh = typedArray;
    }

    /* renamed from: IEE */
    public static C1606A8 m7573IEE(Context context, int i, int[] iArr) {
        return new C1606A8(context, context.obtainStyledAttributes(i, iArr));
    }

    /* renamed from: Pq */
    public static C1606A8 m7574Pq(Context context, AttributeSet attributeSet, int[] iArr) {
        return new C1606A8(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    /* renamed from: diqgf */
    public static C1606A8 m7575diqgf(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new C1606A8(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    /* renamed from: AZxh */
    public int m7576AZxh(int i, int i2) {
        return this.f7322AZxh.getColor(i, i2);
    }

    /* renamed from: Dt */
    public int m7577Dt(int i, int i2) {
        return this.f7322AZxh.getInt(i, i2);
    }

    /* renamed from: ETF */
    public int m7578ETF(int i, int i2) {
        return this.f7322AZxh.getInteger(i, i2);
    }

    /* renamed from: JHa */
    public int m7579JHa(int i, int i2) {
        return this.f7322AZxh.getDimensionPixelSize(i, i2);
    }

    /* renamed from: KLFTb */
    public int m7580KLFTb(int i, int i2) {
        return this.f7322AZxh.getDimensionPixelOffset(i, i2);
    }

    /* renamed from: MiMN */
    public int m7581MiMN(int i, int i2) {
        return this.f7322AZxh.getResourceId(i, i2);
    }

    /* renamed from: VA */
    public int m7582VA(int i, int i2) {
        return this.f7322AZxh.getLayoutDimension(i, i2);
    }

    /* renamed from: YoKzxo */
    public String m7583YoKzxo(int i) {
        return this.f7322AZxh.getString(i);
    }

    /* renamed from: ZfxDd */
    public float m7584ZfxDd(int i, float f) {
        return this.f7322AZxh.getDimension(i, f);
    }

    /* renamed from: eyqo */
    public void m7585eyqo() {
        this.f7322AZxh.recycle();
    }

    /* renamed from: fehf */
    public boolean m7586fehf(int i) {
        return this.f7322AZxh.hasValue(i);
    }

    /* renamed from: lgHUyS */
    public float m7587lgHUyS(int i, float f) {
        return this.f7322AZxh.getFloat(i, f);
    }

    /* renamed from: mjFkc */
    public boolean m7588mjFkc(int i, boolean z) {
        return this.f7322AZxh.getBoolean(i, z);
    }

    /* renamed from: qGY */
    public TypedArray m7589qGY() {
        return this.f7322AZxh;
    }

    /* renamed from: qdMbNW */
    public Typeface m7590qdMbNW(int i, int i2, AbstractC4592t5.KLFTb kLFTb) {
        int resourceId = this.f7322AZxh.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f7324wA == null) {
            this.f7324wA = new TypedValue();
        }
        return AbstractC4592t5.m13583lgHUyS(this.f7323mjFkc, resourceId, this.f7324wA, i2, kLFTb);
    }

    /* renamed from: rkYL */
    public CharSequence m7591rkYL(int i) {
        return this.f7322AZxh.getText(i);
    }

    /* renamed from: wA */
    public ColorStateList m7592wA(int i) {
        int resourceId;
        ColorStateList colorStateListM13795mjFkc;
        return (!this.f7322AZxh.hasValue(i) || (resourceId = this.f7322AZxh.getResourceId(i, 0)) == 0 || (colorStateListM13795mjFkc = AbstractC4768vjlshU.m13795mjFkc(this.f7323mjFkc, resourceId)) == null) ? this.f7322AZxh.getColorStateList(i) : colorStateListM13795mjFkc;
    }

    /* renamed from: xJ */
    public Drawable m7593xJ(int i) {
        int resourceId;
        return (!this.f7322AZxh.hasValue(i) || (resourceId = this.f7322AZxh.getResourceId(i, 0)) == 0) ? this.f7322AZxh.getDrawable(i) : AbstractC4768vjlshU.m13794AZxh(this.f7323mjFkc, resourceId);
    }
}
