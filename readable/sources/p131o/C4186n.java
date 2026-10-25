package p131o;

import p131o.C3776gjvQ;
import p131o.C4446qtZIjO;

/* renamed from: o.n */
/* loaded from: classes.dex */
public class C4186n extends C3776gjvQ {

    /* renamed from: tjSezt */
    public float f15296tjSezt = -1.0f;

    /* renamed from: yX */
    public int f15297yX = -1;

    /* renamed from: gYa */
    public int f15295gYa = -1;

    /* renamed from: LREOK */
    public C4446qtZIjO f15292LREOK = this.f13813lB;

    /* renamed from: fFz */
    public int f15294fFz = 0;

    /* renamed from: XbiWeM */
    public int f15293XbiWeM = 0;

    /* renamed from: o.n$mjFkc */
    public static /* synthetic */ class mjFkc {

        /* renamed from: mjFkc */
        public static final /* synthetic */ int[] f15298mjFkc;

        static {
            int[] iArr = new int[C4446qtZIjO.AZxh.m13324values().length];
            f15298mjFkc = iArr;
            try {
                iArr[C4446qtZIjO.AZxh.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15298mjFkc[C4446qtZIjO.AZxh.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15298mjFkc[C4446qtZIjO.AZxh.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15298mjFkc[C4446qtZIjO.AZxh.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f15298mjFkc[C4446qtZIjO.AZxh.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f15298mjFkc[C4446qtZIjO.AZxh.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f15298mjFkc[C4446qtZIjO.AZxh.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f15298mjFkc[C4446qtZIjO.AZxh.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f15298mjFkc[C4446qtZIjO.AZxh.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public C4186n() {
        this.f13834zvd.clear();
        this.f13834zvd.add(this.f15292LREOK);
        int length = this.f13779KLMXS.length;
        for (int i = 0; i < length; i++) {
            this.f13779KLMXS[i] = this.f15292LREOK;
        }
    }

    /* renamed from: Dp */
    public float m12822Dp() {
        return this.f15296tjSezt;
    }

    @Override // p131o.C3776gjvQ
    /* renamed from: JHa */
    public void mo9028JHa(C3202Y0 c3202y0) {
        C4052kw c4052kw = (C4052kw) m12044Ne();
        if (c4052kw == null) {
            return;
        }
        C4446qtZIjO c4446qtZIjOMo12040MiMN = c4052kw.mo12040MiMN(C4446qtZIjO.AZxh.LEFT);
        C4446qtZIjO c4446qtZIjOMo12040MiMN2 = c4052kw.mo12040MiMN(C4446qtZIjO.AZxh.RIGHT);
        C3776gjvQ c3776gjvQ = this.f13795Vnb;
        boolean z = c3776gjvQ != null && c3776gjvQ.f13821rWxwaT[0] == C3776gjvQ.AZxh.WRAP_CONTENT;
        if (this.f15294fFz == 0) {
            c4446qtZIjOMo12040MiMN = c4052kw.mo12040MiMN(C4446qtZIjO.AZxh.TOP);
            c4446qtZIjOMo12040MiMN2 = c4052kw.mo12040MiMN(C4446qtZIjO.AZxh.BOTTOM);
            C3776gjvQ c3776gjvQ2 = this.f13795Vnb;
            z = c3776gjvQ2 != null && c3776gjvQ2.f13821rWxwaT[1] == C3776gjvQ.AZxh.WRAP_CONTENT;
        }
        if (this.f15297yX != -1) {
            C3274Z6 c3274z6M11025fehf = c3202y0.m11025fehf(this.f15292LREOK);
            c3202y0.m11016KLFTb(c3274z6M11025fehf, c3202y0.m11025fehf(c4446qtZIjOMo12040MiMN), this.f15297yX, 8);
            if (z) {
                c3202y0.m11027lgHUyS(c3202y0.m11025fehf(c4446qtZIjOMo12040MiMN2), c3274z6M11025fehf, 0, 5);
                return;
            }
            return;
        }
        if (this.f15295gYa == -1) {
            if (this.f15296tjSezt != -1.0f) {
                c3202y0.m11022ZfxDd(C3202Y0.m11006Pq(c3202y0, c3202y0.m11025fehf(this.f15292LREOK), c3202y0.m11025fehf(c4446qtZIjOMo12040MiMN2), this.f15296tjSezt));
                return;
            }
            return;
        }
        C3274Z6 c3274z6M11025fehf2 = c3202y0.m11025fehf(this.f15292LREOK);
        C3274Z6 c3274z6M11025fehf3 = c3202y0.m11025fehf(c4446qtZIjOMo12040MiMN2);
        c3202y0.m11016KLFTb(c3274z6M11025fehf2, c3274z6M11025fehf3, -this.f15295gYa, 8);
        if (z) {
            c3202y0.m11027lgHUyS(c3274z6M11025fehf2, c3202y0.m11025fehf(c4446qtZIjOMo12040MiMN), 0, 5);
            c3202y0.m11027lgHUyS(c3274z6M11025fehf3, c3274z6M11025fehf2, 0, 5);
        }
    }

    @Override // p131o.C3776gjvQ
    /* renamed from: MiMN */
    public C4446qtZIjO mo12040MiMN(C4446qtZIjO.AZxh aZxh) {
        switch (mjFkc.f15298mjFkc[aZxh.ordinal()]) {
            case 1:
            case 2:
                if (this.f15294fFz == 1) {
                    return this.f15292LREOK;
                }
                break;
            case 3:
            case 4:
                if (this.f15294fFz == 0) {
                    return this.f15292LREOK;
                }
                break;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
        }
        throw new AssertionError(aZxh.name());
    }

    /* renamed from: Rc */
    public void m12823Rc(float f) {
        if (f > -1.0f) {
            this.f15296tjSezt = f;
            this.f15297yX = -1;
            this.f15295gYa = -1;
        }
    }

    /* renamed from: SKTn */
    public void m12824SKTn(int i) {
        if (this.f15294fFz == i) {
            return;
        }
        this.f15294fFz = i;
        this.f13834zvd.clear();
        if (this.f15294fFz == 1) {
            this.f15292LREOK = this.f13764BAnRFn;
        } else {
            this.f15292LREOK = this.f13813lB;
        }
        this.f13834zvd.add(this.f15292LREOK);
        int length = this.f13779KLMXS.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.f13779KLMXS[i2] = this.f15292LREOK;
        }
    }

    /* renamed from: XD */
    public int m12825XD() {
        return this.f15297yX;
    }

    /* renamed from: fLidf */
    public void m12826fLidf(int i) {
        if (i > -1) {
            this.f15296tjSezt = -1.0f;
            this.f15297yX = i;
            this.f15295gYa = -1;
        }
    }

    @Override // p131o.C3776gjvQ
    /* renamed from: giT */
    public void mo12074giT(C3202Y0 c3202y0) {
        if (m12044Ne() == null) {
            return;
        }
        int iM11012Gd = c3202y0.m11012Gd(this.f15292LREOK);
        if (this.f15294fFz == 1) {
            m12093uH(iM11012Gd);
            m12090tISON(0);
            m12023ANMGZc(m12044Ne().m12051Ucbh());
            m12078jx(0);
            return;
        }
        m12093uH(0);
        m12090tISON(iM11012Gd);
        m12078jx(m12044Ne().m12096vadzgd());
        m12023ANMGZc(0);
    }

    /* renamed from: gtr */
    public int m12827gtr() {
        return this.f15295gYa;
    }

    /* renamed from: hvGY */
    public void m12828hvGY(int i) {
        if (i > -1) {
            this.f15296tjSezt = -1.0f;
            this.f15297yX = -1;
            this.f15295gYa = i;
        }
    }

    /* renamed from: sRqPfw */
    public int m12829sRqPfw() {
        return this.f15294fFz;
    }

    @Override // p131o.C3776gjvQ
    /* renamed from: xJ */
    public boolean mo9035xJ() {
        return true;
    }
}
