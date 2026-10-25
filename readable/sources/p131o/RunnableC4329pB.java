package p131o;

import android.os.Bundle;
import com.p038google.p039android.p042gms.p046common.p047api.internal.LifecycleCallback;

/* renamed from: o.pB */
/* loaded from: classes.dex */
public final class RunnableC4329pB implements Runnable {

    /* renamed from: AZxh */
    public final /* synthetic */ String f15911AZxh;

    /* renamed from: mjFkc */
    public final /* synthetic */ LifecycleCallback f15912mjFkc;

    /* renamed from: wA */
    public final /* synthetic */ FragmentC3740gD f15913wA;

    public RunnableC4329pB(FragmentC3740gD fragmentC3740gD, LifecycleCallback lifecycleCallback, String str) {
        this.f15913wA = fragmentC3740gD;
        this.f15912mjFkc = lifecycleCallback;
        this.f15911AZxh = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        FragmentC3740gD fragmentC3740gD = this.f15913wA;
        if (fragmentC3740gD.f13691AZxh > 0) {
            LifecycleCallback lifecycleCallback = this.f15912mjFkc;
            if (fragmentC3740gD.f13693wA != null) {
                bundle = fragmentC3740gD.f13693wA.getBundle(this.f15911AZxh);
            } else {
                bundle = null;
            }
            lifecycleCallback.mo2386JHa(bundle);
        }
        if (this.f15913wA.f13691AZxh >= 2) {
            this.f15912mjFkc.mo2384Dt();
        }
        if (this.f15913wA.f13691AZxh >= 3) {
            this.f15912mjFkc.mo2388lgHUyS();
        }
        if (this.f15913wA.f13691AZxh >= 4) {
            this.f15912mjFkc.mo2385ETF();
        }
        if (this.f15913wA.f13691AZxh >= 5) {
            this.f15912mjFkc.m2391xJ();
        }
    }
}
