package p131o;

import java.util.ArrayList;
import java.util.Iterator;
import p131o.C3776gjvQ;

/* renamed from: o.ERt */
/* loaded from: classes.dex */
public class C1890ERt extends AbstractC2246Ja {

    /* renamed from: ETF */
    public ArrayList f7986ETF;

    /* renamed from: VA */
    public int f7987VA;

    public C1890ERt(C3776gjvQ c3776gjvQ, int i) {
        super(c3776gjvQ);
        this.f7986ETF = new ArrayList();
        this.f8998JHa = i;
        m8126fehf();
    }

    @Override // p131o.AbstractC2246Ja
    /* renamed from: Dt */
    public long mo8123Dt() {
        int size = this.f7986ETF.size();
        long jMo8123Dt = 0;
        for (int i = 0; i < size; i++) {
            jMo8123Dt = jMo8123Dt + r4.f9001lgHUyS.f16350JHa + ((AbstractC2246Ja) this.f7986ETF.get(i)).mo8123Dt() + r4.f9003qdMbNW.f16350JHa;
        }
        return jMo8123Dt;
    }

    /* renamed from: IEE */
    public final C3776gjvQ m8124IEE() {
        for (int i = 0; i < this.f7986ETF.size(); i++) {
            AbstractC2246Ja abstractC2246Ja = (AbstractC2246Ja) this.f7986ETF.get(i);
            if (abstractC2246Ja.f8996AZxh.m12043NPj() != 8) {
                return abstractC2246Ja.f8996AZxh;
            }
        }
        return null;
    }

    @Override // p131o.AbstractC2246Ja
    /* renamed from: JHa */
    public void mo7516JHa() {
        this.f9004wA = null;
        Iterator it = this.f7986ETF.iterator();
        while (it.hasNext()) {
            ((AbstractC2246Ja) it.next()).mo7516JHa();
        }
    }

    @Override // p131o.AbstractC2246Ja
    /* renamed from: KLFTb */
    public void mo7517KLFTb() {
        for (int i = 0; i < this.f7986ETF.size(); i++) {
            ((AbstractC2246Ja) this.f7986ETF.get(i)).mo7517KLFTb();
        }
    }

    @Override // p131o.AbstractC2246Ja
    /* renamed from: MiMN */
    public boolean mo7518MiMN() {
        int size = this.f7986ETF.size();
        for (int i = 0; i < size; i++) {
            if (!((AbstractC2246Ja) this.f7986ETF.get(i)).mo7518MiMN()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: Pq */
    public final C3776gjvQ m8125Pq() {
        for (int size = this.f7986ETF.size() - 1; size >= 0; size--) {
            AbstractC2246Ja abstractC2246Ja = (AbstractC2246Ja) this.f7986ETF.get(size);
            if (abstractC2246Ja.f8996AZxh.m12043NPj() != 8) {
                return abstractC2246Ja.f8996AZxh;
            }
        }
        return null;
    }

    @Override // p131o.AbstractC2246Ja
    /* renamed from: ZfxDd */
    public void mo7519ZfxDd() {
        Iterator it = this.f7986ETF.iterator();
        while (it.hasNext()) {
            ((AbstractC2246Ja) it.next()).mo7519ZfxDd();
        }
        int size = this.f7986ETF.size();
        if (size < 1) {
            return;
        }
        C3776gjvQ c3776gjvQ = ((AbstractC2246Ja) this.f7986ETF.get(0)).f8996AZxh;
        C3776gjvQ c3776gjvQ2 = ((AbstractC2246Ja) this.f7986ETF.get(size - 1)).f8996AZxh;
        if (this.f8998JHa == 0) {
            C4446qtZIjO c4446qtZIjO = c3776gjvQ.f13764BAnRFn;
            C4446qtZIjO c4446qtZIjO2 = c3776gjvQ2.f13829wJVbdd;
            C4494rdtF c4494rdtFM8994qdMbNW = m8994qdMbNW(c4446qtZIjO, 0);
            int iM13321wA = c4446qtZIjO.m13321wA();
            C3776gjvQ c3776gjvQM8124IEE = m8124IEE();
            if (c3776gjvQM8124IEE != null) {
                iM13321wA = c3776gjvQM8124IEE.f13764BAnRFn.m13321wA();
            }
            if (c4494rdtFM8994qdMbNW != null) {
                m8988AZxh(this.f9001lgHUyS, c4494rdtFM8994qdMbNW, iM13321wA);
            }
            C4494rdtF c4494rdtFM8994qdMbNW2 = m8994qdMbNW(c4446qtZIjO2, 0);
            int iM13321wA2 = c4446qtZIjO2.m13321wA();
            C3776gjvQ c3776gjvQM8125Pq = m8125Pq();
            if (c3776gjvQM8125Pq != null) {
                iM13321wA2 = c3776gjvQM8125Pq.f13829wJVbdd.m13321wA();
            }
            if (c4494rdtFM8994qdMbNW2 != null) {
                m8988AZxh(this.f9003qdMbNW, c4494rdtFM8994qdMbNW2, -iM13321wA2);
            }
        } else {
            C4446qtZIjO c4446qtZIjO3 = c3776gjvQ.f13813lB;
            C4446qtZIjO c4446qtZIjO4 = c3776gjvQ2.f13815mByQ;
            C4494rdtF c4494rdtFM8994qdMbNW3 = m8994qdMbNW(c4446qtZIjO3, 1);
            int iM13321wA3 = c4446qtZIjO3.m13321wA();
            C3776gjvQ c3776gjvQM8124IEE2 = m8124IEE();
            if (c3776gjvQM8124IEE2 != null) {
                iM13321wA3 = c3776gjvQM8124IEE2.f13813lB.m13321wA();
            }
            if (c4494rdtFM8994qdMbNW3 != null) {
                m8988AZxh(this.f9001lgHUyS, c4494rdtFM8994qdMbNW3, iM13321wA3);
            }
            C4494rdtF c4494rdtFM8994qdMbNW4 = m8994qdMbNW(c4446qtZIjO4, 1);
            int iM13321wA4 = c4446qtZIjO4.m13321wA();
            C3776gjvQ c3776gjvQM8125Pq2 = m8125Pq();
            if (c3776gjvQM8125Pq2 != null) {
                iM13321wA4 = c3776gjvQM8125Pq2.f13815mByQ.m13321wA();
            }
            if (c4494rdtFM8994qdMbNW4 != null) {
                m8988AZxh(this.f9003qdMbNW, c4494rdtFM8994qdMbNW4, -iM13321wA4);
            }
        }
        this.f9001lgHUyS.f16355mjFkc = this;
        this.f9003qdMbNW.f16355mjFkc = this;
    }

    /* renamed from: fehf */
    public final void m8126fehf() {
        C3776gjvQ c3776gjvQ;
        C3776gjvQ c3776gjvQ2 = this.f8996AZxh;
        C3776gjvQ c3776gjvQM12025CqaNbM = c3776gjvQ2.m12025CqaNbM(this.f8998JHa);
        while (true) {
            C3776gjvQ c3776gjvQ3 = c3776gjvQM12025CqaNbM;
            c3776gjvQ = c3776gjvQ2;
            c3776gjvQ2 = c3776gjvQ3;
            if (c3776gjvQ2 == null) {
                break;
            } else {
                c3776gjvQM12025CqaNbM = c3776gjvQ2.m12025CqaNbM(this.f8998JHa);
            }
        }
        this.f8996AZxh = c3776gjvQ;
        this.f7986ETF.add(c3776gjvQ.m12037KLMXS(this.f8998JHa));
        C3776gjvQ c3776gjvQM12045OjSQV = c3776gjvQ.m12045OjSQV(this.f8998JHa);
        while (c3776gjvQM12045OjSQV != null) {
            this.f7986ETF.add(c3776gjvQM12045OjSQV.m12037KLMXS(this.f8998JHa));
            c3776gjvQM12045OjSQV = c3776gjvQM12045OjSQV.m12045OjSQV(this.f8998JHa);
        }
        Iterator it = this.f7986ETF.iterator();
        while (it.hasNext()) {
            AbstractC2246Ja abstractC2246Ja = (AbstractC2246Ja) it.next();
            int i = this.f8998JHa;
            if (i == 0) {
                abstractC2246Ja.f8996AZxh.f13828wA = this;
            } else if (i == 1) {
                abstractC2246Ja.f8996AZxh.f13801ZfxDd = this;
            }
        }
        if (this.f8998JHa == 0 && ((C4052kw) this.f8996AZxh.m12044Ne()).m12623dGDT() && this.f7986ETF.size() > 1) {
            ArrayList arrayList = this.f7986ETF;
            this.f8996AZxh = ((AbstractC2246Ja) arrayList.get(arrayList.size() - 1)).f8996AZxh;
        }
        this.f7987VA = this.f8998JHa == 0 ? this.f8996AZxh.m12029Gd() : this.f8996AZxh.m12067cMLeY();
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x01d5 A[PHI: r1 r22 r23 r24
      0x01d5: PHI (r1v61 int) = (r1v59 int), (r1v67 int) binds: [B:119:0x01d3, B:110:0x01ad] A[DONT_GENERATE, DONT_INLINE]
      0x01d5: PHI (r22v1 float) = (r22v0 float), (r22v3 float) binds: [B:119:0x01d3, B:110:0x01ad] A[DONT_GENERATE, DONT_INLINE]
      0x01d5: PHI (r23v4 boolean) = (r23v3 boolean), (r23v6 boolean) binds: [B:119:0x01d3, B:110:0x01ad] A[DONT_GENERATE, DONT_INLINE]
      0x01d5: PHI (r24v4 int) = (r24v3 int), (r24v6 int) binds: [B:119:0x01d3, B:110:0x01ad] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0155  */
    @Override // p131o.AbstractC2246Ja, p131o.InterfaceC2695QQi
    /* renamed from: mjFkc */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo7521mjFkc(InterfaceC2695QQi interfaceC2695QQi) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        float f;
        boolean z;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        boolean z2;
        int i12;
        float f2;
        int iMax;
        int i13;
        int i14;
        if (this.f9001lgHUyS.f16348Dt && this.f9003qdMbNW.f16348Dt) {
            C3776gjvQ c3776gjvQM12044Ne = this.f8996AZxh.m12044Ne();
            boolean zM12623dGDT = (c3776gjvQM12044Ne == null || !(c3776gjvQM12044Ne instanceof C4052kw)) ? false : ((C4052kw) c3776gjvQM12044Ne).m12623dGDT();
            int i15 = this.f9003qdMbNW.f16358xJ - this.f9001lgHUyS.f16358xJ;
            int size = this.f7986ETF.size();
            int i16 = 0;
            while (true) {
                i = -1;
                i2 = 8;
                if (i16 >= size) {
                    i16 = -1;
                    break;
                } else if (((AbstractC2246Ja) this.f7986ETF.get(i16)).f8996AZxh.m12043NPj() != 8) {
                    break;
                } else {
                    i16++;
                }
            }
            int i17 = size - 1;
            int i18 = i17;
            while (true) {
                if (i18 < 0) {
                    break;
                }
                if (((AbstractC2246Ja) this.f7986ETF.get(i18)).f8996AZxh.m12043NPj() != 8) {
                    i = i18;
                    break;
                }
                i18--;
            }
            int i19 = 0;
            while (i19 < 2) {
                int i20 = 0;
                i4 = 0;
                i5 = 0;
                int i21 = 0;
                f = 0.0f;
                while (i20 < size) {
                    AbstractC2246Ja abstractC2246Ja = (AbstractC2246Ja) this.f7986ETF.get(i20);
                    if (abstractC2246Ja.f8996AZxh.m12043NPj() != i2) {
                        i21++;
                        if (i20 > 0 && i20 >= i16) {
                            i4 += abstractC2246Ja.f9001lgHUyS.f16350JHa;
                        }
                        C1691BOPu c1691BOPu = abstractC2246Ja.f8999KLFTb;
                        int i22 = c1691BOPu.f16358xJ;
                        boolean z3 = abstractC2246Ja.f9000ZfxDd != C3776gjvQ.AZxh.MATCH_CONSTRAINT;
                        if (z3) {
                            int i23 = this.f8998JHa;
                            if (i23 == 0 && !abstractC2246Ja.f8996AZxh.f13778KLFTb.f8999KLFTb.f16348Dt) {
                                return;
                            }
                            if (i23 == 1 && !abstractC2246Ja.f8996AZxh.f13774JHa.f8999KLFTb.f16348Dt) {
                                return;
                            } else {
                                i13 = i22;
                            }
                        } else {
                            i13 = i22;
                            if (abstractC2246Ja.f9002mjFkc == 1 && i19 == 0) {
                                i14 = c1691BOPu.f7478MiMN;
                                i5++;
                            } else if (c1691BOPu.f16348Dt) {
                                i14 = i13;
                            }
                            z3 = true;
                            if (z3) {
                                i5++;
                                float f3 = abstractC2246Ja.f8996AZxh.f13790SmIWf[this.f8998JHa];
                                if (f3 >= 0.0f) {
                                    f += f3;
                                }
                            } else {
                                i4 += i14;
                            }
                            if (i20 >= i17 && i20 < i) {
                                i4 += -abstractC2246Ja.f9003qdMbNW.f16350JHa;
                            }
                        }
                        i14 = i13;
                        if (z3) {
                        }
                        if (i20 >= i17) {
                        }
                    }
                    i20++;
                    i2 = 8;
                }
                if (i4 < i15 || i5 == 0) {
                    i3 = i21;
                    break;
                } else {
                    i19++;
                    i2 = 8;
                }
            }
            i3 = 0;
            i4 = 0;
            i5 = 0;
            f = 0.0f;
            int i24 = this.f9001lgHUyS.f16358xJ;
            if (zM12623dGDT) {
                i24 = this.f9003qdMbNW.f16358xJ;
            }
            if (i4 > i15) {
                i24 = zM12623dGDT ? i24 + ((int) (((i4 - i15) / 2.0f) + 0.5f)) : i24 - ((int) (((i4 - i15) / 2.0f) + 0.5f));
            }
            if (i5 > 0) {
                float f4 = i15 - i4;
                int i25 = (int) ((f4 / i5) + 0.5f);
                int i26 = 0;
                int i27 = 0;
                while (i26 < size) {
                    AbstractC2246Ja abstractC2246Ja2 = (AbstractC2246Ja) this.f7986ETF.get(i26);
                    int i28 = i25;
                    int i29 = i4;
                    if (abstractC2246Ja2.f8996AZxh.m12043NPj() != 8 && abstractC2246Ja2.f9000ZfxDd == C3776gjvQ.AZxh.MATCH_CONSTRAINT) {
                        C1691BOPu c1691BOPu2 = abstractC2246Ja2.f8999KLFTb;
                        if (c1691BOPu2.f16348Dt) {
                            z2 = zM12623dGDT;
                            i12 = i3;
                            i10 = i24;
                            f2 = f4;
                        } else {
                            if (f > 0.0f) {
                                i10 = i24;
                                i11 = (int) (((abstractC2246Ja2.f8996AZxh.f13790SmIWf[this.f8998JHa] * f4) / f) + 0.5f);
                            } else {
                                i10 = i24;
                                i11 = i28;
                            }
                            if (this.f8998JHa == 0) {
                                C3776gjvQ c3776gjvQ = abstractC2246Ja2.f8996AZxh;
                                f2 = f4;
                                int i30 = c3776gjvQ.f13819qGY;
                                z2 = zM12623dGDT;
                                i12 = i3;
                                iMax = Math.max(c3776gjvQ.f13822rkYL, abstractC2246Ja2.f9002mjFkc == 1 ? Math.min(i11, c1691BOPu2.f7478MiMN) : i11);
                                if (i30 > 0) {
                                    iMax = Math.min(i30, iMax);
                                }
                                if (iMax != i11) {
                                    i27++;
                                    i11 = iMax;
                                }
                                abstractC2246Ja2.f8999KLFTb.mo7695ZfxDd(i11);
                            } else {
                                z2 = zM12623dGDT;
                                i12 = i3;
                                f2 = f4;
                                C3776gjvQ c3776gjvQ2 = abstractC2246Ja2.f8996AZxh;
                                int i31 = c3776gjvQ2.f13787Pq;
                                iMax = Math.max(c3776gjvQ2.f13771IEE, abstractC2246Ja2.f9002mjFkc == 1 ? Math.min(i11, c1691BOPu2.f7478MiMN) : i11);
                                if (i31 > 0) {
                                    iMax = Math.min(i31, iMax);
                                }
                                if (iMax != i11) {
                                }
                                abstractC2246Ja2.f8999KLFTb.mo7695ZfxDd(i11);
                            }
                        }
                    }
                    i26++;
                    i25 = i28;
                    i4 = i29;
                    i24 = i10;
                    f4 = f2;
                    zM12623dGDT = z2;
                    i3 = i12;
                }
                z = zM12623dGDT;
                i6 = i3;
                i7 = i24;
                int i32 = i4;
                if (i27 > 0) {
                    i5 -= i27;
                    i4 = 0;
                    for (int i33 = 0; i33 < size; i33++) {
                        AbstractC2246Ja abstractC2246Ja3 = (AbstractC2246Ja) this.f7986ETF.get(i33);
                        if (abstractC2246Ja3.f8996AZxh.m12043NPj() != 8) {
                            if (i33 > 0 && i33 >= i16) {
                                i4 += abstractC2246Ja3.f9001lgHUyS.f16350JHa;
                            }
                            i4 += abstractC2246Ja3.f8999KLFTb.f16358xJ;
                            if (i33 < i17 && i33 < i) {
                                i4 += -abstractC2246Ja3.f9003qdMbNW.f16350JHa;
                            }
                        }
                    }
                } else {
                    i4 = i32;
                }
                i9 = 2;
                if (this.f7987VA == 2 && i27 == 0) {
                    i8 = 0;
                    this.f7987VA = 0;
                } else {
                    i8 = 0;
                }
            } else {
                z = zM12623dGDT;
                i6 = i3;
                i7 = i24;
                i8 = 0;
                i9 = 2;
            }
            if (i4 > i15) {
                this.f7987VA = i9;
            }
            if (i6 > 0 && i5 == 0 && i16 == i) {
                this.f7987VA = i9;
            }
            int i34 = this.f7987VA;
            if (i34 == 1) {
                int i35 = i6;
                int i36 = i35 > 1 ? (i15 - i4) / (i35 - 1) : i35 == 1 ? (i15 - i4) / 2 : i8;
                if (i5 > 0) {
                    i36 = i8;
                }
                int i37 = i7;
                for (int i38 = i8; i38 < size; i38++) {
                    AbstractC2246Ja abstractC2246Ja4 = (AbstractC2246Ja) this.f7986ETF.get(z ? size - (i38 + 1) : i38);
                    if (abstractC2246Ja4.f8996AZxh.m12043NPj() == 8) {
                        abstractC2246Ja4.f9001lgHUyS.mo7695ZfxDd(i37);
                        abstractC2246Ja4.f9003qdMbNW.mo7695ZfxDd(i37);
                    } else {
                        if (i38 > 0) {
                            i37 = z ? i37 - i36 : i37 + i36;
                        }
                        if (i38 > 0 && i38 >= i16) {
                            i37 = z ? i37 - abstractC2246Ja4.f9001lgHUyS.f16350JHa : i37 + abstractC2246Ja4.f9001lgHUyS.f16350JHa;
                        }
                        if (z) {
                            abstractC2246Ja4.f9003qdMbNW.mo7695ZfxDd(i37);
                        } else {
                            abstractC2246Ja4.f9001lgHUyS.mo7695ZfxDd(i37);
                        }
                        C1691BOPu c1691BOPu3 = abstractC2246Ja4.f8999KLFTb;
                        int i39 = c1691BOPu3.f16358xJ;
                        if (abstractC2246Ja4.f9000ZfxDd == C3776gjvQ.AZxh.MATCH_CONSTRAINT && abstractC2246Ja4.f9002mjFkc == 1) {
                            i39 = c1691BOPu3.f7478MiMN;
                        }
                        i37 = z ? i37 - i39 : i37 + i39;
                        if (z) {
                            abstractC2246Ja4.f9001lgHUyS.mo7695ZfxDd(i37);
                        } else {
                            abstractC2246Ja4.f9003qdMbNW.mo7695ZfxDd(i37);
                        }
                        abstractC2246Ja4.f9005xJ = true;
                        if (i38 < i17 && i38 < i) {
                            i37 = z ? i37 - (-abstractC2246Ja4.f9003qdMbNW.f16350JHa) : i37 + (-abstractC2246Ja4.f9003qdMbNW.f16350JHa);
                        }
                    }
                }
                return;
            }
            int i40 = i6;
            if (i34 == 0) {
                int i41 = (i15 - i4) / (i40 + 1);
                if (i5 > 0) {
                    i41 = i8;
                }
                int i42 = i7;
                for (int i43 = i8; i43 < size; i43++) {
                    AbstractC2246Ja abstractC2246Ja5 = (AbstractC2246Ja) this.f7986ETF.get(z ? size - (i43 + 1) : i43);
                    if (abstractC2246Ja5.f8996AZxh.m12043NPj() == 8) {
                        abstractC2246Ja5.f9001lgHUyS.mo7695ZfxDd(i42);
                        abstractC2246Ja5.f9003qdMbNW.mo7695ZfxDd(i42);
                    } else {
                        int i44 = z ? i42 - i41 : i42 + i41;
                        if (i43 > 0 && i43 >= i16) {
                            i44 = z ? i44 - abstractC2246Ja5.f9001lgHUyS.f16350JHa : i44 + abstractC2246Ja5.f9001lgHUyS.f16350JHa;
                        }
                        if (z) {
                            abstractC2246Ja5.f9003qdMbNW.mo7695ZfxDd(i44);
                        } else {
                            abstractC2246Ja5.f9001lgHUyS.mo7695ZfxDd(i44);
                        }
                        C1691BOPu c1691BOPu4 = abstractC2246Ja5.f8999KLFTb;
                        int iMin = c1691BOPu4.f16358xJ;
                        if (abstractC2246Ja5.f9000ZfxDd == C3776gjvQ.AZxh.MATCH_CONSTRAINT && abstractC2246Ja5.f9002mjFkc == 1) {
                            iMin = Math.min(iMin, c1691BOPu4.f7478MiMN);
                        }
                        i42 = z ? i44 - iMin : i44 + iMin;
                        if (z) {
                            abstractC2246Ja5.f9001lgHUyS.mo7695ZfxDd(i42);
                        } else {
                            abstractC2246Ja5.f9003qdMbNW.mo7695ZfxDd(i42);
                        }
                        if (i43 < i17 && i43 < i) {
                            i42 = z ? i42 - (-abstractC2246Ja5.f9003qdMbNW.f16350JHa) : i42 + (-abstractC2246Ja5.f9003qdMbNW.f16350JHa);
                        }
                    }
                }
                return;
            }
            if (i34 == 2) {
                float fM12076huTpC = this.f8998JHa == 0 ? this.f8996AZxh.m12076huTpC() : this.f8996AZxh.m12103zvd();
                if (z) {
                    fM12076huTpC = 1.0f - fM12076huTpC;
                }
                int i45 = (int) (((i15 - i4) * fM12076huTpC) + 0.5f);
                if (i45 < 0 || i5 > 0) {
                    i45 = i8;
                }
                int i46 = z ? i7 - i45 : i7 + i45;
                for (int i47 = i8; i47 < size; i47++) {
                    AbstractC2246Ja abstractC2246Ja6 = (AbstractC2246Ja) this.f7986ETF.get(z ? size - (i47 + 1) : i47);
                    if (abstractC2246Ja6.f8996AZxh.m12043NPj() == 8) {
                        abstractC2246Ja6.f9001lgHUyS.mo7695ZfxDd(i46);
                        abstractC2246Ja6.f9003qdMbNW.mo7695ZfxDd(i46);
                    } else {
                        if (i47 > 0 && i47 >= i16) {
                            i46 = z ? i46 - abstractC2246Ja6.f9001lgHUyS.f16350JHa : i46 + abstractC2246Ja6.f9001lgHUyS.f16350JHa;
                        }
                        if (z) {
                            abstractC2246Ja6.f9003qdMbNW.mo7695ZfxDd(i46);
                        } else {
                            abstractC2246Ja6.f9001lgHUyS.mo7695ZfxDd(i46);
                        }
                        C1691BOPu c1691BOPu5 = abstractC2246Ja6.f8999KLFTb;
                        int i48 = c1691BOPu5.f16358xJ;
                        if (abstractC2246Ja6.f9000ZfxDd == C3776gjvQ.AZxh.MATCH_CONSTRAINT && abstractC2246Ja6.f9002mjFkc == 1) {
                            i48 = c1691BOPu5.f7478MiMN;
                        }
                        i46 = z ? i46 - i48 : i46 + i48;
                        if (z) {
                            abstractC2246Ja6.f9001lgHUyS.mo7695ZfxDd(i46);
                        } else {
                            abstractC2246Ja6.f9003qdMbNW.mo7695ZfxDd(i46);
                        }
                        if (i47 < i17 && i47 < i) {
                            i46 = z ? i46 - (-abstractC2246Ja6.f9003qdMbNW.f16350JHa) : i46 + (-abstractC2246Ja6.f9003qdMbNW.f16350JHa);
                        }
                    }
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ChainRun ");
        sb.append(this.f8998JHa == 0 ? "horizontal : " : "vertical : ");
        String string = sb.toString();
        Iterator it = this.f7986ETF.iterator();
        while (it.hasNext()) {
            String str = string + "<";
            string = (str + ((AbstractC2246Ja) it.next())) + "> ";
        }
        return string;
    }
}
