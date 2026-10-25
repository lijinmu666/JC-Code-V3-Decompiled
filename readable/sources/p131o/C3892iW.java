package p131o;

import java.io.UnsupportedEncodingException;

/* renamed from: o.iW */
/* loaded from: classes.dex */
public final class C3892iW implements InterfaceC2443MV {

    /* renamed from: AZxh */
    public C3434bV f14154AZxh = new C3434bV();

    /* renamed from: mjFkc */
    public final C4215nS f14155mjFkc;

    /* renamed from: wA */
    public final int f14156wA;

    public C3892iW(C4215nS c4215nS, int i) {
        this.f14155mjFkc = c4215nS;
        C4487rW.m13376mjFkc();
        this.f14156wA = i;
    }

    /* renamed from: JHa */
    public static InterfaceC2443MV m12298JHa(C4215nS c4215nS, int i) {
        return new C3892iW(c4215nS, 1);
    }

    /* renamed from: KLFTb */
    public static InterfaceC2443MV m12299KLFTb(C4215nS c4215nS) {
        return new C3892iW(c4215nS, 0);
    }

    @Override // p131o.InterfaceC2443MV
    /* renamed from: AZxh */
    public final InterfaceC2443MV mo9513AZxh(C3434bV c3434bV) {
        this.f14154AZxh = c3434bV;
        return this;
    }

    @Override // p131o.InterfaceC2443MV
    /* renamed from: ZfxDd */
    public final InterfaceC2443MV mo9514ZfxDd(EnumC4151mS enumC4151mS) {
        this.f14155mjFkc.m12875JHa(enumC4151mS);
        return this;
    }

    @Override // p131o.InterfaceC2443MV
    /* renamed from: mjFkc */
    public final byte[] mo9515mjFkc(int i, boolean z) {
        this.f14154AZxh.m11495JHa(Boolean.valueOf(1 == (i ^ 1)));
        this.f14154AZxh.m11496KLFTb(Boolean.FALSE);
        this.f14155mjFkc.m12879qdMbNW(this.f14154AZxh.m11497MiMN());
        try {
            C4487rW.m13376mjFkc();
            if (i == 0) {
                return new C4121m0().m12731xJ(C2507NQ.f9741mjFkc).m12730lgHUyS(true).m12727JHa().mo12290mjFkc(this.f14155mjFkc.m12874Dt()).getBytes("utf-8");
            }
            C4350pS c4350pSM12874Dt = this.f14155mjFkc.m12874Dt();
            C2292KF c2292kf = new C2292KF();
            C2507NQ.f9741mjFkc.mo9658mjFkc(c2292kf);
            return c2292kf.m9182AZxh().m9493mjFkc(c4350pSM12874Dt);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedOperationException("Failed to covert logging to UTF-8 byte array", e);
        }
    }

    @Override // p131o.InterfaceC2443MV
    /* renamed from: wA */
    public final String mo9516wA() {
        C3696fV c3696fVM13127JHa = this.f14155mjFkc.m12874Dt().m13127JHa();
        return (c3696fVM13127JHa == null || AbstractC3438bX.m11525AZxh(c3696fVM13127JHa.m11938ETF())) ? "NA" : (String) AbstractC2138I3.m8648xJ(c3696fVM13127JHa.m11938ETF());
    }

    @Override // p131o.InterfaceC2443MV
    /* renamed from: zza */
    public final int mo9517zza() {
        return this.f14156wA;
    }
}
