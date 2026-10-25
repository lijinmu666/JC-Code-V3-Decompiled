package com.p038google.p039android.material.transformation;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.p016widget.CoordinatorLayout;

@Deprecated
/* loaded from: classes.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: AZxh */
    public final Rect f2982AZxh;

    /* renamed from: KLFTb */
    public final int[] f2983KLFTb;

    /* renamed from: ZfxDd */
    public final RectF f2984ZfxDd;

    /* renamed from: wA */
    public final RectF f2985wA;

    public FabTransformationBehavior() {
        this.f2982AZxh = new Rect();
        this.f2985wA = new RectF();
        this.f2984ZfxDd = new RectF();
        this.f2983KLFTb = new int[2];
    }

    @Override // com.p038google.p039android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: KLFTb */
    public boolean mo493KLFTb(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() != 8) {
            return false;
        }
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: xJ */
    public void mo514xJ(CoordinatorLayout.C0060KLFTb c0060KLFTb) {
        if (c0060KLFTb.f928lgHUyS == 0) {
            c0060KLFTb.f928lgHUyS = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2982AZxh = new Rect();
        this.f2985wA = new RectF();
        this.f2984ZfxDd = new RectF();
        this.f2983KLFTb = new int[2];
    }
}
