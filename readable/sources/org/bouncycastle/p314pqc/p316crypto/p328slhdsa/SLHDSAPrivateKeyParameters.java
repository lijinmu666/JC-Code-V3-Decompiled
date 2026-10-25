package org.bouncycastle.p314pqc.p316crypto.p328slhdsa;

import org.bouncycastle.p361util.C6238Arrays;

@Deprecated
/* loaded from: classes2.dex */
public class SLHDSAPrivateKeyParameters extends SLHDSAKeyParameters {

    /* renamed from: pk */
    final C6096PK f23519pk;

    /* renamed from: sk */
    final C6098SK f23520sk;

    public SLHDSAPrivateKeyParameters(SLHDSAParameters sLHDSAParameters, C6098SK c6098sk, C6096PK c6096pk) {
        super(true, sLHDSAParameters);
        this.f23520sk = c6098sk;
        this.f23519pk = c6096pk;
    }

    public byte[] getEncoded() {
        C6098SK c6098sk = this.f23520sk;
        byte[] bArr = c6098sk.f23492seed;
        byte[] bArr2 = c6098sk.f23491prf;
        C6096PK c6096pk = this.f23519pk;
        return C6238Arrays.concatenate(new byte[][]{bArr, bArr2, c6096pk.f23485seed, c6096pk.f23484root});
    }

    public byte[] getEncodedPublicKey() {
        C6096PK c6096pk = this.f23519pk;
        return C6238Arrays.concatenate(c6096pk.f23485seed, c6096pk.f23484root);
    }

    /* renamed from: getPrf */
    public byte[] m17841getPrf() {
        return C6238Arrays.m18231clone(this.f23520sk.f23491prf);
    }

    public byte[] getPublicKey() {
        C6096PK c6096pk = this.f23519pk;
        return C6238Arrays.concatenate(c6096pk.f23485seed, c6096pk.f23484root);
    }

    public byte[] getPublicSeed() {
        return C6238Arrays.m18231clone(this.f23519pk.f23485seed);
    }

    /* renamed from: getRoot */
    public byte[] m17842getRoot() {
        return C6238Arrays.m18231clone(this.f23519pk.f23484root);
    }

    /* renamed from: getSeed */
    public byte[] m17843getSeed() {
        return C6238Arrays.m18231clone(this.f23520sk.f23492seed);
    }

    public SLHDSAPrivateKeyParameters(SLHDSAParameters sLHDSAParameters, byte[] bArr) {
        super(true, sLHDSAParameters);
        int iM17836getN = sLHDSAParameters.m17836getN();
        int i = iM17836getN * 4;
        if (bArr.length != i) {
            throw new IllegalArgumentException("private key encoding does not match parameters");
        }
        int i2 = iM17836getN * 2;
        this.f23520sk = new C6098SK(C6238Arrays.copyOfRange(bArr, 0, iM17836getN), C6238Arrays.copyOfRange(bArr, iM17836getN, i2));
        int i3 = iM17836getN * 3;
        this.f23519pk = new C6096PK(C6238Arrays.copyOfRange(bArr, i2, i3), C6238Arrays.copyOfRange(bArr, i3, i));
    }

    public SLHDSAPrivateKeyParameters(SLHDSAParameters sLHDSAParameters, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        super(true, sLHDSAParameters);
        this.f23520sk = new C6098SK(bArr, bArr2);
        this.f23519pk = new C6096PK(bArr3, bArr4);
    }
}
