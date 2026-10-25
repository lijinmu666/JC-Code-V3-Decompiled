package p131o;

import android.database.sqlite.SQLiteDatabase;
import p131o.C3540d6;

/* renamed from: o.Y5 */
/* loaded from: classes.dex */
public final /* synthetic */ class C3207Y5 implements C3540d6.AZxh {

    /* renamed from: AZxh */
    public final AbstractC3140X8 f11800AZxh;

    /* renamed from: mjFkc */
    public final C3540d6 f11801mjFkc;

    /* renamed from: wA */
    public final AbstractC2097HPA f11802wA;

    public C3207Y5(C3540d6 c3540d6, AbstractC3140X8 abstractC3140X8, AbstractC2097HPA abstractC2097HPA) {
        this.f11801mjFkc = c3540d6;
        this.f11800AZxh = abstractC3140X8;
        this.f11802wA = abstractC2097HPA;
    }

    /* renamed from: mjFkc */
    public static C3540d6.AZxh m11046mjFkc(C3540d6 c3540d6, AbstractC3140X8 abstractC3140X8, AbstractC2097HPA abstractC2097HPA) {
        return new C3207Y5(c3540d6, abstractC3140X8, abstractC2097HPA);
    }

    @Override // p131o.C3540d6.AZxh
    /* renamed from: apply */
    public Object mo9356apply(Object obj) {
        return C3540d6.m11659Ne(this.f11801mjFkc, this.f11800AZxh, this.f11802wA, (SQLiteDatabase) obj);
    }
}
