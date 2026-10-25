package p131o;

/* renamed from: o.Ax */
/* loaded from: classes.dex */
public final class C1659Ax extends AbstractC1795Cx {

    /* renamed from: AZxh */
    public int f7417AZxh;

    /* renamed from: ZfxDd */
    public int f7418ZfxDd;

    /* renamed from: wA */
    public int f7419wA;

    public /* synthetic */ C1659Ax(byte[] bArr, int i, int i2, boolean z, AbstractC5046zx abstractC5046zx) {
        super(null);
        this.f7418ZfxDd = Integer.MAX_VALUE;
        this.f7417AZxh = 0;
    }

    /* renamed from: wA */
    public final int m7641wA(int i) {
        int i2 = this.f7418ZfxDd;
        this.f7418ZfxDd = 0;
        int i3 = this.f7417AZxh + this.f7419wA;
        this.f7417AZxh = i3;
        if (i3 > 0) {
            this.f7419wA = i3;
            this.f7417AZxh = 0;
        } else {
            this.f7419wA = 0;
        }
        return i2;
    }
}
