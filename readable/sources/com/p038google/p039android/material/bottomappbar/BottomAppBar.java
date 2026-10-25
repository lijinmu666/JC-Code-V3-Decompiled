package com.p038google.p039android.material.bottomappbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.p012widget.C0044Toolbar;
import androidx.coordinatorlayout.p016widget.CoordinatorLayout;
import com.p038google.p039android.material.behavior.HideBottomViewOnScrollBehavior;
import java.lang.ref.WeakReference;
import p131o.AbstractC2737R4;
import p131o.AbstractC2876T9;
import p131o.AbstractC3800h4;
import p131o.AbstractC4793w7;

/* loaded from: classes.dex */
public abstract class BottomAppBar extends C0044Toolbar {

    /* renamed from: KRTLGT */
    public static final int f2343KRTLGT = AbstractC2737R4.f10376xJ;

    /* renamed from: GMIER */
    public static final int f2342GMIER = AbstractC3800h4.f13940diqgf;

    /* renamed from: uHVRx */
    public static final int f2344uHVRx = AbstractC3800h4.f13921BAnRFn;

    /* renamed from: Vnb */
    public static /* synthetic */ View m2495Vnb(BottomAppBar bottomAppBar) {
        throw null;
    }

    /* renamed from: rWxwaT */
    public static /* synthetic */ void m2496rWxwaT(BottomAppBar bottomAppBar) {
        throw null;
    }

    /* renamed from: vadzgd */
    public static void m2497vadzgd(BottomAppBar bottomAppBar, View view) {
        ((CoordinatorLayout.C0060KLFTb) view.getLayoutParams()).f926ZfxDd = 17;
        throw null;
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* renamed from: MiMN */
        public final Rect f2345MiMN;

        /* renamed from: YoKzxo */
        public WeakReference f2346YoKzxo;

        /* renamed from: qGY */
        public final View.OnLayoutChangeListener f2347qGY;

        /* renamed from: rkYL */
        public int f2348rkYL;

        /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$Behavior$mjFkc */
        public class ViewOnLayoutChangeListenerC0229mjFkc implements View.OnLayoutChangeListener {
            public ViewOnLayoutChangeListenerC0229mjFkc() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                AbstractC4793w7.m13819mjFkc(Behavior.this.f2346YoKzxo.get());
                view.removeOnLayoutChangeListener(this);
            }
        }

        public Behavior() {
            this.f2347qGY = new ViewOnLayoutChangeListenerC0229mjFkc();
            this.f2345MiMN = new Rect();
        }

        /* renamed from: NPj */
        public boolean m2499NPj(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i) {
            this.f2346YoKzxo = new WeakReference(bottomAppBar);
            View viewM2495Vnb = BottomAppBar.m2495Vnb(bottomAppBar);
            if (viewM2495Vnb != null && !AbstractC2876T9.m10287rWxwaT(viewM2495Vnb)) {
                BottomAppBar.m2497vadzgd(bottomAppBar, viewM2495Vnb);
                this.f2348rkYL = ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.C0060KLFTb) viewM2495Vnb.getLayoutParams())).bottomMargin;
                viewM2495Vnb.addOnLayoutChangeListener(this.f2347qGY);
                BottomAppBar.m2496rWxwaT(bottomAppBar);
            }
            coordinatorLayout.m462Ne(bottomAppBar, i);
            return super.mo497VA(coordinatorLayout, bottomAppBar, i);
        }

        @Override // com.p038google.p039android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
        /* renamed from: VA */
        public /* bridge */ /* synthetic */ boolean mo497VA(CoordinatorLayout coordinatorLayout, View view, int i) {
            AbstractC4793w7.m13819mjFkc(view);
            return m2499NPj(coordinatorLayout, null, i);
        }

        @Override // com.p038google.p039android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
        /* renamed from: VocHEe */
        public /* bridge */ /* synthetic */ boolean mo498VocHEe(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            AbstractC4793w7.m13819mjFkc(view);
            return m2500vadzgd(coordinatorLayout, null, view2, view3, i, i2);
        }

        /* renamed from: vadzgd */
        public boolean m2500vadzgd(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i, int i2) {
            throw null;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2347qGY = new ViewOnLayoutChangeListenerC0229mjFkc();
            this.f2345MiMN = new Rect();
        }
    }
}
