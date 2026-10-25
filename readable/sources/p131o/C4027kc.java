package p131o;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.p038google.p039android.p042gms.p046common.p047api.C0210Status;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import p131o.AbstractC3726g;
import p131o.C3389aqHPIZ;

/* renamed from: o.kc */
/* loaded from: classes.dex */
public final class C4027kc implements AbstractC3726g.mjFkc, AbstractC3726g.AZxh {

    /* renamed from: AZxh */
    public final C3389aqHPIZ.JHa f14547AZxh;

    /* renamed from: MiMN */
    public final /* synthetic */ C3795h f14552MiMN;

    /* renamed from: ZfxDd */
    public final C2969Ub f14554ZfxDd;

    /* renamed from: lgHUyS */
    public final BinderC2041Gc f14555lgHUyS;

    /* renamed from: qdMbNW */
    public boolean f14557qdMbNW;

    /* renamed from: wA */
    public final C2245JYn f14558wA;

    /* renamed from: xJ */
    public final int f14559xJ;

    /* renamed from: mjFkc */
    public final Queue f14556mjFkc = new LinkedList();

    /* renamed from: KLFTb */
    public final Set f14551KLFTb = new HashSet();

    /* renamed from: JHa */
    public final Map f14550JHa = new HashMap();

    /* renamed from: Dt */
    public final List f14548Dt = new ArrayList();

    /* renamed from: ETF */
    public C3613eEOGOh f14549ETF = null;

    /* renamed from: VA */
    public int f14553VA = 0;

    public C4027kc(C3795h c3795h, AbstractC3533d abstractC3533d) {
        this.f14552MiMN = c3795h;
        C3389aqHPIZ.JHa jHaM11628Dt = abstractC3533d.m11628Dt(c3795h.f13906YoKzxo.getLooper(), this);
        this.f14547AZxh = jHaM11628Dt;
        this.f14558wA = abstractC3533d.m11637xJ();
        this.f14554ZfxDd = new C2969Ub();
        this.f14559xJ = abstractC3533d.m11635qdMbNW();
        if (jHaM11628Dt.mo9216YoKzxo()) {
            this.f14555lgHUyS = abstractC3533d.m11629ETF(c3795h.f13903KLFTb, c3795h.f13906YoKzxo);
        } else {
            this.f14555lgHUyS = null;
        }
    }

    /* renamed from: BAnRFn */
    public static /* bridge */ /* synthetic */ void m12550BAnRFn(C4027kc c4027kc, C4160mc c4160mc) {
        if (c4027kc.f14548Dt.contains(c4160mc) && !c4027kc.f14557qdMbNW) {
            if (c4027kc.f14547AZxh.m11420mjFkc()) {
                c4027kc.m12560Dt();
            } else {
                c4027kc.m12577mByQ();
            }
        }
    }

    /* renamed from: lB */
    public static /* bridge */ /* synthetic */ void m12555lB(C4027kc c4027kc, C4160mc c4160mc) {
        C2987UokA[] c2987UokAArrMo11613xJ;
        if (c4027kc.f14548Dt.remove(c4160mc)) {
            c4027kc.f14552MiMN.f13906YoKzxo.removeMessages(15, c4160mc);
            c4027kc.f14552MiMN.f13906YoKzxo.removeMessages(16, c4160mc);
            C2987UokA c2987UokA = c4160mc.f15201AZxh;
            ArrayList arrayList = new ArrayList(c4027kc.f14556mjFkc.size());
            for (AbstractC4028kd abstractC4028kd : c4027kc.f14556mjFkc) {
                if ((abstractC4028kd instanceof AbstractC4894xc) && (c2987UokAArrMo11613xJ = ((AbstractC4894xc) abstractC4028kd).mo11613xJ(c4027kc)) != null && AbstractC2371LREOK.m9364AZxh(c2987UokAArrMo11613xJ, c2987UokA)) {
                    arrayList.add(abstractC4028kd);
                }
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                AbstractC4028kd abstractC4028kd2 = (AbstractC4028kd) arrayList.get(i);
                c4027kc.f14556mjFkc.remove(abstractC4028kd2);
                abstractC4028kd2.mo9000AZxh(new C4728v9(c2987UokA));
            }
        }
    }

    /* renamed from: AZxh */
    public final boolean m12558AZxh() {
        return m12563IEE(true);
    }

    /* renamed from: CqaNbM */
    public final void m12559CqaNbM(C3613eEOGOh c3613eEOGOh, Exception exc) {
        AbstractC2138I3.m8643ZfxDd(this.f14552MiMN.f13906YoKzxo);
        BinderC2041Gc binderC2041Gc = this.f14555lgHUyS;
        if (binderC2041Gc != null) {
            binderC2041Gc.m8444vI();
        }
        m12583wJVbdd();
        this.f14552MiMN.f13913xJ.m12992wA();
        m12564JHa(c3613eEOGOh);
        if ((this.f14547AZxh instanceof C1638Ad) && c3613eEOGOh.m11826mjFkc() != 24) {
            this.f14552MiMN.f13899AZxh = true;
            C3795h c3795h = this.f14552MiMN;
            c3795h.f13906YoKzxo.sendMessageDelayed(c3795h.f13906YoKzxo.obtainMessage(19), 300000L);
        }
        if (c3613eEOGOh.m11826mjFkc() == 4) {
            m12576lgHUyS(C3795h.f13897fehf);
            return;
        }
        if (this.f14556mjFkc.isEmpty()) {
            this.f14549ETF = c3613eEOGOh;
            return;
        }
        if (exc != null) {
            AbstractC2138I3.m8643ZfxDd(this.f14552MiMN.f13906YoKzxo);
            m12580qdMbNW(null, exc, false);
            return;
        }
        if (!this.f14552MiMN.f13911rkYL) {
            m12576lgHUyS(C3795h.m12134JHa(this.f14558wA, c3613eEOGOh));
            return;
        }
        m12580qdMbNW(C3795h.m12134JHa(this.f14558wA, c3613eEOGOh), null, true);
        if (this.f14556mjFkc.isEmpty() || m12575fehf(c3613eEOGOh) || this.f14552MiMN.m12150KLFTb(c3613eEOGOh, this.f14559xJ)) {
            return;
        }
        if (c3613eEOGOh.m11826mjFkc() == 18) {
            this.f14557qdMbNW = true;
        }
        if (!this.f14557qdMbNW) {
            m12576lgHUyS(C3795h.m12134JHa(this.f14558wA, c3613eEOGOh));
            return;
        }
        C3795h c3795h2 = this.f14552MiMN;
        c3795h2.f13906YoKzxo.sendMessageDelayed(Message.obtain(c3795h2.f13906YoKzxo, 9, this.f14558wA), 5000L);
    }

    /* renamed from: Dt */
    public final void m12560Dt() {
        ArrayList arrayList = new ArrayList(this.f14556mjFkc);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            AbstractC4028kd abstractC4028kd = (AbstractC4028kd) arrayList.get(i);
            if (!this.f14547AZxh.m11420mjFkc()) {
                return;
            }
            if (m12579qGY(abstractC4028kd)) {
                this.f14556mjFkc.remove(abstractC4028kd);
            }
        }
    }

    /* renamed from: ETF */
    public final void m12561ETF() {
        m12583wJVbdd();
        m12564JHa(C3613eEOGOh.f13447KLFTb);
        m12581rkYL();
        Iterator it = this.f14550JHa.values().iterator();
        while (it.hasNext()) {
            AbstractC1704Bc abstractC1704Bc = (AbstractC1704Bc) it.next();
            if (m12582wA(abstractC1704Bc.f7500mjFkc.m11979AZxh()) != null) {
                it.remove();
            } else {
                try {
                    abstractC1704Bc.f7500mjFkc.m11982wA(this.f14547AZxh, new C1806D7());
                } catch (DeadObjectException unused) {
                    mo8441KLFTb(3);
                    this.f14547AZxh.m11418ZfxDd("DeadObjectException thrown while calling register listener method.");
                } catch (RemoteException unused2) {
                    it.remove();
                }
            }
        }
        m12560Dt();
        m12566MiMN();
    }

    /* renamed from: Gd */
    public final Map m12562Gd() {
        return this.f14550JHa;
    }

    /* renamed from: IEE */
    public final boolean m12563IEE(boolean z) {
        AbstractC2138I3.m8643ZfxDd(this.f14552MiMN.f13906YoKzxo);
        if (!this.f14547AZxh.m11420mjFkc() || !this.f14550JHa.isEmpty()) {
            return false;
        }
        if (!this.f14554ZfxDd.m10520KLFTb()) {
            this.f14547AZxh.m11418ZfxDd("Timing out service connection.");
            return true;
        }
        if (!z) {
            return false;
        }
        m12566MiMN();
        return false;
    }

    /* renamed from: JHa */
    public final void m12564JHa(C3613eEOGOh c3613eEOGOh) {
        Iterator it = this.f14551KLFTb.iterator();
        if (!it.hasNext()) {
            this.f14551KLFTb.clear();
            return;
        }
        AbstractC4793w7.m13819mjFkc(it.next());
        if (AbstractC2931U2.m10465mjFkc(c3613eEOGOh, C3613eEOGOh.f13447KLFTb)) {
            this.f14547AZxh.m11414Dt();
        }
        throw null;
    }

    @Override // p131o.InterfaceC3976jpz
    /* renamed from: KLFTb */
    public final void mo8441KLFTb(int i) {
        if (Looper.myLooper() == this.f14552MiMN.f13906YoKzxo.getLooper()) {
            m12571VA(i);
        } else {
            this.f14552MiMN.f13906YoKzxo.post(new RunnableC3831hc(this, i));
        }
    }

    /* renamed from: KLMXS */
    public final void m12565KLMXS() {
        AbstractC2138I3.m8643ZfxDd(this.f14552MiMN.f13906YoKzxo);
        if (this.f14557qdMbNW) {
            m12577mByQ();
        }
    }

    /* renamed from: MiMN */
    public final void m12566MiMN() {
        this.f14552MiMN.f13906YoKzxo.removeMessages(12, this.f14558wA);
        C2245JYn c2245JYn = this.f14558wA;
        C3795h c3795h = this.f14552MiMN;
        c3795h.f13906YoKzxo.sendMessageDelayed(c3795h.f13906YoKzxo.obtainMessage(12, c2245JYn), this.f14552MiMN.f13909mjFkc);
    }

    /* renamed from: Ne */
    public final void m12567Ne() {
        this.f14553VA++;
    }

    /* renamed from: OjSQV */
    public final void m12568OjSQV(AbstractC4028kd abstractC4028kd) {
        AbstractC2138I3.m8643ZfxDd(this.f14552MiMN.f13906YoKzxo);
        if (this.f14547AZxh.m11420mjFkc()) {
            if (m12579qGY(abstractC4028kd)) {
                m12566MiMN();
                return;
            } else {
                this.f14556mjFkc.add(abstractC4028kd);
                return;
            }
        }
        this.f14556mjFkc.add(abstractC4028kd);
        C3613eEOGOh c3613eEOGOh = this.f14549ETF;
        if (c3613eEOGOh == null || !c3613eEOGOh.m11824ZfxDd()) {
            m12577mByQ();
        } else {
            m12559CqaNbM(this.f14549ETF, null);
        }
    }

    /* renamed from: Pq */
    public final int m12569Pq() {
        return this.f14559xJ;
    }

    /* renamed from: Ucbh */
    public final C3389aqHPIZ.JHa m12570Ucbh() {
        return this.f14547AZxh;
    }

    /* renamed from: VA */
    public final void m12571VA(int i) {
        m12583wJVbdd();
        this.f14557qdMbNW = true;
        this.f14554ZfxDd.m10522wA(i, this.f14547AZxh.m11415ETF());
        C2245JYn c2245JYn = this.f14558wA;
        C3795h c3795h = this.f14552MiMN;
        c3795h.f13906YoKzxo.sendMessageDelayed(Message.obtain(c3795h.f13906YoKzxo, 9, c2245JYn), 5000L);
        C2245JYn c2245JYn2 = this.f14558wA;
        C3795h c3795h2 = this.f14552MiMN;
        c3795h2.f13906YoKzxo.sendMessageDelayed(Message.obtain(c3795h2.f13906YoKzxo, 11, c2245JYn2), 120000L);
        this.f14552MiMN.f13913xJ.m12992wA();
        Iterator it = this.f14550JHa.values().iterator();
        while (it.hasNext()) {
            ((AbstractC1704Bc) it.next()).f7501wA.run();
        }
    }

    /* renamed from: YoKzxo */
    public final void m12572YoKzxo(AbstractC4028kd abstractC4028kd) {
        abstractC4028kd.mo11612ZfxDd(this.f14554ZfxDd, m12578mjFkc());
        try {
            abstractC4028kd.mo9003wA(this);
        } catch (DeadObjectException unused) {
            mo8441KLFTb(1);
            this.f14547AZxh.m11418ZfxDd("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    @Override // p131o.InterfaceC3338a3
    /* renamed from: ZfxDd */
    public final void mo8443ZfxDd(C3613eEOGOh c3613eEOGOh) {
        m12559CqaNbM(c3613eEOGOh, null);
    }

    /* renamed from: cMLeY */
    public final void m12573cMLeY() {
        AbstractC2138I3.m8643ZfxDd(this.f14552MiMN.f13906YoKzxo);
        if (this.f14557qdMbNW) {
            m12581rkYL();
            C3795h c3795h = this.f14552MiMN;
            m12576lgHUyS(c3795h.f13902JHa.mo11789xJ(c3795h.f13903KLFTb) == 18 ? new C0210Status(21, "Connection timed out waiting for Google Play services update to complete.") : new C0210Status(22, "API failed to connect while resuming due to an unknown error."));
            this.f14547AZxh.m11418ZfxDd("Timing out connection while resuming.");
        }
    }

    /* renamed from: diqgf */
    public final int m12574diqgf() {
        return this.f14553VA;
    }

    /* renamed from: fehf */
    public final boolean m12575fehf(C3613eEOGOh c3613eEOGOh) {
        synchronized (C3795h.f13895IEE) {
            try {
                C3795h c3795h = this.f14552MiMN;
                if (c3795h.f13901ETF == null || !c3795h.f13905VA.contains(this.f14558wA)) {
                    return false;
                }
                this.f14552MiMN.f13901ETF.m7851Pq(c3613eEOGOh, this.f14559xJ);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: lgHUyS */
    public final void m12576lgHUyS(C0210Status c0210Status) {
        AbstractC2138I3.m8643ZfxDd(this.f14552MiMN.f13906YoKzxo);
        m12580qdMbNW(c0210Status, null, false);
    }

    /* renamed from: mByQ */
    public final void m12577mByQ() {
        AbstractC2138I3.m8643ZfxDd(this.f14552MiMN.f13906YoKzxo);
        if (this.f14547AZxh.m11420mjFkc() || this.f14547AZxh.m11419lgHUyS()) {
            return;
        }
        try {
            C3795h c3795h = this.f14552MiMN;
            int iM12990AZxh = c3795h.f13913xJ.m12990AZxh(c3795h.f13903KLFTb, this.f14547AZxh);
            if (iM12990AZxh == 0) {
                C3795h c3795h2 = this.f14552MiMN;
                C3389aqHPIZ.JHa jHa = this.f14547AZxh;
                C4290oc c4290oc = new C4290oc(c3795h2, jHa, this.f14558wA);
                if (jHa.mo9216YoKzxo()) {
                    ((BinderC2041Gc) AbstractC2138I3.m8648xJ(this.f14555lgHUyS)).m8440HGpJ(c4290oc);
                }
                try {
                    this.f14547AZxh.m11421qGY(c4290oc);
                    return;
                } catch (SecurityException e) {
                    m12559CqaNbM(new C3613eEOGOh(10), e);
                    return;
                }
            }
            C3613eEOGOh c3613eEOGOh = new C3613eEOGOh(iM12990AZxh, null);
            Log.w("GoogleApiManager", "The service for " + this.f14547AZxh.getClass().getName() + " is not available: " + c3613eEOGOh.toString());
            m12559CqaNbM(c3613eEOGOh, null);
        } catch (IllegalStateException e2) {
            m12559CqaNbM(new C3613eEOGOh(10), e2);
        }
    }

    /* renamed from: mjFkc */
    public final boolean m12578mjFkc() {
        return this.f14547AZxh.mo9216YoKzxo();
    }

    /* renamed from: qGY */
    public final boolean m12579qGY(AbstractC4028kd abstractC4028kd) {
        if (!(abstractC4028kd instanceof AbstractC4894xc)) {
            m12572YoKzxo(abstractC4028kd);
            return true;
        }
        AbstractC4894xc abstractC4894xc = (AbstractC4894xc) abstractC4028kd;
        C2987UokA c2987UokAM12582wA = m12582wA(abstractC4894xc.mo11613xJ(this));
        if (c2987UokAM12582wA == null) {
            m12572YoKzxo(abstractC4028kd);
            return true;
        }
        Log.w("GoogleApiManager", this.f14547AZxh.getClass().getName() + " could not execute call because it requires feature (" + c2987UokAM12582wA.m10649mjFkc() + ", " + c2987UokAM12582wA.m10647AZxh() + ").");
        if (!this.f14552MiMN.f13911rkYL || !abstractC4894xc.mo11611JHa(this)) {
            abstractC4894xc.mo9000AZxh(new C4728v9(c2987UokAM12582wA));
            return true;
        }
        C4160mc c4160mc = new C4160mc(this.f14558wA, c2987UokAM12582wA, null);
        int iIndexOf = this.f14548Dt.indexOf(c4160mc);
        if (iIndexOf >= 0) {
            C4160mc c4160mc2 = (C4160mc) this.f14548Dt.get(iIndexOf);
            this.f14552MiMN.f13906YoKzxo.removeMessages(15, c4160mc2);
            C3795h c3795h = this.f14552MiMN;
            c3795h.f13906YoKzxo.sendMessageDelayed(Message.obtain(c3795h.f13906YoKzxo, 15, c4160mc2), 5000L);
            return false;
        }
        this.f14548Dt.add(c4160mc);
        C3795h c3795h2 = this.f14552MiMN;
        c3795h2.f13906YoKzxo.sendMessageDelayed(Message.obtain(c3795h2.f13906YoKzxo, 15, c4160mc), 5000L);
        C3795h c3795h3 = this.f14552MiMN;
        c3795h3.f13906YoKzxo.sendMessageDelayed(Message.obtain(c3795h3.f13906YoKzxo, 16, c4160mc), 120000L);
        C3613eEOGOh c3613eEOGOh = new C3613eEOGOh(2, null);
        if (m12575fehf(c3613eEOGOh)) {
            return false;
        }
        this.f14552MiMN.m12150KLFTb(c3613eEOGOh, this.f14559xJ);
        return false;
    }

    /* renamed from: qdMbNW */
    public final void m12580qdMbNW(C0210Status c0210Status, Exception exc, boolean z) {
        AbstractC2138I3.m8643ZfxDd(this.f14552MiMN.f13906YoKzxo);
        if ((c0210Status == null) == (exc == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.f14556mjFkc.iterator();
        while (it.hasNext()) {
            AbstractC4028kd abstractC4028kd = (AbstractC4028kd) it.next();
            if (!z || abstractC4028kd.f14560mjFkc == 2) {
                if (c0210Status != null) {
                    abstractC4028kd.mo9002mjFkc(c0210Status);
                } else {
                    abstractC4028kd.mo9000AZxh(exc);
                }
                it.remove();
            }
        }
    }

    /* renamed from: rkYL */
    public final void m12581rkYL() {
        if (this.f14557qdMbNW) {
            C3795h c3795h = this.f14552MiMN;
            c3795h.f13906YoKzxo.removeMessages(11, this.f14558wA);
            C3795h c3795h2 = this.f14552MiMN;
            c3795h2.f13906YoKzxo.removeMessages(9, this.f14558wA);
            this.f14557qdMbNW = false;
        }
    }

    /* renamed from: wA */
    public final C2987UokA m12582wA(C2987UokA[] c2987UokAArr) {
        if (c2987UokAArr != null && c2987UokAArr.length != 0) {
            C2987UokA[] c2987UokAArrM11422qdMbNW = this.f14547AZxh.m11422qdMbNW();
            if (c2987UokAArrM11422qdMbNW == null) {
                c2987UokAArrM11422qdMbNW = new C2987UokA[0];
            }
            C4633tjSezt c4633tjSezt = new C4633tjSezt(c2987UokAArrM11422qdMbNW.length);
            for (C2987UokA c2987UokA : c2987UokAArrM11422qdMbNW) {
                c4633tjSezt.put(c2987UokA.m10649mjFkc(), Long.valueOf(c2987UokA.m10647AZxh()));
            }
            for (C2987UokA c2987UokA2 : c2987UokAArr) {
                Long l = (Long) c4633tjSezt.get(c2987UokA2.m10649mjFkc());
                if (l == null || l.longValue() < c2987UokA2.m10647AZxh()) {
                    return c2987UokA2;
                }
            }
        }
        return null;
    }

    /* renamed from: wJVbdd */
    public final void m12583wJVbdd() {
        AbstractC2138I3.m8643ZfxDd(this.f14552MiMN.f13906YoKzxo);
        this.f14549ETF = null;
    }

    @Override // p131o.InterfaceC3976jpz
    /* renamed from: xJ */
    public final void mo8445xJ(Bundle bundle) {
        if (Looper.myLooper() == this.f14552MiMN.f13906YoKzxo.getLooper()) {
            m12561ETF();
        } else {
            this.f14552MiMN.f13906YoKzxo.post(new RunnableC3766gc(this));
        }
    }

    /* renamed from: xrEuO */
    public final void m12584xrEuO(C3613eEOGOh c3613eEOGOh) {
        AbstractC2138I3.m8643ZfxDd(this.f14552MiMN.f13906YoKzxo);
        C3389aqHPIZ.JHa jHa = this.f14547AZxh;
        jHa.m11418ZfxDd("onSignInFailed for " + jHa.getClass().getName() + " with " + String.valueOf(c3613eEOGOh));
        m12559CqaNbM(c3613eEOGOh, null);
    }

    /* renamed from: zvd */
    public final void m12585zvd() {
        AbstractC2138I3.m8643ZfxDd(this.f14552MiMN.f13906YoKzxo);
        m12576lgHUyS(C3795h.f13898qGY);
        this.f14554ZfxDd.m10521ZfxDd();
        for (AbstractC3470c1 abstractC3470c1 : (AbstractC3470c1[]) this.f14550JHa.keySet().toArray(new AbstractC3470c1[0])) {
            m12568OjSQV(new C3768gd(abstractC3470c1, new C1806D7()));
        }
        m12564JHa(new C3613eEOGOh(4));
        if (this.f14547AZxh.m11420mjFkc()) {
            this.f14547AZxh.m11423xJ(new C3960jc(this));
        }
    }
}
