package p131o;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;

/* renamed from: o.UmFn */
/* loaded from: classes.dex */
public class C2984UmFn implements InterfaceC4392q7, InterfaceC3406b4 {

    /* renamed from: wA */
    public final Executor f10913wA;

    /* renamed from: mjFkc */
    public final Map f10912mjFkc = new HashMap();

    /* renamed from: AZxh */
    public Queue f10911AZxh = new ArrayDeque();

    public C2984UmFn(Executor executor) {
        this.f10913wA = executor;
    }

    /* renamed from: wA */
    public static /* synthetic */ void m10643wA(Map.Entry entry, AbstractC1756CO abstractC1756CO) {
        AbstractC4793w7.m13819mjFkc(entry.getKey());
        throw null;
    }

    /* renamed from: AZxh */
    public final synchronized Set m10644AZxh(AbstractC1756CO abstractC1756CO) {
        throw null;
    }

    /* renamed from: ZfxDd */
    public void m10645ZfxDd(AbstractC1756CO abstractC1756CO) {
        AbstractC2207J3.m8883AZxh(abstractC1756CO);
        synchronized (this) {
            try {
                Queue queue = this.f10911AZxh;
                if (queue != null) {
                    queue.add(abstractC1756CO);
                    return;
                }
                for (Map.Entry entry : m10644AZxh(abstractC1756CO)) {
                    ((Executor) entry.getValue()).execute(RunnableC4665uAgKP.m13702mjFkc(entry, abstractC1756CO));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: mjFkc */
    public void m10646mjFkc() {
        Queue queue;
        synchronized (this) {
            try {
                queue = this.f10911AZxh;
                if (queue != null) {
                    this.f10911AZxh = null;
                } else {
                    queue = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (queue != null) {
            Iterator it = queue.iterator();
            while (it.hasNext()) {
                AbstractC4793w7.m13819mjFkc(it.next());
                m10645ZfxDd(null);
            }
        }
    }
}
