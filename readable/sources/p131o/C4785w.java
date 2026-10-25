package p131o;

import java.util.Iterator;
import p131o.C4494rdtF;

/* renamed from: o.w */
/* loaded from: classes.dex */
public class C4785w extends AbstractC2246Ja {
    public C4785w(C3776gjvQ c3776gjvQ) {
        super(c3776gjvQ);
    }

    /* renamed from: fehf */
    private void m13805fehf(C4494rdtF c4494rdtF) {
        this.f9001lgHUyS.f16349ETF.add(c4494rdtF);
        c4494rdtF.f16352VA.add(this.f9001lgHUyS);
    }

    @Override // p131o.AbstractC2246Ja
    /* renamed from: JHa */
    public void mo7516JHa() {
        this.f9004wA = null;
        this.f9001lgHUyS.m13387wA();
    }

    @Override // p131o.AbstractC2246Ja
    /* renamed from: KLFTb */
    public void mo7517KLFTb() {
        C3776gjvQ c3776gjvQ = this.f8996AZxh;
        if (c3776gjvQ instanceof C2257Jk) {
            int iM9030XD = ((C2257Jk) c3776gjvQ).m9030XD();
            if (iM9030XD == 0 || iM9030XD == 1) {
                this.f8996AZxh.m12093uH(this.f9001lgHUyS.f16358xJ);
            } else {
                this.f8996AZxh.m12090tISON(this.f9001lgHUyS.f16358xJ);
            }
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
        C3776gjvQ c3776gjvQ = this.f8996AZxh;
        if (c3776gjvQ instanceof C2257Jk) {
            this.f9001lgHUyS.f16347AZxh = true;
            C2257Jk c2257Jk = (C2257Jk) c3776gjvQ;
            int iM9030XD = c2257Jk.m9030XD();
            boolean zM9034sRqPfw = c2257Jk.m9034sRqPfw();
            int i = 0;
            if (iM9030XD == 0) {
                this.f9001lgHUyS.f16351KLFTb = C4494rdtF.mjFkc.LEFT;
                while (i < c2257Jk.f17301yX) {
                    C3776gjvQ c3776gjvQ2 = c2257Jk.f17300tjSezt[i];
                    if (zM9034sRqPfw || c3776gjvQ2.m12043NPj() != 8) {
                        C4494rdtF c4494rdtF = c3776gjvQ2.f13778KLFTb.f9001lgHUyS;
                        c4494rdtF.f16349ETF.add(this.f9001lgHUyS);
                        this.f9001lgHUyS.f16352VA.add(c4494rdtF);
                    }
                    i++;
                }
                m13805fehf(this.f8996AZxh.f13778KLFTb.f9001lgHUyS);
                m13805fehf(this.f8996AZxh.f13778KLFTb.f9003qdMbNW);
                return;
            }
            if (iM9030XD == 1) {
                this.f9001lgHUyS.f16351KLFTb = C4494rdtF.mjFkc.RIGHT;
                while (i < c2257Jk.f17301yX) {
                    C3776gjvQ c3776gjvQ3 = c2257Jk.f17300tjSezt[i];
                    if (zM9034sRqPfw || c3776gjvQ3.m12043NPj() != 8) {
                        C4494rdtF c4494rdtF2 = c3776gjvQ3.f13778KLFTb.f9003qdMbNW;
                        c4494rdtF2.f16349ETF.add(this.f9001lgHUyS);
                        this.f9001lgHUyS.f16352VA.add(c4494rdtF2);
                    }
                    i++;
                }
                m13805fehf(this.f8996AZxh.f13778KLFTb.f9001lgHUyS);
                m13805fehf(this.f8996AZxh.f13778KLFTb.f9003qdMbNW);
                return;
            }
            if (iM9030XD == 2) {
                this.f9001lgHUyS.f16351KLFTb = C4494rdtF.mjFkc.TOP;
                while (i < c2257Jk.f17301yX) {
                    C3776gjvQ c3776gjvQ4 = c2257Jk.f17300tjSezt[i];
                    if (zM9034sRqPfw || c3776gjvQ4.m12043NPj() != 8) {
                        C4494rdtF c4494rdtF3 = c3776gjvQ4.f13774JHa.f9001lgHUyS;
                        c4494rdtF3.f16349ETF.add(this.f9001lgHUyS);
                        this.f9001lgHUyS.f16352VA.add(c4494rdtF3);
                    }
                    i++;
                }
                m13805fehf(this.f8996AZxh.f13774JHa.f9001lgHUyS);
                m13805fehf(this.f8996AZxh.f13774JHa.f9003qdMbNW);
                return;
            }
            if (iM9030XD != 3) {
                return;
            }
            this.f9001lgHUyS.f16351KLFTb = C4494rdtF.mjFkc.BOTTOM;
            while (i < c2257Jk.f17301yX) {
                C3776gjvQ c3776gjvQ5 = c2257Jk.f17300tjSezt[i];
                if (zM9034sRqPfw || c3776gjvQ5.m12043NPj() != 8) {
                    C4494rdtF c4494rdtF4 = c3776gjvQ5.f13774JHa.f9003qdMbNW;
                    c4494rdtF4.f16349ETF.add(this.f9001lgHUyS);
                    this.f9001lgHUyS.f16352VA.add(c4494rdtF4);
                }
                i++;
            }
            m13805fehf(this.f8996AZxh.f13774JHa.f9001lgHUyS);
            m13805fehf(this.f8996AZxh.f13774JHa.f9003qdMbNW);
        }
    }

    @Override // p131o.AbstractC2246Ja, p131o.InterfaceC2695QQi
    /* renamed from: mjFkc */
    public void mo7521mjFkc(InterfaceC2695QQi interfaceC2695QQi) {
        C2257Jk c2257Jk = (C2257Jk) this.f8996AZxh;
        int iM9030XD = c2257Jk.m9030XD();
        Iterator it = this.f9001lgHUyS.f16352VA.iterator();
        int i = 0;
        int i2 = -1;
        while (it.hasNext()) {
            int i3 = ((C4494rdtF) it.next()).f16358xJ;
            if (i2 == -1 || i3 < i2) {
                i2 = i3;
            }
            if (i < i3) {
                i = i3;
            }
        }
        if (iM9030XD == 0 || iM9030XD == 2) {
            this.f9001lgHUyS.mo7695ZfxDd(i2 + c2257Jk.m9032gtr());
        } else {
            this.f9001lgHUyS.mo7695ZfxDd(i + c2257Jk.m9032gtr());
        }
    }
}
