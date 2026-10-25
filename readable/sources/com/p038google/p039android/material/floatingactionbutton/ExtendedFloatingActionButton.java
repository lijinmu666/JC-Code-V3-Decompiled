package com.p038google.p039android.material.floatingactionbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.p016widget.CoordinatorLayout;
import com.p038google.p039android.material.bottomsheet.BottomSheetBehavior;
import com.p038google.p039android.material.p058button.MaterialButton;
import java.util.List;
import p131o.AbstractC3340a5;
import p131o.AbstractC4793w7;

/* loaded from: classes.dex */
public abstract class ExtendedFloatingActionButton extends MaterialButton {

    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.AbstractC0058AZxh {

        /* renamed from: AZxh */
        public boolean f2669AZxh;

        /* renamed from: mjFkc */
        public boolean f2670mjFkc;

        public ExtendedFloatingActionButtonBehavior() {
            this.f2670mjFkc = false;
            this.f2669AZxh = true;
        }

        /* renamed from: OjSQV */
        public static boolean m2942OjSQV(View view) {
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
            return m2946mByQ(coordinatorLayout, null, rect);
        }

        /* renamed from: CqaNbM */
        public boolean m2943CqaNbM(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, int i) {
            List listM474fehf = coordinatorLayout.m474fehf(extendedFloatingActionButton);
            int size = listM474fehf.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = (View) listM474fehf.get(i2);
                if (m2942OjSQV(view) && m2944KLMXS(view, extendedFloatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.m462Ne(extendedFloatingActionButton, i);
            return true;
        }

        /* renamed from: KLMXS */
        public final boolean m2944KLMXS(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (m2947xrEuO(view, extendedFloatingActionButton)) {
                throw null;
            }
            return false;
        }

        /* renamed from: Ne */
        public boolean m2945Ne(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (!m2942OjSQV(view)) {
                return false;
            }
            m2944KLMXS(view, extendedFloatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
        /* renamed from: VA */
        public /* bridge */ /* synthetic */ boolean mo497VA(CoordinatorLayout coordinatorLayout, View view, int i) {
            AbstractC4793w7.m13819mjFkc(view);
            return m2943CqaNbM(coordinatorLayout, null, i);
        }

        @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
        /* renamed from: lgHUyS */
        public /* bridge */ /* synthetic */ boolean mo506lgHUyS(CoordinatorLayout coordinatorLayout, View view, View view2) {
            AbstractC4793w7.m13819mjFkc(view);
            return m2945Ne(coordinatorLayout, null, view2);
        }

        /* renamed from: mByQ */
        public boolean m2946mByQ(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, Rect rect) {
            return super.mo485AZxh(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
        /* renamed from: xJ */
        public void mo514xJ(CoordinatorLayout.C0060KLFTb c0060KLFTb) {
            if (c0060KLFTb.f928lgHUyS == 0) {
                c0060KLFTb.f928lgHUyS = 80;
            }
        }

        /* renamed from: xrEuO */
        public final boolean m2947xrEuO(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            throw null;
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC3340a5.f12700ybBTr);
            this.f2670mjFkc = typedArrayObtainStyledAttributes.getBoolean(AbstractC3340a5.f12653sqndV, false);
            this.f2669AZxh = typedArrayObtainStyledAttributes.getBoolean(AbstractC3340a5.f12620oaI, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
