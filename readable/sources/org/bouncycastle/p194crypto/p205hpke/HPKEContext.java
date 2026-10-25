package org.bouncycastle.p194crypto.p205hpke;

/* loaded from: classes2.dex */
public class HPKEContext {

    /* renamed from: aead */
    protected final C5348AEAD f20348aead;
    protected final byte[] exporterSecret;

    /* renamed from: hkdf */
    protected final C5350HKDF f20349hkdf;

    /* renamed from: suiteId */
    protected final byte[] f20350suiteId;

    public HPKEContext(C5348AEAD c5348aead, C5350HKDF c5350hkdf, byte[] bArr, byte[] bArr2) {
        this.f20348aead = c5348aead;
        this.f20349hkdf = c5350hkdf;
        this.exporterSecret = bArr;
        this.f20350suiteId = bArr2;
    }

    /* renamed from: expand */
    public byte[] m15547expand(byte[] bArr, byte[] bArr2, int i) {
        return this.f20349hkdf.m15543Expand(bArr, bArr2, i);
    }

    /* renamed from: export */
    public byte[] m15548export(byte[] bArr, int i) {
        return this.f20349hkdf.LabeledExpand(this.exporterSecret, this.f20350suiteId, "sec", bArr, i);
    }

    /* renamed from: extract */
    public byte[] m15549extract(byte[] bArr, byte[] bArr2) {
        return this.f20349hkdf.m15544Extract(bArr, bArr2);
    }

    /* renamed from: open */
    public byte[] m15550open(byte[] bArr, byte[] bArr2) {
        return this.f20348aead.m15536open(bArr, bArr2);
    }

    /* renamed from: seal */
    public byte[] m15552seal(byte[] bArr, byte[] bArr2) {
        return this.f20348aead.m15538seal(bArr, bArr2);
    }

    /* renamed from: open */
    public byte[] m15551open(byte[] bArr, byte[] bArr2, int i, int i2) {
        return this.f20348aead.m15537open(bArr, bArr2, i, i2);
    }

    /* renamed from: seal */
    public byte[] m15553seal(byte[] bArr, byte[] bArr2, int i, int i2) {
        return this.f20348aead.m15539seal(bArr, bArr2, i, i2);
    }
}
