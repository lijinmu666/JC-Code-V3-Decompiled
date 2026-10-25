package p131o;

import android.database.sqlite.SQLiteDatabase;
import p131o.C3540d6;

/* renamed from: o.c6 */
/* loaded from: classes.dex */
public final /* synthetic */ class C3475c6 implements C3540d6.AZxh {

    /* renamed from: AZxh */
    public final AbstractC3140X8 f13205AZxh;

    /* renamed from: mjFkc */
    public final C3540d6 f13206mjFkc;

    public C3475c6(C3540d6 c3540d6, AbstractC3140X8 abstractC3140X8) {
        this.f13206mjFkc = c3540d6;
        this.f13205AZxh = abstractC3140X8;
    }

    /* renamed from: mjFkc */
    public static C3540d6.AZxh m11602mjFkc(C3540d6 c3540d6, AbstractC3140X8 abstractC3140X8) {
        return new C3475c6(c3540d6, abstractC3140X8);
    }

    @Override // p131o.C3540d6.AZxh
    /* renamed from: apply */
    public Object mo9356apply(Object obj) {
        return C3540d6.m11662VocHEe(this.f13206mjFkc, this.f13205AZxh, (SQLiteDatabase) obj);
    }
}
