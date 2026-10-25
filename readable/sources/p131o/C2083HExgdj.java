package p131o;

import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: o.HExgdj */
/* loaded from: classes.dex */
public class C2083HExgdj {

    /* renamed from: mjFkc */
    public final ReferenceQueue f8560mjFkc = new ReferenceQueue();

    /* renamed from: AZxh */
    public final Set f8559AZxh = Collections.synchronizedSet(new HashSet());

    /* renamed from: o.HExgdj$mjFkc */
    public interface mjFkc {
        /* renamed from: mjFkc */
        void mo8121mjFkc();
    }

    /* renamed from: mjFkc */
    public static C2083HExgdj m8526mjFkc() {
        C2083HExgdj c2083HExgdj = new C2083HExgdj();
        c2083HExgdj.m8527AZxh(c2083HExgdj, new Runnable() { // from class: o.kB
            @Override // java.lang.Runnable
            public final void run() {
            }
        });
        final ReferenceQueue referenceQueue = c2083HExgdj.f8560mjFkc;
        final Set set = c2083HExgdj.f8559AZxh;
        Thread thread = new Thread(new Runnable() { // from class: o.cD
            @Override // java.lang.Runnable
            public final void run() {
                ReferenceQueue referenceQueue2 = referenceQueue;
                while (!set.isEmpty()) {
                    try {
                        ((C1876EF) referenceQueue2.remove()).mo8121mjFkc();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }, "MlKitCleaner");
        thread.setDaemon(true);
        thread.start();
        return c2083HExgdj;
    }

    /* renamed from: AZxh */
    public mjFkc m8527AZxh(Object obj, Runnable runnable) {
        C1876EF c1876ef = new C1876EF(obj, this.f8560mjFkc, this.f8559AZxh, runnable, null);
        this.f8559AZxh.add(c1876ef);
        return c1876ef;
    }
}
