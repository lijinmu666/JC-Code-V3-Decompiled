package p131o;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import p131o.C3582dkKKW;
import p131o.C3776gjvQ;

/* renamed from: o.RV */
/* loaded from: classes.dex */
public class C2765RV {

    /* renamed from: ZfxDd */
    public C4052kw f10425ZfxDd;

    /* renamed from: mjFkc */
    public C4052kw f10427mjFkc;

    /* renamed from: AZxh */
    public boolean f10422AZxh = true;

    /* renamed from: wA */
    public boolean f10429wA = true;

    /* renamed from: KLFTb */
    public ArrayList f10424KLFTb = new ArrayList();

    /* renamed from: JHa */
    public ArrayList f10423JHa = new ArrayList();

    /* renamed from: xJ */
    public C3582dkKKW.AZxh f10430xJ = null;

    /* renamed from: lgHUyS */
    public C3582dkKKW.mjFkc f10426lgHUyS = new C3582dkKKW.mjFkc();

    /* renamed from: qdMbNW */
    public ArrayList f10428qdMbNW = new ArrayList();

    public C2765RV(C4052kw c4052kw) {
        this.f10427mjFkc = c4052kw;
        this.f10425ZfxDd = c4052kw;
    }

    /* renamed from: AZxh */
    public final boolean m10068AZxh(C4052kw c4052kw) {
        int iM12096vadzgd;
        C3776gjvQ.AZxh aZxh;
        int iM12051Ucbh;
        C3776gjvQ.AZxh aZxh2;
        C3776gjvQ.AZxh[] aZxhArr;
        C3776gjvQ.AZxh aZxh3;
        C3776gjvQ.AZxh aZxh4;
        C3776gjvQ.AZxh aZxh5;
        C3776gjvQ.AZxh aZxh6;
        Iterator it = c4052kw.f8762tjSezt.iterator();
        while (it.hasNext()) {
            C3776gjvQ c3776gjvQ = (C3776gjvQ) it.next();
            C3776gjvQ.AZxh[] aZxhArr2 = c3776gjvQ.f13821rWxwaT;
            C3776gjvQ.AZxh aZxh7 = aZxhArr2[0];
            C3776gjvQ.AZxh aZxh8 = aZxhArr2[1];
            if (c3776gjvQ.m12043NPj() == 8) {
                c3776gjvQ.f13816mjFkc = true;
            } else {
                if (c3776gjvQ.f13809fehf < 1.0f && aZxh7 == C3776gjvQ.AZxh.MATCH_CONSTRAINT) {
                    c3776gjvQ.f13793VA = 2;
                }
                if (c3776gjvQ.f13806diqgf < 1.0f && aZxh8 == C3776gjvQ.AZxh.MATCH_CONSTRAINT) {
                    c3776gjvQ.f13781MiMN = 2;
                }
                if (c3776gjvQ.m12068diqgf() > 0.0f) {
                    C3776gjvQ.AZxh aZxh9 = C3776gjvQ.AZxh.MATCH_CONSTRAINT;
                    if (aZxh7 == aZxh9 && (aZxh8 == C3776gjvQ.AZxh.WRAP_CONTENT || aZxh8 == C3776gjvQ.AZxh.FIXED)) {
                        c3776gjvQ.f13793VA = 3;
                    } else if (aZxh8 == aZxh9 && (aZxh7 == C3776gjvQ.AZxh.WRAP_CONTENT || aZxh7 == C3776gjvQ.AZxh.FIXED)) {
                        c3776gjvQ.f13781MiMN = 3;
                    } else if (aZxh7 == aZxh9 && aZxh8 == aZxh9) {
                        if (c3776gjvQ.f13793VA == 0) {
                            c3776gjvQ.f13793VA = 3;
                        }
                        if (c3776gjvQ.f13781MiMN == 0) {
                            c3776gjvQ.f13781MiMN = 3;
                        }
                    }
                }
                C3776gjvQ.AZxh aZxh10 = C3776gjvQ.AZxh.MATCH_CONSTRAINT;
                if (aZxh7 == aZxh10 && c3776gjvQ.f13793VA == 1 && (c3776gjvQ.f13764BAnRFn.f16248ZfxDd == null || c3776gjvQ.f13829wJVbdd.f16248ZfxDd == null)) {
                    aZxh7 = C3776gjvQ.AZxh.WRAP_CONTENT;
                }
                C3776gjvQ.AZxh aZxh11 = aZxh7;
                if (aZxh8 == aZxh10 && c3776gjvQ.f13781MiMN == 1 && (c3776gjvQ.f13813lB.f16248ZfxDd == null || c3776gjvQ.f13815mByQ.f16248ZfxDd == null)) {
                    aZxh8 = C3776gjvQ.AZxh.WRAP_CONTENT;
                }
                C3776gjvQ.AZxh aZxh12 = aZxh8;
                C1597A c1597a = c3776gjvQ.f13778KLFTb;
                c1597a.f9000ZfxDd = aZxh11;
                int i = c3776gjvQ.f13793VA;
                c1597a.f9002mjFkc = i;
                C2742R9 c2742r9 = c3776gjvQ.f13774JHa;
                c2742r9.f9000ZfxDd = aZxh12;
                int i2 = c3776gjvQ.f13781MiMN;
                c2742r9.f9002mjFkc = i2;
                C3776gjvQ.AZxh aZxh13 = C3776gjvQ.AZxh.MATCH_PARENT;
                if ((aZxh11 == aZxh13 || aZxh11 == C3776gjvQ.AZxh.FIXED || aZxh11 == C3776gjvQ.AZxh.WRAP_CONTENT) && (aZxh12 == aZxh13 || aZxh12 == C3776gjvQ.AZxh.FIXED || aZxh12 == C3776gjvQ.AZxh.WRAP_CONTENT)) {
                    int iM12096vadzgd2 = c3776gjvQ.m12096vadzgd();
                    if (aZxh11 == aZxh13) {
                        iM12096vadzgd = (c4052kw.m12096vadzgd() - c3776gjvQ.f13764BAnRFn.f16247KLFTb) - c3776gjvQ.f13829wJVbdd.f16247KLFTb;
                        aZxh = C3776gjvQ.AZxh.FIXED;
                    } else {
                        iM12096vadzgd = iM12096vadzgd2;
                        aZxh = aZxh11;
                    }
                    int iM12051Ucbh2 = c3776gjvQ.m12051Ucbh();
                    if (aZxh12 == aZxh13) {
                        iM12051Ucbh = (c4052kw.m12051Ucbh() - c3776gjvQ.f13813lB.f16247KLFTb) - c3776gjvQ.f13815mByQ.f16247KLFTb;
                        aZxh2 = C3776gjvQ.AZxh.FIXED;
                    } else {
                        iM12051Ucbh = iM12051Ucbh2;
                        aZxh2 = aZxh12;
                    }
                    m10074VA(c3776gjvQ, aZxh, iM12096vadzgd, aZxh2, iM12051Ucbh);
                    c3776gjvQ.f13778KLFTb.f8999KLFTb.mo7695ZfxDd(c3776gjvQ.m12096vadzgd());
                    c3776gjvQ.f13774JHa.f8999KLFTb.mo7695ZfxDd(c3776gjvQ.m12051Ucbh());
                    c3776gjvQ.f13816mjFkc = true;
                } else {
                    if (aZxh11 == aZxh10 && (aZxh12 == (aZxh6 = C3776gjvQ.AZxh.WRAP_CONTENT) || aZxh12 == C3776gjvQ.AZxh.FIXED)) {
                        if (i == 3) {
                            if (aZxh12 == aZxh6) {
                                m10074VA(c3776gjvQ, aZxh6, 0, aZxh6, 0);
                            }
                            int iM12051Ucbh3 = c3776gjvQ.m12051Ucbh();
                            int i3 = (int) ((iM12051Ucbh3 * c3776gjvQ.f13818oCFDzJ) + 0.5f);
                            C3776gjvQ.AZxh aZxh14 = C3776gjvQ.AZxh.FIXED;
                            m10074VA(c3776gjvQ, aZxh14, i3, aZxh14, iM12051Ucbh3);
                            c3776gjvQ.f13778KLFTb.f8999KLFTb.mo7695ZfxDd(c3776gjvQ.m12096vadzgd());
                            c3776gjvQ.f13774JHa.f8999KLFTb.mo7695ZfxDd(c3776gjvQ.m12051Ucbh());
                            c3776gjvQ.f13816mjFkc = true;
                        } else if (i == 1) {
                            m10074VA(c3776gjvQ, aZxh6, 0, aZxh12, 0);
                            c3776gjvQ.f13778KLFTb.f8999KLFTb.f7478MiMN = c3776gjvQ.m12096vadzgd();
                        } else if (i == 2) {
                            C3776gjvQ.AZxh aZxh15 = c4052kw.f13821rWxwaT[0];
                            C3776gjvQ.AZxh aZxh16 = C3776gjvQ.AZxh.FIXED;
                            if (aZxh15 == aZxh16 || aZxh15 == aZxh13) {
                                m10074VA(c3776gjvQ, aZxh16, (int) ((c3776gjvQ.f13809fehf * c4052kw.m12096vadzgd()) + 0.5f), aZxh12, c3776gjvQ.m12051Ucbh());
                                c3776gjvQ.f13778KLFTb.f8999KLFTb.mo7695ZfxDd(c3776gjvQ.m12096vadzgd());
                                c3776gjvQ.f13774JHa.f8999KLFTb.mo7695ZfxDd(c3776gjvQ.m12051Ucbh());
                                c3776gjvQ.f13816mjFkc = true;
                            }
                        } else {
                            C4446qtZIjO[] c4446qtZIjOArr = c3776gjvQ.f13779KLMXS;
                            if (c4446qtZIjOArr[0].f16248ZfxDd == null || c4446qtZIjOArr[1].f16248ZfxDd == null) {
                                m10074VA(c3776gjvQ, aZxh6, 0, aZxh12, 0);
                                c3776gjvQ.f13778KLFTb.f8999KLFTb.mo7695ZfxDd(c3776gjvQ.m12096vadzgd());
                                c3776gjvQ.f13774JHa.f8999KLFTb.mo7695ZfxDd(c3776gjvQ.m12051Ucbh());
                                c3776gjvQ.f13816mjFkc = true;
                            }
                        }
                    }
                    if (aZxh12 == aZxh10 && (aZxh11 == (aZxh5 = C3776gjvQ.AZxh.WRAP_CONTENT) || aZxh11 == C3776gjvQ.AZxh.FIXED)) {
                        if (i2 == 3) {
                            if (aZxh11 == aZxh5) {
                                m10074VA(c3776gjvQ, aZxh5, 0, aZxh5, 0);
                            }
                            int iM12096vadzgd3 = c3776gjvQ.m12096vadzgd();
                            float f = c3776gjvQ.f13818oCFDzJ;
                            if (c3776gjvQ.m12070eyqo() == -1) {
                                f = 1.0f / f;
                            }
                            C3776gjvQ.AZxh aZxh17 = C3776gjvQ.AZxh.FIXED;
                            m10074VA(c3776gjvQ, aZxh17, iM12096vadzgd3, aZxh17, (int) ((iM12096vadzgd3 * f) + 0.5f));
                            c3776gjvQ.f13778KLFTb.f8999KLFTb.mo7695ZfxDd(c3776gjvQ.m12096vadzgd());
                            c3776gjvQ.f13774JHa.f8999KLFTb.mo7695ZfxDd(c3776gjvQ.m12051Ucbh());
                            c3776gjvQ.f13816mjFkc = true;
                        } else if (i2 == 1) {
                            m10074VA(c3776gjvQ, aZxh11, 0, aZxh5, 0);
                            c3776gjvQ.f13774JHa.f8999KLFTb.f7478MiMN = c3776gjvQ.m12051Ucbh();
                        } else if (i2 == 2) {
                            C3776gjvQ.AZxh aZxh18 = c4052kw.f13821rWxwaT[1];
                            C3776gjvQ.AZxh aZxh19 = C3776gjvQ.AZxh.FIXED;
                            if (aZxh18 == aZxh19 || aZxh18 == aZxh13) {
                                m10074VA(c3776gjvQ, aZxh11, c3776gjvQ.m12096vadzgd(), aZxh19, (int) ((c3776gjvQ.f13806diqgf * c4052kw.m12051Ucbh()) + 0.5f));
                                c3776gjvQ.f13778KLFTb.f8999KLFTb.mo7695ZfxDd(c3776gjvQ.m12096vadzgd());
                                c3776gjvQ.f13774JHa.f8999KLFTb.mo7695ZfxDd(c3776gjvQ.m12051Ucbh());
                                c3776gjvQ.f13816mjFkc = true;
                            }
                        } else {
                            C4446qtZIjO[] c4446qtZIjOArr2 = c3776gjvQ.f13779KLMXS;
                            if (c4446qtZIjOArr2[2].f16248ZfxDd == null || c4446qtZIjOArr2[3].f16248ZfxDd == null) {
                                m10074VA(c3776gjvQ, aZxh5, 0, aZxh12, 0);
                                c3776gjvQ.f13778KLFTb.f8999KLFTb.mo7695ZfxDd(c3776gjvQ.m12096vadzgd());
                                c3776gjvQ.f13774JHa.f8999KLFTb.mo7695ZfxDd(c3776gjvQ.m12051Ucbh());
                                c3776gjvQ.f13816mjFkc = true;
                            }
                        }
                    }
                    if (aZxh11 == aZxh10 && aZxh12 == aZxh10) {
                        if (i == 1 || i2 == 1) {
                            C3776gjvQ.AZxh aZxh20 = C3776gjvQ.AZxh.WRAP_CONTENT;
                            m10074VA(c3776gjvQ, aZxh20, 0, aZxh20, 0);
                            c3776gjvQ.f13778KLFTb.f8999KLFTb.f7478MiMN = c3776gjvQ.m12096vadzgd();
                            c3776gjvQ.f13774JHa.f8999KLFTb.f7478MiMN = c3776gjvQ.m12051Ucbh();
                        } else if (i2 == 2 && i == 2 && ((aZxh3 = (aZxhArr = c4052kw.f13821rWxwaT)[0]) == (aZxh4 = C3776gjvQ.AZxh.FIXED) || aZxh3 == aZxh4)) {
                            C3776gjvQ.AZxh aZxh21 = aZxhArr[1];
                            if (aZxh21 == aZxh4 || aZxh21 == aZxh4) {
                                m10074VA(c3776gjvQ, aZxh4, (int) ((c3776gjvQ.f13809fehf * c4052kw.m12096vadzgd()) + 0.5f), aZxh4, (int) ((c3776gjvQ.f13806diqgf * c4052kw.m12051Ucbh()) + 0.5f));
                                c3776gjvQ.f13778KLFTb.f8999KLFTb.mo7695ZfxDd(c3776gjvQ.m12096vadzgd());
                                c3776gjvQ.f13774JHa.f8999KLFTb.mo7695ZfxDd(c3776gjvQ.m12051Ucbh());
                                c3776gjvQ.f13816mjFkc = true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: Dt */
    public void m10069Dt() {
        this.f10422AZxh = true;
    }

    /* renamed from: ETF */
    public void m10070ETF() {
        this.f10429wA = true;
    }

    /* renamed from: JHa */
    public boolean m10071JHa(boolean z) {
        boolean z2;
        boolean z3 = false;
        if (this.f10422AZxh || this.f10429wA) {
            Iterator it = this.f10427mjFkc.f8762tjSezt.iterator();
            while (it.hasNext()) {
                C3776gjvQ c3776gjvQ = (C3776gjvQ) it.next();
                c3776gjvQ.f13816mjFkc = false;
                c3776gjvQ.f13778KLFTb.m7515IEE();
                c3776gjvQ.f13774JHa.m10056fehf();
            }
            C4052kw c4052kw = this.f10427mjFkc;
            c4052kw.f13816mjFkc = false;
            c4052kw.f13778KLFTb.m7515IEE();
            this.f10427mjFkc.f13774JHa.m10056fehf();
            this.f10429wA = false;
        }
        if (m10068AZxh(this.f10425ZfxDd)) {
            return false;
        }
        this.f10427mjFkc.m12093uH(0);
        this.f10427mjFkc.m12090tISON(0);
        C3776gjvQ.AZxh aZxhM12046Pq = this.f10427mjFkc.m12046Pq(0);
        C3776gjvQ.AZxh aZxhM12046Pq2 = this.f10427mjFkc.m12046Pq(1);
        if (this.f10422AZxh) {
            m10080wA();
        }
        int iM12085oCFDzJ = this.f10427mjFkc.m12085oCFDzJ();
        int iM12065aqHPIZ = this.f10427mjFkc.m12065aqHPIZ();
        this.f10427mjFkc.f13778KLFTb.f9001lgHUyS.mo7695ZfxDd(iM12085oCFDzJ);
        this.f10427mjFkc.f13774JHa.f9001lgHUyS.mo7695ZfxDd(iM12065aqHPIZ);
        m10073MiMN();
        C3776gjvQ.AZxh aZxh = C3776gjvQ.AZxh.WRAP_CONTENT;
        if (aZxhM12046Pq == aZxh || aZxhM12046Pq2 == aZxh) {
            if (z) {
                Iterator it2 = this.f10424KLFTb.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (!((AbstractC2246Ja) it2.next()).mo7518MiMN()) {
                        z = false;
                        break;
                    }
                }
            }
            if (z && aZxhM12046Pq == C3776gjvQ.AZxh.WRAP_CONTENT) {
                this.f10427mjFkc.m12102yfx(C3776gjvQ.AZxh.FIXED);
                C4052kw c4052kw2 = this.f10427mjFkc;
                c4052kw2.m12078jx(m10072KLFTb(c4052kw2, 0));
                C4052kw c4052kw3 = this.f10427mjFkc;
                c4052kw3.f13778KLFTb.f8999KLFTb.mo7695ZfxDd(c4052kw3.m12096vadzgd());
            }
            if (z && aZxhM12046Pq2 == C3776gjvQ.AZxh.WRAP_CONTENT) {
                this.f10427mjFkc.m12071fFz(C3776gjvQ.AZxh.FIXED);
                C4052kw c4052kw4 = this.f10427mjFkc;
                c4052kw4.m12023ANMGZc(m10072KLFTb(c4052kw4, 1));
                C4052kw c4052kw5 = this.f10427mjFkc;
                c4052kw5.f13774JHa.f8999KLFTb.mo7695ZfxDd(c4052kw5.m12051Ucbh());
            }
        }
        C4052kw c4052kw6 = this.f10427mjFkc;
        C3776gjvQ.AZxh aZxh2 = c4052kw6.f13821rWxwaT[0];
        C3776gjvQ.AZxh aZxh3 = C3776gjvQ.AZxh.FIXED;
        if (aZxh2 == aZxh3 || aZxh2 == C3776gjvQ.AZxh.MATCH_PARENT) {
            int iM12096vadzgd = c4052kw6.m12096vadzgd() + iM12085oCFDzJ;
            this.f10427mjFkc.f13778KLFTb.f9003qdMbNW.mo7695ZfxDd(iM12096vadzgd);
            this.f10427mjFkc.f13778KLFTb.f8999KLFTb.mo7695ZfxDd(iM12096vadzgd - iM12085oCFDzJ);
            m10073MiMN();
            C4052kw c4052kw7 = this.f10427mjFkc;
            C3776gjvQ.AZxh aZxh4 = c4052kw7.f13821rWxwaT[1];
            if (aZxh4 == aZxh3 || aZxh4 == C3776gjvQ.AZxh.MATCH_PARENT) {
                int iM12051Ucbh = c4052kw7.m12051Ucbh() + iM12065aqHPIZ;
                this.f10427mjFkc.f13774JHa.f9003qdMbNW.mo7695ZfxDd(iM12051Ucbh);
                this.f10427mjFkc.f13774JHa.f8999KLFTb.mo7695ZfxDd(iM12051Ucbh - iM12065aqHPIZ);
            }
            m10073MiMN();
            z2 = true;
        } else {
            z2 = false;
        }
        Iterator it3 = this.f10424KLFTb.iterator();
        while (it3.hasNext()) {
            AbstractC2246Ja abstractC2246Ja = (AbstractC2246Ja) it3.next();
            if (abstractC2246Ja.f8996AZxh != this.f10427mjFkc || abstractC2246Ja.f9005xJ) {
                abstractC2246Ja.mo7517KLFTb();
            }
        }
        Iterator it4 = this.f10424KLFTb.iterator();
        while (true) {
            if (!it4.hasNext()) {
                z3 = true;
                break;
            }
            AbstractC2246Ja abstractC2246Ja2 = (AbstractC2246Ja) it4.next();
            if (z2 || abstractC2246Ja2.f8996AZxh != this.f10427mjFkc) {
                if (!abstractC2246Ja2.f9001lgHUyS.f16348Dt || ((!abstractC2246Ja2.f9003qdMbNW.f16348Dt && !(abstractC2246Ja2 instanceof C4251o)) || (!abstractC2246Ja2.f8999KLFTb.f16348Dt && !(abstractC2246Ja2 instanceof C1890ERt) && !(abstractC2246Ja2 instanceof C4251o)))) {
                    break;
                }
            }
        }
        this.f10427mjFkc.m12102yfx(aZxhM12046Pq);
        this.f10427mjFkc.m12071fFz(aZxhM12046Pq2);
        return z3;
    }

    /* renamed from: KLFTb */
    public final int m10072KLFTb(C4052kw c4052kw, int i) {
        int size = this.f10428qdMbNW.size();
        long jMax = 0;
        for (int i2 = 0; i2 < size; i2++) {
            jMax = Math.max(jMax, ((C2209J5) this.f10428qdMbNW.get(i2)).m8887AZxh(c4052kw, i));
        }
        return (int) jMax;
    }

    /* renamed from: MiMN */
    public void m10073MiMN() {
        C1691BOPu c1691BOPu;
        Iterator it = this.f10427mjFkc.f8762tjSezt.iterator();
        while (it.hasNext()) {
            C3776gjvQ c3776gjvQ = (C3776gjvQ) it.next();
            if (!c3776gjvQ.f13816mjFkc) {
                C3776gjvQ.AZxh[] aZxhArr = c3776gjvQ.f13821rWxwaT;
                boolean z = false;
                C3776gjvQ.AZxh aZxh = aZxhArr[0];
                C3776gjvQ.AZxh aZxh2 = aZxhArr[1];
                int i = c3776gjvQ.f13793VA;
                int i2 = c3776gjvQ.f13781MiMN;
                C3776gjvQ.AZxh aZxh3 = C3776gjvQ.AZxh.WRAP_CONTENT;
                boolean z2 = aZxh == aZxh3 || (aZxh == C3776gjvQ.AZxh.MATCH_CONSTRAINT && i == 1);
                if (aZxh2 == aZxh3 || (aZxh2 == C3776gjvQ.AZxh.MATCH_CONSTRAINT && i2 == 1)) {
                    z = true;
                }
                C1691BOPu c1691BOPu2 = c3776gjvQ.f13778KLFTb.f8999KLFTb;
                boolean z3 = c1691BOPu2.f16348Dt;
                C1691BOPu c1691BOPu3 = c3776gjvQ.f13774JHa.f8999KLFTb;
                boolean z4 = c1691BOPu3.f16348Dt;
                if (z3 && z4) {
                    C3776gjvQ.AZxh aZxh4 = C3776gjvQ.AZxh.FIXED;
                    m10074VA(c3776gjvQ, aZxh4, c1691BOPu2.f16358xJ, aZxh4, c1691BOPu3.f16358xJ);
                    c3776gjvQ.f13816mjFkc = true;
                } else if (z3 && z) {
                    m10074VA(c3776gjvQ, C3776gjvQ.AZxh.FIXED, c1691BOPu2.f16358xJ, aZxh3, c1691BOPu3.f16358xJ);
                    if (aZxh2 == C3776gjvQ.AZxh.MATCH_CONSTRAINT) {
                        c3776gjvQ.f13774JHa.f8999KLFTb.f7478MiMN = c3776gjvQ.m12051Ucbh();
                    } else {
                        c3776gjvQ.f13774JHa.f8999KLFTb.mo7695ZfxDd(c3776gjvQ.m12051Ucbh());
                        c3776gjvQ.f13816mjFkc = true;
                    }
                } else if (z4 && z2) {
                    m10074VA(c3776gjvQ, aZxh3, c1691BOPu2.f16358xJ, C3776gjvQ.AZxh.FIXED, c1691BOPu3.f16358xJ);
                    if (aZxh == C3776gjvQ.AZxh.MATCH_CONSTRAINT) {
                        c3776gjvQ.f13778KLFTb.f8999KLFTb.f7478MiMN = c3776gjvQ.m12096vadzgd();
                    } else {
                        c3776gjvQ.f13778KLFTb.f8999KLFTb.mo7695ZfxDd(c3776gjvQ.m12096vadzgd());
                        c3776gjvQ.f13816mjFkc = true;
                    }
                }
                if (c3776gjvQ.f13816mjFkc && (c1691BOPu = c3776gjvQ.f13774JHa.f10389VA) != null) {
                    c1691BOPu.mo7695ZfxDd(c3776gjvQ.m12062YoKzxo());
                }
            }
        }
    }

    /* renamed from: VA */
    public final void m10074VA(C3776gjvQ c3776gjvQ, C3776gjvQ.AZxh aZxh, int i, C3776gjvQ.AZxh aZxh2, int i2) {
        C3582dkKKW.mjFkc mjfkc = this.f10426lgHUyS;
        mjfkc.f13387mjFkc = aZxh;
        mjfkc.f13381AZxh = aZxh2;
        mjfkc.f13389wA = i;
        mjfkc.f13385ZfxDd = i2;
        this.f10430xJ.mo407AZxh(c3776gjvQ, mjfkc);
        c3776gjvQ.m12078jx(this.f10426lgHUyS.f13384KLFTb);
        c3776gjvQ.m12023ANMGZc(this.f10426lgHUyS.f13383JHa);
        c3776gjvQ.m12077jm(this.f10426lgHUyS.f13386lgHUyS);
        c3776gjvQ.m12059XV(this.f10426lgHUyS.f13390xJ);
    }

    /* renamed from: YoKzxo */
    public void m10075YoKzxo(C3582dkKKW.AZxh aZxh) {
        this.f10430xJ = aZxh;
    }

    /* renamed from: ZfxDd */
    public void m10076ZfxDd(ArrayList arrayList) {
        arrayList.clear();
        this.f10425ZfxDd.f13778KLFTb.mo7516JHa();
        this.f10425ZfxDd.f13774JHa.mo7516JHa();
        arrayList.add(this.f10425ZfxDd.f13778KLFTb);
        arrayList.add(this.f10425ZfxDd.f13774JHa);
        Iterator it = this.f10425ZfxDd.f8762tjSezt.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            C3776gjvQ c3776gjvQ = (C3776gjvQ) it.next();
            if (c3776gjvQ instanceof C4186n) {
                arrayList.add(new C4251o(c3776gjvQ));
            } else {
                if (c3776gjvQ.m12094uHVRx()) {
                    if (c3776gjvQ.f13828wA == null) {
                        c3776gjvQ.f13828wA = new C1890ERt(c3776gjvQ, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(c3776gjvQ.f13828wA);
                } else {
                    arrayList.add(c3776gjvQ.f13778KLFTb);
                }
                if (c3776gjvQ.m12034JYgkl()) {
                    if (c3776gjvQ.f13801ZfxDd == null) {
                        c3776gjvQ.f13801ZfxDd = new C1890ERt(c3776gjvQ, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(c3776gjvQ.f13801ZfxDd);
                } else {
                    arrayList.add(c3776gjvQ.f13774JHa);
                }
                if (c3776gjvQ instanceof AbstractC4852x) {
                    arrayList.add(new C4785w(c3776gjvQ));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((AbstractC2246Ja) it2.next()).mo7516JHa();
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            AbstractC2246Ja abstractC2246Ja = (AbstractC2246Ja) it3.next();
            if (abstractC2246Ja.f8996AZxh != this.f10425ZfxDd) {
                abstractC2246Ja.mo7519ZfxDd();
            }
        }
    }

    /* renamed from: lgHUyS */
    public boolean m10077lgHUyS(boolean z, int i) {
        boolean z2;
        C3776gjvQ.AZxh aZxh;
        boolean z3 = false;
        C3776gjvQ.AZxh aZxhM12046Pq = this.f10427mjFkc.m12046Pq(0);
        C3776gjvQ.AZxh aZxhM12046Pq2 = this.f10427mjFkc.m12046Pq(1);
        int iM12085oCFDzJ = this.f10427mjFkc.m12085oCFDzJ();
        int iM12065aqHPIZ = this.f10427mjFkc.m12065aqHPIZ();
        if (z && (aZxhM12046Pq == (aZxh = C3776gjvQ.AZxh.WRAP_CONTENT) || aZxhM12046Pq2 == aZxh)) {
            Iterator it = this.f10424KLFTb.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AbstractC2246Ja abstractC2246Ja = (AbstractC2246Ja) it.next();
                if (abstractC2246Ja.f8998JHa == i && !abstractC2246Ja.mo7518MiMN()) {
                    z = false;
                    break;
                }
            }
            if (i == 0) {
                if (z && aZxhM12046Pq == C3776gjvQ.AZxh.WRAP_CONTENT) {
                    this.f10427mjFkc.m12102yfx(C3776gjvQ.AZxh.FIXED);
                    C4052kw c4052kw = this.f10427mjFkc;
                    c4052kw.m12078jx(m10072KLFTb(c4052kw, 0));
                    C4052kw c4052kw2 = this.f10427mjFkc;
                    c4052kw2.f13778KLFTb.f8999KLFTb.mo7695ZfxDd(c4052kw2.m12096vadzgd());
                }
            } else if (z && aZxhM12046Pq2 == C3776gjvQ.AZxh.WRAP_CONTENT) {
                this.f10427mjFkc.m12071fFz(C3776gjvQ.AZxh.FIXED);
                C4052kw c4052kw3 = this.f10427mjFkc;
                c4052kw3.m12023ANMGZc(m10072KLFTb(c4052kw3, 1));
                C4052kw c4052kw4 = this.f10427mjFkc;
                c4052kw4.f13774JHa.f8999KLFTb.mo7695ZfxDd(c4052kw4.m12051Ucbh());
            }
        }
        if (i == 0) {
            C4052kw c4052kw5 = this.f10427mjFkc;
            C3776gjvQ.AZxh aZxh2 = c4052kw5.f13821rWxwaT[0];
            if (aZxh2 == C3776gjvQ.AZxh.FIXED || aZxh2 == C3776gjvQ.AZxh.MATCH_PARENT) {
                int iM12096vadzgd = c4052kw5.m12096vadzgd() + iM12085oCFDzJ;
                this.f10427mjFkc.f13778KLFTb.f9003qdMbNW.mo7695ZfxDd(iM12096vadzgd);
                this.f10427mjFkc.f13778KLFTb.f8999KLFTb.mo7695ZfxDd(iM12096vadzgd - iM12085oCFDzJ);
                z2 = true;
            }
            z2 = false;
        } else {
            C4052kw c4052kw6 = this.f10427mjFkc;
            C3776gjvQ.AZxh aZxh3 = c4052kw6.f13821rWxwaT[1];
            if (aZxh3 == C3776gjvQ.AZxh.FIXED || aZxh3 == C3776gjvQ.AZxh.MATCH_PARENT) {
                int iM12051Ucbh = c4052kw6.m12051Ucbh() + iM12065aqHPIZ;
                this.f10427mjFkc.f13774JHa.f9003qdMbNW.mo7695ZfxDd(iM12051Ucbh);
                this.f10427mjFkc.f13774JHa.f8999KLFTb.mo7695ZfxDd(iM12051Ucbh - iM12065aqHPIZ);
                z2 = true;
            }
            z2 = false;
        }
        m10073MiMN();
        Iterator it2 = this.f10424KLFTb.iterator();
        while (it2.hasNext()) {
            AbstractC2246Ja abstractC2246Ja2 = (AbstractC2246Ja) it2.next();
            if (abstractC2246Ja2.f8998JHa == i && (abstractC2246Ja2.f8996AZxh != this.f10427mjFkc || abstractC2246Ja2.f9005xJ)) {
                abstractC2246Ja2.mo7517KLFTb();
            }
        }
        Iterator it3 = this.f10424KLFTb.iterator();
        while (true) {
            if (!it3.hasNext()) {
                z3 = true;
                break;
            }
            AbstractC2246Ja abstractC2246Ja3 = (AbstractC2246Ja) it3.next();
            if (abstractC2246Ja3.f8998JHa == i && (z2 || abstractC2246Ja3.f8996AZxh != this.f10427mjFkc)) {
                if (!abstractC2246Ja3.f9001lgHUyS.f16348Dt || !abstractC2246Ja3.f9003qdMbNW.f16348Dt || (!(abstractC2246Ja3 instanceof C1890ERt) && !abstractC2246Ja3.f8999KLFTb.f16348Dt)) {
                    break;
                }
            }
        }
        this.f10427mjFkc.m12102yfx(aZxhM12046Pq);
        this.f10427mjFkc.m12071fFz(aZxhM12046Pq2);
        return z3;
    }

    /* renamed from: mjFkc */
    public final void m10078mjFkc(C4494rdtF c4494rdtF, int i, int i2, C4494rdtF c4494rdtF2, ArrayList arrayList, C2209J5 c2209j5) {
        AbstractC2246Ja abstractC2246Ja = c4494rdtF.f16353ZfxDd;
        if (abstractC2246Ja.f9004wA == null) {
            C4052kw c4052kw = this.f10427mjFkc;
            if (abstractC2246Ja == c4052kw.f13778KLFTb || abstractC2246Ja == c4052kw.f13774JHa) {
                return;
            }
            if (c2209j5 == null) {
                c2209j5 = new C2209J5(abstractC2246Ja, i2);
                arrayList.add(c2209j5);
            }
            abstractC2246Ja.f9004wA = c2209j5;
            c2209j5.m8889mjFkc(abstractC2246Ja);
            for (InterfaceC2695QQi interfaceC2695QQi : abstractC2246Ja.f9001lgHUyS.f16349ETF) {
                if (interfaceC2695QQi instanceof C4494rdtF) {
                    m10078mjFkc((C4494rdtF) interfaceC2695QQi, i, 0, c4494rdtF2, arrayList, c2209j5);
                }
            }
            for (InterfaceC2695QQi interfaceC2695QQi2 : abstractC2246Ja.f9003qdMbNW.f16349ETF) {
                if (interfaceC2695QQi2 instanceof C4494rdtF) {
                    m10078mjFkc((C4494rdtF) interfaceC2695QQi2, i, 1, c4494rdtF2, arrayList, c2209j5);
                }
            }
            if (i == 1 && (abstractC2246Ja instanceof C2742R9)) {
                for (InterfaceC2695QQi interfaceC2695QQi3 : ((C2742R9) abstractC2246Ja).f10388ETF.f16349ETF) {
                    if (interfaceC2695QQi3 instanceof C4494rdtF) {
                        m10078mjFkc((C4494rdtF) interfaceC2695QQi3, i, 2, c4494rdtF2, arrayList, c2209j5);
                    }
                }
            }
            for (C4494rdtF c4494rdtF3 : abstractC2246Ja.f9001lgHUyS.f16352VA) {
                if (c4494rdtF3 == c4494rdtF2) {
                    c2209j5.f8856AZxh = true;
                }
                m10078mjFkc(c4494rdtF3, i, 0, c4494rdtF2, arrayList, c2209j5);
            }
            for (C4494rdtF c4494rdtF4 : abstractC2246Ja.f9003qdMbNW.f16352VA) {
                if (c4494rdtF4 == c4494rdtF2) {
                    c2209j5.f8856AZxh = true;
                }
                m10078mjFkc(c4494rdtF4, i, 1, c4494rdtF2, arrayList, c2209j5);
            }
            if (i == 1 && (abstractC2246Ja instanceof C2742R9)) {
                Iterator it = ((C2742R9) abstractC2246Ja).f10388ETF.f16352VA.iterator();
                while (it.hasNext()) {
                    m10078mjFkc((C4494rdtF) it.next(), i, 2, c4494rdtF2, arrayList, c2209j5);
                }
            }
        }
    }

    /* renamed from: qdMbNW */
    public final void m10079qdMbNW(AbstractC2246Ja abstractC2246Ja, int i, ArrayList arrayList) {
        for (InterfaceC2695QQi interfaceC2695QQi : abstractC2246Ja.f9001lgHUyS.f16349ETF) {
            if (interfaceC2695QQi instanceof C4494rdtF) {
                m10078mjFkc((C4494rdtF) interfaceC2695QQi, i, 0, abstractC2246Ja.f9003qdMbNW, arrayList, null);
            } else if (interfaceC2695QQi instanceof AbstractC2246Ja) {
                m10078mjFkc(((AbstractC2246Ja) interfaceC2695QQi).f9001lgHUyS, i, 0, abstractC2246Ja.f9003qdMbNW, arrayList, null);
            }
        }
        for (InterfaceC2695QQi interfaceC2695QQi2 : abstractC2246Ja.f9003qdMbNW.f16349ETF) {
            if (interfaceC2695QQi2 instanceof C4494rdtF) {
                m10078mjFkc((C4494rdtF) interfaceC2695QQi2, i, 1, abstractC2246Ja.f9001lgHUyS, arrayList, null);
            } else if (interfaceC2695QQi2 instanceof AbstractC2246Ja) {
                m10078mjFkc(((AbstractC2246Ja) interfaceC2695QQi2).f9003qdMbNW, i, 1, abstractC2246Ja.f9001lgHUyS, arrayList, null);
            }
        }
        if (i == 1) {
            for (InterfaceC2695QQi interfaceC2695QQi3 : ((C2742R9) abstractC2246Ja).f10388ETF.f16349ETF) {
                if (interfaceC2695QQi3 instanceof C4494rdtF) {
                    m10078mjFkc((C4494rdtF) interfaceC2695QQi3, i, 2, null, arrayList, null);
                }
            }
        }
    }

    /* renamed from: wA */
    public void m10080wA() {
        m10076ZfxDd(this.f10424KLFTb);
        this.f10428qdMbNW.clear();
        C2209J5.f8855lgHUyS = 0;
        m10079qdMbNW(this.f10427mjFkc.f13778KLFTb, 0, this.f10428qdMbNW);
        m10079qdMbNW(this.f10427mjFkc.f13774JHa, 1, this.f10428qdMbNW);
        this.f10422AZxh = false;
    }

    /* renamed from: xJ */
    public boolean m10081xJ(boolean z) {
        if (this.f10422AZxh) {
            Iterator it = this.f10427mjFkc.f8762tjSezt.iterator();
            while (it.hasNext()) {
                C3776gjvQ c3776gjvQ = (C3776gjvQ) it.next();
                c3776gjvQ.f13816mjFkc = false;
                C1597A c1597a = c3776gjvQ.f13778KLFTb;
                c1597a.f8999KLFTb.f16348Dt = false;
                c1597a.f9005xJ = false;
                c1597a.m7515IEE();
                C2742R9 c2742r9 = c3776gjvQ.f13774JHa;
                c2742r9.f8999KLFTb.f16348Dt = false;
                c2742r9.f9005xJ = false;
                c2742r9.m10056fehf();
            }
            C4052kw c4052kw = this.f10427mjFkc;
            c4052kw.f13816mjFkc = false;
            C1597A c1597a2 = c4052kw.f13778KLFTb;
            c1597a2.f8999KLFTb.f16348Dt = false;
            c1597a2.f9005xJ = false;
            c1597a2.m7515IEE();
            C2742R9 c2742r92 = this.f10427mjFkc.f13774JHa;
            c2742r92.f8999KLFTb.f16348Dt = false;
            c2742r92.f9005xJ = false;
            c2742r92.m10056fehf();
            m10080wA();
        }
        if (m10068AZxh(this.f10425ZfxDd)) {
            return false;
        }
        this.f10427mjFkc.m12093uH(0);
        this.f10427mjFkc.m12090tISON(0);
        this.f10427mjFkc.f13778KLFTb.f9001lgHUyS.mo7695ZfxDd(0);
        this.f10427mjFkc.f13774JHa.f9001lgHUyS.mo7695ZfxDd(0);
        return true;
    }
}
