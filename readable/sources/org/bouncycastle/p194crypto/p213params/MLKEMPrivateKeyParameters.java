package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p194crypto.p207kems.p208mlkem.MLKEMEngine;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class MLKEMPrivateKeyParameters extends MLKEMKeyParameters {

    /* renamed from: BOTH */
    public static final int f20798BOTH = 0;
    public static final int EXPANDED_KEY = 2;
    public static final int SEED_ONLY = 1;

    /* renamed from: hpk */
    final byte[] f20799hpk;

    /* renamed from: nonce */
    final byte[] f20800nonce;
    private final int prefFormat;

    /* renamed from: rho */
    final byte[] f20801rho;

    /* renamed from: s */
    final byte[] f20802s;

    /* renamed from: seed */
    final byte[] f20803seed;

    /* renamed from: t */
    final byte[] f20804t;

    public MLKEMPrivateKeyParameters(MLKEMParameters mLKEMParameters, byte[] bArr) {
        this(mLKEMParameters, bArr, null);
    }

    private void validate() {
        if (!MLKEMEngine.getInstance(getParameters()).checkPrivateKey(getEncoded())) {
            throw new IllegalArgumentException("'encoding' fails hash check");
        }
    }

    public byte[] getEncoded() {
        return C6238Arrays.concatenate(new byte[][]{this.f20802s, this.f20804t, this.f20801rho, this.f20799hpk, this.f20800nonce});
    }

    /* renamed from: getHPK */
    public byte[] m15791getHPK() {
        return C6238Arrays.m18231clone(this.f20799hpk);
    }

    public byte[] getNonce() {
        return C6238Arrays.m18231clone(this.f20800nonce);
    }

    public MLKEMPrivateKeyParameters getParametersWithFormat(int i) {
        return withPreferredFormat(i);
    }

    public int getPreferredFormat() {
        return this.prefFormat;
    }

    public byte[] getPublicKey() {
        return MLKEMPublicKeyParameters.getEncoded(this.f20804t, this.f20801rho);
    }

    public MLKEMPublicKeyParameters getPublicKeyParameters() {
        return new MLKEMPublicKeyParameters(getParameters(), this.f20804t, this.f20801rho);
    }

    /* renamed from: getRho */
    public byte[] m15792getRho() {
        return C6238Arrays.m18231clone(this.f20801rho);
    }

    /* renamed from: getS */
    public byte[] m15793getS() {
        return C6238Arrays.m18231clone(this.f20802s);
    }

    /* renamed from: getSeed */
    public byte[] m15794getSeed() {
        return C6238Arrays.m18231clone(this.f20803seed);
    }

    /* renamed from: getT */
    public byte[] m15795getT() {
        return C6238Arrays.m18231clone(this.f20804t);
    }

    public MLKEMPrivateKeyParameters withPreferredFormat(int i) {
        if (this.prefFormat == i) {
            return this;
        }
        if (i == 0 || i == 1) {
            if (this.f20803seed == null) {
                throw new IllegalStateException("no seed available");
            }
        } else if (i != 2) {
            throw new IllegalArgumentException("unknown format");
        }
        return new MLKEMPrivateKeyParameters(this, i);
    }

    public MLKEMPrivateKeyParameters(MLKEMParameters mLKEMParameters, byte[] bArr, MLKEMPublicKeyParameters mLKEMPublicKeyParameters) {
        super(true, mLKEMParameters);
        MLKEMEngine mLKEMEngine = MLKEMEngine.getInstance(mLKEMParameters);
        if (bArr.length == 64) {
            byte[][] bArrGenerateKemKeyPairInternal = mLKEMEngine.generateKemKeyPairInternal(C6238Arrays.copyOfRange(bArr, 0, 32), C6238Arrays.copyOfRange(bArr, 32, bArr.length));
            this.f20802s = bArrGenerateKemKeyPairInternal[2];
            this.f20799hpk = bArrGenerateKemKeyPairInternal[3];
            this.f20800nonce = bArrGenerateKemKeyPairInternal[4];
            this.f20804t = bArrGenerateKemKeyPairInternal[0];
            this.f20801rho = bArrGenerateKemKeyPairInternal[1];
            this.f20803seed = bArrGenerateKemKeyPairInternal[5];
        } else {
            this.f20802s = C6238Arrays.copyOfRange(bArr, 0, mLKEMEngine.getIndCpaSecretKeyBytes());
            int indCpaSecretKeyBytes = mLKEMEngine.getIndCpaSecretKeyBytes();
            this.f20804t = C6238Arrays.copyOfRange(bArr, indCpaSecretKeyBytes, (mLKEMEngine.getIndCpaPublicKeyBytes() + indCpaSecretKeyBytes) - 32);
            int indCpaPublicKeyBytes = indCpaSecretKeyBytes + (mLKEMEngine.getIndCpaPublicKeyBytes() - 32);
            int i = indCpaPublicKeyBytes + 32;
            this.f20801rho = C6238Arrays.copyOfRange(bArr, indCpaPublicKeyBytes, i);
            int i2 = indCpaPublicKeyBytes + 64;
            this.f20799hpk = C6238Arrays.copyOfRange(bArr, i, i2);
            this.f20800nonce = C6238Arrays.copyOfRange(bArr, i2, indCpaPublicKeyBytes + 96);
            this.f20803seed = null;
        }
        validate();
        if (mLKEMPublicKeyParameters != null && (!C6238Arrays.constantTimeAreEqual(this.f20804t, mLKEMPublicKeyParameters.f20806t) || !C6238Arrays.constantTimeAreEqual(this.f20801rho, mLKEMPublicKeyParameters.f20805rho))) {
            throw new IllegalArgumentException("passed in public key does not match private values");
        }
        this.prefFormat = this.f20803seed != null ? 0 : 2;
    }

    public MLKEMPrivateKeyParameters(MLKEMParameters mLKEMParameters, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        this(mLKEMParameters, bArr, bArr2, bArr3, bArr4, bArr5, null);
    }

    public MLKEMPrivateKeyParameters(MLKEMParameters mLKEMParameters, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6) {
        super(true, mLKEMParameters);
        this.f20802s = C6238Arrays.m18231clone(bArr);
        this.f20799hpk = C6238Arrays.m18231clone(bArr2);
        this.f20800nonce = C6238Arrays.m18231clone(bArr3);
        this.f20804t = C6238Arrays.m18231clone(bArr4);
        this.f20801rho = C6238Arrays.m18231clone(bArr5);
        this.f20803seed = C6238Arrays.m18231clone(bArr6);
        this.prefFormat = 0;
        validate();
    }

    private MLKEMPrivateKeyParameters(MLKEMPrivateKeyParameters mLKEMPrivateKeyParameters, int i) {
        super(true, mLKEMPrivateKeyParameters.getParameters());
        this.f20802s = mLKEMPrivateKeyParameters.f20802s;
        this.f20804t = mLKEMPrivateKeyParameters.f20804t;
        this.f20801rho = mLKEMPrivateKeyParameters.f20801rho;
        this.f20799hpk = mLKEMPrivateKeyParameters.f20799hpk;
        this.f20800nonce = mLKEMPrivateKeyParameters.f20800nonce;
        this.f20803seed = mLKEMPrivateKeyParameters.f20803seed;
        this.prefFormat = i;
        validate();
    }
}
