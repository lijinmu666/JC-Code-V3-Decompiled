package com.p038google.p039android.material.floatingactionbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.p016widget.CoordinatorLayout;
import com.p038google.p039android.material.bottomsheet.BottomSheetBehavior;
import java.util.List;
import p131o.AbstractC1968Fa;
import p131o.AbstractC3340a5;
import p131o.AbstractC4793w7;
import p131o.InterfaceC2350L6;
import p131o.InterfaceC4032kgk;

/* loaded from: classes.dex */
public abstract class FloatingActionButton extends AbstractC1968Fa implements InterfaceC4032kgk, InterfaceC2350L6 {

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: CqaNbM */
        public /* bridge */ /* synthetic */ boolean mo2949CqaNbM(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.mo2949CqaNbM(coordinatorLayout, floatingActionButton, view);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: mByQ */
        public /* bridge */ /* synthetic */ boolean mo2952mByQ(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.mo2952mByQ(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
        /* renamed from: xJ */
        public /* bridge */ /* synthetic */ void mo514xJ(CoordinatorLayout.C0060KLFTb c0060KLFTb) {
            super.mo514xJ(c0060KLFTb);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* renamed from: xrEuO */
        public /* bridge */ /* synthetic */ boolean mo2953xrEuO(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            return super.mo2953xrEuO(coordinatorLayout, floatingActionButton, i);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.AbstractC0058AZxh {

        /* renamed from: mjFkc */
        public boolean f2671mjFkc;

        public BaseBehavior() {
            this.f2671mjFkc = true;
        }

        /* renamed from: OjSQV */
        private static boolean m2948OjSQV(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.C0060KLFTb) {
                return ((CoordinatorLayout.C0060KLFTb) layoutParams).m520KLFTb() instanceof BottomSheetBehavior;
            }
            return false;
        }

        @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
        /* renamed from: AZxh */
        public /* bridge */ /* synthetic */ boolean mo485AZxh(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            AbstractC4793w7.m13819mjFkc(view);
            return mo2952mByQ(coordinatorLayout, null, rect);
        }

        /* renamed from: CqaNbM */
        public boolean mo2949CqaNbM(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (!m2948OjSQV(view)) {
                return false;
            }
            m2954zvd(view, floatingActionButton);
            return false;
        }

        /* renamed from: KLMXS */
        public final boolean m2950KLMXS(View view, FloatingActionButton floatingActionButton) {
            throw null;
        }

        /* renamed from: Ne */
        public final void m2951Ne(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            throw null;
        }

        @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
        /* renamed from: VA */
        public /* bridge */ /* synthetic */ boolean mo497VA(CoordinatorLayout coordinatorLayout, View view, int i) {
            AbstractC4793w7.m13819mjFkc(view);
            return mo2953xrEuO(coordinatorLayout, null, i);
        }

        @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
        /* renamed from: lgHUyS */
        public /* bridge */ /* synthetic */ boolean mo506lgHUyS(CoordinatorLayout coordinatorLayout, View view, View view2) {
            AbstractC4793w7.m13819mjFkc(view);
            return mo2949CqaNbM(coordinatorLayout, null, view2);
        }

        /* renamed from: mByQ */
        public boolean mo2952mByQ(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            throw null;
        }

        @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
        /* renamed from: xJ */
        public void mo514xJ(CoordinatorLayout.C0060KLFTb c0060KLFTb) {
            if (c0060KLFTb.f928lgHUyS == 0) {
                c0060KLFTb.f928lgHUyS = 80;
            }
        }

        /* renamed from: xrEuO */
        public boolean mo2953xrEuO(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List listM474fehf = coordinatorLayout.m474fehf(floatingActionButton);
            int size = listM474fehf.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) listM474fehf.get(i2);
                if (m2948OjSQV(view) && m2954zvd(view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.m462Ne(floatingActionButton, i);
            m2951Ne(coordinatorLayout, floatingActionButton);
            return true;
        }

        /* renamed from: zvd */
        public final boolean m2954zvd(View view, FloatingActionButton floatingActionButton) {
            if (m2950KLMXS(view, floatingActionButton)) {
                throw null;
            }
            return false;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3340a5.f12494Vu);
            this.f2671mjFkc = typedArrayObtainStyledAttributes.getBoolean(AbstractC3340a5.f12669uxlM, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
