package p131o;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: o.Eey */
/* loaded from: classes.dex */
public class C1905Eey extends AbstractC1868E7 {

    /* renamed from: wA */
    public volatile Handler f8027wA;

    /* renamed from: mjFkc */
    public final Object f8026mjFkc = new Object();

    /* renamed from: AZxh */
    public final ExecutorService f8025AZxh = Executors.newFixedThreadPool(4, new mjFkc());

    /* renamed from: o.Eey$AZxh */
    public static class AZxh {
        /* renamed from: mjFkc */
        public static Handler m8169mjFkc(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    /* renamed from: o.Eey$mjFkc */
    public class mjFkc implements ThreadFactory {

        /* renamed from: mjFkc */
        public final AtomicInteger f8029mjFkc = new AtomicInteger(0);

        public mjFkc() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("arch_disk_io_" + this.f8029mjFkc.getAndIncrement());
            return thread;
        }
    }

    /* renamed from: ZfxDd */
    public static Handler m8168ZfxDd(Looper looper) {
        return AZxh.m8169mjFkc(looper);
    }

    @Override // p131o.AbstractC1868E7
    /* renamed from: AZxh */
    public boolean mo8107AZxh() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override // p131o.AbstractC1868E7
    /* renamed from: mjFkc */
    public void mo8108mjFkc(Runnable runnable) {
        this.f8025AZxh.execute(runnable);
    }

    @Override // p131o.AbstractC1868E7
    /* renamed from: wA */
    public void mo8109wA(Runnable runnable) {
        if (this.f8027wA == null) {
            synchronized (this.f8026mjFkc) {
                try {
                    if (this.f8027wA == null) {
                        this.f8027wA = m8168ZfxDd(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        this.f8027wA.post(runnable);
    }
}
