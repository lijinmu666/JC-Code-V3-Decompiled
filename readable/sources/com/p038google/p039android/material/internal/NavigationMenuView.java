package com.p038google.p039android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.p010view.p011menu.InterfaceC0008lgHUyS;
import androidx.recyclerview.p023widget.LinearLayoutManager;
import androidx.recyclerview.p023widget.RecyclerView;

/* loaded from: classes.dex */
public class NavigationMenuView extends RecyclerView implements InterfaceC0008lgHUyS {
    public NavigationMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    public NavigationMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutManager(new LinearLayoutManager(context, 1, false));
    }
}
