package p131o;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Set;
import p131o.C2083HExgdj;

/* renamed from: o.EF */
/* loaded from: classes.dex */
public final class C1876EF extends PhantomReference implements C2083HExgdj.mjFkc {

    /* renamed from: AZxh */
    public final Runnable f7970AZxh;

    /* renamed from: mjFkc */
    public final Set f7971mjFkc;

    public /* synthetic */ C1876EF(Object obj, ReferenceQueue referenceQueue, Set set, Runnable runnable, AbstractC4734vE abstractC4734vE) {
        super(obj, referenceQueue);
        this.f7971mjFkc = set;
        this.f7970AZxh = runnable;
    }

    @Override // p131o.C2083HExgdj.mjFkc
    /* renamed from: mjFkc */
    public final void mo8121mjFkc() {
        if (this.f7971mjFkc.remove(this)) {
            clear();
            this.f7970AZxh.run();
        }
    }
}
