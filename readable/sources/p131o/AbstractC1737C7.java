package p131o;

import p131o.C3389aqHPIZ;

/* renamed from: o.C7 */
/* loaded from: classes.dex */
public abstract class AbstractC1737C7 {

    /* renamed from: AZxh */
    public final boolean f7563AZxh;

    /* renamed from: mjFkc */
    public final C2987UokA[] f7564mjFkc;

    /* renamed from: wA */
    public final int f7565wA;

    /* renamed from: o.C7$mjFkc */
    public static class mjFkc {

        /* renamed from: AZxh */
        public boolean f7566AZxh = true;

        /* renamed from: ZfxDd */
        public int f7567ZfxDd = 0;

        /* renamed from: mjFkc */
        public InterfaceC3863i5 f7568mjFkc;

        /* renamed from: wA */
        public C2987UokA[] f7569wA;

        public /* synthetic */ mjFkc(AbstractC2175Ic abstractC2175Ic) {
        }

        /* renamed from: AZxh */
        public mjFkc m7770AZxh(InterfaceC3863i5 interfaceC3863i5) {
            this.f7568mjFkc = interfaceC3863i5;
            return this;
        }

        /* renamed from: KLFTb */
        public mjFkc m7771KLFTb(int i) {
            this.f7567ZfxDd = i;
            return this;
        }

        /* renamed from: ZfxDd */
        public mjFkc m7772ZfxDd(C2987UokA... c2987UokAArr) {
            this.f7569wA = c2987UokAArr;
            return this;
        }

        /* renamed from: mjFkc */
        public AbstractC1737C7 m7773mjFkc() {
            AbstractC2138I3.m8639AZxh(this.f7568mjFkc != null, "execute parameter required");
            return new C2109Hc(this, this.f7569wA, this.f7566AZxh, this.f7567ZfxDd);
        }

        /* renamed from: wA */
        public mjFkc m7774wA(boolean z) {
            this.f7566AZxh = z;
            return this;
        }
    }

    public AbstractC1737C7(C2987UokA[] c2987UokAArr, boolean z, int i) {
        this.f7564mjFkc = c2987UokAArr;
        boolean z2 = false;
        if (c2987UokAArr != null && z) {
            z2 = true;
        }
        this.f7563AZxh = z2;
        this.f7565wA = i;
    }

    /* renamed from: mjFkc */
    public static mjFkc m7764mjFkc() {
        return new mjFkc(null);
    }

    /* renamed from: AZxh */
    public abstract void mo7765AZxh(C3389aqHPIZ.AZxh aZxh, C1806D7 c1806d7);

    /* renamed from: KLFTb */
    public final C2987UokA[] m7766KLFTb() {
        return this.f7564mjFkc;
    }

    /* renamed from: ZfxDd */
    public final int m7767ZfxDd() {
        return this.f7565wA;
    }

    /* renamed from: wA */
    public boolean m7768wA() {
        return this.f7563AZxh;
    }
}
