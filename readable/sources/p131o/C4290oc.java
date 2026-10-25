package p131o;

import android.util.Log;
import java.util.Set;
import p131o.AbstractC2308KRckQg;
import p131o.C3389aqHPIZ;

/* renamed from: o.oc */
/* loaded from: classes.dex */
public final class C4290oc implements AbstractC2308KRckQg.wA, InterfaceC1971Fc {

    /* renamed from: AZxh */
    public final C2245JYn f15767AZxh;

    /* renamed from: JHa */
    public final /* synthetic */ C3795h f15768JHa;

    /* renamed from: mjFkc */
    public final C3389aqHPIZ.JHa f15771mjFkc;

    /* renamed from: wA */
    public InterfaceC1662B f15772wA = null;

    /* renamed from: ZfxDd */
    public Set f15770ZfxDd = null;

    /* renamed from: KLFTb */
    public boolean f15769KLFTb = false;

    public C4290oc(C3795h c3795h, C3389aqHPIZ.JHa jHa, C2245JYn c2245JYn) {
        this.f15768JHa = c3795h;
        this.f15771mjFkc = jHa;
        this.f15767AZxh = c2245JYn;
    }

    @Override // p131o.InterfaceC1971Fc
    /* renamed from: AZxh */
    public final void mo8314AZxh(C3613eEOGOh c3613eEOGOh) {
        C4027kc c4027kc = (C4027kc) this.f15768JHa.f13900Dt.get(this.f15767AZxh);
        if (c4027kc != null) {
            c4027kc.m12584xrEuO(c3613eEOGOh);
        }
    }

    @Override // p131o.AbstractC2308KRckQg.wA
    /* renamed from: ZfxDd */
    public final void mo9238ZfxDd(C3613eEOGOh c3613eEOGOh) {
        this.f15768JHa.f13906YoKzxo.post(new RunnableC4225nc(this, c3613eEOGOh));
    }

    @Override // p131o.InterfaceC1971Fc
    /* renamed from: mjFkc */
    public final void mo8315mjFkc(InterfaceC1662B interfaceC1662B, Set set) {
        if (interfaceC1662B == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            mo8314AZxh(new C3613eEOGOh(4));
        } else {
            this.f15772wA = interfaceC1662B;
            this.f15770ZfxDd = set;
            m12989qdMbNW();
        }
    }

    /* renamed from: qdMbNW */
    public final void m12989qdMbNW() {
        InterfaceC1662B interfaceC1662B;
        if (!this.f15769KLFTb || (interfaceC1662B = this.f15772wA) == null) {
            return;
        }
        this.f15771mjFkc.m11413AZxh(interfaceC1662B, this.f15770ZfxDd);
    }

    @Override // p131o.InterfaceC1971Fc
    /* renamed from: wA */
    public final void mo8316wA(int i) {
        C4027kc c4027kc = (C4027kc) this.f15768JHa.f13900Dt.get(this.f15767AZxh);
        if (c4027kc != null) {
            if (c4027kc.f14557qdMbNW) {
                c4027kc.m12584xrEuO(new C3613eEOGOh(17));
            } else {
                c4027kc.mo8441KLFTb(i);
            }
        }
    }
}
