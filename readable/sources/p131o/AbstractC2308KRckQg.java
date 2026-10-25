package p131o;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.p038google.p039android.p042gms.p046common.p047api.C0209Scope;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: o.KRckQg */
/* loaded from: classes.dex */
public abstract class AbstractC2308KRckQg {

    /* renamed from: mByQ */
    public static final C2987UokA[] f9156mByQ = new C2987UokA[0];

    /* renamed from: wJVbdd */
    public static final String[] f9157wJVbdd = {"service_esmobile", "service_googleme"};

    /* renamed from: AZxh */
    public long f9158AZxh;

    /* renamed from: Dt */
    public final AbstractC3334a f9160Dt;

    /* renamed from: ETF */
    public final C3661f f9161ETF;

    /* renamed from: Gd */
    public final String f9162Gd;

    /* renamed from: HGpJ */
    public volatile String f9163HGpJ;

    /* renamed from: KLFTb */
    public long f9166KLFTb;

    /* renamed from: Pq */
    public ServiceConnectionC2425MG f9168Pq;

    /* renamed from: Ucbh */
    public final AZxh f9169Ucbh;

    /* renamed from: VA */
    public final Handler f9170VA;

    /* renamed from: ZfxDd */
    public int f9173ZfxDd;

    /* renamed from: eyqo */
    public final mjFkc f9175eyqo;

    /* renamed from: fehf */
    public IInterface f9176fehf;

    /* renamed from: huTpC */
    public final int f9177huTpC;

    /* renamed from: lgHUyS */
    public final Context f9179lgHUyS;

    /* renamed from: mjFkc */
    public int f9180mjFkc;

    /* renamed from: qGY */
    public wA f9181qGY;

    /* renamed from: qdMbNW */
    public final Looper f9182qdMbNW;

    /* renamed from: rkYL */
    public InterfaceC1798D f9183rkYL;

    /* renamed from: wA */
    public long f9185wA;

    /* renamed from: xJ */
    public C1831DW f9186xJ;

    /* renamed from: JHa */
    public volatile String f9165JHa = null;

    /* renamed from: MiMN */
    public final Object f9167MiMN = new Object();

    /* renamed from: YoKzxo */
    public final Object f9172YoKzxo = new Object();

    /* renamed from: IEE */
    public final ArrayList f9164IEE = new ArrayList();

    /* renamed from: diqgf */
    public int f9174diqgf = 1;

    /* renamed from: vI */
    public C3613eEOGOh f9184vI = null;

    /* renamed from: VocHEe */
    public boolean f9171VocHEe = false;

    /* renamed from: BAnRFn */
    public volatile C1885EN f9159BAnRFn = null;

    /* renamed from: lB */
    public AtomicInteger f9178lB = new AtomicInteger(0);

    /* renamed from: o.KRckQg$AZxh */
    public interface AZxh {
        /* renamed from: ZfxDd */
        void mo9236ZfxDd(C3613eEOGOh c3613eEOGOh);
    }

    /* renamed from: o.KRckQg$KLFTb */
    public interface KLFTb {
        /* renamed from: mjFkc */
        void mo9237mjFkc();
    }

    /* renamed from: o.KRckQg$ZfxDd */
    public class ZfxDd implements wA {
        public ZfxDd() {
        }

        @Override // p131o.AbstractC2308KRckQg.wA
        /* renamed from: ZfxDd */
        public final void mo9238ZfxDd(C3613eEOGOh c3613eEOGOh) {
            if (c3613eEOGOh.m11823JHa()) {
                AbstractC2308KRckQg abstractC2308KRckQg = AbstractC2308KRckQg.this;
                abstractC2308KRckQg.m9200AZxh(null, abstractC2308KRckQg.mo9201BAnRFn());
            } else if (AbstractC2308KRckQg.this.f9169Ucbh != null) {
                AbstractC2308KRckQg.this.f9169Ucbh.mo9236ZfxDd(c3613eEOGOh);
            }
        }
    }

    /* renamed from: o.KRckQg$mjFkc */
    public interface mjFkc {
        /* renamed from: KLFTb */
        void mo9239KLFTb(int i);

        /* renamed from: xJ */
        void mo9240xJ(Bundle bundle);
    }

    /* renamed from: o.KRckQg$wA */
    public interface wA {
        /* renamed from: ZfxDd */
        void mo9238ZfxDd(C3613eEOGOh c3613eEOGOh);
    }

    public AbstractC2308KRckQg(Context context, Looper looper, AbstractC3334a abstractC3334a, C3661f c3661f, int i, mjFkc mjfkc, AZxh aZxh, String str) {
        AbstractC2138I3.m8644lgHUyS(context, "Context must not be null");
        this.f9179lgHUyS = context;
        AbstractC2138I3.m8644lgHUyS(looper, "Looper must not be null");
        this.f9182qdMbNW = looper;
        AbstractC2138I3.m8644lgHUyS(abstractC3334a, "Supervisor must not be null");
        this.f9160Dt = abstractC3334a;
        AbstractC2138I3.m8644lgHUyS(c3661f, "API availability must not be null");
        this.f9161ETF = c3661f;
        this.f9170VA = new HandlerC3809hD(this, looper);
        this.f9177huTpC = i;
        this.f9175eyqo = mjfkc;
        this.f9169Ucbh = aZxh;
        this.f9162Gd = str;
    }

    /* renamed from: JBhc */
    public static /* bridge */ /* synthetic */ boolean m9188JBhc(AbstractC2308KRckQg abstractC2308KRckQg, int i, int i2, IInterface iInterface) {
        synchronized (abstractC2308KRckQg.f9167MiMN) {
            try {
                if (abstractC2308KRckQg.f9174diqgf != i) {
                    return false;
                }
                abstractC2308KRckQg.m9223jm(i2, iInterface);
                return true;
            } finally {
            }
        }
    }

    /* renamed from: Vdz */
    public static /* bridge */ /* synthetic */ boolean m9194Vdz(AbstractC2308KRckQg abstractC2308KRckQg) throws ClassNotFoundException {
        if (abstractC2308KRckQg.f9171VocHEe || TextUtils.isEmpty(abstractC2308KRckQg.mo7628wJVbdd()) || TextUtils.isEmpty(abstractC2308KRckQg.m9215VocHEe())) {
            return false;
        }
        try {
            Class.forName(abstractC2308KRckQg.mo7628wJVbdd());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: WGXroI */
    public static /* bridge */ /* synthetic */ void m9195WGXroI(AbstractC2308KRckQg abstractC2308KRckQg, C1885EN c1885en) {
        abstractC2308KRckQg.f9159BAnRFn = c1885en;
        if (abstractC2308KRckQg.mo9227oCFDzJ()) {
            C1674BABY c1674baby = c1885en.f7981ZfxDd;
            C1804D5.m7970AZxh().m7972wA(c1674baby == null ? null : c1674baby.m7685xJ());
        }
    }

    /* renamed from: XV */
    public static /* bridge */ /* synthetic */ void m9197XV(AbstractC2308KRckQg abstractC2308KRckQg, int i) {
        int i2;
        int i3;
        synchronized (abstractC2308KRckQg.f9167MiMN) {
            i2 = abstractC2308KRckQg.f9174diqgf;
        }
        if (i2 == 3) {
            abstractC2308KRckQg.f9171VocHEe = true;
            i3 = 5;
        } else {
            i3 = 4;
        }
        Handler handler = abstractC2308KRckQg.f9170VA;
        handler.sendMessage(handler.obtainMessage(i3, abstractC2308KRckQg.f9178lB.get(), 16));
    }

    /* renamed from: AZxh */
    public void m9200AZxh(InterfaceC1662B interfaceC1662B, Set set) {
        Bundle bundleMo7627vI = mo7627vI();
        String str = this.f9163HGpJ;
        int i = C3661f.f13514mjFkc;
        C0209Scope[] c0209ScopeArr = C4221nVsW.f15409rkYL;
        Bundle bundle = new Bundle();
        int i2 = this.f9177huTpC;
        C2987UokA[] c2987UokAArr = C4221nVsW.f15408qGY;
        C4221nVsW c4221nVsW = new C4221nVsW(6, i2, i, null, null, c0209ScopeArr, bundle, null, c2987UokAArr, c2987UokAArr, true, 0, false, str);
        c4221nVsW.f15418ZfxDd = this.f9179lgHUyS.getPackageName();
        c4221nVsW.f15423xJ = bundleMo7627vI;
        if (set != null) {
            c4221nVsW.f15413JHa = (C0209Scope[]) set.toArray(new C0209Scope[0]);
        }
        if (mo9216YoKzxo()) {
            Account accountMo9220diqgf = mo9220diqgf();
            if (accountMo9220diqgf == null) {
                accountMo9220diqgf = new Account("<<default account>>", "com.google");
            }
            c4221nVsW.f15419lgHUyS = accountMo9220diqgf;
            if (interfaceC1662B != null) {
                c4221nVsW.f15414KLFTb = interfaceC1662B.asBinder();
            }
        } else if (m9214Vnb()) {
            c4221nVsW.f15419lgHUyS = mo9220diqgf();
        }
        c4221nVsW.f15421qdMbNW = f9156mByQ;
        c4221nVsW.f15411Dt = mo7625eyqo();
        if (mo9227oCFDzJ()) {
            c4221nVsW.f15415MiMN = true;
        }
        try {
            try {
                synchronized (this.f9172YoKzxo) {
                    try {
                        InterfaceC1798D interfaceC1798D = this.f9183rkYL;
                        if (interfaceC1798D != null) {
                            interfaceC1798D.mo7946qdMbNW(new BinderC4936yF(this, this.f9178lB.get()), c4221nVsW);
                        } else {
                            Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                        }
                    } finally {
                    }
                }
            } catch (RemoteException | RuntimeException e) {
                Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
                m9230rWxwaT(8, null, null, this.f9178lB.get());
            }
        } catch (DeadObjectException e2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            m9232vadzgd(3);
        } catch (SecurityException e3) {
            throw e3;
        }
    }

    /* renamed from: BAnRFn */
    public abstract Set mo9201BAnRFn();

    /* renamed from: CqaNbM */
    public boolean mo7622CqaNbM() {
        return mo7624JHa() >= 211700000;
    }

    /* renamed from: Dt */
    public String m9202Dt() {
        C1831DW c1831dw;
        if (!m9226mjFkc() || (c1831dw = this.f9186xJ) == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
        return c1831dw.m7999mjFkc();
    }

    /* renamed from: ETF */
    public String m9203ETF() {
        return this.f9165JHa;
    }

    /* renamed from: Gd */
    public final Context m9204Gd() {
        return this.f9179lgHUyS;
    }

    /* renamed from: HGpJ */
    public int m9205HGpJ() {
        return this.f9177huTpC;
    }

    /* renamed from: IEE */
    public abstract IInterface mo7623IEE(IBinder iBinder);

    /* renamed from: JHa */
    public abstract int mo7624JHa();

    /* renamed from: KLFTb */
    public boolean m9206KLFTb() {
        return true;
    }

    /* renamed from: KLMXS */
    public void m9207KLMXS(IInterface iInterface) {
        this.f9185wA = System.currentTimeMillis();
    }

    /* renamed from: MiMN */
    public void m9208MiMN() {
        this.f9178lB.incrementAndGet();
        synchronized (this.f9164IEE) {
            try {
                int size = this.f9164IEE.size();
                for (int i = 0; i < size; i++) {
                    ((AbstractC4399qE) this.f9164IEE.get(i)).m13186ZfxDd();
                }
                this.f9164IEE.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.f9172YoKzxo) {
            this.f9183rkYL = null;
        }
        m9223jm(1, null);
    }

    /* renamed from: NPj */
    public void m9209NPj(String str) {
        this.f9163HGpJ = str;
    }

    /* renamed from: Ne */
    public C1674BABY m9210Ne() {
        C1885EN c1885en = this.f9159BAnRFn;
        if (c1885en == null) {
            return null;
        }
        return c1885en.f7981ZfxDd;
    }

    /* renamed from: OjSQV */
    public String m9211OjSQV() {
        return "com.google.android.gms";
    }

    /* renamed from: Pq */
    public boolean m9212Pq() {
        return false;
    }

    /* renamed from: Ucbh */
    public abstract Executor mo9213Ucbh();

    /* renamed from: Vnb */
    public boolean m9214Vnb() {
        return false;
    }

    /* renamed from: VocHEe */
    public String m9215VocHEe() {
        return null;
    }

    /* renamed from: YoKzxo */
    public boolean mo9216YoKzxo() {
        return false;
    }

    /* renamed from: ZfxDd */
    public void m9217ZfxDd(String str) {
        this.f9165JHa = str;
        m9208MiMN();
    }

    /* renamed from: bbzow */
    public final void m9218bbzow(int i, Bundle bundle, int i2) {
        this.f9170VA.sendMessage(this.f9170VA.obtainMessage(7, i2, -1, new C3153XI(this, i, null)));
    }

    /* renamed from: cMLeY */
    public void m9219cMLeY(int i) {
        this.f9180mjFkc = i;
        this.f9158AZxh = System.currentTimeMillis();
    }

    /* renamed from: diqgf */
    public abstract Account mo9220diqgf();

    /* renamed from: eyqo */
    public C2987UokA[] mo7625eyqo() {
        return f9156mByQ;
    }

    /* renamed from: fehf */
    public final void m9221fehf() {
        if (!m9226mjFkc()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    /* renamed from: huTpC */
    public Bundle m9222huTpC() {
        return null;
    }

    /* renamed from: jm */
    public final void m9223jm(int i, IInterface iInterface) {
        C1831DW c1831dw;
        AbstractC2138I3.m8645mjFkc((i == 4) == (iInterface != null));
        synchronized (this.f9167MiMN) {
            try {
                this.f9174diqgf = i;
                this.f9176fehf = iInterface;
                if (i == 1) {
                    ServiceConnectionC2425MG serviceConnectionC2425MG = this.f9168Pq;
                    if (serviceConnectionC2425MG != null) {
                        AbstractC3334a abstractC3334a = this.f9160Dt;
                        String strM7998AZxh = this.f9186xJ.m7998AZxh();
                        AbstractC2138I3.m8648xJ(strM7998AZxh);
                        abstractC3334a.m11241ZfxDd(strM7998AZxh, this.f9186xJ.m7999mjFkc(), 4225, serviceConnectionC2425MG, m9231uHVRx(), this.f9186xJ.m8000wA());
                        this.f9168Pq = null;
                    }
                } else if (i == 2 || i == 3) {
                    ServiceConnectionC2425MG serviceConnectionC2425MG2 = this.f9168Pq;
                    if (serviceConnectionC2425MG2 != null && (c1831dw = this.f9186xJ) != null) {
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + c1831dw.m7998AZxh() + " on " + c1831dw.m7999mjFkc());
                        AbstractC3334a abstractC3334a2 = this.f9160Dt;
                        String strM7998AZxh2 = this.f9186xJ.m7998AZxh();
                        AbstractC2138I3.m8648xJ(strM7998AZxh2);
                        abstractC3334a2.m11241ZfxDd(strM7998AZxh2, this.f9186xJ.m7999mjFkc(), 4225, serviceConnectionC2425MG2, m9231uHVRx(), this.f9186xJ.m8000wA());
                        this.f9178lB.incrementAndGet();
                    }
                    ServiceConnectionC2425MG serviceConnectionC2425MG3 = new ServiceConnectionC2425MG(this, this.f9178lB.get());
                    this.f9168Pq = serviceConnectionC2425MG3;
                    C1831DW c1831dw2 = (this.f9174diqgf != 3 || m9215VocHEe() == null) ? new C1831DW(m9211OjSQV(), mo7626mByQ(), false, 4225, mo7622CqaNbM()) : new C1831DW(m9204Gd().getPackageName(), m9215VocHEe(), true, 4225, false);
                    this.f9186xJ = c1831dw2;
                    if (c1831dw2.m8000wA() && mo7624JHa() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.f9186xJ.m7998AZxh())));
                    }
                    AbstractC3334a abstractC3334a3 = this.f9160Dt;
                    String strM7998AZxh3 = this.f9186xJ.m7998AZxh();
                    AbstractC2138I3.m8648xJ(strM7998AZxh3);
                    if (!abstractC3334a3.mo11240KLFTb(new C2696QR(strM7998AZxh3, this.f9186xJ.m7999mjFkc(), 4225, this.f9186xJ.m8000wA()), serviceConnectionC2425MG3, m9231uHVRx(), mo9213Ucbh())) {
                        Log.w("GmsClient", "unable to connect to service: " + this.f9186xJ.m7998AZxh() + " on " + this.f9186xJ.m7999mjFkc());
                        m9218bbzow(16, null, this.f9178lB.get());
                    }
                } else if (i == 4) {
                    AbstractC2138I3.m8648xJ(iInterface);
                    m9207KLMXS(iInterface);
                }
            } finally {
            }
        }
    }

    /* renamed from: lB */
    public final IInterface m9224lB() {
        IInterface iInterface;
        synchronized (this.f9167MiMN) {
            try {
                if (this.f9174diqgf == 5) {
                    throw new DeadObjectException();
                }
                m9221fehf();
                iInterface = this.f9176fehf;
                AbstractC2138I3.m8644lgHUyS(iInterface, "Client is connected but service is null");
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    /* renamed from: lgHUyS */
    public boolean m9225lgHUyS() {
        boolean z;
        synchronized (this.f9167MiMN) {
            int i = this.f9174diqgf;
            z = true;
            if (i != 2 && i != 3) {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: mByQ */
    public abstract String mo7626mByQ();

    /* renamed from: mjFkc */
    public boolean m9226mjFkc() {
        boolean z;
        synchronized (this.f9167MiMN) {
            z = this.f9174diqgf == 4;
        }
        return z;
    }

    /* renamed from: oCFDzJ */
    public boolean mo9227oCFDzJ() {
        return false;
    }

    /* renamed from: qGY */
    public void m9228qGY(wA wAVar) {
        AbstractC2138I3.m8644lgHUyS(wAVar, "Connection progress callbacks cannot be null.");
        this.f9181qGY = wAVar;
        m9223jm(2, null);
    }

    /* renamed from: qdMbNW */
    public final C2987UokA[] m9229qdMbNW() {
        C1885EN c1885en = this.f9159BAnRFn;
        if (c1885en == null) {
            return null;
        }
        return c1885en.f7980AZxh;
    }

    /* renamed from: rWxwaT */
    public void m9230rWxwaT(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.f9170VA.sendMessage(this.f9170VA.obtainMessage(1, i2, -1, new C2559OH(this, i, iBinder, bundle)));
    }

    /* renamed from: uHVRx */
    public final String m9231uHVRx() {
        String str = this.f9162Gd;
        return str == null ? this.f9179lgHUyS.getClass().getName() : str;
    }

    /* renamed from: vI */
    public Bundle mo7627vI() {
        return new Bundle();
    }

    /* renamed from: vadzgd */
    public void m9232vadzgd(int i) {
        this.f9170VA.sendMessage(this.f9170VA.obtainMessage(6, this.f9178lB.get(), i));
    }

    /* renamed from: wJVbdd */
    public abstract String mo7628wJVbdd();

    /* renamed from: xJ */
    public void m9233xJ(KLFTb kLFTb) {
        kLFTb.mo9237mjFkc();
    }

    /* renamed from: xrEuO */
    public boolean m9234xrEuO() {
        return this.f9159BAnRFn != null;
    }

    /* renamed from: zvd */
    public void m9235zvd(C3613eEOGOh c3613eEOGOh) {
        this.f9173ZfxDd = c3613eEOGOh.m11826mjFkc();
        this.f9166KLFTb = System.currentTimeMillis();
    }
}
