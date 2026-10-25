package org.bouncycastle.p133asn1.p143eac;

import java.util.Enumeration;
import java.util.Hashtable;

/* renamed from: org.bouncycastle.asn1.eac.Flags */
/* loaded from: classes2.dex */
public class C5126Flags {

    /* renamed from: value */
    int f18358value;

    /* renamed from: org.bouncycastle.asn1.eac.Flags$StringJoiner */
    public static class StringJoiner {

        /* renamed from: First */
        boolean f18359First = true;

        /* renamed from: b */
        StringBuilder f18360b = new StringBuilder();
        String mSeparator;

        public StringJoiner(String str) {
            this.mSeparator = str;
        }

        /* renamed from: add */
        public void m14600add(String str) {
            if (this.f18359First) {
                this.f18359First = false;
            } else {
                this.f18360b.append(this.mSeparator);
            }
            this.f18360b.append(str);
        }

        public String toString() {
            return this.f18360b.toString();
        }
    }

    public C5126Flags() {
        this.f18358value = 0;
    }

    /* renamed from: decode */
    public String m14597decode(Hashtable hashtable) {
        StringJoiner stringJoiner = new StringJoiner(" ");
        Enumeration enumerationKeys = hashtable.keys();
        while (enumerationKeys.hasMoreElements()) {
            Integer num = (Integer) enumerationKeys.nextElement();
            if (m14598isSet(num.intValue())) {
                stringJoiner.m14600add((String) hashtable.get(num));
            }
        }
        return stringJoiner.toString();
    }

    public int getFlags() {
        return this.f18358value;
    }

    /* renamed from: isSet */
    public boolean m14598isSet(int i) {
        return (this.f18358value & i) != 0;
    }

    /* renamed from: set */
    public void m14599set(int i) {
        this.f18358value = i | this.f18358value;
    }

    public C5126Flags(int i) {
        this.f18358value = i;
    }
}
