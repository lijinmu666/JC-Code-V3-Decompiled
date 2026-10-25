package p131o;

import android.app.PendingIntent;
import android.os.Bundle;

/* renamed from: o.qB */
/* loaded from: classes.dex */
public abstract class AbstractC4396qB extends AbstractC4399qE {

    /* renamed from: JHa */
    public final /* synthetic */ AbstractC2308KRckQg f16023JHa;

    /* renamed from: KLFTb */
    public final Bundle f16024KLFTb;

    /* renamed from: ZfxDd */
    public final int f16025ZfxDd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC4396qB(AbstractC2308KRckQg abstractC2308KRckQg, int i, Bundle bundle) {
        super(abstractC2308KRckQg, Boolean.TRUE);
        this.f16023JHa = abstractC2308KRckQg;
        this.f16025ZfxDd = i;
        this.f16024KLFTb = bundle;
    }

    @Override // p131o.AbstractC4399qE
    /* renamed from: AZxh */
    public final void mo13183AZxh() {
    }

    /* renamed from: JHa */
    public abstract void mo9895JHa(C3613eEOGOh c3613eEOGOh);

    @Override // p131o.AbstractC4399qE
    /* renamed from: mjFkc */
    public final /* bridge */ /* synthetic */ void mo13184mjFkc(Object obj) {
        if (this.f16025ZfxDd != 0) {
            this.f16023JHa.m9223jm(1, null);
            Bundle bundle = this.f16024KLFTb;
            mo9895JHa(new C3613eEOGOh(this.f16025ZfxDd, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
        } else {
            if (mo9896xJ()) {
                return;
            }
            this.f16023JHa.m9223jm(1, null);
            mo9895JHa(new C3613eEOGOh(8, null));
        }
    }

    /* renamed from: xJ */
    public abstract boolean mo9896xJ();
}
