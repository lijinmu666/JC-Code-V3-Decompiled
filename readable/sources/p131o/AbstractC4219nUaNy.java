package p131o;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* renamed from: o.nUaNy */
/* loaded from: classes.dex */
public abstract class AbstractC4219nUaNy extends FrameLayout {

    /* renamed from: lgHUyS */
    public static final int[] f15396lgHUyS = {R.attr.colorBackground};

    /* renamed from: qdMbNW */
    public static final InterfaceC3443bc f15397qdMbNW;

    /* renamed from: AZxh */
    public boolean f15398AZxh;

    /* renamed from: JHa */
    public final Rect f15399JHa;

    /* renamed from: KLFTb */
    public final Rect f15400KLFTb;

    /* renamed from: ZfxDd */
    public int f15401ZfxDd;

    /* renamed from: mjFkc */
    public boolean f15402mjFkc;

    /* renamed from: wA */
    public int f15403wA;

    /* renamed from: xJ */
    public final InterfaceC4867xCVa f15404xJ;

    /* renamed from: o.nUaNy$mjFkc */
    public class mjFkc implements InterfaceC4867xCVa {

        /* renamed from: mjFkc */
        public Drawable f15406mjFkc;

        public mjFkc() {
        }

        @Override // p131o.InterfaceC4867xCVa
        /* renamed from: AZxh */
        public void mo12886AZxh(int i, int i2, int i3, int i4) {
            AbstractC4219nUaNy.this.f15399JHa.set(i, i2, i3, i4);
            AbstractC4219nUaNy abstractC4219nUaNy = AbstractC4219nUaNy.this;
            Rect rect = abstractC4219nUaNy.f15400KLFTb;
            AbstractC4219nUaNy.super.setPadding(i + rect.left, i2 + rect.top, i3 + rect.right, i4 + rect.bottom);
        }

        @Override // p131o.InterfaceC4867xCVa
        /* renamed from: JHa */
        public Drawable mo12887JHa() {
            return this.f15406mjFkc;
        }

        @Override // p131o.InterfaceC4867xCVa
        /* renamed from: KLFTb */
        public boolean mo12888KLFTb() {
            return AbstractC4219nUaNy.this.getUseCompatPadding();
        }

        @Override // p131o.InterfaceC4867xCVa
        /* renamed from: ZfxDd */
        public boolean mo12889ZfxDd() {
            return AbstractC4219nUaNy.this.getPreventCornerOverlap();
        }

        @Override // p131o.InterfaceC4867xCVa
        /* renamed from: mjFkc */
        public View mo12890mjFkc() {
            return AbstractC4219nUaNy.this;
        }

        @Override // p131o.InterfaceC4867xCVa
        /* renamed from: wA */
        public void mo12891wA(Drawable drawable) {
            this.f15406mjFkc = drawable;
            AbstractC4219nUaNy.this.setBackgroundDrawable(drawable);
        }
    }

    static {
        C4690ub c4690ub = new C4690ub();
        f15397qdMbNW = c4690ub;
        c4690ub.mo11561lgHUyS();
    }

    public AbstractC4219nUaNy(Context context, AttributeSet attributeSet, int i) {
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, i);
        Rect rect = new Rect();
        this.f15400KLFTb = rect;
        this.f15399JHa = new Rect();
        mjFkc mjfkc = new mjFkc();
        this.f15404xJ = mjfkc;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC2933U4.f10779mjFkc, i, AbstractC2610P4.f10031mjFkc);
        if (typedArrayObtainStyledAttributes.hasValue(AbstractC2933U4.f10777ZfxDd)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(AbstractC2933U4.f10777ZfxDd);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(f15396lgHUyS);
            int color = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            colorStateListValueOf = ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(AbstractC3924j4.f14239AZxh) : getResources().getColor(AbstractC3924j4.f14240mjFkc));
        }
        ColorStateList colorStateList = colorStateListValueOf;
        float dimension = typedArrayObtainStyledAttributes.getDimension(AbstractC2933U4.f10773KLFTb, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(AbstractC2933U4.f10772JHa, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(AbstractC2933U4.f10782xJ, 0.0f);
        this.f15402mjFkc = typedArrayObtainStyledAttributes.getBoolean(AbstractC2933U4.f10780qdMbNW, false);
        this.f15398AZxh = typedArrayObtainStyledAttributes.getBoolean(AbstractC2933U4.f10778lgHUyS, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC2933U4.f10770Dt, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC2933U4.f10775VA, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC2933U4.f10776YoKzxo, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC2933U4.f10774MiMN, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC2933U4.f10771ETF, dimensionPixelSize);
        float f = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f15403wA = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC2933U4.f10769AZxh, 0);
        this.f15401ZfxDd = typedArrayObtainStyledAttributes.getDimensionPixelSize(AbstractC2933U4.f10781wA, 0);
        typedArrayObtainStyledAttributes.recycle();
        f15397qdMbNW.mo11566xJ(mjfkc, context, colorStateList, dimension, dimension2, f);
    }

    /* renamed from: AZxh */
    public void m12885AZxh(int i, int i2, int i3, int i4) {
        this.f15400KLFTb.set(i, i2, i3, i4);
        f15397qdMbNW.mo11558VA(this.f15404xJ);
    }

    public ColorStateList getCardBackgroundColor() {
        return f15397qdMbNW.mo11562mjFkc(this.f15404xJ);
    }

    public float getCardElevation() {
        return f15397qdMbNW.mo11557MiMN(this.f15404xJ);
    }

    public int getContentPaddingBottom() {
        return this.f15400KLFTb.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f15400KLFTb.left;
    }

    public int getContentPaddingRight() {
        return this.f15400KLFTb.right;
    }

    public int getContentPaddingTop() {
        return this.f15400KLFTb.top;
    }

    public float getMaxCardElevation() {
        return f15397qdMbNW.mo11552AZxh(this.f15404xJ);
    }

    public boolean getPreventCornerOverlap() {
        return this.f15398AZxh;
    }

    public float getRadius() {
        return f15397qdMbNW.mo11554ETF(this.f15404xJ);
    }

    public boolean getUseCompatPadding() {
        return this.f15402mjFkc;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (f15397qdMbNW instanceof C4690ub) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.mo11555JHa(this.f15404xJ)), View.MeasureSpec.getSize(i)), mode);
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.mo11560ZfxDd(this.f15404xJ)), View.MeasureSpec.getSize(i2)), mode2);
        }
        super.onMeasure(i, i2);
    }

    public void setCardBackgroundColor(int i) {
        f15397qdMbNW.mo11563qdMbNW(this.f15404xJ, ColorStateList.valueOf(i));
    }

    public void setCardElevation(float f) {
        f15397qdMbNW.mo11564rkYL(this.f15404xJ, f);
    }

    public void setMaxCardElevation(float f) {
        f15397qdMbNW.mo11565wA(this.f15404xJ, f);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        this.f15401ZfxDd = i;
        super.setMinimumHeight(i);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        this.f15403wA = i;
        super.setMinimumWidth(i);
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.f15398AZxh) {
            this.f15398AZxh = z;
            f15397qdMbNW.mo11553Dt(this.f15404xJ);
        }
    }

    public void setRadius(float f) {
        f15397qdMbNW.mo11559YoKzxo(this.f15404xJ, f);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f15402mjFkc != z) {
            this.f15402mjFkc = z;
            f15397qdMbNW.mo11556KLFTb(this.f15404xJ);
        }
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f15397qdMbNW.mo11563qdMbNW(this.f15404xJ, colorStateList);
    }
}
