package p131o;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: o.d2 */
/* loaded from: classes.dex */
public final class C3536d2 extends AbstractC1605A7 {
    /* renamed from: lgHUyS */
    public static C3536d2 m11641lgHUyS(ByteBuffer byteBuffer) {
        return m11642qdMbNW(byteBuffer, new C3536d2());
    }

    /* renamed from: qdMbNW */
    public static C3536d2 m11642qdMbNW(ByteBuffer byteBuffer, C3536d2 c3536d2) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return c3536d2.m11645JHa(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    /* renamed from: Dt */
    public C3471c2 m11643Dt(C3471c2 c3471c2, int i) {
        int iM7568AZxh = m7568AZxh(6);
        if (iM7568AZxh != 0) {
            return c3471c2.m11592JHa(m7571mjFkc(m7570ZfxDd(iM7568AZxh) + (i * 4)), this.f7317AZxh);
        }
        return null;
    }

    /* renamed from: ETF */
    public int m11644ETF() {
        int iM7568AZxh = m7568AZxh(6);
        if (iM7568AZxh != 0) {
            return m7569KLFTb(iM7568AZxh);
        }
        return 0;
    }

    /* renamed from: JHa */
    public C3536d2 m11645JHa(int i, ByteBuffer byteBuffer) {
        m11647xJ(i, byteBuffer);
        return this;
    }

    /* renamed from: VA */
    public int m11646VA() {
        int iM7568AZxh = m7568AZxh(4);
        if (iM7568AZxh != 0) {
            return this.f7317AZxh.getInt(iM7568AZxh + this.f7320mjFkc);
        }
        return 0;
    }

    /* renamed from: xJ */
    public void m11647xJ(int i, ByteBuffer byteBuffer) {
        m7572wA(i, byteBuffer);
    }
}
