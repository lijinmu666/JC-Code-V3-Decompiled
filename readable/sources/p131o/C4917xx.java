package p131o;

/* renamed from: o.xx */
/* loaded from: classes.dex */
public class C4917xx extends AbstractC4849wx {

    /* renamed from: wA */
    public final byte[] f17466wA;

    public C4917xx(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.f17466wA = bArr;
    }

    @Override // p131o.AbstractC4981yx
    /* renamed from: JHa */
    public int mo13326JHa() {
        return this.f17466wA.length;
    }

    /* renamed from: MiMN */
    public int mo13327MiMN() {
        return 0;
    }

    @Override // p131o.AbstractC4981yx
    /* renamed from: ZfxDd */
    public byte mo13328ZfxDd(int i) {
        return this.f17466wA[i];
    }

    @Override // p131o.AbstractC4981yx
    /* renamed from: equals */
    public final boolean mo13973equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC4981yx) || mo13326JHa() != ((AbstractC4981yx) obj).mo13326JHa()) {
            return false;
        }
        if (mo13326JHa() == 0) {
            return true;
        }
        if (!(obj instanceof C4917xx)) {
            return obj.equals(this);
        }
        C4917xx c4917xx = (C4917xx) obj;
        int iM14055ETF = m14055ETF();
        int iM14055ETF2 = c4917xx.m14055ETF();
        if (iM14055ETF != 0 && iM14055ETF2 != 0 && iM14055ETF != iM14055ETF2) {
            return false;
        }
        int iMo13326JHa = mo13326JHa();
        if (iMo13326JHa > c4917xx.mo13326JHa()) {
            throw new IllegalArgumentException("Length too large: " + iMo13326JHa + mo13326JHa());
        }
        if (iMo13326JHa > c4917xx.mo13326JHa()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + iMo13326JHa + ", " + c4917xx.mo13326JHa());
        }
        byte[] bArr = this.f17466wA;
        byte[] bArr2 = c4917xx.f17466wA;
        c4917xx.mo13327MiMN();
        int i = 0;
        int i2 = 0;
        while (i < iMo13326JHa) {
            if (bArr[i] != bArr2[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @Override // p131o.AbstractC4981yx
    /* renamed from: lgHUyS */
    public final AbstractC4981yx mo13974lgHUyS(int i, int i2) {
        int iM14053Dt = AbstractC4981yx.m14053Dt(0, i2, mo13326JHa());
        return iM14053Dt == 0 ? AbstractC4981yx.f17599AZxh : new C4450qx(this.f17466wA, 0, iM14053Dt);
    }

    @Override // p131o.AbstractC4981yx
    /* renamed from: mjFkc */
    public byte mo13329mjFkc(int i) {
        return this.f17466wA[i];
    }

    @Override // p131o.AbstractC4981yx
    /* renamed from: qdMbNW */
    public final void mo13975qdMbNW(AbstractC4247nx abstractC4247nx) {
        ((C1856Dx) abstractC4247nx).m8067CqaNbM(this.f17466wA, 0, mo13326JHa());
    }

    @Override // p131o.AbstractC4981yx
    /* renamed from: xJ */
    public final int mo13976xJ(int i, int i2, int i3) {
        return AbstractC4183my.m12815AZxh(i, this.f17466wA, 0, i3);
    }
}
