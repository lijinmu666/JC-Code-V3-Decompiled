package p131o;

import android.database.sqlite.SQLiteDatabase;
import p131o.C3540d6;

/* renamed from: o.O5 */
/* loaded from: classes.dex */
public final /* synthetic */ class C2546O5 implements C3540d6.AZxh {

    /* renamed from: mjFkc */
    public final long f9916mjFkc;

    public C2546O5(long j) {
        this.f9916mjFkc = j;
    }

    /* renamed from: mjFkc */
    public static C3540d6.AZxh m9849mjFkc(long j) {
        return new C2546O5(j);
    }

    @Override // p131o.C3540d6.AZxh
    /* renamed from: apply */
    public Object mo9356apply(Object obj) {
        return Integer.valueOf(((SQLiteDatabase) obj).delete("events", "timestamp_ms < ?", new String[]{String.valueOf(this.f9916mjFkc)}));
    }
}
