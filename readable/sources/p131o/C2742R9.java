package p131o;

import p131o.AbstractC2246Ja;
import p131o.C3776gjvQ;
import p131o.C4446qtZIjO;
import p131o.C4494rdtF;

/* renamed from: o.R9 */
/* loaded from: classes.dex */
public class C2742R9 extends AbstractC2246Ja {

    /* renamed from: ETF */
    public C4494rdtF f10388ETF;

    /* renamed from: VA */
    public C1691BOPu f10389VA;

    /* renamed from: o.R9$mjFkc */
    public static /* synthetic */ class mjFkc {

        /* renamed from: mjFkc */
        public static final /* synthetic */ int[] f10390mjFkc;

        static {
            int[] iArr = new int[AbstractC2246Ja.AZxh.m8999values().length];
            f10390mjFkc = iArr;
            try {
                iArr[AbstractC2246Ja.AZxh.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10390mjFkc[AbstractC2246Ja.AZxh.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10390mjFkc[AbstractC2246Ja.AZxh.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public C2742R9(C3776gjvQ c3776gjvQ) {
        super(c3776gjvQ);
        C4494rdtF c4494rdtF = new C4494rdtF(this);
        this.f10388ETF = c4494rdtF;
        this.f10389VA = null;
        this.f9001lgHUyS.f16351KLFTb = C4494rdtF.mjFkc.TOP;
        this.f9003qdMbNW.f16351KLFTb = C4494rdtF.mjFkc.BOTTOM;
        c4494rdtF.f16351KLFTb = C4494rdtF.mjFkc.BASELINE;
        this.f8998JHa = 1;
    }

    @Override // p131o.AbstractC2246Ja
    /* renamed from: JHa */
    public void mo7516JHa() {
        this.f9004wA = null;
        this.f9001lgHUyS.m13387wA();
        this.f9003qdMbNW.m13387wA();
        this.f10388ETF.m13387wA();
        this.f8999KLFTb.m13387wA();
        this.f9005xJ = false;
    }

    @Override // p131o.AbstractC2246Ja
    /* renamed from: KLFTb */
    public void mo7517KLFTb() {
        C4494rdtF c4494rdtF = this.f9001lgHUyS;
        if (c4494rdtF.f16348Dt) {
            this.f8996AZxh.m12090tISON(c4494rdtF.f16358xJ);
        }
    }

    @Override // p131o.AbstractC2246Ja
    /* renamed from: MiMN */
    public boolean mo7518MiMN() {
        return this.f9000ZfxDd != C3776gjvQ.AZxh.MATCH_CONSTRAINT || this.f8996AZxh.f13781MiMN == 0;
    }

    @Override // p131o.AbstractC2246Ja
    /* renamed from: ZfxDd */
    public void mo7519ZfxDd() {
        C3776gjvQ c3776gjvQM12044Ne;
        C3776gjvQ c3776gjvQM12044Ne2;
        C3776gjvQ c3776gjvQ = this.f8996AZxh;
        if (c3776gjvQ.f13816mjFkc) {
            this.f8999KLFTb.mo7695ZfxDd(c3776gjvQ.m12051Ucbh());
        }
        if (!this.f8999KLFTb.f16348Dt) {
            this.f9000ZfxDd = this.f8996AZxh.m12088rWxwaT();
            if (this.f8996AZxh.m12057WrLQs()) {
                this.f10389VA = new C4148mPWV(this);
            }
            C3776gjvQ.AZxh aZxh = this.f9000ZfxDd;
            if (aZxh != C3776gjvQ.AZxh.MATCH_CONSTRAINT) {
                if (aZxh == C3776gjvQ.AZxh.MATCH_PARENT && (c3776gjvQM12044Ne2 = this.f8996AZxh.m12044Ne()) != null && c3776gjvQM12044Ne2.m12088rWxwaT() == C3776gjvQ.AZxh.FIXED) {
                    int iM12051Ucbh = (c3776gjvQM12044Ne2.m12051Ucbh() - this.f8996AZxh.f13813lB.m13321wA()) - this.f8996AZxh.f13815mByQ.m13321wA();
                    m8988AZxh(this.f9001lgHUyS, c3776gjvQM12044Ne2.f13774JHa.f9001lgHUyS, this.f8996AZxh.f13813lB.m13321wA());
                    m8988AZxh(this.f9003qdMbNW, c3776gjvQM12044Ne2.f13774JHa.f9003qdMbNW, -this.f8996AZxh.f13815mByQ.m13321wA());
                    this.f8999KLFTb.mo7695ZfxDd(iM12051Ucbh);
                    return;
                }
                if (this.f9000ZfxDd == C3776gjvQ.AZxh.FIXED) {
                    this.f8999KLFTb.mo7695ZfxDd(this.f8996AZxh.m12051Ucbh());
                }
            }
        } else if (this.f9000ZfxDd == C3776gjvQ.AZxh.MATCH_PARENT && (c3776gjvQM12044Ne = this.f8996AZxh.m12044Ne()) != null && c3776gjvQM12044Ne.m12088rWxwaT() == C3776gjvQ.AZxh.FIXED) {
            m8988AZxh(this.f9001lgHUyS, c3776gjvQM12044Ne.f13774JHa.f9001lgHUyS, this.f8996AZxh.f13813lB.m13321wA());
            m8988AZxh(this.f9003qdMbNW, c3776gjvQM12044Ne.f13774JHa.f9003qdMbNW, -this.f8996AZxh.f13815mByQ.m13321wA());
            return;
        }
        C1691BOPu c1691BOPu = this.f8999KLFTb;
        boolean z = c1691BOPu.f16348Dt;
        if (z) {
            C3776gjvQ c3776gjvQ2 = this.f8996AZxh;
            if (c3776gjvQ2.f13816mjFkc) {
                C4446qtZIjO[] c4446qtZIjOArr = c3776gjvQ2.f13779KLMXS;
                C4446qtZIjO c4446qtZIjO = c4446qtZIjOArr[2];
                C4446qtZIjO c4446qtZIjO2 = c4446qtZIjO.f16248ZfxDd;
                if (c4446qtZIjO2 != null && c4446qtZIjOArr[3].f16248ZfxDd != null) {
                    if (c3776gjvQ2.m12034JYgkl()) {
                        this.f9001lgHUyS.f16350JHa = this.f8996AZxh.f13779KLMXS[2].m13321wA();
                        this.f9003qdMbNW.f16350JHa = -this.f8996AZxh.f13779KLMXS[3].m13321wA();
                    } else {
                        C4494rdtF c4494rdtFM8992lgHUyS = m8992lgHUyS(this.f8996AZxh.f13779KLMXS[2]);
                        if (c4494rdtFM8992lgHUyS != null) {
                            m8988AZxh(this.f9001lgHUyS, c4494rdtFM8992lgHUyS, this.f8996AZxh.f13779KLMXS[2].m13321wA());
                        }
                        C4494rdtF c4494rdtFM8992lgHUyS2 = m8992lgHUyS(this.f8996AZxh.f13779KLMXS[3]);
                        if (c4494rdtFM8992lgHUyS2 != null) {
                            m8988AZxh(this.f9003qdMbNW, c4494rdtFM8992lgHUyS2, -this.f8996AZxh.f13779KLMXS[3].m13321wA());
                        }
                        this.f9001lgHUyS.f16347AZxh = true;
                        this.f9003qdMbNW.f16347AZxh = true;
                    }
                    if (this.f8996AZxh.m12057WrLQs()) {
                        m8988AZxh(this.f10388ETF, this.f9001lgHUyS, this.f8996AZxh.m12062YoKzxo());
                        return;
                    }
                    return;
                }
                if (c4446qtZIjO2 != null) {
                    C4494rdtF c4494rdtFM8992lgHUyS3 = m8992lgHUyS(c4446qtZIjO);
                    if (c4494rdtFM8992lgHUyS3 != null) {
                        m8988AZxh(this.f9001lgHUyS, c4494rdtFM8992lgHUyS3, this.f8996AZxh.f13779KLMXS[2].m13321wA());
                        m8988AZxh(this.f9003qdMbNW, this.f9001lgHUyS, this.f8999KLFTb.f16358xJ);
                        if (this.f8996AZxh.m12057WrLQs()) {
                            m8988AZxh(this.f10388ETF, this.f9001lgHUyS, this.f8996AZxh.m12062YoKzxo());
                            return;
                        }
                        return;
                    }
                    return;
                }
                C4446qtZIjO c4446qtZIjO3 = c4446qtZIjOArr[3];
                if (c4446qtZIjO3.f16248ZfxDd != null) {
                    C4494rdtF c4494rdtFM8992lgHUyS4 = m8992lgHUyS(c4446qtZIjO3);
                    if (c4494rdtFM8992lgHUyS4 != null) {
                        m8988AZxh(this.f9003qdMbNW, c4494rdtFM8992lgHUyS4, -this.f8996AZxh.f13779KLMXS[3].m13321wA());
                        m8988AZxh(this.f9001lgHUyS, this.f9003qdMbNW, -this.f8999KLFTb.f16358xJ);
                    }
                    if (this.f8996AZxh.m12057WrLQs()) {
                        m8988AZxh(this.f10388ETF, this.f9001lgHUyS, this.f8996AZxh.m12062YoKzxo());
                        return;
                    }
                    return;
                }
                C4446qtZIjO c4446qtZIjO4 = c4446qtZIjOArr[4];
                if (c4446qtZIjO4.f16248ZfxDd != null) {
                    C4494rdtF c4494rdtFM8992lgHUyS5 = m8992lgHUyS(c4446qtZIjO4);
                    if (c4494rdtFM8992lgHUyS5 != null) {
                        m8988AZxh(this.f10388ETF, c4494rdtFM8992lgHUyS5, 0);
                        m8988AZxh(this.f9001lgHUyS, this.f10388ETF, -this.f8996AZxh.m12062YoKzxo());
                        m8988AZxh(this.f9003qdMbNW, this.f9001lgHUyS, this.f8999KLFTb.f16358xJ);
                        return;
                    }
                    return;
                }
                if ((c3776gjvQ2 instanceof InterfaceC4718v) || c3776gjvQ2.m12044Ne() == null || this.f8996AZxh.mo12040MiMN(C4446qtZIjO.AZxh.CENTER).f16248ZfxDd != null) {
                    return;
                }
                m8988AZxh(this.f9001lgHUyS, this.f8996AZxh.m12044Ne().f13774JHa.f9001lgHUyS, this.f8996AZxh.m12065aqHPIZ());
                m8988AZxh(this.f9003qdMbNW, this.f9001lgHUyS, this.f8999KLFTb.f16358xJ);
                if (this.f8996AZxh.m12057WrLQs()) {
                    m8988AZxh(this.f10388ETF, this.f9001lgHUyS, this.f8996AZxh.m12062YoKzxo());
                    return;
                }
                return;
            }
        }
        if (z || this.f9000ZfxDd != C3776gjvQ.AZxh.MATCH_CONSTRAINT) {
            c1691BOPu.m13386AZxh(this);
        } else {
            C3776gjvQ c3776gjvQ3 = this.f8996AZxh;
            int i = c3776gjvQ3.f13781MiMN;
            if (i == 2) {
                C3776gjvQ c3776gjvQM12044Ne3 = c3776gjvQ3.m12044Ne();
                if (c3776gjvQM12044Ne3 != null) {
                    C1691BOPu c1691BOPu2 = c3776gjvQM12044Ne3.f13774JHa.f8999KLFTb;
                    this.f8999KLFTb.f16352VA.add(c1691BOPu2);
                    c1691BOPu2.f16349ETF.add(this.f8999KLFTb);
                    C1691BOPu c1691BOPu3 = this.f8999KLFTb;
                    c1691BOPu3.f16347AZxh = true;
                    c1691BOPu3.f16349ETF.add(this.f9001lgHUyS);
                    this.f8999KLFTb.f16349ETF.add(this.f9003qdMbNW);
                }
            } else if (i == 3 && !c3776gjvQ3.m12034JYgkl()) {
                C3776gjvQ c3776gjvQ4 = this.f8996AZxh;
                if (c3776gjvQ4.f13793VA != 3) {
                    C1691BOPu c1691BOPu4 = c3776gjvQ4.f13778KLFTb.f8999KLFTb;
                    this.f8999KLFTb.f16352VA.add(c1691BOPu4);
                    c1691BOPu4.f16349ETF.add(this.f8999KLFTb);
                    C1691BOPu c1691BOPu5 = this.f8999KLFTb;
                    c1691BOPu5.f16347AZxh = true;
                    c1691BOPu5.f16349ETF.add(this.f9001lgHUyS);
                    this.f8999KLFTb.f16349ETF.add(this.f9003qdMbNW);
                }
            }
        }
        C3776gjvQ c3776gjvQ5 = this.f8996AZxh;
        C4446qtZIjO[] c4446qtZIjOArr2 = c3776gjvQ5.f13779KLMXS;
        C4446qtZIjO c4446qtZIjO5 = c4446qtZIjOArr2[2];
        C4446qtZIjO c4446qtZIjO6 = c4446qtZIjO5.f16248ZfxDd;
        if (c4446qtZIjO6 != null && c4446qtZIjOArr2[3].f16248ZfxDd != null) {
            if (c3776gjvQ5.m12034JYgkl()) {
                this.f9001lgHUyS.f16350JHa = this.f8996AZxh.f13779KLMXS[2].m13321wA();
                this.f9003qdMbNW.f16350JHa = -this.f8996AZxh.f13779KLMXS[3].m13321wA();
            } else {
                C4494rdtF c4494rdtFM8992lgHUyS6 = m8992lgHUyS(this.f8996AZxh.f13779KLMXS[2]);
                C4494rdtF c4494rdtFM8992lgHUyS7 = m8992lgHUyS(this.f8996AZxh.f13779KLMXS[3]);
                c4494rdtFM8992lgHUyS6.m13386AZxh(this);
                c4494rdtFM8992lgHUyS7.m13386AZxh(this);
                this.f8997Dt = AbstractC2246Ja.AZxh.CENTER;
            }
            if (this.f8996AZxh.m12057WrLQs()) {
                m8996wA(this.f10388ETF, this.f9001lgHUyS, 1, this.f10389VA);
            }
        } else if (c4446qtZIjO6 != null) {
            C4494rdtF c4494rdtFM8992lgHUyS8 = m8992lgHUyS(c4446qtZIjO5);
            if (c4494rdtFM8992lgHUyS8 != null) {
                m8988AZxh(this.f9001lgHUyS, c4494rdtFM8992lgHUyS8, this.f8996AZxh.f13779KLMXS[2].m13321wA());
                m8996wA(this.f9003qdMbNW, this.f9001lgHUyS, 1, this.f8999KLFTb);
                if (this.f8996AZxh.m12057WrLQs()) {
                    m8996wA(this.f10388ETF, this.f9001lgHUyS, 1, this.f10389VA);
                }
                C3776gjvQ.AZxh aZxh2 = this.f9000ZfxDd;
                C3776gjvQ.AZxh aZxh3 = C3776gjvQ.AZxh.MATCH_CONSTRAINT;
                if (aZxh2 == aZxh3 && this.f8996AZxh.m12068diqgf() > 0.0f) {
                    C1597A c1597a = this.f8996AZxh.f13778KLFTb;
                    if (c1597a.f9000ZfxDd == aZxh3) {
                        c1597a.f8999KLFTb.f16349ETF.add(this.f8999KLFTb);
                        this.f8999KLFTb.f16352VA.add(this.f8996AZxh.f13778KLFTb.f8999KLFTb);
                        this.f8999KLFTb.f16355mjFkc = this;
                    }
                }
            }
        } else {
            C4446qtZIjO c4446qtZIjO7 = c4446qtZIjOArr2[3];
            if (c4446qtZIjO7.f16248ZfxDd != null) {
                C4494rdtF c4494rdtFM8992lgHUyS9 = m8992lgHUyS(c4446qtZIjO7);
                if (c4494rdtFM8992lgHUyS9 != null) {
                    m8988AZxh(this.f9003qdMbNW, c4494rdtFM8992lgHUyS9, -this.f8996AZxh.f13779KLMXS[3].m13321wA());
                    m8996wA(this.f9001lgHUyS, this.f9003qdMbNW, -1, this.f8999KLFTb);
                    if (this.f8996AZxh.m12057WrLQs()) {
                        m8996wA(this.f10388ETF, this.f9001lgHUyS, 1, this.f10389VA);
                    }
                }
            } else {
                C4446qtZIjO c4446qtZIjO8 = c4446qtZIjOArr2[4];
                if (c4446qtZIjO8.f16248ZfxDd != null) {
                    C4494rdtF c4494rdtFM8992lgHUyS10 = m8992lgHUyS(c4446qtZIjO8);
                    if (c4494rdtFM8992lgHUyS10 != null) {
                        m8988AZxh(this.f10388ETF, c4494rdtFM8992lgHUyS10, 0);
                        m8996wA(this.f9001lgHUyS, this.f10388ETF, -1, this.f10389VA);
                        m8996wA(this.f9003qdMbNW, this.f9001lgHUyS, 1, this.f8999KLFTb);
                    }
                } else if (!(c3776gjvQ5 instanceof InterfaceC4718v) && c3776gjvQ5.m12044Ne() != null) {
                    m8988AZxh(this.f9001lgHUyS, this.f8996AZxh.m12044Ne().f13774JHa.f9001lgHUyS, this.f8996AZxh.m12065aqHPIZ());
                    m8996wA(this.f9003qdMbNW, this.f9001lgHUyS, 1, this.f8999KLFTb);
                    if (this.f8996AZxh.m12057WrLQs()) {
                        m8996wA(this.f10388ETF, this.f9001lgHUyS, 1, this.f10389VA);
                    }
                    C3776gjvQ.AZxh aZxh4 = this.f9000ZfxDd;
                    C3776gjvQ.AZxh aZxh5 = C3776gjvQ.AZxh.MATCH_CONSTRAINT;
                    if (aZxh4 == aZxh5 && this.f8996AZxh.m12068diqgf() > 0.0f) {
                        C1597A c1597a2 = this.f8996AZxh.f13778KLFTb;
                        if (c1597a2.f9000ZfxDd == aZxh5) {
                            c1597a2.f8999KLFTb.f16349ETF.add(this.f8999KLFTb);
                            this.f8999KLFTb.f16352VA.add(this.f8996AZxh.f13778KLFTb.f8999KLFTb);
                            this.f8999KLFTb.f16355mjFkc = this;
                        }
                    }
                }
            }
        }
        if (this.f8999KLFTb.f16352VA.size() == 0) {
            this.f8999KLFTb.f16357wA = true;
        }
    }

    /* renamed from: fehf */
    public void m10056fehf() {
        this.f9005xJ = false;
        this.f9001lgHUyS.m13387wA();
        this.f9001lgHUyS.f16348Dt = false;
        this.f9003qdMbNW.m13387wA();
        this.f9003qdMbNW.f16348Dt = false;
        this.f10388ETF.m13387wA();
        this.f10388ETF.f16348Dt = false;
        this.f8999KLFTb.f16348Dt = false;
    }

    @Override // p131o.AbstractC2246Ja, p131o.InterfaceC2695QQi
    /* renamed from: mjFkc */
    public void mo7521mjFkc(InterfaceC2695QQi interfaceC2695QQi) {
        float f;
        float fM12068diqgf;
        float fM12068diqgf2;
        int i;
        int i2 = mjFkc.f10390mjFkc[this.f8997Dt.ordinal()];
        if (i2 == 1) {
            m8993qGY(interfaceC2695QQi);
        } else if (i2 == 2) {
            m8995rkYL(interfaceC2695QQi);
        } else if (i2 == 3) {
            C3776gjvQ c3776gjvQ = this.f8996AZxh;
            m8991YoKzxo(interfaceC2695QQi, c3776gjvQ.f13813lB, c3776gjvQ.f13815mByQ, 1);
            return;
        }
        C1691BOPu c1691BOPu = this.f8999KLFTb;
        if (c1691BOPu.f16357wA && !c1691BOPu.f16348Dt && this.f9000ZfxDd == C3776gjvQ.AZxh.MATCH_CONSTRAINT) {
            C3776gjvQ c3776gjvQ2 = this.f8996AZxh;
            int i3 = c3776gjvQ2.f13781MiMN;
            if (i3 == 2) {
                C3776gjvQ c3776gjvQM12044Ne = c3776gjvQ2.m12044Ne();
                if (c3776gjvQM12044Ne != null) {
                    if (c3776gjvQM12044Ne.f13774JHa.f8999KLFTb.f16348Dt) {
                        this.f8999KLFTb.mo7695ZfxDd((int) ((r7.f16358xJ * this.f8996AZxh.f13806diqgf) + 0.5f));
                    }
                }
            } else if (i3 == 3 && c3776gjvQ2.f13778KLFTb.f8999KLFTb.f16348Dt) {
                int iM12070eyqo = c3776gjvQ2.m12070eyqo();
                if (iM12070eyqo == -1) {
                    C3776gjvQ c3776gjvQ3 = this.f8996AZxh;
                    f = c3776gjvQ3.f13778KLFTb.f8999KLFTb.f16358xJ;
                    fM12068diqgf = c3776gjvQ3.m12068diqgf();
                } else if (iM12070eyqo == 0) {
                    fM12068diqgf2 = r7.f13778KLFTb.f8999KLFTb.f16358xJ * this.f8996AZxh.m12068diqgf();
                    i = (int) (fM12068diqgf2 + 0.5f);
                    this.f8999KLFTb.mo7695ZfxDd(i);
                } else if (iM12070eyqo != 1) {
                    i = 0;
                    this.f8999KLFTb.mo7695ZfxDd(i);
                } else {
                    C3776gjvQ c3776gjvQ4 = this.f8996AZxh;
                    f = c3776gjvQ4.f13778KLFTb.f8999KLFTb.f16358xJ;
                    fM12068diqgf = c3776gjvQ4.m12068diqgf();
                }
                fM12068diqgf2 = f / fM12068diqgf;
                i = (int) (fM12068diqgf2 + 0.5f);
                this.f8999KLFTb.mo7695ZfxDd(i);
            }
        }
        C4494rdtF c4494rdtF = this.f9001lgHUyS;
        if (c4494rdtF.f16357wA) {
            C4494rdtF c4494rdtF2 = this.f9003qdMbNW;
            if (c4494rdtF2.f16357wA) {
                if (c4494rdtF.f16348Dt && c4494rdtF2.f16348Dt && this.f8999KLFTb.f16348Dt) {
                    return;
                }
                if (!this.f8999KLFTb.f16348Dt && this.f9000ZfxDd == C3776gjvQ.AZxh.MATCH_CONSTRAINT) {
                    C3776gjvQ c3776gjvQ5 = this.f8996AZxh;
                    if (c3776gjvQ5.f13793VA == 0 && !c3776gjvQ5.m12034JYgkl()) {
                        C4494rdtF c4494rdtF3 = (C4494rdtF) this.f9001lgHUyS.f16352VA.get(0);
                        C4494rdtF c4494rdtF4 = (C4494rdtF) this.f9003qdMbNW.f16352VA.get(0);
                        int i4 = c4494rdtF3.f16358xJ;
                        C4494rdtF c4494rdtF5 = this.f9001lgHUyS;
                        int i5 = i4 + c4494rdtF5.f16350JHa;
                        int i6 = c4494rdtF4.f16358xJ + this.f9003qdMbNW.f16350JHa;
                        c4494rdtF5.mo7695ZfxDd(i5);
                        this.f9003qdMbNW.mo7695ZfxDd(i6);
                        this.f8999KLFTb.mo7695ZfxDd(i6 - i5);
                        return;
                    }
                }
                if (!this.f8999KLFTb.f16348Dt && this.f9000ZfxDd == C3776gjvQ.AZxh.MATCH_CONSTRAINT && this.f9002mjFkc == 1 && this.f9001lgHUyS.f16352VA.size() > 0 && this.f9003qdMbNW.f16352VA.size() > 0) {
                    C4494rdtF c4494rdtF6 = (C4494rdtF) this.f9001lgHUyS.f16352VA.get(0);
                    int i7 = (((C4494rdtF) this.f9003qdMbNW.f16352VA.get(0)).f16358xJ + this.f9003qdMbNW.f16350JHa) - (c4494rdtF6.f16358xJ + this.f9001lgHUyS.f16350JHa);
                    C1691BOPu c1691BOPu2 = this.f8999KLFTb;
                    int i8 = c1691BOPu2.f7478MiMN;
                    if (i7 < i8) {
                        c1691BOPu2.mo7695ZfxDd(i7);
                    } else {
                        c1691BOPu2.mo7695ZfxDd(i8);
                    }
                }
                if (this.f8999KLFTb.f16348Dt && this.f9001lgHUyS.f16352VA.size() > 0 && this.f9003qdMbNW.f16352VA.size() > 0) {
                    C4494rdtF c4494rdtF7 = (C4494rdtF) this.f9001lgHUyS.f16352VA.get(0);
                    C4494rdtF c4494rdtF8 = (C4494rdtF) this.f9003qdMbNW.f16352VA.get(0);
                    int i9 = c4494rdtF7.f16358xJ + this.f9001lgHUyS.f16350JHa;
                    int i10 = c4494rdtF8.f16358xJ + this.f9003qdMbNW.f16350JHa;
                    float fM12103zvd = this.f8996AZxh.m12103zvd();
                    if (c4494rdtF7 == c4494rdtF8) {
                        i9 = c4494rdtF7.f16358xJ;
                        i10 = c4494rdtF8.f16358xJ;
                        fM12103zvd = 0.5f;
                    }
                    this.f9001lgHUyS.mo7695ZfxDd((int) (i9 + 0.5f + (((i10 - i9) - this.f8999KLFTb.f16358xJ) * fM12103zvd)));
                    this.f9003qdMbNW.mo7695ZfxDd(this.f9001lgHUyS.f16358xJ + this.f8999KLFTb.f16358xJ);
                }
            }
        }
    }

    public String toString() {
        return "VerticalRun " + this.f8996AZxh.m12031IEE();
    }
}
