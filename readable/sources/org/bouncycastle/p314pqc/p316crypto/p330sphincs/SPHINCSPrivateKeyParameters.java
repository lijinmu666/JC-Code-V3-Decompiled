package org.bouncycastle.p314pqc.p316crypto.p330sphincs;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class SPHINCSPrivateKeyParameters extends SPHINCSKeyParameters {

    /* renamed from: keyData */
    private final byte[] f23578keyData;

    public SPHINCSPrivateKeyParameters(byte[] bArr) {
        super(true, null);
        this.f23578keyData = C6238Arrays.m18231clone(bArr);
    }

    public byte[] getKeyData() {
        return C6238Arrays.m18231clone(this.f23578keyData);
    }

    public SPHINCSPrivateKeyParameters(byte[] bArr, String str) {
        super(true, str);
        this.f23578keyData = C6238Arrays.m18231clone(bArr);
    }
}
