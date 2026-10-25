package p131o;

import android.database.Cursor;
import p131o.C3540d6;

/* renamed from: o.W5 */
/* loaded from: classes.dex */
public final /* synthetic */ class C3073W5 implements C3540d6.AZxh {

    /* renamed from: mjFkc */
    public static final C3073W5 f11412mjFkc = new C3073W5();

    /* renamed from: mjFkc */
    public static C3540d6.AZxh m10806mjFkc() {
        return f11412mjFkc;
    }

    @Override // p131o.C3540d6.AZxh
    /* renamed from: apply */
    public Object mo9356apply(Object obj) {
        return Boolean.valueOf(((Cursor) obj).moveToNext());
    }
}
