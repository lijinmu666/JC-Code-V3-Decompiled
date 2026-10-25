package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class AEADParameters implements CipherParameters {
    private byte[] associatedText;

    /* renamed from: key */
    private KeyParameter f20662key;

    /* renamed from: macSize */
    private int f20663macSize;

    /* renamed from: nonce */
    private byte[] f20664nonce;

    public AEADParameters(KeyParameter keyParameter, int i, byte[] bArr) {
        this(keyParameter, i, bArr, null);
    }

    public byte[] getAssociatedText() {
        return C6238Arrays.m18231clone(this.associatedText);
    }

    /* renamed from: getKey */
    public KeyParameter m15664getKey() {
        return this.f20662key;
    }

    public int getMacSize() {
        return this.f20663macSize;
    }

    public byte[] getNonce() {
        return C6238Arrays.m18231clone(this.f20664nonce);
    }

    public AEADParameters(KeyParameter keyParameter, int i, byte[] bArr, byte[] bArr2) {
        this.f20662key = keyParameter;
        this.f20664nonce = C6238Arrays.m18231clone(bArr);
        this.f20663macSize = i;
        this.associatedText = C6238Arrays.m18231clone(bArr2);
    }
}
