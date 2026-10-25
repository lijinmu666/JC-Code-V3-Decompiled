package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class SLHDSAPrivateKeyParameters extends SLHDSAKeyParameters {

    /* renamed from: pk */
    final C5372PK f20853pk;

    /* renamed from: sk */
    final C5373SK f20854sk;

    /* renamed from: org.bouncycastle.crypto.params.SLHDSAPrivateKeyParameters$PK */
    public class C5372PK {

        /* renamed from: root */
        final byte[] f20855root;

        /* renamed from: seed */
        final byte[] f20856seed;

        public C5372PK(byte[] bArr, byte[] bArr2) {
            this.f20856seed = bArr;
            this.f20855root = bArr2;
        }
    }

    /* renamed from: org.bouncycastle.crypto.params.SLHDSAPrivateKeyParameters$SK */
    public class C5373SK {

        /* renamed from: prf */
        final byte[] f20858prf;

        /* renamed from: seed */
        final byte[] f20859seed;

        public C5373SK(byte[] bArr, byte[] bArr2) {
            this.f20859seed = bArr;
            this.f20858prf = bArr2;
        }
    }

    public SLHDSAPrivateKeyParameters(SLHDSAParameters sLHDSAParameters, C5373SK c5373sk, C5372PK c5372pk) {
        super(true, sLHDSAParameters);
        this.f20854sk = c5373sk;
        this.f20853pk = c5372pk;
    }

    public byte[] getEncoded() {
        C5373SK c5373sk = this.f20854sk;
        byte[] bArr = c5373sk.f20859seed;
        byte[] bArr2 = c5373sk.f20858prf;
        C5372PK c5372pk = this.f20853pk;
        return C6238Arrays.concatenate(new byte[][]{bArr, bArr2, c5372pk.f20856seed, c5372pk.f20855root});
    }

    public byte[] getEncodedPublicKey() {
        C5372PK c5372pk = this.f20853pk;
        return C6238Arrays.concatenate(c5372pk.f20856seed, c5372pk.f20855root);
    }

    /* renamed from: getPrf */
    public byte[] m15820getPrf() {
        return C6238Arrays.m18231clone(this.f20854sk.f20858prf);
    }

    public byte[] getPublicKey() {
        C5372PK c5372pk = this.f20853pk;
        return C6238Arrays.concatenate(c5372pk.f20856seed, c5372pk.f20855root);
    }

    public byte[] getPublicSeed() {
        return C6238Arrays.m18231clone(this.f20853pk.f20856seed);
    }

    /* renamed from: getRoot */
    public byte[] m15821getRoot() {
        return C6238Arrays.m18231clone(this.f20853pk.f20855root);
    }

    /* renamed from: getSeed */
    public byte[] m15822getSeed() {
        return C6238Arrays.m18231clone(this.f20854sk.f20859seed);
    }

    public SLHDSAPrivateKeyParameters(SLHDSAParameters sLHDSAParameters, byte[] bArr) {
        super(true, sLHDSAParameters);
        int iM15815getN = sLHDSAParameters.m15815getN();
        int i = iM15815getN * 4;
        if (bArr.length != i) {
            throw new IllegalArgumentException("private key encoding does not match parameters");
        }
        int i2 = iM15815getN * 2;
        this.f20854sk = new C5373SK(C6238Arrays.copyOfRange(bArr, 0, iM15815getN), C6238Arrays.copyOfRange(bArr, iM15815getN, i2));
        int i3 = iM15815getN * 3;
        this.f20853pk = new C5372PK(C6238Arrays.copyOfRange(bArr, i2, i3), C6238Arrays.copyOfRange(bArr, i3, i));
    }

    public SLHDSAPrivateKeyParameters(SLHDSAParameters sLHDSAParameters, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        super(true, sLHDSAParameters);
        this.f20854sk = new C5373SK(bArr, bArr2);
        this.f20853pk = new C5372PK(bArr3, bArr4);
    }
}
