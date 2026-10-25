package p131o;

import java.util.Arrays;
import org.conscrypt.BuildConfig;
import p131o.AbstractC3551dGDT;

/* renamed from: o.tISON */
/* loaded from: classes.dex */
public final class C4607tISON extends AbstractC3551dGDT {

    /* renamed from: AZxh */
    public final byte[] f16687AZxh;

    /* renamed from: mjFkc */
    public final Iterable f16688mjFkc;

    /* renamed from: o.tISON$AZxh */
    public static final class AZxh extends AbstractC3551dGDT.mjFkc {

        /* renamed from: AZxh */
        public byte[] f16689AZxh;

        /* renamed from: mjFkc */
        public Iterable f16690mjFkc;

        @Override // p131o.AbstractC3551dGDT.mjFkc
        /* renamed from: AZxh */
        public AbstractC3551dGDT.mjFkc mo11723AZxh(Iterable iterable) {
            if (iterable == null) {
                throw new NullPointerException("Null events");
            }
            this.f16690mjFkc = iterable;
            return this;
        }

        @Override // p131o.AbstractC3551dGDT.mjFkc
        /* renamed from: mjFkc */
        public AbstractC3551dGDT mo11724mjFkc() {
            Iterable iterable = this.f16690mjFkc;
            String str = BuildConfig.f24315FLAVOR;
            if (iterable == null) {
                str = BuildConfig.f24315FLAVOR + " events";
            }
            if (str.isEmpty()) {
                return new C4607tISON(this.f16690mjFkc, this.f16689AZxh);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // p131o.AbstractC3551dGDT.mjFkc
        /* renamed from: wA */
        public AbstractC3551dGDT.mjFkc mo11725wA(byte[] bArr) {
            this.f16689AZxh = bArr;
            return this;
        }
    }

    @Override // p131o.AbstractC3551dGDT
    /* renamed from: AZxh */
    public Iterable mo11721AZxh() {
        return this.f16688mjFkc;
    }

    /* renamed from: equals */
    public boolean m13621equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC3551dGDT)) {
            return false;
        }
        AbstractC3551dGDT abstractC3551dGDT = (AbstractC3551dGDT) obj;
        if (this.f16688mjFkc.equals(abstractC3551dGDT.mo11721AZxh())) {
            if (Arrays.equals(this.f16687AZxh, abstractC3551dGDT instanceof C4607tISON ? ((C4607tISON) abstractC3551dGDT).f16687AZxh : abstractC3551dGDT.mo11722wA())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f16687AZxh) ^ ((this.f16688mjFkc.hashCode() ^ 1000003) * 1000003);
    }

    public String toString() {
        return "BackendRequest{events=" + this.f16688mjFkc + ", extras=" + Arrays.toString(this.f16687AZxh) + "}";
    }

    @Override // p131o.AbstractC3551dGDT
    /* renamed from: wA */
    public byte[] mo11722wA() {
        return this.f16687AZxh;
    }

    public C4607tISON(Iterable iterable, byte[] bArr) {
        this.f16688mjFkc = iterable;
        this.f16687AZxh = bArr;
    }
}
