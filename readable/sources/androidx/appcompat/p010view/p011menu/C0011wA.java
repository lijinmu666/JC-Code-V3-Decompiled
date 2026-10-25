package androidx.appcompat.p010view.p011menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.p010view.p011menu.InterfaceC0008lgHUyS;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.view.menu.wA */
/* loaded from: classes.dex */
public class C0011wA extends BaseAdapter {

    /* renamed from: AZxh */
    public int f379AZxh = -1;

    /* renamed from: JHa */
    public final int f380JHa;

    /* renamed from: KLFTb */
    public final LayoutInflater f381KLFTb;

    /* renamed from: ZfxDd */
    public final boolean f382ZfxDd;

    /* renamed from: mjFkc */
    public C0007ZfxDd f383mjFkc;

    /* renamed from: wA */
    public boolean f384wA;

    public C0011wA(C0007ZfxDd c0007ZfxDd, LayoutInflater layoutInflater, boolean z, int i) {
        this.f382ZfxDd = z;
        this.f381KLFTb = layoutInflater;
        this.f383mjFkc = c0007ZfxDd;
        this.f380JHa = i;
        m160mjFkc();
    }

    /* renamed from: AZxh */
    public C0007ZfxDd m158AZxh() {
        return this.f383mjFkc;
    }

    /* renamed from: ZfxDd */
    public void m159ZfxDd(boolean z) {
        this.f384wA = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f379AZxh < 0 ? (this.f382ZfxDd ? this.f383mjFkc.m120Ucbh() : this.f383mjFkc.m123VocHEe()).size() : r0.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f381KLFTb.inflate(this.f380JHa, viewGroup, false);
        }
        int groupId = getItem(i).getGroupId();
        int i2 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f383mjFkc.mo46BAnRFn() && groupId != (i2 >= 0 ? getItem(i2).getGroupId() : groupId));
        InterfaceC0008lgHUyS.mjFkc mjfkc = (InterfaceC0008lgHUyS.mjFkc) view;
        if (this.f384wA) {
            listMenuItemView.setForceShowIcon(true);
        }
        mjfkc.mo38ZfxDd(getItem(i), 0);
        return view;
    }

    /* renamed from: mjFkc */
    public void m160mjFkc() {
        C0006KLFTb c0006KLFTbM128diqgf = this.f383mjFkc.m128diqgf();
        if (c0006KLFTbM128diqgf != null) {
            ArrayList arrayListM120Ucbh = this.f383mjFkc.m120Ucbh();
            int size = arrayListM120Ucbh.size();
            for (int i = 0; i < size; i++) {
                if (((C0006KLFTb) arrayListM120Ucbh.get(i)) == c0006KLFTbM128diqgf) {
                    this.f379AZxh = i;
                    return;
                }
            }
        }
        this.f379AZxh = -1;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        m160mjFkc();
        super.notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    /* renamed from: wA, reason: merged with bridge method [inline-methods] */
    public C0006KLFTb getItem(int i) {
        ArrayList arrayListM120Ucbh = this.f382ZfxDd ? this.f383mjFkc.m120Ucbh() : this.f383mjFkc.m123VocHEe();
        int i2 = this.f379AZxh;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return (C0006KLFTb) arrayListM120Ucbh.get(i);
    }
}
