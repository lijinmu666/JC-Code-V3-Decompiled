package p131o;

import android.util.Log;

/* renamed from: o.nc */
/* loaded from: classes.dex */
public final class RunnableC4225nc implements Runnable {

    /* renamed from: AZxh */
    public final /* synthetic */ C4290oc f15435AZxh;

    /* renamed from: mjFkc */
    public final /* synthetic */ C3613eEOGOh f15436mjFkc;

    public RunnableC4225nc(C4290oc c4290oc, C3613eEOGOh c3613eEOGOh) {
        this.f15435AZxh = c4290oc;
        this.f15436mjFkc = c3613eEOGOh;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4290oc c4290oc = this.f15435AZxh;
        C4027kc c4027kc = (C4027kc) c4290oc.f15768JHa.f13900Dt.get(c4290oc.f15767AZxh);
        if (c4027kc == null) {
            return;
        }
        if (!this.f15436mjFkc.m11823JHa()) {
            c4027kc.m12559CqaNbM(this.f15436mjFkc, null);
            return;
        }
        this.f15435AZxh.f15769KLFTb = true;
        if (this.f15435AZxh.f15771mjFkc.mo9216YoKzxo()) {
            this.f15435AZxh.m12989qdMbNW();
            return;
        }
        try {
            C4290oc c4290oc2 = this.f15435AZxh;
            c4290oc2.f15771mjFkc.m11413AZxh(null, c4290oc2.f15771mjFkc.mo10026wA());
        } catch (SecurityException e) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e);
            this.f15435AZxh.f15771mjFkc.m11418ZfxDd("Failed to get service from broker.");
            c4027kc.m12559CqaNbM(new C3613eEOGOh(10), null);
        }
    }
}
