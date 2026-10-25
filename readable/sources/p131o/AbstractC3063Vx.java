package p131o;

/* renamed from: o.Vx */
/* loaded from: classes.dex */
public abstract class AbstractC3063Vx extends AbstractC3594dx {

    /* renamed from: AZxh */
    public AbstractC3595dy f11390AZxh;

    /* renamed from: mjFkc */
    public final AbstractC3595dy f11391mjFkc;

    public AbstractC3063Vx(AbstractC3595dy abstractC3595dy) {
        this.f11391mjFkc = abstractC3595dy;
        if (abstractC3595dy.m11768fehf()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.f11390AZxh = abstractC3595dy.m11761HGpJ();
    }

    /* renamed from: qdMbNW */
    public static void m10736qdMbNW(Object obj, Object obj2) {
        C2796Ry.m10116mjFkc().m10117AZxh(obj.getClass()).mo9776xJ(obj, obj2);
    }

    /* renamed from: Dt, reason: merged with bridge method [inline-methods] */
    public final AbstractC3063Vx m10742clone() {
        AbstractC3063Vx abstractC3063Vx = (AbstractC3063Vx) this.f11391mjFkc.mo7631IEE(5, null, null);
        abstractC3063Vx.f11390AZxh = mo9071xJ();
        return abstractC3063Vx;
    }

    /* renamed from: ETF */
    public final AbstractC3063Vx m10738ETF(AbstractC3595dy abstractC3595dy) {
        if (!this.f11391mjFkc.m11766equals(abstractC3595dy)) {
            if (!this.f11390AZxh.m11768fehf()) {
                mo10743rkYL();
            }
            m10736qdMbNW(this.f11390AZxh, abstractC3595dy);
        }
        return this;
    }

    @Override // p131o.InterfaceC2274Jy
    /* renamed from: MiMN, reason: merged with bridge method [inline-methods] */
    public AbstractC3595dy mo9071xJ() {
        if (!this.f11390AZxh.m11768fehf()) {
            return this.f11390AZxh;
        }
        this.f11390AZxh.m11765VA();
        return this.f11390AZxh;
    }

    @Override // p131o.InterfaceC2274Jy
    /* renamed from: VA, reason: merged with bridge method [inline-methods] */
    public final AbstractC3595dy mo9070ZfxDd() {
        AbstractC3595dy abstractC3595dyMo9071xJ = mo9071xJ();
        if (AbstractC3595dy.m11758qGY(abstractC3595dyMo9071xJ, true)) {
            return abstractC3595dyMo9071xJ;
        }
        throw new C3918iz(abstractC3595dyMo9071xJ);
    }

    /* renamed from: YoKzxo */
    public final void m10741YoKzxo() {
        if (this.f11390AZxh.m11768fehf()) {
            return;
        }
        mo10743rkYL();
    }

    /* renamed from: rkYL */
    public void mo10743rkYL() {
        AbstractC3595dy abstractC3595dyM11761HGpJ = this.f11391mjFkc.m11761HGpJ();
        m10736qdMbNW(abstractC3595dyM11761HGpJ, this.f11390AZxh);
        this.f11390AZxh = abstractC3595dyM11761HGpJ;
    }

    @Override // p131o.InterfaceC2404Ly
    /* renamed from: wA */
    public final boolean mo9400wA() {
        return AbstractC3595dy.m11758qGY(this.f11390AZxh, false);
    }
}
