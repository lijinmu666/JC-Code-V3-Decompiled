package p131o;

/* renamed from: o.JV */
/* loaded from: classes.dex */
public final class C2242JV extends AbstractC2637PV {

    /* renamed from: AZxh */
    public boolean f8981AZxh;

    /* renamed from: ZfxDd */
    public byte f8982ZfxDd;

    /* renamed from: mjFkc */
    public String f8983mjFkc;

    /* renamed from: wA */
    public int f8984wA;

    @Override // p131o.AbstractC2637PV
    /* renamed from: AZxh */
    public final AbstractC2637PV mo8978AZxh(int i) {
        this.f8984wA = 1;
        this.f8982ZfxDd = (byte) (this.f8982ZfxDd | 2);
        return this;
    }

    /* renamed from: ZfxDd */
    public final AbstractC2637PV m8979ZfxDd(String str) {
        if (str == null) {
            throw new NullPointerException("Null libraryName");
        }
        this.f8983mjFkc = str;
        return this;
    }

    @Override // p131o.AbstractC2637PV
    /* renamed from: mjFkc */
    public final AbstractC2637PV mo8980mjFkc(boolean z) {
        this.f8981AZxh = true;
        this.f8982ZfxDd = (byte) (1 | this.f8982ZfxDd);
        return this;
    }

    @Override // p131o.AbstractC2637PV
    /* renamed from: wA */
    public final AbstractC2700QV mo8981wA() {
        String str;
        if (this.f8982ZfxDd == 3 && (str = this.f8983mjFkc) != null) {
            return new C2375LV(str, this.f8981AZxh, this.f8984wA, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f8983mjFkc == null) {
            sb.append(" libraryName");
        }
        if ((this.f8982ZfxDd & 1) == 0) {
            sb.append(" enableFirelog");
        }
        if ((this.f8982ZfxDd & 2) == 0) {
            sb.append(" firelogEventType");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
