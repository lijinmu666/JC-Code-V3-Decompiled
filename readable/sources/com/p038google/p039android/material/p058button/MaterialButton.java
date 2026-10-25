package com.p038google.p039android.material.p058button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import java.util.Iterator;
import java.util.LinkedHashSet;
import p131o.AbstractC2478N1;
import p131o.AbstractC2607P1;
import p131o.AbstractC2734R1;
import p131o.AbstractC2737R4;
import p131o.AbstractC2876T9;
import p131o.AbstractC3340a5;
import p131o.AbstractC3800h4;
import p131o.AbstractC4065l8;
import p131o.AbstractC4248nxI;
import p131o.AbstractC4260o8;
import p131o.AbstractC4332pCk;
import p131o.AbstractC4557sa;
import p131o.AbstractC4768vjlshU;
import p131o.AbstractC4793w7;
import p131o.AbstractC4796wA;
import p131o.C2004G1;
import p131o.C2141I6;
import p131o.InterfaceC2350L6;

/* loaded from: classes.dex */
public class MaterialButton extends AbstractC4248nxI implements Checkable, InterfaceC2350L6 {

    /* renamed from: IEE */
    public static final int[] f2431IEE = {R.attr.state_checkable};

    /* renamed from: Pq */
    public static final int[] f2432Pq = {R.attr.state_checked};

    /* renamed from: diqgf */
    public static final int f2433diqgf = AbstractC2737R4.f10372lgHUyS;

    /* renamed from: Dt */
    public String f2434Dt;

    /* renamed from: ETF */
    public int f2435ETF;

    /* renamed from: JHa */
    public InterfaceC0238mjFkc f2436JHa;

    /* renamed from: KLFTb */
    public final LinkedHashSet f2437KLFTb;

    /* renamed from: MiMN */
    public int f2438MiMN;

    /* renamed from: VA */
    public int f2439VA;

    /* renamed from: YoKzxo */
    public int f2440YoKzxo;

    /* renamed from: ZfxDd */
    public final C2004G1 f2441ZfxDd;

    /* renamed from: fehf */
    public int f2442fehf;

    /* renamed from: lgHUyS */
    public ColorStateList f2443lgHUyS;

    /* renamed from: qGY */
    public boolean f2444qGY;

    /* renamed from: qdMbNW */
    public Drawable f2445qdMbNW;

    /* renamed from: rkYL */
    public boolean f2446rkYL;

    /* renamed from: xJ */
    public PorterDuff.Mode f2447xJ;

    /* renamed from: com.google.android.material.button.MaterialButton$AZxh */
    public static class C0237AZxh extends AbstractC4796wA {

        /* renamed from: CREATOR */
        public static final Parcelable.Creator<C0237AZxh> f2448CREATOR = new mjFkc();

        /* renamed from: wA */
        public boolean f2449wA;

        /* renamed from: com.google.android.material.button.MaterialButton$AZxh$mjFkc */
        public class mjFkc implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
            public C0237AZxh createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0237AZxh(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
            public C0237AZxh createFromParcel(Parcel parcel) {
                return new C0237AZxh(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: wA, reason: merged with bridge method [inline-methods] */
            public C0237AZxh[] newArray(int i) {
                return new C0237AZxh[i];
            }
        }

        public C0237AZxh(Parcelable parcelable) {
            super(parcelable);
        }

        /* renamed from: AZxh */
        public final void m2593AZxh(Parcel parcel) {
            this.f2449wA = parcel.readInt() == 1;
        }

        @Override // p131o.AbstractC4796wA, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2449wA ? 1 : 0);
        }

        public C0237AZxh(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            m2593AZxh(parcel);
        }
    }

    /* renamed from: com.google.android.material.button.MaterialButton$mjFkc */
    public interface InterfaceC0238mjFkc {
        /* renamed from: mjFkc */
        void mo2597mjFkc(MaterialButton materialButton, boolean z);
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC3800h4.f13938YoKzxo);
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(string, 0, string.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int lineCount = getLineCount();
        float fMax = 0.0f;
        for (int i = 0; i < lineCount; i++) {
            fMax = Math.max(fMax, getLayout().getLineWidth(i));
        }
        return (int) Math.ceil(fMax);
    }

    /* renamed from: AZxh */
    public final boolean m2582AZxh() {
        int i = this.f2442fehf;
        return i == 3 || i == 4;
    }

    /* renamed from: JHa */
    public final boolean m2583JHa() {
        C2004G1 c2004g1 = this.f2441ZfxDd;
        return (c2004g1 == null || c2004g1.m8386rkYL()) ? false : true;
    }

    /* renamed from: KLFTb */
    public final boolean m2584KLFTb() {
        return AbstractC2876T9.m10276huTpC(this) == 1;
    }

    /* renamed from: ZfxDd */
    public final boolean m2585ZfxDd() {
        int i = this.f2442fehf;
        return i == 16 || i == 32;
    }

    public String getA11yClassName() {
        if (TextUtils.isEmpty(this.f2434Dt)) {
            return (m2588mjFkc() ? CompoundButton.class : Button.class).getName();
        }
        return this.f2434Dt;
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (m2583JHa()) {
            return this.f2441ZfxDd.m8356AZxh();
        }
        return 0;
    }

    /* renamed from: getIcon */
    public Drawable m2586getIcon() {
        return this.f2445qdMbNW;
    }

    public int getIconGravity() {
        return this.f2442fehf;
    }

    public int getIconPadding() {
        return this.f2440YoKzxo;
    }

    public int getIconSize() {
        return this.f2435ETF;
    }

    public ColorStateList getIconTint() {
        return this.f2443lgHUyS;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f2447xJ;
    }

    public int getInsetBottom() {
        return this.f2441ZfxDd.m8388wA();
    }

    public int getInsetTop() {
        return this.f2441ZfxDd.m8375ZfxDd();
    }

    public ColorStateList getRippleColor() {
        if (m2583JHa()) {
            return this.f2441ZfxDd.m8381lgHUyS();
        }
        return null;
    }

    public C2141I6 getShapeAppearanceModel() {
        if (m2583JHa()) {
            return this.f2441ZfxDd.m8385qdMbNW();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (m2583JHa()) {
            return this.f2441ZfxDd.m8359Dt();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (m2583JHa()) {
            return this.f2441ZfxDd.m8360ETF();
        }
        return 0;
    }

    @Override // p131o.AbstractC4248nxI
    public ColorStateList getSupportBackgroundTintList() {
        return m2583JHa() ? this.f2441ZfxDd.m8372VA() : super.getSupportBackgroundTintList();
    }

    @Override // p131o.AbstractC4248nxI
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return m2583JHa() ? this.f2441ZfxDd.m8367MiMN() : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f2446rkYL;
    }

    /* renamed from: lgHUyS */
    public final void m2587lgHUyS(boolean z) {
        Drawable drawable = this.f2445qdMbNW;
        if (drawable != null) {
            Drawable drawableMutate = AbstractC4332pCk.m13077VA(drawable).mutate();
            this.f2445qdMbNW = drawableMutate;
            AbstractC4332pCk.m13081qdMbNW(drawableMutate, this.f2443lgHUyS);
            PorterDuff.Mode mode = this.f2447xJ;
            if (mode != null) {
                AbstractC4332pCk.m13073Dt(this.f2445qdMbNW, mode);
            }
            int intrinsicWidth = this.f2435ETF;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.f2445qdMbNW.getIntrinsicWidth();
            }
            int intrinsicHeight = this.f2435ETF;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.f2445qdMbNW.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f2445qdMbNW;
            int i = this.f2439VA;
            int i2 = this.f2438MiMN;
            drawable2.setBounds(i, i2, intrinsicWidth + i, intrinsicHeight + i2);
            this.f2445qdMbNW.setVisible(true, z);
        }
        if (z) {
            m2592xJ();
            return;
        }
        Drawable[] drawableArrM12667mjFkc = AbstractC4065l8.m12667mjFkc(this);
        Drawable drawable3 = drawableArrM12667mjFkc[0];
        Drawable drawable4 = drawableArrM12667mjFkc[1];
        Drawable drawable5 = drawableArrM12667mjFkc[2];
        if ((!m2591wA() || drawable3 == this.f2445qdMbNW) && ((!m2582AZxh() || drawable5 == this.f2445qdMbNW) && (!m2585ZfxDd() || drawable4 == this.f2445qdMbNW))) {
            return;
        }
        m2592xJ();
    }

    /* renamed from: mjFkc */
    public boolean m2588mjFkc() {
        C2004G1 c2004g1 = this.f2441ZfxDd;
        return c2004g1 != null && c2004g1.m8384qGY();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (m2583JHa()) {
            AbstractC2607P1.m9940JHa(this, this.f2441ZfxDd.m8364JHa());
        }
    }

    @Override // android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (m2588mjFkc()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f2431IEE);
        }
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f2432Pq);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // p131o.AbstractC4248nxI, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // p131o.AbstractC4248nxI, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(m2588mjFkc());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // p131o.AbstractC4248nxI, android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m2589qdMbNW(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C0237AZxh)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0237AZxh c0237AZxh = (C0237AZxh) parcelable;
        super.onRestoreInstanceState(c0237AZxh.m13824mjFkc());
        setChecked(c0237AZxh.f2449wA);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        C0237AZxh c0237AZxh = new C0237AZxh(super.onSaveInstanceState());
        c0237AZxh.f2449wA = this.f2446rkYL;
        return c0237AZxh;
    }

    @Override // p131o.AbstractC4248nxI, android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        m2589qdMbNW(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.f2441ZfxDd.m8378fehf()) {
            toggle();
        }
        return super.performClick();
    }

    /* renamed from: qdMbNW */
    public final void m2589qdMbNW(int i, int i2) {
        if (this.f2445qdMbNW == null || getLayout() == null) {
            return;
        }
        if (!m2591wA() && !m2582AZxh()) {
            if (m2585ZfxDd()) {
                this.f2439VA = 0;
                if (this.f2442fehf == 16) {
                    this.f2438MiMN = 0;
                    m2587lgHUyS(false);
                    return;
                }
                int intrinsicHeight = this.f2435ETF;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.f2445qdMbNW.getIntrinsicHeight();
                }
                int iMax = Math.max(0, (((((i2 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.f2440YoKzxo) - getPaddingBottom()) / 2);
                if (this.f2438MiMN != iMax) {
                    this.f2438MiMN = iMax;
                    m2587lgHUyS(false);
                    return;
                }
                return;
            }
            return;
        }
        this.f2438MiMN = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i3 = this.f2442fehf;
        if (i3 == 1 || i3 == 3 || ((i3 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i3 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.f2439VA = 0;
            m2587lgHUyS(false);
            return;
        }
        int intrinsicWidth = this.f2435ETF;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.f2445qdMbNW.getIntrinsicWidth();
        }
        int textLayoutWidth = ((((i - getTextLayoutWidth()) - AbstractC2876T9.m10257VocHEe(this)) - intrinsicWidth) - this.f2440YoKzxo) - AbstractC2876T9.m10224BAnRFn(this);
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            textLayoutWidth /= 2;
        }
        if (m2584KLFTb() != (this.f2442fehf == 4)) {
            textLayoutWidth = -textLayoutWidth;
        }
        if (this.f2439VA != textLayoutWidth) {
            this.f2439VA = textLayoutWidth;
            m2587lgHUyS(false);
        }
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f2445qdMbNW != null) {
            if (this.f2445qdMbNW.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public void setA11yClassName(String str) {
        this.f2434Dt = str;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (m2583JHa()) {
            this.f2441ZfxDd.m8370Pq(i);
        } else {
            super.setBackgroundColor(i);
        }
    }

    @Override // p131o.AbstractC4248nxI, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!m2583JHa()) {
            super.setBackgroundDrawable(drawable);
        } else {
            if (drawable == getBackground()) {
                getBackground().setState(drawable.getState());
                return;
            }
            Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
            this.f2441ZfxDd.m8376diqgf();
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // p131o.AbstractC4248nxI, android.view.View
    public void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? AbstractC4768vjlshU.m13794AZxh(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (m2583JHa()) {
            this.f2441ZfxDd.m8377eyqo(z);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (m2588mjFkc() && isEnabled() && this.f2446rkYL != z) {
            this.f2446rkYL = z;
            refreshDrawableState();
            if (getParent() instanceof MaterialButtonToggleGroup) {
                ((MaterialButtonToggleGroup) getParent()).m2606MiMN(this, this.f2446rkYL);
            }
            if (this.f2444qGY) {
                return;
            }
            this.f2444qGY = true;
            Iterator it = this.f2437KLFTb.iterator();
            if (it.hasNext()) {
                AbstractC4793w7.m13819mjFkc(it.next());
                throw null;
            }
            this.f2444qGY = false;
        }
    }

    public void setCornerRadius(int i) {
        if (m2583JHa()) {
            this.f2441ZfxDd.m8371Ucbh(i);
        }
    }

    public void setCornerRadiusResource(int i) {
        if (m2583JHa()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        if (m2583JHa()) {
            this.f2441ZfxDd.m8364JHa().m9801GMIER(f);
        }
    }

    /* renamed from: setIcon */
    public void m2590setIcon(Drawable drawable) {
        if (this.f2445qdMbNW != drawable) {
            this.f2445qdMbNW = drawable;
            m2587lgHUyS(true);
            m2589qdMbNW(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i) {
        if (this.f2442fehf != i) {
            this.f2442fehf = i;
            m2589qdMbNW(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i) {
        if (this.f2440YoKzxo != i) {
            this.f2440YoKzxo = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(int i) {
        m2590setIcon(i != 0 ? AbstractC4768vjlshU.m13794AZxh(getContext(), i) : null);
    }

    public void setIconSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.f2435ETF != i) {
            this.f2435ETF = i;
            m2587lgHUyS(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f2443lgHUyS != colorStateList) {
            this.f2443lgHUyS = colorStateList;
            m2587lgHUyS(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f2447xJ != mode) {
            this.f2447xJ = mode;
            m2587lgHUyS(false);
        }
    }

    public void setIconTintResource(int i) {
        setIconTint(AbstractC4768vjlshU.m13795mjFkc(getContext(), i));
    }

    public void setInsetBottom(int i) {
        this.f2441ZfxDd.m8379huTpC(i);
    }

    public void setInsetTop(int i) {
        this.f2441ZfxDd.m8361Gd(i);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(InterfaceC0238mjFkc interfaceC0238mjFkc) {
        this.f2436JHa = interfaceC0238mjFkc;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        InterfaceC0238mjFkc interfaceC0238mjFkc = this.f2436JHa;
        if (interfaceC0238mjFkc != null) {
            interfaceC0238mjFkc.mo2597mjFkc(this, z);
        }
        super.setPressed(z);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (m2583JHa()) {
            this.f2441ZfxDd.m8362HGpJ(colorStateList);
        }
    }

    public void setRippleColorResource(int i) {
        if (m2583JHa()) {
            setRippleColor(AbstractC4768vjlshU.m13795mjFkc(getContext(), i));
        }
    }

    @Override // p131o.InterfaceC2350L6
    public void setShapeAppearanceModel(C2141I6 c2141i6) {
        if (!m2583JHa()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.f2441ZfxDd.m8387vI(c2141i6);
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (m2583JHa()) {
            this.f2441ZfxDd.m8373VocHEe(z);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (m2583JHa()) {
            this.f2441ZfxDd.m8357BAnRFn(colorStateList);
        }
    }

    public void setStrokeColorResource(int i) {
        if (m2583JHa()) {
            setStrokeColor(AbstractC4768vjlshU.m13795mjFkc(getContext(), i));
        }
    }

    public void setStrokeWidth(int i) {
        if (m2583JHa()) {
            this.f2441ZfxDd.m8380lB(i);
        }
    }

    public void setStrokeWidthResource(int i) {
        if (m2583JHa()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // p131o.AbstractC4248nxI
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (m2583JHa()) {
            this.f2441ZfxDd.m8389wJVbdd(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // p131o.AbstractC4248nxI
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (m2583JHa()) {
            this.f2441ZfxDd.m8382mByQ(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i) {
        super.setTextAlignment(i);
        m2589qdMbNW(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean z) {
        this.f2441ZfxDd.m8369OjSQV(z);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f2446rkYL);
    }

    /* renamed from: wA */
    public final boolean m2591wA() {
        int i = this.f2442fehf;
        return i == 1 || i == 2;
    }

    /* renamed from: xJ */
    public final void m2592xJ() {
        if (m2591wA()) {
            AbstractC4065l8.m12666lgHUyS(this, this.f2445qdMbNW, null, null, null);
        } else if (m2582AZxh()) {
            AbstractC4065l8.m12666lgHUyS(this, null, null, this.f2445qdMbNW, null);
        } else if (m2585ZfxDd()) {
            AbstractC4065l8.m12666lgHUyS(this, null, this.f2445qdMbNW, null, null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButton(Context context, AttributeSet attributeSet, int i) {
        int i2 = f2433diqgf;
        super(AbstractC2734R1.m10039wA(context, attributeSet, i, i2), attributeSet, i);
        this.f2437KLFTb = new LinkedHashSet();
        this.f2446rkYL = false;
        this.f2444qGY = false;
        Context context2 = getContext();
        TypedArray typedArrayM12940lgHUyS = AbstractC4260o8.m12940lgHUyS(context2, attributeSet, AbstractC3340a5.f12450QyMqpM, i, i2, new int[0]);
        this.f2440YoKzxo = typedArrayM12940lgHUyS.getDimensionPixelSize(AbstractC3340a5.f12471TvfBiy, 0);
        this.f2447xJ = AbstractC4557sa.m13502JHa(typedArrayM12940lgHUyS.getInt(AbstractC3340a5.f12695xfXeiC, -1), PorterDuff.Mode.SRC_IN);
        this.f2443lgHUyS = AbstractC2478N1.m9577mjFkc(getContext(), typedArrayM12940lgHUyS, AbstractC3340a5.f12460Rsp);
        this.f2445qdMbNW = AbstractC2478N1.m9578wA(getContext(), typedArrayM12940lgHUyS, AbstractC3340a5.f12527aDq);
        this.f2442fehf = typedArrayM12940lgHUyS.getInteger(AbstractC3340a5.f12675vZ, 1);
        this.f2435ETF = typedArrayM12940lgHUyS.getDimensionPixelSize(AbstractC3340a5.f12337CqAnRZ, 0);
        C2004G1 c2004g1 = new C2004G1(this, C2141I6.m8658KLFTb(context2, attributeSet, i, i2).m8698MiMN());
        this.f2441ZfxDd = c2004g1;
        c2004g1.m8363IEE(typedArrayM12940lgHUyS);
        typedArrayM12940lgHUyS.recycle();
        setCompoundDrawablePadding(this.f2440YoKzxo);
        m2587lgHUyS(this.f2445qdMbNW != null);
    }
}
