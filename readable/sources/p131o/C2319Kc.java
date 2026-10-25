package p131o;

import android.app.Activity;
import android.content.Intent;

/* renamed from: o.Kc */
/* loaded from: classes.dex */
public final class C2319Kc extends AbstractDialogInterfaceOnClickListenerC3374ad {

    /* renamed from: AZxh */
    public final /* synthetic */ Activity f9204AZxh;

    /* renamed from: mjFkc */
    public final /* synthetic */ Intent f9205mjFkc;

    /* renamed from: wA */
    public final /* synthetic */ int f9206wA;

    public C2319Kc(Intent intent, Activity activity, int i) {
        this.f9205mjFkc = intent;
        this.f9204AZxh = activity;
        this.f9206wA = i;
    }

    @Override // p131o.AbstractDialogInterfaceOnClickListenerC3374ad
    /* renamed from: mjFkc */
    public final void mo9268mjFkc() {
        Intent intent = this.f9205mjFkc;
        if (intent != null) {
            this.f9204AZxh.startActivityForResult(intent, this.f9206wA);
        }
    }
}
