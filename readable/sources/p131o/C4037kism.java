package p131o;

import java.util.Arrays;
import org.conscrypt.BuildConfig;
import p131o.C4955yX;

/* renamed from: o.kism */
/* loaded from: classes.dex */
public class C4037kism implements C4955yX.mjFkc {

    /* renamed from: VA */
    public static float f14581VA = 0.001f;

    /* renamed from: AZxh */
    public final C4955yX f14582AZxh;

    /* renamed from: wA */
    public final C2768RWyiuY f14591wA;

    /* renamed from: mjFkc */
    public int f14589mjFkc = 0;

    /* renamed from: ZfxDd */
    public int f14587ZfxDd = 8;

    /* renamed from: KLFTb */
    public C3274Z6 f14586KLFTb = null;

    /* renamed from: JHa */
    public int[] f14585JHa = new int[8];

    /* renamed from: xJ */
    public int[] f14592xJ = new int[8];

    /* renamed from: lgHUyS */
    public float[] f14588lgHUyS = new float[8];

    /* renamed from: qdMbNW */
    public int f14590qdMbNW = -1;

    /* renamed from: Dt */
    public int f14583Dt = -1;

    /* renamed from: ETF */
    public boolean f14584ETF = false;

    public C4037kism(C4955yX c4955yX, C2768RWyiuY c2768RWyiuY) {
        this.f14582AZxh = c4955yX;
        this.f14591wA = c2768RWyiuY;
    }

    @Override // p131o.C4955yX.mjFkc
    /* renamed from: AZxh */
    public void mo11276AZxh(C3274Z6 c3274z6, float f, boolean z) {
        float f2 = f14581VA;
        if (f <= (-f2) || f >= f2) {
            int i = this.f14590qdMbNW;
            if (i == -1) {
                this.f14590qdMbNW = 0;
                this.f14588lgHUyS[0] = f;
                this.f14585JHa[0] = c3274z6.f11984wA;
                this.f14592xJ[0] = -1;
                c3274z6.f11977MiMN++;
                c3274z6.m11178mjFkc(this.f14582AZxh);
                this.f14589mjFkc++;
                if (this.f14584ETF) {
                    return;
                }
                int i2 = this.f14583Dt + 1;
                this.f14583Dt = i2;
                int[] iArr = this.f14585JHa;
                if (i2 >= iArr.length) {
                    this.f14584ETF = true;
                    this.f14583Dt = iArr.length - 1;
                    return;
                }
                return;
            }
            int i3 = -1;
            for (int i4 = 0; i != -1 && i4 < this.f14589mjFkc; i4++) {
                int i5 = this.f14585JHa[i];
                int i6 = c3274z6.f11984wA;
                if (i5 == i6) {
                    float[] fArr = this.f14588lgHUyS;
                    float f3 = fArr[i] + f;
                    float f4 = f14581VA;
                    if (f3 > (-f4) && f3 < f4) {
                        f3 = 0.0f;
                    }
                    fArr[i] = f3;
                    if (f3 == 0.0f) {
                        if (i == this.f14590qdMbNW) {
                            this.f14590qdMbNW = this.f14592xJ[i];
                        } else {
                            int[] iArr2 = this.f14592xJ;
                            iArr2[i3] = iArr2[i];
                        }
                        if (z) {
                            c3274z6.m11179wA(this.f14582AZxh);
                        }
                        if (this.f14584ETF) {
                            this.f14583Dt = i;
                        }
                        c3274z6.f11977MiMN--;
                        this.f14589mjFkc--;
                        return;
                    }
                    return;
                }
                if (i5 < i6) {
                    i3 = i;
                }
                i = this.f14592xJ[i];
            }
            int length = this.f14583Dt;
            int i7 = length + 1;
            if (this.f14584ETF) {
                int[] iArr3 = this.f14585JHa;
                if (iArr3[length] != -1) {
                    length = iArr3.length;
                }
            } else {
                length = i7;
            }
            int[] iArr4 = this.f14585JHa;
            if (length >= iArr4.length && this.f14589mjFkc < iArr4.length) {
                int i8 = 0;
                while (true) {
                    int[] iArr5 = this.f14585JHa;
                    if (i8 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i8] == -1) {
                        length = i8;
                        break;
                    }
                    i8++;
                }
            }
            int[] iArr6 = this.f14585JHa;
            if (length >= iArr6.length) {
                length = iArr6.length;
                int i9 = this.f14587ZfxDd * 2;
                this.f14587ZfxDd = i9;
                this.f14584ETF = false;
                this.f14583Dt = length - 1;
                this.f14588lgHUyS = Arrays.copyOf(this.f14588lgHUyS, i9);
                this.f14585JHa = Arrays.copyOf(this.f14585JHa, this.f14587ZfxDd);
                this.f14592xJ = Arrays.copyOf(this.f14592xJ, this.f14587ZfxDd);
            }
            this.f14585JHa[length] = c3274z6.f11984wA;
            this.f14588lgHUyS[length] = f;
            if (i3 != -1) {
                int[] iArr7 = this.f14592xJ;
                iArr7[length] = iArr7[i3];
                iArr7[i3] = length;
            } else {
                this.f14592xJ[length] = this.f14590qdMbNW;
                this.f14590qdMbNW = length;
            }
            c3274z6.f11977MiMN++;
            c3274z6.m11178mjFkc(this.f14582AZxh);
            this.f14589mjFkc++;
            if (!this.f14584ETF) {
                this.f14583Dt++;
            }
            int i10 = this.f14583Dt;
            int[] iArr8 = this.f14585JHa;
            if (i10 >= iArr8.length) {
                this.f14584ETF = true;
                this.f14583Dt = iArr8.length - 1;
            }
        }
    }

    @Override // p131o.C4955yX.mjFkc
    /* renamed from: Dt */
    public final float mo11277Dt(C3274Z6 c3274z6, boolean z) {
        if (this.f14586KLFTb == c3274z6) {
            this.f14586KLFTb = null;
        }
        int i = this.f14590qdMbNW;
        if (i == -1) {
            return 0.0f;
        }
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.f14589mjFkc) {
            if (this.f14585JHa[i] == c3274z6.f11984wA) {
                if (i == this.f14590qdMbNW) {
                    this.f14590qdMbNW = this.f14592xJ[i];
                } else {
                    int[] iArr = this.f14592xJ;
                    iArr[i3] = iArr[i];
                }
                if (z) {
                    c3274z6.m11179wA(this.f14582AZxh);
                }
                c3274z6.f11977MiMN--;
                this.f14589mjFkc--;
                this.f14585JHa[i] = -1;
                if (this.f14584ETF) {
                    this.f14583Dt = i;
                }
                return this.f14588lgHUyS[i];
            }
            i2++;
            i3 = i;
            i = this.f14592xJ[i];
        }
        return 0.0f;
    }

    @Override // p131o.C4955yX.mjFkc
    /* renamed from: ETF */
    public void mo11278ETF() {
        int i = this.f14590qdMbNW;
        for (int i2 = 0; i != -1 && i2 < this.f14589mjFkc; i2++) {
            float[] fArr = this.f14588lgHUyS;
            fArr[i] = fArr[i] * (-1.0f);
            i = this.f14592xJ[i];
        }
    }

    @Override // p131o.C4955yX.mjFkc
    /* renamed from: JHa */
    public float mo11280JHa(C4955yX c4955yX, boolean z) {
        float fMo11294xJ = mo11294xJ(c4955yX.f17532mjFkc);
        mo11277Dt(c4955yX.f17532mjFkc, z);
        C4955yX.mjFkc mjfkc = c4955yX.f17530KLFTb;
        int iMo11285ZfxDd = mjfkc.mo11285ZfxDd();
        for (int i = 0; i < iMo11285ZfxDd; i++) {
            C3274Z6 c3274z6Mo11288lgHUyS = mjfkc.mo11288lgHUyS(i);
            mo11276AZxh(c3274z6Mo11288lgHUyS, mjfkc.mo11294xJ(c3274z6Mo11288lgHUyS) * fMo11294xJ, z);
        }
        return fMo11294xJ;
    }

    @Override // p131o.C4955yX.mjFkc
    /* renamed from: KLFTb */
    public boolean mo11281KLFTb(C3274Z6 c3274z6) {
        int i = this.f14590qdMbNW;
        if (i == -1) {
            return false;
        }
        for (int i2 = 0; i != -1 && i2 < this.f14589mjFkc; i2++) {
            if (this.f14585JHa[i] == c3274z6.f11984wA) {
                return true;
            }
            i = this.f14592xJ[i];
        }
        return false;
    }

    @Override // p131o.C4955yX.mjFkc
    /* renamed from: ZfxDd */
    public int mo11285ZfxDd() {
        return this.f14589mjFkc;
    }

    @Override // p131o.C4955yX.mjFkc
    /* renamed from: clear */
    public final void mo11286clear() {
        int i = this.f14590qdMbNW;
        for (int i2 = 0; i != -1 && i2 < this.f14589mjFkc; i2++) {
            C3274Z6 c3274z6 = this.f14591wA.f10435ZfxDd[this.f14585JHa[i]];
            if (c3274z6 != null) {
                c3274z6.m11179wA(this.f14582AZxh);
            }
            i = this.f14592xJ[i];
        }
        this.f14590qdMbNW = -1;
        this.f14583Dt = -1;
        this.f14584ETF = false;
        this.f14589mjFkc = 0;
    }

    @Override // p131o.C4955yX.mjFkc
    /* renamed from: lgHUyS */
    public C3274Z6 mo11288lgHUyS(int i) {
        int i2 = this.f14590qdMbNW;
        for (int i3 = 0; i2 != -1 && i3 < this.f14589mjFkc; i3++) {
            if (i3 == i) {
                return this.f14591wA.f10435ZfxDd[this.f14585JHa[i2]];
            }
            i2 = this.f14592xJ[i2];
        }
        return null;
    }

    @Override // p131o.C4955yX.mjFkc
    /* renamed from: mjFkc */
    public float mo11289mjFkc(int i) {
        int i2 = this.f14590qdMbNW;
        for (int i3 = 0; i2 != -1 && i3 < this.f14589mjFkc; i3++) {
            if (i3 == i) {
                return this.f14588lgHUyS[i2];
            }
            i2 = this.f14592xJ[i2];
        }
        return 0.0f;
    }

    @Override // p131o.C4955yX.mjFkc
    /* renamed from: qdMbNW */
    public void mo11291qdMbNW(float f) {
        int i = this.f14590qdMbNW;
        for (int i2 = 0; i != -1 && i2 < this.f14589mjFkc; i2++) {
            float[] fArr = this.f14588lgHUyS;
            fArr[i] = fArr[i] / f;
            i = this.f14592xJ[i];
        }
    }

    public String toString() {
        int i = this.f14590qdMbNW;
        String str = BuildConfig.f24315FLAVOR;
        for (int i2 = 0; i != -1 && i2 < this.f14589mjFkc; i2++) {
            str = ((str + " -> ") + this.f14588lgHUyS[i] + " : ") + this.f14591wA.f10435ZfxDd[this.f14585JHa[i]];
            i = this.f14592xJ[i];
        }
        return str;
    }

    @Override // p131o.C4955yX.mjFkc
    /* renamed from: wA */
    public final void mo11293wA(C3274Z6 c3274z6, float f) {
        if (f == 0.0f) {
            mo11277Dt(c3274z6, true);
            return;
        }
        int i = this.f14590qdMbNW;
        if (i == -1) {
            this.f14590qdMbNW = 0;
            this.f14588lgHUyS[0] = f;
            this.f14585JHa[0] = c3274z6.f11984wA;
            this.f14592xJ[0] = -1;
            c3274z6.f11977MiMN++;
            c3274z6.m11178mjFkc(this.f14582AZxh);
            this.f14589mjFkc++;
            if (this.f14584ETF) {
                return;
            }
            int i2 = this.f14583Dt + 1;
            this.f14583Dt = i2;
            int[] iArr = this.f14585JHa;
            if (i2 >= iArr.length) {
                this.f14584ETF = true;
                this.f14583Dt = iArr.length - 1;
                return;
            }
            return;
        }
        int i3 = -1;
        for (int i4 = 0; i != -1 && i4 < this.f14589mjFkc; i4++) {
            int i5 = this.f14585JHa[i];
            int i6 = c3274z6.f11984wA;
            if (i5 == i6) {
                this.f14588lgHUyS[i] = f;
                return;
            }
            if (i5 < i6) {
                i3 = i;
            }
            i = this.f14592xJ[i];
        }
        int length = this.f14583Dt;
        int i7 = length + 1;
        if (this.f14584ETF) {
            int[] iArr2 = this.f14585JHa;
            if (iArr2[length] != -1) {
                length = iArr2.length;
            }
        } else {
            length = i7;
        }
        int[] iArr3 = this.f14585JHa;
        if (length >= iArr3.length && this.f14589mjFkc < iArr3.length) {
            int i8 = 0;
            while (true) {
                int[] iArr4 = this.f14585JHa;
                if (i8 >= iArr4.length) {
                    break;
                }
                if (iArr4[i8] == -1) {
                    length = i8;
                    break;
                }
                i8++;
            }
        }
        int[] iArr5 = this.f14585JHa;
        if (length >= iArr5.length) {
            length = iArr5.length;
            int i9 = this.f14587ZfxDd * 2;
            this.f14587ZfxDd = i9;
            this.f14584ETF = false;
            this.f14583Dt = length - 1;
            this.f14588lgHUyS = Arrays.copyOf(this.f14588lgHUyS, i9);
            this.f14585JHa = Arrays.copyOf(this.f14585JHa, this.f14587ZfxDd);
            this.f14592xJ = Arrays.copyOf(this.f14592xJ, this.f14587ZfxDd);
        }
        this.f14585JHa[length] = c3274z6.f11984wA;
        this.f14588lgHUyS[length] = f;
        if (i3 != -1) {
            int[] iArr6 = this.f14592xJ;
            iArr6[length] = iArr6[i3];
            iArr6[i3] = length;
        } else {
            this.f14592xJ[length] = this.f14590qdMbNW;
            this.f14590qdMbNW = length;
        }
        c3274z6.f11977MiMN++;
        c3274z6.m11178mjFkc(this.f14582AZxh);
        int i10 = this.f14589mjFkc + 1;
        this.f14589mjFkc = i10;
        if (!this.f14584ETF) {
            this.f14583Dt++;
        }
        int[] iArr7 = this.f14585JHa;
        if (i10 >= iArr7.length) {
            this.f14584ETF = true;
        }
        if (this.f14583Dt >= iArr7.length) {
            this.f14584ETF = true;
            this.f14583Dt = iArr7.length - 1;
        }
    }

    @Override // p131o.C4955yX.mjFkc
    /* renamed from: xJ */
    public final float mo11294xJ(C3274Z6 c3274z6) {
        int i = this.f14590qdMbNW;
        for (int i2 = 0; i != -1 && i2 < this.f14589mjFkc; i2++) {
            if (this.f14585JHa[i] == c3274z6.f11984wA) {
                return this.f14588lgHUyS[i];
            }
            i = this.f14592xJ[i];
        }
        return 0.0f;
    }
}
