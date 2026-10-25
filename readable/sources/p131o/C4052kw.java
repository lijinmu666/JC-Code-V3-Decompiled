package p131o;

import java.util.ArrayList;
import java.util.Arrays;
import p131o.C3582dkKKW;
import p131o.C3776gjvQ;

/* renamed from: o.kw */
/* loaded from: classes.dex */
public class C4052kw extends AbstractC2173Ia {

    /* renamed from: XFUzSY */
    public int f14634XFUzSY;

    /* renamed from: XtE */
    public int f14636XtE;

    /* renamed from: jx */
    public int f14643jx;

    /* renamed from: uH */
    public int f14648uH;

    /* renamed from: yX */
    public C3582dkKKW f14649yX = new C3582dkKKW(this);

    /* renamed from: gYa */
    public C2765RV f14639gYa = new C2765RV(this);

    /* renamed from: LREOK */
    public C3582dkKKW.AZxh f14628LREOK = null;

    /* renamed from: fFz */
    public boolean f14637fFz = false;

    /* renamed from: XbiWeM */
    public C3202Y0 f14635XbiWeM = new C3202Y0();

    /* renamed from: tISON */
    public int f14647tISON = 0;

    /* renamed from: Vgyli */
    public int f14631Vgyli = 0;

    /* renamed from: lti */
    public C1957FOJ[] f14644lti = new C1957FOJ[4];

    /* renamed from: giT */
    public C1957FOJ[] f14640giT = new C1957FOJ[4];

    /* renamed from: sRqPfw */
    public boolean f14646sRqPfw = false;

    /* renamed from: XD */
    public boolean f14632XD = false;

    /* renamed from: gtr */
    public boolean f14641gtr = false;

    /* renamed from: Dp */
    public int f14627Dp = 0;

    /* renamed from: fLidf */
    public int f14638fLidf = 0;

    /* renamed from: hvGY */
    public int f14642hvGY = 263;

    /* renamed from: Rc */
    public boolean f14629Rc = false;

    /* renamed from: SKTn */
    public boolean f14630SKTn = false;

    /* renamed from: rdJr */
    public boolean f14645rdJr = false;

    /* renamed from: XDdeP */
    public int f14633XDdeP = 0;

    /* renamed from: Dp */
    public void m12609Dp(C3776gjvQ c3776gjvQ, int i) {
        if (i == 0) {
            m12627hvGY(c3776gjvQ);
        } else if (i == 1) {
            m12617Rc(c3776gjvQ);
        }
    }

    /* renamed from: FbxKQm */
    public int m12610FbxKQm() {
        return this.f14642hvGY;
    }

    /* renamed from: IvRQOa */
    public void m12611IvRQOa() {
        this.f14649yX.m11740KLFTb(this);
    }

    /* renamed from: IyS */
    public void m12612IyS() {
        this.f14639gYa.m10070ETF();
    }

    /* renamed from: Jidt */
    public void m12613Jidt(C3202Y0 c3202y0, boolean[] zArr) {
        zArr[2] = false;
        mo12074giT(c3202y0);
        int size = this.f8762tjSezt.size();
        for (int i = 0; i < size; i++) {
            ((C3776gjvQ) this.f8762tjSezt.get(i)).mo12074giT(c3202y0);
        }
    }

    /* renamed from: Jk */
    public boolean m12614Jk(int i) {
        return (this.f14642hvGY & i) == i;
    }

    @Override // p131o.AbstractC2173Ia, p131o.C3776gjvQ
    /* renamed from: JrJO */
    public void mo8790JrJO() {
        this.f14635XbiWeM.m11034wJVbdd();
        this.f14634XFUzSY = 0;
        this.f14643jx = 0;
        this.f14636XtE = 0;
        this.f14648uH = 0;
        this.f14629Rc = false;
        super.mo8790JrJO();
    }

    /* renamed from: KRckQg */
    public final void m12615KRckQg() {
        this.f14647tISON = 0;
        this.f14631Vgyli = 0;
    }

    /* renamed from: NV */
    public void m12616NV(boolean z) {
        this.f14637fFz = z;
    }

    /* renamed from: Rc */
    public final void m12617Rc(C3776gjvQ c3776gjvQ) {
        int i = this.f14631Vgyli + 1;
        C1957FOJ[] c1957fojArr = this.f14644lti;
        if (i >= c1957fojArr.length) {
            this.f14644lti = (C1957FOJ[]) Arrays.copyOf(c1957fojArr, c1957fojArr.length * 2);
        }
        this.f14644lti[this.f14631Vgyli] = new C1957FOJ(c3776gjvQ, 1, m12623dGDT());
        this.f14631Vgyli++;
    }

    /* renamed from: SKTn */
    public boolean m12618SKTn(boolean z) {
        return this.f14639gYa.m10071JHa(z);
    }

    /* renamed from: XDdeP */
    public boolean m12619XDdeP(boolean z, int i) {
        return this.f14639gYa.m10077lgHUyS(z, i);
    }

    /* renamed from: XgAT */
    public void m12620XgAT() {
        this.f14639gYa.m10069Dt();
    }

    /* renamed from: Xxz */
    public boolean m12621Xxz() {
        return this.f14630SKTn;
    }

    /* renamed from: Zdbk */
    public long m12622Zdbk(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.f14634XFUzSY = i8;
        this.f14636XtE = i9;
        return this.f14649yX.m11741ZfxDd(this, i, i8, i9, i2, i3, i4, i5, i6, i7);
    }

    /* renamed from: dGDT */
    public boolean m12623dGDT() {
        return this.f14637fFz;
    }

    /* renamed from: dkKKW */
    public void m12624dkKKW(int i) {
        this.f14642hvGY = i;
        C3202Y0.f11763IEE = AbstractC3861i3.m12277AZxh(i, 256);
    }

    /* renamed from: eQ */
    public C3582dkKKW.AZxh m12625eQ() {
        return this.f14628LREOK;
    }

    /* renamed from: fLidf */
    public boolean m12626fLidf(C3202Y0 c3202y0) {
        mo9028JHa(c3202y0);
        int size = this.f8762tjSezt.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            C3776gjvQ c3776gjvQ = (C3776gjvQ) this.f8762tjSezt.get(i);
            c3776gjvQ.m12032IVlxe(0, false);
            c3776gjvQ.m12032IVlxe(1, false);
            if (c3776gjvQ instanceof C2257Jk) {
                z = true;
            }
        }
        if (z) {
            for (int i2 = 0; i2 < size; i2++) {
                C3776gjvQ c3776gjvQ2 = (C3776gjvQ) this.f8762tjSezt.get(i2);
                if (c3776gjvQ2 instanceof C2257Jk) {
                    ((C2257Jk) c3776gjvQ2).m9027Dp();
                }
            }
        }
        for (int i3 = 0; i3 < size; i3++) {
            C3776gjvQ c3776gjvQ3 = (C3776gjvQ) this.f8762tjSezt.get(i3);
            if (c3776gjvQ3.m12036KLFTb()) {
                c3776gjvQ3.mo9028JHa(c3202y0);
            }
        }
        for (int i4 = 0; i4 < size; i4++) {
            C3776gjvQ c3776gjvQ4 = (C3776gjvQ) this.f8762tjSezt.get(i4);
            if (c3776gjvQ4 instanceof C4052kw) {
                C3776gjvQ.AZxh[] aZxhArr = c3776gjvQ4.f13821rWxwaT;
                C3776gjvQ.AZxh aZxh = aZxhArr[0];
                C3776gjvQ.AZxh aZxh2 = aZxhArr[1];
                C3776gjvQ.AZxh aZxh3 = C3776gjvQ.AZxh.WRAP_CONTENT;
                if (aZxh == aZxh3) {
                    c3776gjvQ4.m12102yfx(C3776gjvQ.AZxh.FIXED);
                }
                if (aZxh2 == aZxh3) {
                    c3776gjvQ4.m12071fFz(C3776gjvQ.AZxh.FIXED);
                }
                c3776gjvQ4.mo9028JHa(c3202y0);
                if (aZxh == aZxh3) {
                    c3776gjvQ4.m12102yfx(aZxh);
                }
                if (aZxh2 == aZxh3) {
                    c3776gjvQ4.m12071fFz(aZxh2);
                }
            } else {
                AbstractC3861i3.m12278mjFkc(this, c3202y0, c3776gjvQ4);
                if (!c3776gjvQ4.m12036KLFTb()) {
                    c3776gjvQ4.mo9028JHa(c3202y0);
                }
            }
        }
        if (this.f14647tISON > 0) {
            AbstractC4752vUsV.m13781mjFkc(this, c3202y0, 0);
        }
        if (this.f14631Vgyli > 0) {
            AbstractC4752vUsV.m13781mjFkc(this, c3202y0, 1);
        }
        return true;
    }

    /* renamed from: hvGY */
    public final void m12627hvGY(C3776gjvQ c3776gjvQ) {
        int i = this.f14647tISON + 1;
        C1957FOJ[] c1957fojArr = this.f14640giT;
        if (i >= c1957fojArr.length) {
            this.f14640giT = (C1957FOJ[]) Arrays.copyOf(c1957fojArr, c1957fojArr.length * 2);
        }
        this.f14640giT[this.f14647tISON] = new C1957FOJ(c3776gjvQ, 0, m12623dGDT());
        this.f14647tISON++;
    }

    /* renamed from: jtz */
    public boolean m12628jtz() {
        return false;
    }

    @Override // p131o.C3776gjvQ
    /* renamed from: lti */
    public void mo12082lti(boolean z, boolean z2) {
        super.mo12082lti(z, z2);
        int size = this.f8762tjSezt.size();
        for (int i = 0; i < size; i++) {
            ((C3776gjvQ) this.f8762tjSezt.get(i)).mo12082lti(z, z2);
        }
    }

    /* renamed from: mPWV */
    public void m12629mPWV(C3582dkKKW.AZxh aZxh) {
        this.f14628LREOK = aZxh;
        this.f14639gYa.m10075YoKzxo(aZxh);
    }

    /* renamed from: rdJr */
    public boolean m12630rdJr(boolean z) {
        return this.f14639gYa.m10081xJ(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x01c8 A[PHI: r0 r5
      0x01c8: PHI (r0v26 boolean) = (r0v25 boolean), (r0v28 boolean), (r0v28 boolean), (r0v28 boolean) binds: [B:70:0x018d, B:78:0x01b0, B:79:0x01b2, B:81:0x01b8] A[DONT_GENERATE, DONT_INLINE]
      0x01c8: PHI (r5v11 boolean) = (r5v10 boolean), (r5v13 boolean), (r5v13 boolean), (r5v13 boolean) binds: [B:70:0x018d, B:78:0x01b0, B:79:0x01b2, B:81:0x01b8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r11v9, types: [boolean] */
    @Override // p131o.AbstractC2173Ia
    /* renamed from: sRqPfw */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo8794sRqPfw() {
        boolean z;
        ?? r11;
        boolean z2;
        this.f13798WrLQs = 0;
        this.f13780KRTLGT = 0;
        int iMax = Math.max(0, m12096vadzgd());
        int iMax2 = Math.max(0, m12051Ucbh());
        this.f14630SKTn = false;
        this.f14645rdJr = false;
        boolean z3 = m12614Jk(64) || m12614Jk(128);
        C3202Y0 c3202y0 = this.f14635XbiWeM;
        c3202y0.f11782xJ = false;
        c3202y0.f11776lgHUyS = false;
        if (this.f14642hvGY != 0 && z3) {
            c3202y0.f11776lgHUyS = true;
        }
        C3776gjvQ.AZxh[] aZxhArr = this.f13821rWxwaT;
        C3776gjvQ.AZxh aZxh = aZxhArr[1];
        C3776gjvQ.AZxh aZxh2 = aZxhArr[0];
        ArrayList arrayList = this.f8762tjSezt;
        C3776gjvQ.AZxh aZxhM12030HGpJ = m12030HGpJ();
        C3776gjvQ.AZxh aZxh3 = C3776gjvQ.AZxh.WRAP_CONTENT;
        boolean z4 = aZxhM12030HGpJ == aZxh3 || m12088rWxwaT() == aZxh3;
        m12615KRckQg();
        int size = this.f8762tjSezt.size();
        for (int i = 0; i < size; i++) {
            C3776gjvQ c3776gjvQ = (C3776gjvQ) this.f8762tjSezt.get(i);
            if (c3776gjvQ instanceof AbstractC2173Ia) {
                ((AbstractC2173Ia) c3776gjvQ).mo8794sRqPfw();
            }
        }
        int i2 = 0;
        boolean z5 = false;
        boolean zM12626fLidf = true;
        while (zM12626fLidf) {
            int i3 = i2 + 1;
            try {
                this.f14635XbiWeM.m11034wJVbdd();
                m12615KRckQg();
                m12052VA(this.f14635XbiWeM);
                for (int i4 = 0; i4 < size; i4++) {
                    ((C3776gjvQ) this.f8762tjSezt.get(i4)).m12052VA(this.f14635XbiWeM);
                }
                zM12626fLidf = m12626fLidf(this.f14635XbiWeM);
                if (zM12626fLidf) {
                    this.f14635XbiWeM.m11032vI();
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("EXCEPTION : " + e);
            }
            if (zM12626fLidf) {
                m12613Jidt(this.f14635XbiWeM, AbstractC3861i3.f14101mjFkc);
            } else {
                mo12074giT(this.f14635XbiWeM);
                for (int i5 = 0; i5 < size; i5++) {
                    ((C3776gjvQ) this.f8762tjSezt.get(i5)).mo12074giT(this.f14635XbiWeM);
                }
            }
            if (z4 && i3 < 8 && AbstractC3861i3.f14101mjFkc[2]) {
                int iMax3 = 0;
                int iMax4 = 0;
                for (int i6 = 0; i6 < size; i6++) {
                    C3776gjvQ c3776gjvQ2 = (C3776gjvQ) this.f8762tjSezt.get(i6);
                    iMax3 = Math.max(iMax3, c3776gjvQ2.f13798WrLQs + c3776gjvQ2.m12096vadzgd());
                    iMax4 = Math.max(iMax4, c3776gjvQ2.f13780KRTLGT + c3776gjvQ2.m12051Ucbh());
                }
                int iMax5 = Math.max(this.f13817nxI, iMax3);
                int iMax6 = Math.max(this.f13797WGXroI, iMax4);
                C3776gjvQ.AZxh aZxh4 = C3776gjvQ.AZxh.WRAP_CONTENT;
                if (aZxh2 != aZxh4 || m12096vadzgd() >= iMax5) {
                    z = false;
                } else {
                    m12078jx(iMax5);
                    this.f13821rWxwaT[0] = aZxh4;
                    z = true;
                    z5 = true;
                }
                if (aZxh == aZxh4 && m12051Ucbh() < iMax6) {
                    m12023ANMGZc(iMax6);
                    this.f13821rWxwaT[1] = aZxh4;
                    z = true;
                    z5 = true;
                }
            } else {
                z = false;
            }
            int iMax7 = Math.max(this.f13817nxI, m12096vadzgd());
            if (iMax7 > m12096vadzgd()) {
                m12078jx(iMax7);
                this.f13821rWxwaT[0] = C3776gjvQ.AZxh.FIXED;
                z = true;
                z5 = true;
            }
            int iMax8 = Math.max(this.f13797WGXroI, m12051Ucbh());
            if (iMax8 > m12051Ucbh()) {
                m12023ANMGZc(iMax8);
                r11 = 1;
                this.f13821rWxwaT[1] = C3776gjvQ.AZxh.FIXED;
                z = true;
                z2 = true;
            } else {
                r11 = 1;
                z2 = z5;
            }
            if (!z2) {
                C3776gjvQ.AZxh aZxh5 = this.f13821rWxwaT[0];
                C3776gjvQ.AZxh aZxh6 = C3776gjvQ.AZxh.WRAP_CONTENT;
                if (aZxh5 == aZxh6 && iMax > 0 && m12096vadzgd() > iMax) {
                    this.f14630SKTn = r11;
                    this.f13821rWxwaT[0] = C3776gjvQ.AZxh.FIXED;
                    m12078jx(iMax);
                    z = r11;
                    z2 = z;
                }
                if (this.f13821rWxwaT[r11] != aZxh6 || iMax2 <= 0 || m12051Ucbh() <= iMax2) {
                    zM12626fLidf = z;
                    z5 = z2;
                } else {
                    this.f14645rdJr = r11;
                    this.f13821rWxwaT[r11] = C3776gjvQ.AZxh.FIXED;
                    m12023ANMGZc(iMax2);
                    zM12626fLidf = true;
                    z5 = true;
                }
            }
            i2 = i3;
        }
        this.f8762tjSezt = arrayList;
        if (z5) {
            C3776gjvQ.AZxh[] aZxhArr2 = this.f13821rWxwaT;
            aZxhArr2[0] = aZxh2;
            aZxhArr2[1] = aZxh;
        }
        mo8791WGXroI(this.f14635XbiWeM.m11018Ucbh());
    }

    /* renamed from: tAfC */
    public boolean m12631tAfC() {
        return this.f14645rdJr;
    }
}
