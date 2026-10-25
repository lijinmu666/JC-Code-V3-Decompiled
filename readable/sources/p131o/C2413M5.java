package p131o;

import android.database.sqlite.SQLiteDatabase;
import p131o.C3540d6;

/* renamed from: o.M5 */
/* loaded from: classes.dex */
public final /* synthetic */ class C2413M5 implements C3540d6.AZxh {

    /* renamed from: AZxh */
    public final AbstractC3140X8 f9552AZxh;

    /* renamed from: mjFkc */
    public final C3540d6 f9553mjFkc;

    public C2413M5(C3540d6 c3540d6, AbstractC3140X8 abstractC3140X8) {
        this.f9553mjFkc = c3540d6;
        this.f9552AZxh = abstractC3140X8;
    }

    /* renamed from: mjFkc */
    public static C3540d6.AZxh m9483mjFkc(C3540d6 c3540d6, AbstractC3140X8 abstractC3140X8) {
        return new C2413M5(c3540d6, abstractC3140X8);
    }

    @Override // p131o.C3540d6.AZxh
    /* renamed from: apply */
    public Object mo9356apply(Object obj) {
        return C3540d6.m11672wJVbdd(this.f9553mjFkc, this.f9552AZxh, (SQLiteDatabase) obj);
    }
}
