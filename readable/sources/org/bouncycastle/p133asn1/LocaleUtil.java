package org.bouncycastle.p133asn1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.bouncycastle.p361util.C6243Longs;

/* loaded from: classes.dex */
public class LocaleUtil {
    private static final Map localeCache = new HashMap();
    public static Locale EN_Locale = m14479forEN();

    public static Date epochAdjust(Date date) {
        Locale locale = Locale.getDefault();
        if (locale == null) {
            return date;
        }
        Map map = localeCache;
        synchronized (map) {
            try {
                Long lLongValueOf = (Long) map.get(locale);
                if (lLongValueOf == null) {
                    lLongValueOf = longValueOf(new SimpleDateFormat("yyyyMMddHHmmssz").parse("19700101000000GMT+00:00").getTime());
                    map.put(locale, lLongValueOf);
                }
                if (lLongValueOf.longValue() == 0) {
                    return date;
                }
                return new Date(date.getTime() - lLongValueOf.longValue());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: forEN */
    private static Locale m14479forEN() {
        if ("en".equalsIgnoreCase(Locale.getDefault().getLanguage())) {
            return Locale.getDefault();
        }
        Locale[] availableLocales = Locale.getAvailableLocales();
        for (int i = 0; i != availableLocales.length; i++) {
            if ("en".equalsIgnoreCase(availableLocales[i].getLanguage())) {
                return availableLocales[i];
            }
        }
        return Locale.getDefault();
    }

    private static Long longValueOf(long j) {
        return C6243Longs.m18299valueOf(j);
    }
}
