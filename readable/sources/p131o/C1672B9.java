package p131o;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import p131o.AbstractC3197Xxz;

/* renamed from: o.B9 */
/* loaded from: classes.dex */
public class C1672B9 {

    /* renamed from: AZxh */
    public final InterfaceC4598tAfC f7441AZxh;

    /* renamed from: JHa */
    public final InterfaceC4992z7 f7442JHa;

    /* renamed from: KLFTb */
    public final Executor f7443KLFTb;

    /* renamed from: ZfxDd */
    public final InterfaceC4957yb f7444ZfxDd;

    /* renamed from: mjFkc */
    public final Context f7445mjFkc;

    /* renamed from: wA */
    public final InterfaceC4829wfQA f7446wA;

    /* renamed from: xJ */
    public final InterfaceC3350aDq f7447xJ;

    public C1672B9(Context context, InterfaceC4598tAfC interfaceC4598tAfC, InterfaceC4829wfQA interfaceC4829wfQA, InterfaceC4957yb interfaceC4957yb, Executor executor, InterfaceC4992z7 interfaceC4992z7, InterfaceC3350aDq interfaceC3350aDq) {
        this.f7445mjFkc = context;
        this.f7441AZxh = interfaceC4598tAfC;
        this.f7446wA = interfaceC4829wfQA;
        this.f7444ZfxDd = interfaceC4957yb;
        this.f7443KLFTb = executor;
        this.f7442JHa = interfaceC4992z7;
        this.f7447xJ = interfaceC3350aDq;
    }

    /* renamed from: KLFTb */
    public static /* synthetic */ void m7673KLFTb(C1672B9 c1672b9, AbstractC3140X8 abstractC3140X8, int i, Runnable runnable) {
        try {
            try {
                InterfaceC4992z7 interfaceC4992z7 = c1672b9.f7442JHa;
                InterfaceC4829wfQA interfaceC4829wfQA = c1672b9.f7446wA;
                interfaceC4829wfQA.getClass();
                interfaceC4992z7.mo11686ZfxDd(C4994z9.m14094AZxh(interfaceC4829wfQA));
                if (c1672b9.m7677mjFkc()) {
                    c1672b9.m7676JHa(abstractC3140X8, i);
                } else {
                    c1672b9.f7442JHa.mo11686ZfxDd(C1607A9.m7594AZxh(c1672b9, abstractC3140X8, i));
                }
            } catch (C4928y7 unused) {
                c1672b9.f7444ZfxDd.mo11973mjFkc(abstractC3140X8, i + 1);
            }
            runnable.run();
        } catch (Throwable th) {
            runnable.run();
            throw th;
        }
    }

    /* renamed from: ZfxDd */
    public static /* synthetic */ Object m7674ZfxDd(C1672B9 c1672b9, AbstractC3140X8 abstractC3140X8, int i) {
        c1672b9.f7444ZfxDd.mo11973mjFkc(abstractC3140X8, i + 1);
        return null;
    }

    /* renamed from: wA */
    public static /* synthetic */ Object m7675wA(C1672B9 c1672b9, AbstractC3197Xxz abstractC3197Xxz, Iterable iterable, AbstractC3140X8 abstractC3140X8, int i) {
        if (abstractC3197Xxz.mo10705wA() == AbstractC3197Xxz.mjFkc.TRANSIENT_ERROR) {
            c1672b9.f7446wA.mo11685YoKzxo(iterable);
            c1672b9.f7444ZfxDd.mo11973mjFkc(abstractC3140X8, i + 1);
            return null;
        }
        c1672b9.f7446wA.mo11694wA(iterable);
        if (abstractC3197Xxz.mo10705wA() == AbstractC3197Xxz.mjFkc.OK) {
            c1672b9.f7446wA.mo11677IEE(abstractC3140X8, c1672b9.f7447xJ.mo7979mjFkc() + abstractC3197Xxz.mo10703AZxh());
        }
        if (!c1672b9.f7446wA.mo11676ETF(abstractC3140X8)) {
            return null;
        }
        c1672b9.f7444ZfxDd.mo11971AZxh(abstractC3140X8, 1, true);
        return null;
    }

    /* renamed from: JHa */
    public void m7676JHa(AbstractC3140X8 abstractC3140X8, int i) {
        AbstractC3197Xxz abstractC3197XxzMo10832mjFkc;
        InterfaceC3076W8 interfaceC3076W8Mo11270get = this.f7441AZxh.mo11270get(abstractC3140X8.mo10887AZxh());
        Iterable iterable = (Iterable) this.f7442JHa.mo11686ZfxDd(C4862x9.m13902AZxh(this, abstractC3140X8));
        if (iterable.iterator().hasNext()) {
            if (interfaceC3076W8Mo11270get == null) {
                AbstractC4122m1.m12737mjFkc("Uploader", "Unknown backend for %s, deleting event batch for it...", abstractC3140X8);
                abstractC3197XxzMo10832mjFkc = AbstractC3197Xxz.m11000mjFkc();
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add(((AbstractC4722v3) it.next()).mo13382AZxh());
                }
                abstractC3197XxzMo10832mjFkc = interfaceC3076W8Mo11270get.mo10832mjFkc(AbstractC3551dGDT.m11720mjFkc().mo11723AZxh(arrayList).mo11725wA(abstractC3140X8.mo10890wA()).mo11724mjFkc());
            }
            this.f7442JHa.mo11686ZfxDd(C4930y9.m13996AZxh(this, abstractC3197XxzMo10832mjFkc, iterable, abstractC3140X8, i));
        }
    }

    /* renamed from: mjFkc */
    public boolean m7677mjFkc() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f7445mjFkc.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* renamed from: xJ */
    public void m7678xJ(AbstractC3140X8 abstractC3140X8, int i, Runnable runnable) {
        this.f7443KLFTb.execute(RunnableC4795w9.m13823mjFkc(this, abstractC3140X8, i, runnable));
    }
}
