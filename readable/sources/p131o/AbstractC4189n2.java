package p131o;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: o.n2 */
/* loaded from: classes.dex */
public abstract class AbstractC4189n2 {

    /* renamed from: mjFkc */
    public final C2010G7 f15300mjFkc;

    /* renamed from: AZxh */
    public final AtomicInteger f15299AZxh = new AtomicInteger(0);

    /* renamed from: wA */
    public final AtomicBoolean f15301wA = new AtomicBoolean(false);

    public AbstractC4189n2(C2010G7 c2010g7) {
        this.f15300mjFkc = c2010g7;
    }

    /* renamed from: AZxh */
    public abstract void mo12280AZxh();

    /* renamed from: JHa */
    public AbstractC1670B7 m12839JHa(Executor executor) {
        AbstractC2138I3.m8646qdMbNW(this.f15299AZxh.get() > 0);
        final C1806D7 c1806d7 = new C1806D7();
        this.f15300mjFkc.m8409mjFkc(executor, new Runnable() { // from class: o.RO
            @Override // java.lang.Runnable
            public final void run() {
                this.f10411mjFkc.m12841lgHUyS(c1806d7);
            }
        });
        return c1806d7.m7977mjFkc();
    }

    /* renamed from: KLFTb */
    public void m12840KLFTb(Executor executor) {
        m12839JHa(executor);
    }

    /* renamed from: ZfxDd */
    public abstract void mo12285ZfxDd();

    /* renamed from: lgHUyS */
    public final /* synthetic */ void m12841lgHUyS(C1806D7 c1806d7) {
        int iDecrementAndGet = this.f15299AZxh.decrementAndGet();
        AbstractC2138I3.m8646qdMbNW(iDecrementAndGet >= 0);
        if (iDecrementAndGet == 0) {
            mo12285ZfxDd();
            this.f15301wA.set(false);
        }
        AbstractC3565dU.m11726mjFkc();
        c1806d7.m7978wA(null);
    }

    /* renamed from: mjFkc */
    public AbstractC1670B7 m12842mjFkc(final Executor executor, final Callable callable, final AbstractC2924Tw abstractC2924Tw) {
        AbstractC2138I3.m8646qdMbNW(this.f15299AZxh.get() > 0);
        if (abstractC2924Tw.mo10446mjFkc()) {
            return AbstractC2142I7.m8715mjFkc();
        }
        final C2731QyqF c2731QyqF = new C2731QyqF();
        final C1806D7 c1806d7 = new C1806D7(c2731QyqF.m10033AZxh());
        this.f15300mjFkc.m8409mjFkc(new Executor() { // from class: o.cQ
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                try {
                    executor.execute(runnable);
                } catch (RuntimeException e) {
                    if (abstractC2924Tw.mo10446mjFkc()) {
                        c2731QyqF.m10034mjFkc();
                    } else {
                        c1806d7.m7974AZxh(e);
                    }
                    throw e;
                }
            }
        }, new Runnable() { // from class: o.jR
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                this.f14312mjFkc.m12844xJ(abstractC2924Tw, c2731QyqF, callable, c1806d7);
            }
        });
        return c1806d7.m7977mjFkc();
    }

    /* renamed from: wA */
    public void m12843wA() {
        this.f15299AZxh.incrementAndGet();
    }

    /* renamed from: xJ */
    public final /* synthetic */ void m12844xJ(AbstractC2924Tw abstractC2924Tw, C2731QyqF c2731QyqF, Callable callable, C1806D7 c1806d7) throws Exception {
        try {
            if (abstractC2924Tw.mo10446mjFkc()) {
                c2731QyqF.m10034mjFkc();
                return;
            }
            try {
                if (!this.f15301wA.get()) {
                    mo12280AZxh();
                    this.f15301wA.set(true);
                }
                if (abstractC2924Tw.mo10446mjFkc()) {
                    c2731QyqF.m10034mjFkc();
                    return;
                }
                Object objCall = callable.call();
                if (abstractC2924Tw.mo10446mjFkc()) {
                    c2731QyqF.m10034mjFkc();
                } else {
                    c1806d7.m7978wA(objCall);
                }
            } catch (RuntimeException e) {
                throw new C3993k2("Internal error has occurred when executing ML Kit tasks", 13, e);
            }
        } catch (Exception e2) {
            if (abstractC2924Tw.mo10446mjFkc()) {
                c2731QyqF.m10034mjFkc();
            } else {
                c1806d7.m7974AZxh(e2);
            }
        }
    }
}
