package org.bouncycastle.p361util.p362io.p363pem;

/* loaded from: classes2.dex */
public class PemHeader {

    /* renamed from: name */
    private String f24250name;

    /* renamed from: value */
    private String f24251value;

    public PemHeader(String str, String str2) {
        this.f24250name = str;
        this.f24251value = str2;
    }

    private int getHashCode(String str) {
        if (str == null) {
            return 1;
        }
        return str.hashCode();
    }

    /* renamed from: isEqual */
    private boolean m18364isEqual(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    /* renamed from: equals */
    public boolean m18365equals(Object obj) {
        if (!(obj instanceof PemHeader)) {
            return false;
        }
        PemHeader pemHeader = (PemHeader) obj;
        return pemHeader == this || (m18364isEqual(this.f24250name, pemHeader.f24250name) && m18364isEqual(this.f24251value, pemHeader.f24251value));
    }

    /* renamed from: getName */
    public String m18366getName() {
        return this.f24250name;
    }

    public String getValue() {
        return this.f24251value;
    }

    public int hashCode() {
        return getHashCode(this.f24250name) + (getHashCode(this.f24251value) * 31);
    }
}
