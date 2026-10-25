package p131o;

import java.nio.ByteBuffer;

/* renamed from: o.c2 */
/* loaded from: classes.dex */
public final class C3471c2 extends AbstractC1605A7 {
    /* renamed from: Dt */
    public boolean m11590Dt() {
        int iM7568AZxh = m7568AZxh(6);
        return (iM7568AZxh == 0 || this.f7317AZxh.get(iM7568AZxh + this.f7320mjFkc) == 0) ? false : true;
    }

    /* renamed from: ETF */
    public short m11591ETF() {
        int iM7568AZxh = m7568AZxh(14);
        if (iM7568AZxh != 0) {
            return this.f7317AZxh.getShort(iM7568AZxh + this.f7320mjFkc);
        }
        return (short) 0;
    }

    /* renamed from: JHa */
    public C3471c2 m11592JHa(int i, ByteBuffer byteBuffer) {
        m11598xJ(i, byteBuffer);
        return this;
    }

    /* renamed from: MiMN */
    public short m11593MiMN() {
        int iM7568AZxh = m7568AZxh(8);
        if (iM7568AZxh != 0) {
            return this.f7317AZxh.getShort(iM7568AZxh + this.f7320mjFkc);
        }
        return (short) 0;
    }

    /* renamed from: VA */
    public int m11594VA() {
        int iM7568AZxh = m7568AZxh(4);
        if (iM7568AZxh != 0) {
            return this.f7317AZxh.getInt(iM7568AZxh + this.f7320mjFkc);
        }
        return 0;
    }

    /* renamed from: YoKzxo */
    public short m11595YoKzxo() {
        int iM7568AZxh = m7568AZxh(12);
        if (iM7568AZxh != 0) {
            return this.f7317AZxh.getShort(iM7568AZxh + this.f7320mjFkc);
        }
        return (short) 0;
    }

    /* renamed from: lgHUyS */
    public int m11596lgHUyS(int i) {
        int iM7568AZxh = m7568AZxh(16);
        if (iM7568AZxh != 0) {
            return this.f7317AZxh.getInt(m7570ZfxDd(iM7568AZxh) + (i * 4));
        }
        return 0;
    }

    /* renamed from: qdMbNW */
    public int m11597qdMbNW() {
        int iM7568AZxh = m7568AZxh(16);
        if (iM7568AZxh != 0) {
            return m7569KLFTb(iM7568AZxh);
        }
        return 0;
    }

    /* renamed from: xJ */
    public void m11598xJ(int i, ByteBuffer byteBuffer) {
        m7572wA(i, byteBuffer);
    }
}
