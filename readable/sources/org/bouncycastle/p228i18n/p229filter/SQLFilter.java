package org.bouncycastle.p228i18n.p229filter;

/* loaded from: classes2.dex */
public class SQLFilter implements InterfaceC5449Filter {
    @Override // org.bouncycastle.p228i18n.p229filter.InterfaceC5449Filter
    public String doFilter(String str) {
        int i;
        String str2;
        StringBuilder sb = new StringBuilder(str);
        int i2 = 0;
        while (i2 < sb.length()) {
            char cCharAt = sb.charAt(i2);
            if (cCharAt == '\n') {
                i = i2 + 1;
                str2 = "\\n";
            } else if (cCharAt == '\r') {
                i = i2 + 1;
                str2 = "\\r";
            } else if (cCharAt == '\"') {
                i = i2 + 1;
                str2 = "\\\"";
            } else if (cCharAt == '\'') {
                i = i2 + 1;
                str2 = "\\'";
            } else if (cCharAt == '-') {
                i = i2 + 1;
                str2 = "\\-";
            } else if (cCharAt == '/') {
                i = i2 + 1;
                str2 = "\\/";
            } else if (cCharAt == ';') {
                i = i2 + 1;
                str2 = "\\;";
            } else if (cCharAt == '=') {
                i = i2 + 1;
                str2 = "\\=";
            } else if (cCharAt != '\\') {
                i2++;
            } else {
                i = i2 + 1;
                str2 = "\\\\";
            }
            sb.replace(i2, i, str2);
            i2 = i;
            i2++;
        }
        return sb.toString();
    }

    @Override // org.bouncycastle.p228i18n.p229filter.InterfaceC5449Filter
    public String doFilterUrl(String str) {
        return doFilter(str);
    }
}
