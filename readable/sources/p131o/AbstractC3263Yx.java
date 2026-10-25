package p131o;

/* renamed from: o.Yx */
/* loaded from: classes.dex */
public abstract class AbstractC3263Yx extends AbstractC3063Vx implements InterfaceC2404Ly {
    public AbstractC3263Yx(AbstractC3330Zx abstractC3330Zx) {
        super(abstractC3330Zx);
    }

    @Override // p131o.AbstractC3063Vx, p131o.InterfaceC2274Jy
    /* renamed from: qGY, reason: merged with bridge method [inline-methods] */
    public final AbstractC3330Zx mo9071xJ() {
        if (!((AbstractC3330Zx) this.f11390AZxh).m11768fehf()) {
            return (AbstractC3330Zx) this.f11390AZxh;
        }
        ((AbstractC3330Zx) this.f11390AZxh).f12261zbb.m9985lgHUyS();
        return (AbstractC3330Zx) super.mo9071xJ();
    }

    @Override // p131o.AbstractC3063Vx
    /* renamed from: rkYL */
    public final void mo10743rkYL() {
        super.mo10743rkYL();
        if (((AbstractC3330Zx) this.f11390AZxh).f12261zbb != C2664Px.m9973KLFTb()) {
            AbstractC3330Zx abstractC3330Zx = (AbstractC3330Zx) this.f11390AZxh;
            abstractC3330Zx.f12261zbb = abstractC3330Zx.f12261zbb.m9983clone();
        }
    }
}
