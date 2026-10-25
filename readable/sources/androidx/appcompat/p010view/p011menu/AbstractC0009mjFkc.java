package androidx.appcompat.p010view.p011menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.p010view.p011menu.InterfaceC0008lgHUyS;
import androidx.appcompat.p010view.p011menu.InterfaceC0012xJ;
import java.util.ArrayList;

/* renamed from: androidx.appcompat.view.menu.mjFkc */
/* loaded from: classes.dex */
public abstract class AbstractC0009mjFkc implements InterfaceC0012xJ {

    /* renamed from: AZxh */
    public Context f347AZxh;

    /* renamed from: JHa */
    public InterfaceC0012xJ.mjFkc f348JHa;

    /* renamed from: KLFTb */
    public LayoutInflater f349KLFTb;

    /* renamed from: ZfxDd */
    public LayoutInflater f350ZfxDd;

    /* renamed from: lgHUyS */
    public int f351lgHUyS;

    /* renamed from: mjFkc */
    public Context f352mjFkc;

    /* renamed from: qdMbNW */
    public InterfaceC0008lgHUyS f353qdMbNW;

    /* renamed from: wA */
    public C0007ZfxDd f354wA;

    /* renamed from: xJ */
    public int f355xJ;

    public AbstractC0009mjFkc(Context context, int i, int i2) {
        this.f352mjFkc = context;
        this.f350ZfxDd = LayoutInflater.from(context);
        this.f355xJ = i;
        this.f351lgHUyS = i2;
    }

    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
    /* renamed from: AZxh */
    public void mo7AZxh(C0007ZfxDd c0007ZfxDd, boolean z) {
        InterfaceC0012xJ.mjFkc mjfkc = this.f348JHa;
        if (mjfkc != null) {
            mjfkc.mo162AZxh(c0007ZfxDd, z);
        }
    }

    /* renamed from: Dt */
    public boolean mo147Dt(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
    /* renamed from: ETF */
    public boolean mo148ETF(C0007ZfxDd c0007ZfxDd, C0006KLFTb c0006KLFTb) {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.appcompat.view.menu.ZfxDd] */
    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
    /* renamed from: JHa */
    public boolean mo11JHa(SubMenuC0004Dt subMenuC0004Dt) {
        InterfaceC0012xJ.mjFkc mjfkc = this.f348JHa;
        SubMenuC0004Dt subMenuC0004Dt2 = subMenuC0004Dt;
        if (mjfkc == null) {
            return false;
        }
        if (subMenuC0004Dt == null) {
            subMenuC0004Dt2 = this.f354wA;
        }
        return mjfkc.mo163wA(subMenuC0004Dt2);
    }

    /* renamed from: KLFTb */
    public InterfaceC0008lgHUyS.mjFkc m149KLFTb(ViewGroup viewGroup) {
        return (InterfaceC0008lgHUyS.mjFkc) this.f350ZfxDd.inflate(this.f351lgHUyS, viewGroup, false);
    }

    /* renamed from: MiMN */
    public InterfaceC0012xJ.mjFkc m150MiMN() {
        return this.f348JHa;
    }

    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
    /* renamed from: VA */
    public void mo18VA(InterfaceC0012xJ.mjFkc mjfkc) {
        this.f348JHa = mjfkc;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: YoKzxo */
    public View mo151YoKzxo(C0006KLFTb c0006KLFTb, View view, ViewGroup viewGroup) {
        InterfaceC0008lgHUyS.mjFkc mjfkcM149KLFTb = view instanceof InterfaceC0008lgHUyS.mjFkc ? (InterfaceC0008lgHUyS.mjFkc) view : m149KLFTb(viewGroup);
        mo152ZfxDd(c0006KLFTb, mjfkcM149KLFTb);
        return (View) mjfkcM149KLFTb;
    }

    /* renamed from: ZfxDd */
    public abstract void mo152ZfxDd(C0006KLFTb c0006KLFTb, InterfaceC0008lgHUyS.mjFkc mjfkc);

    /* renamed from: mjFkc */
    public void m153mjFkc(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f353qdMbNW).addView(view, i);
    }

    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
    /* renamed from: qdMbNW */
    public boolean mo154qdMbNW(C0007ZfxDd c0007ZfxDd, C0006KLFTb c0006KLFTb) {
        return false;
    }

    /* renamed from: rkYL */
    public abstract boolean mo155rkYL(int i, C0006KLFTb c0006KLFTb);

    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
    /* renamed from: wA */
    public void mo156wA(Context context, C0007ZfxDd c0007ZfxDd) {
        this.f347AZxh = context;
        this.f349KLFTb = LayoutInflater.from(context);
        this.f354wA = c0007ZfxDd;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.p010view.p011menu.InterfaceC0012xJ
    /* renamed from: xJ */
    public void mo31xJ(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f353qdMbNW;
        if (viewGroup == null) {
            return;
        }
        C0007ZfxDd c0007ZfxDd = this.f354wA;
        int i = 0;
        if (c0007ZfxDd != null) {
            c0007ZfxDd.m130fehf();
            ArrayList arrayListM123VocHEe = this.f354wA.m123VocHEe();
            int size = arrayListM123VocHEe.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                C0006KLFTb c0006KLFTb = (C0006KLFTb) arrayListM123VocHEe.get(i3);
                if (mo155rkYL(i2, c0006KLFTb)) {
                    View childAt = viewGroup.getChildAt(i2);
                    C0006KLFTb itemData = childAt instanceof InterfaceC0008lgHUyS.mjFkc ? ((InterfaceC0008lgHUyS.mjFkc) childAt).getItemData() : null;
                    View viewMo151YoKzxo = mo151YoKzxo(c0006KLFTb, childAt, viewGroup);
                    if (c0006KLFTb != itemData) {
                        viewMo151YoKzxo.setPressed(false);
                        viewMo151YoKzxo.jumpDrawablesToCurrentState();
                    }
                    if (viewMo151YoKzxo != childAt) {
                        m153mjFkc(viewMo151YoKzxo, i2);
                    }
                    i2++;
                }
            }
            i = i2;
        }
        while (i < viewGroup.getChildCount()) {
            if (!mo147Dt(viewGroup, i)) {
                i++;
            }
        }
    }
}
