package org.bouncycastle.p314pqc.p352legacy.sphincsplus;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class SPHINCSPlusPublicKeyParameters extends SPHINCSPlusKeyParameters {

    /* renamed from: pk */
    private final C6227PK f24135pk;

    public SPHINCSPlusPublicKeyParameters(SPHINCSPlusParameters sPHINCSPlusParameters, C6227PK c6227pk) {
        super(false, sPHINCSPlusParameters);
        this.f24135pk = c6227pk;
    }

    public byte[] getEncoded() {
        C6227PK c6227pk = this.f24135pk;
        return C6238Arrays.concatenate(c6227pk.f24087seed, c6227pk.f24086root);
    }

    /* renamed from: getRoot */
    public byte[] m18178getRoot() {
        return C6238Arrays.m18231clone(this.f24135pk.f24086root);
    }

    /* renamed from: getSeed */
    public byte[] m18179getSeed() {
        return C6238Arrays.m18231clone(this.f24135pk.f24087seed);
    }

    public SPHINCSPlusPublicKeyParameters(SPHINCSPlusParameters sPHINCSPlusParameters, byte[] bArr) {
        super(false, sPHINCSPlusParameters);
        int iM18173getN = sPHINCSPlusParameters.m18173getN();
        int i = iM18173getN * 2;
        if (bArr.length != i) {
            throw new IllegalArgumentException("public key encoding does not match parameters");
        }
        this.f24135pk = new C6227PK(C6238Arrays.copyOfRange(bArr, 0, iM18173getN), C6238Arrays.copyOfRange(bArr, iM18173getN, i));
    }
}
