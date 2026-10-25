package p131o;

/* renamed from: o.o */
/* loaded from: classes.dex */
public class C4251o extends AbstractC2246Ja {
    public C4251o(C3776gjvQ c3776gjvQ) {
        super(c3776gjvQ);
        c3776gjvQ.f13778KLFTb.mo7516JHa();
        c3776gjvQ.f13774JHa.mo7516JHa();
        this.f8998JHa = ((C4186n) c3776gjvQ).m12829sRqPfw();
    }

    @Override // p131o.AbstractC2246Ja
    /* renamed from: JHa */
    public void mo7516JHa() {
        this.f9001lgHUyS.m13387wA();
    }

    @Override // p131o.AbstractC2246Ja
    /* renamed from: KLFTb */
    public void mo7517KLFTb() {
        if (((C4186n) this.f8996AZxh).m12829sRqPfw() == 1) {
            this.f8996AZxh.m12093uH(this.f9001lgHUyS.f16358xJ);
        } else {
            this.f8996AZxh.m12090tISON(this.f9001lgHUyS.f16358xJ);
        }
    }

    @Override // p131o.AbstractC2246Ja
    /* renamed from: MiMN */
    public boolean mo7518MiMN() {
        return false;
    }

    @Override // p131o.AbstractC2246Ja
    /* renamed from: ZfxDd */
    public void mo7519ZfxDd() {
        C4186n c4186n = (C4186n) this.f8996AZxh;
        int iM12825XD = c4186n.m12825XD();
        int iM12827gtr = c4186n.m12827gtr();
        c4186n.m12822Dp();
        if (c4186n.m12829sRqPfw() == 1) {
            if (iM12825XD != -1) {
                this.f9001lgHUyS.f16352VA.add(this.f8996AZxh.f13795Vnb.f13778KLFTb.f9001lgHUyS);
                this.f8996AZxh.f13795Vnb.f13778KLFTb.f9001lgHUyS.f16349ETF.add(this.f9001lgHUyS);
                this.f9001lgHUyS.f16350JHa = iM12825XD;
            } else if (iM12827gtr != -1) {
                this.f9001lgHUyS.f16352VA.add(this.f8996AZxh.f13795Vnb.f13778KLFTb.f9003qdMbNW);
                this.f8996AZxh.f13795Vnb.f13778KLFTb.f9003qdMbNW.f16349ETF.add(this.f9001lgHUyS);
                this.f9001lgHUyS.f16350JHa = -iM12827gtr;
            } else {
                C4494rdtF c4494rdtF = this.f9001lgHUyS;
                c4494rdtF.f16347AZxh = true;
                c4494rdtF.f16352VA.add(this.f8996AZxh.f13795Vnb.f13778KLFTb.f9003qdMbNW);
                this.f8996AZxh.f13795Vnb.f13778KLFTb.f9003qdMbNW.f16349ETF.add(this.f9001lgHUyS);
            }
            m12913fehf(this.f8996AZxh.f13778KLFTb.f9001lgHUyS);
            m12913fehf(this.f8996AZxh.f13778KLFTb.f9003qdMbNW);
            return;
        }
        if (iM12825XD != -1) {
            this.f9001lgHUyS.f16352VA.add(this.f8996AZxh.f13795Vnb.f13774JHa.f9001lgHUyS);
            this.f8996AZxh.f13795Vnb.f13774JHa.f9001lgHUyS.f16349ETF.add(this.f9001lgHUyS);
            this.f9001lgHUyS.f16350JHa = iM12825XD;
        } else if (iM12827gtr != -1) {
            this.f9001lgHUyS.f16352VA.add(this.f8996AZxh.f13795Vnb.f13774JHa.f9003qdMbNW);
            this.f8996AZxh.f13795Vnb.f13774JHa.f9003qdMbNW.f16349ETF.add(this.f9001lgHUyS);
            this.f9001lgHUyS.f16350JHa = -iM12827gtr;
        } else {
            C4494rdtF c4494rdtF2 = this.f9001lgHUyS;
            c4494rdtF2.f16347AZxh = true;
            c4494rdtF2.f16352VA.add(this.f8996AZxh.f13795Vnb.f13774JHa.f9003qdMbNW);
            this.f8996AZxh.f13795Vnb.f13774JHa.f9003qdMbNW.f16349ETF.add(this.f9001lgHUyS);
        }
        m12913fehf(this.f8996AZxh.f13774JHa.f9001lgHUyS);
        m12913fehf(this.f8996AZxh.f13774JHa.f9003qdMbNW);
    }

    /* renamed from: fehf */
    public final void m12913fehf(C4494rdtF c4494rdtF) {
        this.f9001lgHUyS.f16349ETF.add(c4494rdtF);
        c4494rdtF.f16352VA.add(this.f9001lgHUyS);
    }

    @Override // p131o.AbstractC2246Ja, p131o.InterfaceC2695QQi
    /* renamed from: mjFkc */
    public void mo7521mjFkc(InterfaceC2695QQi interfaceC2695QQi) {
        C4494rdtF c4494rdtF = this.f9001lgHUyS;
        if (c4494rdtF.f16357wA && !c4494rdtF.f16348Dt) {
            this.f9001lgHUyS.mo7695ZfxDd((int) ((((C4494rdtF) c4494rdtF.f16352VA.get(0)).f16358xJ * ((C4186n) this.f8996AZxh).m12822Dp()) + 0.5f));
        }
    }
}
