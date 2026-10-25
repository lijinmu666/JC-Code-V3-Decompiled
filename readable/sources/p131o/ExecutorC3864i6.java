package p131o;

import java.util.concurrent.Executor;

/* renamed from: o.i6 */
/* loaded from: classes.dex */
public class ExecutorC3864i6 implements Executor {

    /* renamed from: mjFkc */
    public final Executor f14122mjFkc;

    /* renamed from: o.i6$mjFkc */
    public static class mjFkc implements Runnable {

        /* renamed from: mjFkc */
        public final Runnable f14123mjFkc;

        public mjFkc(Runnable runnable) {
            this.f14123mjFkc = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f14123mjFkc.run();
            } catch (Exception e) {
                AbstractC4122m1.m12738wA("Executor", "Background execution failure.", e);
            }
        }
    }

    public ExecutorC3864i6(Executor executor) {
        this.f14122mjFkc = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f14122mjFkc.execute(new mjFkc(runnable));
    }
}
