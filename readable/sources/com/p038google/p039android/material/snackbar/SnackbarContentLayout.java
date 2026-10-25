package com.p038google.p039android.material.snackbar;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import p131o.AbstractC1803D4;
import p131o.AbstractC2345L1;
import p131o.AbstractC2506NPj;
import p131o.AbstractC2876T9;
import p131o.AbstractC3800h4;
import p131o.AbstractC4191n4;
import p131o.AbstractC4923y2;
import p131o.InterfaceC2703QaEQQ;

/* loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout implements InterfaceC2703QaEQQ {

    /* renamed from: AZxh */
    public Button f2797AZxh;

    /* renamed from: ZfxDd */
    public int f2798ZfxDd;

    /* renamed from: mjFkc */
    public TextView f2799mjFkc;

    /* renamed from: wA */
    public final TimeInterpolator f2800wA;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2800wA = AbstractC4923y2.m13988xJ(context, AbstractC3800h4.f13921BAnRFn, AbstractC2506NPj.f9736AZxh);
    }

    /* renamed from: ZfxDd */
    public static void m3098ZfxDd(View view, int i, int i2) {
        if (AbstractC2876T9.m10245NPj(view)) {
            AbstractC2876T9.m10274gYa(view, AbstractC2876T9.m10224BAnRFn(view), i, AbstractC2876T9.m10257VocHEe(view), i2);
        } else {
            view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
        }
    }

    @Override // p131o.InterfaceC2703QaEQQ
    /* renamed from: AZxh */
    public void mo3099AZxh(int i, int i2) {
        this.f2799mjFkc.setAlpha(1.0f);
        long j = i2;
        long j2 = i;
        this.f2799mjFkc.animate().alpha(0.0f).setDuration(j).setInterpolator(this.f2800wA).setStartDelay(j2).start();
        if (this.f2797AZxh.getVisibility() == 0) {
            this.f2797AZxh.setAlpha(1.0f);
            this.f2797AZxh.animate().alpha(0.0f).setDuration(j).setInterpolator(this.f2800wA).setStartDelay(j2).start();
        }
    }

    /* renamed from: KLFTb */
    public final boolean m3100KLFTb(int i, int i2, int i3) {
        boolean z;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        } else {
            z = false;
        }
        if (this.f2799mjFkc.getPaddingTop() == i2 && this.f2799mjFkc.getPaddingBottom() == i3) {
            return z;
        }
        m3098ZfxDd(this.f2799mjFkc, i2, i3);
        return true;
    }

    public Button getActionView() {
        return this.f2797AZxh;
    }

    public TextView getMessageView() {
        return this.f2799mjFkc;
    }

    @Override // p131o.InterfaceC2703QaEQQ
    /* renamed from: mjFkc */
    public void mo3101mjFkc(int i, int i2) {
        this.f2799mjFkc.setAlpha(0.0f);
        long j = i2;
        long j2 = i;
        this.f2799mjFkc.animate().alpha(1.0f).setDuration(j).setInterpolator(this.f2800wA).setStartDelay(j2).start();
        if (this.f2797AZxh.getVisibility() == 0) {
            this.f2797AZxh.setAlpha(0.0f);
            this.f2797AZxh.animate().alpha(1.0f).setDuration(j).setInterpolator(this.f2800wA).setStartDelay(j2).start();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f2799mjFkc = (TextView) findViewById(AbstractC1803D4.f7800OjSQV);
        this.f2797AZxh = (Button) findViewById(AbstractC1803D4.f7815mByQ);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) throws Resources.NotFoundException {
        super.onMeasure(i, i2);
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(AbstractC4191n4.f15328ZfxDd);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(AbstractC4191n4.f15346wA);
        Layout layout = this.f2799mjFkc.getLayout();
        boolean z = layout != null && layout.getLineCount() > 1;
        if (!z || this.f2798ZfxDd <= 0 || this.f2797AZxh.getMeasuredWidth() <= this.f2798ZfxDd) {
            if (!z) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!m3100KLFTb(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        } else if (!m3100KLFTb(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            return;
        }
        super.onMeasure(i, i2);
    }

    public void setMaxInlineActionWidth(int i) {
        this.f2798ZfxDd = i;
    }

    /* renamed from: wA */
    public void m3102wA(float f) {
        if (f != 1.0f) {
            this.f2797AZxh.setTextColor(AbstractC2345L1.m9306qdMbNW(AbstractC2345L1.m9303ZfxDd(this, AbstractC3800h4.f13945lgHUyS), this.f2797AZxh.getCurrentTextColor(), f));
        }
    }
}
