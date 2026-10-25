package p131o;

import java.nio.ByteBuffer;

/* renamed from: o.A7 */
/* loaded from: classes.dex */
public abstract class AbstractC1605A7 {

    /* renamed from: AZxh */
    public ByteBuffer f7317AZxh;

    /* renamed from: KLFTb */
    public AbstractC1939F9 f7318KLFTb = AbstractC1939F9.m8267mjFkc();

    /* renamed from: ZfxDd */
    public int f7319ZfxDd;

    /* renamed from: mjFkc */
    public int f7320mjFkc;

    /* renamed from: wA */
    public int f7321wA;

    /* renamed from: AZxh */
    public int m7568AZxh(int i) {
        if (i < this.f7319ZfxDd) {
            return this.f7317AZxh.getShort(this.f7321wA + i);
        }
        return 0;
    }

    /* renamed from: KLFTb */
    public int m7569KLFTb(int i) {
        int i2 = i + this.f7320mjFkc;
        return this.f7317AZxh.getInt(i2 + this.f7317AZxh.getInt(i2));
    }

    /* renamed from: ZfxDd */
    public int m7570ZfxDd(int i) {
        int i2 = i + this.f7320mjFkc;
        return i2 + this.f7317AZxh.getInt(i2) + 4;
    }

    /* renamed from: mjFkc */
    public int m7571mjFkc(int i) {
        return i + this.f7317AZxh.getInt(i);
    }

    /* renamed from: wA */
    public void m7572wA(int i, ByteBuffer byteBuffer) {
        this.f7317AZxh = byteBuffer;
        if (byteBuffer == null) {
            this.f7320mjFkc = 0;
            this.f7321wA = 0;
            this.f7319ZfxDd = 0;
        } else {
            this.f7320mjFkc = i;
            int i2 = i - byteBuffer.getInt(i);
            this.f7321wA = i2;
            this.f7319ZfxDd = this.f7317AZxh.getShort(i2);
        }
    }
}
