package p131o;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: o.G7 */
/* loaded from: classes.dex */
public class C2010G7 {

    /* renamed from: AZxh */
    public boolean f8331AZxh;

    /* renamed from: mjFkc */
    public final Object f8333mjFkc = new Object();

    /* renamed from: wA */
    public final Queue f8334wA = new ArrayDeque();

    /* renamed from: ZfxDd */
    public final AtomicReference f8332ZfxDd = new AtomicReference();

    /* renamed from: KLFTb */
    public final void m8407KLFTb(Executor executor, final Runnable runnable) {
        try {
            executor.execute(new Runnable() { // from class: o.sV
                @Override // java.lang.Runnable
                public final void run() {
                    C3236YW c3236yw = new C3236YW(this.f16514mjFkc, null);
                    try {
                        runnable.run();
                        c3236yw.close();
                    } catch (Throwable th) {
                        try {
                            c3236yw.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
            m8408ZfxDd();
        }
    }

    /* renamed from: ZfxDd */
    public final void m8408ZfxDd() {
        synchronized (this.f8333mjFkc) {
            try {
                if (this.f8334wA.isEmpty()) {
                    this.f8331AZxh = false;
                } else {
                    C1766CW c1766cw = (C1766CW) this.f8334wA.remove();
                    m8407KLFTb(c1766cw.f7633mjFkc, c1766cw.f7632AZxh);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: mjFkc */
    public void m8409mjFkc(Executor executor, Runnable runnable) {
        synchronized (this.f8333mjFkc) {
            try {
                if (this.f8331AZxh) {
                    this.f8334wA.add(new C1766CW(executor, runnable, null));
                } else {
                    this.f8331AZxh = true;
                    m8407KLFTb(executor, runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
