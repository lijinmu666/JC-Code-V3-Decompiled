package androidx.appcompat.p010view.p011menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.p010view.p011menu.C0007ZfxDd;
import p131o.C1606A8;

/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements C0007ZfxDd.AZxh, InterfaceC0008lgHUyS, AdapterView.OnItemClickListener {

    /* renamed from: wA */
    public static final int[] f257wA = {R.attr.background, R.attr.divider};

    /* renamed from: AZxh */
    public int f258AZxh;

    /* renamed from: mjFkc */
    public C0007ZfxDd f259mjFkc;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    public int getWindowAnimations() {
        return this.f258AZxh;
    }

    @Override // androidx.appcompat.p010view.p011menu.C0007ZfxDd.AZxh
    /* renamed from: mjFkc */
    public boolean mo55mjFkc(C0006KLFTb c0006KLFTb) {
        return this.f259mjFkc.m108CqaNbM(c0006KLFTb, 0);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        mo55mjFkc((C0006KLFTb) getAdapter().getItem(i));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        C1606A8 c1606a8M7575diqgf = C1606A8.m7575diqgf(context, attributeSet, f257wA, i, 0);
        if (c1606a8M7575diqgf.m7586fehf(0)) {
            setBackgroundDrawable(c1606a8M7575diqgf.m7593xJ(0));
        }
        if (c1606a8M7575diqgf.m7586fehf(1)) {
            setDivider(c1606a8M7575diqgf.m7593xJ(1));
        }
        c1606a8M7575diqgf.m7585eyqo();
    }
}
