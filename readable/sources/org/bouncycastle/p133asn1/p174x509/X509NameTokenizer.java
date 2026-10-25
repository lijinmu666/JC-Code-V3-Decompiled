package org.bouncycastle.p133asn1.p174x509;

/* loaded from: classes2.dex */
public class X509NameTokenizer {

    /* renamed from: buf */
    private StringBuffer f18738buf;

    /* renamed from: index */
    private int f18739index;
    private char separator;

    /* renamed from: value */
    private String f18740value;

    public X509NameTokenizer(String str) {
        this(str, ',');
    }

    public boolean hasMoreTokens() {
        return this.f18739index < this.f18740value.length();
    }

    public String nextToken() {
        if (this.f18739index >= this.f18740value.length()) {
            return null;
        }
        int i = this.f18739index + 1;
        this.f18738buf.setLength(0);
        boolean z = false;
        boolean z2 = false;
        while (i != this.f18740value.length()) {
            char cCharAt = this.f18740value.charAt(i);
            if (cCharAt != '\"') {
                if (!z && !z2) {
                    if (cCharAt == '\\') {
                        this.f18738buf.append(cCharAt);
                        z = true;
                    } else {
                        if (cCharAt == this.separator) {
                            break;
                        }
                        this.f18738buf.append(cCharAt);
                    }
                }
                i++;
            } else if (!z) {
                z2 = !z2;
            }
            this.f18738buf.append(cCharAt);
            z = false;
            i++;
        }
        this.f18739index = i;
        return this.f18738buf.toString();
    }

    public X509NameTokenizer(String str, char c) {
        this.f18738buf = new StringBuffer();
        this.f18740value = str;
        this.f18739index = str.length() < 1 ? 0 : -1;
        this.separator = c;
    }
}
