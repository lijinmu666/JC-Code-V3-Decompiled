package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class IESParameters implements CipherParameters {
    private byte[] derivation;
    private byte[] encoding;
    private int macKeySize;

    public IESParameters(byte[] bArr, byte[] bArr2, int i) {
        this.derivation = C6238Arrays.m18231clone(bArr);
        this.encoding = C6238Arrays.m18231clone(bArr2);
        this.macKeySize = i;
    }

    public byte[] getDerivationV() {
        return C6238Arrays.m18231clone(this.derivation);
    }

    public byte[] getEncodingV() {
        return C6238Arrays.m18231clone(this.encoding);
    }

    public int getMacKeySize() {
        return this.macKeySize;
    }
}
