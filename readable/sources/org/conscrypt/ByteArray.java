package org.conscrypt;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class ByteArray {

    /* renamed from: bytes */
    private final byte[] f24316bytes;
    private final int hashCode;

    public ByteArray(byte[] bArr) {
        this.f24316bytes = bArr;
        this.hashCode = Arrays.hashCode(bArr);
    }

    /* renamed from: equals */
    public boolean m18415equals(Object obj) {
        if (obj instanceof ByteArray) {
            return Arrays.equals(this.f24316bytes, ((ByteArray) obj).f24316bytes);
        }
        return false;
    }

    public int hashCode() {
        return this.hashCode;
    }
}
