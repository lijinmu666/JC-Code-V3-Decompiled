package p131o;

import java.io.UnsupportedEncodingException;

/* renamed from: o.CQ */
/* loaded from: classes.dex */
public final class C1758CQ implements InterfaceC3949jQ {

    /* renamed from: AZxh */
    public C2232JO f7628AZxh = new C2232JO();

    /* renamed from: mjFkc */
    public final C4409qM f7629mjFkc;

    public C1758CQ(C4409qM c4409qM, int i) {
        this.f7629mjFkc = c4409qM;
        C3364aR.m11318mjFkc();
    }

    /* renamed from: KLFTb */
    public static InterfaceC3949jQ m7829KLFTb(C4409qM c4409qM) {
        return new C1758CQ(c4409qM, 0);
    }

    @Override // p131o.InterfaceC3949jQ
    /* renamed from: AZxh */
    public final InterfaceC3949jQ mo7830AZxh(C2232JO c2232jo) {
        this.f7628AZxh = c2232jo;
        return this;
    }

    @Override // p131o.InterfaceC3949jQ
    /* renamed from: ZfxDd */
    public final InterfaceC3949jQ mo7831ZfxDd(EnumC4275oM enumC4275oM) {
        this.f7629mjFkc.m13208wA(enumC4275oM);
        return this;
    }

    @Override // p131o.InterfaceC3949jQ
    /* renamed from: mjFkc */
    public final String mo7832mjFkc() {
        C3025VO c3025voM13714wA = this.f7629mjFkc.m13205JHa().m13714wA();
        return (c3025voM13714wA == null || AbstractC3221YI.m11089AZxh(c3025voM13714wA.m10684ETF())) ? "NA" : (String) AbstractC2138I3.m8648xJ(c3025voM13714wA.m10684ETF());
    }

    @Override // p131o.InterfaceC3949jQ
    /* renamed from: wA */
    public final byte[] mo7833wA(int i, boolean z) {
        this.f7628AZxh.m8941JHa(Boolean.valueOf(1 == (i ^ 1)));
        this.f7628AZxh.m8942KLFTb(Boolean.FALSE);
        this.f7629mjFkc.m13206KLFTb(this.f7628AZxh.m8943MiMN());
        try {
            C3364aR.m11318mjFkc();
            if (i == 0) {
                return new C4121m0().m12731xJ(C4741vK.f17019mjFkc).m12730lgHUyS(true).m12727JHa().mo12290mjFkc(this.f7629mjFkc.m13205JHa()).getBytes("utf-8");
            }
            C4678uM c4678uMM13205JHa = this.f7629mjFkc.m13205JHa();
            C4330pC c4330pC = new C4330pC();
            C4741vK.f17019mjFkc.mo9658mjFkc(c4330pC);
            return c4330pC.m13070AZxh().m13494mjFkc(c4678uMM13205JHa);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }
}
