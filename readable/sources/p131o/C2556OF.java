package p131o;

import java.io.IOException;

/* renamed from: o.OF */
/* loaded from: classes.dex */
public final class C2556OF implements InterfaceC2144I9 {

    /* renamed from: ZfxDd */
    public final C4801wF f9929ZfxDd;

    /* renamed from: wA */
    public C3363aQ f9931wA;

    /* renamed from: mjFkc */
    public boolean f9930mjFkc = false;

    /* renamed from: AZxh */
    public boolean f9928AZxh = false;

    public C2556OF(C4801wF c4801wF) {
        this.f9929ZfxDd = c4801wF;
    }

    /* renamed from: wA */
    private final void m9892wA() {
        if (this.f9930mjFkc) {
            throw new C2570ORe("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f9930mjFkc = true;
    }

    @Override // p131o.InterfaceC2144I9
    /* renamed from: AZxh */
    public final InterfaceC2144I9 mo8719AZxh(boolean z) throws IOException {
        m9892wA();
        this.f9929ZfxDd.m13837JHa(this.f9931wA, z ? 1 : 0, this.f9928AZxh);
        return this;
    }

    @Override // p131o.InterfaceC2144I9
    /* renamed from: add */
    public final InterfaceC2144I9 mo8720add(String str) throws IOException {
        m9892wA();
        this.f9929ZfxDd.m13838KLFTb(this.f9931wA, str, this.f9928AZxh);
        return this;
    }

    /* renamed from: mjFkc */
    public final void m9893mjFkc(C3363aQ c3363aQ, boolean z) {
        this.f9930mjFkc = false;
        this.f9931wA = c3363aQ;
        this.f9928AZxh = z;
    }
}
