package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class KeyParameter implements CipherParameters {

    /* renamed from: key */
    private byte[] f20777key;

    private KeyParameter(int i) {
        this.f20777key = new byte[i];
    }

    /* renamed from: copyTo */
    public void m15772copyTo(byte[] bArr, int i, int i2) {
        byte[] bArr2 = this.f20777key;
        if (bArr2.length != i2) {
            throw new IllegalArgumentException("len");
        }
        System.arraycopy(bArr2, 0, bArr, i, i2);
    }

    /* renamed from: getKey */
    public byte[] m15773getKey() {
        return this.f20777key;
    }

    public int getKeyLength() {
        return this.f20777key.length;
    }

    /* renamed from: reverse */
    public KeyParameter m15774reverse() {
        KeyParameter keyParameter = new KeyParameter(this.f20777key.length);
        C6238Arrays.m18266reverse(this.f20777key, keyParameter.f20777key);
        return keyParameter;
    }

    public KeyParameter(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public KeyParameter(byte[] bArr, int i, int i2) {
        this(i2);
        System.arraycopy(bArr, i, this.f20777key, 0, i2);
    }
}
