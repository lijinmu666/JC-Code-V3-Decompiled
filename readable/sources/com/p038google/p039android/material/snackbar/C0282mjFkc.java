package com.p038google.p039android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.material.snackbar.mjFkc */
/* loaded from: classes.dex */
public class C0282mjFkc {

    /* renamed from: KLFTb */
    public static C0282mjFkc f2801KLFTb;

    /* renamed from: ZfxDd */
    public wA f2803ZfxDd;

    /* renamed from: wA */
    public wA f2805wA;

    /* renamed from: mjFkc */
    public final Object f2804mjFkc = new Object();

    /* renamed from: AZxh */
    public final Handler f2802AZxh = new Handler(Looper.getMainLooper(), new mjFkc());

    /* renamed from: com.google.android.material.snackbar.mjFkc$AZxh */
    public interface AZxh {
        /* renamed from: AZxh */
        void mo3083AZxh(int i);

        /* renamed from: mjFkc */
        void mo3084mjFkc();
    }

    /* renamed from: com.google.android.material.snackbar.mjFkc$mjFkc */
    public class mjFkc implements Handler.Callback {
        public mjFkc() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            C0282mjFkc.this.m3112ZfxDd((wA) message.obj);
            return true;
        }
    }

    /* renamed from: com.google.android.material.snackbar.mjFkc$wA */
    public static class wA {

        /* renamed from: AZxh */
        public int f2807AZxh;

        /* renamed from: mjFkc */
        public final WeakReference f2808mjFkc;

        /* renamed from: wA */
        public boolean f2809wA;

        public wA(int i, AZxh aZxh) {
            this.f2808mjFkc = new WeakReference(aZxh);
            this.f2807AZxh = i;
        }

        /* renamed from: mjFkc */
        public boolean m3117mjFkc(AZxh aZxh) {
            return aZxh != null && this.f2808mjFkc.get() == aZxh;
        }
    }

    /* renamed from: wA */
    public static C0282mjFkc m3103wA() {
        if (f2801KLFTb == null) {
            f2801KLFTb = new C0282mjFkc();
        }
        return f2801KLFTb;
    }

    /* renamed from: AZxh */
    public void m3104AZxh(AZxh aZxh, int i) {
        synchronized (this.f2804mjFkc) {
            try {
                if (m3107JHa(aZxh)) {
                    m3114mjFkc(this.f2805wA, i);
                } else if (m3116xJ(aZxh)) {
                    m3114mjFkc(this.f2803ZfxDd, i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: Dt */
    public void m3105Dt(AZxh aZxh) {
        synchronized (this.f2804mjFkc) {
            try {
                if (m3107JHa(aZxh)) {
                    wA wAVar = this.f2805wA;
                    if (!wAVar.f2809wA) {
                        wAVar.f2809wA = true;
                        this.f2802AZxh.removeCallbacksAndMessages(wAVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: ETF */
    public void m3106ETF(AZxh aZxh) {
        synchronized (this.f2804mjFkc) {
            try {
                if (m3107JHa(aZxh)) {
                    wA wAVar = this.f2805wA;
                    if (wAVar.f2809wA) {
                        wAVar.f2809wA = false;
                        m3110VA(wAVar);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: JHa */
    public final boolean m3107JHa(AZxh aZxh) {
        wA wAVar = this.f2805wA;
        return wAVar != null && wAVar.m3117mjFkc(aZxh);
    }

    /* renamed from: KLFTb */
    public boolean m3108KLFTb(AZxh aZxh) {
        boolean z;
        synchronized (this.f2804mjFkc) {
            try {
                z = m3107JHa(aZxh) || m3116xJ(aZxh);
            } finally {
            }
        }
        return z;
    }

    /* renamed from: MiMN */
    public void m3109MiMN(int i, AZxh aZxh) {
        synchronized (this.f2804mjFkc) {
            try {
                if (m3107JHa(aZxh)) {
                    wA wAVar = this.f2805wA;
                    wAVar.f2807AZxh = i;
                    this.f2802AZxh.removeCallbacksAndMessages(wAVar);
                    m3110VA(this.f2805wA);
                    return;
                }
                if (m3116xJ(aZxh)) {
                    this.f2803ZfxDd.f2807AZxh = i;
                } else {
                    this.f2803ZfxDd = new wA(i, aZxh);
                }
                wA wAVar2 = this.f2805wA;
                if (wAVar2 == null || !m3114mjFkc(wAVar2, 4)) {
                    this.f2805wA = null;
                    m3111YoKzxo();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: VA */
    public final void m3110VA(wA wAVar) {
        int i = wAVar.f2807AZxh;
        if (i == -2) {
            return;
        }
        if (i <= 0) {
            i = i == -1 ? 1500 : 2750;
        }
        this.f2802AZxh.removeCallbacksAndMessages(wAVar);
        Handler handler = this.f2802AZxh;
        handler.sendMessageDelayed(Message.obtain(handler, 0, wAVar), i);
    }

    /* renamed from: YoKzxo */
    public final void m3111YoKzxo() {
        wA wAVar = this.f2803ZfxDd;
        if (wAVar != null) {
            this.f2805wA = wAVar;
            this.f2803ZfxDd = null;
            AZxh aZxh = (AZxh) wAVar.f2808mjFkc.get();
            if (aZxh != null) {
                aZxh.mo3084mjFkc();
            } else {
                this.f2805wA = null;
            }
        }
    }

    /* renamed from: ZfxDd */
    public void m3112ZfxDd(wA wAVar) {
        synchronized (this.f2804mjFkc) {
            try {
                if (this.f2805wA == wAVar || this.f2803ZfxDd == wAVar) {
                    m3114mjFkc(wAVar, 2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: lgHUyS */
    public void m3113lgHUyS(AZxh aZxh) {
        synchronized (this.f2804mjFkc) {
            try {
                if (m3107JHa(aZxh)) {
                    this.f2805wA = null;
                    if (this.f2803ZfxDd != null) {
                        m3111YoKzxo();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: mjFkc */
    public final boolean m3114mjFkc(wA wAVar, int i) {
        AZxh aZxh = (AZxh) wAVar.f2808mjFkc.get();
        if (aZxh == null) {
            return false;
        }
        this.f2802AZxh.removeCallbacksAndMessages(wAVar);
        aZxh.mo3083AZxh(i);
        return true;
    }

    /* renamed from: qdMbNW */
    public void m3115qdMbNW(AZxh aZxh) {
        synchronized (this.f2804mjFkc) {
            try {
                if (m3107JHa(aZxh)) {
                    m3110VA(this.f2805wA);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: xJ */
    public final boolean m3116xJ(AZxh aZxh) {
        wA wAVar = this.f2803ZfxDd;
        return wAVar != null && wAVar.m3117mjFkc(aZxh);
    }
}
