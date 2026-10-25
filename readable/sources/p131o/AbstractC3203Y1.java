package p131o;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.p010view.p011menu.C0006KLFTb;
import androidx.appcompat.p010view.p011menu.C0007ZfxDd;
import androidx.appcompat.p010view.p011menu.C0011wA;
import androidx.appcompat.p010view.p011menu.InterfaceC0012xJ;

/* renamed from: o.Y1 */
/* loaded from: classes.dex */
public abstract class AbstractC3203Y1 implements InterfaceC2674Q6, InterfaceC0012xJ, AdapterView.OnItemClickListener {

    /* renamed from: mjFkc */
    public Rect f11784mjFkc;

    /* renamed from: HGpJ */
    public static boolean m11038HGpJ(C0007ZfxDd c0007ZfxDd) {
        int size = c0007ZfxDd.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = c0007ZfxDd.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: qGY */
    public static int m11039qGY(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i2 = 0;
        int i3 = 0;
        View view = null;
        for (int i4 = 0; i4 < count; i4++) {
            int itemViewType = listAdapter.getItemViewType(i4);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            if (viewGroup == null) {
                viewGroup = new FrameLayout(context);
            }
            view = listAdapter.getView(i4, view, viewGroup);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth > i2) {
                i2 = measuredWidth;
            }
        }
        return i2;
    }

    /* renamed from: vI */
    public static C0011wA m11040vI(ListAdapter listAdapter) {
        return listAdapter instanceof HeaderViewListAdapter ? (C0011wA) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (C0011wA) listAdapter;
    }

    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
    /* renamed from: ETF */
    public boolean mo148ETF(C0007ZfxDd c0007ZfxDd, C0006KLFTb c0006KLFTb) {
        return false;
    }

    /* renamed from: Gd */
    public abstract void mo10Gd(int i);

    /* renamed from: IEE */
    public void m11041IEE(Rect rect) {
        this.f11784mjFkc = rect;
    }

    /* renamed from: MiMN */
    public abstract void mo13MiMN(C0007ZfxDd c0007ZfxDd);

    /* renamed from: Pq */
    public abstract void mo16Pq(boolean z);

    /* renamed from: Ucbh */
    public abstract void mo17Ucbh(PopupWindow.OnDismissListener onDismissListener);

    /* renamed from: YoKzxo */
    public boolean mo20YoKzxo() {
        return true;
    }

    /* renamed from: diqgf */
    public abstract void mo22diqgf(int i);

    /* renamed from: eyqo */
    public abstract void mo23eyqo(int i);

    /* renamed from: fehf */
    public abstract void mo24fehf(View view);

    /* renamed from: huTpC */
    public abstract void mo25huTpC(boolean z);

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        m11040vI(listAdapter).f383mjFkc.m143xrEuO((MenuItem) listAdapter.getItem(i), this, mo20YoKzxo() ? 0 : 4);
    }

    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
    /* renamed from: qdMbNW */
    public boolean mo154qdMbNW(C0007ZfxDd c0007ZfxDd, C0006KLFTb c0006KLFTb) {
        return false;
    }

    /* renamed from: rkYL */
    public Rect m11042rkYL() {
        return this.f11784mjFkc;
    }

    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
    /* renamed from: wA */
    public void mo156wA(Context context, C0007ZfxDd c0007ZfxDd) {
    }
}
