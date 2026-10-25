package p131o;

import org.conscrypt.BuildConfig;
import p131o.AbstractC1736C6;

/* renamed from: o.FbxKQm */
/* loaded from: classes.dex */
public final class C1970FbxKQm extends AbstractC1736C6 {

    /* renamed from: AZxh */
    public final String f8221AZxh;

    /* renamed from: KLFTb */
    public final C3569dXmy f8222KLFTb;

    /* renamed from: ZfxDd */
    public final InterfaceC2416M8 f8223ZfxDd;

    /* renamed from: mjFkc */
    public final AbstractC3140X8 f8224mjFkc;

    /* renamed from: wA */
    public final AbstractC4697uhQ f8225wA;

    /* renamed from: o.FbxKQm$AZxh */
    public static final class AZxh extends AbstractC1736C6.mjFkc {

        /* renamed from: AZxh */
        public String f8226AZxh;

        /* renamed from: KLFTb */
        public C3569dXmy f8227KLFTb;

        /* renamed from: ZfxDd */
        public InterfaceC2416M8 f8228ZfxDd;

        /* renamed from: mjFkc */
        public AbstractC3140X8 f8229mjFkc;

        /* renamed from: wA */
        public AbstractC4697uhQ f8230wA;

        @Override // p131o.AbstractC1736C6.mjFkc
        /* renamed from: AZxh */
        public AbstractC1736C6.mjFkc mo7758AZxh(C3569dXmy c3569dXmy) {
            if (c3569dXmy == null) {
                throw new NullPointerException("Null encoding");
            }
            this.f8227KLFTb = c3569dXmy;
            return this;
        }

        @Override // p131o.AbstractC1736C6.mjFkc
        /* renamed from: JHa */
        public AbstractC1736C6.mjFkc mo7759JHa(String str) {
            if (str == null) {
                throw new NullPointerException("Null transportName");
            }
            this.f8226AZxh = str;
            return this;
        }

        @Override // p131o.AbstractC1736C6.mjFkc
        /* renamed from: KLFTb */
        public AbstractC1736C6.mjFkc mo7760KLFTb(AbstractC3140X8 abstractC3140X8) {
            if (abstractC3140X8 == null) {
                throw new NullPointerException("Null transportContext");
            }
            this.f8229mjFkc = abstractC3140X8;
            return this;
        }

        @Override // p131o.AbstractC1736C6.mjFkc
        /* renamed from: ZfxDd */
        public AbstractC1736C6.mjFkc mo7761ZfxDd(InterfaceC2416M8 interfaceC2416M8) {
            if (interfaceC2416M8 == null) {
                throw new NullPointerException("Null transformer");
            }
            this.f8228ZfxDd = interfaceC2416M8;
            return this;
        }

        @Override // p131o.AbstractC1736C6.mjFkc
        /* renamed from: mjFkc */
        public AbstractC1736C6 mo7762mjFkc() {
            AbstractC3140X8 abstractC3140X8 = this.f8229mjFkc;
            String str = BuildConfig.f24315FLAVOR;
            if (abstractC3140X8 == null) {
                str = BuildConfig.f24315FLAVOR + " transportContext";
            }
            if (this.f8226AZxh == null) {
                str = str + " transportName";
            }
            if (this.f8230wA == null) {
                str = str + " event";
            }
            if (this.f8228ZfxDd == null) {
                str = str + " transformer";
            }
            if (this.f8227KLFTb == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new C1970FbxKQm(this.f8229mjFkc, this.f8226AZxh, this.f8230wA, this.f8228ZfxDd, this.f8227KLFTb);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // p131o.AbstractC1736C6.mjFkc
        /* renamed from: wA */
        public AbstractC1736C6.mjFkc mo7763wA(AbstractC4697uhQ abstractC4697uhQ) {
            if (abstractC4697uhQ == null) {
                throw new NullPointerException("Null event");
            }
            this.f8230wA = abstractC4697uhQ;
            return this;
        }
    }

    @Override // p131o.AbstractC1736C6
    /* renamed from: AZxh */
    public C3569dXmy mo7752AZxh() {
        return this.f8222KLFTb;
    }

    @Override // p131o.AbstractC1736C6
    /* renamed from: JHa */
    public AbstractC3140X8 mo7753JHa() {
        return this.f8224mjFkc;
    }

    @Override // p131o.AbstractC1736C6
    /* renamed from: KLFTb */
    public InterfaceC2416M8 mo7754KLFTb() {
        return this.f8223ZfxDd;
    }

    /* renamed from: equals */
    public boolean m8313equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1736C6)) {
            return false;
        }
        AbstractC1736C6 abstractC1736C6 = (AbstractC1736C6) obj;
        return this.f8224mjFkc.equals(abstractC1736C6.mo7753JHa()) && this.f8221AZxh.equals(abstractC1736C6.mo7757xJ()) && this.f8225wA.equals(abstractC1736C6.mo7756wA()) && this.f8223ZfxDd.equals(abstractC1736C6.mo7754KLFTb()) && this.f8222KLFTb.m11729equals(abstractC1736C6.mo7752AZxh());
    }

    public int hashCode() {
        return this.f8222KLFTb.hashCode() ^ ((((((((this.f8224mjFkc.hashCode() ^ 1000003) * 1000003) ^ this.f8221AZxh.hashCode()) * 1000003) ^ this.f8225wA.hashCode()) * 1000003) ^ this.f8223ZfxDd.hashCode()) * 1000003);
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f8224mjFkc + ", transportName=" + this.f8221AZxh + ", event=" + this.f8225wA + ", transformer=" + this.f8223ZfxDd + ", encoding=" + this.f8222KLFTb + "}";
    }

    @Override // p131o.AbstractC1736C6
    /* renamed from: wA */
    public AbstractC4697uhQ mo7756wA() {
        return this.f8225wA;
    }

    @Override // p131o.AbstractC1736C6
    /* renamed from: xJ */
    public String mo7757xJ() {
        return this.f8221AZxh;
    }

    public C1970FbxKQm(AbstractC3140X8 abstractC3140X8, String str, AbstractC4697uhQ abstractC4697uhQ, InterfaceC2416M8 interfaceC2416M8, C3569dXmy c3569dXmy) {
        this.f8224mjFkc = abstractC3140X8;
        this.f8221AZxh = str;
        this.f8225wA = abstractC4697uhQ;
        this.f8223ZfxDd = interfaceC2416M8;
        this.f8222KLFTb = c3569dXmy;
    }
}
