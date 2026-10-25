package p131o;

import java.util.Arrays;
import org.conscrypt.BuildConfig;
import p131o.AbstractC3140X8;

/* renamed from: o.jtz */
/* loaded from: classes.dex */
public final class C3981jtz extends AbstractC3140X8 {

    /* renamed from: AZxh */
    public final byte[] f14384AZxh;

    /* renamed from: mjFkc */
    public final String f14385mjFkc;

    /* renamed from: wA */
    public final EnumC2347L3 f14386wA;

    /* renamed from: o.jtz$AZxh */
    public static final class AZxh extends AbstractC3140X8.mjFkc {

        /* renamed from: AZxh */
        public byte[] f14387AZxh;

        /* renamed from: mjFkc */
        public String f14388mjFkc;

        /* renamed from: wA */
        public EnumC2347L3 f14389wA;

        @Override // p131o.AbstractC3140X8.mjFkc
        /* renamed from: AZxh */
        public AbstractC3140X8.mjFkc mo10891AZxh(String str) {
            if (str == null) {
                throw new NullPointerException("Null backendName");
            }
            this.f14388mjFkc = str;
            return this;
        }

        @Override // p131o.AbstractC3140X8.mjFkc
        /* renamed from: ZfxDd */
        public AbstractC3140X8.mjFkc mo10892ZfxDd(EnumC2347L3 enumC2347L3) {
            if (enumC2347L3 == null) {
                throw new NullPointerException("Null priority");
            }
            this.f14389wA = enumC2347L3;
            return this;
        }

        @Override // p131o.AbstractC3140X8.mjFkc
        /* renamed from: mjFkc */
        public AbstractC3140X8 mo10893mjFkc() {
            String str = this.f14388mjFkc;
            String str2 = BuildConfig.f24315FLAVOR;
            if (str == null) {
                str2 = BuildConfig.f24315FLAVOR + " backendName";
            }
            if (this.f14389wA == null) {
                str2 = str2 + " priority";
            }
            if (str2.isEmpty()) {
                return new C3981jtz(this.f14388mjFkc, this.f14387AZxh, this.f14389wA);
            }
            throw new IllegalStateException("Missing required properties:" + str2);
        }

        @Override // p131o.AbstractC3140X8.mjFkc
        /* renamed from: wA */
        public AbstractC3140X8.mjFkc mo10894wA(byte[] bArr) {
            this.f14387AZxh = bArr;
            return this;
        }
    }

    @Override // p131o.AbstractC3140X8
    /* renamed from: AZxh */
    public String mo10887AZxh() {
        return this.f14385mjFkc;
    }

    @Override // p131o.AbstractC3140X8
    /* renamed from: ZfxDd */
    public EnumC2347L3 mo10889ZfxDd() {
        return this.f14386wA;
    }

    /* renamed from: equals */
    public boolean m12448equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC3140X8)) {
            return false;
        }
        AbstractC3140X8 abstractC3140X8 = (AbstractC3140X8) obj;
        if (this.f14385mjFkc.equals(abstractC3140X8.mo10887AZxh())) {
            if (Arrays.equals(this.f14384AZxh, abstractC3140X8 instanceof C3981jtz ? ((C3981jtz) abstractC3140X8).f14384AZxh : abstractC3140X8.mo10890wA()) && this.f14386wA.equals(abstractC3140X8.mo10889ZfxDd())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f14386wA.hashCode() ^ ((((this.f14385mjFkc.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f14384AZxh)) * 1000003);
    }

    @Override // p131o.AbstractC3140X8
    /* renamed from: wA */
    public byte[] mo10890wA() {
        return this.f14384AZxh;
    }

    public C3981jtz(String str, byte[] bArr, EnumC2347L3 enumC2347L3) {
        this.f14385mjFkc = str;
        this.f14384AZxh = bArr;
        this.f14386wA = enumC2347L3;
    }
}
