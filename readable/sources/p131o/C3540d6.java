package p131o;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import p131o.AbstractC2097HPA;
import p131o.InterfaceC4992z7;

/* renamed from: o.d6 */
/* loaded from: classes.dex */
public class C3540d6 implements InterfaceC4829wfQA, InterfaceC4992z7 {

    /* renamed from: KLFTb */
    public static final C3569dXmy f13302KLFTb = C3569dXmy.m11728AZxh("proto");

    /* renamed from: AZxh */
    public final InterfaceC3350aDq f13303AZxh;

    /* renamed from: ZfxDd */
    public final AbstractC3264YxdwU f13304ZfxDd;

    /* renamed from: mjFkc */
    public final C4991z6 f13305mjFkc;

    /* renamed from: wA */
    public final InterfaceC3350aDq f13306wA;

    /* renamed from: o.d6$AZxh */
    public interface AZxh {
        /* renamed from: apply */
        Object mo9356apply(Object obj);
    }

    /* renamed from: o.d6$ZfxDd */
    public interface ZfxDd {
        /* renamed from: mjFkc */
        Object mo10133mjFkc();
    }

    /* renamed from: o.d6$wA */
    public static class wA {

        /* renamed from: AZxh */
        public final String f13307AZxh;

        /* renamed from: mjFkc */
        public final String f13308mjFkc;

        public wA(String str, String str2) {
            this.f13308mjFkc = str;
            this.f13307AZxh = str2;
        }
    }

    public C3540d6(InterfaceC3350aDq interfaceC3350aDq, InterfaceC3350aDq interfaceC3350aDq2, AbstractC3264YxdwU abstractC3264YxdwU, C4991z6 c4991z6) {
        this.f13305mjFkc = c4991z6;
        this.f13303AZxh = interfaceC3350aDq;
        this.f13306wA = interfaceC3350aDq2;
        this.f13304ZfxDd = abstractC3264YxdwU;
    }

    /* renamed from: BAnRFn */
    public static /* synthetic */ List m11654BAnRFn(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(AbstractC3140X8.m10886mjFkc().mo10891AZxh(cursor.getString(1)).mo10892ZfxDd(AbstractC2480N3.m9583AZxh(cursor.getInt(2))).mo10894wA(m11669rWxwaT(cursor.getString(3))).mo10893mjFkc());
        }
        return arrayList;
    }

    /* renamed from: CqaNbM */
    public static /* synthetic */ byte[] m11655CqaNbM(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int length = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            length += blob.length;
        }
        byte[] bArr = new byte[length];
        int length2 = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            byte[] bArr2 = (byte[]) arrayList.get(i);
            System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
            length2 += bArr2.length;
        }
        return bArr;
    }

    /* renamed from: Gd */
    public static /* synthetic */ SQLiteDatabase m11656Gd(Throwable th) {
        throw new C4928y7("Timed out while trying to open db.", th);
    }

    /* renamed from: HGpJ */
    public static /* synthetic */ Long m11657HGpJ(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    /* renamed from: KLMXS */
    public static /* synthetic */ Object m11658KLMXS(long j, AbstractC3140X8 abstractC3140X8, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{abstractC3140X8.mo10887AZxh(), String.valueOf(AbstractC2480N3.m9584mjFkc(abstractC3140X8.mo10889ZfxDd()))}) < 1) {
            contentValues.put("backend_name", abstractC3140X8.mo10887AZxh());
            contentValues.put("priority", Integer.valueOf(AbstractC2480N3.m9584mjFkc(abstractC3140X8.mo10889ZfxDd())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    /* renamed from: Ne */
    public static /* synthetic */ Long m11659Ne(C3540d6 c3540d6, AbstractC3140X8 abstractC3140X8, AbstractC2097HPA abstractC2097HPA, SQLiteDatabase sQLiteDatabase) {
        if (c3540d6.m11682Pq()) {
            return -1L;
        }
        long jM11695xJ = c3540d6.m11695xJ(sQLiteDatabase, abstractC3140X8);
        int iMo8049KLFTb = c3540d6.f13304ZfxDd.mo8049KLFTb();
        byte[] bArrM11235mjFkc = abstractC2097HPA.mo8550KLFTb().m11235mjFkc();
        boolean z = bArrM11235mjFkc.length <= iMo8049KLFTb;
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(jM11695xJ));
        contentValues.put("transport_name", abstractC2097HPA.mo8547Dt());
        contentValues.put("timestamp_ms", Long.valueOf(abstractC2097HPA.mo8549JHa()));
        contentValues.put("uptime_ms", Long.valueOf(abstractC2097HPA.mo8548ETF()));
        contentValues.put("payload_encoding", abstractC2097HPA.mo8550KLFTb().m11233AZxh().m11730mjFkc());
        contentValues.put("code", abstractC2097HPA.mo8552ZfxDd());
        contentValues.put("num_attempts", (Integer) 0);
        contentValues.put("inline", Boolean.valueOf(z));
        contentValues.put("payload", z ? bArrM11235mjFkc : new byte[0]);
        long jInsert = sQLiteDatabase.insert("events", null, contentValues);
        if (!z) {
            int iCeil = (int) Math.ceil(bArrM11235mjFkc.length / iMo8049KLFTb);
            for (int i = 1; i <= iCeil; i++) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrM11235mjFkc, (i - 1) * iMo8049KLFTb, Math.min(i * iMo8049KLFTb, bArrM11235mjFkc.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(jInsert));
                contentValues2.put("sequence_num", Integer.valueOf(i));
                contentValues2.put("bytes", bArrCopyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues2);
            }
        }
        for (Map.Entry entry : abstractC2097HPA.m8554qdMbNW().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(jInsert));
            contentValues3.put("name", (String) entry.getKey());
            contentValues3.put("value", (String) entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues3);
        }
        return Long.valueOf(jInsert);
    }

    /* renamed from: OjSQV */
    public static /* synthetic */ Object m11660OjSQV(Map map, Cursor cursor) {
        while (true) {
            if (!cursor.moveToNext()) {
                return null;
            }
            long j = cursor.getLong(0);
            Set hashSet = (Set) map.get(Long.valueOf(j));
            if (hashSet == null) {
                hashSet = new HashSet();
                map.put(Long.valueOf(j), hashSet);
            }
            hashSet.add(new wA(cursor.getString(1), cursor.getString(2)));
        }
    }

    /* renamed from: Ucbh */
    public static /* synthetic */ Object m11661Ucbh(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        return null;
    }

    /* renamed from: VocHEe */
    public static /* synthetic */ Boolean m11662VocHEe(C3540d6 c3540d6, AbstractC3140X8 abstractC3140X8, SQLiteDatabase sQLiteDatabase) {
        Long lM11680MiMN = c3540d6.m11680MiMN(sQLiteDatabase, abstractC3140X8);
        return lM11680MiMN == null ? Boolean.FALSE : (Boolean) m11663aqHPIZ(c3540d6.m11690lgHUyS().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lM11680MiMN.toString()}), C3073W5.m10806mjFkc());
    }

    /* renamed from: aqHPIZ */
    public static Object m11663aqHPIZ(Cursor cursor, AZxh aZxh) {
        try {
            return aZxh.mo9356apply(cursor);
        } finally {
            cursor.close();
        }
    }

    /* renamed from: huTpC */
    public static /* synthetic */ Object m11665huTpC(Throwable th) {
        throw new C4928y7("Timed out while trying to acquire the lock.", th);
    }

    /* renamed from: lB */
    public static /* synthetic */ List m11666lB(SQLiteDatabase sQLiteDatabase) {
        return (List) m11663aqHPIZ(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), C3006V5.m10661mjFkc());
    }

    /* renamed from: mByQ */
    public static /* synthetic */ Object m11667mByQ(C3540d6 c3540d6, List list, AbstractC3140X8 abstractC3140X8, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j = cursor.getLong(0);
            boolean z = cursor.getInt(7) != 0;
            AbstractC2097HPA.mjFkc mjfkcMo8559ETF = AbstractC2097HPA.m8545mjFkc().mo8558Dt(cursor.getString(1)).mo8565qdMbNW(cursor.getLong(2)).mo8559ETF(cursor.getLong(3));
            if (z) {
                mjfkcMo8559ETF.mo8563lgHUyS(new C3331ZxmHEb(m11671vadzgd(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                mjfkcMo8559ETF.mo8563lgHUyS(new C3331ZxmHEb(m11671vadzgd(cursor.getString(4)), c3540d6.m11684Vnb(j)));
            }
            if (!cursor.isNull(6)) {
                mjfkcMo8559ETF.mo8567xJ(Integer.valueOf(cursor.getInt(6)));
            }
            list.add(AbstractC4722v3.m13745mjFkc(j, abstractC3140X8, mjfkcMo8559ETF.mo8562ZfxDd()));
        }
        return null;
    }

    /* renamed from: oCFDzJ */
    public static String m11668oCFDzJ(Iterable iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(((AbstractC4722v3) it.next()).mo13385wA());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    /* renamed from: rWxwaT */
    public static byte[] m11669rWxwaT(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    /* renamed from: vI */
    public static /* synthetic */ Long m11670vI(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return null;
    }

    /* renamed from: vadzgd */
    public static C3569dXmy m11671vadzgd(String str) {
        return str == null ? f13302KLFTb : C3569dXmy.m11728AZxh(str);
    }

    /* renamed from: wJVbdd */
    public static /* synthetic */ List m11672wJVbdd(C3540d6 c3540d6, AbstractC3140X8 abstractC3140X8, SQLiteDatabase sQLiteDatabase) {
        List listM11696zvd = c3540d6.m11696zvd(sQLiteDatabase, abstractC3140X8);
        return c3540d6.m11688diqgf(listM11696zvd, c3540d6.m11687cMLeY(sQLiteDatabase, listM11696zvd));
    }

    /* renamed from: xrEuO */
    public static /* synthetic */ Object m11673xrEuO(String str, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    @Override // p131o.InterfaceC4829wfQA
    /* renamed from: AZxh */
    public long mo11674AZxh(AbstractC3140X8 abstractC3140X8) {
        return ((Long) m11663aqHPIZ(m11690lgHUyS().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{abstractC3140X8.mo10887AZxh(), String.valueOf(AbstractC2480N3.m9584mjFkc(abstractC3140X8.mo10889ZfxDd()))}), C3408b6.m11448mjFkc())).longValue();
    }

    @Override // p131o.InterfaceC4829wfQA
    /* renamed from: Dt */
    public Iterable mo11675Dt(AbstractC3140X8 abstractC3140X8) {
        return (Iterable) m11689fehf(C2413M5.m9483mjFkc(this, abstractC3140X8));
    }

    @Override // p131o.InterfaceC4829wfQA
    /* renamed from: ETF */
    public boolean mo11676ETF(AbstractC3140X8 abstractC3140X8) {
        return ((Boolean) m11689fehf(C3475c6.m11602mjFkc(this, abstractC3140X8))).booleanValue();
    }

    @Override // p131o.InterfaceC4829wfQA
    /* renamed from: IEE */
    public void mo11677IEE(AbstractC3140X8 abstractC3140X8, long j) {
        m11689fehf(C2349L5.m9355mjFkc(j, abstractC3140X8));
    }

    @Override // p131o.InterfaceC4829wfQA
    /* renamed from: JHa */
    public Iterable mo11678JHa() {
        return (Iterable) m11689fehf(C2482N5.m9585mjFkc());
    }

    /* renamed from: KLFTb */
    public final void m11679KLFTb(SQLiteDatabase sQLiteDatabase) {
        m11681NPj(C2804S5.m10132AZxh(sQLiteDatabase), C2872T5.m10215mjFkc());
    }

    /* renamed from: MiMN */
    public final Long m11680MiMN(SQLiteDatabase sQLiteDatabase, AbstractC3140X8 abstractC3140X8) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(abstractC3140X8.mo10887AZxh(), String.valueOf(AbstractC2480N3.m9584mjFkc(abstractC3140X8.mo10889ZfxDd()))));
        if (abstractC3140X8.mo10890wA() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(abstractC3140X8.mo10890wA(), 0));
        } else {
            sb.append(" and extras is null");
        }
        return (Long) m11663aqHPIZ(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), C3273Z5.m11173mjFkc());
    }

    /* renamed from: NPj */
    public final Object m11681NPj(ZfxDd zfxDd, AZxh aZxh) {
        long jMo7979mjFkc = this.f13306wA.mo7979mjFkc();
        while (true) {
            try {
                return zfxDd.mo10133mjFkc();
            } catch (SQLiteDatabaseLockedException e) {
                if (this.f13306wA.mo7979mjFkc() >= this.f13304ZfxDd.mo8047AZxh() + jMo7979mjFkc) {
                    return aZxh.mo9356apply(e);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    /* renamed from: Pq */
    public final boolean m11682Pq() {
        return m11692qdMbNW() * m11683VA() >= this.f13304ZfxDd.mo8048JHa();
    }

    /* renamed from: VA */
    public final long m11683VA() {
        return m11690lgHUyS().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    /* renamed from: Vnb */
    public final byte[] m11684Vnb(long j) {
        return (byte[]) m11663aqHPIZ(m11690lgHUyS().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j)}, null, null, "sequence_num"), C2673Q5.m9997mjFkc());
    }

    @Override // p131o.InterfaceC4829wfQA
    /* renamed from: YoKzxo */
    public void mo11685YoKzxo(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            m11689fehf(C3341a6.m11275mjFkc("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + m11668oCFDzJ(iterable)));
        }
    }

    @Override // p131o.InterfaceC4992z7
    /* renamed from: ZfxDd */
    public Object mo11686ZfxDd(InterfaceC4992z7.mjFkc mjfkc) {
        SQLiteDatabase sQLiteDatabaseM11690lgHUyS = m11690lgHUyS();
        m11679KLFTb(sQLiteDatabaseM11690lgHUyS);
        try {
            Object objMo7595mjFkc = mjfkc.mo7595mjFkc();
            sQLiteDatabaseM11690lgHUyS.setTransactionSuccessful();
            return objMo7595mjFkc;
        } finally {
            sQLiteDatabaseM11690lgHUyS.endTransaction();
        }
    }

    /* renamed from: cMLeY */
    public final Map m11687cMLeY(SQLiteDatabase sQLiteDatabase, List list) {
        HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i = 0; i < list.size(); i++) {
            sb.append(((AbstractC4722v3) list.get(i)).mo13385wA());
            if (i < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        m11663aqHPIZ(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), null, null, null, null), C2738R5.m10040mjFkc(map));
        return map;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f13305mjFkc.close();
    }

    /* renamed from: diqgf */
    public final List m11688diqgf(List list, Map map) {
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            AbstractC4722v3 abstractC4722v3 = (AbstractC4722v3) listIterator.next();
            if (map.containsKey(Long.valueOf(abstractC4722v3.mo13385wA()))) {
                AbstractC2097HPA.mjFkc mjfkcM8551VA = abstractC4722v3.mo13382AZxh().m8551VA();
                for (wA wAVar : (Set) map.get(Long.valueOf(abstractC4722v3.mo13385wA()))) {
                    mjfkcM8551VA.m8566wA(wAVar.f13308mjFkc, wAVar.f13307AZxh);
                }
                listIterator.set(AbstractC4722v3.m13745mjFkc(abstractC4722v3.mo13385wA(), abstractC4722v3.mo13383ZfxDd(), mjfkcM8551VA.mo8562ZfxDd()));
            }
        }
        return list;
    }

    /* renamed from: fehf */
    public Object m11689fehf(AZxh aZxh) {
        SQLiteDatabase sQLiteDatabaseM11690lgHUyS = m11690lgHUyS();
        sQLiteDatabaseM11690lgHUyS.beginTransaction();
        try {
            Object objMo9356apply = aZxh.mo9356apply(sQLiteDatabaseM11690lgHUyS);
            sQLiteDatabaseM11690lgHUyS.setTransactionSuccessful();
            return objMo9356apply;
        } finally {
            sQLiteDatabaseM11690lgHUyS.endTransaction();
        }
    }

    /* renamed from: lgHUyS */
    public SQLiteDatabase m11690lgHUyS() {
        C4991z6 c4991z6 = this.f13305mjFkc;
        c4991z6.getClass();
        return (SQLiteDatabase) m11681NPj(C2934U5.m10468AZxh(c4991z6), C3137X5.m10885mjFkc());
    }

    @Override // p131o.InterfaceC4829wfQA
    /* renamed from: mjFkc */
    public int mo11691mjFkc() {
        return ((Integer) m11689fehf(C2546O5.m9849mjFkc(this.f13303AZxh.mo7979mjFkc() - this.f13304ZfxDd.mo8052wA()))).intValue();
    }

    /* renamed from: qdMbNW */
    public final long m11692qdMbNW() {
        return m11690lgHUyS().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    @Override // p131o.InterfaceC4829wfQA
    /* renamed from: rkYL */
    public AbstractC4722v3 mo11693rkYL(AbstractC3140X8 abstractC3140X8, AbstractC2097HPA abstractC2097HPA) {
        AbstractC4122m1.m12733AZxh("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", abstractC3140X8.mo10889ZfxDd(), abstractC2097HPA.mo8547Dt(), abstractC3140X8.mo10887AZxh());
        long jLongValue = ((Long) m11689fehf(C3207Y5.m11046mjFkc(this, abstractC3140X8, abstractC2097HPA))).longValue();
        if (jLongValue < 1) {
            return null;
        }
        return AbstractC4722v3.m13745mjFkc(jLongValue, abstractC3140X8, abstractC2097HPA);
    }

    @Override // p131o.InterfaceC4829wfQA
    /* renamed from: wA */
    public void mo11694wA(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            m11690lgHUyS().compileStatement("DELETE FROM events WHERE _id in " + m11668oCFDzJ(iterable)).execute();
        }
    }

    /* renamed from: xJ */
    public final long m11695xJ(SQLiteDatabase sQLiteDatabase, AbstractC3140X8 abstractC3140X8) {
        Long lM11680MiMN = m11680MiMN(sQLiteDatabase, abstractC3140X8);
        if (lM11680MiMN != null) {
            return lM11680MiMN.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", abstractC3140X8.mo10887AZxh());
        contentValues.put("priority", Integer.valueOf(AbstractC2480N3.m9584mjFkc(abstractC3140X8.mo10889ZfxDd())));
        contentValues.put("next_request_ms", (Integer) 0);
        if (abstractC3140X8.mo10890wA() != null) {
            contentValues.put("extras", Base64.encodeToString(abstractC3140X8.mo10890wA(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    /* renamed from: zvd */
    public final List m11696zvd(SQLiteDatabase sQLiteDatabase, AbstractC3140X8 abstractC3140X8) {
        ArrayList arrayList = new ArrayList();
        Long lM11680MiMN = m11680MiMN(sQLiteDatabase, abstractC3140X8);
        if (lM11680MiMN == null) {
            return arrayList;
        }
        m11663aqHPIZ(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{lM11680MiMN.toString()}, null, null, null, String.valueOf(this.f13304ZfxDd.mo8050ZfxDd())), C2611P5.m9946mjFkc(this, arrayList, abstractC3140X8));
        return arrayList;
    }
}
