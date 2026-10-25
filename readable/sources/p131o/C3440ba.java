package p131o;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* renamed from: o.ba */
/* loaded from: classes.dex */
public class C3440ba implements InterfaceC3506ca {

    /* renamed from: mjFkc */
    public final ViewGroupOverlay f13114mjFkc;

    public C3440ba(ViewGroup viewGroup) {
        this.f13114mjFkc = viewGroup.getOverlay();
    }

    @Override // p131o.InterfaceC4223na
    /* renamed from: AZxh */
    public void mo11527AZxh(Drawable drawable) {
        this.f13114mjFkc.add(drawable);
    }

    @Override // p131o.InterfaceC4223na
    /* renamed from: ZfxDd */
    public void mo11528ZfxDd(Drawable drawable) {
        this.f13114mjFkc.remove(drawable);
    }

    @Override // p131o.InterfaceC3506ca
    /* renamed from: mjFkc */
    public void mo11529mjFkc(View view) {
        this.f13114mjFkc.add(view);
    }

    @Override // p131o.InterfaceC3506ca
    /* renamed from: wA */
    public void mo11530wA(View view) {
        this.f13114mjFkc.remove(view);
    }
}
