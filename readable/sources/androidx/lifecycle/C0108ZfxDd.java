package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;
import p094kotlin.p105jvm.internal.Intrinsics;
import p131o.AbstractC2189Ipwl;

/* renamed from: androidx.lifecycle.ZfxDd */
/* loaded from: classes.dex */
public final class C0108ZfxDd {

    /* renamed from: mjFkc */
    public static final C0108ZfxDd f1381mjFkc = new C0108ZfxDd();

    /* renamed from: AZxh */
    public static final AtomicBoolean f1380AZxh = new AtomicBoolean(false);

    /* renamed from: androidx.lifecycle.ZfxDd$mjFkc */
    public static final class mjFkc extends AbstractC2189Ipwl {
        @Override // p131o.AbstractC2189Ipwl, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            FragmentC0102Dt.f1341AZxh.m1029AZxh(activity);
        }
    }

    /* renamed from: mjFkc */
    public static final void m1071mjFkc(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (f1380AZxh.getAndSet(true)) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new mjFkc());
    }
}
