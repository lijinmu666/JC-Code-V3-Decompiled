package p131o;

/* renamed from: o.qx */
/* loaded from: classes.dex */
public final class C4450qx extends C4917xx {

    /* renamed from: ZfxDd */
    public final int f16271ZfxDd;

    public C4450qx(byte[] bArr, int i, int i2) {
        super(bArr);
        AbstractC4981yx.m14053Dt(0, i2, bArr.length);
        this.f16271ZfxDd = i2;
    }

    @Override // p131o.C4917xx, p131o.AbstractC4981yx
    /* renamed from: JHa */
    public final int mo13326JHa() {
        return this.f16271ZfxDd;
    }

    @Override // p131o.C4917xx
    /* renamed from: MiMN */
    public final int mo13327MiMN() {
        return 0;
    }

    @Override // p131o.C4917xx, p131o.AbstractC4981yx
    /* renamed from: ZfxDd */
    public final byte mo13328ZfxDd(int i) {
        return this.f17466wA[i];
    }

    @Override // p131o.C4917xx, p131o.AbstractC4981yx
    /* renamed from: mjFkc */
    public final byte mo13329mjFkc(int i) {
        int i2 = this.f16271ZfxDd;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.f17466wA[i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
    }
}
