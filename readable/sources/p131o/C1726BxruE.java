package p131o;

import android.os.CancellationSignal;

/* renamed from: o.BxruE */
/* loaded from: classes.dex */
public final class C1726BxruE {

    /* renamed from: AZxh */
    public mjFkc f7539AZxh;

    /* renamed from: ZfxDd */
    public boolean f7540ZfxDd;

    /* renamed from: mjFkc */
    public boolean f7541mjFkc;

    /* renamed from: wA */
    public Object f7542wA;

    /* renamed from: o.BxruE$mjFkc */
    public interface mjFkc {
        /* renamed from: mjFkc */
        void mo752mjFkc();
    }

    /* renamed from: AZxh */
    public void m7740AZxh(mjFkc mjfkc) {
        synchronized (this) {
            try {
                m7742wA();
                if (this.f7539AZxh == mjfkc) {
                    return;
                }
                this.f7539AZxh = mjfkc;
                if (this.f7541mjFkc && mjfkc != null) {
                    mjfkc.mo752mjFkc();
                }
            } finally {
            }
        }
    }

    /* renamed from: mjFkc */
    public void m7741mjFkc() {
        synchronized (this) {
            try {
                if (this.f7541mjFkc) {
                    return;
                }
                this.f7541mjFkc = true;
                this.f7540ZfxDd = true;
                mjFkc mjfkc = this.f7539AZxh;
                Object obj = this.f7542wA;
                if (mjfkc != null) {
                    try {
                        mjfkc.mo752mjFkc();
                    } catch (Throwable th) {
                        synchronized (this) {
                            this.f7540ZfxDd = false;
                            notifyAll();
                            throw th;
                        }
                    }
                }
                if (obj != null) {
                    ((CancellationSignal) obj).cancel();
                }
                synchronized (this) {
                    this.f7540ZfxDd = false;
                    notifyAll();
                }
            } finally {
            }
        }
    }

    /* renamed from: wA */
    public final void m7742wA() throws InterruptedException {
        while (this.f7540ZfxDd) {
            try {
                wait();
            } catch (InterruptedException unused) {
            }
        }
    }
}
