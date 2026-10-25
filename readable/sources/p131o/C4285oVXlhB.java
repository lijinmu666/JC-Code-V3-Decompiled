package p131o;

import android.graphics.Typeface;
import android.os.Handler;
import p131o.AbstractC2927Tz;
import p131o.AbstractC4165mh;

/* renamed from: o.oVXlhB */
/* loaded from: classes.dex */
public class C4285oVXlhB {

    /* renamed from: AZxh */
    public final Handler f15751AZxh;

    /* renamed from: mjFkc */
    public final AbstractC2927Tz.wA f15752mjFkc;

    /* renamed from: o.oVXlhB$AZxh */
    public class AZxh implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ int f15753AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ AbstractC2927Tz.wA f15754mjFkc;

        public AZxh(AbstractC2927Tz.wA wAVar, int i) {
            this.f15754mjFkc = wAVar;
            this.f15753AZxh = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15754mjFkc.mo10463mjFkc(this.f15753AZxh);
        }
    }

    /* renamed from: o.oVXlhB$mjFkc */
    public class mjFkc implements Runnable {

        /* renamed from: AZxh */
        public final /* synthetic */ Typeface f15756AZxh;

        /* renamed from: mjFkc */
        public final /* synthetic */ AbstractC2927Tz.wA f15757mjFkc;

        public mjFkc(AbstractC2927Tz.wA wAVar, Typeface typeface) {
            this.f15757mjFkc = wAVar;
            this.f15756AZxh = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15757mjFkc.mo10462AZxh(this.f15756AZxh);
        }
    }

    public C4285oVXlhB(AbstractC2927Tz.wA wAVar, Handler handler) {
        this.f15752mjFkc = wAVar;
        this.f15751AZxh = handler;
    }

    /* renamed from: AZxh */
    public void m12962AZxh(AbstractC4165mh.KLFTb kLFTb) {
        if (kLFTb.m12786mjFkc()) {
            m12964wA(kLFTb.f15238mjFkc);
        } else {
            m12963mjFkc(kLFTb.f15237AZxh);
        }
    }

    /* renamed from: mjFkc */
    public final void m12963mjFkc(int i) {
        this.f15751AZxh.post(new AZxh(this.f15752mjFkc, i));
    }

    /* renamed from: wA */
    public final void m12964wA(Typeface typeface) {
        this.f15751AZxh.post(new mjFkc(this.f15752mjFkc, typeface));
    }
}
