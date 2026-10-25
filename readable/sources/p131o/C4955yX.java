package p131o;

import java.util.ArrayList;
import java.util.Iterator;
import org.conscrypt.BuildConfig;
import p131o.C3202Y0;
import p131o.C3274Z6;

/* renamed from: o.yX */
/* loaded from: classes.dex */
public class C4955yX implements C3202Y0.mjFkc {

    /* renamed from: KLFTb */
    public mjFkc f17530KLFTb;

    /* renamed from: mjFkc */
    public C3274Z6 f17532mjFkc = null;

    /* renamed from: AZxh */
    public float f17528AZxh = 0.0f;

    /* renamed from: wA */
    public boolean f17533wA = false;

    /* renamed from: ZfxDd */
    public ArrayList f17531ZfxDd = new ArrayList();

    /* renamed from: JHa */
    public boolean f17529JHa = false;

    /* renamed from: o.yX$mjFkc */
    public interface mjFkc {
        /* renamed from: AZxh */
        void mo11276AZxh(C3274Z6 c3274z6, float f, boolean z);

        /* renamed from: Dt */
        float mo11277Dt(C3274Z6 c3274z6, boolean z);

        /* renamed from: ETF */
        void mo11278ETF();

        /* renamed from: JHa */
        float mo11280JHa(C4955yX c4955yX, boolean z);

        /* renamed from: KLFTb */
        boolean mo11281KLFTb(C3274Z6 c3274z6);

        /* renamed from: ZfxDd */
        int mo11285ZfxDd();

        /* renamed from: clear */
        void mo11286clear();

        /* renamed from: lgHUyS */
        C3274Z6 mo11288lgHUyS(int i);

        /* renamed from: mjFkc */
        float mo11289mjFkc(int i);

        /* renamed from: qdMbNW */
        void mo11291qdMbNW(float f);

        /* renamed from: wA */
        void mo11293wA(C3274Z6 c3274z6, float f);

        /* renamed from: xJ */
        float mo11294xJ(C3274Z6 c3274z6);
    }

    public C4955yX() {
    }

    @Override // p131o.C3202Y0.mjFkc
    /* renamed from: AZxh */
    public C3274Z6 mo9471AZxh(C3202Y0 c3202y0, boolean[] zArr) {
        return m14016Gd(zArr, null);
    }

    /* renamed from: BAnRFn */
    public void m14013BAnRFn(C3202Y0 c3202y0, C3274Z6 c3274z6, boolean z) {
        if (c3274z6.f11985xJ) {
            this.f17528AZxh += c3274z6.f11975JHa * this.f17530KLFTb.mo11294xJ(c3274z6);
            this.f17530KLFTb.mo11277Dt(c3274z6, z);
            if (z) {
                c3274z6.m11179wA(this);
            }
        }
    }

    /* renamed from: Dt */
    public C4955yX m14014Dt(C3274Z6 c3274z6, C3274Z6 c3274z62, float f) {
        this.f17530KLFTb.mo11293wA(c3274z6, -1.0f);
        this.f17530KLFTb.mo11293wA(c3274z62, f);
        return this;
    }

    /* renamed from: ETF */
    public C4955yX m14015ETF(C3274Z6 c3274z6, C3274Z6 c3274z62, C3274Z6 c3274z63, C3274Z6 c3274z64, float f) {
        this.f17530KLFTb.mo11293wA(c3274z6, -1.0f);
        this.f17530KLFTb.mo11293wA(c3274z62, 1.0f);
        this.f17530KLFTb.mo11293wA(c3274z63, f);
        this.f17530KLFTb.mo11293wA(c3274z64, -f);
        return this;
    }

    /* renamed from: Gd */
    public final C3274Z6 m14016Gd(boolean[] zArr, C3274Z6 c3274z6) {
        C3274Z6.mjFkc mjfkc;
        int iMo11285ZfxDd = this.f17530KLFTb.mo11285ZfxDd();
        C3274Z6 c3274z62 = null;
        float f = 0.0f;
        for (int i = 0; i < iMo11285ZfxDd; i++) {
            float fMo11289mjFkc = this.f17530KLFTb.mo11289mjFkc(i);
            if (fMo11289mjFkc < 0.0f) {
                C3274Z6 c3274z6Mo11288lgHUyS = this.f17530KLFTb.mo11288lgHUyS(i);
                if ((zArr == null || !zArr[c3274z6Mo11288lgHUyS.f11984wA]) && c3274z6Mo11288lgHUyS != c3274z6 && (((mjfkc = c3274z6Mo11288lgHUyS.f11973Dt) == C3274Z6.mjFkc.SLACK || mjfkc == C3274Z6.mjFkc.ERROR) && fMo11289mjFkc < f)) {
                    f = fMo11289mjFkc;
                    c3274z62 = c3274z6Mo11288lgHUyS;
                }
            }
        }
        return c3274z62;
    }

    /* renamed from: HGpJ */
    public void m14017HGpJ(C3274Z6 c3274z6) {
        C3274Z6 c3274z62 = this.f17532mjFkc;
        if (c3274z62 != null) {
            this.f17530KLFTb.mo11293wA(c3274z62, -1.0f);
            this.f17532mjFkc = null;
        }
        float fMo11277Dt = this.f17530KLFTb.mo11277Dt(c3274z6, true) * (-1.0f);
        this.f17532mjFkc = c3274z6;
        if (fMo11277Dt == 1.0f) {
            return;
        }
        this.f17528AZxh /= fMo11277Dt;
        this.f17530KLFTb.mo11291qdMbNW(fMo11277Dt);
    }

    /* renamed from: IEE */
    public void m14018IEE() {
        float f = this.f17528AZxh;
        if (f < 0.0f) {
            this.f17528AZxh = f * (-1.0f);
            this.f17530KLFTb.mo11278ETF();
        }
    }

    /* renamed from: JHa */
    public boolean m14019JHa(C3202Y0 c3202y0) {
        boolean z;
        C3274Z6 c3274z6M14038xJ = m14038xJ(c3202y0);
        if (c3274z6M14038xJ == null) {
            z = true;
        } else {
            m14017HGpJ(c3274z6M14038xJ);
            z = false;
        }
        if (this.f17530KLFTb.mo11285ZfxDd() == 0) {
            this.f17529JHa = true;
        }
        return z;
    }

    /* renamed from: KLFTb */
    public C4955yX m14020KLFTb(C3274Z6 c3274z6, int i) {
        this.f17530KLFTb.mo11293wA(c3274z6, i);
        return this;
    }

    /* renamed from: MiMN */
    public C4955yX m14021MiMN(C3274Z6 c3274z6, int i) {
        if (i < 0) {
            this.f17528AZxh = i * (-1);
            this.f17530KLFTb.mo11293wA(c3274z6, 1.0f);
        } else {
            this.f17528AZxh = i;
            this.f17530KLFTb.mo11293wA(c3274z6, -1.0f);
        }
        return this;
    }

    /* renamed from: Pq */
    public boolean m14022Pq() {
        C3274Z6 c3274z6 = this.f17532mjFkc;
        return c3274z6 != null && (c3274z6.f11973Dt == C3274Z6.mjFkc.UNRESTRICTED || this.f17528AZxh >= 0.0f);
    }

    /* renamed from: Ucbh */
    public final boolean m14023Ucbh(C3274Z6 c3274z6, C3202Y0 c3202y0) {
        return c3274z6.f11977MiMN <= 1;
    }

    /* renamed from: VA */
    public C4955yX m14024VA(float f, float f2, float f3, C3274Z6 c3274z6, C3274Z6 c3274z62, C3274Z6 c3274z63, C3274Z6 c3274z64) {
        this.f17528AZxh = 0.0f;
        if (f2 == 0.0f || f == f3) {
            this.f17530KLFTb.mo11293wA(c3274z6, 1.0f);
            this.f17530KLFTb.mo11293wA(c3274z62, -1.0f);
            this.f17530KLFTb.mo11293wA(c3274z64, 1.0f);
            this.f17530KLFTb.mo11293wA(c3274z63, -1.0f);
        } else if (f == 0.0f) {
            this.f17530KLFTb.mo11293wA(c3274z6, 1.0f);
            this.f17530KLFTb.mo11293wA(c3274z62, -1.0f);
        } else if (f3 == 0.0f) {
            this.f17530KLFTb.mo11293wA(c3274z63, 1.0f);
            this.f17530KLFTb.mo11293wA(c3274z64, -1.0f);
        } else {
            float f4 = (f / f2) / (f3 / f2);
            this.f17530KLFTb.mo11293wA(c3274z6, 1.0f);
            this.f17530KLFTb.mo11293wA(c3274z62, -1.0f);
            this.f17530KLFTb.mo11293wA(c3274z64, f4);
            this.f17530KLFTb.mo11293wA(c3274z63, -f4);
        }
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d0  */
    /* renamed from: VocHEe */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String m14025VocHEe() {
        boolean z;
        String str = (this.f17532mjFkc == null ? BuildConfig.f24315FLAVOR + "0" : BuildConfig.f24315FLAVOR + this.f17532mjFkc) + " = ";
        if (this.f17528AZxh != 0.0f) {
            str = str + this.f17528AZxh;
            z = true;
        } else {
            z = false;
        }
        int iMo11285ZfxDd = this.f17530KLFTb.mo11285ZfxDd();
        for (int i = 0; i < iMo11285ZfxDd; i++) {
            C3274Z6 c3274z6Mo11288lgHUyS = this.f17530KLFTb.mo11288lgHUyS(i);
            if (c3274z6Mo11288lgHUyS != null) {
                float fMo11289mjFkc = this.f17530KLFTb.mo11289mjFkc(i);
                if (fMo11289mjFkc != 0.0f) {
                    String string = c3274z6Mo11288lgHUyS.toString();
                    if (!z) {
                        if (fMo11289mjFkc < 0.0f) {
                            str = str + "- ";
                            fMo11289mjFkc *= -1.0f;
                        }
                        str = fMo11289mjFkc == 1.0f ? str + string : str + fMo11289mjFkc + " " + string;
                        z = true;
                    } else if (fMo11289mjFkc > 0.0f) {
                        str = str + " + ";
                        if (fMo11289mjFkc == 1.0f) {
                        }
                        z = true;
                    } else {
                        str = str + " - ";
                        fMo11289mjFkc *= -1.0f;
                        if (fMo11289mjFkc == 1.0f) {
                        }
                        z = true;
                    }
                }
            }
        }
        if (z) {
            return str;
        }
        return str + "0.0";
    }

    /* renamed from: YoKzxo */
    public C4955yX m14026YoKzxo(C3274Z6 c3274z6, C3274Z6 c3274z62, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f17528AZxh = i;
        }
        if (z) {
            this.f17530KLFTb.mo11293wA(c3274z6, 1.0f);
            this.f17530KLFTb.mo11293wA(c3274z62, -1.0f);
        } else {
            this.f17530KLFTb.mo11293wA(c3274z6, -1.0f);
            this.f17530KLFTb.mo11293wA(c3274z62, 1.0f);
        }
        return this;
    }

    /* renamed from: ZfxDd */
    public C4955yX m14027ZfxDd(C3202Y0 c3202y0, int i) {
        this.f17530KLFTb.mo11293wA(c3202y0.m11031rkYL(i, "ep"), 1.0f);
        this.f17530KLFTb.mo11293wA(c3202y0.m11031rkYL(i, "em"), -1.0f);
        return this;
    }

    @Override // p131o.C3202Y0.mjFkc
    /* renamed from: clear */
    public void mo9474clear() {
        this.f17530KLFTb.mo11286clear();
        this.f17532mjFkc = null;
        this.f17528AZxh = 0.0f;
    }

    /* renamed from: diqgf */
    public boolean m14028diqgf(C3274Z6 c3274z6) {
        return this.f17530KLFTb.mo11281KLFTb(c3274z6);
    }

    /* renamed from: eyqo */
    public boolean m14029eyqo() {
        return this.f17532mjFkc == null && this.f17528AZxh == 0.0f && this.f17530KLFTb.mo11285ZfxDd() == 0;
    }

    /* renamed from: fehf */
    public C4955yX m14030fehf(C3274Z6 c3274z6, C3274Z6 c3274z62, C3274Z6 c3274z63, C3274Z6 c3274z64, float f) {
        this.f17530KLFTb.mo11293wA(c3274z63, 0.5f);
        this.f17530KLFTb.mo11293wA(c3274z64, 0.5f);
        this.f17530KLFTb.mo11293wA(c3274z6, -0.5f);
        this.f17530KLFTb.mo11293wA(c3274z62, -0.5f);
        this.f17528AZxh = -f;
        return this;
    }

    @Override // p131o.C3202Y0.mjFkc
    /* renamed from: getKey */
    public C3274Z6 mo11036getKey() {
        return this.f17532mjFkc;
    }

    /* renamed from: huTpC */
    public C3274Z6 m14031huTpC(C3274Z6 c3274z6) {
        return m14016Gd(null, c3274z6);
    }

    /* renamed from: lB */
    public void mo9475lB(C4955yX c4955yX, boolean z) {
        this.f17528AZxh += c4955yX.f17528AZxh * this.f17530KLFTb.mo11280JHa(c4955yX, z);
        if (z) {
            c4955yX.f17532mjFkc.m11179wA(this);
        }
    }

    /* renamed from: lgHUyS */
    public C4955yX m14032lgHUyS(C3274Z6 c3274z6, C3274Z6 c3274z62, int i, float f, C3274Z6 c3274z63, C3274Z6 c3274z64, int i2) {
        if (c3274z62 == c3274z63) {
            this.f17530KLFTb.mo11293wA(c3274z6, 1.0f);
            this.f17530KLFTb.mo11293wA(c3274z64, 1.0f);
            this.f17530KLFTb.mo11293wA(c3274z62, -2.0f);
            return this;
        }
        if (f == 0.5f) {
            this.f17530KLFTb.mo11293wA(c3274z6, 1.0f);
            this.f17530KLFTb.mo11293wA(c3274z62, -1.0f);
            this.f17530KLFTb.mo11293wA(c3274z63, -1.0f);
            this.f17530KLFTb.mo11293wA(c3274z64, 1.0f);
            if (i > 0 || i2 > 0) {
                this.f17528AZxh = (-i) + i2;
            }
        } else if (f <= 0.0f) {
            this.f17530KLFTb.mo11293wA(c3274z6, -1.0f);
            this.f17530KLFTb.mo11293wA(c3274z62, 1.0f);
            this.f17528AZxh = i;
        } else if (f >= 1.0f) {
            this.f17530KLFTb.mo11293wA(c3274z64, -1.0f);
            this.f17530KLFTb.mo11293wA(c3274z63, 1.0f);
            this.f17528AZxh = -i2;
        } else {
            float f2 = 1.0f - f;
            this.f17530KLFTb.mo11293wA(c3274z6, f2 * 1.0f);
            this.f17530KLFTb.mo11293wA(c3274z62, f2 * (-1.0f));
            this.f17530KLFTb.mo11293wA(c3274z63, (-1.0f) * f);
            this.f17530KLFTb.mo11293wA(c3274z64, 1.0f * f);
            if (i > 0 || i2 > 0) {
                this.f17528AZxh = ((-i) * f2) + (i2 * f);
            }
        }
        return this;
    }

    @Override // p131o.C3202Y0.mjFkc
    /* renamed from: mjFkc */
    public void mo9476mjFkc(C3274Z6 c3274z6) {
        int i = c3274z6.f11976KLFTb;
        float f = 1.0f;
        if (i != 1) {
            if (i == 2) {
                f = 1000.0f;
            } else if (i == 3) {
                f = 1000000.0f;
            } else if (i == 4) {
                f = 1.0E9f;
            } else if (i == 5) {
                f = 1.0E12f;
            }
        }
        this.f17530KLFTb.mo11293wA(c3274z6, f);
    }

    /* renamed from: qGY */
    public C4955yX m14033qGY(C3274Z6 c3274z6, C3274Z6 c3274z62, C3274Z6 c3274z63, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f17528AZxh = i;
        }
        if (z) {
            this.f17530KLFTb.mo11293wA(c3274z6, 1.0f);
            this.f17530KLFTb.mo11293wA(c3274z62, -1.0f);
            this.f17530KLFTb.mo11293wA(c3274z63, 1.0f);
        } else {
            this.f17530KLFTb.mo11293wA(c3274z6, -1.0f);
            this.f17530KLFTb.mo11293wA(c3274z62, 1.0f);
            this.f17530KLFTb.mo11293wA(c3274z63, -1.0f);
        }
        return this;
    }

    /* renamed from: qdMbNW */
    public C4955yX m14034qdMbNW(C3274Z6 c3274z6, int i) {
        this.f17532mjFkc = c3274z6;
        float f = i;
        c3274z6.f11975JHa = f;
        this.f17528AZxh = f;
        this.f17529JHa = true;
        return this;
    }

    /* renamed from: rkYL */
    public C4955yX m14035rkYL(C3274Z6 c3274z6, C3274Z6 c3274z62, C3274Z6 c3274z63, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.f17528AZxh = i;
        }
        if (z) {
            this.f17530KLFTb.mo11293wA(c3274z6, 1.0f);
            this.f17530KLFTb.mo11293wA(c3274z62, -1.0f);
            this.f17530KLFTb.mo11293wA(c3274z63, -1.0f);
        } else {
            this.f17530KLFTb.mo11293wA(c3274z6, -1.0f);
            this.f17530KLFTb.mo11293wA(c3274z62, 1.0f);
            this.f17530KLFTb.mo11293wA(c3274z63, 1.0f);
        }
        return this;
    }

    public String toString() {
        return m14025VocHEe();
    }

    /* renamed from: vI */
    public void m14036vI() {
        this.f17532mjFkc = null;
        this.f17530KLFTb.mo11286clear();
        this.f17528AZxh = 0.0f;
        this.f17529JHa = false;
    }

    @Override // p131o.C3202Y0.mjFkc
    /* renamed from: wA */
    public void mo11037wA(C3202Y0.mjFkc mjfkc) {
        if (mjfkc instanceof C4955yX) {
            C4955yX c4955yX = (C4955yX) mjfkc;
            this.f17532mjFkc = null;
            this.f17530KLFTb.mo11286clear();
            for (int i = 0; i < c4955yX.f17530KLFTb.mo11285ZfxDd(); i++) {
                this.f17530KLFTb.mo11276AZxh(c4955yX.f17530KLFTb.mo11288lgHUyS(i), c4955yX.f17530KLFTb.mo11289mjFkc(i), true);
            }
        }
    }

    /* renamed from: wJVbdd */
    public void m14037wJVbdd(C3202Y0 c3202y0) {
        if (c3202y0.f11770JHa.length == 0) {
            return;
        }
        boolean z = false;
        while (!z) {
            int iMo11285ZfxDd = this.f17530KLFTb.mo11285ZfxDd();
            for (int i = 0; i < iMo11285ZfxDd; i++) {
                C3274Z6 c3274z6Mo11288lgHUyS = this.f17530KLFTb.mo11288lgHUyS(i);
                if (c3274z6Mo11288lgHUyS.f11980ZfxDd != -1 || c3274z6Mo11288lgHUyS.f11985xJ) {
                    this.f17531ZfxDd.add(c3274z6Mo11288lgHUyS);
                }
            }
            if (this.f17531ZfxDd.size() > 0) {
                Iterator it = this.f17531ZfxDd.iterator();
                while (it.hasNext()) {
                    C3274Z6 c3274z6 = (C3274Z6) it.next();
                    if (c3274z6.f11985xJ) {
                        m14013BAnRFn(c3202y0, c3274z6, true);
                    } else {
                        mo9475lB(c3202y0.f11770JHa[c3274z6.f11980ZfxDd], true);
                    }
                }
                this.f17531ZfxDd.clear();
            } else {
                z = true;
            }
        }
    }

    /* renamed from: xJ */
    public C3274Z6 m14038xJ(C3202Y0 c3202y0) {
        int iMo11285ZfxDd = this.f17530KLFTb.mo11285ZfxDd();
        C3274Z6 c3274z6 = null;
        float f = 0.0f;
        float f2 = 0.0f;
        boolean z = false;
        boolean z2 = false;
        C3274Z6 c3274z62 = null;
        for (int i = 0; i < iMo11285ZfxDd; i++) {
            float fMo11289mjFkc = this.f17530KLFTb.mo11289mjFkc(i);
            C3274Z6 c3274z6Mo11288lgHUyS = this.f17530KLFTb.mo11288lgHUyS(i);
            if (c3274z6Mo11288lgHUyS.f11973Dt == C3274Z6.mjFkc.UNRESTRICTED) {
                if (c3274z6 == null || f > fMo11289mjFkc) {
                    boolean zM14023Ucbh = m14023Ucbh(c3274z6Mo11288lgHUyS, c3202y0);
                    z = zM14023Ucbh;
                    f = fMo11289mjFkc;
                    c3274z6 = c3274z6Mo11288lgHUyS;
                } else if (!z && m14023Ucbh(c3274z6Mo11288lgHUyS, c3202y0)) {
                    f = fMo11289mjFkc;
                    c3274z6 = c3274z6Mo11288lgHUyS;
                    z = true;
                }
            } else if (c3274z6 == null && fMo11289mjFkc < 0.0f) {
                if (c3274z62 == null || f2 > fMo11289mjFkc) {
                    boolean zM14023Ucbh2 = m14023Ucbh(c3274z6Mo11288lgHUyS, c3202y0);
                    z2 = zM14023Ucbh2;
                    f2 = fMo11289mjFkc;
                    c3274z62 = c3274z6Mo11288lgHUyS;
                } else if (!z2 && m14023Ucbh(c3274z6Mo11288lgHUyS, c3202y0)) {
                    f2 = fMo11289mjFkc;
                    c3274z62 = c3274z6Mo11288lgHUyS;
                    z2 = true;
                }
            }
        }
        return c3274z6 != null ? c3274z6 : c3274z62;
    }

    public C4955yX(C2768RWyiuY c2768RWyiuY) {
        this.f17530KLFTb = new C4037kism(this, c2768RWyiuY);
    }
}
