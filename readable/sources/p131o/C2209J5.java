package p131o;

import java.util.ArrayList;

/* renamed from: o.J5 */
/* loaded from: classes.dex */
public class C2209J5 {

    /* renamed from: lgHUyS */
    public static int f8855lgHUyS;

    /* renamed from: JHa */
    public int f8857JHa;

    /* renamed from: ZfxDd */
    public AbstractC2246Ja f8859ZfxDd;

    /* renamed from: wA */
    public AbstractC2246Ja f8861wA;

    /* renamed from: xJ */
    public int f8862xJ;

    /* renamed from: mjFkc */
    public int f8860mjFkc = 0;

    /* renamed from: AZxh */
    public boolean f8856AZxh = false;

    /* renamed from: KLFTb */
    public ArrayList f8858KLFTb = new ArrayList();

    public C2209J5(AbstractC2246Ja abstractC2246Ja, int i) {
        this.f8861wA = null;
        this.f8859ZfxDd = null;
        int i2 = f8855lgHUyS;
        this.f8857JHa = i2;
        f8855lgHUyS = i2 + 1;
        this.f8861wA = abstractC2246Ja;
        this.f8859ZfxDd = abstractC2246Ja;
        this.f8862xJ = i;
    }

    /* renamed from: AZxh */
    public long m8887AZxh(C4052kw c4052kw, int i) {
        AbstractC2246Ja abstractC2246Ja = this.f8861wA;
        if (abstractC2246Ja instanceof C1890ERt) {
            if (((C1890ERt) abstractC2246Ja).f8998JHa != i) {
                return 0L;
            }
        } else if (i == 0) {
            if (!(abstractC2246Ja instanceof C1597A)) {
                return 0L;
            }
        } else if (!(abstractC2246Ja instanceof C2742R9)) {
            return 0L;
        }
        C4494rdtF c4494rdtF = (i == 0 ? c4052kw.f13778KLFTb : c4052kw.f13774JHa).f9001lgHUyS;
        C4494rdtF c4494rdtF2 = (i == 0 ? c4052kw.f13778KLFTb : c4052kw.f13774JHa).f9003qdMbNW;
        boolean zContains = abstractC2246Ja.f9001lgHUyS.f16352VA.contains(c4494rdtF);
        boolean zContains2 = this.f8861wA.f9003qdMbNW.f16352VA.contains(c4494rdtF2);
        long jMo8123Dt = this.f8861wA.mo8123Dt();
        if (!zContains || !zContains2) {
            if (zContains) {
                return Math.max(m8888ZfxDd(this.f8861wA.f9001lgHUyS, r12.f16350JHa), this.f8861wA.f9001lgHUyS.f16350JHa + jMo8123Dt);
            }
            if (!zContains2) {
                return (r12.f9001lgHUyS.f16350JHa + this.f8861wA.mo8123Dt()) - this.f8861wA.f9003qdMbNW.f16350JHa;
            }
            return Math.max(-m8890wA(this.f8861wA.f9003qdMbNW, r12.f16350JHa), (-this.f8861wA.f9003qdMbNW.f16350JHa) + jMo8123Dt);
        }
        long jM8888ZfxDd = m8888ZfxDd(this.f8861wA.f9001lgHUyS, 0L);
        long jM8890wA = m8890wA(this.f8861wA.f9003qdMbNW, 0L);
        long j = jM8888ZfxDd - jMo8123Dt;
        AbstractC2246Ja abstractC2246Ja2 = this.f8861wA;
        int i2 = abstractC2246Ja2.f9003qdMbNW.f16350JHa;
        if (j >= (-i2)) {
            j += i2;
        }
        int i3 = abstractC2246Ja2.f9001lgHUyS.f16350JHa;
        long j2 = ((-jM8890wA) - jMo8123Dt) - i3;
        if (j2 >= i3) {
            j2 -= i3;
        }
        float fM12089rkYL = abstractC2246Ja2.f8996AZxh.m12089rkYL(i);
        float f = fM12089rkYL > 0.0f ? (long) ((j2 / fM12089rkYL) + (j / (1.0f - fM12089rkYL))) : 0L;
        long j3 = ((long) ((f * fM12089rkYL) + 0.5f)) + jMo8123Dt + ((long) ((f * (1.0f - fM12089rkYL)) + 0.5f));
        AbstractC2246Ja abstractC2246Ja3 = this.f8861wA;
        return (abstractC2246Ja3.f9001lgHUyS.f16350JHa + j3) - abstractC2246Ja3.f9003qdMbNW.f16350JHa;
    }

    /* renamed from: ZfxDd */
    public final long m8888ZfxDd(C4494rdtF c4494rdtF, long j) {
        AbstractC2246Ja abstractC2246Ja = c4494rdtF.f16353ZfxDd;
        if (abstractC2246Ja instanceof C4785w) {
            return j;
        }
        int size = c4494rdtF.f16349ETF.size();
        long jMax = j;
        for (int i = 0; i < size; i++) {
            InterfaceC2695QQi interfaceC2695QQi = (InterfaceC2695QQi) c4494rdtF.f16349ETF.get(i);
            if (interfaceC2695QQi instanceof C4494rdtF) {
                C4494rdtF c4494rdtF2 = (C4494rdtF) interfaceC2695QQi;
                if (c4494rdtF2.f16353ZfxDd != abstractC2246Ja) {
                    jMax = Math.max(jMax, m8888ZfxDd(c4494rdtF2, c4494rdtF2.f16350JHa + j));
                }
            }
        }
        if (c4494rdtF != abstractC2246Ja.f9001lgHUyS) {
            return jMax;
        }
        long jMo8123Dt = j + abstractC2246Ja.mo8123Dt();
        return Math.max(Math.max(jMax, m8888ZfxDd(abstractC2246Ja.f9003qdMbNW, jMo8123Dt)), jMo8123Dt - abstractC2246Ja.f9003qdMbNW.f16350JHa);
    }

    /* renamed from: mjFkc */
    public void m8889mjFkc(AbstractC2246Ja abstractC2246Ja) {
        this.f8858KLFTb.add(abstractC2246Ja);
        this.f8859ZfxDd = abstractC2246Ja;
    }

    /* renamed from: wA */
    public final long m8890wA(C4494rdtF c4494rdtF, long j) {
        AbstractC2246Ja abstractC2246Ja = c4494rdtF.f16353ZfxDd;
        if (abstractC2246Ja instanceof C4785w) {
            return j;
        }
        int size = c4494rdtF.f16349ETF.size();
        long jMin = j;
        for (int i = 0; i < size; i++) {
            InterfaceC2695QQi interfaceC2695QQi = (InterfaceC2695QQi) c4494rdtF.f16349ETF.get(i);
            if (interfaceC2695QQi instanceof C4494rdtF) {
                C4494rdtF c4494rdtF2 = (C4494rdtF) interfaceC2695QQi;
                if (c4494rdtF2.f16353ZfxDd != abstractC2246Ja) {
                    jMin = Math.min(jMin, m8890wA(c4494rdtF2, c4494rdtF2.f16350JHa + j));
                }
            }
        }
        if (c4494rdtF != abstractC2246Ja.f9003qdMbNW) {
            return jMin;
        }
        long jMo8123Dt = j - abstractC2246Ja.mo8123Dt();
        return Math.min(Math.min(jMin, m8890wA(abstractC2246Ja.f9001lgHUyS, jMo8123Dt)), jMo8123Dt - abstractC2246Ja.f9001lgHUyS.f16350JHa);
    }
}
