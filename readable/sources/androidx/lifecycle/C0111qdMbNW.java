package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.AbstractC0112wA;
import androidx.lifecycle.C0111qdMbNW;
import androidx.lifecycle.FragmentC0102Dt;
import p094kotlin.p105jvm.JvmStatic;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p131o.AbstractC2189Ipwl;
import p131o.InterfaceC3068W0;

/* renamed from: androidx.lifecycle.qdMbNW */
/* loaded from: classes.dex */
public final class C0111qdMbNW implements InterfaceC3068W0 {

    /* renamed from: AZxh */
    public int f1391AZxh;

    /* renamed from: KLFTb */
    public Handler f1393KLFTb;

    /* renamed from: mjFkc */
    public int f1396mjFkc;

    /* renamed from: qdMbNW */
    public static final AZxh f1390qdMbNW = new AZxh(null);

    /* renamed from: Dt */
    public static final C0111qdMbNW f1389Dt = new C0111qdMbNW();

    /* renamed from: wA */
    public boolean f1397wA = true;

    /* renamed from: ZfxDd */
    public boolean f1394ZfxDd = true;

    /* renamed from: JHa */
    public final C0103JHa f1392JHa = new C0103JHa(this);

    /* renamed from: xJ */
    public final Runnable f1398xJ = new Runnable() { // from class: o.O3
        @Override // java.lang.Runnable
        public final void run() {
            C0111qdMbNW.m1083Dt(this.f9903mjFkc);
        }
    };

    /* renamed from: lgHUyS */
    public final FragmentC0102Dt.mjFkc f1395lgHUyS = new ZfxDd();

    /* renamed from: androidx.lifecycle.qdMbNW$AZxh */
    public static final class AZxh {
        public /* synthetic */ AZxh(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: AZxh */
        public final void m1092AZxh(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            C0111qdMbNW.f1389Dt.m1090qdMbNW(context);
        }

        /* renamed from: mjFkc */
        public final InterfaceC3068W0 m1093mjFkc() {
            return C0111qdMbNW.f1389Dt;
        }

        public AZxh() {
        }
    }

    /* renamed from: androidx.lifecycle.qdMbNW$ZfxDd */
    public static final class ZfxDd implements FragmentC0102Dt.mjFkc {
        public ZfxDd() {
        }

        @Override // androidx.lifecycle.FragmentC0102Dt.mjFkc
        /* renamed from: AZxh */
        public void mo1031AZxh() {
            C0111qdMbNW.this.m1086KLFTb();
        }

        @Override // androidx.lifecycle.FragmentC0102Dt.mjFkc
        /* renamed from: mjFkc */
        public void mo1032mjFkc() {
        }

        @Override // androidx.lifecycle.FragmentC0102Dt.mjFkc
        /* renamed from: wA */
        public void mo1033wA() {
            C0111qdMbNW.this.m1091xJ();
        }
    }

    /* renamed from: androidx.lifecycle.qdMbNW$mjFkc */
    public static final class mjFkc {

        /* renamed from: mjFkc */
        public static final mjFkc f1400mjFkc = new mjFkc();

        @JvmStatic
        /* renamed from: mjFkc */
        public static final void m1094mjFkc(Activity activity, Application.ActivityLifecycleCallbacks callback) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(callback, "callback");
            activity.registerActivityLifecycleCallbacks(callback);
        }
    }

    /* renamed from: androidx.lifecycle.qdMbNW$wA */
    public static final class wA extends AbstractC2189Ipwl {

        /* renamed from: androidx.lifecycle.qdMbNW$wA$mjFkc */
        public static final class mjFkc extends AbstractC2189Ipwl {

            /* renamed from: this$0 */
            final /* synthetic */ C0111qdMbNW f1402this$0;

            public mjFkc(C0111qdMbNW c0111qdMbNW) {
                this.f1402this$0 = c0111qdMbNW;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                this.f1402this$0.m1086KLFTb();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                this.f1402this$0.m1091xJ();
            }
        }

        public wA() {
        }

        @Override // p131o.AbstractC2189Ipwl, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // p131o.AbstractC2189Ipwl, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            C0111qdMbNW.this.m1088ZfxDd();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            mjFkc.m1094mjFkc(activity, new mjFkc(C0111qdMbNW.this));
        }

        @Override // p131o.AbstractC2189Ipwl, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            C0111qdMbNW.this.m1089lgHUyS();
        }
    }

    /* renamed from: Dt */
    public static final void m1083Dt(C0111qdMbNW this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m1085ETF();
        this$0.m1087VA();
    }

    /* renamed from: ETF */
    public final void m1085ETF() {
        if (this.f1391AZxh == 0) {
            this.f1397wA = true;
            this.f1392JHa.m1043lgHUyS(AbstractC0112wA.mjFkc.ON_PAUSE);
        }
    }

    @Override // p131o.InterfaceC3068W0
    /* renamed from: JHa */
    public AbstractC0112wA mo770JHa() {
        return this.f1392JHa;
    }

    /* renamed from: KLFTb */
    public final void m1086KLFTb() {
        int i = this.f1391AZxh + 1;
        this.f1391AZxh = i;
        if (i == 1) {
            if (this.f1397wA) {
                this.f1392JHa.m1043lgHUyS(AbstractC0112wA.mjFkc.ON_RESUME);
                this.f1397wA = false;
            } else {
                Handler handler = this.f1393KLFTb;
                Intrinsics.checkNotNull(handler);
                handler.removeCallbacks(this.f1398xJ);
            }
        }
    }

    /* renamed from: VA */
    public final void m1087VA() {
        if (this.f1396mjFkc == 0 && this.f1397wA) {
            this.f1392JHa.m1043lgHUyS(AbstractC0112wA.mjFkc.ON_STOP);
            this.f1394ZfxDd = true;
        }
    }

    /* renamed from: ZfxDd */
    public final void m1088ZfxDd() {
        int i = this.f1391AZxh - 1;
        this.f1391AZxh = i;
        if (i == 0) {
            Handler handler = this.f1393KLFTb;
            Intrinsics.checkNotNull(handler);
            handler.postDelayed(this.f1398xJ, 700L);
        }
    }

    /* renamed from: lgHUyS */
    public final void m1089lgHUyS() {
        this.f1396mjFkc--;
        m1087VA();
    }

    /* renamed from: qdMbNW */
    public final void m1090qdMbNW(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f1393KLFTb = new Handler();
        this.f1392JHa.m1043lgHUyS(AbstractC0112wA.mjFkc.ON_CREATE);
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new wA());
    }

    /* renamed from: xJ */
    public final void m1091xJ() {
        int i = this.f1396mjFkc + 1;
        this.f1396mjFkc = i;
        if (i == 1 && this.f1394ZfxDd) {
            this.f1392JHa.m1043lgHUyS(AbstractC0112wA.mjFkc.ON_START);
            this.f1394ZfxDd = false;
        }
    }
}
