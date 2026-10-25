package p131o;

import p131o.C3389aqHPIZ;

/* renamed from: o.JYn */
/* loaded from: classes.dex */
public final class C2245JYn {

    /* renamed from: AZxh */
    public final C3389aqHPIZ f8992AZxh;

    /* renamed from: ZfxDd */
    public final String f8993ZfxDd;

    /* renamed from: mjFkc */
    public final int f8994mjFkc;

    /* renamed from: wA */
    public final C3389aqHPIZ.ZfxDd f8995wA;

    public C2245JYn(C3389aqHPIZ c3389aqHPIZ, C3389aqHPIZ.ZfxDd zfxDd, String str) {
        this.f8992AZxh = c3389aqHPIZ;
        this.f8995wA = zfxDd;
        this.f8993ZfxDd = str;
        this.f8994mjFkc = AbstractC2931U2.m10464AZxh(c3389aqHPIZ, zfxDd, str);
    }

    /* renamed from: mjFkc */
    public static C2245JYn m8985mjFkc(C3389aqHPIZ c3389aqHPIZ, C3389aqHPIZ.ZfxDd zfxDd, String str) {
        return new C2245JYn(c3389aqHPIZ, zfxDd, str);
    }

    /* renamed from: AZxh */
    public final String m8986AZxh() {
        return this.f8992AZxh.m11411AZxh();
    }

    /* renamed from: equals */
    public final boolean m8987equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2245JYn)) {
            return false;
        }
        C2245JYn c2245JYn = (C2245JYn) obj;
        return AbstractC2931U2.m10465mjFkc(this.f8992AZxh, c2245JYn.f8992AZxh) && AbstractC2931U2.m10465mjFkc(this.f8995wA, c2245JYn.f8995wA) && AbstractC2931U2.m10465mjFkc(this.f8993ZfxDd, c2245JYn.f8993ZfxDd);
    }

    public final int hashCode() {
        return this.f8994mjFkc;
    }
}
