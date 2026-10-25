package p131o;

import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* renamed from: o.nTET */
/* loaded from: classes.dex */
public class C4217nTET implements InterfaceC4324p6 {

    /* renamed from: JHa */
    public static final Logger f15390JHa = Logger.getLogger(C3543d9.class.getName());

    /* renamed from: AZxh */
    public final Executor f15391AZxh;

    /* renamed from: KLFTb */
    public final InterfaceC4992z7 f15392KLFTb;

    /* renamed from: ZfxDd */
    public final InterfaceC4829wfQA f15393ZfxDd;

    /* renamed from: mjFkc */
    public final InterfaceC4957yb f15394mjFkc;

    /* renamed from: wA */
    public final InterfaceC4598tAfC f15395wA;

    public C4217nTET(Executor executor, InterfaceC4598tAfC interfaceC4598tAfC, InterfaceC4957yb interfaceC4957yb, InterfaceC4829wfQA interfaceC4829wfQA, InterfaceC4992z7 interfaceC4992z7) {
        this.f15391AZxh = executor;
        this.f15395wA = interfaceC4598tAfC;
        this.f15394mjFkc = interfaceC4957yb;
        this.f15393ZfxDd = interfaceC4829wfQA;
        this.f15392KLFTb = interfaceC4992z7;
    }

    /* renamed from: AZxh */
    public static /* synthetic */ Object m12881AZxh(C4217nTET c4217nTET, AbstractC3140X8 abstractC3140X8, AbstractC2097HPA abstractC2097HPA) {
        c4217nTET.f15393ZfxDd.mo11693rkYL(abstractC3140X8, abstractC2097HPA);
        c4217nTET.f15394mjFkc.mo11973mjFkc(abstractC3140X8, 1);
        return null;
    }

    /* renamed from: wA */
    public static /* synthetic */ void m12882wA(C4217nTET c4217nTET, AbstractC3140X8 abstractC3140X8, InterfaceC3736g9 interfaceC3736g9, AbstractC2097HPA abstractC2097HPA) {
        try {
            InterfaceC3076W8 interfaceC3076W8Mo11270get = c4217nTET.f15395wA.mo11270get(abstractC3140X8.mo10887AZxh());
            if (interfaceC3076W8Mo11270get == null) {
                String str = String.format("Transport backend '%s' is not registered", abstractC3140X8.mo10887AZxh());
                f15390JHa.warning(str);
                interfaceC3736g9.mo11306mjFkc(new IllegalArgumentException(str));
            } else {
                c4217nTET.f15392KLFTb.mo11686ZfxDd(C2187Io.m8800AZxh(c4217nTET, abstractC3140X8, interfaceC3076W8Mo11270get.mo10831AZxh(abstractC2097HPA)));
                interfaceC3736g9.mo11306mjFkc(null);
            }
        } catch (Exception e) {
            f15390JHa.warning("Error scheduling event " + e.getMessage());
            interfaceC3736g9.mo11306mjFkc(e);
        }
    }

    @Override // p131o.InterfaceC4324p6
    /* renamed from: mjFkc */
    public void mo12883mjFkc(AbstractC3140X8 abstractC3140X8, AbstractC2097HPA abstractC2097HPA, InterfaceC3736g9 interfaceC3736g9) {
        this.f15391AZxh.execute(RunnableC4878xM.m13932mjFkc(this, abstractC3140X8, interfaceC3736g9, abstractC2097HPA));
    }
}
