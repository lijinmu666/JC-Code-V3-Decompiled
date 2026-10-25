package org.bouncycastle.p194crypto.agreement.p197kdf;

import org.bouncycastle.p194crypto.DerivationParameters;

/* loaded from: classes2.dex */
public class GSKKDFParameters implements DerivationParameters {

    /* renamed from: nonce */
    private final byte[] f19220nonce;
    private final int startCounter;

    /* renamed from: z */
    private final byte[] f19221z;

    public GSKKDFParameters(byte[] bArr, int i) {
        this(bArr, i, null);
    }

    public byte[] getNonce() {
        return this.f19220nonce;
    }

    public int getStartCounter() {
        return this.startCounter;
    }

    /* renamed from: getZ */
    public byte[] m15029getZ() {
        return this.f19221z;
    }

    public GSKKDFParameters(byte[] bArr, int i, byte[] bArr2) {
        this.f19221z = bArr;
        this.startCounter = i;
        this.f19220nonce = bArr2;
    }
}
