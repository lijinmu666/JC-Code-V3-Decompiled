package p131o;

import p131o.C3776gjvQ;

/* renamed from: o.Jk */
/* loaded from: classes.dex */
public class C2257Jk extends AbstractC4852x {

    /* renamed from: gYa */
    public int f9034gYa = 0;

    /* renamed from: LREOK */
    public boolean f9032LREOK = true;

    /* renamed from: fFz */
    public int f9033fFz = 0;

    /* renamed from: Dp */
    public void m9027Dp() {
        for (int i = 0; i < this.f17301yX; i++) {
            C3776gjvQ c3776gjvQ = this.f17300tjSezt[i];
            int i2 = this.f9034gYa;
            if (i2 == 0 || i2 == 1) {
                c3776gjvQ.m12032IVlxe(0, true);
            } else if (i2 == 2 || i2 == 3) {
                c3776gjvQ.m12032IVlxe(1, true);
            }
        }
    }

    @Override // p131o.C3776gjvQ
    /* renamed from: JHa */
    public void mo9028JHa(C3202Y0 c3202y0) {
        C4446qtZIjO[] c4446qtZIjOArr;
        boolean z;
        int i;
        int i2;
        int i3;
        C4446qtZIjO[] c4446qtZIjOArr2 = this.f13779KLMXS;
        c4446qtZIjOArr2[0] = this.f13764BAnRFn;
        c4446qtZIjOArr2[2] = this.f13813lB;
        c4446qtZIjOArr2[1] = this.f13829wJVbdd;
        c4446qtZIjOArr2[3] = this.f13815mByQ;
        int i4 = 0;
        while (true) {
            c4446qtZIjOArr = this.f13779KLMXS;
            if (i4 >= c4446qtZIjOArr.length) {
                break;
            }
            C4446qtZIjO c4446qtZIjO = c4446qtZIjOArr[i4];
            c4446qtZIjO.f16251xJ = c3202y0.m11025fehf(c4446qtZIjO);
            i4++;
        }
        int i5 = this.f9034gYa;
        if (i5 < 0 || i5 >= 4) {
            return;
        }
        C4446qtZIjO c4446qtZIjO2 = c4446qtZIjOArr[i5];
        for (int i6 = 0; i6 < this.f17301yX; i6++) {
            C3776gjvQ c3776gjvQ = this.f17300tjSezt[i6];
            if ((this.f9032LREOK || c3776gjvQ.mo9035xJ()) && ((((i2 = this.f9034gYa) == 0 || i2 == 1) && c3776gjvQ.m12030HGpJ() == C3776gjvQ.AZxh.MATCH_CONSTRAINT && c3776gjvQ.f13764BAnRFn.f16248ZfxDd != null && c3776gjvQ.f13829wJVbdd.f16248ZfxDd != null) || (((i3 = this.f9034gYa) == 2 || i3 == 3) && c3776gjvQ.m12088rWxwaT() == C3776gjvQ.AZxh.MATCH_CONSTRAINT && c3776gjvQ.f13813lB.f16248ZfxDd != null && c3776gjvQ.f13815mByQ.f16248ZfxDd != null))) {
                z = true;
                break;
            }
        }
        z = false;
        boolean z2 = this.f13764BAnRFn.m13320qdMbNW() || this.f13829wJVbdd.m13320qdMbNW();
        boolean z3 = this.f13813lB.m13320qdMbNW() || this.f13815mByQ.m13320qdMbNW();
        int i7 = !(!z && (((i = this.f9034gYa) == 0 && z2) || ((i == 2 && z3) || ((i == 1 && z2) || (i == 3 && z3))))) ? 4 : 5;
        for (int i8 = 0; i8 < this.f17301yX; i8++) {
            C3776gjvQ c3776gjvQ2 = this.f17300tjSezt[i8];
            if (this.f9032LREOK || c3776gjvQ2.mo9035xJ()) {
                C3274Z6 c3274z6M11025fehf = c3202y0.m11025fehf(c3776gjvQ2.f13779KLMXS[this.f9034gYa]);
                C4446qtZIjO[] c4446qtZIjOArr3 = c3776gjvQ2.f13779KLMXS;
                int i9 = this.f9034gYa;
                C4446qtZIjO c4446qtZIjO3 = c4446qtZIjOArr3[i9];
                c4446qtZIjO3.f16251xJ = c3274z6M11025fehf;
                C4446qtZIjO c4446qtZIjO4 = c4446qtZIjO3.f16248ZfxDd;
                int i10 = (c4446qtZIjO4 == null || c4446qtZIjO4.f16245AZxh != this) ? 0 : c4446qtZIjO3.f16247KLFTb;
                if (i9 == 0 || i9 == 2) {
                    c3202y0.m11030qdMbNW(c4446qtZIjO2.f16251xJ, c3274z6M11025fehf, this.f9033fFz - i10, z);
                } else {
                    c3202y0.m11035xJ(c4446qtZIjO2.f16251xJ, c3274z6M11025fehf, this.f9033fFz + i10, z);
                }
                c3202y0.m11016KLFTb(c4446qtZIjO2.f16251xJ, c3274z6M11025fehf, this.f9033fFz + i10, i7);
            }
        }
        int i11 = this.f9034gYa;
        if (i11 == 0) {
            c3202y0.m11016KLFTb(this.f13829wJVbdd.f16251xJ, this.f13764BAnRFn.f16251xJ, 0, 8);
            c3202y0.m11016KLFTb(this.f13764BAnRFn.f16251xJ, this.f13795Vnb.f13829wJVbdd.f16251xJ, 0, 4);
            c3202y0.m11016KLFTb(this.f13764BAnRFn.f16251xJ, this.f13795Vnb.f13764BAnRFn.f16251xJ, 0, 0);
            return;
        }
        if (i11 == 1) {
            c3202y0.m11016KLFTb(this.f13764BAnRFn.f16251xJ, this.f13829wJVbdd.f16251xJ, 0, 8);
            c3202y0.m11016KLFTb(this.f13764BAnRFn.f16251xJ, this.f13795Vnb.f13764BAnRFn.f16251xJ, 0, 4);
            c3202y0.m11016KLFTb(this.f13764BAnRFn.f16251xJ, this.f13795Vnb.f13829wJVbdd.f16251xJ, 0, 0);
        } else if (i11 == 2) {
            c3202y0.m11016KLFTb(this.f13815mByQ.f16251xJ, this.f13813lB.f16251xJ, 0, 8);
            c3202y0.m11016KLFTb(this.f13813lB.f16251xJ, this.f13795Vnb.f13815mByQ.f16251xJ, 0, 4);
            c3202y0.m11016KLFTb(this.f13813lB.f16251xJ, this.f13795Vnb.f13813lB.f16251xJ, 0, 0);
        } else if (i11 == 3) {
            c3202y0.m11016KLFTb(this.f13813lB.f16251xJ, this.f13815mByQ.f16251xJ, 0, 8);
            c3202y0.m11016KLFTb(this.f13813lB.f16251xJ, this.f13795Vnb.f13813lB.f16251xJ, 0, 4);
            c3202y0.m11016KLFTb(this.f13813lB.f16251xJ, this.f13795Vnb.f13815mByQ.f16251xJ, 0, 0);
        }
    }

    /* renamed from: Rc */
    public void m9029Rc(int i) {
        this.f9033fFz = i;
    }

    /* renamed from: XD */
    public int m9030XD() {
        return this.f9034gYa;
    }

    /* renamed from: fLidf */
    public void m9031fLidf(boolean z) {
        this.f9032LREOK = z;
    }

    /* renamed from: gtr */
    public int m9032gtr() {
        return this.f9033fFz;
    }

    /* renamed from: hvGY */
    public void m9033hvGY(int i) {
        this.f9034gYa = i;
    }

    /* renamed from: sRqPfw */
    public boolean m9034sRqPfw() {
        return this.f9032LREOK;
    }

    @Override // p131o.C3776gjvQ
    public String toString() {
        String str = "[Barrier] " + m12031IEE() + " {";
        for (int i = 0; i < this.f17301yX; i++) {
            C3776gjvQ c3776gjvQ = this.f17300tjSezt[i];
            if (i > 0) {
                str = str + ", ";
            }
            str = str + c3776gjvQ.m12031IEE();
        }
        return str + "}";
    }

    @Override // p131o.C3776gjvQ
    /* renamed from: xJ */
    public boolean mo9035xJ() {
        return true;
    }
}
