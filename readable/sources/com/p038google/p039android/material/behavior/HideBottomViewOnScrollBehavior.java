package com.p038google.p039android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.p016widget.CoordinatorLayout;
import java.util.Iterator;
import java.util.LinkedHashSet;
import p131o.AbstractC2506NPj;
import p131o.AbstractC3800h4;
import p131o.AbstractC4793w7;
import p131o.AbstractC4923y2;

/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.AbstractC0058AZxh {

    /* renamed from: Dt */
    public static final int f2311Dt = AbstractC3800h4.f13940diqgf;

    /* renamed from: ETF */
    public static final int f2312ETF = AbstractC3800h4.f13935Ucbh;

    /* renamed from: VA */
    public static final int f2313VA = AbstractC3800h4.f13921BAnRFn;

    /* renamed from: AZxh */
    public int f2314AZxh;

    /* renamed from: JHa */
    public int f2315JHa;

    /* renamed from: KLFTb */
    public TimeInterpolator f2316KLFTb;

    /* renamed from: ZfxDd */
    public TimeInterpolator f2317ZfxDd;

    /* renamed from: lgHUyS */
    public int f2318lgHUyS;

    /* renamed from: mjFkc */
    public final LinkedHashSet f2319mjFkc;

    /* renamed from: qdMbNW */
    public ViewPropertyAnimator f2320qdMbNW;

    /* renamed from: wA */
    public int f2321wA;

    /* renamed from: xJ */
    public int f2322xJ;

    /* renamed from: com.google.android.material.behavior.HideBottomViewOnScrollBehavior$mjFkc */
    public class C0224mjFkc extends AnimatorListenerAdapter {
        public C0224mjFkc() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f2320qdMbNW = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
        this.f2319mjFkc = new LinkedHashSet();
        this.f2315JHa = 0;
        this.f2322xJ = 2;
        this.f2318lgHUyS = 0;
    }

    /* renamed from: CqaNbM */
    public boolean m2463CqaNbM() {
        return this.f2322xJ == 2;
    }

    /* renamed from: KLMXS */
    public void m2464KLMXS(View view, boolean z) {
        if (m2465Ne()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f2320qdMbNW;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        m2468rWxwaT(view, 1);
        int i = this.f2315JHa + this.f2318lgHUyS;
        if (z) {
            m2466OjSQV(view, i, this.f2321wA, this.f2316KLFTb);
        } else {
            view.setTranslationY(i);
        }
    }

    /* renamed from: Ne */
    public boolean m2465Ne() {
        return this.f2322xJ == 1;
    }

    /* renamed from: OjSQV */
    public final void m2466OjSQV(View view, int i, long j, TimeInterpolator timeInterpolator) {
        this.f2320qdMbNW = view.animate().translationY(i).setInterpolator(timeInterpolator).setDuration(j).setListener(new C0224mjFkc());
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: VA */
    public boolean mo497VA(CoordinatorLayout coordinatorLayout, View view, int i) {
        this.f2315JHa = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        this.f2314AZxh = AbstractC4923y2.m13983JHa(view.getContext(), f2311Dt, 225);
        this.f2321wA = AbstractC4923y2.m13983JHa(view.getContext(), f2312ETF, 175);
        Context context = view.getContext();
        int i2 = f2313VA;
        this.f2317ZfxDd = AbstractC4923y2.m13988xJ(context, i2, AbstractC2506NPj.f9738ZfxDd);
        this.f2316KLFTb = AbstractC4923y2.m13988xJ(view.getContext(), i2, AbstractC2506NPj.f9740wA);
        return super.mo497VA(coordinatorLayout, view, i);
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: VocHEe */
    public boolean mo498VocHEe(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
        return i == 2;
    }

    /* renamed from: cMLeY */
    public void m2467cMLeY(View view, boolean z) {
        if (m2463CqaNbM()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.f2320qdMbNW;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        m2468rWxwaT(view, 2);
        if (z) {
            m2466OjSQV(view, 0, this.f2314AZxh, this.f2317ZfxDd);
        } else {
            view.setTranslationY(0);
        }
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: diqgf */
    public void mo501diqgf(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (i2 > 0) {
            m2469xrEuO(view);
        } else if (i2 < 0) {
            m2470zvd(view);
        }
    }

    /* renamed from: rWxwaT */
    public final void m2468rWxwaT(View view, int i) {
        this.f2322xJ = i;
        Iterator it = this.f2319mjFkc.iterator();
        if (it.hasNext()) {
            AbstractC4793w7.m13819mjFkc(it.next());
            throw null;
        }
    }

    /* renamed from: xrEuO */
    public void m2469xrEuO(View view) {
        m2464KLMXS(view, true);
    }

    /* renamed from: zvd */
    public void m2470zvd(View view) {
        m2467cMLeY(view, true);
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2319mjFkc = new LinkedHashSet();
        this.f2315JHa = 0;
        this.f2322xJ = 2;
        this.f2318lgHUyS = 0;
    }
}
