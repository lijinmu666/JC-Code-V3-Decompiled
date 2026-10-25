package p131o;

/* renamed from: o.o1 */
/* loaded from: classes.dex */
public class C4253o1 implements Cloneable {

    /* renamed from: KLFTb */
    public static final Object f15488KLFTb = new Object();

    /* renamed from: AZxh */
    public long[] f15489AZxh;

    /* renamed from: ZfxDd */
    public int f15490ZfxDd;

    /* renamed from: mjFkc */
    public boolean f15491mjFkc;

    /* renamed from: wA */
    public Object[] f15492wA;

    public C4253o1() {
        this(10);
    }

    /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
    public C4253o1 m12922clone() {
        try {
            C4253o1 c4253o1 = (C4253o1) super.clone();
            c4253o1.f15489AZxh = (long[]) this.f15489AZxh.clone();
            c4253o1.f15492wA = (Object[]) this.f15492wA.clone();
            return c4253o1;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: Dt */
    public void m12915Dt(long j, Object obj) {
        int iM9530AZxh = AbstractC2458MlqoT.m9530AZxh(this.f15489AZxh, this.f15490ZfxDd, j);
        if (iM9530AZxh >= 0) {
            this.f15492wA[iM9530AZxh] = obj;
            return;
        }
        int i = ~iM9530AZxh;
        int i2 = this.f15490ZfxDd;
        if (i < i2) {
            Object[] objArr = this.f15492wA;
            if (objArr[i] == f15488KLFTb) {
                this.f15489AZxh[i] = j;
                objArr[i] = obj;
                return;
            }
        }
        if (this.f15491mjFkc && i2 >= this.f15489AZxh.length) {
            m12926wA();
            i = ~AbstractC2458MlqoT.m9530AZxh(this.f15489AZxh, this.f15490ZfxDd, j);
        }
        int i3 = this.f15490ZfxDd;
        if (i3 >= this.f15489AZxh.length) {
            int iM9531JHa = AbstractC2458MlqoT.m9531JHa(i3 + 1);
            long[] jArr = new long[iM9531JHa];
            Object[] objArr2 = new Object[iM9531JHa];
            long[] jArr2 = this.f15489AZxh;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f15492wA;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f15489AZxh = jArr;
            this.f15492wA = objArr2;
        }
        int i4 = this.f15490ZfxDd;
        if (i4 - i != 0) {
            long[] jArr3 = this.f15489AZxh;
            int i5 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i5, i4 - i);
            Object[] objArr4 = this.f15492wA;
            System.arraycopy(objArr4, i, objArr4, i5, this.f15490ZfxDd - i);
        }
        this.f15489AZxh[i] = j;
        this.f15492wA[i] = obj;
        this.f15490ZfxDd++;
    }

    /* renamed from: ETF */
    public void m12916ETF(long j) {
        int iM9530AZxh = AbstractC2458MlqoT.m9530AZxh(this.f15489AZxh, this.f15490ZfxDd, j);
        if (iM9530AZxh >= 0) {
            Object[] objArr = this.f15492wA;
            Object obj = objArr[iM9530AZxh];
            Object obj2 = f15488KLFTb;
            if (obj != obj2) {
                objArr[iM9530AZxh] = obj2;
                this.f15491mjFkc = true;
            }
        }
    }

    /* renamed from: JHa */
    public Object m12917JHa(long j, Object obj) {
        Object obj2;
        int iM9530AZxh = AbstractC2458MlqoT.m9530AZxh(this.f15489AZxh, this.f15490ZfxDd, j);
        return (iM9530AZxh < 0 || (obj2 = this.f15492wA[iM9530AZxh]) == f15488KLFTb) ? obj : obj2;
    }

    /* renamed from: KLFTb */
    public Object m12918KLFTb(long j) {
        return m12917JHa(j, null);
    }

    /* renamed from: MiMN */
    public int m12919MiMN() {
        if (this.f15491mjFkc) {
            m12926wA();
        }
        return this.f15490ZfxDd;
    }

    /* renamed from: VA */
    public void m12920VA(int i) {
        Object[] objArr = this.f15492wA;
        Object obj = objArr[i];
        Object obj2 = f15488KLFTb;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.f15491mjFkc = true;
        }
    }

    /* renamed from: YoKzxo */
    public Object m12921YoKzxo(int i) {
        if (this.f15491mjFkc) {
            m12926wA();
        }
        return this.f15492wA[i];
    }

    /* renamed from: lgHUyS */
    public int m12923lgHUyS(long j) {
        if (this.f15491mjFkc) {
            m12926wA();
        }
        return AbstractC2458MlqoT.m9530AZxh(this.f15489AZxh, this.f15490ZfxDd, j);
    }

    /* renamed from: mjFkc */
    public void m12924mjFkc() {
        int i = this.f15490ZfxDd;
        Object[] objArr = this.f15492wA;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f15490ZfxDd = 0;
        this.f15491mjFkc = false;
    }

    /* renamed from: qdMbNW */
    public long m12925qdMbNW(int i) {
        if (this.f15491mjFkc) {
            m12926wA();
        }
        return this.f15489AZxh[i];
    }

    public String toString() {
        if (m12919MiMN() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f15490ZfxDd * 28);
        sb.append('{');
        for (int i = 0; i < this.f15490ZfxDd; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(m12925qdMbNW(i));
            sb.append('=');
            Object objM12921YoKzxo = m12921YoKzxo(i);
            if (objM12921YoKzxo != this) {
                sb.append(objM12921YoKzxo);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: wA */
    public final void m12926wA() {
        int i = this.f15490ZfxDd;
        long[] jArr = this.f15489AZxh;
        Object[] objArr = this.f15492wA;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f15488KLFTb) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f15491mjFkc = false;
        this.f15490ZfxDd = i2;
    }

    public C4253o1(int i) {
        this.f15491mjFkc = false;
        if (i == 0) {
            this.f15489AZxh = AbstractC2458MlqoT.f9604AZxh;
            this.f15492wA = AbstractC2458MlqoT.f9606wA;
        } else {
            int iM9531JHa = AbstractC2458MlqoT.m9531JHa(i);
            this.f15489AZxh = new long[iM9531JHa];
            this.f15492wA = new Object[iM9531JHa];
        }
    }
}
