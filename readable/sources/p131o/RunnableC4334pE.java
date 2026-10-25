package p131o;

import android.os.Bundle;
import com.p038google.p039android.p042gms.p046common.p047api.internal.LifecycleCallback;

/* renamed from: o.pE */
/* loaded from: classes.dex */
public final class RunnableC4334pE implements Runnable {

    /* renamed from: AZxh */
    public final /* synthetic */ String f15928AZxh;

    /* renamed from: mjFkc */
    public final /* synthetic */ LifecycleCallback f15929mjFkc;

    /* renamed from: wA */
    public final /* synthetic */ C2084HF f15930wA;

    public RunnableC4334pE(C2084HF c2084hf, LifecycleCallback lifecycleCallback, String str) {
        this.f15930wA = c2084hf;
        this.f15929mjFkc = lifecycleCallback;
        this.f15928AZxh = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        C2084HF c2084hf = this.f15930wA;
        if (c2084hf.f8564nxI > 0) {
            LifecycleCallback lifecycleCallback = this.f15929mjFkc;
            if (c2084hf.f8563WGXroI != null) {
                bundle = c2084hf.f8563WGXroI.getBundle(this.f15928AZxh);
            } else {
                bundle = null;
            }
            lifecycleCallback.mo2386JHa(bundle);
        }
        if (this.f15930wA.f8564nxI >= 2) {
            this.f15929mjFkc.mo2384Dt();
        }
        if (this.f15930wA.f8564nxI >= 3) {
            this.f15929mjFkc.mo2388lgHUyS();
        }
        if (this.f15930wA.f8564nxI >= 4) {
            this.f15929mjFkc.mo2385ETF();
        }
        if (this.f15930wA.f8564nxI >= 5) {
            this.f15929mjFkc.m2391xJ();
        }
    }
}
