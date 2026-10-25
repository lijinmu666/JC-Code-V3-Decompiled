package p131o;

import p131o.C3829ha;

/* renamed from: o.e1 */
/* loaded from: classes.dex */
public class C3599e1 extends AbstractC3535d1 {

    /* renamed from: AZxh */
    public final mjFkc f13425AZxh;

    /* renamed from: mjFkc */
    public final InterfaceC3068W0 f13426mjFkc;

    /* renamed from: o.e1$mjFkc */
    public static class mjFkc extends AbstractC3764ga {

        /* renamed from: JHa */
        public static final C3829ha.mjFkc f13427JHa = new C6364mjFkc();

        /* renamed from: ZfxDd */
        public C3605e7 f13429ZfxDd = new C3605e7();

        /* renamed from: KLFTb */
        public boolean f13428KLFTb = false;

        /* renamed from: o.e1$mjFkc$mjFkc, reason: collision with other inner class name */
        public static class C6364mjFkc implements C3829ha.mjFkc {
            @Override // p131o.C3829ha.mjFkc
            /* renamed from: mjFkc */
            public AbstractC3764ga mo11588mjFkc(Class cls) {
                return new mjFkc();
            }
        }

        /* renamed from: wA */
        public static mjFkc m11790wA(C3893ia c3893ia) {
            return (mjFkc) new C3829ha(c3893ia, f13427JHa).m12227mjFkc(mjFkc.class);
        }

        @Override // p131o.AbstractC3764ga
        /* renamed from: AZxh */
        public void mo11578AZxh() {
            super.mo11578AZxh();
            if (this.f13429ZfxDd.m11810VA() <= 0) {
                this.f13429ZfxDd.m11804AZxh();
            } else {
                AbstractC4793w7.m13819mjFkc(this.f13429ZfxDd.m11809MiMN(0));
                throw null;
            }
        }

        /* renamed from: ZfxDd */
        public void m11791ZfxDd() {
            if (this.f13429ZfxDd.m11810VA() <= 0) {
                return;
            }
            AbstractC4793w7.m13819mjFkc(this.f13429ZfxDd.m11809MiMN(0));
            throw null;
        }
    }

    public C3599e1(InterfaceC3068W0 interfaceC3068W0, C3893ia c3893ia) {
        this.f13426mjFkc = interfaceC3068W0;
        this.f13425AZxh = mjFkc.m11790wA(c3893ia);
    }

    @Override // p131o.AbstractC3535d1
    /* renamed from: AZxh */
    public void mo11640AZxh() {
        this.f13425AZxh.m11791ZfxDd();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        AbstractC2764RURGdp.m10067mjFkc(this.f13426mjFkc, sb);
        sb.append("}}");
        return sb.toString();
    }
}
