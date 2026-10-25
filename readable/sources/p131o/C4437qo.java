package p131o;

/* renamed from: o.qo */
/* loaded from: classes.dex */
public final class C4437qo extends AbstractC2038Ga {

    /* renamed from: AZxh */
    public final String f16233AZxh;

    /* renamed from: ZfxDd */
    public final boolean f16234ZfxDd;

    /* renamed from: mjFkc */
    public final String f16235mjFkc;

    /* renamed from: wA */
    public final String f16236wA;

    public /* synthetic */ C4437qo(String str, String str2, String str3, boolean z, AbstractC4172mn abstractC4172mn) {
        this.f16235mjFkc = str;
        this.f16233AZxh = str2;
        this.f16236wA = str3;
        this.f16234ZfxDd = z;
    }

    @Override // p131o.AbstractC2038Ga
    /* renamed from: AZxh */
    public final String mo8429AZxh() {
        return this.f16235mjFkc;
    }

    @Override // p131o.AbstractC2038Ga
    /* renamed from: KLFTb */
    public final boolean mo8430KLFTb() {
        return this.f16234ZfxDd;
    }

    @Override // p131o.AbstractC2038Ga
    /* renamed from: ZfxDd */
    public final String mo8431ZfxDd() {
        return this.f16233AZxh;
    }

    /* renamed from: equals */
    public final boolean m13296equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2038Ga) {
            AbstractC2038Ga abstractC2038Ga = (AbstractC2038Ga) obj;
            if (this.f16235mjFkc.equals(abstractC2038Ga.mo8429AZxh()) && this.f16233AZxh.equals(abstractC2038Ga.mo8431ZfxDd()) && this.f16236wA.equals(abstractC2038Ga.mo8432wA()) && this.f16234ZfxDd == abstractC2038Ga.mo8430KLFTb()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (true != this.f16234ZfxDd ? 1237 : 1231) ^ ((((((this.f16235mjFkc.hashCode() ^ 1000003) * 1000003) ^ this.f16233AZxh.hashCode()) * 1000003) ^ this.f16236wA.hashCode()) * 1000003);
    }

    public final String toString() {
        return "VkpTextRecognizerOptions{configLabel=" + this.f16235mjFkc + ", modelDir=" + this.f16233AZxh + ", languageHint=" + this.f16236wA + ", enableLowLatencyInBackground=" + this.f16234ZfxDd + "}";
    }

    @Override // p131o.AbstractC2038Ga
    /* renamed from: wA */
    public final String mo8432wA() {
        return this.f16236wA;
    }
}
