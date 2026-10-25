package p131o;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import p131o.C4991z6;

/* renamed from: o.x6 */
/* loaded from: classes.dex */
public final /* synthetic */ class C4859x6 implements C4991z6.mjFkc {

    /* renamed from: mjFkc */
    public static final C4859x6 f17324mjFkc = new C4859x6();

    /* renamed from: AZxh */
    public static C4991z6.mjFkc m13899AZxh() {
        return f17324mjFkc;
    }

    @Override // p131o.C4991z6.mjFkc
    /* renamed from: mjFkc */
    public void mo13747mjFkc(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
    }
}
