package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p194crypto.CipherParameters;

/* loaded from: classes2.dex */
public class RC5Parameters implements CipherParameters {

    /* renamed from: key */
    private byte[] f20819key;

    /* renamed from: rounds */
    private int f20820rounds;

    public RC5Parameters(byte[] bArr, int i) {
        if (bArr.length > 255) {
            throw new IllegalArgumentException("RC5 key length can be no greater than 255");
        }
        byte[] bArr2 = new byte[bArr.length];
        this.f20819key = bArr2;
        this.f20820rounds = i;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
    }

    /* renamed from: getKey */
    public byte[] m15805getKey() {
        return this.f20819key;
    }

    public int getRounds() {
        return this.f20820rounds;
    }
}
