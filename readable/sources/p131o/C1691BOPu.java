package p131o;

import p131o.C4494rdtF;

/* renamed from: o.BOPu */
/* loaded from: classes.dex */
public class C1691BOPu extends C4494rdtF {

    /* renamed from: MiMN */
    public int f7478MiMN;

    public C1691BOPu(AbstractC2246Ja abstractC2246Ja) {
        super(abstractC2246Ja);
        if (abstractC2246Ja instanceof C1597A) {
            this.f16351KLFTb = C4494rdtF.mjFkc.HORIZONTAL_DIMENSION;
        } else {
            this.f16351KLFTb = C4494rdtF.mjFkc.VERTICAL_DIMENSION;
        }
    }

    @Override // p131o.C4494rdtF
    /* renamed from: ZfxDd */
    public void mo7695ZfxDd(int i) {
        if (this.f16348Dt) {
            return;
        }
        this.f16348Dt = true;
        this.f16358xJ = i;
        for (InterfaceC2695QQi interfaceC2695QQi : this.f16349ETF) {
            interfaceC2695QQi.mo7521mjFkc(interfaceC2695QQi);
        }
    }
}
