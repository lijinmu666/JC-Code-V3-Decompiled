package p131o;

import android.database.Cursor;
import java.util.List;
import p131o.C3540d6;

/* renamed from: o.P5 */
/* loaded from: classes.dex */
public final /* synthetic */ class C2611P5 implements C3540d6.AZxh {

    /* renamed from: AZxh */
    public final List f10032AZxh;

    /* renamed from: mjFkc */
    public final C3540d6 f10033mjFkc;

    /* renamed from: wA */
    public final AbstractC3140X8 f10034wA;

    public C2611P5(C3540d6 c3540d6, List list, AbstractC3140X8 abstractC3140X8) {
        this.f10033mjFkc = c3540d6;
        this.f10032AZxh = list;
        this.f10034wA = abstractC3140X8;
    }

    /* renamed from: mjFkc */
    public static C3540d6.AZxh m9946mjFkc(C3540d6 c3540d6, List list, AbstractC3140X8 abstractC3140X8) {
        return new C2611P5(c3540d6, list, abstractC3140X8);
    }

    @Override // p131o.C3540d6.AZxh
    /* renamed from: apply */
    public Object mo9356apply(Object obj) {
        return C3540d6.m11667mByQ(this.f10033mjFkc, this.f10032AZxh, this.f10034wA, (Cursor) obj);
    }
}
