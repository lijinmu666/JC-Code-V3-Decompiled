package p131o;

import p131o.AbstractC2038Ga;

/* renamed from: o.hm */
/* loaded from: classes.dex */
public final class C3841hm extends AbstractC2038Ga.mjFkc {

    /* renamed from: AZxh */
    public String f14050AZxh;

    /* renamed from: KLFTb */
    public byte f14051KLFTb;

    /* renamed from: ZfxDd */
    public boolean f14052ZfxDd;

    /* renamed from: mjFkc */
    public String f14053mjFkc;

    /* renamed from: wA */
    public String f14054wA;

    @Override // p131o.AbstractC2038Ga.mjFkc
    /* renamed from: AZxh */
    public final AbstractC2038Ga.mjFkc mo8433AZxh(boolean z) {
        this.f14052ZfxDd = z;
        this.f14051KLFTb = (byte) 1;
        return this;
    }

    /* renamed from: KLFTb */
    public final AbstractC2038Ga.mjFkc m12233KLFTb(String str) {
        if (str == null) {
            throw new NullPointerException("Null configLabel");
        }
        this.f14053mjFkc = str;
        return this;
    }

    @Override // p131o.AbstractC2038Ga.mjFkc
    /* renamed from: ZfxDd */
    public final AbstractC2038Ga.mjFkc mo8434ZfxDd(String str) {
        if (str == null) {
            throw new NullPointerException("Null modelDir");
        }
        this.f14050AZxh = str;
        return this;
    }

    @Override // p131o.AbstractC2038Ga.mjFkc
    /* renamed from: mjFkc */
    public final AbstractC2038Ga mo8435mjFkc() {
        String str;
        String str2;
        String str3;
        if (this.f14051KLFTb == 1 && (str = this.f14053mjFkc) != null && (str2 = this.f14050AZxh) != null && (str3 = this.f14054wA) != null) {
            return new C4437qo(str, str2, str3, this.f14052ZfxDd, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f14053mjFkc == null) {
            sb.append(" configLabel");
        }
        if (this.f14050AZxh == null) {
            sb.append(" modelDir");
        }
        if (this.f14054wA == null) {
            sb.append(" languageHint");
        }
        if (this.f14051KLFTb == 0) {
            sb.append(" enableLowLatencyInBackground");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // p131o.AbstractC2038Ga.mjFkc
    /* renamed from: wA */
    public final AbstractC2038Ga.mjFkc mo8436wA(String str) {
        if (str == null) {
            throw new NullPointerException("Null languageHint");
        }
        this.f14054wA = str;
        return this;
    }
}
