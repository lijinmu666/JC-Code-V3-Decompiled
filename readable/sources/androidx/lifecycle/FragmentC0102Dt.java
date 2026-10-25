package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0112wA;
import p094kotlin.p105jvm.JvmStatic;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p131o.InterfaceC3068W0;

/* renamed from: androidx.lifecycle.Dt */
/* loaded from: classes.dex */
public class FragmentC0102Dt extends Fragment {

    /* renamed from: AZxh */
    public static final AZxh f1341AZxh = new AZxh(null);

    /* renamed from: mjFkc */
    public mjFkc f1342mjFkc;

    /* renamed from: androidx.lifecycle.Dt$AZxh */
    public static final class AZxh {
        public /* synthetic */ AZxh(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: AZxh */
        public final void m1029AZxh(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            wA.Companion.m1034mjFkc(activity);
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
                fragmentManager.beginTransaction().add(new FragmentC0102Dt(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
                fragmentManager.executePendingTransactions();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: mjFkc */
        public final void m1030mjFkc(Activity activity, AbstractC0112wA.mjFkc event) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(event, "event");
            if (activity instanceof InterfaceC3068W0) {
                AbstractC0112wA abstractC0112wAMo770JHa = ((InterfaceC3068W0) activity).mo770JHa();
                if (abstractC0112wAMo770JHa instanceof C0103JHa) {
                    ((C0103JHa) abstractC0112wAMo770JHa).m1043lgHUyS(event);
                }
            }
        }

        public AZxh() {
        }
    }

    /* renamed from: androidx.lifecycle.Dt$mjFkc */
    public interface mjFkc {
        /* renamed from: AZxh */
        void mo1031AZxh();

        /* renamed from: mjFkc */
        void mo1032mjFkc();

        /* renamed from: wA */
        void mo1033wA();
    }

    /* renamed from: androidx.lifecycle.Dt$wA */
    public static final class wA implements Application.ActivityLifecycleCallbacks {
        public static final mjFkc Companion = new mjFkc(null);

        /* renamed from: androidx.lifecycle.Dt$wA$mjFkc */
        public static final class mjFkc {
            public /* synthetic */ mjFkc(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: mjFkc */
            public final void m1034mjFkc(Activity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                activity.registerActivityLifecycleCallbacks(new wA());
            }

            public mjFkc() {
            }
        }

        @JvmStatic
        public static final void registerIn(Activity activity) {
            Companion.m1034mjFkc(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            FragmentC0102Dt.f1341AZxh.m1030mjFkc(activity, AbstractC0112wA.mjFkc.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            FragmentC0102Dt.f1341AZxh.m1030mjFkc(activity, AbstractC0112wA.mjFkc.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            FragmentC0102Dt.f1341AZxh.m1030mjFkc(activity, AbstractC0112wA.mjFkc.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            FragmentC0102Dt.f1341AZxh.m1030mjFkc(activity, AbstractC0112wA.mjFkc.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            FragmentC0102Dt.f1341AZxh.m1030mjFkc(activity, AbstractC0112wA.mjFkc.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            FragmentC0102Dt.f1341AZxh.m1030mjFkc(activity, AbstractC0112wA.mjFkc.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
        }
    }

    /* renamed from: AZxh */
    public final void m1025AZxh(mjFkc mjfkc) {
        if (mjfkc != null) {
            mjfkc.mo1032mjFkc();
        }
    }

    /* renamed from: ZfxDd */
    public final void m1026ZfxDd(mjFkc mjfkc) {
        if (mjfkc != null) {
            mjfkc.mo1033wA();
        }
    }

    /* renamed from: mjFkc */
    public final void m1027mjFkc(AbstractC0112wA.mjFkc mjfkc) {
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m1025AZxh(this.f1342mjFkc);
        m1027mjFkc(AbstractC0112wA.mjFkc.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        m1027mjFkc(AbstractC0112wA.mjFkc.ON_DESTROY);
        this.f1342mjFkc = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        m1027mjFkc(AbstractC0112wA.mjFkc.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        m1028wA(this.f1342mjFkc);
        m1027mjFkc(AbstractC0112wA.mjFkc.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        m1026ZfxDd(this.f1342mjFkc);
        m1027mjFkc(AbstractC0112wA.mjFkc.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        m1027mjFkc(AbstractC0112wA.mjFkc.ON_STOP);
    }

    /* renamed from: wA */
    public final void m1028wA(mjFkc mjfkc) {
        if (mjfkc != null) {
            mjfkc.mo1031AZxh();
        }
    }
}
