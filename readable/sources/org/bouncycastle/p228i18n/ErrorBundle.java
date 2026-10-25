package org.bouncycastle.p228i18n;

import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class ErrorBundle extends MessageBundle {
    public static final String DETAIL_ENTRY = "details";
    public static final String SUMMARY_ENTRY = "summary";

    public ErrorBundle(String str, String str2) {
        super(str, str2);
    }

    public String getDetail(Locale locale) {
        return getEntry("details", locale, TimeZone.getDefault());
    }

    public String getSummary(Locale locale) {
        return getEntry("summary", locale, TimeZone.getDefault());
    }

    public ErrorBundle(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    public String getDetail(Locale locale, TimeZone timeZone) {
        return getEntry("details", locale, timeZone);
    }

    public String getSummary(Locale locale, TimeZone timeZone) {
        return getEntry("summary", locale, timeZone);
    }

    public ErrorBundle(String str, String str2, String str3, Object[] objArr) {
        super(str, str2, str3, objArr);
    }

    public ErrorBundle(String str, String str2, Object[] objArr) {
        super(str, str2, objArr);
    }
}
