package com.p038google.p039android.material.p057appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.p010view.p011menu.C0007ZfxDd;
import androidx.appcompat.p012widget.C0044Toolbar;
import p131o.AbstractC2075H8;
import p131o.AbstractC2607P1;
import p131o.AbstractC2734R1;
import p131o.AbstractC2737R4;
import p131o.AbstractC2876T9;
import p131o.AbstractC3340a5;
import p131o.AbstractC3800h4;
import p131o.AbstractC4260o8;
import p131o.AbstractC4332pCk;
import p131o.C2542O1;

/* loaded from: classes.dex */
public class MaterialToolbar extends C0044Toolbar {

    /* renamed from: JrJO */
    public static final int f2304JrJO = AbstractC2737R4.f10370YoKzxo;

    /* renamed from: nxI */
    public static final ImageView.ScaleType[] f2305nxI = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: GMIER */
    public boolean f2306GMIER;

    /* renamed from: JYgkl */
    public Boolean f2307JYgkl;

    /* renamed from: JYn */
    public ImageView.ScaleType f2308JYn;

    /* renamed from: KRTLGT */
    public Integer f2309KRTLGT;

    /* renamed from: uHVRx */
    public boolean f2310uHVRx;

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC3800h4.f13956zvd);
    }

    /* renamed from: NPj */
    public final void m2456NPj(View view, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = view.getMeasuredWidth();
        int i = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i2 = measuredWidth2 + i;
        int iMax = Math.max(Math.max(((Integer) pair.first).intValue() - i, 0), Math.max(i2 - ((Integer) pair.second).intValue(), 0));
        if (iMax > 0) {
            i += iMax;
            i2 -= iMax;
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 - i, 1073741824), view.getMeasuredHeightAndState());
        }
        view.layout(i, view.getTop(), i2, view.getBottom());
    }

    /* renamed from: Vnb */
    public final void m2457Vnb(Context context) {
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            C2542O1 c2542o1 = new C2542O1();
            c2542o1.m9841uHVRx(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            c2542o1.m9827cMLeY(context);
            c2542o1.m9801GMIER(AbstractC2876T9.m10231IEE(this));
            AbstractC2876T9.m10294vjlshU(this, c2542o1);
        }
    }

    /* renamed from: aqHPIZ */
    public final void m2458aqHPIZ() {
        ImageView imageViewM8517AZxh = AbstractC2075H8.m8517AZxh(this);
        if (imageViewM8517AZxh != null) {
            Boolean bool = this.f2307JYgkl;
            if (bool != null) {
                imageViewM8517AZxh.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.f2308JYn;
            if (scaleType != null) {
                imageViewM8517AZxh.setScaleType(scaleType);
            }
        }
    }

    @Override // androidx.appcompat.p012widget.C0044Toolbar
    /* renamed from: eyqo */
    public void mo300eyqo(int i) {
        Menu menuM303getMenu = m303getMenu();
        boolean z = menuM303getMenu instanceof C0007ZfxDd;
        if (z) {
            ((C0007ZfxDd) menuM303getMenu).m140uHVRx();
        }
        super.mo300eyqo(i);
        if (z) {
            ((C0007ZfxDd) menuM303getMenu).m110GMIER();
        }
    }

    public ImageView.ScaleType getLogoScaleType() {
        return this.f2308JYn;
    }

    public Integer getNavigationIconTint() {
        return this.f2309KRTLGT;
    }

    /* renamed from: oCFDzJ */
    public final Drawable m2459oCFDzJ(Drawable drawable) {
        if (drawable == null || this.f2309KRTLGT == null) {
            return drawable;
        }
        Drawable drawableM13077VA = AbstractC4332pCk.m13077VA(drawable.mutate());
        AbstractC4332pCk.m13079lgHUyS(drawableM13077VA, this.f2309KRTLGT.intValue());
        return drawableM13077VA;
    }

    @Override // androidx.appcompat.p012widget.C0044Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractC2607P1.m9941KLFTb(this);
    }

    @Override // androidx.appcompat.p012widget.C0044Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m2461vadzgd();
        m2458aqHPIZ();
    }

    /* renamed from: rWxwaT */
    public final Pair m2460rWxwaT(TextView textView, TextView textView2) {
        int measuredWidth = getMeasuredWidth();
        int i = measuredWidth / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = measuredWidth - getPaddingRight();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                if (childAt.getRight() < i && childAt.getRight() > paddingLeft) {
                    paddingLeft = childAt.getRight();
                }
                if (childAt.getLeft() > i && childAt.getLeft() < paddingRight) {
                    paddingRight = childAt.getLeft();
                }
            }
        }
        return new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        AbstractC2607P1.m9942ZfxDd(this, f);
    }

    public void setLogoAdjustViewBounds(boolean z) {
        Boolean bool = this.f2307JYgkl;
        if (bool == null || bool.booleanValue() != z) {
            this.f2307JYgkl = Boolean.valueOf(z);
            requestLayout();
        }
    }

    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.f2308JYn != scaleType) {
            this.f2308JYn = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.p012widget.C0044Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(m2459oCFDzJ(drawable));
    }

    public void setNavigationIconTint(int i) {
        this.f2309KRTLGT = Integer.valueOf(i);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z) {
        if (this.f2310uHVRx != z) {
            this.f2310uHVRx = z;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z) {
        if (this.f2306GMIER != z) {
            this.f2306GMIER = z;
            requestLayout();
        }
    }

    /* renamed from: vadzgd */
    public final void m2461vadzgd() {
        if (this.f2306GMIER || this.f2310uHVRx) {
            TextView textViewM8518KLFTb = AbstractC2075H8.m8518KLFTb(this);
            TextView textViewM8521wA = AbstractC2075H8.m8521wA(this);
            if (textViewM8518KLFTb == null && textViewM8521wA == null) {
                return;
            }
            Pair pairM2460rWxwaT = m2460rWxwaT(textViewM8518KLFTb, textViewM8521wA);
            if (this.f2306GMIER && textViewM8518KLFTb != null) {
                m2456NPj(textViewM8518KLFTb, pairM2460rWxwaT);
            }
            if (!this.f2310uHVRx || textViewM8521wA == null) {
                return;
            }
            m2456NPj(textViewM8521wA, pairM2460rWxwaT);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialToolbar(Context context, AttributeSet attributeSet, int i) {
        int i2 = f2304JrJO;
        super(AbstractC2734R1.m10039wA(context, attributeSet, i, i2), attributeSet, i);
        Context context2 = getContext();
        TypedArray typedArrayM12940lgHUyS = AbstractC4260o8.m12940lgHUyS(context2, attributeSet, AbstractC3340a5.f12359FVsTt, i, i2, new int[0]);
        if (typedArrayM12940lgHUyS.hasValue(AbstractC3340a5.f12362Fncs)) {
            setNavigationIconTint(typedArrayM12940lgHUyS.getColor(AbstractC3340a5.f12362Fncs, -1));
        }
        this.f2306GMIER = typedArrayM12940lgHUyS.getBoolean(AbstractC3340a5.f12421MLoZE, false);
        this.f2310uHVRx = typedArrayM12940lgHUyS.getBoolean(AbstractC3340a5.f12649sTX, false);
        int i3 = typedArrayM12940lgHUyS.getInt(AbstractC3340a5.f12659tnpR, -1);
        if (i3 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = f2305nxI;
            if (i3 < scaleTypeArr.length) {
                this.f2308JYn = scaleTypeArr[i3];
            }
        }
        if (typedArrayM12940lgHUyS.hasValue(AbstractC3340a5.f12544cQmsjG)) {
            this.f2307JYgkl = Boolean.valueOf(typedArrayM12940lgHUyS.getBoolean(AbstractC3340a5.f12544cQmsjG, false));
        }
        typedArrayM12940lgHUyS.recycle();
        m2457Vnb(context2);
    }
}
