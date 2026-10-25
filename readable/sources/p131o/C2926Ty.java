package p131o;

/* renamed from: o.Ty */
/* loaded from: classes.dex */
public final class C2926Ty implements InterfaceC2132Hy {

    /* renamed from: AZxh */
    public final String f10754AZxh;

    /* renamed from: ZfxDd */
    public final int f10755ZfxDd;

    /* renamed from: mjFkc */
    public final InterfaceC2341Ky f10756mjFkc;

    /* renamed from: wA */
    public final Object[] f10757wA;

    public C2926Ty(InterfaceC2341Ky interfaceC2341Ky, String str, Object[] objArr) {
        this.f10756mjFkc = interfaceC2341Ky;
        this.f10754AZxh = str;
        this.f10757wA = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f10755ZfxDd = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 1;
        int i3 = 13;
        while (true) {
            int i4 = i2 + 1;
            char cCharAt2 = str.charAt(i2);
            if (cCharAt2 < 55296) {
                this.f10755ZfxDd = i | (cCharAt2 << i3);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i3;
                i3 += 13;
                i2 = i4;
            }
        }
    }

    @Override // p131o.InterfaceC2132Hy
    /* renamed from: AZxh */
    public final int mo8631AZxh() {
        int i = this.f10755ZfxDd;
        if ((i & 1) != 0) {
            return 1;
        }
        return (i & 4) == 4 ? 3 : 2;
    }

    /* renamed from: KLFTb */
    public final Object[] m10448KLFTb() {
        return this.f10757wA;
    }

    /* renamed from: ZfxDd */
    public final String m10449ZfxDd() {
        return this.f10754AZxh;
    }

    @Override // p131o.InterfaceC2132Hy
    /* renamed from: mjFkc */
    public final InterfaceC2341Ky mo8632mjFkc() {
        return this.f10756mjFkc;
    }

    @Override // p131o.InterfaceC2132Hy
    /* renamed from: wA */
    public final boolean mo8633wA() {
        return (this.f10755ZfxDd & 2) == 2;
    }
}
