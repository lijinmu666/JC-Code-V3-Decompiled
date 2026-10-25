package com.p038google.p039android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.p016widget.CoordinatorLayout;
import java.util.List;
import p131o.AbstractC2876T9;
import p131o.AbstractC4793w7;
import p131o.InterfaceC4032kgk;

@Deprecated
/* loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.AbstractC0058AZxh {

    /* renamed from: mjFkc */
    public int f2981mjFkc;

    public ExpandableBehavior() {
        this.f2981mjFkc = 0;
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: KLFTb */
    public abstract boolean mo493KLFTb(CoordinatorLayout coordinatorLayout, View view, View view2);

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: VA */
    public boolean mo497VA(CoordinatorLayout coordinatorLayout, View view, int i) {
        if (AbstractC2876T9.m10287rWxwaT(view)) {
            return false;
        }
        m3321mByQ(coordinatorLayout, view);
        return false;
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: lgHUyS */
    public boolean mo506lgHUyS(CoordinatorLayout coordinatorLayout, View view, View view2) {
        AbstractC4793w7.m13819mjFkc(view2);
        throw null;
    }

    /* renamed from: mByQ */
    public InterfaceC4032kgk m3321mByQ(CoordinatorLayout coordinatorLayout, View view) {
        List listM474fehf = coordinatorLayout.m474fehf(view);
        int size = listM474fehf.size();
        for (int i = 0; i < size; i++) {
            View view2 = (View) listM474fehf.get(i);
            if (mo493KLFTb(coordinatorLayout, view, view2)) {
                AbstractC4793w7.m13819mjFkc(view2);
                return null;
            }
        }
        return null;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2981mjFkc = 0;
    }
}
