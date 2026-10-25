package com.p038google.p039android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.coordinatorlayout.p016widget.CoordinatorLayout;
import p131o.C4855x2;

@Deprecated
/* loaded from: classes.dex */
public class FabTransformationScrimBehavior extends ExpandableTransformationBehavior {

    /* renamed from: AZxh */
    public final C4855x2 f2986AZxh;

    /* renamed from: wA */
    public final C4855x2 f2987wA;

    public FabTransformationScrimBehavior() {
        this.f2986AZxh = new C4855x2(75L, 150L);
        this.f2987wA = new C4855x2(0L, 150L);
    }

    @Override // com.p038google.p039android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: KLFTb */
    public boolean mo493KLFTb(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return false;
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: wJVbdd */
    public boolean mo513wJVbdd(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        return super.mo513wJVbdd(coordinatorLayout, view, motionEvent);
    }

    public FabTransformationScrimBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2986AZxh = new C4855x2(75L, 150L);
        this.f2987wA = new C4855x2(0L, 150L);
    }
}
