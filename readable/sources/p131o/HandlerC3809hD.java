package p131o;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* renamed from: o.hD */
/* loaded from: classes.dex */
public final class HandlerC3809hD extends HandlerC4274oL {

    /* renamed from: AZxh */
    public final /* synthetic */ AbstractC2308KRckQg f13997AZxh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC3809hD(AbstractC2308KRckQg abstractC2308KRckQg, Looper looper) {
        super(looper);
        this.f13997AZxh = abstractC2308KRckQg;
    }

    /* renamed from: AZxh */
    public static final boolean m12214AZxh(Message message) {
        int i = message.what;
        return i == 2 || i == 1 || i == 7;
    }

    /* renamed from: mjFkc */
    public static final void m12215mjFkc(Message message) {
        AbstractC4399qE abstractC4399qE = (AbstractC4399qE) message.obj;
        abstractC4399qE.mo13183AZxh();
        abstractC4399qE.m13185KLFTb();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.f13997AZxh.f9178lB.get() != message.arg1) {
            if (m12214AZxh(message)) {
                m12215mjFkc(message);
                return;
            }
            return;
        }
        int i = message.what;
        if ((i == 1 || i == 7 || ((i == 4 && !this.f13997AZxh.m9212Pq()) || message.what == 5)) && !this.f13997AZxh.m9225lgHUyS()) {
            m12215mjFkc(message);
            return;
        }
        int i2 = message.what;
        if (i2 == 4) {
            this.f13997AZxh.f9184vI = new C3613eEOGOh(message.arg2);
            if (AbstractC2308KRckQg.m9194Vdz(this.f13997AZxh)) {
                AbstractC2308KRckQg abstractC2308KRckQg = this.f13997AZxh;
                if (!abstractC2308KRckQg.f9171VocHEe) {
                    abstractC2308KRckQg.m9223jm(3, null);
                    return;
                }
            }
            AbstractC2308KRckQg abstractC2308KRckQg2 = this.f13997AZxh;
            C3613eEOGOh c3613eEOGOh = abstractC2308KRckQg2.f9184vI != null ? abstractC2308KRckQg2.f9184vI : new C3613eEOGOh(8);
            this.f13997AZxh.f9181qGY.mo9238ZfxDd(c3613eEOGOh);
            this.f13997AZxh.m9235zvd(c3613eEOGOh);
            return;
        }
        if (i2 == 5) {
            AbstractC2308KRckQg abstractC2308KRckQg3 = this.f13997AZxh;
            C3613eEOGOh c3613eEOGOh2 = abstractC2308KRckQg3.f9184vI != null ? abstractC2308KRckQg3.f9184vI : new C3613eEOGOh(8);
            this.f13997AZxh.f9181qGY.mo9238ZfxDd(c3613eEOGOh2);
            this.f13997AZxh.m9235zvd(c3613eEOGOh2);
            return;
        }
        if (i2 == 3) {
            Object obj = message.obj;
            C3613eEOGOh c3613eEOGOh3 = new C3613eEOGOh(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
            this.f13997AZxh.f9181qGY.mo9238ZfxDd(c3613eEOGOh3);
            this.f13997AZxh.m9235zvd(c3613eEOGOh3);
            return;
        }
        if (i2 == 6) {
            this.f13997AZxh.m9223jm(5, null);
            AbstractC2308KRckQg abstractC2308KRckQg4 = this.f13997AZxh;
            if (abstractC2308KRckQg4.f9175eyqo != null) {
                abstractC2308KRckQg4.f9175eyqo.mo9239KLFTb(message.arg2);
            }
            this.f13997AZxh.m9219cMLeY(message.arg2);
            AbstractC2308KRckQg.m9188JBhc(this.f13997AZxh, 5, 1, null);
            return;
        }
        if (i2 == 2 && !this.f13997AZxh.m9226mjFkc()) {
            m12215mjFkc(message);
            return;
        }
        if (m12214AZxh(message)) {
            ((AbstractC4399qE) message.obj).m13187wA();
            return;
        }
        Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
    }
}
