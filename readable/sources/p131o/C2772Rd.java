package p131o;

/* renamed from: o.Rd */
/* loaded from: classes.dex */
public final class C2772Rd extends AbstractC3720fu {

    /* renamed from: AZxh */
    public final C2994Uu f10439AZxh;

    /* renamed from: ZfxDd */
    public final boolean f10440ZfxDd;

    /* renamed from: mjFkc */
    public final AbstractC2194Iu f10441mjFkc;

    /* renamed from: wA */
    public final AbstractC2919Ts f10442wA;

    public C2772Rd(AbstractC2194Iu abstractC2194Iu, C2994Uu c2994Uu, AbstractC2919Ts abstractC2919Ts, boolean z) {
        this.f10441mjFkc = abstractC2194Iu;
        this.f10439AZxh = c2994Uu;
        if (abstractC2919Ts == null) {
            throw new NullPointerException("Null lineBoxParcels");
        }
        this.f10442wA = abstractC2919Ts;
        this.f10440ZfxDd = z;
    }

    @Override // p131o.AbstractC3720fu
    /* renamed from: AZxh */
    public final C2994Uu mo10086AZxh() {
        return this.f10439AZxh;
    }

    @Override // p131o.AbstractC3720fu
    /* renamed from: ZfxDd */
    public final boolean mo10087ZfxDd() {
        return this.f10440ZfxDd;
    }

    /* renamed from: equals */
    public final boolean m10088equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC3720fu) {
            AbstractC3720fu abstractC3720fu = (AbstractC3720fu) obj;
            if (this.f10441mjFkc.equals(abstractC3720fu.mo10090wA()) && this.f10439AZxh.equals(abstractC3720fu.mo10086AZxh()) && this.f10442wA.equals(abstractC3720fu.mo10089mjFkc()) && this.f10440ZfxDd == abstractC3720fu.mo10087ZfxDd()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (true != this.f10440ZfxDd ? 1237 : 1231) ^ ((((((this.f10441mjFkc.hashCode() ^ 1000003) * 1000003) ^ this.f10439AZxh.hashCode()) * 1000003) ^ this.f10442wA.hashCode()) * 1000003);
    }

    @Override // p131o.AbstractC3720fu
    /* renamed from: mjFkc */
    public final AbstractC2919Ts mo10089mjFkc() {
        return this.f10442wA;
    }

    public final String toString() {
        AbstractC2919Ts abstractC2919Ts = this.f10442wA;
        C2994Uu c2994Uu = this.f10439AZxh;
        return "VkpResults{status=" + this.f10441mjFkc.toString() + ", textParcel=" + c2994Uu.toString() + ", lineBoxParcels=" + abstractC2919Ts.toString() + ", fromColdCall=" + this.f10440ZfxDd + "}";
    }

    @Override // p131o.AbstractC3720fu
    /* renamed from: wA */
    public final AbstractC2194Iu mo10090wA() {
        return this.f10441mjFkc;
    }
}
