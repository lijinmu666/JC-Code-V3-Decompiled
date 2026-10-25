package com.p038google.p061crypto.p062tink.p078util;

import com.p038google.p061crypto.p062tink.p075subtle.C0865Hex;
import java.util.Arrays;

/* renamed from: com.google.crypto.tink.util.Bytes */
/* loaded from: classes.dex */
public final class C0878Bytes {

    /* renamed from: data */
    private final byte[] f4020data;

    private C0878Bytes(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.f4020data = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
    }

    public static C0878Bytes copyFrom(byte[] bArr) {
        if (bArr != null) {
            return copyFrom(bArr, 0, bArr.length);
        }
        throw new NullPointerException("data must be non-null");
    }

    /* renamed from: equals */
    public boolean m4291equals(Object obj) {
        if (obj instanceof C0878Bytes) {
            return Arrays.equals(((C0878Bytes) obj).f4020data, this.f4020data);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f4020data);
    }

    /* renamed from: size */
    public int m4292size() {
        return this.f4020data.length;
    }

    public byte[] toByteArray() {
        byte[] bArr = this.f4020data;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public String toString() {
        return "Bytes(" + C0865Hex.m4275encode(this.f4020data) + ")";
    }

    public static C0878Bytes copyFrom(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            return new C0878Bytes(bArr, i, i2);
        }
        throw new NullPointerException("data must be non-null");
    }
}
