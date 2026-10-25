package org.bouncycastle.p133asn1;

/* loaded from: classes.dex */
public class OIDTokenizer {

    /* renamed from: index */
    private int f18008index = 0;

    /* renamed from: oid */
    private String f18009oid;

    public OIDTokenizer(String str) {
        this.f18009oid = str;
    }

    public boolean hasMoreTokens() {
        return this.f18008index != -1;
    }

    public String nextToken() {
        int i = this.f18008index;
        if (i == -1) {
            return null;
        }
        int iIndexOf = this.f18009oid.indexOf(46, i);
        if (iIndexOf == -1) {
            String strSubstring = this.f18009oid.substring(this.f18008index);
            this.f18008index = -1;
            return strSubstring;
        }
        String strSubstring2 = this.f18009oid.substring(this.f18008index, iIndexOf);
        this.f18008index = iIndexOf + 1;
        return strSubstring2;
    }
}
