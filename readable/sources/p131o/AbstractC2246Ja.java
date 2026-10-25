package p131o;

import p131o.C3776gjvQ;
import p131o.C4446qtZIjO;

/* renamed from: o.Ja */
/* loaded from: classes.dex */
public abstract class AbstractC2246Ja implements InterfaceC2695QQi {

    /* renamed from: AZxh */
    public C3776gjvQ f8996AZxh;

    /* renamed from: ZfxDd */
    public C3776gjvQ.AZxh f9000ZfxDd;

    /* renamed from: mjFkc */
    public int f9002mjFkc;

    /* renamed from: wA */
    public C2209J5 f9004wA;

    /* renamed from: KLFTb */
    public C1691BOPu f8999KLFTb = new C1691BOPu(this);

    /* renamed from: JHa */
    public int f8998JHa = 0;

    /* renamed from: xJ */
    public boolean f9005xJ = false;

    /* renamed from: lgHUyS */
    public C4494rdtF f9001lgHUyS = new C4494rdtF(this);

    /* renamed from: qdMbNW */
    public C4494rdtF f9003qdMbNW = new C4494rdtF(this);

    /* renamed from: Dt */
    public AZxh f8997Dt = AZxh.NONE;

    /* renamed from: o.Ja$AZxh */
    public enum AZxh {
        NONE,
        START,
        END,
        CENTER
    }

    /* renamed from: o.Ja$mjFkc */
    public static /* synthetic */ class mjFkc {

        /* renamed from: mjFkc */
        public static final /* synthetic */ int[] f9011mjFkc;

        static {
            int[] iArr = new int[C4446qtZIjO.AZxh.m13324values().length];
            f9011mjFkc = iArr;
            try {
                iArr[C4446qtZIjO.AZxh.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9011mjFkc[C4446qtZIjO.AZxh.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9011mjFkc[C4446qtZIjO.AZxh.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9011mjFkc[C4446qtZIjO.AZxh.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9011mjFkc[C4446qtZIjO.AZxh.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public AbstractC2246Ja(C3776gjvQ c3776gjvQ) {
        this.f8996AZxh = c3776gjvQ;
    }

    /* renamed from: AZxh */
    public final void m8988AZxh(C4494rdtF c4494rdtF, C4494rdtF c4494rdtF2, int i) {
        c4494rdtF.f16352VA.add(c4494rdtF2);
        c4494rdtF.f16350JHa = i;
        c4494rdtF2.f16349ETF.add(c4494rdtF);
    }

    /* renamed from: Dt */
    public long mo8123Dt() {
        if (this.f8999KLFTb.f16348Dt) {
            return r2.f16358xJ;
        }
        return 0L;
    }

    /* renamed from: ETF */
    public boolean m8989ETF() {
        return this.f9005xJ;
    }

    /* renamed from: JHa */
    public abstract void mo7516JHa();

    /* renamed from: KLFTb */
    public abstract void mo7517KLFTb();

    /* renamed from: MiMN */
    public abstract boolean mo7518MiMN();

    /* renamed from: VA */
    public final void m8990VA(int i, int i2) {
        int i3 = this.f9002mjFkc;
        if (i3 == 0) {
            this.f8999KLFTb.mo7695ZfxDd(m8997xJ(i2, i));
            return;
        }
        if (i3 == 1) {
            this.f8999KLFTb.mo7695ZfxDd(Math.min(m8997xJ(this.f8999KLFTb.f7478MiMN, i), i2));
            return;
        }
        if (i3 == 2) {
            C3776gjvQ c3776gjvQM12044Ne = this.f8996AZxh.m12044Ne();
            if (c3776gjvQM12044Ne != null) {
                if ((i == 0 ? c3776gjvQM12044Ne.f13778KLFTb : c3776gjvQM12044Ne.f13774JHa).f8999KLFTb.f16348Dt) {
                    C3776gjvQ c3776gjvQ = this.f8996AZxh;
                    this.f8999KLFTb.mo7695ZfxDd(m8997xJ((int) ((r9.f16358xJ * (i == 0 ? c3776gjvQ.f13809fehf : c3776gjvQ.f13806diqgf)) + 0.5f), i));
                    return;
                }
                return;
            }
            return;
        }
        if (i3 != 3) {
            return;
        }
        C3776gjvQ c3776gjvQ2 = this.f8996AZxh;
        AbstractC2246Ja abstractC2246Ja = c3776gjvQ2.f13778KLFTb;
        C3776gjvQ.AZxh aZxh = abstractC2246Ja.f9000ZfxDd;
        C3776gjvQ.AZxh aZxh2 = C3776gjvQ.AZxh.MATCH_CONSTRAINT;
        if (aZxh == aZxh2 && abstractC2246Ja.f9002mjFkc == 3) {
            C2742R9 c2742r9 = c3776gjvQ2.f13774JHa;
            if (c2742r9.f9000ZfxDd == aZxh2 && c2742r9.f9002mjFkc == 3) {
                return;
            }
        }
        if (i == 0) {
            abstractC2246Ja = c3776gjvQ2.f13774JHa;
        }
        if (abstractC2246Ja.f8999KLFTb.f16348Dt) {
            float fM12068diqgf = c3776gjvQ2.m12068diqgf();
            this.f8999KLFTb.mo7695ZfxDd(i == 1 ? (int) ((abstractC2246Ja.f8999KLFTb.f16358xJ / fM12068diqgf) + 0.5f) : (int) ((fM12068diqgf * abstractC2246Ja.f8999KLFTb.f16358xJ) + 0.5f));
        }
    }

    /* renamed from: YoKzxo */
    public void m8991YoKzxo(InterfaceC2695QQi interfaceC2695QQi, C4446qtZIjO c4446qtZIjO, C4446qtZIjO c4446qtZIjO2, int i) {
        C4494rdtF c4494rdtFM8992lgHUyS = m8992lgHUyS(c4446qtZIjO);
        C4494rdtF c4494rdtFM8992lgHUyS2 = m8992lgHUyS(c4446qtZIjO2);
        if (c4494rdtFM8992lgHUyS.f16348Dt && c4494rdtFM8992lgHUyS2.f16348Dt) {
            int iM13321wA = c4494rdtFM8992lgHUyS.f16358xJ + c4446qtZIjO.m13321wA();
            int iM13321wA2 = c4494rdtFM8992lgHUyS2.f16358xJ - c4446qtZIjO2.m13321wA();
            int i2 = iM13321wA2 - iM13321wA;
            if (!this.f8999KLFTb.f16348Dt && this.f9000ZfxDd == C3776gjvQ.AZxh.MATCH_CONSTRAINT) {
                m8990VA(i, i2);
            }
            C1691BOPu c1691BOPu = this.f8999KLFTb;
            if (c1691BOPu.f16348Dt) {
                if (c1691BOPu.f16358xJ == i2) {
                    this.f9001lgHUyS.mo7695ZfxDd(iM13321wA);
                    this.f9003qdMbNW.mo7695ZfxDd(iM13321wA2);
                    return;
                }
                C3776gjvQ c3776gjvQ = this.f8996AZxh;
                float fM12076huTpC = i == 0 ? c3776gjvQ.m12076huTpC() : c3776gjvQ.m12103zvd();
                if (c4494rdtFM8992lgHUyS == c4494rdtFM8992lgHUyS2) {
                    iM13321wA = c4494rdtFM8992lgHUyS.f16358xJ;
                    iM13321wA2 = c4494rdtFM8992lgHUyS2.f16358xJ;
                    fM12076huTpC = 0.5f;
                }
                this.f9001lgHUyS.mo7695ZfxDd((int) (iM13321wA + 0.5f + (((iM13321wA2 - iM13321wA) - this.f8999KLFTb.f16358xJ) * fM12076huTpC)));
                this.f9003qdMbNW.mo7695ZfxDd(this.f9001lgHUyS.f16358xJ + this.f8999KLFTb.f16358xJ);
            }
        }
    }

    /* renamed from: ZfxDd */
    public abstract void mo7519ZfxDd();

    /* renamed from: lgHUyS */
    public final C4494rdtF m8992lgHUyS(C4446qtZIjO c4446qtZIjO) {
        C4446qtZIjO c4446qtZIjO2 = c4446qtZIjO.f16248ZfxDd;
        if (c4446qtZIjO2 == null) {
            return null;
        }
        C3776gjvQ c3776gjvQ = c4446qtZIjO2.f16245AZxh;
        int i = mjFkc.f9011mjFkc[c4446qtZIjO2.f16250wA.ordinal()];
        if (i == 1) {
            return c3776gjvQ.f13778KLFTb.f9001lgHUyS;
        }
        if (i == 2) {
            return c3776gjvQ.f13778KLFTb.f9003qdMbNW;
        }
        if (i == 3) {
            return c3776gjvQ.f13774JHa.f9001lgHUyS;
        }
        if (i == 4) {
            return c3776gjvQ.f13774JHa.f10388ETF;
        }
        if (i != 5) {
            return null;
        }
        return c3776gjvQ.f13774JHa.f9003qdMbNW;
    }

    @Override // p131o.InterfaceC2695QQi
    /* renamed from: mjFkc */
    public abstract void mo7521mjFkc(InterfaceC2695QQi interfaceC2695QQi);

    /* renamed from: qGY */
    public void m8993qGY(InterfaceC2695QQi interfaceC2695QQi) {
    }

    /* renamed from: qdMbNW */
    public final C4494rdtF m8994qdMbNW(C4446qtZIjO c4446qtZIjO, int i) {
        C4446qtZIjO c4446qtZIjO2 = c4446qtZIjO.f16248ZfxDd;
        if (c4446qtZIjO2 == null) {
            return null;
        }
        C3776gjvQ c3776gjvQ = c4446qtZIjO2.f16245AZxh;
        AbstractC2246Ja abstractC2246Ja = i == 0 ? c3776gjvQ.f13778KLFTb : c3776gjvQ.f13774JHa;
        int i2 = mjFkc.f9011mjFkc[c4446qtZIjO2.f16250wA.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 5) {
                        return null;
                    }
                }
            }
            return abstractC2246Ja.f9003qdMbNW;
        }
        return abstractC2246Ja.f9001lgHUyS;
    }

    /* renamed from: rkYL */
    public void m8995rkYL(InterfaceC2695QQi interfaceC2695QQi) {
    }

    /* renamed from: wA */
    public final void m8996wA(C4494rdtF c4494rdtF, C4494rdtF c4494rdtF2, int i, C1691BOPu c1691BOPu) {
        c4494rdtF.f16352VA.add(c4494rdtF2);
        c4494rdtF.f16352VA.add(this.f8999KLFTb);
        c4494rdtF.f16354lgHUyS = i;
        c4494rdtF.f16356qdMbNW = c1691BOPu;
        c4494rdtF2.f16349ETF.add(c4494rdtF);
        c1691BOPu.f16349ETF.add(c4494rdtF);
    }

    /* renamed from: xJ */
    public final int m8997xJ(int i, int i2) {
        int iMax;
        if (i2 == 0) {
            C3776gjvQ c3776gjvQ = this.f8996AZxh;
            int i3 = c3776gjvQ.f13819qGY;
            iMax = Math.max(c3776gjvQ.f13822rkYL, i);
            if (i3 > 0) {
                iMax = Math.min(i3, i);
            }
            if (iMax == i) {
                return i;
            }
        } else {
            C3776gjvQ c3776gjvQ2 = this.f8996AZxh;
            int i4 = c3776gjvQ2.f13787Pq;
            iMax = Math.max(c3776gjvQ2.f13771IEE, i);
            if (i4 > 0) {
                iMax = Math.min(i4, i);
            }
            if (iMax == i) {
                return i;
            }
        }
        return iMax;
    }
}
