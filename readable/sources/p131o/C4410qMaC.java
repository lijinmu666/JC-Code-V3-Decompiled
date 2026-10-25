package p131o;

import java.util.ArrayList;
import java.util.Arrays;
import p131o.C3776gjvQ;

/* renamed from: o.qMaC */
/* loaded from: classes.dex */
public class C4410qMaC extends AbstractC1832Da {

    /* renamed from: Jidt */
    public C3776gjvQ[] f16150Jidt;

    /* renamed from: XD */
    public int f16156XD = -1;

    /* renamed from: gtr */
    public int f16165gtr = -1;

    /* renamed from: Dp */
    public int f16146Dp = -1;

    /* renamed from: fLidf */
    public int f16164fLidf = -1;

    /* renamed from: hvGY */
    public int f16166hvGY = -1;

    /* renamed from: Rc */
    public int f16154Rc = -1;

    /* renamed from: SKTn */
    public float f16155SKTn = 0.5f;

    /* renamed from: rdJr */
    public float f16169rdJr = 0.5f;

    /* renamed from: XDdeP */
    public float f16157XDdeP = 0.5f;

    /* renamed from: eQ */
    public float f16163eQ = 0.5f;

    /* renamed from: FbxKQm */
    public float f16147FbxKQm = 0.5f;

    /* renamed from: jtz */
    public float f16167jtz = 0.5f;

    /* renamed from: XgAT */
    public int f16158XgAT = 0;

    /* renamed from: IyS */
    public int f16149IyS = 0;

    /* renamed from: tAfC */
    public int f16170tAfC = 2;

    /* renamed from: dGDT */
    public int f16161dGDT = 2;

    /* renamed from: Xxz */
    public int f16159Xxz = 0;

    /* renamed from: Zdbk */
    public int f16160Zdbk = -1;

    /* renamed from: Jk */
    public int f16151Jk = 0;

    /* renamed from: KRckQg */
    public ArrayList f16152KRckQg = new ArrayList();

    /* renamed from: mPWV */
    public C3776gjvQ[] f16168mPWV = null;

    /* renamed from: dkKKW */
    public C3776gjvQ[] f16162dkKKW = null;

    /* renamed from: NV */
    public int[] f16153NV = null;

    /* renamed from: IvRQOa */
    public int f16148IvRQOa = 0;

    /* renamed from: o.qMaC$mjFkc */
    public class mjFkc {

        /* renamed from: Dt */
        public int f16172Dt;

        /* renamed from: ETF */
        public int f16173ETF;

        /* renamed from: JHa */
        public C4446qtZIjO f16175JHa;

        /* renamed from: KLFTb */
        public C4446qtZIjO f16176KLFTb;

        /* renamed from: ZfxDd */
        public C4446qtZIjO f16180ZfxDd;

        /* renamed from: fehf */
        public int f16181fehf;

        /* renamed from: lgHUyS */
        public int f16182lgHUyS;

        /* renamed from: mjFkc */
        public int f16183mjFkc;

        /* renamed from: qdMbNW */
        public int f16185qdMbNW;

        /* renamed from: xJ */
        public C4446qtZIjO f16188xJ;

        /* renamed from: AZxh */
        public C3776gjvQ f16171AZxh = null;

        /* renamed from: wA */
        public int f16187wA = 0;

        /* renamed from: VA */
        public int f16178VA = 0;

        /* renamed from: MiMN */
        public int f16177MiMN = 0;

        /* renamed from: YoKzxo */
        public int f16179YoKzxo = 0;

        /* renamed from: rkYL */
        public int f16186rkYL = 0;

        /* renamed from: qGY */
        public int f16184qGY = 0;

        public mjFkc(int i, C4446qtZIjO c4446qtZIjO, C4446qtZIjO c4446qtZIjO2, C4446qtZIjO c4446qtZIjO3, C4446qtZIjO c4446qtZIjO4, int i2) {
            this.f16182lgHUyS = 0;
            this.f16185qdMbNW = 0;
            this.f16172Dt = 0;
            this.f16173ETF = 0;
            this.f16181fehf = 0;
            this.f16183mjFkc = i;
            this.f16180ZfxDd = c4446qtZIjO;
            this.f16176KLFTb = c4446qtZIjO2;
            this.f16175JHa = c4446qtZIjO3;
            this.f16188xJ = c4446qtZIjO4;
            this.f16182lgHUyS = C4410qMaC.this.m8017hvGY();
            this.f16185qdMbNW = C4410qMaC.this.m8007SKTn();
            this.f16172Dt = C4410qMaC.this.m8006Rc();
            this.f16173ETF = C4410qMaC.this.m8015fLidf();
            this.f16181fehf = i2;
        }

        /* renamed from: AZxh */
        public void m13255AZxh(C3776gjvQ c3776gjvQ) {
            if (this.f16183mjFkc == 0) {
                int iM13238QyqF = C4410qMaC.this.m13238QyqF(c3776gjvQ, this.f16181fehf);
                if (c3776gjvQ.m12030HGpJ() == C3776gjvQ.AZxh.MATCH_CONSTRAINT) {
                    this.f16184qGY++;
                    iM13238QyqF = 0;
                }
                this.f16178VA += iM13238QyqF + (c3776gjvQ.m12043NPj() != 8 ? C4410qMaC.this.f16158XgAT : 0);
                int iM13239Tw = C4410qMaC.this.m13239Tw(c3776gjvQ, this.f16181fehf);
                if (this.f16171AZxh == null || this.f16187wA < iM13239Tw) {
                    this.f16171AZxh = c3776gjvQ;
                    this.f16187wA = iM13239Tw;
                    this.f16177MiMN = iM13239Tw;
                }
            } else {
                int iM13238QyqF2 = C4410qMaC.this.m13238QyqF(c3776gjvQ, this.f16181fehf);
                int iM13239Tw2 = C4410qMaC.this.m13239Tw(c3776gjvQ, this.f16181fehf);
                if (c3776gjvQ.m12088rWxwaT() == C3776gjvQ.AZxh.MATCH_CONSTRAINT) {
                    this.f16184qGY++;
                    iM13239Tw2 = 0;
                }
                this.f16177MiMN += iM13239Tw2 + (c3776gjvQ.m12043NPj() != 8 ? C4410qMaC.this.f16149IyS : 0);
                if (this.f16171AZxh == null || this.f16187wA < iM13238QyqF2) {
                    this.f16171AZxh = c3776gjvQ;
                    this.f16187wA = iM13238QyqF2;
                    this.f16178VA = iM13238QyqF2;
                }
            }
            this.f16186rkYL++;
        }

        /* renamed from: Dt */
        public void m13256Dt(int i, C4446qtZIjO c4446qtZIjO, C4446qtZIjO c4446qtZIjO2, C4446qtZIjO c4446qtZIjO3, C4446qtZIjO c4446qtZIjO4, int i2, int i3, int i4, int i5, int i6) {
            this.f16183mjFkc = i;
            this.f16180ZfxDd = c4446qtZIjO;
            this.f16176KLFTb = c4446qtZIjO2;
            this.f16175JHa = c4446qtZIjO3;
            this.f16188xJ = c4446qtZIjO4;
            this.f16182lgHUyS = i2;
            this.f16185qdMbNW = i3;
            this.f16172Dt = i4;
            this.f16173ETF = i5;
            this.f16181fehf = i6;
        }

        /* renamed from: JHa */
        public int m13257JHa() {
            return this.f16183mjFkc == 0 ? this.f16178VA - C4410qMaC.this.f16158XgAT : this.f16178VA;
        }

        /* renamed from: KLFTb */
        public int m13258KLFTb() {
            return this.f16183mjFkc == 1 ? this.f16177MiMN - C4410qMaC.this.f16149IyS : this.f16177MiMN;
        }

        /* renamed from: ZfxDd */
        public void m13259ZfxDd(boolean z, int i, boolean z2) {
            C3776gjvQ c3776gjvQ;
            char c;
            int i2 = this.f16186rkYL;
            for (int i3 = 0; i3 < i2 && this.f16179YoKzxo + i3 < C4410qMaC.this.f16148IvRQOa; i3++) {
                C3776gjvQ c3776gjvQ2 = C4410qMaC.this.f16150Jidt[this.f16179YoKzxo + i3];
                if (c3776gjvQ2 != null) {
                    c3776gjvQ2.m12084nxI();
                }
            }
            if (i2 == 0 || this.f16171AZxh == null) {
                return;
            }
            boolean z3 = z2 && i == 0;
            int i4 = -1;
            int i5 = -1;
            for (int i6 = 0; i6 < i2; i6++) {
                int i7 = z ? (i2 - 1) - i6 : i6;
                if (this.f16179YoKzxo + i7 >= C4410qMaC.this.f16148IvRQOa) {
                    break;
                }
                if (C4410qMaC.this.f16150Jidt[this.f16179YoKzxo + i7].m12043NPj() == 0) {
                    if (i4 == -1) {
                        i4 = i6;
                    }
                    i5 = i6;
                }
            }
            C3776gjvQ c3776gjvQ3 = null;
            if (this.f16183mjFkc != 0) {
                C3776gjvQ c3776gjvQ4 = this.f16171AZxh;
                c3776gjvQ4.m12069dm(C4410qMaC.this.f16156XD);
                int i8 = this.f16182lgHUyS;
                if (i > 0) {
                    i8 += C4410qMaC.this.f16158XgAT;
                }
                if (z) {
                    c3776gjvQ4.f13829wJVbdd.m13319mjFkc(this.f16175JHa, i8);
                    if (z2) {
                        c3776gjvQ4.f13764BAnRFn.m13319mjFkc(this.f16180ZfxDd, this.f16172Dt);
                    }
                    if (i > 0) {
                        this.f16175JHa.f16245AZxh.f13764BAnRFn.m13319mjFkc(c3776gjvQ4.f13829wJVbdd, 0);
                    }
                } else {
                    c3776gjvQ4.f13764BAnRFn.m13319mjFkc(this.f16180ZfxDd, i8);
                    if (z2) {
                        c3776gjvQ4.f13829wJVbdd.m13319mjFkc(this.f16175JHa, this.f16172Dt);
                    }
                    if (i > 0) {
                        this.f16180ZfxDd.f16245AZxh.f13829wJVbdd.m13319mjFkc(c3776gjvQ4.f13764BAnRFn, 0);
                    }
                }
                int i9 = 0;
                while (i9 < i2 && this.f16179YoKzxo + i9 < C4410qMaC.this.f16148IvRQOa) {
                    C3776gjvQ c3776gjvQ5 = C4410qMaC.this.f16150Jidt[this.f16179YoKzxo + i9];
                    if (i9 == 0) {
                        c3776gjvQ5.m12026Dt(c3776gjvQ5.f13813lB, this.f16176KLFTb, this.f16185qdMbNW);
                        int i10 = C4410qMaC.this.f16165gtr;
                        float f = C4410qMaC.this.f16169rdJr;
                        if (this.f16179YoKzxo == 0 && C4410qMaC.this.f16164fLidf != -1) {
                            i10 = C4410qMaC.this.f16164fLidf;
                            f = C4410qMaC.this.f16163eQ;
                        } else if (z2 && C4410qMaC.this.f16154Rc != -1) {
                            i10 = C4410qMaC.this.f16154Rc;
                            f = C4410qMaC.this.f16167jtz;
                        }
                        c3776gjvQ5.m12073gYa(i10);
                        c3776gjvQ5.m12101yX(f);
                    }
                    if (i9 == i2 - 1) {
                        c3776gjvQ5.m12026Dt(c3776gjvQ5.f13815mByQ, this.f16188xJ, this.f16173ETF);
                    }
                    if (c3776gjvQ3 != null) {
                        c3776gjvQ5.f13813lB.m13319mjFkc(c3776gjvQ3.f13815mByQ, C4410qMaC.this.f16149IyS);
                        if (i9 == i4) {
                            c3776gjvQ5.f13813lB.m13316YoKzxo(this.f16185qdMbNW);
                        }
                        c3776gjvQ3.f13815mByQ.m13319mjFkc(c3776gjvQ5.f13813lB, 0);
                        if (i9 == i5 + 1) {
                            c3776gjvQ3.f13815mByQ.m13316YoKzxo(this.f16173ETF);
                        }
                    }
                    if (c3776gjvQ5 != c3776gjvQ4) {
                        if (z) {
                            int i11 = C4410qMaC.this.f16170tAfC;
                            if (i11 == 0) {
                                c3776gjvQ5.f13829wJVbdd.m13319mjFkc(c3776gjvQ4.f13829wJVbdd, 0);
                            } else if (i11 == 1) {
                                c3776gjvQ5.f13764BAnRFn.m13319mjFkc(c3776gjvQ4.f13764BAnRFn, 0);
                            } else if (i11 == 2) {
                                c3776gjvQ5.f13764BAnRFn.m13319mjFkc(c3776gjvQ4.f13764BAnRFn, 0);
                                c3776gjvQ5.f13829wJVbdd.m13319mjFkc(c3776gjvQ4.f13829wJVbdd, 0);
                            }
                        } else {
                            int i12 = C4410qMaC.this.f16170tAfC;
                            if (i12 == 0) {
                                c3776gjvQ5.f13764BAnRFn.m13319mjFkc(c3776gjvQ4.f13764BAnRFn, 0);
                            } else if (i12 == 1) {
                                c3776gjvQ5.f13829wJVbdd.m13319mjFkc(c3776gjvQ4.f13829wJVbdd, 0);
                            } else if (i12 == 2) {
                                if (z3) {
                                    c3776gjvQ5.f13764BAnRFn.m13319mjFkc(this.f16180ZfxDd, this.f16182lgHUyS);
                                    c3776gjvQ5.f13829wJVbdd.m13319mjFkc(this.f16175JHa, this.f16172Dt);
                                } else {
                                    c3776gjvQ5.f13764BAnRFn.m13319mjFkc(c3776gjvQ4.f13764BAnRFn, 0);
                                    c3776gjvQ5.f13829wJVbdd.m13319mjFkc(c3776gjvQ4.f13829wJVbdd, 0);
                                }
                            }
                        }
                    }
                    i9++;
                    c3776gjvQ3 = c3776gjvQ5;
                }
                return;
            }
            C3776gjvQ c3776gjvQ6 = this.f16171AZxh;
            c3776gjvQ6.m12073gYa(C4410qMaC.this.f16165gtr);
            int i13 = this.f16185qdMbNW;
            if (i > 0) {
                i13 += C4410qMaC.this.f16149IyS;
            }
            c3776gjvQ6.f13813lB.m13319mjFkc(this.f16176KLFTb, i13);
            if (z2) {
                c3776gjvQ6.f13815mByQ.m13319mjFkc(this.f16188xJ, this.f16173ETF);
            }
            if (i > 0) {
                this.f16176KLFTb.f16245AZxh.f13815mByQ.m13319mjFkc(c3776gjvQ6.f13813lB, 0);
            }
            if (C4410qMaC.this.f16161dGDT != 3 || c3776gjvQ6.m12057WrLQs()) {
                c3776gjvQ = c3776gjvQ6;
            } else {
                for (int i14 = 0; i14 < i2; i14++) {
                    int i15 = z ? (i2 - 1) - i14 : i14;
                    if (this.f16179YoKzxo + i15 >= C4410qMaC.this.f16148IvRQOa) {
                        break;
                    }
                    c3776gjvQ = C4410qMaC.this.f16150Jidt[this.f16179YoKzxo + i15];
                    if (c3776gjvQ.m12057WrLQs()) {
                        break;
                    }
                }
                c3776gjvQ = c3776gjvQ6;
            }
            int i16 = 0;
            while (i16 < i2) {
                int i17 = z ? (i2 - 1) - i16 : i16;
                if (this.f16179YoKzxo + i17 >= C4410qMaC.this.f16148IvRQOa) {
                    return;
                }
                C3776gjvQ c3776gjvQ7 = C4410qMaC.this.f16150Jidt[this.f16179YoKzxo + i17];
                if (i16 == 0) {
                    c3776gjvQ7.m12026Dt(c3776gjvQ7.f13764BAnRFn, this.f16180ZfxDd, this.f16182lgHUyS);
                }
                if (i17 == 0) {
                    int i18 = C4410qMaC.this.f16156XD;
                    float f2 = C4410qMaC.this.f16155SKTn;
                    if (this.f16179YoKzxo == 0 && C4410qMaC.this.f16146Dp != -1) {
                        i18 = C4410qMaC.this.f16146Dp;
                        f2 = C4410qMaC.this.f16157XDdeP;
                    } else if (z2 && C4410qMaC.this.f16166hvGY != -1) {
                        i18 = C4410qMaC.this.f16166hvGY;
                        f2 = C4410qMaC.this.f16147FbxKQm;
                    }
                    c3776gjvQ7.m12069dm(i18);
                    c3776gjvQ7.m12064alEkx(f2);
                }
                if (i16 == i2 - 1) {
                    c3776gjvQ7.m12026Dt(c3776gjvQ7.f13829wJVbdd, this.f16175JHa, this.f16172Dt);
                }
                if (c3776gjvQ3 != null) {
                    c3776gjvQ7.f13764BAnRFn.m13319mjFkc(c3776gjvQ3.f13829wJVbdd, C4410qMaC.this.f16158XgAT);
                    if (i16 == i4) {
                        c3776gjvQ7.f13764BAnRFn.m13316YoKzxo(this.f16182lgHUyS);
                    }
                    c3776gjvQ3.f13829wJVbdd.m13319mjFkc(c3776gjvQ7.f13764BAnRFn, 0);
                    if (i16 == i5 + 1) {
                        c3776gjvQ3.f13829wJVbdd.m13316YoKzxo(this.f16172Dt);
                    }
                }
                if (c3776gjvQ7 != c3776gjvQ6) {
                    c = 3;
                    if (C4410qMaC.this.f16161dGDT == 3 && c3776gjvQ.m12057WrLQs() && c3776gjvQ7 != c3776gjvQ && c3776gjvQ7.m12057WrLQs()) {
                        c3776gjvQ7.f13786OjSQV.m13319mjFkc(c3776gjvQ.f13786OjSQV, 0);
                    } else {
                        int i19 = C4410qMaC.this.f16161dGDT;
                        if (i19 == 0) {
                            c3776gjvQ7.f13813lB.m13319mjFkc(c3776gjvQ6.f13813lB, 0);
                        } else if (i19 == 1) {
                            c3776gjvQ7.f13815mByQ.m13319mjFkc(c3776gjvQ6.f13815mByQ, 0);
                        } else if (z3) {
                            c3776gjvQ7.f13813lB.m13319mjFkc(this.f16176KLFTb, this.f16185qdMbNW);
                            c3776gjvQ7.f13815mByQ.m13319mjFkc(this.f16188xJ, this.f16173ETF);
                        } else {
                            c3776gjvQ7.f13813lB.m13319mjFkc(c3776gjvQ6.f13813lB, 0);
                            c3776gjvQ7.f13815mByQ.m13319mjFkc(c3776gjvQ6.f13815mByQ, 0);
                        }
                    }
                } else {
                    c = 3;
                }
                i16++;
                c3776gjvQ3 = c3776gjvQ7;
            }
        }

        /* renamed from: lgHUyS */
        public final void m13260lgHUyS() {
            this.f16178VA = 0;
            this.f16177MiMN = 0;
            this.f16171AZxh = null;
            this.f16187wA = 0;
            int i = this.f16186rkYL;
            for (int i2 = 0; i2 < i && this.f16179YoKzxo + i2 < C4410qMaC.this.f16148IvRQOa; i2++) {
                C3776gjvQ c3776gjvQ = C4410qMaC.this.f16150Jidt[this.f16179YoKzxo + i2];
                if (this.f16183mjFkc == 0) {
                    int iM12096vadzgd = c3776gjvQ.m12096vadzgd();
                    int i3 = C4410qMaC.this.f16158XgAT;
                    if (c3776gjvQ.m12043NPj() == 8) {
                        i3 = 0;
                    }
                    this.f16178VA += iM12096vadzgd + i3;
                    int iM13239Tw = C4410qMaC.this.m13239Tw(c3776gjvQ, this.f16181fehf);
                    if (this.f16171AZxh == null || this.f16187wA < iM13239Tw) {
                        this.f16171AZxh = c3776gjvQ;
                        this.f16187wA = iM13239Tw;
                        this.f16177MiMN = iM13239Tw;
                    }
                } else {
                    int iM13238QyqF = C4410qMaC.this.m13238QyqF(c3776gjvQ, this.f16181fehf);
                    int iM13239Tw2 = C4410qMaC.this.m13239Tw(c3776gjvQ, this.f16181fehf);
                    int i4 = C4410qMaC.this.f16149IyS;
                    if (c3776gjvQ.m12043NPj() == 8) {
                        i4 = 0;
                    }
                    this.f16177MiMN += iM13239Tw2 + i4;
                    if (this.f16171AZxh == null || this.f16187wA < iM13238QyqF) {
                        this.f16171AZxh = c3776gjvQ;
                        this.f16187wA = iM13238QyqF;
                        this.f16178VA = iM13238QyqF;
                    }
                }
            }
        }

        /* renamed from: qdMbNW */
        public void m13261qdMbNW(int i) {
            this.f16179YoKzxo = i;
        }

        /* renamed from: wA */
        public void m13262wA() {
            this.f16187wA = 0;
            this.f16171AZxh = null;
            this.f16178VA = 0;
            this.f16177MiMN = 0;
            this.f16179YoKzxo = 0;
            this.f16186rkYL = 0;
            this.f16184qGY = 0;
        }

        /* renamed from: xJ */
        public void m13263xJ(int i) {
            int i2 = this.f16184qGY;
            if (i2 == 0) {
                return;
            }
            int i3 = this.f16186rkYL;
            int i4 = i / i2;
            for (int i5 = 0; i5 < i3 && this.f16179YoKzxo + i5 < C4410qMaC.this.f16148IvRQOa; i5++) {
                C3776gjvQ c3776gjvQ = C4410qMaC.this.f16150Jidt[this.f16179YoKzxo + i5];
                if (this.f16183mjFkc == 0) {
                    if (c3776gjvQ != null && c3776gjvQ.m12030HGpJ() == C3776gjvQ.AZxh.MATCH_CONSTRAINT && c3776gjvQ.f13793VA == 0) {
                        C4410qMaC.this.m8009XDdeP(c3776gjvQ, C3776gjvQ.AZxh.FIXED, i4, c3776gjvQ.m12088rWxwaT(), c3776gjvQ.m12051Ucbh());
                    }
                } else if (c3776gjvQ != null && c3776gjvQ.m12088rWxwaT() == C3776gjvQ.AZxh.MATCH_CONSTRAINT && c3776gjvQ.f13781MiMN == 0) {
                    C4410qMaC.this.m8009XDdeP(c3776gjvQ, c3776gjvQ.m12030HGpJ(), c3776gjvQ.m12096vadzgd(), C3776gjvQ.AZxh.FIXED, i4);
                }
            }
            m13260lgHUyS();
        }
    }

    /* renamed from: BxruE */
    public final void m13229BxruE(boolean z) {
        C3776gjvQ c3776gjvQ;
        if (this.f16153NV == null || this.f16162dkKKW == null || this.f16168mPWV == null) {
            return;
        }
        for (int i = 0; i < this.f16148IvRQOa; i++) {
            this.f16150Jidt[i].m12084nxI();
        }
        int[] iArr = this.f16153NV;
        int i2 = iArr[0];
        int i3 = iArr[1];
        C3776gjvQ c3776gjvQ2 = null;
        for (int i4 = 0; i4 < i2; i4++) {
            C3776gjvQ c3776gjvQ3 = this.f16162dkKKW[z ? (i2 - i4) - 1 : i4];
            if (c3776gjvQ3 != null && c3776gjvQ3.m12043NPj() != 8) {
                if (i4 == 0) {
                    c3776gjvQ3.m12026Dt(c3776gjvQ3.f13764BAnRFn, this.f13764BAnRFn, m8017hvGY());
                    c3776gjvQ3.m12069dm(this.f16156XD);
                    c3776gjvQ3.m12064alEkx(this.f16155SKTn);
                }
                if (i4 == i2 - 1) {
                    c3776gjvQ3.m12026Dt(c3776gjvQ3.f13829wJVbdd, this.f13829wJVbdd, m8006Rc());
                }
                if (i4 > 0) {
                    c3776gjvQ3.m12026Dt(c3776gjvQ3.f13764BAnRFn, c3776gjvQ2.f13829wJVbdd, this.f16158XgAT);
                    c3776gjvQ2.m12026Dt(c3776gjvQ2.f13829wJVbdd, c3776gjvQ3.f13764BAnRFn, 0);
                }
                c3776gjvQ2 = c3776gjvQ3;
            }
        }
        for (int i5 = 0; i5 < i3; i5++) {
            C3776gjvQ c3776gjvQ4 = this.f16168mPWV[i5];
            if (c3776gjvQ4 != null && c3776gjvQ4.m12043NPj() != 8) {
                if (i5 == 0) {
                    c3776gjvQ4.m12026Dt(c3776gjvQ4.f13813lB, this.f13813lB, m8007SKTn());
                    c3776gjvQ4.m12073gYa(this.f16165gtr);
                    c3776gjvQ4.m12101yX(this.f16169rdJr);
                }
                if (i5 == i3 - 1) {
                    c3776gjvQ4.m12026Dt(c3776gjvQ4.f13815mByQ, this.f13815mByQ, m8015fLidf());
                }
                if (i5 > 0) {
                    c3776gjvQ4.m12026Dt(c3776gjvQ4.f13813lB, c3776gjvQ2.f13815mByQ, this.f16149IyS);
                    c3776gjvQ2.m12026Dt(c3776gjvQ2.f13815mByQ, c3776gjvQ4.f13813lB, 0);
                }
                c3776gjvQ2 = c3776gjvQ4;
            }
        }
        for (int i6 = 0; i6 < i2; i6++) {
            for (int i7 = 0; i7 < i3; i7++) {
                int i8 = (i7 * i2) + i6;
                if (this.f16151Jk == 1) {
                    i8 = (i6 * i3) + i7;
                }
                C3776gjvQ[] c3776gjvQArr = this.f16150Jidt;
                if (i8 < c3776gjvQArr.length && (c3776gjvQ = c3776gjvQArr[i8]) != null && c3776gjvQ.m12043NPj() != 8) {
                    C3776gjvQ c3776gjvQ5 = this.f16162dkKKW[i6];
                    C3776gjvQ c3776gjvQ6 = this.f16168mPWV[i7];
                    if (c3776gjvQ != c3776gjvQ5) {
                        c3776gjvQ.m12026Dt(c3776gjvQ.f13764BAnRFn, c3776gjvQ5.f13764BAnRFn, 0);
                        c3776gjvQ.m12026Dt(c3776gjvQ.f13829wJVbdd, c3776gjvQ5.f13829wJVbdd, 0);
                    }
                    if (c3776gjvQ != c3776gjvQ6) {
                        c3776gjvQ.m12026Dt(c3776gjvQ.f13813lB, c3776gjvQ6.f13813lB, 0);
                        c3776gjvQ.m12026Dt(c3776gjvQ.f13815mByQ, c3776gjvQ6.f13815mByQ, 0);
                    }
                }
            }
        }
    }

    /* renamed from: CcoH */
    public void m13230CcoH(int i) {
        this.f16159Xxz = i;
    }

    /* renamed from: ERt */
    public void m13231ERt(int i) {
        this.f16166hvGY = i;
    }

    /* renamed from: FOJ */
    public void m13232FOJ(float f) {
        this.f16147FbxKQm = f;
    }

    /* renamed from: HExgdj */
    public void m13233HExgdj(int i) {
        this.f16161dGDT = i;
    }

    @Override // p131o.C3776gjvQ
    /* renamed from: JHa */
    public void mo9028JHa(C3202Y0 c3202y0) {
        super.mo9028JHa(c3202y0);
        boolean zM12623dGDT = m12044Ne() != null ? ((C4052kw) m12044Ne()).m12623dGDT() : false;
        int i = this.f16159Xxz;
        if (i != 0) {
            if (i == 1) {
                int size = this.f16152KRckQg.size();
                int i2 = 0;
                while (i2 < size) {
                    ((mjFkc) this.f16152KRckQg.get(i2)).m13259ZfxDd(zM12623dGDT, i2, i2 == size + (-1));
                    i2++;
                }
            } else if (i == 2) {
                m13229BxruE(zM12623dGDT);
            }
        } else if (this.f16152KRckQg.size() > 0) {
            ((mjFkc) this.f16152KRckQg.get(0)).m13259ZfxDd(zM12623dGDT, 0, true);
        }
        m8018jtz(false);
    }

    /* renamed from: JOe */
    public void m13234JOe(float f) {
        this.f16167jtz = f;
    }

    /* renamed from: KSf */
    public void m13235KSf(float f) {
        this.f16169rdJr = f;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x005e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x010d -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:106:0x010f -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:108:0x0115 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x0117 -> B:42:0x0059). Please report as a decompilation issue!!! */
    /* renamed from: LsBneK */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m13236LsBneK(C3776gjvQ[] c3776gjvQArr, int i, int i2, int i3, int[] iArr) {
        int iCeil;
        int iCeil2;
        C3776gjvQ c3776gjvQ;
        if (i2 == 0) {
            int i4 = this.f16160Zdbk;
            if (i4 <= 0) {
                i4 = 0;
                int iM13238QyqF = 0;
                for (int i5 = 0; i5 < i; i5++) {
                    if (i5 > 0) {
                        iM13238QyqF += this.f16158XgAT;
                    }
                    C3776gjvQ c3776gjvQ2 = c3776gjvQArr[i5];
                    if (c3776gjvQ2 != null) {
                        iM13238QyqF += m13238QyqF(c3776gjvQ2, i3);
                        if (iM13238QyqF > i3) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                }
            }
            iCeil2 = i4;
            iCeil = 0;
        } else {
            iCeil = this.f16160Zdbk;
            if (iCeil <= 0) {
                iCeil = 0;
                int iM13239Tw = 0;
                for (int i6 = 0; i6 < i; i6++) {
                    if (i6 > 0) {
                        iM13239Tw += this.f16149IyS;
                    }
                    C3776gjvQ c3776gjvQ3 = c3776gjvQArr[i6];
                    if (c3776gjvQ3 != null) {
                        iM13239Tw += m13239Tw(c3776gjvQ3, i3);
                        if (iM13239Tw > i3) {
                            break;
                        } else {
                            iCeil++;
                        }
                    }
                }
            }
            iCeil2 = 0;
        }
        if (this.f16153NV == null) {
            this.f16153NV = new int[2];
        }
        boolean z = (iCeil == 0 && i2 == 1) || (iCeil2 == 0 && i2 == 0);
        while (!z) {
            if (i2 == 0) {
                iCeil = (int) Math.ceil(i / iCeil2);
            } else {
                iCeil2 = (int) Math.ceil(i / iCeil);
            }
            C3776gjvQ[] c3776gjvQArr2 = this.f16162dkKKW;
            if (c3776gjvQArr2 == null || c3776gjvQArr2.length < iCeil2) {
                this.f16162dkKKW = new C3776gjvQ[iCeil2];
            } else {
                Arrays.fill(c3776gjvQArr2, (Object) null);
            }
            C3776gjvQ[] c3776gjvQArr3 = this.f16168mPWV;
            if (c3776gjvQArr3 == null || c3776gjvQArr3.length < iCeil) {
                this.f16168mPWV = new C3776gjvQ[iCeil];
            } else {
                Arrays.fill(c3776gjvQArr3, (Object) null);
            }
            for (int i7 = 0; i7 < iCeil2; i7++) {
                for (int i8 = 0; i8 < iCeil; i8++) {
                    int i9 = (i8 * iCeil2) + i7;
                    if (i2 == 1) {
                        i9 = (i7 * iCeil) + i8;
                    }
                    if (i9 < c3776gjvQArr.length && (c3776gjvQ = c3776gjvQArr[i9]) != null) {
                        int iM13238QyqF2 = m13238QyqF(c3776gjvQ, i3);
                        C3776gjvQ c3776gjvQ4 = this.f16162dkKKW[i7];
                        if (c3776gjvQ4 == null || c3776gjvQ4.m12096vadzgd() < iM13238QyqF2) {
                            this.f16162dkKKW[i7] = c3776gjvQ;
                        }
                        int iM13239Tw2 = m13239Tw(c3776gjvQ, i3);
                        C3776gjvQ c3776gjvQ5 = this.f16168mPWV[i8];
                        if (c3776gjvQ5 == null || c3776gjvQ5.m12051Ucbh() < iM13239Tw2) {
                            this.f16168mPWV[i8] = c3776gjvQ;
                        }
                    }
                }
            }
            int iM13238QyqF3 = 0;
            for (int i10 = 0; i10 < iCeil2; i10++) {
                C3776gjvQ c3776gjvQ6 = this.f16162dkKKW[i10];
                if (c3776gjvQ6 != null) {
                    if (i10 > 0) {
                        iM13238QyqF3 += this.f16158XgAT;
                    }
                    iM13238QyqF3 += m13238QyqF(c3776gjvQ6, i3);
                }
            }
            int iM13239Tw3 = 0;
            for (int i11 = 0; i11 < iCeil; i11++) {
                C3776gjvQ c3776gjvQ7 = this.f16168mPWV[i11];
                if (c3776gjvQ7 != null) {
                    if (i11 > 0) {
                        iM13239Tw3 += this.f16149IyS;
                    }
                    iM13239Tw3 += m13239Tw(c3776gjvQ7, i3);
                }
            }
            iArr[0] = iM13238QyqF3;
            iArr[1] = iM13239Tw3;
            if (i2 != 0) {
                if (iM13239Tw3 > i3 && iCeil > 1) {
                    iCeil--;
                }
            } else if (iM13238QyqF3 > i3 && iCeil2 > 1) {
                iCeil2--;
            }
            while (!z) {
            }
        }
        int[] iArr2 = this.f16153NV;
        iArr2[0] = iCeil2;
        iArr2[1] = iCeil;
    }

    /* renamed from: QyMqpM */
    public void m13237QyMqpM(int i) {
        this.f16151Jk = i;
    }

    /* renamed from: QyqF */
    public final int m13238QyqF(C3776gjvQ c3776gjvQ, int i) {
        if (c3776gjvQ == null) {
            return 0;
        }
        if (c3776gjvQ.m12030HGpJ() == C3776gjvQ.AZxh.MATCH_CONSTRAINT) {
            int i2 = c3776gjvQ.f13793VA;
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 2) {
                int i3 = (int) (c3776gjvQ.f13809fehf * i);
                if (i3 != c3776gjvQ.m12096vadzgd()) {
                    m8009XDdeP(c3776gjvQ, C3776gjvQ.AZxh.FIXED, i3, c3776gjvQ.m12088rWxwaT(), c3776gjvQ.m12051Ucbh());
                }
                return i3;
            }
            if (i2 == 1) {
                return c3776gjvQ.m12096vadzgd();
            }
            if (i2 == 3) {
                return (int) ((c3776gjvQ.m12051Ucbh() * c3776gjvQ.f13818oCFDzJ) + 0.5f);
            }
        }
        return c3776gjvQ.m12096vadzgd();
    }

    /* renamed from: Tw */
    public final int m13239Tw(C3776gjvQ c3776gjvQ, int i) {
        if (c3776gjvQ == null) {
            return 0;
        }
        if (c3776gjvQ.m12088rWxwaT() == C3776gjvQ.AZxh.MATCH_CONSTRAINT) {
            int i2 = c3776gjvQ.f13781MiMN;
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 2) {
                int i3 = (int) (c3776gjvQ.f13806diqgf * i);
                if (i3 != c3776gjvQ.m12051Ucbh()) {
                    m8009XDdeP(c3776gjvQ, c3776gjvQ.m12030HGpJ(), c3776gjvQ.m12096vadzgd(), C3776gjvQ.AZxh.FIXED, i3);
                }
                return i3;
            }
            if (i2 == 1) {
                return c3776gjvQ.m12051Ucbh();
            }
            if (i2 == 3) {
                return (int) ((c3776gjvQ.m12096vadzgd() * c3776gjvQ.f13818oCFDzJ) + 0.5f);
            }
        }
        return c3776gjvQ.m12051Ucbh();
    }

    /* renamed from: Vptz */
    public void m13240Vptz(int i) {
        this.f16149IyS = i;
    }

    /* renamed from: bc */
    public void m13241bc(int i) {
        this.f16146Dp = i;
    }

    /* renamed from: nUaNy */
    public final void m13242nUaNy(C3776gjvQ[] c3776gjvQArr, int i, int i2, int i3, int[] iArr) {
        int i4;
        int i5;
        int i6;
        C4446qtZIjO c4446qtZIjO;
        int iM8006Rc;
        C4446qtZIjO c4446qtZIjO2;
        int iM8015fLidf;
        int i7;
        if (i == 0) {
            return;
        }
        this.f16152KRckQg.clear();
        mjFkc mjfkc = new mjFkc(i2, this.f13764BAnRFn, this.f13813lB, this.f13829wJVbdd, this.f13815mByQ, i3);
        this.f16152KRckQg.add(mjfkc);
        if (i2 == 0) {
            i4 = 0;
            int i8 = 0;
            int i9 = 0;
            while (i9 < i) {
                C3776gjvQ c3776gjvQ = c3776gjvQArr[i9];
                int iM13238QyqF = m13238QyqF(c3776gjvQ, i3);
                if (c3776gjvQ.m12030HGpJ() == C3776gjvQ.AZxh.MATCH_CONSTRAINT) {
                    i4++;
                }
                int i10 = i4;
                boolean z = (i8 == i3 || (this.f16158XgAT + i8) + iM13238QyqF > i3) && mjfkc.f16171AZxh != null;
                if (!z && i9 > 0 && (i7 = this.f16160Zdbk) > 0 && i9 % i7 == 0) {
                    z = true;
                }
                if (z) {
                    mjfkc = new mjFkc(i2, this.f13764BAnRFn, this.f13813lB, this.f13829wJVbdd, this.f13815mByQ, i3);
                    mjfkc.m13261qdMbNW(i9);
                    this.f16152KRckQg.add(mjfkc);
                } else {
                    if (i9 > 0) {
                        i8 += this.f16158XgAT + iM13238QyqF;
                    }
                    mjfkc.m13255AZxh(c3776gjvQ);
                    i9++;
                    i4 = i10;
                }
                i8 = iM13238QyqF;
                mjfkc.m13255AZxh(c3776gjvQ);
                i9++;
                i4 = i10;
            }
        } else {
            i4 = 0;
            int i11 = 0;
            int i12 = 0;
            while (i12 < i) {
                C3776gjvQ c3776gjvQ2 = c3776gjvQArr[i12];
                int iM13239Tw = m13239Tw(c3776gjvQ2, i3);
                if (c3776gjvQ2.m12088rWxwaT() == C3776gjvQ.AZxh.MATCH_CONSTRAINT) {
                    i4++;
                }
                int i13 = i4;
                boolean z2 = (i11 == i3 || (this.f16149IyS + i11) + iM13239Tw > i3) && mjfkc.f16171AZxh != null;
                if (!z2 && i12 > 0 && (i5 = this.f16160Zdbk) > 0 && i12 % i5 == 0) {
                    z2 = true;
                }
                if (z2) {
                    mjfkc = new mjFkc(i2, this.f13764BAnRFn, this.f13813lB, this.f13829wJVbdd, this.f13815mByQ, i3);
                    mjfkc.m13261qdMbNW(i12);
                    this.f16152KRckQg.add(mjfkc);
                } else {
                    if (i12 > 0) {
                        i11 += this.f16149IyS + iM13239Tw;
                    }
                    mjfkc.m13255AZxh(c3776gjvQ2);
                    i12++;
                    i4 = i13;
                }
                i11 = iM13239Tw;
                mjfkc.m13255AZxh(c3776gjvQ2);
                i12++;
                i4 = i13;
            }
        }
        int size = this.f16152KRckQg.size();
        C4446qtZIjO c4446qtZIjO3 = this.f13764BAnRFn;
        C4446qtZIjO c4446qtZIjO4 = this.f13813lB;
        C4446qtZIjO c4446qtZIjO5 = this.f13829wJVbdd;
        C4446qtZIjO c4446qtZIjO6 = this.f13815mByQ;
        int iM8017hvGY = m8017hvGY();
        int iM8007SKTn = m8007SKTn();
        int iM8006Rc2 = m8006Rc();
        int iM8015fLidf2 = m8015fLidf();
        C3776gjvQ.AZxh aZxhM12030HGpJ = m12030HGpJ();
        C3776gjvQ.AZxh aZxh = C3776gjvQ.AZxh.WRAP_CONTENT;
        boolean z3 = aZxhM12030HGpJ == aZxh || m12088rWxwaT() == aZxh;
        if (i4 > 0 && z3) {
            for (int i14 = 0; i14 < size; i14++) {
                mjFkc mjfkc2 = (mjFkc) this.f16152KRckQg.get(i14);
                if (i2 == 0) {
                    mjfkc2.m13263xJ(i3 - mjfkc2.m13257JHa());
                } else {
                    mjfkc2.m13263xJ(i3 - mjfkc2.m13258KLFTb());
                }
            }
        }
        int i15 = iM8007SKTn;
        int i16 = iM8006Rc2;
        int iM13258KLFTb = 0;
        int iM13257JHa = 0;
        int i17 = 0;
        int i18 = iM8017hvGY;
        C4446qtZIjO c4446qtZIjO7 = c4446qtZIjO4;
        C4446qtZIjO c4446qtZIjO8 = c4446qtZIjO3;
        int i19 = iM8015fLidf2;
        while (i17 < size) {
            mjFkc mjfkc3 = (mjFkc) this.f16152KRckQg.get(i17);
            if (i2 == 0) {
                if (i17 < size - 1) {
                    c4446qtZIjO2 = ((mjFkc) this.f16152KRckQg.get(i17 + 1)).f16171AZxh.f13813lB;
                    iM8015fLidf = 0;
                } else {
                    c4446qtZIjO2 = this.f13815mByQ;
                    iM8015fLidf = m8015fLidf();
                }
                C4446qtZIjO c4446qtZIjO9 = mjfkc3.f16171AZxh.f13815mByQ;
                C4446qtZIjO c4446qtZIjO10 = c4446qtZIjO8;
                C4446qtZIjO c4446qtZIjO11 = c4446qtZIjO8;
                int i20 = iM13258KLFTb;
                C4446qtZIjO c4446qtZIjO12 = c4446qtZIjO7;
                int i21 = iM13257JHa;
                C4446qtZIjO c4446qtZIjO13 = c4446qtZIjO5;
                C4446qtZIjO c4446qtZIjO14 = c4446qtZIjO5;
                i6 = i17;
                mjfkc3.m13256Dt(i2, c4446qtZIjO10, c4446qtZIjO12, c4446qtZIjO13, c4446qtZIjO2, i18, i15, i16, iM8015fLidf, i3);
                int iMax = Math.max(i21, mjfkc3.m13257JHa());
                iM13258KLFTb = i20 + mjfkc3.m13258KLFTb();
                if (i6 > 0) {
                    iM13258KLFTb += this.f16149IyS;
                }
                c4446qtZIjO8 = c4446qtZIjO11;
                iM13257JHa = iMax;
                i15 = 0;
                c4446qtZIjO7 = c4446qtZIjO9;
                c4446qtZIjO = c4446qtZIjO14;
                int i22 = iM8015fLidf;
                c4446qtZIjO6 = c4446qtZIjO2;
                i19 = i22;
            } else {
                C4446qtZIjO c4446qtZIjO15 = c4446qtZIjO8;
                int i23 = iM13258KLFTb;
                int i24 = iM13257JHa;
                i6 = i17;
                if (i6 < size - 1) {
                    c4446qtZIjO = ((mjFkc) this.f16152KRckQg.get(i6 + 1)).f16171AZxh.f13764BAnRFn;
                    iM8006Rc = 0;
                } else {
                    c4446qtZIjO = this.f13829wJVbdd;
                    iM8006Rc = m8006Rc();
                }
                C4446qtZIjO c4446qtZIjO16 = mjfkc3.f16171AZxh.f13829wJVbdd;
                mjfkc3.m13256Dt(i2, c4446qtZIjO15, c4446qtZIjO7, c4446qtZIjO, c4446qtZIjO6, i18, i15, iM8006Rc, i19, i3);
                iM13257JHa = i24 + mjfkc3.m13257JHa();
                int iMax2 = Math.max(i23, mjfkc3.m13258KLFTb());
                if (i6 > 0) {
                    iM13257JHa += this.f16158XgAT;
                }
                iM13258KLFTb = iMax2;
                i18 = 0;
                i16 = iM8006Rc;
                c4446qtZIjO8 = c4446qtZIjO16;
            }
            i17 = i6 + 1;
            c4446qtZIjO5 = c4446qtZIjO;
        }
        iArr[0] = iM13257JHa;
        iArr[1] = iM13258KLFTb;
    }

    /* renamed from: np */
    public void m13243np(int i) {
        this.f16160Zdbk = i;
    }

    /* renamed from: pJeaSR */
    public void m13244pJeaSR(int i) {
        this.f16154Rc = i;
    }

    /* renamed from: qGgY */
    public void m13245qGgY(int i) {
        this.f16158XgAT = i;
    }

    /* renamed from: qrxT */
    public void m13246qrxT(int i) {
        this.f16165gtr = i;
    }

    @Override // p131o.AbstractC1832Da
    /* renamed from: rdJr */
    public void mo8020rdJr(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int[] iArr;
        boolean z;
        if (this.f17301yX > 0 && !m8014eQ()) {
            m8010XgAT(0, 0);
            m8018jtz(false);
            return;
        }
        int iM8017hvGY = m8017hvGY();
        int iM8006Rc = m8006Rc();
        int iM8007SKTn = m8007SKTn();
        int iM8015fLidf = m8015fLidf();
        int[] iArr2 = new int[2];
        int i7 = (i2 - iM8017hvGY) - iM8006Rc;
        int i8 = this.f16151Jk;
        if (i8 == 1) {
            i7 = (i4 - iM8007SKTn) - iM8015fLidf;
        }
        int i9 = i7;
        if (i8 == 0) {
            if (this.f16156XD == -1) {
                this.f16156XD = 0;
            }
            if (this.f16165gtr == -1) {
                this.f16165gtr = 0;
            }
        } else {
            if (this.f16156XD == -1) {
                this.f16156XD = 0;
            }
            if (this.f16165gtr == -1) {
                this.f16165gtr = 0;
            }
        }
        C3776gjvQ[] c3776gjvQArr = this.f17300tjSezt;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            i5 = this.f17301yX;
            if (i10 >= i5) {
                break;
            }
            if (this.f17300tjSezt[i10].m12043NPj() == 8) {
                i11++;
            }
            i10++;
        }
        if (i11 > 0) {
            c3776gjvQArr = new C3776gjvQ[i5 - i11];
            int i12 = 0;
            for (int i13 = 0; i13 < this.f17301yX; i13++) {
                C3776gjvQ c3776gjvQ = this.f17300tjSezt[i13];
                if (c3776gjvQ.m12043NPj() != 8) {
                    c3776gjvQArr[i12] = c3776gjvQ;
                    i12++;
                }
            }
            i6 = i12;
        } else {
            i6 = i5;
        }
        this.f16150Jidt = c3776gjvQArr;
        this.f16148IvRQOa = i6;
        int i14 = this.f16159Xxz;
        if (i14 == 0) {
            iArr = iArr2;
            z = true;
            m13248ub(c3776gjvQArr, i6, this.f16151Jk, i9, iArr2);
        } else if (i14 == 1) {
            z = true;
            iArr = iArr2;
            m13242nUaNy(c3776gjvQArr, i6, this.f16151Jk, i9, iArr2);
        } else if (i14 != 2) {
            z = true;
            iArr = iArr2;
        } else {
            z = true;
            iArr = iArr2;
            m13236LsBneK(c3776gjvQArr, i6, this.f16151Jk, i9, iArr2);
        }
        int iMin = iArr[0] + iM8017hvGY + iM8006Rc;
        int iMin2 = iArr[z ? 1 : 0] + iM8007SKTn + iM8015fLidf;
        if (i == 1073741824) {
            iMin = i2;
        } else if (i == Integer.MIN_VALUE) {
            iMin = Math.min(iMin, i2);
        } else if (i != 0) {
            iMin = 0;
        }
        if (i3 == 1073741824) {
            iMin2 = i4;
        } else if (i3 == Integer.MIN_VALUE) {
            iMin2 = Math.min(iMin2, i4);
        } else if (i3 != 0) {
            iMin2 = 0;
        }
        m8010XgAT(iMin, iMin2);
        m12078jx(iMin);
        m12023ANMGZc(iMin2);
        if (this.f17301yX <= 0) {
            z = false;
        }
        m8018jtz(z);
    }

    /* renamed from: tpGcn */
    public void m13247tpGcn(float f) {
        this.f16155SKTn = f;
    }

    /* renamed from: ub */
    public final void m13248ub(C3776gjvQ[] c3776gjvQArr, int i, int i2, int i3, int[] iArr) {
        mjFkc mjfkc;
        if (i == 0) {
            return;
        }
        if (this.f16152KRckQg.size() == 0) {
            mjfkc = new mjFkc(i2, this.f13764BAnRFn, this.f13813lB, this.f13829wJVbdd, this.f13815mByQ, i3);
            this.f16152KRckQg.add(mjfkc);
        } else {
            mjFkc mjfkc2 = (mjFkc) this.f16152KRckQg.get(0);
            mjfkc2.m13262wA();
            mjfkc = mjfkc2;
            mjfkc.m13256Dt(i2, this.f13764BAnRFn, this.f13813lB, this.f13829wJVbdd, this.f13815mByQ, m8017hvGY(), m8007SKTn(), m8006Rc(), m8015fLidf(), i3);
        }
        for (int i4 = 0; i4 < i; i4++) {
            mjfkc.m13255AZxh(c3776gjvQArr[i4]);
        }
        iArr[0] = mjfkc.m13257JHa();
        iArr[1] = mjfkc.m13258KLFTb();
    }

    /* renamed from: ui */
    public void m13249ui(int i) {
        this.f16170tAfC = i;
    }

    /* renamed from: vUsV */
    public void m13250vUsV(int i) {
        this.f16156XD = i;
    }

    /* renamed from: wLtdyQ */
    public void m13251wLtdyQ(float f) {
        this.f16163eQ = f;
    }

    /* renamed from: xCVa */
    public void m13252xCVa(float f) {
        this.f16157XDdeP = f;
    }

    /* renamed from: yP */
    public void m13253yP(int i) {
        this.f16164fLidf = i;
    }
}
