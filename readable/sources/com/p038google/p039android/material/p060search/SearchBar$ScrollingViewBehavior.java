package com.p038google.p039android.material.p060search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.p016widget.CoordinatorLayout;
import com.p038google.p039android.material.p057appbar.AppBarLayout;

/* loaded from: classes.dex */
public class SearchBar$ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {

    /* renamed from: lgHUyS */
    public boolean f2694lgHUyS;

    public SearchBar$ScrollingViewBehavior() {
        this.f2694lgHUyS = false;
    }

    @Override // p131o.AbstractC4653u
    /* renamed from: Vnb */
    public boolean mo2964Vnb() {
        return true;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: lgHUyS */
    public boolean mo506lgHUyS(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return super.mo506lgHUyS(coordinatorLayout, view, view2);
    }

    public SearchBar$ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2694lgHUyS = false;
    }
}
