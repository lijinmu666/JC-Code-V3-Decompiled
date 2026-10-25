package p131o;

import p131o.AbstractC2246Ja;
import p131o.C3776gjvQ;
import p131o.C4446qtZIjO;
import p131o.C4494rdtF;

/* renamed from: o.A */
/* loaded from: classes.dex */
public class C1597A extends AbstractC2246Ja {

    /* renamed from: ETF */
    public static int[] f7299ETF = new int[2];

    /* renamed from: o.A$mjFkc */
    public static /* synthetic */ class mjFkc {

        /* renamed from: mjFkc */
        public static final /* synthetic */ int[] f7300mjFkc;

        static {
            int[] iArr = new int[AbstractC2246Ja.AZxh.m8999values().length];
            f7300mjFkc = iArr;
            try {
                iArr[AbstractC2246Ja.AZxh.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7300mjFkc[AbstractC2246Ja.AZxh.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7300mjFkc[AbstractC2246Ja.AZxh.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public C1597A(C3776gjvQ c3776gjvQ) {
        super(c3776gjvQ);
        this.f9001lgHUyS.f16351KLFTb = C4494rdtF.mjFkc.LEFT;
        this.f9003qdMbNW.f16351KLFTb = C4494rdtF.mjFkc.RIGHT;
        this.f8998JHa = 0;
    }

    /* renamed from: IEE */
    public void m7515IEE() {
        this.f9005xJ = false;
        this.f9001lgHUyS.m13387wA();
        this.f9001lgHUyS.f16348Dt = false;
        this.f9003qdMbNW.m13387wA();
        this.f9003qdMbNW.f16348Dt = false;
        this.f8999KLFTb.f16348Dt = false;
    }

    @Override // p131o.AbstractC2246Ja
    /* renamed from: JHa */
    public void mo7516JHa() {
        this.f9004wA = null;
        this.f9001lgHUyS.m13387wA();
        this.f9003qdMbNW.m13387wA();
        this.f8999KLFTb.m13387wA();
        this.f9005xJ = false;
    }

    @Override // p131o.AbstractC2246Ja
    /* renamed from: KLFTb */
    public void mo7517KLFTb() {
        C4494rdtF c4494rdtF = this.f9001lgHUyS;
        if (c4494rdtF.f16348Dt) {
            this.f8996AZxh.m12093uH(c4494rdtF.f16358xJ);
        }
    }

    @Override // p131o.AbstractC2246Ja
    /* renamed from: MiMN */
    public boolean mo7518MiMN() {
        return this.f9000ZfxDd != C3776gjvQ.AZxh.MATCH_CONSTRAINT || this.f8996AZxh.f13793VA == 0;
    }

    @Override // p131o.AbstractC2246Ja
    /* renamed from: ZfxDd */
    public void mo7519ZfxDd() {
        C3776gjvQ c3776gjvQM12044Ne;
        C3776gjvQ c3776gjvQM12044Ne2;
        C3776gjvQ c3776gjvQ = this.f8996AZxh;
        if (c3776gjvQ.f13816mjFkc) {
            this.f8999KLFTb.mo7695ZfxDd(c3776gjvQ.m12096vadzgd());
        }
        if (this.f8999KLFTb.f16348Dt) {
            C3776gjvQ.AZxh aZxh = this.f9000ZfxDd;
            C3776gjvQ.AZxh aZxh2 = C3776gjvQ.AZxh.MATCH_PARENT;
            if (aZxh == aZxh2 && (((c3776gjvQM12044Ne = this.f8996AZxh.m12044Ne()) != null && c3776gjvQM12044Ne.m12030HGpJ() == C3776gjvQ.AZxh.FIXED) || c3776gjvQM12044Ne.m12030HGpJ() == aZxh2)) {
                m8988AZxh(this.f9001lgHUyS, c3776gjvQM12044Ne.f13778KLFTb.f9001lgHUyS, this.f8996AZxh.f13764BAnRFn.m13321wA());
                m8988AZxh(this.f9003qdMbNW, c3776gjvQM12044Ne.f13778KLFTb.f9003qdMbNW, -this.f8996AZxh.f13829wJVbdd.m13321wA());
                return;
            }
        } else {
            C3776gjvQ.AZxh aZxhM12030HGpJ = this.f8996AZxh.m12030HGpJ();
            this.f9000ZfxDd = aZxhM12030HGpJ;
            if (aZxhM12030HGpJ != C3776gjvQ.AZxh.MATCH_CONSTRAINT) {
                C3776gjvQ.AZxh aZxh3 = C3776gjvQ.AZxh.MATCH_PARENT;
                if (aZxhM12030HGpJ == aZxh3 && (((c3776gjvQM12044Ne2 = this.f8996AZxh.m12044Ne()) != null && c3776gjvQM12044Ne2.m12030HGpJ() == C3776gjvQ.AZxh.FIXED) || c3776gjvQM12044Ne2.m12030HGpJ() == aZxh3)) {
                    int iM12096vadzgd = (c3776gjvQM12044Ne2.m12096vadzgd() - this.f8996AZxh.f13764BAnRFn.m13321wA()) - this.f8996AZxh.f13829wJVbdd.m13321wA();
                    m8988AZxh(this.f9001lgHUyS, c3776gjvQM12044Ne2.f13778KLFTb.f9001lgHUyS, this.f8996AZxh.f13764BAnRFn.m13321wA());
                    m8988AZxh(this.f9003qdMbNW, c3776gjvQM12044Ne2.f13778KLFTb.f9003qdMbNW, -this.f8996AZxh.f13829wJVbdd.m13321wA());
                    this.f8999KLFTb.mo7695ZfxDd(iM12096vadzgd);
                    return;
                }
                if (this.f9000ZfxDd == C3776gjvQ.AZxh.FIXED) {
                    this.f8999KLFTb.mo7695ZfxDd(this.f8996AZxh.m12096vadzgd());
                }
            }
        }
        C1691BOPu c1691BOPu = this.f8999KLFTb;
        if (c1691BOPu.f16348Dt) {
            C3776gjvQ c3776gjvQ2 = this.f8996AZxh;
            if (c3776gjvQ2.f13816mjFkc) {
                C4446qtZIjO[] c4446qtZIjOArr = c3776gjvQ2.f13779KLMXS;
                C4446qtZIjO c4446qtZIjO = c4446qtZIjOArr[0];
                C4446qtZIjO c4446qtZIjO2 = c4446qtZIjO.f16248ZfxDd;
                if (c4446qtZIjO2 != null && c4446qtZIjOArr[1].f16248ZfxDd != null) {
                    if (c3776gjvQ2.m12094uHVRx()) {
                        this.f9001lgHUyS.f16350JHa = this.f8996AZxh.f13779KLMXS[0].m13321wA();
                        this.f9003qdMbNW.f16350JHa = -this.f8996AZxh.f13779KLMXS[1].m13321wA();
                        return;
                    }
                    C4494rdtF c4494rdtFM8992lgHUyS = m8992lgHUyS(this.f8996AZxh.f13779KLMXS[0]);
                    if (c4494rdtFM8992lgHUyS != null) {
                        m8988AZxh(this.f9001lgHUyS, c4494rdtFM8992lgHUyS, this.f8996AZxh.f13779KLMXS[0].m13321wA());
                    }
                    C4494rdtF c4494rdtFM8992lgHUyS2 = m8992lgHUyS(this.f8996AZxh.f13779KLMXS[1]);
                    if (c4494rdtFM8992lgHUyS2 != null) {
                        m8988AZxh(this.f9003qdMbNW, c4494rdtFM8992lgHUyS2, -this.f8996AZxh.f13779KLMXS[1].m13321wA());
                    }
                    this.f9001lgHUyS.f16347AZxh = true;
                    this.f9003qdMbNW.f16347AZxh = true;
                    return;
                }
                if (c4446qtZIjO2 != null) {
                    C4494rdtF c4494rdtFM8992lgHUyS3 = m8992lgHUyS(c4446qtZIjO);
                    if (c4494rdtFM8992lgHUyS3 != null) {
                        m8988AZxh(this.f9001lgHUyS, c4494rdtFM8992lgHUyS3, this.f8996AZxh.f13779KLMXS[0].m13321wA());
                        m8988AZxh(this.f9003qdMbNW, this.f9001lgHUyS, this.f8999KLFTb.f16358xJ);
                        return;
                    }
                    return;
                }
                C4446qtZIjO c4446qtZIjO3 = c4446qtZIjOArr[1];
                if (c4446qtZIjO3.f16248ZfxDd != null) {
                    C4494rdtF c4494rdtFM8992lgHUyS4 = m8992lgHUyS(c4446qtZIjO3);
                    if (c4494rdtFM8992lgHUyS4 != null) {
                        m8988AZxh(this.f9003qdMbNW, c4494rdtFM8992lgHUyS4, -this.f8996AZxh.f13779KLMXS[1].m13321wA());
                        m8988AZxh(this.f9001lgHUyS, this.f9003qdMbNW, -this.f8999KLFTb.f16358xJ);
                        return;
                    }
                    return;
                }
                if ((c3776gjvQ2 instanceof InterfaceC4718v) || c3776gjvQ2.m12044Ne() == null || this.f8996AZxh.mo12040MiMN(C4446qtZIjO.AZxh.CENTER).f16248ZfxDd != null) {
                    return;
                }
                m8988AZxh(this.f9001lgHUyS, this.f8996AZxh.m12044Ne().f13778KLFTb.f9001lgHUyS, this.f8996AZxh.m12085oCFDzJ());
                m8988AZxh(this.f9003qdMbNW, this.f9001lgHUyS, this.f8999KLFTb.f16358xJ);
                return;
            }
        }
        if (this.f9000ZfxDd == C3776gjvQ.AZxh.MATCH_CONSTRAINT) {
            C3776gjvQ c3776gjvQ3 = this.f8996AZxh;
            int i = c3776gjvQ3.f13793VA;
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
            } else if (i == 3) {
                if (c3776gjvQ3.f13781MiMN == 3) {
                    this.f9001lgHUyS.f16355mjFkc = this;
                    this.f9003qdMbNW.f16355mjFkc = this;
                    C2742R9 c2742r9 = c3776gjvQ3.f13774JHa;
                    c2742r9.f9001lgHUyS.f16355mjFkc = this;
                    c2742r9.f9003qdMbNW.f16355mjFkc = this;
                    c1691BOPu.f16355mjFkc = this;
                    if (c3776gjvQ3.m12034JYgkl()) {
                        this.f8999KLFTb.f16352VA.add(this.f8996AZxh.f13774JHa.f8999KLFTb);
                        this.f8996AZxh.f13774JHa.f8999KLFTb.f16349ETF.add(this.f8999KLFTb);
                        C2742R9 c2742r92 = this.f8996AZxh.f13774JHa;
                        c2742r92.f8999KLFTb.f16355mjFkc = this;
                        this.f8999KLFTb.f16352VA.add(c2742r92.f9001lgHUyS);
                        this.f8999KLFTb.f16352VA.add(this.f8996AZxh.f13774JHa.f9003qdMbNW);
                        this.f8996AZxh.f13774JHa.f9001lgHUyS.f16349ETF.add(this.f8999KLFTb);
                        this.f8996AZxh.f13774JHa.f9003qdMbNW.f16349ETF.add(this.f8999KLFTb);
                    } else if (this.f8996AZxh.m12094uHVRx()) {
                        this.f8996AZxh.f13774JHa.f8999KLFTb.f16352VA.add(this.f8999KLFTb);
                        this.f8999KLFTb.f16349ETF.add(this.f8996AZxh.f13774JHa.f8999KLFTb);
                    } else {
                        this.f8996AZxh.f13774JHa.f8999KLFTb.f16352VA.add(this.f8999KLFTb);
                    }
                } else {
                    C1691BOPu c1691BOPu4 = c3776gjvQ3.f13774JHa.f8999KLFTb;
                    c1691BOPu.f16352VA.add(c1691BOPu4);
                    c1691BOPu4.f16349ETF.add(this.f8999KLFTb);
                    this.f8996AZxh.f13774JHa.f9001lgHUyS.f16349ETF.add(this.f8999KLFTb);
                    this.f8996AZxh.f13774JHa.f9003qdMbNW.f16349ETF.add(this.f8999KLFTb);
                    C1691BOPu c1691BOPu5 = this.f8999KLFTb;
                    c1691BOPu5.f16347AZxh = true;
                    c1691BOPu5.f16349ETF.add(this.f9001lgHUyS);
                    this.f8999KLFTb.f16349ETF.add(this.f9003qdMbNW);
                    this.f9001lgHUyS.f16352VA.add(this.f8999KLFTb);
                    this.f9003qdMbNW.f16352VA.add(this.f8999KLFTb);
                }
            }
        }
        C3776gjvQ c3776gjvQ4 = this.f8996AZxh;
        C4446qtZIjO[] c4446qtZIjOArr2 = c3776gjvQ4.f13779KLMXS;
        C4446qtZIjO c4446qtZIjO4 = c4446qtZIjOArr2[0];
        C4446qtZIjO c4446qtZIjO5 = c4446qtZIjO4.f16248ZfxDd;
        if (c4446qtZIjO5 != null && c4446qtZIjOArr2[1].f16248ZfxDd != null) {
            if (c3776gjvQ4.m12094uHVRx()) {
                this.f9001lgHUyS.f16350JHa = this.f8996AZxh.f13779KLMXS[0].m13321wA();
                this.f9003qdMbNW.f16350JHa = -this.f8996AZxh.f13779KLMXS[1].m13321wA();
                return;
            }
            C4494rdtF c4494rdtFM8992lgHUyS5 = m8992lgHUyS(this.f8996AZxh.f13779KLMXS[0]);
            C4494rdtF c4494rdtFM8992lgHUyS6 = m8992lgHUyS(this.f8996AZxh.f13779KLMXS[1]);
            c4494rdtFM8992lgHUyS5.m13386AZxh(this);
            c4494rdtFM8992lgHUyS6.m13386AZxh(this);
            this.f8997Dt = AbstractC2246Ja.AZxh.CENTER;
            return;
        }
        if (c4446qtZIjO5 != null) {
            C4494rdtF c4494rdtFM8992lgHUyS7 = m8992lgHUyS(c4446qtZIjO4);
            if (c4494rdtFM8992lgHUyS7 != null) {
                m8988AZxh(this.f9001lgHUyS, c4494rdtFM8992lgHUyS7, this.f8996AZxh.f13779KLMXS[0].m13321wA());
                m8996wA(this.f9003qdMbNW, this.f9001lgHUyS, 1, this.f8999KLFTb);
                return;
            }
            return;
        }
        C4446qtZIjO c4446qtZIjO6 = c4446qtZIjOArr2[1];
        if (c4446qtZIjO6.f16248ZfxDd != null) {
            C4494rdtF c4494rdtFM8992lgHUyS8 = m8992lgHUyS(c4446qtZIjO6);
            if (c4494rdtFM8992lgHUyS8 != null) {
                m8988AZxh(this.f9003qdMbNW, c4494rdtFM8992lgHUyS8, -this.f8996AZxh.f13779KLMXS[1].m13321wA());
                m8996wA(this.f9001lgHUyS, this.f9003qdMbNW, -1, this.f8999KLFTb);
                return;
            }
            return;
        }
        if ((c3776gjvQ4 instanceof InterfaceC4718v) || c3776gjvQ4.m12044Ne() == null) {
            return;
        }
        m8988AZxh(this.f9001lgHUyS, this.f8996AZxh.m12044Ne().f13778KLFTb.f9001lgHUyS, this.f8996AZxh.m12085oCFDzJ());
        m8996wA(this.f9003qdMbNW, this.f9001lgHUyS, 1, this.f8999KLFTb);
    }

    /* renamed from: fehf */
    public final void m7520fehf(int[] iArr, int i, int i2, int i3, int i4, float f, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i5 != -1) {
            if (i5 == 0) {
                iArr[0] = (int) ((i7 * f) + 0.5f);
                iArr[1] = i7;
                return;
            } else {
                if (i5 != 1) {
                    return;
                }
                iArr[0] = i6;
                iArr[1] = (int) ((i6 * f) + 0.5f);
                return;
            }
        }
        int i8 = (int) ((i7 * f) + 0.5f);
        int i9 = (int) ((i6 / f) + 0.5f);
        if (i8 <= i6) {
            iArr[0] = i8;
            iArr[1] = i7;
        } else if (i9 <= i7) {
            iArr[0] = i6;
            iArr[1] = i9;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x02df  */
    @Override // p131o.AbstractC2246Ja, p131o.InterfaceC2695QQi
    /* renamed from: mjFkc */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo7521mjFkc(InterfaceC2695QQi interfaceC2695QQi) {
        float f;
        float fM12068diqgf;
        float fM12068diqgf2;
        int i;
        int i2 = mjFkc.f7300mjFkc[this.f8997Dt.ordinal()];
        if (i2 == 1) {
            m8993qGY(interfaceC2695QQi);
        } else if (i2 == 2) {
            m8995rkYL(interfaceC2695QQi);
        } else if (i2 == 3) {
            C3776gjvQ c3776gjvQ = this.f8996AZxh;
            m8991YoKzxo(interfaceC2695QQi, c3776gjvQ.f13764BAnRFn, c3776gjvQ.f13829wJVbdd, 0);
            return;
        }
        if (!this.f8999KLFTb.f16348Dt && this.f9000ZfxDd == C3776gjvQ.AZxh.MATCH_CONSTRAINT) {
            C3776gjvQ c3776gjvQ2 = this.f8996AZxh;
            int i3 = c3776gjvQ2.f13793VA;
            if (i3 == 2) {
                C3776gjvQ c3776gjvQM12044Ne = c3776gjvQ2.m12044Ne();
                if (c3776gjvQM12044Ne != null) {
                    if (c3776gjvQM12044Ne.f13778KLFTb.f8999KLFTb.f16348Dt) {
                        this.f8999KLFTb.mo7695ZfxDd((int) ((r0.f16358xJ * this.f8996AZxh.f13809fehf) + 0.5f));
                    }
                }
            } else if (i3 == 3) {
                int i4 = c3776gjvQ2.f13781MiMN;
                if (i4 == 0 || i4 == 3) {
                    C2742R9 c2742r9 = c3776gjvQ2.f13774JHa;
                    C4494rdtF c4494rdtF = c2742r9.f9001lgHUyS;
                    C4494rdtF c4494rdtF2 = c2742r9.f9003qdMbNW;
                    boolean z = c3776gjvQ2.f13764BAnRFn.f16248ZfxDd != null;
                    boolean z2 = c3776gjvQ2.f13813lB.f16248ZfxDd != null;
                    boolean z3 = c3776gjvQ2.f13829wJVbdd.f16248ZfxDd != null;
                    boolean z4 = c3776gjvQ2.f13815mByQ.f16248ZfxDd != null;
                    int iM12070eyqo = c3776gjvQ2.m12070eyqo();
                    if (z && z2 && z3 && z4) {
                        float fM12068diqgf3 = this.f8996AZxh.m12068diqgf();
                        if (c4494rdtF.f16348Dt && c4494rdtF2.f16348Dt) {
                            C4494rdtF c4494rdtF3 = this.f9001lgHUyS;
                            if (c4494rdtF3.f16357wA && this.f9003qdMbNW.f16357wA) {
                                m7520fehf(f7299ETF, ((C4494rdtF) c4494rdtF3.f16352VA.get(0)).f16358xJ + this.f9001lgHUyS.f16350JHa, ((C4494rdtF) this.f9003qdMbNW.f16352VA.get(0)).f16358xJ - this.f9003qdMbNW.f16350JHa, c4494rdtF.f16358xJ + c4494rdtF.f16350JHa, c4494rdtF2.f16358xJ - c4494rdtF2.f16350JHa, fM12068diqgf3, iM12070eyqo);
                                this.f8999KLFTb.mo7695ZfxDd(f7299ETF[0]);
                                this.f8996AZxh.f13774JHa.f8999KLFTb.mo7695ZfxDd(f7299ETF[1]);
                                return;
                            }
                            return;
                        }
                        C4494rdtF c4494rdtF4 = this.f9001lgHUyS;
                        if (c4494rdtF4.f16348Dt) {
                            C4494rdtF c4494rdtF5 = this.f9003qdMbNW;
                            if (c4494rdtF5.f16348Dt) {
                                if (!c4494rdtF.f16357wA || !c4494rdtF2.f16357wA) {
                                    return;
                                }
                                m7520fehf(f7299ETF, c4494rdtF4.f16358xJ + c4494rdtF4.f16350JHa, c4494rdtF5.f16358xJ - c4494rdtF5.f16350JHa, ((C4494rdtF) c4494rdtF.f16352VA.get(0)).f16358xJ + c4494rdtF.f16350JHa, ((C4494rdtF) c4494rdtF2.f16352VA.get(0)).f16358xJ - c4494rdtF2.f16350JHa, fM12068diqgf3, iM12070eyqo);
                                this.f8999KLFTb.mo7695ZfxDd(f7299ETF[0]);
                                this.f8996AZxh.f13774JHa.f8999KLFTb.mo7695ZfxDd(f7299ETF[1]);
                            }
                        }
                        C4494rdtF c4494rdtF6 = this.f9001lgHUyS;
                        if (!c4494rdtF6.f16357wA || !this.f9003qdMbNW.f16357wA || !c4494rdtF.f16357wA || !c4494rdtF2.f16357wA) {
                            return;
                        }
                        m7520fehf(f7299ETF, ((C4494rdtF) c4494rdtF6.f16352VA.get(0)).f16358xJ + this.f9001lgHUyS.f16350JHa, ((C4494rdtF) this.f9003qdMbNW.f16352VA.get(0)).f16358xJ - this.f9003qdMbNW.f16350JHa, ((C4494rdtF) c4494rdtF.f16352VA.get(0)).f16358xJ + c4494rdtF.f16350JHa, ((C4494rdtF) c4494rdtF2.f16352VA.get(0)).f16358xJ - c4494rdtF2.f16350JHa, fM12068diqgf3, iM12070eyqo);
                        this.f8999KLFTb.mo7695ZfxDd(f7299ETF[0]);
                        this.f8996AZxh.f13774JHa.f8999KLFTb.mo7695ZfxDd(f7299ETF[1]);
                    } else if (z && z3) {
                        if (!this.f9001lgHUyS.f16357wA || !this.f9003qdMbNW.f16357wA) {
                            return;
                        }
                        float fM12068diqgf4 = this.f8996AZxh.m12068diqgf();
                        int i5 = ((C4494rdtF) this.f9001lgHUyS.f16352VA.get(0)).f16358xJ + this.f9001lgHUyS.f16350JHa;
                        int i6 = ((C4494rdtF) this.f9003qdMbNW.f16352VA.get(0)).f16358xJ - this.f9003qdMbNW.f16350JHa;
                        if (iM12070eyqo == -1 || iM12070eyqo == 0) {
                            int iM8997xJ = m8997xJ(i6 - i5, 0);
                            int i7 = (int) ((iM8997xJ * fM12068diqgf4) + 0.5f);
                            int iM8997xJ2 = m8997xJ(i7, 1);
                            if (i7 != iM8997xJ2) {
                                iM8997xJ = (int) ((iM8997xJ2 / fM12068diqgf4) + 0.5f);
                            }
                            this.f8999KLFTb.mo7695ZfxDd(iM8997xJ);
                            this.f8996AZxh.f13774JHa.f8999KLFTb.mo7695ZfxDd(iM8997xJ2);
                        } else if (iM12070eyqo == 1) {
                            int iM8997xJ3 = m8997xJ(i6 - i5, 0);
                            int i8 = (int) ((iM8997xJ3 / fM12068diqgf4) + 0.5f);
                            int iM8997xJ4 = m8997xJ(i8, 1);
                            if (i8 != iM8997xJ4) {
                                iM8997xJ3 = (int) ((iM8997xJ4 * fM12068diqgf4) + 0.5f);
                            }
                            this.f8999KLFTb.mo7695ZfxDd(iM8997xJ3);
                            this.f8996AZxh.f13774JHa.f8999KLFTb.mo7695ZfxDd(iM8997xJ4);
                        }
                    } else if (z2 && z4) {
                        if (!c4494rdtF.f16357wA || !c4494rdtF2.f16357wA) {
                            return;
                        }
                        float fM12068diqgf5 = this.f8996AZxh.m12068diqgf();
                        int i9 = ((C4494rdtF) c4494rdtF.f16352VA.get(0)).f16358xJ + c4494rdtF.f16350JHa;
                        int i10 = ((C4494rdtF) c4494rdtF2.f16352VA.get(0)).f16358xJ - c4494rdtF2.f16350JHa;
                        if (iM12070eyqo == -1) {
                            int iM8997xJ5 = m8997xJ(i10 - i9, 1);
                            int i11 = (int) ((iM8997xJ5 / fM12068diqgf5) + 0.5f);
                            int iM8997xJ6 = m8997xJ(i11, 0);
                            if (i11 != iM8997xJ6) {
                                iM8997xJ5 = (int) ((iM8997xJ6 * fM12068diqgf5) + 0.5f);
                            }
                            this.f8999KLFTb.mo7695ZfxDd(iM8997xJ6);
                            this.f8996AZxh.f13774JHa.f8999KLFTb.mo7695ZfxDd(iM8997xJ5);
                        } else if (iM12070eyqo == 0) {
                            int iM8997xJ7 = m8997xJ(i10 - i9, 1);
                            int i12 = (int) ((iM8997xJ7 * fM12068diqgf5) + 0.5f);
                            int iM8997xJ8 = m8997xJ(i12, 0);
                            if (i12 != iM8997xJ8) {
                                iM8997xJ7 = (int) ((iM8997xJ8 / fM12068diqgf5) + 0.5f);
                            }
                            this.f8999KLFTb.mo7695ZfxDd(iM8997xJ8);
                            this.f8996AZxh.f13774JHa.f8999KLFTb.mo7695ZfxDd(iM8997xJ7);
                        } else if (iM12070eyqo == 1) {
                        }
                    }
                } else {
                    int iM12070eyqo2 = c3776gjvQ2.m12070eyqo();
                    if (iM12070eyqo2 == -1) {
                        C3776gjvQ c3776gjvQ3 = this.f8996AZxh;
                        f = c3776gjvQ3.f13774JHa.f8999KLFTb.f16358xJ;
                        fM12068diqgf = c3776gjvQ3.m12068diqgf();
                    } else if (iM12070eyqo2 == 0) {
                        fM12068diqgf2 = r0.f13774JHa.f8999KLFTb.f16358xJ / this.f8996AZxh.m12068diqgf();
                        i = (int) (fM12068diqgf2 + 0.5f);
                        this.f8999KLFTb.mo7695ZfxDd(i);
                    } else if (iM12070eyqo2 != 1) {
                        i = 0;
                        this.f8999KLFTb.mo7695ZfxDd(i);
                    } else {
                        C3776gjvQ c3776gjvQ4 = this.f8996AZxh;
                        f = c3776gjvQ4.f13774JHa.f8999KLFTb.f16358xJ;
                        fM12068diqgf = c3776gjvQ4.m12068diqgf();
                    }
                    fM12068diqgf2 = f * fM12068diqgf;
                    i = (int) (fM12068diqgf2 + 0.5f);
                    this.f8999KLFTb.mo7695ZfxDd(i);
                }
            }
        }
        C4494rdtF c4494rdtF7 = this.f9001lgHUyS;
        if (c4494rdtF7.f16357wA) {
            C4494rdtF c4494rdtF8 = this.f9003qdMbNW;
            if (c4494rdtF8.f16357wA) {
                if (c4494rdtF7.f16348Dt && c4494rdtF8.f16348Dt && this.f8999KLFTb.f16348Dt) {
                    return;
                }
                if (!this.f8999KLFTb.f16348Dt && this.f9000ZfxDd == C3776gjvQ.AZxh.MATCH_CONSTRAINT) {
                    C3776gjvQ c3776gjvQ5 = this.f8996AZxh;
                    if (c3776gjvQ5.f13793VA == 0 && !c3776gjvQ5.m12094uHVRx()) {
                        C4494rdtF c4494rdtF9 = (C4494rdtF) this.f9001lgHUyS.f16352VA.get(0);
                        C4494rdtF c4494rdtF10 = (C4494rdtF) this.f9003qdMbNW.f16352VA.get(0);
                        int i13 = c4494rdtF9.f16358xJ;
                        C4494rdtF c4494rdtF11 = this.f9001lgHUyS;
                        int i14 = i13 + c4494rdtF11.f16350JHa;
                        int i15 = c4494rdtF10.f16358xJ + this.f9003qdMbNW.f16350JHa;
                        c4494rdtF11.mo7695ZfxDd(i14);
                        this.f9003qdMbNW.mo7695ZfxDd(i15);
                        this.f8999KLFTb.mo7695ZfxDd(i15 - i14);
                        return;
                    }
                }
                if (!this.f8999KLFTb.f16348Dt && this.f9000ZfxDd == C3776gjvQ.AZxh.MATCH_CONSTRAINT && this.f9002mjFkc == 1 && this.f9001lgHUyS.f16352VA.size() > 0 && this.f9003qdMbNW.f16352VA.size() > 0) {
                    int iMin = Math.min((((C4494rdtF) this.f9003qdMbNW.f16352VA.get(0)).f16358xJ + this.f9003qdMbNW.f16350JHa) - (((C4494rdtF) this.f9001lgHUyS.f16352VA.get(0)).f16358xJ + this.f9001lgHUyS.f16350JHa), this.f8999KLFTb.f7478MiMN);
                    C3776gjvQ c3776gjvQ6 = this.f8996AZxh;
                    int i16 = c3776gjvQ6.f13819qGY;
                    int iMax = Math.max(c3776gjvQ6.f13822rkYL, iMin);
                    if (i16 > 0) {
                        iMax = Math.min(i16, iMax);
                    }
                    this.f8999KLFTb.mo7695ZfxDd(iMax);
                }
                if (this.f8999KLFTb.f16348Dt) {
                    C4494rdtF c4494rdtF12 = (C4494rdtF) this.f9001lgHUyS.f16352VA.get(0);
                    C4494rdtF c4494rdtF13 = (C4494rdtF) this.f9003qdMbNW.f16352VA.get(0);
                    int i17 = c4494rdtF12.f16358xJ + this.f9001lgHUyS.f16350JHa;
                    int i18 = c4494rdtF13.f16358xJ + this.f9003qdMbNW.f16350JHa;
                    float fM12076huTpC = this.f8996AZxh.m12076huTpC();
                    if (c4494rdtF12 == c4494rdtF13) {
                        i17 = c4494rdtF12.f16358xJ;
                        i18 = c4494rdtF13.f16358xJ;
                        fM12076huTpC = 0.5f;
                    }
                    this.f9001lgHUyS.mo7695ZfxDd((int) (i17 + 0.5f + (((i18 - i17) - this.f8999KLFTb.f16358xJ) * fM12076huTpC)));
                    this.f9003qdMbNW.mo7695ZfxDd(this.f9001lgHUyS.f16358xJ + this.f8999KLFTb.f16358xJ);
                }
            }
        }
    }

    public String toString() {
        return "HorizontalRun " + this.f8996AZxh.m12031IEE();
    }
}
