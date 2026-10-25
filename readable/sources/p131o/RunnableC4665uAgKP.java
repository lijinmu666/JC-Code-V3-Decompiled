package p131o;

import java.util.Map;

/* renamed from: o.uAgKP */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC4665uAgKP implements Runnable {

    /* renamed from: mjFkc */
    public final Map.Entry f16806mjFkc;

    public RunnableC4665uAgKP(Map.Entry entry, AbstractC1756CO abstractC1756CO) {
        this.f16806mjFkc = entry;
    }

    /* renamed from: mjFkc */
    public static Runnable m13702mjFkc(Map.Entry entry, AbstractC1756CO abstractC1756CO) {
        return new RunnableC4665uAgKP(entry, abstractC1756CO);
    }

    @Override // java.lang.Runnable
    public void run() {
        C2984UmFn.m10643wA(this.f16806mjFkc, null);
    }
}
