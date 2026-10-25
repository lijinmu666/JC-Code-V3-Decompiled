package p131o;

import android.content.Context;
import java.util.Collections;
import java.util.Set;

/* renamed from: o.d9 */
/* loaded from: classes.dex */
public class C3543d9 implements InterfaceC3478c9 {

    /* renamed from: KLFTb */
    public static volatile AbstractC3607e9 f13313KLFTb;

    /* renamed from: AZxh */
    public final InterfaceC3350aDq f13314AZxh;

    /* renamed from: ZfxDd */
    public final C1672B9 f13315ZfxDd;

    /* renamed from: mjFkc */
    public final InterfaceC3350aDq f13316mjFkc;

    /* renamed from: wA */
    public final InterfaceC4324p6 f13317wA;

    public C3543d9(InterfaceC3350aDq interfaceC3350aDq, InterfaceC3350aDq interfaceC3350aDq2, InterfaceC4324p6 interfaceC4324p6, C1672B9 c1672b9, C4824wb c4824wb) {
        this.f13316mjFkc = interfaceC3350aDq;
        this.f13314AZxh = interfaceC3350aDq2;
        this.f13317wA = interfaceC4324p6;
        this.f13315ZfxDd = c1672b9;
        c4824wb.m13862mjFkc();
    }

    /* renamed from: JHa */
    public static void m11710JHa(Context context) {
        if (f13313KLFTb == null) {
            synchronized (C3543d9.class) {
                try {
                    if (f13313KLFTb == null) {
                        f13313KLFTb = C3985jwyZcq.m12450xJ().mo11819mjFkc(context).mo11818build();
                    }
                } finally {
                }
            }
        }
    }

    /* renamed from: ZfxDd */
    public static Set m11711ZfxDd(InterfaceC1635Ab interfaceC1635Ab) {
        return interfaceC1635Ab instanceof InterfaceC4731vBFMCS ? Collections.unmodifiableSet(((InterfaceC4731vBFMCS) interfaceC1635Ab).mo12982mjFkc()) : Collections.singleton(C3569dXmy.m11728AZxh("proto"));
    }

    /* renamed from: wA */
    public static C3543d9 m11712wA() {
        AbstractC3607e9 abstractC3607e9 = f13313KLFTb;
        if (abstractC3607e9 != null) {
            return abstractC3607e9.mo11816KLFTb();
        }
        throw new IllegalStateException("Not initialized!");
    }

    /* renamed from: AZxh */
    public final AbstractC2097HPA m11713AZxh(AbstractC1736C6 abstractC1736C6) {
        return AbstractC2097HPA.m8545mjFkc().mo8565qdMbNW(this.f13316mjFkc.mo7979mjFkc()).mo8559ETF(this.f13314AZxh.mo7979mjFkc()).mo8558Dt(abstractC1736C6.mo7757xJ()).mo8563lgHUyS(new C3331ZxmHEb(abstractC1736C6.mo7752AZxh(), abstractC1736C6.m7755ZfxDd())).mo8567xJ(abstractC1736C6.mo7756wA().mo10916mjFkc()).mo8562ZfxDd();
    }

    /* renamed from: KLFTb */
    public C1672B9 m11714KLFTb() {
        return this.f13315ZfxDd;
    }

    @Override // p131o.InterfaceC3478c9
    /* renamed from: mjFkc */
    public void mo11607mjFkc(AbstractC1736C6 abstractC1736C6, InterfaceC3736g9 interfaceC3736g9) {
        this.f13317wA.mo12883mjFkc(abstractC1736C6.mo7753JHa().m10888KLFTb(abstractC1736C6.mo7756wA().mo10917wA()), m11713AZxh(abstractC1736C6), interfaceC3736g9);
    }

    /* renamed from: xJ */
    public InterfaceC3210Y8 m11715xJ(InterfaceC1635Ab interfaceC1635Ab) {
        return new C3276Z8(m11711ZfxDd(interfaceC1635Ab), AbstractC3140X8.m10886mjFkc().mo10891AZxh(interfaceC1635Ab.mo7621getName()).mo10894wA(interfaceC1635Ab.mo7620AZxh()).mo10893mjFkc(), this);
    }
}
