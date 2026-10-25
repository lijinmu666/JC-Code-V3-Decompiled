package p131o;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* renamed from: o.vC */
/* loaded from: classes.dex */
public final class C4732vC implements InterfaceC2144I9 {

    /* renamed from: ZfxDd */
    public final C3932jC f16989ZfxDd;

    /* renamed from: wA */
    public C3363aQ f16991wA;

    /* renamed from: mjFkc */
    public boolean f16990mjFkc = false;

    /* renamed from: AZxh */
    public boolean f16988AZxh = false;

    public C4732vC(C3932jC c3932jC) {
        this.f16989ZfxDd = c3932jC;
    }

    @Override // p131o.InterfaceC2144I9
    /* renamed from: AZxh */
    public final InterfaceC2144I9 mo8719AZxh(boolean z) throws IOException {
        m13765wA();
        this.f16989ZfxDd.m12399JHa(this.f16991wA, z ? 1 : 0, this.f16988AZxh);
        return this;
    }

    @Override // p131o.InterfaceC2144I9
    /* renamed from: add */
    public final InterfaceC2144I9 mo8720add(String str) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        m13765wA();
        this.f16989ZfxDd.m12400KLFTb(this.f16991wA, str, this.f16988AZxh);
        return this;
    }

    /* renamed from: mjFkc */
    public final void m13764mjFkc(C3363aQ c3363aQ, boolean z) {
        this.f16990mjFkc = false;
        this.f16991wA = c3363aQ;
        this.f16988AZxh = z;
    }

    /* renamed from: wA */
    public final void m13765wA() {
        if (this.f16990mjFkc) {
            throw new C2570ORe("Cannot encode a second value in the ValueEncoderContext");
        }
        this.f16990mjFkc = true;
    }
}
