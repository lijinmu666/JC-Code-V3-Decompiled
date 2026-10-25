package p131o;

import android.database.sqlite.SQLiteDatabase;
import p131o.C3540d6;

/* renamed from: o.L5 */
/* loaded from: classes.dex */
public final /* synthetic */ class C2349L5 implements C3540d6.AZxh {

    /* renamed from: AZxh */
    public final AbstractC3140X8 f9389AZxh;

    /* renamed from: mjFkc */
    public final long f9390mjFkc;

    public C2349L5(long j, AbstractC3140X8 abstractC3140X8) {
        this.f9390mjFkc = j;
        this.f9389AZxh = abstractC3140X8;
    }

    /* renamed from: mjFkc */
    public static C3540d6.AZxh m9355mjFkc(long j, AbstractC3140X8 abstractC3140X8) {
        return new C2349L5(j, abstractC3140X8);
    }

    @Override // p131o.C3540d6.AZxh
    /* renamed from: apply */
    public Object mo9356apply(Object obj) {
        return C3540d6.m11658KLMXS(this.f9390mjFkc, this.f9389AZxh, (SQLiteDatabase) obj);
    }
}
