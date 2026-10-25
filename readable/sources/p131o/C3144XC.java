package p131o;

import java.util.Map;

/* renamed from: o.XC */
/* loaded from: classes.dex */
public final class C3144XC extends AbstractC4397qC {

    /* renamed from: AZxh */
    public int f11557AZxh;

    /* renamed from: mjFkc */
    public final Object f11558mjFkc;

    /* renamed from: wA */
    public final /* synthetic */ C4333pD f11559wA;

    public C3144XC(C4333pD c4333pD, int i) {
        this.f11559wA = c4333pD;
        this.f11558mjFkc = C4333pD.m13095Dt(c4333pD, i);
        this.f11557AZxh = i;
    }

    @Override // p131o.AbstractC4397qC, java.util.Map.Entry
    public final Object getKey() {
        return this.f11558mjFkc;
    }

    @Override // p131o.AbstractC4397qC, java.util.Map.Entry
    public final Object getValue() {
        Map mapM13121rkYL = this.f11559wA.m13121rkYL();
        if (mapM13121rkYL != null) {
            return mapM13121rkYL.get(this.f11558mjFkc);
        }
        m10913mjFkc();
        int i = this.f11557AZxh;
        if (i == -1) {
            return null;
        }
        return C4333pD.m13100MiMN(this.f11559wA, i);
    }

    /* renamed from: mjFkc */
    public final void m10913mjFkc() {
        int i = this.f11557AZxh;
        if (i == -1 || i >= this.f11559wA.size() || !AbstractC2833SW.m10153mjFkc(this.f11558mjFkc, C4333pD.m13095Dt(this.f11559wA, this.f11557AZxh))) {
            this.f11557AZxh = this.f11559wA.m13122vI(this.f11558mjFkc);
        }
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        Map mapM13121rkYL = this.f11559wA.m13121rkYL();
        if (mapM13121rkYL != null) {
            return mapM13121rkYL.put(this.f11558mjFkc, obj);
        }
        m10913mjFkc();
        int i = this.f11557AZxh;
        if (i == -1) {
            this.f11559wA.put(this.f11558mjFkc, obj);
            return null;
        }
        C4333pD c4333pD = this.f11559wA;
        Object objM13100MiMN = C4333pD.m13100MiMN(c4333pD, i);
        C4333pD.m13105fehf(c4333pD, this.f11557AZxh, obj);
        return objM13100MiMN;
    }
}
