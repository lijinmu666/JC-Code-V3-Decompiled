package p131o;

/* renamed from: o.TP */
/* loaded from: classes.dex */
public final class C2893TP extends AbstractC4213nQ {

    /* renamed from: AZxh */
    public boolean f10696AZxh;

    /* renamed from: ZfxDd */
    public byte f10697ZfxDd;

    /* renamed from: mjFkc */
    public String f10698mjFkc;

    /* renamed from: wA */
    public int f10699wA;

    @Override // p131o.AbstractC4213nQ
    /* renamed from: AZxh */
    public final AbstractC4213nQ mo10413AZxh(int i) {
        this.f10699wA = 1;
        this.f10697ZfxDd = (byte) (this.f10697ZfxDd | 2);
        return this;
    }

    /* renamed from: ZfxDd */
    public final AbstractC4213nQ m10414ZfxDd(String str) {
        this.f10698mjFkc = "vision-common";
        return this;
    }

    @Override // p131o.AbstractC4213nQ
    /* renamed from: mjFkc */
    public final AbstractC4213nQ mo10415mjFkc(boolean z) {
        this.f10696AZxh = true;
        this.f10697ZfxDd = (byte) (1 | this.f10697ZfxDd);
        return this;
    }

    @Override // p131o.AbstractC4213nQ
    /* renamed from: wA */
    public final AbstractC4348pQ mo10416wA() {
        String str;
        if (this.f10697ZfxDd == 3 && (str = this.f10698mjFkc) != null) {
            return new C3822hQ(str, this.f10696AZxh, this.f10699wA, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f10698mjFkc == null) {
            sb.append(" libraryName");
        }
        if ((this.f10697ZfxDd & 1) == 0) {
            sb.append(" enableFirelog");
        }
        if ((this.f10697ZfxDd & 2) == 0) {
            sb.append(" firelogEventType");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
