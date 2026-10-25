package org.conscrypt;

import java.security.PublicKey;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class X509PublicKey implements PublicKey {
    private static final long serialVersionUID = -8610156854731664298L;
    private final String algorithm;

    /* renamed from: encoded */
    private final byte[] f24466encoded;

    public X509PublicKey(String str, byte[] bArr) {
        this.algorithm = str;
        this.f24466encoded = bArr;
    }

    /* renamed from: equals */
    public boolean m18511equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || X509PublicKey.class != obj.getClass()) {
            return false;
        }
        X509PublicKey x509PublicKey = (X509PublicKey) obj;
        String str = this.algorithm;
        if (str == null) {
            if (x509PublicKey.algorithm != null) {
                return false;
            }
        } else if (!str.equals(x509PublicKey.algorithm)) {
            return false;
        }
        return Arrays.equals(this.f24466encoded, x509PublicKey.f24466encoded);
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithm;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return this.f24466encoded;
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public int hashCode() {
        String str = this.algorithm;
        return (((str == null ? 0 : str.hashCode()) + 31) * 31) + Arrays.hashCode(this.f24466encoded);
    }

    public String toString() {
        return "X509PublicKey [algorithm=" + this.algorithm + ", encoded=" + Arrays.toString(this.f24466encoded) + "]";
    }
}
