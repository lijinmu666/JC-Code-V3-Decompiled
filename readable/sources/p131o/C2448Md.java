package p131o;

import android.content.Context;
import p131o.AbstractC1737C7;
import p131o.AbstractC3533d;
import p131o.C3389aqHPIZ;

/* renamed from: o.Md */
/* loaded from: classes.dex */
public final class C2448Md extends AbstractC3533d implements InterfaceC4387q2 {

    /* renamed from: ETF */
    public static final C3389aqHPIZ.xJ f9586ETF;

    /* renamed from: MiMN */
    public static final C3389aqHPIZ f9587MiMN;

    /* renamed from: VA */
    public static final C3389aqHPIZ.mjFkc f9588VA;

    static {
        C3389aqHPIZ.xJ xJVar = new C3389aqHPIZ.xJ();
        f9586ETF = xJVar;
        C1836Dd c1836Dd = new C1836Dd();
        f9588VA = c1836Dd;
        f9587MiMN = new C3389aqHPIZ("ModuleInstall.API", c1836Dd, xJVar);
    }

    public C2448Md(Context context) {
        super(context, f9587MiMN, C3389aqHPIZ.ZfxDd.f12821mjFkc, AbstractC3533d.mjFkc.f13288wA);
    }

    @Override // p131o.InterfaceC4387q2
    /* renamed from: AZxh */
    public final AbstractC1670B7 mo9522AZxh(C4522s2 c4522s2) {
        final C4673uHVRx c4673uHVRxM13708mjFkc = C4673uHVRx.m13708mjFkc(c4522s2);
        c4522s2.m13446AZxh();
        c4522s2.m13448wA();
        if (c4673uHVRxM13708mjFkc.m13710AZxh().isEmpty()) {
            return AbstractC2142I7.m8716wA(new C4589t2(0));
        }
        AbstractC1737C7.mjFkc mjfkcM7764mjFkc = AbstractC1737C7.m7764mjFkc();
        mjfkcM7764mjFkc.m7772ZfxDd(AbstractC2249Jd.f9014mjFkc);
        mjfkcM7764mjFkc.m7774wA(true);
        mjfkcM7764mjFkc.m7771KLFTb(27304);
        mjfkcM7764mjFkc.m7770AZxh(new InterfaceC3863i5() { // from class: o.wd
            @Override // p131o.InterfaceC3863i5
            /* renamed from: mjFkc */
            public final void mo12279mjFkc(Object obj, Object obj2) {
                ((C3036Vc) ((C2517Nd) obj).m9224lB()).m10697Ucbh(new BinderC1902Ed(this.f17236mjFkc, (C1806D7) obj2), c4673uHVRxM13708mjFkc, null);
            }
        });
        return m11631KLFTb(mjfkcM7764mjFkc.m7773mjFkc());
    }
}
