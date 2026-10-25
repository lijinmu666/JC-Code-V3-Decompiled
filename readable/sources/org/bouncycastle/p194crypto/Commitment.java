package org.bouncycastle.p194crypto;

/* loaded from: classes2.dex */
public class Commitment {
    private final byte[] commitment;

    /* renamed from: secret */
    private final byte[] f19122secret;

    public Commitment(byte[] bArr, byte[] bArr2) {
        this.f19122secret = bArr;
        this.commitment = bArr2;
    }

    public byte[] getCommitment() {
        return this.commitment;
    }

    public byte[] getSecret() {
        return this.f19122secret;
    }
}
