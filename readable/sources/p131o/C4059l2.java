package p131o;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: o.l2 */
/* loaded from: classes.dex */
public class C4059l2 extends AbstractExecutorServiceC2811SC {

    /* renamed from: AZxh */
    public static final ThreadLocal f14662AZxh = new ThreadLocal();

    /* renamed from: mjFkc */
    public final ThreadPoolExecutor f14663mjFkc;

    public C4059l2() {
        final ThreadFactory threadFactoryDefaultThreadFactory = Executors.defaultThreadFactory();
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(iAvailableProcessors, iAvailableProcessors, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: o.BM
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(final Runnable runnable) {
                return threadFactoryDefaultThreadFactory.newThread(new Runnable() { // from class: o.IN
                    @Override // java.lang.Runnable
                    public final void run() {
                        C4059l2.m12651lgHUyS(runnable);
                    }
                });
            }
        });
        this.f14663mjFkc = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    /* renamed from: lgHUyS */
    public static /* synthetic */ void m12651lgHUyS(Runnable runnable) {
        f14662AZxh.set(new ArrayDeque());
        runnable.run();
    }

    /* renamed from: qdMbNW */
    public static void m12652qdMbNW(Deque deque, Runnable runnable) {
        AbstractC2138I3.m8648xJ(deque);
        deque.add(runnable);
        if (deque.size() <= 1) {
            do {
                runnable.run();
                deque.removeFirst();
                runnable = (Runnable) deque.peekFirst();
            } while (runnable != null);
        }
    }

    @Override // p131o.AbstractExecutorServiceC2811SC
    /* renamed from: KLFTb */
    public final ExecutorService mo10139KLFTb() {
        return this.f14663mjFkc;
    }

    @Override // p131o.AbstractC3302ZW
    /* renamed from: ZfxDd */
    public final /* synthetic */ Object mo11201ZfxDd() {
        return this.f14663mjFkc;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(final Runnable runnable) {
        Deque deque = (Deque) f14662AZxh.get();
        if (deque == null || deque.size() > 1) {
            this.f14663mjFkc.execute(new Runnable() { // from class: o.sL
                @Override // java.lang.Runnable
                public final void run() {
                    C4059l2.m12652qdMbNW((Deque) C4059l2.f14662AZxh.get(), runnable);
                }
            });
        } else {
            m12652qdMbNW(deque, runnable);
        }
    }
}
