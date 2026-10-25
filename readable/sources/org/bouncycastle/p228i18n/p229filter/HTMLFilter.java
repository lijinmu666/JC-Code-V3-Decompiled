package org.bouncycastle.p228i18n.p229filter;

import org.bouncycastle.p133asn1.p143eac.C5125EACTags;

/* loaded from: classes2.dex */
public class HTMLFilter implements InterfaceC5449Filter {
    @Override // org.bouncycastle.p228i18n.p229filter.InterfaceC5449Filter
    public String doFilter(String str) {
        int i;
        String str2;
        StringBuilder sb = new StringBuilder(str);
        int i2 = 0;
        while (i2 < sb.length()) {
            char cCharAt = sb.charAt(i2);
            if (cCharAt == '\"') {
                i = i2 + 1;
                str2 = "&#34";
            } else if (cCharAt == '#') {
                i = i2 + 1;
                str2 = "&#35";
            } else if (cCharAt == '+') {
                i = i2 + 1;
                str2 = "&#43";
            } else if (cCharAt == '-') {
                i = i2 + 1;
                str2 = "&#45";
            } else if (cCharAt == '>') {
                i = i2 + 1;
                str2 = "&#62";
            } else if (cCharAt == ';') {
                i = i2 + 1;
                str2 = "&#59";
            } else if (cCharAt != '<') {
                switch (cCharAt) {
                    case C5125EACTags.APPLICATION_EFFECTIVE_DATE /* 37 */:
                        i = i2 + 1;
                        str2 = "&#37";
                        break;
                    case C5125EACTags.CARD_EFFECTIVE_DATE /* 38 */:
                        i = i2 + 1;
                        str2 = "&#38";
                        break;
                    case C5125EACTags.INTERCHANGE_CONTROL /* 39 */:
                        i = i2 + 1;
                        str2 = "&#39";
                        break;
                    case '(':
                        i = i2 + 1;
                        str2 = "&#40";
                        break;
                    case C5125EACTags.INTERCHANGE_PROFILE /* 41 */:
                        i = i2 + 1;
                        str2 = "&#41";
                        break;
                    default:
                        i2 -= 3;
                        continue;
                        i2 += 4;
                }
            } else {
                i = i2 + 1;
                str2 = "&#60";
            }
            sb.replace(i2, i, str2);
            i2 += 4;
        }
        return sb.toString();
    }

    @Override // org.bouncycastle.p228i18n.p229filter.InterfaceC5449Filter
    public String doFilterUrl(String str) {
        return doFilter(str);
    }
}
