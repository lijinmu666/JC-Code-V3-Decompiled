package androidx.lifecycle;

import androidx.lifecycle.AbstractC0112wA;
import java.util.Map;
import p131o.C3787gtIJp;
import p131o.C3802h6;
import p131o.InterfaceC3068W0;
import p131o.InterfaceC3070W2;

/* loaded from: classes.dex */
public abstract class LiveData {

    /* renamed from: ETF */
    public static final Object f1359ETF = new Object();

    /* renamed from: Dt */
    public final Runnable f1361Dt;

    /* renamed from: JHa */
    public volatile Object f1362JHa;

    /* renamed from: KLFTb */
    public volatile Object f1363KLFTb;

    /* renamed from: ZfxDd */
    public boolean f1364ZfxDd;

    /* renamed from: lgHUyS */
    public boolean f1365lgHUyS;

    /* renamed from: qdMbNW */
    public boolean f1367qdMbNW;

    /* renamed from: xJ */
    public int f1369xJ;

    /* renamed from: mjFkc */
    public final Object f1366mjFkc = new Object();

    /* renamed from: AZxh */
    public C3802h6 f1360AZxh = new C3802h6();

    /* renamed from: wA */
    public int f1368wA = 0;

    /* renamed from: androidx.lifecycle.LiveData$AZxh */
    public abstract class AbstractC0106AZxh {

        /* renamed from: AZxh */
        public boolean f1370AZxh;

        /* renamed from: ZfxDd */
        public final /* synthetic */ LiveData f1371ZfxDd;

        /* renamed from: mjFkc */
        public final InterfaceC3070W2 f1372mjFkc;

        /* renamed from: wA */
        public int f1373wA;

        /* renamed from: AZxh */
        public abstract void m1063AZxh();

        /* renamed from: mjFkc */
        public void m1064mjFkc(boolean z) {
            if (z == this.f1370AZxh) {
                return;
            }
            this.f1370AZxh = z;
            this.f1371ZfxDd.m1056AZxh(z ? 1 : -1);
            if (this.f1370AZxh) {
                this.f1371ZfxDd.m1059ZfxDd(this);
            }
        }

        /* renamed from: wA */
        public abstract boolean m1065wA();
    }

    public class LifecycleBoundObserver extends androidx.lifecycle.LiveData.AZxh implements InterfaceC0104KLFTb {

        /* renamed from: JHa */
        public final /* synthetic */ LiveData f1374JHa;

        /* renamed from: KLFTb */
        public final InterfaceC3068W0 f1375KLFTb;

        /* renamed from: AZxh */
        public void m1066AZxh() {
            this.f1375KLFTb.mo770JHa().mo1046wA(this);
        }

        @Override // androidx.lifecycle.InterfaceC0104KLFTb
        /* renamed from: VA */
        public void mo4VA(InterfaceC3068W0 interfaceC3068W0, AbstractC0112wA.mjFkc mjfkc) {
            AbstractC0112wA.AZxh aZxhMo1035AZxh = this.f1375KLFTb.mo770JHa().mo1035AZxh();
            if (aZxhMo1035AZxh == AbstractC0112wA.AZxh.DESTROYED) {
                this.f1374JHa.m1062xJ(this.f1372mjFkc);
                return;
            }
            AbstractC0112wA.AZxh aZxh = null;
            while (aZxh != aZxhMo1035AZxh) {
                m1064mjFkc(m1067wA());
                aZxh = aZxhMo1035AZxh;
                aZxhMo1035AZxh = this.f1375KLFTb.mo770JHa().mo1035AZxh();
            }
        }

        /* renamed from: wA */
        public boolean m1067wA() {
            return this.f1375KLFTb.mo770JHa().mo1035AZxh().m1098lgHUyS(AbstractC0112wA.AZxh.STARTED);
        }
    }

    /* renamed from: androidx.lifecycle.LiveData$mjFkc */
    public class RunnableC0107mjFkc implements Runnable {
        public RunnableC0107mjFkc() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f1366mjFkc) {
                obj = LiveData.this.f1362JHa;
                LiveData.this.f1362JHa = LiveData.f1359ETF;
            }
            LiveData.this.mo1060lgHUyS(obj);
        }
    }

    public LiveData() {
        Object obj = f1359ETF;
        this.f1362JHa = obj;
        this.f1361Dt = new RunnableC0107mjFkc();
        this.f1363KLFTb = obj;
        this.f1369xJ = -1;
    }

    /* renamed from: mjFkc */
    public static void m1055mjFkc(String str) {
        if (C3787gtIJp.m12108JHa().mo8107AZxh()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    /* renamed from: AZxh */
    public void m1056AZxh(int i) {
        int i2 = this.f1368wA;
        this.f1368wA = i + i2;
        if (this.f1364ZfxDd) {
            return;
        }
        this.f1364ZfxDd = true;
        while (true) {
            try {
                int i3 = this.f1368wA;
                if (i2 == i3) {
                    this.f1364ZfxDd = false;
                    return;
                }
                boolean z = i2 == 0 && i3 > 0;
                boolean z2 = i2 > 0 && i3 == 0;
                if (z) {
                    m1058KLFTb();
                } else if (z2) {
                    m1057JHa();
                }
                i2 = i3;
            } catch (Throwable th) {
                this.f1364ZfxDd = false;
                throw th;
            }
        }
    }

    /* renamed from: JHa */
    public void m1057JHa() {
    }

    /* renamed from: KLFTb */
    public void m1058KLFTb() {
    }

    /* renamed from: ZfxDd */
    public void m1059ZfxDd(AbstractC0106AZxh abstractC0106AZxh) {
        if (this.f1365lgHUyS) {
            this.f1367qdMbNW = true;
            return;
        }
        this.f1365lgHUyS = true;
        do {
            this.f1367qdMbNW = false;
            if (abstractC0106AZxh != null) {
                m1061wA(abstractC0106AZxh);
                abstractC0106AZxh = null;
            } else {
                C3802h6.ZfxDd zfxDdM12176xJ = this.f1360AZxh.m12176xJ();
                while (zfxDdM12176xJ.hasNext()) {
                    m1061wA((AbstractC0106AZxh) ((Map.Entry) zfxDdM12176xJ.next()).getValue());
                    if (this.f1367qdMbNW) {
                        break;
                    }
                }
            }
        } while (this.f1367qdMbNW);
        this.f1365lgHUyS = false;
    }

    /* renamed from: lgHUyS */
    public void mo1060lgHUyS(Object obj) {
        m1055mjFkc("setValue");
        this.f1369xJ++;
        this.f1363KLFTb = obj;
        m1059ZfxDd(null);
    }

    /* renamed from: wA */
    public final void m1061wA(AbstractC0106AZxh abstractC0106AZxh) {
        if (abstractC0106AZxh.f1370AZxh) {
            if (!abstractC0106AZxh.m1065wA()) {
                abstractC0106AZxh.m1064mjFkc(false);
                return;
            }
            int i = abstractC0106AZxh.f1373wA;
            int i2 = this.f1369xJ;
            if (i >= i2) {
                return;
            }
            abstractC0106AZxh.f1373wA = i2;
            abstractC0106AZxh.f1372mjFkc.mo10764mjFkc(this.f1363KLFTb);
        }
    }

    /* renamed from: xJ */
    public void m1062xJ(InterfaceC3070W2 interfaceC3070W2) {
        m1055mjFkc("removeObserver");
        AbstractC0106AZxh abstractC0106AZxh = (AbstractC0106AZxh) this.f1360AZxh.mo12168ETF(interfaceC3070W2);
        if (abstractC0106AZxh == null) {
            return;
        }
        abstractC0106AZxh.m1063AZxh();
        abstractC0106AZxh.m1064mjFkc(false);
    }
}
