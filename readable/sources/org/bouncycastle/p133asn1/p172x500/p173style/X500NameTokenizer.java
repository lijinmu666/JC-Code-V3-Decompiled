package org.bouncycastle.p133asn1.p172x500.p173style;

/* loaded from: classes2.dex */
public class X500NameTokenizer {

    /* renamed from: index */
    private int f18621index;
    private final char separator;

    /* renamed from: value */
    private final String f18622value;

    public X500NameTokenizer(String str) {
        this(str, ',');
    }

    public boolean hasMoreTokens() {
        return this.f18621index < this.f18622value.length();
    }

    public String nextToken() {
        if (this.f18621index >= this.f18622value.length()) {
            return null;
        }
        int i = this.f18621index + 1;
        boolean z = false;
        boolean z2 = false;
        while (true) {
            int i2 = this.f18621index + 1;
            this.f18621index = i2;
            if (i2 < this.f18622value.length()) {
                char cCharAt = this.f18622value.charAt(this.f18621index);
                if (z) {
                    z = false;
                } else if (cCharAt == '\"') {
                    z2 = !z2;
                } else if (z2) {
                    continue;
                } else if (cCharAt == '\\') {
                    z = true;
                } else if (cCharAt == this.separator) {
                    break;
                }
            } else if (z || z2) {
                throw new IllegalArgumentException("badly formatted directory string");
            }
        }
        return this.f18622value.substring(i, this.f18621index);
    }

    public X500NameTokenizer(String str, char c) {
        str.getClass();
        if (c == '\"' || c == '\\') {
            throw new IllegalArgumentException("reserved separator character");
        }
        this.f18622value = str;
        this.separator = c;
        this.f18621index = str.length() < 1 ? 0 : -1;
    }
}
