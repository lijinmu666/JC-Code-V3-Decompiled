package org.bouncycastle.p314pqc.p316crypto.p328slhdsa;

import org.bouncycastle.p361util.C6238Arrays;

@Deprecated
/* loaded from: classes2.dex */
public class SLHDSAPublicKeyParameters extends SLHDSAKeyParameters {

    /* renamed from: pk */
    private final C6096PK f23521pk;

    public SLHDSAPublicKeyParameters(SLHDSAParameters sLHDSAParameters, C6096PK c6096pk) {
        super(false, sLHDSAParameters);
        this.f23521pk = c6096pk;
    }

    public byte[] getEncoded() {
        C6096PK c6096pk = this.f23521pk;
        return C6238Arrays.concatenate(c6096pk.f23485seed, c6096pk.f23484root);
    }

    /* renamed from: getRoot */
    public byte[] m17844getRoot() {
        return C6238Arrays.m18231clone(this.f23521pk.f23484root);
    }

    /* renamed from: getSeed */
    public byte[] m17845getSeed() {
        return C6238Arrays.m18231clone(this.f23521pk.f23485seed);
    }

    public SLHDSAPublicKeyParameters(SLHDSAParameters sLHDSAParameters, byte[] bArr) {
        super(false, sLHDSAParameters);
        int iM17836getN = sLHDSAParameters.m17836getN();
        int i = iM17836getN * 2;
        if (bArr.length != i) {
            throw new IllegalArgumentException("public key encoding does not match parameters");
        }
        this.f23521pk = new C6096PK(C6238Arrays.copyOfRange(bArr, 0, iM17836getN), C6238Arrays.copyOfRange(bArr, iM17836getN, i));
    }
}
