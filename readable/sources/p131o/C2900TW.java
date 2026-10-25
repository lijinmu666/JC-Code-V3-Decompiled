package p131o;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* renamed from: o.TW */
/* loaded from: classes.dex */
public final class C2900TW extends AbstractC1670B7 {

    /* renamed from: JHa */
    public Exception f10705JHa;

    /* renamed from: KLFTb */
    public Object f10706KLFTb;

    /* renamed from: ZfxDd */
    public volatile boolean f10707ZfxDd;

    /* renamed from: wA */
    public boolean f10709wA;

    /* renamed from: mjFkc */
    public final Object f10708mjFkc = new Object();

    /* renamed from: AZxh */
    public final C2102HT f10704AZxh = new C2102HT();

    @Override // p131o.AbstractC1670B7
    /* renamed from: AZxh */
    public final AbstractC1670B7 mo7663AZxh(InterfaceC3270Z2 interfaceC3270Z2) {
        this.f10704AZxh.m8575mjFkc(new C1620AM(AbstractC1937F7.f8135mjFkc, interfaceC3270Z2));
        m10424diqgf();
        return this;
    }

    /* renamed from: Dt */
    public final AbstractC1670B7 m10417Dt(Executor executor, InterfaceC3405b3 interfaceC3405b3) {
        this.f10704AZxh.m8575mjFkc(new C2692QO(executor, interfaceC3405b3));
        m10424diqgf();
        return this;
    }

    /* renamed from: ETF */
    public final AbstractC1670B7 m10418ETF(Executor executor, InterfaceC3665f3 interfaceC3665f3) {
        this.f10704AZxh.m8575mjFkc(new C3887iR(executor, interfaceC3665f3));
        m10424diqgf();
        return this;
    }

    /* renamed from: IEE */
    public final void m10419IEE() {
        if (this.f10707ZfxDd) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    @Override // p131o.AbstractC1670B7
    /* renamed from: JHa */
    public final Object mo7664JHa() {
        Object obj;
        synchronized (this.f10708mjFkc) {
            try {
                m10425fehf();
                m10419IEE();
                Exception exc = this.f10705JHa;
                if (exc != null) {
                    throw new C2282K5(exc);
                }
                obj = this.f10706KLFTb;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    @Override // p131o.AbstractC1670B7
    /* renamed from: KLFTb */
    public final Exception mo7665KLFTb() {
        Exception exc;
        synchronized (this.f10708mjFkc) {
            exc = this.f10705JHa;
        }
        return exc;
    }

    /* renamed from: MiMN */
    public final void m10420MiMN(Object obj) {
        synchronized (this.f10708mjFkc) {
            m10421Pq();
            this.f10709wA = true;
            this.f10706KLFTb = obj;
        }
        this.f10704AZxh.m8574AZxh(this);
    }

    /* renamed from: Pq */
    public final void m10421Pq() {
        if (this.f10709wA) {
            throw C1978FiDh.m8318mjFkc(this);
        }
    }

    /* renamed from: VA */
    public final void m10422VA(Exception exc) {
        AbstractC2138I3.m8644lgHUyS(exc, "Exception must not be null");
        synchronized (this.f10708mjFkc) {
            m10421Pq();
            this.f10709wA = true;
            this.f10705JHa = exc;
        }
        this.f10704AZxh.m8574AZxh(this);
    }

    /* renamed from: YoKzxo */
    public final boolean m10423YoKzxo() {
        synchronized (this.f10708mjFkc) {
            try {
                if (this.f10709wA) {
                    return false;
                }
                this.f10709wA = true;
                this.f10707ZfxDd = true;
                this.f10704AZxh.m8574AZxh(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p131o.AbstractC1670B7
    /* renamed from: ZfxDd */
    public final AbstractC1670B7 mo7666ZfxDd(InterfaceC3665f3 interfaceC3665f3) {
        m10418ETF(AbstractC1937F7.f8135mjFkc, interfaceC3665f3);
        return this;
    }

    /* renamed from: diqgf */
    public final void m10424diqgf() {
        synchronized (this.f10708mjFkc) {
            try {
                if (this.f10709wA) {
                    this.f10704AZxh.m8574AZxh(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: fehf */
    public final void m10425fehf() {
        AbstractC2138I3.m8640Dt(this.f10709wA, "Task is not yet complete");
    }

    @Override // p131o.AbstractC1670B7
    /* renamed from: lgHUyS */
    public final boolean mo7667lgHUyS() {
        boolean z;
        synchronized (this.f10708mjFkc) {
            z = this.f10709wA;
        }
        return z;
    }

    @Override // p131o.AbstractC1670B7
    /* renamed from: mjFkc */
    public final AbstractC1670B7 mo7668mjFkc(Executor executor, InterfaceC3270Z2 interfaceC3270Z2) {
        this.f10704AZxh.m8575mjFkc(new C1620AM(executor, interfaceC3270Z2));
        m10424diqgf();
        return this;
    }

    /* renamed from: qGY */
    public final boolean m10426qGY(Object obj) {
        synchronized (this.f10708mjFkc) {
            try {
                if (this.f10709wA) {
                    return false;
                }
                this.f10709wA = true;
                this.f10706KLFTb = obj;
                this.f10704AZxh.m8574AZxh(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p131o.AbstractC1670B7
    /* renamed from: qdMbNW */
    public final boolean mo7669qdMbNW() {
        boolean z;
        synchronized (this.f10708mjFkc) {
            try {
                z = false;
                if (this.f10709wA && !this.f10707ZfxDd && this.f10705JHa == null) {
                    z = true;
                }
            } finally {
            }
        }
        return z;
    }

    /* renamed from: rkYL */
    public final boolean m10427rkYL(Exception exc) {
        AbstractC2138I3.m8644lgHUyS(exc, "Exception must not be null");
        synchronized (this.f10708mjFkc) {
            try {
                if (this.f10709wA) {
                    return false;
                }
                this.f10709wA = true;
                this.f10705JHa = exc;
                this.f10704AZxh.m8574AZxh(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // p131o.AbstractC1670B7
    /* renamed from: wA */
    public final AbstractC1670B7 mo7670wA(InterfaceC3405b3 interfaceC3405b3) {
        m10417Dt(AbstractC1937F7.f8135mjFkc, interfaceC3405b3);
        return this;
    }

    @Override // p131o.AbstractC1670B7
    /* renamed from: xJ */
    public final boolean mo7671xJ() {
        return this.f10707ZfxDd;
    }
}
