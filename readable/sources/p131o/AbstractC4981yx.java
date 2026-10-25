package p131o;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Locale;

/* renamed from: o.yx */
/* loaded from: classes.dex */
public abstract class AbstractC4981yx implements Iterable, Serializable {

    /* renamed from: AZxh */
    public static final AbstractC4981yx f17599AZxh = new C4917xx(AbstractC4183my.f15286AZxh);

    /* renamed from: mjFkc */
    public int f17600mjFkc = 0;

    static {
        int i = AbstractC3792gx.f13874mjFkc;
    }

    /* renamed from: Dt */
    public static int m14053Dt(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i + " < 0");
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i + ", " + i2);
        }
        throw new IndexOutOfBoundsException("End index: " + i2 + " >= " + i3);
    }

    /* renamed from: VA */
    public static AbstractC4981yx m14054VA(byte[] bArr, int i, int i2) {
        m14053Dt(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new C4917xx(bArr2);
    }

    /* renamed from: ETF */
    public final int m14055ETF() {
        return this.f17600mjFkc;
    }

    /* renamed from: JHa */
    public abstract int mo13326JHa();

    /* renamed from: ZfxDd */
    public abstract byte mo13328ZfxDd(int i);

    /* renamed from: equals */
    public abstract boolean mo13973equals(Object obj);

    public final int hashCode() {
        int iMo13976xJ = this.f17600mjFkc;
        if (iMo13976xJ == 0) {
            int iMo13326JHa = mo13326JHa();
            iMo13976xJ = mo13976xJ(iMo13326JHa, 0, iMo13326JHa);
            if (iMo13976xJ == 0) {
                iMo13976xJ = 1;
            }
            this.f17600mjFkc = iMo13976xJ;
        }
        return iMo13976xJ;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new C4314ox(this);
    }

    /* renamed from: lgHUyS */
    public abstract AbstractC4981yx mo13974lgHUyS(int i, int i2);

    /* renamed from: mjFkc */
    public abstract byte mo13329mjFkc(int i);

    /* renamed from: qdMbNW */
    public abstract void mo13975qdMbNW(AbstractC4247nx abstractC4247nx);

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(mo13326JHa()), mo13326JHa() <= 50 ? AbstractC3856hz.m12260mjFkc(this) : AbstractC3856hz.m12260mjFkc(mo13974lgHUyS(0, 47)).concat("..."));
    }

    /* renamed from: xJ */
    public abstract int mo13976xJ(int i, int i2, int i3);
}
