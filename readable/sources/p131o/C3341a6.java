package p131o;

import android.database.sqlite.SQLiteDatabase;
import p131o.C3540d6;

/* renamed from: o.a6 */
/* loaded from: classes.dex */
public final /* synthetic */ class C3341a6 implements C3540d6.AZxh {

    /* renamed from: mjFkc */
    public final String f12708mjFkc;

    public C3341a6(String str) {
        this.f12708mjFkc = str;
    }

    /* renamed from: mjFkc */
    public static C3540d6.AZxh m11275mjFkc(String str) {
        return new C3341a6(str);
    }

    @Override // p131o.C3540d6.AZxh
    /* renamed from: apply */
    public Object mo9356apply(Object obj) {
        return C3540d6.m11673xrEuO(this.f12708mjFkc, (SQLiteDatabase) obj);
    }
}
