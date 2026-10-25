package org.bouncycastle.p314pqc.p316crypto.p325newhope;

import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class NHPublicKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: pubData */
    final byte[] f23365pubData;

    public NHPublicKeyParameters(byte[] bArr) {
        super(false);
        this.f23365pubData = C6238Arrays.m18231clone(bArr);
    }

    public byte[] getPubData() {
        return C6238Arrays.m18231clone(this.f23365pubData);
    }
}
