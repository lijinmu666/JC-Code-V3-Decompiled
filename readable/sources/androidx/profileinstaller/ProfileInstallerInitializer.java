package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.profileinstaller.AbstractC0121wA;
import androidx.profileinstaller.ProfileInstallerInitializer;
import com.indidevs.p086android.p087adbeesh.notifications.NotificationFlowConfig;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p131o.InterfaceC2343L;

/* loaded from: classes.dex */
public class ProfileInstallerInitializer implements InterfaceC2343L {

    /* renamed from: androidx.profileinstaller.ProfileInstallerInitializer$AZxh */
    public static class C0116AZxh {
        /* renamed from: mjFkc */
        public static Handler m1139mjFkc(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    /* renamed from: androidx.profileinstaller.ProfileInstallerInitializer$mjFkc */
    public static class C0117mjFkc {
        /* renamed from: wA */
        public static void m1142wA(final Runnable runnable) {
            Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: o.V3
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j) {
                    runnable.run();
                }
            });
        }
    }

    /* renamed from: androidx.profileinstaller.ProfileInstallerInitializer$wA */
    public static class C0118wA {
    }

    /* renamed from: VA */
    public static void m1132VA(final Context context) {
        new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new Runnable() { // from class: o.U3
            @Override // java.lang.Runnable
            public final void run() throws PackageManager.NameNotFoundException {
                AbstractC0121wA.m1162qdMbNW(context);
            }
        });
    }

    @Override // p131o.InterfaceC2343L
    /* renamed from: JHa, reason: merged with bridge method [inline-methods] */
    public C0118wA mo626AZxh(Context context) {
        m1138xJ(context.getApplicationContext());
        return new C0118wA();
    }

    /* renamed from: lgHUyS, reason: merged with bridge method [inline-methods] */
    public void m1137qdMbNW(final Context context) {
        C0116AZxh.m1139mjFkc(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: o.T3
            @Override // java.lang.Runnable
            public final void run() {
                ProfileInstallerInitializer.m1132VA(context);
            }
        }, new Random().nextInt(Math.max(NotificationFlowConfig.DEFAULT_BASE_REQUEST_CODE, 1)) + 5000);
    }

    @Override // p131o.InterfaceC2343L
    /* renamed from: mjFkc */
    public List mo629mjFkc() {
        return Collections.emptyList();
    }

    /* renamed from: xJ */
    public void m1138xJ(final Context context) {
        C0117mjFkc.m1142wA(new Runnable() { // from class: o.S3
            @Override // java.lang.Runnable
            public final void run() {
                this.f10512mjFkc.m1137qdMbNW(context);
            }
        });
    }
}
