package p131o;

import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: o.E9 */
/* loaded from: classes.dex */
public abstract class AbstractC1870E9 {

    /* renamed from: mjFkc */
    public static AtomicReference f7965mjFkc = new AtomicReference();

    /* renamed from: AZxh */
    public static DateFormat m8110AZxh(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(m8120xJ());
        instanceForSkeleton.setContext(DisplayContext.CAPITALIZATION_FOR_STANDALONE);
        return instanceForSkeleton;
    }

    /* renamed from: Dt */
    public static DateFormat m8111Dt(Locale locale) {
        return m8110AZxh("yMMMEd", locale);
    }

    /* renamed from: ETF */
    public static DateFormat m8112ETF(Locale locale) {
        return m8110AZxh("yMMMM", locale);
    }

    /* renamed from: JHa */
    public static Calendar m8113JHa() {
        Calendar calendarM13822mjFkc = m8115ZfxDd().m13822mjFkc();
        calendarM13822mjFkc.set(11, 0);
        calendarM13822mjFkc.set(12, 0);
        calendarM13822mjFkc.set(13, 0);
        calendarM13822mjFkc.set(14, 0);
        calendarM13822mjFkc.setTimeZone(m8114KLFTb());
        return calendarM13822mjFkc;
    }

    /* renamed from: KLFTb */
    public static TimeZone m8114KLFTb() {
        return TimeZone.getTimeZone("UTC");
    }

    /* renamed from: ZfxDd */
    public static C4794w8 m8115ZfxDd() {
        C4794w8 c4794w8 = (C4794w8) f7965mjFkc.get();
        return c4794w8 == null ? C4794w8.m13820wA() : c4794w8;
    }

    /* renamed from: lgHUyS */
    public static Calendar m8116lgHUyS() {
        return m8118qdMbNW(null);
    }

    /* renamed from: mjFkc */
    public static DateFormat m8117mjFkc(Locale locale) {
        return m8110AZxh("MMMEd", locale);
    }

    /* renamed from: qdMbNW */
    public static Calendar m8118qdMbNW(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(m8114KLFTb());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }

    /* renamed from: wA */
    public static Calendar m8119wA(Calendar calendar) {
        Calendar calendarM8118qdMbNW = m8118qdMbNW(calendar);
        Calendar calendarM8116lgHUyS = m8116lgHUyS();
        calendarM8116lgHUyS.set(calendarM8118qdMbNW.get(1), calendarM8118qdMbNW.get(2), calendarM8118qdMbNW.get(5));
        return calendarM8116lgHUyS;
    }

    /* renamed from: xJ */
    public static android.icu.util.TimeZone m8120xJ() {
        return android.icu.util.TimeZone.getTimeZone("UTC");
    }
}
