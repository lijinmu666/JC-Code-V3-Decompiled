package p131o;

import android.content.Context;
import p131o.AbstractC1737C7;
import p131o.AbstractC3533d;
import p131o.C3389aqHPIZ;

/* renamed from: o.vd */
/* loaded from: classes.dex */
public final class C4760vd extends AbstractC3533d implements InterfaceC2806S7 {

    /* renamed from: ETF */
    public static final C3389aqHPIZ.xJ f17030ETF;

    /* renamed from: MiMN */
    public static final C3389aqHPIZ f17031MiMN;

    /* renamed from: VA */
    public static final C3389aqHPIZ.mjFkc f17032VA;

    static {
        C3389aqHPIZ.xJ xJVar = new C3389aqHPIZ.xJ();
        f17030ETF = xJVar;
        C4560sd c4560sd = new C4560sd();
        f17032VA = c4560sd;
        f17031MiMN = new C3389aqHPIZ("ClientTelemetry.API", c4560sd, xJVar);
    }

    public C4760vd(Context context, C2874T7 c2874t7) {
        super(context, f17031MiMN, c2874t7, AbstractC3533d.mjFkc.f13288wA);
    }

    @Override // p131o.InterfaceC2806S7
    /* renamed from: mjFkc */
    public final AbstractC1670B7 mo10134mjFkc(final C2675Q7 c2675q7) {
        AbstractC1737C7.mjFkc mjfkcM7764mjFkc = AbstractC1737C7.m7764mjFkc();
        mjfkcM7764mjFkc.m7772ZfxDd(AbstractC3104Wc.f11473mjFkc);
        mjfkcM7764mjFkc.m7774wA(false);
        mjfkcM7764mjFkc.m7770AZxh(new InterfaceC3863i5() { // from class: o.pd
            @Override // p131o.InterfaceC3863i5
            /* renamed from: mjFkc */
            public final void mo12279mjFkc(Object obj, Object obj2) {
                C3389aqHPIZ.xJ xJVar = C4760vd.f17030ETF;
                ((C3896id) ((C1638Ad) obj).m9224lB()).m12304Ucbh(c2675q7);
                ((C1806D7) obj2).m7978wA(null);
            }
        });
        return m11633ZfxDd(mjfkcM7764mjFkc.m7773mjFkc());
    }
}
