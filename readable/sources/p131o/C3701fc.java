package p131o;

import p131o.ComponentCallbacks2C3307Zdbk;

/* renamed from: o.fc */
/* loaded from: classes.dex */
public final class C3701fc implements ComponentCallbacks2C3307Zdbk.mjFkc {

    /* renamed from: mjFkc */
    public final /* synthetic */ C3795h f13615mjFkc;

    public C3701fc(C3795h c3795h) {
        this.f13615mjFkc = c3795h;
    }

    @Override // p131o.ComponentCallbacks2C3307Zdbk.mjFkc
    /* renamed from: mjFkc */
    public final void mo11209mjFkc(boolean z) {
        C3795h c3795h = this.f13615mjFkc;
        c3795h.f13906YoKzxo.sendMessage(c3795h.f13906YoKzxo.obtainMessage(1, Boolean.valueOf(z)));
    }
}
