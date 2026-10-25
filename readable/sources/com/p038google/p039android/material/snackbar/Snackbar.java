package com.p038google.p039android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.p016widget.CoordinatorLayout;
import com.p038google.p039android.material.snackbar.BaseTransientBottomBar;
import p131o.AbstractC2007G4;
import p131o.AbstractC3800h4;
import p131o.InterfaceC2703QaEQQ;

/* loaded from: classes.dex */
public class Snackbar extends BaseTransientBottomBar {

    /* renamed from: KLMXS */
    public static final int[] f2793KLMXS;

    /* renamed from: xrEuO */
    public static final int[] f2794xrEuO;

    /* renamed from: CqaNbM */
    public boolean f2795CqaNbM;

    /* renamed from: Ne */
    public final AccessibilityManager f2796Ne;

    public static final class SnackbarLayout extends BaseTransientBottomBar.C0267IEE {
        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // com.p038google.p039android.material.snackbar.BaseTransientBottomBar.C0267IEE, android.widget.FrameLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }

        @Override // com.p038google.p039android.material.snackbar.BaseTransientBottomBar.C0267IEE, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(Drawable drawable) {
            super.setBackground(drawable);
        }

        @Override // com.p038google.p039android.material.snackbar.BaseTransientBottomBar.C0267IEE, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        @Override // com.p038google.p039android.material.snackbar.BaseTransientBottomBar.C0267IEE, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        @Override // com.p038google.p039android.material.snackbar.BaseTransientBottomBar.C0267IEE, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        @Override // com.p038google.p039android.material.snackbar.BaseTransientBottomBar.C0267IEE, android.view.View
        public /* bridge */ /* synthetic */ void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super.setLayoutParams(layoutParams);
        }

        @Override // com.p038google.p039android.material.snackbar.BaseTransientBottomBar.C0267IEE, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }
    }

    static {
        int i = AbstractC3800h4.f13946mByQ;
        f2794xrEuO = new int[]{i};
        f2793KLMXS = new int[]{i, AbstractC3800h4.f13932Ne};
    }

    public Snackbar(Context context, ViewGroup viewGroup, View view, InterfaceC2703QaEQQ interfaceC2703QaEQQ) {
        super(context, viewGroup, view, interfaceC2703QaEQQ);
        this.f2796Ne = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    /* renamed from: JBhc */
    public static ViewGroup m3088JBhc(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    /* renamed from: alEkx */
    public static boolean m3089alEkx(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f2793KLMXS);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        typedArrayObtainStyledAttributes.recycle();
        return (resourceId == -1 || resourceId2 == -1) ? false : true;
    }

    /* renamed from: dm */
    public static Snackbar m3090dm(View view, CharSequence charSequence, int i) {
        return m3091tQ(null, view, charSequence, i);
    }

    /* renamed from: tQ */
    public static Snackbar m3091tQ(Context context, View view, CharSequence charSequence, int i) {
        ViewGroup viewGroupM3088JBhc = m3088JBhc(view);
        if (viewGroupM3088JBhc == null) {
            throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
        }
        if (context == null) {
            context = viewGroupM3088JBhc.getContext();
        }
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) LayoutInflater.from(context).inflate(m3089alEkx(context) ? AbstractC2007G4.f8315Pq : AbstractC2007G4.f8308AZxh, viewGroupM3088JBhc, false);
        Snackbar snackbar = new Snackbar(context, viewGroupM3088JBhc, snackbarContentLayout, snackbarContentLayout);
        snackbar.m3095vjlshU(charSequence);
        snackbar.m3058WrLQs(i);
        return snackbar;
    }

    /* renamed from: ANMGZc */
    public final TextView m3092ANMGZc() {
        return m3094jm().getMessageView();
    }

    @Override // com.p038google.p039android.material.snackbar.BaseTransientBottomBar
    /* renamed from: BAnRFn */
    public int mo3040BAnRFn() {
        int iMo3040BAnRFn = super.mo3040BAnRFn();
        if (iMo3040BAnRFn == -2) {
            return -2;
        }
        return this.f2796Ne.getRecommendedTimeoutMillis(iMo3040BAnRFn, (this.f2795CqaNbM ? 4 : 0) | 3);
    }

    @Override // com.p038google.p039android.material.snackbar.BaseTransientBottomBar
    /* renamed from: Gd */
    public void mo3043Gd() {
        super.mo3043Gd();
    }

    @Override // com.p038google.p039android.material.snackbar.BaseTransientBottomBar
    /* renamed from: JYn */
    public void mo3046JYn() {
        super.mo3046JYn();
    }

    /* renamed from: Vdz */
    public final Button m3093Vdz() {
        return m3094jm().getActionView();
    }

    /* renamed from: jm */
    public final SnackbarContentLayout m3094jm() {
        return (SnackbarContentLayout) this.f2755qdMbNW.getChildAt(0);
    }

    /* renamed from: vjlshU */
    public Snackbar m3095vjlshU(CharSequence charSequence) {
        m3092ANMGZc().setText(charSequence);
        return this;
    }

    /* renamed from: xROA */
    public Snackbar m3096xROA(int i) {
        m3092ANMGZc().setTextColor(i);
        return this;
    }

    /* renamed from: yfx */
    public Snackbar m3097yfx(int i) {
        m3093Vdz().setTextColor(i);
        return this;
    }
}
