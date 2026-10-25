package p131o;

import java.util.Arrays;

/* renamed from: o.kz */
/* loaded from: classes.dex */
public final class C4055kz {

    /* renamed from: JHa */
    public static final C4055kz f14653JHa = new C4055kz(0, new int[0], new Object[0], false);

    /* renamed from: AZxh */
    public int[] f14654AZxh;

    /* renamed from: KLFTb */
    public boolean f14655KLFTb;

    /* renamed from: ZfxDd */
    public int f14656ZfxDd = -1;

    /* renamed from: mjFkc */
    public int f14657mjFkc;

    /* renamed from: wA */
    public Object[] f14658wA;

    public C4055kz(int i, int[] iArr, Object[] objArr, boolean z) {
        this.f14657mjFkc = i;
        this.f14654AZxh = iArr;
        this.f14658wA = objArr;
        this.f14655KLFTb = z;
    }

    /* renamed from: JHa */
    public static C4055kz m12633JHa() {
        return new C4055kz(0, new int[8], new Object[8], true);
    }

    /* renamed from: KLFTb */
    public static C4055kz m12634KLFTb(C4055kz c4055kz, C4055kz c4055kz2) {
        int i = c4055kz.f14657mjFkc + c4055kz2.f14657mjFkc;
        int[] iArrCopyOf = Arrays.copyOf(c4055kz.f14654AZxh, i);
        System.arraycopy(c4055kz2.f14654AZxh, 0, iArrCopyOf, c4055kz.f14657mjFkc, c4055kz2.f14657mjFkc);
        Object[] objArrCopyOf = Arrays.copyOf(c4055kz.f14658wA, i);
        System.arraycopy(c4055kz2.f14658wA, 0, objArrCopyOf, c4055kz.f14657mjFkc, c4055kz2.f14657mjFkc);
        return new C4055kz(i, iArrCopyOf, objArrCopyOf, true);
    }

    /* renamed from: wA */
    public static C4055kz m12635wA() {
        return f14653JHa;
    }

    /* renamed from: AZxh */
    public final int m12636AZxh() {
        int i = this.f14656ZfxDd;
        if (i != -1) {
            return i;
        }
        int iM8470ZfxDd = 0;
        for (int i2 = 0; i2 < this.f14657mjFkc; i2++) {
            int i3 = this.f14654AZxh[i2] >>> 3;
            AbstractC4981yx abstractC4981yx = (AbstractC4981yx) this.f14658wA[i2];
            int iM8470ZfxDd2 = AbstractC2063Gx.m8470ZfxDd(8);
            int iM8470ZfxDd3 = AbstractC2063Gx.m8470ZfxDd(16) + AbstractC2063Gx.m8470ZfxDd(i3);
            int iM8470ZfxDd4 = AbstractC2063Gx.m8470ZfxDd(24);
            int iMo13326JHa = abstractC4981yx.mo13326JHa();
            iM8470ZfxDd += iM8470ZfxDd2 + iM8470ZfxDd2 + iM8470ZfxDd3 + iM8470ZfxDd4 + AbstractC2063Gx.m8470ZfxDd(iMo13326JHa) + iMo13326JHa;
        }
        this.f14656ZfxDd = iM8470ZfxDd;
        return iM8470ZfxDd;
    }

    /* renamed from: Dt */
    public final void m12637Dt(int i, Object obj) {
        m12646xJ();
        m12639MiMN(this.f14657mjFkc + 1);
        int[] iArr = this.f14654AZxh;
        int i2 = this.f14657mjFkc;
        iArr[i2] = i;
        this.f14658wA[i2] = obj;
        this.f14657mjFkc = i2 + 1;
    }

    /* renamed from: ETF */
    public final void m12638ETF(InterfaceC4919xz interfaceC4919xz) {
        for (int i = 0; i < this.f14657mjFkc; i++) {
            interfaceC4919xz.mo8599HGpJ(this.f14654AZxh[i] >>> 3, this.f14658wA[i]);
        }
    }

    /* renamed from: MiMN */
    public final void m12639MiMN(int i) {
        int[] iArr = this.f14654AZxh;
        if (i > iArr.length) {
            int i2 = this.f14657mjFkc;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.f14654AZxh = Arrays.copyOf(iArr, i);
            this.f14658wA = Arrays.copyOf(this.f14658wA, i);
        }
    }

    /* renamed from: VA */
    public final void m12640VA(InterfaceC4919xz interfaceC4919xz) {
        if (this.f14657mjFkc != 0) {
            for (int i = 0; i < this.f14657mjFkc; i++) {
                int i2 = this.f14654AZxh[i];
                Object obj = this.f14658wA[i];
                int i3 = i2 & 7;
                int i4 = i2 >>> 3;
                if (i3 == 0) {
                    interfaceC4919xz.mo8603KLMXS(i4, ((Long) obj).longValue());
                } else if (i3 == 1) {
                    interfaceC4919xz.mo8619lgHUyS(i4, ((Long) obj).longValue());
                } else if (i3 == 2) {
                    interfaceC4919xz.mo8595CqaNbM(i4, (AbstractC4981yx) obj);
                } else if (i3 == 3) {
                    interfaceC4919xz.mo8625vI(i4);
                    ((C4055kz) obj).m12640VA(interfaceC4919xz);
                    interfaceC4919xz.mo8616fehf(i4);
                } else {
                    if (i3 != 5) {
                        throw new RuntimeException(new C4249ny("Protocol message tag had invalid wire type."));
                    }
                    interfaceC4919xz.mo8618lB(i4, ((Integer) obj).intValue());
                }
            }
        }
    }

    /* renamed from: ZfxDd */
    public final C4055kz m12641ZfxDd(C4055kz c4055kz) {
        if (c4055kz.m12642equals(f14653JHa)) {
            return this;
        }
        m12646xJ();
        int i = this.f14657mjFkc + c4055kz.f14657mjFkc;
        m12639MiMN(i);
        System.arraycopy(c4055kz.f14654AZxh, 0, this.f14654AZxh, this.f14657mjFkc, c4055kz.f14657mjFkc);
        System.arraycopy(c4055kz.f14658wA, 0, this.f14658wA, this.f14657mjFkc, c4055kz.f14657mjFkc);
        this.f14657mjFkc = i;
        return this;
    }

    /* renamed from: equals */
    public final boolean m12642equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C4055kz)) {
            return false;
        }
        C4055kz c4055kz = (C4055kz) obj;
        int i = this.f14657mjFkc;
        if (i == c4055kz.f14657mjFkc) {
            int[] iArr = this.f14654AZxh;
            int[] iArr2 = c4055kz.f14654AZxh;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.f14658wA;
                    Object[] objArr2 = c4055kz.f14658wA;
                    int i3 = this.f14657mjFkc;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
                if (iArr[i2] != iArr2[i2]) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f14657mjFkc;
        int i2 = i + 527;
        int[] iArr = this.f14654AZxh;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = ((i2 * 31) + i3) * 31;
        Object[] objArr = this.f14658wA;
        int i6 = this.f14657mjFkc;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    /* renamed from: lgHUyS */
    public final void m12643lgHUyS() {
        if (this.f14655KLFTb) {
            this.f14655KLFTb = false;
        }
    }

    /* renamed from: mjFkc */
    public final int m12644mjFkc() {
        int iM8470ZfxDd;
        int iM8468KLFTb;
        int iM8470ZfxDd2;
        int i = this.f14656ZfxDd;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f14657mjFkc; i3++) {
            int i4 = this.f14654AZxh[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 != 0) {
                if (i6 == 1) {
                    ((Long) this.f14658wA[i3]).longValue();
                    iM8470ZfxDd2 = AbstractC2063Gx.m8470ZfxDd(i5 << 3) + 8;
                } else if (i6 == 2) {
                    int i7 = i5 << 3;
                    AbstractC4981yx abstractC4981yx = (AbstractC4981yx) this.f14658wA[i3];
                    int iM8470ZfxDd3 = AbstractC2063Gx.m8470ZfxDd(i7);
                    int iMo13326JHa = abstractC4981yx.mo13326JHa();
                    iM8470ZfxDd2 = iM8470ZfxDd3 + AbstractC2063Gx.m8470ZfxDd(iMo13326JHa) + iMo13326JHa;
                } else if (i6 == 3) {
                    int iM8470ZfxDd4 = AbstractC2063Gx.m8470ZfxDd(i5 << 3);
                    iM8470ZfxDd = iM8470ZfxDd4 + iM8470ZfxDd4;
                    iM8468KLFTb = ((C4055kz) this.f14658wA[i3]).m12644mjFkc();
                } else {
                    if (i6 != 5) {
                        throw new IllegalStateException(new C4249ny("Protocol message tag had invalid wire type."));
                    }
                    ((Integer) this.f14658wA[i3]).intValue();
                    iM8470ZfxDd2 = AbstractC2063Gx.m8470ZfxDd(i5 << 3) + 4;
                }
                i2 += iM8470ZfxDd2;
            } else {
                int i8 = i5 << 3;
                long jLongValue = ((Long) this.f14658wA[i3]).longValue();
                iM8470ZfxDd = AbstractC2063Gx.m8470ZfxDd(i8);
                iM8468KLFTb = AbstractC2063Gx.m8468KLFTb(jLongValue);
            }
            iM8470ZfxDd2 = iM8470ZfxDd + iM8468KLFTb;
            i2 += iM8470ZfxDd2;
        }
        this.f14656ZfxDd = i2;
        return i2;
    }

    /* renamed from: qdMbNW */
    public final void m12645qdMbNW(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.f14657mjFkc; i2++) {
            AbstractC2474My.m9562AZxh(sb, i, String.valueOf(this.f14654AZxh[i2] >>> 3), this.f14658wA[i2]);
        }
    }

    /* renamed from: xJ */
    public final void m12646xJ() {
        if (!this.f14655KLFTb) {
            throw new UnsupportedOperationException();
        }
    }
}
