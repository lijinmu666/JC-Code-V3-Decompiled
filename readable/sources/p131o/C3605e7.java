package p131o;

/* renamed from: o.e7 */
/* loaded from: classes.dex */
public class C3605e7 implements Cloneable {

    /* renamed from: KLFTb */
    public static final Object f13439KLFTb = new Object();

    /* renamed from: AZxh */
    public int[] f13440AZxh;

    /* renamed from: ZfxDd */
    public int f13441ZfxDd;

    /* renamed from: mjFkc */
    public boolean f13442mjFkc;

    /* renamed from: wA */
    public Object[] f13443wA;

    public C3605e7() {
        this(10);
    }

    /* renamed from: AZxh */
    public void m11804AZxh() {
        int i = this.f13441ZfxDd;
        Object[] objArr = this.f13443wA;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f13441ZfxDd = 0;
        this.f13442mjFkc = false;
    }

    /* renamed from: Dt */
    public int m11805Dt(int i) {
        if (this.f13442mjFkc) {
            m11808KLFTb();
        }
        return this.f13440AZxh[i];
    }

    /* renamed from: ETF */
    public void m11806ETF(int i, Object obj) {
        int iM9534mjFkc = AbstractC2458MlqoT.m9534mjFkc(this.f13440AZxh, this.f13441ZfxDd, i);
        if (iM9534mjFkc >= 0) {
            this.f13443wA[iM9534mjFkc] = obj;
            return;
        }
        int i2 = ~iM9534mjFkc;
        int i3 = this.f13441ZfxDd;
        if (i2 < i3) {
            Object[] objArr = this.f13443wA;
            if (objArr[i2] == f13439KLFTb) {
                this.f13440AZxh[i2] = i;
                objArr[i2] = obj;
                return;
            }
        }
        if (this.f13442mjFkc && i3 >= this.f13440AZxh.length) {
            m11808KLFTb();
            i2 = ~AbstractC2458MlqoT.m9534mjFkc(this.f13440AZxh, this.f13441ZfxDd, i);
        }
        int i4 = this.f13441ZfxDd;
        if (i4 >= this.f13440AZxh.length) {
            int iM9532KLFTb = AbstractC2458MlqoT.m9532KLFTb(i4 + 1);
            int[] iArr = new int[iM9532KLFTb];
            Object[] objArr2 = new Object[iM9532KLFTb];
            int[] iArr2 = this.f13440AZxh;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f13443wA;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f13440AZxh = iArr;
            this.f13443wA = objArr2;
        }
        int i5 = this.f13441ZfxDd;
        if (i5 - i2 != 0) {
            int[] iArr3 = this.f13440AZxh;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr4 = this.f13443wA;
            System.arraycopy(objArr4, i2, objArr4, i6, this.f13441ZfxDd - i2);
        }
        this.f13440AZxh[i2] = i;
        this.f13443wA[i2] = obj;
        this.f13441ZfxDd++;
    }

    /* renamed from: JHa */
    public Object m11807JHa(int i) {
        return m11812lgHUyS(i, null);
    }

    /* renamed from: KLFTb */
    public final void m11808KLFTb() {
        int i = this.f13441ZfxDd;
        int[] iArr = this.f13440AZxh;
        Object[] objArr = this.f13443wA;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f13439KLFTb) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f13442mjFkc = false;
        this.f13441ZfxDd = i2;
    }

    /* renamed from: MiMN */
    public Object m11809MiMN(int i) {
        if (this.f13442mjFkc) {
            m11808KLFTb();
        }
        return this.f13443wA[i];
    }

    /* renamed from: VA */
    public int m11810VA() {
        if (this.f13442mjFkc) {
            m11808KLFTb();
        }
        return this.f13441ZfxDd;
    }

    /* renamed from: lgHUyS */
    public Object m11812lgHUyS(int i, Object obj) {
        Object obj2;
        int iM9534mjFkc = AbstractC2458MlqoT.m9534mjFkc(this.f13440AZxh, this.f13441ZfxDd, i);
        return (iM9534mjFkc < 0 || (obj2 = this.f13443wA[iM9534mjFkc]) == f13439KLFTb) ? obj : obj2;
    }

    /* renamed from: mjFkc */
    public void m11813mjFkc(int i, Object obj) {
        int i2 = this.f13441ZfxDd;
        if (i2 != 0 && i <= this.f13440AZxh[i2 - 1]) {
            m11806ETF(i, obj);
            return;
        }
        if (this.f13442mjFkc && i2 >= this.f13440AZxh.length) {
            m11808KLFTb();
        }
        int i3 = this.f13441ZfxDd;
        if (i3 >= this.f13440AZxh.length) {
            int iM9532KLFTb = AbstractC2458MlqoT.m9532KLFTb(i3 + 1);
            int[] iArr = new int[iM9532KLFTb];
            Object[] objArr = new Object[iM9532KLFTb];
            int[] iArr2 = this.f13440AZxh;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f13443wA;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f13440AZxh = iArr;
            this.f13443wA = objArr;
        }
        this.f13440AZxh[i3] = i;
        this.f13443wA[i3] = obj;
        this.f13441ZfxDd = i3 + 1;
    }

    /* renamed from: qdMbNW */
    public int m11814qdMbNW(Object obj) {
        if (this.f13442mjFkc) {
            m11808KLFTb();
        }
        for (int i = 0; i < this.f13441ZfxDd; i++) {
            if (this.f13443wA[i] == obj) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        if (m11810VA() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f13441ZfxDd * 28);
        sb.append('{');
        for (int i = 0; i < this.f13441ZfxDd; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(m11805Dt(i));
            sb.append('=');
            Object objM11809MiMN = m11809MiMN(i);
            if (objM11809MiMN != this) {
                sb.append(objM11809MiMN);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: wA, reason: merged with bridge method [inline-methods] */
    public C3605e7 m11811clone() {
        try {
            C3605e7 c3605e7 = (C3605e7) super.clone();
            c3605e7.f13440AZxh = (int[]) this.f13440AZxh.clone();
            c3605e7.f13443wA = (Object[]) this.f13443wA.clone();
            return c3605e7;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public C3605e7(int i) {
        this.f13442mjFkc = false;
        if (i == 0) {
            this.f13440AZxh = AbstractC2458MlqoT.f9605mjFkc;
            this.f13443wA = AbstractC2458MlqoT.f9606wA;
        } else {
            int iM9532KLFTb = AbstractC2458MlqoT.m9532KLFTb(i);
            this.f13440AZxh = new int[iM9532KLFTb];
            this.f13443wA = new Object[iM9532KLFTb];
        }
    }
}
