package org.bouncycastle.p226est;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import org.conscrypt.BuildConfig;
import p094kotlin.p117text.Typography;

/* loaded from: classes2.dex */
class HttpUtil {

    /* renamed from: org.bouncycastle.est.HttpUtil$Headers */
    public static class C5443Headers extends HashMap<String, String[]> {
        private String actualKey(String str) {
            if (containsKey(str)) {
                return str;
            }
            for (String str2 : keySet()) {
                if (str.equalsIgnoreCase(str2)) {
                    return str2;
                }
            }
            return null;
        }

        /* renamed from: copy */
        private String[] m15971copy(String[] strArr) {
            int length = strArr.length;
            String[] strArr2 = new String[length];
            System.arraycopy(strArr, 0, strArr2, 0, length);
            return strArr2;
        }

        private boolean hasHeader(String str) {
            return actualKey(str) != null;
        }

        /* renamed from: add */
        public void m15972add(String str, String str2) {
            put(str, HttpUtil.m15970append(get(str), str2));
        }

        @Override // java.util.HashMap, java.util.AbstractMap
        public Object clone() {
            C5443Headers c5443Headers = new C5443Headers();
            for (Map.Entry<String, String[]> entry : entrySet()) {
                c5443Headers.put(entry.getKey(), m15971copy(entry.getValue()));
            }
            return c5443Headers;
        }

        public void ensureHeader(String str, String str2) {
            if (containsKey(str)) {
                return;
            }
            m15973set(str, str2);
        }

        public String getFirstValue(String str) {
            String[] values = getValues(str);
            if (values == null || values.length <= 0) {
                return null;
            }
            return values[0];
        }

        public String getFirstValueOrEmpty(String str) {
            String[] values = getValues(str);
            return (values == null || values.length <= 0) ? BuildConfig.f24315FLAVOR : values[0];
        }

        public String[] getValues(String str) {
            String strActualKey = actualKey(str);
            if (strActualKey == null) {
                return null;
            }
            return get(strActualKey);
        }

        /* renamed from: set */
        public void m15973set(String str, String str2) {
            put(str, new String[]{str2});
        }
    }

    public static class PartLexer {

        /* renamed from: last */
        int f21207last = 0;

        /* renamed from: p */
        int f21208p = 0;

        /* renamed from: src */
        private final String f21209src;

        public PartLexer(String str) {
            this.f21209src = str;
        }

        private String consumeAlpha() {
            char cCharAt = this.f21209src.charAt(this.f21208p);
            while (this.f21208p < this.f21209src.length() && ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z'))) {
                int i = this.f21208p + 1;
                this.f21208p = i;
                cCharAt = this.f21209src.charAt(i);
            }
            String strSubstring = this.f21209src.substring(this.f21207last, this.f21208p);
            this.f21207last = this.f21208p;
            return strSubstring;
        }

        private boolean consumeIf(char c) {
            if (this.f21208p >= this.f21209src.length() || this.f21209src.charAt(this.f21208p) != c) {
                return false;
            }
            this.f21208p++;
            return true;
        }

        private String consumeUntil(char c) {
            while (this.f21208p < this.f21209src.length() && this.f21209src.charAt(this.f21208p) != c) {
                this.f21208p++;
            }
            String strSubstring = this.f21209src.substring(this.f21207last, this.f21208p);
            this.f21207last = this.f21208p;
            return strSubstring;
        }

        /* renamed from: discard */
        private void m15974discard() {
            this.f21207last = this.f21208p;
        }

        private void skipWhiteSpace() {
            while (this.f21208p < this.f21209src.length() && this.f21209src.charAt(this.f21208p) < '!') {
                this.f21208p++;
            }
            this.f21207last = this.f21208p;
        }

        /* renamed from: Parse */
        public Map<String, String> m15976Parse() {
            HashMap map = new HashMap();
            while (this.f21208p < this.f21209src.length()) {
                skipWhiteSpace();
                String strConsumeAlpha = consumeAlpha();
                if (strConsumeAlpha.length() == 0) {
                    throw new IllegalArgumentException("Expecting alpha label.");
                }
                skipWhiteSpace();
                if (!consumeIf('=')) {
                    throw new IllegalArgumentException("Expecting assign: '='");
                }
                skipWhiteSpace();
                if (!consumeIf(Typography.f5424quote)) {
                    throw new IllegalArgumentException("Expecting start quote: '\"'");
                }
                m15974discard();
                String strConsumeUntil = consumeUntil(Typography.f5424quote);
                m15975discard(1);
                map.put(strConsumeAlpha, strConsumeUntil);
                skipWhiteSpace();
                if (!consumeIf(',')) {
                    break;
                }
                m15974discard();
            }
            return map;
        }

        /* renamed from: discard */
        private void m15975discard(int i) {
            int i2 = this.f21208p + i;
            this.f21208p = i2;
            this.f21207last = i2;
        }
    }

    /* renamed from: append */
    public static String[] m15970append(String[] strArr, String str) {
        if (strArr == null) {
            return new String[]{str};
        }
        int length = strArr.length;
        String[] strArr2 = new String[length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, length);
        strArr2[length] = str;
        return strArr2;
    }

    public static String mergeCSL(String str, Map<String, String> map) {
        StringWriter stringWriter = new StringWriter();
        stringWriter.write(str);
        stringWriter.write(32);
        boolean z = false;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (z) {
                stringWriter.write(44);
            } else {
                z = true;
            }
            stringWriter.write(entry.getKey());
            stringWriter.write("=\"");
            stringWriter.write(entry.getValue());
            stringWriter.write(34);
        }
        return stringWriter.toString();
    }

    public static Map<String, String> splitCSL(String str, String str2) {
        String strTrim = str2.trim();
        if (strTrim.startsWith(str)) {
            strTrim = strTrim.substring(str.length());
        }
        return new PartLexer(strTrim).m15976Parse();
    }
}
