package p131o;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: o.Zdbk */
/* loaded from: classes.dex */
public final class ComponentCallbacks2C3307Zdbk implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: KLFTb */
    public static final ComponentCallbacks2C3307Zdbk f12173KLFTb = new ComponentCallbacks2C3307Zdbk();

    /* renamed from: mjFkc */
    public final AtomicBoolean f12176mjFkc = new AtomicBoolean();

    /* renamed from: AZxh */
    public final AtomicBoolean f12174AZxh = new AtomicBoolean();

    /* renamed from: wA */
    public final ArrayList f12177wA = new ArrayList();

    /* renamed from: ZfxDd */
    public boolean f12175ZfxDd = false;

    /* renamed from: o.Zdbk$mjFkc */
    public interface mjFkc {
        /* renamed from: mjFkc */
        void mo11209mjFkc(boolean z);
    }

    /* renamed from: AZxh */
    public static ComponentCallbacks2C3307Zdbk m11203AZxh() {
        return f12173KLFTb;
    }

    /* renamed from: wA */
    public static void m11204wA(Application application) {
        ComponentCallbacks2C3307Zdbk componentCallbacks2C3307Zdbk = f12173KLFTb;
        synchronized (componentCallbacks2C3307Zdbk) {
            try {
                if (!componentCallbacks2C3307Zdbk.f12175ZfxDd) {
                    application.registerActivityLifecycleCallbacks(componentCallbacks2C3307Zdbk);
                    application.registerComponentCallbacks(componentCallbacks2C3307Zdbk);
                    componentCallbacks2C3307Zdbk.f12175ZfxDd = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: JHa */
    public final void m11205JHa(boolean z) {
        synchronized (f12173KLFTb) {
            try {
                Iterator it = this.f12177wA.iterator();
                while (it.hasNext()) {
                    ((mjFkc) it.next()).mo11209mjFkc(z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: KLFTb */
    public boolean m11206KLFTb(boolean z) {
        if (!this.f12174AZxh.get()) {
            if (!AbstractC4856x3.m13895mjFkc()) {
                return z;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f12174AZxh.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f12176mjFkc.set(true);
            }
        }
        return m11207ZfxDd();
    }

    /* renamed from: ZfxDd */
    public boolean m11207ZfxDd() {
        return this.f12176mjFkc.get();
    }

    /* renamed from: mjFkc */
    public void m11208mjFkc(mjFkc mjfkc) {
        synchronized (f12173KLFTb) {
            this.f12177wA.add(mjfkc);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AtomicBoolean atomicBoolean = this.f12174AZxh;
        boolean zCompareAndSet = this.f12176mjFkc.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (zCompareAndSet) {
            m11205JHa(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        AtomicBoolean atomicBoolean = this.f12174AZxh;
        boolean zCompareAndSet = this.f12176mjFkc.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (zCompareAndSet) {
            m11205JHa(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        if (i == 20 && this.f12176mjFkc.compareAndSet(false, true)) {
            this.f12174AZxh.set(true);
            m11205JHa(true);
        }
    }
}
