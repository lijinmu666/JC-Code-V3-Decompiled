package p131o;

import android.content.Context;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* renamed from: o.zZ */
/* loaded from: classes.dex */
public abstract class AbstractC5019zZ {
    /* renamed from: AZxh */
    public static String m14112AZxh(long j) {
        return m14119wA(j, Locale.getDefault());
    }

    /* renamed from: JHa */
    public static String m14113JHa(long j) {
        return AbstractC1870E9.m8112ETF(Locale.getDefault()).format(new Date(j));
    }

    /* renamed from: KLFTb */
    public static String m14114KLFTb(Context context, int i) {
        return AbstractC1870E9.m8113JHa().get(1) == i ? String.format(context.getString(AbstractC2481N4.f9637ETF), Integer.valueOf(i)) : String.format(context.getString(AbstractC2481N4.f9643VA), Integer.valueOf(i));
    }

    /* renamed from: ZfxDd */
    public static String m14115ZfxDd(long j) {
        return m14118qdMbNW(j) ? m14112AZxh(j) : m14120xJ(j);
    }

    /* renamed from: lgHUyS */
    public static String m14116lgHUyS(long j, Locale locale) {
        return AbstractC1870E9.m8111Dt(locale).format(new Date(j));
    }

    /* renamed from: mjFkc */
    public static String m14117mjFkc(Context context, long j, boolean z, boolean z2, boolean z3) {
        String strM14115ZfxDd = m14115ZfxDd(j);
        if (z) {
            strM14115ZfxDd = String.format(context.getString(AbstractC2481N4.f9644YoKzxo), strM14115ZfxDd);
        }
        return z2 ? String.format(context.getString(AbstractC2481N4.f9641MiMN), strM14115ZfxDd) : z3 ? String.format(context.getString(AbstractC2481N4.f9636Dt), strM14115ZfxDd) : strM14115ZfxDd;
    }

    /* renamed from: qdMbNW */
    public static boolean m14118qdMbNW(long j) {
        Calendar calendarM8113JHa = AbstractC1870E9.m8113JHa();
        Calendar calendarM8116lgHUyS = AbstractC1870E9.m8116lgHUyS();
        calendarM8116lgHUyS.setTimeInMillis(j);
        return calendarM8113JHa.get(1) == calendarM8116lgHUyS.get(1);
    }

    /* renamed from: wA */
    public static String m14119wA(long j, Locale locale) {
        return AbstractC1870E9.m8117mjFkc(locale).format(new Date(j));
    }

    /* renamed from: xJ */
    public static String m14120xJ(long j) {
        return m14116lgHUyS(j, Locale.getDefault());
    }
}
