package p131o;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: o.IPpyV */
/* loaded from: classes.dex */
public abstract class AbstractC2162IPpyV {

    /* renamed from: o.IPpyV$mjFkc */
    public static class mjFkc {
        /* renamed from: mjFkc */
        public static Handler m8727mjFkc(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    /* renamed from: AZxh */
    public static ThreadPoolExecutor m8723AZxh(final String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactory() { // from class: o.UPU
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return AbstractC2162IPpyV.m8726wA(str, runnable);
            }
        });
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    /* renamed from: ZfxDd */
    public static Handler m8724ZfxDd() {
        return mjFkc.m8727mjFkc(Looper.getMainLooper());
    }

    /* renamed from: wA */
    public static /* synthetic */ Thread m8726wA(String str, Runnable runnable) {
        Thread thread = new Thread(runnable, str);
        thread.setPriority(10);
        return thread;
    }
}
