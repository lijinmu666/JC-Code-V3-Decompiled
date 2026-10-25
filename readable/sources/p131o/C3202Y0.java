package p131o;

import java.util.Arrays;
import java.util.HashMap;
import p131o.C3274Z6;
import p131o.C4446qtZIjO;

/* renamed from: o.Y0 */
/* loaded from: classes.dex */
public class C3202Y0 {

    /* renamed from: IEE */
    public static boolean f11763IEE = true;

    /* renamed from: Pq */
    public static long f11764Pq = 0;

    /* renamed from: diqgf */
    public static long f11765diqgf = 0;

    /* renamed from: fehf */
    public static int f11766fehf = 1000;

    /* renamed from: JHa */
    public C4955yX[] f11770JHa;

    /* renamed from: MiMN */
    public final C2768RWyiuY f11772MiMN;

    /* renamed from: qGY */
    public mjFkc f11778qGY;

    /* renamed from: wA */
    public mjFkc f11781wA;

    /* renamed from: mjFkc */
    public int f11777mjFkc = 0;

    /* renamed from: AZxh */
    public HashMap f11767AZxh = null;

    /* renamed from: ZfxDd */
    public int f11775ZfxDd = 32;

    /* renamed from: KLFTb */
    public int f11771KLFTb = 32;

    /* renamed from: xJ */
    public boolean f11782xJ = false;

    /* renamed from: lgHUyS */
    public boolean f11776lgHUyS = false;

    /* renamed from: qdMbNW */
    public boolean[] f11779qdMbNW = new boolean[32];

    /* renamed from: Dt */
    public int f11768Dt = 1;

    /* renamed from: ETF */
    public int f11769ETF = 0;

    /* renamed from: VA */
    public int f11773VA = 32;

    /* renamed from: YoKzxo */
    public C3274Z6[] f11774YoKzxo = new C3274Z6[f11766fehf];

    /* renamed from: rkYL */
    public int f11780rkYL = 0;

    /* renamed from: o.Y0$AZxh */
    public class AZxh extends C4955yX {
        public AZxh(C2768RWyiuY c2768RWyiuY) {
            this.f17530KLFTb = new C3342a7(this, c2768RWyiuY);
        }
    }

    /* renamed from: o.Y0$mjFkc */
    public interface mjFkc {
        /* renamed from: AZxh */
        C3274Z6 mo9471AZxh(C3202Y0 c3202y0, boolean[] zArr);

        /* renamed from: clear */
        void mo9474clear();

        /* renamed from: getKey */
        C3274Z6 mo11036getKey();

        /* renamed from: mjFkc */
        void mo9476mjFkc(C3274Z6 c3274z6);

        /* renamed from: wA */
        void mo11037wA(mjFkc mjfkc);
    }

    public C3202Y0() {
        this.f11770JHa = null;
        this.f11770JHa = new C4955yX[32];
        m11026lB();
        C2768RWyiuY c2768RWyiuY = new C2768RWyiuY();
        this.f11772MiMN = c2768RWyiuY;
        this.f11781wA = new C2411M3(c2768RWyiuY);
        if (f11763IEE) {
            this.f11778qGY = new AZxh(c2768RWyiuY);
        } else {
            this.f11778qGY = new C4955yX(c2768RWyiuY);
        }
    }

    /* renamed from: Pq */
    public static C4955yX m11006Pq(C3202Y0 c3202y0, C3274Z6 c3274z6, C3274Z6 c3274z62, float f) {
        return c3202y0.m11014IEE().m14014Dt(c3274z6, c3274z62, f);
    }

    /* renamed from: huTpC */
    public static AbstractC3798h2 m11007huTpC() {
        return null;
    }

    /* renamed from: AZxh */
    public void m11008AZxh(C3776gjvQ c3776gjvQ, C3776gjvQ c3776gjvQ2, float f, int i) {
        C4446qtZIjO.AZxh aZxh = C4446qtZIjO.AZxh.LEFT;
        C3274Z6 c3274z6M11025fehf = m11025fehf(c3776gjvQ.mo12040MiMN(aZxh));
        C4446qtZIjO.AZxh aZxh2 = C4446qtZIjO.AZxh.TOP;
        C3274Z6 c3274z6M11025fehf2 = m11025fehf(c3776gjvQ.mo12040MiMN(aZxh2));
        C4446qtZIjO.AZxh aZxh3 = C4446qtZIjO.AZxh.RIGHT;
        C3274Z6 c3274z6M11025fehf3 = m11025fehf(c3776gjvQ.mo12040MiMN(aZxh3));
        C4446qtZIjO.AZxh aZxh4 = C4446qtZIjO.AZxh.BOTTOM;
        C3274Z6 c3274z6M11025fehf4 = m11025fehf(c3776gjvQ.mo12040MiMN(aZxh4));
        C3274Z6 c3274z6M11025fehf5 = m11025fehf(c3776gjvQ2.mo12040MiMN(aZxh));
        C3274Z6 c3274z6M11025fehf6 = m11025fehf(c3776gjvQ2.mo12040MiMN(aZxh2));
        C3274Z6 c3274z6M11025fehf7 = m11025fehf(c3776gjvQ2.mo12040MiMN(aZxh3));
        C3274Z6 c3274z6M11025fehf8 = m11025fehf(c3776gjvQ2.mo12040MiMN(aZxh4));
        C4955yX c4955yXM11014IEE = m11014IEE();
        double d = f;
        double d2 = i;
        c4955yXM11014IEE.m14030fehf(c3274z6M11025fehf2, c3274z6M11025fehf4, c3274z6M11025fehf6, c3274z6M11025fehf8, (float) (Math.sin(d) * d2));
        m11022ZfxDd(c4955yXM11014IEE);
        C4955yX c4955yXM11014IEE2 = m11014IEE();
        c4955yXM11014IEE2.m14030fehf(c3274z6M11025fehf, c3274z6M11025fehf3, c3274z6M11025fehf5, c3274z6M11025fehf7, (float) (Math.cos(d) * d2));
        m11022ZfxDd(c4955yXM11014IEE2);
    }

    /* renamed from: BAnRFn */
    public final int m11009BAnRFn(mjFkc mjfkc, boolean z) {
        for (int i = 0; i < this.f11768Dt; i++) {
            this.f11779qdMbNW[i] = false;
        }
        boolean z2 = false;
        int i2 = 0;
        while (!z2) {
            i2++;
            if (i2 >= this.f11768Dt * 2) {
                return i2;
            }
            if (mjfkc.mo11036getKey() != null) {
                this.f11779qdMbNW[mjfkc.mo11036getKey().f11984wA] = true;
            }
            C3274Z6 c3274z6Mo9471AZxh = mjfkc.mo9471AZxh(this, this.f11779qdMbNW);
            if (c3274z6Mo9471AZxh != null) {
                boolean[] zArr = this.f11779qdMbNW;
                int i3 = c3274z6Mo9471AZxh.f11984wA;
                if (zArr[i3]) {
                    return i2;
                }
                zArr[i3] = true;
            }
            if (c3274z6Mo9471AZxh != null) {
                float f = Float.MAX_VALUE;
                int i4 = -1;
                for (int i5 = 0; i5 < this.f11769ETF; i5++) {
                    C4955yX c4955yX = this.f11770JHa[i5];
                    if (c4955yX.f17532mjFkc.f11973Dt != C3274Z6.mjFkc.UNRESTRICTED && !c4955yX.f17529JHa && c4955yX.m14028diqgf(c3274z6Mo9471AZxh)) {
                        float fMo11294xJ = c4955yX.f17530KLFTb.mo11294xJ(c3274z6Mo9471AZxh);
                        if (fMo11294xJ < 0.0f) {
                            float f2 = (-c4955yX.f17528AZxh) / fMo11294xJ;
                            if (f2 < f) {
                                i4 = i5;
                                f = f2;
                            }
                        }
                    }
                }
                if (i4 > -1) {
                    C4955yX c4955yX2 = this.f11770JHa[i4];
                    c4955yX2.f17532mjFkc.f11980ZfxDd = -1;
                    c4955yX2.m14017HGpJ(c3274z6Mo9471AZxh);
                    C3274Z6 c3274z6 = c4955yX2.f17532mjFkc;
                    c3274z6.f11980ZfxDd = i4;
                    c3274z6.m11180xJ(c4955yX2);
                }
            } else {
                z2 = true;
            }
        }
        return i2;
    }

    /* renamed from: Dt */
    public void m11010Dt(C3274Z6 c3274z6, C3274Z6 c3274z62, int i, int i2) {
        C4955yX c4955yXM11014IEE = m11014IEE();
        C3274Z6 c3274z6M11023diqgf = m11023diqgf();
        c3274z6M11023diqgf.f11976KLFTb = 0;
        c4955yXM11014IEE.m14033qGY(c3274z6, c3274z62, c3274z6M11023diqgf, i);
        if (i2 != 8) {
            m11017MiMN(c4955yXM11014IEE, (int) (c4955yXM11014IEE.f17530KLFTb.mo11294xJ(c3274z6M11023diqgf) * (-1.0f)), i2);
        }
        m11022ZfxDd(c4955yXM11014IEE);
    }

    /* renamed from: ETF */
    public void m11011ETF(C3274Z6 c3274z6, C3274Z6 c3274z62, C3274Z6 c3274z63, C3274Z6 c3274z64, float f, int i) {
        C4955yX c4955yXM11014IEE = m11014IEE();
        c4955yXM11014IEE.m14015ETF(c3274z6, c3274z62, c3274z63, c3274z64, f);
        if (i != 8) {
            c4955yXM11014IEE.m14027ZfxDd(this, i);
        }
        m11022ZfxDd(c4955yXM11014IEE);
    }

    /* renamed from: Gd */
    public int m11012Gd(Object obj) {
        C3274Z6 c3274z6M13312JHa = ((C4446qtZIjO) obj).m13312JHa();
        if (c3274z6M13312JHa != null) {
            return (int) (c3274z6M13312JHa.f11975JHa + 0.5f);
        }
        return 0;
    }

    /* renamed from: HGpJ */
    public final void m11013HGpJ() {
        int i = this.f11775ZfxDd * 2;
        this.f11775ZfxDd = i;
        this.f11770JHa = (C4955yX[]) Arrays.copyOf(this.f11770JHa, i);
        C2768RWyiuY c2768RWyiuY = this.f11772MiMN;
        c2768RWyiuY.f10435ZfxDd = (C3274Z6[]) Arrays.copyOf(c2768RWyiuY.f10435ZfxDd, this.f11775ZfxDd);
        int i2 = this.f11775ZfxDd;
        this.f11779qdMbNW = new boolean[i2];
        this.f11771KLFTb = i2;
        this.f11773VA = i2;
    }

    /* renamed from: IEE */
    public C4955yX m11014IEE() {
        C4955yX c4955yX;
        if (f11763IEE) {
            c4955yX = (C4955yX) this.f11772MiMN.f10436mjFkc.mo7658AZxh();
            if (c4955yX == null) {
                c4955yX = new AZxh(this.f11772MiMN);
                f11765diqgf++;
            } else {
                c4955yX.m14036vI();
            }
        } else {
            c4955yX = (C4955yX) this.f11772MiMN.f10434AZxh.mo7658AZxh();
            if (c4955yX == null) {
                c4955yX = new C4955yX(this.f11772MiMN);
                f11764Pq++;
            } else {
                c4955yX.m14036vI();
            }
        }
        C3274Z6.m11174AZxh();
        return c4955yX;
    }

    /* renamed from: JHa */
    public void m11015JHa(C3274Z6 c3274z6, int i) {
        int i2 = c3274z6.f11980ZfxDd;
        if (i2 == -1) {
            c3274z6.m11176KLFTb(this, i);
            return;
        }
        if (i2 == -1) {
            C4955yX c4955yXM11014IEE = m11014IEE();
            c4955yXM11014IEE.m14034qdMbNW(c3274z6, i);
            m11022ZfxDd(c4955yXM11014IEE);
            return;
        }
        C4955yX c4955yX = this.f11770JHa[i2];
        if (c4955yX.f17529JHa) {
            c4955yX.f17528AZxh = i;
            return;
        }
        if (c4955yX.f17530KLFTb.mo11285ZfxDd() == 0) {
            c4955yX.f17529JHa = true;
            c4955yX.f17528AZxh = i;
        } else {
            C4955yX c4955yXM11014IEE2 = m11014IEE();
            c4955yXM11014IEE2.m14021MiMN(c3274z6, i);
            m11022ZfxDd(c4955yXM11014IEE2);
        }
    }

    /* renamed from: KLFTb */
    public C4955yX m11016KLFTb(C3274Z6 c3274z6, C3274Z6 c3274z62, int i, int i2) {
        if (i2 == 8 && c3274z62.f11985xJ && c3274z6.f11980ZfxDd == -1) {
            c3274z6.m11176KLFTb(this, c3274z62.f11975JHa + i);
            return null;
        }
        C4955yX c4955yXM11014IEE = m11014IEE();
        c4955yXM11014IEE.m14026YoKzxo(c3274z6, c3274z62, i);
        if (i2 != 8) {
            c4955yXM11014IEE.m14027ZfxDd(this, i2);
        }
        m11022ZfxDd(c4955yXM11014IEE);
        return c4955yXM11014IEE;
    }

    /* renamed from: MiMN */
    public void m11017MiMN(C4955yX c4955yX, int i, int i2) {
        c4955yX.m14020KLFTb(m11031rkYL(i2, null), i);
    }

    /* renamed from: Ucbh */
    public C2768RWyiuY m11018Ucbh() {
        return this.f11772MiMN;
    }

    /* renamed from: VA */
    public final void m11019VA(C4955yX c4955yX) {
        if (f11763IEE) {
            C4955yX c4955yX2 = this.f11770JHa[this.f11769ETF];
            if (c4955yX2 != null) {
                this.f11772MiMN.f10436mjFkc.mo7659mjFkc(c4955yX2);
            }
        } else {
            C4955yX c4955yX3 = this.f11770JHa[this.f11769ETF];
            if (c4955yX3 != null) {
                this.f11772MiMN.f10434AZxh.mo7659mjFkc(c4955yX3);
            }
        }
        C4955yX[] c4955yXArr = this.f11770JHa;
        int i = this.f11769ETF;
        c4955yXArr[i] = c4955yX;
        C3274Z6 c3274z6 = c4955yX.f17532mjFkc;
        c3274z6.f11980ZfxDd = i;
        this.f11769ETF = i + 1;
        c3274z6.m11180xJ(c4955yX);
    }

    /* renamed from: VocHEe */
    public void m11020VocHEe(mjFkc mjfkc) {
        m11024eyqo(mjfkc);
        m11009BAnRFn(mjfkc, false);
        m11021YoKzxo();
    }

    /* renamed from: YoKzxo */
    public final void m11021YoKzxo() {
        for (int i = 0; i < this.f11769ETF; i++) {
            C4955yX c4955yX = this.f11770JHa[i];
            c4955yX.f17532mjFkc.f11975JHa = c4955yX.f17528AZxh;
        }
    }

    /* renamed from: ZfxDd */
    public void m11022ZfxDd(C4955yX c4955yX) {
        C3274Z6 c3274z6M14031huTpC;
        if (c4955yX == null) {
            return;
        }
        boolean z = true;
        if (this.f11769ETF + 1 >= this.f11773VA || this.f11768Dt + 1 >= this.f11771KLFTb) {
            m11013HGpJ();
        }
        boolean z2 = false;
        if (!c4955yX.f17529JHa) {
            c4955yX.m14037wJVbdd(this);
            if (c4955yX.m14029eyqo()) {
                return;
            }
            c4955yX.m14018IEE();
            if (c4955yX.m14019JHa(this)) {
                C3274Z6 c3274z6M11029qGY = m11029qGY();
                c4955yX.f17532mjFkc = c3274z6M11029qGY;
                m11019VA(c4955yX);
                this.f11778qGY.mo11037wA(c4955yX);
                m11009BAnRFn(this.f11778qGY, true);
                if (c3274z6M11029qGY.f11980ZfxDd == -1) {
                    if (c4955yX.f17532mjFkc == c3274z6M11029qGY && (c3274z6M14031huTpC = c4955yX.m14031huTpC(c3274z6M11029qGY)) != null) {
                        c4955yX.m14017HGpJ(c3274z6M14031huTpC);
                    }
                    if (!c4955yX.f17529JHa) {
                        c4955yX.f17532mjFkc.m11180xJ(c4955yX);
                    }
                    this.f11769ETF--;
                }
            } else {
                z = false;
            }
            if (!c4955yX.m14022Pq()) {
                return;
            } else {
                z2 = z;
            }
        }
        if (z2) {
            return;
        }
        m11019VA(c4955yX);
    }

    /* renamed from: diqgf */
    public C3274Z6 m11023diqgf() {
        if (this.f11768Dt + 1 >= this.f11771KLFTb) {
            m11013HGpJ();
        }
        C3274Z6 c3274z6M11028mjFkc = m11028mjFkc(C3274Z6.mjFkc.SLACK, null);
        int i = this.f11777mjFkc + 1;
        this.f11777mjFkc = i;
        this.f11768Dt++;
        c3274z6M11028mjFkc.f11984wA = i;
        this.f11772MiMN.f10435ZfxDd[i] = c3274z6M11028mjFkc;
        return c3274z6M11028mjFkc;
    }

    /* renamed from: eyqo */
    public final int m11024eyqo(mjFkc mjfkc) {
        for (int i = 0; i < this.f11769ETF; i++) {
            C4955yX c4955yX = this.f11770JHa[i];
            if (c4955yX.f17532mjFkc.f11973Dt != C3274Z6.mjFkc.UNRESTRICTED && c4955yX.f17528AZxh < 0.0f) {
                boolean z = false;
                int i2 = 0;
                while (!z) {
                    i2++;
                    float f = Float.MAX_VALUE;
                    int i3 = -1;
                    int i4 = -1;
                    int i5 = 0;
                    int i6 = 0;
                    while (true) {
                        if (i5 >= this.f11769ETF) {
                            break;
                        }
                        C4955yX c4955yX2 = this.f11770JHa[i5];
                        if (c4955yX2.f17532mjFkc.f11973Dt != C3274Z6.mjFkc.UNRESTRICTED && !c4955yX2.f17529JHa && c4955yX2.f17528AZxh < 0.0f) {
                            for (int i7 = 1; i7 < this.f11768Dt; i7++) {
                                C3274Z6 c3274z6 = this.f11772MiMN.f10435ZfxDd[i7];
                                float fMo11294xJ = c4955yX2.f17530KLFTb.mo11294xJ(c3274z6);
                                if (fMo11294xJ > 0.0f) {
                                    for (int i8 = 0; i8 < 9; i8++) {
                                        float f2 = c3274z6.f11981lgHUyS[i8] / fMo11294xJ;
                                        if ((f2 < f && i8 == i6) || i8 > i6) {
                                            f = f2;
                                            i3 = i5;
                                            i4 = i7;
                                            i6 = i8;
                                        }
                                    }
                                }
                            }
                        }
                        i5++;
                    }
                    if (i3 != -1) {
                        C4955yX c4955yX3 = this.f11770JHa[i3];
                        c4955yX3.f17532mjFkc.f11980ZfxDd = -1;
                        c4955yX3.m14017HGpJ(this.f11772MiMN.f10435ZfxDd[i4]);
                        C3274Z6 c3274z62 = c4955yX3.f17532mjFkc;
                        c3274z62.f11980ZfxDd = i3;
                        c3274z62.m11180xJ(c4955yX3);
                    } else {
                        z = true;
                    }
                    if (i2 > this.f11768Dt / 2) {
                        z = true;
                    }
                }
                return i2;
            }
        }
        return 0;
    }

    /* renamed from: fehf */
    public C3274Z6 m11025fehf(Object obj) {
        C3274Z6 c3274z6M13312JHa = null;
        if (obj == null) {
            return null;
        }
        if (this.f11768Dt + 1 >= this.f11771KLFTb) {
            m11013HGpJ();
        }
        if (obj instanceof C4446qtZIjO) {
            C4446qtZIjO c4446qtZIjO = (C4446qtZIjO) obj;
            c3274z6M13312JHa = c4446qtZIjO.m13312JHa();
            if (c3274z6M13312JHa == null) {
                c4446qtZIjO.m13314MiMN(this.f11772MiMN);
                c3274z6M13312JHa = c4446qtZIjO.m13312JHa();
            }
            int i = c3274z6M13312JHa.f11984wA;
            if (i == -1 || i > this.f11777mjFkc || this.f11772MiMN.f10435ZfxDd[i] == null) {
                if (i != -1) {
                    c3274z6M13312JHa.m11177ZfxDd();
                }
                int i2 = this.f11777mjFkc + 1;
                this.f11777mjFkc = i2;
                this.f11768Dt++;
                c3274z6M13312JHa.f11984wA = i2;
                c3274z6M13312JHa.f11973Dt = C3274Z6.mjFkc.UNRESTRICTED;
                this.f11772MiMN.f10435ZfxDd[i2] = c3274z6M13312JHa;
            }
        }
        return c3274z6M13312JHa;
    }

    /* renamed from: lB */
    public final void m11026lB() {
        int i = 0;
        if (f11763IEE) {
            while (true) {
                C4955yX[] c4955yXArr = this.f11770JHa;
                if (i >= c4955yXArr.length) {
                    return;
                }
                C4955yX c4955yX = c4955yXArr[i];
                if (c4955yX != null) {
                    this.f11772MiMN.f10436mjFkc.mo7659mjFkc(c4955yX);
                }
                this.f11770JHa[i] = null;
                i++;
            }
        } else {
            while (true) {
                C4955yX[] c4955yXArr2 = this.f11770JHa;
                if (i >= c4955yXArr2.length) {
                    return;
                }
                C4955yX c4955yX2 = c4955yXArr2[i];
                if (c4955yX2 != null) {
                    this.f11772MiMN.f10434AZxh.mo7659mjFkc(c4955yX2);
                }
                this.f11770JHa[i] = null;
                i++;
            }
        }
    }

    /* renamed from: lgHUyS */
    public void m11027lgHUyS(C3274Z6 c3274z6, C3274Z6 c3274z62, int i, int i2) {
        C4955yX c4955yXM11014IEE = m11014IEE();
        C3274Z6 c3274z6M11023diqgf = m11023diqgf();
        c3274z6M11023diqgf.f11976KLFTb = 0;
        c4955yXM11014IEE.m14035rkYL(c3274z6, c3274z62, c3274z6M11023diqgf, i);
        if (i2 != 8) {
            m11017MiMN(c4955yXM11014IEE, (int) (c4955yXM11014IEE.f17530KLFTb.mo11294xJ(c3274z6M11023diqgf) * (-1.0f)), i2);
        }
        m11022ZfxDd(c4955yXM11014IEE);
    }

    /* renamed from: mjFkc */
    public final C3274Z6 m11028mjFkc(C3274Z6.mjFkc mjfkc, String str) {
        C3274Z6 c3274z6 = (C3274Z6) this.f11772MiMN.f10437wA.mo7658AZxh();
        if (c3274z6 == null) {
            c3274z6 = new C3274Z6(mjfkc, str);
            c3274z6.m11175JHa(mjfkc, str);
        } else {
            c3274z6.m11177ZfxDd();
            c3274z6.m11175JHa(mjfkc, str);
        }
        int i = this.f11780rkYL;
        int i2 = f11766fehf;
        if (i >= i2) {
            int i3 = i2 * 2;
            f11766fehf = i3;
            this.f11774YoKzxo = (C3274Z6[]) Arrays.copyOf(this.f11774YoKzxo, i3);
        }
        C3274Z6[] c3274z6Arr = this.f11774YoKzxo;
        int i4 = this.f11780rkYL;
        this.f11780rkYL = i4 + 1;
        c3274z6Arr[i4] = c3274z6;
        return c3274z6;
    }

    /* renamed from: qGY */
    public C3274Z6 m11029qGY() {
        if (this.f11768Dt + 1 >= this.f11771KLFTb) {
            m11013HGpJ();
        }
        C3274Z6 c3274z6M11028mjFkc = m11028mjFkc(C3274Z6.mjFkc.SLACK, null);
        int i = this.f11777mjFkc + 1;
        this.f11777mjFkc = i;
        this.f11768Dt++;
        c3274z6M11028mjFkc.f11984wA = i;
        this.f11772MiMN.f10435ZfxDd[i] = c3274z6M11028mjFkc;
        return c3274z6M11028mjFkc;
    }

    /* renamed from: qdMbNW */
    public void m11030qdMbNW(C3274Z6 c3274z6, C3274Z6 c3274z62, int i, boolean z) {
        C4955yX c4955yXM11014IEE = m11014IEE();
        C3274Z6 c3274z6M11023diqgf = m11023diqgf();
        c3274z6M11023diqgf.f11976KLFTb = 0;
        c4955yXM11014IEE.m14033qGY(c3274z6, c3274z62, c3274z6M11023diqgf, i);
        m11022ZfxDd(c4955yXM11014IEE);
    }

    /* renamed from: rkYL */
    public C3274Z6 m11031rkYL(int i, String str) {
        if (this.f11768Dt + 1 >= this.f11771KLFTb) {
            m11013HGpJ();
        }
        C3274Z6 c3274z6M11028mjFkc = m11028mjFkc(C3274Z6.mjFkc.ERROR, str);
        int i2 = this.f11777mjFkc + 1;
        this.f11777mjFkc = i2;
        this.f11768Dt++;
        c3274z6M11028mjFkc.f11984wA = i2;
        c3274z6M11028mjFkc.f11976KLFTb = i;
        this.f11772MiMN.f10435ZfxDd[i2] = c3274z6M11028mjFkc;
        this.f11781wA.mo9476mjFkc(c3274z6M11028mjFkc);
        return c3274z6M11028mjFkc;
    }

    /* renamed from: vI */
    public void m11032vI() {
        if (!this.f11782xJ && !this.f11776lgHUyS) {
            m11020VocHEe(this.f11781wA);
            return;
        }
        for (int i = 0; i < this.f11769ETF; i++) {
            if (!this.f11770JHa[i].f17529JHa) {
                m11020VocHEe(this.f11781wA);
                return;
            }
        }
        m11021YoKzxo();
    }

    /* renamed from: wA */
    public void m11033wA(C3274Z6 c3274z6, C3274Z6 c3274z62, int i, float f, C3274Z6 c3274z63, C3274Z6 c3274z64, int i2, int i3) {
        C4955yX c4955yXM11014IEE = m11014IEE();
        c4955yXM11014IEE.m14032lgHUyS(c3274z6, c3274z62, i, f, c3274z63, c3274z64, i2);
        if (i3 != 8) {
            c4955yXM11014IEE.m14027ZfxDd(this, i3);
        }
        m11022ZfxDd(c4955yXM11014IEE);
    }

    /* renamed from: wJVbdd */
    public void m11034wJVbdd() {
        C2768RWyiuY c2768RWyiuY;
        int i = 0;
        while (true) {
            c2768RWyiuY = this.f11772MiMN;
            C3274Z6[] c3274z6Arr = c2768RWyiuY.f10435ZfxDd;
            if (i >= c3274z6Arr.length) {
                break;
            }
            C3274Z6 c3274z6 = c3274z6Arr[i];
            if (c3274z6 != null) {
                c3274z6.m11177ZfxDd();
            }
            i++;
        }
        c2768RWyiuY.f10437wA.mo7660wA(this.f11774YoKzxo, this.f11780rkYL);
        this.f11780rkYL = 0;
        Arrays.fill(this.f11772MiMN.f10435ZfxDd, (Object) null);
        HashMap map = this.f11767AZxh;
        if (map != null) {
            map.clear();
        }
        this.f11777mjFkc = 0;
        this.f11781wA.mo9474clear();
        this.f11768Dt = 1;
        for (int i2 = 0; i2 < this.f11769ETF; i2++) {
            this.f11770JHa[i2].f17533wA = false;
        }
        m11026lB();
        this.f11769ETF = 0;
        if (f11763IEE) {
            this.f11778qGY = new AZxh(this.f11772MiMN);
        } else {
            this.f11778qGY = new C4955yX(this.f11772MiMN);
        }
    }

    /* renamed from: xJ */
    public void m11035xJ(C3274Z6 c3274z6, C3274Z6 c3274z62, int i, boolean z) {
        C4955yX c4955yXM11014IEE = m11014IEE();
        C3274Z6 c3274z6M11023diqgf = m11023diqgf();
        c3274z6M11023diqgf.f11976KLFTb = 0;
        c4955yXM11014IEE.m14035rkYL(c3274z6, c3274z62, c3274z6M11023diqgf, i);
        m11022ZfxDd(c4955yXM11014IEE);
    }
}
