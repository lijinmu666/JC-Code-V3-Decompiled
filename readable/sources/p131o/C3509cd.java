package p131o;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.p038google.p039android.p042gms.p046common.p047api.C0210Status;

/* renamed from: o.cd */
/* loaded from: classes.dex */
public final class C3509cd extends AbstractC4894xc {

    /* renamed from: AZxh */
    public final AbstractC1737C7 f13238AZxh;

    /* renamed from: ZfxDd */
    public final InterfaceC4064l7 f13239ZfxDd;

    /* renamed from: wA */
    public final C1806D7 f13240wA;

    public C3509cd(int i, AbstractC1737C7 abstractC1737C7, C1806D7 c1806d7, InterfaceC4064l7 interfaceC4064l7) {
        super(i);
        this.f13240wA = c1806d7;
        this.f13238AZxh = abstractC1737C7;
        this.f13239ZfxDd = interfaceC4064l7;
        if (i == 2 && abstractC1737C7.m7768wA()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // p131o.AbstractC4028kd
    /* renamed from: AZxh */
    public final void mo9000AZxh(Exception exc) {
        this.f13240wA.m7976ZfxDd(exc);
    }

    @Override // p131o.AbstractC4894xc
    /* renamed from: JHa */
    public final boolean mo11611JHa(C4027kc c4027kc) {
        return this.f13238AZxh.m7768wA();
    }

    @Override // p131o.AbstractC4028kd
    /* renamed from: ZfxDd */
    public final void mo11612ZfxDd(C2969Ub c2969Ub, boolean z) {
        c2969Ub.m10518AZxh(this.f13240wA, z);
    }

    @Override // p131o.AbstractC4028kd
    /* renamed from: mjFkc */
    public final void mo9002mjFkc(C0210Status c0210Status) {
        this.f13240wA.m7976ZfxDd(this.f13239ZfxDd.mo9186mjFkc(c0210Status));
    }

    @Override // p131o.AbstractC4028kd
    /* renamed from: wA */
    public final void mo9003wA(C4027kc c4027kc) throws DeadObjectException {
        try {
            this.f13238AZxh.mo7765AZxh(c4027kc.m12570Ucbh(), this.f13240wA);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e2) {
            mo9002mjFkc(AbstractC4028kd.m12586KLFTb(e2));
        } catch (RuntimeException e3) {
            this.f13240wA.m7976ZfxDd(e3);
        }
    }

    @Override // p131o.AbstractC4894xc
    /* renamed from: xJ */
    public final C2987UokA[] mo11613xJ(C4027kc c4027kc) {
        return this.f13238AZxh.m7766KLFTb();
    }
}
