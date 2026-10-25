package p131o;

import java.util.concurrent.Executor;

/* renamed from: o.gtIJp */
/* loaded from: classes.dex */
public class C3787gtIJp extends AbstractC1868E7 {

    /* renamed from: wA */
    public static volatile C3787gtIJp f13852wA;

    /* renamed from: AZxh */
    public final AbstractC1868E7 f13853AZxh;

    /* renamed from: mjFkc */
    public AbstractC1868E7 f13854mjFkc;

    /* renamed from: ZfxDd */
    public static final Executor f13851ZfxDd = new Executor() { // from class: o.Qr
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            C3787gtIJp.m12112xJ(runnable);
        }
    };

    /* renamed from: KLFTb */
    public static final Executor f13850KLFTb = new Executor() { // from class: o.NKyg
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            C3787gtIJp.m12111lgHUyS(runnable);
        }
    };

    public C3787gtIJp() {
        C1905Eey c1905Eey = new C1905Eey();
        this.f13853AZxh = c1905Eey;
        this.f13854mjFkc = c1905Eey;
    }

    /* renamed from: JHa */
    public static C3787gtIJp m12108JHa() {
        if (f13852wA != null) {
            return f13852wA;
        }
        synchronized (C3787gtIJp.class) {
            try {
                if (f13852wA == null) {
                    f13852wA = new C3787gtIJp();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f13852wA;
    }

    /* renamed from: lgHUyS */
    public static /* synthetic */ void m12111lgHUyS(Runnable runnable) {
        m12108JHa().mo8108mjFkc(runnable);
    }

    /* renamed from: xJ */
    public static /* synthetic */ void m12112xJ(Runnable runnable) {
        m12108JHa().mo8109wA(runnable);
    }

    @Override // p131o.AbstractC1868E7
    /* renamed from: AZxh */
    public boolean mo8107AZxh() {
        return this.f13854mjFkc.mo8107AZxh();
    }

    @Override // p131o.AbstractC1868E7
    /* renamed from: mjFkc */
    public void mo8108mjFkc(Runnable runnable) {
        this.f13854mjFkc.mo8108mjFkc(runnable);
    }

    @Override // p131o.AbstractC1868E7
    /* renamed from: wA */
    public void mo8109wA(Runnable runnable) {
        this.f13854mjFkc.mo8109wA(runnable);
    }
}
