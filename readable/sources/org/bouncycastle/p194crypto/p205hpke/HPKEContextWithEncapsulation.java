package org.bouncycastle.p194crypto.p205hpke;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class HPKEContextWithEncapsulation extends HPKEContext {
    final byte[] encapsulation;

    public HPKEContextWithEncapsulation(HPKEContext hPKEContext, byte[] bArr) {
        super(hPKEContext.f20348aead, hPKEContext.f20349hkdf, hPKEContext.exporterSecret, hPKEContext.f20350suiteId);
        this.encapsulation = bArr;
    }

    public byte[] getEncapsulation() {
        return C6238Arrays.m18231clone(this.encapsulation);
    }
}
