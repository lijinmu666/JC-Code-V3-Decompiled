package p131o;

import java.util.Arrays;
import p131o.C4955yX;

/* renamed from: o.a7 */
/* loaded from: classes.dex */
public class C3342a7 implements C4955yX.mjFkc {

    /* renamed from: YoKzxo */
    public static float f12709YoKzxo = 0.001f;

    /* renamed from: MiMN */
    public final C2768RWyiuY f12715MiMN;

    /* renamed from: VA */
    public final C4955yX f12716VA;

    /* renamed from: mjFkc */
    public final int f12719mjFkc = -1;

    /* renamed from: AZxh */
    public int f12710AZxh = 16;

    /* renamed from: wA */
    public int f12721wA = 16;

    /* renamed from: ZfxDd */
    public int[] f12717ZfxDd = new int[16];

    /* renamed from: KLFTb */
    public int[] f12714KLFTb = new int[16];

    /* renamed from: JHa */
    public int[] f12713JHa = new int[16];

    /* renamed from: xJ */
    public float[] f12722xJ = new float[16];

    /* renamed from: lgHUyS */
    public int[] f12718lgHUyS = new int[16];

    /* renamed from: qdMbNW */
    public int[] f12720qdMbNW = new int[16];

    /* renamed from: Dt */
    public int f12711Dt = 0;

    /* renamed from: ETF */
    public int f12712ETF = -1;

    public C3342a7(C4955yX c4955yX, C2768RWyiuY c2768RWyiuY) {
        this.f12716VA = c4955yX;
        this.f12715MiMN = c2768RWyiuY;
        mo11286clear();
    }

    @Override // p131o.C4955yX.mjFkc
    /* renamed from: AZxh */
    public void mo11276AZxh(C3274Z6 c3274z6, float f, boolean z) {
        float f2 = f12709YoKzxo;
        if (f <= (-f2) || f >= f2) {
            int iM11290qGY = m11290qGY(c3274z6);
            if (iM11290qGY == -1) {
                mo11293wA(c3274z6, f);
                return;
            }
            float[] fArr = this.f12722xJ;
            float f3 = fArr[iM11290qGY] + f;
            fArr[iM11290qGY] = f3;
            float f4 = f12709YoKzxo;
            if (f3 <= (-f4) || f3 >= f4) {
                return;
            }
            fArr[iM11290qGY] = 0.0f;
            mo11277Dt(c3274z6, z);
        }
    }

    @Override // p131o.C4955yX.mjFkc
    /* renamed from: Dt */
    public float mo11277Dt(C3274Z6 c3274z6, boolean z) {
        int iM11290qGY = m11290qGY(c3274z6);
        if (iM11290qGY == -1) {
            return 0.0f;
        }
        m11279IEE(c3274z6);
        float f = this.f12722xJ[iM11290qGY];
        if (this.f12712ETF == iM11290qGY) {
            this.f12712ETF = this.f12720qdMbNW[iM11290qGY];
        }
        this.f12713JHa[iM11290qGY] = -1;
        int[] iArr = this.f12718lgHUyS;
        int i = iArr[iM11290qGY];
        if (i != -1) {
            int[] iArr2 = this.f12720qdMbNW;
            iArr2[i] = iArr2[iM11290qGY];
        }
        int i2 = this.f12720qdMbNW[iM11290qGY];
        if (i2 != -1) {
            iArr[i2] = iArr[iM11290qGY];
        }
        this.f12711Dt--;
        c3274z6.f11977MiMN--;
        if (z) {
            c3274z6.m11179wA(this.f12716VA);
        }
        return f;
    }

    @Override // p131o.C4955yX.mjFkc
    /* renamed from: ETF */
    public void mo11278ETF() {
        int i = this.f12711Dt;
        int i2 = this.f12712ETF;
        for (int i3 = 0; i3 < i; i3++) {
            float[] fArr = this.f12722xJ;
            fArr[i2] = fArr[i2] * (-1.0f);
            i2 = this.f12720qdMbNW[i2];
            if (i2 == -1) {
                return;
            }
        }
    }

    /* renamed from: IEE */
    public final void m11279IEE(C3274Z6 c3274z6) {
        int[] iArr;
        int i;
        int i2 = c3274z6.f11984wA;
        int i3 = i2 % this.f12721wA;
        int[] iArr2 = this.f12717ZfxDd;
        int i4 = iArr2[i3];
        if (i4 == -1) {
            return;
        }
        if (this.f12713JHa[i4] == i2) {
            int[] iArr3 = this.f12714KLFTb;
            iArr2[i3] = iArr3[i4];
            iArr3[i4] = -1;
            return;
        }
        while (true) {
            iArr = this.f12714KLFTb;
            i = iArr[i4];
            if (i == -1 || this.f12713JHa[i] == i2) {
                break;
            } else {
                i4 = i;
            }
        }
        if (i == -1 || this.f12713JHa[i] != i2) {
            return;
        }
        iArr[i4] = iArr[i];
        iArr[i] = -1;
    }

    @Override // p131o.C4955yX.mjFkc
    /* renamed from: JHa */
    public float mo11280JHa(C4955yX c4955yX, boolean z) {
        float fMo11294xJ = mo11294xJ(c4955yX.f17532mjFkc);
        mo11277Dt(c4955yX.f17532mjFkc, z);
        C3342a7 c3342a7 = (C3342a7) c4955yX.f17530KLFTb;
        int iMo11285ZfxDd = c3342a7.mo11285ZfxDd();
        int i = 0;
        int i2 = 0;
        while (i < iMo11285ZfxDd) {
            int i3 = c3342a7.f12713JHa[i2];
            if (i3 != -1) {
                mo11276AZxh(this.f12715MiMN.f10435ZfxDd[i3], c3342a7.f12722xJ[i2] * fMo11294xJ, z);
                i++;
            }
            i2++;
        }
        return fMo11294xJ;
    }

    @Override // p131o.C4955yX.mjFkc
    /* renamed from: KLFTb */
    public boolean mo11281KLFTb(C3274Z6 c3274z6) {
        return m11290qGY(c3274z6) != -1;
    }

    /* renamed from: MiMN */
    public final void m11282MiMN(int i, C3274Z6 c3274z6, float f) {
        this.f12713JHa[i] = c3274z6.f11984wA;
        this.f12722xJ[i] = f;
        this.f12718lgHUyS[i] = -1;
        this.f12720qdMbNW[i] = -1;
        c3274z6.m11178mjFkc(this.f12716VA);
        c3274z6.f11977MiMN++;
        this.f12711Dt++;
    }

    /* renamed from: VA */
    public final void m11283VA(C3274Z6 c3274z6, int i) {
        int[] iArr;
        int i2 = c3274z6.f11984wA % this.f12721wA;
        int[] iArr2 = this.f12717ZfxDd;
        int i3 = iArr2[i2];
        if (i3 == -1) {
            iArr2[i2] = i;
        } else {
            while (true) {
                iArr = this.f12714KLFTb;
                int i4 = iArr[i3];
                if (i4 == -1) {
                    break;
                } else {
                    i3 = i4;
                }
            }
            iArr[i3] = i;
        }
        this.f12714KLFTb[i] = -1;
    }

    /* renamed from: YoKzxo */
    public final int m11284YoKzxo() {
        for (int i = 0; i < this.f12710AZxh; i++) {
            if (this.f12713JHa[i] == -1) {
                return i;
            }
        }
        return -1;
    }

    @Override // p131o.C4955yX.mjFkc
    /* renamed from: ZfxDd */
    public int mo11285ZfxDd() {
        return this.f12711Dt;
    }

    @Override // p131o.C4955yX.mjFkc
    /* renamed from: clear */
    public void mo11286clear() {
        int i = this.f12711Dt;
        for (int i2 = 0; i2 < i; i2++) {
            C3274Z6 c3274z6Mo11288lgHUyS = mo11288lgHUyS(i2);
            if (c3274z6Mo11288lgHUyS != null) {
                c3274z6Mo11288lgHUyS.m11179wA(this.f12716VA);
            }
        }
        for (int i3 = 0; i3 < this.f12710AZxh; i3++) {
            this.f12713JHa[i3] = -1;
            this.f12714KLFTb[i3] = -1;
        }
        for (int i4 = 0; i4 < this.f12721wA; i4++) {
            this.f12717ZfxDd[i4] = -1;
        }
        this.f12711Dt = 0;
        this.f12712ETF = -1;
    }

    /* renamed from: fehf */
    public final void m11287fehf(int i, C3274Z6 c3274z6, float f) {
        int iM11284YoKzxo = m11284YoKzxo();
        m11282MiMN(iM11284YoKzxo, c3274z6, f);
        if (i != -1) {
            this.f12718lgHUyS[iM11284YoKzxo] = i;
            int[] iArr = this.f12720qdMbNW;
            iArr[iM11284YoKzxo] = iArr[i];
            iArr[i] = iM11284YoKzxo;
        } else {
            this.f12718lgHUyS[iM11284YoKzxo] = -1;
            if (this.f12711Dt > 0) {
                this.f12720qdMbNW[iM11284YoKzxo] = this.f12712ETF;
                this.f12712ETF = iM11284YoKzxo;
            } else {
                this.f12720qdMbNW[iM11284YoKzxo] = -1;
            }
        }
        int i2 = this.f12720qdMbNW[iM11284YoKzxo];
        if (i2 != -1) {
            this.f12718lgHUyS[i2] = iM11284YoKzxo;
        }
        m11283VA(c3274z6, iM11284YoKzxo);
    }

    @Override // p131o.C4955yX.mjFkc
    /* renamed from: lgHUyS */
    public C3274Z6 mo11288lgHUyS(int i) {
        int i2 = this.f12711Dt;
        if (i2 == 0) {
            return null;
        }
        int i3 = this.f12712ETF;
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 == i && i3 != -1) {
                return this.f12715MiMN.f10435ZfxDd[this.f12713JHa[i3]];
            }
            i3 = this.f12720qdMbNW[i3];
            if (i3 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // p131o.C4955yX.mjFkc
    /* renamed from: mjFkc */
    public float mo11289mjFkc(int i) {
        int i2 = this.f12711Dt;
        int i3 = this.f12712ETF;
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 == i) {
                return this.f12722xJ[i3];
            }
            i3 = this.f12720qdMbNW[i3];
            if (i3 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    /* renamed from: qGY */
    public int m11290qGY(C3274Z6 c3274z6) {
        if (this.f12711Dt == 0) {
            return -1;
        }
        int i = c3274z6.f11984wA;
        int i2 = this.f12717ZfxDd[i % this.f12721wA];
        if (i2 == -1) {
            return -1;
        }
        if (this.f12713JHa[i2] == i) {
            return i2;
        }
        do {
            i2 = this.f12714KLFTb[i2];
            if (i2 == -1) {
                break;
            }
        } while (this.f12713JHa[i2] != i);
        if (i2 != -1 && this.f12713JHa[i2] == i) {
            return i2;
        }
        return -1;
    }

    @Override // p131o.C4955yX.mjFkc
    /* renamed from: qdMbNW */
    public void mo11291qdMbNW(float f) {
        int i = this.f12711Dt;
        int i2 = this.f12712ETF;
        for (int i3 = 0; i3 < i; i3++) {
            float[] fArr = this.f12722xJ;
            fArr[i2] = fArr[i2] / f;
            i2 = this.f12720qdMbNW[i2];
            if (i2 == -1) {
                return;
            }
        }
    }

    /* renamed from: rkYL */
    public final void m11292rkYL() {
        int i = this.f12710AZxh * 2;
        this.f12713JHa = Arrays.copyOf(this.f12713JHa, i);
        this.f12722xJ = Arrays.copyOf(this.f12722xJ, i);
        this.f12718lgHUyS = Arrays.copyOf(this.f12718lgHUyS, i);
        this.f12720qdMbNW = Arrays.copyOf(this.f12720qdMbNW, i);
        this.f12714KLFTb = Arrays.copyOf(this.f12714KLFTb, i);
        for (int i2 = this.f12710AZxh; i2 < i; i2++) {
            this.f12713JHa[i2] = -1;
            this.f12714KLFTb[i2] = -1;
        }
        this.f12710AZxh = i;
    }

    public String toString() {
        String str = hashCode() + " { ";
        int i = this.f12711Dt;
        for (int i2 = 0; i2 < i; i2++) {
            C3274Z6 c3274z6Mo11288lgHUyS = mo11288lgHUyS(i2);
            if (c3274z6Mo11288lgHUyS != null) {
                String str2 = str + c3274z6Mo11288lgHUyS + " = " + mo11289mjFkc(i2) + " ";
                int iM11290qGY = m11290qGY(c3274z6Mo11288lgHUyS);
                String str3 = str2 + "[p: ";
                String str4 = (this.f12718lgHUyS[iM11290qGY] != -1 ? str3 + this.f12715MiMN.f10435ZfxDd[this.f12713JHa[this.f12718lgHUyS[iM11290qGY]]] : str3 + "none") + ", n: ";
                str = (this.f12720qdMbNW[iM11290qGY] != -1 ? str4 + this.f12715MiMN.f10435ZfxDd[this.f12713JHa[this.f12720qdMbNW[iM11290qGY]]] : str4 + "none") + "]";
            }
        }
        return str + " }";
    }

    @Override // p131o.C4955yX.mjFkc
    /* renamed from: wA */
    public void mo11293wA(C3274Z6 c3274z6, float f) {
        float f2 = f12709YoKzxo;
        if (f > (-f2) && f < f2) {
            mo11277Dt(c3274z6, true);
            return;
        }
        if (this.f12711Dt == 0) {
            m11282MiMN(0, c3274z6, f);
            m11283VA(c3274z6, 0);
            this.f12712ETF = 0;
            return;
        }
        int iM11290qGY = m11290qGY(c3274z6);
        if (iM11290qGY != -1) {
            this.f12722xJ[iM11290qGY] = f;
            return;
        }
        if (this.f12711Dt + 1 >= this.f12710AZxh) {
            m11292rkYL();
        }
        int i = this.f12711Dt;
        int i2 = this.f12712ETF;
        int i3 = -1;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = this.f12713JHa[i2];
            int i6 = c3274z6.f11984wA;
            if (i5 == i6) {
                this.f12722xJ[i2] = f;
                return;
            }
            if (i5 < i6) {
                i3 = i2;
            }
            i2 = this.f12720qdMbNW[i2];
            if (i2 == -1) {
                break;
            }
        }
        m11287fehf(i3, c3274z6, f);
    }

    @Override // p131o.C4955yX.mjFkc
    /* renamed from: xJ */
    public float mo11294xJ(C3274Z6 c3274z6) {
        int iM11290qGY = m11290qGY(c3274z6);
        if (iM11290qGY != -1) {
            return this.f12722xJ[iM11290qGY];
        }
        return 0.0f;
    }
}
