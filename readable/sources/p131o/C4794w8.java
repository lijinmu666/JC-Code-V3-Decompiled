package p131o;

import java.util.Calendar;
import java.util.TimeZone;

/* renamed from: o.w8 */
/* loaded from: classes.dex */
public class C4794w8 {

    /* renamed from: wA */
    public static final C4794w8 f17162wA = new C4794w8(null, null);

    /* renamed from: AZxh */
    public final TimeZone f17163AZxh;

    /* renamed from: mjFkc */
    public final Long f17164mjFkc;

    public C4794w8(Long l, TimeZone timeZone) {
        this.f17164mjFkc = l;
        this.f17163AZxh = timeZone;
    }

    /* renamed from: wA */
    public static C4794w8 m13820wA() {
        return f17162wA;
    }

    /* renamed from: AZxh */
    public Calendar m13821AZxh(TimeZone timeZone) {
        Calendar calendar = timeZone == null ? Calendar.getInstance() : Calendar.getInstance(timeZone);
        Long l = this.f17164mjFkc;
        if (l != null) {
            calendar.setTimeInMillis(l.longValue());
        }
        return calendar;
    }

    /* renamed from: mjFkc */
    public Calendar m13822mjFkc() {
        return m13821AZxh(this.f17163AZxh);
    }
}
