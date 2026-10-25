package p131o;

/* renamed from: o.fU */
/* loaded from: classes.dex */
public final class C3695fU extends AbstractC4952yU {

    /* renamed from: AZxh */
    public boolean f13585AZxh;

    /* renamed from: ZfxDd */
    public byte f13586ZfxDd;

    /* renamed from: mjFkc */
    public String f13587mjFkc;

    /* renamed from: wA */
    public int f13588wA;

    @Override // p131o.AbstractC4952yU
    /* renamed from: AZxh */
    public final AbstractC4952yU mo11932AZxh(int i) {
        this.f13588wA = 1;
        this.f13586ZfxDd = (byte) (this.f13586ZfxDd | 2);
        return this;
    }

    /* renamed from: ZfxDd */
    public final AbstractC4952yU m11933ZfxDd(String str) {
        this.f13587mjFkc = "common";
        return this;
    }

    @Override // p131o.AbstractC4952yU
    /* renamed from: mjFkc */
    public final AbstractC4952yU mo11934mjFkc(boolean z) {
        this.f13585AZxh = true;
        this.f13586ZfxDd = (byte) (1 | this.f13586ZfxDd);
        return this;
    }

    @Override // p131o.AbstractC4952yU
    /* renamed from: wA */
    public final AbstractC1630AU mo11935wA() {
        String str;
        if (this.f13586ZfxDd == 3 && (str = this.f13587mjFkc) != null) {
            return new C3954jU(str, this.f13585AZxh, this.f13588wA, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f13587mjFkc == null) {
            sb.append(" libraryName");
        }
        if ((this.f13586ZfxDd & 1) == 0) {
            sb.append(" enableFirelog");
        }
        if ((this.f13586ZfxDd & 2) == 0) {
            sb.append(" firelogEventType");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
