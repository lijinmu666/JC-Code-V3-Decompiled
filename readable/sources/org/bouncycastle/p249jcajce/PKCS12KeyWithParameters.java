package org.bouncycastle.p249jcajce;

import javax.crypto.interfaces.PBEKey;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class PKCS12KeyWithParameters extends PKCS12Key implements PBEKey {
    private final int iterationCount;

    /* renamed from: salt */
    private final byte[] f21360salt;

    public PKCS12KeyWithParameters(char[] cArr, boolean z, byte[] bArr, int i) {
        super(cArr, z);
        this.f21360salt = C6238Arrays.m18231clone(bArr);
        this.iterationCount = i;
    }

    @Override // javax.crypto.interfaces.PBEKey
    public int getIterationCount() {
        return this.iterationCount;
    }

    @Override // javax.crypto.interfaces.PBEKey
    public byte[] getSalt() {
        return this.f21360salt;
    }

    public PKCS12KeyWithParameters(char[] cArr, byte[] bArr, int i) {
        super(cArr);
        this.f21360salt = C6238Arrays.m18231clone(bArr);
        this.iterationCount = i;
    }
}
