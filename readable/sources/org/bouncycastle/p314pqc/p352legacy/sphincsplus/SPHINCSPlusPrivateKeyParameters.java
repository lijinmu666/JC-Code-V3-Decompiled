package org.bouncycastle.p314pqc.p352legacy.sphincsplus;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class SPHINCSPlusPrivateKeyParameters extends SPHINCSPlusKeyParameters {

    /* renamed from: pk */
    final C6227PK f24133pk;

    /* renamed from: sk */
    final C6229SK f24134sk;

    public SPHINCSPlusPrivateKeyParameters(SPHINCSPlusParameters sPHINCSPlusParameters, C6229SK c6229sk, C6227PK c6227pk) {
        super(true, sPHINCSPlusParameters);
        this.f24134sk = c6229sk;
        this.f24133pk = c6227pk;
    }

    public byte[] getEncoded() {
        C6229SK c6229sk = this.f24134sk;
        byte[] bArr = c6229sk.f24094seed;
        byte[] bArr2 = c6229sk.f24093prf;
        C6227PK c6227pk = this.f24133pk;
        return C6238Arrays.concatenate(new byte[][]{bArr, bArr2, c6227pk.f24087seed, c6227pk.f24086root});
    }

    public byte[] getEncodedPublicKey() {
        C6227PK c6227pk = this.f24133pk;
        return C6238Arrays.concatenate(c6227pk.f24087seed, c6227pk.f24086root);
    }

    /* renamed from: getPrf */
    public byte[] m18175getPrf() {
        return C6238Arrays.m18231clone(this.f24134sk.f24093prf);
    }

    public byte[] getPublicKey() {
        C6227PK c6227pk = this.f24133pk;
        return C6238Arrays.concatenate(c6227pk.f24087seed, c6227pk.f24086root);
    }

    public byte[] getPublicSeed() {
        return C6238Arrays.m18231clone(this.f24133pk.f24087seed);
    }

    /* renamed from: getRoot */
    public byte[] m18176getRoot() {
        return C6238Arrays.m18231clone(this.f24133pk.f24086root);
    }

    /* renamed from: getSeed */
    public byte[] m18177getSeed() {
        return C6238Arrays.m18231clone(this.f24134sk.f24094seed);
    }

    public SPHINCSPlusPrivateKeyParameters(SPHINCSPlusParameters sPHINCSPlusParameters, byte[] bArr) {
        super(true, sPHINCSPlusParameters);
        int iM18173getN = sPHINCSPlusParameters.m18173getN();
        int i = iM18173getN * 4;
        if (bArr.length != i) {
            throw new IllegalArgumentException("private key encoding does not match parameters");
        }
        int i2 = iM18173getN * 2;
        this.f24134sk = new C6229SK(C6238Arrays.copyOfRange(bArr, 0, iM18173getN), C6238Arrays.copyOfRange(bArr, iM18173getN, i2));
        int i3 = iM18173getN * 3;
        this.f24133pk = new C6227PK(C6238Arrays.copyOfRange(bArr, i2, i3), C6238Arrays.copyOfRange(bArr, i3, i));
    }

    public SPHINCSPlusPrivateKeyParameters(SPHINCSPlusParameters sPHINCSPlusParameters, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        super(true, sPHINCSPlusParameters);
        this.f24134sk = new C6229SK(bArr, bArr2);
        this.f24133pk = new C6227PK(bArr3, bArr4);
    }
}
