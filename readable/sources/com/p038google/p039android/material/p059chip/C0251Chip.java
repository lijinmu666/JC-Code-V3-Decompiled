package com.p038google.p039android.material.p059chip;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.p038google.p039android.material.p059chip.C0252mjFkc;
import java.util.List;
import org.conscrypt.BuildConfig;
import p131o.AbstractC1735C5;
import p131o.AbstractC1919EqDGZ;
import p131o.AbstractC2481N4;
import p131o.AbstractC2607P1;
import p131o.AbstractC2734R1;
import p131o.AbstractC2737R4;
import p131o.AbstractC2876T9;
import p131o.AbstractC3085WGXroI;
import p131o.AbstractC3139X7;
import p131o.AbstractC3340a5;
import p131o.AbstractC3800h4;
import p131o.AbstractC4260o8;
import p131o.AbstractC4557sa;
import p131o.C2141I6;
import p131o.C2971Ucbh;
import p131o.C3008V7;
import p131o.C4788w2;
import p131o.InterfaceC2278K1;
import p131o.InterfaceC2350L6;

/* renamed from: com.google.android.material.chip.Chip */
/* loaded from: classes.dex */
public class C0251Chip extends AbstractC3085WGXroI implements C0252mjFkc.mjFkc, InterfaceC2350L6, Checkable {

    /* renamed from: Dt */
    public boolean f2524Dt;

    /* renamed from: ETF */
    public boolean f2525ETF;

    /* renamed from: IEE */
    public final wA f2526IEE;

    /* renamed from: JHa */
    public InsetDrawable f2527JHa;

    /* renamed from: KLFTb */
    public C0252mjFkc f2528KLFTb;

    /* renamed from: MiMN */
    public boolean f2529MiMN;

    /* renamed from: Pq */
    public boolean f2530Pq;

    /* renamed from: Ucbh */
    public final AbstractC3139X7 f2531Ucbh;

    /* renamed from: VA */
    public boolean f2532VA;

    /* renamed from: YoKzxo */
    public boolean f2533YoKzxo;

    /* renamed from: diqgf */
    public final Rect f2534diqgf;

    /* renamed from: eyqo */
    public final RectF f2535eyqo;

    /* renamed from: fehf */
    public CharSequence f2536fehf;

    /* renamed from: lgHUyS */
    public View.OnClickListener f2537lgHUyS;

    /* renamed from: qGY */
    public int f2538qGY;

    /* renamed from: qdMbNW */
    public CompoundButton.OnCheckedChangeListener f2539qdMbNW;

    /* renamed from: rkYL */
    public int f2540rkYL;

    /* renamed from: xJ */
    public RippleDrawable f2541xJ;

    /* renamed from: huTpC */
    public static final int f2522huTpC = AbstractC2737R4.f10364Dt;

    /* renamed from: Gd */
    public static final Rect f2520Gd = new Rect();

    /* renamed from: HGpJ */
    public static final int[] f2521HGpJ = {R.attr.state_selected};

    /* renamed from: vI */
    public static final int[] f2523vI = {R.attr.state_checkable};

    /* renamed from: com.google.android.material.chip.Chip$AZxh */
    public class AZxh extends ViewOutlineProvider {
        public AZxh() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (C0251Chip.this.f2528KLFTb != null) {
                C0251Chip.this.f2528KLFTb.getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    /* renamed from: com.google.android.material.chip.Chip$mjFkc */
    public class mjFkc extends AbstractC3139X7 {
        public mjFkc() {
        }

        @Override // p131o.AbstractC3139X7
        /* renamed from: AZxh */
        public void mo2738AZxh(Typeface typeface, boolean z) {
            C0251Chip c0251Chip = C0251Chip.this;
            c0251Chip.setText(c0251Chip.f2528KLFTb.m2817ZGL() ? C0251Chip.this.f2528KLFTb.m2845mPWV() : C0251Chip.this.getText());
            C0251Chip.this.requestLayout();
            C0251Chip.this.invalidate();
        }

        @Override // p131o.AbstractC3139X7
        /* renamed from: mjFkc */
        public void mo2739mjFkc(int i) {
        }
    }

    /* renamed from: com.google.android.material.chip.Chip$wA */
    public class wA extends AbstractC1919EqDGZ {
        public wA(C0251Chip c0251Chip) {
            super(c0251Chip);
        }

        @Override // p131o.AbstractC1919EqDGZ
        /* renamed from: BAnRFn */
        public int mo2740BAnRFn(float f, float f2) {
            return (C0251Chip.this.m2727YoKzxo() && C0251Chip.this.getCloseIconTouchBounds().contains(f, f2)) ? 1 : 0;
        }

        @Override // p131o.AbstractC1919EqDGZ
        /* renamed from: KLMXS */
        public boolean mo2741KLMXS(int i, int i2, Bundle bundle) {
            if (i2 != 16) {
                return false;
            }
            if (i == 0) {
                return C0251Chip.this.performClick();
            }
            if (i == 1) {
                return C0251Chip.this.m2729eyqo();
            }
            return false;
        }

        @Override // p131o.AbstractC1919EqDGZ
        /* renamed from: NPj */
        public void mo2742NPj(int i, boolean z) {
            if (i == 1) {
                C0251Chip.this.f2529MiMN = z;
                C0251Chip.this.refreshDrawableState();
            }
        }

        @Override // p131o.AbstractC1919EqDGZ
        /* renamed from: Vnb */
        public void mo2743Vnb(int i, C2971Ucbh c2971Ucbh) {
            CharSequence charSequence = BuildConfig.f24315FLAVOR;
            if (i != 1) {
                c2971Ucbh.m10583jm(BuildConfig.f24315FLAVOR);
                c2971Ucbh.m10544JrJO(C0251Chip.f2520Gd);
                return;
            }
            CharSequence closeIconContentDescription = C0251Chip.this.getCloseIconContentDescription();
            if (closeIconContentDescription != null) {
                c2971Ucbh.m10583jm(closeIconContentDescription);
            } else {
                CharSequence text = C0251Chip.this.getText();
                Context context = C0251Chip.this.getContext();
                int i2 = AbstractC2481N4.f9648lgHUyS;
                if (!TextUtils.isEmpty(text)) {
                    charSequence = text;
                }
                c2971Ucbh.m10583jm(context.getString(i2, charSequence).trim());
            }
            c2971Ucbh.m10544JrJO(C0251Chip.this.getCloseIconTouchBoundsInt());
            c2971Ucbh.m10531AZxh(C2971Ucbh.mjFkc.f10892qdMbNW);
            c2971Ucbh.m10570alEkx(C0251Chip.this.isEnabled());
        }

        @Override // p131o.AbstractC1919EqDGZ
        /* renamed from: lB */
        public void mo2744lB(List list) {
            list.add(0);
            if (C0251Chip.this.m2727YoKzxo() && C0251Chip.this.m2723Pq() && C0251Chip.this.f2537lgHUyS != null) {
                list.add(1);
            }
        }

        @Override // p131o.AbstractC1919EqDGZ
        /* renamed from: rWxwaT */
        public void mo2745rWxwaT(C2971Ucbh c2971Ucbh) {
            c2971Ucbh.m10564WGXroI(C0251Chip.this.m2721IEE());
            c2971Ucbh.m10558SwgkN(C0251Chip.this.isClickable());
            c2971Ucbh.m10572bbzow(C0251Chip.this.getAccessibilityClassName());
            c2971Ucbh.m10547LREOK(C0251Chip.this.getText());
        }
    }

    public C0251Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC3800h4.f13920AZxh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.f2535eyqo.setEmpty();
        if (m2727YoKzxo() && this.f2537lgHUyS != null) {
            this.f2528KLFTb.m2840jtz(this.f2535eyqo);
        }
        return this.f2535eyqo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.f2534diqgf.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.f2534diqgf;
    }

    private C3008V7 getTextAppearance() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            return c0252mjFkc.m2825dkKKW();
        }
        return null;
    }

    private void setCloseIconHovered(boolean z) {
        if (this.f2532VA != z) {
            this.f2532VA = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.f2525ETF != z) {
            this.f2525ETF = z;
            refreshDrawableState();
        }
    }

    /* renamed from: BAnRFn */
    public final void m2716BAnRFn() {
        C0252mjFkc c0252mjFkc;
        if (TextUtils.isEmpty(getText()) || (c0252mjFkc = this.f2528KLFTb) == null) {
            return;
        }
        int iM2807Vgyli = (int) (c0252mjFkc.m2807Vgyli() + this.f2528KLFTb.m2787NV() + this.f2528KLFTb.m2771IVlxe());
        int iM2835gtr = (int) (this.f2528KLFTb.m2835gtr() + this.f2528KLFTb.m2775Jidt() + this.f2528KLFTb.m2864tQ());
        if (this.f2527JHa != null) {
            Rect rect = new Rect();
            this.f2527JHa.getPadding(rect);
            iM2835gtr += rect.left;
            iM2807Vgyli += rect.right;
        }
        AbstractC2876T9.m10274gYa(this, iM2835gtr, getPaddingTop(), iM2807Vgyli, getPaddingBottom());
    }

    /* renamed from: Dt */
    public final void m2717Dt(C0252mjFkc c0252mjFkc) {
        c0252mjFkc.m2816XyP(this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    /* renamed from: ETF */
    public final int[] m2718ETF() {
        ?? IsEnabled = isEnabled();
        int i = IsEnabled;
        if (this.f2529MiMN) {
            i = IsEnabled + 1;
        }
        int i2 = i;
        if (this.f2532VA) {
            i2 = i + 1;
        }
        int i3 = i2;
        if (this.f2525ETF) {
            i3 = i2 + 1;
        }
        int i4 = i3;
        if (isChecked()) {
            i4 = i3 + 1;
        }
        int[] iArr = new int[i4];
        int i5 = 0;
        if (isEnabled()) {
            iArr[0] = 16842910;
            i5 = 1;
        }
        if (this.f2529MiMN) {
            iArr[i5] = 16842908;
            i5++;
        }
        if (this.f2532VA) {
            iArr[i5] = 16843623;
            i5++;
        }
        if (this.f2525ETF) {
            iArr[i5] = 16842919;
            i5++;
        }
        if (isChecked()) {
            iArr[i5] = 16842913;
        }
        return iArr;
    }

    /* renamed from: Gd */
    public final void m2719Gd(C0252mjFkc c0252mjFkc) {
        if (c0252mjFkc != null) {
            c0252mjFkc.m2816XyP(null);
        }
    }

    /* renamed from: HGpJ */
    public final void m2720HGpJ() {
        if (m2727YoKzxo() && m2723Pq() && this.f2537lgHUyS != null) {
            AbstractC2876T9.m10265alEkx(this, this.f2526IEE);
            this.f2530Pq = true;
        } else {
            AbstractC2876T9.m10265alEkx(this, null);
            this.f2530Pq = false;
        }
    }

    /* renamed from: IEE */
    public boolean m2721IEE() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        return c0252mjFkc != null && c0252mjFkc.m2883ybBTr();
    }

    /* renamed from: MiMN */
    public final void m2722MiMN() {
        if (getBackgroundDrawable() == this.f2527JHa && this.f2528KLFTb.getCallback() == null) {
            this.f2528KLFTb.setCallback(this.f2527JHa);
        }
    }

    /* renamed from: Pq */
    public boolean m2723Pq() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        return c0252mjFkc != null && c0252mjFkc.m2852oaI();
    }

    /* renamed from: Ucbh */
    public final void m2724Ucbh() {
        if (this.f2527JHa != null) {
            this.f2527JHa = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            m2736vI();
        }
    }

    /* renamed from: VA */
    public boolean m2725VA(int i) {
        this.f2538qGY = i;
        if (!m2731huTpC()) {
            if (this.f2527JHa != null) {
                m2724Ucbh();
            } else {
                m2736vI();
            }
            return false;
        }
        int iMax = Math.max(0, i - this.f2528KLFTb.getIntrinsicHeight());
        int iMax2 = Math.max(0, i - this.f2528KLFTb.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            if (this.f2527JHa != null) {
                m2724Ucbh();
            } else {
                m2736vI();
            }
            return false;
        }
        int i2 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i3 = iMax > 0 ? iMax / 2 : 0;
        if (this.f2527JHa != null) {
            Rect rect = new Rect();
            this.f2527JHa.getPadding(rect);
            if (rect.top == i3 && rect.bottom == i3 && rect.left == i2 && rect.right == i2) {
                m2736vI();
                return true;
            }
        }
        if (getMinHeight() != i) {
            setMinHeight(i);
        }
        if (getMinWidth() != i) {
            setMinWidth(i);
        }
        m2730fehf(i2, i3, i2, i3);
        m2736vI();
        return true;
    }

    /* renamed from: VocHEe */
    public final void m2726VocHEe() {
        this.f2541xJ = new RippleDrawable(AbstractC1735C5.m7750mjFkc(this.f2528KLFTb.m2776Jk()), getBackgroundDrawable(), null);
        this.f2528KLFTb.m2762Es(false);
        AbstractC2876T9.m10294vjlshU(this, this.f2541xJ);
        m2716BAnRFn();
    }

    /* renamed from: YoKzxo */
    public final boolean m2727YoKzxo() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        return (c0252mjFkc == null || c0252mjFkc.m2836hvGY() == null) ? false : true;
    }

    /* renamed from: diqgf */
    public final /* synthetic */ void m2728diqgf(CompoundButton compoundButton, boolean z) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.f2539qdMbNW;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(compoundButton, z);
        }
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return !this.f2530Pq ? super.dispatchHoverEvent(motionEvent) : this.f2526IEE.m8199Ucbh(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f2530Pq) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (!this.f2526IEE.m8208huTpC(keyEvent) || this.f2526IEE.m8200VocHEe() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    @Override // p131o.AbstractC3085WGXroI, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if ((c0252mjFkc == null || !c0252mjFkc.m2860sqndV()) ? false : this.f2528KLFTb.m2786Mpf(m2718ETF())) {
            invalidate();
        }
    }

    /* renamed from: eyqo */
    public boolean m2729eyqo() {
        boolean z = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f2537lgHUyS;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z = true;
        }
        if (this.f2530Pq) {
            this.f2526IEE.m8192GMIER(1, 1);
        }
        return z;
    }

    /* renamed from: fehf */
    public final void m2730fehf(int i, int i2, int i3, int i4) {
        this.f2527JHa = new InsetDrawable((Drawable) this.f2528KLFTb, i, i2, i3, i4);
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.f2536fehf)) {
            return this.f2536fehf;
        }
        if (!m2721IEE()) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        getParent();
        return "android.widget.Button";
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f2527JHa;
        return insetDrawable == null ? this.f2528KLFTb : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            return c0252mjFkc.m2814XtE();
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            return c0252mjFkc.m2841jx();
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            return c0252mjFkc.m2867uH();
        }
        return null;
    }

    public float getChipCornerRadius() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            return Math.max(0.0f, c0252mjFkc.m2862tISON());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f2528KLFTb;
    }

    public float getChipEndPadding() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            return c0252mjFkc.m2807Vgyli();
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            return c0252mjFkc.m2844lti();
        }
        return null;
    }

    public float getChipIconSize() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            return c0252mjFkc.m2833giT();
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            return c0252mjFkc.m2859sRqPfw();
        }
        return null;
    }

    public float getChipMinHeight() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            return c0252mjFkc.m2809XD();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            return c0252mjFkc.m2835gtr();
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            return c0252mjFkc.m2758Dp();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            return c0252mjFkc.m2830fLidf();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            return c0252mjFkc.m2836hvGY();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            return c0252mjFkc.m2794Rc();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            return c0252mjFkc.m2796SKTn();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            return c0252mjFkc.m2858rdJr();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            return c0252mjFkc.m2810XDdeP();
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            return c0252mjFkc.m2764FbxKQm();
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            return c0252mjFkc.m2861tAfC();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        if (this.f2530Pq && (this.f2526IEE.m8200VocHEe() == 1 || this.f2526IEE.m8193Gd() == 1)) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public C4788w2 getHideMotionSpec() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            return c0252mjFkc.m2824dGDT();
        }
        return null;
    }

    public float getIconEndPadding() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            return c0252mjFkc.m2815Xxz();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            return c0252mjFkc.m2818Zdbk();
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            return c0252mjFkc.m2776Jk();
        }
        return null;
    }

    public C2141I6 getShapeAppearanceModel() {
        return this.f2528KLFTb.m9833lB();
    }

    public C4788w2 getShowMotionSpec() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            return c0252mjFkc.m2777KRckQg();
        }
        return null;
    }

    public float getTextEndPadding() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            return c0252mjFkc.m2787NV();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            return c0252mjFkc.m2775Jidt();
        }
        return 0.0f;
    }

    /* renamed from: huTpC */
    public boolean m2731huTpC() {
        return this.f2533YoKzxo;
    }

    /* renamed from: lB */
    public final void m2732lB() {
        TextPaint paint = getPaint();
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            paint.drawableState = c0252mjFkc.getState();
        }
        C3008V7 textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.m10672YoKzxo(getContext(), paint, this.f2531Ucbh);
        }
    }

    @Override // com.p038google.p039android.material.p059chip.C0252mjFkc.mjFkc
    /* renamed from: mjFkc */
    public void mo2733mjFkc() {
        m2725VA(this.f2538qGY);
        requestLayout();
        invalidateOutline();
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AbstractC2607P1.m9940JHa(this, this.f2528KLFTb);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f2521HGpJ);
        }
        if (m2721IEE()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f2523vI);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (this.f2530Pq) {
            this.f2526IEE.m8216xrEuO(z, i, rect);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        accessibilityNodeInfo.setCheckable(m2721IEE());
        accessibilityNodeInfo.setClickable(isClickable());
        getParent();
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), 1002);
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (this.f2540rkYL != i) {
            this.f2540rkYL = i;
            m2716BAnRFn();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r0 != 3) goto L22;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int actionMasked = motionEvent.getActionMasked();
        boolean zContains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.f2525ETF) {
                        if (!zContains) {
                            setCloseIconPressed(false);
                        }
                        z = true;
                    }
                }
                z = false;
            } else {
                if (this.f2525ETF) {
                    m2729eyqo();
                    z = true;
                }
                setCloseIconPressed(false);
            }
            z = false;
            setCloseIconPressed(false);
        } else {
            if (zContains) {
                setCloseIconPressed(true);
                z = true;
            }
            z = false;
        }
        return z || super.onTouchEvent(motionEvent);
    }

    /* renamed from: qGY */
    public final void m2734qGY() {
        setOutlineProvider(new AZxh());
    }

    /* renamed from: rkYL */
    public final void m2735rkYL(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayM12940lgHUyS = AbstractC4260o8.m12940lgHUyS(context, attributeSet, AbstractC3340a5.f12496WGXroI, i, f2522huTpC, new int[0]);
        this.f2533YoKzxo = typedArrayM12940lgHUyS.getBoolean(AbstractC3340a5.f12655tISON, false);
        this.f2538qGY = (int) Math.ceil(typedArrayM12940lgHUyS.getDimension(AbstractC3340a5.f12569gtIJp, (float) Math.ceil(AbstractC4557sa.m13501AZxh(getContext(), 48))));
        typedArrayM12940lgHUyS.recycle();
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.f2536fehf = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f2541xJ) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // p131o.AbstractC3085WGXroI, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f2541xJ) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // p131o.AbstractC3085WGXroI, android.view.View
    public void setBackgroundResource(int i) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2765Fztqa(z);
        }
    }

    public void setCheckableResource(int i) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2847mzUGzO(i);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc == null) {
            this.f2524Dt = z;
        } else if (c0252mjFkc.m2883ybBTr()) {
            super.setChecked(z);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2806VfB(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i) {
        setCheckedIconVisible(i);
    }

    public void setCheckedIconResource(int i) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2769Htq(i);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2754BxruE(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2802Tw(i);
        }
    }

    public void setCheckedIconVisible(int i) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2792QyqF(i);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2848nUaNy(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int i) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2868ub(i);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2876xCVa(f);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2822bc(i);
        }
    }

    public void setChipDrawable(C0252mjFkc c0252mjFkc) {
        C0252mjFkc c0252mjFkc2 = this.f2528KLFTb;
        if (c0252mjFkc2 != c0252mjFkc) {
            m2719Gd(c0252mjFkc2);
            this.f2528KLFTb = c0252mjFkc;
            c0252mjFkc.m2752ArO(false);
            m2717Dt(this.f2528KLFTb);
            m2725VA(this.f2538qGY);
        }
    }

    public void setChipEndPadding(float f) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2874wLtdyQ(f);
        }
    }

    public void setChipEndPaddingResource(int i) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2881yP(i);
        }
    }

    public void setChipIcon(Drawable drawable) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2869ui(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i) {
        setChipIconVisible(i);
    }

    public void setChipIconResource(int i) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2866tpGcn(i);
        }
    }

    public void setChipIconSize(float f) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2855qGgY(f);
        }
    }

    public void setChipIconSizeResource(int i) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2870vUsV(i);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2763FOJ(colorStateList);
        }
    }

    public void setChipIconTintResource(int i) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2759ERt(i);
        }
    }

    public void setChipIconVisible(int i) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2774JOe(i);
        }
    }

    public void setChipMinHeight(float f) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2849np(f);
        }
    }

    public void setChipMinHeightResource(int i) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2791QyMqpM(i);
        }
    }

    public void setChipStartPadding(float f) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2766HExgdj(f);
        }
    }

    public void setChipStartPaddingResource(int i) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2778KSf(i);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2808Vptz(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2856qrxT(i);
        }
    }

    public void setChipStrokeWidth(float f) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2756CcoH(f);
        }
    }

    public void setChipStrokeWidthResource(int i) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2767HX(i);
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i) {
        setText(getResources().getString(i));
    }

    public void setCloseIcon(Drawable drawable) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2879xbjHT(drawable);
        }
        m2720HGpJ();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2885zPp(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i) {
        setCloseIconVisible(i);
    }

    public void setCloseIconEndPadding(float f) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2783MC(f);
        }
    }

    public void setCloseIconEndPaddingResource(int i) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2819aDq(i);
        }
    }

    public void setCloseIconResource(int i) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2871vZ(i);
        }
        m2720HGpJ();
    }

    public void setCloseIconSize(float f) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2801TvfBiy(f);
        }
    }

    public void setCloseIconSizeResource(int i) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2757CqAnRZ(i);
        }
    }

    public void setCloseIconStartPadding(float f) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2795Rsp(f);
        }
    }

    public void setCloseIconStartPaddingResource(int i) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2880xfXeiC(i);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2768Hk(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2850oJ(i);
        }
    }

    public void setCloseIconVisible(int i) {
        setCloseIconVisible(getResources().getBoolean(i));
    }

    @Override // p131o.AbstractC3085WGXroI, android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // p131o.AbstractC3085WGXroI, android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m9801GMIER(f);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f2528KLFTb == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2803UDcil(truncateAt);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        this.f2533YoKzxo = z;
        m2725VA(this.f2538qGY);
    }

    @Override // android.widget.TextView
    public void setGravity(int i) {
        if (i != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i);
        }
    }

    public void setHideMotionSpec(C4788w2 c4788w2) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2838jY(c4788w2);
        }
    }

    public void setHideMotionSpecResource(int i) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2804UOnCkw(i);
        }
    }

    public void setIconEndPadding(float f) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2799Sx(f);
        }
    }

    public void setIconEndPaddingResource(int i) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2854peCqC(i);
        }
    }

    public void setIconStartPadding(float f) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2873wGscSa(f);
        }
    }

    public void setIconStartPaddingResource(int i) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2863tPvjn(i);
        }
    }

    public void setInternalOnCheckedChangeListener(InterfaceC2278K1 interfaceC2278K1) {
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        if (this.f2528KLFTb == null) {
            return;
        }
        super.setLayoutDirection(i);
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i) {
        super.setMaxWidth(i);
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2800TFbkuO(i);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f2539qdMbNW = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f2537lgHUyS = onClickListener;
        m2720HGpJ();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2788Otxclu(colorStateList);
        }
        if (this.f2528KLFTb.m2751APn()) {
            return;
        }
        m2726VocHEe();
    }

    public void setRippleColorResource(int i) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2789OzIs(i);
            if (this.f2528KLFTb.m2751APn()) {
                return;
            }
            m2726VocHEe();
        }
    }

    @Override // p131o.InterfaceC2350L6
    public void setShapeAppearanceModel(C2141I6 c2141i6) {
        this.f2528KLFTb.setShapeAppearanceModel(c2141i6);
    }

    public void setShowMotionSpec(C4788w2 c4788w2) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2793RWb(c4788w2);
        }
    }

    public void setShowMotionSpecResource(int i) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2837jTNPnW(i);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z) {
        if (!z) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = BuildConfig.f24315FLAVOR;
        }
        super.setText(c0252mjFkc.m2817ZGL() ? null : charSequence, bufferType);
        C0252mjFkc c0252mjFkc2 = this.f2528KLFTb;
        if (c0252mjFkc2 != null) {
            c0252mjFkc2.m2760EeoThB(charSequence);
        }
    }

    public void setTextAppearance(C3008V7 c3008v7) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2823cdjp(c3008v7);
        }
        m2732lB();
    }

    public void setTextAppearanceResource(int i) {
        setTextAppearance(getContext(), i);
    }

    public void setTextEndPadding(float f) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2784MFekjo(f);
        }
    }

    public void setTextEndPaddingResource(int i) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2805UPU(i);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        super.setTextSize(i, f);
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2770IPpyV(TypedValue.applyDimension(i, f, getResources().getDisplayMetrics()));
        }
        m2732lB();
    }

    public void setTextStartPadding(float f) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2842kOlLW(f);
        }
    }

    public void setTextStartPaddingResource(int i) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2781LlB(i);
        }
    }

    /* renamed from: vI */
    public final void m2736vI() {
        if (AbstractC1735C5.f7559mjFkc) {
            m2726VocHEe();
            return;
        }
        this.f2528KLFTb.m2762Es(true);
        AbstractC2876T9.m10294vjlshU(this, getBackgroundDrawable());
        m2716BAnRFn();
        m2722MiMN();
    }

    /* renamed from: wJVbdd */
    public final void m2737wJVbdd(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C0251Chip(Context context, AttributeSet attributeSet, int i) {
        int i2 = f2522huTpC;
        super(AbstractC2734R1.m10039wA(context, attributeSet, i, i2), attributeSet, i);
        this.f2534diqgf = new Rect();
        this.f2535eyqo = new RectF();
        this.f2531Ucbh = new mjFkc();
        Context context2 = getContext();
        m2737wJVbdd(attributeSet);
        C0252mjFkc c0252mjFkcM2746NKyg = C0252mjFkc.m2746NKyg(context2, attributeSet, i, i2);
        m2735rkYL(context2, attributeSet, i);
        setChipDrawable(c0252mjFkcM2746NKyg);
        c0252mjFkcM2746NKyg.m9801GMIER(AbstractC2876T9.m10231IEE(this));
        TypedArray typedArrayM12940lgHUyS = AbstractC4260o8.m12940lgHUyS(context2, attributeSet, AbstractC3340a5.f12496WGXroI, i, i2, new int[0]);
        boolean zHasValue = typedArrayM12940lgHUyS.hasValue(AbstractC3340a5.f12500XD);
        typedArrayM12940lgHUyS.recycle();
        this.f2526IEE = new wA(this);
        m2720HGpJ();
        if (!zHasValue) {
            m2734qGY();
        }
        setChecked(this.f2524Dt);
        setText(c0252mjFkcM2746NKyg.m2845mPWV());
        setEllipsize(c0252mjFkcM2746NKyg.m2861tAfC());
        m2732lB();
        if (!this.f2528KLFTb.m2817ZGL()) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        m2716BAnRFn();
        if (m2731huTpC()) {
            setMinHeight(this.f2538qGY);
        }
        this.f2540rkYL = AbstractC2876T9.m10276huTpC(this);
        super.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: o.np
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f15475mjFkc.m2728diqgf(compoundButton, z);
            }
        });
    }

    public void setCloseIconVisible(boolean z) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2821bWIyu(z);
        }
        m2720HGpJ();
    }

    public void setCheckedIconVisible(boolean z) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2782LsBneK(z);
        }
    }

    public void setChipIconVisible(boolean z) {
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2853pJeaSR(z);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2875xBQUgd(i);
        }
        m2732lB();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        super.setTextAppearance(i);
        C0252mjFkc c0252mjFkc = this.f2528KLFTb;
        if (c0252mjFkc != null) {
            c0252mjFkc.m2875xBQUgd(i);
        }
        m2732lB();
    }
}
