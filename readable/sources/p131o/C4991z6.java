package p131o;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Arrays;
import java.util.List;

/* renamed from: o.z6 */
/* loaded from: classes.dex */
public final class C4991z6 extends SQLiteOpenHelper {

    /* renamed from: JHa */
    public static final mjFkc f17628JHa;

    /* renamed from: KLFTb */
    public static final mjFkc f17629KLFTb;

    /* renamed from: ZfxDd */
    public static final mjFkc f17630ZfxDd;

    /* renamed from: lgHUyS */
    public static final List f17631lgHUyS;

    /* renamed from: wA */
    public static int f17632wA = 4;

    /* renamed from: xJ */
    public static final mjFkc f17633xJ;

    /* renamed from: AZxh */
    public boolean f17634AZxh;

    /* renamed from: mjFkc */
    public final int f17635mjFkc;

    /* renamed from: o.z6$mjFkc */
    public interface mjFkc {
        /* renamed from: mjFkc */
        void mo13747mjFkc(SQLiteDatabase sQLiteDatabase);
    }

    static {
        mjFkc mjfkcM13746AZxh = C4725v6.m13746AZxh();
        f17630ZfxDd = mjfkcM13746AZxh;
        mjFkc mjfkcM13818AZxh = C4792w6.m13818AZxh();
        f17629KLFTb = mjfkcM13818AZxh;
        mjFkc mjfkcM13899AZxh = C4859x6.m13899AZxh();
        f17628JHa = mjfkcM13899AZxh;
        mjFkc mjfkcM13994AZxh = C4927y6.m13994AZxh();
        f17633xJ = mjfkcM13994AZxh;
        f17631lgHUyS = Arrays.asList(mjfkcM13746AZxh, mjfkcM13818AZxh, mjfkcM13899AZxh, mjfkcM13994AZxh);
    }

    public C4991z6(Context context, String str, int i) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i);
        this.f17634AZxh = false;
        this.f17635mjFkc = i;
    }

    /* renamed from: KLFTb */
    public static /* synthetic */ void m14087KLFTb(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    /* renamed from: qdMbNW */
    public static /* synthetic */ void m14089qdMbNW(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }

    /* renamed from: xJ */
    public static /* synthetic */ void m14090xJ(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    /* renamed from: MiMN */
    public final void m14091MiMN(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        List list = f17631lgHUyS;
        if (i2 <= list.size()) {
            while (i < i2) {
                ((mjFkc) f17631lgHUyS.get(i)).mo13747mjFkc(sQLiteDatabase);
                i++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i + " to " + i2 + " was requested, but cannot be performed. Only " + list.size() + " migrations are provided");
    }

    /* renamed from: VA */
    public final void m14092VA(SQLiteDatabase sQLiteDatabase, int i) {
        m14093ZfxDd(sQLiteDatabase);
        m14091MiMN(sQLiteDatabase, 0, i);
    }

    /* renamed from: ZfxDd */
    public final void m14093ZfxDd(SQLiteDatabase sQLiteDatabase) {
        if (this.f17634AZxh) {
            return;
        }
        onConfigure(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.f17634AZxh = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        m14092VA(sQLiteDatabase, this.f17635mjFkc);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        m14092VA(sQLiteDatabase, i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        m14093ZfxDd(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        m14093ZfxDd(sQLiteDatabase);
        m14091MiMN(sQLiteDatabase, i, i2);
    }
}
