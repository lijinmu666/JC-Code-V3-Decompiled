package p131o;

import android.app.Dialog;

/* renamed from: o.ud */
/* loaded from: classes.dex */
public final class C4692ud extends AbstractC4424qc {

    /* renamed from: AZxh */
    public final /* synthetic */ RunnableC4960yd f16859AZxh;

    /* renamed from: mjFkc */
    public final /* synthetic */ Dialog f16860mjFkc;

    public C4692ud(RunnableC4960yd runnableC4960yd, Dialog dialog) {
        this.f16859AZxh = runnableC4960yd;
        this.f16860mjFkc = dialog;
    }

    @Override // p131o.AbstractC4424qc
    /* renamed from: mjFkc */
    public final void mo13271mjFkc() {
        this.f16859AZxh.f17541AZxh.m7854rkYL();
        if (this.f16860mjFkc.isShowing()) {
            this.f16860mjFkc.dismiss();
        }
    }
}
