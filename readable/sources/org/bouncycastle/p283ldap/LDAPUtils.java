package org.bouncycastle.p283ldap;

import org.bouncycastle.p361util.C6250Strings;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public class LDAPUtils {
    private static String[] FILTER_ESCAPE_TABLE = new String[93];

    static {
        char c = 0;
        while (true) {
            String[] strArr = FILTER_ESCAPE_TABLE;
            if (c >= strArr.length) {
                strArr[42] = "\\2a";
                strArr[40] = "\\28";
                strArr[41] = "\\29";
                strArr[92] = "\\5c";
                strArr[0] = "\\00";
                return;
            }
            strArr[c] = String.valueOf(c);
            c = (char) (c + 1);
        }
    }

    private static String filterEncode(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(str.length() * 2);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            String[] strArr = FILTER_ESCAPE_TABLE;
            if (cCharAt < strArr.length) {
                sb.append(strArr[cCharAt]);
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    /* renamed from: parseDN */
    public static String m16292parseDN(String str, String str2) {
        int iIndexOf = C6250Strings.toLowerCase(str).indexOf(C6250Strings.toLowerCase(str2));
        if (iIndexOf == -1) {
            return BuildConfig.f24315FLAVOR;
        }
        String strSubstring = str.substring(iIndexOf + str2.length());
        int iIndexOf2 = strSubstring.indexOf(44);
        if (iIndexOf2 == -1) {
            iIndexOf2 = strSubstring.length();
        }
        while (strSubstring.charAt(iIndexOf2 - 1) == '\\') {
            iIndexOf2 = strSubstring.indexOf(44, iIndexOf2 + 1);
            if (iIndexOf2 == -1) {
                iIndexOf2 = strSubstring.length();
            }
        }
        String strSubstring2 = strSubstring.substring(0, iIndexOf2);
        String strSubstring3 = strSubstring2.substring(strSubstring2.indexOf(61) + 1);
        if (strSubstring3.charAt(0) == ' ') {
            strSubstring3 = strSubstring3.substring(1);
        }
        if (strSubstring3.startsWith("\"")) {
            strSubstring3 = strSubstring3.substring(1);
        }
        if (strSubstring3.endsWith("\"")) {
            strSubstring3 = strSubstring3.substring(0, strSubstring3.length() - 1);
        }
        return filterEncode(strSubstring3);
    }
}
