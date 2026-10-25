package org.bouncycastle.p314pqc.p316crypto.p318falcon;

import org.bouncycastle.p194crypto.CipherParameters;

/* loaded from: classes2.dex */
public class FalconParameters implements CipherParameters {

    /* renamed from: logn */
    private final int f23122logn;

    /* renamed from: name */
    private final String f23123name;
    private final int nonce_length;
    public static final FalconParameters falcon_512 = new FalconParameters("falcon-512", 9, 40);
    public static final FalconParameters falcon_1024 = new FalconParameters("falcon-1024", 10, 40);

    private FalconParameters(String str, int i, int i2) {
        if (i < 1 || i > 10) {
            throw new IllegalArgumentException("Log N degree should be between 1 and 10");
        }
        this.f23123name = str;
        this.f23122logn = i;
        this.nonce_length = i2;
    }

    /* renamed from: getLogN */
    public int m17548getLogN() {
        return this.f23122logn;
    }

    /* renamed from: getName */
    public String m17549getName() {
        return this.f23123name;
    }

    public int getNonceLength() {
        return this.nonce_length;
    }
}
