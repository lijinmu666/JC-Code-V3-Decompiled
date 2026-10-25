package p131o;

import java.io.Closeable;

/* renamed from: o.YW */
/* loaded from: classes.dex */
public final class C3236YW implements Closeable {

    /* renamed from: mjFkc */
    public final /* synthetic */ C2010G7 f11888mjFkc;

    public /* synthetic */ C3236YW(C2010G7 c2010g7, AbstractC2966UW abstractC2966UW) {
        this.f11888mjFkc = c2010g7;
        AbstractC2138I3.m8646qdMbNW(((Thread) c2010g7.f8332ZfxDd.getAndSet(Thread.currentThread())) == null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f11888mjFkc.f8332ZfxDd.set(null);
        this.f11888mjFkc.m8408ZfxDd();
    }
}
