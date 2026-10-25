package p131o;

import android.util.Log;

/* renamed from: o.qE */
/* loaded from: classes.dex */
public abstract class AbstractC4399qE {

    /* renamed from: AZxh */
    public boolean f16026AZxh = false;

    /* renamed from: mjFkc */
    public Object f16027mjFkc;

    /* renamed from: wA */
    public final /* synthetic */ AbstractC2308KRckQg f16028wA;

    public AbstractC4399qE(AbstractC2308KRckQg abstractC2308KRckQg, Object obj) {
        this.f16028wA = abstractC2308KRckQg;
        this.f16027mjFkc = obj;
    }

    /* renamed from: AZxh */
    public abstract void mo13183AZxh();

    /* renamed from: KLFTb */
    public final void m13185KLFTb() {
        m13186ZfxDd();
        synchronized (this.f16028wA.f9164IEE) {
            this.f16028wA.f9164IEE.remove(this);
        }
    }

    /* renamed from: ZfxDd */
    public final void m13186ZfxDd() {
        synchronized (this) {
            this.f16027mjFkc = null;
        }
    }

    /* renamed from: mjFkc */
    public abstract void mo13184mjFkc(Object obj);

    /* renamed from: wA */
    public final void m13187wA() {
        Object obj;
        synchronized (this) {
            try {
                obj = this.f16027mjFkc;
                if (this.f16026AZxh) {
                    Log.w("GmsClient", "Callback proxy " + toString() + " being reused. This is not safe.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (obj != null) {
            mo13184mjFkc(obj);
        }
        synchronized (this) {
            this.f16026AZxh = true;
        }
        m13185KLFTb();
    }
}
