package p131o;

import android.content.Context;

/* renamed from: o.sRqPfw */
/* loaded from: classes.dex */
public final class C4549sRqPfw extends AbstractC3128WxE {

    /* renamed from: AZxh */
    public final InterfaceC3350aDq f16509AZxh;

    /* renamed from: ZfxDd */
    public final String f16510ZfxDd;

    /* renamed from: mjFkc */
    public final Context f16511mjFkc;

    /* renamed from: wA */
    public final InterfaceC3350aDq f16512wA;

    public C4549sRqPfw(Context context, InterfaceC3350aDq interfaceC3350aDq, InterfaceC3350aDq interfaceC3350aDq2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.f16511mjFkc = context;
        if (interfaceC3350aDq == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.f16509AZxh = interfaceC3350aDq;
        if (interfaceC3350aDq2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.f16512wA = interfaceC3350aDq2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f16510ZfxDd = str;
    }

    @Override // p131o.AbstractC3128WxE
    /* renamed from: AZxh */
    public Context mo10849AZxh() {
        return this.f16511mjFkc;
    }

    @Override // p131o.AbstractC3128WxE
    /* renamed from: KLFTb */
    public InterfaceC3350aDq mo10850KLFTb() {
        return this.f16509AZxh;
    }

    @Override // p131o.AbstractC3128WxE
    /* renamed from: ZfxDd */
    public InterfaceC3350aDq mo10851ZfxDd() {
        return this.f16512wA;
    }

    /* renamed from: equals */
    public boolean m13500equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC3128WxE)) {
            return false;
        }
        AbstractC3128WxE abstractC3128WxE = (AbstractC3128WxE) obj;
        return this.f16511mjFkc.equals(abstractC3128WxE.mo10849AZxh()) && this.f16509AZxh.equals(abstractC3128WxE.mo10850KLFTb()) && this.f16512wA.equals(abstractC3128WxE.mo10851ZfxDd()) && this.f16510ZfxDd.equals(abstractC3128WxE.mo10852wA());
    }

    public int hashCode() {
        return this.f16510ZfxDd.hashCode() ^ ((((((this.f16511mjFkc.hashCode() ^ 1000003) * 1000003) ^ this.f16509AZxh.hashCode()) * 1000003) ^ this.f16512wA.hashCode()) * 1000003);
    }

    public String toString() {
        return "CreationContext{applicationContext=" + this.f16511mjFkc + ", wallClock=" + this.f16509AZxh + ", monotonicClock=" + this.f16512wA + ", backendName=" + this.f16510ZfxDd + "}";
    }

    @Override // p131o.AbstractC3128WxE
    /* renamed from: wA */
    public String mo10852wA() {
        return this.f16510ZfxDd;
    }
}
