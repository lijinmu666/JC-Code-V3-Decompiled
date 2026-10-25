package p131o;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: o.m5 */
/* loaded from: classes.dex */
public abstract class AbstractC4126m5 {

    /* renamed from: o.m5$AZxh */
    public static class AZxh implements Runnable {

        /* renamed from: AZxh */
        public InterfaceC2317KbE f14863AZxh;

        /* renamed from: mjFkc */
        public Callable f14864mjFkc;

        /* renamed from: wA */
        public Handler f14865wA;

        /* renamed from: o.m5$AZxh$mjFkc */
        public class mjFkc implements Runnable {

            /* renamed from: AZxh */
            public final /* synthetic */ Object f14866AZxh;

            /* renamed from: mjFkc */
            public final /* synthetic */ InterfaceC2317KbE f14867mjFkc;

            public mjFkc(InterfaceC2317KbE interfaceC2317KbE, Object obj) {
                this.f14867mjFkc = interfaceC2317KbE;
                this.f14866AZxh = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f14867mjFkc.mo9246mjFkc(this.f14866AZxh);
            }
        }

        public AZxh(Handler handler, Callable callable, InterfaceC2317KbE interfaceC2317KbE) {
            this.f14864mjFkc = callable;
            this.f14863AZxh = interfaceC2317KbE;
            this.f14865wA = handler;
        }

        @Override // java.lang.Runnable
        public void run() throws Exception {
            Object objCall;
            try {
                objCall = this.f14864mjFkc.call();
            } catch (Exception unused) {
                objCall = null;
            }
            this.f14865wA.post(new mjFkc(this.f14863AZxh, objCall));
        }
    }

    /* renamed from: o.m5$mjFkc */
    public static class mjFkc implements ThreadFactory {

        /* renamed from: AZxh */
        public int f14869AZxh;

        /* renamed from: mjFkc */
        public String f14870mjFkc;

        /* renamed from: o.m5$mjFkc$mjFkc, reason: collision with other inner class name */
        public static class C6367mjFkc extends Thread {

            /* renamed from: mjFkc */
            public final int f14871mjFkc;

            public C6367mjFkc(Runnable runnable, String str, int i) {
                super(runnable, str);
                this.f14871mjFkc = i;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws SecurityException, IllegalArgumentException {
                Process.setThreadPriority(this.f14871mjFkc);
                super.run();
            }
        }

        public mjFkc(String str, int i) {
            this.f14870mjFkc = str;
            this.f14869AZxh = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C6367mjFkc(runnable, this.f14870mjFkc, this.f14869AZxh);
        }
    }

    /* renamed from: AZxh */
    public static void m12740AZxh(Executor executor, Callable callable, InterfaceC2317KbE interfaceC2317KbE) {
        executor.execute(new AZxh(AbstractC1763CTcA.m7846mjFkc(), callable, interfaceC2317KbE));
    }

    /* renamed from: mjFkc */
    public static ThreadPoolExecutor m12741mjFkc(String str, int i, int i2) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i2, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new mjFkc(str, i));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    /* renamed from: wA */
    public static Object m12742wA(ExecutorService executorService, Callable callable, int i) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw e;
        } catch (ExecutionException e2) {
            throw new RuntimeException(e2);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
