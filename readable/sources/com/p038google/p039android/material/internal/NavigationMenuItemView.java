package com.p038google.p039android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.p010view.p011menu.C0006KLFTb;
import androidx.appcompat.p010view.p011menu.InterfaceC0008lgHUyS;
import androidx.appcompat.p012widget.AbstractC0013AZxh;
import p131o.AbstractC1803D4;
import p131o.AbstractC2007G4;
import p131o.AbstractC2143I8;
import p131o.AbstractC2876T9;
import p131o.AbstractC3862i4;
import p131o.AbstractC4065l8;
import p131o.AbstractC4191n4;
import p131o.AbstractC4232niM;
import p131o.AbstractC4332pCk;
import p131o.AbstractC4458r4;
import p131o.AbstractC4592t5;
import p131o.C2454MiMN;
import p131o.C2971Ucbh;

/* loaded from: classes.dex */
public class NavigationMenuItemView extends AbstractC4232niM implements InterfaceC0008lgHUyS.mjFkc {

    /* renamed from: OjSQV */
    public static final int[] f2681OjSQV = {R.attr.state_checked};

    /* renamed from: BAnRFn */
    public ColorStateList f2682BAnRFn;

    /* renamed from: Gd */
    public boolean f2683Gd;

    /* renamed from: HGpJ */
    public final CheckedTextView f2684HGpJ;

    /* renamed from: Ucbh */
    public int f2685Ucbh;

    /* renamed from: VocHEe */
    public C0006KLFTb f2686VocHEe;

    /* renamed from: huTpC */
    public boolean f2687huTpC;

    /* renamed from: lB */
    public boolean f2688lB;

    /* renamed from: mByQ */
    public final C2454MiMN f2689mByQ;

    /* renamed from: vI */
    public FrameLayout f2690vI;

    /* renamed from: wJVbdd */
    public Drawable f2691wJVbdd;

    /* renamed from: com.google.android.material.internal.NavigationMenuItemView$mjFkc */
    public class C0260mjFkc extends C2454MiMN {
        public C0260mjFkc() {
        }

        @Override // p131o.C2454MiMN
        /* renamed from: xJ */
        public void mo620xJ(View view, C2971Ucbh c2971Ucbh) {
            super.mo620xJ(view, c2971Ucbh);
            c2971Ucbh.m10564WGXroI(NavigationMenuItemView.this.f2683Gd);
        }
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.f2690vI == null) {
                this.f2690vI = (FrameLayout) ((ViewStub) findViewById(AbstractC1803D4.f7807ZfxDd)).inflate();
            }
            this.f2690vI.removeAllViews();
            this.f2690vI.addView(view);
        }
    }

    /* renamed from: BAnRFn */
    public final StateListDrawable m2960BAnRFn() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(AbstractC3862i4.f14104ETF, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f2681OjSQV, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    /* renamed from: VocHEe */
    public final void m2961VocHEe() {
        if (m2962lB()) {
            this.f2684HGpJ.setVisibility(8);
            FrameLayout frameLayout = this.f2690vI;
            if (frameLayout != null) {
                AbstractC0013AZxh.mjFkc mjfkc = (AbstractC0013AZxh.mjFkc) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) mjfkc).width = -1;
                this.f2690vI.setLayoutParams(mjfkc);
                return;
            }
            return;
        }
        this.f2684HGpJ.setVisibility(0);
        FrameLayout frameLayout2 = this.f2690vI;
        if (frameLayout2 != null) {
            AbstractC0013AZxh.mjFkc mjfkc2 = (AbstractC0013AZxh.mjFkc) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) mjfkc2).width = -2;
            this.f2690vI.setLayoutParams(mjfkc2);
        }
    }

    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0008lgHUyS.mjFkc
    /* renamed from: ZfxDd */
    public void mo38ZfxDd(C0006KLFTb c0006KLFTb, int i) {
        this.f2686VocHEe = c0006KLFTb;
        if (c0006KLFTb.getItemId() > 0) {
            setId(c0006KLFTb.getItemId());
        }
        setVisibility(c0006KLFTb.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            AbstractC2876T9.m10294vjlshU(this, m2960BAnRFn());
        }
        setCheckable(c0006KLFTb.isCheckable());
        setChecked(c0006KLFTb.isChecked());
        setEnabled(c0006KLFTb.isEnabled());
        setTitle(c0006KLFTb.getTitle());
        m2963setIcon(c0006KLFTb.getIcon());
        setActionView(c0006KLFTb.getActionView());
        setContentDescription(c0006KLFTb.getContentDescription());
        AbstractC2143I8.m8717mjFkc(this, c0006KLFTb.getTooltipText());
        m2961VocHEe();
    }

    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0008lgHUyS.mjFkc
    public C0006KLFTb getItemData() {
        return this.f2686VocHEe;
    }

    /* renamed from: lB */
    public final boolean m2962lB() {
        return this.f2686VocHEe.getTitle() == null && this.f2686VocHEe.getIcon() == null && this.f2686VocHEe.getActionView() != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        C0006KLFTb c0006KLFTb = this.f2686VocHEe;
        if (c0006KLFTb != null && c0006KLFTb.isCheckable() && this.f2686VocHEe.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f2681OjSQV);
        }
        return iArrOnCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.f2683Gd != z) {
            this.f2683Gd = z;
            this.f2689mByQ.mo1222VA(this.f2684HGpJ, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.f2684HGpJ.setChecked(z);
        CheckedTextView checkedTextView = this.f2684HGpJ;
        checkedTextView.setTypeface(checkedTextView.getTypeface(), z ? 1 : 0);
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, getPaddingTop(), i, getPaddingBottom());
    }

    /* renamed from: setIcon */
    public void m2963setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.f2688lB) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = AbstractC4332pCk.m13077VA(drawable).mutate();
                AbstractC4332pCk.m13081qdMbNW(drawable, this.f2682BAnRFn);
            }
            int i = this.f2685Ucbh;
            drawable.setBounds(0, 0, i, i);
        } else if (this.f2687huTpC) {
            if (this.f2691wJVbdd == null) {
                Drawable drawableM13578KLFTb = AbstractC4592t5.m13578KLFTb(getResources(), AbstractC4458r4.f16286xJ, getContext().getTheme());
                this.f2691wJVbdd = drawableM13578KLFTb;
                if (drawableM13578KLFTb != null) {
                    int i2 = this.f2685Ucbh;
                    drawableM13578KLFTb.setBounds(0, 0, i2, i2);
                }
            }
            drawable = this.f2691wJVbdd;
        }
        AbstractC4065l8.m12666lgHUyS(this.f2684HGpJ, drawable, null, null, null);
    }

    public void setIconPadding(int i) {
        this.f2684HGpJ.setCompoundDrawablePadding(i);
    }

    public void setIconSize(int i) {
        this.f2685Ucbh = i;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f2682BAnRFn = colorStateList;
        this.f2688lB = colorStateList != null;
        C0006KLFTb c0006KLFTb = this.f2686VocHEe;
        if (c0006KLFTb != null) {
            m2963setIcon(c0006KLFTb.getIcon());
        }
    }

    public void setMaxLines(int i) {
        this.f2684HGpJ.setMaxLines(i);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.f2687huTpC = z;
    }

    public void setTextAppearance(int i) {
        AbstractC4065l8.m12662MiMN(this.f2684HGpJ, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f2684HGpJ.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f2684HGpJ.setText(charSequence);
    }

    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0008lgHUyS.mjFkc
    /* renamed from: wA */
    public boolean mo42wA() {
        return false;
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C0260mjFkc c0260mjFkc = new C0260mjFkc();
        this.f2689mByQ = c0260mjFkc;
        setOrientation(0);
        LayoutInflater.from(context).inflate(AbstractC2007G4.f8327wA, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(AbstractC4191n4.f15306AZxh));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(AbstractC1803D4.f7796KLFTb);
        this.f2684HGpJ = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        AbstractC2876T9.m10265alEkx(checkedTextView, c0260mjFkc);
    }
}
