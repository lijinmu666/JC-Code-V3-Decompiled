package androidx.appcompat.p012widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import p131o.AbstractC1633AZxh;
import p131o.AbstractC1865E4;
import p131o.AbstractC2139I4;
import p131o.AbstractC2876T9;
import p131o.AbstractC3407b5;
import p131o.AbstractC3862i4;
import p131o.AbstractC4689ua;
import p131o.C1606A8;

/* loaded from: classes.dex */
public class ActionBarContextView extends AbstractC1633AZxh {

    /* renamed from: Dt */
    public View f410Dt;

    /* renamed from: ETF */
    public View f411ETF;

    /* renamed from: IEE */
    public int f412IEE;

    /* renamed from: MiMN */
    public TextView f413MiMN;

    /* renamed from: VA */
    public LinearLayout f414VA;

    /* renamed from: YoKzxo */
    public TextView f415YoKzxo;

    /* renamed from: fehf */
    public boolean f416fehf;

    /* renamed from: lgHUyS */
    public CharSequence f417lgHUyS;

    /* renamed from: qGY */
    public int f418qGY;

    /* renamed from: qdMbNW */
    public CharSequence f419qdMbNW;

    /* renamed from: rkYL */
    public int f420rkYL;

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC3862i4.f14112ZfxDd);
    }

    /* renamed from: ZfxDd */
    public final void m188ZfxDd() {
        if (this.f414VA == null) {
            LayoutInflater.from(getContext()).inflate(AbstractC2139I4.f8675mjFkc, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f414VA = linearLayout;
            this.f413MiMN = (TextView) linearLayout.findViewById(AbstractC1865E4.f7937KLFTb);
            this.f415YoKzxo = (TextView) this.f414VA.findViewById(AbstractC1865E4.f7944ZfxDd);
            if (this.f420rkYL != 0) {
                this.f413MiMN.setTextAppearance(getContext(), this.f420rkYL);
            }
            if (this.f418qGY != 0) {
                this.f415YoKzxo.setTextAppearance(getContext(), this.f418qGY);
            }
        }
        this.f413MiMN.setText(this.f417lgHUyS);
        this.f415YoKzxo.setText(this.f419qdMbNW);
        boolean zIsEmpty = TextUtils.isEmpty(this.f417lgHUyS);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.f419qdMbNW);
        this.f415YoKzxo.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.f414VA.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
        if (this.f414VA.getParent() == null) {
            addView(this.f414VA);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // p131o.AbstractC1633AZxh
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // p131o.AbstractC1633AZxh
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f419qdMbNW;
    }

    public CharSequence getTitle() {
        return this.f417lgHUyS;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0047mjFkc c0047mjFkc = this.f7374ZfxDd;
        if (c0047mjFkc != null) {
            c0047mjFkc.m366vI();
            this.f7374ZfxDd.m362VocHEe();
        }
    }

    @Override // p131o.AbstractC1633AZxh, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean zM13718mjFkc = AbstractC4689ua.m13718mjFkc(this);
        int paddingRight = zM13718mjFkc ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        View view = this.f410Dt;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f410Dt.getLayoutParams();
            int i5 = zM13718mjFkc ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = zM13718mjFkc ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iM7609AZxh = AbstractC1633AZxh.m7609AZxh(paddingRight, i5, zM13718mjFkc);
            paddingRight = AbstractC1633AZxh.m7609AZxh(iM7609AZxh + m7611wA(this.f410Dt, iM7609AZxh, paddingTop, paddingTop2, zM13718mjFkc), i6, zM13718mjFkc);
        }
        int iM7611wA = paddingRight;
        LinearLayout linearLayout = this.f414VA;
        if (linearLayout != null && this.f411ETF == null && linearLayout.getVisibility() != 8) {
            iM7611wA += m7611wA(this.f414VA, iM7611wA, paddingTop, paddingTop2, zM13718mjFkc);
        }
        int i7 = iM7611wA;
        View view2 = this.f411ETF;
        if (view2 != null) {
            m7611wA(view2, i7, paddingTop, paddingTop2, zM13718mjFkc);
        }
        int paddingLeft = zM13718mjFkc ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        ActionMenuView actionMenuView = this.f7376wA;
        if (actionMenuView != null) {
            m7611wA(actionMenuView, paddingLeft, paddingTop, paddingTop2, !zM13718mjFkc);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = this.f7373KLFTb;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i2);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f410Dt;
        if (view != null) {
            int iM7610mjFkc = m7610mjFkc(view, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f410Dt.getLayoutParams();
            paddingLeft = iM7610mjFkc - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f7376wA;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = m7610mjFkc(this.f7376wA, paddingLeft, iMakeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.f414VA;
        if (linearLayout != null && this.f411ETF == null) {
            if (this.f416fehf) {
                this.f414VA.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f414VA.getMeasuredWidth();
                boolean z = measuredWidth <= paddingLeft;
                if (z) {
                    paddingLeft -= measuredWidth;
                }
                this.f414VA.setVisibility(z ? 0 : 8);
            } else {
                paddingLeft = m7610mjFkc(linearLayout, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        View view2 = this.f411ETF;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i3 = layoutParams.width;
            int i4 = i3 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i3 >= 0) {
                paddingLeft = Math.min(i3, paddingLeft);
            }
            int i5 = layoutParams.height;
            int i6 = i5 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i5 >= 0) {
                iMin = Math.min(i5, iMin);
            }
            this.f411ETF.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i4), View.MeasureSpec.makeMeasureSpec(iMin, i6));
        }
        if (this.f7373KLFTb > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            int measuredHeight = getChildAt(i8).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i7) {
                i7 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i7);
    }

    @Override // p131o.AbstractC1633AZxh, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // p131o.AbstractC1633AZxh
    public void setContentHeight(int i) {
        this.f7373KLFTb = i;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f411ETF;
        if (view2 != null) {
            removeView(view2);
        }
        this.f411ETF = view;
        if (view != null && (linearLayout = this.f414VA) != null) {
            removeView(linearLayout);
            this.f414VA = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f419qdMbNW = charSequence;
        m188ZfxDd();
    }

    public void setTitle(CharSequence charSequence) {
        this.f417lgHUyS = charSequence;
        m188ZfxDd();
        AbstractC2876T9.m10301yfx(this, charSequence);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f416fehf) {
            requestLayout();
        }
        this.f416fehf = z;
    }

    @Override // p131o.AbstractC1633AZxh, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C1606A8 c1606a8M7575diqgf = C1606A8.m7575diqgf(context, attributeSet, AbstractC3407b5.f12975huTpC, i, 0);
        AbstractC2876T9.m10294vjlshU(this, c1606a8M7575diqgf.m7593xJ(AbstractC3407b5.f12869Gd));
        this.f420rkYL = c1606a8M7575diqgf.m7581MiMN(AbstractC3407b5.f12852BAnRFn, 0);
        this.f418qGY = c1606a8M7575diqgf.m7581MiMN(AbstractC3407b5.f12934VocHEe, 0);
        this.f7373KLFTb = c1606a8M7575diqgf.m7582VA(AbstractC3407b5.f13023vI, 0);
        this.f412IEE = c1606a8M7575diqgf.m7581MiMN(AbstractC3407b5.f12871HGpJ, AbstractC2139I4.f8673ZfxDd);
        c1606a8M7575diqgf.m7585eyqo();
    }
}
