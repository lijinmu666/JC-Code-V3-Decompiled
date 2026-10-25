package p131o;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* renamed from: o.ma */
/* loaded from: classes.dex */
public class C4158ma implements InterfaceC4223na {

    /* renamed from: mjFkc */
    public final ViewOverlay f15200mjFkc;

    public C4158ma(View view) {
        this.f15200mjFkc = view.getOverlay();
    }

    @Override // p131o.InterfaceC4223na
    /* renamed from: AZxh */
    public void mo11527AZxh(Drawable drawable) {
        this.f15200mjFkc.add(drawable);
    }

    @Override // p131o.InterfaceC4223na
    /* renamed from: ZfxDd */
    public void mo11528ZfxDd(Drawable drawable) {
        this.f15200mjFkc.remove(drawable);
    }
}
