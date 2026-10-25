package p131o;

import android.content.Intent;

/* renamed from: o.Zc */
/* loaded from: classes.dex */
public final class C3305Zc extends AbstractDialogInterfaceOnClickListenerC3374ad {

    /* renamed from: AZxh */
    public final /* synthetic */ InterfaceC2929U0 f12171AZxh;

    /* renamed from: mjFkc */
    public final /* synthetic */ Intent f12172mjFkc;

    public C3305Zc(Intent intent, InterfaceC2929U0 interfaceC2929U0, int i) {
        this.f12172mjFkc = intent;
        this.f12171AZxh = interfaceC2929U0;
    }

    @Override // p131o.AbstractDialogInterfaceOnClickListenerC3374ad
    /* renamed from: mjFkc */
    public final void mo9268mjFkc() {
        Intent intent = this.f12172mjFkc;
        if (intent != null) {
            this.f12171AZxh.startActivityForResult(intent, 2);
        }
    }
}
