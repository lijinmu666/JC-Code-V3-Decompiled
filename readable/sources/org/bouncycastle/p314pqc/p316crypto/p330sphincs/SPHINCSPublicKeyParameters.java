package org.bouncycastle.p314pqc.p316crypto.p330sphincs;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class SPHINCSPublicKeyParameters extends SPHINCSKeyParameters {

    /* renamed from: keyData */
    private final byte[] f23579keyData;

    public SPHINCSPublicKeyParameters(byte[] bArr) {
        super(false, null);
        this.f23579keyData = C6238Arrays.m18231clone(bArr);
    }

    public byte[] getKeyData() {
        return C6238Arrays.m18231clone(this.f23579keyData);
    }

    public SPHINCSPublicKeyParameters(byte[] bArr, String str) {
        super(false, str);
        this.f23579keyData = C6238Arrays.m18231clone(bArr);
    }
}
