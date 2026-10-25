package p131o;

import java.util.Map;
import java.util.Set;

/* renamed from: o.tC */
/* loaded from: classes.dex */
public abstract class AbstractC4600tC implements InterfaceC1813DE {

    /* renamed from: AZxh */
    public transient Map f16670AZxh;

    /* renamed from: mjFkc */
    public transient Set f16671mjFkc;

    /* renamed from: JHa */
    public abstract Set mo12863JHa();

    /* renamed from: KLFTb */
    public abstract Map mo12864KLFTb();

    @Override // p131o.InterfaceC1813DE
    /* renamed from: ZfxDd */
    public final Set mo7990ZfxDd() {
        Set set = this.f16671mjFkc;
        if (set != null) {
            return set;
        }
        Set setMo12863JHa = mo12863JHa();
        this.f16671mjFkc = setMo12863JHa;
        return setMo12863JHa;
    }

    /* renamed from: equals */
    public final boolean m13610equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InterfaceC1813DE) {
            return mo7991mjFkc().equals(((InterfaceC1813DE) obj).mo7991mjFkc());
        }
        return false;
    }

    public final int hashCode() {
        return mo7991mjFkc().hashCode();
    }

    @Override // p131o.InterfaceC1813DE
    /* renamed from: mjFkc */
    public final Map mo7991mjFkc() {
        Map map = this.f16670AZxh;
        if (map != null) {
            return map;
        }
        Map mapMo12864KLFTb = mo12864KLFTb();
        this.f16670AZxh = mapMo12864KLFTb;
        return mapMo12864KLFTb;
    }

    public final String toString() {
        return mo7991mjFkc().toString();
    }
}
