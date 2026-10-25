package androidx.appcompat.p010view.p011menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.p010view.p011menu.C0007ZfxDd;

/* renamed from: androidx.appcompat.view.menu.Dt */
/* loaded from: classes.dex */
public class SubMenuC0004Dt extends C0007ZfxDd implements SubMenu {

    /* renamed from: BAnRFn */
    public C0007ZfxDd f255BAnRFn;

    /* renamed from: lB */
    public C0006KLFTb f256lB;

    public SubMenuC0004Dt(Context context, C0007ZfxDd c0007ZfxDd, C0006KLFTb c0006KLFTb) {
        super(context);
        this.f255BAnRFn = c0007ZfxDd;
        this.f256lB = c0006KLFTb;
    }

    @Override // androidx.appcompat.p010view.p011menu.C0007ZfxDd
    /* renamed from: BAnRFn */
    public boolean mo46BAnRFn() {
        return this.f255BAnRFn.mo46BAnRFn();
    }

    @Override // androidx.appcompat.p010view.p011menu.C0007ZfxDd
    /* renamed from: Dt */
    public boolean mo47Dt(C0006KLFTb c0006KLFTb) {
        return this.f255BAnRFn.mo47Dt(c0006KLFTb);
    }

    /* renamed from: JYn */
    public Menu m48JYn() {
        return this.f255BAnRFn;
    }

    @Override // androidx.appcompat.p010view.p011menu.C0007ZfxDd
    /* renamed from: KLFTb */
    public boolean mo49KLFTb(C0006KLFTb c0006KLFTb) {
        return this.f255BAnRFn.mo49KLFTb(c0006KLFTb);
    }

    @Override // androidx.appcompat.p010view.p011menu.C0007ZfxDd
    /* renamed from: cMLeY */
    public void mo50cMLeY(C0007ZfxDd.mjFkc mjfkc) {
        this.f255BAnRFn.mo50cMLeY(mjfkc);
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.f256lB;
    }

    @Override // androidx.appcompat.p010view.p011menu.C0007ZfxDd
    /* renamed from: lB */
    public boolean mo51lB() {
        return this.f255BAnRFn.mo51lB();
    }

    @Override // androidx.appcompat.p010view.p011menu.C0007ZfxDd, android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.f255BAnRFn.setGroupDividerEnabled(z);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.m116NPj(drawable);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.m127aqHPIZ(charSequence);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.m124WrLQs(view);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f256lB.setIcon(drawable);
        return this;
    }

    @Override // androidx.appcompat.p010view.p011menu.C0007ZfxDd, android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f255BAnRFn.setQwertyMode(z);
    }

    @Override // androidx.appcompat.p010view.p011menu.C0007ZfxDd
    /* renamed from: vI */
    public C0007ZfxDd mo52vI() {
        return this.f255BAnRFn.mo52vI();
    }

    @Override // androidx.appcompat.p010view.p011menu.C0007ZfxDd
    /* renamed from: wJVbdd */
    public boolean mo53wJVbdd() {
        return this.f255BAnRFn.mo53wJVbdd();
    }

    @Override // androidx.appcompat.p010view.p011menu.C0007ZfxDd
    /* renamed from: xJ */
    public boolean mo54xJ(C0007ZfxDd c0007ZfxDd, MenuItem menuItem) {
        return super.mo54xJ(c0007ZfxDd, menuItem) || this.f255BAnRFn.mo54xJ(c0007ZfxDd, menuItem);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.m122Vnb(i);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.m135oCFDzJ(i);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        this.f256lB.setIcon(i);
        return this;
    }
}
