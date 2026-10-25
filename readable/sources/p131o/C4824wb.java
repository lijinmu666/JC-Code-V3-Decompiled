package p131o;

import java.util.Iterator;
import java.util.concurrent.Executor;

/* renamed from: o.wb */
/* loaded from: classes.dex */
public class C4824wb {

    /* renamed from: AZxh */
    public final InterfaceC4829wfQA f17231AZxh;

    /* renamed from: ZfxDd */
    public final InterfaceC4992z7 f17232ZfxDd;

    /* renamed from: mjFkc */
    public final Executor f17233mjFkc;

    /* renamed from: wA */
    public final InterfaceC4957yb f17234wA;

    public C4824wb(Executor executor, InterfaceC4829wfQA interfaceC4829wfQA, InterfaceC4957yb interfaceC4957yb, InterfaceC4992z7 interfaceC4992z7) {
        this.f17233mjFkc = executor;
        this.f17231AZxh = interfaceC4829wfQA;
        this.f17234wA = interfaceC4957yb;
        this.f17232ZfxDd = interfaceC4992z7;
    }

    /* renamed from: AZxh */
    public static /* synthetic */ Object m13860AZxh(C4824wb c4824wb) {
        Iterator it = c4824wb.f17231AZxh.mo11678JHa().iterator();
        while (it.hasNext()) {
            c4824wb.f17234wA.mo11973mjFkc((AbstractC3140X8) it.next(), 1);
        }
        return null;
    }

    /* renamed from: mjFkc */
    public void m13862mjFkc() {
        this.f17233mjFkc.execute(RunnableC4624tb.m13643mjFkc(this));
    }
}
