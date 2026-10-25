package p131o;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* renamed from: o.s1 */
/* loaded from: classes.dex */
public class C4521s1 {

    /* renamed from: AZxh */
    public static final Object f16409AZxh = new Object();

    /* renamed from: wA */
    public static C4521s1 f16410wA;

    /* renamed from: mjFkc */
    public final Handler f16411mjFkc;

    public C4521s1(Looper looper) {
        this.f16411mjFkc = new HandlerC4730vB(looper);
    }

    /* renamed from: ZfxDd */
    public static Executor m13441ZfxDd() {
        return EnumC3942jK.f14301mjFkc;
    }

    /* renamed from: mjFkc */
    public static C4521s1 m13442mjFkc() {
        C4521s1 c4521s1;
        synchronized (f16409AZxh) {
            try {
                if (f16410wA == null) {
                    HandlerThread handlerThread = new HandlerThread("MLHandler", 9);
                    handlerThread.start();
                    f16410wA = new C4521s1(handlerThread.getLooper());
                }
                c4521s1 = f16410wA;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c4521s1;
    }

    /* renamed from: AZxh */
    public AbstractC1670B7 m13443AZxh(final Callable callable) {
        final C1806D7 c1806d7 = new C1806D7();
        m13444wA(new Runnable() { // from class: o.SH
            @Override // java.lang.Runnable
            public final void run() {
                Callable callable2 = callable;
                C1806D7 c1806d72 = c1806d7;
                try {
                    c1806d72.m7978wA(callable2.call());
                } catch (C3993k2 e) {
                    c1806d72.m7974AZxh(e);
                } catch (Exception e2) {
                    c1806d72.m7974AZxh(new C3993k2("Internal error has occurred when executing ML Kit tasks", 13, e2));
                }
            }
        });
        return c1806d7.m7977mjFkc();
    }

    /* renamed from: wA */
    public void m13444wA(Runnable runnable) {
        m13441ZfxDd().execute(runnable);
    }
}
