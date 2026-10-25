package p131o;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: o.s2 */
/* loaded from: classes.dex */
public final class C4522s2 {

    /* renamed from: AZxh */
    public final Executor f16412AZxh;

    /* renamed from: mjFkc */
    public final List f16413mjFkc;

    /* renamed from: o.s2$mjFkc */
    public static class mjFkc {

        /* renamed from: AZxh */
        public Executor f16414AZxh;

        /* renamed from: mjFkc */
        public final List f16415mjFkc = new ArrayList();

        /* renamed from: AZxh */
        public C4522s2 m13449AZxh() {
            return new C4522s2(this.f16415mjFkc, null, this.f16414AZxh, true, null);
        }

        /* renamed from: mjFkc */
        public mjFkc m13450mjFkc(InterfaceC3923j3 interfaceC3923j3) {
            this.f16415mjFkc.add(interfaceC3923j3);
            return this;
        }
    }

    public /* synthetic */ C4522s2(List list, InterfaceC2928U interfaceC2928U, Executor executor, boolean z, AbstractC4625tc abstractC4625tc) {
        AbstractC2138I3.m8644lgHUyS(list, "APIs must not be null.");
        AbstractC2138I3.m8639AZxh(!list.isEmpty(), "APIs must not be empty.");
        if (executor != null) {
            AbstractC2138I3.m8644lgHUyS(interfaceC2928U, "Listener must not be null when listener executor is set.");
        }
        this.f16413mjFkc = list;
        this.f16412AZxh = executor;
    }

    /* renamed from: ZfxDd */
    public static mjFkc m13445ZfxDd() {
        return new mjFkc();
    }

    /* renamed from: AZxh */
    public InterfaceC2928U m13446AZxh() {
        return null;
    }

    /* renamed from: mjFkc */
    public List m13447mjFkc() {
        return this.f16413mjFkc;
    }

    /* renamed from: wA */
    public Executor m13448wA() {
        return this.f16412AZxh;
    }
}
