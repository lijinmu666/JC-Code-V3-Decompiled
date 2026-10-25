package p131o;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.p038google.p039android.p042gms.p046common.p047api.C0210Status;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: o.h */
/* loaded from: classes.dex */
public class C3795h implements Handler.Callback {

    /* renamed from: Pq */
    public static C3795h f13896Pq;

    /* renamed from: JHa */
    public final C3597e f13902JHa;

    /* renamed from: KLFTb */
    public final Context f13903KLFTb;

    /* renamed from: YoKzxo */
    public final Handler f13906YoKzxo;

    /* renamed from: ZfxDd */
    public InterfaceC2806S7 f13907ZfxDd;

    /* renamed from: rkYL */
    public volatile boolean f13911rkYL;

    /* renamed from: wA */
    public C2675Q7 f13912wA;

    /* renamed from: xJ */
    public final C4291od f13913xJ;

    /* renamed from: qGY */
    public static final C0210Status f13898qGY = new C0210Status(4, "Sign-out occurred while this API call was in progress.");

    /* renamed from: fehf */
    public static final C0210Status f13897fehf = new C0210Status(4, "The user must be signed in to make this API call.");

    /* renamed from: IEE */
    public static final Object f13895IEE = new Object();

    /* renamed from: mjFkc */
    public long f13909mjFkc = 10000;

    /* renamed from: AZxh */
    public boolean f13899AZxh = false;

    /* renamed from: lgHUyS */
    public final AtomicInteger f13908lgHUyS = new AtomicInteger(1);

    /* renamed from: qdMbNW */
    public final AtomicInteger f13910qdMbNW = new AtomicInteger(0);

    /* renamed from: Dt */
    public final Map f13900Dt = new ConcurrentHashMap(5, 0.75f, 1);

    /* renamed from: ETF */
    public C3035Vb f13901ETF = null;

    /* renamed from: VA */
    public final Set f13905VA = new C3762gYa();

    /* renamed from: MiMN */
    public final Set f13904MiMN = new C3762gYa();

    public C3795h(Context context, Looper looper, C3597e c3597e) {
        this.f13911rkYL = true;
        this.f13903KLFTb = context;
        HandlerC2110Hd handlerC2110Hd = new HandlerC2110Hd(looper, this);
        this.f13906YoKzxo = handlerC2110Hd;
        this.f13902JHa = c3597e;
        this.f13913xJ = new C4291od(c3597e);
        if (AbstractC3943jKf.m12432mjFkc(context)) {
            this.f13911rkYL = false;
        }
        handlerC2110Hd.sendMessage(handlerC2110Hd.obtainMessage(6));
    }

    /* renamed from: JHa */
    public static C0210Status m12134JHa(C2245JYn c2245JYn, C3613eEOGOh c3613eEOGOh) {
        return new C0210Status(c3613eEOGOh, "API: " + c2245JYn.m8986AZxh() + " is not available on this device. Connection failed with: " + String.valueOf(c3613eEOGOh));
    }

    /* renamed from: diqgf */
    public static C3795h m12139diqgf(Context context) {
        C3795h c3795h;
        synchronized (f13895IEE) {
            try {
                if (f13896Pq == null) {
                    f13896Pq = new C3795h(context.getApplicationContext(), AbstractC3334a.m11238AZxh().getLooper(), C3597e.m11771MiMN());
                }
                c3795h = f13896Pq;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c3795h;
    }

    /* renamed from: AZxh */
    public final void m12146AZxh(C3035Vb c3035Vb) {
        synchronized (f13895IEE) {
            try {
                if (this.f13901ETF == c3035Vb) {
                    this.f13901ETF = null;
                    this.f13905VA.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: BAnRFn */
    public final void m12147BAnRFn(C3613eEOGOh c3613eEOGOh, int i) {
        if (m12150KLFTb(c3613eEOGOh, i)) {
            return;
        }
        Handler handler = this.f13906YoKzxo;
        handler.sendMessage(handler.obtainMessage(5, i, 0, c3613eEOGOh));
    }

    /* renamed from: Dt */
    public final void m12148Dt(C1806D7 c1806d7, int i, AbstractC3533d abstractC3533d) {
        C4959yc c4959ycM14039AZxh;
        if (i == 0 || (c4959ycM14039AZxh = C4959yc.m14039AZxh(this, i, abstractC3533d.m11637xJ())) == null) {
            return;
        }
        AbstractC1670B7 abstractC1670B7M7977mjFkc = c1806d7.m7977mjFkc();
        final Handler handler = this.f13906YoKzxo;
        handler.getClass();
        abstractC1670B7M7977mjFkc.mo7668mjFkc(new Executor() { // from class: o.ec
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        }, c4959ycM14039AZxh);
    }

    /* renamed from: ETF */
    public final int m12149ETF() {
        return this.f13908lgHUyS.getAndIncrement();
    }

    /* renamed from: KLFTb */
    public final boolean m12150KLFTb(C3613eEOGOh c3613eEOGOh, int i) {
        return this.f13902JHa.m11784huTpC(this.f13903KLFTb, c3613eEOGOh, i);
    }

    /* renamed from: Pq */
    public final C4027kc m12151Pq(C2245JYn c2245JYn) {
        return (C4027kc) this.f13900Dt.get(c2245JYn);
    }

    /* renamed from: VocHEe */
    public final void m12152VocHEe(C3729g2 c3729g2, int i, long j, int i2) {
        this.f13906YoKzxo.sendMessage(this.f13906YoKzxo.obtainMessage(18, new C5023zc(c3729g2, i, j, i2)));
    }

    /* renamed from: ZfxDd */
    public final boolean m12153ZfxDd() {
        if (this.f13899AZxh) {
            return false;
        }
        C1866E5 c1866e5M7971mjFkc = C1804D5.m7970AZxh().m7971mjFkc();
        if (c1866e5M7971mjFkc != null && !c1866e5M7971mjFkc.m8106wA()) {
            return false;
        }
        int iM12991mjFkc = this.f13913xJ.m12991mjFkc(this.f13903KLFTb, 203400000);
        return iM12991mjFkc == -1 || iM12991mjFkc == 0;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        C4027kc c4027kc = null;
        switch (i) {
            case 1:
                this.f13909mjFkc = true == ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.f13906YoKzxo.removeMessages(12);
                for (C2245JYn c2245JYn : this.f13900Dt.keySet()) {
                    Handler handler = this.f13906YoKzxo;
                    handler.sendMessageDelayed(handler.obtainMessage(12, c2245JYn), this.f13909mjFkc);
                }
                return true;
            case 2:
                AbstractC4793w7.m13819mjFkc(message.obj);
                throw null;
            case 3:
                for (C4027kc c4027kc2 : this.f13900Dt.values()) {
                    c4027kc2.m12583wJVbdd();
                    c4027kc2.m12577mByQ();
                }
                return true;
            case 4:
            case 8:
            case 13:
                C1637Ac c1637Ac = (C1637Ac) message.obj;
                C4027kc c4027kcM12160xJ = (C4027kc) this.f13900Dt.get(c1637Ac.f7383wA.m11637xJ());
                if (c4027kcM12160xJ == null) {
                    c4027kcM12160xJ = m12160xJ(c1637Ac.f7383wA);
                }
                if (!c4027kcM12160xJ.m12578mjFkc() || this.f13910qdMbNW.get() == c1637Ac.f7381AZxh) {
                    c4027kcM12160xJ.m12568OjSQV(c1637Ac.f7382mjFkc);
                } else {
                    c1637Ac.f7382mjFkc.mo9002mjFkc(f13898qGY);
                    c4027kcM12160xJ.m12585zvd();
                }
                return true;
            case 5:
                int i2 = message.arg1;
                C3613eEOGOh c3613eEOGOh = (C3613eEOGOh) message.obj;
                Iterator it = this.f13900Dt.values().iterator();
                while (true) {
                    if (it.hasNext()) {
                        C4027kc c4027kc3 = (C4027kc) it.next();
                        if (c4027kc3.m12569Pq() == i2) {
                            c4027kc = c4027kc3;
                        }
                    }
                }
                if (c4027kc == null) {
                    Log.wtf("GoogleApiManager", "Could not find API instance " + i2 + " while trying to fail enqueued calls.", new Exception());
                } else if (c3613eEOGOh.m11826mjFkc() == 13) {
                    c4027kc.m12576lgHUyS(new C0210Status(17, "Error resolution was canceled by the user, original error message: " + this.f13902JHa.mo11776KLFTb(c3613eEOGOh.m11826mjFkc()) + ": " + c3613eEOGOh.m11822AZxh()));
                } else {
                    c4027kc.m12576lgHUyS(m12134JHa(c4027kc.f14558wA, c3613eEOGOh));
                }
                return true;
            case 6:
                if (this.f13903KLFTb.getApplicationContext() instanceof Application) {
                    ComponentCallbacks2C3307Zdbk.m11204wA((Application) this.f13903KLFTb.getApplicationContext());
                    ComponentCallbacks2C3307Zdbk.m11203AZxh().m11208mjFkc(new C3701fc(this));
                    if (!ComponentCallbacks2C3307Zdbk.m11203AZxh().m11206KLFTb(true)) {
                        this.f13909mjFkc = 300000L;
                    }
                }
                return true;
            case 7:
                m12160xJ((AbstractC3533d) message.obj);
                return true;
            case 9:
                if (this.f13900Dt.containsKey(message.obj)) {
                    ((C4027kc) this.f13900Dt.get(message.obj)).m12565KLMXS();
                }
                return true;
            case 10:
                Iterator it2 = this.f13904MiMN.iterator();
                while (it2.hasNext()) {
                    C4027kc c4027kc4 = (C4027kc) this.f13900Dt.remove((C2245JYn) it2.next());
                    if (c4027kc4 != null) {
                        c4027kc4.m12585zvd();
                    }
                }
                this.f13904MiMN.clear();
                return true;
            case 11:
                if (this.f13900Dt.containsKey(message.obj)) {
                    ((C4027kc) this.f13900Dt.get(message.obj)).m12573cMLeY();
                }
                return true;
            case 12:
                if (this.f13900Dt.containsKey(message.obj)) {
                    ((C4027kc) this.f13900Dt.get(message.obj)).m12558AZxh();
                }
                return true;
            case 14:
                AbstractC4793w7.m13819mjFkc(message.obj);
                throw null;
            case 15:
                C4160mc c4160mc = (C4160mc) message.obj;
                if (this.f13900Dt.containsKey(c4160mc.f15202mjFkc)) {
                    C4027kc.m12550BAnRFn((C4027kc) this.f13900Dt.get(c4160mc.f15202mjFkc), c4160mc);
                }
                return true;
            case 16:
                C4160mc c4160mc2 = (C4160mc) message.obj;
                if (this.f13900Dt.containsKey(c4160mc2.f15202mjFkc)) {
                    C4027kc.m12555lB((C4027kc) this.f13900Dt.get(c4160mc2.f15202mjFkc), c4160mc2);
                }
                return true;
            case 17:
                m12157qdMbNW();
                return true;
            case 18:
                C5023zc c5023zc = (C5023zc) message.obj;
                if (c5023zc.f17696wA == 0) {
                    m12155lgHUyS().mo10134mjFkc(new C2675Q7(c5023zc.f17693AZxh, Arrays.asList(c5023zc.f17695mjFkc)));
                } else {
                    C2675Q7 c2675q7 = this.f13912wA;
                    if (c2675q7 != null) {
                        List listM9998AZxh = c2675q7.m9998AZxh();
                        if (c2675q7.m9999mjFkc() != c5023zc.f17693AZxh || (listM9998AZxh != null && listM9998AZxh.size() >= c5023zc.f17694ZfxDd)) {
                            this.f13906YoKzxo.removeMessages(17);
                            m12157qdMbNW();
                        } else {
                            this.f13912wA.m10000wA(c5023zc.f17695mjFkc);
                        }
                    }
                    if (this.f13912wA == null) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(c5023zc.f17695mjFkc);
                        this.f13912wA = new C2675Q7(c5023zc.f17693AZxh, arrayList);
                        Handler handler2 = this.f13906YoKzxo;
                        handler2.sendMessageDelayed(handler2.obtainMessage(17), c5023zc.f17696wA);
                    }
                }
                return true;
            case 19:
                this.f13899AZxh = false;
                return true;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + i);
                return false;
        }
    }

    /* renamed from: lB */
    public final void m12154lB() {
        Handler handler = this.f13906YoKzxo;
        handler.sendMessage(handler.obtainMessage(3));
    }

    /* renamed from: lgHUyS */
    public final InterfaceC2806S7 m12155lgHUyS() {
        if (this.f13907ZfxDd == null) {
            this.f13907ZfxDd = AbstractC2740R7.m10042mjFkc(this.f13903KLFTb);
        }
        return this.f13907ZfxDd;
    }

    /* renamed from: mjFkc */
    public final void m12156mjFkc(C3035Vb c3035Vb) {
        synchronized (f13895IEE) {
            try {
                if (this.f13901ETF != c3035Vb) {
                    this.f13901ETF = c3035Vb;
                    this.f13905VA.clear();
                }
                this.f13905VA.addAll(c3035Vb.m10696diqgf());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: qdMbNW */
    public final void m12157qdMbNW() {
        C2675Q7 c2675q7 = this.f13912wA;
        if (c2675q7 != null) {
            if (c2675q7.m9999mjFkc() > 0 || m12153ZfxDd()) {
                m12155lgHUyS().mo10134mjFkc(c2675q7);
            }
            this.f13912wA = null;
        }
    }

    /* renamed from: vI */
    public final void m12158vI(AbstractC3533d abstractC3533d, int i, AbstractC1737C7 abstractC1737C7, C1806D7 c1806d7, InterfaceC4064l7 interfaceC4064l7) {
        m12148Dt(c1806d7, abstractC1737C7.m7767ZfxDd(), abstractC3533d);
        this.f13906YoKzxo.sendMessage(this.f13906YoKzxo.obtainMessage(4, new C1637Ac(new C3509cd(i, abstractC1737C7, c1806d7, interfaceC4064l7), this.f13910qdMbNW.get(), abstractC3533d)));
    }

    /* renamed from: wJVbdd */
    public final void m12159wJVbdd(AbstractC3533d abstractC3533d) {
        Handler handler = this.f13906YoKzxo;
        handler.sendMessage(handler.obtainMessage(7, abstractC3533d));
    }

    /* renamed from: xJ */
    public final C4027kc m12160xJ(AbstractC3533d abstractC3533d) {
        Map map = this.f13900Dt;
        C2245JYn c2245JYnM11637xJ = abstractC3533d.m11637xJ();
        C4027kc c4027kc = (C4027kc) map.get(c2245JYnM11637xJ);
        if (c4027kc == null) {
            c4027kc = new C4027kc(this, abstractC3533d);
            this.f13900Dt.put(c2245JYnM11637xJ, c4027kc);
        }
        if (c4027kc.m12578mjFkc()) {
            this.f13904MiMN.add(c2245JYnM11637xJ);
        }
        c4027kc.m12577mByQ();
        return c4027kc;
    }
}
